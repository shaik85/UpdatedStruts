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
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalForApprovalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalsForApprovalCustomDTO;

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
public class ProposalForApprovalLinkAction extends OPPTLongAction {
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

			ProposalForApprovalCustomDTO currentProposal = getSelectedProposalForApproval(session, actionForm.getProposalId());
			if(null != currentProposal){
				saveCurrentProposalForApproval(session, currentProposal);
				setForwardName(ForwardNameConstants.ACTION_PROPOSAL_HEADER);
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
	private ProposalForApprovalCustomDTO getSelectedProposalForApproval(OPPTSession session, String proposalId){
		ProposalForApprovalCustomDTO selectedProposal = null;
		
		if(null != session && null != proposalId){
			ProposalsForApprovalCustomDTO userProposals = (ProposalsForApprovalCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSALS_FOR_APPROVAL);
			if(null != userProposals){
				TreeMap proposals = userProposals.getProposalsForApproval();
				if(null != proposals){
					try{
						int propId = Integer.parseInt(proposalId);
						selectedProposal = (ProposalForApprovalCustomDTO)proposals.get(new Integer(propId));
					}
					catch(Exception e){
						// When number format exception occurs the selected proposal will be null
					}
				}
			}
		}
		
		return selectedProposal;
	}

	private void saveCurrentProposalForApproval(OPPTSession session, ProposalForApprovalCustomDTO currentProposal){
		if(null != session && null != currentProposal){
			session.storeObjectToSession(SessionConstants.CURRENT_PROPOSAL, currentProposal);
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