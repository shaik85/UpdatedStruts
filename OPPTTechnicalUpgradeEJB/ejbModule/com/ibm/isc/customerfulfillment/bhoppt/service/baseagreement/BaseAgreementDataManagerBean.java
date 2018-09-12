/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.BaseAgreementBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.BaseAgreementModificationTypesBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.FormNumbersBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.ModificationOptionsBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.factory.BaseAgreementBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.factory.BaseAgreementModificationTypesBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.factory.FormNumbersBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.factory.ModificationOptionsBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.BaseAgreementDataDAO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormMaintenanceCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormNumbersBySalesOrgCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationOptionCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypesCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationsBySalesOrgCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SalesOrgForReportsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.TimeTaken;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * Bean implementation class for Enterprise Bean: BaseAgreementDataManager
 */
public class BaseAgreementDataManagerBean implements javax.ejb.SessionBean {
    private static final String EXCEPTION = "EXCEPTION";
	private static final String CLASS_NAME = "BaseAgreementDataManagerBean";
    
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
     * get the modification types
     * 
     * @param modificationTypesCustomDTO
     * @return
     * @throws RemoteException
     * @throws ServiceException
     * @throws DomainException
     */
    
    public  ModificationTypesCustomDTO getAllModificationTypes(ModificationTypesCustomDTO modificationTypesCustomDTO) throws  DomainException, ServiceException {
    	TimeTaken log = new TimeTaken(CLASS_NAME, "getAllModificationTypes");
       
    	BaseAgreementModificationTypesBOFactory baseAgreementModificationTypesBOFactory = new BaseAgreementModificationTypesBOFactory();
        BaseAgreementModificationTypesBO baseAgreementModificationTypesBO = new BaseAgreementModificationTypesBO();
        baseAgreementModificationTypesBO.setSalesOrg(modificationTypesCustomDTO.getSalesOrg());
        ArrayList baseAgreementModificationBOList = null;
        TreeMap baseAgreementModificationMap = new TreeMap();
        try{
        	baseAgreementModificationBOList = baseAgreementModificationTypesBOFactory.getAllModificationTypesBO(baseAgreementModificationTypesBO);
		    }catch(DomainException de){		
		    OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "getAllModificationTypes", null, de);
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
		}

