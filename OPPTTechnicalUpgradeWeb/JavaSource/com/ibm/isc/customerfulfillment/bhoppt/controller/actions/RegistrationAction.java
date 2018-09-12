/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class RegistrationAction extends OPPTLongAction {
	/** 
	 * Overridden method - logic for connecting to service layer to get the data required for 
	 * registering proposal and creating view bean out of the data received will be present here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {		
		OPPTViewBean viewBean = null;
		ProposalCustomDTO currentProposal = getCurrentProposal(session);
		RegistrationCustomDTO customDTO = new RegistrationCustomDTO();
		setTransactionInformation(customDTO, session);
		customDTO.setProposalDTO(currentProposal);

		try {
			customDTO = getProposalManager().getRegistrationData(customDTO);
			ErrorReport errorReport = customDTO.getMessageReport();
			if(null == errorReport){
				addDataStoreEntry(session, customDTO);
				setRegistrationData(session, customDTO);
				if(currentProposal instanceof ContractCustomDTO){
					viewBean = new RegistrationViewBean(customDTO, RegistrationViewBean.REGISTRAION_CONTRACT);
				}
				else{ 
					viewBean = new RegistrationViewBean(customDTO, RegistrationViewBean.REGISTRAION_PROPOSAL);
				}
				setForwardName(getRole(session));
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
	 * Overridden method - Returns current action's name. 
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
		return ActionNameConstants.REGISTRATION;
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

	private void setRegistrationData(OPPTSession session, RegistrationCustomDTO customDTO) {
		if(null != session && null != customDTO){
			session.storeObjectToSession(SessionConstants.REGISTER_PROPOSAL, customDTO);
		}
	}

	private void setForwardName(int role){
		
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								// Commented and added for the change DAD O11 Remove approval step,Blue Harmony -Ramesh 
								//setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSAL_REGISTRATION);								
								setForwardName(ForwardNameConstants.ACTION_SUBMIT_REGISTRATION);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								// Commented and added for the change DAD O11 Remove approval step,Blue Harmony -Ramesh 
								//setForwardName(ForwardNameConstants.PAGE_PROPOSAL_REGISTRATION);
								setForwardName(ForwardNameConstants.ACTION_SUBMIT_REGISTRATION);
								break;
		}
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
}