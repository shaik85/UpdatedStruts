/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateGroupCustomDTO;

/**
 * Holds complete information for create group view.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 18, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class CreateGroupViewBean extends OPPTViewBean {
	private String groupName = null;
	private TreeMap salesAreas = null;
	private String selectedSalesArea=null;
	
	/**
	 *  
	 * Constructor 
	 * Empty Constructor
	 * 
	 * <br/><PRE> 
	 * date Dec 26, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public CreateGroupViewBean(){
	}
	
	/**
	 *  
	 * Constructor 
	 * Accepts CreateGroupCustomDTO and populates fields.
	 * 
	 * <br/><PRE> 
	 * date Dec 26, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param customDto
	 */
	public CreateGroupViewBean(CreateGroupCustomDTO customDto){
		setGroupName(customDto.getGroupName());
		setSalesAreas(restructureSalesOrg(customDto.getSalesAreas()));
		setSelectedSalesArea(customDto.getSelectedSalesArea());
	}
	/**
	 * Returns group name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * Returns collection of sales areas  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Vector
	 */
	public TreeMap getSalesAreas() {
		return salesAreas;
	}

	/**
	 * Sets the group name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGroupName String 
	 */
	public void setGroupName(String newGroupName) {
		groupName = newGroupName;
	}

	/**
	 * Sets the collection as sales areas collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSalesAreas Vector 
	 */
	public void setSalesAreas(TreeMap newSalesAreas) {
		salesAreas = newSalesAreas;
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
	 * date Feb 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getSelectedSalesArea() {
		return selectedSalesArea;
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
	 * date Feb 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setSelectedSalesArea(String string) {
		selectedSalesArea = string;
	}

	/**
	 * Sets complete data in a single method call.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param groupName
	 * @param salesAreas
	 */
	public void setData(String groupName, TreeMap salesAreas) {
		setGroupName(groupName);
		setSalesAreas(salesAreas);
	}
	
	/**
	 * Sets the available sales area collection
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSalesAreas Hashtable 
	 */
	private TreeMap restructureSalesOrg(TreeMap newSalesAreas) {
		TreeMap localSalesArea = null;
		if(null != newSalesAreas){
			localSalesArea = new TreeMap();
			Set keySet = newSalesAreas.keySet();
			Iterator itr = keySet.iterator();
			String key;
	
			while(itr.hasNext()){
				key = (String)itr.next();
				localSalesArea.put(((String)newSalesAreas.get(key)).trim() + "-" + key, key);  //$NON-NLS-1$
			}
		}
		return localSalesArea;
	}
}
