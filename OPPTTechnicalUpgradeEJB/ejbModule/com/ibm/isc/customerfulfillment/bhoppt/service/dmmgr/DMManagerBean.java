/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr;

import java.sql.Date;
import java.util.*;

import javax.ejb.CreateException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo.CustomerBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.factory.CustomerBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dm.bo.DMBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dm.factory.DMBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.*;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ProposalContractBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo.EEBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo.PriceBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo.SWOBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.factory.EEBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.factory.PriceBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.factory.SWOBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.service.swomgr.SWOManagerLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;

/**
 *  
 * This Manager class delegates the DM Request 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar * @version 5.1A
 */
public class DMManagerBean implements javax.ejb.SessionBean {
	/** Constant */
	private final String SWO_MANAGER_LOCAL_HOME = "SWOManagerLocalHome";
	/** Constant */
	private final int COPY = 1;
	/** Constant */
	private final String CLASS_NAME = "DMManagerBean";
	
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
	 */
	
	public void copyInventory(CopyInventoryDomainDTO copyInventoryDomainDTO) throws ServiceException {
		DMBOFactory dmBOFactory = new DMBOFactory();
		DMBO dmBO = null;
		boolean isCopyDM = true;
		List dmBOList = null;
		String methodName = "copyInventory";
		int maxDMId=0;
		SWOManagerLocal swoLocal = getSWOManagerLocal();
		/* CR6153 start change */
		ProposalContractBO proposal = null;
		ProposalContractBOFactory proposalBOFactory = new ProposalContractBOFactory();
		/* CR6153 end change */
		try {
			if (copyInventoryDomainDTO != null && (copyInventoryDomainDTO.getActionName().equalsIgnoreCase(ActionNameConstants.COPY_INVENTORY_DM))) {

				dmBO = new DMBO();
				dmBO = dmBOFactory.getDMBO(copyInventoryDomainDTO.getOldProposalID(), copyInventoryDomainDTO.getOldCustomerID(), copyInventoryDomainDTO.getOldDMID(), DMBOFactory.DM_TABLE);
				Map map = copyInventoryDomainDTO.getValues();
				populateDMBO(dmBO, copyInventoryDomainDTO);
				maxDMId = dmBOFactory.findMaxDMBO(DMBOFactory.DM_TABLE).getDmId();
				dmBO.setDmId(maxDMId + 1);
				dmBO.setDmNo(String.valueOf(map.get(UtilityConstants.DM_NO)));
				dmBO.setDmDesc(String.valueOf(map.get(UtilityConstants.DM_DESC)));
				dmBO.setPlannedInd(UtilityConstants.YES);
				copyInventoryDomainDTO.setNewDMID(dmBO.getDmId());
				try{
					dmBOFactory.createDMBO(dmBO, DMBOFactory.DM_TABLE);
				}catch(DomainException d){
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0130);	
				}

				swoLocal.copyInventory(copyInventoryDomainDTO);

			} else if (copyInventoryDomainDTO != null && copyInventoryDomainDTO.getActionName().equalsIgnoreCase(ActionNameConstants.COPY_INVENTORY_SWO)) {

				swoLocal.copyInventory(copyInventoryDomainDTO);

			} else {
				List list = new ArrayList();
				if(ActionNameConstants.CREATE_VARIANCEPROPOSAL.equals(copyInventoryDomainDTO.getActionName())) {
					list = dmBOFactory.findDMBOForCustomer(copyInventoryDomainDTO.getOldProposalID(), copyInventoryDomainDTO.getOldCustomerID(), DMBOFactory.VARIANCE_DM_TABLE);
				}else {
					list = dmBOFactory.findDMBOForCustomer(copyInventoryDomainDTO.getOldProposalID(), copyInventoryDomainDTO.getOldCustomerID(), DMBOFactory.DM_TABLE);
				}
				Iterator iter = list.iterator();
				int dmID;
				DMDomainDTO dmDomainDTO = null;
				Map values = copyInventoryDomainDTO.getValues();
				/* CR6153 start change */
				try {
					proposal = proposalBOFactory.getProposalContractBO(copyInventoryDomainDTO.getOldProposalID());
				} catch (DomainException e) {
					throw ExceptionGenerator.generateServiceException(e.getErrorReport());
				}
				/* CR6153 end change */
				while (iter.hasNext()) {
					dmBO = (DMBO) iter.next();
					copyInventoryDomainDTO.setOldDMID(dmBO.getDmId());
					OPPTLogger.debug("In Old DM " + "DM Id :" + dmBO.getDmId() + "Customer Id:" + dmBO.getCustomerId() + "Proposal id:" + dmBO.getProposalId(), CLASS_NAME, methodName);
					/* Variance MN fix Start */										
					if(ActionNameConstants.CREATE_VARIANCEPROPOSAL.equalsIgnoreCase(copyInventoryDomainDTO.getActionName())) {
						boolean insertDM = false;
						dmDomainDTO = validateDMForInsert(dmBO,copyInventoryDomainDTO);
						if(dmDomainDTO == null)	{
							continue;					
						} 
					}
					/* Variance MN fix end */
					if (ActionNameConstants.REPLACE_CONTRACT.equalsIgnoreCase(copyInventoryDomainDTO.getActionName()) ||
					    ActionNameConstants.CREATE_VARIANCEPROPOSAL.equalsIgnoreCase(copyInventoryDomainDTO.getActionName())) {
						/* CR6153 start change */
						if((proposal.getExtendPeriod() != null) && (proposal.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
							if((ActionNameConstants.REPLACE_CONTRACT.equalsIgnoreCase(copyInventoryDomainDTO.getActionName()))
								||(ActionNameConstants.RENEW_CONTRACT.equalsIgnoreCase(copyInventoryDomainDTO.getActionName()))){
								java.sql.Date replaceDate = null;
								if (values != null && values.get(UtilityConstants.PLAN_START_DATE) != null) {
									replaceDate = (java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE);
								}
								if((replaceDate.after(dmBO.getPlanStartDate()) && (replaceDate.before(dmBO.getPlanEndDate())))){
									dmBO.setPlanStartDate((java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE));
								}
							}
						}
						else{
						/* CR6153 end change */
							if (values != null && values.get(UtilityConstants.PLAN_START_DATE) != null) {
								dmBO.setPlanStartDate((java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE));
								dmBO.setPlanEndDate((java.sql.Date) values.get(UtilityConstants.PLAN_END_DATE));
							}
						}
						
					}
					
					// set the old dm id
					populateDMBO(dmBO, copyInventoryDomainDTO);
					if(maxDMId==0){
						maxDMId = dmBOFactory.findMaxDMBO(DMBOFactory.DM_TABLE).getDmId();
					}else{
						maxDMId++;	
					}
				
					dmBO.setDmId(maxDMId + 1); // max dm-id + 1
					OPPTLogger.debug("In New DM " + "DM Id :" + dmBO.getDmId() + "Customer Id:" + dmBO.getCustomerId() + "Proposal id:" + dmBO.getProposalId(), CLASS_NAME, methodName);
					copyInventoryDomainDTO.setNewDMID(dmBO.getDmId());
					try{
						dmBOFactory.createDMBO(dmBO, DMBOFactory.DM_TABLE);
					}catch(DomainException d){
						throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0129);	
					}
					/* Variance MN fix Start */
					if(ActionNameConstants.CREATE_VARIANCEPROPOSAL.equalsIgnoreCase(copyInventoryDomainDTO.getActionName())) {
						// Here write a copyInventory method in SWOInfoBean and pass dmDomainDTO to that.
						swoLocal.copyInventory(dmDomainDTO,copyInventoryDomainDTO);
					}
					else {
						swoLocal.copyInventory(copyInventoryDomainDTO);
					}
					/* Variance MN fix end */
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
	 * @param dmBO
	 * @param copyInventoryDomainDTO 
	 */
	private void populateDMBO(DMBO dmBO, CopyInventoryDomainDTO copyInventoryDomainDTO) {
		Map map = copyInventoryDomainDTO.getValues();

		dmBO.setLastUpdatedDate(new Date(System.currentTimeMillis()));

		switch (copyInventoryDomainDTO.getChoice()) {
			case COPY :
				Date planStartDate = new Date(((java.util.Date) map.get(UtilityConstants.PLAN_START_DATE)).getTime());
				Date planEndDate = new Date(((java.util.Date) map.get(UtilityConstants.PLAN_END_DATE)).getTime());
				dmBO.setPlanStartDate(planStartDate);
				dmBO.setPlanEndDate(planEndDate);

			default :
				dmBO.setProposalId(copyInventoryDomainDTO.getNewProposalID());
				dmBO.setCustomerId(copyInventoryDomainDTO.getNewCustomerID());
		}
	}
	
	/** 
	 * To validate the DM to be inserted for Variance proposal
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Aug 23,2004 
	 * Variance MN fix
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @author Saravanan Viswanathan
	 * @param dmBO
	 * @param copyInventoryDomainDTO
	 * @return DMDomainDTO
	 *  
	 */
	private DMDomainDTO validateDMForInsert(DMBO dmBO,CopyInventoryDomainDTO copyInventoryDomainDTO) {
		boolean insertDM = false;
		SWOBOFactory swoBOFactory = new SWOBOFactory();
		EEBOFactory eeBOFactory = new EEBOFactory();
		PriceBOFactory priceBOFactory = new PriceBOFactory();
		SWOBO swoBO = null;
		EEBO eeBO = null;
		PriceBO priceBO = null;
		List storeSWOList = null;
		List storeEEList = null;
		List storePriceList = null;
		DMDomainDTO dmDomainDTO = null;
		try {
			List swoList = new ArrayList();
			swoList = swoBOFactory.findSWOBOForDM(copyInventoryDomainDTO.getOldDMID(),copyInventoryDomainDTO.getOldCustomerID(),copyInventoryDomainDTO.getOldProposalID(),SWOBOFactory.VARIANCE_SWO_TABLE);
			Iterator swoIter = swoList.iterator();
			storeSWOList = new ArrayList();
			while (swoIter.hasNext()) {
				swoBO = (SWOBO) swoIter.next();
				copyInventoryDomainDTO.setOldSWOID(swoBO.getSwoId());
				List eeList = new ArrayList();
				eeList = eeBOFactory.findEEBOForSWO(copyInventoryDomainDTO.getOldProposalID(),copyInventoryDomainDTO.getOldCustomerID(),copyInventoryDomainDTO.getOldDMID(),copyInventoryDomainDTO.getOldSWOID(),EEBOFactory.EE_VARIANCE_TABLE);
				Iterator eeIter = eeList.iterator();
				storeEEList = new ArrayList();
				while (eeIter.hasNext()) {
					eeBO = (EEBO) eeIter.next();
					copyInventoryDomainDTO.setOldEEID(eeBO.getEeId());
					List priceList = new ArrayList();
					//priceList = priceBOFactory.findPriceBOForEE(copyInventoryDomainDTO.getOldEEID(),copyInventoryDomainDTO.getOldSWOID(),copyInventoryDomainDTO.getOldDMID(),copyInventoryDomainDTO.getOldCustomerID(),copyInventoryDomainDTO.getOldProposalID(),PriceBOFactory.VARIANCE_PRICE_TABLE);
					priceList = priceBOFactory.findPriceBOForEEVariance(copyInventoryDomainDTO.getOldEEID(),copyInventoryDomainDTO.getOldSWOID(),copyInventoryDomainDTO.getOldDMID(),copyInventoryDomainDTO.getOldCustomerID(),copyInventoryDomainDTO.getOldProposalID());
					Iterator priceIter = priceList.iterator();
					storePriceList = new ArrayList();
					while (priceIter.hasNext()) {
						priceBO = (PriceBO) priceIter.next();
						if((priceBO.getIIndicator().equals("R") && priceBO.getEswPrice()==0) || priceBO.getIIndicator().equals("D") || priceBO.getIIndicator().equals("S")) {
							continue;
						} else {
							PriceDomainDTO priceDomainDTO = new PriceDomainDTO(priceBO);
							storePriceList.add(priceDomainDTO);
						}
					}
					if(storePriceList != null && storePriceList.size() > 0) {
						EEDomainDTO eeDomainDTO = new EEDomainDTO(eeBO);
						eeDomainDTO.setPriceDTOList(storePriceList);
						storeEEList.add(eeDomainDTO);
					}
				}
				if(storeEEList != null && storeEEList.size() > 0) {
					SWODomainDTO swoDomainDTO = new SWODomainDTO(swoBO);
					swoDomainDTO.setEEDTOList(storeEEList);
					storeSWOList.add(swoDomainDTO);
				}
			}
			if(storeSWOList != null && storeSWOList.size() > 0) {
				dmDomainDTO = new DMDomainDTO(dmBO);
				dmDomainDTO.setSwoDTOList(storeSWOList);
			}
		}
		catch(DomainException de) {
		}
		return dmDomainDTO;
	}	

	/**
	 *  
	 * This method retrieve the DM information 
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
	 * @author Ravishankar
	 * @return DMDomainDTO
	 */
	public DMDomainDTO retrieveDM(DMDomainDTO dmDTO) throws ServiceException {
		DMBOFactory dmBOFactory = null;
		DMBO dmBO = null;
		SWOManagerLocal swoManagerLocal = null;
		List swoDTOList = null;
		dmBOFactory = new DMBOFactory();
		String methodName = "retrieveDM";

		try {
			dmBO = dmBOFactory.getDMBO(dmDTO.getProposalId(), dmDTO.getCustomerId(), dmDTO.getDmId(), DMBOFactory.DM_TABLE);
			if (dmDTO.getActionName() != null && dmDTO.getActionName().equals(ActionNameConstants.CONFIGURE_DM)) {
				swoManagerLocal = getSWOManagerLocal();
				swoDTOList = swoManagerLocal.retrieveSWODetails(dmDTO);
			}
			dmDTO = new DMDomainDTO(dmBO);
			dmDTO.setSwoDTOList(swoDTOList);
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}

		return dmDTO;
	}

	/**
	 *  
	 * This method retrieves the swo eidt information 
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
	 * @return DMDomainDTO
	 * @throws ServiceException
	 */
	public DMDomainDTO retrieveEditSWOInfo(SWODomainDTO swoDomainDTO) throws ServiceException {
		DMBOFactory dmBOFactory = null;
		DMBO dmBO = null;
		DMDomainDTO dmDomainDTO = null;
		dmBOFactory = new DMBOFactory();
		SWOManagerLocal swoManagerLocal = null;
		List swoDomainDTOList = new ArrayList();
		String methodName = "retrieveEditSWOInfo";

		try {
			swoManagerLocal = getSWOManagerLocal();
			dmBO = dmBOFactory.getDMBO(swoDomainDTO.getProposalId(), swoDomainDTO.getCustomerId(), swoDomainDTO.getDmId(), DMBOFactory.DM_TABLE);
			dmDomainDTO = new DMDomainDTO(dmBO);
			swoDomainDTO = swoManagerLocal.retrieveSWOEditInfo(swoDomainDTO);
			swoDomainDTOList.add(swoDomainDTO);
			dmDomainDTO.setSwoDTOList(swoDomainDTOList);
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
		return dmDomainDTO;
	}

	/**
	 *  
	 * This method updates the dm information based on the customer edit information
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerDomainDTO
	 * @throws ServiceException
	 */
	public void updateDMForCustomer(CustomerDomainDTO customerDomainDTO) throws ServiceException {
		DMBOFactory dmFactory = null;
		DMBO dmBO = null;
		List dmBOList = null;
		dmFactory = new DMBOFactory();
		SWOManagerLocal swoManagerLocal = null;
		String methodName = "updateDMForCustomer";
		try {
			dmBOList = dmFactory.findDMBOForCustomer(customerDomainDTO.getProposalId(), customerDomainDTO.getCustomerId(), DMBOFactory.DM_TABLE);
			for (int i = 0; i < dmBOList.size(); i++) {
				dmBO = (DMBO) dmBOList.get(i);
				dmBO.setPlanStartDate(customerDomainDTO.getPlanStartDate());
				dmBO.setPlanEndDate(customerDomainDTO.getPlanEndDate());
				dmFactory.updateDMBO(dmBO, DMBOFactory.DM_TABLE);
			}
			swoManagerLocal = getSWOManagerLocal();
			swoManagerLocal.updateSWOForCustomer(customerDomainDTO);

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}

	}

	/**
	 *  
	 * This method stores the Bump information 
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
	 * @param bumpDMDTO
	 */
	public void storeBumpInfo(DMDomainDTO bumpDMDTO) throws ServiceException {
		DMBOFactory dmBOFactory = null;
		DMBO dmBO = null;
		DMDomainDTO dmDomainDTO = null;
		List swoDomainDTOList = null;
		SWODomainDTO swoDomainDTO = null;
		SWOManagerLocal swoManagerLocal = null;
		HashMap values = null;
		String methodName = "storeBumpInfo";
		OPPTCalender calender=new OPPTCalender();

		try {

			if (bumpDMDTO.getValues().get(UtilityConstants.STATUS) != null && !(bumpDMDTO.getValues().get(UtilityConstants.STATUS).toString().equals(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT))) {
				dmBOFactory = new DMBOFactory();
				dmBO = dmBOFactory.getDMBO(bumpDMDTO.getProposalId(), bumpDMDTO.getCustomerId(), bumpDMDTO.getDmId(), DMBOFactory.DM_TABLE);
				values = new HashMap();
				values.put(UtilityConstants.PLAN_START_DATE, bumpDMDTO.getPlanStartDate());
				values.put(UtilityConstants.PLAN_END_DATE, bumpDMDTO.getPlanEndDate());
				values.put(UtilityConstants.DM_ID, String.valueOf(dmBO.getDmId()));
				try {
					dmBO.validateDMForCopyBump(UtilityConstants.BUSINESSRULE_OTHER_TYPE, values);
				} catch (DomainException d) {
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
					throw ExceptionGenerator.generateServiceException(d.getErrorReport());
				}
				dmDomainDTO = new DMDomainDTO(dmBO);
				dmDomainDTO.setActionName(bumpDMDTO.getActionName());
				swoManagerLocal = getSWOManagerLocal();
				swoDomainDTOList = swoManagerLocal.retrieveSWODetails(dmDomainDTO);
				dmBO.setPlanStartDate(bumpDMDTO.getPlanStartDate());
				dmBO.setPlanEndDate(bumpDMDTO.getPlanEndDate());
				for (int i = 0; i < swoDomainDTOList.size(); i++) {
					swoDomainDTO = (SWODomainDTO) swoDomainDTOList.get(i);
					if(UtilityConstants.SANDS_IND.equals(swoDomainDTO.getSAndSInd())) {
						// S and S License cannot be copy bumped
						continue;
					}
					swoDomainDTO.setDmId(dmBO.getDmId());
					swoDomainDTO.setValues(values);
					swoDomainDTO.setActionName(ActionNameConstants.COPY_BUMP_DM);
				}
				swoManagerLocal.insertBumpLicenseInfo(swoDomainDTOList);

			} else {
				//add error entry and throw the service exception   		
			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}

	/**
	 *  
	 * This method stores the DM information 
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
	public void storeDMInfo(List dmDTOList) throws ServiceException {
		String methodName = "storeDMInfo";
		//TimeTaken log = new //TimeTaken(CLASS_NAME, methodName);
		SWOManagerLocalHome swoManagerLocalHome = null;
		SWOManagerLocal swoManagerLocal = null;
		DMBOFactory dmBOFactory = null;
		DMBO maxDMBO = null;
		DMBO dmBO = null;
		SWODomainDTO swoDomainDTO = null;
		DMDomainDTO dmDTO=null;
		List swoDomainDTOList = null;
		dmBOFactory = new DMBOFactory();
		swoManagerLocal = getSWOManagerLocal();
		int maxDMId=0;

		
		
		try {
			
		 if(dmDTOList!=null && dmDTOList.size()>0){
		 	  for(int k=0;k<dmDTOList.size();k++){  	
				dmDTO=(DMDomainDTO)dmDTOList.get(k);		   
		   	//OPPTLogger.debug("Store dminfo method", CLASS_NAME, methodName);
				List dmBOList = dmBOFactory.findDMBOForDMNo(dmDTO.getDmNo(), dmDTO.getProposalId(), dmDTO.getCustomerId(), DMBOFactory.DM_TABLE);
			//OPPTLogger.debug("Store dminfo method----DMList" + dmBOList, CLASS_NAME, methodName);
			if (dmBOList == null || dmBOList.size() == 0) {
				
				maxDMBO = dmBOFactory.findMaxDMBO(DMBOFactory.DM_TABLE);
				if(maxDMId==0){
					maxDMId=maxDMBO.getDmId();
				}else{
					maxDMId++;
				}
				dmDTO.setDmId(maxDMId+ 1);
				dmBO = populateDMBO(dmDTO);
				dmBO.setDmAddedDate(new Date(new java.util.Date().getTime()));
				dmBOFactory.createDMBO(dmBO, DMBOFactory.DM_TABLE);
				swoDomainDTOList = dmDTO.getSWODTOList();
				if (swoDomainDTOList != null) {
					for (int i = 0; i < swoDomainDTOList.size(); i++) {
						swoDomainDTO = (SWODomainDTO) swoDomainDTOList.get(i);
						swoDomainDTO.setDmId(dmBO.getDmId());
					}
					//OPPTLogger.debug("DM Id in if codtn" + dmBO.getDmId(), CLASS_NAME, methodName);
					swoManagerLocal.storeSWODetails(swoDomainDTOList);
				}
			} else if (dmBOList.size() > 0) {
			
				for (int i = 0; i < dmBOList.size(); i++) {

					dmBO = (DMBO) dmBOList.get(i);
				}
				swoDomainDTOList = dmDTO.getSWODTOList();
				if (swoDomainDTOList != null && swoDomainDTOList.size() > 0) {
					for (int j = 0; j < swoDomainDTOList.size(); j++) {
						swoDomainDTO = (SWODomainDTO) swoDomainDTOList.get(j);
						swoDomainDTO.setDmId(dmBO.getDmId());
					}
					//OPPTLogger.debug("DM Id in else if codtn" + dmBO.getDmId(), CLASS_NAME, methodName);
					swoManagerLocal.storeSWODetails(swoDomainDTOList);
				}
			}
		  }
		 }	
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
		// log.end();
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
	  * @return SWOManagerLocal
	  * @throws ServiceException
	  */
	private SWOManagerLocal getSWOManagerLocal() throws ServiceException {
		SWOManagerLocal swoManagerLocal = null;
		String methodName = "getSWOManagerLocal";
		try {
			swoManagerLocal = HomeProvider.getSWOManagerLocal();
		} catch (CreateException c) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, c);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return swoManagerLocal;
	}

	/**
	 *  
	 * This method stores the Ineligible License information 
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
	public void storeIneligibleLicenseInfo(DMDomainDTO dmDTO) throws ServiceException {
		SWOManagerLocalHome swoManagerLocalHome = null;
		SWOManagerLocal swoManagerLocal = null;
		DMBOFactory dmBOFactory = null;
		DMBO maxDMBO = null;
		DMBO dmBO = null;
		SWODomainDTO swoDomainDTO = null;
		List swoDomainDTOList = null;
		dmBOFactory = new DMBOFactory();
		String methodName = "storeIneligibleLicenseInfo";

		try {
			swoManagerLocal = getSWOManagerLocal();
			List dmBOList = dmBOFactory.findDMBOForDMNo(dmDTO.getDmNo(), dmDTO.getProposalId(), dmDTO.getCustomerId(), DMBOFactory.DM_TABLE);
			if (dmBOList == null || dmBOList.size() == 0) {
				maxDMBO = dmBOFactory.findMaxDMBO(DMBOFactory.DM_TABLE);
				dmDTO.setDmId(maxDMBO.getDmId() + 1);
				dmBO = populateDMBO(dmDTO);
				dmBO.setDmAddedDate(new Date(new java.util.Date().getTime()));
				dmBOFactory.createDMBO(dmBO, DMBOFactory.DM_TABLE);
				swoDomainDTOList = dmDTO.getSWODTOList();
				if (swoDomainDTOList != null) {
					for (int i = 0; i < swoDomainDTOList.size(); i++) {
						swoDomainDTO = (SWODomainDTO) swoDomainDTOList.get(i);
						swoDomainDTO.setDmId(dmBO.getDmId());
					}
					swoManagerLocal.storeIneligibleLicense(swoDomainDTOList);
				}
			} else if (dmBOList.size() > 0) {
				for (int i = 0; i < dmBOList.size(); i++) {

					dmBO = (DMBO) dmBOList.get(i);
				}
				swoDomainDTOList = dmDTO.getSWODTOList();
				if (swoDomainDTOList != null) {
					for (int j = 0; j < swoDomainDTOList.size(); j++) {
						swoDomainDTO = (SWODomainDTO) swoDomainDTOList.get(j);
						swoDomainDTO.setDmId(dmBO.getDmId());
					}
					swoManagerLocal.storeIneligibleLicense(swoDomainDTOList);
				}
			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}

	/**
	 *  
	 * This method stores the Varaince DM information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmDTO
	 * @author Venkat
	 */
	public void storeVarianceInfoForDM(DMDomainDTO dmDTO) throws ServiceException {
		SWOManagerLocalHome swoManagerLocalHome = null;
		SWOManagerLocal swoManagerLocal = null;
		DMBOFactory dmBOFactory = null;
		DMBO maxDMBO = null;
		DMBO dmBO = null;
		SWODomainDTO swoDomainDTO = null;
		List swoDomainDTOList = null;
		dmBOFactory = new DMBOFactory();
		swoManagerLocal = getSWOManagerLocal();
		String methodName = "storeVarianceInfoForDM";
		try {
			List dmBOList = dmBOFactory.findDMBOForDMNo(dmDTO.getDmNo(), dmDTO.getProposalId(), dmDTO.getCustomerId(), DMBOFactory.VARIANCE_DM_TABLE);
			OPPTLogger.debug("Store dminfo method----DMList" + dmBOList, CLASS_NAME, methodName);
			if (dmBOList == null || dmBOList.size() == 0) {
				maxDMBO = dmBOFactory.findMaxDMBO(DMBOFactory.VARIANCE_DM_TABLE);
				dmDTO.setDmId(maxDMBO.getDmId() + 1);
				dmBO = populateDMBO(dmDTO);
				dmBO.setDmAddedDate(new Date(new java.util.Date().getTime()));
				dmBOFactory.createDMBO(dmBO, DMBOFactory.VARIANCE_DM_TABLE);
				swoDomainDTOList = dmDTO.getSWODTOList();
				if (swoDomainDTOList != null) {
					for (int i = 0; i < swoDomainDTOList.size(); i++) {
						swoDomainDTO = (SWODomainDTO) swoDomainDTOList.get(i);
						swoDomainDTO.setDmId(dmBO.getDmId());
					}
					OPPTLogger.debug("DM Id in if codtn" + dmBO.getDmId(), CLASS_NAME, methodName);
					swoManagerLocal.storeVarianceInfoSWO(swoDomainDTOList);
				}
			} else if (dmBOList.size() > 0) {
				for (int i = 0; i < dmBOList.size(); i++) {

					dmBO = (DMBO) dmBOList.get(i);
				}
				swoDomainDTOList = dmDTO.getSWODTOList();
				if (swoDomainDTOList != null && swoDomainDTOList.size() > 0) {
					for (int j = 0; j < swoDomainDTOList.size(); j++) {
						swoDomainDTO = (SWODomainDTO) swoDomainDTOList.get(j);
						swoDomainDTO.setDmId(dmBO.getDmId());
					}
					OPPTLogger.debug("DM Id in else if codtn" + dmBO.getDmId(), CLASS_NAME, methodName);
					swoManagerLocal.storeVarianceInfoSWO(swoDomainDTOList);
				}
			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}

	}

	/**
	 *  
	 * This method updates the DM information 
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
	public void updateDMDetails(DMDomainDTO dmDTO) throws ServiceException {
		DMBOFactory dmBOFactory = null;
		dmBOFactory = new DMBOFactory();
		DMBO dmBO = null;
		Map values = null;
		boolean isUpdate = false;
		SWOManagerLocal swoManagerLocal = null;
		ErrorReport errorReport = new ErrorReport();
		ServiceException se = new ServiceException();
		String methodName = "updateDMDetails";

		try {
			dmBO = populateDMBO(dmDTO);
			if (dmDTO.getActionName().equals(ActionNameConstants.EDIT_INVENTORY_DM)) {
				values = dmDTO.getValues();
				if (values.get(UtilityConstants.STATUS) != null && values.get(UtilityConstants.STATUS).equals("Proposal")) {
					isUpdate = true;
				} else if ((values.get(UtilityConstants.STATUS) != null && values.get(UtilityConstants.STATUS).equals("Contract")) && (values.get(UtilityConstants.STATUS_CODE).equals(ProposalContractStatusConstants.DRAFT_AMENDED_CONTRACT) || values.get(UtilityConstants.STATUS_CODE).equals(ProposalContractStatusConstants.AMENDED_PRICED_CONTRACT))) {
					isUpdate = true;
				}
				if (isUpdate) {
					dmBO = dmBOFactory.getDMBO(dmDTO.getProposalId(), dmDTO.getCustomerId(), dmDTO.getDmId(), DMBOFactory.DM_TABLE);
					dmBO.setPlannedInd(UtilityConstants.YES);
					dmBO.setPlanStartDate(dmDTO.getPlanStartDate());
					dmBO.setPlanEndDate(dmDTO.getPlanEndDate());
					dmBOFactory.updateDMBO(dmBO, DMBOFactory.DM_TABLE);
					swoManagerLocal = getSWOManagerLocal();
					swoManagerLocal.updateSWOForDM(dmDTO);
				} else {
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0110);
				}
			}

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}

	/**
	 *  
	 * This method stores the Configure DM information
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param dmDTO
	 *
	 */
	public void storeConfigureDMInfo(DMDomainDTO dmDTO) throws ServiceException {
		DMBOFactory dmBOFactory = null;
		DMBO dmBO = null;
		List swoDomainDTOList = null;
		SWODomainDTO swoDomainDTO = null;
		SWOManagerLocal swoManagerLocal = null;
		HashMap values = null;
		String methodName = "storeConfigureDMInfo";
		try {

			dmBOFactory = new DMBOFactory();
			dmBO = dmBOFactory.getDMBO(dmDTO.getProposalId(), dmDTO.getCustomerId(), dmDTO.getDmId(), DMBOFactory.DM_TABLE);
			dmBO.setPlanEndDate(OPPTCalender.getDayMinusOneSqlDate(dmDTO.getPlanStartDate()));
			dmBOFactory.updateDMBO(dmBO, DMBOFactory.DM_TABLE);
			dmBO.setDmId(dmBOFactory.findMaxDMBO(DMBOFactory.DM_TABLE).getDmId() + 1);
			dmBO.setPlanStartDate(dmDTO.getPlanStartDate());
			dmBO.setPlanEndDate(dmDTO.getPlanEndDate());
			values = new HashMap();
			values.put(UtilityConstants.PLAN_START_DATE,dmDTO.getPlanStartDate());
			values.put(UtilityConstants.PLAN_END_DATE,dmDTO.getPlanEndDate());
			values.put(UtilityConstants.DM_ID, String.valueOf(dmBO.getDmId()));
			swoManagerLocal = getSWOManagerLocal();
			if(dmBO.getDmNo()!=null){
				String dmNo=null;
				if(dmBO.getDmNo().length()>0){
					if(dmBO.getDmCopyIncrNo()>0){
						dmNo=dmBO.getDmNo().substring(0,dmBO.getDmNo().length()-2);
						dmBO.setDmNo(OPPTHelper.trimString(dmNo)+(dmBO.getDmCopyIncrNo()+1));
					}else{
						dmBO.setDmNo(OPPTHelper.trimString(dmBO.getDmNo())+(dmBO.getDmCopyIncrNo()+1));		
					}
				}
				OPPTLogger.debug("DM No"+dmBO.getDmNo(),CLASS_NAME,methodName);
				dmBO.setDmCopyIncrNo(dmBO.getDmCopyIncrNo()+1);
				OPPTLogger.debug("INCER NO"+dmBO.getDmCopyIncrNo(),CLASS_NAME,methodName);
				dmBO.setPlannedInd(LicenseConstants.LICENSE_PLANNED);
			}
			
			dmBOFactory.createDMBO(dmBO,DMBOFactory.DM_TABLE);

			if (dmDTO != null && dmDTO.getSWODTOList().size() > 0) {
				for (int i = 0; i < dmDTO.getSWODTOList().size(); i++) {
					swoDomainDTO = (SWODomainDTO) dmDTO.getSWODTOList().get(i);
					swoDomainDTO.setActionName(ActionNameConstants.CONFIGURE_DM);
					swoDomainDTO.setValues(values);
				}
				swoManagerLocal.storeConfigSWODetails(dmDTO.getSWODTOList());
			}

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}

	/**
	 *  
	 * This method remove the DM information 
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
	public void removeDMInfo(DMDomainDTO dmDTO) throws ServiceException {
		DMBOFactory dmBOFactory = null;
		DMBO dmBO = null;
		dmBOFactory = new DMBOFactory();
		String methodName = "removeDMInfo";
		dmBO = populateDMBO(dmDTO);
		try {
			dmBOFactory.deleteDMBO(dmBO, DMBOFactory.DM_TABLE);

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}

	/**
	 *  
	 * This method remove the selected licenses 
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
	 * @param swoDomainDTO
	 * @throws ServiceException
	 */
	public void removeLicenses(SWODomainDTO swoDomainDTO) throws ServiceException {
		SWOManagerLocal swoManagerLocal = null;
		swoManagerLocal = getSWOManagerLocal();
		DMBOFactory dmBOFactory = null;
		DMBO dmBO = null;
		DMDomainDTO dmDomainDTO = null;
		dmBOFactory = new DMBOFactory();
		String methodName = "removeLicenses";
		try {
			dmBO = dmBOFactory.getDMBO(swoDomainDTO.getProposalId(), swoDomainDTO.getCustomerId(), swoDomainDTO.getDmId(), DMBOFactory.DM_TABLE);
			dmDomainDTO = new DMDomainDTO(dmBO);
			copyStoreDMHistoryInfo(dmDomainDTO);
			swoManagerLocal.copyStoreSWOHistoryInfo(swoDomainDTO);
			swoManagerLocal.removeLicenses(swoDomainDTO);

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}
	/**
	 *  
	 * This method stores the deleted information in the history table 
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
	 * @throws ServiceException
	 */
	public void copyStoreDMHistoryInfo(DMDomainDTO dmDTO) throws ServiceException {
		DMBOFactory dmBOFactory = null;
		DMBO dmBO = null;
		DMBO historyDMBO = null;
		List dmBOList = null;
		SWODomainDTO swoDomainDTO = null;
		dmBOFactory = new DMBOFactory();
		SWOManagerLocal swoManagerLocal = null;
		swoManagerLocal = getSWOManagerLocal();
		swoDomainDTO = new SWODomainDTO();
		String methodName = "copyStoreDMHistoryInfo";

		if (dmDTO != null && dmDTO.getDmId() != 0) {
			try {

				dmBO = dmBOFactory.getDMBO(dmDTO.getProposalId(), dmDTO.getCustomerId(), dmDTO.getDmId(), DMBOFactory.DM_TABLE);
				dmBO.setLastUpdatedDate(new Date(new java.util.Date().getTime()));
				try {
					historyDMBO = dmBOFactory.getDMBO(dmBO.getProposalId(), dmBO.getCustomerId(), dmBO.getDmId(), DMBOFactory.HISTORY_DM_TABLE);

				} catch (DomainException d) {

					dmBOFactory.createDMBO(dmBO, DMBOFactory.HISTORY_DM_TABLE);
					if (dmDTO.getActionName() != null && dmDTO.getActionName().equals(ActionNameConstants.DELETE_INVENTORY_DM)) {
						swoDomainDTO.setDmId(dmDTO.getDmId());
						swoDomainDTO.setCustomerId(dmDTO.getCustomerId());
						swoDomainDTO.setProposalId(dmDTO.getProposalId());
						swoManagerLocal.copyStoreSWOHistoryInfo(swoDomainDTO);
					}
				}

			} catch (DomainException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}

		} else if (dmDTO != null && dmDTO.getDmId() == 0) {
			try {
				dmBOList = dmBOFactory.findDMBOForCustomer(dmDTO.getProposalId(), dmDTO.getCustomerId(), DMBOFactory.DM_TABLE);
				if (dmBOList != null && dmBOList.size() > 0) {
					for (int i = 0; i < dmBOList.size(); i++) {
						dmBO = (DMBO) dmBOList.get(i);
						dmBO.setLastUpdatedDate(new Date(new java.util.Date().getTime()));
						dmBOFactory.createDMBO(dmBO, DMBOFactory.HISTORY_DM_TABLE);
						swoDomainDTO.setCustomerId(dmBO.getCustomerId());
						swoDomainDTO.setProposalId(dmBO.getProposalId());
						swoDomainDTO.setDmId(dmBO.getDmId());
						swoManagerLocal.copyStoreSWOHistoryInfo(swoDomainDTO);
					}

				}

			} catch (DomainException d) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
				throw ExceptionGenerator.generateServiceException(d.getErrorReport());
			}

		}

	}

	/**
	 *  
	 * This method populate DM Domain DTO from DM BO 
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
	 * @param dmBO
	 * @return DMDomainDTO
	 * @author Ravishankar
	 */
	private DMDomainDTO populateDMDomainDTO(DMDomainDTO dmDomainDTO, DMBO dmBO) {

		dmDomainDTO.setDmId(dmBO.getDmId());
		dmDomainDTO.setCustomerId(dmBO.getCustomerId());
		dmDomainDTO.setProposalId(dmBO.getProposalId());
		dmDomainDTO.setDmAddedDate(dmBO.getDmAddedDate());
		dmDomainDTO.setDmCopyIncrNo(dmBO.getDmCopyIncrNo());
		dmDomainDTO.setDmDesc(dmBO.getDmDesc());
		dmDomainDTO.setDmNo(dmBO.getDmNo());
		dmDomainDTO.setExclusionID(dmBO.getExclusionID());
		dmDomainDTO.setLastUpdatedDate(dmBO.getLastUpdatedDate());
		dmDomainDTO.setPlanEndDate(dmBO.getPlanEndDate());
		dmDomainDTO.setPlannedInd(dmBO.getPlannedInd());
		dmDomainDTO.setPlanStartDate(dmBO.getPlanStartDate());

		return dmDomainDTO;
	}

	/**
		*  
		* This method populates the DM BO from Dm Domain DTO 
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
		* @param dmDomainDTO
		* @return
		*/
	private DMBO populateDMBO(DMDomainDTO dmDomainDTO) {
		DMBO dmBO = null;
		dmBO = new DMBO();
		dmBO.setDmId(dmDomainDTO.getDmId());
		dmBO.setCustomerId(dmDomainDTO.getCustomerId());
		dmBO.setProposalId(dmDomainDTO.getProposalId());
		dmBO.setDmAddedDate(dmDomainDTO.getDmAddedDate());
		dmBO.setDmCopyIncrNo(dmDomainDTO.getDmCopyIncrNo());
		dmBO.setDmDesc(dmDomainDTO.getDmDesc());
		dmBO.setDmNo(dmDomainDTO.getDmNo());
		dmBO.setExclusionID(dmDomainDTO.getExclusionID());
		dmBO.setLastUpdatedDate(dmDomainDTO.getLastUpdatedDate());
		dmBO.setPlanEndDate(dmDomainDTO.getPlanEndDate());
		dmBO.setPlannedInd(dmDomainDTO.getPlannedInd());
		dmBO.setPlanStartDate(dmDomainDTO.getPlanStartDate());
		return dmBO;
	}

	/**
	 *  
	 * This method retrieves the DM for the particular swo
	 * during copy swo usecase 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoDomainDTO
	 * @return DMDomainDTO
	 * @throws ServiceException
	 */

	public DMDomainDTO retrieveSWOInfo(SWODomainDTO swoDomainDTO) throws ServiceException {

		DMDomainDTO dmDomainDTO = null;
		DMBOFactory dmBOFactory = null;
		DMBO dmBO = null;
		dmBOFactory = new DMBOFactory();
		SWOManagerLocal swoManagerLocal = null;
		List swoDTOList = null;
		swoDTOList = new ArrayList();
		String methodName = "retrieveSWOInfo";

		try {

			dmBO = dmBOFactory.getDMBO(swoDomainDTO.getProposalId(), swoDomainDTO.getCustomerId(), swoDomainDTO.getDmId(), DMBOFactory.DM_TABLE);
			dmDomainDTO = new DMDomainDTO(dmBO);
			swoManagerLocal = getSWOManagerLocal();
			swoDomainDTO = swoManagerLocal.retrieveSWOEditInfo(swoDomainDTO);
			swoDTOList.add(swoDomainDTO);
			dmDomainDTO.setSwoDTOList(swoDTOList);

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}

		return dmDomainDTO;
	}

	/**
	 *  
	 * This method replace or skip the license based on the selection made by the user 
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
	 * @throws ServiceException
	 */
	public void repalceSkipLicenses(DMDomainDTO dmDTO) throws ServiceException {
		String methodName="replaceSkipLicenses";
		//TimeTaken log = new //TimeTaken(CLASS_NAME, methodName);
		SWOManagerLocalHome swoManagerLocalHome = null;
		SWOManagerLocal swoManagerLocal = null;
		DMBOFactory dmBOFactory = null;
		DMBO maxDMBO = null;
		DMBO dmBO = null;
		SWODomainDTO swoDomainDTO = null;
		List swoDomainDTOList = null;
		dmBOFactory = new DMBOFactory();
		swoManagerLocal = getSWOManagerLocal();
		try {
			List dmBOList = dmBOFactory.findDMBOForDMNo(dmDTO.getDmNo(), dmDTO.getProposalId(), dmDTO.getCustomerId(), DMBOFactory.DM_TABLE);
			if (dmBOList == null ||dmBOList.size()==0) {
				maxDMBO = dmBOFactory.findMaxDMBO(DMBOFactory.DM_TABLE);
				dmDTO.setDmId(maxDMBO.getDmId() + 1);
				dmBO = populateDMBO(dmDTO);
				dmBOFactory.createDMBO(dmBO, DMBOFactory.DM_TABLE);
				swoDomainDTOList = dmDTO.getSWODTOList();
				if (swoDomainDTOList != null && swoDomainDTOList.size() > 0) {
					for (int i = 0; i < swoDomainDTOList.size(); i++) {
						swoDomainDTO = (SWODomainDTO) swoDomainDTOList.get(i);
						swoDomainDTO.setDmId(dmBO.getDmId());
					}
					swoManagerLocal.replaceSkipLicenses(swoDomainDTOList);
				}
			} else if (dmBOList != null && dmBOList.size() >= 1) {
				for (int i = 0; i < dmBOList.size(); i++) {
					dmBO = (DMBO) dmBOList.get(i);
				}
				swoDomainDTOList = dmDTO.getSWODTOList();
				if (swoDomainDTOList != null) {
					for (int j = 0; j < swoDomainDTOList.size(); j++) {
						swoDomainDTO = (SWODomainDTO) swoDomainDTOList.get(j);
						swoDomainDTO.setDmId(dmBO.getDmId());
					}
					swoManagerLocal.replaceSkipLicenses(swoDomainDTOList);
				}

			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	// log.end();	
	}

	/**
	 *  
	 * This method retrieves the dm for customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerDomainDTO
	 * @return
	 * @throws ServiceException
	 */
	public CustomerDomainDTO retrieveDMForCustomer(CustomerDomainDTO customerDomainDTO) throws ServiceException {
		DMBOFactory dmFactory = null;
		dmFactory = new DMBOFactory();
		DMDomainDTO dmDomainDTO = null;
		List dmBOList = null;
		DMBO dmBO = null;
		List dmDTOList = new ArrayList();
		String methodName = "retrieveDMForCustomer";

		try {
			dmBOList = dmFactory.findDMBOForCustomer(customerDomainDTO.getProposalId(), customerDomainDTO.getCustomerId(), DMBOFactory.DM_TABLE);
			if (dmBOList != null && dmBOList.size() > 0) {
				for (int i = 0; i < dmBOList.size(); i++) {
					dmBO = (DMBO) dmBOList.get(i);
					dmDomainDTO = new DMDomainDTO(dmBO);
					dmDTOList.add(dmDomainDTO);
				}
			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
		customerDomainDTO.setDMDTOList(dmDTOList);

		return customerDomainDTO;
	}

	/** 
	 * Deletes variance inventory
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
	public void deleteVarianceDM(ProposalDomainDTO proposal) throws ServiceException {
		DMBOFactory factory = null;

		if (proposal != null) {
			try {
				factory = new DMBOFactory();
				factory.deleteVarianceDM(proposal.getProposalId());
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "DMManagerBean", "deleteVarianceDM", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
	}
	
	/** 
	 * Gets DM for copy inventory
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
	 * @param customerDomainDTO
	 * @return customerDomainDTO
	 * @throws ServiceException 
	 */
	public CustomerDomainDTO retrieveDMForCopyInventory(CustomerDomainDTO customerDomainDTO)throws ServiceException {
		DMBOFactory dmFactory = new DMBOFactory();
		DMDomainDTO dmDomainDTO = null;
		List dmBOList = new ArrayList();
		List dmDTOList = new ArrayList();
		DMBO dmBO = null;
		try {
			if(ActionNameConstants.CREATE_VARIANCEPROPOSAL.equalsIgnoreCase(customerDomainDTO.getActionName())) {
				dmBOList = dmFactory.findDMBOForCustomer(customerDomainDTO.getProposalId(), customerDomainDTO.getCustomerId(), DMBOFactory.VARIANCE_DM_TABLE);
			}else{
				dmBOList = dmFactory.findDMBOForCustomer(customerDomainDTO.getProposalId(), customerDomainDTO.getCustomerId(), DMBOFactory.DM_TABLE);
			}
			if (dmBOList != null && dmBOList.size() > 0) {
				for (int i = 0; i < dmBOList.size(); i++) {
					dmBO = (DMBO) dmBOList.get(i);
					dmDomainDTO = new DMDomainDTO(dmBO);
					dmDomainDTO.setActionName(customerDomainDTO.getActionName());
					if (ActionNameConstants.REPLACE_CONTRACT.equalsIgnoreCase(customerDomainDTO.getActionName()) || 
						ActionNameConstants.CREATE_VARIANCEPROPOSAL.equalsIgnoreCase(customerDomainDTO.getActionName())) {
							dmDomainDTO.setPlanStartDate(customerDomainDTO.getPlanStartDate());
							dmDomainDTO.setPlanEndDate(customerDomainDTO.getPlanEndDate());
					}
					dmDomainDTO = getSWOManagerLocal().retrieveSWOForCopyInventory(dmDomainDTO);
					dmDTOList.add(dmDomainDTO);
				}
			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "retrieveDMForCopyInventory", null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
		customerDomainDTO.setDMDTOList(dmDTOList);
		return customerDomainDTO;
	}
	
	/**
	 * getSessionContext
	 * @return SessionContext
	 */
	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
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

}