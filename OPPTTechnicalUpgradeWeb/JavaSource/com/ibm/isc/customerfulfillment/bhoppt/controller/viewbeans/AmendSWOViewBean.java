/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.AmendSWOActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AmendSWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWODetailsCustomDTO;

/**
 * This class holds the information about amending an swo.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 14, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class AmendSWOViewBean extends OPPTViewBean{
	private Date defaultFromDate = null;
	private Date defaultToDate = null;
	private Date fromDate = null;
	private Date toDate = null;
	private ArrayList yearList=null;
	
	/**
     *  AmendSWOViewBean
     * 
     *  @author thirumalai
     */
    public AmendSWOViewBean(){
	}
	
	/**
     * AmendSWOViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public AmendSWOViewBean(SWOCustomDTO customDto){
		populateBean(customDto);
	}

	/**
	 * getDefaultFromDate
	 * 
	 * Returns the default start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getDefaultFromDate() {
		return defaultFromDate;
	}

	/**
	 * getDefaultToDate
	 * 
	 * Returns default end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getDefaultToDate() {
		return defaultToDate;
	}

	/**
	 * getFromDate
	 * 
	 * Returns the selected start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * getToDate
	 * 
	 * Returns the selected end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * setDefaultFromDate
	 * 
	 * Sets the date given as the default start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDefaultFromDate Date 
	 */
	public void setDefaultFromDate(Date newDefaultFromDate) {
		defaultFromDate = newDefaultFromDate;
	}

	/**
	 * Sets the date given as the default end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDefaultToDate Date 
	 */
	public void setDefaultToDate(Date newDefaultToDate) {
		defaultToDate = newDefaultToDate;
	}

	/** 
	 * Sets the date given as the selected start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newFromDate Date  
	 */
	public void setFromDate(Date newFromDate) {
		fromDate = newFromDate;
	}

	/**
	 * Sets the date given as the default end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newToDate Date 
	 */
	public void setToDate(Date newToDate) {
		toDate = newToDate;
	}
	
    /** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
		public ArrayList getYearList() {
			return yearList;
		}

		/** 
		 * Enter one sentence as a brief description for this method. 
		 * You can enter more text here. Please think of 
		 * - visibility decision 
		 * - changes that are made to objects, which are passed as parameters 
		 * - concurrency issues 
		 * - examples how to invoke this methods 
		 * - preconditions that this method relies on 
		 * 
		 * <br><b>Known Bugs</b><br> 
		 * 
		 * <br><PRE> 
		 * date Jan 30, 2004 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @param list 
		 */
		public void setYearList(ArrayList list) {
			yearList = list;
		}

	/**
	 * Sets complete data in a single method call.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param defaultFromDate Date
	 * @param defaultToDate Date
	 * @param fromDate Date
	 * @param toDate Date
	 */
	public void setData(Date defaultFromDate, Date defaultToDate, Date fromDate, Date toDate) {
		setDefaultFromDate(defaultFromDate);
		setDefaultToDate(defaultToDate);
		setFromDate(fromDate);
		setToDate(toDate);
	}

	/**
	 * populateBean
	 *   
	 * @param customDto
	 */	
	private void populateBean(SWOCustomDTO customDto){
		setDefaultFromDate(customDto.getPlanStartDate());
		setDefaultToDate(customDto.getPlanEndDate());
	}
	

}
