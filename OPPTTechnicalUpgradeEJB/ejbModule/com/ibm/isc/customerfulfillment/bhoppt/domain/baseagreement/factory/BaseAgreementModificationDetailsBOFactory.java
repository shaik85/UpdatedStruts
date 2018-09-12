/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationConstants;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.BaseAgreementModificationDetailsBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/** 
 * This factory class returns BaseAgreementModificationDetailsBO objects
 * based on the arguments it returns Collection of BO or single BO
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jun 14, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Sasi R Challa
 * @version CBS 2.1
 */
public class BaseAgreementModificationDetailsBOFactory {
	
	//private static final String BASE_AGREEMENT_MOD_DETAILS_LOCAL_HOME = "BaseAgreementModificationDetailsLocalHome";
	
	/**
	 * getBAModificationDetailsBO
     * @param agreementId
     * @param modificationTypeCode
     * @throws com.ibm.support.oppt.projectutilities.exception.DomainException
     * @return
     * @author Sudharsan Reddy
     */
    public BaseAgreementModificationDetailsBO getBAModificationDetailsBO(int agreementId, String modificationTypeCode) throws DomainException
	{
		BaseAgreementModificationDetailsBO baModificationDetailsBO = new BaseAgreementModificationDetailsBO();
		BaseAgreementModificationDetailsLocalHome baModificationDetailsHome = getBaseAgreementModificationLocalHome();
		BaseAgreementModificationDetailsKey baModificationDetailsKey = new BaseAgreementModificationDetailsKey(new Integer(agreementId),modificationTypeCode);
		BaseAgreementModificationDetailsLocal baModificationDetailsLocal = null;
		try
		{
			baModificationDetailsLocal = baModificationDetailsHome.findByPrimaryKey(baModificationDetailsKey);
		}catch(FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "BaseAgreementModificationDetailsBOFactory", "getBAModificationDetailsBO", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
			populateDataFromEntity(baModificationDetailsBO, baModificationDetailsLocal);
		
		return baModificationDetailsBO;
	}

	
	private BaseAgreementModificationDetailsLocalHome getBaseAgreementModificationLocalHome() {
		return (BaseAgreementModificationDetailsLocalHome)ServiceLocator.getEJBHomeFactory().getLocalHome(HomeProvider.BASE_AGREEMENT_MODIFICATION_DETAILS_LOCAL_HOME);
	}
	
	private void populateDataFromEntity(BaseAgreementModificationDetailsBO baModificationDetailsBO, BaseAgreementModificationDetailsLocal baModificationDetailsLocal)
	{
		if(baModificationDetailsLocal != null)
		{
			baModificationDetailsBO.setAgreementId(baModificationDetailsLocal.getAgreementId().intValue());
			baModificationDetailsBO.setAccountingContact(OPPTHelper.trimString(baModificationDetailsLocal.getAccountingContact()));
			baModificationDetailsBO.setDetails(OPPTHelper.trimString(baModificationDetailsLocal.getDetails()));
			baModificationDetailsBO.setLegalContract(OPPTHelper.trimString(baModificationDetailsLocal.getLegalContract()));
			baModificationDetailsBO.setModificationTypeCode(OPPTHelper.trimString(baModificationDetailsLocal.getModificationTypeCode()));
			baModificationDetailsBO.setModifiedIBMLetterHead(OPPTHelper.trimString(baModificationDetailsLocal.getModifiedIBMLetterHead()));
			baModificationDetailsBO.setRevenueRecognition(OPPTHelper.trimString(baModificationDetailsLocal.getRevenueRecognition()));
			baModificationDetailsBO.setRolStartDate(baModificationDetailsLocal.getRolStartDate());
			baModificationDetailsBO.setRolEndDate(baModificationDetailsLocal.getRolEndDate());
			baModificationDetailsBO.setModificationOption(OPPTHelper.trimString(baModificationDetailsLocal.getModificationOption()));
			baModificationDetailsBO.setChangedBy(baModificationDetailsLocal.getChangedBy());
			baModificationDetailsBO.setChangedDate(baModificationDetailsLocal.getChangedDate());
			baModificationDetailsBO.setCreatedBy(baModificationDetailsLocal.getCreatedBy());
			baModificationDetailsBO.setCreatedDate(baModificationDetailsLocal.getCreatedDate());
			baModificationDetailsBO.setModStatus(baModificationDetailsLocal.getStatus());
		}
	}

	/**
	 * getAllModificationDetails
     * @param agreementID
     * @throws com.ibm.support.oppt.projectutilities.exception.DomainException
     * @return
     * @author Sasi R Challa
     */
    public ArrayList getAllModificationDetails(int agreementID) throws DomainException
	{
		ArrayList baModificationDetailsList = new ArrayList();
		BaseAgreementModificationDetailsBO baModificationDetailsBO= null;
		Collection baModificationDetailsCollection = null;
		Iterator baModificationDetailsIterator = null;
		BaseAgreementModificationDetailsLocal baModificationDetailsLocal = null;
		BaseAgreementModificationDetailsLocalHome baModificationDetailsHome = getBaseAgreementModificationLocalHome();
		try
		{
			baModificationDetailsCollection =  baModificationDetailsHome.findByAgreementId(new Integer(agreementID));
		} catch(FinderException ex){
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "BaseAgreementModificationDetailsBOFactory", "getAllModificationDetails", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		if(baModificationDetailsCollection != null)
		{
			baModificationDetailsIterator = baModificationDetailsCollection.iterator();
			while(baModificationDetailsIterator.hasNext())
			{
				baModificationDetailsLocal = (BaseAgreementModificationDetailsLocal)baModificationDetailsIterator.next();
				baModificationDetailsBO = new BaseAgreementModificationDetailsBO();
				populateDataFromEntity(baModificationDetailsBO, baModificationDetailsLocal);
				baModificationDetailsList.add(baModificationDetailsBO);
			}
		}
		return baModificationDetailsList;
	}
	/**
	 * createBaseAgreementModification
     * @param baModificationDetailsBO
     * @throws com.ibm.support.oppt.projectutilities.exception.DomainException
     * @author Sudharsan
     */
    public void createBaseAgreementModification(BaseAgreementModificationDetailsBO baModificationDetailsBO) throws DomainException
	{
		BaseAgreementModificationDetailsLocalHome home = getBaseAgreementModificationLocalHome();
		try
		{
			BaseAgreementModificationDetailsLocal local = home.create(new Integer(baModificationDetailsBO.getAgreementId()), baModificationDetailsBO.getModificationTypeCode());
			populateEntity(baModificationDetailsBO, local,false);
			
		}catch(CreateException ex){
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "BaseAgreementModificationBOFactory", "createBaseAgreementModification", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
	}
    /**
	 * updateBaseAgreementModification
     * @param baModificationDetailsBO
     * @throws com.ibm.support.oppt.projectutilities.exception.DomainException
     * @author Sudharsan
     */
    public void updateBaseAgreementModification(BaseAgreementModificationDetailsBO baModificationDetailsBO) throws DomainException
	{
		BaseAgreementModificationDetailsLocalHome home = getBaseAgreementModificationLocalHome();
		//Collection baseAgreementLocalCollection = null;
		BaseAgreementModificationDetailsLocal baseAgreementLocal = null;
		BaseAgreementModificationDetailsKey bAMDetailsKey = new BaseAgreementModificationDetailsKey(new Integer(baModificationDetailsBO.getAgreementId()),baModificationDetailsBO.getModificationTypeCode());
			try
			{
			    baseAgreementLocal =  home.findByPrimaryKey(bAMDetailsKey);
				if(null != baseAgreementLocal) {
		               populateEntity(baModificationDetailsBO, baseAgreementLocal,true);
		          	}
				
			} catch(FinderException ex){
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "BaseAgreementModificationBOFactory", "upateBaseAgreementModification", null, ex);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
	}
	
	private void populateEntity(BaseAgreementModificationDetailsBO baModificationDetailsBO, BaseAgreementModificationDetailsLocal local,boolean update)
	{
		if((BaseAgreementModificationConstants.ROL).equals(baModificationDetailsBO.getModificationTypeCode()))
		{
			local.setRolEndDate(baModificationDetailsBO.getRolEndDate());
			local.setRolStartDate(baModificationDetailsBO.getRolStartDate());
			local.setModificationOption(OPPTHelper.trimString(baModificationDetailsBO.getModificationOption()));
		}
		local.setAccountingContact(baModificationDetailsBO.getAccountingContact());
		local.setAgreementId(new Integer(baModificationDetailsBO.getAgreementId()));
		local.setDetails(OPPTHelper.trimString(baModificationDetailsBO.getDetails()));
		local.setLegalContract(OPPTHelper.trimString(baModificationDetailsBO.getLegalContract()));
		local.setModificationTypeCode(OPPTHelper.trimString(baModificationDetailsBO.getModificationTypeCode()));
		local.setModifiedIBMLetterHead(OPPTHelper.trimString(baModificationDetailsBO.getModifiedIBMLetterHead()));
		local.setRevenueRecognition(OPPTHelper.trimString(baModificationDetailsBO.getRevenueRecognition()));
		if (update)
		{
		local.setChangedBy(OPPTHelper.trimString(baModificationDetailsBO.getChangedBy()));
		local.setChangedDate(baModificationDetailsBO.getChangedDate());
		}
		else{
		local.setCreatedBy(OPPTHelper.trimString(baModificationDetailsBO.getCreatedBy()));
		local.setCreatedDate(baModificationDetailsBO.getCreatedDate());
		}
		local.setStatus(baModificationDetailsBO.getModStatus());
	}
}
