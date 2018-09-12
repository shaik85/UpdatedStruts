/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;

/**
 * Cancel View Action
 * @author Administrator
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class CancelViewAction extends OPPTAction {
	/**
	 * Overridden method - Enter your description here.
	 * 
	 * <br/>
	 * 
	 * <PRE>
	 * 
	 * date Oct 28, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br/>
	 * 
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception
	 *  
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
			throws Exception {

		OPPTViewBean viewBean = session.getCurrentViewBean();
		setForwardName(ForwardNameConstants.PAGE_REFRESH_BASEAGREEMENT);
		return viewBean;

	}

	/**
	 * Overridden method - Enter your description here.
	 * 
	 * <br/>
	 * 
	 * <PRE>
	 * 
	 * date Oct 28, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br/>
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#getActionName()
	 * @return
	 *  
	 */
	protected String getActionName() {
		// TODO Auto-generated method stub
		return "CancelViewAction"; //$NON-NLS-1$
	}

	/**
	 * Overridden method - Enter your description here.
	 * 
	 * <br/>
	 * 
	 * <PRE>
	 * 
	 * date Oct 28, 2004
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br/>
	 * 
	 * @param session
	 * @return
	 *  
	 */
	protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = true;
		return valid;
	}

}
