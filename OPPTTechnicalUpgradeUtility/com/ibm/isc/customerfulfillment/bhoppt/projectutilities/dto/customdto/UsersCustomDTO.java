/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.TreeMap;

/**
 * Custom dto that holds complete information about users in a sales area.  
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
public class UsersCustomDTO extends OPPTCustomDTO {
	private TreeMap salesAreas = null;
	private String selectedSalesArea = null;
	private TreeMap users = null;
	
	/**
	 * Returns sales area collection 
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
	 * @return TreeMap
	 */
	public TreeMap getSalesAreas() {
		return salesAreas;
	}

	/**
	 * Returns selected sales area value 
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
	public String getSelectedSalesArea() {
		return selectedSalesArea;
	}

	/**
	 * Returns collection of users for selected sales area 
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
	 * @return TreeMap
	 */
	public TreeMap getUsers() {
		return users;
	}

	/**
	 * Sets sales areas collection 
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
	 * @param newSalesAreas TreeMap 
	 */
	public void setSalesAreas(TreeMap newSalesAreas) {
		salesAreas = newSalesAreas;
	}

	/**
	 * Sets selected sales area value 
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
	 * @param newSelectedSalesArea String 
	 */
	public void setSelectedSalesArea(String newSelectedSalesArea) {
		selectedSalesArea = newSelectedSalesArea;
	}

	/**
	 * Sets users in selected sales area 
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
	 * @param newUsers TreeMap 
	 */
	public void setUsers(TreeMap newUsers) {
		users = newUsers;
	}

	/**
	 * Adds sales area to the collection of sales areas  
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
	 * @param id String
	 * @param description String
	 */
	public void addSalesArea(String id, String description){
		if(null != id &&  null != description){
			if(null == salesAreas){
				salesAreas = new TreeMap();
			}
			salesAreas.put(id, description);
		}
	}
	
	/**
	 * Adds new user to collection of users for selected sales area  
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
	 * @param user UserCustomDTO
	 */
	public void addUser(UserCustomDTO user){
		if(null != user){
			if(null == users){
				users = new TreeMap();
			}
			users.put(user.getUserId(),user);
		}
	}
	
	/**
	 * sets complete data in a single method call  
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
	 * @param isalesAreas TreeMap
	 * @param iselectedSalesArea String
	 * @param iusers TreeMap
	 */
	public void setData(TreeMap isalesAreas, String iselectedSalesArea, TreeMap iusers){
		setSalesAreas(isalesAreas);
		setSelectedSalesArea(iselectedSalesArea);
		setUsers(iusers);
	}
}
