/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.invmgr;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.CreateException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo.CustomerBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.factory.CustomerBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CopyInventoryDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.EEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.TempEEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ProposalContractBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr.DMManagerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/**
 *  
 * Inventory manager class acts as a interface between Proposal Manager and DM Manager,SWO Manager 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 2, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar J
 * @version 5.1A
 */
public class InventoryManagerBean implements javax.ejb.SessionBean {
	private final String SWO_MANAGER_LOCAL_HOME = "SWOManagerLocalHome";
	private final String DM_MANAGER_LOCAL_HOME = "DMManagerLocalHome";
	private final String CLASS_NAME = "InventoryManagerBean";
	private javax.ejb.SessionContext mySessionCtx;

	/**
	 * To copy the inventory for the given proposal  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param copyInventoryDomainDTO
	 * @throws ServiceException
	 * Customer information to be copied during Renewal. Changed by Sara for EF0722042442 on 26 July 2004 - CMVCDefect 20 
	 */
	public void copyInventory(CopyInventoryDomainDTO copyInventoryDomainDTO) throws ServiceException {
		CustomerBOFactory customerBOFactory = new CustomerBOFactory();
		DMManagerLocal dmLocal = getDMManagerLocal();
		CustomerBO customerBO;
		List list = null;
		Map values = null;
		String methodName = "copyInventory";
		/* CR6153 start change */
		ProposalContractBO proposal = null;
		ProposalContractBOFactory proposalBOFactory = new ProposalContractBOFactory();
		/* CR6153 end change */
		try {
			if (copyInventoryDomainDTO.getActionName() != null && copyInventoryDomainDTO.getActionName().equalsIgnoreCase(ActionNameConstants.COPY_INVENTORY_CUSTOMER) || copyInventoryDomainDTO.getActionName().equalsIgnoreCase(ActionNameConstants.COPY_INVENTORY_DM)) {
				dmLocal.copyInventory(copyInventoryDomainDTO);

			}
			//			else if (copyInventoryDomainDTO.getActionName() != null && copyInventoryDomainDTO.getActionName().equalsIgnoreCase(ActionNameConstants.CREATE_VARIANCEPROPOSAL)) {
			//				customerBO = customerBOFactory.getCustomerBO(copyInventoryDomainDTO.getNewProposalID(), copyInventoryDomainDTO.getNewCustomerID(), CustomerBOFactory.CUSTOMER_TABLE);
			//				values = copyInventoryDomainDTO.getValues();
			//
			//				if (values != null && values.get(UtilityConstants.PLAN_START_DATE) != null) {
			//					customerBO.setPlanStartDate((java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE));
			//					customerBO.setPlanEndDate((java.sql.Date) values.get(UtilityConstants.PLAN_END_DATE));
			//				}
			//
			//				customerBO.setCustomerId(customerBOFactory.findMaxCustomerBO().getCustomerId() + 1);
			//				copyInventoryDomainDTO.setNewCustomerID(customerBO.getCustomerId());
			//				customerBOFactory.createCustomerBO(customerBO, CustomerBOFactory.CUSTOMER_TABLE);
			//
			//			}
			else if (copyInventoryDomainDTO != null && copyInventoryDomainDTO.getActionName().equalsIgnoreCase(ActionNameConstants.COPY_INVENTORY_SWO)) {
				dmLocal.copyInventory(copyInventoryDomainDTO);

			} else {
					/* CR6153 Start Change */
					try {
						proposal = proposalBOFactory.getProposalContractBO(copyInventoryDomainDTO.getOldProposalID());
					} catch (DomainException e) {
						throw ExceptionGenerator.generateServiceException(e.getErrorReport());
					}
						
					int contractDurationMonths =  OPPTCalender.calculateContractPeriodDuration(proposal.getContrStartDate(),proposal.getContrEndDate());
					int contractDurationYears = contractDurationMonths/12;
					
					//If it is S&S extended contract
					if((proposal.getExtendPeriod() != null) && (proposal.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
						Iterator iter1 = null;
						ArrayList extendList = new ArrayList();
						list = customerBOFactory.findCustomerBOforProposal(copyInventoryDomainDTO.getOldProposalID(), CustomerBOFactory.CUSTOMER_TABLE);
						Iterator iter = null;
						if(list != null){
							iter = list.iterator();
							values = copyInventoryDomainDTO.getValues();
							java.sql.Date replaceDate = null;
							if (values != null && values.get(UtilityConstants.PLAN_START_DATE) != null) {
								replaceDate = (java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE);
							}
							//Discard the CustomerBo before Replacement date, and for the year of the Replacement date...let the plan start date be the replacement date,
							//let the plan end date be as it is, for the next years copy as it is.
							while(iter.hasNext()){
								customerBO = (CustomerBO) iter.next();
								if ((ActionNameConstants.REPLACE_CONTRACT.equalsIgnoreCase(copyInventoryDomainDTO.getActionName())) 
									||(ActionNameConstants.RENEW_CONTRACT.equalsIgnoreCase(copyInventoryDomainDTO.getActionName()))) {
									if((replaceDate.after(customerBO.getPlanStartDate()) && (replaceDate.after(customerBO.getPlanEndDate())))){
										continue;
									}
									extendList.add(customerBO);
								}
							}
							if ((ActionNameConstants.REPLACE_CONTRACT.equalsIgnoreCase(copyInventoryDomainDTO.getActionName())) 
								||(ActionNameConstants.RENEW_CONTRACT.equalsIgnoreCase(copyInventoryDomainDTO.getActionName()))) {
								iter1 = extendList.iterator();
							}
							else{
								iter1 = list.iterator();
							}
							while(iter1.hasNext()){
								customerBO = (CustomerBO) iter1.next();
								if (ActionNameConstants.REPLACE_CONTRACT.equalsIgnoreCase(copyInventoryDomainDTO.getActionName())){
									if((replaceDate.after(customerBO.getPlanStartDate()) && (replaceDate.before(customerBO.getPlanEndDate())))){
										customerBO.setPlanStartDate((java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE));
									}
								}
															
								copyInventoryDomainDTO.setOldCustomerID(customerBO.getCustomerId());
								customerBO.setCustomerId(customerBOFactory.findMaxCustomerBO().getCustomerId() + 1);
		
								populateCustomerBO(customerBO, copyInventoryDomainDTO);
								customerBOFactory.createCustomerBO(customerBO, CustomerBOFactory.CUSTOMER_TABLE);
								copyInventoryDomainDTO.setNewCustomerID(customerBO.getCustomerId());
								dmLocal.copyInventory(copyInventoryDomainDTO);
							}
						}
						 					
					}
					 //Not extended
					else{
						/* CR6153 end change */
						list = customerBOFactory.findCustomerBOforProposal(copyInventoryDomainDTO.getOldProposalID(), CustomerBOFactory.CUSTOMER_TABLE);
						Iterator iter = list.iterator();
						values = copyInventoryDomainDTO.getValues();
						while (iter.hasNext()) {
							customerBO = (CustomerBO) iter.next();
							//EF0722042442S 
							if (ActionNameConstants.REPLACE_CONTRACT.equalsIgnoreCase(copyInventoryDomainDTO.getActionName()) || ActionNameConstants.CREATE_VARIANCEPROPOSAL.equalsIgnoreCase(copyInventoryDomainDTO.getActionName()) || ActionNameConstants.RENEW_CONTRACT.equalsIgnoreCase(copyInventoryDomainDTO.getActionName())) {
								 //EF0722042442E 
								if (values != null && values.get(UtilityConstants.PLAN_START_DATE) != null) {
									customerBO.setPlanStartDate((java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE));
									customerBO.setPlanEndDate((java.sql.Date) values.get(UtilityConstants.PLAN_END_DATE));
								}
		
							}
		
							// set the old customer id
							copyInventoryDomainDTO.setOldCustomerID(customerBO.getCustomerId());
							customerBO.setCustomerId(customerBOFactory.findMaxCustomerBO().getCustomerId() + 1);
		
							populateCustomerBO(customerBO, copyInventoryDomainDTO);
							customerBOFactory.createCustomerBO(customerBO, CustomerBOFactory.CUSTOMER_TABLE);
							// set the new customer id
							copyInventoryDomainDTO.setNewCustomerID(customerBO.getCustomerId());
		
							// dm level copy for this customer
							 //EF0722042442S 
							if (!(ActionNameConstants.RENEW_CONTRACT.equalsIgnoreCase(copyInventoryDomainDTO.getActionName()))) {
								 //EF0722042442E 
								dmLocal.copyInventory(copyInventoryDomainDTO);
							}
						}
					}
			}
			
		} catch (DomainException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}
	}

	/** 
	 * To populate the customer BO using the copy inventory domaindto
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerBO
	 * @param copyInventoryDomainDTO 
	 */
	private void populateCustomerBO(CustomerBO customerBO, CopyInventoryDomainDTO copyInventoryDomainDTO) {
		switch (copyInventoryDomainDTO.getChoice()) {
			default :
				customerBO.setProposalId(copyInventoryDomainDTO.getNewProposalID());
				customerBO.setLastUpdatedDate(new Date(System.currentTimeMillis()));
		}
	}

	/**
	 * This method removes the selected customer and the inventory from inventory details
	 *  This method calls uses appropriate BO and BOFactory classes
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerDTO
	 */
	public void removeCustomerDetail(CustomerDomainDTO customerDTO) throws ServiceException {
		CustomerBOFactory customerBOFactory = null;
		CustomerBO customerBO = null;
		customerBOFactory = new CustomerBOFactory();
		String methodName = "removeCustomerDetail";

		customerBO = populateCustomerBO(customerDTO);
		try {
			customerBOFactory.deleteCustomerBO(customerBO, CustomerBOFactory.CUSTOMER_TABLE);
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}

	/**
	 *  
	 *  This method adds customer details to the proposal as part of Inventory 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerDTO
	 */
	public void addCustomersToProposal(CustomerDomainDTO customerDTO) throws ServiceException {
		CustomerBOFactory customerBOFactory = new CustomerBOFactory();
		CustomerBO customerBO = new CustomerBO();
		String methodName = "addCustomersToProposal";
		
	    
		customerBO.setProposalId(customerDTO.getProposalId());
	//	customerBO.setCustomerListNo(customerDTO.getCustomerListNo());
		//customerBO.setCustmerASNo(customerDTO.getCustmerASNo());
		//customerBO.setLegacyCustomerNo(customerDTO.getLegacyCustomerNo());
		customerBO.setSapCustomerName(customerDTO.getSapCustomerName());
		customerBO.setSapCustomerNo(customerDTO.getSapCustomerNo());
		customerBO.setLastUpdatedDate(customerDTO.getLastUpdatedDate());
		customerBO.setPlanStartDate(customerDTO.getPlanStartDate());
		customerBO.setPlanEndDate(customerDTO.getPlanEndDate());
		//DADO02&DADO09 SATEESH BlueHarmony 
		customerBO.setBillToPartyNo(customerDTO.getBillToPartyNo());
		
		customerBO.setBillToPartyName(customerDTO.getBillToPartyName());
		customerBO.setBillToPartyASNo(customerDTO.getBillToPartyASNo());
		customerBO.setBillToPartyLNo(customerDTO.getBillToPartyLNo());
		customerBO.setPayerNo(customerDTO.getPayerNo());
		
		customerBO.setPayerName(customerDTO.getPayerName());
		customerBO.setPayerASNo(customerDTO.getPayerASNo());
		customerBO.setPayerLNo(customerDTO.getPayerLNo());
		customerBO.setShipToPartyNo(customerDTO.getShipToPartyNo());
		customerBO.setShipToPartyName(customerDTO.getShipToPartyName());
		customerBO.setShipToPartyASNo(customerDTO.getShipToPartyASNo());
		customerBO.setShipToPartyLNo(customerDTO.getShipToPartyLNo());
		//END OF DADO02&DADO09
		//customerBO.setCountryCode(customerDTO.getCountryCode()); /* Changed for EF0607044559	by Sara on June 16,2004 */
		
		//		Changed by Balaji for MN22673010 - Starts
		/*
		 * There can be one customer assosiated with one or more customer lists in this case the customer should 
		 * be added only once in STP table
		 */
		if (!customerBOFactory.isCustomerAvailableForProposal(customerBO.getProposalId(), customerBO.getSapCustomerNo())) {
			CustomerBO maxCustomerBO = null;
			try {
				
				maxCustomerBO = customerBOFactory.findMaxCustomerBO();
			
			} catch (DomainException e1) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e1);
				throw ExceptionGenerator.generateServiceException(e1.getErrorReport());
			}

			customerBO.setCustomerId(maxCustomerBO.getCustomerId() + 1);
			
			try {
				
				customerBOFactory.createCustomerBO(customerBO, CustomerBOFactory.CUSTOMER_TABLE);
			} catch (DomainException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}

		} else {
			// Update 
			try {
				CustomerBO initialCustomerBO = customerBOFactory.findSTPForProposal(customerBO.getProposalId(), customerBO.getSapCustomerNo());
				initialCustomerBO.setCustomerListNo(customerDTO.getCustomerListNo());
				initialCustomerBO.setCustmerASNo(customerDTO.getCustmerASNo());
				initialCustomerBO.setLegacyCustomerNo(customerDTO.getLegacyCustomerNo());
				initialCustomerBO.setSapCustomerName(customerDTO.getSapCustomerName());
				initialCustomerBO.setSapCustomerNo(customerDTO.getSapCustomerNo());
				initialCustomerBO.setLastUpdatedDate(customerDTO.getLastUpdatedDate());
				initialCustomerBO.setPlanStartDate(customerDTO.getPlanStartDate());
				initialCustomerBO.setPlanEndDate(customerDTO.getPlanEndDate());
				initialCustomerBO.setCountryCode(customerDTO.getCountryCode());

				customerBOFactory.updateCustomerBO(initialCustomerBO, CustomerBOFactory.CUSTOMER_TABLE);
			} catch (DomainException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}
		}
		// Changed by Balaji for MN22673010 - Ends
	}
	/**
	 *  
	 *  This method adds customer details to the proposal as part of Inventory for an S&S Contract type and if 
	 * the contract is to be extended
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date June 25, 2007, Nayanatara L Pai
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerDTO
	 */
	/* CR6153 Start Changes  */
	public void addCustomersToProposalSAndSExtended(CustomerDomainDTO customerDTO) throws ServiceException {
		
		CustomerBOFactory customerBOFactory = new CustomerBOFactory();
		CustomerBO customerBO = new CustomerBO();
		String methodName = "addCustomersToProposalSAndSExtended";

		customerBO.setProposalId(customerDTO.getProposalId());
		customerBO.setCustomerListNo(customerDTO.getCustomerListNo());
		customerBO.setCustmerASNo(customerDTO.getCustmerASNo());
		customerBO.setLegacyCustomerNo(customerDTO.getLegacyCustomerNo());
		customerBO.setSapCustomerName(customerDTO.getSapCustomerName());
		customerBO.setSapCustomerNo(customerDTO.getSapCustomerNo());
		customerBO.setLastUpdatedDate(customerDTO.getLastUpdatedDate());
		customerBO.setPlanStartDate(customerDTO.getPlanStartDate());
		customerBO.setPlanEndDate(customerDTO.getPlanEndDate());
		customerBO.setCountryCode(customerDTO.getCountryCode()); 
		
		
		if (!customerBOFactory.isCustomerAvailableForProposalPlanStartEndDate(customerBO.getProposalId(), customerBO.getSapCustomerNo(),customerBO.getPlanStartDate(),customerBO.getPlanEndDate())) {
			CustomerBO maxCustomerBO = null;
			try {
				maxCustomerBO = customerBOFactory.findMaxCustomerBO();
			} catch (DomainException e1) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e1);
				throw ExceptionGenerator.generateServiceException(e1.getErrorReport());
			}

