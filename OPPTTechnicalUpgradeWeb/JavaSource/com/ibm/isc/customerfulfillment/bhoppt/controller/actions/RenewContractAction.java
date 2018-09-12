/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ContractMaintenanceActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 *  
 * This class has method that retrieves the detail of a contract,
 * store it in view bean and keeps the bean in session. 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 15, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */
public class RenewContractAction extends OPPTLongAction 
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
			
		OPPTViewBean viewBean;
		RenewContractCustomDTO contractDto;
		String []contractId;
		ContractMaintenanceActionForm actionForm = (ContractMaintenanceActionForm)form;
		UserContractsCustomDTO customDto = getUserContract(session);
		contractId = actionForm.getSelectedContractIds();

		if(null != contractId && contractId.length == 1){
			contractDto = new RenewContractCustomDTO();
			setTransactionInformation(contractDto, session);
			contractDto = populateContractDto(contractDto, customDto, contractId[0], session);

			try {
				contractDto = getProposalManager().renewContract(contractDto);
				ErrorReport errorReport = contractDto.getMessageReport();

				if(null == errorReport){
					viewBean = new RenewContractViewBean(contractDto);
					setInSession(contractDto, session);
					setForwardName(getRole(session));
				}
				else{
					viewBean = new MessageViewBean();
					viewBean.setErrorReport(errorReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);
				}
				
			}
			catch(ServiceException ex){
				viewBean = handleServiceException(session, ex.getErrorReport());
			}
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA17));
			setForwardName(session.getCurrentForward());
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
		return ActionNameConstants.RENEW_CONTRACT;
	}
	
	/**
	 *  
	 * Retrieves UserContractsCustomDTO from session
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 14, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session
	 * @return
	 */
	
	private UserContractsCustomDTO getUserContract(OPPTSession session){
		UserContractsCustomDTO customDTO = null;

		if(null != session){
			customDTO = (UserContractsCustomDTO)session.getObjectFromSession(SessionConstants.USER_CONTRACT);
		}

		return customDTO;
	}
	
	/**
	 * Extracts ContractCustomDTO object for the gicen contractId and
	 * packs in RenewContractCustomDTO.
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 14, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDto
	 * @param contractId
	 * @return
	 */
	private RenewContractCustomDTO populateContractDto(RenewContractCustomDTO renewContractDto, 
		UserContractsCustomDTO customDto, String contractId, OPPTSession session){
			
		ContractCustomDTO contractCustomDto;
	
		contractCustomDto =  (ContractCustomDTO)customDto.getContractCustomDTO().get(contractId);
	
		renewContractDto.setContractDTO(contractCustomDto);
		return renewContractDto;
	}
	
	private void setInSession(RenewContractCustomDTO contractDto, OPPTSession session){
		session.storeObjectToSession(SessionConstants.SESSION_CONTRACT_RENEW, contractDto);
	}

	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_RENEW_CONTRACT);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_RENEW_CONTRACT);
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
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = getCurrentForwardName(getRole(session));

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof ContractMaintenanceViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.CONTRACT_MAINTENANCE);
			if(null != dataStoreEntry && dataStoreEntry instanceof UserContractsCustomDTO){
				session.setCurrentViewBean(new ContractMaintenanceViewBean((UserContractsCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_MAINTENANCE;
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_CONTRACT_MAINTENANCE;
								break;
		}
		
		return currentForwardName;
	}
}
