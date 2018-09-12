/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Vector;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * Holds the information about a SWO and its ee's. This is used in Compate TP report.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class CompareTPSWOViewBean extends OPPTViewBean{
	private String swoNumber = null;
	private Vector eeViewBeans = null;

	/**
	 * Returns the collection of view beans (CompareTPEEViewBean) associated with the SWO.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Vector 
	 */
	public Vector getEEViewBeans() {
		return eeViewBeans;
	}

	/**
	 * Returns the SWO number associated with the SWO. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSwoNumber() {
		return swoNumber;
	}

	/**
	 * Sets the collection as the collection of EE's associated with the  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEEViewBeans Vector 
	 */
	public void setEEViewBeans(Vector newEEViewBeans) {
		eeViewBeans = newEEViewBeans;
	}

	/**
	 * Sets the swo number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwoNumber String 
	 */
	public void setSwoNumber(String newSwoNumber) {
		swoNumber = newSwoNumber;
	}
	
	/**
	 * Sets the data in a single method call. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSwoNumber
	 * @param newEEViewBeans
	 */
	public void setData(String newSwoNumber, Vector newEEViewBeans) {
		setSwoNumber(newSwoNumber);
		setEEViewBeans(newEEViewBeans);
	}
	
	/**
	 * Adds a new CompareTPEEViewBean to tbe already existing collection of CompareTPEEViewBean's.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eeViewBean CompateTPEEViewBean
	 */
	public void addEEViewBean(CompareTPEEViewBean eeViewBean){
		if(eeViewBeans == null)
			eeViewBeans = new Vector();
		eeViewBeans.addElement(eeViewBean);
	}
}
