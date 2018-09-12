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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.TransferProposalsActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.TransferProposalsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.TransferProposalsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class SubmitTransferProposalsAction extends OPPTLongAction 
{
  
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
		throws Exception {
			
		ErrorReport errorReport=null;
		OPPTViewBean viewBean=null;
		TransferProposalsCustomDTO customDto = (TransferProposalsCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_TRANSFER_PROPOSAL_DETAIL);
		
		TransferProposalsActionForm actionForm = (TransferProposalsActionForm)form;
		setTransactionInformation(customDto,session);
		populateTransferDto(customDto, actionForm);
	
		try {
			customDto = getProposalManager().transferProposals(customDto);
			errorReport = customDto.getMessageReport();
			if(null == errorReport){
				setForwardName(ForwardNameConstants.ACTION_ADMINISTRATOR);
			}
			else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(errorReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);
			}
	
		}
		catch(ServiceException ex){
			viewBean = handleServiceException(session, ex.getErrorReport());
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
		return ActionNameConstants.SUBMIT_TRANSFER_PROPOSALS;
	}
	
	/**
	 * Populates TransferProposalsCustomDTO with detail of selected user
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDto
	 * @param actionForm
	 */
	private void populateTransferDto(TransferProposalsCustomDTO customDto, TransferProposalsActionForm actionForm){
		TreeMap selectedTarget = new TreeMap();
		UserCustomDTO user;
		
		if(RoleConstants.CREATE_APPROVE != Integer.parseInt(actionForm.getSourceUserRole())){
			if(null != actionForm.getSelectedUserId() && !"".equals(actionForm.getSelectedUserId().trim())){  //$NON-NLS-1$
				user = (UserCustomDTO)customDto.getTargetUsers().get(actionForm.getSelectedUserId());
				selectedTarget.put(actionForm.getSelectedUserId(), user);
			}
		}
		else{
			if(null != actionForm.getCreateApproverId() && !"".equals(actionForm.getCreateApproverId().trim())){  //$NON-NLS-1$
				user = (UserCustomDTO)customDto.getCreateApproveUsers().get(actionForm.getCreateApproverId());
				selectedTarget.put(actionForm.getCreateApproverId(), user);
			}

			if(null != actionForm.getApproverId() && !"".equals(actionForm.getApproverId().trim())){  //$NON-NLS-1$
				user = (UserCustomDTO)customDto.getProposalApproveUsers().get(actionForm.getApproverId());
				selectedTarget.put(actionForm.getApproverId(), user);
			}
			
			if(null != actionForm.getGeneralUserId() && !"".equals(actionForm.getGeneralUserId().trim())){  //$NON-NLS-1$
				user = (UserCustomDTO)customDto.getTargetUsers().get(actionForm.getGeneralUserId());
				selectedTarget.put(actionForm.getGeneralUserId(), user);
			}
		}
		
		customDto.setTargetUsers(selectedTarget);
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
		String actualForward = ForwardNameConstants.PAGE_TRANSFER_PROPOSAL;

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof TransferProposalsViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.TRANSFER_PROPOSALS);
			if(null != dataStoreEntry && dataStoreEntry instanceof TransferProposalsCustomDTO){
				session.setCurrentViewBean(new TransferProposalsViewBean((TransferProposalsCustomDTO)dataStoreEntry));
				session.setCurrentForward(actualForward);
				valid = true;
			}
		}
		
		return valid;
	}
}