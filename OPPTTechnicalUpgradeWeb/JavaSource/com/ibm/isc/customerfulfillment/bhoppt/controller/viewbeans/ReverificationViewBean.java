/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReverificationCustomDTO;

/**
 * Holds complete data required for report view.   
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Oct 05, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Saravanan Viswanathan
 * @version 5.1X PMR 2005
 */
public class ReverificationViewBean extends OPPTViewBean{
	private TreeMap iSalesAreas = null;
	
	/**
     * ReverificationViewBean
     * 
     * @author thirumalai
     */
    public ReverificationViewBean(){
	}
	
	/**
     * ReverificationViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public ReverificationViewBean(ReverificationCustomDTO customDto){
		populateBean(customDto.getSalesOrgs());
	}

	/**
	 * Returns the collection of sales orgs available for generating reports 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Oct 05,2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ArrayList
	 */
	public TreeMap getSalesAreas() {
		return iSalesAreas;
	}

	/**
	 * Sets the collection of sales orgs available for report generation 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Oct 05, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSalesAreas TreeMap 
	 */
	public void setSalesAreas(TreeMap newSalesAreas) {
		iSalesAreas = newSalesAreas;
	}

	/**
     * Adds a new sales org to the already existing collection
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Oct 05, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param key, value
     * @param value 
     */
	public void addSalesArea(Object key, Object value){
		
		if(null == iSalesAreas){
			iSalesAreas = new TreeMap();
		}
		iSalesAreas.put(key,value);
	}
	
	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Oct 05, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param salesAreas
	 */
	public void setData(TreeMap salesAreas){
		setSalesAreas(salesAreas);
	}
	
	private void populateBean(Map newSalesAreas){
		TreeMap localSalesArea = null;
		if(null != newSalesAreas){
			localSalesArea = new TreeMap();
			Set keySet = newSalesAreas.keySet();
			Iterator itr = keySet.iterator();
			String key;
			while(itr.hasNext()){
				key = (String)itr.next();
				String desc = (String)newSalesAreas.get(key);
				if(null == desc){
					desc = "";  //$NON-NLS-1$
				}
				localSalesArea.put(desc.trim() + "-" + key, key);  //$NON-NLS-1$
			}
		}
		iSalesAreas = localSalesArea;
	}
}

