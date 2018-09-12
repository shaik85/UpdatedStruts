/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector;

import java.util.Map;
import java.util.TreeMap;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Sep 24, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1x
 */
public class UserProfilesConnectorDTO {
	
	private Map userProfiles = null;

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
	 * date Sep 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public Map getUserProfiles() {
		if(null == userProfiles){
			userProfiles = new TreeMap();
		}
		return userProfiles;
	}

	/**
     * Enter one sentence as a brief description for this method.
     * You can enter more text here. Please think of
     * - visibility decision
     * - changes that are made to objects, which are passed as parameters
     * - concurrency issues
     * - examples how to invoke this methods
     * - preconditions that this method relies on
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Sep 30, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param map
     * @param newUserProfiles 
     */
	public void setUserProfiles(Map newUserProfiles) {
		userProfiles = newUserProfiles;
	}
	/**
	 * adding users
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Sep 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param userID
	 */
	public void addUser(String userID){
		if(null != userID){
			getUserProfiles().put(userID, null);
		}
	}
	/**
	 * getUserProfile
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Sep 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param userID
	 * @return UserProfileConnectorDTO
	 */
	public UserProfileConnectorDTO getUserProfile(String userID){
		UserProfileConnectorDTO connectorDTO = null;
		if(null != userID){
			connectorDTO = (UserProfileConnectorDTO)getUserProfiles().get(userID);
		}
		return connectorDTO;
	}
}