/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.BaseAgreementActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;



/**
 * Holds the basic information to display the create agreement form  
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
public class BaseAgreementFormViewBean extends OPPTViewBean{
   
    private TreeMap coverageTypeDetails = null;

    private TreeMap formDetails = null;
    
    private String formDetailKey = null;

    private TreeMap modificationType = null;

    private String customerNumber = null;

    private String customerName = null;

    private String enterpriseNumber = null;

    private String customerRepresentative = null;
    
    private TreeMap salesOrg = null;

    private String agreementNumber = null;

    private String acceptedDate = null;

    private String branchOffice = null;

    private String imageReferenceNumber = null;

    private String oneWay = null;
    
    private int agreementId= 0;
    
    private String coverageType = null;
    
    private String formNo = null;
    
    private String language = null;
    
    private TreeMap languageMap = null;
    
    /**
     * default constructor
     *
     * 
     */
   public  BaseAgreementFormViewBean(){
   	
   	
        
    }
   /**
    *  constructor
    *
    *@param baseAgreementActionForm
    */
   public  BaseAgreementFormViewBean(BaseAgreementActionForm baseAgreementActionForm){
    
   	        setActionForm(baseAgreementActionForm);
   	
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
     * setAgreementId
     * 
     * @param lAgreementId
     *            The acceptedDate to set.
     */
    public void setAgreementId(int lAgreementId) {
        agreementId = lAgreementId;
    }
    /**
     * returns  BaseAgreementActionForm
     * 
     * @return 
     */
    public BaseAgreementActionForm getBaseAgreementActionForm() {
        BaseAgreementActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof BaseAgreementActionForm){
			actionForm = (BaseAgreementActionForm)getActionForm();
		}
		else{
			actionForm = new BaseAgreementActionForm();
			}
		return actionForm;
	}

    /**
     * returns the acceptedDate
     * 
     * @return Returns the acceptedDate.
     */
    public String getAcceptedDate() {
        return acceptedDate;
    }

    /**
     * sets the acceptedDate
     * 
     * @param lAcceptedDate
     *            The acceptedDate to set.
     */
    public void setAcceptedDate(String lAcceptedDate) {
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
    public TreeMap getCoverageTypeDetails() {
        return coverageTypeDetails;
    }

    /**
     * sets the coverageTypeDetails
     * 
     * @param lCoverageTypeDetails
     *            The coverageTypeDetails to set.
     */
    public void setCoverageTypeDetails(TreeMap lCoverageTypeDetails) {
        coverageTypeDetails = lCoverageTypeDetails;
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
     * returns the formDetails
     * 
     * @return Returns the formDetails.
     */
    public TreeMap getFormDetails() {
        return formDetails;
    }

	/**
	 * 
	 *getFormDetailKey
	 *
	 *@author Ravi Yandapalli
	 *
	 * Dec 27, 20066:01:15 PM
	 * @return
	 */
	public String getFormDetailKey() {
		return formDetailKey;
	}
	/**
	 * 
	 *setFormDetailKey
	 *
	 *@author Ravi Yandapalli
	 *
	 * Dec 27, 20066:01:10 PM
	 * @param lformDetailKey
	 */
	public void setFormDetailKey(String lformDetailKey) {
		formDetailKey = lformDetailKey;
		if(null != getBaseAgreementActionForm()) {
			getBaseAgreementActionForm().setFormNumberKey(lformDetailKey);
		}
	}
    /**
     * sets the formDetails
     * 
     * @param lFormDetails
     *            The formDetails to set.
     */
    public void setFormDetails(TreeMap lFormDetails) {
        formDetails = lFormDetails;
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
     * returns the modificationType
     * 
     * @return Returns the modificationType.
     */
    public TreeMap getModificationType() {
        return modificationType;
    }

    /**
     * sets the modificationType
     * 
     * @param lModificationType
     *            The modificationType to set.
     */
    public void setModificationType(TreeMap lModificationType) {
        modificationType = lModificationType;
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
     * sets the oneWay
     * 
     * @param lOneWay
     *            The oneWay to set.
     */
    public void setOneWay(String lOneWay) {
        oneWay = lOneWay;
    }
    /**
     * returns the salesOrg
     *
     * @return Returns the salesOrg.
     */
    public TreeMap getSalesOrg() {
        return salesOrg;
    }
    /**
     * sets the salesOrg
     *
     * @param lSalesOrg The salesOrg to set.
     */
    public void setSalesOrg(TreeMap lSalesOrg) {
        salesOrg = lSalesOrg;
    }
    
    
    /**
     * 
     *getReverseMap
     *
     *@author Ravi Yandapalli
     *
     * Dec 27, 20066:01:47 PM
     * @param map
     * @return
     */
    public TreeMap getReverseMap(TreeMap map){
    	TreeMap reverseMap = new TreeMap();
    	Iterator iterator = map.keySet().iterator();
    	while(iterator.hasNext()){
    		String key = (String)iterator.next();
    		String value =(String)map.get(key);
    		reverseMap.put(value,key);
       	}
    	
    	return reverseMap;
    	
    }
    /**
     * 
     *getSalesOrgDetails
     *
     *@author Ravi Yandapalli
     *
     * Dec 27, 20066:01:52 PM
     * @return
     */
    public TreeMap getSalesOrgDetails(){
    	TreeMap salesOrgMap = new TreeMap();
    	TreeMap treeMap = getSalesOrg();
    	Iterator iterator = treeMap.keySet().iterator();
    	while(iterator.hasNext()){
    		String key = (String)iterator.next();
    		String value = (String)treeMap.get(key);
    		salesOrgMap.put(value +"-"+ key,value +"-"+ key);  /* NOI18N */  /* NOI18N */
    	}
    	return salesOrgMap;
    }
    /**
     * 
     *getFormNumbersString
     *
     *@author Ravi Yandapalli
     *
     * Dec 27, 20066:02:16 PM
     * @return
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
     *this is the getter method for coverageType 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:24:39 PM
     *
     * @return String.
     */
    public String getCoverageType() {
        return coverageType;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:24:39 PM
     * @param lCoverageType coverageType.
     */
    public void setCoverageType(String lCoverageType) {
        coverageType = lCoverageType;
    }
    /**
     *this is the getter method for formNo 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:24:39 PM
     *
     * @return String.
     */
    public String getFormNo() {
        return formNo;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:24:39 PM
     * @param lFormNo formNo.
     */
    public void setFormNo(String lFormNo) {
        formNo = lFormNo;
    }
    /**
     *this is the getter method for language 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:24:39 PM
     *
     * @return String.
     */
    public String getLanguage() {
        return language;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:24:39 PM
     * @param lLanguage language.
     */
    public void setLanguage(String lLanguage) {
        language = lLanguage;
    }
    /**
     *this is the getter method for languageMap 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:24:39 PM
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
     *Dec 27, 2006   6:24:39 PM
     * @param lLanguageMap languageMap.
     */
    public void setLanguageMap(TreeMap lLanguageMap) {
        languageMap = lLanguageMap;
    }
}
