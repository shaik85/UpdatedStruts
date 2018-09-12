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
public class ReportInfoActionForm extends OPPTActionForm  {

	private String salesOrg = null;
	
	private String status = null;
	
	
    /**
     *this is the getter method for salesOrg 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:47:09 PM
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
     *Dec 27, 2006   4:47:09 PM
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
     *Dec 27, 2006   4:47:09 PM
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
     *Dec 27, 2006   4:47:09 PM
     * @param lStatus status.
     */
    public void setStatus(String lStatus) {
        status = lStatus;
    }
	/**
	 *reset
	 *
	 *@author Ravi Yandapalli
	 *
	 *Dec 27, 2006  4:46:58 PM
	 *
	 *
	 */ 
	 public void reset(){
	 	 salesOrg = null;
		
		 status = null;
	 }
	 }

