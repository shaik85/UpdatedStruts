/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.ArrayList;
import java.util.Calendar;

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
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ReplaceContractAction extends OPPTLongAction 
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
		throws Exception {
			
		OPPTViewBean viewBean;
		ReplaceContractCustomDTO contractDto;
		String []contractId;
		ContractMaintenanceActionForm actionForm = (ContractMaintenanceActionForm)form;
		UserContractsCustomDTO customDto = getUserContract(session);
		contractId = actionForm.getSelectedContractIds();
		
		if(null != contractId && contractId.length == 1){
			contractDto = new ReplaceContractCustomDTO();
			setTransactionInformation(contractDto, session);
			contractDto = populateContractDto(contractDto,customDto, contractId[0]);
			try {
				if((contractDto.getContractDTO().getExtendPeriod() != null) && (contractDto.getContractDTO().getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
					viewBean = session.getCurrentViewBean();
					viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA54));
					setForwardName(session.getCurrentForward());
				} else {
					contractDto = getProposalManager().getHeaderForReplacement(contractDto);
					ErrorReport errorReport = contractDto.getMessageReport();
					
					if(null == errorReport){
						viewBean = new ContractReplacementViewBean(contractDto);
						setToSession(contractDto,session);
					
						populateYearList(viewBean);
						setForwardName(getRole(session));
					}
					else{
						viewBean = new MessageViewBean();
						viewBean.setErrorReport(errorReport);
						setForwardName(ForwardNameConstants.PAGE_MESSAGE);
					}
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
		return ActionNameConstants.REPLACE_CONTRACT;
	}
	
	/**
	 *  
	 * Populate ReplaceContractCustomDTO with the values stored in UserContractsCustomDTO
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
	 * @param customDto
	 * @param contractId
	 * @return
	 */
	private ReplaceContractCustomDTO populateContractDto(ReplaceContractCustomDTO replaceContractDto, 
		UserContractsCustomDTO customDto, String contractId){
			
		ContractCustomDTO contractCustomDto;
		
		contractCustomDto =  (ContractCustomDTO)customDto.getContractCustomDTO().get(contractId);
		replaceContractDto.setContractDTO(contractCustomDto);
		return replaceContractDto;
	}
	
	/**
	 *  
	 * Retrieve UserContractsCustomDTO from session
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
	 *  
	 * Strore ReplaceContractCustomDTO in session
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
	 * @param contractDto
	 * @param session
	 */
	private void setToSession(ReplaceContractCustomDTO contractDto, OPPTSession session){
		session.storeObjectToSession(SessionConstants.SESSION_REPLACE_CONTRACT, contractDto);
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
		ContractReplacementViewBean yearBean = (ContractReplacementViewBean)viewBean;
		
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

	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_REPLACE_CONTRACT);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_REPLACE_CONTRACT);
								break;
		}
	}

	/** 
	 * Overridden method - Check if the current view bean stored in session is what is expected. 
	 * If it is not valid, try to create the current view using the custom dto stored in session 
	 * and set it as current view. If current view cannot be created, return false. 
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
