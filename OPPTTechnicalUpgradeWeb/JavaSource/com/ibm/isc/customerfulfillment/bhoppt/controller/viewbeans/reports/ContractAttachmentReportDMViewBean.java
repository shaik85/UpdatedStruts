/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.ArrayList;

/**
 * Holds data of an dm that is used in contract attachment report.  
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
public class ContractAttachmentReportDMViewBean extends ReportDMViewBean 
{
	private ArrayList iSwos = null;
	
	/**
	 * Returns swo collection for the dm 
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
	 * Sets swo collection for the dm 
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
	 * Adds swo to the collection of swos for the dm.  
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
	 * @param swo ContractAttachmentReportSWOViewBean
	 */
	public void addSwo(ContractAttachmentReportSWOViewBean swo){
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
	 * @param number
	 * @param description
	 * @param valueMetricDescription
	 * @param useLevel
	 * @param swos
	 */
	public void setData(String number, String description, String valueMetricDescription, 
						String useLevel, ArrayList swos){
		setNumber(number);
		setDescription(description);
		setValueMetricDescription(valueMetricDescription);
		setUseLevel(useLevel);
		setSwos(swos);
	}
}
