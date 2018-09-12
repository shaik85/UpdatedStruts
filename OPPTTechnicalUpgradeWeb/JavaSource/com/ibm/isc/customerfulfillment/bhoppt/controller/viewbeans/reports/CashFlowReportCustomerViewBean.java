/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * Holds complete data about a customer used in cash flow report.  
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
public class CashFlowReportCustomerViewBean extends OPPTViewBean {
	private String iSoldToPartyNumber;
	private String iSoldToPartyASNumber;
	private HashMap iMonthlyPrices;
	private ArrayList iDms;
	
	/**
	 * Returns the collection of dms (CashFlowReportDMViewBean) for the customer 
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
	 * @return ArrayList
	 */
	public ArrayList getDms() {
		return iDms;
	}

	/**
	 * Returns the collection of monthly prices for the customer 
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
	public HashMap getMonthlyPrices() {
		return iMonthlyPrices;
	}

	/**
	 * Returns sold to party address sequence number
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
	public String getSoldToPartyASNumber() {
		return iSoldToPartyASNumber;
	}

	/**
	 * Returns sold to party number 
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
	public String getSoldToPartyNumber() {
		return iSoldToPartyNumber;
	}

	/**
	 * Sets the collection of dms (CashFlowReportDMViewBean) for the customer 
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
	 * @param newDms ArrayList 
	 */
	public void setDms(ArrayList newDms) {
		iDms = newDms;
	}

	/**
	 * Sets the collection of monthly prices for the customer 
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
	 * @param newMonthlyPrices HashMap 
	 */
	public void setMonthlyPrices(HashMap newMonthlyPrices) {
		iMonthlyPrices = newMonthlyPrices;
	}

	/**
	 * Sets sold to party address sequence number 
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
	 * @param newSoldToPartyASNumber String 
	 */
	public void setSoldToPartyASNumber(String newSoldToPartyASNumber) {
		iSoldToPartyASNumber = newSoldToPartyASNumber;
	}

	/**
	 * Set sold to party number 
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
	 * @param newSoldToPartyNumber String 
	 */
	public void setSoldToPartyNumber(String newSoldToPartyNumber) {
		iSoldToPartyNumber = newSoldToPartyNumber;
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
			if(null == iMonthlyPrices){
				iMonthlyPrices = new HashMap();
			}
			iMonthlyPrices.put(month, new Double(price));
		}
	}
	
	/**
	 * Adds a new CashFlowReportDMViewBean to the collection of dms  
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
	 * @param dm
	 */
	public void addDM(CashFlowReportDMViewBean dm){
		if(null != dm){
			if(null == iDms){
				iDms = new ArrayList();
			}
			iDms.add(dm);
		}
	}
	
	/**
	 * Sets complete data in a single data  
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
	 * @param soldToPartyNumber String
	 * @param soldToPartyASNumber String
	 * @param monthlyPrices HashMap
	 * @param dms ArrayList
	 */
	public void setData(String soldToPartyNumber, String soldToPartyASNumber, HashMap monthlyPrices, ArrayList dms){
		setSoldToPartyNumber(soldToPartyNumber);
		setSoldToPartyASNumber(soldToPartyASNumber);
		setMonthlyPrices(monthlyPrices);
		setDms(dms);
	}
}
