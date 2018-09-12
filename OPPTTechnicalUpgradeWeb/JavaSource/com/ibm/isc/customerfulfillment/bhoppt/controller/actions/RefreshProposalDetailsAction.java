/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.Iterator;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalDetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class RefreshProposalDetailsAction extends OPPTLongAction {
	/** 
	 * Overridden method - Enter your description here.
	 *  
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;

		ProposalCustomDTO currentProposal = getCurrentProposal(session);
		if (null != currentProposal) {
			ProposalDetailsCustomDTO customDTO = new ProposalDetailsCustomDTO();
			setTransactionInformation(customDTO, session);
			customDTO.setProposalDTO(currentProposal);
			//customDTO.setTotalNoOfPages(getTotalPages(session));
			customDTO.setPageIndex(getPageIndex(session));
			customDTO.setMLCTotalNoOfPages(getMlcTotalPages(session));
			customDTO.setMLCExcess(getMlcExcess(session));
			//CR 2031
			customDTO.setDuplicateSerial(getDuplicateSerial(session));
			if (isSearchLicenses(session)) {
				customDTO.setRequestFor(UtilityConstants.SEARCH_PAGE);
				customDTO.setSearchString(getSearchString(session));
			} else {
				customDTO.setRequestFor(UtilityConstants.GOTO_PAGE);
			}

			try {
				OPPTLogger.debug("Before page index: " + String.valueOf(customDTO.getPageIndex()), "[RefreshProposalDetailsAction]", "[executeAction]");  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
				OPPTLogger.debug("Before total pages: " + String.valueOf(customDTO.getTotalNoOfPages()), "[RefreshProposalDetailsAction]", "[executeAction]");  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
				customDTO = getProposalManager().fetchProposalDetails(customDTO);
				OPPTLogger.debug("Afterpage index: " + String.valueOf(customDTO.getPageIndex()), "[RefreshProposalDetailsAction]", "[executeAction]");  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
				OPPTLogger.debug("After total pages: " + String.valueOf(customDTO.getTotalNoOfPages()), "[RefreshProposalDetailsAction]", "[executeAction]");  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
				ErrorReport messageReport = customDTO.getMessageReport();
				if (null == messageReport) {
					addDataStoreEntry(session, customDTO);
					setProposalDetails(session, customDTO);
					updateInProposalDetails(session, customDTO.getTotalNoOfPages(), customDTO.getPageIndex(), customDTO.getMLCTotalNoOfPages(), customDTO.getMLCExcess());
					// CR 2031
					if (customDTO.isDuplicateSerial()) {
						customDTO = updateMarkedForDeletionSWOs(customDTO, session);
					}
					viewBean = new ProposalDetailsViewBean(customDTO);
					setForwardName(session, currentProposal);

				} else {
					viewBean = new MessageViewBean(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_MAINTENANCE, true);
					viewBean.setErrorReport(messageReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);
				}
			} catch (ServiceException se) {
				viewBean = handleErrorReport(se.getErrorReport());
			}
		} else {
			viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA00));
			setForwardName(ForwardNameConstants.PAGE_ERROR);
		}

		return viewBean;
	}

	//CR 2031
	private ProposalDetailsCustomDTO updateMarkedForDeletionSWOs(ProposalDetailsCustomDTO customDTO, OPPTSession session) {

		if(null != session.getObjectFromSession(SessionConstants.MARKED_FOR_DELETION))
		{
			TreeMap customers = customDTO.getCustomers();
			updateMarkedForDeletionSWOs(customers, session);
			TreeMap sAndSCustomers = customDTO.getSAndSCustomers();
			updateMarkedForDeletionSWOs(sAndSCustomers, session);
		}
		

		return customDTO;
	}

	//	CR 2031
	private TreeMap updateMarkedForDeletionSWOs(TreeMap customers, OPPTSession session) {

		if (null != customers) {
			Iterator iterator = customers.keySet().iterator();
			while (iterator.hasNext()) {
				ProposalCustomerCustomDTO proposalCustomerCustomDTO = (ProposalCustomerCustomDTO) customers.get(iterator.next());
				TreeMap dms = proposalCustomerCustomDTO.getDMs();
				if (null != dms) {
					Iterator dmIterator = dms.keySet().iterator();
					while (dmIterator.hasNext()) {
						DMCustomDTO dmCustomDTO = (DMCustomDTO) dms.get(dmIterator.next());
						TreeMap swos = dmCustomDTO.getSwos();
						if (null != swos) {
							Iterator swoIterator = swos.keySet().iterator();
							while (swoIterator.hasNext()) {
								SWOCustomDTO swoCustomDTO = (SWOCustomDTO) swos.get(swoIterator.next());
								if (null != swoCustomDTO) {
									DeleteDuplicateSWOCustomDTO deleteDuplicateSWOCustomDTO =(DeleteDuplicateSWOCustomDTO)session.getObjectFromSession(SessionConstants.MARKED_FOR_DELETION);
									deleteDuplicateSWOCustomDTO.checkForSWO(swoCustomDTO);
								}
							}
						}
					}
				}
			}
		}

		return customers;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return 
	 * 
	 */
	protected String getActionName() {
		return ActionNameConstants.PROPOSAL_DETAILS;
	}

	/**
	 * Gets the current proposal stored as part of the session  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session OPPTSession
	 * @return ProposalCustomDTO
	 */
	private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
		ProposalCustomDTO currentProposal = null;
		if (null != session) {
			currentProposal = (ProposalCustomDTO) session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);
		}
		return currentProposal;
	}

	/**
	 * Stores proposal details as part of session  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session OPPTSession
	 * @param dto ProposalDetailsCustomDTO
	 */
	private void setProposalDetails(OPPTSession session, ProposalDetailsCustomDTO dto) {
		if (null != session & null != dto) {
			session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS, dto);
		}
	}

	private void setForwardName(OPPTSession session, ProposalCustomDTO currentProposal) {
		if (currentProposal instanceof ContractCustomDTO) {
			setContractDetailsForwardName(getRole(session));
		} else if (currentProposal instanceof ProposalForApprovalCustomDTO) {
			setProposalForApprovalDetailsForwardName(getRole(session));
		} else {
			setProposalDetailsForwardName(getRole(session));
		}
	}

	private int getTotalPages(OPPTSession session) {
		int totalPages = 0;
		Object integerObject = session.getObjectFromSession(SessionConstants.PROPOSAL_DETAILS_TOTAL_PAGES);
		if (null != integerObject) {
			totalPages = ((Integer) integerObject).intValue();
		}
		return totalPages;
	}
	private int getPageIndex(OPPTSession session) {
		int pageIndex = 1;
		Object integerObject = session.getObjectFromSession(SessionConstants.PROPOSAL_DETAILS_PAGE_INDEX);
		if (null != integerObject) {
			pageIndex = ((Integer) integerObject).intValue();
		}
		return pageIndex;
	}
	private int getMlcTotalPages(OPPTSession session) {
		int mlcTotalPages = 1;
		Object integerObject = session.getObjectFromSession(SessionConstants.PROPOSAL_DETAILS_MLC_TOTAL_PAGES);
		if (null != integerObject) {
			mlcTotalPages = ((Integer) integerObject).intValue();
		}
		return mlcTotalPages;
	}
	private int getMlcExcess(OPPTSession session) {
		int mlcExcess = 1;
		Object integerObject = session.getObjectFromSession(SessionConstants.PROPOSAL_DETAILS_MLC_EXCESS);
		if (null != integerObject) {
			mlcExcess = ((Integer) integerObject).intValue();
		}
		return mlcExcess;
	}
	private boolean isSearchLicenses(OPPTSession session) {
		boolean searchLicenses = false;
		Object booleanObject = session.getObjectFromSession(SessionConstants.PROPOSAL_DETAILS_SEARCH_LICENSES);
		if (null != booleanObject) {
			searchLicenses = ((Boolean) booleanObject).booleanValue();
		}
		return searchLicenses;
	}
	private String getSearchString(OPPTSession session) {
		String searchString = null;
		Object stringObject = session.getObjectFromSession(SessionConstants.PROPOSAL_DETAILS_SEARCH_STRING);
		if (null != stringObject) {
			searchString = (String) stringObject;
		}
		return searchString;
	}

	private void updateInProposalDetails(OPPTSession session, int totalPages, int pageIndex, int mlcTotalPages, int mlcExcess) {
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_TOTAL_PAGES, new Integer(totalPages));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_PAGE_INDEX, new Integer(pageIndex));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_MLC_TOTAL_PAGES, new Integer(mlcTotalPages));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_MLC_EXCESS, new Integer(mlcExcess));
	}

	private void setProposalDetailsForwardName(int role) {
		setFirstActionOfProcess(true);
		switch (role) {
			case Constants.PROPOSAL_CREATE_APPROVER :
				setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSAL_DETAILS);
				break;

			case Constants.PROPOSAL_ADMINISTRATOR :
			default :
				setForwardName(ForwardNameConstants.PAGE_PROPOSAL_DETAILS);
				break;
		}
	}

	private void setContractDetailsForwardName(int role) {
		setFirstActionOfProcess(true);
		switch (role) {
			case Constants.PROPOSAL_CREATE_APPROVER :
				setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_DETAILS);
				break;

			case Constants.PROPOSAL_ADMINISTRATOR :
			default :
				setForwardName(ForwardNameConstants.PAGE_CONTRACT_DETAILS);
				break;
		}
	}

	private void setProposalForApprovalDetailsForwardName(int role) {
		setFirstActionOfProcess(true);
		switch (role) {
			case Constants.PROPOSAL_CREATE_APPROVER :
				setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSALS_FOR_APPROVAL_DETAILS);
				break;

			case Constants.PROPOSAL_APPROVER :
			default :
				setForwardName(ForwardNameConstants.PAGE_PROPOSAL_FOR_APPROVAL_DETAILS);
				break;
		}
	}

	private void setPartnerInformationForwardName(int role) {
		switch (role) {
			case Constants.PROPOSAL_CREATE_APPROVER :
				setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PARTNER_INFORMATION);
				break;

			case Constants.PROPOSAL_ADMINISTRATOR :
			default :
				setForwardName(ForwardNameConstants.PAGE_PARTNER_INFORMATION);
				break;
		}
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Feb 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param session
	 * @return 
	 * 
	 */
	protected boolean validateCurrentViewContent(OPPTSession session) {
		return true;
	}
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#isFirstActionOfProcess() 
	 * @return 
	 * 
	 */
	protected boolean isFirstActionOfProcess() {
		return true;
	}
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#getFirstActionForwardName() 
	 * @return 
	 * 
	 */
	protected String getFirstActionForwardName() {
		return ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS;
	}
	//CR 2031
	private boolean getDuplicateSerial(OPPTSession session) {
		boolean duplicateSerial = false;
		Object booleanObject = session.getObjectFromSession(SessionConstants.DUPLICATE_SERIAL_NUMBERS);
		if (null != booleanObject) {
			duplicateSerial = ((Boolean) booleanObject).booleanValue();
		}
		return duplicateSerial;
	}
}