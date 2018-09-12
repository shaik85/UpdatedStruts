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
public class CCMSCustomerSelectionCustomDTO extends OPPTCustomDTO {
   
    private String cMRNumber= null;
    private String enterpriseNumber= null;
    private String countryCode= null;
    private ArrayList customerList = null;
    
    
    /**
     *gets the  cMRNumber
     *
     * @return Returns the cMRNumber.
     */
    public String getCMRNumber() {
        return cMRNumber;
    }
    /**
     * sets the cMRNumber
     * @param number The cMRNumber to set.
     */
    public void setCMRNumber(String number) {
        cMRNumber = number;
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
     *gets the  customerList
     *
     * @return Returns the customerList.
     */
    public ArrayList getCustomerList() {
        return customerList;
    }
    /**
     * sets the customerList
     * @param customerList The customerList to set.
     */
    public void setCustomerList(ArrayList customerList) {
        this.customerList = customerList;
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
}
