/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.Map;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CopyDMActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CopyDMViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class CopyDMAction extends OPPTLongAction 
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		CopyDMActionForm actionForm = (CopyDMActionForm)form;
		CopyDMCustomDTO customDTO = getCopyDM(session);
		customDTO.setTransactionName(getActionName());

		customDTO = getInputData(customDTO, actionForm, session);

		try {
			customDTO = getProposalManager().copyDMInventory(customDTO);
			removeCopyDM(session);
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
		return ActionNameConstants.COPY_INVENTORY_DM;
	}

	private CopyDMCustomDTO getCopyDM(OPPTSession session) 
	{
		CopyDMCustomDTO customDTO = null;
		
		if(null != session){
			customDTO = (CopyDMCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_COPY_INVENTIORY_DM);
		}
		
		return customDTO;
	}
   
	private void removeCopyDM(OPPTSession session) 
	{
    	if(null != session){
    		session.removeObjectFromSession(SessionConstants.SESSION_COPY_INVENTIORY_DM);
    	}
	}

	private CopyDMCustomDTO getInputData(CopyDMCustomDTO customDTO, CopyDMActionForm actionForm, OPPTSession session){
		if(null != actionForm && null != session && null != customDTO)
		{
			String soldToParty = actionForm.getSoldToParty();
			
			Map soldToPartys = customDTO.getTargetCustomers();
			if(null != soldToPartys && null != soldToParty){
				ProposalCustomerCustomDTO targetCustomer = (ProposalCustomerCustomDTO)soldToPartys.get(soldToParty);
				DMCustomDTO targetDM = new DMCustomDTO();
				targetDM.setProposalId(targetCustomer.getProposalId());
				targetDM.setCustomerId(String.valueOf(targetCustomer.getCustomerId()));
				targetDM.setNumber(actionForm.getDmNumber());
				targetDM.setDescription(actionForm.getDmDescription());
				customDTO.setTargetDM(targetDM);
				customDTO.setTargetCustomer(targetCustomer);					
			}
			
			customDTO.setPlanEndDate(actionForm.getPlanEndDate().getDate());
			customDTO.setPlanStartDate(actionForm.getPlanStartDate().getDate());

			ProposalCustomerCustomDTO targetCustomer = customDTO.getTargetCustomer();
			if(null != targetCustomer){
				if(null == customDTO.getPlanEndDate()){ 
					customDTO.setPlanEndDate(targetCustomer.getPlanEndDate());
				}
				if(null == customDTO.getPlanStartDate()){
					customDTO.setPlanStartDate(targetCustomer.getPlanStartDate());
				}
			}
		}
	
		return customDTO;
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
			if(viewBean instanceof CopyDMViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.COPY_INVENTORY);
			if(null != dataStoreEntry && dataStoreEntry instanceof CopyDMCustomDTO){
				session.setCurrentViewBean(new CopyDMViewBean((CopyDMCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_COPY_DM;
								break;
			
			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_COPY_DM;
								break;
		}
		
		return currentForwardName;
	}
}