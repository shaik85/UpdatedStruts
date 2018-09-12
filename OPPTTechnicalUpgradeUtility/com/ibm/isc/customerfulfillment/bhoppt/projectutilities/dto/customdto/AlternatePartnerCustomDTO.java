/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;


/**
 * Custom dto that holds data required for fetching alternate partner for a partner type.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 10, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class AlternatePartnerCustomDTO extends OPPTCustomDTO {
	private boolean financingFlag = false;
	private String legacyCustomerNumber = null;
	private String sequenceNumber = null;
	private String sAPCustomerNumber = null;
	private String customerName = null;
	private String countryCode = null;
	private int partnerType = -1;
	
	private ESWCustomerCustomDTO partnerInfo= null;

	private String distributionChannel = null;
	private String salesGroup = null;
	private String channelRole = null;
	private String submitterRole = null;
	private String division = null;
	private String selectedSalesOrg = null;
	
	private boolean btpEditable = false;
	
	/**
	 * Returns distribution channel value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDistributionChannel() {
		return distributionChannel;
	}

	/**
	 * @return the salesGroup
	 */
	public String getSalesGroup() {
		return salesGroup;
	}

	/**
	 * @return the channelRole
	 */
	public String getChannelRole() {
		return channelRole;
	}

	/**
	 * @return the submitterRole
	 */
	public String getSubmitterRole() {
		return submitterRole;
	}

	/**
	 * @param salesGroup the salesGroup to set
	 */
	public void setSalesGroup(String newSalesGroup) {
		salesGroup = newSalesGroup;
	}

	/**
	 * @param channelRole the channelRole to set
	 */
	public void setChannelRole(String newChannelRole) {
		channelRole = newChannelRole;
	}

	/**
	 * @param submitterRole the submitterRole to set
	 */
	public void setSubmitterRole(String newSubmitterRole) {
		submitterRole = newSubmitterRole;
	}

	/**
	 * Returns division value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDivision() {
		return division;
	}

	/**
	 * Returns partner information. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 10, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getPartnerInfo() {
		return partnerInfo;
	}

	/**
	 * Returns legacy customer number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
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
	 * Returns partner type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
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
	 * Returns sequence number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * Returns financing flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isFinancingFlag() {
		return financingFlag;
	}

	/**
	 * Sets distribution channel value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDistributionChannel String 
	 */
	public void setDistributionChannel(String newDistributionChannel) {
		distributionChannel = newDistributionChannel;
	}

	/**
	 * Sets division value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDivision String 
	 */
	public void setDivision(String newDivision) {
		division = newDivision;
	}

	/**
	 * Sets financing flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newFinancingFlag boolean 
	 */
	public void setFinancingFlag(boolean newFinancingFlag) {
		financingFlag = newFinancingFlag;
	}

	/**
	 * Returns partner information  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 10, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPartnerInfo ESWCustomerCustomDTO 
	 */
	public void setPartnerInfo(ESWCustomerCustomDTO newPartnerInfo) {
		partnerInfo = newPartnerInfo;
	}

	/**
	 * Sets legacy customer number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
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
	 * Sets partner type value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPartnerType int 
	 */
	public void setPartnerType(int newPartnerType) {
		partnerType = newPartnerType;
	}

	/**
	 * Sets sequence number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSequenceNumber String 
	 */
	public void setSequenceNumber(String newSequenceNumber) {
		sequenceNumber = newSequenceNumber;
	}
	
	/**
	 * Returns selected sales org value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedSalesOrg() {
		return selectedSalesOrg;
	}

	/**
	 * Sets selected sales org value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedSalesOrg String 
	 */
	public void setSelectedSalesOrg(String newSelectedSalesOrg) {
		selectedSalesOrg = newSelectedSalesOrg;
	}
	
	/**
	 * Returns the source customer name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 3, 2004 
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
	 * Returns source sap customer number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 3, 2004 
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
	 * Sets source customer name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 3, 2004 
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
	 * Sets source sap customer numbwe 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSAPCustomerNumber String 
	 */
	public void setSAPCustomerNumber(String newSAPCustomerNumber) {
		sAPCustomerNumber = newSAPCustomerNumber;
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
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isBtpEditable() {
		return btpEditable;
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
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setBtpEditable(boolean b) {
		btpEditable = b;
	}

	/**
	 * Returns country code value 
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
		return countryCode;
	}

	/**
	 * Sets country code value 
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
		countryCode = newCountryCode;
	}
}