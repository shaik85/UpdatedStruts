/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

/**
 * Holds customer information 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 5, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class CustomerInfoCustomDTO extends OPPTCustomDTO {
	private String customerName = null;
	private String customerNumber = null;
	private String legacyCustomerNumber = null;
	private String addressSequenceNumber = null;
	
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
	 * @param newCustomerName  
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
	 * @param newCustomerNumber 
	 */
	public void setCustomerNumber(String newCustomerNumber) {
		customerNumber = newCustomerNumber;
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
	 * @param newLegacyCustomerNumber 
	 */
	public void setLegacyCustomerNumber(String newLegacyCustomerNumber) {
		legacyCustomerNumber = newLegacyCustomerNumber;
	}
	
	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param icustomerName 
	 * @param icustomerNumber 
	 * @param ilegacyCustomerNumber 
	 * @param iaddressSequenceNumber 
	 */
	public void setData(String icustomerName, String icustomerNumber, String ilegacyCustomerNumber, String iaddressSequenceNumber){
		setCustomerName(icustomerName);
		setCustomerNumber(icustomerNumber);
		setLegacyCustomerNumber(ilegacyCustomerNumber);
		setAddressSequenceNumber(iaddressSequenceNumber);
	}
	/**
	 * constructor
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
	 *
	 */
	public CustomerInfoCustomDTO(){
	}
	
	/**
	 * constructor set the data 
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
	 * @param icustomerName
	 * @param icustomerNumber
	 * @param ilegacyCustomerNumber
	 * @param iaddressSequenceNumber
	 * 
	 * 
	 */
	
	public CustomerInfoCustomDTO(String icustomerName, String icustomerNumber, String ilegacyCustomerNumber, String iaddressSequenceNumber){
		setData(icustomerName, icustomerNumber, ilegacyCustomerNumber, iaddressSequenceNumber);
	}
	
	/**
	 * Returns address sequence number of the customer 
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
	 * @param newAddressSequenceNumber 
	 */
	public void setAddressSequenceNumber(String newAddressSequenceNumber) {
		addressSequenceNumber = newAddressSequenceNumber;
	}
}
