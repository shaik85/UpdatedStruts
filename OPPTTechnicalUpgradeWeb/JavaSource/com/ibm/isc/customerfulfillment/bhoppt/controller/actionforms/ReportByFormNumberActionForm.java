/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;



/**
 * Actionform to get reporttype ,formnumber and status
 * 
 * @author Gavaskar Bhojan
 * oct 11, 2006
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ReportByFormNumberActionForm extends OPPTActionForm {
	
	private String salesOrg= null;
	
	private String[] formNumber = null;
	
	private String status = null;
	
	private String formInput = null;
	
	private String allFormNumbers = null;

	
	
	 
    /**
     *this is the getter method for allFormNumbers 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:45:09 PM
     *
     * @return String.
     */
    public String getAllFormNumbers() {
        return allFormNumbers;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:45:09 PM
     * @param lAllFormNumbers allFormNumbers.
     */
    public void setAllFormNumbers(String lAllFormNumbers) {
        allFormNumbers = lAllFormNumbers;
    }
    /**
     *this is the getter method for formInput 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:45:09 PM
     *
     * @return String.
     */
    public String getFormInput() {
        return formInput;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:45:09 PM
     * @param lFormInput formInput.
     */
    public void setFormInput(String lFormInput) {
        formInput = lFormInput;
    }
    /**
     *this is the getter method for formNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:45:09 PM
     *
     * @return String[].
     */
    public String[] getFormNumber() {
        return formNumber;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:45:09 PM
     * @param lFormNumber formNumber.
     */
    public void setFormNumber(String[] lFormNumber) {
        formNumber = lFormNumber;
    }
    /**
     *this is the getter method for salesOrg 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:45:09 PM
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
     *Dec 27, 2006   4:45:09 PM
     * @param lSalesOrg salesOrg.
     */
    public void setSalesOrg(String lSalesOrg) {
        salesOrg = lSalesOrg;
    }
    /**
     *this is the getter method for status 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:45:09 PM
     *
     * @return String.
     */
    public String getStatus() {
        return status;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:45:09 PM
     * @param lStatus status.
     */
    public void setStatus(String lStatus) {
        status = lStatus;
    }
    /**
     * 
     *reset
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006  4:45:17 PM
     *
     *
     */
	 public void reset(){
	 	salesOrg = null;
		formNumber = null;
		status = null;
		formInput = null;
		allFormNumbers = null;
	}
}
