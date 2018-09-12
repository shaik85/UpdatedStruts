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
public class CCMSCustomerSelectionActionForm extends OPPTActionForm {
    
    private String cmrNumber= null;
    private String enterpriseNumber= null;
    private String countryCode= null;
    
    

  
    /**
     *gets the  cmrNumber
     *
     * @return Returns the cmrNumber.
     */
    public String getCmrNumber() {
        return cmrNumber;
    }
    /**
     * sets the cmrNumber
     * @param cmrNumber The cmrNumber to set.
     */
    public void setCmrNumber(String cmrNumber) {
        this.cmrNumber = cmrNumber;
    }
    /**
     *gets the  countryCode
     *
     * @return Returns the countryCode.
     */
    public String getCountryCode() {
        return countryCode;
    }
    /**
     * sets the countryCode
     * @param countryCode The countryCode to set.
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    /**
     *gets the  enterpriseNumber
     *
     * @return Returns the enterpriseNumber.
     */
    public String getEnterpriseNumber() {
        return enterpriseNumber;
    }
    /**
     * sets the enterpriseNumber
     * @param enterpriseNumber The enterpriseNumber to set.
     */
    public void setEnterpriseNumber(String enterpriseNumber) {
        this.enterpriseNumber = enterpriseNumber;
    }
    /**
     * Reset the default values
     *  
     */
       public void reset(){
       cmrNumber = null;
       enterpriseNumber = null;
       countryCode = null;
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
       if(isFieldEmpty(getCmrNumber())&& isFieldEmpty(getEnterpriseNumber())){
            errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF260, OPPTMessageCatalog.TYPE_PRESENTATION), null);
        }else{
	        if(!isFieldEmpty(getCmrNumber())&& !isFieldEmpty(getEnterpriseNumber())){
	            errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF260, OPPTMessageCatalog.TYPE_PRESENTATION), null);
	        }else{
	            if(!isFieldEmpty(getCmrNumber()) && isSelectEmpty(getCountryCode())) {
	                errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF259, OPPTMessageCatalog.TYPE_PRESENTATION), null);
	              } 
	        }
        }
  return errorReport;
	}
}
