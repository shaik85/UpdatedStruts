/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;

/**
 * <p>View bean that is used by the confirmation JSP. When ever an action is initiating a confirmation 
 * view, it should set an initiator parameter (that is which action initiated this action) and the 
 * messages that are requiring confirmation. </p>
 * 
 * <p>The messages are displayed to the user by asking his confirmation. The initiator is passed to the 
 * Confirmation action as an hidden variable. It is used by the confirmation action to find out the 
 * what step it has to take to finish the action.</p>  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 13, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ConfirmationViewBean extends OPPTViewBean {
	private String initiator = null;
	private String header = Constants.CONFIRMATION_HEADER;
	private String footer = Constants.CONFIRMATION_FOOTER;
	
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
    public ConfirmationViewBean(){	
	}
	
	/**
     * ConfirmationViewBean
     * 
     * @param initiator
     * @author thirumalai
     */
    public ConfirmationViewBean(String initiator){
		setInitiator(initiator);
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
