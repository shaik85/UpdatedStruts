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
 * date Jan 23, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class ErrorActionForm extends OPPTActionForm {
	private String initiator = null;
	private boolean forwardInitiator = false;
	
	/**
	 * Returns initiator value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getInitiator() {
		if(null != initiator && "null".equalsIgnoreCase(initiator)){
			initiator = null;
		}
		return initiator;
	}

	/**
	 * Sets message view initiator value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 31, 2003 
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

	public void reset(){
		initiator = null;
		forwardInitiator = false;
	}
	
	/**
	 * Retrurns forward initiator flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isForwardInitiator() {
		return forwardInitiator;
	}

	/**
	 * Sets forward initiator flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newForwardInitiator boolean
	 */
	public void setForwardInitiator(boolean newForwardInitiator) {
		forwardInitiator = newForwardInitiator;
	}
}