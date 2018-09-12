/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.List;
import java.util.TreeMap;

/**
 * Custom dto that holds info about partner selection
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
public class FetchPartnerInformationCustomDTO extends OPPTCustomDTO {
	private ProposalCustomDTO proposalDTO = null;
	private TreeMap soldToParty = null;
	private TreeMap billToParty = null;
	private TreeMap payer = null;
	private TreeMap shipToParty = null;
	
	private ESWCustomerCustomDTO selectedSoldToParty = null;
	private ESWCustomerCustomDTO selectedBillToParty = null;
	private ESWCustomerCustomDTO selectedPayer = null;
	private ESWCustomerCustomDTO selectedShipToParty = null;
	private ESWCustomerCustomDTO selectedNineDPartner = null;
	
	
	private String comments = null;

	private String divisionCode = null;
	private String distributionChannel = null;
	private String salesGroup = null;
	private String channelRole = null;
	private String submitterRole = null;
	private String selectedSalesOrg = null;


//	private TreeMap customerLists = null;
	private ESWCustomerCustomDTO customer = null;
	private String customerName= null;
	
	private boolean varianceProposal;
	private boolean iGFFlag; 
	
	//DADO02&DADO09 added to display customers in partnerselection page
	private List selectedCustomers = null;
	
	
	/**
	 * Returns bill to party customers collection 
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
	public TreeMap getBillToParty() {
		return billToParty;
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
	 * Returns customer lists collection value 
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
//	public TreeMap getCustomerLists() {
//		return customerLists;
//	}

	/**
	 * Returns distribution channel value 
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
	 * Returns payer collection 
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
	public TreeMap getPayer() {
		return payer;
	}

	/**
	 * Returns proposal info custom dot 
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
	 * @return ProposalCustomDTO
	 */
	public ProposalCustomDTO getProposalDTO() {
		return proposalDTO;
	}

	/**
	 * Returns ship to party collection value 
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
	public TreeMap getShipToParty() {
		return shipToParty;
	}

	/**
	 * Returns sold to party collection value 
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
	public TreeMap getSoldToParty() {
		return soldToParty;
	}

	/**
	 * Sets bill to party collection 
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
	 * @param newBillToParty 
	 */
	public void setBillToParty(TreeMap newBillToParty) {
		billToParty = newBillToParty;
	}

	/**
	 * Sets comments value 
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
	 * Sets customer lists collection 
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
//	public void setCustomerLists(TreeMap newCustomerLists) {
//		customerLists = newCustomerLists;
//	}

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
	 * Sets payer collection  
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
	 * @param newPayer 
	 */
	public void setPayer(TreeMap newPayer) {
		payer = newPayer;
	}

	/**
	 * Sets proposal information 
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
	 * @param newProposalDTO 
	 */
	public void setProposalDTO(ProposalCustomDTO newProposalDTO) {
		proposalDTO = newProposalDTO;
	}

	/**
	 * Sets ship to party collection 
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
	 * @param newShipToParty 
	 */
	public void setShipToParty(TreeMap newShipToParty) {
		shipToParty = newShipToParty;
	}

	/**
	 * Sets sold to party collection 
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
	 * @param newSoldToParty 
	 */
	public void setSoldToParty(TreeMap newSoldToParty) {
		soldToParty = newSoldToParty;
	}

	/**
	 * Adds sold to party to collection of existing sold to parties  
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
	 * @param asoldToParty 
	 */
	public void addSoldToParty(ESWCustomerCustomDTO asoldToParty){
		if(null != asoldToParty){
			if(null == soldToParty){
				soldToParty = new TreeMap(); 
			}
			soldToParty.put(asoldToParty.getSAPCustomerNumber(), asoldToParty);
		}
	}

	/**
	 * Adds new bill to party to collection of bill to parties available  
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
	 * @param abillToParty
	 */
	public void addBillToParty(ESWCustomerCustomDTO abillToParty){
		if(null != abillToParty){
			if(null == billToParty){
				billToParty = new TreeMap(); 
			}
			billToParty.put(abillToParty.getSAPCustomerNumber(), abillToParty);
		}
	}

	/**
	 * Adds bew payer to the collection of payers available  
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
	 * @param apayer
	 */
	public void addPayer(ESWCustomerCustomDTO apayer){
		if(null != apayer){
			if(null == payer){
				payer = new TreeMap(); 
			}
			payer.put(apayer.getSAPCustomerNumber(), apayer);
		}
	}

	/**
	 * Adds new ship to party to the collection of ship to parties available  
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
	 * @param ashipToParty 
	 */
	public void addShipToParty(ESWCustomerCustomDTO ashipToParty){
		if(null != ashipToParty){
			if(null == shipToParty){
				shipToParty = new TreeMap(); 
			}
			shipToParty.put(ashipToParty.getSAPCustomerNumber(), ashipToParty);
		}
	}

	/**
	 * Adds customer list to the collection of already existing customer lists  
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
	 * @param customerList 
	 */
//	public void addCustomerList(CustomerListCustomDTO acustomerList){
//		if(null != acustomerList){
//			if(null == customerLists){
//				customerLists = new TreeMap(); 
//			}
//			customerLists.put(acustomerList.getListNumber(), acustomerList);
//		}
//	}

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
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getSelectedBillToParty() {
		return selectedBillToParty;
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
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getSelectedPayer() {
		return selectedPayer;
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
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getSelectedShipToParty() {
		return selectedShipToParty;
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
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getSelectedSoldToParty() {
		return selectedSoldToParty;
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
	 * @param string 
	 */
	public void setSelectedBillToParty(ESWCustomerCustomDTO string) {
		selectedBillToParty = string;
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
	 * @param string 
	 */
	public void setSelectedPayer(ESWCustomerCustomDTO string) {
		selectedPayer = string;
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
	 * @param string 
	 */
	public void setSelectedShipToParty(ESWCustomerCustomDTO string) {
		selectedShipToParty = string;
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
	 * @param string 
	 */
	public void setSelectedSoldToParty(ESWCustomerCustomDTO string) {
		selectedSoldToParty = string;
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
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getSelectedNineDPartner() {
		return selectedNineDPartner;
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
	 * @return boolean
	 */
	public boolean isVarianceProposal() {
		return varianceProposal;
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
	public void setSelectedNineDPartner(ESWCustomerCustomDTO customDTO) {
		selectedNineDPartner = customDTO;
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
	 * @param b 
	 */
	public void setVarianceProposal(boolean b) {
		varianceProposal = b;
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
	 * @return boolean
	 */
	public boolean isIGFFlag() {
		return iGFFlag;
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
	 * @param b 
	 */
	public void setIGFFlag(boolean b) {
		iGFFlag = b;
	}
	
	/**
	 * get the customer
	 * 
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getCustomer() {
		return customer;
	}
	
	/**set customer
	 * 
	 * 
	 * @param newCustomer ESWCustomerCustomDTO
	 */
	public void setCustomer(ESWCustomerCustomDTO newCustomer) {
		customer = newCustomer;
	}
	
	
	/**
	 * @return Returns the selectedCustomers.
	 */
	public List getSelectedCustomers() {
		return selectedCustomers;
	}
	/**
	 * @param selectedCustomers The selectedCustomers to set.
	 */
	public void setSelectedCustomers(List selectedCustomers) {
		this.selectedCustomers = selectedCustomers;
	}
	/**
	 * @return Returns the customerName.
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName The customerName to set.
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
