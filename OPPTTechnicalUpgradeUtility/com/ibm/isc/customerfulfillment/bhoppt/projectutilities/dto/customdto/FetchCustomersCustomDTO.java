/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.TreeMap;

/**
 * Custom dto that holds data required for customer selection, in proposal creation and change proposal 
 * sequence.  
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
public class FetchCustomersCustomDTO extends OPPTCustomDTO {
	private ProposalCustomDTO proposalDTO = null;

	private TreeMap selectedCustomerLists = null;
	//DADO02
	private TreeMap selectedCustomers = null;
	private TreeMap alternatePartners = null; 
	
	private String divisionCode = null;
	private String distributionChannel = null;
	private String salesGroup = null;
	private String channelRole = null;
	private String submitterRole = null;
	private String selectedSalesOrg = null;
	
	
	/**
	 * Return proposal dto 
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
	 * @return ProposalCustomDTO
	 */
	public ProposalCustomDTO getProposalDTO() {
		return proposalDTO;
	}

	/**
	 * Returns collection of customer lists 
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
	 * @return TreeMap
	 */
	public TreeMap getSelectedCustomerLists() {
		return selectedCustomerLists;
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
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTO 
	 */
	public void setProposalDTO(ProposalCustomDTO customDTO) {
		proposalDTO = customDTO;
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
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedCustomerLists 
	 */
	public void setSelectedCustomerLists(TreeMap newSelectedCustomerLists) {
		selectedCustomerLists = newSelectedCustomerLists;
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
	 * date Dec 4, 2003 
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
	 * date Dec 4, 2003 
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
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setDistributionChannel(String string) {
		distributionChannel = string;
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
	public void setSalesGroup(String string) {
		salesGroup = string;
	}

	/**
	 * @param channelRole the channelRole to set
	 */
	public void setChannelRole(String string) {
		channelRole = string;
	}

	/**
	 * @param submitterRole the submitterRole to set
	 */
	public void setSubmitterRole(String string) {
		submitterRole = string;
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
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setDivisionCode(String string) {
		divisionCode = string;
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
	 * @param newSelectedSalesOrg  
	 */
	public void setSelectedSalesOrg(String newSelectedSalesOrg) {
		selectedSalesOrg = newSelectedSalesOrg;
	}

	/**
	 * Returns alternate partners collection 
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
	 * @return TreeMap 
	 */
	public TreeMap getAlternatePartners() {
		return alternatePartners;
	}

	/**
	 * Sets alternate partners collection 
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
	 * @param newAlternatePartners 
	 */
	public void setAlternatePartners(TreeMap newAlternatePartners) {
		alternatePartners = newAlternatePartners;
	}
	
	/**
	 * Adds new alternate partner to the collection of existing alternate partners  
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
	 * @param alternateCustomer 
	 */
	public void addAlternatePartner(CustomerListCustomerCustomDTO alternateCustomer){
		if(null != alternateCustomer){
			if(null == alternatePartners){
				alternatePartners = new TreeMap();
			}
			alternatePartners.put(alternateCustomer.getCustomerNumber(), alternateCustomer);
		}
	}
	/**
	 * @return Returns the selectedCustomers.
	 */
	public TreeMap getSelectedCustomers() {
		return selectedCustomers;
	}
	/**
	 * @param selectedCustomers The selectedCustomers to set.
	 */
	public void setSelectedCustomers(TreeMap selectedCustomers) {
		this.selectedCustomers = selectedCustomers;
	}
}