/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationTypeCodeActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ConfirmationConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementConfirmationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;


/**
 * This is the Confirm Inactivate Modification Action
 * 
 * @author Tapan Malhothra
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ConfirmInactivateModificationAction extends OPPTLongAction {

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Tapan Malhothra
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
			throws Exception {
		
		OPPTViewBean viewBean;
		ModificationTypeCodeActionForm actionForm =(ModificationTypeCodeActionForm)form;
		BaseAgreementConfirmationViewBean bAConfirmationViewBean = new BaseAgreementConfirmationViewBean();
	    bAConfirmationViewBean.setInitiator(ConfirmationConstants.INACTIVE_MODIFICATION_DETAILS);
	    bAConfirmationViewBean.setFooter(Constants.CONFIRMATION_INACTIVATE_FOOTER);
	    viewBean=bAConfirmationViewBean;
	   	setForwardName(ForwardNameConstants.PAGE_BASEAGREEMENT_CONFIRMATION); 
		session.storeObjectToSession(SessionConstants.SESSION_MODIFICATIONTYPECODE_ACTIONFORM,actionForm);
		return viewBean;	
		
	}

	 /** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Tapan Malhothra
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return String
	 * 
	 */
	protected String getActionName() {
		
		return ActionNameConstants.INACTIVE_MODIFICATION;
	}

	  /**
     * validate current view bwan
     * 
     * 
     * @return
     * @author Tapan Malhothra
     * @param session
     */  
	protected boolean validateCurrentViewContent(OPPTSession session) {
		// TODO Auto-generated method stub
		return true;
	}

}
