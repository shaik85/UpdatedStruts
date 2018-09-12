/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalDetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo.CustomerBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.factory.CustomerBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.InventoryDAO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalDetailsCustomDTO;
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
public class ReFetchInventoryAction extends OPPTLongAction {
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
		String  changeproposalstatus = getchangeProposalstatus(session); //added by ramesh
		ProposalCustomDTO currentProposal = getCurrentProposal(session);
		InventoryCustomDTO customDTO = getInventoryCustomDTO(currentProposal, InventoryCustomDTO.REFETCH_INVENTORY);
		setTransactionInformation(customDTO, session);
		
		//List customers =(List)session.getObjectFromSession(SessionConstants.SELECTED_INVENTORY);
		List customers = getCustomers(currentProposal.getId());
        if(null!=customers){
        	customDTO.setCustomers(customers);	
        }
		try{
			/*//InventoryCustomDTO selectedcustomDTO =(InventoryCustomDTO)session.getObjectFromSession(SessionConstants.RFETCH_SELECTED_INVENTORY);
			//InventoryCustomDTO selectedcustomDTO = getSelectedInventory(String.valueOf(currentProposal.getId()));
	 	   // selectedcustomDTO.setSelectedInventory(false); //hardcoding for tesing purpose
			if(null!=selectedcustomDTO){
				//for selectedfetch inventory
			if(selectedcustomDTO.isSelectedInventory())
			  {
				customDTO = getProposalManager().fetchInventory(selectedcustomDTO);
				}
			}else{*/
			 //for fetchall inventory
			if(changeproposalstatus!= null && changeproposalstatus.equalsIgnoreCase("true")){ //added by ramesh
				customDTO.setChangeProposal(true);
			}
			customDTO.setRefetch(true);
			customDTO = getProposalManager().fetchInventory(customDTO);
			
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
		return ActionNameConstants.RE_FETCH_INVENTORY;
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
			if(viewBean instanceof ProposalDetailsViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.PROPOSAL_DETAILS);
			if(null != dataStoreEntry && dataStoreEntry instanceof ProposalDetailsCustomDTO){
				session.setCurrentViewBean(new ProposalDetailsViewBean((ProposalDetailsCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSAL_DETAILS;
								break;
			
			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_PROPOSAL_DETAILS;
								break;
		}
		
		return currentForwardName;
	}
	
	
	public InventoryCustomDTO getSelectedInventory(String proposalId)throws Exception{
		
		InventoryDAO inventoryDAO = new InventoryDAO();
		InventoryCustomDTO customDTO = (InventoryCustomDTO)inventoryDAO.getSelectedInventory(proposalId);
		
		return customDTO;
	}
	
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
//	added by ramesh
	private String getchangeProposalstatus(OPPTSession session){
		return (String)session.getObjectFromSession(SessionConstants.CHANGE_PROPOSAL);
		
	} 
}
