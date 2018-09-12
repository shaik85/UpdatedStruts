/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationConstants;
import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementStatusConstant;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.BaseAgreementActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ROLModificationCustomDTO;

/**
 * Holds the detail information about an agreement  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date jun 13, 2006
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Gavaskar Bhojan
 * 
 */
public class BaseAgreementDetailViewBean extends OPPTViewBean {
   
    private TreeMap  formDetailsMap = null;
    
    private TreeMap  coverageTypeMap = null;
    
    private TreeMap  salesOrgMap = null;
    
    private String coverageType = null;
    
    private int agreementId = 0;
  
    private String formNo= null;

    private String formShortDescripton= null;
   
    private String  formLongDescripton = null;

    private String customerNumber = null;

    private String customerName = null;

    private String enterpriseNumber = null;
    
    private String enterpriseName = null;

    private String customerRepresentative = null;

    private String agreementNumber = null;

    private Date acceptedDate = null;
    
    private Date createdDate = null;
    
    private String createdBy= null;

    private String branchOffice = null;

    private String imageReferenceNumber = null;
    
    private String oneWay = null;

    private TreeMap modificatioDetailsMap = null;
    
    private String agreementStatus = null;
    
    private String isModified = null;
    
    private String fileNo = null;
    
    private String salesOrganisation = null;
    
    private String formDetailKey = null;
    
    private boolean showModificationDetail = true;
   
    private String isElectronicSubmitter = null;
   
    private String changedBy = null;
   
    private Date changedOn = null;
    
    private Date expiryDate = null;
    
    private TreeMap languageMap=null;
    
    //private String language=null;
    
    /**
     * Default Constructor 
     *
     */
    
