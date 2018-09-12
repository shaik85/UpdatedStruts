/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CustomerActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class CustomerDetailsAction extends OPPTLongAction 
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
   protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception 
   {
	   OPPTViewBean viewBean = null;
		
	   CustomerActionForm actionForm = (CustomerActionForm)form;
	    ProposalCustomerCustomDTO customDTO = getCustomer(session, actionForm.getCustomerId(), actionForm.getType());
	   if(null != customDTO){
		   setTransactionInformation(customDTO, session);
			
		   try{
			   customDTO = getProposalManager().retrieveCustomerDetails(customDTO);
			   ErrorReport messageReport = customDTO.getMessageReport();
			   if(null == messageReport){
				   addDataStoreEntry(session, customDTO);
				   viewBean = new CustomerDetailsViewBean(customDTO);
				   setForwardName(getRole(session));
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
	   }
	   else{
		   viewBean = new ErrorViewBean();
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
	   return ActionNameConstants.CUSTOMER_DETAILS;
   }

   private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
	   ProposalCustomDTO currentProposal = null;
	   if(null != session){
		   currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);			
	   }
	   return currentProposal;
   }

   private ProposalCustomerCustomDTO getCustomer(OPPTSession session, String customerId, String type) 
   {
	   ProposalCustomerCustomDTO customDTO = null;
	   TreeMap customers = null;
	   if(null != session && null != customerId){
		   ProposalDetailsCustomDTO proposalDetails = (ProposalDetailsCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_DETAILS);
			if(null != proposalDetails){
				if(type != null && type.equalsIgnoreCase("sands")){
					customers = proposalDetails.getSAndSCustomers();
				}
				else{
					customers = proposalDetails.getCustomers();
				}
			   
				if(null != customers){
					customDTO = (ProposalCustomerCustomDTO)customers.get(customerId);
				}
		   }
	   }
	   return customDTO;
   }

   private void setForwardName(int role){
	   switch(role){
		   case Constants.PROPOSAL_CREATE_APPROVER: 
							   setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CUSTOMER_DETAILS);
							   break;

		   case Constants.PROPOSAL_ADMINISTRATOR:
		   default:
							   setForwardName(ForwardNameConstants.PAGE_CUSTOMER_DETAILS);
							   break;
	   }
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
}