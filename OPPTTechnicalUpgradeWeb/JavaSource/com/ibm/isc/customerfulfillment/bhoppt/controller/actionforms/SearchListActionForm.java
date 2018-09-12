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
 * This is the Search List ActionForm
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SearchListActionForm extends OPPTActionForm{

    private int agreementId = 0;
    
    
    
    /**
     * gets the agreementId * 
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
     * Reset the default values
     *  
     */
   /* public void reset(){
        agreementId = 0;
    }*/
    
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
        if(0 == getAgreementId()){
          errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF212, OPPTMessageCatalog.TYPE_PRESENTATION), null);
   }
        
	return errorReport;
	}
}
