/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import javax.ejb.CreateException;
import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationConstants;
import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementStatusConstant;
import com.ibm.isc.customerfulfillment.bhoppt.connector.JMSConnectorLocal;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CreateBaseAgreementInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CreateBaseAgreementOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CreateModificationInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.CreateModificationOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.UpdateBaseAgreementInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.UpdateBaseAgreementOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.UpdateModificationInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.UpdateModificationOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.BaseAgreementBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.BaseAgreementChangeLogBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.BaseAgreementModificationDetailsBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.factory.BaseAgreementBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.factory.BaseAgreementChangeLogBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.factory.BaseAgreementModificationDetailsBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.BaseAgreementDAO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementChangeLogCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementChangeLogDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ROLModificationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SearchBaseAgreementCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ButtonConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.TimeTaken;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorEntry;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;


/**
 * Bean implementation class for Enterprise Bean: BaseAgreementManager
 */
public class BaseAgreementManagerBean implements javax.ejb.SessionBean {
	
	private static final String EXCEPTION = "EXCEPTION";
	private static final String CLASS_NAME = "BaseAgreementManagerBean";
	
	private javax.ejb.SessionContext mySessionCtx;
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
     *
     * @throws javax.ejb.CreateException 
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
     * getAllBaseAgreements method used to get search result based on the input
     *
     * @return
     * @param searchBaseAgreementCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @author Sasi R Challa
     */
	public SearchBaseAgreementCustomDTO getAllBaseAgreements(SearchBaseAgreementCustomDTO searchBaseAgreementCustomDTO) throws ServiceException
	{
		TimeTaken log = new TimeTaken(CLASS_NAME, "getAllBaseAgreements");
		
		String agreeementNumber = OPPTHelper.trimStringToNull(searchBaseAgreementCustomDTO.getAgreementNumber());
		String formNumber = OPPTHelper.trimStringToNull(searchBaseAgreementCustomDTO.getFormNumber());
		String customerNumber = OPPTHelper.trimStringToNull(searchBaseAgreementCustomDTO.getCustomerNumber());
		String enterprseNumber = OPPTHelper.trimStringToNull(searchBaseAgreementCustomDTO.getEnterpriseNumber());
		String imageReferenceNumber = OPPTHelper.trimStringToNull(searchBaseAgreementCustomDTO.getImageReferenceNumber());
		String iNAC = OPPTHelper.trimStringToNull(searchBaseAgreementCustomDTO.getINAC());
		String customerName = OPPTHelper.trimStringToNull(searchBaseAgreementCustomDTO.getCustomerName());
		String customerLegacyNumber = OPPTHelper.trimStringToNull(searchBaseAgreementCustomDTO.getCustomerLegacyNumber());
				
		BaseAgreementBOFactory baseAgreementBOFactory = new BaseAgreementBOFactory();
		BaseAgreementDAO baseAgreementDAO = new BaseAgreementDAO();
		BaseAgreementBO baseAgreementBO = new BaseAgreementBO();
		ArrayList baseAgreementBOList = null;
		ArrayList baseAgreementList = new ArrayList();
		//TreeMap baseAgreementMap = new TreeMap();
		
		
	    try {
			baseAgreementBOList = baseAgreementDAO.getAllBaseAgreementsBO(agreeementNumber, formNumber, customerNumber, enterprseNumber,imageReferenceNumber,customerName);
		} catch(Exception de){		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"getAllBaseAgreements",de.getMessage());
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);	
		}
		try
		{
		     if(baseAgreementBOList!=null && baseAgreementBOList.size()!=0){
		        baseAgreementList = filterBaseAgreements(searchBaseAgreementCustomDTO,baseAgreementBOList);	
		    }else{
		        throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1000);
		    }	
		}catch(DomainException de){		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"getAllBaseAgreements",de.getMessage());
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
		}
		searchBaseAgreementCustomDTO.setBaseAgreementList(baseAgreementList);
		if(new Integer(RoleConstants.READ_ONLY).equals(new Integer(searchBaseAgreementCustomDTO.getBaUserRole())) 
				|| new Integer(RoleConstants.READ_LIMITED).equals (new Integer(searchBaseAgreementCustomDTO.getBaUserRole())))
		{
			searchBaseAgreementCustomDTO.addButtonFlag(ButtonConstants.BASEAGREEMENT_AMEND);
			searchBaseAgreementCustomDTO.addButtonFlag(ButtonConstants.BASEAGREEMENT_INACTIVATE);
			searchBaseAgreementCustomDTO.addButtonFlag(ButtonConstants.BASEAGREEMENT_REACTIVATE);
		}
		
		return searchBaseAgreementCustomDTO;
	}
	
	/**
	 * @param baseAgreementBO
	 * @return
	 */
	private BaseAgreementCustomDTO populateCustomDTO(BaseAgreementBO baseAgreementBO)
	{
		BaseAgreementCustomDTO customDTO = new BaseAgreementCustomDTO();
		if(baseAgreementBO != null)
		{
			customDTO.setAgreementId(baseAgreementBO.getAgreementId());
			customDTO.setAgreementNumber(baseAgreementBO.getAgreementNumber());
			customDTO.setCustomerName(baseAgreementBO.getCustomerName());
			customDTO.setCustomerNumber(baseAgreementBO.getCustomerNumber());
			customDTO.setFormNumber(baseAgreementBO.getFormNumber());
			customDTO.setEnterpriseNumber(baseAgreementBO.getEnterpriseNumber());
			customDTO.setAgreementStatus(baseAgreementBO.getAgreementStatus());
			customDTO.setImageReferenceNumber(baseAgreementBO.getImageReferenceNumber());
			customDTO.setINAC(baseAgreementBO.getInac());
			customDTO.setCustomerLegacyNumber(baseAgreementBO.getLegacyCustomerNumber());
		}
		return customDTO;
	}
	
	/**
	 * getBaseAgreement method is used view the Agreement based on Agreement id 
     * @param baDetailsCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @return
     * @author Sudharsan
     */
    public BaseAgreementDetailsCustomDTO getBaseAgreement(BaseAgreementDetailsCustomDTO baDetailsCustomDTO) throws ServiceException
	{
    	TimeTaken log = new TimeTaken(CLASS_NAME, "getBaseAgreement");
		
    	
    	int agreementId = baDetailsCustomDTO.getAgreementId(); 
		BaseAgreementModificationDetailsBOFactory baModificationDetailsBoFactory = new BaseAgreementModificationDetailsBOFactory();
		BaseAgreementBOFactory baBOFactory = new BaseAgreementBOFactory();
		BaseAgreementBO baBO = null;
		ArrayList baModificationDetailsBOList = null;
		ROLModificationCustomDTO rolModificationCustomDTO = null;
		ModificationCustomDTO modificationCustomDTO = null;
		
		try
		{
			baBO = baBOFactory.getBaseAgreementBO(agreementId);
			if(ActionNameConstants.AMEND_BASEAGREEMENT.equals(baDetailsCustomDTO.getTransactionName())) {
				baBO.validateForAmend();
			}
			baModificationDetailsBOList = baModificationDetailsBoFactory.getAllModificationDetails(agreementId);
		}catch(DomainException de){
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "getBaseAgreement", null, de);
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
		}
		TreeMap modificationDetailsMap = new TreeMap();
		if(baModificationDetailsBOList != null)
		{
			Iterator baModificationDetailsBOIterator = baModificationDetailsBOList.iterator();
			while(baModificationDetailsBOIterator.hasNext())
			{
				BaseAgreementModificationDetailsBO baModificationDetailsBO = (BaseAgreementModificationDetailsBO)baModificationDetailsBOIterator.next();
				if((BaseAgreementModificationConstants.ROL).equals(baModificationDetailsBO.getModificationTypeCode()))
				{
					rolModificationCustomDTO = new ROLModificationCustomDTO();
					rolModificationCustomDTO = populateROLFromBO(baModificationDetailsBO);
					modificationDetailsMap.put(rolModificationCustomDTO.getModificationTypeCode(), rolModificationCustomDTO);
					
				}
				else
				{
					modificationCustomDTO = populateDTOFromBO(baModificationDetailsBO);
					modificationDetailsMap.put(modificationCustomDTO.getModificationTypeCode(), modificationCustomDTO);				
				}
			}
			if(new Integer(RoleConstants.READ_LIMITED).equals(new Integer(baDetailsCustomDTO.getBaUserRole())))
			{			
				baDetailsCustomDTO.setShowModificationDetails(false);
			}
			baDetailsCustomDTO.setModificationDetailsMap(modificationDetailsMap);
			baDetailsCustomDTO.setAcceptedDate(baBO.getAcceptedDate());
			baDetailsCustomDTO.setAgreementNumber(baBO.getAgreementNumber());
			baDetailsCustomDTO.setBranchOffice(baBO.getBranchOffice());
			baDetailsCustomDTO.setAgreementStatus(baBO.getAgreementStatus());
			//clarification on contract submmitter
			//baDetailsCustomDTO.setContractSubmitter(baBO.getCustomerRepresentative());
			baDetailsCustomDTO.setOneWay(baBO.getOneWay());
			baDetailsCustomDTO.setCoverageType(baBO.getCoverageType());
			baDetailsCustomDTO.setCustomerName(baBO.getCustomerName());
			baDetailsCustomDTO.setCustomerNumber(baBO.getCustomerNumber());
			baDetailsCustomDTO.setCustomerRepresentative(baBO.getCustomerRepresentative());
			baDetailsCustomDTO.setEnterpriseName(baBO.getEnterpriseName());
			baDetailsCustomDTO.setEnterpriseNumber(baBO.getEnterpriseNumber());
			baDetailsCustomDTO.setFileNumber(baBO.getFileNumber());
			baDetailsCustomDTO.setIsElectronicSumbmitter(baBO.getIsElectronicSubmitter());
			baDetailsCustomDTO.setImageReferenceNumber(baBO.getImageReferenceNumber());
			baDetailsCustomDTO.setEntryDate(baBO.getCreatedDate());
			baDetailsCustomDTO.setImageReferenceNumber(baBO.getImageReferenceNumber());	
			baDetailsCustomDTO.setChangedBy(baBO.getChangedBy());
			baDetailsCustomDTO.setSalesOrganization(baBO.getSalesOrganization());
			baDetailsCustomDTO.setChangedDate(baBO.getChangedDate());
			baDetailsCustomDTO.setExpirationDate(baBO.getExpirationDate());
			baDetailsCustomDTO.setFormNumber(baBO.getFormNumber());
			baDetailsCustomDTO.setAgreementId(baBO.getAgreementId());
			baDetailsCustomDTO.setAgreementStatus(baBO.getAgreementStatus());
			baDetailsCustomDTO.setIsModified(baBO.getIsModifiedAgreement());
			baDetailsCustomDTO.setCreatedBy(baBO.getCreatedBy());
			baDetailsCustomDTO.setInac(baBO.getInac());
			baDetailsCustomDTO.setLegacyCustomerNumber(baBO.getLegacyCustomerNumber());
			baDetailsCustomDTO.setLegalContactHdr(baBO.getLegalContactHdr());
			baDetailsCustomDTO.setAccountingContactHdr(baBO.getAccountingContactHdr());
			
			}		

		return baDetailsCustomDTO;
	}
	
	private ModificationCustomDTO populateDTOFromBO(BaseAgreementModificationDetailsBO baModificationDetailsBO)
	{
	    
		ModificationCustomDTO customDTO = new ModificationCustomDTO();
		if(baModificationDetailsBO != null)
		{
			customDTO.setAccountingContact(baModificationDetailsBO.getAccountingContact());
			customDTO.setAgreementId(baModificationDetailsBO.getAgreementId());
			customDTO.setLegalContract(baModificationDetailsBO.getLegalContract());
			customDTO.setModifiedLetterHead(baModificationDetailsBO.getModifiedIBMLetterHead());
			customDTO.setModificationTypeCode(baModificationDetailsBO.getModificationTypeCode());
			customDTO.setRevenueRecognition(baModificationDetailsBO.getRevenueRecognition());
			customDTO.setDetails(baModificationDetailsBO.getDetails());
			customDTO.setChangedBy(baModificationDetailsBO.getChangedBy());
			customDTO.setCreatedBy(baModificationDetailsBO.getCreatedBy());
			customDTO.setChangedDate(baModificationDetailsBO.getChangedDate());
			customDTO.setCreatedDate(baModificationDetailsBO.getCreatedDate());	
			customDTO.setStatus(baModificationDetailsBO.getModStatus());
		}
		
		return customDTO;
	}
	
	 private ROLModificationCustomDTO populateROLFromBO(BaseAgreementModificationDetailsBO baModificationDetailsBO)
	{
		ROLModificationCustomDTO rolCustomDTO = new ROLModificationCustomDTO();
		if(baModificationDetailsBO != null)
		{
			rolCustomDTO.setAccountingContact(baModificationDetailsBO.getAccountingContact());
			rolCustomDTO.setAgreementId(baModificationDetailsBO.getAgreementId());
			rolCustomDTO.setLegalContract(baModificationDetailsBO.getLegalContract());
			rolCustomDTO.setRevenueRecognition(baModificationDetailsBO.getRevenueRecognition());
			rolCustomDTO.setDetails(baModificationDetailsBO.getDetails());
			rolCustomDTO.setModificationTypeCode(baModificationDetailsBO.getModificationTypeCode());
			rolCustomDTO.setModifiedLetterHead(baModificationDetailsBO.getModifiedIBMLetterHead());
			rolCustomDTO.setRolStartDate(baModificationDetailsBO.getRolStartDate());
			rolCustomDTO.setRolEndDate(baModificationDetailsBO.getRolEndDate());
			rolCustomDTO.setModificationOption(baModificationDetailsBO.getModificationOption());
			rolCustomDTO.setChangedBy(baModificationDetailsBO.getChangedBy());
			rolCustomDTO.setCreatedBy(baModificationDetailsBO.getCreatedBy());
			rolCustomDTO.setChangedDate(baModificationDetailsBO.getChangedDate());
			rolCustomDTO.setCreatedDate(baModificationDetailsBO.getCreatedDate());	
			rolCustomDTO.setStatus(baModificationDetailsBO.getModStatus());
		}
		return rolCustomDTO;
	}
	
	/**
	 * Register Base Agreement used to register Agreement
     * @param baDetailsCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @return
     * @author Sudharsan
     */
    public BaseAgreementDetailsCustomDTO registerBaseAgreement(BaseAgreementDetailsCustomDTO baDetailsCustomDTO) throws ServiceException
	{  
    	
        TimeTaken log = new TimeTaken(CLASS_NAME, "registerBaseAgreement");
    	boolean valid = false;
    	BaseAgreementBO baBO = new BaseAgreementBO();
		populateBOFromDTO(baDetailsCustomDTO,baBO);
		int agreementId = getBaseAgreementID();
		baBO.setAgreementStatus(BaseAgreementStatusConstant.Active);
		baBO.setAgreementId(agreementId);
		try
		{
			HashMap compareValues = getComapareValues(baDetailsCustomDTO);
			baBO.validateAgreementHeader(compareValues);
		}catch(DomainException de)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "registerBaseAgreement", null, de);
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
		}
		valid = formValidation(baBO,false,0);
		if (valid)
		{
		   // Validate for Base Agreement With CBS 
		   validateCreateBaseAgreement(baBO,baDetailsCustomDTO);
		   ArrayList modificationList = new ArrayList();
		   
		   if (baDetailsCustomDTO.getModificationDetailsMap() != null)
	        {
		       modificationList = performModificationValidation(agreementId,baDetailsCustomDTO,baBO,false);
	        }
		  // Insert into database
		  insertBaseAgreement(baBO);
		  insertModificationDetails(modificationList);
		} else {
			     try
			      {
				    baBO.validateForFormNumber(valid);
			      }catch (DomainException de)
			       { 
				        throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
			       }
		       }
		ErrorReport messages = baDetailsCustomDTO.getMessageReport();
		if(messages == null ) {
	   		messages = new ErrorReport();
	   	}
		String[] msgStr = {"Customer number : "+baDetailsCustomDTO.getCustomerNumber()+ " and Customer name : "+ baDetailsCustomDTO.getCustomerName()};
		ErrorEntry errorEntry = new ErrorEntry(msgStr);
		messages.addErrorEntry(new ErrorKey(ErrorCodeConstants.SE0805,OPPTMessageCatalog.TYPE_SERVICE), errorEntry);
		baDetailsCustomDTO.setMessageReport(messages);
		
		log.end();
		return baDetailsCustomDTO;
	}
	
   	
	private ArrayList performModificationValidation(int agreementId, 
			                                        BaseAgreementDetailsCustomDTO baseAgreementDetailsCustomDTO,
			                                        BaseAgreementBO baseAgreementBO,boolean amend)  throws ServiceException  {
		 ArrayList modList = new ArrayList();
		 
		 TreeMap modificationTreeMap = baseAgreementDetailsCustomDTO.getModificationDetailsMap();
		 Set modificationSet = modificationTreeMap.keySet();
		    Iterator modificationIterator = modificationSet.iterator();
		    java.util.Date today = new java.util.Date();
		     while(modificationIterator.hasNext())
		    {
		    	String typeCode = (String) modificationIterator.next();
		    	BaseAgreementModificationDetailsBO modificationDetailsBO = new BaseAgreementModificationDetailsBO();
		    	if((BaseAgreementModificationConstants.ROL).equals(typeCode))
		    	{
		    		ROLModificationCustomDTO rolModificationCustomDTO = (ROLModificationCustomDTO)modificationTreeMap.get(typeCode);
		    		if(rolModificationCustomDTO.getRolStartDate() != null)
		    		{
		    			modificationDetailsBO.setRolStartDate(new java.sql.Date(rolModificationCustomDTO.getRolStartDate().getTime()));
		    		}
		    		if(rolModificationCustomDTO.getRolEndDate() != null)
		    		{
		    			modificationDetailsBO.setRolEndDate(new java.sql.Date(rolModificationCustomDTO.getRolEndDate().getTime()));
		    		}
		    		modificationDetailsBO.setModificationOption(OPPTHelper.trimString(rolModificationCustomDTO.getModificationOption()));
		    		populateModificationDetailsBO(rolModificationCustomDTO, modificationDetailsBO);
		    		modificationDetailsBO.setAgreementId(agreementId);
		    	} else {
		    		ModificationCustomDTO modificationCustomDTO = (ModificationCustomDTO)modificationTreeMap.get(typeCode); 
		    		populateModificationDetailsBO(modificationCustomDTO, modificationDetailsBO);
		    		modificationDetailsBO.setAgreementId(agreementId);
		    	}
		    	if (amend)
		    	{
		    		modificationDetailsBO.setChangedBy(baseAgreementDetailsCustomDTO.getUserId());
		    		modificationDetailsBO.setChangedDate((new java.sql.Date(today.getTime())));
		    		validateUpdateModification(baseAgreementBO,baseAgreementDetailsCustomDTO,modificationDetailsBO);
		    	}else{
		    		modificationDetailsBO.setCreatedBy(baseAgreementDetailsCustomDTO.getUserId());
			    	modificationDetailsBO.setCreatedDate((new java.sql.Date(today.getTime())));
		    	    validateCreateModification(baseAgreementBO,baseAgreementDetailsCustomDTO,modificationDetailsBO);
		    	}
		    	modList.add(modificationDetailsBO);
		    }
		return modList;
	}
	
	/**
	 * Register Base Agreement used to register Agreement
     * @param baDetailsCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @return
     * @author Sudharsan
     */
	private void insertBaseAgreement(BaseAgreementBO baBO) throws ServiceException 
	{		
		int agreementId = getBaseAgreementID();
		baBO.setAgreementId(agreementId);	
		BaseAgreementBOFactory baBOFactory = new BaseAgreementBOFactory();
		try
		{
	    	baBOFactory.createBaseAgreement(baBO);
    	}catch(DomainException de)
		{
    		OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "insertBaseAgreement", null, de);
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
		}
	    
	}
	
	/**
	 * Register Base Agreement used to register Agreement
     * @param baDetailsCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @return
     * @author Sudharsan
     */
	private void insertModificationDetails(ArrayList baseAgreementModificationDetailsBOList) throws ServiceException 
	{		
		BaseAgreementModificationDetailsBO modificationDetailsBO = new BaseAgreementModificationDetailsBO();
		BaseAgreementModificationDetailsBOFactory baModificationDetailsBOFactory = new BaseAgreementModificationDetailsBOFactory();
	    for(int i=0;i< baseAgreementModificationDetailsBOList.size();i++)
	    {
	    	modificationDetailsBO = (BaseAgreementModificationDetailsBO)baseAgreementModificationDetailsBOList.get(i);
	    	try
			{
	    		baModificationDetailsBOFactory.createBaseAgreementModification(modificationDetailsBO);
	    	}catch(DomainException de)
			{
	    		OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "insertBaseAgreementDetails", null, de);
				throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
			}
	    }
	}
	
	
	private void updateModificationDetails(ArrayList baseAgreementModificationDetailsBOList) throws ServiceException 
	 {  
	     BaseAgreementModificationDetailsBO modificationDetailsBO = null;
	     BaseAgreementModificationDetailsBOFactory baModificationDetailsBOFactory = new BaseAgreementModificationDetailsBOFactory();
	     for(int i=0;i< baseAgreementModificationDetailsBOList.size();i++)
	     {
	        
	         modificationDetailsBO = (BaseAgreementModificationDetailsBO)baseAgreementModificationDetailsBOList.get(i);
	      try
	   {
	       baModificationDetailsBOFactory.updateBaseAgreementModification(modificationDetailsBO);
	      }catch(DomainException de)
	   {
	       OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "updateBaseAgreementDetails", null, de);
	    throw ExceptionGenerator.generateServiceException(de.getErrorReport()); 
	   }
	     }
	 }
	
	private void populateBOFromDTO(BaseAgreementDetailsCustomDTO baDetailsCustomDTO, BaseAgreementBO baBO) throws ServiceException
	{
		if(baDetailsCustomDTO != null)
		{	
			TreeMap modificationTreeMap = baDetailsCustomDTO.getModificationDetailsMap();	
			baBO.setAgreementId(baDetailsCustomDTO.getAgreementId());
			baBO.setAcceptedDate(new Date(baDetailsCustomDTO.getAcceptedDate().getTime()));
			baBO.setAgreementNumber(baDetailsCustomDTO.getAgreementNumber());
			baBO.setAgreementStatus(baDetailsCustomDTO.getAgreementStatus());
			baBO.setBranchOffice(baDetailsCustomDTO.getBranchOffice());
			baBO.setCoverageType(baDetailsCustomDTO.getCoverageType());
			baBO.setCreatedBy(baDetailsCustomDTO.getUserId());
			baBO.setCustomerName(baDetailsCustomDTO.getCustomerName());
			baBO.setCustomerNumber(baDetailsCustomDTO.getCustomerNumber());
			baBO.setCustomerRepresentative(baDetailsCustomDTO.getCustomerRepresentative());
			baBO.setEnterpriseName(baDetailsCustomDTO.getEnterpriseName());
			baBO.setEnterpriseNumber(baDetailsCustomDTO.getEnterpriseNumber());
			baBO.setFileNumber(baDetailsCustomDTO.getFileNumber());
			baBO.setFormNumber(baDetailsCustomDTO.getFormNumber());
			baBO.setImageReferenceNumber(baDetailsCustomDTO.getImageReferenceNumber());
			baBO.setOneWay(baDetailsCustomDTO.getOneWay());
			baBO.setIsElectronicSubmitter(baDetailsCustomDTO.getIsElectronicSumbmitter());
			baBO.setIsModifiedAgreement(UtilityConstants.NO);
			if(baDetailsCustomDTO.getChangedBy() != null) 
			{
				baBO.setChangedBy(baDetailsCustomDTO.getChangedBy());
			}
			java.util.Date today = new java.util.Date();
			baBO.setCreatedDate((new java.sql.Date(today.getTime())));
			baBO.setSalesOrganization(baDetailsCustomDTO.getSalesOrganization());
			if(baDetailsCustomDTO.getExpirationDate() != null) 
			{
				baBO.setExpirationDate(new Date(baDetailsCustomDTO.getExpirationDate().getTime()));
			}
			if((modificationTreeMap != null) && modificationTreeMap.size() > 0 )
			{
				baBO.setIsModifiedAgreement(UtilityConstants.YES);
			}
			
			baBO.setInac(baDetailsCustomDTO.getInac());
			baBO.setLegacyCustomerNumber(baDetailsCustomDTO.getLegacyCustomerNumber());
			baBO.setAccountingContactHdr(baDetailsCustomDTO.getAccountingContactHdr());
			baBO.setLegalContactHdr(baDetailsCustomDTO.getLegalContactHdr());
			
		}
		
	}
	
	private void populateModificationDetailsBO(ModificationCustomDTO modificationCustomDTO, BaseAgreementModificationDetailsBO modificationDetailsBO)
	{
		if(modificationCustomDTO != null)
		{
			modificationDetailsBO.setAccountingContact(modificationCustomDTO.getAccountingContact());
			modificationDetailsBO.setAgreementId(modificationCustomDTO.getAgreementId());
			modificationDetailsBO.setDetails(modificationCustomDTO.getDetails());
			modificationDetailsBO.setLegalContract(modificationCustomDTO.getLegalContract());
			modificationDetailsBO.setModificationTypeCode(modificationCustomDTO.getModificationTypeCode());
			modificationDetailsBO.setModifiedIBMLetterHead(modificationCustomDTO.getModifiedLetterHead());
			modificationDetailsBO.setRevenueRecognition(modificationCustomDTO.getRevenueRecognition());
			modificationDetailsBO.setChangedBy(modificationCustomDTO.getChangedBy());
			modificationDetailsBO.setCreatedBy(modificationCustomDTO.getUserId());
			modificationDetailsBO.setModStatus(OPPTHelper.trimString(modificationCustomDTO.getStatus()));
			if(modificationCustomDTO.getChangedDate() != null)
			{
				modificationDetailsBO.setChangedDate(new Date(modificationCustomDTO.getChangedDate().getTime()));
			}			
			if(modificationCustomDTO.getCreatedDate() != null)
			{
				modificationDetailsBO.setCreatedDate(new Date(modificationCustomDTO.getCreatedDate().getTime()));
			}
		}
	}
	
	/**
	 * inActivate BaseAgreement used to inactivate BaseAgreement
     * @param baCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @return
     * @author Sasi R Challa
     */
    public BaseAgreementCustomDTO inActivateBaseAgreement(BaseAgreementCustomDTO baCustomDTO) throws ServiceException
	{
    	TimeTaken log = new TimeTaken(CLASS_NAME, "inActivateBaseAgreement");
    	
		int agreementId = baCustomDTO.getAgreementId();
		try
		{
			HashMap compareValues = new HashMap();
			compareValues.put(UtilityConstants.BO_ROLE, new Integer(baCustomDTO.getBaUserRole()));
			BaseAgreementBOFactory baBOFactory = new BaseAgreementBOFactory(); 
			BaseAgreementBO baBO = new BaseAgreementBO();
			baBO.setAgreementStatus(baCustomDTO.getAgreementStatus());
			baBO.validateForInactive(compareValues);
			//	Added by Balaji
			baBO = baBOFactory.getBaseAgreementBO(baCustomDTO.getAgreementId());
			baBO.setChangedBy(baCustomDTO.getUserId());
			java.util.Date today = new java.util.Date();
			baBO.setChangedDate((new java.sql.Date(today.getTime())));
			baBO.setAgreementStatus(BaseAgreementStatusConstant.Inactive);
			validateUpdateBaseAgreement(baBO,baCustomDTO.getSessionId());
			baBOFactory.updateBaseAgreementBO(baBO);
			BaseAgreementChangeLogBO baChangeLogBO = new BaseAgreementChangeLogBO();
			baChangeLogBO.setAgreementId(baCustomDTO.getAgreementId());
			baChangeLogBO.setChangedBy(baCustomDTO.getUserId());
			baChangeLogBO.setChangedDate((new java.sql.Date(today.getTime())));
			baChangeLogBO.setChangedTime(new java.sql.Time(today.getTime()));
			StringBuffer changeHistory = new StringBuffer();
	 		changeHistory.append(UtilityConstants.BA_STATUS).append(",")
            		     .append("Active").append(",")
						 .append("Inactive").append(UtilityConstants.CHANGEDETAILS_VARIETOR);
			baChangeLogBO.setChangedDetails(changeHistory.toString());
			insertChangeLog(baChangeLogBO);
		}catch(DomainException de)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "inActivateBaseAgreement", null, de);
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
		}
		//updateBaseAgreementStatus(agreementId,BaseAgreementStatusConstant.Inactive);
		
		return baCustomDTO;	
	}
	
	private void updateBaseAgreementStatus(int agreementId, String statusCode) throws ServiceException
	{
		try
		{
			BaseAgreementBOFactory baBOFactory = new BaseAgreementBOFactory();
			BaseAgreementBO baseAgreementBO =  baBOFactory.getBaseAgreementBO(agreementId);
			baseAgreementBO.setAgreementStatus(statusCode);
			baBOFactory.updateBaseAgreementBO(baseAgreementBO);
		}catch(DomainException de){
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "updateBaseAgreementStatus", null, de);
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
		}
	}
	
	 /**
	 * reActivate BaseAgreement used to inactivate BaseAgreement
     * @param baCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @return
     * @author Sudharsan
     */
    public BaseAgreementCustomDTO reActivateBaseAgreement(BaseAgreementCustomDTO baCustomDTO) throws ServiceException
	{
    	TimeTaken log = new TimeTaken(CLASS_NAME, "reActivateBaseAgreement");
		int agreementId = baCustomDTO.getAgreementId();
		boolean valid = false;
		try
		{
			HashMap compareValues = new HashMap();
			compareValues.put(UtilityConstants.BO_ROLE, new Integer(baCustomDTO.getBaUserRole()));
			BaseAgreementBOFactory baBOFactory = new BaseAgreementBOFactory(); 
			BaseAgreementBO baBO = new BaseAgreementBO();
			baBO.setAgreementStatus(baCustomDTO.getAgreementStatus());
			baBO.validateForActive(compareValues);
			baBO = baBOFactory.getBaseAgreementBO(baCustomDTO.getAgreementId());
			valid = formValidation(baBO,false,0);
			if(valid){
			baBO.setChangedBy(baCustomDTO.getUserId());
			java.util.Date today = new java.util.Date();
			baBO.setChangedDate((new java.sql.Date(today.getTime())));
			baBO.setAgreementStatus(BaseAgreementStatusConstant.Active);
			validateUpdateBaseAgreement(baBO,baCustomDTO.getSessionId());
			baBOFactory.updateBaseAgreementBO(baBO);
			BaseAgreementChangeLogBO baChangeLogBO = new BaseAgreementChangeLogBO();
			baChangeLogBO.setAgreementId(baCustomDTO.getAgreementId());
			baChangeLogBO.setChangedBy(baCustomDTO.getUserId());
			baChangeLogBO.setChangedDate((new java.sql.Date(today.getTime())));
			baChangeLogBO.setChangedTime(new java.sql.Time(today.getTime()));
			StringBuffer changeHistory = new StringBuffer();
	 		changeHistory.append(UtilityConstants.BA_STATUS).append(",")
            		     .append("Inactive").append(",")
						 .append("Active").append(UtilityConstants.CHANGEDETAILS_VARIETOR);
			baChangeLogBO.setChangedDetails(changeHistory.toString());
			insertChangeLog(baChangeLogBO);

			}else {
			     try
			      {
				    baBO.validateForFormNumber(valid);
			      }catch (DomainException de)
			       { 
				        throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
			       }
		       }
		}catch(DomainException de)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "reActivateBaseAgreement", null, de);
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
		}
		//updateBaseAgreementStatus(agreementId,BaseAgreementStatusConstant.Inactive);
		
		return baCustomDTO;	
	}


	
	
	private int getBaseAgreementID() throws ServiceException
	{
		BaseAgreementBOFactory baBOFactory = new BaseAgreementBOFactory();
		BaseAgreementBO maxBaseAgreementBO = null;
		try
		{
			maxBaseAgreementBO = baBOFactory.findMaxBaseAgreementBO();
		}catch(DomainException de){
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "getBaseAgreementID", null, de);
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
		}
		int agreementId = maxBaseAgreementBO.getAgreementId() + 1;	
		return agreementId;
	}
	/**
	 * getBaseAgreementChangeLogDetails used to get change log Details
     * @param BaseAgreementChangeLogDetailsCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @return
     * @author Thirumalai kumar
     */
	
    public BaseAgreementChangeLogDetailsCustomDTO getBaseAgreementChangeLogDetails(BaseAgreementChangeLogDetailsCustomDTO baChangeLogDetailsCustomDTO) throws ServiceException
	{
    	TimeTaken log = new TimeTaken(CLASS_NAME, "getBaseAgreementChangeLogDetails");
    	
    	int agreementId = 0; 
		BaseAgreementDAO baseAgreementDAO = new BaseAgreementDAO();
		BaseAgreementChangeLogBOFactory baChangeLogBOFactory = new BaseAgreementChangeLogBOFactory();
		ArrayList baChangeLogBOList = null;

		String agreeementNumber = OPPTHelper.trimStringToNull(baChangeLogDetailsCustomDTO.getAgreementNumber());
		String salesOrg         = OPPTHelper.trimStringToNull(baChangeLogDetailsCustomDTO.getSalesOrg());
		String customerNumber   = OPPTHelper.trimStringToNull(baChangeLogDetailsCustomDTO.getCustomerNumber());
		String enterprseNumber  = OPPTHelper.trimStringToNull(baChangeLogDetailsCustomDTO.getEnterpriseNumber());
		
		try {
		    baChangeLogBOList = baseAgreementDAO.getBaseAgreementId(agreeementNumber, salesOrg, customerNumber, enterprseNumber);
		} catch(Exception de){		
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"getBaseAgreementChangeLogDetails",de.getMessage());
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0807);	
		}
		
	
		ArrayList changeLogList = new ArrayList();
		baChangeLogDetailsCustomDTO.setIsModified("Yes");
		if(baChangeLogBOList != null && baChangeLogBOList.size() != 0)
		{
			Iterator baChangeLogBOIterator = baChangeLogBOList.iterator();
			while(baChangeLogBOIterator.hasNext())
			{
				BaseAgreementChangeLogCustomDTO baChangeLogCustomDTO = new BaseAgreementChangeLogCustomDTO();
				BaseAgreementChangeLogBO baChangeLogBO = (BaseAgreementChangeLogBO)baChangeLogBOIterator.next();
				baChangeLogCustomDTO.setChangeId(baChangeLogBO.getChangeId());
				baChangeLogCustomDTO.setAgreementId(baChangeLogBO.getAgreementId());
				baChangeLogCustomDTO.setUserId(baChangeLogBO.getChangedBy());
				baChangeLogCustomDTO.setChangeOfDate(baChangeLogBO.getChangedDate());
				baChangeLogCustomDTO.setChangedTime(baChangeLogBO.getChangedTime());
				baChangeLogCustomDTO.setChangedValues(baChangeLogBO.getChangedDetails());
				changeLogList.add(baChangeLogCustomDTO);
				 //baChangeLogDetailsCustomDTO.setIsModified("Yes");
			}
			baChangeLogDetailsCustomDTO.setChangeDetailslist(changeLogList);
			baChangeLogDetailsCustomDTO.setIsModified("No");
		}
		 
		return baChangeLogDetailsCustomDTO;
	}

    /**
	 * amendBase Agreement used to update BaseAgreement Details
     * @param baDetailsCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @return
     * @author Sasi R Challa
     */
    public BaseAgreementDetailsCustomDTO amendBaseAgreement(BaseAgreementDetailsCustomDTO baDetailsCustomDTO) throws ServiceException
	{
    	TimeTaken log = new TimeTaken(CLASS_NAME, "amendBaseAgreement");
		BaseAgreementBO originalBABO = new BaseAgreementBO();
		boolean amend = true;
	    TreeMap oldTypeCodeMap = new TreeMap();
	    TreeMap newTypeCodeMap = new TreeMap();
		BaseAgreementChangeLogBO baChangeLogBO = new BaseAgreementChangeLogBO();
		BaseAgreementDetailsCustomDTO originalBADetailsCustomDTO = new BaseAgreementDetailsCustomDTO();
		originalBADetailsCustomDTO.setAgreementId(baDetailsCustomDTO.getAgreementId());

		try
		{
			BaseAgreementBOFactory baBOFactory = new BaseAgreementBOFactory();
			originalBABO =  baBOFactory.getBaseAgreementBO(baDetailsCustomDTO.getAgreementId());
			originalBADetailsCustomDTO = getBaseAgreement(originalBADetailsCustomDTO);
			java.util.Date today = new java.util.Date();
			
			baChangeLogBO.setAgreementId(baDetailsCustomDTO.getAgreementId());
		    baChangeLogBO.setChangedBy(baDetailsCustomDTO.getUserId());
			baChangeLogBO.setChangedDate((new java.sql.Date(today.getTime())));
			baChangeLogBO.setChangedTime(new java.sql.Time(today.getTime()));
			baChangeLogBO.setChangedDetails(generateChangeHistory(originalBADetailsCustomDTO,baDetailsCustomDTO).toString());
		    oldTypeCodeMap = originalBADetailsCustomDTO.getModificationDetailsMap();
		    newTypeCodeMap = baDetailsCustomDTO.getModificationDetailsMap();	
		    ArrayList modifiedTypeCodeList = checkModificationChanges(oldTypeCodeMap,newTypeCodeMap);
			HashMap compareValues = getComapareValues(baDetailsCustomDTO);
			//originalBABO.setAgreementStatus(baDetailsCustomDTO.getAgreementStatus());
			originalBABO.validateForInactive(compareValues);
			populateBOFromDTO(baDetailsCustomDTO,originalBABO);
			originalBABO.setChangedDate((new java.sql.Date(today.getTime())));
			originalBABO.setChangedBy(baDetailsCustomDTO.getUserId());
			originalBABO.setAgreementStatus(BaseAgreementStatusConstant.Active);
			originalBABO.validateAgreementHeader(compareValues);
			originalBABO.setPreviousAgreementId(0);
			boolean valid = formValidation(originalBABO,true,baDetailsCustomDTO.getAgreementId());
			if (valid)
			{
			    // Validate for Base Agreement With CBS 
				validateUpdateBaseAgreement(originalBABO,baDetailsCustomDTO.getSessionId());
			    // update into baseagreement table
			    baBOFactory.updateBaseAgreementBO(originalBABO);
			    // Update into bamodification details table
			    baDetailsCustomDTO.setModificationDetailsMap((TreeMap)modifiedTypeCodeList.get(0));
			   
			    ArrayList modificationList = new ArrayList();
			    if (baDetailsCustomDTO.getModificationDetailsMap() != null)
		        {
				  modificationList = performModificationValidation(originalBABO.getAgreementId(),baDetailsCustomDTO,originalBABO,amend);
				  if(modificationList.size() > 0)
				    updateModificationDetails(modificationList);
		        }
			    // Insert into bamodification details table
			    baDetailsCustomDTO.setModificationDetailsMap((TreeMap)modifiedTypeCodeList.get(1));
				if (baDetailsCustomDTO.getModificationDetailsMap() != null)
			    {
					  modificationList = performModificationValidation(originalBABO.getAgreementId(),baDetailsCustomDTO,originalBABO,false);
					  if(modificationList.size() > 0)
					    insertModificationDetails(modificationList);
			    }
			    // Insert into base agreement change log table
			    if(baChangeLogBO.getChangedDetails().length() > 0) {
			       insertChangeLog(baChangeLogBO);
			    }
			}else {
				   try
				    {
				       originalBABO.validateForFormNumber(valid);
				    }catch (DomainException de)
				     { 
					  throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
				     }
			      }
		}catch(DomainException de){
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "amendBaseAgreement", null, de);
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
		}finally {
			log.end();
		}
		ErrorReport messages = baDetailsCustomDTO.getMessageReport();
		if(messages == null ) {
	   		messages = new ErrorReport();
	   	}
		String[] msgStr = {"Customer number : "+originalBABO.getCustomerNumber()+ " and Customer name : "+ originalBABO.getCustomerName()};
		ErrorEntry errorEntry = new ErrorEntry(msgStr);
		messages.addErrorEntry(new ErrorKey(ErrorCodeConstants.SE0806,OPPTMessageCatalog.TYPE_SERVICE), errorEntry);
		baDetailsCustomDTO.setMessageReport(messages);
		return baDetailsCustomDTO;
	}
	
	private HashMap getComapareValues(BaseAgreementDetailsCustomDTO baDetailsCustomDTO)
	{
		HashMap compareValues = new HashMap();
		compareValues.put(UtilityConstants.BO_ROLE, new Integer(baDetailsCustomDTO.getBaUserRole()));
		return compareValues;
	}
	/**
	 * Validate Agreement Header method used to validate all mandatory fields
     * @param baseAgreementDetailsCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @return
     * @author Sudharsan
     */
    public BaseAgreementDetailsCustomDTO validateAgreementHeader(BaseAgreementDetailsCustomDTO baseAgreementDetailsCustomDTO) throws ServiceException {
    	TimeTaken log = new TimeTaken(CLASS_NAME, "validateAgreementHeader");
		BaseAgreementBO baBO = new BaseAgreementBO();
		populateBOFromDTO(baseAgreementDetailsCustomDTO,baBO);
		boolean valid = false;
		try
		{
			HashMap compareValues = getComapareValues(baseAgreementDetailsCustomDTO);
			baBO.validateAgreementHeader(compareValues);
			if(baBO.getAgreementId() > 0) {
				valid = formValidation(baBO,true,baBO.getAgreementId());
			}else {
				valid = formValidation(baBO,false,0);
			}
		}catch(DomainException de)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "validateAgreementHeader", null, de);
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());
		}
		// To validate the base agreement changed
		if(!valid) {
		     try
		      {
			    baBO.validateForFormNumber(valid);
		      }catch (DomainException de)
		       { 
			        throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
		       }
	    }
		log.end();
		return baseAgreementDetailsCustomDTO;
	}
    
    /**
	 *  
	 * Common method to throw BackendException 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorCode
	 * @throws ServiceException
	 * @author balajiv
	 */
    
    private void validateCreateBaseAgreement(BaseAgreementBO baseAgreementBO,BaseAgreementDetailsCustomDTO baseAgreementDetailsCustomDTO) throws ServiceException {
    	
    	boolean validateWithCBS = false;
    	if(OPPTPropertiesReader.getMBECBSCodeReady() != null && "true".equals(OPPTPropertiesReader.getMBECBSCodeReady())){
    		validateWithCBS = true;
    	}
    	
    	if(validateWithCBS) {
    		JMSConnectorLocal jmsConnectorLocal = null;
    		try {
    			jmsConnectorLocal = (JMSConnectorLocal) HomeProvider.getJMSConnectorLocal();
    		} catch (CreateException e) {
    			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "validateCreateBaseAgreement", null, e);
    			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);

    		}	
    		CreateBaseAgreementInputConnectorDTO connectorInputDTO = BaseAgreementConnectorDTOBuilder.buildCreateBaseAgreementInputConnectorDTO(baseAgreementBO);
    		// 	Common Values which needs to be set
    		connectorInputDTO.setFunctionModuleName(ConnectorConstants.RFC_BASE_AGREEMENT_CREATE);
    		connectorInputDTO.setSessionID(baseAgreementDetailsCustomDTO.getSessionId());
    		CreateBaseAgreementOutputConnectorDTO connectorOutputDTO = null;
    		try {
    			connectorOutputDTO = (CreateBaseAgreementOutputConnectorDTO) jmsConnectorLocal.sendReceive(connectorInputDTO);
    			OPPTLogger.debug("RFC RETURN CODE :" + connectorOutputDTO.getReturnCode(), CLASS_NAME, "validateCreateBaseAgreement");
    		} catch (Exception e1) {
    			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "validateCreateBaseAgreement", null, e1);
    			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
    		}
    		// if return code is not zero then throw a new service Exception e.
    			if (!ConnectorConstants.RFC_SUCCESS_CODE.equals(connectorOutputDTO.getReturnCode())) {
    			throwServiceException(connectorOutputDTO.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
    		}
    	}
    	
    }
    
    /**
	 *  
	 * Common method to throw BackendException 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorCode
	 * @throws ServiceException
	 * @author balajiv
	 */
    private void validateUpdateBaseAgreement (BaseAgreementBO baseAgreementBO,String sessionId) throws ServiceException {
    	boolean validateWithCBS = false;
    	if(OPPTPropertiesReader.getMBECBSCodeReady() != null && "true".equals(OPPTPropertiesReader.getMBECBSCodeReady())){
    		validateWithCBS = true;
    	}
    	if(validateWithCBS) {
    	JMSConnectorLocal jmsConnectorLocal = null;
		try {
			jmsConnectorLocal = (JMSConnectorLocal) HomeProvider.getJMSConnectorLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "validateUpdateBaseAgreement", null, e);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);

		}
		UpdateBaseAgreementInputConnectorDTO connectorInputDTO = BaseAgreementConnectorDTOBuilder.buildUpdateBaseAgreementInputConnectorDTO(baseAgreementBO);
		// Common Values which needs to be set
		connectorInputDTO.setFunctionModuleName(ConnectorConstants.RFC_BASE_AGREEMENT_UPDATE);
		connectorInputDTO.setSessionID(sessionId);
		UpdateBaseAgreementOutputConnectorDTO connectorOutputDTO = null;
		try {
			connectorOutputDTO = (UpdateBaseAgreementOutputConnectorDTO)jmsConnectorLocal.sendReceive(connectorInputDTO);
			OPPTLogger.debug("RFC RETURN CODE :" + connectorOutputDTO.getReturnCode(), CLASS_NAME, "validateUpdateBaseAgreement");
		} catch (Exception e1) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "validateUpdateBaseAgreement", null, e1);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		// if return code is not zero then throw a new service Exception e.
		if (!ConnectorConstants.RFC_SUCCESS_CODE.equals(connectorOutputDTO.getReturnCode())) {
			throwServiceException(connectorOutputDTO.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
		}
    	}
    }
    
    /**
	 *  
	 * validateCreateModification 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorCode
	 * @throws ServiceException
	 * @author balajiv
	 */
    private void validateCreateModification(BaseAgreementBO baseAgreementBO,
    		                                BaseAgreementDetailsCustomDTO baseAgreementDetailsCustomDTO,
											BaseAgreementModificationDetailsBO modDetailsBO)  throws ServiceException {
    	
    	boolean validateWithCBS = false;
    	if(OPPTPropertiesReader.getMBECBSCodeReady() != null && "true".equals(OPPTPropertiesReader.getMBECBSCodeReady())){
    		validateWithCBS = true;
    	}
    	if(validateWithCBS) {
    	JMSConnectorLocal jmsConnectorLocal = null;
		try {
			jmsConnectorLocal = (JMSConnectorLocal) HomeProvider.getJMSConnectorLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "validateCreateModification", null, e);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);

		}
		CreateModificationInputConnectorDTO connectorInputDTO = BaseAgreementConnectorDTOBuilder.buildCreateModificationInputConnectorDTO(baseAgreementBO,modDetailsBO);
		// Common Values which needs to be set
		connectorInputDTO.setFunctionModuleName(ConnectorConstants.RFC_BA_MODIFICATION_CREATE);
		connectorInputDTO.setSessionID(baseAgreementDetailsCustomDTO.getSessionId());
		CreateModificationOutputConnectorDTO connectorOutputDTO = null;
		try {
			connectorOutputDTO = (CreateModificationOutputConnectorDTO)jmsConnectorLocal.sendReceive(connectorInputDTO);
			OPPTLogger.debug("RFC RETURN CODE :" + connectorOutputDTO.getReturnCode(), CLASS_NAME, "validateCreateModification");
		} catch (Exception e1) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "validateCreateModification", null, e1);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		// if return code is not zero then throw a new service Exception e.
		if (!ConnectorConstants.RFC_SUCCESS_CODE.equals(connectorOutputDTO.getReturnCode())) {
			throwServiceException(connectorOutputDTO.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
		}
    	}
    	
    }
    /**
	 *  
	 * validateUpdateModification 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorCode
	 * @throws ServiceException
	 * @author balajiv
	 */
    private void validateUpdateModification(BaseAgreementBO baseAgreementBO,BaseAgreementDetailsCustomDTO baseAgreementDetailsCustomDTO,BaseAgreementModificationDetailsBO modDetailsBO)  throws ServiceException 
	{

    	boolean validateWithCBS = false;
    	if(OPPTPropertiesReader.getMBECBSCodeReady() != null && "true".equals(OPPTPropertiesReader.getMBECBSCodeReady())){
    	validateWithCBS = true;
    	}
    	if(validateWithCBS) {
    		JMSConnectorLocal jmsConnectorLocal = null;
    		try {
    			jmsConnectorLocal = (JMSConnectorLocal) HomeProvider.getJMSConnectorLocal();
    		} catch (CreateException e) {
    			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "validateUpdateModification", null, e);
    			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);

    		}
    		UpdateModificationInputConnectorDTO connectorInputDTO = BaseAgreementConnectorDTOBuilder.buildUpdateModificationInputConnectorDTO(baseAgreementBO,modDetailsBO);
    		// Common Values which needs to be set
    		connectorInputDTO.setFunctionModuleName(ConnectorConstants.RFC_BA_MODIFICATION_UPDATE);
    		connectorInputDTO.setSessionID(baseAgreementDetailsCustomDTO.getSessionId());
    		UpdateModificationOutputConnectorDTO connectorOutputDTO = null;
    		try {
    			connectorOutputDTO = (UpdateModificationOutputConnectorDTO) jmsConnectorLocal.sendReceive(connectorInputDTO);
    			
    			OPPTLogger.debug("RFC RETURN CODE :" + connectorOutputDTO.getReturnCode(), CLASS_NAME, "validateUpdateModification");
    		} catch (Exception e1) {
    			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "validateUpdateModification", null, e1);
    			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
    		}
    		// if return code is not zero then throw a new service Exception e.
    		if (!ConnectorConstants.RFC_SUCCESS_CODE.equals(connectorOutputDTO.getReturnCode())) {
    			throwServiceException(connectorOutputDTO.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
    		}
    	}

	}	


    
    /**
	 *  
	 * Common method to throw BackendException 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorCode
	 * @throws ServiceException
	 * @author balajiv
	 */
