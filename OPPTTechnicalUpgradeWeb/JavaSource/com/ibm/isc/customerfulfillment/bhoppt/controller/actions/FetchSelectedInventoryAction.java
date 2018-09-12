/*
 * Created on May 20, 2010
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

/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.FetchSelectedInventoryActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.UnfetchdSelectedInvViewbean;
import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo.CustomerBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.factory.CustomerBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.InventoryDAO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomersCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchSelectedInventoryDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
public class FetchSelectedInventoryAction extends OPPTLongAction{
	ArrayList a= new ArrayList();
	ArrayList b= new ArrayList();
	ArrayList c= new ArrayList();
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception
	{
		ProposalCustomDTO currentProposal = getCurrentProposal(session);
		TreeMap t = new TreeMap();
		FetchCustomersCustomDTO fetchCustomersCustomDTO=new FetchCustomersCustomDTO();
		//FetchCustomersCustomDTO customers = (FetchCustomersCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_CREATION_CUSTOMERS);
		
		//Added by JD
		//List customerLists = (List)session.getObjectFromSession(SessionConstants.SELECTED_INVENTORY);
		List customers = getCustomers(currentProposal.getId());
		ArrayList cList=new ArrayList();
	    if(null != customers){
	    Iterator iterator = customers.iterator();
        while(iterator.hasNext()){
	    CustomerListCustomDTO customerList = (CustomerListCustomDTO)iterator.next();
    
        cList.add(customerList.getCustomerNumber());
	    }
	
	    }
	    if(cList!=null)
	    {
	    	Iterator iter = cList.iterator();
			int c=0;
			while (iter.hasNext())
			{
				String n=(String)iter.next();
	    	}
	    }
		 OPPTViewBean viewBean = null;
	   	//FetchSelectedInventoryDTO fetchSelectedInventoryDTO=new FetchSelectedInventoryDTO();
	     FetchSelectedInventoryActionForm fsa=(FetchSelectedInventoryActionForm)form;	     
		 
		 FetchSelectedInventoryDTO dto= new FetchSelectedInventoryDTO();
		 dto.setDesignatedMachineID(fsa.getList1());
		 dto.setMaterialID(fsa.getList2());
		 dto.setSerialNumber(fsa.getList3());
		 	 
	  
			InventoryCustomDTO customDTO = getInventoryCustomDTO(currentProposal, InventoryCustomDTO.FETCH_INVENTORY);		customDTO.setCustomers(getNewCustomersForInventory(session));
			setTransactionInformation(customDTO, session);
					 
			try {
				customDTO.setCustomers(customers);
				currentProposal.setSelectedInventory(true);
				customDTO.setDesignatedMachineID(dto.getDesignatedMachineID());
				customDTO.setMaterialID(dto.getMaterialID());
				customDTO.setSerialNumber(dto.getSerialNumber());
				customDTO.setCustomersList(cList);
			    customDTO.setSelectedInventory(currentProposal.isSelectedInventory());
				customDTO = getProposalManager().fetchInventory(customDTO);
				removeNewCustomersForInventory(session);
				session.storeObjectToSession(SessionConstants.RFETCH_SELECTED_INVENTORY,customDTO);//jagdeesh
				//saveInventoryDTO(customDTO,String.valueOf(customDTO.getId())); //Added by jagdeesh
				ErrorReport messageReport = customDTO.getMessageReport();
				if(null == messageReport){
					if(customDTO.isErrSelectedInventory()){
						viewBean = new UnfetchdSelectedInvViewbean(customDTO);
						setForwardName(ForwardNameConstants.PAGE_UNFETCHED_SELECTED_INV);
					}else{
						setForwardName(ForwardNameConstants.ACTION_PROPOSAL_DETAILS);
					}
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
	
	private void removeNewCustomersForInventory(OPPTSession session){
		session.removeObjectFromSession(SessionConstants.NEW_CUSTOMERS_FOR_INVENTORY);
	}
	protected String getActionName() {
				
		//return ActionNameConstants.FETCH_INVENTORY;
		return "fetchselectedinventory";
	}
	protected boolean validateCurrentViewContent(OPPTSession session) {
		return true;
	}
	private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
		ProposalCustomDTO currentProposal = null;
		
		if(null != session){
			currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);
		}
		
		return currentProposal;
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
	private List getNewCustomersForInventory(OPPTSession session){
		List newCustomers = null;
		Object object = session.getObjectFromSession(SessionConstants.NEW_CUSTOMERS_FOR_INVENTORY);
		if(null != object){
			newCustomers = (ArrayList)object;
		}
		return newCustomers;
	}
	
	//Added by jagdeesh
	/*public void saveInventoryDTO(Object inventoryDTO,String proposalId) throws Exception{
		InventoryDAO  inventoryDAO= new InventoryDAO();
		inventoryDAO.storeSelectedInventory(inventoryDTO,proposalId);
		
	}*/
	
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
