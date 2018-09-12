/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Custom dto that holds data for creating and editing non bnusiness partner user.  
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
public class NonBPUserCustomDTO extends CreateUserCustomDTO {
	private TreeMap salesAreaAccessType = null;
	private String geoSecOff = null;
	/**
	 * Returns sales area and its access type combination collection 
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
	 * @return HashMap
	 */
	public TreeMap getSalesAreaAccessType() {
		return salesAreaAccessType;
	}

	/**
	 * Sets sales area ans its access type combination collection 
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
	 * @param newSalesAreaAccessType  
	 */
	public void setSalesAreaAccessType(TreeMap newSalesAreaAccessType) {
		salesAreaAccessType = newSalesAreaAccessType;
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
	 * Adds new sales area and access type combinatino value  
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
	 * @param salesArea 
	 * @param accessType 
	 */
	public void addSalesAreaAccessType(String salesArea, String accessType){
		if(null != salesArea && null != accessType){
			if(null != salesAreaAccessType){
				salesAreaAccessType = new TreeMap();
			}
			salesAreaAccessType.put(salesArea, accessType);
		}
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
	 * @param roles HashMap
	 * @param salesAreas HashMap
	 * @param managers HashMap
	 * @param groups HashMap
	 * @param userId String
	 * @param selectedRole String
	 * @param primarySalesArea String
	 * @param selectedManager String
	 * @param selectedGroups String
	 * @param asalesAreaAccessType HashMap
	 */
	public void setData(TreeMap roles, TreeMap salesAreas, TreeMap managers, 
						TreeMap groups, String userId, String selectedRole, 
						String primarySalesArea, String selectedManager, TreeSet selectedGroups,
						TreeMap asalesAreaAccessType,TreeMap userTypes, String selectedUserType,TreeMap baRoles,String selectedBARole){
		super.setData(roles, salesAreas, managers, groups, userId, selectedRole, primarySalesArea, selectedManager, selectedGroups,userTypes, selectedUserType,baRoles,selectedBARole);
		setSalesAreaAccessType(asalesAreaAccessType);
	}
}
