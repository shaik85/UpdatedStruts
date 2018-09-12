/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.ArrayList;
import java.util.Calendar;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ContractMaintenanceActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.AmendContractViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ContractMaintenanceViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ComplexContractIdentifiers;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AmendContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserContractsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class AmendContractAction extends OPPTLongAction 
{
	public static int rol;
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
	throws Exception{
		OPPTViewBean viewBean;
		AmendContractCustomDTO contractDto;
		String []contractId;
		ContractMaintenanceActionForm actionForm = (ContractMaintenanceActionForm)form;
		contractId = actionForm.getSelectedContractIds();
		// BH Wave1 - DAD 003 - Begin - Manoj
		ComplexContractIdentifiers complexContractIdentifiers = ComplexContractIdentifiers.getComplexContractIdentifiers();
		complexContractIdentifiers.ResetComplexContractIdentifiers();		
		// BH Wave1 - DAD 003 - End - Manoj
		if(null != contractId && contractId.length == 1){
			contractDto = new AmendContractCustomDTO();
			setTransactionInformation(contractDto, session);
			contractDto = populateContractDto(contractDto, contractId[0],session);
			contractDto.setDisplayOption(AmendContractCustomDTO.AMEND_PROPOSAL);
			
			try {
				contractDto = getProposalManager().amendContract(contractDto);
				ErrorReport errorReport = contractDto.getMessageReport();

				if(null == errorReport){
				
					viewBean = new AmendContractViewBean(contractDto);
					setToSession(contractDto,session);
					populateYearList(viewBean);
					setForwardName(getRole(session));
				}
				else{
					
					viewBean = handleMessageReport(errorReport);
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
		return ActionNameConstants.AMEND_CONTRACT;
	}
	
	
	/**
	 *  
	 * Populate AmendContractCustomDTO with the values stored in UserContractsCustomDTO
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param contractId
	 * @return
	 */
	private AmendContractCustomDTO populateContractDto(AmendContractCustomDTO amendContractDto, String contractId, OPPTSession session){
		UserContractsCustomDTO customDTO = null;
		ContractCustomDTO contractCustomDto=null;
		if(null != session){
			customDTO = (UserContractsCustomDTO)session.getObjectFromSession(SessionConstants.USER_CONTRACT);
			contractCustomDto =  (ContractCustomDTO)customDTO.getContractCustomDTO().get(contractId);
			session.storeObjectToSession(SessionConstants.CURRENT_PROPOSAL, contractCustomDto);
		}
	
		amendContractDto.setContract(contractCustomDto);
		return amendContractDto;
	}
	
	/**
	 *  
	 * Populate year list
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param viewBean
	 */
	private void populateYearList(OPPTViewBean viewBean){
		ArrayList yearList = new ArrayList();
		Calendar cal = Calendar.getInstance();
		AmendContractViewBean yearBean = (AmendContractViewBean)viewBean;
		
		if(rol==RoleConstants.DATA_MIGRATOR){
			int initialYear = cal.get(Calendar.YEAR) -5;
			int finalYear = initialYear + 15;
			
			for (int i = initialYear; i <= finalYear; i++){
				yearList.add(new Integer(i));
			}
		
		}
		else
		{
			
			int initialYear = cal.get(Calendar.YEAR) -1;
			int finalYear = initialYear + 11;
			
			for (int i = initialYear; i <= finalYear; i++){
				yearList.add(new Integer(i));
			}
			
		}

		yearBean.setYearList(yearList);
	}
	
	private void setToSession(AmendContractCustomDTO contractDto,OPPTSession session){
		session.storeObjectToSession(SessionConstants.SESSION_AMEND_CONTRACT,contractDto);
	}

	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_AMEND_CONTRACT);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_AMEND_CONTRACT);
								break;
		}
	}

	/**
     * validateCurrentViewContent
     * 
     * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#validateCurrentViewContent(com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession)
     * @author thirumalai
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