        baseAgreementModificationMap = getModificationMap(baseAgreementModificationBOList);
        modificationTypesCustomDTO.setModificationTypesMap(baseAgreementModificationMap);
        return modificationTypesCustomDTO;
    }
    
    
    /**
     * get the modification map
     * 
     * @param modificationTypesCustomDTO
     * @param baseAgreementModificationBOList
     * @return
     * @throws ServiceException
     */
    private TreeMap getModificationMap(ArrayList baseAgreementModificationBOList)throws DomainException, ServiceException {
        ModificationOptionsBOFactory  modificationOptionsBOFactory = new ModificationOptionsBOFactory(); 
        ModificationOptionsBO modificationOptionsBO  = new ModificationOptionsBO();
        ModificationTypeCustomDTO modificationTypeCustomDTO = null;
        ArrayList modificationOptionsBOList = null;
        TreeMap modificationsTypesMap = new TreeMap();
        TreeMap modificationsOptionsMap = new TreeMap();
        Iterator modificationListIterator =baseAgreementModificationBOList.iterator();
        while(modificationListIterator.hasNext()){
            modificationTypeCustomDTO = new ModificationTypeCustomDTO();
            BaseAgreementModificationTypesBO baseAgreementModificationTypesBO =(BaseAgreementModificationTypesBO)modificationListIterator.next();
            String typeCode = (String)baseAgreementModificationTypesBO.getModificationTypeCode();
            modificationOptionsBO.setModificationTypeCode(typeCode);
            try{
            	modificationOptionsBOList = modificationOptionsBOFactory.getAllModificationOptionsBO(modificationOptionsBO);
            }catch(DomainException de){		
    			throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
    		}
             TreeMap modificationsTypeOptionsMap = new TreeMap();
             if(modificationOptionsBOList.size()!= 0){
               modificationsOptionsMap = getModificationOptionsMap(modificationOptionsBOList);
               modificationsTypeOptionsMap.put(typeCode,modificationsOptionsMap);
               modificationTypeCustomDTO.setModificationTypeMap(modificationsTypeOptionsMap);
            }
            
            modificationTypeCustomDTO.setTypeCode(baseAgreementModificationTypesBO.getModificationTypeCode());
            modificationTypeCustomDTO.setDescription(baseAgreementModificationTypesBO.getModificationTypeDescription());
            modificationTypeCustomDTO.setSelectedSalesOrg(baseAgreementModificationTypesBO.getSalesOrg());
            modificationsTypesMap.put(typeCode,modificationTypeCustomDTO);
         }
        return modificationsTypesMap;
    }
    
    /**
     * 
     * @param modificationOptionsBOList
     * @return
     */
     private TreeMap getModificationOptionsMap(ArrayList modificationOptionsBOList) {
          TreeMap modificationsOptionsMap = new TreeMap();
         Iterator modificationOptionsListIterator =modificationOptionsBOList.iterator();
         while(modificationOptionsListIterator.hasNext()){
         	ModificationOptionCustomDTO modificationOptionsCustomDTO = new ModificationOptionCustomDTO();    
             ModificationOptionsBO modificationOptionsBO =(ModificationOptionsBO)modificationOptionsListIterator.next();
             String modificationOptions = (String)modificationOptionsBO.getModificationOption();
             modificationOptionsCustomDTO.setTypeCode(modificationOptionsBO.getModificationTypeCode());
             modificationOptionsCustomDTO.setModificationOption(modificationOptionsBO.getModificationOption());
             modificationOptionsCustomDTO.setModificationDescription(modificationOptionsBO.getModificationOptionDesc());
             modificationsOptionsMap.put(modificationOptions,modificationOptionsCustomDTO);
         }
         return modificationsOptionsMap;
     }
     
     /**
      * new modification type added
      * 
      * @param modificationTypeCustomDTO
      * @return
      * @throws ServiceException
      * @throws RemoteException
      */
     public  ModificationTypeCustomDTO addModificationType(ModificationTypeCustomDTO modificationTypeCustomDTO) throws ServiceException{
        
       	 TimeTaken log = new TimeTaken(CLASS_NAME, "addModificationType");
     	
         BaseAgreementModificationTypesBOFactory baseAgreementModificationTypesBOFactory = new BaseAgreementModificationTypesBOFactory();     
         BaseAgreementModificationTypesBO baseAgreementModificationTypesBO = new BaseAgreementModificationTypesBO();
         baseAgreementModificationTypesBO.setSalesOrg(OPPTHelper.trimString(modificationTypeCustomDTO.getSelectedSalesOrg()));
         baseAgreementModificationTypesBO.setModificationTypeCode(OPPTHelper.trimString(modificationTypeCustomDTO.getTypeCode()));
         baseAgreementModificationTypesBO.setModificationTypeDescription(OPPTHelper.trimString(modificationTypeCustomDTO.getDescription()));
         
         try{
             baseAgreementModificationTypesBOFactory.addModificationTypeBO(baseAgreementModificationTypesBO);
         }catch(DomainException de){	
         	OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "addModificationType", null, de);
 			throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
 		}
                 
         return modificationTypeCustomDTO;        
                
         }
	    /**
	     * update the modification type
	     * 
	     * @param modificationTypeCustomDTO
	     * @return
	     * @throws ServiceException
	     * @throws RemoteException
	     */
	    public  ModificationTypeCustomDTO updateModificationType(ModificationTypeCustomDTO modificationTypeCustomDTO) throws ServiceException {
	       
	    	TimeTaken log = new TimeTaken(CLASS_NAME, "updateModificationType");
	    	
	    	BaseAgreementModificationTypesBOFactory baseAgreementModificationTypesBOFactory = new BaseAgreementModificationTypesBOFactory();     
	        BaseAgreementModificationTypesBO baseAgreementModificationTypesBO = new BaseAgreementModificationTypesBO();
	        baseAgreementModificationTypesBO.setSalesOrg(OPPTHelper.trimString(modificationTypeCustomDTO.getSelectedSalesOrg()));
	        baseAgreementModificationTypesBO.setModificationTypeCode(OPPTHelper.trimString(modificationTypeCustomDTO.getTypeCode()));
	        baseAgreementModificationTypesBO.setModificationTypeDescription(OPPTHelper.trimString(modificationTypeCustomDTO.getDescription()));
	        try{
	            baseAgreementModificationTypesBOFactory.updateModificationTypeBO(baseAgreementModificationTypesBO);
	        }catch(DomainException de){		
	        	OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, "updateModificationType", null, de);
				throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
			}
	                
	        return modificationTypeCustomDTO;        
	    }
	   
	    
	    /**
	     * update the modification type
	     * 
	     * @param modificationTypeCustomDTO
	     * @return
	     * @throws ServiceException
	     * @throws RemoteException
	     */
	    public  void deleteModificationType(ModificationTypeCustomDTO modificationTypeCustomDTO) throws ServiceException {
	      
	    	TimeTaken log = new TimeTaken(CLASS_NAME, "deleteModificationType");
	    	
	    	boolean valid= false;
	        BaseAgreementModificationTypesBOFactory baseAgreementModificationTypesBOFactory = new BaseAgreementModificationTypesBOFactory();     
	        BaseAgreementModificationTypesBO baseAgreementModificationTypesBO = new BaseAgreementModificationTypesBO();
	        baseAgreementModificationTypesBO.setSalesOrg(OPPTHelper.trimString(modificationTypeCustomDTO.getSelectedSalesOrg()));
	        baseAgreementModificationTypesBO.setModificationTypeCode(OPPTHelper.trimString(modificationTypeCustomDTO.getTypeCode()));
	        
	        BaseAgreementDataDAO dataDAO =new BaseAgreementDataDAO();
	       
	        try {
	            valid = dataDAO.validateModificationType(baseAgreementModificationTypesBO.getSalesOrg(),baseAgreementModificationTypesBO.getModificationTypeCode());
			} catch(Exception de){		
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"deleteModificationType",de.getMessage());
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);	
			}
			
	        if(valid){
		        try{
		            baseAgreementModificationTypesBOFactory.deleteModificationTypeBO(baseAgreementModificationTypesBO);
		        }catch(DomainException de){		
					throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
				}
	                
	        }else{
	        }
	    }	    
	    
