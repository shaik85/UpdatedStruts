/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jun 14, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author thirumalai
 * @version 5.1A 
 */

public class UserTypeBDO {
	private String userType;
	
	private String userTypeDescription;
	
	/**
	 * Get User type 
	 *  
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Jun 14, 2006 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author thirumalai
	 * @version 5.1A 
	 * @return Returns the userType.
	 */
	public String getUserType() {
		return userType;
	}
	
	/**
	 * Set User type 
	 *  
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Jun 14, 2006 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author thirumalai
	 * @version 5.1A 
	 * @param lUserType    The userType to set.
	 */
	public void setUserType(String lUserType) {
		userType = lUserType;
	}
	
	/**
	 * Get User type description
	 *  
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Jun 14, 2006 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author thirumalai
	 * @version 5.1A 
	 * @return Returns the userTypeDescription.
	 */
	public String getUserTypeDescription() {
		return userTypeDescription;
	}
	
	/**
	 * Set User type description
	 *  
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Jun 14, 2006 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author thirumalai
	 * @version 5.1A
	 * @param lUserTypeDescription
	 *            The userTypeDescription to set.
	 */
	public void setUserTypeDescription(String lUserTypeDescription) {
		userTypeDescription = lUserTypeDescription;
	}
}
