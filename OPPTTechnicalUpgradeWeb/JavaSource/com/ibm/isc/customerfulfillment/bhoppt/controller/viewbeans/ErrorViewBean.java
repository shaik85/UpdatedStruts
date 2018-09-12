/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;

/**
 * Holds the information about the error view. It has an instance variable initiator, 
 * which is passed to the action as an hidden variable, so that the action can know 
 * which action has initiated this error view.  
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
public class ErrorViewBean extends OPPTViewBean {
	private String iInitiator = null;
	private boolean iForwardInitiator = false;
	private boolean iShowContinueButton = true;
	
	/**
	 * Constructor
	 * Creates a new ErrorViewBean object 
	 * 
	 * <br/><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public ErrorViewBean() {
	}
	
	/**
	 * Constructor
	 * Creates a new ErrorViewBean object 
	 * 
	 * <br/><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param report
	 */
	public ErrorViewBean(ErrorReport report) {
		setErrorReport(report);
	}

	/**
     * Constructor
     * Creates a new ErrorViewBean object
     * <br/><PRE>
     * date Nov 19, 2003
     * revision date author reason
     * </PRE><br/>
     *
     * @param report
     * @param initiator 
     */
	public ErrorViewBean(ErrorReport report, String initiator) {
		setErrorReport(report);
		setInitiator(initiator);
	}

	/**
     * ErrorViewBean
     * @param report
     * @param initiator
     * @param forwardInitiator
     * @author thirumalai
     */
    public ErrorViewBean(ErrorReport report, String initiator, boolean forwardInitiator) {
		setErrorReport(report);
		setInitiator(initiator);
		setForwardInitiator(forwardInitiator);
	}

	/**
	 * Returns error view initiator  
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
	public String getInitiator() {
		return iInitiator;
	}
	
	/**
	 * Sets the error view initiator  
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
	 * @param newInitiator String
	 */
	public void setInitiator(String newInitiator) {
		iInitiator = newInitiator;
	}

	/**
	 * Sets complete data in a single method call  
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
	 * @param initiator String
	 */
	public void setData(String initiator){
		setInitiator(initiator);
	}
	/** 
	 * Whether continue button should be displayed on error page.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isShowContinueButton() {
		return iShowContinueButton;
	}

	/** 
	 * Set false if error page should not contain continue button;
	 * Default value is true
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setShowContinueButton(boolean b) {
		iShowContinueButton = b;
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