    public BaseAgreementDetailViewBean(){
        
    }
    /**
     * Constructor
     * @param baseAgreementDetailsCustomDto
     *
     */
    public BaseAgreementDetailViewBean(BaseAgreementDetailsCustomDTO baseAgreementDetailsCustomDto){
    	
        
       
        setAgreementId(baseAgreementDetailsCustomDto.getAgreementId());
       setCoverageType(baseAgreementDetailsCustomDto.getCoverageType());
       
        setData(baseAgreementDetailsCustomDto.getFormNumber());
                       
        TreeMap modificationDetailsmap = baseAgreementDetailsCustomDto.getModificationDetailsMap();
        Iterator modificationDetailsIterator = modificationDetailsmap.keySet().iterator();
        TreeMap displayModificationviewbeanmap = new TreeMap();
         
         while (modificationDetailsIterator.hasNext()) {
          String key = (String) modificationDetailsIterator.next();
          DisplayModificationDetailViewBean displayModificationDetailViewBean = null;
          if(BaseAgreementModificationConstants.ROL.equals(key)) {
          	ROLModificationCustomDTO rOLModificationDTO = (ROLModificationCustomDTO)modificationDetailsmap.get(key);
          	displayModificationDetailViewBean = new DisplayModificationDetailViewBean(rOLModificationDTO);
          }else {
          	ModificationCustomDTO modificationDTO = (ModificationCustomDTO)modificationDetailsmap.get(key);
          	displayModificationDetailViewBean = new DisplayModificationDetailViewBean(modificationDTO);
          } 
          displayModificationviewbeanmap.put(key,displayModificationDetailViewBean);
         }
         setModificatioDetailsMap(displayModificationviewbeanmap);
       
        setCustomerNumber(baseAgreementDetailsCustomDto.getCustomerNumber());
        setCustomerName(baseAgreementDetailsCustomDto.getCustomerName());
        setEnterpriseNumber(baseAgreementDetailsCustomDto.getEnterpriseNumber());
        setEnterpriseName(baseAgreementDetailsCustomDto.getEnterpriseName());
        setCustomerRepresentative(baseAgreementDetailsCustomDto.getCustomerRepresentative());
        setAgreementNumber(baseAgreementDetailsCustomDto.getAgreementNumber());
        setAcceptedDate(baseAgreementDetailsCustomDto.getAcceptedDate());
        setCreatedBy(baseAgreementDetailsCustomDto.getCreatedBy());
        setCreatedDate(baseAgreementDetailsCustomDto.getEntryDate());
        setBranchOffice(baseAgreementDetailsCustomDto.getBranchOffice());
        setImageReferenceNumber(baseAgreementDetailsCustomDto.getImageReferenceNumber());
        setFormNo(baseAgreementDetailsCustomDto.getFormNumber());
        setShowModificationDetail(baseAgreementDetailsCustomDto.isShowModificationDetails());
        // Added by Balaji to fix defect 
        setChangedBy(baseAgreementDetailsCustomDto.getChangedBy());
        setChangedOn(baseAgreementDetailsCustomDto.getChangedDate());
        setExpiryDate(baseAgreementDetailsCustomDto.getExpirationDate());
        // Added by Balaji to fix defect
        
        if((UtilityConstants.YES).equals(baseAgreementDetailsCustomDto.getOneWay())){
            setOneWay("Yes");  /* NOI18N */
            }
            else{
                setOneWay("No");  /* NOI18N */ 
                
            }
        if((UtilityConstants.YES).equals(baseAgreementDetailsCustomDto.getIsElectronicSumbmitter())){
            setIsElectronicSubmitter("Yes");  /* NOI18N */
            }
            else{
                setIsElectronicSubmitter("No");  /* NOI18N */ 
                
            }
        
        if((UtilityConstants.YES).equals(baseAgreementDetailsCustomDto.getIsModified())){
            setIsModified("Yes");  /* NOI18N */
            }
            else{
                setIsModified("No");  /* NOI18N */ 
                
            }
        if((BaseAgreementStatusConstant.Active).equals(baseAgreementDetailsCustomDto.getAgreementStatus())){
            setAgreementStatus("Active");  /* NOI18N */
            }
            else{
                setAgreementStatus("InActive");  /* NOI18N */ 
                
            }
       // setLanguage(baseAgreementDetailsCustomDto.getLanguage());
        setFileNo(baseAgreementDetailsCustomDto.getFileNumber());
        setSalesOrganisation(baseAgreementDetailsCustomDto.getSalesOrganization());
        
        BaseAgreementActionForm  actionForm = new BaseAgreementActionForm();
       
        actionForm.setAgreementId(baseAgreementDetailsCustomDto.getAgreementId());
        actionForm.setAgreementNumber(baseAgreementDetailsCustomDto.getAgreementNumber());
        actionForm.setAgreementStatus(baseAgreementDetailsCustomDto.getAgreementStatus());
        actionForm.setBranchOffice(baseAgreementDetailsCustomDto.getBranchOffice());
        actionForm.setCoverageType(baseAgreementDetailsCustomDto.getCoverageType());
        actionForm.setCreatedBy(baseAgreementDetailsCustomDto.getCreatedBy());
        actionForm.setCustomerName(baseAgreementDetailsCustomDto.getCustomerName());
        actionForm.setCustomerNumber(baseAgreementDetailsCustomDto.getCustomerNumber());
        actionForm.setCustomerRepresentive(baseAgreementDetailsCustomDto.getCustomerRepresentative());
        actionForm.setEnterpriseName(baseAgreementDetailsCustomDto.getEnterpriseName());
        actionForm.setEnterpriseNumber(baseAgreementDetailsCustomDto.getEnterpriseNumber());
        actionForm.setEntryDate(baseAgreementDetailsCustomDto.getEntryDate());
        actionForm.setFileNo(baseAgreementDetailsCustomDto.getFileNumber());
        actionForm.setFormNo(baseAgreementDetailsCustomDto.getFormNumber()+"|"+formLongDescripton+"|"+formShortDescripton);  /* NOI18N */
        actionForm.setFormLongDescripton(getFormLongDescripton());
        actionForm.setFormShortDescripton(getFormShortDescripton());
        actionForm.setImageReferenceNumber(baseAgreementDetailsCustomDto.getImageReferenceNumber());
        actionForm.setIsElectronicSubmitter(baseAgreementDetailsCustomDto.getIsElectronicSumbmitter());
        actionForm.setOneWay(baseAgreementDetailsCustomDto.getOneWay());
        actionForm.setSalesOrg(baseAgreementDetailsCustomDto.getSalesOrganization());
        actionForm.setFormNumberKey(getFormDetailKey());
        actionForm.setLegacyCustomerNumber(baseAgreementDetailsCustomDto.getLegacyCustomerNumber());
        actionForm.setInac(baseAgreementDetailsCustomDto.getInac());
        try{
        	String lacceptedDate = null;
        	String expirydate = null;
        	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");  /* NOI18N */
            if(null != baseAgreementDetailsCustomDto.getAcceptedDate()){
            	
            	lacceptedDate = sdf.format(baseAgreementDetailsCustomDto.getAcceptedDate());
            }
            if(null != baseAgreementDetailsCustomDto.getExpirationDate()){
            	
            	expirydate = sdf.format(baseAgreementDetailsCustomDto.getExpirationDate());
            	
            }
           actionForm.setAcceptedDate(lacceptedDate);
           actionForm.setExpirationDate(expirydate);
           }catch(Exception e){
               e.printStackTrace();}
        setActionForm(actionForm);
                   
    }
          
