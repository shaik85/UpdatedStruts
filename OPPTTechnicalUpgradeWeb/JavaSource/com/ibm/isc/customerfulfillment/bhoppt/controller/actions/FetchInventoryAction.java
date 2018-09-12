/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;
import java.util.*;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo.CustomerBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.factory.CustomerBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomersCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Action class that fetches inventory from backend and updates front end tables. If successful 
 * it forwards the control to proposal details action else it forwards the control to error page.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 12, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class FetchInventoryAction extends OPPTLongAction {
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception
	{
		
		OPPTViewBean viewBean = null;
		
		ProposalCustomDTO currentProposal = getCurrentProposal(session);
		InventoryCustomDTO customDTO = getInventoryCustomDTO(currentProposal, InventoryCustomDTO.FETCH_INVENTORY);
		customDTO.setCustomers(getNewCustomersForInventory(session));
		setTransactionInformation(customDTO, session);
		/*
		 * 
		 * 
		 * Added by SJD
		 */
		
		//
		//List customerLists = (List)session.getObjectFromSession(SessionConstants.SELECTED_INVENTORY);
		//FetchCustomersCustomDTO customers = (FetchCustomersCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_CREATION_CUSTOMERS);
		List customers = getCustomers(currentProposal.getId());
	


     
		//  TreeMap customerLists = customers.getSelectedCustomers();
	   
		try {
		   customDTO.setCustomers(customers);
			customDTO = getProposalManager().fetchInventory(customDTO);
			removeNewCustomersForInventory(session);
			ErrorReport messageReport = customDTO.getMessageReport();
			if(null == messageReport){
				setForwardName(ForwardNameConstants.ACTION_PROPOSAL_DETAILS);
			}
			else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(messageReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);
			}
		}
		catch(ServiceException se){
			viewBean = new ErrorViewBean();
			viewBean.setErrorReport(se.getErrorReport());
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
		return ActionNameConstants.FETCH_INVENTORY;
	}

	/**
	 * Gets the current proposal stored as part of the session  
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
	 * @return ProposalCustomDTO
	 */
	private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
		ProposalCustomDTO currentProposal = null;
		
		if(null != session){
			currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);
		}
		
		return currentProposal;
	}
	
	private List getNewCustomersForInventory(OPPTSession session){
		List newCustomers = null;
		Object object = session.getObjectFromSession(SessionConstants.NEW_CUSTOMERS_FOR_INVENTORY);
		if(null != object){
			newCustomers = (ArrayList)object;
		}
		return newCustomers;
	}
	
	private void removeNewCustomersForInventory(OPPTSession session){
		session.removeObjectFromSession(SessionConstants.NEW_CUSTOMERS_FOR_INVENTORY);
	}

	private InventoryCustomDTO getInventoryCustomDTO(ProposalCustomDTO proposalDTO, String type){
		InventoryCustomDTO customDTO = null;
		
		if(null != proposalDTO){
			customDTO = new InventoryCustomDTO();
			customDTO.setData(proposalDTO.getId(), proposalDTO.getName(), proposalDTO.getType(), proposalDTO.getStatus(), proposalDTO.getOldContractNumber(), proposalDTO.getLockedBy(), proposalDTO.getAccess());
			customDTO.setFetchType(type);
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
	//
	public List getCustomers(int proposalId )throws Exception{
		List customersList = new  ArrayList();
		CustomerBOFactory customerBo = new CustomerBOFactory();
		
	     List customers = customerBo.findCustomerBOforProposal(proposalId,1);
		 if(null!=customers){
			Iterator iterator = customers.iterator();
			while (iterator.hasNext())
			{
				CustomerBO customerBO = (CustomerBO) iterator.next();
				CustomerListCustomDTO customDTO = new CustomerListCustomDTO(); 
				customDTO.setCustomerNumber(customerBO.getSapCustomerNo());
				customDTO.setCustomerName(customerBO.getSapCustomerName());
				customersList.add(customDTO);
			}
		}
		return customersList;
	}
	
}
