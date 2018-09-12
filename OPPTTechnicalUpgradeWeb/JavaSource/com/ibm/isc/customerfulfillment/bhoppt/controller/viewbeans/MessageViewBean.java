/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * Holds the information required for a message view. The initiator is passed as an hidden variable.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class MessageViewBean extends OPPTViewBean 
{
	private String iInitiator = null;
	private boolean iForwardInitiator = false;
	private boolean iRedirectTohomePage = false;
	
	/**
	 * Returns the message view initiator 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getInitiator() {
		return iInitiator;
	}

	/**
	 * Sets the message view initiator 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newInitiator String 
	 */
	public void setInitiator(String newInitiator) {
		iInitiator = newInitiator;
	}
	
	/**
	 * MessageViewBean
	 * 
     * @param initiator
     * @param forwardInitiator
     * @author thirumalai
     */
    public MessageViewBean(String initiator, boolean forwardInitiator){
		setInitiator(initiator);
		setForwardInitiator(forwardInitiator);
	}
	/**
     * MessageViewBean
     * 
     * @param initiator
     * @author thirumalai
     */
    public MessageViewBean(String initiator){
		setInitiator(initiator);
	}
	/**
     * MessageViewBean
     * 
     * @author thirumalai
     */
    public MessageViewBean(){
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isRedirectTohomePage() {
		return iRedirectTohomePage;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setRedirectTohomePage(boolean b) {
		iRedirectTohomePage = b;
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
	
	/**
	 * Returns true if the initiator set is an forward initiator. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isForwardInitiator() {
		return iForwardInitiator;
	}

	/**
	 * Sets forward initiator value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newForwardInitiator boolean
	 */
	public void setForwardInitiator(boolean newForwardInitiator) {
		iForwardInitiator = newForwardInitiator;
	}
}