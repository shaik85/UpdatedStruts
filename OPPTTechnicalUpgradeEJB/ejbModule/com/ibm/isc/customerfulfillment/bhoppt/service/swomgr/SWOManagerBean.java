/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.swomgr;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/**
 *  
 * This manager class delegates the SWOInfo call
 * Process the SWO,EE,Price Information 
  
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

public class SWOManagerBean implements javax.ejb.SessionBean {
	private final String SWO_INFO_LOCAL_HOME = "SWOInfoLocalHome";

	private javax.ejb.SessionContext mySessionCtx;

	private final String CLASS_NAME = "SWOManagerBean";
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
		getSWOInfoLocal().copyInventory(copyInventoryDomainDTO);
	}

	/**
	 * To copy the inventory for the variance proposal  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Aug 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param copyInventoryDomainDTO
	 * @throws ServiceException
	 * Method added by Sara on 23 Aug 2004, for copying variance proposal
	 */
	public void copyInventory(DMDomainDTO dmDomainDTO,CopyInventoryDomainDTO copyInventoryDomainDTO) throws ServiceException {
		getSWOInfoLocal().copyInventory(dmDomainDTO,copyInventoryDomainDTO);
	}
	/**
	 *  
	 * This method retrieve swo details based on the dm information 
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
	 * @return SWODomainDTO
	 */
	public List retrieveSWODetails(DMDomainDTO dmDTO) throws ServiceException {
		List swoDomainDTOList = null;
		SWOInfoLocal swoInfoLocal = null;
		SWODomainDTO swoDomainDTO = null;
		swoDomainDTO = new SWODomainDTO();
		swoDomainDTO.setDmId(dmDTO.getDmId());
		swoDomainDTO.setCustomerId(dmDTO.getCustomerId());
		swoDomainDTO.setProposalId(dmDTO.getProposalId());
		swoDomainDTO.setActionName(dmDTO.getActionName());
		swoInfoLocal = getSWOInfoLocal();
		swoDomainDTOList = swoInfoLocal.retrieveSWODetails(swoDomainDTO);

		return swoDomainDTOList;
	}

	/**
	 *  
	 * This method stores the SWO information 
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
	 * @param swoDTOList
	 */
	public void storeSWODetails(List swoDTOList) throws ServiceException {
		SWOInfoLocal swoInfoLocal = null;
		swoInfoLocal = getSWOInfoLocal();
			swoInfoLocal.storeSWOInfo(swoDTOList);
		
	}

	/**
	 *  
	 * This method retrieves the SWO edit information 
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
	 * @return SWODomainDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public SWODomainDTO retrieveSWOEditInfo(SWODomainDTO swoDomainDTO) throws ServiceException {
		SWOInfoLocal swoInfoLocal = null;
		swoInfoLocal = getSWOInfoLocal();
		swoDomainDTO = swoInfoLocal.retrieveSWOInformation(swoDomainDTO);
		return swoDomainDTO;
	}

	/**
	 *  
	 * This method returns SWOInfo Local Object 
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
	private SWOInfoLocal getSWOInfoLocal() throws ServiceException {
		SWOInfoLocalHome swoInfoLocalHome = null;
		SWOInfoLocal swoInfoLocal = null;
		swoInfoLocalHome = getSWOInfoLocalHome();
		String methodName = "getSWOInfoLocal";
		try {
			swoInfoLocal = swoInfoLocalHome.create();
		} catch (CreateException c) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, c);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return swoInfoLocal;
	}
	/**
	 *  
	 * This method stores the bump information 
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
	 * @param bumpSWODTO
	 */
	public void insertBumpLicenseInfo(List bumpSWODTOList) throws ServiceException {
		String methodName="insertBumpLicenseInfo";
		SWOInfoLocal swoInfoLocal = null;
		SWODomainDTO swoDomainDTO = null;
		swoInfoLocal = getSWOInfoLocal();
		OPPTCalender calendar=new OPPTCalender();

		for (int i = 0; i < bumpSWODTOList.size(); i++) {
			swoDomainDTO = (SWODomainDTO) bumpSWODTOList.get(i);
			swoInfoLocal.insertBumpSwoInfo(swoDomainDTO);	
			if (swoDomainDTO.getActionName() != null && swoDomainDTO.getActionName().equals(ActionNameConstants.COPY_BUMP_DM)) {
				swoDomainDTO.setDmId(Integer.parseInt(swoDomainDTO.getValues().get(UtilityConstants.DM_ID).toString()));
				Date dmBumpStartDate = (Date) swoDomainDTO.getValues().get(UtilityConstants.PLAN_START_DATE);
				OPPTLogger.debug("DM Bump start date"+dmBumpStartDate,CLASS_NAME,methodName);
				Date dmBumpEndDate = (Date) swoDomainDTO.getValues().get(UtilityConstants.PLAN_END_DATE);
				OPPTLogger.debug("DM Bump end date"+dmBumpEndDate,CLASS_NAME,methodName);
				boolean isDeleted = false;
				if (calendar.isDateGreater(swoDomainDTO.getPlanStartDate(),dmBumpStartDate) || calendar.isDateEqual(swoDomainDTO.getPlanStartDate(),dmBumpStartDate)) {	
					if (swoDomainDTO.getBumpInd() != null && swoDomainDTO.getBumpInd().startsWith(LicenseConstants.LICENSE_BUMPED)) {
						isDeleted=true;
						String maxBumpInd = getMaxBumpInd(bumpSWODTOList, swoDomainDTO);
						if (swoDomainDTO.getBumpInd().equals(LicenseConstants.LICENSE_BUMPED) || (maxBumpInd != null && swoDomainDTO.getBumpInd().equals(maxBumpInd))) {
								isDeleted = false;
							if(maxBumpInd != null && swoDomainDTO.getBumpInd().equals(maxBumpInd)){
								isDeleted=true;
								swoDomainDTO.setPlanStartDate(dmBumpStartDate);		
							}							
						}
					}
				}
				
				if(calendar.isDateGreater(swoDomainDTO.getPlanEndDate(),dmBumpStartDate)){
					if (swoDomainDTO.getBumpInd() != null && swoDomainDTO.getBumpInd().startsWith(LicenseConstants.LICENSE_BUMPED)) {
						String maxBumpInd = getMaxBumpInd(bumpSWODTOList, swoDomainDTO);
						if (swoDomainDTO.getBumpInd().equals(LicenseConstants.LICENSE_BUMPED) || (maxBumpInd != null && swoDomainDTO.getBumpInd().equals(maxBumpInd))) {
								swoDomainDTO.setPlanEndDate(OPPTCalender.getDayMinusOneSqlDate(dmBumpStartDate));		
						}else{
								swoDomainDTO.setPlanEndDate(OPPTCalender.getDayMinusOneSqlDate(dmBumpStartDate));							
						}
					}else{
						swoDomainDTO.setPlanEndDate(OPPTCalender.getDayMinusOneSqlDate(dmBumpStartDate));	
					}
				}
				
				if (isDeleted) {
					  swoInfoLocal.removeLicenses(swoDomainDTO);
					  continue;
				}
			}
		  swoInfoLocal.updateSWOEditInfo(swoDomainDTO);
		}			
	}
	/**
	 *  
	 * This gets the maximum bump indicator
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
	 * @param bumpSWODTO
	 */
	private String getMaxBumpInd(List swoDTOList, SWODomainDTO swoDomainDTO) {
		SWODomainDTO maxSWO = null;
		String maxBumpInd = null;
		if (swoDTOList != null && swoDTOList.size() > 0) {
			maxSWO = (SWODomainDTO) swoDTOList.get(0);
			SWODomainDTO temp;
			int tempVal = 0;
			int maxVal = 0;
			for (int i = 1; i < swoDTOList.size(); i++) {
				temp = (SWODomainDTO) swoDTOList.get(i);
				if (temp != null) {
					if (temp.getBumpInd() != null && temp.getBumpInd().length() > 1) {
						tempVal = Integer.parseInt(temp.getBumpInd().substring(1));
					}

				}
				if (maxSWO != null) {
					if (maxSWO.getBumpInd() != null && maxSWO.getBumpInd().length() > 1) {
						maxVal = Integer.parseInt(maxSWO.getBumpInd().substring(1));
					}

				}
				if (tempVal > maxVal) {
					maxSWO = temp;
				}
			}
		}
		return maxSWO.getBumpInd();
	}

	/**
	 *  
	 * This method checks whether licenses are already pulled or not 
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
	 * @param swoDomainDTO
	 * @return
	 * @throws ServiceException
	 */
	public boolean verifyLicenseAreExists(SWODomainDTO swoDomainDTO) throws ServiceException {
		boolean isLicenseExists = false;
		SWOInfoLocal swoInfoLocal = null;
		swoInfoLocal = getSWOInfoLocal();
		isLicenseExists = swoInfoLocal.verifyLicensesAreExists(swoDomainDTO);
		return isLicenseExists;
	}

	/**
	 *  
	 * This method stores the Variance SWO information 
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
	 * @param swoDTOList
	 */
	public void storeVarianceInfoSWO(List swoDTOList) throws ServiceException {
		SWOInfoLocal swoInfoLocal = null;
		SWODomainDTO swoDomainDTO = null;
		Iterator iterate = swoDTOList.iterator();
		swoInfoLocal = getSWOInfoLocal();
		while (iterate.hasNext()) {
			swoDomainDTO = (SWODomainDTO) iterate.next();
			swoInfoLocal.storeVarianceInfoSWO(swoDomainDTO);
		}
	}

	/**
	 *  
	 * This method retrieve the variance information from temp table 
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
	 * @return
	 */
	public DMDomainDTO retrieveVarianceForSWO(DMDomainDTO dmDTO) {
		return null;
	}

	/**
	 *  
	 * This method stores the ineligible license information 
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
	 * @param swoDTO
	 */
	public void storeIneligibleLicense(List swoDTOList) throws ServiceException {
		String methodName="storeIneligibleLicense";
		SWOInfoLocal swoInfoLocal = null;
		SWODomainDTO swoDomainDTO = null;
		swoInfoLocal = getSWOInfoLocal();
		//OPPTLogger.debug("Selected swo list"+swoDTOList.size(),CLASS_NAME,methodName);
		Iterator iterateSWO = swoDTOList.iterator();
		while (iterateSWO.hasNext()) {
			swoDomainDTO = (SWODomainDTO) iterateSWO.next();
			OPPTLogger.debug("SWO Domain Info-- "+"DM Id:" + swoDomainDTO.getDmId() + "Customer Id:" + swoDomainDTO.getCustomerId() + "Proposal Id:" + swoDomainDTO.getProposalId() + "Equp No:" + swoDomainDTO.getEquipmentNo(), CLASS_NAME, methodName);
			swoInfoLocal.storeIneligibleLicenses(swoDomainDTO);
		}
	}

	/**
	 *  
	 * This method removes the selected licenses 
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
	 * @param swoDTO
	 */
	public void removeLicenses(SWODomainDTO swoDTO) throws ServiceException {
		SWOInfoLocal swoInfoLocal = null;
		swoInfoLocal = getSWOInfoLocal();
		swoInfoLocal.removeLicenses(swoDTO);
	}

	/**
	 *  
	 * This method updates the license information, edited as part of edit customer 
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
	 * @param swoDTO
	 */
	public void updateSWOForCustomer(CustomerDomainDTO customerDTO) throws ServiceException {
		SWOInfoLocal swoInfoLocal = null;
		swoInfoLocal = getSWOInfoLocal();
		swoInfoLocal.updateSWOForCustomer(customerDTO);
	}

	/**
	 *  
	 * This method updates the SWO for DM 
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
	public void updateSWOForDM(DMDomainDTO dmDTO) throws ServiceException {
		SWOInfoLocal swoInfoLocal = null;
		swoInfoLocal = getSWOInfoLocal();
		swoInfoLocal.updateSWOForDM(dmDTO);
	}

	/**
	 *  
	 * This method copy and store swo information, its deleted as part of delete inventory 
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
	 * @param swoDTO
	 */
	public void copyStoreSWOHistoryInfo(SWODomainDTO swoDTO) throws ServiceException {
		SWOInfoLocal swoInfoLocal = null;
		swoInfoLocal = getSWOInfoLocal();
		swoInfoLocal.copyStoreInfo(swoDTO);
	}

	/**
	 *  
	 * This method stores EE Configuration information 
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
	public void storeEEConfigInfo(TempEEDomainDTO tempEEDTO) throws ServiceException {
		SWOInfoLocal swoInfoLocal = null;
		swoInfoLocal = getSWOInfoLocal();
		swoInfoLocal.storeEEConfigInfo(tempEEDTO);

	}

	/**
	 *  
	 * This method stores the defaulted configuration information 
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
	 * @param swoDTO
	 */
	public void storeConfigSWODetails(List swoDTOList) throws ServiceException {
		String methodName="storeConfigSWODetails";
		SWOInfoLocal swoInfoLocal = null;
		swoInfoLocal = getSWOInfoLocal();
		SWODomainDTO swoDomainDTO = null;
		SWODomainDTO oldSWODomainDTO=null;
		List swoDomainDTOList=null;
		List eeDomianDTOList=null;
		
		if (swoDTOList != null) {
			for (int i = 0; i < swoDTOList.size(); i++) {
				swoDomainDTO = (SWODomainDTO) swoDTOList.get(i);
				Date dmBumpStartDate = (Date) swoDomainDTO.getValues().get(UtilityConstants.PLAN_START_DATE);
				OPPTLogger.debug("DM Bump start date"+dmBumpStartDate,CLASS_NAME,methodName);
				Date dmBumpEndDate = (Date) swoDomainDTO.getValues().get(UtilityConstants.PLAN_END_DATE);
				swoDomainDTOList=swoInfoLocal.retrieveSWODetails(swoDomainDTO);
				if(swoDomainDTOList!=null && swoDomainDTOList.size()>0){
					for(int j=0;j<swoDomainDTOList.size();j++){
						oldSWODomainDTO=(SWODomainDTO)swoDomainDTOList.get(j);
						oldSWODomainDTO.setPlanEndDate(OPPTCalender.getDayMinusOneSqlDate(dmBumpStartDate));
						oldSWODomainDTO.setCalcPrice(0.0);
						oldSWODomainDTO.setActionName(ActionNameConstants.CONFIGURE_DM);
						if(oldSWODomainDTO.getEEDTOList()!=null && oldSWODomainDTO.getEEDTOList().size()>0){
							eeDomianDTOList=oldSWODomainDTO.getEEDTOList();	
						 	for(int k=0;k<eeDomianDTOList.size();k++){
						 		EEDomainDTO eeDomainDTO=(EEDomainDTO)eeDomianDTOList.get(k);
						 		eeDomainDTO.setPlanStartDate(oldSWODomainDTO.getPlanStartDate());
						 		eeDomainDTO.setPlanEndDate(oldSWODomainDTO.getPlanEndDate());
						 	}
						}	
						swoInfoLocal.updateSWOInfo(oldSWODomainDTO);	
					}
				}	
				swoInfoLocal.storeSWOConfigInfo(swoDomainDTO);
			}
		}
	}

	/**
	 *  
	 * This method removes the Configuration details(During 
	 * Cancel ConfigureDM functionality 
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
	public void removeConfigurationDetails(TempEEDomainDTO tempEEDomainDTO) throws ServiceException {
		SWOInfoLocal swoInfoLocal = null;
		swoInfoLocal = getSWOInfoLocal();
		swoInfoLocal.removeConfigurationInfo(tempEEDomainDTO);
	}

	/**
	@param priceProposalDTO
	@roseuid 3FB46EBC00FE
		*/
	public void calculateSWOPrice(PriceProposalDomainDTO priceProposalDTO) {

	}

	/**
	 *  
	 * This method skip or replace the licenses based on the selection made by the user 
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
	 * @param swoDTO
	 */
	public void replaceSkipLicenses(List swoDTOList) throws ServiceException {
		String methodName="replaceSkipLicenses";
		//TimeTaken log = new //TimeTaken(CLASS_NAME, methodName);
		SWOInfoLocal swoInfoLocal = null;
		SWODomainDTO swoDomainDTO = null;
		swoInfoLocal = getSWOInfoLocal();
		boolean isExist=false;
		List swoDomainDTOList = null;
		
		if (swoDTOList != null && swoDTOList.size() > 0) {
			for (int i = 0; i < swoDTOList.size(); i++) {
				swoDomainDTO = (SWODomainDTO) swoDTOList.get(i);
				isExist=swoInfoLocal.verifyLicensesAreExists(swoDomainDTO);
				 if(isExist){
					if (UtilityConstants.NO.equals(swoDomainDTO.getSkipOption())){
						swoDomainDTO.setDeltaFetchId(LicenseConstants.LICENSE_DELTAFETCH);
						swoDomainDTO.setActionName(ActionNameConstants.DELTA_FETCH);
						swoInfoLocal.updateSWOInfo(swoDomainDTO);
					}
			 	}else{
					swoDomainDTO.setDeltaFetchId(LicenseConstants.LICENSE_DELTAFETCH);
					swoDomainDTOList=new ArrayList();
					swoDomainDTOList.add(swoDomainDTO);
					swoInfoLocal.storeSWOInfo(swoDomainDTOList);
				 }	
			}
		} 
	// log.end();		 		
	}
	/**
	 * This method is used for pricing
	 * and it retrieves all swo,ee and price DOT's
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param priceProposalDomainDTO
	 * @return
	 * @throws ServiceException
	 */
	public PriceProposalDomainDTO retrieveSWODetailsForPricing(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException {

		SWOInfoLocal swoInfoLocal = getSWOInfoLocal();
		return swoInfoLocal.retrieveSWODetailsForPricing(priceProposalDomainDTO);

	}

	/**
	 * Check if SVC License OR Quote is present for a Proposal.
	 * Check needs to be done before a Proposal can be send for Registration
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
	 * @throws ServiceException
	 * @author Prakash Mall
	 */

	public boolean chkSVCLicense(int ProposalID, String transactionName) throws ServiceException {

		String methodName="chkSVCLicense";
		boolean exist = false;
		SWOInfoLocal swoInfoLocal = null;

		try {
			swoInfoLocal = getSWOInfoLocal();
		} catch (ServiceException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
		}

		exist = swoInfoLocal.chkSVCLicense(ProposalID, transactionName);
		return exist;
	}

	/**
	 * Check if Proposal contains SandS Licenses. 
	 * Check needs to be done before a Proposal can be send for Registration
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date March 9th 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @author Prakash Mall
	 */

	public boolean chkSandSLicense(int ProposalID, String flag) throws ServiceException {

		String methodName="chkSandSLicense";
		boolean exist = false;
		SWOInfoLocal swoInfoLocal = null;

		try {
			swoInfoLocal = getSWOInfoLocal();
		} catch (ServiceException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
		}

		exist = swoInfoLocal.chkSandSLicense(ProposalID, flag);
		return exist;
	}

	
	
	
	public String chkSWOExternalCntrNumber(int proposalId) throws ServiceException {
		
		String methodName="chkSWOExternalCntrNumber";
		String messageString = OPPTHelper.getLogString(String.valueOf(proposalId));		
		OPPTLogger.log("PROPOSAL_ID", OPPTLogger.DEBUG, CLASS_NAME, "chkSWOExternalCntrNumber", messageString);


		SWOInfoLocal swoInfoLocal = null;

		try {
			swoInfoLocal = getSWOInfoLocal();
		} catch (ServiceException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
		}
		String swoExtCntrNum = swoInfoLocal.chkSWOExternalCntrNumber(proposalId);
		return swoExtCntrNum;
	}	

	/** 
	 * Validate and Populate SWO BO's for StatusCheck
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
	 * @return SWOInfoLocalHome
	 */

	public SWODomainDTO validateAndPopulateSWOForStatusCheck(SWODomainDTO swoDomainDTO) throws ServiceException {
		String methodName = "validateAndPopulateSWOForStatusCheck";
		try {
			SWOInfoLocal swoInfoLocal = HomeProvider.getSWOinfoLocal();
			swoDomainDTO = swoInfoLocal.validateAndPopulateForStatusCheck(swoDomainDTO);
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return swoDomainDTO;
	}

	/**
	 * getSessionContext
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

	/** 
	 * To get the swo info local home
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
	 * @return SWOInfoLocalHome
	 */
	private SWOInfoLocalHome getSWOInfoLocalHome() {
		return (SWOInfoLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(SWO_INFO_LOCAL_HOME);
	}

	/** 
	 * Delegates the call to remove the SVC Licenses of the proposal
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
	 * @param proposalDTO
	 * @throws ServiceException 
	 */
	public void removeSVCLicenses(ProposalDomainDTO proposalDTO) throws ServiceException {
		SWOInfoLocal swoInfo = null;
		swoInfo = getSWOInfoLocal();
		swoInfo.removeSVCLicenses(proposalDTO);
	}

	/** 
	 * Exclude/Include SWOs for special pricing
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
	 * @return boolean
	 * @throws ServiceException 
	 */
	public boolean excludeIncludeSWO(SWODomainDTO[] licenses) throws ServiceException {
		boolean result = false;
		SWOInfoLocal swoLocal = getSWOInfoLocal();
		if (licenses != null) {
			for (int i = 0; i < licenses.length; i++) {
				boolean executeResult = swoLocal.updateSWOForExcludeInclude(licenses[i]);
				if (!result) {
					result = executeResult;
				}
			}
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "SWOManagerBean", "excludeIncludeSWO", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return result;
	}

	/** 
	 * Exclude/include licenses of a DM for special pricing
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
	 * @param machine
	 * @return boolean
	 * @throws ServiceException 
	 */
	public boolean excludeIncludeSWOsOfDM(DMDomainDTO machine) throws ServiceException {
		SWOInfoLocal swoLocal = getSWOInfoLocal();
		if (machine != null) {
			return swoLocal.updateSWOsOfDMForExcludeInclude(machine);
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "SWOManagerBean", "excludeIncludeSWOsOfDM", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
	}

	/** 
	 * Exclude/Include licenses of a customer for Special pricing
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
	 * @param customer
	 * @return boolean
	 * @throws ServiceException 
	 */
	public boolean excludeIncludeSWOsOfCustomer(CustomerDomainDTO customer) throws ServiceException {
		SWOInfoLocal swoLocal = getSWOInfoLocal();
		if (customer != null) {
			return swoLocal.updateSWOsOfCustomerForExcludeInclude(customer);
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "SWOManagerBean", "excludeIncludeSWOsOfCustomer", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
	}

	/** 
	 * Retrieves the details of liceneses
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
		SWOInfoLocal swoInfo = null;

		if (licenses != null && licenses.length > 0) {
			swoInfo = getSWOInfoLocal();
			for (int i = 0; i < licenses.length; i++) {
				licenses[i] = swoInfo.retrieveSWOInformation(licenses[i]);
			}
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "SWOManagerBean", "retrieveSWODetails", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return licenses;
	}

	/**
	 *  
	 * This method retrieves the EE Configuration information from Temp table 
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
		SWOInfoLocal swoInfoLocal = null;
		try {
			swoInfoLocal = HomeProvider.getSWOinfoLocal();
			tempEEDomainDTO = swoInfoLocal.retrieveEEConfigInfoFromTemp(tempEEDomainDTO);

		} catch (CreateException c) {
			throw new ServiceException();
		}
		return tempEEDomainDTO;
	}
	/** 
	 * Updates the details of licenses
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
	 * @throws ServiceException 
	 */
	public void updateSWODetails(SWODomainDTO[] licenses) throws ServiceException {
		SWOInfoLocal swoInfo = null;
		boolean changeSWOPlan = false;
		boolean changeSWOAndEE = false;

		String actionName = licenses[0].getActionName();
		OPPTLogger.debug("Action Name : "+actionName,CLASS_NAME,"updateSWODetails");

		if (licenses != null && licenses.length > 0) {
			swoInfo = getSWOInfoLocal();
			if (ActionNameConstants.EDIT_INVENTORY_SWO.equals(actionName) || ActionNameConstants.SUBMIT_AMEND_SWO.equals(actionName)) {
				changeSWOPlan = true;
			} else
				if (ActionNameConstants.CHANGE_SWODETAILS.equals(actionName)) {
					changeSWOAndEE = true;
				}
			for (int i = 0; i < licenses.length; i++) {
				if (changeSWOPlan) {
					swoInfo.updateSWOEditInfo(licenses[i]);
				} else {
					swoInfo.updateSWOInfo(licenses[i]);
				}
			}
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "SWOManagerBean", "updateSWODetails", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
	}
	public void updateESWPriceForVarianceProposal(ProposalDomainDTO proposalDomainDTO) throws ServiceException {
		SWOInfoLocal swoInfoLocal = null;

		try {
			swoInfoLocal = HomeProvider.getSWOinfoLocal();
		} catch (CreateException e) {
			// TODO Auto-generated catch block
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		swoInfoLocal.updateESWPriceForVarianceProposal(proposalDomainDTO);
	}

	/** 
		 * Delegates the call to remove the Quotes of the proposal
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
		 * @param proposalDTO
		 * @throws ServiceException
		 * @author Saravanan Viswanathan
		 */
	public boolean removeQuotes(ProposalDomainDTO proposalDTO) throws ServiceException {
		SWOInfoLocal swoInfo = null;
		boolean resultvalue = false;
		swoInfo = getSWOInfoLocal();
		resultvalue = swoInfo.removeQuotes(proposalDTO);
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
		SWOInfoLocal swoInfo = getSWOInfoLocal();
		return swoInfo.fetchSAndSDetails(dmDomainDTOList, swoDomainDTOList);
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
		SWOInfoLocal swoInfo = getSWOInfoLocal();
		swoInfo.applySAndSDiscount(eeDomainDTOArray, sAndSDiscount);
	}
	
	public DMDomainDTO retrieveSWOForCopyInventory(DMDomainDTO dmDomainDTO) throws ServiceException {
		SWOInfoLocal swoInfo = getSWOInfoLocal();
		return swoInfo.retrieveSWOForCopyInventory(dmDomainDTO);
		
	}
}
