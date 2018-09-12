/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import java.util.Date;
import java.util.StringTokenizer;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * This is the Base Agreement Action Form
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAgreementActionForm extends OPPTActionForm{
   
    
    private int agreementId = 0;

    private String agreementNumber = null;

    private Date entryDate = null;

    private String acceptedDate = null;

    private String formNo = null;

    private String enterpriseName = null;
    
    private String fileNo = null;

    private String customerNumber = null;

    private String enterpriseNumber = null;

    private String branchOffice = null;

    private String coverageType = null;

    private String customerRepresentive = null;

    private String salesOrg = null;

    private String agreementStatus = null;

    private String isElectronicSubmitter = null;

    private String createdBy = null;

    private String formShortDescripton = null;

    private String formLongDescripton = null;

    private String imageReferenceNumber = null;

    private String customerName = null;

    private String oneWay = null;
    
    private String expirationDate = null;
    
    private String formNumberKey = null;
    
    private String legacyCustomerNumber=null;
	
    private String inac =null;
    
   // private String language = null;

   
	/**
     * isIntValue
     *
     * @param stringValue
     * @return boolean
     * @return boolean
     * @param stringValue 
     */

   
    public boolean isIntValue(String stringValue){
        boolean isIntegerValue = true;
		if(null != stringValue && 0 < stringValue.trim().length()){
		      stringValue = stringValue.trim();
		      int length = stringValue.length();
			      for(int j=0; j<length; j++){
			       char currentChar = stringValue.charAt(j);
			       if((currentChar >='0' && currentChar <= '9')){
			        isIntegerValue = true;
			       }
			       else{
			        isIntegerValue = false;
			       
			       break;
			       }
		      }
		        }
		    return isIntegerValue;
       }
    /**
     * Reset the default values
     *
     * @return ErrorReport
     */
/*    public void reset(){
        	agreementId = 0;
        	agreementNumber = null;
        	entryDate = null;
        	acceptedDate = null;
        	formNo = null;
        	enterpriseName = null;
        	fileNo = null;
        	customerNumber = null;
        	enterpriseNumber = null;
        	branchOffice = null;
        	coverageType = null;
        	customerRepresentive = null;
        	salesOrg = null;
        	agreementStatus = null;
        	isElectronicSubmitter = null;
        	createdBy = null;
        	formShortDescripton = null;
        	formLongDescripton = null;
        	imageReferenceNumber = null;
        	customerName = null;
        	oneWay = null;
        	expirationDate = null;
        	formNumberKey = null;
        	legacyCustomerNumber=null;
        	inac =null;
        
		}*/

    public ErrorReport validate() {
    	
		ErrorReport errorReport = new ErrorReport();
		if(isFieldEmpty(getAgreementNumber())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF205, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
							
		if(isFieldEmpty(getCustomerNumber()) || isFieldEmpty(getCustomerName())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF214, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
		
		if(isFieldEmpty(getCustomerRepresentive())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF203, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
		/*if(isFieldEmpty(getLegacyCustomerNumber())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF230, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}*/
		if(isSelectEmpty(getFormNo())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF204, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		} 
			
		if(isSelectEmpty(getCoverageType())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF216, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
				
		if(isFieldEmpty(getAcceptedDate())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF206, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
		if(!isValidDate(getAcceptedDate())){
		    errorReport.put(new ErrorKey(ErrorCodeConstants.PAF217, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
		if(isSelectEmpty(getSalesOrg())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF222, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}	
		if( !isIntValue(getCustomerNumber())){
		    errorReport.put(new ErrorKey(ErrorCodeConstants.PAF223, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		 }
		if( !isIntValue(getEnterpriseNumber())){
		    errorReport.put(new ErrorKey(ErrorCodeConstants.PAF224, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		 }
		if( !isIntValue(getFileNo())){
		     errorReport.put(new ErrorKey(ErrorCodeConstants.PAF225, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
	    if(!isIntValue(getImageReferenceNumber())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF226, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}


		return errorReport;
    }
   /**
    * 
    *parseFormNumber
    *
    *@author Ravi Yandapalli
    *
    * Dec 27, 20064:36:45 PM
    * @param formDetails
    * @return
    */ 
    public String parseFormNumber(String formDetails) {
    	StringTokenizer tok = new StringTokenizer(formDetails,"|");  /* NOI18N */
    	String formNumber = "";  /* NOI18N */
    	if(tok.hasMoreElements()) {
    		formNumber = (String) tok.nextElement();
    	}
    	return formNumber;
    }
 


    /**
     *this is the getter method for acceptedDate 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     *
     * @return String.
     */
    public String getAcceptedDate() {
        return acceptedDate;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     * @param lAcceptedDate acceptedDate.
     */
    public void setAcceptedDate(String lAcceptedDate) {
        acceptedDate = lAcceptedDate;
    }
    /**
     *this is the getter method for agreementId 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     *
     * @return int.
     */
    public int getAgreementId() {
        return agreementId;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     * @param lAgreementId agreementId.
     */
    public void setAgreementId(int lAgreementId) {
        agreementId = lAgreementId;
    }
    /**
     *this is the getter method for agreementNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     *
     * @return String.
     */
    public String getAgreementNumber() {
        return agreementNumber;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     * @param lAgreementNumber agreementNumber.
     */
    public void setAgreementNumber(String lAgreementNumber) {
        agreementNumber = lAgreementNumber;
    }
    /**
     *this is the getter method for agreementStatus 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     *
     * @return String.
     */
    public String getAgreementStatus() {
        return agreementStatus;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     * @param lAgreementStatus agreementStatus.
     */
    public void setAgreementStatus(String lAgreementStatus) {
        agreementStatus = lAgreementStatus;
    }
    /**
     *this is the getter method for branchOffice 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     *
     * @return String.
     */
    public String getBranchOffice() {
        return branchOffice;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     * @param lBranchOffice branchOffice.
     */
    public void setBranchOffice(String lBranchOffice) {
        branchOffice = lBranchOffice;
    }
    /**
     *this is the getter method for coverageType 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
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
     *Dec 27, 2006   4:36:33 PM
     * @param lCoverageType coverageType.
     */
    public void setCoverageType(String lCoverageType) {
        coverageType = lCoverageType;
    }
    /**
     *this is the getter method for createdBy 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     *
     * @return String.
     */
    public String getCreatedBy() {
        return createdBy;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     * @param lCreatedBy createdBy.
     */
    public void setCreatedBy(String lCreatedBy) {
        createdBy = lCreatedBy;
    }
    /**
     *this is the getter method for customerName 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     *
     * @return String.
     */
    public String getCustomerName() {
        return customerName;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     * @param lCustomerName customerName.
     */
    public void setCustomerName(String lCustomerName) {
        customerName = lCustomerName;
    }
    /**
     *this is the getter method for customerNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     *
     * @return String.
     */
    public String getCustomerNumber() {
        return customerNumber;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     * @param lCustomerNumber customerNumber.
     */
    public void setCustomerNumber(String lCustomerNumber) {
        customerNumber = lCustomerNumber;
    }
    /**
     *this is the getter method for customerRepresentive 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     *
     * @return String.
     */
    public String getCustomerRepresentive() {
        return customerRepresentive;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     * @param lCustomerRepresentive customerRepresentive.
     */
    public void setCustomerRepresentive(String lCustomerRepresentive) {
        customerRepresentive = lCustomerRepresentive;
    }
    /**
     *this is the getter method for enterpriseName 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     *
     * @return String.
     */
    public String getEnterpriseName() {
        return enterpriseName;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:33 PM
     * @param lEnterpriseName enterpriseName.
     */
    public void setEnterpriseName(String lEnterpriseName) {
        enterpriseName = lEnterpriseName;
    }
    /**
     *this is the getter method for enterpriseNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     *
     * @return String.
     */
    public String getEnterpriseNumber() {
        return enterpriseNumber;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     * @param lEnterpriseNumber enterpriseNumber.
     */
    public void setEnterpriseNumber(String lEnterpriseNumber) {
        enterpriseNumber = lEnterpriseNumber;
    }
    /**
     *this is the getter method for entryDate 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     *
     * @return Date.
     */
    public Date getEntryDate() {
        return entryDate;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     * @param lEntryDate entryDate.
     */
    public void setEntryDate(Date lEntryDate) {
        entryDate = lEntryDate;
    }
    /**
     *this is the getter method for expirationDate 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     *
     * @return String.
     */
    public String getExpirationDate() {
        return expirationDate;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     * @param lExpirationDate expirationDate.
     */
    public void setExpirationDate(String lExpirationDate) {
        expirationDate = lExpirationDate;
    }
    /**
     *this is the getter method for fileNo 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     *
     * @return String.
     */
    public String getFileNo() {
        return fileNo;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     * @param lFileNo fileNo.
     */
    public void setFileNo(String lFileNo) {
        fileNo = lFileNo;
    }
    /**
     *this is the getter method for formLongDescripton 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     *
     * @return String.
     */
    public String getFormLongDescripton() {
        return formLongDescripton;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     * @param lFormLongDescripton formLongDescripton.
     */
    public void setFormLongDescripton(String lFormLongDescripton) {
        formLongDescripton = lFormLongDescripton;
    }
    /**
     *this is the getter method for formNo 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
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
     *Dec 27, 2006   4:36:34 PM
     * @param lFormNo formNo.
     */
    public void setFormNo(String lFormNo) {
        formNo = lFormNo;
    }
    /**
     *this is the getter method for formNumberKey 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     *
     * @return String.
     */
    public String getFormNumberKey() {
        return formNumberKey;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     * @param lFormNumberKey formNumberKey.
     */
    public void setFormNumberKey(String lFormNumberKey) {
        formNumberKey = lFormNumberKey;
    }
    /**
     *this is the getter method for formShortDescripton 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     *
     * @return String.
     */
    public String getFormShortDescripton() {
        return formShortDescripton;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     * @param lFormShortDescripton formShortDescripton.
     */
    public void setFormShortDescripton(String lFormShortDescripton) {
        formShortDescripton = lFormShortDescripton;
    }
    /**
     *this is the getter method for imageReferenceNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     *
     * @return String.
     */
    public String getImageReferenceNumber() {
        return imageReferenceNumber;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     * @param lImageReferenceNumber imageReferenceNumber.
     */
    public void setImageReferenceNumber(String lImageReferenceNumber) {
        imageReferenceNumber = lImageReferenceNumber;
    }
    /**
     *this is the getter method for inac 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     *
     * @return String.
     */
    public String getInac() {
        return inac;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     * @param lInac inac.
     */
    public void setInac(String lInac) {
        inac = lInac;
    }
    /**
     *this is the getter method for isElectronicSubmitter 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     *
     * @return String.
     */
    public String getIsElectronicSubmitter() {
        return isElectronicSubmitter;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     * @param lIsElectronicSubmitter isElectronicSubmitter.
     */
    public void setIsElectronicSubmitter(String lIsElectronicSubmitter) {
        isElectronicSubmitter = lIsElectronicSubmitter;
    }
    /**
     *this is the getter method for legacyCustomerNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     *
     * @return String.
     */
    public String getLegacyCustomerNumber() {
        return legacyCustomerNumber;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     * @param lLegacyCustomerNumber legacyCustomerNumber.
     */
    public void setLegacyCustomerNumber(String lLegacyCustomerNumber) {
        legacyCustomerNumber = lLegacyCustomerNumber;
    }
    /**
     *this is the getter method for oneWay 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:34 PM
     *
     * @return String.
     */
    public String getOneWay() {
        return oneWay;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:35 PM
     * @param lOneWay oneWay.
     */
    public void setOneWay(String lOneWay) {
        oneWay = lOneWay;
    }
    /**
     *this is the getter method for salesOrg 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:35 PM
     *
     * @return String.
     */
    public String getSalesOrg() {
        return salesOrg;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:36:35 PM
     * @param lSalesOrg salesOrg.
     */
    public void setSalesOrg(String lSalesOrg) {
        salesOrg = lSalesOrg;
    }
}
