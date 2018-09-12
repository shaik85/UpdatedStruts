/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;

public class PartnerSelectionActionForm extends OPPTActionForm {
	private String soldToPartyNumber = null;
	private String soldToPartyName = null;
	private String billToPartyASNumber = null;
	private String billToPartyNumber = null;
	private String billToPartyName = null;
	private String payerASNumber = null;
	private String payerNumber = null;
	private String payerName = null;
	private String shipToPartyNumber = null;
	private String shipToPartyName = null;
	private String nineDPartnerNumber = null;
	private String nineDPartnerName = null;
	private String comments = null;
	private boolean igfNumber = false;

	/**
	 * Returns bill to party name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getBillToPartyName() {
		return billToPartyName;
	}

	/**
	 * Returns bill to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getBillToPartyNumber() {
		return billToPartyNumber;
	}

	/**
	 * Sets comments value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getComments() {
		if(null == comments){
			comments = "";
		}
		return comments;
	}

	/**
	 * Returns 9D partner name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getNineDPartnerName() {
		return nineDPartnerName;
	}

	/**
	 * Returns 9D Partner number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getNineDPartnerNumber() {
		return nineDPartnerNumber;
	}

	/**
	 * Returns payer name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPayerName() {
		return payerName;
	}

	/**
	 * Returns payer number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPayerNumber() {
		return payerNumber;
	}

	/**
	 * Returns ship to party name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getShipToPartyName() {
		return shipToPartyName;
	}

	/**
	 * Returns ship to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getShipToPartyNumber() {
		return shipToPartyNumber;
	}

	/**
	 * Returns sold to party name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSoldToPartyName() {
		return soldToPartyName;
	}

	/**
	 * Returns sold to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSoldToPartyNumber() {
		return soldToPartyNumber;
	}

	/**
	 * Sets bill to party name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillToPartyName String 
	 */
	public void setBillToPartyName(String newBillToPartyName) {
		billToPartyName = newBillToPartyName;
	}

	/**
	 * Sets bill to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillToPartyNumber String 
	 */
	public void setBillToPartyNumber(String newBillToPartyNumber) {
		billToPartyNumber = newBillToPartyNumber;
	}

	/**
	 * Sets commetns value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newComments String 
	 */
	public void setComments(String newComments) {
		comments = newComments;
	}

	/**
	 * Sets 9D Partner name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNineDPartnerName String 
	 */
	public void setNineDPartnerName(String newNineDPartnerName) {
		nineDPartnerName = newNineDPartnerName;
	}

	/**
	 * Sets 9D partner number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNineDPartnerNumber String 
	 */
	public void setNineDPartnerNumber(String newNineDPartnerNumber) {
		nineDPartnerNumber = newNineDPartnerNumber;
	}

	/**
	 * Sets payer name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPayerName String 
	 */
	public void setPayerName(String newPayerName) {
		payerName = newPayerName;
	}

	/**
	 * Sets payer number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPayerNumber String 
	 */
	public void setPayerNumber(String newPayerNumber) {
		payerNumber = newPayerNumber;
	}

	/**
	 * Sets ship to party name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newShipToPartyName String 
	 */
	public void setShipToPartyName(String newShipToPartyName) {
		shipToPartyName = newShipToPartyName;
	}

	/**
	 * Sets ship to party number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newShipToPartyNumber String 
	 */
	public void setShipToPartyNumber(String newShipToPartyNumber) {
		shipToPartyNumber = newShipToPartyNumber;
	}

	/**
	 * Sets sold to party name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSoldToPartyName String 
	 */
	public void setSoldToPartyName(String newSoldToPartyName) {
		soldToPartyName = newSoldToPartyName;
	}

	/**
	 * Sets sold to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSoldToPartyNumber String 
	 */
	public void setSoldToPartyNumber(String newSoldToPartyNumber) {
		soldToPartyNumber = newSoldToPartyNumber;
	}

	/**
	 * Returns bill to party address sequence number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getBillToPartyASNumber() {
		return billToPartyASNumber;
	}

	/**
	 * Returns payer address sequence number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPayerASNumber() {
		return payerASNumber;
	}

	/**
	 * Sets bill to party address sequence number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillToPartyASNumber String 
	 */
	public void setBillToPartyASNumber(String newBillToPartyASNumber) {
		billToPartyASNumber = newBillToPartyASNumber;
	}

	/**
	 * Sets payer address sequence number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPayerASNumber String 
	 */
	public void setPayerASNumber(String newPayerASNumber) {
		payerASNumber = newPayerASNumber;
	}

	/**
	 * Overridden method - Resets the action form values. 
	 * 
	 * <br/><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#reset() 
	 *
	 */
	public void reset(){
		soldToPartyNumber = null;
		soldToPartyName = null;
		billToPartyASNumber = null;
		billToPartyNumber = null;
		billToPartyName = null;
		payerASNumber = null;
		payerNumber = null;
		payerName = null;
		shipToPartyNumber = null;
		shipToPartyName = null;
		nineDPartnerNumber = null;
		nineDPartnerName = null;
		comments = null;
		igfNumber = false;
	}
	
	/**
	 * Returns true if igf number is associated with the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isIgfNumber() {
		return igfNumber;
	}

	/**
	 * Sets igf number flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newIgfNumber boolean
	 */
	public void setIgfNumber(boolean newIgfNumber) {
		igfNumber = newIgfNumber;
	}
}