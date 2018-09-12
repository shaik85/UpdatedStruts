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

import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.FormNumbersBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.TimeTaken;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/** 
 * This factory class returns FormNumbersBO objects
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
public class FormNumbersBOFactory {
	
	
	private static final String EXCEPTION = "EXCEPTION";
	private static final String CLASS_NAME = "FormNumbersBOFactory";

/**
 * 
 * Dec 27, 2006
 * getAllFormsBO
 * @param formNumbersBO
 * @return
 * @throws DomainException
 */
	
public ArrayList getAllFormsBO(FormNumbersBO formNumbersBO) throws DomainException{
	
	TimeTaken log = new TimeTaken(CLASS_NAME, "getAllFormsBO");
	
	ArrayList baFormList = new ArrayList();
	BaseAgreementFormLocal baFormTypeLocal = null;
	BaseAgreementFormLocalHome  localHome =  getBaseAgreementFormLocalHome();
	Collection formdetailsCollection = null;
	
	try
	{
		formdetailsCollection = localHome.findAllForm(formNumbersBO.getSalesOrg());
    } catch(FinderException ex) {
		OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "getAllFormsBO", null, ex);
		throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
	}
	
	if(formdetailsCollection != null){
      Iterator formdetailsIterator = formdetailsCollection.iterator();
      while(formdetailsIterator.hasNext()){
      	FormNumbersBO formNumberBO = new FormNumbersBO();
      	baFormTypeLocal = (BaseAgreementFormLocal)formdetailsIterator.next();
      	populateDataFromEntity(formNumberBO,baFormTypeLocal);
      	baFormList.add(formNumberBO);
      }
		
	}
	return baFormList;
}
/**
 * 
 * Dec 27, 2006
 * getAllFormsBO
 * @param formNumbersBO
 * @return
 * @throws DomainException
 */
private void populateDataFromEntity(FormNumbersBO formNumbersBO,BaseAgreementFormLocal baFormTypeLocal ){
	if(baFormTypeLocal != null){
		formNumbersBO.setSalesOrg(OPPTHelper.trimString(baFormTypeLocal.getSalesOrganization()));
		formNumbersBO.setFormNumber(OPPTHelper.trimString(baFormTypeLocal.getFormNumber()));
		formNumbersBO.setFormLongDescription(OPPTHelper.trimString(baFormTypeLocal.getFormLongDescription()));
		formNumbersBO.setFormShortDescription(OPPTHelper.trimString(baFormTypeLocal.getFormShortDescription()));
	}
	
}
/**
 * 
 * Dec 27, 2006
 * getFormNumbers
 * @param salesOrg
 * @return
 * @throws DomainException
 */
public ArrayList getFormNumbers(String salesOrg) throws DomainException{

	TimeTaken log = new TimeTaken(CLASS_NAME, "getFormNumbers");
	
	ArrayList baFormList = new ArrayList();
	BaseAgreementFormLocal baFormTypeLocal = null;
	BaseAgreementFormLocalHome  localHome =  getBaseAgreementFormLocalHome();
	Collection formdetailsCollection = null;
	
	try
	{
		formdetailsCollection = localHome.findAllForm(salesOrg);
    } catch(FinderException ex) {
		OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "getFormNumbers", null, ex);
		throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
	}
	
	if(formdetailsCollection != null){
      Iterator formdetailsIterator = formdetailsCollection.iterator();
      while(formdetailsIterator.hasNext()){
      	FormNumbersBO formNumberBO = new FormNumbersBO();
      	baFormTypeLocal = (BaseAgreementFormLocal)formdetailsIterator.next();
      	populateDataFromEntity(formNumberBO,baFormTypeLocal);
      	baFormList.add(formNumberBO);
      }
		
	}
	return baFormList;
}

/**
 * 
 * Dec 27, 2006
 * addFormBO
 * @param formNumbersBO
 * @throws DomainException
 */

