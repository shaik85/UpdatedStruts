/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * This is the Modification ActionForm 
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ModificationActionForm extends OPPTActionForm{

    private int agreementId = 0;

    private String modificationTypeCode = null;

    private String legalContact = null;

    private String accountingContact = null;

    private String modifiedIBMLetterHead = null;

    private String revenueRecognition = null;
    
    private String rolStartDate = null;
    
    private String rolEndDate = null;

    private String rolOptions = null;
    
    private String details = null; 
    
      
	
    /**
     * return the agreementId 
     *
     * @return Returns the agreementId.
     */
    public int getAgreementId() {
        return agreementId;
    }
    /**
     * sets the agreementId
     *
     * @param lAgreementId The agreementId to set.
     */
    public void setAgreementId(int lAgreementId) {
        agreementId = lAgreementId;
    }
    /**
     * return the details 
     *
     * @return Returns the details.
     */
    public String getDetails() {
        return details;
    }
    /**
     * sets the details
     *
     * @param lDetails The details to set.
     */
    public void setDetails(String lDetails) {
        details = lDetails;
    }
    /**
     * gets the accountingContact *
     * 
     * @return Returns the accountingContact.
     */
    public String getAccountingContact() {
        return accountingContact;
    }

    /**
     * sets the accountingContact
     * 
     * @param lAccountingContact
     *            The accountingContact to set.
     */
    public void setAccountingContact(String lAccountingContact) {
        accountingContact = lAccountingContact;
    }

    /**
     * gets the agreementId *
     * 
     * @return Returns the agreementId.
     */
    public int getagreementId() {
        return agreementId;
    }

    /**
     * sets the agreementId
     * 
     * @param lagreementId
     *            The agreementId to set.
     */
    public void setagreementId(int lagreementId) {
        agreementId = lagreementId;
    }

    /**
     * gets the legalContact *
     * 
     * @return Returns the legalContact.
     */
    public String getLegalContact() {
        return legalContact;
    }

    /**
     * sets the legalContact
     * 
     * @param lLegalContact
     *            The legalContact to set.
     */
    public void setLegalContact(String lLegalContact) {
        legalContact = lLegalContact;
    }

    /**
     * gets the modificationTypeCode *
     * 
     * @return Returns the modificationTypeCode.
     */
    public String getModificationTypeCode() {
        return modificationTypeCode;
    }

    /**
     * sets the modificationTypeCode
     * 
     * @param lModificationTypeCode
     *            The modificationTypeCode to set.
     */
    public void setModificationTypeCode(String lModificationTypeCode) {
        modificationTypeCode = lModificationTypeCode;
    }

    /**
     * gets the modifiedIBMLetterHead *
     * 
     * @return Returns the modifiedIBMLetterHead.
     */
    public String getModifiedIBMLetterHead() {
        return modifiedIBMLetterHead;
    }

    /**
     * sets the modifiedIBMLetterHead
     * 
     * @param lModifiedIBMLetterHead
     *            The modifiedIBMLetterHead to set.
     */
    public void setModifiedIBMLetterHead(String lModifiedIBMLetterHead) {
        modifiedIBMLetterHead = lModifiedIBMLetterHead;
    }

        /**
     * returns the rolOptions
     *
     * @return Returns the rolOptions.
     */
    public String getRolOptions() {
        return rolOptions;
    }
    /**
     * sets the rolOptions
     *
     * @param lRolOptions The rolOptions to set.
     */
    public void setRolOptions(String lRolOptions) {
        rolOptions = lRolOptions;
    }
    /**
     * validate the agreementId
     *  
     * it's at least one value not null
     * 
     * @return error report     * 
     * 
     * 
     */
    
    public ErrorReport validate() {
		ErrorReport errorReport = new ErrorReport();
		if(isFieldEmpty(getDetails())){
			errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF209, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		
		if(BaseAgreementModificationConstants.ROL.equalsIgnoreCase(getModificationTypeCode() )){
		  if(isFieldEmpty(getRolStartDate())){
			  errorReport.put(new ErrorKey(ErrorCodeConstants.PAF219, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		  	}
		
		if(!isValidDate(getRolStartDate())){
		    errorReport.put(new ErrorKey(ErrorCodeConstants.PAF218, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		 }
		if(isSelectEmpty(getRolOptions())){
			 errorReport.put(new ErrorKey(ErrorCodeConstants.PAF220, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
		if(null != OPPTHelper.trimStringToNull(getRolEndDate())){
			if(!isValidDate(getRolEndDate())){
			 errorReport.put(new ErrorKey(ErrorCodeConstants.PAF221, OPPTMessageCatalog.TYPE_PRESENTATION),null);
			}
		}
	}	
		if(isFieldEmpty(getLegalContact())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF227, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		return errorReport;
	}
	
    
    
    
    
	
    /**
     *this is the getter method for revenueRecognition 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:41:04 PM
     *
     * @return String.
     */
    public String getRevenueRecognition() {
        return revenueRecognition;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:41:04 PM
     * @param lRevenueRecognition revenueRecognition.
     */
    public void setRevenueRecognition(String lRevenueRecognition) {
        revenueRecognition = lRevenueRecognition;
    }
    /**
     *this is the getter method for rolEndDate 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:41:04 PM
     *
     * @return String.
     */
    public String getRolEndDate() {
        return rolEndDate;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:41:04 PM
     * @param lRolEndDate rolEndDate.
     */
    public void setRolEndDate(String lRolEndDate) {
        rolEndDate = lRolEndDate;
    }
    /**
     *this is the getter method for rolStartDate 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:41:04 PM
     *
     * @return String.
     */
    public String getRolStartDate() {
        return rolStartDate;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:41:04 PM
     * @param lRolStartDate rolStartDate.
     */
    public void setRolStartDate(String lRolStartDate) {
        rolStartDate = lRolStartDate;
    }
	/**
	 * Set the default values
	 */
	public void reset() {
		setAgreementId(0);
		setAccountingContact("");  /* NOI18N */
		setLegalContact("");  /* NOI18N */
		setModifiedIBMLetterHead(null);
		setModificationTypeCode("");  /* NOI18N */
		setRevenueRecognition(null);
		setRolEndDate("");  /* NOI18N */
		setRolStartDate("");  /* NOI18N */
		setRolOptions("");  /* NOI18N */
		setDetails("");  /* NOI18N */
		
		
	}
}
