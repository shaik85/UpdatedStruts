/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.DateDataBean;

public class InventoryDateRangeActionForm extends OPPTActionForm {
	private DateDataBean fromDate = null;
	private DateDataBean toDate = null;

	/**
	 * Returns from date value object 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DateDataBean
	 */
	public DateDataBean getFromDate() {
		if(null == fromDate){
			fromDate = new DateDataBean();
		}
		return fromDate;
	}

	/**
	 * Returns to date data object 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DateDataBean
	 */
	public DateDataBean getToDate() {
		if(null == toDate){
			toDate = new DateDataBean();
		}
		return toDate;
	}

	/**
	 * Set from date data  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newFromDate DateDataBean 
	 */
	public void setFromDate(DateDataBean newFromDate) {
		fromDate = newFromDate;
	}

	/**
	 * Sets new to date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newToDate DateDataBean 
	 */
	public void setToDate(DateDataBean newToDate) {
		toDate = newToDate;
	}

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#reset()
	 */
	public void reset(){
		fromDate = null;
		toDate = null;
	}
}
