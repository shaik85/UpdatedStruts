/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.ArrayList;



/**
 * Holds complete data of an swo that is used in contract attachment report  
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
public class ContractAttachmentReportSWOViewBean extends ReportSWOViewBean {
	private ArrayList iEEs = null;
	private String iIndicator = null;
	private String iComments = null;
	private String iMonthlyPrice = "0.00";
	private String iCalculatedPrice = "0.00";
	
	/**
	 * Returns calculated price of the swo 
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
	 * Returns comments about the swo 
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
	public String getComments() {
		return iComments;
	}

	/**
	 * Returns license indicator  
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
	 * Returns the monthly price of the license 
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
	public String getMonthlyPrice() {
		return iMonthlyPrice;
	}

	/**
	 * Sets the calculated price of the license 
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
	 * Sets comments for the license 
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
	 * @param newComments String 
	 */
	public void setComments(String newComments) {
		iComments = newComments;
	}

	/**
	 * Sets license indicator 
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
	 * Sets monthly price of the license 
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
	 * @param newMonthlyPrice String 
	 */
	public void setMonthlyPrice(String newMonthlyPrice) {
		iMonthlyPrice = newMonthlyPrice;
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
	 * @param indicator String
	 * @param comments String
	 * @param monthlyPrice String
	 * @param calculatedPrice String
	 */
	public void setData(String number, String serialNumber, String description, 
						String planStartDate, String planEndDate, String indicator, 
						String comments, String monthlyPrice, String calculatedPrice){
		super.setData(number, serialNumber, description, planStartDate, planEndDate);
		setIndicator(indicator);
		setComments(comments);
		setMonthlyPrice(monthlyPrice);
		setCalculatedPrice(calculatedPrice);
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

}
