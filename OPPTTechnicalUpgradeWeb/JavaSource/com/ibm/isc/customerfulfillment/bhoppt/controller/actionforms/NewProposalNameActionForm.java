/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.NewProposalNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;


public class NewProposalNameActionForm extends OPPTActionForm {
	private String newProposalName = null;
	private String initiator = null;
	
	/**
	 * Returns initiator value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
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
	 * Returns proposal name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getNewProposalName() {
		return newProposalName;
	}

	/**
	 * Sets initiator value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
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

	/**
	 * Sets proposal name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNewProposalName String 
	 */
	public void setNewProposalName(String newNewProposalName) {
		newProposalName = newNewProposalName;
	}
	
	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#validate()
	 */
	public ErrorReport validate() 
	{
		ErrorReport errorReport = new ErrorReport();
		
		if((isFieldEmpty(getNewProposalName()))&& initiator.equalsIgnoreCase(NewProposalNameConstants.RENAME_PROPOSAL)){
			errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF39, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		 if(!isAlphaNumeric(getNewProposalName())){
			errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF75, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		
		return errorReport;
	}
	
	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#reset()
	 */
	public void reset(){
		newProposalName = null;
		initiator = null;
	}
}
