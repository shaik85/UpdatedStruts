/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.AddCustomerActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.AddCustomerViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AddCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Action class that helps in adding the selected customers to the proposal and initiated 
 * fetch inventory action.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 10, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class AddCustomerFetchInventoryAction extends OPPTLongAction 
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
		
		AddCustomerActionForm actionForm = (AddCustomerActionForm)form;
		
		AddCustomerCustomDTO customDTO = (AddCustomerCustomDTO)getCustomerLists(session);
		String selectedIds[] = actionForm.getSelectedCustomerIds();
		if(null != selectedIds && 0 < selectedIds.length){
			if(null != customDTO){
				customDTO.setCustomerLists(getSelectedCustomers(session, customDTO.getCustomerLists(), selectedIds));

				try {
					customDTO = getProposalManager().addSelectedCustomers(customDTO);
					ErrorReport messageReport = customDTO.getMessageReport();
					if(null == messageReport){
						addDataStoreEntry(session, customDTO);
						removeCustomerLists(session);
						setForwardName(ForwardNameConstants.ACTION_FETCH_INVENTORY);
					}
					else{
						viewBean = handleMessageReport(messageReport);
					}
				}
				catch(ServiceException se){
					removeNewCustomersForInventory(session);
					viewBean = handleServiceException(session, se.getErrorReport());
				}
			}
		}
		else{
			viewBean = handleErrorReport(session, getErrorReport(ErrorCodeConstants.PA17));
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
		return ActionNameConstants.ADD_CUSTOMER_FETCH_INVENTORY;
	}

	/**
	 * Returns the collection of selected customers along with customer lists  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerLists TreeMap
	 * @param selectedIds String[]
	 * @return TreeMap
	 */
	private TreeMap getSelectedCustomers(OPPTSession session, TreeMap customerLists, String selectedIds[]){
		
		if(null != customerLists && null != selectedIds){
			List newCustomers = new ArrayList();
			for(int i=0, size=selectedIds.length; i<size; i++){
				StringTokenizer st = new StringTokenizer(selectedIds[i], Constants.STRING_SEPERATOR);
				if(null != st && 2 == st.countTokens()){
					String customerListId = st.nextToken();
					String customerId = st.nextToken();
					CustomerListCustomDTO customerList = (CustomerListCustomDTO)customerLists.get(customerListId);
					if(null != customerList){
						TreeMap customers = customerList.getCustomers();
						if(null != customers){
							CustomerListCustomerCustomDTO customer = (CustomerListCustomerCustomDTO)customers.get(customerId);
							if(null != customer){
								customer.setInventorySelected(true);
								if(!customer.isAlreadyExists()){
									newCustomers.add(customer);
								}
							}
						}
					}
				}
			}
			if(0 < newCustomers.size()){
				session.storeObjectToSession(SessionConstants.NEW_CUSTOMERS_FOR_INVENTORY, newCustomers);
			}
		}
		return customerLists;	
	}
	
	private void removeNewCustomersForInventory(OPPTSession session){
		session.removeObjectFromSession(SessionConstants.NEW_CUSTOMERS_FOR_INVENTORY);
	}
   
	private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
		ProposalCustomDTO currentProposal = null;
		if(null != session){
			currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);			
		}
		return currentProposal;
	}
	
	private void removeCustomerLists(OPPTSession session){
		if(null != session){
			session.removeObjectFromSession(SessionConstants.PROPOSAL_CUSTOMERS);
		}
	}
	
	private AddCustomerCustomDTO getCustomerLists(OPPTSession session){
		AddCustomerCustomDTO customDTO = null;
		
		if(null != session){
			customDTO = (AddCustomerCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_CUSTOMERS);
		}
		
		return customDTO;
	}

	/** 
	 * Overridden method - Usage of back button is not allowed in this case. So retutn false. 
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
     * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#validateCurrentViewContent(com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession)
     * @author thirumalai
     */
    protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = getCurrentForwardName(getRole(session));

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof AddCustomerViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.ADD_CUSTOMER);
			if(null != dataStoreEntry && dataStoreEntry instanceof AddCustomerCustomDTO){
				session.setCurrentViewBean(new AddCustomerViewBean((AddCustomerCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_ADD_CUSTOMER;
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_ADD_CUSTOMER;
								break;
		}
		
		return currentForwardName;
	}
}