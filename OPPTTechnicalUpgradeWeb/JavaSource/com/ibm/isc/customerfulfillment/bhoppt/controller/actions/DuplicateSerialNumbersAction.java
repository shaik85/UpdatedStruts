/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalDetailsActionForm;
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
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalForApprovalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Oct 26, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1x
 */
public class DuplicateSerialNumbersAction extends OPPTLongAction {

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Oct 26, 2004 
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
		boolean errorPage = true;

		ProposalCustomDTO currentProposal = null;
		ProposalDetailsActionForm actionForm = (ProposalDetailsActionForm) form;
		if (null != actionForm) {

			currentProposal = getCurrentProposal(session);
			if (null != currentProposal) {
				ProposalDetailsCustomDTO customDTO = new ProposalDetailsCustomDTO();
				setTransactionInformation(customDTO, session);
				customDTO.setProposalDTO(currentProposal);
				customDTO.setPageIndex(1);
				customDTO.setRequestFor(UtilityConstants.SEARCH_PAGE);
				customDTO.setDuplicateSerial(true);
				try {
					customDTO = getProposalManager().fetchProposalDetails(customDTO);
					ErrorReport messageReport = customDTO.getMessageReport();
					if (null == messageReport) {
						addDataStoreEntry(session, customDTO);
						setProposalDetails(session, customDTO);
						updateInProposalDetails(
							session,
							customDTO.getTotalNoOfPages(),
							customDTO.getPageIndex(),
							customDTO.getMLCTotalNoOfPages(),
							customDTO.getMLCExcess(),
							false,
							customDTO.getSearchString(),
						    customDTO.isDuplicateSerial());
						viewBean = new ProposalDetailsViewBean(customDTO);
						setCurrentForwardName(session, currentProposal);
						errorPage = false;
					} else {
						viewBean = new MessageViewBean();
						viewBean.setErrorReport(messageReport);
						setForwardName(ForwardNameConstants.PAGE_MESSAGE);
						errorPage = false;
					}
				} catch (ServiceException se) {
					viewBean = handleServiceException(session, se.getErrorReport());
					errorPage = false;
				}

			}
		}
		if (errorPage) {
			viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PAF31));
			setForwardName(ForwardNameConstants.PAGE_ERROR);
		}

		return viewBean;
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
		return ActionNameConstants.DUPLICATE_SERIAL_NUMBER;
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

	private void updateInProposalDetails(OPPTSession session, int totalPages, int pageIndex, int mlcTotalPages, int mlcExcess, boolean searchLicenses, String searchString,boolean duplicateSerialNumbers) {
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_TOTAL_PAGES, new Integer(totalPages));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_PAGE_INDEX, new Integer(pageIndex));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_MLC_TOTAL_PAGES, new Integer(mlcTotalPages));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_MLC_EXCESS, new Integer(mlcExcess));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_SEARCH_LICENSES, new Boolean(searchLicenses));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_SEARCH_STRING, searchString);
		session.storeObjectToSession(SessionConstants.DUPLICATE_SERIAL_NUMBERS, new Boolean(duplicateSerialNumbers));
	}

	private void setCurrentForwardName(OPPTSession session, ProposalCustomDTO currentProposal) {
		if (null != currentProposal && null != session) {
			if (currentProposal instanceof ContractCustomDTO) {
				setContractForwardName(getRole(session));
			} else {
				setProposalForwardName(getRole(session));
			}
		}
	}

	private void setContractForwardName(int role) {
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

	private void setProposalForwardName(int role) {
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

	/**
     * validateCurrentViewContent
     * 
     * @param session
     * @return boolean
     * @author thirumalai
     */
	protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = false;

		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = getCurrentForwardName(session);

		if (null != viewBean && null != currentForward) {
			if (viewBean instanceof ProposalDetailsViewBean && currentForward.equals(actualForward)) {
				valid = true;
			}
		}

		if (!valid) {
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.PROPOSAL_DETAILS);
			if (null != dataStoreEntry && dataStoreEntry instanceof ProposalDetailsCustomDTO) {
				session.setCurrentViewBean(new ProposalDetailsViewBean((ProposalDetailsCustomDTO) dataStoreEntry));
				session.setCurrentForward(actualForward);
				valid = true;
			}
		}

		return valid;
	}

	private String getCurrentForwardName(OPPTSession session) {
		String currentForwardName = null;

		ProposalCustomDTO currentProposal = getCurrentProposal(session);
		if (null != currentProposal) {
			if (currentProposal instanceof ContractCustomDTO) {
				currentForwardName = getContractForwardName(getRole(session));
			} else if (currentProposal instanceof ProposalForApprovalCustomDTO) {
				currentForwardName = getProposalForApprovalForwardName(getRole(session));
			} else {
				currentForwardName = getProposalForwardName(getRole(session));
			}
		}
		return currentForwardName;
	}

	private String getContractForwardName(int role) {
		String currentForwardName = null;
		switch (role) {
			case Constants.PROPOSAL_CREATE_APPROVER :
				currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_DETAILS;
				break;

			case Constants.PROPOSAL_ADMINISTRATOR :
			default :
				currentForwardName = ForwardNameConstants.PAGE_CONTRACT_DETAILS;
				break;
		}
		return currentForwardName;
	}

	private String getProposalForwardName(int role) {
		String currentForwardName = null;
		switch (role) {
			case Constants.PROPOSAL_CREATE_APPROVER :
				currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSAL_DETAILS;
				break;

			case Constants.PROPOSAL_ADMINISTRATOR :
			default :
				currentForwardName = ForwardNameConstants.PAGE_PROPOSAL_DETAILS;
				break;
		}
		return currentForwardName;
	}

	private String getProposalForApprovalForwardName(int role) {
		String currentForwardName = null;
		switch (role) {
			case Constants.PROPOSAL_CREATE_APPROVER :
				currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSALS_FOR_APPROVAL_DETAILS;
				break;

			case Constants.PROPOSAL_APPROVER :
			default :
				currentForwardName = ForwardNameConstants.PAGE_PROPOSAL_FOR_APPROVAL_DETAILS;
				break;
		}
		return currentForwardName;
	}
}
