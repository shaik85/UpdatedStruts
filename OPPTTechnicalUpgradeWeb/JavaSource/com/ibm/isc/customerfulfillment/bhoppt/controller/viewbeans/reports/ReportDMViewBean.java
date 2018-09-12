/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * Holds basic data about a dm that is used in reports  
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
public class ReportDMViewBean extends OPPTViewBean {
	private String iNumber = null;
	private String iDescription = null;
	private String iValueMetricDescription = null;
	private String iUseLevel = null;
	
	/**
	 * Returns dm number 
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
	public String getDescription() {
		return iDescription;
	}

	/**
	 * Returns dm number 
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
	 * Returns use level 
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
	 * Returns value metric description 
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
	 * Sets description about the dm 
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
	 * @param newDescription String 
	 */
	public void setDescription(String newDescription) {
		iDescription = newDescription;
	}

	/**
	 * Sets dm number 
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
	 * Sets use level for the dm 
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
	 * Sets value metric description of the dm 
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
	 * @param number String
	 * @param description String
	 * @param valueMetricDescription String
	 * @param useLevel String
	 */
	public void setData(String number, String description, String valueMetricDescription, String useLevel){
		setNumber(number);
		setDescription(description);
		setValueMetricDescription(valueMetricDescription);
		setUseLevel(useLevel);
	}
}
