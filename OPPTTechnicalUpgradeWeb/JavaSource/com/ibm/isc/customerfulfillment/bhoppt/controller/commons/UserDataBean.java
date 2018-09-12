/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;

/**
 * This bean hold the primary user information like the userId, role and primary sales organization.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 14, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class UserDataBean extends OPPTDataBean
{
	private String userId = null;
	private String userType = null;
	private String primarySalesOrganization = null;

	/**
	 * Returns the primary saled organization of the user 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPrimarySalesOrganization() {
		return primarySalesOrganization;
	}

	/**
	 * Returns the role of the user 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * Returns the user id of the user 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
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
	 * Sets the string value passed as primary sales organization 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPrimarySalesOrganization String 
	 */
	public void setPrimarySalesOrganization(String newPrimarySalesOrganization) {
		primarySalesOrganization = newPrimarySalesOrganization;
	}

	/**
	 * Sets the string value passed as the role of the user 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newRole String 
	 */
	public void setUserType(String newUserType) {
		userType = newUserType;
	}

	/**
	 * Sets the string value passed as user id of the user 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newUserId String 
	 */
	public void setUserId(String newUserId) {
		userId = newUserId;
	}

	/**
	 * Sets complete information in a single calls  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param userId String
	 * @param role String
	 * @param primarySalesOrganization String
	 */
	public void setData(String userId, String userType, String primarySalesOrganization){
		setUserId(userId);
		setUserType(userType);
		setPrimarySalesOrganization(primarySalesOrganization);
	}
}
