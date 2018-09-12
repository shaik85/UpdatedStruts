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

public class BARoleBDO {
	
	private String role;
	
	private String roleDescription;
	
	/**
	 * Get base agreement user role 
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
	 * @return Returns the role.
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * Set base agreement user role 
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
	 * @param lRole The role to set.
	 */
	public void setRole(String lRole) {
		role = lRole;
	}
	
	/**
	 * Get base agreement user role 
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
	 * @return Returns the roleDescription.
	 */
	public String getRoleDescription() {
		return roleDescription;
	}
	
	/**
	 * Set base agreement user role description 
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
	 * @param lRoleDescription The roleDescription to set.
	 */
	public void setRoleDescription(String lRoleDescription) {
		roleDescription = lRoleDescription;
	}
	
}
