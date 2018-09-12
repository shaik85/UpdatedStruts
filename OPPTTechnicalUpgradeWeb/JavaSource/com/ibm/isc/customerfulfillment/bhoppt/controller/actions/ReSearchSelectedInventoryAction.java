/*
 * Created on Nov 15, 2010
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.struts.action.ActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerInformationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo.CustomerBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.factory.CustomerBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.PartnerInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ReSearchSelectedInventoryAction extends OPPTLongAction {

	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception
	{
		ProposalCustomDTO currentProposal = getCurrentProposal(session);
		ProposalDetailsCustomDTO customDTO = new ProposalDetailsCustomDTO();
		 OPPTViewBean viewBean = null;
		 setTransactionInformation(customDTO, session);
			customDTO.setProposalDTO(currentProposal);
			customDTO.setPageIndex(1);
			customDTO.setRequestFor(UtilityConstants.GOTO_PAGE);
					 
			try {
				customDTO = getProposalManager().fetchProposalDetails(customDTO);
				PartnerInformationCustomDTO partnerInformation = customDTO.getPartnerInformation();
				if(null != partnerInformation)
				{ 
					System.out.println("ReSearchSelectedInventoryAction.executeAction()1:insidecustinfo");
					partnerInformation.setSelectedCustomers(customDTO.getSelectedCustomers()); //DADO02 Sateesh Anne BlueHarmony
					InventoryCustomDTO fullInventoryCustomDTO = getFullInventory(session);
					partnerInformation.setInventoryCustomDTO(fullInventoryCustomDTO);
					viewBean = new PartnerInformationViewBean(partnerInformation);
					setForwardName(ForwardNameConstants.FETCH_SELECTED_INV);
				}else
				{
					System.out.println("ReSearchSelectedInventoryAction.executeAction()In else ");
					viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA40), ForwardNameConstants.ACTION_REFRESH_PROPOSAL_MAINTENANCE, true);
					setForwardName(ForwardNameConstants.PAGE_ERROR);
				}
				
			}catch(ServiceException se){
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
		return "unselectcancel";
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
	private void saveCurrentProposal(OPPTSession session, ProposalCustomDTO currentProposal){
		if(null != session && null != currentProposal){
			session.storeObjectToSession(SessionConstants.CURRENT_PROPOSAL, currentProposal);
		}
	}
	
	
	/**
	 * 
	 * @author administrator
	 *
	 * TODO To change the template for this generated type comment go to
	 * Window - Preferences - Java - Code Style - Code Templates
	 */
	
	private InventoryCustomDTO getFullInventory(OPPTSession session){
		InventoryCustomDTO inventoryCustomDTO = null;
		if(null != session){
			inventoryCustomDTO= (InventoryCustomDTO)session.getObjectFromSession(SessionConstants.RFETCH_SELECTED_INVENTORY);
		}
		return inventoryCustomDTO;
	}


}
