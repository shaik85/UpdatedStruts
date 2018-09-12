/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.DMCopyBumpActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DMCopyBumpViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpDMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class DMCopyBumpAction extends OPPTLongAction {
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
		
		DMCopyBumpActionForm actionForm = (DMCopyBumpActionForm)form;
		CopyBumpDMCustomDTO customDTO = getCopyBumpDM(session);
		customDTO.setTransactionName(getActionName());
		customDTO = getInputData(customDTO, actionForm, session);

		try {
			if(isDMChanged(customDTO)){
				customDTO = getProposalManager().saveCopyBumpDM(customDTO);
			}
			removeCopyBumpDM(session);
			setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS);
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
		return ActionNameConstants.COPY_BUMP_DM;
	}

	private CopyBumpDMCustomDTO getCopyBumpDM(OPPTSession session) {
		CopyBumpDMCustomDTO customDTO = null;
		
		if(null != session){
			customDTO = (CopyBumpDMCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_COPY_BUMP_INVENTIORY_DM);
		}
		
		return customDTO;
	}

	private void removeCopyBumpDM(OPPTSession session){
		if(null != session){
			session.removeObjectFromSession(SessionConstants.SESSION_COPY_BUMP_INVENTIORY_SWO);
		}
	}

	private CopyBumpDMCustomDTO getInputData(CopyBumpDMCustomDTO customDTO, DMCopyBumpActionForm actionForm, OPPTSession session){
		if(null != actionForm && null != session && null != customDTO)
		{
			customDTO.setOriginalPlanEndDate(actionForm.getOriginalPlanEndDate().getDate());
			customDTO.setBumpPlanEndDate(actionForm.getBumpPlanEndDate().getDate());
			customDTO.setBumpPlanStartDate(actionForm.getBumpPlanStartDate().getDate());
		}
		
		return customDTO;
	}

	private boolean isDMChanged(CopyBumpDMCustomDTO customDTO){
		boolean changed = true;
		if(null != customDTO){
			if(null == customDTO.getBumpPlanStartDate() || null == customDTO.getBumpPlanEndDate()){
				changed = false;
			}
		}
		else{
			changed = false;
		}

		return changed;
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
		String actualForward = getCurrentForwardName(getRole(session));

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof DMCopyBumpViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.COPY_BUMP_INVENTORY);
			if(null != dataStoreEntry && dataStoreEntry instanceof CopyBumpDMCustomDTO){
				session.setCurrentViewBean(new DMCopyBumpViewBean((CopyBumpDMCustomDTO)dataStoreEntry));
				session.setCurrentForward(actualForward);
				valid = true;
			}
		}
		
		return valid;
	}

	private String getCurrentForwardName(int role){
		String currentForwardName = null;
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_COPY_BUMP_DM;
								break;
			
			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_COPY_BUMP_DM;
								break;
		}
		
		return currentForwardName;
	}
}