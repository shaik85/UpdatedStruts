/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.RejectionReasonActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RejectProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class RejectionReasonAction extends OPPTLongAction {
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
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		RejectionReasonActionForm actionForm = (RejectionReasonActionForm)form;
		if(null != actionForm){
			RejectProposalCustomDTO customDTO = getProposalToBeRejected(session);
			if(null != customDTO){
				customDTO.setRejectionReason(actionForm.getRejectionReason());
				customDTO.setConfirmationRequired(false);
				setTransactionInformation(customDTO, session);
				
				
				try{
					getProposalManager().rejectRequest(customDTO);
					removeProposalToBeRejected(session);
					setForwardName(ForwardNameConstants.ACTION_PROPOSALS_FOR_APPROVAL);
				}
				catch(ServiceException se){
					viewBean = new ErrorViewBean(se.getErrorReport(), ActionNameConstants.REJECTION_REASON);
					setForwardName(ForwardNameConstants.PAGE_ERROR);
				}
			}
			else{
				viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA00));
				setForwardName(ForwardNameConstants.PAGE_ERROR);
			}
		}
		else{
			viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA00));
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
		return ActionNameConstants.REJECTION_REASON;
	}

	private RejectProposalCustomDTO getProposalToBeRejected(OPPTSession session) {
		RejectProposalCustomDTO customDTO = null;
		if(null != session){
			customDTO = (RejectProposalCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_TO_BE_REJECTED);
		}
		return customDTO;
	}

	private void removeProposalToBeRejected(OPPTSession session) {
		if(null != session){
			session.removeObjectFromSession(SessionConstants.PROPOSAL_TO_BE_REJECTED);
		}
	}
	
	/** 
	 * Overridden method - Usage of back button is not allowed for this action. So return false. 
	 * 
	 * <br/><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#isBackButtonAllowed() 
	 * @return 
	 * 
	 */
	protected boolean isBackButtonAllowed() {
		return false;
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