public void addFormBO(FormNumbersBO formNumbersBO) throws DomainException {
	
	TimeTaken log = new TimeTaken(CLASS_NAME, "addFormBO");
	
	BaseAgreementFormLocal baFormTypeLocal = null;
	BaseAgreementFormLocalHome baFormLocalHome = getBaseAgreementFormLocalHome();
    BaseAgreementFormKey baFormKey = new BaseAgreementFormKey(formNumbersBO.getFormNumber(),formNumbersBO.getSalesOrg());
      	try
        	{
        		baFormTypeLocal = baFormLocalHome.create(OPPTHelper.trimString(formNumbersBO.getFormNumber()),OPPTHelper.trimString(formNumbersBO.getSalesOrg()));
        		baFormTypeLocal.setFormLongDescription(OPPTHelper.trimString(formNumbersBO.getFormLongDescription()));
        		baFormTypeLocal.setFormShortDescription(OPPTHelper.trimString(formNumbersBO.getFormShortDescription()));
        		
        
     		} catch(CreateException e) {
     		    OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "addFormBO", null, e);
     		    throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
     		} catch (EJBException e) {
     		    OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "addFormBO", null, e);
     		    throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
     		}
}
/**
 * 
 * Dec 27, 2006
 * deleteFormBO
 * @param formNumbersBO
 * @throws DomainException
 */
public void deleteFormBO(FormNumbersBO formNumbersBO) throws DomainException{

	TimeTaken log = new TimeTaken(CLASS_NAME, "deleteFormBO");
	
	BaseAgreementFormLocal baFormTypeLocal = null;
	BaseAgreementFormLocalHome baFormLocalHome = getBaseAgreementFormLocalHome();
	BaseAgreementFormKey baFormKey = new BaseAgreementFormKey(formNumbersBO.getFormNumber(),formNumbersBO.getSalesOrg());
	try
	{
		baFormTypeLocal = baFormLocalHome.findByPrimaryKey(baFormKey);
		baFormTypeLocal.remove();
	} catch(FinderException ex) {
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "deleteFormBO", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}catch(RemoveException ex) {
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "deleteFormBO", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		catch (EJBException e) {
		    OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "deleteFormBO", null, e);
		    throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
}
/**
 * 
 * Dec 27, 2006
 * updateFormBO
 * @param formNumbersBO
 * @throws DomainException
 */

public void updateFormBO(FormNumbersBO formNumbersBO) throws DomainException{
  
	TimeTaken log = new TimeTaken(CLASS_NAME, "updateFormBO");
	
	BaseAgreementFormLocal baFormTypeLocal = null;
	BaseAgreementFormLocalHome baFormLocalHome = getBaseAgreementFormLocalHome();
	BaseAgreementFormKey baFormKey = new BaseAgreementFormKey(formNumbersBO.getFormNumber(),formNumbersBO.getSalesOrg());
   
    try
	{
    	baFormTypeLocal = baFormLocalHome.findByPrimaryKey(baFormKey);
	} catch(FinderException ex) {
		OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "updateFormBO", null, ex);
		throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
	}
	if(baFormTypeLocal != null)
	{
		//baFormTypeLocal.setSalesOrganization(OPPTHelper.trimString(formNumbersBO.getSalesOrg()));
		//baFormTypeLocal.setFormNumber(OPPTHelper.trimString(formNumbersBO.getFormNumber()));
		baFormTypeLocal.setFormLongDescription(OPPTHelper.trimString(formNumbersBO.getFormLongDescription()));
		baFormTypeLocal.setFormShortDescription(OPPTHelper.trimString(formNumbersBO.getFormShortDescription()));
		
		    
	}
}
/**
 * getBaseAgreementFormLocalHome
 * Dec 27, 2006
 * @return BaseAgreementFormLocalHome
 */

private BaseAgreementFormLocalHome getBaseAgreementFormLocalHome() {
    return (BaseAgreementFormLocalHome)ServiceLocator.getEJBHomeFactory().getLocalHome(HomeProvider.BASE_AGREEMENT_FORM_LOCAL_HOME);
   }
}
