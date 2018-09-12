/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalHeaderActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ComplexContractIdentifiers;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BasicProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalFormDataCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * Action that handles the logic of validating the proposal header information, once validated helps 
 * in storing the header information into session.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 9, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class SubmitCreateProposalAction extends OPPTLongAction {
	/** 
	 * Overridden method - for performing the validations on proposal header data 
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
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception
	{
		OPPTViewBean viewBean = null;

		ProposalHeaderActionForm actionForm = (ProposalHeaderActionForm)form;
		boolean businessPartner = false;
		int role = session.getUserInfo().getRole();
		if(role == RoleConstants.BUSINESS_PARTNER){
			businessPartner = true;
		}
	
		ProposalHeaderCustomDTO customDTO = new ProposalHeaderCustomDTO();
		actionForm.getRequestParams(customDTO);
		setTransactionInformation(customDTO, session);
		setTransactionInformation(customDTO.getBasicProposalCustomDTO(), session);
		//this.saveProposalHeaderCustomDTO(session,)
	
		try {
			// BH Wave1 - DAD003 - Complex Contract Identifiers - Begin - Manoj
			BasicProposalCustomDTO bpCustomDTO = getProposalManager().validateComplexContractIdentifiers(customDTO.getBasicProposalCustomDTO());
			customDTO.setBasicProposalCustomDTO(bpCustomDTO);
			ErrorReport messageReport = bpCustomDTO.getMessageReport();
			ComplexContractIdentifiers complexContractIdentifiers = ComplexContractIdentifiers.getComplexContractIdentifiers();
			if(null != messageReport){
				addDataStoreEntry(session, customDTO);
				saveProposalHeaderCustomDTO(session, customDTO);
				ProposalFormDataCustomDTO proposalFormDataCustomDTO = getProposalManager().getProposalFormData();
				try {
					getProposalManager().throwExceptionForService(complexContractIdentifiers.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
				} catch(ServiceException se){
					viewBean = handleServiceExceptionForMessage(session, se.getErrorReport(), session.getCurrentForward(), session.getCurrentForward());
					return viewBean;
				}				
			}
			
			if (complexContractIdentifiers.IsAllValueNull(customDTO.getBasicProposalCustomDTO()) || ConnectorConstants.RFC_SUCCESS_CODE.equals(complexContractIdentifiers.getReturnCode())){
				// Either if all the Complex contract Identifiers fields are empty or the return code is success then allow Register using CCI_IND
				customDTO.getBasicProposalCustomDTO().setCciInd("Y");
			} else {
				// Else Donot allow Register
				customDTO.getBasicProposalCustomDTO().setCciInd("N");
			}
			// BH Wave1 - DAD003 - Complex Contract Identifiers - End - Manoj
			
			customDTO = getProposalManager().validateProposalHeader(customDTO);			
			messageReport = customDTO.getMessageReport();
			if(null == messageReport)
			{
				addDataStoreEntry(session, customDTO);
				saveProposalHeaderCustomDTO(session, customDTO);
				viewBean = new PartnerDetailsViewBean(businessPartner, false, null, customDTO.getSecondaryProposalCustomDTO().getComments());
				setForwardName(getRole(session));
			}
			else{
				addDataStoreEntry(session, customDTO);
				saveProposalHeaderCustomDTO(session, customDTO);
				viewBean = new ConfirmationViewBean(ConfirmationConstants.CREATE_PROPOSAL);
				viewBean.setErrorReport(messageReport);
				setForwardName(ForwardNameConstants.PAGE_CONFIRMATION);
			}
		}
		catch(ServiceException se){
			viewBean = handleServiceException(session, se.getErrorReport(), session.getCurrentForward(), session.getCurrentForward());
		}
		
		return viewBean;
	}

	/** 
	 * Overridden method - Returns the current actions name. 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return String 
	 * 
	 */
	protected String getActionName() {
		return ActionNameConstants.SUBMIT_CREATE_PROPOSAL;
	}
	
	/**
	 * Saves the proposal header information into session  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session
	 * @param customDTO
	 */
	private void saveProposalHeaderCustomDTO(OPPTSession session, ProposalHeaderCustomDTO customDTO){
		if(null != session && null != customDTO){
			session.storeObjectToSession(SessionConstants.PROPOSAL_HEADER, customDTO);
		}
	}
	
	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PARTNER_DETAILS);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_PARTNER_DETAILS);
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
			if(viewBean instanceof CreateProposalViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.CREATE_PROPOSAL);
			if(null == dataStoreEntry){
				dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.SUBMIT_REPLACE_CONTRACT);
			}
//			Object dataStoreEntry = session.getDataStoreEntryBefore(getActionName());
			if(null != dataStoreEntry && dataStoreEntry instanceof ProposalFormDataCustomDTO){
				session.setCurrentViewBean(new CreateProposalViewBean((ProposalFormDataCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_CREATE_PROPOSAL;
								break;
			
			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_CREATE_PROPOSAL;
								break;
		}
		
		return currentForwardName;
	}
	
}