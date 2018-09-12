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
 * Action form for alternate partner view. It checks whether any data entered for legacy number field 
 * which is a required field in alternate partner view.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 25, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */


public class AlternatePartnerActionForm extends OPPTActionForm {
	private String partnerType = null;
	private String legacyNumber = null;
	private String sequenceNumber = null;
	private String countryCode = null;
	//DADO02 BlueHarmony wave1 Sateesh Anne
	private String sapCustomerNumber = null;

	/**
	 * Returns legacy customer numer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
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
	 * Returns address sequence number of the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
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
	 * Sets legacy number of the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
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
	 * Sets address sequence number of the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
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

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#validate()
	 */
	public ErrorReport validate() {
		ErrorReport errorReport = new ErrorReport();
	//DADO02 Sateesh Anne BHWave1
		/* if(isFieldEmpty(getLegacyNumber())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF28, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		if(isFieldEmpty(getSequenceNumber())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF29, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}*/
		
		if(isFieldEmpty(getSapCustomerNumber())){ //DAD O02 Sateesh Anne BHWave1
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF284,OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
		return errorReport;
	}
	
	/**
	 * Returns partner type value 
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
	public String getPartnerType() {
		return partnerType;
	}

	/**
	 * Sets partner type value 
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
	 * @param newPartnerType String 
	 */
	public void setPartnerType(String newPartnerType) {
		partnerType = newPartnerType;
	}
	
	/**
	 * @return
	 */
	public int getPartnerTypeValue(){
		int partnerTypeValue = -1;
		
		try{
			partnerTypeValue = Integer.parseInt(partnerType);
		}
		catch(Exception e){}
		
		return partnerTypeValue;
	}

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#reset()
	 */
	public void reset(){
		partnerType = null;
		legacyNumber = null;
		sequenceNumber = null;
		sapCustomerNumber = null;
	}
	
	/**
	 * Returns country code value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Sets country code value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCountryCode String 
	 */
	public void setCountryCode(String newCountryCode) {
		countryCode = newCountryCode;
	}
	/**
	 * @return Returns the sapCustomerNumber.
	 */
	public String getSapCustomerNumber() {
		return sapCustomerNumber;
	}
	/**
	 * @param sapCustomerNumber The sapCustomerNumber to set.
	 */
	public void setSapCustomerNumber(String newsapCustomerNumber) {
		sapCustomerNumber = newsapCustomerNumber;
	}
}