    /**
     * returns the formLongDescripton
     *
     * @return Returns the formLongDescripton.
     */
    public String getFormLongDescripton() {
        return formLongDescripton;
    }
    /**
     * sets the formLongDescripton
     *
     * @param lFormLongDescripton The formLongDescripton to set.
     */
    public void setFormLongDescripton(String lFormLongDescripton) {
        formLongDescripton = lFormLongDescripton;
    }
    /**
     * returns the formNo
     *
     * @return Returns the formNo.
     */
    public String getFormNo() {
        return formNo;
    }
    /**
     * sets the formNo
     *
     * @param lFormNo The formNo to set.
     */
    public void setFormNo(String lFormNo) {
        formNo = lFormNo;
    }
    /**
     * returns the formShortDescripton
     *
     * @return Returns the formShortDescripton.
     */
    public String getFormShortDescripton() {
        return formShortDescripton;
    }
    /**
     * sets the formShortDescripton
     *
     * @param lFormShortDescripton The formShortDescripton to set.
     */
    public void setFormShortDescripton(String lFormShortDescripton) {
        formShortDescripton = lFormShortDescripton;
    }
    /**
     * returns the acceptedDate
     * 
     * @return Returns the acceptedDate.
     */
    public Date getAcceptedDate() {
        return acceptedDate;
    }

    /**
     * sets the acceptedDate
     * 
     * @param lAcceptedDate
     *            The acceptedDate to set.
     */
    public void setAcceptedDate(Date lAcceptedDate) {
        acceptedDate = lAcceptedDate;
    }

    /**
     * returns the agreementNumber
     * 
     * @return Returns the agreementNumber.
     */
    public String getAgreementNumber() {
        return agreementNumber;
    }

    /**
     * sets the agreementNumber
     * 
     * @param lAgreementNumber
     *            The agreementNumber to set.
     */
    public void setAgreementNumber(String lAgreementNumber) {
        agreementNumber = lAgreementNumber;
    }

    /**
     * returns the branchOffice
     * 
     * @return Returns the branchOffice.
     */
    public String getBranchOffice() {
        return branchOffice;
    }

    /**
     * sets the branchOffice
     * 
     * @param lBranchOffice
     *            The branchOffice to set.
     */
    public void setBranchOffice(String lBranchOffice) {
        branchOffice = lBranchOffice;
    }

    /**
     * returns the coverageTypeDetails
     * 
     * @return Returns the coverageTypeDetails.
     */
    public String getCoverageType() {
        return coverageType;
    }

    /**
     * sets the coverageTypeDetails
     *
     * @param lCoverageType 
     */
    public void setCoverageType(String lCoverageType) {
    	lCoverageType = (String)OPPTStaticDataHolder.coverageTypeMap.get(lCoverageType);
        coverageType = lCoverageType;
    }

    /**
     * returns the customerName
     * 
     * @return Returns the customerName.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * sets the customerName
     * 
     * @param lCustomerName
     *            The customerName to set.
     */
    public void setCustomerName(String lCustomerName) {
        customerName = lCustomerName;
    }

    /**
     * returns the customerNumber
     * 
     * @return Returns the customerNumber.
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * sets the customerNumber
     * 
     * @param lCustomerNumber
     *            The customerNumber to set.
     */
    public void setCustomerNumber(String lCustomerNumber) {
        customerNumber = lCustomerNumber;
    }

    /**
     * returns the customerRepresentative
     * 
     * @return Returns the customerRepresentative.
     */
    public String getCustomerRepresentative() {
        return customerRepresentative;
    }

    /**
     * sets the customerRepresentative
     * 
     * @param lCustomerRepresentative
     *            The customerRepresentative to set.
     */
    public void setCustomerRepresentative(String lCustomerRepresentative) {
        customerRepresentative = lCustomerRepresentative;
    }

    /**
     * returns the enterpriseNumber
     * 
     * @return Returns the enterpriseNumber.
     */
    public String getEnterpriseNumber() {
        return enterpriseNumber;
    }

