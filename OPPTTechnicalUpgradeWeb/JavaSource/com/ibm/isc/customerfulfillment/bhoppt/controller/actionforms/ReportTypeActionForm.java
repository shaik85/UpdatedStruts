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
 * Actionform to get reporttype
 * 
 * @author Gavaskar Bhojan
 * oct 11, 2006
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ReportTypeActionForm extends OPPTActionForm {

	private String reportType = null;


    /**
     *this is the getter method for reportType 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:47:47 PM
     *
     * @return String.
     */
    public String getReportType() {
        return reportType;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:47:47 PM
     * @param lReportType reportType.
     */
    public void setReportType(String lReportType) {
        reportType = lReportType;
    }
/**
 * Reset the default values
 *  
 */
public void reset(){
    reportType = null;
}




}
