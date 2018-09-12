/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import java.util.Date;
/**
 *  
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
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
public class CloseContractAction extends OPPTLongAction 
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
		
		OPPTViewBean viewBean=null;
		CloseContractCustomDTO contractDto;
		String []contractId;
		ContractMaintenanceActionForm actionForm = (ContractMaintenanceActionForm)form;
		UserContractsCustomDTO customDto = getUserContract(session);
		contractId = actionForm.getSelectedContractIds();
		if(null != contractId && contractId.length == 1){
			contractDto = new CloseContractCustomDTO();
			setTransactionInformation(contractDto, session);
			populateContractDto(contractDto, customDto, contractId[0], session);

			try {
				contractDto = getProposalManager().closeContract(contractDto);
				ErrorReport errorReport = contractDto.getMessageReport();
				
				if(null == errorReport){
					if(contractDto.isCloseVarianceContract()){
						RegistrationCustomDTO customDTO = new RegistrationCustomDTO();
						setTransactionInformation(customDTO, session);
						customDTO.setProposalDTO(contractDto.getContractDTO());
						customDTO.setVarianceContractClosure(true);

						try {
							customDTO = getProposalManager().getRegistrationData(customDTO);
							ErrorReport messageReport = customDTO.getMessageReport();
							if(null == messageReport){
								addDataStoreEntry(session, customDTO);
								setRegistrationData(session, customDTO);
								viewBean = new ContractClosureViewBean(contractDto);
								populateVarianceClosureDate(viewBean ,contractDto);
								storeInSession(contractDto, session);
								setForwardName(ForwardNameConstants.PAGE_CLOSE_CONTRACT);
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
					}
					else{
						// start change CR6153 						
						Date cntrPeriodStrtDate = contractDto.getContractPeriodStartDate();
						Date cntrPeriodEndDate = contractDto.getContractPeriodEndDate();
						OPPTCalender startDateCalender = new OPPTCalender();
						OPPTCalender endDateCalender = new OPPTCalender();
						
						if (contractDto.isISandsExtendPeriod()!= null && contractDto.isISandsExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD)) 			
		 				{
							Date date = new Date();
							while(cntrPeriodEndDate.getTime()< date.getTime() && cntrPeriodEndDate.getTime() < contractDto.getContractEndDate().getTime())
							{
								startDateCalender.setTime(OPPTCalender.addDate(OPPTCalender.YEAR, 1, cntrPeriodStrtDate));
								endDateCalender.setTime(OPPTCalender.addDate(OPPTCalender.YEAR, 1, cntrPeriodEndDate));
								if(endDateCalender.getYear()%4 == 0 &&(endDateCalender.getYear()%100 != 0 || endDateCalender.getYear()%400 == 0))  
								{
									if(startDateCalender.getMonth() == 3 && startDateCalender.getDay()== 1 && (contractDto.getContractEndDate().getTime() > cntrPeriodEndDate.getTime()))
									{
										endDateCalender.set(endDateCalender.getYear(),endDateCalender.getMonth()-1,endDateCalender.getDay()+1 );
										// since month is 0 based in the set method, and starts from 1 in the get method, we subtract 1
									}
								}
								cntrPeriodStrtDate.setTime(startDateCalender.getTimeInMillis());									
								cntrPeriodEndDate.setTime(endDateCalender.getTimeInMillis());
							}
							contractDto.setContractPeriodStartDate(cntrPeriodStrtDate);
							contractDto.setContractPeriodEndDate(cntrPeriodEndDate);										
						}
						//  end change CR6153 
						viewBean = new ContractClosureViewBean(contractDto);
						populateYearList(viewBean);
						storeInSession(contractDto, session);
						setForwardName(ForwardNameConstants.PAGE_CLOSE_CONTRACT);
					}
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
		return ActionNameConstants.CLOSE_CONTRACT;
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
	
	private void setRegistrationData(OPPTSession session, RegistrationCustomDTO customDTO) {
		if(null != session && null != customDTO){
			session.storeObjectToSession(SessionConstants.REGISTER_PROPOSAL, customDTO);
		}
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
	 */
	private void populateContractDto(CloseContractCustomDTO closeContractDto, 
		UserContractsCustomDTO customDto, String contractId, OPPTSession session){
			
		ContractCustomDTO contractCustomDto;

		contractCustomDto =  (ContractCustomDTO)customDto.getContractCustomDTO().get(contractId);
		session.storeObjectToSession(SessionConstants.CURRENT_PROPOSAL, contractCustomDto);
		closeContractDto.setContractDTO(contractCustomDto);
	}
	
	/**
	 *  
	 * Creates list of year from present year - 1 year to present year + 10 years.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
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
		ContractClosureViewBean yearBean = (ContractClosureViewBean)viewBean;
		
		
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
	
	
	private void populateVarianceClosureDate(OPPTViewBean viewBean  ,CloseContractCustomDTO contractDto ){
		
		ContractClosureViewBean yearBean = (ContractClosureViewBean)viewBean;
		
		yearBean.setClosureDateEditable(false);
		Date cntrPeriodStrtDate = contractDto.getContractPeriodStartDate();
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		cal.setTime(cntrPeriodStrtDate);
        cal.add(Calendar.DATE, -1);
		try {  
		String str_date=dateFormat.format(cal.getTime());
		Date date ; 
		date = (Date)dateFormat.parse(str_date);  
		yearBean.setContractClosureDate(date);
		contractDto.setContractClosureDate(date);
		 } catch (ParseException e)
		{ }  
		   			}
	
	
	private void storeInSession(CloseContractCustomDTO contractDto, OPPTSession session){
		session.storeObjectToSession(SessionConstants.SESSION_CLOSE_CONTRACT,contractDto);
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

	private void setCloseVarianceContractForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_REGISTRATION);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_CONTRACT_REGISTRATION);
								break;
		}
	}
}
