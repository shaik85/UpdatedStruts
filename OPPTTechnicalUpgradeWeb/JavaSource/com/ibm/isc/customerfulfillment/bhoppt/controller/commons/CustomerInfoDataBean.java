/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ESWCustomerCustomDTO;

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
public class CustomerInfoDataBean extends OPPTDataBean {
	private String iCustomerName = null;
	private String iCustomerNumber = null;
	private String iLegacyCustomerNumber = null;
	private String iAddressSequenceNumber = null;
	private String iCountryCode = null;
	private String isiteID = null;

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
		return iCustomerName;
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
		return iCustomerNumber;
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
		return iLegacyCustomerNumber;
	}

	/**
	 * Returns legacy customer embeded with address sequence number  
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
	public String getLegacyCustomerNumberWithAS() {
		StringBuffer buffer = new StringBuffer();
		if(null != iLegacyCustomerNumber){
			buffer.append(iLegacyCustomerNumber+" ");  //$NON-NLS-1$
		}
		/*DADO02 if(null != iAddressSequenceNumber){
			buffer.append(iAddressSequenceNumber);
		}*/
		return buffer.toString();
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
		iCustomerName = newCustomerName;
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
		iCustomerNumber = newCustomerNumber;
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
		iLegacyCustomerNumber = newLegacyCustomerNumber;
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
	 * @param customerName String
	 * @param customerNumber String
	 * @param legacyCustomerNumber String
	 */
	public void setData(String customerName, String customerNumber, String legacyCustomerNumber){
		setCustomerName(customerName);
		setCustomerNumber(customerNumber);
		setLegacyCustomerNumber(legacyCustomerNumber);
	}
	
	/**
     * setData
     * 
     * @param customerInfo
     * @author thirumalai
     */
    public void setData(ESWCustomerCustomDTO customerInfo){
		if(null != customerInfo){
			setCustomerName(customerInfo.getCustomerName());
			setCustomerNumber(customerInfo.getSAPCustomerNumber());
			/*DADO02 setLegacyCustomerNumber(customerInfo.getLegacyCustomerNumber());
			setAddressSequenceNumber(customerInfo.getAddressSequenceNumber());*/
			
			setLegacyCustomerNumber(customerInfo.getSAPCustomerNumber()); //DADO02
			
			
			setCountryCode(customerInfo.getCountryCode());
			setSiteID(customerInfo.getSiteID());
		}
	}
	
	/**
     * CustomerInfoDataBean
     * 
     * @author thirumalai
     */
    public CustomerInfoDataBean(){
	}
	/**
     * CustomerInfoDataBean
     * 
     * @param customerInfo
     * @author thirumalai
     */
    public CustomerInfoDataBean(ESWCustomerCustomDTO customerInfo){
		setData(customerInfo);
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
		return iAddressSequenceNumber;
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
	 * @param newAddressSequenceNumber string 
	 */
	public void setAddressSequenceNumber(String newAddressSequenceNumber) {
		iAddressSequenceNumber = newAddressSequenceNumber;
	}
	
	/**
	 * Returns country code associated with the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCountryCode() {
		return iCountryCode;
	}

	/**
	 * Sets the country code value to the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCountryCode String
	 */
	public void setCountryCode(String newCountryCode) {
		iCountryCode = newCountryCode;
	}
	/**
	 * @return Returns the siteID.
	 */
	public String getSiteID() {
		return isiteID;
	}
	/**
	 * @param siteID The siteID to set.
	 */
	public void setSiteID(String siteID) {
		isiteID = siteID;
	}
}