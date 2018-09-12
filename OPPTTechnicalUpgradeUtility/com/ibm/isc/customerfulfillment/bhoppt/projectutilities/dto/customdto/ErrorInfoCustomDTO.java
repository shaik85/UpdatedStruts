/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Custom dto that holds details about an ee  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 7, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */

public class ErrorInfoCustomDTO extends OPPTCustomDTO {
	private Integer id = null;
	private double messageNumber = 0;
	private String messageDescription = null;
	private String userId = null;
	private Date date = null;
	private Time time = null;
	private ArrayList errorDetails = null;
	
	/**
	 * Returns date on which an error occured 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	
	public Date getDate() {
		return date;
	}

	/**
	 * Returns collection of error details for this error. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ArrayList
	 */
	public ArrayList getErrorDetails() {
		return errorDetails;
	}

	/**
	 * Returns error identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Integer
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Returns message description of the error 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getMessageDescription() {
		return messageDescription;
	}

	/**
	 * Returns the message number of the error 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return double
	 */
	public double getMessageNumber() {
		return messageNumber;
	}

	/**
	 * Returns the user id involved in the error 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * Returns the time at which the error occured  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Time
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * Sets the date on which the error occured 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDate 
	 */
	public void setDate(Date newDate) {
		date = newDate;
	}
	
	/**
	 * Sets time at which the error occured
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newTime 
	 */
	public void setTime(Time newTime) {
		time = newTime;
	}

	/**
	 * Sets the collection of error details for the error 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newErrorDetails  
	 */
	public void setErrorDetails(ArrayList newErrorDetails) {
		errorDetails = newErrorDetails;
	}

	/**
	 * Sets the error identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newId 
	 */
	public void setId(Integer newId) {
		id = newId;
	}

	/**
	 * Sets the message description value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMessageDescription 
	 */
	public void setMessageDescription(String newMessageDescription) {
		messageDescription = newMessageDescription;
	}

	/**
	 * Sets message number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMessageNumber 
	 */
	public void setMessageNumber(double newMessageNumber) {
		messageNumber = newMessageNumber;
	}

	/**
	 * Sets user id involved in the error 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newUserId 
	 */
	public void setUserId(String newUserId) {
		userId = newUserId;
	}

	/**
	 * Adds a new error detail entry to the collection of error details for the error.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorDetail 
	 */
	public void addErrorDetails(ErrorDetailsCustomDTO errorDetail){
		if(null != errorDetail){
			if(null == errorDetails){
				errorDetails = new ArrayList();
			}
			errorDetails.add(errorDetail);
		}
	}
}
