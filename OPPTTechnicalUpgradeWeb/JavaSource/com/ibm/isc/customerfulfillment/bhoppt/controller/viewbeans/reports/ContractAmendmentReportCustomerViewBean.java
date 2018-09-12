/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.ArrayList;

public class ContractAmendmentReportCustomerViewBean extends ReportCustomerViewBean {
	private String iTotalMonthlyPrice = "0.00";
	private String iTotalCalculatedPrice = "0.00";
	private ArrayList iDms = null;
	
	/**
	 * Returns collection of dms available for the customer 
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
	 * @return ArrayList
	 */
	public ArrayList getDms() {
		return iDms;
	}

	/**
	 * Returns the total calculated price for the customer 
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
	public String getTotalCalculatedPrice() {
		return iTotalCalculatedPrice;
	}

	/**
	 * Returns total monthly price for the customer 
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
	public String getTotalMonthlyPrice() {
		return iTotalMonthlyPrice;
	}

	/**
	 * Sets the dms collection for the customer 
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
	 * @param newDms ArrayList 
	 */
	public void setDms(ArrayList newDms) {
		iDms = newDms;
	}

	/**
	 * Sets total calculated price for the customer 
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
	 * @param newTotalCalculatedPrice String 
	 */
	public void setTotalCalculatedPrice(String newTotalCalculatedPrice) {
		iTotalCalculatedPrice = newTotalCalculatedPrice;
	}

	/**
	 * Sets total monthly price for the customer 
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
	 * @param newTotalMonthlyPrice String 
	 */
	public void setTotalMonthlyPrice(String newTotalMonthlyPrice) {
		iTotalMonthlyPrice = newTotalMonthlyPrice;
	}

	/**
	 * Adds new dm to the collection of dms for the customer  
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
	 * @param dm ContractAmendmentReportDMViewBean
	 */
	public void addDm(ContractAmendmentReportDMViewBean dm){
		if(null != dm){
			if(null == iDms){
				iDms = new ArrayList();
			}
			iDms.add(dm);
		}
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
	 * @param totalMonthlyPrice String
	 * @param totalCalculatedPrice String
	 * @param dms ArrayList
	 */
	public void setData(String soldToPartyName, String soldToPartyNumber, String soldToPartyASNumber, 
						String billToPartyName, String billToPartyNumber, String billToPartyASNumber, 
						String payerName, String payerNumber, String payerASNumber, 
						String totalMonthlyPrice, String totalCalculatedPrice, ArrayList dms){
		super.setData(soldToPartyName, soldToPartyNumber, soldToPartyASNumber, billToPartyName, billToPartyNumber, billToPartyASNumber, payerName, payerNumber, payerASNumber);
		setTotalMonthlyPrice(totalMonthlyPrice);
		setTotalCalculatedPrice(totalCalculatedPrice);
		setDms(dms);
	}
}
