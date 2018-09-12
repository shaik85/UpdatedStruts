/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.HashMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * Holds complete data required for showing a swo in cash flow report view  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class CashFlowReportSWOViewBean extends OPPTViewBean 
{
	private String iNumber = null;
	private String iSerialNumber = null;
	private HashMap iMonthlyPrice = null;

	/**
	 * Returns collection of swo monthly price's 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return HashMap
	 */
	public HashMap getMonthlyPrice() {
		return iMonthlyPrice;
	}

	/**
	 *  Returns swo number
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getNumber() {
		return iNumber;
	}

	/**
	 * Returns swo serial number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSerialNumber() {
		return iSerialNumber;
	}

	/**
	 * Sets swo monthly price collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMonthlyPrice HashMap 
	 */
	public void setMonthlyPrice(HashMap newMonthlyPrice) {
		iMonthlyPrice = newMonthlyPrice;
	}

	/**
	 * Sets swo number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNumber String 
	 */
	public void setNumber(String newNumber) {
		iNumber = newNumber;
	}

	/**
	 * Sets swo serial number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSerialNumber String 
	 */
	public void setSerialNumber(String newSerialNumber) {
		iSerialNumber = newSerialNumber;
	}

	/**
	 * Adds a new monthly price entry to the already existing collection of monthly price entries  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param month String
	 * @param price double
	 */
	public void addMonthlyPrice(String month, double price){
		if(null != month){
			if(null == iMonthlyPrice){
				iMonthlyPrice = new HashMap();
			}
			iMonthlyPrice.put(month, new Double(price));
		}
	}
	
	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param number String
	 * @param serialNumber String
	 * @param monthlyPrice HashMap
	 */
	public void setData(String number, String serialNumber, HashMap monthlyPrice){
		setNumber(number);
		setSerialNumber(serialNumber);
		setMonthlyPrice(monthlyPrice);
	}
}
