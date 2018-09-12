/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

/**
 * Custom dto that holds customer information   
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 4, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class CustomerListCustomerCustomDTO extends OPPTCustomDTO {
	private String legacyCustomerNumber = null;
	private String customerNumber = null;
	private String customerName = null;
	private String addressSequenceNumber = null;
	private boolean inventorySelected = false;
	private boolean alreadyExists = false;
	private boolean iIsSTP = false;
	private String countryCode = null; //EF0607044559
	
	private String SAPCustomerNumber = null; //DAO02	
	
	/**
	 * Returns customer name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String 
	 */
	public String getCustomerName() {
		return customerName;
	}

    /**
     * return the iIsSTP 
     *
     * @return Returns the iIsSTP.
     */
    public boolean isIIsSTP() {
        return iIsSTP;
    }
    /**
     * sets the iIsSTP
     *
     * @param lIsSTP The iIsSTP to set.
     */
    public void setIIsSTP(boolean lIsSTP) {
        iIsSTP = lIsSTP;
    }
	/** 
	 * Retunrs customer number
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * Returns true if the inventory is already selected 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isInventorySelected() {
		return inventorySelected;
	}

	/**
	 * Returns legacy customer number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getLegacyCustomerNumber() {
		return legacyCustomerNumber;
	}
	
	/**
	 * Returns country code 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date June 16, 2004 
	 * Added for EF0607044559 by Sara 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Sets customer name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerName String 
	 */
	public void setCustomerName(String newCustomerName) {
		customerName = newCustomerName;
	}

	/**
	 * Sets customer number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerNumber String 
	 */
	public void setCustomerNumber(String newCustomerNumber) {
		customerNumber = newCustomerNumber;
	}

	/**
	 * Sets the inventory selected flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newInventorySelected boolean 
	 */
	public void setInventorySelected(boolean newInventorySelected) {
		inventorySelected = newInventorySelected;
	}

	/**
	 * Sets legacy customer number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLegacyCustomerNumber String 
	 */
	public void setLegacyCustomerNumber(String newLegacyCustomerNumber) {
		legacyCustomerNumber = newLegacyCustomerNumber;
	}
	
	/**
	 * Sets country code 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date June 16, 2004
	 * Added for EF0607044559 by Sara 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCountryCode String 
	 */
	public void setCountryCode(String newCountryCode) {
		countryCode = newCountryCode;
	}

	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param llegacyCustomerNumber String
	 * @param laddressSequenceNumber String
	 * @param lcustomerNumber String
	 * @param lcustomerName String
	 * @param linventorySelected boolean
	 */
	public void setData(String llegacyCustomerNumber, String laddressSequenceNumber, 
						String lcustomerNumber, String lcustomerName, boolean linventorySelected){
		setLegacyCustomerNumber(llegacyCustomerNumber);
		setAddressSequenceNumber(laddressSequenceNumber);
		setCustomerNumber(lcustomerNumber);
		setCustomerName(lcustomerName);
		setInventorySelected(linventorySelected);
	}
	
	/**
	 * Returns address sequence number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getAddressSequenceNumber() {
		return addressSequenceNumber;
	}

	/**
	 * Sets address sequence number of the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAddressSequenceNumber String 
	 */
	public void setAddressSequenceNumber(String newAddressSequenceNumber) {
		addressSequenceNumber = newAddressSequenceNumber;
	}
	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isAlreadyExists() {
		return alreadyExists;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setAlreadyExists(boolean b) {
		alreadyExists = b;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isIsSTP() {
		return iIsSTP;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setIsSTP(boolean b) {
		iIsSTP = b;
	}

	/**
	 * @return Returns the sAPCustomerNumber.
	 */
	public String getSAPCustomerNumber() {
		return SAPCustomerNumber;
	}
	/**
	 * @param customerNumber The sAPCustomerNumber to set.
	 */
	public void setSAPCustomerNumber(String customerNumber) {
		SAPCustomerNumber = customerNumber;
	}
}
