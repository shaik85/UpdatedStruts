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
 * BaseAgreement ChangeLog ActionForm
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAgreementChangeLogActionForm extends OPPTActionForm {

    private String salesOrganization=null;
    private String agreementNumber=null;
    private String enterpriseNumber=null;
    private String iNACNumber=null;
    private String customerNumber=null;
   
    /**
     *gets the  agreementNumber
     *
     * @return Returns the agreementNumber.
     */
    public String getAgreementNumber() {
        return agreementNumber;
    }
    /**
     * sets the agreementNumber
     * @param lagreementNumber The agreementNumber to set.
     */
    public void setAgreementNumber(String lagreementNumber) {
        agreementNumber = lagreementNumber;
    }
    /**
     *gets the  custmerNumber
     *
     * @return Returns the custmerNumber.
     */
    public String getCustomerNumber() {
        return customerNumber;
    }
    /**
     * sets the custmerNumber
     * @param lcustomerNumber The custmerNumber to set.
     */
    public void setCustomerNumber(String lcustomerNumber) {
        customerNumber = lcustomerNumber;
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
     * @param lenterpriseNumber The enterpriseNumber to set.
     */
    public void setEnterpriseNumber(String lenterpriseNumber) {
        enterpriseNumber = lenterpriseNumber;
    }
    /**
     *gets the  iNACNumber
     *
     * @return Returns the iNACNumber.
     */
    public String getINACNumber() {
        return iNACNumber;
    }
    /**
     * sets the iNACNumber
     * @param lnumber The iNACNumber to set.
     */
    public void setINACNumber(String lnumber) {
        iNACNumber = lnumber;
    }
    /**
     *gets the  salesOrg
     *
     * @return Returns the salesOrg.
     */
    public String getSalesOrganization() {
        return salesOrganization;
    }
    /**
     * sets the salesOrg
     *
     * @param lsalesOrganization 
     */
    public void setSalesOrganization(String lsalesOrganization) {
        salesOrganization = lsalesOrganization;
    }
    /**
     * Reset the default values
     *  
     */
     public void reset(){
        salesOrganization=null;
        agreementNumber=null;
        enterpriseNumber=null;
        iNACNumber=null;
        customerNumber=null;

    }
    /**
     *validate
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006  4:37:56 PM
     *
     *@return
     */
    public ErrorReport validate() {
		ErrorReport errorReport = new ErrorReport();
		if(isSelectEmpty(salesOrganization) ){
		    errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF01 , OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		if(isFieldEmpty(agreementNumber) ){
		    errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF205 , OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		if(isFieldEmpty(customerNumber) && isFieldEmpty(enterpriseNumber)){
		    errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF244 , OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		
		return errorReport;
	}
}
