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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CopyCustomerActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CopyCustomerViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CopyCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class CopyCustomerAction extends OPPTLongAction {
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
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception 
	{
		OPPTViewBean viewBean = null;
		
		CopyCustomerActionForm actionForm = (CopyCustomerActionForm)form;
		CopyCustomerCustomDTO customDTO = getCopyCustomer(session);
		customDTO.setTransactionName(getActionName());

		customDTO = getInputData(customDTO, actionForm, session);

		try {
			customDTO = getProposalManager().copyCustomerInventory(customDTO);
			removeCopyCustomer(session);
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
		return ActionNameConstants.COPY_INVENTORY_CUSTOMER;
	}

	private CopyCustomerCustomDTO getCopyCustomer(OPPTSession session) {
		CopyCustomerCustomDTO customDTO = null;
		
		if(null != session){
			customDTO = (CopyCustomerCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_COPY_INVENTIORY_CUSTOMER);
		}
		
		return customDTO;
	}

	private void removeCopyCustomer(OPPTSession session) {
		session.removeObjectFromSession(SessionConstants.SESSION_COPY_INVENTIORY_CUSTOMER);

	}

	private CopyCustomerCustomDTO getInputData(CopyCustomerCustomDTO customDTO, CopyCustomerActionForm actionForm, OPPTSession session){
		if(null != actionForm && null != session && null != customDTO)
		{
			String soldToParty = actionForm.getTargetSoldToParty();
			
			Map soldToPartys = customDTO.getTargetCustomers();
			if(null != soldToPartys && null != soldToParty){
				customDTO.setTargetCustomer((ProposalCustomerCustomDTO)soldToPartys.get(soldToParty));
			}

			customDTO.setPlanEndDate(actionForm.getPlanEndDate().getDate());
			customDTO.setPlanStartDate(actionForm.getPlanStartDate().getDate());
			
			ProposalCustomerCustomDTO sourceCustomer = customDTO.getSourceCustomer();
			if(null != sourceCustomer){
				if(null == customDTO.getPlanEndDate()){ 
					customDTO.setPlanEndDate(sourceCustomer.getPlanEndDate());
				}
				if(null == customDTO.getPlanStartDate()){
					customDTO.setPlanStartDate(sourceCustomer.getPlanStartDate());
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
			if(viewBean instanceof CopyCustomerViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.COPY_INVENTORY);
			if(null != dataStoreEntry && dataStoreEntry instanceof CopyCustomerCustomDTO){
				session.setCurrentViewBean(new CopyCustomerViewBean((CopyCustomerCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_COPY_CUSTOMER;
								break;
			
			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_COPY_CUSTOMER;
								break;
		}
		
		return currentForwardName;
	}
}
