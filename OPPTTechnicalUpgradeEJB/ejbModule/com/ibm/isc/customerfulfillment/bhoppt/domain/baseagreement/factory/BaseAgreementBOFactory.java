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
import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementStatusConstant;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.BaseAgreementBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.TimeTaken;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/** 
 * This factory class returns BaseAgreementBO objects
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

public class BaseAgreementBOFactory {
	
	
	private static final String EXCEPTION = "EXCEPTION";
	private static final String CLASS_NAME = "BaseAgreementBOFactory";
	//private static final String BASE_AGREEMENT_LOCAL_HOME = "BaseAgreementLocalHome";
	
	/**
     * getAllBaseAgreementsBO method is used in getting Search result
     *
     * @return list of BaseAgreementBO
     * @param agreementNumber
     * @param customerNumber
     * @param enterpriseNumber
     * @param formNumber
     * @throws com.ibm.support.oppt.projectutilities.exception.DomainException
     * @author Sasi R Challa
     */
	public ArrayList getAllBaseAgreementsBO(String agreementNumber, String formNumber, String customerNumber, String enterpriseNumber) throws DomainException
	{	
		TimeTaken log = new TimeTaken(CLASS_NAME, "registerBaseAgreement");
		
		BaseAgreementBO baseAgreementBO = null;
		ArrayList baseAgreementList = new ArrayList();
		BaseAgreementLocal baseAgreementLocal = null;
		BaseAgreementLocalHome baseAgreementLocalHome = getBaseAgreementLocalHome();
		Collection baseAgreementsCollection = null;		
		try
		{
			baseAgreementsCollection = baseAgreementLocalHome.findBySearch(agreementNumber, formNumber, customerNumber, enterpriseNumber);
		} catch(FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "BaseAgreementBOFactory", "getAllBaseAgreementsBO", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1000);
		}
		if(baseAgreementsCollection != null)
		{
			Iterator baseAgreementsIterator = baseAgreementsCollection.iterator();
			while(baseAgreementsIterator.hasNext())
			{
				baseAgreementLocal = (BaseAgreementLocal)baseAgreementsIterator.next();
				baseAgreementBO = new BaseAgreementBO();
				populateDataFromEntity(baseAgreementBO, baseAgreementLocal);
				baseAgreementList.add(baseAgreementBO);			
			}
			// Added by Balaji - for some reason finder fails to throw exception :) 
		}else if (baseAgreementsCollection == null || baseAgreementsCollection.size() == 0){
		    throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1000);
		}
		if(baseAgreementList.size() == 0) {
		    throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1000);
		}
		
		return baseAgreementList;
	}
	
	/**
     * getBaseAgreementBO used to get View result
     *
     * @return
     * @param agreementId
     * @throws com.ibm.support.oppt.projectutilities.exception.DomainException
     * @author Sudharsan Reddy
     */
	public BaseAgreementBO getBaseAgreementBO(int agreementId) throws DomainException
	{
		TimeTaken log = new TimeTaken(CLASS_NAME, "getBaseAgreementBO");
		
		BaseAgreementBO baseAgreementBO = new BaseAgreementBO();
		BaseAgreementLocalHome baseAgreementLocalHome = getBaseAgreementLocalHome();
		BaseAgreementKey baseAgreementKey = new BaseAgreementKey(new Integer(agreementId));
		BaseAgreementLocal baseAgreementLocal = null;
		try
		{
			baseAgreementLocal = (BaseAgreementLocal)baseAgreementLocalHome.findByPrimaryKey(baseAgreementKey);
		} catch(FinderException ex){
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "BaseAgreementBOFactory", "getBaseAgreementBO", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
			populateDataFromEntity(baseAgreementBO, baseAgreementLocal);
		
		return baseAgreementBO;
	}
	
	/**
	 * @return
	 */
	private BaseAgreementLocalHome getBaseAgreementLocalHome() {
		return (BaseAgreementLocalHome)ServiceLocator.getEJBHomeFactory().getLocalHome(HomeProvider.BASE_AGREEMENT_LOCAL_HOME);
	}
	
	/**
	 * @param baseAgreementBO
	 * @param baseAgreementLocal
	 */
	private void populateDataFromEntity(BaseAgreementBO baseAgreementBO, BaseAgreementLocal baseAgreementLocal)
	{
		if(baseAgreementLocal != null)
		{
			baseAgreementBO.setAgreementNumber(OPPTHelper.trimString(baseAgreementLocal.getAgreementNumber()));
			baseAgreementBO.setCustomerNumber(OPPTHelper.trimString(baseAgreementLocal.getCustomerNumber()));
			baseAgreementBO.setAgreementStatus(OPPTHelper.trimString(baseAgreementLocal.getAgreementStatus()));
			baseAgreementBO.setEnterpriseNumber(OPPTHelper.trimString(baseAgreementLocal.getEnterpriseNumber()));
			baseAgreementBO.setFormNumber(OPPTHelper.trimString(baseAgreementLocal.getFormNumber()));
			baseAgreementBO.setCustomerName(OPPTHelper.trimString(baseAgreementLocal.getCustomerName()));
			baseAgreementBO.setEnterpriseName(OPPTHelper.trimString(baseAgreementLocal.getEnterpriseName()));
			baseAgreementBO.setAcceptedDate(baseAgreementLocal.getAcceptedDate());
			baseAgreementBO.setBranchOffice(OPPTHelper.trimString(baseAgreementLocal.getBranchOffice()));
			baseAgreementBO.setCoverageType(OPPTHelper.trimString(baseAgreementLocal.getCoverageType()));
			baseAgreementBO.setCreatedBy(OPPTHelper.trimString(baseAgreementLocal.getCreatedBy()));
			baseAgreementBO.setCreatedDate(baseAgreementLocal.getCreatedDate());
			baseAgreementBO.setCustomerRepresentative(OPPTHelper.trimString(baseAgreementLocal.getCustomerRepresentative()));
			baseAgreementBO.setFileNumber(OPPTHelper.trimString(baseAgreementLocal.getFileNumber()));
			baseAgreementBO.setImageReferenceNumber(OPPTHelper.trimString(baseAgreementLocal.getImageReferenceNumber()));
			baseAgreementBO.setIsElectronicSubmitter(OPPTHelper.trimString(baseAgreementLocal.getIsElectronicSubmitter()));
			baseAgreementBO.setIsModifiedAgreement(OPPTHelper.trimString(baseAgreementLocal.getIsModifiedAgreement()));
			if(baseAgreementLocal.getPreviousAgreementId() != null) {
				baseAgreementBO.setPreviousAgreementId((baseAgreementLocal.getPreviousAgreementId().intValue()));
			}
			baseAgreementBO.setOneWay(OPPTHelper.trimString(baseAgreementLocal.getOneway()));
			baseAgreementBO.setAgreementId(baseAgreementLocal.getAgreementId().intValue());
			baseAgreementBO.setSalesOrganization(OPPTHelper.trimString(baseAgreementLocal.getSalesOrganization()));
			baseAgreementBO.setExpirationDate(baseAgreementLocal.getExpirationDate());
			baseAgreementBO.setChangedBy(OPPTHelper.trimString(baseAgreementLocal.getChangedBy()));
			baseAgreementBO.setChangedDate(baseAgreementLocal.getChangedDate());
			baseAgreementBO.setAccountingContactHdr(baseAgreementLocal.getAccountingContactHdr());
			baseAgreementBO.setLegalContactHdr(baseAgreementLocal.getLegalContactHdr());
			baseAgreementBO.setInac(baseAgreementLocal.getInac());
			baseAgreementBO.setLegacyCustomerNumber(baseAgreementLocal.getLegacyCustomerNumber());
			
		}
	}

	/**
	 * createBaseAgreement method used to create baseagreement
     * @param baBO
     * @throws com.ibm.support.oppt.projectutilities.exception.DomainException
     * @author Sudharsan Reddy
     */
    public void createBaseAgreement(BaseAgreementBO baBO) throws DomainException
	{
    	TimeTaken log = new TimeTaken(CLASS_NAME, "createBaseAgreement");
    	
		BaseAgreementLocalHome baseAgreementLocalHome = getBaseAgreementLocalHome();
		try
		{
			BaseAgreementLocal local = baseAgreementLocalHome.create(new Integer(baBO.getAgreementId()),baBO.getSalesOrganization(),baBO.getAgreementNumber(),baBO.getAgreementStatus(),baBO.getCoverageType(),baBO.getIsModifiedAgreement(),baBO.getCreatedBy(),baBO.getCreatedDate());
			populateDataLocalFromBO(baBO, local);			
			
		} catch(CreateException ex){
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "BaseAgreementBOFactory", "createBaseAgreement", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		
	}
	
	private void populateDataLocalFromBO(BaseAgreementBO baBO, BaseAgreementLocal baseAgreementLocal)
	{
		if(baBO != null)
		{
		 	baseAgreementLocal.setAgreementId(new Integer(baBO.getAgreementId()));
			baseAgreementLocal.setAgreementNumber(OPPTHelper.trimString(baBO.getAgreementNumber()));
			baseAgreementLocal.setCustomerNumber(OPPTHelper.trimString(baBO.getCustomerNumber()));
			baseAgreementLocal.setAgreementStatus(OPPTHelper.trimString(baBO.getAgreementStatus()));
			baseAgreementLocal.setEnterpriseNumber(OPPTHelper.trimString(baBO.getEnterpriseNumber()));
			baseAgreementLocal.setFormNumber(OPPTHelper.trimString(baBO.getFormNumber()));
			baseAgreementLocal.setCustomerName(OPPTHelper.trimString(baBO.getCustomerName()));
			baseAgreementLocal.setEnterpriseName(OPPTHelper.trimString(baBO.getEnterpriseName()));
			baseAgreementLocal.setAcceptedDate(baBO.getAcceptedDate());
			baseAgreementLocal.setBranchOffice(OPPTHelper.trimString(baBO.getBranchOffice()));
			baseAgreementLocal.setCoverageType(OPPTHelper.trimString(baBO.getCoverageType()));
			//baseAgreementLocal.setCreatedBy(OPPTHelper.trimString(baBO.getCreatedBy()));
			//baseAgreementLocal.setCreatedDate(baBO.getCreatedDate());
		    baseAgreementLocal.setCustomerRepresentative(OPPTHelper.trimString(baBO.getCustomerRepresentative()));
			baseAgreementLocal.setFileNumber(OPPTHelper.trimString(baBO.getFileNumber()));
			baseAgreementLocal.setImageReferenceNumber(OPPTHelper.trimString(baBO.getImageReferenceNumber()));
			baseAgreementLocal.setIsElectronicSubmitter(OPPTHelper.trimString(baBO.getIsElectronicSubmitter()));
			baseAgreementLocal.setIsModifiedAgreement(OPPTHelper.trimString(baBO.getIsModifiedAgreement()));
			//baseAgreementLocal.setIsModifiedAgreement("Y");
			baseAgreementLocal.setOneway(OPPTHelper.trimString(baBO.getOneWay()));
			if(0 != baBO.getPreviousAgreementId()) {
				baseAgreementLocal.setPreviousAgreementId(new Integer(baBO.getPreviousAgreementId()));
			}		
			baseAgreementLocal.setSalesOrganization(OPPTHelper.trimString(baBO.getSalesOrganization()));
			baseAgreementLocal.setExpirationDate(baBO.getExpirationDate());
			baseAgreementLocal.setChangedBy(OPPTHelper.trimString(baBO.getChangedBy()));
			baseAgreementLocal.setChangedDate(baBO.getChangedDate());
			baseAgreementLocal.setLegacyCustomerNumber(baBO.getLegacyCustomerNumber());
			baseAgreementLocal.setAccountingContactHdr(baBO.getAccountingContactHdr());
			baseAgreementLocal.setLegalContactHdr(baBO.getLegalContactHdr());
			baseAgreementLocal.setInac(baBO.getInac());
			//baseAgreementLocal.setLanguage(baBO.getLanguage());
		}		
			
	}
	
	/**
	 * updateBaseAgreementBO method 
     * @param baseAgreementBO
     * @throws com.ibm.support.oppt.projectutilities.exception.DomainException
     * @author Sasi R Challa
     */
    public void updateBaseAgreementBO(BaseAgreementBO baseAgreementBO) throws DomainException
	{
    	TimeTaken log = new TimeTaken(CLASS_NAME, "updateBaseAgreementBO");
    	
    	try
		{
			BaseAgreementLocalHome baseAgreementLocalHome = getBaseAgreementLocalHome();
			BaseAgreementKey baKey = new BaseAgreementKey(new Integer(baseAgreementBO.getAgreementId()));
			BaseAgreementLocal baseAgreementLocal = baseAgreementLocalHome.findByPrimaryKey(baKey);
			populateDataLocalFromBO(baseAgreementBO, baseAgreementLocal);
			
		} catch(FinderException ex){
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "BaseAgreementBOFactory", "updateBaseAgreementBO", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
	}
	
	/**
	 * findMaxBaseAgreementBO
     * @throws com.ibm.support.oppt.projectutilities.exception.DomainException
     * @return
     * @author Sudharsan Reddy
     */
    public BaseAgreementBO findMaxBaseAgreementBO() throws DomainException
	{
    	TimeTaken log = new TimeTaken(CLASS_NAME, "findMaxBaseAgreementBO");
    	
		BaseAgreementBO baseAgreementBO = new BaseAgreementBO();
		BaseAgreementLocalHome baseAgreementLocalHome = getBaseAgreementLocalHome();
		BaseAgreementLocal baseAgreementLocal = null;

		try {
			baseAgreementLocal = baseAgreementLocalHome.findMaxAgreementId();
			if(null != baseAgreementLocal) {
				baseAgreementBO.setAgreementId(baseAgreementLocal.getAgreementId().intValue());
			}else {
				baseAgreementBO.setAgreementId(0);
			}

		} catch (FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "BaseAgreementBOFactory", "findMaxBaseAgreementBO", null, ex);
			baseAgreementBO.setAgreementId(0);
			//throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		return baseAgreementBO;

	}
    /**
	 * checkValidity
     * @throws com.ibm.support.oppt.projectutilities.exception.DomainException
     * @return
     * @author Sudharsan Reddy
     */ 
    
    public boolean checkValidity(String customernumber,String formnumber,boolean amend,int amendedAgreementId) throws DomainException
		{  
    	TimeTaken log = new TimeTaken(CLASS_NAME, "checkValidity");    	
    	
    	    BaseAgreementBO baseAgreementBO = null;
			BaseAgreementLocal baseAgreementLocal = null;
			Collection baseAgreementLocalCollection = null;
			BaseAgreementLocalHome baseAgreementLocalHome = getBaseAgreementLocalHome();
			boolean validity= true;		
			try
			{
				customernumber= OPPTHelper.trimStringToNull(customernumber);
				formnumber = OPPTHelper.trimStringToNull(formnumber);
			  if (customernumber != null)
	            {    
	            	baseAgreementLocalCollection  = baseAgreementLocalHome.findByCustomerNumberandFormNumber(customernumber,formnumber);
	            }
	          } catch(FinderException ex) 
			    {
				// Empty we do not handle this exception
			    }
	          if(null != baseAgreementLocalCollection) {
	          	Iterator iter = baseAgreementLocalCollection.iterator();
	          	while(iter.hasNext()) {
	          		baseAgreementLocal = (BaseAgreementLocal)iter.next();
	          		if(BaseAgreementStatusConstant.Active.equals(baseAgreementLocal.getAgreementStatus())) {
	          			if(amend) {
	          				if(baseAgreementLocal.getAgreementId().intValue() == amendedAgreementId) {
	          					validity = true;
	          				}
	          			}else {
	          				validity =false;
	          			}
	          		}
	          	}
	          }
	        		
		 return validity;
		}

    /**
	 * deleteFormBO
     * @throws com.ibm.support.oppt.projectutilities.exception.DomainException
     * @return boolean
     * @author Nayanatara
     */
    public boolean deleteFormBO(BaseAgreementBO baseAgreementBO)throws DomainException{
    	TimeTaken log = new TimeTaken(CLASS_NAME, "deleteFormBO");
    	boolean value = false;

    	BaseAgreementLocalHome baseAgreementLocalHome = getBaseAgreementLocalHome();
    	Collection baseAgreementLocalCollection = null;
    	try
		{
    		baseAgreementLocalCollection  = baseAgreementLocalHome.findBySalesOrgAndFormNumber(baseAgreementBO.getSalesOrganization(),baseAgreementBO.getFormNumber());
	
    } catch (FinderException ex) {
		OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "BaseAgreementBOFactory", "deleteFormBO", null, ex);
	}
    //if baseAgreementLocalCollection = 0 ie value = true; then no match in the table is found
    if(baseAgreementLocalCollection.size() != 0){
    	value = false;
    }else
    {
    	value = true;
    }
    
    return value;
   }

}
