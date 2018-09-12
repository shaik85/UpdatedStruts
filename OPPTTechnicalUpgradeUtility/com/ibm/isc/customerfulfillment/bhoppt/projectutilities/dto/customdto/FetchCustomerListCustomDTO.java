/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.*;

/**
 * Custom dto that holds input and output for fetch customerlist action  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 3, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class FetchCustomerListCustomDTO extends OPPTCustomDTO {
	private String customerListNumber = null;
	private String customerListName = null;
	// Sateesh Anne  DAD O02
	private String siteID = null;
	private String siteName = null;
	private TreeMap siteIDLists = null; 
	
	private String zipCode = null;
	private String city = null;
	private String comments = null;
	private TreeMap customerLists = null;
	
	private String divisionCode = null;
	private String distributionChannel = null;
	private String SalesGroup = null;
	private String channelRole = null;
	private String submitterRole = null;
	private String selectedSalesOrg = null;
	
	private ProposalCustomDTO proposal;
	
	/**
	 * Returns city value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Returns comments value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Returns customer list name input value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCustomerListName() {
		return customerListName;
	}

	/**
	 * Returns customer list number input value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCustomerListNumber() {
		return customerListNumber;
	}

	/**
	 * Retuns the collection of customer lists for the given input 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getCustomerLists() {
		return customerLists;
	}

	/**
	 * Retuns the distribution channle value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
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
		return SalesGroup;
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
		SalesGroup = newSalesGroup;
	}

	/**
	 * @param channelRole the channelRole to set
	 */
	public void setChannelRole(String newChannelRole) {
		this.channelRole = newChannelRole;
	}

	/**
	 * @param submitterRole the submitterRole to set
	 */
	public void setSubmitterRole(String newSubmitterRole) {
		this.submitterRole = newSubmitterRole;
	}

	/**
	 * Returns the division code value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDivisionCode() {
		return divisionCode;
	}

	/**
	 * Returns the zip code input value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Set the city input value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCity 
	 */
	public void setCity(String newCity) {
		city = newCity;
	}

	/**
	 * Sets the comments value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newComments 
	 */
	public void setComments(String newComments) {
		comments = newComments;
	}

	/**
	 * Sets customer list name input value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerListName 
	 */
	public void setCustomerListName(String newCustomerListName) {
		customerListName = newCustomerListName;
	}

	/**
	 * Sets customer list number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerListNumber 
	 */
	public void setCustomerListNumber(String newCustomerListNumber) {
		customerListNumber = newCustomerListNumber;
	}

	/**
	 * Sets the collection of customer lists for the given input 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerLists 
	 */
	public void setCustomerLists(TreeMap newCustomerLists) {
		customerLists = newCustomerLists;
	}

	/**
	 * Sets distribution channel value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDistributionChannel 
	 */
	public void setDistributionChannel(String newDistributionChannel) {
		distributionChannel = newDistributionChannel;
	}

	/**
	 * Sets division code value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDivisionCode 
	 */
	public void setDivisionCode(String newDivisionCode) {
		divisionCode = newDivisionCode;
	}

	/**
	 * Sets zip code input value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newZipCode 
	 */
	public void setZipCode(String newZipCode) {
		zipCode = newZipCode;
	}
	
	/**
	 * @param siteID The siteID to set.
	 */
	public void setSiteID(String newSiteID) {
		siteID = newSiteID;
	}
	/**
	 * @param siteName The siteName to set.
	 */
	public void setSiteName(String newSiteName) {
		siteName = newSiteName;
	}
	/**
	 * sets complete input data   
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
	 * @param asessionId 
	 * @param agroupName 
	 * @param auserId 
	 * @param arole 
	 * @param aemailAddress 
	 * @param asalesOrg 
	 * @param acustomerListNumber 
	 * @param acustomerListName 
	 * @param azipCode 
	 * @param acity 
	 * @param acomments 
	 * @param adivisionCode 
	 * @param adistributionChannel 
	 */
	public void setInputData(String asessionId, String agroupName, String auserId, int arole, 
							String aemailAddress, String asalesOrg, String acustomerListNumber, 
							String acustomerListName,String asiteID,String asiteName, String azipCode, String acity, 
							String acomments, String adivisionCode, String adistributionChannel, String aSalesGroup, String aChannelRole, String aSubmitterRole){
		super.setData(asessionId, agroupName, auserId, arole, aemailAddress, asalesOrg);
		setCustomerListNumber(acustomerListNumber);
		setCustomerListName(acustomerListName);
		//DAD O02
		setSiteID(asiteID);
		setSiteName(asiteName);
		
		setZipCode(azipCode);
		setCity(acity);
		setComments(acomments);
		setDivisionCode(adivisionCode);
		setDistributionChannel(adistributionChannel);
		setSalesGroup(aSalesGroup);
		setChannelRole(aChannelRole);
		setSubmitterRole(aSubmitterRole);
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
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public ProposalCustomDTO getProposal() {
		return proposal;
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
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTO 
	 */
	public void setProposal(ProposalCustomDTO customDTO) {
		proposal = customDTO;
	}

	/**
	 * @return Returns the siteID.
	 */
	public String getSiteID() {
		return siteID;
	}
	
	/**
	 * @return Returns the siteName.
	 */
	public String getSiteName() {
		return siteName;
	}
	
	/**
	 * @return Returns the siteIDLists.
	 */
	public TreeMap getSiteIDLists() {
		return siteIDLists;
	}
	/**
	 * @param siteIDLists The siteIDLists to set.
	 */
	public void setSiteIDLists(TreeMap siteIDLists) {
		this.siteIDLists = siteIDLists;
	}
}
