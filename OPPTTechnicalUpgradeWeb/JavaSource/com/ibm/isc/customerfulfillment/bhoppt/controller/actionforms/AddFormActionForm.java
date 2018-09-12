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
 * This is the Add Form ActionForm  
 * 
 * @author Nayanatara L Pai
 * Oct 13, 2006
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AddFormActionForm extends OPPTActionForm {
	
	private String formNumber = null;
	
	private String formVersion = null;
	
	private String formLongDescription = null;
	
	private String formShortDescription = null;
	
	private String language = null;
	
	private String salesOrg = null;
	
	
	
   
    /**
     *this is the getter method for formLongDescription 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:35:41 PM
     *
     * @return String.
     */
    public String getFormLongDescription() {
        return formLongDescription;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:35:41 PM
     * @param lFormLongDescription formLongDescription.
     */
    public void setFormLongDescription(String lFormLongDescription) {
        formLongDescription = lFormLongDescription;
    }
    /**
     *this is the getter method for formNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:35:42 PM
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
     *Dec 27, 2006   4:35:43 PM
     * @param lFormNumber formNumber.
     */
    public void setFormNumber(String lFormNumber) {
        formNumber = lFormNumber;
    }
    /**
     *this is the getter method for formShortDescription 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:35:43 PM
     *
     * @return String.
     */
    public String getFormShortDescription() {
        return formShortDescription;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:35:43 PM
     * @param lFormShortDescription formShortDescription.
     */
    public void setFormShortDescription(String lFormShortDescription) {
        formShortDescription = lFormShortDescription;
    }
    /**
     *this is the getter method for formVersion 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:35:43 PM
     *
     * @return String.
     */
    public String getFormVersion() {
        return formVersion;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:35:43 PM
     * @param lFormVersion formVersion.
     */
    public void setFormVersion(String lFormVersion) {
        formVersion = lFormVersion;
    }
    /**
     *this is the getter method for language 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:35:43 PM
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
     *Dec 27, 2006   4:35:43 PM
     * @param lLanguage language.
     */
    public void setLanguage(String lLanguage) {
        language = lLanguage;
    }
    /**
     *this is the getter method for salesOrg 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:35:44 PM
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
     *Dec 27, 2006   4:35:44 PM
     * @param lSalesOrg salesOrg.
     */
    public void setSalesOrg(String lSalesOrg) {
        salesOrg = lSalesOrg;
    }
	/**
     * validate the mandatory fields
     * 
     * @return error report      
     *  
     */
	public ErrorReport validate() {
    	
		ErrorReport errorReport = new ErrorReport();

									
		if(isFieldEmpty(getFormNumber())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF230, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
		if(isFieldEmpty(getFormVersion())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF235, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
		
		if(isFieldEmpty(getFormLongDescription())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF231, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
		
		if(isFieldEmpty(getFormShortDescription())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF232, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		} 
			
		if(isFieldEmpty(getLanguage())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF233, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
				
		return errorReport;
    }
	

}
