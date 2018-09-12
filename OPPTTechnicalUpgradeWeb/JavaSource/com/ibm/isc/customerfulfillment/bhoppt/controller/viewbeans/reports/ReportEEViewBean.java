/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * Holds complete data about an ee that is used in reports  
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
public class ReportEEViewBean extends OPPTViewBean {
	private String iNumber = null;
	private String iUseLevel = null;
	private String iValueMetricDescription = null;
	private String iEswPrice = "0.00";
	private String iAlternatePrice = "0.00";
	private String iCalculatedPrice = "0.00";
	
	/**
	 * Returns the alternate price for the EE 
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
	 * Returns the calculated price for the EE 
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
	 * Returns EE number 
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
	 * Returns use level of the EE 
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
	public String getUseLevel() {
		return iUseLevel;
	}

	/**
	 * Returns value metric description of EE 
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
	public String getValueMetricDescription() {
		return iValueMetricDescription;
	}

	/**
	 * Sets alternate price of the EE 
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
	 * Sets calculated price of the EE 
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
	 * Sets esw price 
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
	 * Sets EE number 
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
	 * Sets use level for EE 
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
	 * @param newUseLevel String 
	 */
	public void setUseLevel(String newUseLevel) {
		iUseLevel = newUseLevel;
	}

	/**
	 * Sets value metric description for the ee 
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
	 * @param newValueMetricDescription String 
	 */
	public void setValueMetricDescription(String newValueMetricDescription) {
		iValueMetricDescription = newValueMetricDescription;
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
	 * @param number
	 * @param useLevel
	 * @param valueMetricDescription
	 * @param eswPrice
	 * @param alternatePrice
	 * @param calculatedPrice
	 */
	public void setData(String number, String useLevel, String valueMetricDescription, 
						String eswPrice, String alternatePrice, String calculatedPrice){
		setNumber(number);
		setUseLevel(useLevel);
		setValueMetricDescription(valueMetricDescription);
		setEswPrice(eswPrice);
		setAlternatePrice(alternatePrice);
		setCalculatedPrice(calculatedPrice);
	}
}
