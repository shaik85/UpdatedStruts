package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;
/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */


import java.util.Date;
import java.sql.Time;

/**
 * . 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 11 2011
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * Nomita
 * @version
 */
public class ActivityLogDataCustomDTO extends OPPTCustomDTO {
	
	private String userId = null;
	private String message = null;
	private Date activityDate = null;
	private Date activityTime = null;
	private UserCustomDTO userDTO = null;
	
	
	public UserCustomDTO getUserDTO() {
		return userDTO;
	}
	
	
	
	
		public String getUserId() {
		return userId;
	}

	public String getMessage() {
		return message;
	}
	
	public Date getActivityDate() {
		return activityDate;
	}
	public Date getActivityTime() {
		return activityTime;
	}
	
	
	
	
	
	
	
	public void  setUserId(String newUserId) {
		 userId=newUserId;
	}
	public void  setMessage(String newMessage) {
		 message=newMessage;
	}

		
	public void  setActivityDate(Date newActivityDate) {
		activityDate=newActivityDate;
	}
	
	public void  setActivityTime(Date newActivityTime) {
		activityTime=newActivityTime;
	}
		
	
	

	
	

	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @
	 */
	public void setData(String userId,String message,Date activityDate,Date activityTime){
		setUserId(userId);
		setMessage(message);
		setActivityDate(activityDate);
		setActivityTime(activityTime);
		
	}
	
	/**
	 * constructor
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 */
	
	public ActivityLogDataCustomDTO(){
	}
	
	/**
	 * 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ilockedBy String
	 * @param ilockedOn Date
	 */
	public ActivityLogDataCustomDTO(String userId,String message,Date activityDate,Date activityTime){
		setUserId(userId);
		setMessage(message);
		setActivityDate(activityDate);
		setActivityTime(activityTime);
	}
}
