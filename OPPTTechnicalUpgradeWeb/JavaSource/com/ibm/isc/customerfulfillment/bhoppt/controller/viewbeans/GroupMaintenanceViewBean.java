/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorEntry;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * Holds complete data required for group maintenance view. 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 19, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class GroupMaintenanceViewBean extends OPPTViewBean{
	private TreeMap iSalesAreas = null;
	private String iSelectedSalesArea = null;
	private ArrayList iGroups = null;
	private String iMessage = null; 
	
	/**
     * GroupMaintenanceViewBean
     * 
     * @author thirumalai
     */
    public GroupMaintenanceViewBean(){
	}
	
	/**
     * GroupMaintenanceViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public GroupMaintenanceViewBean(GroupsCustomDTO customDto){
		populateData(customDto);
	}
	/**
	 * Returns collection of groups (GroupViewBean) for the selected sales area 
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
	 * @return ArrayList
	 */
	public ArrayList getGroups() {
		return iGroups;
	}

	/**
	 * Returns collection of available sales areas  
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
	 * @return 
	 */
	public TreeMap getSalesAreas() {
		return iSalesAreas;
	}

	/**
	 * Returns the selected sales area 
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
	 * @return String
	 */
	public String getSelectedSalesArea() {
		return iSelectedSalesArea;
	}

	/**
	 * Sets the groups collection for the selected sales area 
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
	 * @param newGroups ArrayList 
	 */
	public void setGroups(ArrayList newGroups) {
		iGroups = newGroups;
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
	public void setSalesAreas(TreeMap newSalesAreas) {
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
		iSalesAreas = localSalesArea;
	}

	/**
	 * Sets selected sales area 
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
	 * @param newSelectedSalesArea String 
	 */
	public void setSelectedSalesArea(String newSelectedSalesArea) {
		iSelectedSalesArea = newSelectedSalesArea;
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getMessage() {
		return iMessage;
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setMessage(String string) {
		iMessage = string;
	}
	
	/**
	 * Adds a new sales area to the collection of already existing sales areas.  
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
	 * @param salesAreaCode String
	 * @param salesAreaDescription String
	 */
	public void addSalesArea(String salesAreaCode, String salesAreaDescription){
		if(null != salesAreaCode && null != salesAreaDescription){
			if(null == iSalesAreas){
				iSalesAreas = new TreeMap();
			}
			iSalesAreas.put(salesAreaCode, salesAreaDescription);
		}
	}
	
	/**
	 * Adds a new group to already exising collection of groups.  
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
	 * @param group
	 */
	public void addGroup(GroupViewBean group){
		if(null != group){
			if(null == iGroups){
				iGroups = new ArrayList();
			}
			iGroups.add(group);
		}
	}
	
	/**
	 * Sets complete data in a single method call  
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
	 * @param salesAreas
	 * @param selectedSalesArea
	 * @param groups
	 */
	public void setData(TreeMap salesAreas, String selectedSalesArea, ArrayList groups){
		setSalesAreas(salesAreas);
		setSelectedSalesArea(selectedSalesArea);
		setGroups(groups);
	}
	
	private void populateData(GroupsCustomDTO customDto){
		setData(customDto.getSalesAreas(),customDto.getSelectedSalesArea(),customDto.getGroups());
		ErrorReport messageReport = customDto.getMessageReport();
		if(null != messageReport)
		{
			setMessage(getMessage(messageReport));
		}
	}
	
	private String getMessage(ErrorReport errorReport){
		String message = null;

		if(null != errorReport){
			OPPTMessageCatalog.getInstance().populateErrorReport(errorReport);
			Iterator errorReportIterator = errorReport.values().iterator();
			if(errorReportIterator.hasNext()){
				ErrorEntry errorEntry = (ErrorEntry)errorReportIterator.next();
				if(null != errorEntry){
					message = errorEntry.getErrorMessage();
				}
			}
		}

		return message;
	}
}
