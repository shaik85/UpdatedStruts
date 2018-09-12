/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Custom dto that holds data for creating an user  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 28, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class CreateUserCustomDTO extends OPPTCustomDTO 
{
	private TreeMap roles = null;
	private TreeMap salesAreas = null;
	private TreeMap managers = null;
	private TreeMap groups = null;
	private String  userId = null;
	private String  selectedRole = null;
	private String  primarySalesArea = null;
	private String  selectedManager = null;
	private TreeSet selectedGroups = null;
	private TreeSet groupsThatCannotBeDeleted = null;	
	private String  geoSecOfficer = null;
	private String  authorization = null;
	private TreeMap userTypes = null;
	private String selectedUserType = null;
	private TreeMap baRoles = null;
	private String selectedBaRole = null;
	
	/**
	 * Returns collection of groups available for selected sales org 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return HashMap
	 */
	public TreeMap getGroups() {
		return groups;
	}

	/**
	 * Sets collection of managers 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return HashMap
	 */
	public TreeMap getManagers() {
		return managers;
	}

	/**
	 * Returns primary sales org which is the selected sales org 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPrimarySalesArea() {
		return primarySalesArea;
	}

	/**
	 * Returns primary sales org authorization value  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPrimarySalesAreaAuthorization()
	{
		return authorization;
	}
	/**
	 * Returns the collection of roles available 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return HashMap
	 */
	public TreeMap getRoles() {
		return roles;
	}

	/**
	 * Returns the collection of sales areas 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return HashMap
	 */
	public TreeMap getSalesAreas() {
		return salesAreas;
	}

	/** 
	 * Returns selected group
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public TreeSet getSelectedGroups() {
		return selectedGroups;
	}

	/**
	 * Returns selected manager value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedManager() {
		return selectedManager;
	}

	/**
	 * Returns selected role value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedRole() {
		return selectedRole;
	}
	/**
	 * Returns geoSecOfficer value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getGeoSecOfficer() 
	{
		return geoSecOfficer;
	}
	/**
	 * Returns user id value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
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
	 * Sets groups collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGroups 
	 */
	public void setGroups(TreeMap newGroups) {
		groups = newGroups;
	}

	/**
	 * Sets manager collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newManagers 
	 */
	public void setManagers(TreeMap newManagers) {
		managers = newManagers;
	}

	/**
	 * Sets primary sales area value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPrimarySalesArea  
	 */
	public void setPrimarySalesArea(String newPrimarySalesArea) {
		primarySalesArea = newPrimarySalesArea;
	}
	/**
	 * Sets primary sales area authorization  value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPrimarySalesAreaAuthorization 
	 */
	public void setPrimarySalesAreaAuthorization(String newPrimarySalesAreaAuthorization) {
		authorization = newPrimarySalesAreaAuthorization;
	}
	/**
	 * Sets roles collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newRoles 
	 */
	public void setRoles(TreeMap newRoles) {
		roles = newRoles;
	}

	/**
	 * Sets sales areas collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSalesAreas 
	 */
	public void setSalesAreas(TreeMap newSalesAreas) {
		salesAreas = newSalesAreas;
	}

	/**
	 * Sets selected group value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedGroups 
	 */
	public void setSelectedGroups(TreeSet newSelectedGroups) {
		selectedGroups = newSelectedGroups;
	}

	/**
	 * Sets selected manager value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedManager 
	 */
	public void setSelectedManager(String newSelectedManager) {
		selectedManager = newSelectedManager;
	}

	/**
	 * Sets selected role value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedRole 
	 */
	public void setSelectedRole(String newSelectedRole) {
		selectedRole = newSelectedRole;
	}

	/**
	 * Sets user id value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newUserId 
	 */
	public void setUserId(String newUserId) {
		userId = newUserId;
	}
	/**
	 * Sets GeoSecOfficer value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGeoSecOfficer
	 */
	public void setGeoSecOfficer(String newGeoSecOfficer) {
		geoSecOfficer = newGeoSecOfficer;
	}
	/**
	 * Adds new role to the collection of roles available  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param id 
	 * @param description 
	 */
	public void addRole(String id, String description){
		if(null != id && null != description){
			if(null == roles){
				roles = new TreeMap();
			}
			roles.put(id, description);
		}
	}

	/**
	 * Adds new sales area to the collection of sales areas available  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param id 
	 * @param description 
	 */
	public void addSalesArea(String id, String description){
		if(null != id && null != description){
			if(null == salesAreas){
				salesAreas = new TreeMap();
			}
			salesAreas.put(id, description);
		}
	}

	/**
	 * Adds new manager to the collection of managers available  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param id 
	 * @param description 
	 */
	public void addManager(String id, String description){
		if(null != id && null != description){
			if(null == managers){
				managers = new TreeMap();
			}
			managers.put(id, description);
		}
	}

	/**
	 * Adds new group to the collection of groups available  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param id 
	 * @param description 
	 */
	public void addGroup(String id, String description){
		if(null != id && null != description){
			if(null == groups){
				groups = new TreeMap();
			}
			groups.put(id, description);
		}
	}

	/**
     * Sets complete data in a single method call
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 28, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param iroles
     * @param isalesAreas
     * @param imanagers
     * @param igroups
     * @param iuserId
     * @param iselectedRole
     * @param iprimarySalesArea
     * @param iselectedManager
     * @param iselectedGroups 
     * @param userTypes
     * @param selectedUserType
     * @param baRoles
     * @param selectedBaRole
     */
	public void setData(TreeMap iroles, TreeMap isalesAreas, TreeMap imanagers, 
						TreeMap igroups, String iuserId, String iselectedRole, 
						String iprimarySalesArea, String iselectedManager, TreeSet iselectedGroups,
						TreeMap userTypes, String selectedUserType,TreeMap baRoles,String selectedBARole){
		setRoles(iroles);
		setSalesAreas(isalesAreas);
		setManagers(imanagers);
		setGroups(igroups);
		setUserId(iuserId);
		setSelectedRole(iselectedRole);
		setPrimarySalesArea(iprimarySalesArea);
		setSelectedManager(iselectedManager);
		setSelectedGroups(iselectedGroups);
		setUserTypes(userTypes);
		setSelectedUserType(selectedUserType);
		setBaRoles(baRoles);
		setSelectedBaRole(selectedBARole);
		
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
	 * date Jun 15, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeSet
	 */
	public TreeSet getGroupsThatCannotBeDeleted() {
		return groupsThatCannotBeDeleted;
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
	 * date Jun 15, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param set 
	 */
	public void setGroupsThatCannotBeDeleted(TreeSet set) {
		groupsThatCannotBeDeleted = set;
	}

    /**
     * return the authorization 
     *
     * @return Returns the authorization.
     */
    public String getAuthorization() {
        return authorization;
    }
    /**
     * sets the authorization
     *
     * @param lAuthorization The authorization to set.
     */
    public void setAuthorization(String lAuthorization) {
        authorization = lAuthorization;
    }
	/**
	 * @return Returns the baRoles.
	 */
	public TreeMap getBaRoles() {
		return baRoles;
	}
	/**
	 * @param lBaRoles The baRoles to set.
	 */
	public void setBaRoles(TreeMap lBaRoles) {
		baRoles = lBaRoles;
	}
	/**
	 * @return Returns the selectedBaRoles.
	 */
	public String getSelectedBaRole() {
		return selectedBaRole;
	}
	/**
	 * @param lSelectedBaRoles The selectedBaRoles to set.
	 */
	public void setSelectedBaRole(String lSelectedBaRole) {
		selectedBaRole = lSelectedBaRole;
	}
	/**
	 * @return Returns the selectedUserType.
	 */
	public String getSelectedUserType() {
		return selectedUserType;
	}
	/**
	 * @param lSelectedUserType The selectedUserType to set.
	 */
	public void setSelectedUserType(String lSelectedUserType) {
		selectedUserType = lSelectedUserType;
	}
	/**
	 * @return Returns the userTypes.
	 */
	public TreeMap getUserTypes() {
		return userTypes;
	}
	/**
	 * @param lUserTypes The userTypes to set.
	 */
	public void setUserTypes(TreeMap lUserTypes) {
		userTypes = lUserTypes;
	}
}
