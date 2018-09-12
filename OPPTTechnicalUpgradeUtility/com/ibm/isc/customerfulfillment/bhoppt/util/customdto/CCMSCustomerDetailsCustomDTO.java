/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CCMSCustomerDetailsCustomDTO extends OPPTCustomDTO {
   
    private String sapCustomerNumber = null;
    private String enterPriseNumber = null;
    private String iNAC = null;
    private String uRN = null;
    private String country = null;
    private String cMRNumber = null;
    private String city = null;
    private String street = null;
    private String customerAccountGroup = null;
    private String businessName = null;
    private String legalName = null;
    
    
    
    
    
    /**
     *gets the  enterPriseNumber
     *
     * @return Returns the enterPriseNumber.
     */
    public String getEnterPriseNumber() {
        return enterPriseNumber;
    }
    /**
     * sets the enterPriseNumber
     * @param enterPriseNumber The enterPriseNumber to set.
     */
    public void setEnterPriseNumber(String enterPriseNumber) {
        this.enterPriseNumber = enterPriseNumber;
    }
    /**
     *gets the  iNAC
     *
     * @return Returns the iNAC.
     */
    public String getINAC() {
        return iNAC;
    }
    /**
     * sets the iNAC
     * @param inac The iNAC to set.
     */
    public void setINAC(String inac) {
        iNAC = inac;
    }
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
     *gets the  street
     *
     * @return Returns the street.
     */
    public String getStreet() {
        return street;
    }
    /**
     * sets the street
     * @param street The street to set.
     */
    public void setStreet(String street) {
        this.street = street;
    }
    /**
     *gets the  uRN
     *
     * @return Returns the uRN.
     */
    public String getURN() {
        return uRN;
    }
    /**
     * sets the uRN
     * @param urn The uRN to set.
     */
    public void setURN(String urn) {
        uRN = urn;
    }
    
    /**
     *gets the  city
     *
     * @return Returns the city.
     */
    public String getCity() {
        return city;
    }
    /**
     * sets the city
     * @param city The city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }
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
     *gets the  country
     *
     * @return Returns the country.
     */
    public String getCountry() {
        return country;
    }
    /**
     * sets the country
     * @param country The country to set.
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     *gets the  customerAccountGroup
     *
     * @return Returns the customerAccountGroup.
     */
    public String getCustomerAccountGroup() {
        return customerAccountGroup;
    }
    /**
     * sets the customerAccountGroup
     * @param customerAccountGroup The customerAccountGroup to set.
     */
    public void setCustomerAccountGroup(String customerAccountGroup) {
        this.customerAccountGroup = customerAccountGroup;
    }
    
	/**
	 * @return Returns the businessName.
	 */
	public String getBusinessName() {
		return businessName;
	}
	/**
	 * @param businessName The businessName to set.
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	/**
	 * @return Returns the legalName.
	 */
	public String getLegalName() {
		return legalName;
	}
	/**
	 * @param legalName The legalName to set.
	 */
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
}
