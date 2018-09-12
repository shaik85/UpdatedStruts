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


/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 10, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */


public class GetPartnersActionForm extends OPPTActionForm {
	private String legacyNumber = null;
	private String sequenceNumber = null;
	private String countryCode = null;
	
	/**
	 * Returns legacy number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 10, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getLegacyNumber() {
		return legacyNumber;
	}

	/**
	 * Returns sequence number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 10, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * Sets legacy number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 10, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLegacyNumber String 
	 */
	public void setLegacyNumber(String newLegacyNumber) {
		legacyNumber = newLegacyNumber;
	}

	/**
	 * Sets sequence number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 10, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSequenceNumber String 
	 */
	public void setSequenceNumber(String newSequenceNumber) {
		sequenceNumber = newSequenceNumber;
	}

	/**
	 * @return
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param newCountryCode
	 */
	public void setCountryCode(String newCountryCode){
		countryCode = newCountryCode;
	}

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#validate()
	 */
	public ErrorReport validate() {
		ErrorReport errorReport = new ErrorReport();
		
		/*DADO02 Sateesh Anne BlueHarmony if(isFieldEmpty(getLegacyNumber())){
			errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF28, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		if(isFieldEmpty(getSequenceNumber())){
			errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF29, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}*/
		
		return errorReport;
	}

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#reset()
	 */
	public void reset(){
		legacyNumber = null;
		sequenceNumber = null;
		countryCode = null;
	}
}