			customerBO.setCustomerId(maxCustomerBO.getCustomerId() + 1);

			try {
				customerBOFactory.createCustomerBO(customerBO, CustomerBOFactory.CUSTOMER_TABLE);
			} catch (DomainException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}

		} else {
			// Update 
			try {
				CustomerBO initialCustomerBO = customerBOFactory.findSTPForProposalPlanStartEndDate(customerBO.getProposalId(), customerBO.getSapCustomerNo(),customerBO.getPlanStartDate(),customerBO.getPlanEndDate());
				initialCustomerBO.setCustomerListNo(customerDTO.getCustomerListNo());
				initialCustomerBO.setCustmerASNo(customerDTO.getCustmerASNo());
				initialCustomerBO.setLegacyCustomerNo(customerDTO.getLegacyCustomerNo());
				initialCustomerBO.setSapCustomerName(customerDTO.getSapCustomerName());
				initialCustomerBO.setSapCustomerNo(customerDTO.getSapCustomerNo());
				initialCustomerBO.setLastUpdatedDate(customerDTO.getLastUpdatedDate());
				initialCustomerBO.setPlanStartDate(customerDTO.getPlanStartDate());
				initialCustomerBO.setPlanEndDate(customerDTO.getPlanEndDate());
				initialCustomerBO.setCountryCode(customerDTO.getCountryCode());

				customerBOFactory.updateCustomerBO(initialCustomerBO, CustomerBOFactory.CUSTOMER_TABLE);
			} catch (DomainException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}
		}
		
	}
	/* CR6153 end change */

	/**
	 *  
	 * This method retrieve customers as part of proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalDTO
	 * @return
	 */
	public ProposalDomainDTO retrieveCustomerForProposal(ProposalDomainDTO proposalDTO) throws ServiceException {
		CustomerBOFactory customerBOFactory = null;
		List customerDTOList = null;
		List customerBOList = null;
		CustomerBO customerBO = null;
		CustomerDomainDTO customerDomainDTO = null;
		DMManagerLocal dmManagerLocal = null;
		String methodName = "retrieveCustomerForProposal";
      	customerBOFactory = new CustomerBOFactory();
		try {
			customerBOList = customerBOFactory.findCustomerBOforProposal(proposalDTO.getProposalId(), CustomerBOFactory.CUSTOMER_TABLE);
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
		Iterator iterate = customerBOList.iterator();
		customerDTOList = new ArrayList();
		while (iterate.hasNext()) {
			customerBO = (CustomerBO) iterate.next();
			customerDomainDTO = new CustomerDomainDTO(customerBO);
			if (proposalDTO.getActionName() != null && proposalDTO.getActionName().equals(ActionNameConstants.COPY_INVENTORY_SWO)) {
				dmManagerLocal = getDMManagerLocal();
				customerDomainDTO = dmManagerLocal.retrieveDMForCustomer(customerDomainDTO);
			}
			customerDTOList.add(customerDomainDTO);
		}
		proposalDTO.setCustomerDTOList(customerDTOList);

		return proposalDTO;
	}

	/**
	 *  
	 * This method stores the dm information which is returned from 
	 * back end as part of the customer
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerDTO
	 */
	public void storeInventory(CustomerDomainDTO customerDTO) throws ServiceException {
		
		DMManagerLocal dmManagerLocal = null;
		CustomerBOFactory customerBOFactory = null;
		CustomerBO customerBO = null;
		List dmDomainDTOList = null;
		DMDomainDTO dmDomainDTO = null;
		customerBOFactory = new CustomerBOFactory();
		String methodName = "storeInventory";

		try {
						
			customerBO = customerBOFactory.getCustomerBO(customerDTO.getProposalId(), customerDTO.getCustomerId(), CustomerBOFactory.CUSTOMER_TABLE);
			customerBO.setPlanStartDate(customerDTO.getPlanStartDate());
			customerBO.setPlanEndDate(customerDTO.getPlanEndDate());
			customerBOFactory.updateCustomerBO(customerBO, CustomerBOFactory.CUSTOMER_TABLE);
			dmManagerLocal = getDMManagerLocal();
			dmDomainDTOList = customerDTO.getDMDTOList();
			
			
			if (dmDomainDTOList != null && dmDomainDTOList.size() > 0) {
				dmManagerLocal.storeDMInfo(dmDomainDTOList);
			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}

	/**
	 *  
	 * This method store ineligible license information to be pulled in to inventory 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerDTO
	 * @throws ServiceException
	 */
	public void storeIneligibleInventory(CustomerDomainDTO customerDTO) throws ServiceException {
		DMManagerLocal dmManagerLocal = null;
		CustomerBOFactory customerBOFactory = null;
		CustomerBO customerBO = null;
		List dmDomainDTOList = null;
		DMDomainDTO dmDomainDTO = null;
		customerBOFactory = new CustomerBOFactory();
		String methodName = "storeIneligibleInventory";

		try {
			customerBO = customerBOFactory.getCustomerBO(customerDTO.getProposalId(), customerDTO.getCustomerId(), CustomerBOFactory.CUSTOMER_TABLE);
			customerBO.setPlanStartDate(customerDTO.getPlanStartDate());
			customerBO.setPlanEndDate(customerDTO.getPlanEndDate());
			customerBOFactory.updateCustomerBO(customerBO, CustomerBOFactory.CUSTOMER_TABLE);
			dmManagerLocal = getDMManagerLocal();
			dmDomainDTOList = customerDTO.getDMDTOList();
			if (dmDomainDTOList != null) {
				Iterator iterate = dmDomainDTOList.iterator();
				while (iterate.hasNext()) {
					dmDomainDTO = (DMDomainDTO) iterate.next();
					dmManagerLocal.storeIneligibleLicenseInfo(dmDomainDTO);
				}
			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}

	/**
	 *  
	 * This method returns DMManager Local Object 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 * @throws ServiceException
	 */
	private DMManagerLocal getDMManagerLocal() throws ServiceException {
		DMManagerLocalHome dmManagerLocalHome = null;
		DMManagerLocal dmManagerLocal = null;
		dmManagerLocalHome = getDMManagerLocalHome();
		String methodName = "getDMManagerLocal";

		try {
			dmManagerLocal = dmManagerLocalHome.create();
		} catch (CreateException c) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, c);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return dmManagerLocal;
	}

	/**
	 * This method returns SWOManager Local Object 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 * @throws ServiceException
	 */
	private SWOManagerLocal getSWOManagerLocal() throws ServiceException {
		SWOManagerLocalHome swoManagerLocalHome = null;
		SWOManagerLocal swoManagerLocal = null;
		swoManagerLocalHome = getSWOManagerLocalHome();
		String methodName = "getSWOManagerLocal";

		try {
			swoManagerLocal = swoManagerLocalHome.create();
		} catch (CreateException c) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, c);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return swoManagerLocal;
	}

	/**
	 *  
	 * This method Updates the customer information
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerDTO
	 */
	public void updateCustomer(CustomerDomainDTO customerDTO) throws ServiceException {
		CustomerBOFactory customerBOFactory = null;
		CustomerBO customerBO = null;
		customerBOFactory = new CustomerBOFactory();
		DMManagerLocal dmManagerLocal = null;
		String methodName = "updateCustomer";

		try {

			customerBO = customerBOFactory.getCustomerBO(customerDTO.getProposalId(), customerDTO.getCustomerId(), CustomerBOFactory.CUSTOMER_TABLE);

			customerBO.setPlanStartDate(customerDTO.getPlanStartDate());
			customerBO.setPlanEndDate(customerDTO.getPlanEndDate());

			customerBO.setPayerNo(customerDTO.getPayerNo());
			customerBO.setPayerName(customerDTO.getPayerName());
			customerBO.setPayerLNo(customerDTO.getPayerLNo());
			customerBO.setPayerASNo(customerDTO.getPayerASNo());

			customerBO.setBillToPartyNo(customerDTO.getBillToPartyNo());
			customerBO.setBillToPartyName(customerDTO.getBillToPartyName());
			customerBO.setBillToPartyLNo(customerDTO.getBillToPartyLNo());
			customerBO.setBillToPartyASNo(customerDTO.getBillToPartyASNo());

			customerBOFactory.updateCustomerBO(customerBO, CustomerBOFactory.CUSTOMER_TABLE);
			if (customerDTO.getPlanStartDate() != null && customerDTO.getPlanEndDate() != null) {
				dmManagerLocal = getDMManagerLocal();
				dmManagerLocal.updateDMForCustomer(customerDTO);
			}

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
	}

	/**
	 *  
	 * This method retrieves DM and License information
	 * during the configure dm process. 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmDTO
	 * @return
	 */
	public DMDomainDTO retrieveDMAndLicenseInfo(DMDomainDTO dmDTO) throws ServiceException {
		DMManagerLocal dmManagerLocal = null;
		DMDomainDTO dmDomainDTO = null;
		dmManagerLocal = getDMManagerLocal();
		dmDomainDTO = dmManagerLocal.retrieveDM(dmDTO);

		return dmDomainDTO;
	}

	/** 
	 * This method remove SVCLicenses from the inventory before pricing 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalInformation
	 * @throws ServiceException 
	 */
	public void removeSVCLicenses(ProposalDomainDTO proposalInformation) throws ServiceException {
		SWOManagerLocal swoManager = getSWOManagerLocal();
		swoManager.removeSVCLicenses(proposalInformation);
	}
	/**
	 *  
	 * This method retrieves the dm edit information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmDomainDTO
	 * @return CustomerDomainDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public CustomerDomainDTO retrieveDMEditInfo(DMDomainDTO dmDomainDTO) throws ServiceException {
		CustomerDomainDTO customerDomainDTO = null;
		CustomerBOFactory customerBOFactory = null;
		CustomerBO customerBO = null;
		List dmDTOList = null;
		customerBOFactory = new CustomerBOFactory();
		DMManagerLocal dmManagerLocal = null;
		String methodName = "retrieveDMEditInfo";
		try {
			customerBO = customerBOFactory.getCustomerBO(dmDomainDTO.getProposalId(), dmDomainDTO.getCustomerId(), CustomerBOFactory.CUSTOMER_TABLE);
			customerDomainDTO = new CustomerDomainDTO(customerBO);
			dmManagerLocal = getDMManagerLocal();
			dmDomainDTO = dmManagerLocal.retrieveDM(dmDomainDTO);
			dmDTOList = new ArrayList();
			dmDTOList.add(dmDomainDTO);
			customerDomainDTO.setDMDTOList(dmDTOList);

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
		return customerDomainDTO;
	}

	/**
	 *  
	 * This method retrieves the swo edit information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoDomainDTO
	 * @return
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public CustomerDomainDTO retrieveSWOEditInfo(SWODomainDTO swoDomainDTO) throws ServiceException {
		CustomerDomainDTO customerDomainDTO = null;
		CustomerBOFactory customerBOFactory = null;
		CustomerBO customerBO = null;
		List dmDTOList = null;
		customerBOFactory = new CustomerBOFactory();
		DMManagerLocal dmManagerLocal = null;
		DMDomainDTO dmDomainDTO = null;
		String methodName = "retrieveSWOEditInfo";
		try {
			customerBO = customerBOFactory.getCustomerBO(swoDomainDTO.getProposalId(), swoDomainDTO.getCustomerId(), CustomerBOFactory.CUSTOMER_TABLE);
			customerDomainDTO = new CustomerDomainDTO(customerBO);
			dmManagerLocal = getDMManagerLocal();
			dmDomainDTO = dmManagerLocal.retrieveEditSWOInfo(swoDomainDTO);
			dmDTOList = new ArrayList();
			dmDTOList.add(dmDomainDTO);
			customerDomainDTO.setDMDTOList(dmDTOList);
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}

		return customerDomainDTO;
	}

	/**
	 *  
	 * This method stores bump inventory information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bumpProposalDTO
	 */
	public void storeBumpInfo(DMDomainDTO bumpDMDTO) throws ServiceException {
		DMManagerLocal dmManagerLocal = null;
		SWOManagerLocal swoManagerLocal = null;
		List swoDomainDTOList = null;

		if (bumpDMDTO.getActionName() != null && bumpDMDTO.getActionName().equals(ActionNameConstants.COPY_BUMP_DM)) {

			dmManagerLocal = getDMManagerLocal();
			dmManagerLocal.storeBumpInfo(bumpDMDTO);

		} else {

			swoManagerLocal = getSWOManagerLocal();
			swoDomainDTOList = bumpDMDTO.getSWODTOList();
			swoManagerLocal.insertBumpLicenseInfo(swoDomainDTOList);
		}

	}

	/**
	 *  
	 * This method store the variance information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param CustomerDomainDTO
	 * @author Venkat
	 *
	 */
	public void storeVarianceInfo(CustomerDomainDTO customerDTO) throws ServiceException {
		DMManagerLocal dmManagerLocal = null;
		List dmDomainDTOList = null;
		DMDomainDTO dmDomainDTO = null;
		dmManagerLocal = getDMManagerLocal();
		dmDomainDTOList = customerDTO.getDMDTOList();
		if (dmDomainDTOList != null) {
			Iterator iterate = dmDomainDTOList.iterator();
			while (iterate.hasNext()) {
				dmDomainDTO = (DMDomainDTO) iterate.next();
				dmManagerLocal.storeVarianceInfoForDM(dmDomainDTO);
			}
		}
	}

	/**
	 *  
	 * This method verifies license information stored in as part of inventory 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalDTO
	 */
	public boolean verifyLicensesAlreadyExists(SWODomainDTO swoDomainDTO) throws ServiceException {
		boolean isLicenseExists = false;
		SWOManagerLocal swoManagerLocal = null;
		swoManagerLocal = getSWOManagerLocal();
		isLicenseExists = swoManagerLocal.verifyLicenseAreExists(swoDomainDTO);
		return isLicenseExists;
	}

	/**
	 *  
	 * This method Configure DM information 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *
	 */
	public void storeConfigureDMInfo(DMDomainDTO dmDTO) throws ServiceException {
		DMManagerLocal dmManagerLocal = null;
		dmManagerLocal = getDMManagerLocal();
		dmManagerLocal.storeConfigureDMInfo(dmDTO);
	}

	/**
	 *  
	 * This method remove the DM details and License information as part of the DM 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmDTO
	 */
	public void removeDMDetails(DMDomainDTO dmDTO) throws ServiceException {
		DMManagerLocal dmManagerLocal = null;
		dmManagerLocal = getDMManagerLocal();
		CustomerBOFactory customerBOFactory = null;
		CustomerBO customerBO = null;
		CustomerDomainDTO customerDomainDTO = null;
		String methodName = "removeDMDetails";
		try {

			customerBOFactory = new CustomerBOFactory();
			customerBO = customerBOFactory.getCustomerBO(dmDTO.getProposalId(), dmDTO.getCustomerId(), CustomerBOFactory.CUSTOMER_TABLE);
			customerDomainDTO = new CustomerDomainDTO(customerBO);
			copyStoreCustomerInfo(customerDomainDTO);
			dmManagerLocal.copyStoreDMHistoryInfo(dmDTO);
			dmManagerLocal.removeDMInfo(dmDTO);

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}

	/**
	 *  
	 * This method removes the SWO information and EE information as part of SWO 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *
	 */
	public void removeSWODetails(SWODomainDTO swoDTO) throws ServiceException {
		DMManagerLocal dmManagerLocal = null;
		dmManagerLocal = getDMManagerLocal();
		CustomerBOFactory customerBOFactory = null;
		CustomerBO customerBO = null;
		CustomerDomainDTO customerDomainDTO = null;
		String methodName = "removeSWODetails";

		try {
			customerBOFactory = new CustomerBOFactory();
			customerBO = customerBOFactory.getCustomerBO(swoDTO.getProposalId(), swoDTO.getCustomerId(), CustomerBOFactory.CUSTOMER_TABLE);
			customerDomainDTO = new CustomerDomainDTO(customerBO);
			copyStoreCustomerInfo(customerDomainDTO);
			dmManagerLocal.removeLicenses(swoDTO);

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}

	/**
	 *  
	 * This method updates the edited DM information
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmDTO
	 */
	public void updateDMEditInfo(DMDomainDTO dmDTO) throws ServiceException {
		DMManagerLocal dmManagerLocal = null;
		dmManagerLocal = getDMManagerLocal();
		dmManagerLocal.updateDMDetails(dmDTO);
	}

	/**
	 *  
	 * This method copy the information from the inventory and stored in a history table
	 * when user deletes the inventory of customer
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *
	 */
	public void copyStoreCustomerInfo(CustomerDomainDTO customerDTO) throws ServiceException {
		DMManagerLocalHome dmManagerLocalHome = null;
		DMManagerLocal dmManagerLocal = null;
		CustomerBO customerBO = null;
		CustomerBO historyCustomerBO = null;
		CustomerBOFactory customerBOFactory = null;
		DMDomainDTO dmDomainDTO = null;
		String methodName = "copyStoreCustomerInfo";

		customerBOFactory = new CustomerBOFactory();
		try {
			customerBO = customerBOFactory.getCustomerBO(customerDTO.getProposalId(), customerDTO.getCustomerId(), CustomerBOFactory.CUSTOMER_TABLE);
			try {
				historyCustomerBO = customerBOFactory.getCustomerBO(customerDTO.getProposalId(), customerDTO.getCustomerId(), CustomerBOFactory.HISTORY_CUSTOMER_TABLE);

			} catch (DomainException d) {
				customerBOFactory.createCustomerBO(customerBO, CustomerBOFactory.HISTORY_CUSTOMER_TABLE);
				if (customerDTO.getActionName() != null && customerDTO.getActionName().equals(ActionNameConstants.DELETE_INVENTORY_CUSTOMER)) {
					dmManagerLocal = getDMManagerLocal();
					dmDomainDTO = new DMDomainDTO();
					dmDomainDTO.setCustomerId(customerDTO.getCustomerId());
					dmDomainDTO.setProposalId(customerDTO.getProposalId());
					dmManagerLocal.copyStoreDMHistoryInfo(dmDomainDTO);
				}
			}

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}

	}

	/**
	 *  
	 * This method retrieves DM and Customer information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmDTO
	 */
	public CustomerDomainDTO retrieveCustomerAndDMInfo(DMDomainDTO dmDTO) throws ServiceException {
		CustomerBOFactory customerBOFactory = null;
		CustomerBO customerBO = null;
		DMManagerLocal dmManagerLocal = null;
		CustomerDomainDTO customerDomainDTO = null;
		List dmList = null;
		customerBOFactory = new CustomerBOFactory();
		String methodName = "retrieveCustomerAndDMInfo";
		try {

			customerBO = customerBOFactory.getCustomerBO(dmDTO.getProposalId(), dmDTO.getCustomerId(), CustomerBOFactory.CUSTOMER_TABLE);
			customerDomainDTO = new CustomerDomainDTO(customerBO);
			dmManagerLocal = getDMManagerLocal();
			dmList = new ArrayList();
			dmDTO = dmManagerLocal.retrieveDM(dmDTO);
			dmList.add(dmDTO);
			customerDomainDTO.setDMDTOList(dmList);

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
		return customerDomainDTO;
	}

	/**
	 *  
	 * This method retrieves the copy SWO information 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerDTO
	 */
	public CustomerDomainDTO retrieveSWOCopyInfo(SWODomainDTO swoDomainDTO) throws ServiceException {
		CustomerBOFactory customerBOFactory = null;
		CustomerDomainDTO customerDomainDTO = null;
		DMManagerLocal dmManagerLocal = null;
		CustomerBO customerBO = null;
		customerBOFactory = new CustomerBOFactory();
		List dmDTOList = null;
		DMDomainDTO dmDomainDTO = null;
		dmDTOList = new ArrayList();
		String methodName = "retrieveSWOCopyInfo";

		try {

			customerBO = customerBOFactory.getCustomerBO(swoDomainDTO.getProposalId(), swoDomainDTO.getCustomerId(), CustomerBOFactory.CUSTOMER_TABLE);
			customerDomainDTO = new CustomerDomainDTO(customerBO);
			dmManagerLocal = getDMManagerLocal();
			dmDomainDTO = dmManagerLocal.retrieveSWOInfo(swoDomainDTO);
			dmDTOList.add(dmDomainDTO);
			customerDomainDTO.setDMDTOList(dmDTOList);

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}

		return customerDomainDTO;
	}

	/**
	 *  
	 * This method stores EE configuration information during configure dm functionality 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eeDTO
	 */
	public void storeEEConfigInfo(TempEEDomainDTO tempEEDTO) throws ServiceException {
		SWOManagerLocal swoManagerLocal = null;
		String methodName = "storeEEConfigInfo";
		try {
			swoManagerLocal = HomeProvider.getSWOManagerLocal();
			swoManagerLocal.storeEEConfigInfo(tempEEDTO);

		} catch (CreateException c) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, c);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
	}

	/**
	 *  
	 * This metho populates the CustomerBO from Customer Domain DTO 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerDomainDTO
	 * @return
	 */
	private CustomerBO populateCustomerBO(CustomerDomainDTO customerDomainDTO) {
		CustomerBO customerBO = null;
		customerBO = new CustomerBO();
		customerBO.setCustomerId(customerDomainDTO.getCustomerId());
		customerBO.setProposalId(customerDomainDTO.getProposalId());
		customerBO.setBillToPartyASNo(customerDomainDTO.getBillToPartyASNo());
		customerBO.setBillToPartyLNo(customerDomainDTO.getBillToPartyLNo());
		customerBO.setBillToPartyName(customerDomainDTO.getBillToPartyName());
		customerBO.setBillToPartyNo(customerDomainDTO.getBillToPartyNo());
		//customerBO.setCustmerASNo(customerDomainDTO.getCustomerASNo());
		customerBO.setCustomerListNo(customerDomainDTO.getCustomerListNo());
		customerBO.setLastUpdatedDate(customerDomainDTO.getLastUpdatedDate());
		customerBO.setLegacyCustomerNo(customerDomainDTO.getLegacyCustomerNo());
		customerBO.setPayerASNo(customerDomainDTO.getPayerASNo());
		customerBO.setPayerNo(customerDomainDTO.getPayerNo());
		customerBO.setPayerName(customerDomainDTO.getPayerName());
		customerBO.setPayerNo(customerDomainDTO.getPayerNo());
		customerBO.setPlanEndDate(customerDomainDTO.getPlanEndDate());
		customerBO.setSapCustomerName(customerDomainDTO.getSapCustomerName());
		customerBO.setSapCustomerNo(customerDomainDTO.getSapCustomerNo());
		customerBO.setShipToPartyASNo(customerDomainDTO.getShipToPartyASNo());
		customerBO.setShipToPartyLNo(customerDomainDTO.getShipToPartyLNo());
		customerBO.setShipToPartyName(customerDomainDTO.getShipToPartyName());
		customerBO.setShipToPartyNo(customerDomainDTO.getShipToPartyNo());
		return customerBO;
	}

	/**
	 *  
	 * This method skip or replace licenses during delta- fetch operation 
	 * based on the user selection 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerDTO
	 */
	public void replaceSkipLicenses(CustomerDomainDTO customerDTO) throws ServiceException {
		String methodName = "replaceSkipLicenses";
		// TimeTaken log = new // TimeTaken(CLASS_NAME, methodName);
		DMManagerLocal dmManagerLocal = null;
		List dmDomainDTOList = null;
		DMDomainDTO dmDomainDTO = null;
		dmManagerLocal = getDMManagerLocal();
		dmDomainDTOList = customerDTO.getDMDTOList();
		if (dmDomainDTOList != null) {
			Iterator iterate = dmDomainDTOList.iterator();
			while (iterate.hasNext()) {
				dmDomainDTO = (DMDomainDTO) iterate.next();
				dmManagerLocal.repalceSkipLicenses(dmDomainDTO);
			}
		}
		//log.end();
	}

	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}

	/**
	 * |
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 16, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param 
	 * @return 
	 * @throws 
	 * @author Prakash Mall
	 */

	public boolean isSVCLicenseExistsForProposal(int proposalID, String transactionName) throws ServiceException {

		boolean exist = true;
		String methodName = "isSVCLicenseExistsForProposal";
		// Delegate the responsibility to SWO Manager 

		SWOManagerLocalHome swoManagerLocalHome = (SWOManagerLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome("SWOManagerLocalHome");

		SWOManagerLocal swoManagerLocal = null;

		try {
			swoManagerLocal = (SWOManagerLocal) swoManagerLocalHome.create();
		} catch (CreateException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		exist = swoManagerLocal.chkSVCLicense(proposalID, transactionName);

		return exist;
	}

	/**	
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date March 9th, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param 
	 * @return 
	 * @throws 
	 * @author Prakash Mall
	 */

	public boolean isSandSLicenseExistForProposal(int proposalID, String flag) throws ServiceException {

		String methodName = "isSandSLicenseExistForProposal";

		boolean exist = true;
		SWOManagerLocalHome swoManagerLocalHome = (SWOManagerLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome("SWOManagerLocalHome");

		SWOManagerLocal swoManagerLocal = null;

		try {
			swoManagerLocal = (SWOManagerLocal) swoManagerLocalHome.create();
		} catch (CreateException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		exist = swoManagerLocal.chkSandSLicense(proposalID, flag);

		return exist;
	}

	public String getSWOExternalCntrNumber(int proposalId) throws ServiceException {

		String methodName = "chkSWOExternalCntrNumber";

		String messageString = OPPTHelper.getLogString(String.valueOf(proposalId));
		OPPTLogger.log("PROPOSAL_ID", OPPTLogger.DEBUG, CLASS_NAME, "chkSWOExternalCntrNumber", messageString);

		SWOManagerLocalHome swoManagerLocalHome = (SWOManagerLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome("SWOManagerLocalHome");

		SWOManagerLocal swoManagerLocal = null;

		try {
			swoManagerLocal = (SWOManagerLocal) swoManagerLocalHome.create();
		} catch (CreateException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		String swoExtCntrNum = swoManagerLocal.chkSWOExternalCntrNumber(proposalId);
		return swoExtCntrNum;
	}

	/** 
	 * Delegates the call to exclude/include licenses
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param licenses
	 * @param machines
	 * @param customers
	 * @return boolean
	 * @throws ServiceException 
	 */
	public boolean excludeIncludeLicenses(SWODomainDTO[] licenses, DMDomainDTO[] machines, CustomerDomainDTO[] customers) throws ServiceException {
		boolean result = false;
		boolean executeResult = false;
		SWOManagerLocal swoManagerLocal = null;

		if (licenses != null && licenses.length > 0) {
			swoManagerLocal = getSWOManagerLocal();
			executeResult = swoManagerLocal.excludeIncludeSWO(licenses);
			if (executeResult) {
				result = true;
			}
		}
		if (machines != null && machines.length > 0) {
			if (swoManagerLocal == null) {
				swoManagerLocal = getSWOManagerLocal();
			}
			for (int i = 0; i < machines.length; i++) {
				executeResult = swoManagerLocal.excludeIncludeSWOsOfDM(machines[i]);
				if (!result) {
					result = executeResult;
				}
			}
		}
		if (customers != null && customers.length > 0) {
			if (swoManagerLocal == null) {
				swoManagerLocal = getSWOManagerLocal();
			}
			for (int i = 0; i < customers.length; i++) {
				executeResult = swoManagerLocal.excludeIncludeSWOsOfCustomer(customers[i]);
				if (!result) {
					result = executeResult;
				}
			}
		}
		return result;
	}

	/** 
	 * Retrieves the details of licenses
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param licenses
	 * @return SWODomainDTO[]
	 * @throws ServiceException 
	 */
	public SWODomainDTO[] retrieveSWODetails(SWODomainDTO[] licenses) throws ServiceException {
		SWOManagerLocal swoManager = getSWOManagerLocal();
		return swoManager.retrieveSWODetails(licenses);
	}

	/** 
	 * Retrieves the detail of DMs
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param machines
	 * @return DMDomainDTO[]
	 * @throws ServiceException 
	 */
	public DMDomainDTO[] retrieveDMDetails(DMDomainDTO[] machines) throws ServiceException {
		DMManagerLocal managerDM = null;

		if (machines != null && machines.length > 0) {
			managerDM = getDMManagerLocal();
			for (int i = 0; i < machines.length; i++) {
				machines[i] = managerDM.retrieveDM(machines[i]);
			}
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "InventoryManagerBean", "retrieveDMDetails", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return machines;
	}

	/** 
	 * Retrieves the information of customers
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customers
	 * @return CustomerDomainDTO[]
	 * @throws ServiceException 
	 */
	public CustomerDomainDTO[] retrieveCustomerDetails(CustomerDomainDTO[] customers) throws ServiceException {
		CustomerBOFactory customerBOFactory = null;
		CustomerBO customerBO = null;

		if (customers != null && customers.length > 0) {
			customerBOFactory = new CustomerBOFactory();
			for (int i = 0; i < customers.length; i++) {
				try {
					customerBO = customerBOFactory.getCustomerBO(customers[i].getProposalId(), customers[i].getCustomerId(), CustomerBOFactory.CUSTOMER_TABLE);
					customers[i] = new CustomerDomainDTO(customerBO);
				} catch (DomainException e) {
					throw ExceptionGenerator.generateServiceException(e.getErrorReport());
				}
			}
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "InventoryManagerBean", "retrieveCustomerDetails", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return customers;
	}

	/** 
	 * Retrieves the details of a DM
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param machines
	 * @return DMDomainDTO
	 * @throws ServiceException 
	 */
	public DMDomainDTO retrieveDMInfo(DMDomainDTO machine) throws ServiceException {
		DMManagerLocal managerDM = null;

		if (machine != null) {
			managerDM = getDMManagerLocal();
			machine = managerDM.retrieveDM(machine);
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "InventoryManagerBean", "retrieveDMInfo", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return machine;
	}

	/** 
	 * Retrieves the details of a customer
	 *   
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customers
	 * @return CustomerDomainDTO
	 * @throws ServiceException 
	 */
	public CustomerDomainDTO retrieveCustomerInfo(CustomerDomainDTO customer) throws ServiceException {
		CustomerBOFactory customerBOFactory = null;
		CustomerBO customerBO = null;
		String methodName = "retrieveCustomerInfo";

		if (customer != null) {
			customerBOFactory = new CustomerBOFactory();
			try {
				customerBO = customerBOFactory.getCustomerBO(customer.getProposalId(), customer.getCustomerId(), CustomerBOFactory.CUSTOMER_TABLE);
				
				customer = new CustomerDomainDTO(customerBO);

			} catch (DomainException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}
		}
		return customer;
	}

	/** 
	 * Updates the SWO Details
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoDTO
	 * @throws ServiceException 
	 */
	public void updateSWODetails(SWODomainDTO[] swoDTO) throws ServiceException {
		SWOManagerLocal swoManagerLocal = null;
		swoManagerLocal = getSWOManagerLocal();
		if (swoDTO != null & swoDTO.length > 0) {
			swoManagerLocal.updateSWODetails(swoDTO);
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "InventoryManagerBean", "updateSWODetails", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
	}

	/**
	* Validates and Populate SWO Info for Status Checking
	* <br><b>Known Bugs</b><br> 
	* 
	* <br><PRE> 
	* date Jan 15, 2004
	* 
	* revision date author reason 
	* 
	* </PRE><br> 
	* 
	* @param SWODomainDTO
	* @return 
	* @throws ServiceException
	* @author Prakash Mall
	*/

	public SWODomainDTO validateAndPopulateSWOForStatusCheck(SWODomainDTO swoDomainDTO) throws ServiceException {
		String methodName = "validateAndPopulateSWOForStatusCheck";
		try {
			swoDomainDTO = HomeProvider.getSWOManagerLocal().validateAndPopulateSWOForStatusCheck(swoDomainDTO);
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		} finally {
			return swoDomainDTO;
		}
	}

	/**
	 * setSessionContext
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		mySessionCtx = ctx;
	}
	/**
	 * ejbCreate
	 */
	public void ejbCreate() throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() {
	}

	/**
	 *  
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmDTO
	 * @return
	 * @throws ServiceException
	 */
	public List retrieveSWODetails(DMDomainDTO dmDTO) throws ServiceException {
		String methodName = "retrieveSWODetails";
		try {
			SWOManagerLocal local = HomeProvider.getSWOManagerLocal();
			return local.retrieveSWODetails(dmDTO);
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
	}

	/**
	 * This method retrieves the EE Configuration information from temp 
	 *  
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
	 * @param tempEEDomainDTO
	 * @return
	 * @throws ServiceException
	 */
	public TempEEDomainDTO retrieveEEConfigInfoFromTemp(TempEEDomainDTO tempEEDomainDTO) throws ServiceException {
		SWOManagerLocal swoManagerLocal = null;
		String methodName = "retrieveEEConfigInfoFromTemp";
		try {
			swoManagerLocal = HomeProvider.getSWOManagerLocal();
			tempEEDomainDTO = swoManagerLocal.retrieveEEConfigInfoFromTemp(tempEEDomainDTO);
		} catch (CreateException c) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, c);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		return tempEEDomainDTO;
	}

	/**
	 *  
	 * This method removes the configuration details from temp 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param tempEEDomainDTO
	 * @throws ServiceException
	 */
	public void removeEEConfigDetails(TempEEDomainDTO tempEEDomainDTO) throws ServiceException {
		SWOManagerLocal swoManagerLocal = null;
		swoManagerLocal = getSWOManagerLocal();
		swoManagerLocal.removeConfigurationDetails(tempEEDomainDTO);
	}

	/** 
	 * Deletes variance inventory related to a variance contract from the temporary table
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposal
	 * @throws ServiceException 
	 */
	public void deleteVarianceInventory(ProposalDomainDTO proposal) throws ServiceException {
		DMManagerLocal dmManager = null;

		if (null != proposal) {
			dmManager = getDMManagerLocal();
			dmManager.deleteVarianceDM(proposal);
		}
	}

	private DMManagerLocalHome getDMManagerLocalHome() {
		return (DMManagerLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(DM_MANAGER_LOCAL_HOME);
	}

	private SWOManagerLocalHome getSWOManagerLocalHome() {
		return (SWOManagerLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(SWO_MANAGER_LOCAL_HOME);
	}

	/**
	 *  
	 * This method retrieves the Customer no 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerDomainDTO
	 * @return
	 * @throws ServiceException
	 */
	//DADO02 Sateesh Anne return type is changed from String Array to CustomerBO Array
	public CustomerBO[] retrieveCustomerNumberForCustomerList(CustomerDomainDTO customerDomainDTO) throws ServiceException {

		CustomerBOFactory customerBOFactory = new CustomerBOFactory();
		List customerBOList = new ArrayList();
		String methodName = "retrieveCustomerNumberForCustomerList";
		try {
			customerBOList = customerBOFactory.findCustomerBOForCustomerListAndProposal(customerDomainDTO.getCustomerListNo(), customerDomainDTO.getProposalId());
		} catch (DomainException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}
	//DADO02 	String customerNumbers[] = new String[customerBOList.size()];
		CustomerBO customerBO[] = new CustomerBO[customerBOList.size()];
		for (int i = 0, size = customerBOList.size(); i < size; i++) {
			
		/*DADO02 CustomerBO customerBO = (CustomerBO) customerBOList.get(i);
			customerNumbers[i] = customerBO.getSapCustomerNo();*/
			customerBO[i] = (CustomerBO)customerBOList.get(i);
		}

		return customerBO;

	}

	/**
	 *  
	 * This updates the ESW Price for customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalDomainDTO
	 * @throws ServiceException
	 */
	public void updateESWPriceForVarianceProposal(ProposalDomainDTO proposalDomainDTO) throws ServiceException {
		SWOManagerLocal swoManagerLocal = null;
		String methodName = "updateESWPriceForVarianceProposal";

		try {
			swoManagerLocal = HomeProvider.getSWOManagerLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		swoManagerLocal.updateESWPriceForVarianceProposal(proposalDomainDTO);
	}

	/** 
		* This method remove Quotes from the inventory before sending for Registration 
		*  
		* <br><b>Known Bugs</b><br> 
		* 
		* <br><PRE> 
		* date Feb 14, 2004 
		* 
		* revision date author reason 
		* 
		* </PRE><br> 
		* 
		* @param proposalInformation
		* @throws ServiceException
		* @author Saravanan Viswanathan 
		*/
	public boolean removeQuotes(ProposalDomainDTO proposalInformation) throws ServiceException {
		boolean resultvalue = false;
		SWOManagerLocal swoManager = getSWOManagerLocal();
		resultvalue = swoManager.removeQuotes(proposalInformation);
		return resultvalue;
	}

	/** 
		* Delegates the call to fetch S&S details for the proposal 
		*  
		* <br><b>Known Bugs</b><br> 
		* 
		* <br><PRE> 
		* date Feb 21, 2004 
		* 
		* revision date author reason 
		* 
		* </PRE><br> 
		* 
		* @param dmDomainDTOList
		* @param swoDomainDTOList
		* @throws ServiceException
		* @author Saravanan Viswanathan 
		*/
	public List fetchSAndSDetails(DMDomainDTO[] dmDomainDTOList, SWODomainDTO[] swoDomainDTOList) throws ServiceException {
		SWOManagerLocal swoManager = getSWOManagerLocal();
		return swoManager.fetchSAndSDetails(dmDomainDTOList, swoDomainDTOList);
	}

	/** 
		* Delegates the call to apply S&S discount percent for the EE's of the proposal 
		*  
		* <br><b>Known Bugs</b><br> 
		* 
		* <br><PRE> 
		* date Feb 21, 2004 
		* 
		* revision date author reason 
		* 
		* </PRE><br> 
		* 
		* @param eeDomainDTOArray
		* @param sAndSDiscount
		* @throws ServiceException
		* @author Saravanan Viswanathan 
		*/
	public void applySAndSDiscount(EEDomainDTO[] eeDomainDTOArray, double sAndSDiscount) throws ServiceException {
		SWOManagerLocal swoManager = getSWOManagerLocal();
		swoManager.applySAndSDiscount(eeDomainDTOArray, sAndSDiscount);
	}

	public boolean isCustomerAvailableForProposal(CustomerDomainDTO customer) throws ServiceException {
		CustomerBOFactory factory = new CustomerBOFactory();
		return factory.isCustomerAvailableForProposal(customer.getProposalId(), customer.getSapCustomerNo());
	}
	
	/* CR6153 start change */
	public boolean isCustomerAvailableForProposalPlanStartEndDate(CustomerDomainDTO customer)throws ServiceException {
		CustomerBOFactory factory = new CustomerBOFactory();
		return factory.isCustomerAvailableForProposalPlanStartEndDate(customer.getProposalId(), customer.getSapCustomerNo(),customer.getPlanStartDate(),customer.getPlanEndDate());
	}
	/* CR6153 end change */
	
	/* Changed for EF0607044559S by Sara on June 16,2004 */
	public CustomerDomainDTO findSTPForProposal(int proposalId, String sapCustomerNo) throws ServiceException {
		CustomerBOFactory factory = new CustomerBOFactory();
		CustomerDomainDTO customerDomainDTO = null;
		try {
			CustomerBO customerBO = factory.findSTPForProposal(proposalId, sapCustomerNo);
			customerDomainDTO = new CustomerDomainDTO(customerBO);
		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
		return customerDomainDTO;
	}
	/* EF0607044559E */
	
	/* CR6153 start cahnge */
	public CustomerDomainDTO findSTPForProposalPlanStartEndDate(int proposalId, String sapCustomerNo, Date planStartDate, Date planEndDate) throws ServiceException {
		CustomerBOFactory factory = new CustomerBOFactory();
		CustomerDomainDTO customerDomainDTO = null;
		try {
			CustomerBO customerBO = factory.findSTPForProposalPlanStartEndDate(proposalId, sapCustomerNo, planStartDate, planEndDate);
			customerDomainDTO = new CustomerDomainDTO(customerBO);
		} catch (DomainException d) {
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
		return customerDomainDTO;
	}
	/* CR6153 end change */
	public ProposalDomainDTO retrieveCustomerForCopyInventory(ProposalDomainDTO proposalDTO) throws ServiceException {
		CustomerBOFactory customerBOFactory = null;
		List customerDTOList = null;
		List customerBOList = null;
		CustomerBO customerBO = null;
		CustomerDomainDTO customerDomainDTO = null;
		DMManagerLocal dmManagerLocal = null;
		String methodName = "retrieveCustomerForProposal";

		customerBOFactory = new CustomerBOFactory();
		try {
			customerBOList = customerBOFactory.findCustomerBOforProposal(proposalDTO.getProposalId(), CustomerBOFactory.CUSTOMER_TABLE);
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
		Iterator iterate = customerBOList.iterator();
		customerDTOList = new ArrayList();
		while (iterate.hasNext()) {
			customerBO = (CustomerBO) iterate.next();
			customerDomainDTO = new CustomerDomainDTO(customerBO);
			if (ActionNameConstants.REPLACE_CONTRACT.equalsIgnoreCase(proposalDTO.getActionName()) || ActionNameConstants.CREATE_VARIANCEPROPOSAL.equalsIgnoreCase(proposalDTO.getActionName())) {
				customerDomainDTO.setPlanStartDate(OPPTCalender.convertToSQLDate(proposalDTO.getContrStartPeriod()));
				customerDomainDTO.setPlanEndDate(OPPTCalender.convertToSQLDate(proposalDTO.getContrEndPeriod()));
			}
			dmManagerLocal = getDMManagerLocal();
			customerDomainDTO.setActionName(proposalDTO.getActionName());
			customerDomainDTO = dmManagerLocal.retrieveDMForCopyInventory(customerDomainDTO);
			customerDTOList.add(customerDomainDTO);
		}
		proposalDTO.setCustomerDTOList(customerDTOList);

		return proposalDTO;
	}

}
