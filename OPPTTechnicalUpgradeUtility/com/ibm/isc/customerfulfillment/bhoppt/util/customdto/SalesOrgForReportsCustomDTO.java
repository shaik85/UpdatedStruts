/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * Custom dto that holds the detail information about a form  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 16, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Nayanatara L Pai
 * @version CBS 2.1
 */
public class SalesOrgForReportsCustomDTO extends OPPTCustomDTO {
	
	private String salesOrg = null;
		
	/**
	 * Returns the salesOrg
	 * 
	 * @return String
	 */
	public String getSalesOrg() {
		return salesOrg;
	}
	
	/**
	 * sets salesOrg
	 * 
	 * @param salesOrg String
	 */
	public void setSalesOrg(String lSalesOrg) {
		salesOrg = lSalesOrg;
	}
}
