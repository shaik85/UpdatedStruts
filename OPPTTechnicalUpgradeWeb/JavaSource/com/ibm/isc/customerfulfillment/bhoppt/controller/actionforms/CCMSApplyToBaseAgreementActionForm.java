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
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CCMSApplyToBaseAgreementActionForm extends OPPTActionForm {
    
    private String sapCustomerNumber = null;
    
    

    /**
     *gets the  sapCustomerNumber
     *
     * @return Returns the sapCustomerNumber.
     */
    public String getSapCustomerNumber() {
        return sapCustomerNumber;
    }
    /**
     * sets the sapCustomerNumber
     * @param sapCustomerNumber The sapCustomerNumber to set.
     */
    public void setSapCustomerNumber(String sapCustomerNumber) {
        this.sapCustomerNumber = sapCustomerNumber;
    }
    
    /**
     * Reset the default values
     *  
     */
       public void reset(){
           sapCustomerNumber = null;
    }
    /**
     * validate the Type Code 
     *  
     * it's at least one value not null
     * 
     * @return error report     * 
     * 
     * 
     */
    
    public ErrorReport validate() {
       ErrorReport errorReport = new ErrorReport();
    if( null == getSapCustomerNumber() ) {
          errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF261, OPPTMessageCatalog.TYPE_PRESENTATION), null);
    }else{
        String countryCode = getSapCustomerNumber().substring((getSapCustomerNumber().lastIndexOf('#')+1)); 
        if(countryCode!=null && !countryCode.equals("897")&& !countryCode.equals("649")){
            errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF262, OPPTMessageCatalog.TYPE_PRESENTATION), null);
        }
    }
  return errorReport;
	}
}
