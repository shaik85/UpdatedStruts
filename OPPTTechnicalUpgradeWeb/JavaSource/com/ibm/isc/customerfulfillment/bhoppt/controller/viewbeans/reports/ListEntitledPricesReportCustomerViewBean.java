/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import com.ibm.isc.customerfulfillment.bhoppt.controller.*;

import java.util.*;



/**
 * Holds complete data about a customer required for list entitled prices report.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ListEntitledPricesReportCustomerViewBean extends OPPTViewBean {
	private String iLegacyNumber = null;
	private String iAddressSequenceNumber = null;
	private double iTotalListPrice = 0;
    private double iTotalEntitledPrice = 0;
	private ArrayList iDMs = null;
	
	/**
	 * Returns address sequence number value for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
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
	 *  Returns the collection of dms available for the customer
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ArrayList
	 */
	public ArrayList getDMs() {
		return iDMs;
	}

	/**
	 * Returns the legacy number for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getLegacyNumber() {
		return iLegacyNumber;
	}

	/**
	 * Returns the total entitled price for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return double
	 */
	public double getTotalEntitledPrice() {
		return iTotalEntitledPrice;
	}

	/**
	 * Returns total list price for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return double
	 */
	public double getTotalListPrice() {
		return iTotalListPrice;
	}

	/**
	 * Sets address sequence number for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAddressSequenceNumber String 
	 */
	public void setAddressSequenceNumber(String newAddressSequenceNumber) {
		iAddressSequenceNumber = newAddressSequenceNumber;
	}

	/**
	 * Sets the collection of dms for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDMs ArrayList 
	 */
	public void setDMs(ArrayList newDMs) {
		iDMs = newDMs;
	}

	/**
	 * Sets the legacy number for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLegacyNumber String 
	 */
	public void setLegacyNumber(String newLegacyNumber) {
		iLegacyNumber = newLegacyNumber;
	}

	/**
	 * Sets the total entitled price value for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newTotalEntitledPrice double 
	 */
	public void setTotalEntitledPrice(double newTotalEntitledPrice) {
		iTotalEntitledPrice = newTotalEntitledPrice;
	}

	/**
	 * Sets the total entitled price for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newTotalListPrice double 
	 */
	public void setTotalListPrice(double newTotalListPrice) {
		iTotalListPrice = newTotalListPrice;
	}

	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param legacyNumber String
	 * @param addressSequenceNumber String
	 * @param dms ArrayList
	 * @param totalListPrice double 
	 * @param totalEntitledPrice double
	 */
	public void setData(String legacyNumber, String addressSequenceNumber, ArrayList dms, 
						double totalListPrice, double totalEntitledPrice){
		setLegacyNumber(legacyNumber);
		setAddressSequenceNumber(addressSequenceNumber);
		setDMs(dms);
		setTotalListPrice(totalListPrice);
		setTotalEntitledPrice(totalEntitledPrice);
	}
}
