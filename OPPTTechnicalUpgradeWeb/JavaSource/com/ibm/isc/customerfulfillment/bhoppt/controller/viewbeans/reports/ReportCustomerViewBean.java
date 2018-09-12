/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * Holds complete data of a customer to be used in reports  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ReportCustomerViewBean extends OPPTViewBean {
	private String iSoldToPartyName = null;
	private String iSoldToPartyNumber = null;
	private String iSoldToPartyASNumber = null;
	private String iBillToPartyName = null;
	private String iBillToPartyNumber = null;
	private String iBillToPartyASNumber = null;
	private String iPayerName = null;
	private String iPayerNumber = null;
	private String iPayerASNumber = null;
	
	/**
	 * Returns bill to partry address sequence number
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getBillToPartyASNumber() {
		return iBillToPartyASNumber;
	}

	/**
	 * Returns bill to party name
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getBillToPartyName() {
		return iBillToPartyName;
	}

	/**
	 * Sets bill to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getBillToPartyNumber() {
		return iBillToPartyNumber;
	}

	/**
	 * Sets payer address sequence number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPayerASNumber() {
		return iPayerASNumber;
	}

	/**
	 * Sets payer name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPayerName() {
		return iPayerName;
	}

	/**
	 * Sets payer number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPayerNumber() {
		return iPayerNumber;
	}

	/**
	 * Sets sold to party address sequence number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSoldToPartyASNumber() {
		return iSoldToPartyASNumber;
	}

	/**
	 * Returns sold to party name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSoldToPartyName() {
		return iSoldToPartyName;
	}

	/**
	 * Returns sold to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSoldToPartyNumber() {
		return iSoldToPartyNumber;
	}

	/**
	 * Sets bill to party address sequence number
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillToPartyASNumber String 
	 */
	public void setBillToPartyASNumber(String newBillToPartyASNumber) {
		iBillToPartyASNumber = newBillToPartyASNumber;
	}

	/**
	 * Sets bill to party name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillToPartyName String 
	 */
	public void setBillToPartyName(String newBillToPartyName) {
		iBillToPartyName = newBillToPartyName;
	}

	/**
	 * Sets bill to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillToPartyNumber String 
	 */
	public void setBillToPartyNumber(String newBillToPartyNumber) {
		iBillToPartyNumber = newBillToPartyNumber;
	}

	/**
	 * Sets payer address sequence number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPayerASNumber String 
	 */
	public void setPayerASNumber(String newPayerASNumber) {
		iPayerASNumber = newPayerASNumber;
	}

	/**
	 * Sets payer name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPayerName String 
	 */
	public void setPayerName(String newPayerName) {
		iPayerName = newPayerName;
	}

	/**
	 * Sets payer number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPayerNumber String 
	 */
	public void setPayerNumber(String newPayerNumber) {
		iPayerNumber = newPayerNumber;
	}

	/** 
	 * Sets sold to party address sequence number
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSoldToPartyASNumber String 
	 */
	public void setSoldToPartyASNumber(String newSoldToPartyASNumber) {
		iSoldToPartyASNumber = newSoldToPartyASNumber;
	}

	/**
	 * Sets sold to party name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSoldToPartyName String 
	 */
	public void setSoldToPartyName(String newSoldToPartyName) {
		iSoldToPartyName = newSoldToPartyName;
	}

	/**
	 * Sets sold to party number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSoldToPartyNumber String 
	 */
	public void setSoldToPartyNumber(String newSoldToPartyNumber) {
		iSoldToPartyNumber = newSoldToPartyNumber;
	}

	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param soldToPartyName String
	 * @param soldToPartyNumber String
	 * @param soldToPartyASNumber String
	 * @param billToPartyName String
	 * @param billToPartyNumber String
	 * @param billToPartyASNumber String
	 * @param payerName String
	 * @param payerNumber String
	 * @param payerASNumber String
	 */
	public void setData(String soldToPartyName, String soldToPartyNumber, String soldToPartyASNumber, 
						String billToPartyName, String billToPartyNumber, String billToPartyASNumber, 
						String payerName, String payerNumber, String payerASNumber){
		setSoldToPartyName(soldToPartyName);
		setSoldToPartyNumber(soldToPartyNumber);
		setSoldToPartyASNumber(soldToPartyASNumber);
		setBillToPartyName(billToPartyName);
		setBillToPartyNumber(billToPartyNumber);
		setBillToPartyASNumber(billToPartyASNumber);
		setPayerName(payerName);
		setPayerNumber(payerNumber);
		setPayerASNumber(payerASNumber);
	}
}
