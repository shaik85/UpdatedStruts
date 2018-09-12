/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.ArrayList;

/**
 * Holds complete data required for showing an dm in contract amendment report  
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
public class ContractAmendmentReportDMViewBean extends ReportDMViewBean {
	private ArrayList iSwos = null;
	
	/**
	 * Returns collection of swos available for the dm 
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
	 * Sets the collection of swos to the dm 
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
	 * Adds an swo to the collection of swo's available for the dm  
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
	 * @param swo ContractAmendmentReportSWOViewBean
	 */
	public void addSwo(ContractAmendmentReportSWOViewBean swo){
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
	 * @param swos ArrayList
	 */
	public void setData(String number, String description, String valueMetricDescription, 
						String useLevel, ArrayList swos){
		super.setData(number, description, valueMetricDescription, useLevel);
		setSwos(swos);
	}
}
