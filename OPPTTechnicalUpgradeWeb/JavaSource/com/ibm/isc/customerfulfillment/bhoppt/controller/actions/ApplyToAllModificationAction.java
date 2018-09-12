/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationContactActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ConfirmationConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ConfirmationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;

/**
 * Apply To All Modification Action
 * @author tapan malhotra
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ApplyToAllModificationAction extends OPPTLongAction {

	/**
	 * 
	 *executeAction
	 *
	 *@author Ravi Yandapalli
	 *
	 *Dec 27, 2006  1:46:47 PM
	 *
	 *@param form
	 *@param session
	 *@return
	 *@throws Exception
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)throws Exception {
		OPPTViewBean viewBean = null;
		ModificationContactActionForm actionForm =(ModificationContactActionForm)form;
		viewBean = new ConfirmationViewBean(ConfirmationConstants.APPLYTOALL_MODIFICATION);
		setForwardName(ForwardNameConstants.PAGE_CONFIRMATION);  //$NON-NLS-1$
		session.storeObjectToSession(SessionConstants.SESSION_MODIFICATIONCONTACT_ACTIONFORM,actionForm);
		return viewBean;	
		
	}

    /**
     * 
     *getActionName
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006  1:47:12 PM
     *
     *@return String
     */
	
	protected String getActionName() {
		return ActionNameConstants.APPLYTOALL_MODIFICATION;
	}

	/**
	 * 
	 *validateCurrentViewContent
	 *
	 *@author Ravi Yandapalli
	 *
	 *Dec 27, 2006  1:47:30 PM
	 *
	 *@param session
	 *@return boolean
	 */
	
	protected boolean validateCurrentViewContent(OPPTSession session) {

		return true;
	}

}