private void throwServiceException(String errorCode, int messageType) throws ServiceException {
	if (messageType == OPPTMessageCatalog.TYPE_BACKEND) {
		OPPTLogger.debug("Message Code = " + errorCode, CLASS_NAME, "throwServiceException");
		try {
			Integer.parseInt(errorCode);
		} catch (NumberFormatException ne) {
			errorCode = ErrorCodeConstants.CE0801;
		} catch (Exception e) {
			errorCode = ErrorCodeConstants.CE0801;
		}
	}
	ErrorReport errorReport = new ErrorReport();
	ErrorKey key = new ErrorKey(errorCode, messageType);
	errorReport.addErrorEntry(key, null);
	ServiceException se = new ServiceException();
	se.setErrorReport(errorReport);
	throw se;
}
/**
 *  
 * formValidation
 * <br><b>Known Bugs</b><br> 
 * 
 * <br><PRE> 
 * date Dec 8, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param errorCode
 * @throws ServiceException
 * @author balajiv
 * @return boolean
 */
private boolean formValidation(BaseAgreementBO baBO,boolean amend,int agreementId) throws ServiceException
{
	boolean valid = false;
	BaseAgreementBOFactory baBOFactory = new BaseAgreementBOFactory();
	try
	{
		valid =baBOFactory.checkValidity(baBO.getCustomerNumber(),baBO.getFormNumber(),amend,agreementId);
	}catch(DomainException de)
	{
		//OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "formValidation", null, de);
		//throw ExceptionGenerator.generateServiceException(de.getErrorReport());
	}
	return valid;
}

