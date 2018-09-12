/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * Custom dto that holds the detail information about a form  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 15, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Nayanatara L Pai
 * @version CBS 2.1
 */
public class FormNumbersBySalesOrgCustomDTO extends OPPTCustomDTO {
	
	private TreeMap formNumbersMap = null;
	
	/**
	 * Returns the formNumbersMap
	 * 
	 * @return TreeMap
	 */
	public TreeMap getFormNumbersMap() {
		return formNumbersMap;
	}
	
	/**
	 * sets formNumbersMap
	 * 
	 * @param formNumbersMap TreeMap
	 */
	public void setFormNumbersMap(TreeMap lFormNumbersMap) {
		formNumbersMap = lFormNumbersMap;
	}
}
