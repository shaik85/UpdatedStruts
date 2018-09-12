/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomerCustomDTO;

/**
 * This is an data holder class which holds information about a customer.   
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
public class CustomerListCustomerViewBean extends OPPTViewBean {
	private String addressSequenceNumber = null;
	private String customerName = null;
	private String customerNumber = null;
	private boolean invSelected = false;
	private boolean selectedSTP = false;
	private boolean userINVSelection = false;
	private String legacyCustomerNumber = null;
	
	/**
     * CustomerListCustomerViewBean
     * 
     * @author thirumalai
     */
    public CustomerListCustomerViewBean(){
	}

	/**
     * CustomerListCustomerViewBean
     * 
     * @param customerDTO
     * @author thirumalai
     */
    public CustomerListCustomerViewBean(CustomerListCustomerCustomDTO customerDTO){
		setData(customerDTO);
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
	 * Returns the customer name 
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
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Retuns customer number 
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
	public String getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * Returns the legacy customer number 
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
	public String getLegacyCustomerNumber() {
		return legacyCustomerNumber;
	}

	/**
	 * Returns legacy customer number embeded with address sequence number  
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
		return legacyCustomerNumber+" "+addressSequenceNumber;  //$NON-NLS-1$
	}

	/**
	 * Returns true if inventory of this customer is added into the proposal. 
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
	 * @return boolean
	 */
	public boolean isInvSelected() {
		return invSelected;
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
	 * Sets the string value passed as customer name 
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
	 * @param newCustomerName String
	 */
	public void setCustomerName(String newCustomerName) {
		customerName = newCustomerName;
	}

	/**
	 * Sets the string value passed as the customer number. 
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
	 * @param newCustomerNumber String 
	 */
	public void setCustomerNumber(String newCustomerNumber) {
		customerNumber = newCustomerNumber;
	}
	
	/**
     * setData
     * @param customDTO
     * @author thirumalai
     */
    public void setData(CustomerListCustomerCustomDTO customDTO){
		if(null != customDTO){
			setLegacyCustomerNumber(customDTO.getLegacyCustomerNumber());
			setAddressSequenceNumber(customDTO.getAddressSequenceNumber());
			setCustomerNumber(customDTO.getCustomerNumber());
			setCustomerName(customDTO.getCustomerName());
			setInvSelected(customDTO.isInventorySelected()); //DADO02 Sateesh
			setSelectedSTP(customDTO.isIsSTP());
		}
	}
	
	/**
     * This method is used for populating the data in a single call.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 14, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param legacyCustomerNumber String
     * @param customerNumber String
     * @param customerName String
     * @param invSelected boolean
     * @param addressSequenceNumber 
     */
	public void setData(String legacyCustomerNumber, String addressSequenceNumber, String customerNumber, String customerName, boolean invSelected) {
		setLegacyCustomerNumber(legacyCustomerNumber);
		setAddressSequenceNumber(addressSequenceNumber);
		setCustomerNumber(customerNumber);
		setCustomerName(customerName);
		setInvSelected(invSelected);
	}

	/**
	 * Sets whether the customers inventory is added into proposal 
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
	 * @param newInvSelected boolean 
	 */
	public void setInvSelected(boolean newInvSelected) {
		invSelected = newInvSelected;
	}

	/**
	 * Sets the string value passed as legacy customer number 
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
	 * @param newLegacyCustomerNumber String
	 */
	public void setLegacyCustomerNumber(String newLegacyCustomerNumber) {
		legacyCustomerNumber = newLegacyCustomerNumber;
	}
	
	/**
	 * Returns true if this customer is the selected sold to party 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean 
	 */
	public boolean isSelectedSTP() {
		return selectedSTP;
	}

	/** 
	 * Sets selected stp flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedSTP boolean
	 */
	public void setSelectedSTP(boolean newSelectedSTP) {
		selectedSTP = newSelectedSTP;
	}
	
	/**
     * toSring
     * @see java.lang.Object#toString()
     * @author thirumalai
     */
    public String toString(){
		String value = "\n[CustomerListCustomerViewBean] - Start...";  //$NON-NLS-1$
		value += "\n\t[CustomerListCustomerViewBean] - [iAddressSequenceNumber]-"+getAddressSequenceNumber();  //$NON-NLS-1$
		value += "\n\t[CustomerListCustomerViewBean] - [iCustomerName] - "+getCustomerName();  //$NON-NLS-1$
		value += "\n\t[CustomerListCustomerViewBean] - [iCustomerNumber] - "+getCustomerNumber();  //$NON-NLS-1$
		value += "\n\t[CustomerListCustomerViewBean] - [iLegacyCustomerNumber] - "+getLegacyCustomerNumber();  //$NON-NLS-1$
		value += "\n\t[CustomerListCustomerViewBean] - [iInvSelected] - "+isInvSelected();  //$NON-NLS-1$
		value += "\n\t[CustomerListCustomerViewBean] - [iSelectedStp] - "+isSelectedSTP();  //$NON-NLS-1$
		value += "\n[CustomerListCustomerViewBean] - End...\n";  //$NON-NLS-1$
		return value;
	}
	
	/**
	 * Returns users selection on the customer for inventory 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isUserINVSelection() {
		return userINVSelection;
	}

	/** 
	 * Sets users selection on the customer for inventory
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newUserINVSelection boolean
	 */
	public void setUserINVSelection(boolean newUserINVSelection) {
		userINVSelection = newUserINVSelection;
	}
}
