/*
 * Created on Nov 25, 2010
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
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo.CustomerBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.factory.CustomerBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.InventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * @author administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ContinueSelectedInventoryAction extends OPPTLongAction {

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 25, 2010
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
		List customers = getCustomers(currentProposal.getId());
		boolean continuErrSelectInv=true;
		if(null != session)
		{
			customDTO= (InventoryCustomDTO)session.getObjectFromSession(SessionConstants.RFETCH_SELECTED_INVENTORY);
		}  
		try {
			System.out.println("comming ContinueSelectedInventoryAction!!");
			customDTO.setCustomers(customers);
			customDTO.setContinuErrSelectInv(continuErrSelectInv);
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
	 * @see com.ibm.isc.customerfulfillment.oppt.controller.OPPTAction#isBackButtonAllowed() 
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
