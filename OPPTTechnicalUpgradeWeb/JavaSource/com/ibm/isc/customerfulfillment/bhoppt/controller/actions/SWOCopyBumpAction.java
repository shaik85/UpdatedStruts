/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SWOCopyBumpActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SWOCopyBumpViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyBumpSWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class SWOCopyBumpAction extends OPPTLongAction 
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)throws Exception {
		OPPTViewBean viewBean = null;
		
		SWOCopyBumpActionForm actionForm = (SWOCopyBumpActionForm)form;
		CopyBumpSWOCustomDTO customDTO = getCopyBumpSWO(session);
		customDTO.setTransactionName(getActionName());
		customDTO = getInputData(customDTO, actionForm, session);

		try {
			if(isSWOChanged(customDTO)){
				customDTO = getProposalManager().saveCopyBumpSWO(customDTO);
			}
			removeCopyBumpSWO(session);
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
		return ActionNameConstants.COPY_BUMP_SWO;
	}

	private CopyBumpSWOCustomDTO getCopyBumpSWO(OPPTSession session){
		CopyBumpSWOCustomDTO customDTO = null;
		if(null != session){
			customDTO = (CopyBumpSWOCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_COPY_BUMP_INVENTIORY_SWO);
		}
		return customDTO;
	}
   
	private void removeCopyBumpSWO(OPPTSession session){
    	if(null != session){
    		session.removeObjectFromSession(SessionConstants.SESSION_COPY_BUMP_INVENTIORY_SWO);
    	}
	}

	private CopyBumpSWOCustomDTO getInputData(CopyBumpSWOCustomDTO customDTO, SWOCopyBumpActionForm actionForm, OPPTSession session){
		if(null != actionForm && null != session && null != customDTO)
		{
			customDTO.setOriginalPlanEndDate(actionForm.getOriginalPlanEndDate().getDate());
			customDTO.setBumpPlanEndDate(actionForm.getBumpPlanEndDate().getDate());
			customDTO.setBumpPlanStartDate(actionForm.getBumpPlanStartDate().getDate());
			customDTO.setAlternatePrice(actionForm.getTargetAlternatePrice());
			customDTO.getSwoDTO().setAlternatePrice(actionForm.getSourceAlternatePrice());
		}
	
		return customDTO;
	}
	
	private boolean isSWOChanged(CopyBumpSWOCustomDTO customDTO){
		boolean changed = true;
		if(null != customDTO){
			if(null == customDTO.getBumpPlanStartDate() && null == customDTO.getBumpPlanEndDate()){
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
			if(viewBean instanceof SWOCopyBumpViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.COPY_BUMP_INVENTORY);
			if(null != dataStoreEntry && dataStoreEntry instanceof CopyBumpSWOCustomDTO){
				session.setCurrentViewBean(new SWOCopyBumpViewBean((CopyBumpSWOCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_COPY_BUMP_SWO;
								break;
			
			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_COPY_BUMP_SWO;
								break;
		}
		
		return currentForwardName;
	}
}