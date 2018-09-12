/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.utility;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Represents the calender for performing date validation in oppt. 
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
public class OPPTCalender extends GregorianCalendar {

    /**
     * getUtilDate
     * 
     * @param day
     * @param month
     * @param year
     * @return 
     */
    public Date getUtilDate(int day, int month, int year){
		set(year, month, day);
		return getTime();
	}

    /**
     * isValidDate
     * 
     * @param day
     * @param month
     * @param year
     * @return 
     */
	public boolean isValidDate(int day, int month, int year){
		boolean validDate = false;
		clear();
		set(year, month, day);
		
		if (day == get(GregorianCalendar.DATE) &&
			month == get(GregorianCalendar.MONTH) &&
			year == get(GregorianCalendar.YEAR)){
			validDate = true; 
		}
		return validDate;
	}

	
    /**
     * setDate
     * 
     * @param date
     */
	public void setDate(Date date){
		setTime(date);		
	}
	
    /**
     * getDay
     * 
     * @return
     */	
	public int getDay(){
		return get(OPPTCalender.DATE);
	}

    /**
     * getMonth
     * 
     * @return
     */	
	public int getMonth(){
		return get(OPPTCalender.MONTH);
	}
	
	
    /**
     * getYear
     * 
     * @return
     */
	public int getYear(){
		return get(OPPTCalender.YEAR);
	}
	
    /**
     * getDateString
     * 
     * @param date
     * @return
     */
	public String getDateString(Date date){
		setTime(date);
		return getYear()+"-"+getMonth()+"-"+getDay();
	}
}