/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;

/**
 * Action form that holds input regarding the confirmation view initiator. 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class ConfirmationActionForm extends OPPTActionForm {
	private String initiator = null;

	/**
	 * Returns confirmation view initiator value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getInitiator() {
		return initiator;
	}

	/**
	 * Sets confirmation initiator value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newInitiator String 
	 */
	public void setInitiator(String newInitiator) {
		initiator = newInitiator;
	}
}
