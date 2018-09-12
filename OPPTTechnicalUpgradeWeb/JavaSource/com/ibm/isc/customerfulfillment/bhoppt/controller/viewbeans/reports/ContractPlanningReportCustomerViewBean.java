/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports;

import java.util.ArrayList;

/**
 * Holds complete data about a customer that is used in contract planning report  
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
public class ContractPlanningReportCustomerViewBean extends ReportCustomerViewBean {
	private ArrayList iDms = null;
	private String iTotalCalculatedPrice = "0.00";
	
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
	 * Returns total calculated price of the customer 
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
     * Sets the dm collection for the customer
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 21, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newDms 
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
	 * Adds a new dm to the collection of dms available for the customer   
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
	 * @param dm ContractPlanningReportDMViewBean
	 */
	public void addDm(ContractPlanningReportDMViewBean dm){
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
	 * @param dms ArrayList
	 * @param totalCalculatedPrice String
	 */
	public void setData(String soldToPartyName, String soldToPartyNumber, String soldToPartyASNumber, 
						String billToPartyName, String billToPartyNumber, String billToPartyASNumber, 
						String payerName, String payerNumber, String payerASNumber, 
						ArrayList dms, String totalCalculatedPrice){
		super.setData(soldToPartyName, soldToPartyNumber, soldToPartyASNumber, billToPartyName, billToPartyNumber, billToPartyASNumber, payerName, payerNumber, payerASNumber);
		setDms(dms);
		setTotalCalculatedPrice(totalCalculatedPrice);		
	}
}