    /**
     * sets the enterpriseNumber
     * 
     * @param lEnterpriseNumber
     *            The enterpriseNumber to set.
     */
    public void setEnterpriseNumber(String lEnterpriseNumber) {
        enterpriseNumber = lEnterpriseNumber;
    }

     /**
     * returns the imageReferenceNumber
     * 
     * @return Returns the imageReferenceNumber.
     */
    public String getImageReferenceNumber() {
        return imageReferenceNumber;
    }

    /**
     * sets the imageReferenceNumber
     * 
     * @param lImageReferenceNumber
     *            The imageReferenceNumber to set.
     */
    public void setImageReferenceNumber(String lImageReferenceNumber) {
        imageReferenceNumber = lImageReferenceNumber;
    }

    /**
     * returns the modificatioDetailsMap
     * 
     * @return Returns the modificatioDetailsMap.
     */
    public TreeMap getModificatioDetailsMap() {
        return modificatioDetailsMap;
    }

    /**
     * sets the modificatioDetailsMap
     * 
     * @param lModificatioDetailsMap
     *            The modificatioDetailsMap to set.
     */
    public void setModificatioDetailsMap(TreeMap lModificatioDetailsMap) {
        modificatioDetailsMap = lModificatioDetailsMap;
    }

    /**
     * returns the coverageTypeMap
     *
     * @return Returns the coverageTypeMap.
     */
    public TreeMap getCoverageTypeMap() {
        return coverageTypeMap;
    }
    /**
     * sets the coverageTypeMap
     *
     * @param lCoverageTypeMap The coverageTypeMap to set.
     */
    public void setCoverageTypeMap(TreeMap lCoverageTypeMap) {
        coverageTypeMap = lCoverageTypeMap;
    }
    /**
     * returns the formDetailsMap
     *
     * @return Returns the formDetailsMap.
     */
    public TreeMap getFormDetailsMap() {
        return formDetailsMap;
    }
    /**
     * sets the formDetailsMap
     *
     * @param lFormDetailsMap The formDetailsMap to set.
     */
    public void setFormDetailsMap(TreeMap lFormDetailsMap) {
        formDetailsMap = lFormDetailsMap;
    }
    /**
     * returns the salesOrgMap
     *
     * @return Returns the salesOrgMap.
     */
    public TreeMap getSalesOrgMap() {
        return salesOrgMap;
    }
    /**
     * sets the salesOrgMap
     *
     * @param lSalesOrgMap The salesOrgMap to set.
     */
    public void setSalesOrgMap(TreeMap lSalesOrgMap) {
        salesOrgMap = lSalesOrgMap;
    }
   /**
     * returns the oneWay
     * 
     * @return Returns the oneWay.
     */
    public String getOneWay() {
        return oneWay;
    }
    /**
     * returns the isElectronicSubmitter
     * 
     * @return Returns the isElectronicSubmitter.
     */
    public String getIsElectronicSubmitter() {
        return isElectronicSubmitter;
    }
    /**
     * returns the agreementId
     *
     * @return Returns the agreementId.
     */
    public int getAgreementId() {
        return agreementId;
    }
    /**
     * sets the agreementId
     *
     * @param lAgreementId The agreementId to set.
     */
    public void setAgreementId(int lAgreementId) {
        agreementId = lAgreementId;
    }
    /**
     * sets the oneWay
     * 
     * @param lOneWay
     *            The oneWay to set.
     */
    public void setOneWay(String lOneWay) {
        oneWay = lOneWay;
    }
    /**
     * sets the IsElectronicSubmitter
     * 
     * @param lisElectronicSubmitter
     *            The isElectronicSubmitter to set.
     */
    public void setIsElectronicSubmitter(String lisElectronicSubmitter) {
    	isElectronicSubmitter = lisElectronicSubmitter;
    }
    /**
     * returns the agreementStatus
     *
     * @return Returns the agreementStatus.
     */
    public String getAgreementStatus() {
        return agreementStatus;
    }
    /**
     * sets the agreementStatus
     *
     * @param lAgreementStatus The agreementStatus to set.
     */
    public void setAgreementStatus(String lAgreementStatus) {
        agreementStatus = lAgreementStatus;
    }
    /**
     * returns the isModified
     *
     * @return Returns the isModified.
     */
    public String getIsModified() {
        return isModified;
    }
    /**
     * sets the isModified
     *
     * @param lIsModified The isModified to set.
     */
    public void setIsModified(String lIsModified) {
        isModified = lIsModified;
    }
    /**
     * returns the fileNo
     *
     * @return Returns the fileNo.
     */
    public String getFileNo() {
        return fileNo;
    }
    /**
     * sets the fileNo
     *
     * @param lFileNo The fileNo to set.
     */
    public void setFileNo(String lFileNo) {
        fileNo = lFileNo;
    }
    /**
     * returns the createdDate
     *
     * @return Returns the createdDate.
     */
    public Date getCreatedDate() {
        return createdDate;
    }
    /**
     * sets the createdDate
     *
     * @param lCreatedDate The createdDate to set.
     */
    public void setCreatedDate(Date lCreatedDate) {
        createdDate = lCreatedDate;
    }
    /**
     * returns the createdBy
     *
     * @return Returns the createdBy.
     */
    public String getCreatedBy() {
        return createdBy;
    }
    /**
     * sets the createdBy
     *
     * @param lCreatedBy The createdBy to set.
     */
    public void setCreatedBy(String lCreatedBy) {
        createdBy = lCreatedBy;
    }
    /**
     * returns the enterpriseName
     *
     * @return Returns the enterpriseName.
     */
    public String getEnterpriseName() {
        return enterpriseName;
    }
    /**
     * sets the enterpriseName
     *
     * @param lEnterpriseName The enterpriseName to set.
     */
    public void setEnterpriseName(String lEnterpriseName) {
        enterpriseName = lEnterpriseName;
    }
    /**
     * sets the enterpriseName
     *
     * @return  BaseAgreementActionForm
     */
    public BaseAgreementActionForm getBaseAgreementActionForm(){
        BaseAgreementActionForm baseagreementActionForm = null;
        if(null != getActionForm() && getActionForm() instanceof BaseAgreementActionForm){
        baseagreementActionForm = (BaseAgreementActionForm)getActionForm();
        }
        else{
            baseagreementActionForm = new BaseAgreementActionForm();
        }
        return baseagreementActionForm;
               
    }
    /**
     * return the salesOrganisation 
     *
     * @return Returns the salesOrganisation.
     */
    public String getSalesOrganisation() {
        return salesOrganisation;
    }
    /**
     * sets the salesOrganisation
     *
     * @param lSalesOrganisation The salesOrganisation to set.
     */
    public void setSalesOrganisation(String lSalesOrganisation) {
    	
    	lSalesOrganisation = (String)OPPTStaticDataHolder.salesOrgMapForBaseAgreement.get(lSalesOrganisation);
        salesOrganisation = lSalesOrganisation ;
    }
    
  
    /**
     *this is the getter method for formDetailKey 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:56:35 PM
     *
     * @return String.
     */
    public String getFormDetailKey() {
        return formDetailKey;
    }
	/**
     *'
     *setFormDetailKey
     *
     *@author Ravi Yandapalli
     * Dec 27, 20065:56:41 PM
     * @param lformDetailKey 
     */
	public void setFormDetailKey(String lformDetailKey) {
		formDetailKey = lformDetailKey;
		if(null != getBaseAgreementActionForm()) {
			getBaseAgreementActionForm().setFormNumberKey(lformDetailKey);
		}
	}
    
