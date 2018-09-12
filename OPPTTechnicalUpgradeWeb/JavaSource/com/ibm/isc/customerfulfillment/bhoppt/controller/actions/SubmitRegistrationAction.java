/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.RegistrationActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.RegistrationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RegistrationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class SubmitRegistrationAction extends OPPTLongAction {
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 17, 2003 
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
		
/*		OPPTSession opptSession = new OPPTSession(session);
		RegistrationViewBean view = (RegistrationViewBean)opptSession.getCurrentViewBean();
		if(null == view){
			return;
		}
	*/	
		OPPTViewBean viewBean = null;
		OPPTLogger.debug("Called SubmitRegistrationAction class", "SubmitRegistrationAction", "executeAction");
		RegistrationCustomDTO customDTO = getRegistrationData(session);
		RegistrationActionForm actionForm = (RegistrationActionForm)form;
		customDTO.setSelectedApproverId(actionForm.getApproverId());
		customDTO.setSendContractTo(actionForm.getSendContractTo());
		customDTO.setSendReplyTo(actionForm.getSendReplyNotesTo());
		try {
			customDTO = getProposalManager().proposalRegistration(customDTO);
			ErrorReport errorReport = customDTO.getMessageReport();
			if(null == errorReport){
				RegistrationViewBean regViewBean= new RegistrationViewBean();// added by ramesh
				removeRegistrationData(session);
				//Commented and added for the change DAD O11 Remove approval step,Blue Harmony -Ramesh
				//String initiator = actionForm.getInitiator();
				String initiator = regViewBean.getInitiator();
				OPPTLogger.debug("In SubmitRegistrationAction:: initiator1:"+initiator,"SubmitRegistrationAction", "executeAction");
				
				if(null == initiator || initiator.equalsIgnoreCase(RegistrationViewBean.REGISTRAION_PROPOSAL)){
					OPPTLogger.debug("In SubmitRegistrationAction:: forward ACTION_APPROVE_PROPOSAL","SubmitRegistrationAction", "executeAction");
//					Commented and added for the change DAD O11 Remove approval step,Blue Harmony -Ramesh
					//setForwardName(ForwardNameConstants.ACTION_PROPOSAL_MAINTENANCE);
					setForwardName(ForwardNameConstants.ACTION_APPROVE_PROPOSAL);
				}
				else{
					OPPTLogger.debug("In SubmitRegistrationAction:: forward ACTION_CONTRACT_MAINTENANCE","SubmitRegistrationAction", "executeAction");
					setForwardName(ForwardNameConstants.ACTION_CONTRACT_MAINTENANCE);
				}
			}
			else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(errorReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);
			}
		}
		catch(ServiceException se){
			viewBean = handleServiceException(session, se.getErrorReport());
		}
		
		return viewBean;
	}

	/** 
	 * Overridden method - Returns action name of the current action. 
	 * 
	 * <br/><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#getActionName() 
	 * @return String
	 * 
	 */
	protected String getActionName() {
		return ActionNameConstants.SUBMIT_REGISTRATION;
	}
	
	private RegistrationCustomDTO getRegistrationData(OPPTSession session){
		RegistrationCustomDTO customDTO = null;
		
		if(null != session){
			customDTO = (RegistrationCustomDTO)session.getObjectFromSession(SessionConstants.REGISTER_PROPOSAL);
		}
		
		return customDTO;
	}
	
	private void removeRegistrationData(OPPTSession session){
		if(null != session){
			session.removeObjectFromSession(SessionConstants.REGISTER_PROPOSAL);
		}
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
     * @author thirumalai
     */
    protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = getCurrentForwardName(session, getRole(session));

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof RegistrationViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.REGISTRATION);
			if(null == dataStoreEntry){
				dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.CLOSE_CONTRACT);
			}
			if(null != dataStoreEntry && dataStoreEntry instanceof RegistrationCustomDTO){
				session.setCurrentViewBean(new RegistrationViewBean((RegistrationCustomDTO)dataStoreEntry));
				session.setCurrentForward(actualForward);
				valid = true;
			}
		}
		
		return valid;
	}

	private String getCurrentForwardName(OPPTSession session, int role){
		String currentForwardName = null;

		RegistrationCustomDTO customDTO = (RegistrationCustomDTO)session.getObjectFromSession(SessionConstants.REGISTER_PROPOSAL);
		if(null != customDTO){
			if(customDTO.isVarianceContractClosure()){
				switch(role){
					case Constants.PROPOSAL_CREATE_APPROVER: 
										currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_REGISTRATION;
										break;
			
					case Constants.PROPOSAL_ADMINISTRATOR:
					default:
										currentForwardName = ForwardNameConstants.PAGE_CONTRACT_REGISTRATION;
										break;
				}
			}
			else{
				switch(role){
					case Constants.PROPOSAL_CREATE_APPROVER: 
										currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSAL_REGISTRATION;
										break;
			
					case Constants.PROPOSAL_ADMINISTRATOR:
					default:
										currentForwardName = ForwardNameConstants.PAGE_PROPOSAL_REGISTRATION;
										break;
				}
			}
		}

		return currentForwardName;
	}
}
