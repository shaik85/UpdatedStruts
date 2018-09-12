/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * Custom dto that holds the basic data of form  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Oct 11, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Nayanatara L Pai
 * @version CBS 2.1
 */
public class FormMaintenanceCustomDTO extends OPPTCustomDTO {
	
	private TreeMap formDetailsMap = null;
	
	private String salesOrg = null;
	
	
	/**
	 * Returns the formDetailsMap.
	 * 
	 * @return TreeMap
	 */
	public TreeMap getFormDetailsMap() {
		return formDetailsMap;
	}
	
	/**
	 * sets formDetailsMap
	 * 
	 * @param formDetailsMap Treemap
	 */
	public void setFormDetailsMap(TreeMap lFormDetailsMap) {
		formDetailsMap = lFormDetailsMap;
	}
	
	

	/**
	 * @return Returns the salesOrg.
	 */
	public String getSalesOrg() {
		return salesOrg;
	}
	/**
	 * @param salesOrg The salesOrg to set.
	 */
	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}
}