    /**
     * sets the form short description and long description
     *
     * @param formNumber.
     */
    public void setData(String formNumber) {
      
       	String formDescription = (String)OPPTStaticDataHolder.formNumberMap.get(formNumber);
       	StringTokenizer formMapValue = new StringTokenizer(formDescription,"|");  /* NOI18N */
       	  
       	if(formMapValue.hasMoreTokens()){
       	 formNumber = formMapValue.nextToken();
       		formLongDescripton = formMapValue.nextToken();
           	formShortDescripton = formMapValue.nextToken();	
       	}
       	
        setFormShortDescripton(formShortDescripton);
        setFormLongDescripton(formLongDescripton);
       	
             
       
    }
    
  
    /**
     * getReverseMap
     *
     * @return TreeMap
     */
    public TreeMap getReverseMap(){
    	TreeMap reverseMap = new TreeMap();
    	TreeMap map = getFormDetailsMap();
    	Iterator iterator = map.keySet().iterator();
    	while(iterator.hasNext()){
    		String key = (String)iterator.next();
    		String value =(String)map.get(key);
    		reverseMap.put(value,key);
       	}
    	
    	return reverseMap;
    	
    }
    /**
     *getSalesOrgDetails
     *
     *@author Ravi Yandapalli
     *
     * Dec 27, 20066:23:40 PM
     * @return
     */
    public TreeMap getSalesOrgDetails(){
    	TreeMap lsalesOrgMap = new TreeMap();
    	TreeMap treeMap = getSalesOrgMap();
    	Iterator iterator = treeMap.keySet().iterator();
    	while(iterator.hasNext()){
    		String key = (String)iterator.next();
    		String value = (String)treeMap.get(key);
    		lsalesOrgMap.put(value+"-"+ key,value+"-"+key);  /* NOI18N */  /* NOI18N */
    	}
    	return lsalesOrgMap;
    }  
	
