package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;
/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */


import java.util.ArrayList;


/**
 * Custom dto that holds access information about geo sec officer
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Nomita
 * @version 5.1A
 */
public class ActivityLogCustomDTO extends OPPTCustomDTO
{
	private UserCustomDTO userDTO = null;
	private ArrayList activityLog = null;

	/**
	 * Returns activity log collection values. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 *  
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ArrayList
	 */
	public ArrayList getActivityLog() {
		return activityLog;
	}

	public UserCustomDTO getUserDTO() {
		return userDTO;
	}


	/**
	 * Sets activityLog  details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 *  
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newActivityLog ArrayList 
	 */
	public void setActivityLog(ArrayList newActivityLog) {
		activityLog = newActivityLog;
	}
	public void setUserDTO(UserCustomDTO newUserDTO) {
		userDTO = newUserDTO;
	}
	
	/**
	 * Adds a new ActivityLogDataCustomDTO to the collection of activity log objects   
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newActivityLog ActivityLogDataCustomDTO
	 */
	public void addActivityLog(ActivityLogDataCustomDTO newActivityLog){
		if(null != newActivityLog){
			if(null == activityLog){
				activityLog = new ArrayList();
			}
			activityLog.add(newActivityLog);
		}
	} 
}