/**
 * 
 * Dec 27, 2006
 * updateModificationOptions
 * @param customDTO
 * @return
 * @throws ServiceException
 * @throws RemoteException
 */
	    public  ModificationOptionCustomDTO updateModificationOptions(ModificationOptionCustomDTO customDTO) throws ServiceException, RemoteException {
	    	
	    	TimeTaken log = new TimeTaken(CLASS_NAME, "updateModificationOptions");             
	        
	    	ModificationOptionsBOFactory boFactory = new ModificationOptionsBOFactory();
	        ModificationOptionsBO optionsBO = new ModificationOptionsBO();
	        optionsBO.setModificationTypeCode(OPPTHelper.trimString(customDTO.getTypeCode()));
	        optionsBO.setModificationOption(OPPTHelper.trimString(customDTO.getModificationOption()));
	        optionsBO.setModificationOptionDesc(OPPTHelper.trimString(customDTO.getModificationDescription()));
	        
	        try{
	            boFactory.updateModificationOptionsBO(optionsBO);
	        }catch(DomainException de){		
	        	OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"updateModificationOptions",de.getMessage());
	        	throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
			}
	        
	        return customDTO;
	        
	        
	    }
	   /**
	    * 
	    * Dec 27, 2006
	    * addModificationOption
	    * @param customDto
	    * @return
	    * @throws ServiceException
	    */
	    
	    public  ModificationOptionCustomDTO addModificationOption(ModificationOptionCustomDTO customDto) throws ServiceException{
	    	
	    	TimeTaken log = new TimeTaken(CLASS_NAME, "addModificationOption");     
	    	
	    	ModificationOptionsBOFactory boFactory = new ModificationOptionsBOFactory();
	        ModificationOptionsBO optionsBO = new ModificationOptionsBO();
	        optionsBO.setModificationTypeCode(OPPTHelper.trimString(customDto.getTypeCode()));
	        optionsBO.setModificationOption(OPPTHelper.trimString(customDto.getModificationOption()));
	        optionsBO.setModificationOptionDesc(OPPTHelper.trimString(customDto.getModificationDescription()));
	        try{
	            boFactory.addModificationOptionBO(optionsBO);
	        }catch(DomainException de){		
	        	OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"addModificationOption",de.getMessage());
	        	throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
			}
	        
	        return customDto;
	    }
	    /**
	     * Dec 27, 2006
	     * getModificationOptions
	     * @param customDTO
	     * @return
	     * @throws ServiceException
	     */
	    public  ModificationTypeCustomDTO getModificationOptions(ModificationTypeCustomDTO customDTO) throws ServiceException{
	        
	    	TimeTaken log = new TimeTaken(CLASS_NAME, "getModificationOptions");
	    	
	        ModificationOptionsBOFactory  modificationOptionsBOFactory = new ModificationOptionsBOFactory(); 
	        ModificationOptionsBO modificationOptionsBO  = new ModificationOptionsBO();
	        ArrayList modificationOptionsBOList = null;
	        String typeCode = customDTO.getTypeCode();
	        modificationOptionsBO.setModificationTypeCode(typeCode);
	        TreeMap modificationsOptionsMap = new TreeMap();
	        try{
            	modificationOptionsBOList = modificationOptionsBOFactory.getAllModificationOptionsBO(modificationOptionsBO);
            }catch(DomainException de){		
            	OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"getModificationOptions",de.getMessage());
            	throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
    		}
             TreeMap modificationsTypeOptionsMap = new TreeMap();
             if(modificationOptionsBOList.size()!= 0){
               modificationsOptionsMap = getModificationOptionsMap(modificationOptionsBOList);
               modificationsTypeOptionsMap.put(typeCode,modificationsOptionsMap);
               customDTO.setModificationTypeMap(modificationsTypeOptionsMap);
            }
            else {
                modificationsOptionsMap = new TreeMap();
                modificationsTypeOptionsMap.put(typeCode,modificationsOptionsMap);
            	customDTO.setModificationTypeMap(modificationsTypeOptionsMap);
            }     
	        return customDTO;
	    }
	    
	    
	  
	    
	     /**
	      * get the modification types
	      * 
	      * @param modificationTypesCustomDTO
	      * @return
	      * @throws RemoteException
	      * @throws ServiceException
	      * @throws DomainException
	      */
	     public ModificationsBySalesOrgCustomDTO getModificationsBySalesOrg (SalesOrgForReportsCustomDTO salesOrgForReportsCustomDTO)throws ServiceException,DomainException{
	     	
	     	TimeTaken log = new TimeTaken(CLASS_NAME, "getModificationsBySalesOrg");
	     	
	     	BaseAgreementModificationTypesBOFactory baseAgreementModificationTypesBOFactory = new BaseAgreementModificationTypesBOFactory();
	        BaseAgreementModificationTypesBO baseAgreementModificationTypesBO = new BaseAgreementModificationTypesBO();
	        //baseAgreementModificationTypesBO.setSalesOrg(salesOrg);
	        baseAgreementModificationTypesBO.setSalesOrg(salesOrgForReportsCustomDTO.getSalesOrg());
	        ArrayList baseAgreementModificationBOList = null;
	        TreeMap baseAgreementModificationMap = new TreeMap();
	        
	        ModificationsBySalesOrgCustomDTO modificationsBySalesOrgCustomDTO = new ModificationsBySalesOrgCustomDTO();
	        try{
	        	//baseAgreementModificationBOList = baseAgreementModificationTypesBOFactory.getModOptions(salesOrg);
	        	baseAgreementModificationBOList = baseAgreementModificationTypesBOFactory.getModOptions(salesOrgForReportsCustomDTO.getSalesOrg());
				}catch(DomainException de){		
					OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"getModificationsBySalesOrg",de.getMessage());
					throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
			}

	        baseAgreementModificationMap = getModificationMap(baseAgreementModificationBOList);
	       	//return baseAgreementModificationMap;
	        modificationsBySalesOrgCustomDTO.setModificationsMap(baseAgreementModificationMap);
	        return modificationsBySalesOrgCustomDTO;
	     }
	     /**
	      * get the modification types
	      * 
	      * @param modificationTypesCustomDTO
	      * @return
	      * @throws RemoteException
	      * @throws ServiceException
	      * @throws DomainException
	      */
	    public FormNumbersBySalesOrgCustomDTO getFormNumbersBySalesOrg(SalesOrgForReportsCustomDTO salesOrgForReportsCustomDTO)throws ServiceException,DomainException{
	     	
	    	TimeTaken log = new TimeTaken(CLASS_NAME, "getFormNumbersBySalesOrg");
	    	
	    	FormNumbersBOFactory formNumbersBOFactory= new FormNumbersBOFactory();
	     	TreeMap baseAgreementFormNumbersMap = new TreeMap();
	     	FormNumbersBO formNumbersBO = new FormNumbersBO();
	     	 ArrayList formBOList = null;
	     	//formNumbersBO.setSalesOrg(salesOrg);
	     	formNumbersBO.setSalesOrg(salesOrgForReportsCustomDTO.getSalesOrg());
	     	
	     	FormNumbersBySalesOrgCustomDTO formNumbersBySalesOrgCustomDTO = new FormNumbersBySalesOrgCustomDTO();
	     	
	     	  try{
	     	  	//formBOList = formNumbersBOFactory.getFormNumbers(salesOrg);
	     	  	formBOList = formNumbersBOFactory.getFormNumbers(salesOrgForReportsCustomDTO.getSalesOrg());
	        
				}catch(DomainException de){		
					OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"getFormNumbersBySalesOrg",de.getMessage());
					throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
			}
		
				Iterator formBOListIterator = formBOList.iterator();
				while(formBOListIterator.hasNext()){
		     		FormDetailsCustomDTO formDetailsCustomDto = new FormDetailsCustomDTO();
		     		formNumbersBO =(FormNumbersBO)formBOListIterator.next(); 
		     		String formNumber = formNumbersBO.getFormNumber();
		     		populateCustomDTO(formNumbersBO,formDetailsCustomDto);
		     		baseAgreementFormNumbersMap.put(formNumber,formDetailsCustomDto);
		     		}
				
	     	//return baseAgreementFormNumbersMap;
				formNumbersBySalesOrgCustomDTO.setFormNumbersMap(baseAgreementFormNumbersMap);
				return formNumbersBySalesOrgCustomDTO;
	     }
