/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.ArrayList;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * Holds complete data about a license that is required for sysplex report   
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
public class SysplexReportSWOViewBean extends OPPTViewBean {
	private String iNumber = null;
	private String iActiveDM = null;
	private ArrayList iEEs = null;
	
	
	/**
	 * Returns the active dm value 
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
	public String getActiveDM() {
		return iActiveDM;
	}

	/**
	 * Returns the collaction ees available for the swo 
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
	public ArrayList getEEs() {
		return iEEs;
	}

	/**
	 * Returns the license number 
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
	public String getNumber() {
		return iNumber;
	}

	/**
	 * Sets the active dm value 
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
	 * @param newActiveDM String 
	 */
	public void setActiveDM(String newActiveDM) {
		iActiveDM = newActiveDM;
	}

	/**
	 * Sets the collection of ees for the license 
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
	 * @param newEEs ArrayList 
	 */
	public void setEEs(ArrayList newEEs) {
		iEEs = newEEs;
	}

	/**
	 * Sets the license number
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
	 * @param newNumber String 
	 */
	public void setNumber(String newNumber) {
		iNumber = newNumber;
	}
	
	/**
	 * Adds a new EE to the collection ees for the license  
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
	 * @param ee SysplexReportEEViewBean
	 */
	public void addEE(SysplexReportEEViewBean ee){
		if(null != ee){
			if(null == iEEs){
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
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param number String
	 * @param activeDM String
	 * @param ees ArrayList
	 */
	public void setData(String number, String activeDM, ArrayList ees){
		setNumber(number);
		setActiveDM(activeDM);
		setEEs(ees);
	}
}
