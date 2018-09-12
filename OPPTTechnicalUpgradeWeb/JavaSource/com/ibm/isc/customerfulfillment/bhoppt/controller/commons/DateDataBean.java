/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;

import java.util.Date;


import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;

/**
 * Used as date object in the action forms. In the action forms we can have string values only.
 * So for representing date object with day, month and year as seperate strings and working 
 * with the date object we will be using this object. 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 25, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class DateDataBean extends OPPTDataBean {
	private String day = "dd";  //$NON-NLS-1$
	private String month = "mm";  //$NON-NLS-1$
	private String year = "yyyy";  //$NON-NLS-1$

	/**
	 * Returns the day value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDay() {
		return day;
	}

	/**
	 * Returns month value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * Returns year value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Sets day value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDay String 
	 */
	public void setDay(String newDay) {
		day = newDay;
	}

	/**
	 * Sets month value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMonth String 
	 */
	public void setMonth(String newMonth) {
		month = newMonth;
	}

	/**
	 * Sets year value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newYear String 
	 */
	public void setYear(String newYear) {
		year = newYear;
	}

	/**
	 * Checks whether the resulting date object is a valid date or not.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isValidDate(){
		boolean validDate = false;
		
		int dayValue = -1;
		int monthValue = -1;
		int yearValue = -1;
		try{
			dayValue = Integer.parseInt(getDay());
			monthValue = Integer.parseInt(getMonth());
			yearValue = Integer.parseInt(getYear());
			OPPTCalender calender = new OPPTCalender();
			validDate = calender.isValidDate(dayValue, monthValue, yearValue);
			validDate = true;
		}
		catch(NumberFormatException nfe){
			validDate = false;
		}
		
		return validDate;
	}
	
	/**
	 * Returns the java.util.Date object. Date object will be returned only if it is valid. If 
	 * not valid it returns null.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getDate(){
		Date date = null;
		
		int dayValue = -1;
		int monthValue = -1;
		int yearValue = -1;
		try{
			dayValue = Integer.parseInt(getDay());
			monthValue = Integer.parseInt(getMonth());
			yearValue = Integer.parseInt(getYear());
			OPPTCalender calender = new OPPTCalender();
			if(calender.isValidDate(dayValue, monthValue, yearValue)){
				date = calender.getUtilDate(dayValue, monthValue, yearValue);
			}
		}
		catch(Exception nfe){
			date = null;
		}
		
		return date;
	}
	
	/** 
	 * Overridden method - Returns the date representation 
	 * 
	 * <br/><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see java.lang.Object#toString() 
	 * @return String
	 * 
	 */
	public String toString() {
		return getDay()+"-"+getMonth()+"-"+getYear();  //$NON-NLS-1$  //$NON-NLS-2$
	}
	
	/**
     * DateDataBean
     * 
     * @author thirumalai
     */
    public DateDataBean(){
	}
	/**
     * DateDataBean
     * 
     * @param newDate
     * @author thirumalai
     */
    public DateDataBean(Date newDate){
		if(null != newDate){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(newDate);
			
			if(9 >= calender.getDay()){
				day = "0"+calender.getDay();  //$NON-NLS-1$
			}
			else{
				day = calender.getDay()+"";  //$NON-NLS-1$
			}
			if(9 >= calender.getMonth()){
				month = "0"+calender.getMonth();  //$NON-NLS-1$
			}
			else{
				month = calender.getMonth()+"";  //$NON-NLS-1$
			}
			year = calender.getYear()+"";  //$NON-NLS-1$
		}
	}
	
	/**
     * equals
     * 
     * @param newDate
     * @return
     * @author thirumalai
     */
    public boolean equals(DateDataBean newDate){
		boolean equal = true;
		if(null != newDate){
			if(!day.equalsIgnoreCase(newDate.getDay())){
				equal = false;
			}
			else if(!month.equalsIgnoreCase(newDate.getMonth())){
				equal = false;
			}
			else if(!year.equalsIgnoreCase(newDate.getYear())){
				equal = false;
			}
		}
		else{
			equal = false;
		}
		return equal;
	}
}