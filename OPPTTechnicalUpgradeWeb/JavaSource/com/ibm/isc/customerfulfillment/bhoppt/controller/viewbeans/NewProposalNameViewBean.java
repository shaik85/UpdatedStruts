/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * Holds information required for new proposal name view. Inititator is passes as an hidden variable.  
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
public class NewProposalNameViewBean extends OPPTViewBean {
	private String iInitiator = null;
	private String title = null;
	
	/**
	 * Returns new proposal name view initiator 
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
	 * Sets new proposal name initiator 
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
	 * Sets complete data in a single method call  
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
	 * @param initiator
	 */
	public void setData(String initiator){
		setInitiator(initiator);
	}
	
	/**
     * NewProposalNameViewBean
     * 
     * @author thirumalai
     */
    public NewProposalNameViewBean(){
	}
	/**
     * NewProposalNameViewBean
     * 
     * @param initiator
     * @param title
     * @author thirumalai
     */
    public NewProposalNameViewBean(String initiator, String title){
		setInitiator(initiator);
		setTitle(title);
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
     * getTitle
     * 
     * @return Returns the message.
     */
    public String getTitle() {
        return title;
    }
    /**
     * setTitle
     * 
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
