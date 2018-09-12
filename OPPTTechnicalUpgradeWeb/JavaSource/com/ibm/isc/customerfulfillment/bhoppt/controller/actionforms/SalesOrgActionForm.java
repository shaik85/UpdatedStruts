/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;

/**
 * This is the Sales Organization ActionForm  
 * 
 * @author Nayanatara L Pai
 * Oct 13, 2006
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SalesOrgActionForm extends OPPTActionForm {
	
	private String salesOrganization = null;
	
	

	
    /**
     *gets the  salesOrganization
     *
     * @return Returns the salesOrganization.
     */
    public String getSalesOrganization() {
        return salesOrganization;
    }
  
 


    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:48:45 PM
     * @param lSalesOrganization salesOrganization.
     */
    public void setSalesOrganization(String lSalesOrganization) {
        salesOrganization = lSalesOrganization;
    }
}
