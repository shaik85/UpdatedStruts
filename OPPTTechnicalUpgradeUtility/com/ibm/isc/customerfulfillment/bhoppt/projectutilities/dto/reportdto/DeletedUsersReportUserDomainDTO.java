/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto;

import java.sql.Timestamp;
import java.util.Map;
import java.util.TreeMap;


import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.OPPTDomainDTO;

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
 * @author Vinod Kumar Burugupalli
 * @version 5.1x
 */
public class DeletedUsersReportUserDomainDTO extends OPPTDomainDTO {
	private String userID = null;
	private String deletedAdminEmail = null;
   private String userType = null;
	private String firstName = null;
	private String lastName = null;
	private String role = null;
    private String groupName = null; 
	private String primarySalesOrg = null;
	private String primaryAccessType = null;
	private Timestamp deletedDate = null;
	private Map users = null;
	
	
	
		
	/**
	 * @return Returns the deletedAdminEmail.
	 */
	public String getDeletedAdminEmail() {
		return deletedAdminEmail;
	}
	/**
	 * @param deletedAdminEmail The deletedAdminEmail to set.
	 */
	public void setDeletedAdminEmail(String deletedAdminEmail) {
		this.deletedAdminEmail = deletedAdminEmail;
	}
	/**
	 * @return Returns the deletedDate.
	 */
	public Timestamp getDeletedDate() {
		return deletedDate;
	}
	/**
	 * @param deletedDate The deletedDate to set.
	 */
	public void setDeletedDate(Timestamp deletedDate) {
		this.deletedDate = deletedDate;
	}
	/**
	 * @return Returns the firstName.
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName The firstName to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return Returns the groupName.
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param groupName The groupName to set.
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * @return Returns the lastName.
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName The lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return Returns the primaryAccessType.
	 */
	public String getPrimaryAccessType() {
		return primaryAccessType;
	}
	/**
	 * @param primaryAccessType The primaryAccessType to set.
	 */
	public void setPrimaryAccessType(String primaryAccessType) {
		this.primaryAccessType = primaryAccessType;
	}
	/**
	 * @return Returns the primarySalesOrg.
	 */
	public String getPrimarySalesOrg() {
		return primarySalesOrg;
	}
	/**
	 * @param primarySalesOrg The primarySalesOrg to set.
	 */
	public void setPrimarySalesOrg(String primarySalesOrg) {
		this.primarySalesOrg = primarySalesOrg;
	}
	/**
	 * @return Returns the role.
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role The role to set.
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return Returns the userID.
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * @param userID The userID to set.
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
/**
 * @return Returns the userType.
 */
public String getUserType() {
	return userType;
}
/**
 * @param userType The userType to set.
 */
public void setUserType(String userType) {
	this.userType = userType;
}
	/**
	 * @return Returns the users.
	 */
public Map getUsers() {
	if(null == users){
		users = new TreeMap();
	}
	return users;
}
	/**
	 * @param users The users to set.
	 */
	public void setUsers(Map users) {
		this.users = users;
	}
}