/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;



import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;

/**
 * Actionform to get reporttstatus and salesOrg
 * 
 * @author Gavaskar Bhojan
 * oct 11, 2006
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ReportByModificationTypeActionForm extends OPPTActionForm{
   
	private String salesOrg = null;
	
	private String status = null;
	
	private String[] typeCode = null;
	
	private String modTypeCode = null;
	
	private String allModifications = null;
	
	
	
    /**
     *this is the getter method for allModifications 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:46:23 PM
     *
     * @return String.
     */
    public String getAllModifications() {
        return allModifications;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:46:23 PM
     * @param lAllModifications allModifications.
     */
    public void setAllModifications(String lAllModifications) {
        allModifications = lAllModifications;
    }
    /**
     *this is the getter method for modTypeCode 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:46:23 PM
     *
     * @return String.
     */
    public String getModTypeCode() {
        return modTypeCode;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:46:23 PM
     * @param lModTypeCode modTypeCode.
     */
    public void setModTypeCode(String lModTypeCode) {
        modTypeCode = lModTypeCode;
    }
    /**
     *this is the getter method for salesOrg 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:46:23 PM
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
     *Dec 27, 2006   4:46:23 PM
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
     *Dec 27, 2006   4:46:23 PM
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
     *Dec 27, 2006   4:46:23 PM
     * @param lStatus status.
     */
    public void setStatus(String lStatus) {
        status = lStatus;
    }
    /**
     *this is the getter method for typeCode 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:46:23 PM
     *
     * @return String[].
     */
    public String[] getTypeCode() {
        return typeCode;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:46:23 PM
     * @param lTypeCode typeCode.
     */
    public void setTypeCode(String[] lTypeCode) {
        typeCode = lTypeCode;
    }
	/**
	 * 
	 *reset
	 *
	 *@author Ravi Yandapalli
	 *
	 *Dec 27, 2006  4:46:12 PM
	 *
	 *
	 */
	 public void reset(){
	 	salesOrg = null;
	 	typeCode = null;
		status = null;
		modTypeCode = null;
		allModifications = null;
	}
}
