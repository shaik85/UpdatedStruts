/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.ArrayList;

/**
 * Holds complete data required for a swo in contract amendment report.  
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
public class ContractAmendmentReportSWOViewBean extends ReportSWOViewBean {
	private ArrayList iEEs = null;
	private String iTotalMonthlyPrice = "0.00";
	private String iTotalCalculatedPrice = "0.00";
	private String iAdjustmentAmount = "0.00";

	/**
	 * Returns adjustment amount 
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
	public String getAdjustmentAmount() {
		return iAdjustmentAmount;
	}

	/**
	 * Retuns total calculated price  
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
	public String getTotalCalculatedPrice() {
		return iTotalCalculatedPrice;
	}

	/**
	 * Returns total monthly price 
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
	public String getTotalMonthlyPrice() {
		return iTotalMonthlyPrice;
	}

	/**
	 * Sets adjustment amount 
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
	 * @param newAdjustmentAmount String 
	 */
	public void setAdjustmentAmount(String newAdjustmentAmount) {
		iAdjustmentAmount = newAdjustmentAmount;
	}

	/**
	 * Sets total calculated price 
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
	 * @param newTotalCalculatedPrice String 
	 */
	public void setTotalCalculatedPrice(String newTotalCalculatedPrice) {
		iTotalCalculatedPrice = newTotalCalculatedPrice;
	}

	/**
	 * Sets total monthly price 
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
	 * @param newTotalMonthlyPrice String 
	 */
	public void setTotalMonthlyPrice(String newTotalMonthlyPrice) {
		iTotalMonthlyPrice = newTotalMonthlyPrice;
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
	 * @param totalMonthlyPrice String
	 * @param totalCalculatedPrice String
	 * @param adjustmentAmount String
	 */
	public void setData(
		String number,
		String serialNumber,
		String description,
		String planStartDate,
		String planEndDate,
		String totalMonthlyPrice,
		String totalCalculatedPrice,
		String adjustmentAmount) {
		super.setData(number, serialNumber, description, planStartDate, planEndDate);
		setTotalMonthlyPrice(totalMonthlyPrice);
		setTotalCalculatedPrice(totalCalculatedPrice);
		setAdjustmentAmount(adjustmentAmount);
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
	public void addEE(ReportEEViewBean ee) {
		if (null != ee) {
			if (iEEs == null) {
				iEEs = new ArrayList();
			}
			iEEs.add(ee);
		}
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
