/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;

public class RejectionReasonActionForm extends OPPTActionForm {
	private String rejectionReason = null;

	/**
	 * Returns rejection reason value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getRejectionReason() {
		return rejectionReason;
	}

	/**
	 * Sets rejection reason value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newRejectionReason String 
	 */
	public void setRejectionReason(String newRejectionReason) {
		rejectionReason = newRejectionReason;
	}

	public void reset(){
		rejectionReason = null;
	}
}
