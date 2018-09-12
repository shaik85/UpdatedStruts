/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ContractExtensionActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ContractExtensionViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ExtendContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RegistrationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ExtendIntremediateContractAction extends OPPTLongAction 
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
		throws Exception {
		OPPTViewBean viewBean=null;
		ExtendContractCustomDTO customDto;
		
		ContractExtensionActionForm actionForm = (ContractExtensionActionForm)form;	
		RegistrationCustomDTO registrationDto=new RegistrationCustomDTO();
		customDto = getFromSession(session);
		
		if(null != customDto){
			setTransactionInformation(registrationDto, session);
			customDto.setExtensionDate(actionForm.getContractExtensionDate().getDate());
			registrationDto.setProposalDTO(customDto.getContractDTO());
			registrationDto.setExtensionDate(customDto.getExtensionDate());
			
			
			// DADO011
			//tostore current proposalkey in session
			
			ProposalCustomDTO currentProposal = new ProposalCustomDTO();
			currentProposal.setId(customDto.getContractDTO().getId());
			currentProposal.setName(customDto.getProposalName());
			currentProposal.setType(customDto.getProposalType());
			currentProposal.setStatus(customDto.getContractDTO().getStatus());
			currentProposal.setOldContractNumber(customDto.getContractDTO().getOldContractNumber());
			currentProposal.setLockedBy(customDto.getContractDTO().getLockedBy());
			currentProposal.setAccess(customDto.getContractDTO().getAccess());
			currentProposal.setFullAccess(customDto.getContractDTO().isFullAccess());
			session.storeObjectToSession(SessionConstants.CURRENT_PROPOSAL, currentProposal);
			
			
		}
	
		try {
			registrationDto = getProposalManager().getRegistrationData(registrationDto);
			ErrorReport errorReport = registrationDto.getMessageReport();

			if(null == errorReport){
				
				OPPTLogger.debug("ERROR REPORT NULL","ExtendIntremediateContractAction","executeAction");
				ContractExtensionViewBean extensionBean = new ContractExtensionViewBean(customDto);
				//extensionBean.setApprover(registrationDto.getApproverIds());
				//extensionBean.setSelectedApprover(registrationDto.getSelectedApproverId());
				extensionBean.setBillingFrequency(registrationDto.getBillingFrequency());
				viewBean = extensionBean;
				setToSession(registrationDto, session);
				setForwardName(getRole(session));
			}
			else{
				OPPTLogger.debug("ERROR REPORT NOT NULL","ExtendIntremediateContractAction","executeAction");
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(errorReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);
			}
			
		}
		catch(ServiceException ex){
			viewBean = handleServiceException(session, ex.getErrorReport());
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
		return ActionNameConstants.EXTEND_INTERMEDIATE_CONTRACT;
	}
	
	
	
	private ExtendContractCustomDTO getFromSession(OPPTSession session){
		ExtendContractCustomDTO customDto;
		
		customDto = (ExtendContractCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_CONTRACT_EXTEND);
		
		return customDto;
	}
	
	
	private void setToSession(RegistrationCustomDTO registrationDto, OPPTSession session){
		session.storeObjectToSession(SessionConstants.SESSION_REGISTER_EXTEND,registrationDto);
	}


	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								//Commented and added for the change DAD O11 Remove approval step,Blue Harmony -Ramesh
								//setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_EXTEND_CONTRACT_DETAIL); commented by Ramesh Gandi
				OPPTLogger.debug("before forwording to PROPOSAL_CREATE_APPROVER","ExtendIntremediateContractAction","executeAction");
								setForwardName(ForwardNameConstants.ACTION_SUBMIT_EXTENDED_CONTRACT);
								OPPTLogger.debug("after forwording to PROPOSAL_CREATE_APPROVER","ExtendIntremediateContractAction","executeAction");
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
							OPPTLogger.debug("after forwording to PROPOSAL_CREPAGE_EXTEND_CONTRACT_DETAIL","ExtendIntremediateContractAction","executeAction");
							//	setForwardName(ForwardNameConstants.PAGE_EXTEND_CONTRACT_DETAIL);
							setForwardName(ForwardNameConstants.ACTION_SUBMIT_EXTENDED_CONTRACT);
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