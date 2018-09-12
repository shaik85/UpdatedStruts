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
 * This is the Modification Contact ActionForm  
 * 
 * @author Nayanatara L Pai
 * Sep 28, 2006
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ModificationContactActionForm extends OPPTActionForm {
	
	private String legalContact;
	
	private String accountingContact;

	private String Modificationcontact=null;
	

	
	
	
    /**
     *this is the getter method for accountingContact 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:42:32 PM
     *
     * @return String.
     */
    public String getAccountingContact() {
        return accountingContact;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:42:32 PM
     * @param lAccountingContact accountingContact.
     */
    public void setAccountingContact(String lAccountingContact) {
        accountingContact = lAccountingContact;
    }
    /**
     *this is the getter method for legalContact 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:42:32 PM
     *
     * @return String.
     */
    public String getLegalContact() {
        return legalContact;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:42:32 PM
     * @param lLegalContact legalContact.
     */
    public void setLegalContact(String lLegalContact) {
        legalContact = lLegalContact;
    }
    /**
     *this is the getter method for Modificationcontact 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:42:33 PM
     *
     * @return String.
     */
    public String getModificationcontact() {
        return Modificationcontact;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:42:33 PM
     * @param lModificationcontact modificationcontact.
     */
    public void setModificationcontact(String lModificationcontact) {
        Modificationcontact = lModificationcontact;
    }
	/**
	 * Reset the default values
	 * 
	 */
	public void reset(){
	    legalContact=null;
		accountingContact=null;
        Modificationcontact=null;

	}
	/**
     * validate 
     *  
     * legalcontact and accounting contact are mandatory fields
     * 
     * @return error report     * 
     * 
     * 
     */
	
	public ErrorReport validate() {
		
		ErrorReport errorReport = new ErrorReport();
		if(isFieldEmpty(getLegalContact())){
			errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF227, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		/*
		
		if(isFieldEmpty(getAccountingContact())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF229, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}*/
		return errorReport;
	}
	
}
