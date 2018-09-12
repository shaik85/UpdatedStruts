/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;


public class RegistrationActionForm extends OPPTActionForm {
	private String approverId = null;
	private String sendContractTo = null;
	private String sendReplyNotesTo = null;
	private String initiator = null;
	
	/**
	 * Returns selected approver id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getApproverId() {
		return approverId;
	}

	/**
	 * Returns entered send contract to id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSendContractTo() {
		return sendContractTo;
	}

	/**
	 * Returns entered send reply noted to id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSendReplyNotesTo() {
		return sendReplyNotesTo;
	}

	/**
	 * Sets approve id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newApproverId String 
	 */
	public void setApproverId(String newApproverId) {
		approverId = newApproverId;
	}

	/**
	 * Sets send contract to value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSendContractTo String 
	 */
	public void setSendContractTo(String newSendContractTo) {
		sendContractTo = newSendContractTo;
	}

	/**
	 * Sets send reply noted to id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSendReplyNotesTo String 
	 */
	public void setSendReplyNotesTo(String newSendReplyNotesTo) {
		sendReplyNotesTo = newSendReplyNotesTo;
	}
	
	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#validate()
	 */
	public ErrorReport validate() {
		ErrorReport errorReport = new ErrorReport();
		
		/*DADO02 Ramesh BlueHarmony if(isSelectEmpty(getApproverId())){
			errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF34, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		*/
		return errorReport;
	}

	/**
	 * Returns the registration view initiator 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
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
	 * Sets registration view initiator value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
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

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#reset()
	 */
	public void reset(){
		approverId = null;
		sendContractTo = null;
		sendReplyNotesTo = null;
		initiator = null;
	}
}
