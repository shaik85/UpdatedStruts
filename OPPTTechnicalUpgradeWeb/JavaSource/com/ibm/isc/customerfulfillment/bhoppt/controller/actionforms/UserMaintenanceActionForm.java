/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;


public class UserMaintenanceActionForm  extends OPPTActionForm{
	private String userId="";
	
	/** 
	 * Retrieve user id
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getUserId() {
		return userId;
	}

	/** 
	 * For setting user id
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setUserId(String newUserId) {
		userId = newUserId;
	}
	

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#reset()
	 */
	public void reset(){
		userId = "";
	}
}
