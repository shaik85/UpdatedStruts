/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Custom dto that holds information about groups in a selected sales org.  
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
public class GroupsCustomDTO extends OPPTCustomDTO {
	private TreeMap salesAreas = null;
	private String selectedSalesArea = null;
	private ArrayList groups = null;

	/**
	 * Returns collection of groups available for the slected sales area 
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
	 * @return ArrayList
	 */
	public ArrayList getGroups() {
		return groups;
	}

	/**
	 * Returns collection of sales area and sales area description map collection 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
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
	 * Returns selected sales area 
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
	public String getSelectedSalesArea() {
		return selectedSalesArea;
	}

	/**
	 * Sets groups collection for selected sales area 
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
	public void setGroups(ArrayList newGroups) {
		groups = newGroups;
	}

	/**
	 * Sets sales area collection 
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
	 * Sets selected sales area value 
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
	 * @param newSelectedSalesArea 
	 */
	public void setSelectedSalesArea(String newSelectedSalesArea) {
		selectedSalesArea = newSelectedSalesArea;
	}

	/**
	 * Adds new group to the collection of groups available for the selected sales org  
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
	 * @param group 
	 */
	public void addGroup(GroupCustomDTO group){
		if(null != group){
			if(null == groups){
				groups = new ArrayList();
			}
			groups.add(group);
		}
	}
	
	/**
	 * Adds new sales area and description map to the collection of already existing maps.  
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
	 * Sets complete data in a single method call  
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
	 * @param asalesAreas 
	 * @param aselectedSalesArea 
	 * @param agroups 
	 */
	public void setData(TreeMap asalesAreas, String aselectedSalesArea, ArrayList agroups){
		setSalesAreas(asalesAreas);
		setSelectedSalesArea(aselectedSalesArea);
		setGroups(agroups);
	}
}
