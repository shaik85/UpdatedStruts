/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;

import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupUserCustomDTO;

/**
 * Holds information about a group user  
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
public class GroupUserDataBean extends OPPTDataBean {
	private String iGroupName = null;
	private String iSelectedUser = null;
	// users belonging to selected group
	private TreeMap iGroupUsers = null;
	// groups that the current user has access to 
	private TreeMap iUserGroups = null;
	private String iSelectedGroupName = null;

	/**
	 * Returns group name 
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
	public String getGroupName() {
		return iGroupName;
	}

	/**
	 * Returns collection of users for users group 
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
	public TreeMap getGroupUsers() {
		return iGroupUsers;
	}

	/**
	 * Returns selected user  
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
	public String getSelectedUser() {
		return iSelectedUser;
	}

	/**
	 * Sets group name  
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
	 * @param newGroupName String 
	 */
	public void setGroupName(String newGroupName) {
		iGroupName = newGroupName;
	}

	/**
	 * Sets group users collection 
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
	 * @param newGroupUsers TreeMap 
	 */
	public void setGroupUsers(TreeMap newGroupUsers) {
		iGroupUsers = newGroupUsers;
	}

	/**
	 * Sets selected users value 
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
	 * @param newSelectedUser String 
	 */
	public void setSelectedUser(String newSelectedUser) {
		iSelectedUser = newSelectedUser;
	}

	/**
     * Sets complete data in a single method call
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 25, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param groupName String
     * @param selectedUser String
     * @param groupUsers TreeMap
     * @param selectedGroupName
     * @param userGroups 
     */
	public void setData(String groupName, String selectedUser, TreeMap groupUsers, TreeMap userGroups,String selectedGroupName) {
		setGroupName(groupName);
		setSelectedUser(selectedUser);
		setGroupUsers(groupUsers);
		setUserGroups(userGroups);
		setSelectedGroupName(selectedGroupName);
	}
	/**
     * addGroupUser
     * 
     * @param groupUser
     * @author thirumalai
     */
    public void addGroupUser(String groupUser) {
		if (null != groupUser) {
			if (null == iGroupUsers) {
				iGroupUsers = new TreeMap();
			}
			iGroupUsers.put(groupUser, groupUser);
		}
	}

	public GroupUserDataBean() {
	}
	public GroupUserDataBean(String groupName, String selectedUser, TreeMap groupUsers, TreeMap userGroups,String selectedGroupName) {
		setData(groupName, selectedUser, groupUsers, userGroups,selectedGroupName);
	}
	public GroupUserDataBean(GroupUserCustomDTO customDTO) {
		if (null != customDTO) {
			setData(customDTO.getGroupName(), customDTO.getSelectedUser(), customDTO.getGroupUsers(), customDTO.getUserGroups(), customDTO.getSelectedGroupName());
		}
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
	 * date May 27, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public TreeMap getUserGroups() {
		return iUserGroups;
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
	 * date May 27, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setUserGroups(TreeMap map) {
		iUserGroups = map;

	}

	public String getSelectedGroupName() {
		if (null == iSelectedGroupName) {
			iSelectedGroupName = getGroupName();
		}
		return iSelectedGroupName;
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
	 * date Jun 6, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setSelectedGroupName(String string) {
		iSelectedGroupName = string;
	}
}
