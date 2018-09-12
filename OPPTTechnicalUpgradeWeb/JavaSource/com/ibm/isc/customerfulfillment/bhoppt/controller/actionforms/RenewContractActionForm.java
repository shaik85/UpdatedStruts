/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date May 4, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class RenewContractActionForm extends OPPTActionForm {
	private boolean anniversaryRenewal = false;

	/**
	 * Returns anniversary renewal flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date May 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean 
	 */
	public boolean isAnniversaryRenewal() {
		return anniversaryRenewal;
	}

	/** 
	 * Sets anniversary renewal flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date May 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAnniversaryRenewal boolean
	 */
	public void setAnniversaryRenewal(boolean newAnniversaryRenewal) {
		anniversaryRenewal = newAnniversaryRenewal;
	}
}