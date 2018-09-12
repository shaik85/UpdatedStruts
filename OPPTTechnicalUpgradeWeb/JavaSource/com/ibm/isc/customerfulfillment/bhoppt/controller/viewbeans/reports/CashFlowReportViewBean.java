/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Holds complete data required for cash flow report  
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
public class CashFlowReportViewBean extends ReportViewBean {
	/**
	 * This will have month as key and price as value 
	 */
	private HashMap iMonthlyPrices = null;
	private ArrayList iCustomers = null;

	/**
	 * Returns collection of customers 
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
	public ArrayList getCustomers() {
		return iCustomers;
	}

	/** 
	 * Returns collection of methly prices for the proposal
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
	 * Sets the collection of customers for the proposal 
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
	 * @param newCustomers ArrayList 
	 */
	public void setCustomers(ArrayList newCustomers) {
		iCustomers = newCustomers;
	}

	/**
	 * Sets collection of montly prices for the proposal 
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
	public void setMonthlyPrice(HashMap newMonthlyPrices) {
		iMonthlyPrices = newMonthlyPrices;
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
	 * Adds a new customer (CashFlowReportCustomerViewBean) to the collection of already 
	 * existing customers  
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
	 * @param customer CashFlowReportCustomerViewBean
	 */
	public void addCustomer(CashFlowReportCustomerViewBean customer){
		if(null != customer){
			if(null == iCustomers){
				iCustomers = new ArrayList();
			}
			iCustomers.add(customer);
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
	 * @param monthlyPrices HashMap
	 * @param customers ArrayList
	 */
	public void setData(HashMap monthlyPrices, ArrayList customers){
		setMonthlyPrice(monthlyPrices);
		setCustomers(customers);
	}
}
