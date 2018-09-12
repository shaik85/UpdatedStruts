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
 * Edit Modification Option ActionForm
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EditModificationOptionActionForm extends OPPTActionForm {

   private String modificationOption = null;
   
   
/**
 *gets the  modificationOption
 *
 * @return Returns the modificationOption.
 */
public String getModificationOption() {
    return modificationOption;
}
/**
 * sets the modificationOption
 * @param lmodificationOption The modificationOption to set.
 */
public void setModificationOption(String lmodificationOption) {
    modificationOption = lmodificationOption;
}
/**
 * Reset the default values
 */
/*
 public void reset(){
       modificationOption = null;
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

   if(null == getModificationOption()){
      errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF239, OPPTMessageCatalog.TYPE_PRESENTATION), null);
  
}
    
return errorReport;
}
}
