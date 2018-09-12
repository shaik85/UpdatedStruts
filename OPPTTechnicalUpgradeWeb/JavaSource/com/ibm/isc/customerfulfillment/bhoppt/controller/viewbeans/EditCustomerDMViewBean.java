/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * Holds complete date required for edit dm view.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 19, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class EditCustomerDMViewBean extends OPPTViewBean {
	private String iSoldToPartyNumber = null;
	private String iSoldToPartyName = null;

	private TreeMap iDMs = null;

	/**
	 * Returns sold to party name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
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
	 * date Nov 19, 2003 
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
	 * Sets sold to party name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
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
	 * date Nov 19, 2003 
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
	 * Returns DMs collection for the customer. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getDMs() {
		return iDMs;
	}

	/**
	 * Sets dms collection for the customer. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDMs TreeMap 
	 */
	public void setDMs(TreeMap newDMs) {
		iDMs = newDMs;
	}

	/**
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Aug 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param key
	 * @param dm
	 */
	public void addDM(String key, EditDMViewBean dm){
		if(null != dm){
			if(null == iDMs){
				iDMs = new TreeMap();
			}
			
			iDMs.put(key, dm);
		}
	}
	
	/**
     * EditCustomerDMViewBean
     * 
     * @param soldToPartyNumber
     * @param soldToPartyName
     * @author thirumalai
     */
    public EditCustomerDMViewBean(String soldToPartyNumber, String soldToPartyName){
		setSoldToPartyNumber(soldToPartyNumber);
		setSoldToPartyName(soldToPartyName);
	}

	/**
     * EditCustomerDMViewBean
     * 
     * @author thirumalai
     */
    public EditCustomerDMViewBean(){
	}
}