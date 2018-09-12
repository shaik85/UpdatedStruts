/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Custom dto that holds customer list information  
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
 * CustomerListCustomerCustomDTO
 */
public class CustomerListCustomDTO extends OPPTCustomDTO {
	private boolean alreadyExists = false;
	private boolean canBeDeleted = false;
	private TreeMap customers = null;
	private String listName = null;
	private String listNumber = null;
	//DADO02
	private String customerNumber = null;
	private String customerName = null;
	private String SAPCustomerNumber = null;
	private String siteID;
	private boolean inventorySelected;
	
	private boolean isSTPSelected ; //DADO02
	
	/**
	 * Returns the collection of customer for the customer list 
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
	public TreeMap getCustomers() {
		return customers;
	}

	/**
	 * Returns customer list name 
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
	public String getListName() {
		return listName;
	}

	/**
	 * Returns customer list number 
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
	public String getListNumber() {
		return listNumber;
	}
	/**
	 * Returns already exists flag 
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
	public boolean isAlreadyExists() {
		return alreadyExists;
	}

	/**
	 * Sets customer list already exists in proposal flag 
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
	 * @param newAlreadyExists 
	 */
	public void setAlreadyExists(boolean newAlreadyExists) {
		alreadyExists = newAlreadyExists;
	}

	/**
	 * Sets customer collection for the customer list 
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
	 * @param newCustomers 
	 */
	public void setCustomers(TreeMap newCustomers) {
		customers = newCustomers;
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
	 * @param ilistName 
	 * @param ilistNumber 
	 * @param icustomers 
	 * @param ialreadyExists 
	 */
	public void setData(String ilistName, String ilistNumber, TreeMap icustomers, boolean ialreadyExists){
		setListName(ilistName);
		setListNumber(ilistNumber);
		setCustomers(icustomers);
		setAlreadyExists(ialreadyExists);
	}

	/**
	 * Sets customer list name 
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
	 * @param newListName 
	 */
	public void setListName(String newListName) {
		listName = newListName;
	}

	/**
	 * Set customer list number 
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
	 * @param newListNumber 
	 */
	public void setListNumber(String newListNumber) {
		listNumber = newListNumber;
	}

	/**
	 * Adds new customer to the collection of customers in the customer list  
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
	 * @param customer 
	 */
	public void addCustomer(CustomerListCustomerCustomDTO customer){
		if(null != customer){
			if(null == customers){
				customers = new TreeMap();
			}
			customers.put(customer.getCustomerNumber(), customer);
		}
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
	public boolean isCanBeDeleted() {
		return canBeDeleted;
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
	public void setCanBeDeleted(boolean b) {
		canBeDeleted = b;
	}

	/**
     * Enter one sentence as a brief description for this method.
     * You can enter more text here. Please think of
     * - visibility decision
     * - changes that are made to objects, which are passed as parameters
     * - concurrency issues
     * - examples how to invoke this methods
     * - preconditions that this method relies on
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 23, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return String
     */
	public String toString(){
		StringBuffer stringValue = new StringBuffer();

		stringValue.append("\nCustomer number: "+getCustomerNumber());  /* NOI18N */
		stringValue.append("\nCustomer name: "+getCustomerName());  /* NOI18N */
		//stringValue.append("\nCustomer list already exists: "+isAlreadyExists());  /* NOI18N */
		//stringValue.append("\nCustomer list cab be deleted: "+isCanBeDeleted());  /* NOI18N */
		
		return stringValue.toString();
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
	
	/**
	 * @return Returns the isSTPSelected.
	 */
	public boolean isSTPSelected() {
		return isSTPSelected;
	}
	/**
	 * @param isSTPSelected The isSTPSelected to set.
	 */
	public void setSTPSelected(boolean isSTPSelected) {
		this.isSTPSelected = isSTPSelected;
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
	 * @return Returns the inventorySelected.
	 */
	public boolean isInventorySelected() {
		return inventorySelected;
	}
	/**
	 * @param inventorySelected The inventorySelected to set.
	 */
	public void setInventorySelected(boolean inventorySelected) {
		this.inventorySelected = inventorySelected;
	}
}
