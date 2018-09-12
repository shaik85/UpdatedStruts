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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalDetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ProposalForApprovalDetailsAction extends OPPTLongAction {
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
		
		ProposalCustomDTO currentProposal = null;
		ProposalActionForm actionForm = (ProposalActionForm)form;
		if(null != actionForm){
			String proposalId = actionForm.getProposalId();
			if(null != proposalId){
				currentProposal = getSelectedProposal(session, actionForm.getProposalId());
				saveCurrentProposal(session, currentProposal);
			}
			else{
				currentProposal = getCurrentProposal(session);
			}
		}
		
		ProposalDetailsCustomDTO customDTO = new ProposalDetailsCustomDTO();
		setTransactionInformation(customDTO, session);
		customDTO.setProposalDTO(currentProposal);
		customDTO.setPageIndex(actionForm.getPageIndex());
		customDTO.setRequestFor(UtilityConstants.GOTO_PAGE);
		
		try {
			customDTO = getProposalManager().fetchProposalDetails(customDTO);
			ErrorReport errorReport = customDTO.getMessageReport();
			if(null == errorReport)
			{
				addDataStoreEntry(session, customDTO);
				setProposalDetails(session, customDTO);
				viewBean = new ProposalDetailsViewBean(customDTO);
				setForwardName(getRole(session));
			}
			else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(errorReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);
			}
		}
		catch(ServiceException se){
			viewBean = handleServiceException(session, se.getErrorReport());
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
	 * Overridden method - Returns true as this action is the first action of the process. 
	 * 
	 * <br/><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#isFirstActionOfProcess() 
	 * @return boolean 
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
			ProposalsForApprovalCustomDTO userProposals = (ProposalsForApprovalCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSALS_FOR_APPROVAL);
			if(null != userProposals){
				TreeMap proposals = userProposals.getProposalsForApproval();
				if(null != proposals){
					try{
						int propId = Integer.parseInt(proposalId);
						selectedProposal = (ProposalCustomDTO)proposals.get(new Integer(propId));
					}
					catch(Exception e){
					}
				}
			}
		}
		if(null == selectedProposal){
			selectedProposal = getCurrentProposal(session);
		}
		
		return selectedProposal;
	}
	
	private void printProposalDetails(ProposalDetailsCustomDTO customDTO){
		if(null != customDTO){
			TreeMap customers = customDTO.getCustomers();
			if(null != customers){
				Iterator iterator = customers.values().iterator();
				while(iterator.hasNext()){
					ProposalCustomerCustomDTO customer = (ProposalCustomerCustomDTO)iterator.next();
					
					TreeMap dms = customer.getDMs();
					if(null != dms){
						Iterator iterator1 = dms.values().iterator();
						while(iterator1.hasNext()){
							DMCustomDTO dm = (DMCustomDTO)iterator1.next();
					
							TreeMap swos = dm.getSwos();
							if(null != swos){
								Iterator iterator2 = swos.values().iterator();
								while(iterator2.hasNext()){
									SWOCustomDTO swo = (SWOCustomDTO)iterator2.next();
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void saveCurrentProposal(OPPTSession session, ProposalCustomDTO currentProposal){
		if(null != session && null != currentProposal){
			session.storeObjectToSession(SessionConstants.CURRENT_PROPOSAL, currentProposal);
		}
	}



	private void setForwardName(int role){
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
