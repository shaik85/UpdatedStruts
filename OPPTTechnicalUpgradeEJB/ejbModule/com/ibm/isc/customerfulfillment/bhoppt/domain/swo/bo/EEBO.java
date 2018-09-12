/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo;

/** 
 * This class checks the business condition against eebdo attributes* * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar * @version 5.1A 
 */
public class EEBO extends EEBDO {
	private static final String NO_CHARGE = "No Charge";
	
	/** 
	 * Checks whether the EE has no charge option. If so, return true. Else, false.
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isNoChargeOption(){
		boolean result = false;
		if(NO_CHARGE.equals(getChargeOptionDesc())){
			return true;
		}
		return result;
	}
}
