/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

/**
 * Custom dto holds data about an user  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 1, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class UserCustomDTO extends OPPTCustomDTO 
{
	private String id = null;
	private String userId = null;
	private int role = 0;
	private String approvedBy = null;
	private String group = null;
	private String salesOrg = null;
	private String geoSecOff = null;
	/**
	 * Returns approved by user id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getApprovedBy() {
		return approvedBy;
	}

	/**
	 * Returns group  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Returns user identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns role of the user 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getRole() {
		return role;
	}

	/**
	 * Returns sales org of the user 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSalesOrg() {
		return salesOrg;
	}

	/**
	 * Returns user id of the user 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
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
	 * Sets approved by user value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newApprovedBy String 
	 */
	public void setApprovedBy(String newApprovedBy) {
		approvedBy = newApprovedBy;
	}

	/**
	 * Sets group value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGroup String 
	 */
	public void setGroup(String newGroup) {
		group = newGroup;
	}

	/**
	 * Sets user identifier value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newId String 
	 */
	public void setId(String newId) {
		id = newId;
	}

	/**
	 * Sets role of the user 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newRole int 
	 */
	public void setRole(int newRole) {
		role = newRole;
	}

	/**
	 * Sets sales org value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSalesOrg String 
	 */
	public void setSalesOrg(String newSalesOrg) {
		salesOrg = newSalesOrg;
	}

	/**
	 * Sets user id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
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
	 * @return Returns the geoSecOff.
	 */
	public String getGeoSecOff() {
		return geoSecOff;
	}
	/**
	 * @param geoSecOff The geoSecOff to set.
	 */
	public void setGeoSecOff(String geoSecOff) {
		this.geoSecOff = geoSecOff;
	}
	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param iid String
	 * @param iuserId String
	 * @param irole int
	 * @param iapprovedBy String
	 * @param igroup String
	 * @param isalesOrg String
	 */
	public void setData(String iid, String iuserId, int irole, 
						String iapprovedBy, String igroup, String isalesOrg){
		setId(iid);
		setUserId(iuserId);
		setRole(irole);
		setApprovedBy(iapprovedBy);
		setGroup(igroup);
		setSalesOrg(isalesOrg);
	}
}
