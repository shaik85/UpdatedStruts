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
 * Holds complete data about a dm that is used in cash flow report  
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
public class CashFlowReportDMViewBean extends ReportDMViewBean {
	private HashMap iMonthlyPrices = null;
	private ArrayList iSwos = null;
	
	/**
	 * Returns the collection of monthly prices for the dm 
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
	 * Returns the collection of swo's (CashFlowReportSWOViewBean) for dm 
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
	public ArrayList getSwos() {
		return iSwos;
	}

	/**
	 * Sets monthly prices collection for the dm 
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
	 * Sets collection of swo's (CashFlowReportSWOViewBean) for the dm 
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
	 * @param newSwos ArrayList 
	 */
	public void setSwos(ArrayList newSwos) {
		iSwos = newSwos;
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
	 * Adds a new CashFlowReportSWOViewBean to the collection of swos  
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
	 * @param swo CashFlowReportSWOViewBean
	 */
	public void addSwo(CashFlowReportSWOViewBean swo){
		if(null != swo){
			if(null == iSwos){
				iSwos = new ArrayList();
			}
			iSwos.add(swo);
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
	 * @param description String
	 * @param valueMetricDescription String
	 * @param useLevel String
	 * @param monthlyPrices HashMap
	 * @param swos ArrayList
	 */
	public void setData(String number, String description, String valueMetricDescription, String useLevel, 
						HashMap monthlyPrices, ArrayList swos){
		super.setData(number, description, valueMetricDescription, useLevel);
		setMonthlyPrices(monthlyPrices);
		setSwos(swos);
	}
}
