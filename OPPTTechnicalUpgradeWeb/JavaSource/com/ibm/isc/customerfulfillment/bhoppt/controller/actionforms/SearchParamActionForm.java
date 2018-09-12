/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * This is the Search Param ActionForm
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SearchParamActionForm extends OPPTActionForm{

    private String customerNumber = null;

    private String enterpriseNumber = null;

    private String formNumber = null;

    private String agreementNumber = null;
    
    private String customerName = null;
    
    private String imageReferenceNumber = null;
    
    private String customerLegacyNumber = null;
    
    private String accountNumber =null;
    
	
    
    
    /**
     *this is the getter method for accountNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:49:26 PM
     *
     * @return String.
     */
    public String getAccountNumber() {
        return accountNumber;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:49:26 PM
     * @param lAccountNumber accountNumber.
     */
    public void setAccountNumber(String lAccountNumber) {
        accountNumber = lAccountNumber;
    }
    /**
     *this is the getter method for agreementNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:49:26 PM
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
     *Dec 27, 2006   4:49:26 PM
     * @param lAgreementNumber agreementNumber.
     */
    public void setAgreementNumber(String lAgreementNumber) {
        agreementNumber = lAgreementNumber;
    }
    /**
     *this is the getter method for customerLegacyNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:49:26 PM
     *
     * @return String.
     */
    public String getCustomerLegacyNumber() {
        return customerLegacyNumber;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:49:26 PM
     * @param lCustomerLegacyNumber customerLegacyNumber.
     */
    public void setCustomerLegacyNumber(String lCustomerLegacyNumber) {
        customerLegacyNumber = lCustomerLegacyNumber;
    }
    /**
     *this is the getter method for customerName 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:49:26 PM
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
     *Dec 27, 2006   4:49:26 PM
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
     *Dec 27, 2006   4:49:26 PM
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
     *Dec 27, 2006   4:49:26 PM
     * @param lCustomerNumber customerNumber.
     */
    public void setCustomerNumber(String lCustomerNumber) {
        customerNumber = lCustomerNumber;
    }
    /**
     *this is the getter method for enterpriseNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:49:26 PM
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
     *Dec 27, 2006   4:49:26 PM
     * @param lEnterpriseNumber enterpriseNumber.
     */
    public void setEnterpriseNumber(String lEnterpriseNumber) {
        enterpriseNumber = lEnterpriseNumber;
    }
    /**
     *this is the getter method for formNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:49:26 PM
     *
     * @return String.
     */
    public String getFormNumber() {
        return formNumber;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:49:27 PM
     * @param lFormNumber formNumber.
     */
    public void setFormNumber(String lFormNumber) {
        formNumber = lFormNumber;
    }
    /**
     *this is the getter method for imageReferenceNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:49:27 PM
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
     *Dec 27, 2006   4:49:27 PM
     * @param lImageReferenceNumber imageReferenceNumber.
     */
    public void setImageReferenceNumber(String lImageReferenceNumber) {
        imageReferenceNumber = lImageReferenceNumber;
    }
    /**
     * validate the all values
     * 
     * it's at least one value not null
     * 
     * @return error report     * 
     * 
     * 
     */
    
    
    public ErrorReport validate() {
		ErrorReport errorReport = new ErrorReport();
		if(isFieldEmpty(customerNumber) && isFieldEmpty(enterpriseNumber) && isFieldEmpty(formNumber) && isFieldEmpty(agreementNumber) &&
				isFieldEmpty(customerName) && isFieldEmpty(imageReferenceNumber) && isFieldEmpty(customerLegacyNumber) && isFieldEmpty(accountNumber) 	){
		    errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF210 , OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		
		return errorReport;
	}
}
