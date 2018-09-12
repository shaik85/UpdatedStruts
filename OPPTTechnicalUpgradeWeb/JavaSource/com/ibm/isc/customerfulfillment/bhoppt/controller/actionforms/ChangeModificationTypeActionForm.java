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
 * This is the Modification option Action Form
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ChangeModificationTypeActionForm extends OPPTActionForm {

    private String typeCode = null;
    private String description = null;
    private String salesOrg = null;
    
    
    /**
     * return the description 
     *
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }
    /**
     * sets the description
     *
     * @param ldescription The description to set.
     */
    public void setDescription(String ldescription) {
        description = ldescription;
    }
    /**
     * return the typeCode 
     *
     * @return Returns the typeCode.
     */
    public String getTypeCode() {
        return typeCode;
    }
    /**
     * sets the typeCode
     *
     * @param ltypeCode The typeCode to set.
     */
    public void setTypeCode(String ltypeCode) {
        typeCode = ltypeCode;
    }
    
    
    
    /**
     *gets the  salesOrg
     *
     * @return Returns the salesOrg.
     */
    public String getSalesOrg() {
        return salesOrg;
    }
    /**
     * sets the salesOrg
     * @param lsalesOrg The salesOrg to set.
     */
    public void setSalesOrg(String lsalesOrg) {
       salesOrg = lsalesOrg;
    }
    /**
     * Reset the default values
     *  
     */
/*   public void reset(){
        typeCode = null;
        description = null;
        salesOrg = null;
    }*/
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
        if(isFieldEmpty(getTypeCode())) {
          errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF237, OPPTMessageCatalog.TYPE_PRESENTATION), null);
   }
        if(isFieldEmpty(getDescription())){
            errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF238, OPPTMessageCatalog.TYPE_PRESENTATION), null);
        }
        
        
	return errorReport;
	}
}
