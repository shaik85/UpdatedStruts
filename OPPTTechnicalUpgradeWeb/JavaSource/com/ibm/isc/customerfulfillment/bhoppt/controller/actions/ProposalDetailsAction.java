/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ProposalDetailsAction extends OPPTLongAction {
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

//		boolean fromProposalMaintenance = getProposalDetailsFlag(session);
		ProposalCustomDTO currentProposal = getCurrentProposal(session);
		if(null != currentProposal){
			ProposalDetailsCustomDTO customDTO = new ProposalDetailsCustomDTO();
			setTransactionInformation(customDTO, session);
			customDTO.setProposalDTO(currentProposal);
			customDTO.setPageIndex(1);
			customDTO.setRequestFor(UtilityConstants.GOTO_PAGE);
			
			// CR 2031
			boolean isDuplicateSerial = false; 
			if(null != session.getObjectFromSession(SessionConstants.DUPLICATE_SERIAL_NUMBERS)) {
				isDuplicateSerial =((Boolean)session.getObjectFromSession(SessionConstants.DUPLICATE_SERIAL_NUMBERS)).booleanValue();				
			}
			
			customDTO.setDuplicateSerial(isDuplicateSerial);			
						
			try {
				customDTO = getProposalManager().fetchProposalDetails(customDTO);
				ErrorReport messageReport = customDTO.getMessageReport();
				if(null == messageReport)
				{
					addDataStoreEntry(session, customDTO);
					if(customDTO.isInventoryFetched()){
						addDataStoreEntry(session, customDTO);
						setProposalDetails(session, customDTO);
						updateInProposalDetails(session, customDTO.getTotalNoOfPages(), customDTO.getPageIndex(), customDTO.getMLCTotalNoOfPages(), customDTO.getMLCExcess(), false, null);
						viewBean = new ProposalDetailsViewBean(customDTO);
						setForwardName(session, currentProposal);
					}
					else{
						viewBean = new MessageViewBean(ForwardNameConstants.ACTION_PROPOSAL_MAINTENANCE, true);
						viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA31));
						setForwardName(ForwardNameConstants.PAGE_MESSAGE);
					}
				}
				else{
					viewBean = new MessageViewBean(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_MAINTENANCE, true);
					viewBean.setErrorReport(messageReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);
				}
			}
			catch(ServiceException se){
				viewBean = handleErrorReport(se.getErrorReport(), getErrorInitiator(currentProposal), true);
			}
		}
		else{
			viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA39), getErrorInitiator(currentProposal), true);
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
		if(null != session){
			currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);
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
		if(null != session & null != dto){
			session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS, dto);
		}
	}
	
	private void setForwardName(OPPTSession session, ProposalCustomDTO currentProposal){
		if(currentProposal instanceof ContractCustomDTO){
			setContractDetailsForwardName(getRole(session));
		}
		else if(currentProposal instanceof ProposalForApprovalCustomDTO){
			setProposalForApprovalDetailsForwardName(getRole(session));
		}
		else{
			setProposalDetailsForwardName(getRole(session));
		}
	}
	
	private void updateInProposalDetails(OPPTSession session, int totalPages, int pageIndex, int mlcTotalPages, int mlcExcess, boolean searchLicenses, String searchString){
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_TOTAL_PAGES, new Integer(totalPages));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_PAGE_INDEX, new Integer(pageIndex));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_MLC_TOTAL_PAGES, new Integer(mlcTotalPages));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_MLC_EXCESS, new Integer(mlcExcess));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_SEARCH_LICENSES, new Boolean(searchLicenses));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_SEARCH_STRING, searchString);
	}
	
	private void setProposalDetailsForwardName(int role){
		setFirstActionOfProcess(true);
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSAL_DETAILS);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_PROPOSAL_DETAILS);
								break;
		}
	}

	private void setContractDetailsForwardName(int role){
		setFirstActionOfProcess(true);
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_DETAILS);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_CONTRACT_DETAILS);
								break;
		}
	}

	private void setProposalForApprovalDetailsForwardName(int role){
		setFirstActionOfProcess(true);
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSALS_FOR_APPROVAL_DETAILS);
								break;

			case Constants.PROPOSAL_APPROVER:
			default:
								setForwardName(ForwardNameConstants.PAGE_PROPOSAL_FOR_APPROVAL_DETAILS);
								break;
		}
	}

	private void setPartnerInformationForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PARTNER_INFORMATION);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
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
		return ForwardNameConstants.ACTION_PROPOSAL_DETAILS;
	}
	
	private String getErrorInitiator(ProposalCustomDTO currentProposal){
		String initiator = null;

		if(null != currentProposal){
			if(currentProposal instanceof ProposalCustomDTO){
				initiator = ForwardNameConstants.ACTION_REFRESH_PROPOSAL_MAINTENANCE;
			}
			else if(currentProposal instanceof ContractCustomDTO){
				initiator = ForwardNameConstants.ACTION_CONTRACT_MAINTENANCE;
			}
			else if(currentProposal instanceof ProposalForApprovalCustomDTO){
				initiator = ForwardNameConstants.ACTION_PROPOSALS_FOR_APPROVAL;
			}
		}
		
		return initiator;
	}
}