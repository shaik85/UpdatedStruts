/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.EditInventoryActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.EditCustomerDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.EditDMDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.EditSWODataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.EditInventoryViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ESWCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditDMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditInventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditSWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Action class that handles editing a customer 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 21, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class SubmitEditInventoryAction extends OPPTLongAction 
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
		
		EditInventoryActionForm actionForm = (EditInventoryActionForm)form;

		EditInventoryCustomDTO customDTO = getEditInventory(session);
		customDTO.setTransactionName(getActionName());
		
		customDTO = getEditInventory(customDTO, actionForm, session);
		try {
			
			getProposalManager().saveInventory(customDTO);
			removeEditInventory(session);
			setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS);
		}
		catch(ServiceException se){
			viewBean = handleServiceException(session, se.getErrorReport(), session.getCurrentForward(), session.getCurrentForward());
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
		return ActionNameConstants.EDIT_INVENTORY_CUSTOMER;
	}

	private EditInventoryCustomDTO getEditInventory(OPPTSession session) 
	{
		EditInventoryCustomDTO customDTO = null;
		if(null != session){
			customDTO = (EditInventoryCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_EDIT_INVENTIORY);
		}
		return customDTO;
	}
   
	private void removeEditInventory(OPPTSession session){
    	if(null != session){
    		session.removeObjectFromSession(SessionConstants.SESSION_EDIT_INVENTIORY);
    	}
	}

	private EditInventoryCustomDTO getEditInventory(EditInventoryCustomDTO customDTO, EditInventoryActionForm actionForm, OPPTSession session){
		if(null != actionForm && null != session && null != customDTO)
		{
			HashMap customers = actionForm.getCustomers();
			if(0 < customers.size()){
				Iterator iterator = customers.keySet().iterator();
				while(iterator.hasNext()){
					String key = iterator.next().toString();
					EditCustomerDataBean customer = (EditCustomerDataBean)customers.get(key);
					EditCustomerCustomDTO customerCustomDTO = (EditCustomerCustomDTO)customDTO.getSelectedCustomers().get(key);
					
					String billToParty = customer.getBillToPartyNumber();
					Map billToPartys = customerCustomDTO.getBillToParty();
					if(null != billToPartys && null != billToParty){
						customerCustomDTO.setSelectedBillToParty((ESWCustomerCustomDTO)billToPartys.get(billToParty));
					}
	
					String payer = customer.getPayerNumber();
					Map payers = customerCustomDTO.getPayer();
					if(null != payers && null != payer){
						customerCustomDTO.setSelectedPayer((ESWCustomerCustomDTO)payers.get(payer));
					}
			
					customerCustomDTO.setEditPlanStartDate(customer.getPlanStartDate().getDate());
					customerCustomDTO.setEditPlanEndDate(customer.getPlanEndDate().getDate());
				}
			}

			HashMap dms = actionForm.getDMs();
			if(0 < dms.size()){
				Iterator iterator = dms.keySet().iterator();
				while(iterator.hasNext()){
					String key = iterator.next().toString();
					EditDMDataBean dm = (EditDMDataBean)dms.get(key);
					EditDMCustomDTO dmCustomDTO = (EditDMCustomDTO)customDTO.getSelectedDMs().get(key);
					
					dmCustomDTO.setEditPlanStartDate(dm.getPlanStartDate().getDate());
					dmCustomDTO.setEditPlanEndDate(dm.getPlanEndDate().getDate());
				}
			}

			HashMap swos = actionForm.getSWOs();
			if(0 < swos.size()){
				Iterator iterator = swos.keySet().iterator();
				while(iterator.hasNext()){
					String key = iterator.next().toString();
					EditSWODataBean swo = (EditSWODataBean)swos.get(key);
					EditSWOCustomDTO swoCustomDTO = (EditSWOCustomDTO)customDTO.getSelectedSWOs().get(key);
					
					swoCustomDTO.getSelectedSWO().setAlternatePrice(getAlternatePrice(swo.getAlternatePrice()));
					swoCustomDTO.setEditPlanStartDate(swo.getPlanStartDate().getDate());
					swoCustomDTO.setEditPlanEndDate(swo.getPlanEndDate().getDate());
				}
			}
		}

		return customDTO;
	}

	/**
     * @author thirumalai
     */
    protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = getCurrentForwardName(getRole(session));

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof EditInventoryViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.EDIT_INVENTORY);
			if(null != dataStoreEntry && dataStoreEntry instanceof EditInventoryCustomDTO){
				session.setCurrentViewBean(new EditInventoryViewBean((EditInventoryCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_EDIT_INVENTORY;
								break;
			
			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_EDIT_INVENTORY;
								break;
		}
		
		return currentForwardName;
	}

	private double getAlternatePrice(String alternatePrice){
		double value = 0;
		
		try{
			if(null == alternatePrice){
				value = -1;
			}
			else{
				if(0 == alternatePrice.trim().length()){
					value = -1;
				}
				else{
					value = Double.parseDouble(alternatePrice);
				}
			}
		}
		catch(Exception e){
			value = -1;
		}
		
		return value;
	}
}