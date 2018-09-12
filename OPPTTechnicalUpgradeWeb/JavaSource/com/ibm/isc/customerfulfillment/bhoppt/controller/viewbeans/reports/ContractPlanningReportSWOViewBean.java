/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.ArrayList;
import java.util.Date;

/**
 * Holds complete data about a license that is used in contract planning report  
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
public class ContractPlanningReportSWOViewBean extends ReportSWOViewBean {
	private ArrayList iEEs = null;
	private String iIndicator = null;
	private String iEswPrice = "0.00";
	private String iAlternatePrice = "0.00";
	private String iCalculatedPrice = "0.00";
	
	/**
	 * Returns alternate price 
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
	public String getAlternatePrice() {
		return iAlternatePrice;
	}

	/**
	 * Returns calculated price 
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
	public String getCalculatedPrice() {
		return iCalculatedPrice;
	}

	/**
	 * Returns collection of ees for the license 
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
	public ArrayList getEEs() {
		return iEEs;
	}

	/**
	 * Returns esw price 
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
	public String getEswPrice() {
		return iEswPrice;
	}

	/**
	 * Returns ee indicator 
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
	public String getIndicator() {
		return iIndicator;
	}

	/**
	 * Sets alternate price for the license 
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
	 * @param newAlternatePrice String 
	 */
	public void setAlternatePrice(String newAlternatePrice) {
		iAlternatePrice = newAlternatePrice;
	}

	/**
	 * Sets calculated price for the license 
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
	 * @param newCalculatedPrice String 
	 */
	public void setCalculatedPrice(String newCalculatedPrice) {
		iCalculatedPrice = newCalculatedPrice;
	}

	/**
	 * Sets the collection of ees for the license 
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
	 * @param newEEs ArrayList 
	 */
	public void setEEs(ArrayList newEEs) {
		iEEs = newEEs;
	}

	/**
	 * Sets esw price for the license 
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
	 * @param newEswPrice String 
	 */
	public void setEswPrice(String newEswPrice) {
		iEswPrice = newEswPrice;
	}

	/**
	 * Sets indicator for the license 
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
	 * @param newIndicator String 
	 */
	public void setIndicator(String newIndicator) {
		iIndicator = newIndicator;
	}
	
	/**
	 * Adds a new ee to the collection of ees for the license  
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
	 * @param ee ReportEEViewBean
	 */
	public void addEE(ReportEEViewBean ee){
		if(null != ee){
			if(iEEs == null){
				iEEs = new ArrayList();
			}
			iEEs.add(ee);
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
	 * @param description String
	 * @param planStartDate String
	 * @param planEndDate String
	 * @param ees ArrayList
	 * @param indicator String
	 * @param eswPrice String
	 * @param alternatePrice String
	 * @param calculatedPrice String
	 */
	public void setData(String number, String serialNumber, String description, 
						String planStartDate, String planEndDate, ArrayList ees, String indicator, 
						String eswPrice, String alternatePrice, String calculatedPrice){
		super.setData(number, serialNumber, description, planStartDate, planEndDate);
		setEEs(ees);
		setIndicator(indicator);
		setEswPrice(eswPrice);
		setAlternatePrice(alternatePrice);
		setCalculatedPrice(calculatedPrice);
	}
}
