/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 27, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class ProposalLinkAction extends OPPTLongAction {
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
		
		if(null != form){
			ProposalActionForm actionForm = (ProposalActionForm)form;
			ProposalCustomDTO currentProposal = getSelectedProposal(session, actionForm.getProposalId());
			if(null != currentProposal){
//				Added for the change DAD O11 Remove approval step,Blue Harmony -Ramesh
//				after clicking on the regected by ECC
				OPPTLogger.debug("currentProposal.getStatus():"+currentProposal.getStatus(), "ProposalLinkAction", "executeAction");
				String curntProposalStatus =currentProposal.getStatus();
				if (curntProposalStatus.equalsIgnoreCase("PA")){
					RejectProposalCustomDTO customDTO1 = new RejectProposalCustomDTO();
					setTransactionInformation(customDTO1, session);
					customDTO1.setProposalDTO(currentProposal);
					customDTO1.setConfirmationRequired(false);
					try{
						OPPTLogger.debug("before calling.rejectRequest():", "ProposalLinkAction", "executeAction");
						getProposalManager().rejectRequest(customDTO1);
						OPPTLogger.debug("after calling.rejectRequest():"+currentProposal.getStatus(), "ProposalLinkAction", "executeAction");
					}
					catch(ServiceException se){
						viewBean = handleErrorReport(session, se.getErrorReport());
					}
				}
//End by Ramesh
				saveCurrentProposal(session, currentProposal);

				ProposalDetailsCustomDTO customDTO = new ProposalDetailsCustomDTO();
				setTransactionInformation(customDTO, session);
				customDTO.setProposalDTO(currentProposal);
				customDTO.setPageIndex(1);
				customDTO.setRequestFor(UtilityConstants.GOTO_PAGE);
			
				try {
					OPPTLogger.debug("before calling.fetchProposalDetails()", "ProposalLinkAction", "executeAction");
					customDTO = getProposalManager().fetchProposalDetails(customDTO);
					OPPTLogger.debug("after calling.fetchProposalDetails()", "ProposalLinkAction", "executeAction");
					ErrorReport messageReport = customDTO.getMessageReport();
					if(null == messageReport)
					{
						addDataStoreEntry(session, customDTO);
						if(customDTO.getProposalEditable())
						{
							if(customDTO.isInventoryFetched())
							{
								addDataStoreEntry(session, customDTO);
								setProposalDetails(session, customDTO);
								updateInProposalDetails(session, customDTO.getTotalNoOfPages(), customDTO.getPageIndex(), customDTO.getMLCTotalNoOfPages(), customDTO.getMLCExcess());
								viewBean = new ProposalDetailsViewBean(customDTO);
								setProposalDetailsForwardName(getRole(session));
							}
							else 
							{
								PartnerInformationCustomDTO partnerInformation = customDTO.getPartnerInformation();
								if(null != partnerInformation)
								{   
									partnerInformation.setSelectedCustomers(customDTO.getSelectedCustomers()); //DADO02 Sateesh Anne BlueHarmony
									
									viewBean = new PartnerInformationViewBean(partnerInformation);
									setPartnerInformationForwardName(getRole(session));
								}
								else
								{
									viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA40), ForwardNameConstants.ACTION_REFRESH_PROPOSAL_MAINTENANCE, true);
									setForwardName(ForwardNameConstants.PAGE_ERROR);
								}
							}
						}
						else{
							setForwardName(ForwardNameConstants.ACTION_PROPOSAL_HEADER);
						}
					}
					else{
						viewBean = new MessageViewBean(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_MAINTENANCE, true);
						viewBean.setErrorReport(messageReport);
						setForwardName(ForwardNameConstants.PAGE_MESSAGE);
					}
				}
				catch(ServiceException se){
					viewBean = handleErrorReport(se.getErrorReport(), ForwardNameConstants.ACTION_REFRESH_PROPOSAL_MAINTENANCE, true);
				}
			}
			else{
				viewBean = new ErrorViewBean();
				viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA00));
				setForwardName(ForwardNameConstants.PAGE_ERROR);
			}
		}
		else{
			viewBean = new ErrorViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA00));
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
	
	/**
	 * Given the proposal id, this method gets the proposal object from the collection of proposals
	 * for the user stored as part of session.  
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
	 * @param proposalId String
	 * @return ProposalCustomDTO
	 */
	private ProposalCustomDTO getSelectedProposal(OPPTSession session, String proposalId){
		ProposalCustomDTO selectedProposal = null;
		
		if(null != session && null != proposalId){
			UserProposalsCustomDTO userProposals = (UserProposalsCustomDTO)session.getObjectFromSession(SessionConstants.USER_PROPOSALS);
			if(null != userProposals){
				TreeMap proposals = userProposals.getProposals();
				if(null != proposals){
					try{
						int propId = Integer.parseInt(proposalId);
						selectedProposal = (ProposalCustomDTO)proposals.get(new Integer(propId));
					}
					catch(Exception e){
						// When number format exception occurs the selected proposal will be null
					}
				}
			}
		}
		
		return selectedProposal;
	}

	private void saveCurrentProposal(OPPTSession session, ProposalCustomDTO currentProposal){
		if(null != session && null != currentProposal){
			session.storeObjectToSession(SessionConstants.CURRENT_PROPOSAL, currentProposal);
		}
	}

	private void setProposalDetails(OPPTSession session, ProposalDetailsCustomDTO dto) {
		if(null != session & null != dto){
			session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS, dto);
		}
	}

	private void updateInProposalDetails(OPPTSession session, int totalPages, int pageIndex, int mlcTotalPages, int mlcExcess){
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_TOTAL_PAGES, new Integer(totalPages));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_PAGE_INDEX, new Integer(pageIndex));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_MLC_TOTAL_PAGES, new Integer(mlcTotalPages));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_MLC_EXCESS, new Integer(mlcExcess));
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
}