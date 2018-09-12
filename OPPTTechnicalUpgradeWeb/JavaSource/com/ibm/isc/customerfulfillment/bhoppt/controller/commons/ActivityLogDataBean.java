
/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ActivityLogDataCustomDTO;

/**
 * Holds activity Log data 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date March 29th 2011
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Nomita
 *  
 */
public class ActivityLogDataBean extends OPPTDataBean{
	private String userId=null;
	private String message=null;
	private Date activityDate=null;
	private Date activityTime=null;
	
	
	/**
	 * 
	 * Returns the userId 
	 * Date:31st March 2011
	 * @return String
	 */
	
	public String getUserId() {
		return userId;
	}

	/**
	 * Returns the action performed
	 * Date: 31st March 2011
	 * @return String
	 */
	
	public String getMessage() {
		return message;
	}
	
	
	/**
	 * Returns modified on date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date mar 31 2011
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getActivityDate() {
		return activityDate;
			
	}
	
	
	public Date getActivityTime() {
		return activityTime;
	}
	/**Sets userId
	 * date 31st Mar 2011
	 * @param newuserid
	 */
	public void setUserId(String newUserId){
		userId=newUserId;
	}
	
	
	/**Sets action performed
	 * date 31st March 2011
	 * @param newactionperformed
	 */
	
	public void setMessage(String newMessage){
	message=newMessage;
	}
	
	/**
	 * Sets modified on date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date 31st march 2011
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newModifiedOn Date 
	 */
	public void setActivityDate(Date newActivityDate){
		activityDate = newActivityDate;
	}

	
	
	
	
	
	
	public void setActivityTime(Date newActivityTime){
		activityTime = newActivityTime;
	}
	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 24th 2010
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param operationPerformed String
	 * @param description String
	 * @param earlierContract String
	 * @param modifiedBy String
	 * @param modifiedOn Date
	 */
	public void setData(String userId,String message,Date ActivityDate, Date ActivityTime){
		setUserId(userId);
		setMessage(message);
		setActivityDate(activityDate);
		setActivityTime(activityTime);
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * 
     * revised by Nomita
     */
    public void setData(ActivityLogDataCustomDTO customDTO){
		if(null != customDTO){
			setUserId(customDTO.getUserId());
			setMessage(customDTO.getMessage());
			setActivityDate(customDTO.getActivityDate());
			setActivityTime(customDTO.getActivityTime());
			
		}
	}
	
	/**
     * ProposalHistoryDataBean
     * 
     * @author thirumalai
     * revised by Nomita
     */
    public ActivityLogDataBean(){
	}
	/**
     * ProposalHistoryDataBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public ActivityLogDataBean(ActivityLogDataCustomDTO customDTO){
		setData(customDTO);
	}
}