    /**
     * changed by tapan malhotra
     *
     * @return String
     */
	public String getFormNumbersString(){
    	Map map = OPPTStaticDataHolder.formNumberMap;
    	TreeMap treeMap = new TreeMap();
    	treeMap.putAll(map);
    	Iterator iterator = null;
    	String key = null;
    	String value = null;
    	StringBuffer resultString = new StringBuffer();
    	iterator = map.keySet().iterator();
    	while(iterator.hasNext()){
    		key = (String)iterator.next();
    		value = (String)map.get(key);
    		
    		resultString = resultString.append(value).append("$");  /* NOI18N */
       	}
    	
       	return resultString.toString();
       
        }
	
	/**
     * changed by tapan malhotra
     *
     * @return TreeMap
     */
	public TreeMap getFormNumberDetails(){
	 	BaseAgreementActionForm actionForm  = 	getBaseAgreementActionForm();
	 	String selectedSalesOrg = actionForm.getSalesOrg();
	 	TreeMap FormDetailsMap = new TreeMap();
    	Map treeMap = OPPTStaticDataHolder.formNumberMap;
    	Iterator iterator = treeMap.keySet().iterator();
    	while(iterator.hasNext()){
    	    String key = (String)iterator.next();
    		String value = (String)treeMap.get(key);
    		String[] string = value.split("|");  /* NOI18N */
    		String salesOrg = string[3];
    	    
    		if(salesOrg == selectedSalesOrg)
    		
    		{
    			FormDetailsMap.put(value,key);
    	
    		}
    		
    		
    		
    		
    		
	 }
		return FormDetailsMap;
	 
    	}
	
	/**
     * chanegd by tapan malhotra
     *
     * @return String
     * @param salesOrgName 
     */
	public String getSaleOrgCode(String salesOrgName)
	 {
	 	TreeMap map = getSalesOrgMap();;
	 	String key = "";  /* NOI18N */  
	 	String value = "";  /* NOI18N */
	 	String salesOrgCode ="";  /* NOI18N */
	 	Iterator iterator = map.keySet().iterator();
    	while(iterator.hasNext()){
    		key = (String)iterator.next();
    		value =(String)map.get(key);
    		if (value.equals(salesOrgName))
    		{
    			salesOrgCode = key;
    			break;
    		}
       	}
    	return salesOrgCode;
	 }

	
    /**
     *this is the getter method for changedBy 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:58:43 PM
     *
     * @return String.
     */
    public String getChangedBy() {
        return changedBy;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:58:44 PM
     * @param lChangedBy changedBy.
     */
    public void setChangedBy(String lChangedBy) {
        changedBy = lChangedBy;
    }
    /**
     *this is the getter method for changedOn 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:58:44 PM
     *
     * @return Date.
     */
    public Date getChangedOn() {
        return changedOn;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:58:44 PM
     * @param lChangedOn changedOn.
     */
    public void setChangedOn(Date lChangedOn) {
        changedOn = lChangedOn;
    }
    /**
     *this is the getter method for expiryDate 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:58:44 PM
     *
     * @return Date.
     */
    public Date getExpiryDate() {
        return expiryDate;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:58:44 PM
     * @param lExpiryDate expiryDate.
     */
    public void setExpiryDate(Date lExpiryDate) {
        expiryDate = lExpiryDate;
    }
    /**
     *this is the getter method for languageMap 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:58:44 PM
     *
     * @return TreeMap.
     */
    public TreeMap getLanguageMap() {
        return languageMap;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:58:44 PM
     * @param lLanguageMap languageMap.
     */
    public void setLanguageMap(TreeMap lLanguageMap) {
        languageMap = lLanguageMap;
    }
    /**
     *this is the getter method for showModificationDetail 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:58:44 PM
     *
     * @return boolean.
     */
    public boolean isShowModificationDetail() {
        return showModificationDetail;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:58:44 PM
     * @param lShowModificationDetail showModificationDetail.
     */
    public void setShowModificationDetail(boolean lShowModificationDetail) {
        showModificationDetail = lShowModificationDetail;
    }
}
