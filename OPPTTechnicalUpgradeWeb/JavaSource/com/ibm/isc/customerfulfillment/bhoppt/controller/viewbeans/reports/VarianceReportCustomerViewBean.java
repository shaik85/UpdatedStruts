/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.ArrayList;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * Holds complete data about a customer required for variance report  
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
public class VarianceReportCustomerViewBean extends OPPTViewBean {
	private String iCustomerNumber = null;
	private ArrayList iDMs = null;

	/**
	 * Returns customer number
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
	public String getCustomerNumber() {
		return iCustomerNumber;
	}

	/**
	 * Returns collection of dms for the customer 
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
	 * Sets customer number 
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
	 * @param newCustomerNumber String 
	 */
	public void setCustomerNumber(String newCustomerNumber) {
		iCustomerNumber = newCustomerNumber;
	}

	/**
	 * Sets dm collection for the customer 
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
	 * Adds dm to the collection of dms for the customer  
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
	 * @param dm
	 */
	public void addDM(VarianceReportDMViewBean dm){
		if(null != dm){
			if(null == iDMs){
				iDMs = new ArrayList();
			}
			iDMs.add(dm);
		}
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
	 * @param customerNumber
	 * @param dms
	 */
	public void setData(String customerNumber, ArrayList dms){
		setCustomerNumber(customerNumber);
		setDMs(dms);
	}
}
