/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

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
public class ReleaseProposalViewBean extends OPPTViewBean {
	
}
