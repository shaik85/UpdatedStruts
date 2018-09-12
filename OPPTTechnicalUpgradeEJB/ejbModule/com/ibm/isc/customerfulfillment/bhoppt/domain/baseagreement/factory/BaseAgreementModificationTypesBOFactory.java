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
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.BaseAgreementModificationTypesBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.TimeTaken;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/** 
 * This factory class returns BaseAgreementModificationTypesBO objects
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
public class BaseAgreementModificationTypesBOFactory {
	
	
	
	private static final String EXCEPTION = "EXCEPTION";
	private static final String CLASS_NAME = "BaseAgreementModificationTypesBOFactory";
	
	
	/**
	    * get all modification type
	    * 
	    * @return ArrayList
	    * @throws DomainException
	    */
	    
	    
	    public ArrayList getAllModificationTypesBO(BaseAgreementModificationTypesBO baseAgreementModificationTypesBO) throws DomainException{
	    
	    	TimeTaken log = new TimeTaken(CLASS_NAME, "getAllModificationTypesBO");
	    	
	    	ArrayList baModificationTypesList = new ArrayList();
	        BaseAgreementModificationTypeLocal baModificationTypeLocal = null;
	        BaseAgreementModificationTypeLocalHome baModificationTypeLocalHome = getBaseAgreementModificationTypeLocalHome();
	        Collection baModificationTypeCollection = null;	
	        try
			{
	            baModificationTypeCollection = baModificationTypeLocalHome.findBySalesOrganisation(baseAgreementModificationTypesBO.getSalesOrg());
	        } catch(FinderException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "getAllModificationTypesBO", null, ex);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			if(baModificationTypeCollection != null)
			{
				Iterator baModificationTypesIterator = baModificationTypeCollection.iterator();
				while(baModificationTypesIterator.hasNext())
				{ 	
					BaseAgreementModificationTypesBO baModificationTypesBO = new BaseAgreementModificationTypesBO();
				    baModificationTypeLocal = (BaseAgreementModificationTypeLocal)baModificationTypesIterator.next();
				    populateDataFromEntity(baModificationTypesBO, baModificationTypeLocal);
					baModificationTypesList.add(baModificationTypesBO);			
				}
				 
			}
	        return baModificationTypesList;
	    }
	    /**
	     * populate the data in BO
	     * 
	     * @param baModificationTypesBO
	     * @param baModificationTypeLocal
	     */
	    private void populateDataFromEntity(BaseAgreementModificationTypesBO baModificationTypesBO, BaseAgreementModificationTypeLocal baModificationTypeLocal) {
	        
	        if(baModificationTypeLocal != null){
	            baModificationTypesBO.setModificationTypeCode(OPPTHelper.trimString(baModificationTypeLocal.getModificationTypeCode()));
	            baModificationTypesBO.setModificationTypeDescription(OPPTHelper.trimString(baModificationTypeLocal.getModificationTypeDescription()));
	            baModificationTypesBO.setSalesOrg(OPPTHelper.trimString(baModificationTypeLocal.getSalesOrganization()));
	        }
	    }
	    
	    /**
	     * add modification type
	     * 
	     * @param baModificationTypesBO
	     * @throws DomainException
	     */
	    
	    public void addModificationTypeBO(BaseAgreementModificationTypesBO baModificationTypesBO) throws DomainException {
	    
	    	TimeTaken log = new TimeTaken(CLASS_NAME, "addModificationTypeBO");
	    	
	    	BaseAgreementModificationTypeLocal baModificationTypeLocal=null;
	        BaseAgreementModificationTypeLocalHome baModificationTypeLocalHome = getBaseAgreementModificationTypeLocalHome();
	        Collection baModificationTypeCollection = null;
	        try
			{
	             baModificationTypeCollection= baModificationTypeLocalHome.findExistModificationType(baModificationTypesBO.getSalesOrg(),baModificationTypesBO.getModificationTypeCode());
	     	}catch(FinderException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "addModificationTypeBO", null, ex);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			} catch (EJBException e) {
         		    OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "addModificationTypeBO", null, e);
         		    throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
         		}
			
		   if(baModificationTypeCollection!=null && baModificationTypeCollection.size()!=0){
	        }else{
	            try{
            	    baModificationTypeLocal = baModificationTypeLocalHome.create(OPPTHelper.trimString(baModificationTypesBO.getModificationTypeCode()),OPPTHelper.trimString(baModificationTypesBO.getSalesOrg()));
            	    baModificationTypeLocal.setModificationTypeDescription(OPPTHelper.trimString(baModificationTypesBO.getModificationTypeDescription()));
           	} catch(CreateException e) {
         		    OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "addModificationTypeBO", null, e);
         		    throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
         	} catch (EJBException e) {
         		    OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "addModificationTypeBO", null, e);
         		    throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
         	}
 	      }
		}
	    
	    /**
	     * update modification type
	     * 
	     * @param baModificationTypesBO
	     * @throws DomainException
	     */
	 
	    public void updateModificationTypeBO(BaseAgreementModificationTypesBO baModificationTypesBO) throws DomainException{
	       
	    	TimeTaken log = new TimeTaken(CLASS_NAME, "updateModificationTypeBO");
	    	
	        BaseAgreementModificationTypeLocal baModificationTypeLocal = null;
	        BaseAgreementModificationTypeLocalHome baModificationTypeLocalHome = getBaseAgreementModificationTypeLocalHome();
	        BaseAgreementModificationTypeKey modificationTypeKey = new BaseAgreementModificationTypeKey(baModificationTypesBO.getModificationTypeCode(),baModificationTypesBO.getSalesOrg());
	        Collection baModificationTypeCollection = null;	
	        try
			{
	            baModificationTypeLocal = baModificationTypeLocalHome.findByPrimaryKey(modificationTypeKey);
			} catch(FinderException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "updateModificationTypeBO", null, ex);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			if(baModificationTypeLocal != null)
			{
			     baModificationTypeLocal.setModificationTypeDescription(OPPTHelper.trimString(baModificationTypesBO.getModificationTypeDescription()));    
				    
			}
	    }
	    
	    /**
	     * update modification type
	     * 
	     * @param baModificationTypesBO
	     * @throws DomainException
	     */
	 
	    public void deleteModificationTypeBO(BaseAgreementModificationTypesBO baModificationTypesBO) throws DomainException{
	      
	    	TimeTaken log = new TimeTaken(CLASS_NAME, "deleteModificationTypeBO");
	    	
	        BaseAgreementModificationTypeLocal baModificationTypeLocal = null;
	        BaseAgreementModificationTypeLocalHome baModificationTypeLocalHome = getBaseAgreementModificationTypeLocalHome();
	        BaseAgreementModificationTypeKey modificationTypeKey = new BaseAgreementModificationTypeKey(baModificationTypesBO.getModificationTypeCode(),baModificationTypesBO.getSalesOrg());
	        Collection baModificationTypeCollection = null;	
	        try
			{
	            baModificationTypeLocal = baModificationTypeLocalHome.findByPrimaryKey(modificationTypeKey);
	            baModificationTypeLocal.remove();
			} catch(FinderException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "deleteModificationTypeBO", null, ex);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}catch(RemoveException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "deleteModificationTypeBO", null, ex);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			if(baModificationTypeLocal != null)
			{
			     baModificationTypeLocal.setModificationTypeDescription(OPPTHelper.trimString(baModificationTypesBO.getModificationTypeDescription()));    
				    
			}
	    }
	    
	    /**
	     * update modification type
	     * 
	     * @param baModificationTypesBO
	     * @throws DomainException
	     */
	    public ArrayList getModOptions(String salesOrg)throws DomainException{
	    	
	    	TimeTaken log = new TimeTaken(CLASS_NAME, "getModOptions");
	    	
	    	BaseAgreementModificationTypeLocal baModificationTypeLocal = null;
	        BaseAgreementModificationTypeLocalHome baModificationTypeLocalHome = getBaseAgreementModificationTypeLocalHome();
	        Collection baModificationTypeCollection = null;	
	        ArrayList baModificationTypesList = new ArrayList();
	      
	        try
			{
	            baModificationTypeCollection = baModificationTypeLocalHome.findBySalesOrganisation(salesOrg);
	        } catch(FinderException ex) {
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "getModOptions", null, ex);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
	        if(baModificationTypeCollection != null)
			{
				Iterator baModificationTypesIterator = baModificationTypeCollection.iterator();
				while(baModificationTypesIterator.hasNext())
				{ 	
					BaseAgreementModificationTypesBO baModificationTypesBO = new BaseAgreementModificationTypesBO();
				    baModificationTypeLocal = (BaseAgreementModificationTypeLocal)baModificationTypesIterator.next();
				    populateDataFromEntity(baModificationTypesBO, baModificationTypeLocal);
					baModificationTypesList.add(baModificationTypesBO);			
				}
				 
			}
	        return baModificationTypesList;
	    
	    	
	    }
	    /**
	     * get the home object reference
	     * 
	     * @return BaseAgreementModificationTypeLocalHome
	     */
	    private BaseAgreementModificationTypeLocalHome getBaseAgreementModificationTypeLocalHome() {
	        return (BaseAgreementModificationTypeLocalHome)ServiceLocator.getEJBHomeFactory().getLocalHome(HomeProvider.BASE_AGREEMENT_MODIFICATION_TYPE_LOCAL_HOME);
	       }

}