/**
 * 
 * Dec 27, 2006
 * getAllForms
 * @param customDTO
 * @return
 * @throws ServiceException
 */
	    
	   public FormMaintenanceCustomDTO getAllForms(FormMaintenanceCustomDTO customDTO) throws ServiceException{
	     
	   	TimeTaken log = new TimeTaken(CLASS_NAME, "getAllForms");
	   	
	   	FormNumbersBOFactory  boFactory= new FormNumbersBOFactory();
	     	FormNumbersBO formNumbersBO = new FormNumbersBO();
	     	formNumbersBO.setSalesOrg(customDTO.getSalesOrg());
	     	ArrayList formBOList =null;
	     	TreeMap formDetailsMap = new TreeMap();
	     	try{
	     		formBOList = boFactory.getAllFormsBO(formNumbersBO);
			    }catch(DomainException de){		
			    	OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"getAllForms",de.getMessage());
			    	throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
			    	
			}
	     	if(formBOList!=null){
	     	Iterator formBOListIterator = formBOList.iterator();
	     	while(formBOListIterator.hasNext()){
	     		FormDetailsCustomDTO formDetailsCustomDto = new FormDetailsCustomDTO();
	     		formNumbersBO =(FormNumbersBO)formBOListIterator.next(); 
	     		String formNumber = formNumbersBO.getFormNumber();
	     		populateCustomDTO(formNumbersBO,formDetailsCustomDto);
	     		formDetailsMap.put(formNumber,formDetailsCustomDto);
	     		}
	     		
	     	}
	     	customDTO.setFormDetailsMap(formDetailsMap);
	     	return customDTO;
	     }
	     
	     private void populateCustomDTO(FormNumbersBO formNumbersBO,FormDetailsCustomDTO formDetailsCustomDto){
	     	
	     	if(formNumbersBO != null){
	     		formDetailsCustomDto.setSalesOrg(formNumbersBO.getSalesOrg());
	     		formDetailsCustomDto.setFormNumber(formNumbersBO.getFormNumber());
	     		formDetailsCustomDto.setFormLongDescription(formNumbersBO.getFormLongDescription());
	     		formDetailsCustomDto.setFormShortDescription(formNumbersBO.getFormShortDescription());
	     		
	     	}
	     	
	     }
	     /**
	      * new form added
	      * 
	      * @param modificationTypeCustomDTO
	      * @return
	      * @throws ServiceException
	      * @throws RemoteException
	      */
	     public  FormDetailsCustomDTO addForm(FormDetailsCustomDTO formDetailsCustomDTO) throws ServiceException{
	    	
	     	 TimeTaken log = new TimeTaken(CLASS_NAME, "addForm");
	    	
	         FormNumbersBOFactory formNumbersBOFactory = new FormNumbersBOFactory();     
	         FormNumbersBO formNumbersBO = new FormNumbersBO();
	         formNumbersBO.setSalesOrg(OPPTHelper.trimString(formDetailsCustomDTO.getSalesOrg()));
	         formNumbersBO.setFormNumber(OPPTHelper.trimString(formDetailsCustomDTO.getFormNumber()));
	         formNumbersBO.setFormLongDescription(OPPTHelper.trimString(formDetailsCustomDTO.getFormLongDescription()));
	         formNumbersBO.setFormShortDescription(OPPTHelper.trimString(formDetailsCustomDTO.getFormShortDescription()));
	                  
	         try{
	         	formNumbersBOFactory.addFormBO(formNumbersBO);
	         }catch(DomainException de){		
	         	OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"addForm",de.getMessage());
	         	throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
	         	
	 		 }
	                 
	         return formDetailsCustomDTO;        
	                
	         }
	     
	     /**
	      * @param customDTO
	      * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
	      * @throws java.rmi.RemoteException
	      * @return
	      * @author Sasi R Challa
	      */
	    public void deleteForm(FormDetailsCustomDTO customDTO) throws ServiceException {
	    	
	   	      TimeTaken log = new TimeTaken(CLASS_NAME, "deleteForm");
	    	
	    	 BaseAgreementBOFactory baseAgreementBOFactory = new BaseAgreementBOFactory();
	    	 BaseAgreementBO baseAgreementBO = new BaseAgreementBO();
	    	 baseAgreementBO.setFormNumber(customDTO.getFormNumber());
	    	 boolean value = false;
	    	 baseAgreementBO.setSalesOrganization(customDTO.getSalesOrg());
	    	  try{
	    	  	value=baseAgreementBOFactory.deleteFormBO(baseAgreementBO);
	         }catch(DomainException de){		
	         	OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"deleteForm",de.getMessage());
	         	throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
	 		 }
	       
	         FormNumbersBOFactory  boFactory= new FormNumbersBOFactory();
		 	 FormNumbersBO formNumbersBO = new FormNumbersBO();        
		 	formNumbersBO.setSalesOrg(customDTO.getSalesOrg());
		 	formNumbersBO.setFormNumber(customDTO.getFormNumber());
		 	//	 	if baseAgreementLocalCollection = null ie value = true; then no match in the table is found; so delete
	     if(value){
	     	try{
	     		     		
	     		boFactory.deleteFormBO(formNumbersBO);
	     	 }catch(DomainException de){		
	 			throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
	 		 }
	     }else
	     {
	     }
	     
	    }
	    
	    /**
	     * @param customDTO
	     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
	     * @throws java.rmi.RemoteException
	     * @return
	     * @author Sasi R Challa
	     */
	   public FormDetailsCustomDTO updateForm(FormDetailsCustomDTO customDTO) throws ServiceException {
	   	   	
	        TimeTaken log = new TimeTaken(CLASS_NAME, "updateForm");
	   	
	        FormNumbersBOFactory  boFactory= new FormNumbersBOFactory();
		 	FormNumbersBO formNumbersBO = new FormNumbersBO();
		 	formNumbersBO.setSalesOrg(customDTO.getSalesOrg());
		 	formNumbersBO.setFormNumber(customDTO.getFormNumber());
		 	formNumbersBO.setFormLongDescription(customDTO.getFormLongDescription());
		 	formNumbersBO.setFormShortDescription(customDTO.getFormShortDescription());
		    try{
		    	boFactory.updateFormBO(formNumbersBO);
	        }catch(DomainException de){		
	        	OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"updateForm",de.getMessage());
	        	throw ExceptionGenerator.generateServiceException(de.getErrorReport());	
			}
	        return customDTO;
	   }

}
    

