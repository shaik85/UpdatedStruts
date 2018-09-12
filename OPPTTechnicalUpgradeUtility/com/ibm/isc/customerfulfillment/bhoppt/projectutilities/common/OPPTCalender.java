/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common;

import java.util.*;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * Represents the calender for performing date validation in oppt. 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 25, 2003 
 * 
 * 
 * revision date Dec 23, 2003
 * Author: Muruganantham
 * Reason: Added new methods for Date Greater, Lesser and Months Between.
 * 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class OPPTCalender extends GregorianCalendar {
	/**
	 * treemap is static 
	 */
	public static TreeMap monthMap = null; /* NOI18N */
	
	public static int role = 0;

	/**
	 * it's calls the opptcalender of superclass constructor
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 */
	public OPPTCalender() {
		super();
		if(null == monthMap) {
			loadMonthMap();
		}
		setLenient(false);
	}
	
	/**
	 * loadMonthMap
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 */
	
	public static void loadMonthMap() {
		monthMap = new TreeMap();		
		monthMap.put("01","Jan");  /* NOI18N */
		monthMap.put("02","Feb");   /* NOI18N */
		monthMap.put("03","Mar");   /* NOI18N */
		monthMap.put("04","Apr");   /* NOI18N */
		monthMap.put("05","May");   /* NOI18N */
		monthMap.put("06","Jun");   /* NOI18N */
		monthMap.put("07","Jul");   /* NOI18N */
		monthMap.put("08","Aug");   /* NOI18N */
		monthMap.put("09","Sep");   /* NOI18N */
		monthMap.put("10","Oct");   /* NOI18N */
		monthMap.put("11","Nov");   /* NOI18N */
		monthMap.put("12","Dec");   /* NOI18N */		
	}
	
	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param month
	 * @return string
	 */
	
	public static String getMonthDesc(String month) { 
	    if(monthMap == null) {
	        loadMonthMap();
	    }
		return (String)monthMap.get(month);
	}
	
	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return Date
	 */
	
	public Date getUtilDate(int day, int month, int year) {
		set(year, month - 1, day, 0, 0, 0);
		return getTime();
	}
	
	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *  
	 * @return date
	 */

	public Date getUtilDate() {
		set(get(YEAR), get(MONTH), get(DATE), 0, 0, 0);
		return getTime();
	}

	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return boolean
	 */
	
	public boolean isValidDate(int day, int month, int year) {
		boolean validDate = false;
		try {
			set(year, month - 1, day);
			if(day > getActualMaximum(Calendar.DATE)) {
				validDate = false;
			}else {
				validDate = true;
			}
		} catch (Exception e) {
			validDate = false;
		}
		return validDate;
	}

	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param currentDate
	 * @param propDate
	 * @return boolean
	 */
	
	public boolean isDateEqual(Date currentDate, Date propDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(propDate);

		setTime(currentDate);

		return (
			get(YEAR) == calendar.get(YEAR)
				&& get(MONTH) == calendar.get(MONTH)
				&& get(DAY_OF_MONTH) == calendar.get(DAY_OF_MONTH));
	}

	/**
     * To get the log string
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 28, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return boolean
     * @param propDate 
     */
	public boolean isDateEqual(Date propDate) {
		return isDateEqual(Calendar.getInstance().getTime(), propDate);
	}

	/**
	 * This method tells if currentDate is greater than propDate
	 * eg currentDate = 01/01/2004, propDate = 01/01/2003  this method 
	 * returns true
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param currentDate
	 * @param propDate
	 * @return boolean 
	 */
	public boolean isDateGreater(Date currentDate, Date propDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(propDate);

		setTime(currentDate);

		boolean isGreater = false;

		if (get(YEAR) > calendar.get(YEAR)) {
			isGreater = true;
		} else if (get(YEAR) == calendar.get(YEAR)) {
			if (get(MONTH) > calendar.get(MONTH)) {
				isGreater = true;
			} else if (get(MONTH) == calendar.get(MONTH)) {
				if (get(DAY_OF_MONTH) > calendar.get(DAY_OF_MONTH)) {
					isGreater = true;
				}
			}
		}

		return isGreater;
	}
	/**
     * To get the log string
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 28, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return boolean
     * @param propDate 
     */
	public boolean isDateGreater(Date propDate) {
		return isDateGreater(Calendar.getInstance().getTime(), propDate);
	}

	/**
	 * This method tells if currentDate is lesser than propDate
	 * eg currentDate =01/01/2003  , propDate = 01/01/2004 this method 
	 * returns true
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param currentDate
	 * @param propDate
	 * @return boolean 
	 */

	public boolean isDateLesser(Date currentDate, Date propDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(propDate);

		setTime(currentDate);

		boolean isLesser = false;

		if (get(YEAR) < calendar.get(YEAR)) {
			isLesser = true;
		} else if (get(YEAR) == calendar.get(YEAR)) {
			if (get(MONTH) < calendar.get(MONTH)) {
				isLesser = true;
			} else if (get(MONTH) == calendar.get(MONTH)) {
				if (get(DAY_OF_MONTH) < calendar.get(DAY_OF_MONTH)) {
					isLesser = true;
				}
			}
		}

		return isLesser;
	}

	/**
     * To get the log string
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 28, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return boolean
     * @param propDate 
     */
	
	public boolean isDateLesser(Date propDate) {
		return isDateLesser(Calendar.getInstance().getTime(), propDate);
	}

	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date
	 * @return integer
	 */
	public int getYear(Date date) {
		setTime(date);

		return get(YEAR);
	}

	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date
	 * @return integer
	 */
	public int getMonth(Date date) {
		setTime(date);

		return get(MONTH) + 1;
	}
	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date
	 * @return integer
	 */
	
	public int getDay(Date date) {
		setTime(date);

		return get(DATE);
	}

	/*
	 * Used in proposalcontractDAO for getting SQL
	 */
	
	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date
	 * @return String
	 */
	
	public String getDateString(Date date) {
		StringBuffer buffer = new StringBuffer();

		if (null != date) {
			setTime(date);
				
			buffer.append(getYear());
			buffer.append("-");  /* NOI18N */
			if (10 > getMonth()) {
				buffer.append("0");  /* NOI18N */
			}
			buffer.append(getMonth());
			buffer.append("-");  /* NOI18N */
			if (10 > getDay()) {
				buffer.append("0");  /* NOI18N */
			}
			buffer.append(getDay());

		}

		return buffer.toString();
	}

	/*
	 * Used for Display
	 */
	
	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date
	 * @param display
	 * @return String
	 */
	
	public String getDateString(Date date,boolean display) {
		StringBuffer buffer = new StringBuffer();

		if (null != date) {
			setTime(date);
			String monthKey ="";  /* NOI18N */
			if (10 > getDay()) {
				buffer.append("0");  /* NOI18N */
			}
			buffer.append(getDay());
			buffer.append("-");  /* NOI18N */
			if (10 > getMonth()) {
				monthKey = "0";  /* NOI18N */				
			}
			monthKey = monthKey + getMonth();
			buffer.append(monthMap.get(monthKey));
			buffer.append("-");  /* NOI18N */
			
			buffer.append(getYear());		

		}

		return buffer.toString();
	}
	
	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date
	 * @param display
	 * @return String
	 */
	public String getDateStringASMMDDYYYY(Date date) {
		StringBuffer buffer = new StringBuffer();

		if (null != date) {
			setTime(date);
			
			if (10 > getMonth()) {
				buffer.append("0");  /* NOI18N */
			}
			buffer.append(getMonth());
			buffer.append("/");  /* NOI18N */
			if (10 > getDay()) {
				buffer.append("0");  /* NOI18N */
			}
			buffer.append(getDay());
			buffer.append("/");  /* NOI18N */
			buffer.append(getYear());
		}

		return buffer.toString();
	}
	
	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	  
	 * @return integer
	 */
	
	public int getDay() {
		return get(DATE);
	}
	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *  
	 * @return integer
	 */
	
	public int getMonth() {
		return get(MONTH) + 1;
	}

	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *  
	 * @return integer
	 */
	
	public int getYear() {
		return get(YEAR);
	}

	/**
	 * Sets date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date
	 */
	
	public void setDate(Date date) {
		setTime(date);
	}
	/**
	 * To get the MonthsBetween integer 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param startDate
	 * @param endDate
	 * @return integer
	 */
	
	
	public int getMonthsBetween(Date startDate, Date endDate) {
		Calendar two = Calendar.getInstance();

		setTime(startDate);
		two.setTime(endDate);

		return ((two.get(YEAR) - get(YEAR)) * 12 + (two.get(MONTH) - get(MONTH)));
	}

	/**
	 * add the date
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param field
	 * @param amount
	 * @param date
	 * @return date
	 */


	public static Date addDate(int field, int amount, Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.add(field, amount);

		return calendar.getTime();
	}
	/**
     * This method is used in Pricing
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 12, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return java.util.Date
     * @author balajiv
     * @param date 
     */
	public static java.sql.Date getDayMinusOneSqlDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		if (calendar.get(Calendar.DATE) == 1) {
			calendar.roll(Calendar.MONTH, false);
			if(calendar.get(Calendar.MONTH) == 11) {
				calendar.roll(Calendar.YEAR, false);
			}
		}
		calendar.roll(Calendar.DATE, false);
		java.sql.Date sqlDate = new java.sql.Date(calendar.getTime().getTime());
		return sqlDate;
	}
	/**
     * This method is used in Pricing
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 12, 2004
     * revision date author reason
     * </PRE><br>
     *
     * 
     * @return java.util.Date
     * @author balajiv
     * @param date 
     */
	public static java.sql.Date getDayPlusOneSqlDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		if (calendar.get(Calendar.DATE) == calendar.getActualMaximum(Calendar.DATE)) {
			calendar.roll(Calendar.MONTH, true);
			if(calendar.get(Calendar.MONTH) == 0) {
				calendar.roll(Calendar.YEAR, true);
			}
			calendar.set(Calendar.DATE,1);
		}else {
			calendar.roll(Calendar.DATE, true);
		}
		java.sql.Date sqlDate = new java.sql.Date(calendar.getTime().getTime());
		return sqlDate;
	}
	/**
     * This method gives us the number of months for which we do pricing.
     * This is not exactly number of months between pricing, this is number
     * of months in which pricing period is spread.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 5, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return int
     * @author balajiv
     * @param periodEndDate
     * @param periodStartDate 
     */

	public static int calculateContractPeriodDuration(Date periodStartDate, Date periodEndDate) {
		OPPTCalender cal = new OPPTCalender();
		int contractPeriodDuration =
			12 * (cal.getYear(periodEndDate) - cal.getYear(periodStartDate))
				+ cal.getMonth(periodEndDate)
				- cal.getMonth(periodStartDate)
				+ 1;
		return contractPeriodDuration;
	}

	/**
	 * To find out whether the day is first day of the given date's month 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date
	 * @return boolean
	 * @author Muruganantham Mani 
	 */
	public static boolean isFirstDayOfTheMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return (calendar.getActualMinimum(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * To find out whether the day is last day of the given date's month 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date
	 * @return
	 * @author Muruganantham Mani 
	 */
	public static boolean isLastDayOfTheMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return (calendar.getActualMaximum(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * To get the StartYearlist integer 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *  
	 * @return Arraylist
	 */


	public static ArrayList getStartYearList() {
		GregorianCalendar currentCal = new GregorianCalendar();
		currentCal.setTime(new Date());
		int currentYear = currentCal.get(Calendar.YEAR);

		ArrayList contractStartYearList = new ArrayList();
		if(role==RoleConstants.DATA_MIGRATOR){
			System.out.println("OPPTCalender.getStartYearList()in if of calender");
		contractStartYearList.add(String.valueOf((currentYear - 5)));
		for (int i = 0; i < 10; i++) {
			contractStartYearList.add(String.valueOf((currentYear -4 + i)));
		}
		}
		else
		{
			System.out.println("OPPTCalender.getStartYearList()in else of calender");
			contractStartYearList.add(String.valueOf((currentYear - 1)));
			for (int i = 0; i < 11; i++) {
				contractStartYearList.add(String.valueOf((currentYear + i)));
			}
		}
		return contractStartYearList;
	}

	/**
	 * To get the StartYearlist integer 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *  
	 * @return Arraylist
	 */
	
	public static ArrayList getEndYearList() {
		OPPTCustomDTO customDTO = new OPPTCustomDTO();
		
		GregorianCalendar currentCal = new GregorianCalendar();
		currentCal.setTime(new Date());
		int currentYear = currentCal.get(Calendar.YEAR);
		ArrayList contractEndYearList = new ArrayList();
		if(role==RoleConstants.DATA_MIGRATOR){
			System.out.println("OPPTCalender.getEndYearList()if of calender");
		contractEndYearList.add(String.valueOf((currentYear - 5)));
		for (int i = 0; i < 15; i++) {
			contractEndYearList.add(String.valueOf((currentYear- 4 + i)));
		}
			}
		else
		{	System.out.println("OPPTCalender.getEndYearList()else ofcalender");
			contractEndYearList.add(String.valueOf((currentYear - 1)));
			for (int i = 0; i < 16; i++) {
				contractEndYearList.add(String.valueOf((currentYear + i)));
			}
		}
		return contractEndYearList;
		
		
		
	}
	
	/**
	 * validDuration 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param duration
	 * @param startDate
	 * @param endDate
	 * @return boolean
	 */

	public static boolean validDuration(int duration, Date startDate, Date endDate) {
		boolean result = false;
		OPPTCalender cal = new OPPTCalender();
		OPPTCalender calStart = new OPPTCalender();
		calStart.setDate(startDate);
		OPPTCalender calEnd = new OPPTCalender();
		calEnd.setDate(endDate);

		int contractPeriodMonths = calculateContractPeriodDuration(startDate, endDate);

		if (contractPeriodMonths <= duration) {
			result = true;
		} else if (contractPeriodMonths == (duration + 1)) {
			// days can be diffrent start and end
			if ((calEnd.getDay(startDate) - calStart.getDay(endDate)) == 1) {
				result = true;
			}
		}

		return result;
	}
	
	/**
	 * rollMonth
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date
	 * @return java.sql.Date
	 */
	
	public static java.sql.Date rollMonth(Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		calendar.roll(Calendar.MONTH, true);
		if(calendar.get(Calendar.MONTH) == 0) {
			calendar.roll(Calendar.YEAR, true);
		}
		java.sql.Date sqlDate = new java.sql.Date(calendar.getTime().getTime());
	
		return sqlDate;
		
	}
	
	/**
	 * isDateGreaterInMonths
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param currentDate
	 * @param propDate
	 * @return boolean
	 */
	
	public boolean isDateGreaterInMonths(Date currentDate, Date propDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(propDate);

		setTime(currentDate);

		boolean isGreater = false;

		if (get(YEAR) > calendar.get(YEAR)) {
			isGreater = true;
		} else if (get(YEAR) == calendar.get(YEAR)) {
			if (get(MONTH) > calendar.get(MONTH)) {
				isGreater = true;
			} 
		}

		return isGreater;
	}
	
	/**
	 * convertToSQLDate
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date
	 * @return java.sql.Date
	 */
	
	
	public static java.sql.Date convertToSQLDate(java.util.Date date) {
		if (date != null) {
			return (new java.sql.Date(date.getTime()));
		}
		return null;	
	}
}
