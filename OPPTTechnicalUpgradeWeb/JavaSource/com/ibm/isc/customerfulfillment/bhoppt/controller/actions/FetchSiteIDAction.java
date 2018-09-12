/*
 * Created on Apr 19, 2010
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/*
* IBM Confidential
*
* ©  Copyright IBM Corp. 2004, 2005  All Rights Reserved.

* The source code for this program is not published or otherwise divested of
* its trade secrets, irrespective of what has been deposited with the U.S. Copyright office.
*/
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;


import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CustomerSelectionActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerDetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomersCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PartnerInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO;

/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FetchSiteIDAction extends OPPTAction{

	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		boolean changeproposal =false;
		ProposalHeaderCustomDTO proposalHeaderCustomDTO = getProposalHeader(session);
		ProposalCustomDTO proposalCustomDTO = proposalHeaderCustomDTO.getProposal();
		if (proposalCustomDTO != null
				&& ActionNameConstants.CHANGE_PROPOSAL
						.equals(proposalHeaderCustomDTO.getTransactionName())) {
			changeproposal = true;
		}
		CustomerSelectionActionForm customerSelectionActionForm = (CustomerSelectionActionForm)form;
		String[] selectedInv = customerSelectionActionForm.getSelectedINV();
		String selectedSTP = customerSelectionActionForm.getSelectedSTP();
				
		FetchCustomersCustomDTO fetchCustomersCustomDTO = getStoredCustomers(session);
		TreeMap customers = fetchCustomersCustomDTO.getSelectedCustomers();
		
		TreeMap selectedcustomers = getSelectedCustomers(customers,selectedInv,selectedSTP);
		
				
		fetchCustomersCustomDTO.setSelectedCustomers(selectedcustomers); 
		saveCustomers(session,fetchCustomersCustomDTO);
		
	//DADO02 to dispaly the stored customers in proposaldetails page by selecting the fetch Addsiteid buttion
//		if(null!=proposalHeaderCustomDTO.getPartnerInformationCustomDTO().getSelectedCustomers()){
//		List storedcustomers =	proposalHeaderCustomDTO.getPartnerInformationCustomDTO().getSelectedCustomers();
//		}

		PartnerInformationCustomDTO partnerInformation = proposalHeaderCustomDTO.getPartnerInformationCustomDTO();
		
		viewBean = new PartnerDetailsViewBean(false, changeproposal, partnerInformation, "");
		setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PARTNER_DETAILS);
		
		
		return viewBean;
	}

	
	public void saveCustomers(OPPTSession session, FetchCustomersCustomDTO dto) {
		if(null != session && null != dto){
			session.storeObjectToSession(SessionConstants.CUSTOMERS_FOR_PREVIOUS_SITEID, dto);
		}
	}
	
	
	
	
	protected boolean validateCurrentViewContent(OPPTSession session) {
		return true;
	}
	
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date APR 15, 2010 
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
		return ActionNameConstants.ADD_FETCH_SITEIDS;
	}
	
	//DADO02 SATEESH
	private FetchCustomersCustomDTO getStoredCustomers(OPPTSession session){
		return (FetchCustomersCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_CREATION_CUSTOMERS);
	}
	
	private TreeMap getSelectedCustomers(TreeMap customers ,String[] selectedInv,String selectedSTP){
		CustomerListCustomDTO customerListCustomDTO =null;
		TreeMap newCustomers = new TreeMap();
		//making all previous checked INV and STP as unchecked 
		if(null!=customers){
		Iterator customer = customers.entrySet().iterator();
		while(customer.hasNext()){
			Map.Entry entry = (Map.Entry) customer.next();
			CustomerListCustomDTO customerListCustomDTO1 =  (CustomerListCustomDTO)entry.getValue(); 
			customerListCustomDTO1.setInventorySelected(false);
			customerListCustomDTO1.setSTPSelected(false);
			newCustomers.put(customerListCustomDTO1.getCustomerNumber(),customerListCustomDTO1);
		}
		}
		
		//making all INV and STP checked
		if(null!=newCustomers && null!=selectedInv){
		
			for( int i=0;i<selectedInv.length;i++){
				
			    customerListCustomDTO = (CustomerListCustomDTO)customers.get(selectedInv[i]);
			    String customerNumber = customerListCustomDTO.getCustomerNumber();
			   	String customerName = customerListCustomDTO.getCustomerName();
			   	boolean isAlreadyExists = customerListCustomDTO.isAlreadyExists();
				customers.remove(selectedInv[i]);
				customerListCustomDTO = new CustomerListCustomDTO();
				//setting new INV value
				customerListCustomDTO.setCustomerNumber(customerNumber);
				customerListCustomDTO.setCustomerName(customerName);
				customerListCustomDTO.setInventorySelected(true);
				customerListCustomDTO.setAlreadyExists(isAlreadyExists);
				if(selectedSTP.equalsIgnoreCase(selectedInv[i])){
					customerListCustomDTO.setSTPSelected(true);
				}
				else{
					customerListCustomDTO.setSTPSelected(false);
				}
				newCustomers.put(customerListCustomDTO.getCustomerNumber(),customerListCustomDTO);
			}
		
		}
		
		return newCustomers;
	}
	
	private ProposalHeaderCustomDTO getProposalHeader(OPPTSession session){
		return (ProposalHeaderCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_HEADER);
	}
  //DADO02
}
