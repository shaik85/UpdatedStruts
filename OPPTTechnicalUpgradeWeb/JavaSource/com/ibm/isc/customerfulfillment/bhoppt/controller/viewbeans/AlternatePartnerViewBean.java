/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.AlternatePartnerActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;

/**
 * Holds the information about the alternate partner screen.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 14, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class AlternatePartnerViewBean extends OPPTViewBean {
	private int partnerType = -1;
	private String partnerName = null;
	
	/**
	 * Returns partner type for fetching alternate partner 
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
	 * @return int
	 */
	public int getPartnerType() {
		return partnerType;
	}
	/**
     * getPartnerTypeString
     * 
     * @return
     * @author thirumalai
     */
    public String getPartnerTypeString() {
		return String.valueOf(partnerType);
	}

	/**
	 * Sets partner type 
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
	 * @param newPartnerType int 
	 */
	public void setPartnerType(int newPartnerType) {
		partnerType = newPartnerType;
		
		switch(partnerType){
			case Constants.SOLD_TO_PARTY: 
							setPartnerName("Sold to party");  //$NON-NLS-1$
							break;
			case Constants.SHIP_TO_PARTY: 
							setPartnerName("Ship to party");  //$NON-NLS-1$
							break;
			case Constants.BILL_TO_PARTY: 
							setPartnerName("Bill to party");  //$NON-NLS-1$
							break;
			case Constants.PAYER: 
							setPartnerName("Payer");  //$NON-NLS-1$
							break;
			default:
							setPartnerName("Sold to party");  //$NON-NLS-1$
							break;
		}
	}

	/**
	 * Returns partner name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPartnerName() {
		return partnerName;
	}

	/**
	 * Sets partner name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPartnerName String 
	 */
	public void setPartnerName(String newPartnerName) {
		partnerName = newPartnerName;
	}

	/**
     * AlternatePartnerViewBean
     * 
     * @author thirumalai
     */
    public AlternatePartnerViewBean(){
	}

	/**
     * AlternatePartnerViewBean
     * 
     * @param partnerType
     * @author thirumalai
     */
    public AlternatePartnerViewBean(int partnerType){
		setPartnerType(partnerType);
	}

	/**
     * getAlternatePartnerActionForm
     * 
     * @return
     * @author thirumalai
     */
    public AlternatePartnerActionForm getAlternatePartnerActionForm(){
		AlternatePartnerActionForm actionForm = null;
		
		if(null != getActionForm() && getActionForm() instanceof AlternatePartnerActionForm){
			actionForm = (AlternatePartnerActionForm)getActionForm();
		}
		else{
			actionForm = new AlternatePartnerActionForm();
		}
		
		return actionForm;
	}
	
	/**
     * isCountryCodeVisible
     * 
     * @return
     * @author thirumalai
     */
    public boolean isCountryCodeVisible(){
		boolean countryCodeVisible = false;
		
		if(partnerType == Constants.SOLD_TO_PARTY){
			countryCodeVisible = true;
		}
		
		return countryCodeVisible;	
	}
}