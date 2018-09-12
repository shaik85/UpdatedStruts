/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;

/**
 * BaseAgreement Confirmation ViewBean
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAgreementConfirmationViewBean extends OPPTViewBean {

    private String initiator = null;
	private String header = Constants.CONFIRMATION_HEADER;
	private String footer = null;
	
	/**
	 * Returns the initiator action name. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 13, 2003 
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
	 * Sets the string value passed as the confirmation initiator action name.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 13, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newInitiator String value which is the initiator action name
	 */
	public void setInitiator(String newInitiator) {
		initiator = newInitiator;
	}
	
	/**
	 * Returns the header of the confirmation page. 
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
	 * @return String
	 */
	public String getFooter() {
		return footer;
	}

	/**
	 * Returns the header of the confirmation page. 
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
	 * @return String
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * Sets the footer for the confirmation page 
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
	 * @param newFooter String 
	 */
	public void setFooter(String newFooter) {
		footer = newFooter;
	}

	/**
	 * Sets the header for the confirmation page 
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
	 * @param newHeader String 
	 */
	public void setHeader(String newHeader) {
		header = newHeader;
	}

	/**
     * ConfirmationViewBean
     * 
     * @author thirumalai
     */
    public BaseAgreementConfirmationViewBean(){	
	}
	
	

	/** 
	 * Overridden method - Returns flag suggesting whether this view can be current view bean. 
	 * 
	 * <br/><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean#isCurrentViewBean() 
	 * @return boolean 
	 * 
	 */
	public boolean isCurrentViewBean() {
		return false;
	}
}
