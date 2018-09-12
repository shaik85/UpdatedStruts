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
 * This is the Modification type code actionform
 * 
 * @author Ravi Yandapalli
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class ModificationTypeCodeActionForm extends OPPTActionForm{
    
    private String modificationTypeCode = null;
    private String modificationStatus =   null;
    
	
    
    /**
     *this is the getter method for modificationStatus 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:44:08 PM
     *
     * @return String.
     */
    public String getModificationStatus() {
        return modificationStatus;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:44:08 PM
     * @param lModificationStatus modificationStatus.
     */
    public void setModificationStatus(String lModificationStatus) {
        modificationStatus = lModificationStatus;
    }
    /**
     * return the typeCode 
     *
     * @return Returns the typeCode.
     */
    public String getModificationTypeCode() {
        return modificationTypeCode;
    }
    /**
     * sets the typeCode
     *
     * @param lTypeCode The typeCode to set.
     */
    public void setModificationTypeCode(String lTypeCode) {
    	modificationTypeCode = lTypeCode;
    }
    
    /**
     * Reset the default values
     *  
     */
    public void reset(){
        modificationTypeCode = null;
        modificationStatus =   null;
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
    
       if(null == getModificationTypeCode()){
          errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF236, OPPTMessageCatalog.TYPE_PRESENTATION), null);
   }
        
	return errorReport;
	}
}
