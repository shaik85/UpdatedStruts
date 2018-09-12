/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * Holds complete data required for user info view  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class UserInfoViewBean extends OPPTViewBean {
	private String iUserId = null;
	private int iRole = 0;
	private int baRole = 0;
	private String userType = null;
	private String userTypDesc = null;
	private String iRoleDescription = null;
	private String iApprovedBy = null;
	private String iGroup = null;
	
	/**
	 * Returns approves by value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getApprovedBy() {
		return iApprovedBy;
	}

	/**
	 * Returns user's group value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getGroup() {
		return iGroup;
	}

	/**
	 * Returns user's role value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public int getRole() {
		return iRole;
	}

	/**
	 * Returns userId 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getUserId() {
		return iUserId;
	}

	/**
	 * Sets approved by value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newApprovedBy String 
	 */
	public void setApprovedBy(String newApprovedBy) {
		iApprovedBy = newApprovedBy;
	}

	/**
	 * Sets users group value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGroup String 
	 */
	public void setGroup(String newGroup) {
		iGroup = newGroup;
	}

	/**
	 * Sets users role 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newRole String 
	 */
	public void setRole(int newRole) {
		iRole = newRole;
	}

	/**
	 * Sets user id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newUserId Sering 
	 */
	public void setUserId(String newUserId) {
		iUserId = newUserId;
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
	 * date Feb 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getRoleDescription() {
		return iRoleDescription;
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
	 * date Feb 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setRoleDescription(String string) {
		iRoleDescription = string;
	}

	/**
	 * @return Returns the baRole.
	 */
	public int getBaRole() {
		return baRole;
	}
	/**
	 * @param lBaRole The baRole to set.
	 */
	public void setBaRole(int lBaRole) {
		baRole = lBaRole;
	}
	/**
	 * @return Returns the userType.
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param lUserType The userType to set.
	 */
	public void setUserType(String lUserType) {
		userType = lUserType;
	}
	
	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param userId
	 * @param role
	 * @param approvedBy
	 * @param group
	 */
	public void setData(String userId, int role, String approvedBy, String group,int barole,String userType){
		setUserId(userId);
		setRole(role);
		setApprovedBy(approvedBy);
		setGroup(group);
		setBaRole(barole);
		setUserType(userType);
	}

	/**
     * getUserIdValue
     * 
     * @param length
     * @return
     * @author thirumalai
     */
    public String getUserIdValue(int length){
		StringBuffer buffer = new StringBuffer();
		
		if(null != iUserId){
			char chars[] = iUserId.trim().toCharArray();
			for(int i=0, size=chars.length; i<size; i++){
				buffer.append(chars[i]);
				if(0 == (i+1)%length){
					if(size != (i+1)){
						buffer.append("<br />");  //$NON-NLS-1$
					}
				}
			}
		}
		
		return buffer.toString();
	}
	/**
	 * @return Returns the userTypDesc.
	 */
	public String getUserTypDesc() {
		return userTypDesc;
	}
	/**
	 * @param lUserTypDesc The userTypDesc to set.
	 */
	public void setUserTypDesc(String lUserTypDesc) {
		userTypDesc = lUserTypDesc;
	}
}
