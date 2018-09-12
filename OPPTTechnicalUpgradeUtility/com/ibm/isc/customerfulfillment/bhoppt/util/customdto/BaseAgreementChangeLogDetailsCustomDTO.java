/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import java.util.ArrayList;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAgreementChangeLogDetailsCustomDTO extends OPPTCustomDTO {
    
    private String salesOrg=null;
    private String agreementNumber=null;
    private String enterpriseNumber=null;
    private String iNACNumber=null;
    private String customerNumber=null;
    private ArrayList changeDetailslist = null;
    private String isModified=null;
    
 
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
     * @param number The iNACNumber to set.
     */
    public void setINACNumber(String number) {
        iNACNumber = number;
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
     * @param salesOrg The salesOrg to set.
     */
    public void setSalesOrg(String lsalesOrg) {
        salesOrg = lsalesOrg;
    }
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
     *gets the  changeDetailslist
     *
     * @return Returns the changeDetailslist.
     */
    public ArrayList getChangeDetailslist() {
        return changeDetailslist;
    }
    /**
     * sets the changeDetailslist
     * @param changeDetailslist The changeDetailslist to set.
     */
    public void setChangeDetailslist(ArrayList changeDetailslist) {
        this.changeDetailslist = changeDetailslist;
    }
    /**
     *gets the  customerNumber
     *
     * @return Returns the customerNumber.
     */
    public String getCustomerNumber() {
        return customerNumber;
    }
    /**
     * sets the customerNumber
     * @param lcustomerNumber The customerNumber to set.
     */
    public void setCustomerNumber(String lcustomerNumber) {
        customerNumber = lcustomerNumber;
    }
    
    /**
     *gets the  isModified
     *
     * @return Returns the isModified.
     */
    public String getIsModified() {
        return isModified;
    }
    /**
     * sets the isModified
     * @param isModified The isModified to set.
     */
    public void setIsModified(String isModified) {
        this.isModified = isModified;
    }
}
