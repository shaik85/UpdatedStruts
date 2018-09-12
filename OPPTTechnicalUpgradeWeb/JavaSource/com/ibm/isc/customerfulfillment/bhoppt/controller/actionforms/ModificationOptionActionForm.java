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
public class ModificationOptionActionForm extends OPPTActionForm {
    
    private String typeCode = null;

    private String modificationOption = null;
    
    private String modificationDescription = null;
    
    


    /**
     * return the modificationDescription 
     *
     * @return Returns the modificationDescription.
     */
    public String getModificationDescription() {
        return modificationDescription;
    }
    /**
     * sets the modificationDescription
     *
     * @param lmodificationDescription The modificationDescription to set.
     */
    public void setModificationDescription(String lmodificationDescription) {
        modificationDescription = lmodificationDescription;
    }
    /**
     * return the modificationOption 
     *
     * @return Returns the modificationOption.
     */
    public String getModificationOption() {
        return modificationOption;
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
     * Reset the default values
     *  
     */
   public void reset(){
        typeCode = null;
        modificationOption = null;
        modificationDescription = null;
    }
    /**
     * 
     *validate
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006  4:43:18 PM
     *
     *@return
     */
    public ErrorReport validate() {
    	
           ErrorReport errorReport = new ErrorReport();
            if(isFieldEmpty(getModificationOption())){
              errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF240, OPPTMessageCatalog.TYPE_PRESENTATION), null);
       }
            if (isFieldEmpty(getModificationDescription())){
                errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF241, OPPTMessageCatalog.TYPE_PRESENTATION), null);   
            }
            
    	return errorReport;
    	}
    
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:43:25 PM
     * @param lModificationOption modificationOption.
     */
    public void setModificationOption(String lModificationOption) {
        modificationOption = lModificationOption;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   4:43:25 PM
     * @param lTypeCode typeCode.
     */
    public void setTypeCode(String lTypeCode) {
        typeCode = lTypeCode;
    }
}


