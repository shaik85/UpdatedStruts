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
public class ESWCustomerCustomDTO extends OPPTCustomDTO {
	private int partnerType = -1;
	private String customerName = null;
	private String sAPCustomerNumber = null;
	private String legacyCustomerNumber = null;
	private String addressSequenceNumber = null;
	private String customerClass = null;
	private String countryCode = null; //EF0607044559
	private String customerNumber = null;
	private String siteID = null;
	
	private String soldToPartyNo = null; //DADO02
	
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
	public String getSAPCustomerNumber() {
		return sAPCustomerNumber;
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
	public String getLegacyCustomerNumberWithAS() {
		return legacyCustomerNumber+" "+addressSequenceNumber;  /* NOI18N */
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
	 * @param newSAPCustomerNumber 
	 */
	public void setSAPCustomerNumber(String newSAPCustomerNumber) {
		sAPCustomerNumber = newSAPCustomerNumber;
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
	 * Sets country code 
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
	 * @param newCountryCode 
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
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param acustomerName 
	 * @param asapCustomerNumber 
	 * @param alegacyCustomerNumber 
	 * @param aaddressSequenceNumber 
	 * @param apartnerType
	 */
	public void setData(String acustomerName, String asapCustomerNumber, String alegacyCustomerNumber, String aaddressSequenceNumber, int apartnerType){
		setCustomerName(acustomerName);
		setSAPCustomerNumber(asapCustomerNumber);
		setLegacyCustomerNumber(alegacyCustomerNumber);
		setAddressSequenceNumber(aaddressSequenceNumber);
		setPartnerType(apartnerType);
	}
	
	/**
	 * constructor
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
	
	 */
	
	public ESWCustomerCustomDTO(){
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
	 * @param acustomerName 
	 * @param asapCustomerNumber 
	 * @param alegacyCustomerNumber 
	 * @param aaddressSequenceNumber 
	 * @param apartnerType
	 */
	
	public ESWCustomerCustomDTO(String acustomerName, String asapCustomerNumber, String alegacyCustomerNumber, String aaddressSequenceNumber, int apartnerType){
		setData(acustomerName, asapCustomerNumber, alegacyCustomerNumber, aaddressSequenceNumber, apartnerType);
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
	
	/**
	 * Retrns partner type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getPartnerType() {
		return partnerType;
	}

	/**
	 * Sets partner type value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPartnerType 
	 */
	public void setPartnerType(int newPartnerType) {
		partnerType = newPartnerType;
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
	 * @return String
	 */
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("[ESWCustomerCustomDTO] -");  //$NON-NLS-1$
		buffer.append(" - [Partner type: "+partnerType+"]");  //$NON-NLS-1$  //$NON-NLS-2$
		buffer.append(" - [Customer name: "+customerName+"]");  /* NOI18N */  /* NOI18N */
		buffer.append(" - [SAP customer number: "+sAPCustomerNumber+"]");  /* NOI18N */  /* NOI18N */
		buffer.append(" - [Legacy customer number: "+legacyCustomerNumber+"]");  /* NOI18N */  /* NOI18N */
		buffer.append(" - [Address sequence number: "+addressSequenceNumber+"]");  /* NOI18N */  /* NOI18N */
		
		return buffer.toString();
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
	 * date Apr 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return string
	 */
	public String getCustomerClass() {
		return customerClass;
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
	 * date Apr 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setCustomerClass(String string) {
		customerClass = string;
	}

	/**
	 * @return Returns the customerNumber.
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}
	/**
	 * @param customerNumber The customerNumber to set.
	 */
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	/**
	 * @return Returns the siteID.
	 */
	public String getSiteID() {
		return siteID;
	}
	/**
	 * @param siteID The siteID to set.
	 */
	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}
	/**
	 * @return Returns the soldToPartyNo.
	 */
	public String getSoldToPartyNo() {
		return soldToPartyNo;
	}
	/**
	 * @param soldToPartyNo The soldToPartyNo to set.
	 */
	public void setSoldToPartyNo(String soldToPartyNo) {
		this.soldToPartyNo = soldToPartyNo;
	}
}