/**
 *  
 * formValidation
 * <br><b>Known Bugs</b><br> 
 * 
 * <br><PRE> 
 * date Dec 8, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param errorCode
 * @throws ServiceException
 * @author balajiv
 * @return boolean
 */
private ArrayList filterBaseAgreements(SearchBaseAgreementCustomDTO searchBaseAgreementCustomDTO, ArrayList baseAgreementBOList) throws DomainException {
    ArrayList baseAgreementList = new ArrayList();
	
	Iterator baseAgreementIterator = baseAgreementBOList.iterator();
	while(baseAgreementIterator.hasNext())
	{
		BaseAgreementBO baseAgreementBO = (BaseAgreementBO)baseAgreementIterator.next(); 
		BaseAgreementCustomDTO baseAgreementCustomDTO = populateCustomDTO(baseAgreementBO);
		baseAgreementList.add(baseAgreementCustomDTO);	
	}
	
	if(baseAgreementList == null && baseAgreementList.size() == 0) {
		throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE1000);
	}
	return baseAgreementList;
}

private String generateChangeHistory(BaseAgreementDetailsCustomDTO oldBA,BaseAgreementDetailsCustomDTO newBA) throws DomainException {
 	StringBuffer changeHistory = new StringBuffer();
 	
 	String oldSalesOrg = oldBA.getSalesOrganization() == null ? "" : oldBA.getSalesOrganization();
 	String newSalesOrg = newBA.getSalesOrganization() == null ? "" : newBA.getSalesOrganization();
 	if(!oldSalesOrg.equals(newSalesOrg)) {
 		changeHistory.append(UtilityConstants.SALES_ORG).append(",")
		             .append((String)OPPTStaticDataHolder.salesOrgMapForBaseAgreement.get(oldSalesOrg)+"-"+oldSalesOrg).append(",")
		             .append((String)OPPTStaticDataHolder.salesOrgMapForBaseAgreement.get(newSalesOrg)+"-"+newSalesOrg).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldAgreementNumber = oldBA.getAgreementNumber() == null ? "" : oldBA.getAgreementNumber();
 	String newAgreementNumber = newBA.getAgreementNumber() == null ? "" : newBA.getAgreementNumber();
 	if(! oldAgreementNumber.equals(newAgreementNumber)) {
 		changeHistory.append(UtilityConstants.AGREEMENT_NUMBER).append(",")
		             .append(oldAgreementNumber).append(",")
		             .append(newAgreementNumber).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldFormNumber = oldBA.getFormNumber() == null ? "" : oldBA.getFormNumber();
 	String newFormNumber = newBA.getFormNumber() == null ? "" : newBA.getFormNumber();
 	if(!oldFormNumber.equals(newFormNumber)) {
 		changeHistory.append(UtilityConstants.FORM_NUMBER).append(",")
		             .append(oldFormNumber).append(",")
		             .append(newFormNumber).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldCustomerNumber = oldBA.getCustomerNumber() == null ? "" : oldBA.getCustomerNumber();
 	String newCustomerNumber = newBA.getCustomerNumber() == null ? "" : newBA.getCustomerNumber();
 	if(!oldCustomerNumber.equals(newCustomerNumber)) {
 		changeHistory.append(UtilityConstants.CUSTOMER_NUMBER).append(",")
		             .append(oldCustomerNumber).append(",")
		             .append(newCustomerNumber).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldCustomerName = oldBA.getCustomerName() == null ? "" : oldBA.getCustomerName();
 	String newCustomerName = newBA.getCustomerName() == null ? "" : newBA.getCustomerName();
 	if(!oldCustomerName.equals(newCustomerName)) {
 		changeHistory.append(UtilityConstants.CUSTOMER_NAME).append(",")
		             .append(oldCustomerName).append(",")
		             .append(newCustomerName).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldEnterpriseNumber = oldBA.getEnterpriseNumber() == null ? "" : oldBA.getEnterpriseNumber();
 	String newEnterpriseNumber = newBA.getEnterpriseNumber() == null ? "" : newBA.getEnterpriseNumber();
 	if(!oldEnterpriseNumber.equals(newEnterpriseNumber)) {
 		changeHistory.append(UtilityConstants.ENTERPRISE_NUMBER).append(",")
		             .append(oldEnterpriseNumber).append(",")
		             .append(newEnterpriseNumber).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldEnterpriseName = oldBA.getEnterpriseName() == null ? "" : oldBA.getEnterpriseName();
 	String newEnterpriseName = newBA.getEnterpriseName() == null ? "" : newBA.getEnterpriseName();
 	if(!oldEnterpriseName.equals(newEnterpriseName)) {
 		changeHistory.append(UtilityConstants.ENTERPRISE_NAME).append(",")
		             .append(oldEnterpriseName).append(",")
		             .append(newEnterpriseName).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldFileNumber = oldBA.getFileNumber() == null ? "" : oldBA.getFileNumber();
 	String newFileNumber = newBA.getFileNumber() == null ? "" : newBA.getFileNumber();
 	if(!oldFileNumber.equals(newFileNumber)) {
 		changeHistory.append(UtilityConstants.FILE_NUMBER).append(",")
		             .append(oldFileNumber).append(",")
		             .append(newFileNumber).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}
 
 	String oldCoverageType = oldBA.getCoverageType() == null ? "" : oldBA.getCoverageType();
 	String newCoverageType = newBA.getCoverageType() == null ? "" : newBA.getCoverageType();
    if(!oldCoverageType.equals(newCoverageType)) {
 		changeHistory.append(UtilityConstants.COVERAGE_TYPE).append(",")
		             .append(OPPTStaticDataHolder.getCoverageTypeDescription(oldCoverageType)).append(",")
		             .append(OPPTStaticDataHolder.getCoverageTypeDescription(newCoverageType)).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldBranchOffice = oldBA.getBranchOffice() == null ? "" : oldBA.getBranchOffice();
 	String newBranchOffice = newBA.getBranchOffice() == null ? "" : newBA.getBranchOffice();
 	if(!oldBranchOffice.equals(newBranchOffice)) {
 		changeHistory.append(UtilityConstants.BRANCH_OFFICE).append(",")
		             .append(oldBranchOffice).append(",")
		             .append(newBranchOffice).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldCustomerRepresentative = oldBA.getCustomerRepresentative() == null ? "" : oldBA.getCustomerRepresentative();
 	String newCustomerRepresentative = newBA.getCustomerRepresentative() == null ? "" : newBA.getCustomerRepresentative();
 	if(!oldCustomerRepresentative.equals(newCustomerRepresentative)) {
 		changeHistory.append(UtilityConstants.CUSTOMER_REPRESENTATIVE).append(",")
		             .append(oldCustomerRepresentative).append(",")
		             .append(newCustomerRepresentative).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldImageReferenceNumber = oldBA.getImageReferenceNumber() == null ? "" : oldBA.getImageReferenceNumber();
 	String newImageReferenceNumber = newBA.getImageReferenceNumber() == null ? "" : newBA.getImageReferenceNumber();
 	if(!oldImageReferenceNumber.equals(newImageReferenceNumber)) {
 		changeHistory.append(UtilityConstants.IMAGE_REFERENCE_NO).append(",")
		             .append(oldImageReferenceNumber).append(",")
		             .append(newImageReferenceNumber).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldElectronicSumbmitter = oldBA.getIsElectronicSumbmitter() == null ? "" : (oldBA.getIsElectronicSumbmitter().equals("Y")?"Yes":"No");
 	String newElectronicSumbmitter = newBA.getIsElectronicSumbmitter() == null ? "" : (newBA.getIsElectronicSumbmitter().equals("Y")?"Yes":"No");
 	if(!oldElectronicSumbmitter.equals(newElectronicSumbmitter)) {
 		changeHistory.append(UtilityConstants.IS_ELECTRONIC_SUBMITTER).append(",")
		             .append(oldElectronicSumbmitter).append(",")
		             .append(newElectronicSumbmitter).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldOneWay = oldBA.getOneWay() == null ? "" : (oldBA.getOneWay().equals("Y")?"Yes":"No");
 	String newOneWay = newBA.getOneWay() == null ? "" : (newBA.getOneWay().equals("Y")?"Yes":"No");
 	if(!oldOneWay.equals(newOneWay)) {
 		changeHistory.append(UtilityConstants.ONE_WAY).append(",")
		             .append(oldOneWay).append(",")
		             .append(newOneWay).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}
 	OPPTCalender calender = new OPPTCalender();
 	String oldAcceptedDate = calender.getDateString(oldBA.getAcceptedDate()) == null ? "" : calender.getDateString(oldBA.getAcceptedDate());
 	String newAcceptedDate = calender.getDateString(newBA.getAcceptedDate()) == null ? "" : calender.getDateString(newBA.getAcceptedDate()); 	
 	if(!oldAcceptedDate.equals(newAcceptedDate)) {
 		changeHistory.append(UtilityConstants.ACCEPTED_DATE).append(",")
		             .append(oldAcceptedDate.equals("") ? "" :calender.getDateStringASMMDDYYYY(oldBA.getAcceptedDate())).append(",")
		             .append(newAcceptedDate.equals("") ? "" :calender.getDateStringASMMDDYYYY(newBA.getAcceptedDate())).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldExpirationDate = calender.getDateString(oldBA.getExpirationDate()) == null ? "" : calender.getDateString(oldBA.getExpirationDate());
 	String newExpirationDate = calender.getDateString(newBA.getExpirationDate()) == null ? "" : calender.getDateString(newBA.getExpirationDate()); 	
 	if(!oldExpirationDate.equals(newExpirationDate)) {
 		changeHistory.append(UtilityConstants.EXPIRATION_DATE).append(",")
		             .append(oldExpirationDate.equals("") ? "" :calender.getDateStringASMMDDYYYY(oldBA.getExpirationDate())).append(",")
		             .append(newExpirationDate.equals("") ? "" :calender.getDateStringASMMDDYYYY(newBA.getExpirationDate())).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldInac = oldBA.getInac() == null ? "" : oldBA.getInac();
 	String newInac = newBA.getInac() == null ? "" : newBA.getInac();
 	if(!oldInac.equals(newInac)) {
 		changeHistory.append(UtilityConstants.INAC).append(",")
		             .append(oldInac).append(",")
		             .append(newInac).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldLegacyCustomerNumber = oldBA.getLegacyCustomerNumber() == null ? "" : oldBA.getLegacyCustomerNumber();
 	String newLegacyCustomerNumber = newBA.getLegacyCustomerNumber() == null ? "" : newBA.getLegacyCustomerNumber();
 	if(!oldLegacyCustomerNumber.equals(newLegacyCustomerNumber)) {
 		changeHistory.append(UtilityConstants.LEGACY_CUSTOMER_NUMBER).append(",")
		             .append(oldLegacyCustomerNumber).append(",")
		             .append(newLegacyCustomerNumber).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldLegalContactHdr = oldBA.getLegalContactHdr() == null ? "" : oldBA.getLegalContactHdr();
 	String newLegalContactHdr = newBA.getLegalContactHdr() == null ? "" : newBA.getLegalContactHdr();
 	if(!oldLegalContactHdr.equals(newLegalContactHdr)) {
 		changeHistory.append(UtilityConstants.LEGAL_CONTACT_HDR).append(",")
		             .append(oldLegalContactHdr).append(",")
		             .append(newLegalContactHdr).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 	String oldAccountingContactHdr = oldBA.getAccountingContactHdr() == null ? "" : oldBA.getAccountingContactHdr();
 	String newAccountingContactHdr = newBA.getAccountingContactHdr() == null ? "" : newBA.getAccountingContactHdr();
 	if(!oldAccountingContactHdr.equals(newAccountingContactHdr)) {
 		changeHistory.append(UtilityConstants.ACCOUNTING_CONTACT_HDR).append(",")
		             .append(oldAccountingContactHdr).append(",")
		             .append(newAccountingContactHdr).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}

 /*	String oldAgreementStatus = oldBA.getAgreementStatus() == null ? "" : (oldBA.getAgreementStatus().equals("A")?"Active":"Inactive");
 	String newAgreementStatus = newBA.getAgreementStatus() == null ? "" : (newBA.getAgreementStatus().equals("A")?"Active":"Inactive");
 	if(!oldAgreementStatus.equals(newAgreementStatus)) {
 		changeHistory.append(UtilityConstants.BA_STATUS).append(",")
		             .append(oldAgreementStatus).append(",")
		             .append(newAgreementStatus).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	}*/
 	
 	TreeMap newModificationMap = new TreeMap();
 	newModificationMap.putAll(newBA.getModificationDetailsMap());
 	changeHistory.append(checkChangesInModificationTypes(oldBA.getModificationDetailsMap(),newModificationMap));
 	return changeHistory.toString();
 }
/**
 *  
 * checkChangesInModificationTypes
 * <br><b>Known Bugs</b><br> 
 * 
 * <br><PRE> 
 * date Dec 8, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param errorCode
 * @throws ServiceException
 * @author balajiv
 * @return String
 */
 
 private String checkChangesInModificationTypes(TreeMap oldModificationTypes,TreeMap newModificationTypes) {
    StringBuffer modificationTypeChanges = new StringBuffer(); 
 	Iterator oldModificationTypeIterator = oldModificationTypes.keySet().iterator();
 	while(oldModificationTypeIterator.hasNext()) {
 	  String modificationType = (String)oldModificationTypeIterator.next();
 	  ModificationCustomDTO oldModificationCustomDTO =(ModificationCustomDTO) oldModificationTypes.get(modificationType);
 	  if(newModificationTypes.containsKey(modificationType))
 	  {
 	  	  ModificationCustomDTO newModificationCustomDTO = (ModificationCustomDTO)newModificationTypes.get(modificationType);
 	  	  modificationTypeChanges.append(isModificationTypeExist(oldModificationCustomDTO,newModificationCustomDTO));
 	  	 // newModificationTypes.remove(modificationType);
 	  } else {
 	  	  modificationTypeChanges.append(isModificationTypeNotExist(oldModificationCustomDTO,"OLD"));
 	  }
 	}  
 	if(newModificationTypes.size() > 0 ) {
 	    Iterator newModificationTypeIterator = newModificationTypes.keySet().iterator();
 	 	while(newModificationTypeIterator.hasNext()) {
 	 		String modificationType = (String)newModificationTypeIterator.next();
            if(!oldModificationTypes.containsKey(modificationType))
             {   ModificationCustomDTO newModificationCustomDTO =(ModificationCustomDTO) newModificationTypes.get(modificationType);
                 modificationTypeChanges.append(isModificationTypeNotExist(newModificationCustomDTO,"NEW"));
             }   
 	    }
 	} 	
 	return modificationTypeChanges.toString();
 }
 /**
  *  
  * isModificationTypeExist
  * <br><b>Known Bugs</b><br> 
  * 
  * <br><PRE> 
  * date Dec 8, 2003 
  * 
  * revision date author reason 
  * 
  * </PRE><br> 
  * 
  * @param errorCode
  * @throws ServiceException
  * @author balajiv
  * @return String
  */
  
 private String isModificationTypeExist(ModificationCustomDTO oldModificationCustomDTO ,ModificationCustomDTO newModificationCustomDTO) {
     StringBuffer modificationTypeChanges = new StringBuffer(); 

  	String oldAccountingContact = oldModificationCustomDTO.getAccountingContact() == null ? "" : oldModificationCustomDTO.getAccountingContact();
  	String newAccountingContact = newModificationCustomDTO.getAccountingContact() == null ? "" : newModificationCustomDTO.getAccountingContact();
  	if(!oldAccountingContact.equals(newAccountingContact)) {
  		modificationTypeChanges.append(UtilityConstants.ACCOUNTING_CONTACT+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 		             .append(oldAccountingContact).append(",")
 		             .append(newAccountingContact).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
  	}

  	String oldLegalContract = oldModificationCustomDTO.getLegalContract() == null ? "" : oldModificationCustomDTO.getLegalContract();
  	String newLegalContract = newModificationCustomDTO.getLegalContract() == null ? "" : newModificationCustomDTO.getLegalContract();
  	if(!oldLegalContract.equals(newLegalContract)) {
  		modificationTypeChanges.append(UtilityConstants.LEGAL_CONTACT+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 		             .append(oldLegalContract).append(",")
 		             .append(newLegalContract).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
  	}

  	String oldModifiedLetterHead = oldModificationCustomDTO.getModifiedLetterHead() == null ? "" : oldModificationCustomDTO.getModifiedLetterHead();
  	String newModifiedLetterHead = newModificationCustomDTO.getModifiedLetterHead() == null ? "" : newModificationCustomDTO.getModifiedLetterHead();
  	if(!oldModifiedLetterHead.equals(newModifiedLetterHead)) {
  		modificationTypeChanges.append(UtilityConstants.MODIFIED_IBM_LETTERHEAD+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 		             .append(oldModifiedLetterHead.equals("Y")?"Checked":"Unchecked").append(",")
 		             .append(newModifiedLetterHead.equals("Y")?"Checked":"Unchecked").append(UtilityConstants.CHANGEDETAILS_VARIETOR);
  	}

  	String oldRevenueRecognition = oldModificationCustomDTO.getRevenueRecognition() == null ? "" : oldModificationCustomDTO.getRevenueRecognition();
  	String newRevenueRecognition = newModificationCustomDTO.getRevenueRecognition() == null ? "" : newModificationCustomDTO.getRevenueRecognition();
     if(!oldRevenueRecognition.equals(newRevenueRecognition)) {
  		modificationTypeChanges.append(UtilityConstants.REVENUE_RECOGNITION+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 		             .append(oldRevenueRecognition.equals("Y")?"Checked":"Unchecked").append(",")
 		             .append(newRevenueRecognition.equals("Y")?"Checked":"Unchecked").append(UtilityConstants.CHANGEDETAILS_VARIETOR);
  	}

 	if((BaseAgreementModificationConstants.ROL).equals(oldModificationCustomDTO.getModificationTypeCode()))
	{
		 	OPPTCalender calender = new OPPTCalender();
			String oldROLStartDate = calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolStartDate()) == null ? "" : calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolStartDate());
			String newROLStartDate = calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolStartDate()) == null ? "" : calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolStartDate());
		  	if(!oldROLStartDate.equals(newROLStartDate)) {
		  		modificationTypeChanges.append(UtilityConstants.ROL_STARTDATE+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
			                           .append(oldROLStartDate.equals("") ? "" :calender.getDateStringASMMDDYYYY(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolStartDate())).append(",")
	                                   .append(newROLStartDate.equals("") ? "" :calender.getDateStringASMMDDYYYY(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolStartDate())).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
		  	}

		  	String oldROLEndDate = calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolEndDate()) == null ? "" : calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolEndDate());
			String newROLEndDate = calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolEndDate()) == null ? "" : calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolEndDate());
		  	if(!oldROLEndDate.equals(newROLEndDate)) {
		  		modificationTypeChanges.append(UtilityConstants.ROL_ENDDATE+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
			                           .append(oldROLEndDate.equals("") ? "" :calender.getDateStringASMMDDYYYY(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolEndDate())).append(",")
	                                   .append(newROLEndDate.equals("") ? "" :calender.getDateStringASMMDDYYYY(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolEndDate())).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
		  	}

			String oldROLOption = ((ROLModificationCustomDTO)oldModificationCustomDTO).getModificationOption() == null ? "" : ((ROLModificationCustomDTO)oldModificationCustomDTO).getModificationOption();
			String newROLOption = ((ROLModificationCustomDTO)oldModificationCustomDTO).getModificationOption() == null ? "" : ((ROLModificationCustomDTO)oldModificationCustomDTO).getModificationOption();
		  	if(!oldROLOption.equals(newROLOption)) {
		  		modificationTypeChanges.append(UtilityConstants.ROL_OPTIONs+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
			                           .append(OPPTStaticDataHolder.rolOptionsMap.get(oldROLOption)).append(",")
	                                   .append(OPPTStaticDataHolder.rolOptionsMap.get(newROLOption)).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
		  	}

	}
 
  	String oldDetails = oldModificationCustomDTO.getDetails() == null ? "" : oldModificationCustomDTO.getDetails();
  	String newDetails = newModificationCustomDTO.getDetails() == null ? "" : newModificationCustomDTO.getDetails();
     if(!oldDetails.equals(newDetails)) {
  		modificationTypeChanges.append(UtilityConstants.MODIFICATION_DETAILS+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 		             .append(oldDetails).append(",")
 		             .append(newDetails).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
  	}
     
   	String oldStatus = oldModificationCustomDTO.getStatus() == null ? "" : oldModificationCustomDTO.getStatus().equals("A")?"Active":"Inactive";
  	String newStatus = newModificationCustomDTO.getStatus() == null ? "" : newModificationCustomDTO.getStatus().equals("A")?"Active":"Inactive";
     if(!oldStatus.equals(newStatus)) {
  		modificationTypeChanges.append(UtilityConstants.STATUS+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 		             .append(oldStatus).append(",")
 		             .append(newStatus).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
  	}

  	return modificationTypeChanges.toString();
  }
 /**
  *  
  * isModificationTypeNotExist
  * <br><b>Known Bugs</b><br> 
  * 
  * <br><PRE> 
  * date Dec 8, 2003 
  * 
  * revision date author reason 
  * 
  * </PRE><br> 
  * 
  * @param errorCode
  * @throws ServiceException
  * @author balajiv
  * @return String
  */
 private String isModificationTypeNotExist(ModificationCustomDTO oldModificationCustomDTO,String type) {
  	
     StringBuffer modificationTypeChanges = new StringBuffer(); 
     if(type.equals("OLD"))
     {	
     	String modificationTypeCode = oldModificationCustomDTO.getModificationTypeCode() == null ? "" : oldModificationCustomDTO.getModificationTypeCode();
 		modificationTypeChanges.append(UtilityConstants.MODIFICATION_TYPE).append(",")
 	    .append(modificationTypeCode).append(",")
 	    .append("").append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	
     	String accountingContact = oldModificationCustomDTO.getAccountingContact() == null ? "" : oldModificationCustomDTO.getAccountingContact();		
 		modificationTypeChanges.append(UtilityConstants.ACCOUNTING_CONTACT+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 	            .append(accountingContact).append(",")
 	            .append("").append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	

     	String legalContract = oldModificationCustomDTO.getLegalContract() == null ? "" : oldModificationCustomDTO.getLegalContract();		
     	if(legalContract.length() != 0) {
     	    modificationTypeChanges.append(UtilityConstants.LEGAL_CONTACT+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 		        .append(legalContract).append(",")
 	            .append("").append(UtilityConstants.CHANGEDETAILS_VARIETOR);
     	}

     	String modifiedLetterHead = oldModificationCustomDTO.getModifiedLetterHead() == null ? "" : oldModificationCustomDTO.getModifiedLetterHead();		
 		modificationTypeChanges.append(UtilityConstants.MODIFIED_IBM_LETTERHEAD+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 	            .append(modifiedLetterHead.equals("Y")?"Checked":"Unchecked").append(",")
 	            .append("").append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	
     	String revenueRecognition = oldModificationCustomDTO.getRevenueRecognition() == null ? "" : oldModificationCustomDTO.getRevenueRecognition();		
 		modificationTypeChanges.append(UtilityConstants.REVENUE_RECOGNITION+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 			    .append(revenueRecognition.equals("Y")?"Checked":"Unchecked").append(",")
 	            .append("").append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	 	
 		if((BaseAgreementModificationConstants.ROL).equals(modificationTypeCode))
		{
		 	OPPTCalender calender = new OPPTCalender();
			String rolStartDate = calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolStartDate()) == null ? "" : calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolStartDate());
	 		modificationTypeChanges.append(UtilityConstants.ROL_STARTDATE+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
			                       .append(rolStartDate.equals("") ? "" :calender.getDateStringASMMDDYYYY(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolStartDate())).append(",")
	                               .append("").append(UtilityConstants.CHANGEDETAILS_VARIETOR);

			String rolEndDate = calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolEndDate()) == null ? "" : calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolEndDate());
	     	if(rolEndDate.length() != 0) {
			modificationTypeChanges.append(UtilityConstants.ROL_ENDDATE+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
			                       .append(rolEndDate.equals("") ? "" :calender.getDateStringASMMDDYYYY(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolEndDate())).append(",")
	                               .append("").append(UtilityConstants.CHANGEDETAILS_VARIETOR);
	     	}

	     	String rolOption = ((ROLModificationCustomDTO)oldModificationCustomDTO).getModificationOption() == null ? "" : ((ROLModificationCustomDTO)oldModificationCustomDTO).getModificationOption();
	 		modificationTypeChanges.append(UtilityConstants.ROL_OPTIONs+" - "+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
			                       .append(rolOption).append(",")
	                               .append("").append(UtilityConstants.CHANGEDETAILS_VARIETOR);
		}
     	String details = oldModificationCustomDTO.getDetails() == null ? "" : oldModificationCustomDTO.getDetails();		
 		modificationTypeChanges.append(UtilityConstants.MODIFICATION_DETAILS+" - "+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 			    .append(details).append(",")
 	            .append("").append(UtilityConstants.CHANGEDETAILS_VARIETOR);

     	String status = oldModificationCustomDTO.getStatus() == null ? "" : oldModificationCustomDTO.getStatus().equals("A")?"Active":"Inactive";		
 		modificationTypeChanges.append(UtilityConstants.STATUS+" - "+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 	            .append(status).append(",")
 	 			.append("").append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 		
     }
     else {
     	String modificationTypeCode = oldModificationCustomDTO.getModificationTypeCode() == null ? "" : oldModificationCustomDTO.getModificationTypeCode();
     	modificationTypeChanges.append(UtilityConstants.MODIFICATION_TYPE).append(",")
 	    		.append("").append(",")
 				.append(modificationTypeCode).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	
     	String accountingContact = oldModificationCustomDTO.getAccountingContact() == null ? "" : oldModificationCustomDTO.getAccountingContact();		
     	modificationTypeChanges.append(UtilityConstants.ACCOUNTING_CONTACT+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 	            .append("").append(",")
 				.append(accountingContact).append(UtilityConstants.CHANGEDETAILS_VARIETOR);

     	String legalContract = oldModificationCustomDTO.getLegalContract() == null ? "" : oldModificationCustomDTO.getLegalContract();
     	if(legalContract.length() != 0) {
	 		modificationTypeChanges.append(UtilityConstants.LEGAL_CONTACT+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
	 	            .append("").append(",")
	 				.append(legalContract).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
     	}
     	
     	String modifiedLetterHead = oldModificationCustomDTO.getModifiedLetterHead() == null ? ""  : oldModificationCustomDTO.getModifiedLetterHead();		
 		modificationTypeChanges.append(UtilityConstants.MODIFIED_IBM_LETTERHEAD+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 	            .append("").append(",")
 				.append(modifiedLetterHead.equals("Y")?"Checked":"Unchecked").append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	
     	String revenueRecognition = oldModificationCustomDTO.getRevenueRecognition() == null ? "" : oldModificationCustomDTO.getRevenueRecognition();		
 		modificationTypeChanges.append(UtilityConstants.REVENUE_RECOGNITION+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 	            .append("").append(",")
 	 			.append(revenueRecognition.equals("Y")?"Checked":"Unchecked").append(UtilityConstants.CHANGEDETAILS_VARIETOR);
 	 	
		if((BaseAgreementModificationConstants.ROL).equals(modificationTypeCode))
		{
		 	OPPTCalender calender = new OPPTCalender();
			String rolStartDate = calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolStartDate()) == null ? "" : calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolStartDate());
	 		modificationTypeChanges.append(UtilityConstants.ROL_STARTDATE+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
			                       .append("").append(",")
	                               .append(rolStartDate.equals("") ? "" :calender.getDateStringASMMDDYYYY(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolStartDate())).append(UtilityConstants.CHANGEDETAILS_VARIETOR);

			String rolEndDate = calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolEndDate()) == null ? "" : calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolEndDate());
	     	if(rolEndDate.length() != 0) {
			modificationTypeChanges.append(UtilityConstants.ROL_ENDDATE+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
			                       .append("").append(",")
	                               .append(rolEndDate.equals("") ? "" :calender.getDateStringASMMDDYYYY(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolEndDate())).append(UtilityConstants.CHANGEDETAILS_VARIETOR);
	     	}
	     	
			String rolOption = ((ROLModificationCustomDTO)oldModificationCustomDTO).getModificationOption() == null ? "" : ((ROLModificationCustomDTO)oldModificationCustomDTO).getModificationOption();
	 		modificationTypeChanges.append(UtilityConstants.ROL_OPTIONs+" - "+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
			                       .append("").append(",")
	                               .append(rolOption).append(UtilityConstants.CHANGEDETAILS_VARIETOR);

		}
 		String details = oldModificationCustomDTO.getDetails() == null ? "" : oldModificationCustomDTO.getDetails();		
 		modificationTypeChanges.append(UtilityConstants.MODIFICATION_DETAILS+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 	            .append("").append(",")
 	 			.append(details).append(UtilityConstants.CHANGEDETAILS_VARIETOR);

     	String status = oldModificationCustomDTO.getStatus() == null ? "" : oldModificationCustomDTO.getStatus().equals("A")?"Active":"Inactive";		
 		modificationTypeChanges.append(UtilityConstants.STATUS+"-"+ oldModificationCustomDTO.getModificationTypeCode()).append(",")
 	            .append("").append(",")
 	 			.append(status).append(UtilityConstants.CHANGEDETAILS_VARIETOR);

     }	
  	return modificationTypeChanges.toString();
  }

 /**
  *  
  * getChangeLogID
  * <br><b>Known Bugs</b><br> 
  * 
  * <br><PRE> 
  * date Dec 8, 2003 
  * 
  * revision date author reason 
  * 
  * </PRE><br> 
  * 
  * @param errorCode
  * @throws ServiceException
  * @author balajiv
  * @return int
  */
	private int getChangeLogID() throws ServiceException
	{
		BaseAgreementChangeLogBOFactory baChangeLogBOFactory = new BaseAgreementChangeLogBOFactory();
		BaseAgreementChangeLogBO maxBaseAgreementChangeLogBO = null;
		try
		{
		    maxBaseAgreementChangeLogBO = baChangeLogBOFactory.findMaxBaseAgreementChangeLogBO();
		}catch(DomainException de){
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "getChangeLogID", null, de);
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
		}
		int changeId = maxBaseAgreementChangeLogBO.getChangeId() + 1;	
		return changeId;
	}

	/**
	 * This method is used to insert change history details
     * @param BaseAgreementChangeLogBO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @return
     * @author Lakshmanan Thirumalaikumar
     */
	private void insertChangeLog(BaseAgreementChangeLogBO baChangeLogBO) throws ServiceException 
	{		
		int changeId = getChangeLogID();
		baChangeLogBO.setChangeId(changeId);	
		BaseAgreementChangeLogBOFactory bachangeLogBOFactory = new BaseAgreementChangeLogBOFactory();
		try
		{
			bachangeLogBOFactory.createChangeLog(baChangeLogBO);
    	}catch(DomainException de)
		{
    		OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "insertChangeHistory", null, de);
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
		}
	}
	/**
	  *  
	  * checkModificationChanges
	  * <br><b>Known Bugs</b><br> 
	  * 
	  * <br><PRE> 
	  * date Dec 8, 2003 
	  * 
	  * revision date author reason 
	  * 
	  * </PRE><br> 
	  * 
	  * @param errorCode
	  * @throws ServiceException
	  * @author balajiv
	  * @return ArrayList
	  */
	private ArrayList checkModificationChanges(TreeMap oldModificationTypeTreeMap,TreeMap newModificationTypeTreeMap) {

		ArrayList modificationTypeList = new ArrayList();
		TreeMap updatedModificationTypeMap = new TreeMap();
		TreeMap createdModificationTypeMap = new TreeMap();
		
	 	Iterator oldModificationTypeIterator = oldModificationTypeTreeMap.keySet().iterator();
	 	while(oldModificationTypeIterator.hasNext()) {
	 	  String modificationTypeCode = (String)oldModificationTypeIterator.next();
	 	  ModificationCustomDTO oldModificationCustomDTO =(ModificationCustomDTO) oldModificationTypeTreeMap.get(modificationTypeCode);
	 	  if(newModificationTypeTreeMap.containsKey(modificationTypeCode))
	 	  {
	 	  	  ModificationCustomDTO newModificationCustomDTO = (ModificationCustomDTO)newModificationTypeTreeMap.get(modificationTypeCode);
	 	  	  if (isModificationTypeChanged(oldModificationCustomDTO,newModificationCustomDTO)) {
	 	  	      updatedModificationTypeMap.put(newModificationCustomDTO.getModificationTypeCode(),newModificationCustomDTO);	 	  	  	
	 	  	      //newModificationTypeTreeMap.remove(modificationTypeCode);
	 	  	  } 
	 	  } 
	    }
	 	 Iterator newModificationTypeIterator = newModificationTypeTreeMap.keySet().iterator();
         while(newModificationTypeIterator.hasNext()) {
           String modificationTypeCode = (String)newModificationTypeIterator.next();
           ModificationCustomDTO newModificationCustomDTO =(ModificationCustomDTO) newModificationTypeTreeMap.get(modificationTypeCode);
           if(!oldModificationTypeTreeMap.containsKey(modificationTypeCode))
           {
                 createdModificationTypeMap.put(newModificationCustomDTO.getModificationTypeCode(),newModificationCustomDTO);                            
           } 
         }   
	 	modificationTypeList.add(0,updatedModificationTypeMap);
	 	modificationTypeList.add(1,createdModificationTypeMap);
	 	return modificationTypeList;
	}
	/**
	  *  
	  * isModificationTypeChanged
	  * <br><b>Known Bugs</b><br> 
	  * 
	  * <br><PRE> 
	  * date Dec 8, 2003 
	  * 
	  * revision date author reason 
	  * 
	  * </PRE><br> 
	  * 
	  * @param errorCode
	  * @throws ServiceException
	  * @author balajiv
	  * @return boolean
	  */
	private boolean isModificationTypeChanged(ModificationCustomDTO oldModificationCustomDTO,ModificationCustomDTO newModificationCustomDTO) {
		boolean isChanged = false;
		
	  	String oldAccountingContact = oldModificationCustomDTO.getAccountingContact() == null ? "" : oldModificationCustomDTO.getAccountingContact();
	  	String newAccountingContact = newModificationCustomDTO.getAccountingContact() == null ? "" : newModificationCustomDTO.getAccountingContact();
	  	if(!oldAccountingContact.equals(newAccountingContact)) {
	  		return true;
	  	}

	  	String oldLegalContract = oldModificationCustomDTO.getLegalContract() == null ? "" : oldModificationCustomDTO.getLegalContract();
	  	String newLegalContract = newModificationCustomDTO.getLegalContract() == null ? "" : newModificationCustomDTO.getLegalContract();
	  	if(!oldLegalContract.equals(newLegalContract)) {
	  		return true;
	  	}

	  	String oldModifiedLetterHead = oldModificationCustomDTO.getModifiedLetterHead() == null ? "" : oldModificationCustomDTO.getModifiedLetterHead();
	  	String newModifiedLetterHead = newModificationCustomDTO.getModifiedLetterHead() == null ? "" : newModificationCustomDTO.getModifiedLetterHead();
	  	if(!oldModifiedLetterHead.equals(newModifiedLetterHead)) {
	  		return true;
	  	}

	  	String oldRevenueRecognition = oldModificationCustomDTO.getRevenueRecognition() == null ? "" : oldModificationCustomDTO.getRevenueRecognition();
	  	String newRevenueRecognition = newModificationCustomDTO.getRevenueRecognition() == null ? "" : newModificationCustomDTO.getRevenueRecognition();
	     if(!oldRevenueRecognition.equals(newRevenueRecognition)) {
	  		return true;
	  	}

		if((BaseAgreementModificationConstants.ROL).equals(oldModificationCustomDTO.getModificationTypeCode()))
		{
			 	OPPTCalender calender = new OPPTCalender();
				String oldROLStartDate = calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolStartDate()) == null ? "" : calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolStartDate());
				String newROLStartDate = calender.getDateString(((ROLModificationCustomDTO)newModificationCustomDTO).getRolStartDate()) == null ? "" : calender.getDateString(((ROLModificationCustomDTO)newModificationCustomDTO).getRolStartDate());
			  	if(!oldROLStartDate.equals(newROLStartDate)) {
			  		return true;
			  	}

			  	String oldROLEndDate = calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolEndDate()) == null ? "" : calender.getDateString(((ROLModificationCustomDTO)oldModificationCustomDTO).getRolEndDate());
				String newROLEndDate = calender.getDateString(((ROLModificationCustomDTO)newModificationCustomDTO).getRolEndDate()) == null ? "" : calender.getDateString(((ROLModificationCustomDTO)newModificationCustomDTO).getRolEndDate());
			  	if(!oldROLEndDate.equals(newROLEndDate)) {
			  		return true;
			  	}

				String oldROLOption = ((ROLModificationCustomDTO)oldModificationCustomDTO).getModificationOption() == null ? "" : ((ROLModificationCustomDTO)oldModificationCustomDTO).getModificationOption();
				String newROLOption = ((ROLModificationCustomDTO)newModificationCustomDTO).getModificationOption() == null ? "" : ((ROLModificationCustomDTO)newModificationCustomDTO).getModificationOption();
			  	if(!oldROLOption.equals(newROLOption)) {
			  		return true;
			  	}
		}
	 
	  	String oldDetails = oldModificationCustomDTO.getDetails() == null ? "" : oldModificationCustomDTO.getDetails();
	  	String newDetails = newModificationCustomDTO.getDetails() == null ? "" : newModificationCustomDTO.getDetails();
	     if(!oldDetails.equals(newDetails)) {
	  		return true;
	  	}
	     
	  	String oldStatus = oldModificationCustomDTO.getStatus() == null ? "" : oldModificationCustomDTO.getStatus();
	  	String newStatus = newModificationCustomDTO.getStatus() == null ? "" : newModificationCustomDTO.getStatus();
        if(!oldStatus.equals(newStatus)) {
		  		return true;
	  	}
    	return isChanged;

		
	}	

} 