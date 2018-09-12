/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomerCustomDTO;

/**
 * This class shows the information about a customer list and all the customers present in the 
 * customer list.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 14, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class CustomerListViewBean extends OPPTViewBean {
	private String iListNumber = null;
	private String iListName = null;
	private TreeMap iCustomers = null;
	//DADO02
	private String icustomerNumber = null;
	private String icustomerName = null;
	private String iSAPCustomerNumber = null;
	private String isiteID = null;
	
	private boolean iCanBeDeleted = false;
	private boolean iAlreadyExists = false;
	private boolean iSelected = false;
	private boolean iDeleteSelected = false;
	
	private boolean invSelected = false;
	private boolean selectedSTP = false;
	private boolean userINVSelection = false;
	
	/**
	 * Returs collection of customers part of the customer list 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getCustomers() {
		return iCustomers;
	}

	/**
	 * Returns the customer list name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getListName() {
		return iListName;
	}

	/**
	 * Returns the customer list number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getListNumber() {
		return iListNumber;
	}

	/**
	 * Sets the collection passed as customer for customer list 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomers TreeMap 
	 */
	public void setCustomers(TreeMap newCustomers) {
		iCustomers = newCustomers;
	}

	/**
	 * Sets the string value passed as customer list name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newListName String 
	 */
	public void setListName(String newListName) {
		iListName = newListName;
	}

	/**
	 * Sets the string value passed as customer list number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newListNumber String 
	 */
	public void setListNumber(String newListNumber) {
		iListNumber = newListNumber;
	}
	
	/**
     * Sets the information about the customer list on a single call.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 14, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param listNumber String
     * @param listName String
     * @param customers TreeMap
     * @param alreadyExists 
     */
	public void setData(String listNumber, String listName, boolean alreadyExists, TreeMap customers) {
		setListNumber(listNumber);
		setListName(listName);
		setCustomers(customers);
		setAlreadyExists(alreadyExists);
	}
	
	/**
	 * Adds the newCustomer to the already existing collection of customers if any.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomer CustomerListCustomerViewBean
	 */
	public void addCustomer(CustomerListCustomerViewBean newCustomer) {
		if(newCustomer != null) {
			if(iCustomers == null) {
				iCustomers = new TreeMap();
			}
			iCustomers.put(newCustomer.getCustomerNumber(), newCustomer);
		}
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(CustomerListCustomDTO customDTO){
		if(null != customDTO){
						
			 String value = customDTO.getSiteID();
			if(null!=value){
			setSiteID(value.toUpperCase());	
			}
			
			value = customDTO.getCustomerNumber();
			if(null!=value){
				setCustomerNumber(value.toUpperCase());
			}
			value = customDTO.getCustomerName();
			if(null!=value){
				setCustomerName(value.toUpperCase());
			}
			value = customDTO.getSAPCustomerNumber();
			if(null!=value){
				setSAPCustomerNumber(value.toUpperCase());
			}
			setSelectedSTP(customDTO.isSTPSelected());
			setInvSelected(customDTO.isInventorySelected());
			// DADO02
			setAlreadyExists(customDTO.isAlreadyExists());
			setCanBeDeleted(customDTO.isCanBeDeleted());
			
			TreeMap customers = customDTO.getCustomers();
			if(null != customers){
				Iterator iterator = customers.values().iterator();
				while(iterator.hasNext()){
					addCustomer(new CustomerListCustomerViewBean((CustomerListCustomerCustomDTO)iterator.next()));			
				}
			}
		}
	}
	
   
	/**
     * CustomerListViewBean
     * 
     * @author thirumalai
     */
    public CustomerListViewBean(){
	}

	/**
     * CustomerListViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public CustomerListViewBean(CustomerListCustomDTO customDTO){
		setData(customDTO);
	}
    
    /**
     * CustomerListViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
   
	/**
	 * Returns true if the customer list is already existing in the proposal 
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
	 * @return boolean
	 */
	public boolean isAlreadyExists() {
		return iAlreadyExists;
	}

	/**
	 * sets already exists flag 
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
	 * @param newAlreadyExists boolean 
	 */
	public void setAlreadyExists(boolean newAlreadyExists) {
		iAlreadyExists = newAlreadyExists;
	}

	/**
	 * Returns can be deleted flag 
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
		return iCanBeDeleted;
	}

	/**
	 * Sets can be deleted flag value 
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
		iCanBeDeleted = b;
	}

	/**
     * toString
     * 
     * @see java.lang.Object#toString()
     * @author thirumalai
     */
    public String toString(){
		StringBuffer stringValue = new StringBuffer();

		//stringValue.append("\nCustomer list number: "+getListNumber());  //$NON-NLS-1$
		//stringValue.append("\nCustomer list name: "+getListName());  //$NON-NLS-1$
		stringValue.append("\nCustomer list number: "+getCustomerName());  //$NON-NLS-1$
		stringValue.append("\nCustomer list name: "+getCustomerNumber());  //$NON-NLS-1$
		stringValue.append("\nCustomer list number: "+getSAPCustomerNumber());  //$NON-NLS-1$
		stringValue.append("\nCustomer list already exists: "+isAlreadyExists());  //$NON-NLS-1$
		stringValue.append("\nCustomer list cab be deleted: "+isCanBeDeleted());  //$NON-NLS-1$
		stringValue.append("\nCustomer list userinvoiceselected: "+isUserINVSelection());  //$NON-NLS-1$
		
		return stringValue.toString();
	}
	
	/**
	 * Returns true if the check box corresponding to this customer list is selected 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isSelected() {
		return iSelected;
	}

	/**
	 * Sets selected status of the check box corresponding to this customer. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelected boolean
	 */
	public void setSelected(boolean newSelected) {
		iSelected = newSelected;
	}

	/**
	 * Returns true if the delete check box corresponding to this customer list is selected 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isDeleteSelected() {
		return iDeleteSelected;
	}

	/**
	 * Sets selected status of the delete check box corresponding to this customer. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDeleteSelected boolean
	 */
	public void setDeleteSelected(boolean newDeleteSelected) {
		iDeleteSelected = newDeleteSelected;
	}
	
	//DADO02
	/**
	 * @return Returns the customerName.
	 */
	public String getCustomerName() {
		return icustomerName;
	}
	/**
	 * @param customerName The customerName to set.
	 */
	public void setCustomerName(String newcustomerName) {
		icustomerName = newcustomerName;
	}
	/**
	 * @return Returns the customerNumber.
	 */
	public String getCustomerNumber() {
		return icustomerNumber;
	}
	/**
	 * @param customerNumber The customerNumber to set.
	 */
	public void setCustomerNumber(String newcustomerNumber) {
		icustomerNumber = newcustomerNumber;
	}
	/**
	 * @return Returns the sAPCustomerNumber.
	 */
	public String getSAPCustomerNumber() {
		return iSAPCustomerNumber;
	}
	/**
	 * @param customerNumber The sAPCustomerNumber to set.
	 */
	public void setSAPCustomerNumber(String newcustomerNumber) {
		iSAPCustomerNumber = newcustomerNumber;
	}
	/**
	 * @return Returns the invSelected.
	 */
	public boolean isInvSelected() {
		return invSelected;
	}
	/**
	 * @param invSelected The invSelected to set.
	 */
	public void setInvSelected(boolean invSelected) {
		this.invSelected = invSelected;
	}
	/**
	 * @return Returns the selectedSTP.
	 */
	public boolean isSelectedSTP() {
		return selectedSTP;
	}
	/**
	 * @param selectedSTP The selectedSTP to set.
	 */
	public void setSelectedSTP(boolean selectedSTP) {
		this.selectedSTP = selectedSTP;
	}
	/**
	 * @return Returns the userINVSelection.
	 */
	public boolean isUserINVSelection() {
		return userINVSelection;
	}
	/**
	 * @param userINVSelection The userINVSelection to set.
	 */
	public void setUserINVSelection(boolean userINVSelection) {
		this.userINVSelection = userINVSelection;
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