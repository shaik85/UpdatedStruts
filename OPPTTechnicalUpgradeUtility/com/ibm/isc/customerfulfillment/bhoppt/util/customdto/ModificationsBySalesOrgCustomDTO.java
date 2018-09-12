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
public class ModificationsBySalesOrgCustomDTO extends OPPTCustomDTO {
	
	private TreeMap modificationsMap = null;

	
	/**
	 * Returns the modificationsMap
	 * 
	 * @return TreeMap
	 */
	public TreeMap getModificationsMap() {
		return modificationsMap;
	}
	
	/**
	 * sets modificationsMap
	 * 
	 * @param modificationsMap TreeMap
	 */
	public void setModificationsMap(TreeMap lModificationsMap) {
		modificationsMap = lModificationsMap;
	}
}
