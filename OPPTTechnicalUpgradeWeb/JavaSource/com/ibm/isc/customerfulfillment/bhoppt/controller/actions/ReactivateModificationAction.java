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
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO;

/**
 * Reactivate Modification Action
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public  class ReactivateModificationAction extends OPPTLongAction {
   
    /**
    * executeAction
    *
    *@author Ravi Yandapalli
    *
    *Dec 27, 2006  3:01:48 PM
    *
    *@param form
    *@param session
    *@return
    *@throws Exception
    */
	
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)    throws Exception {
	    OPPTViewBean viewBean;
		ModificationTypeCodeActionForm actionForm =(ModificationTypeCodeActionForm)form;
	   	BaseAgreementConfirmationViewBean bAConfirmationViewBean = new BaseAgreementConfirmationViewBean();
	    bAConfirmationViewBean.setInitiator(ConfirmationConstants.CONFIRM_REACTIVATE_MODIFICATION);
	    bAConfirmationViewBean.setFooter(Constants.CONFIRMATION_REACTIVATE_FOOTER);
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
	 * @author Ravi Yandapalli
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return String
	 * 
	 */
	protected String getActionName() {
		return ActionNameConstants.REACTIVATE_MODIFICATION;
	}
    
	/**
	 *validateCurrentViewContent
	 *
	 *@author Ravi Yandapalli
	 *
	 *Dec 27, 2006  3:02:07 PM
	 *
	 *@param session
	 *@return
	 */
	protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = false;
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = ForwardNameConstants.PAGE_DISPLAY_MODIFICATION;
	    BaseAgreementDetailsCustomDTO customDto = (BaseAgreementDetailsCustomDTO) session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
	    if(customDto != null && customDto.getAgreementId() > 0) {
	    	actualForward  =  ForwardNameConstants.PAGE_DISPLAY_MODIFICATION_FOR_AMEND;
	      	session.storeObjectToSession(SessionConstants.SESSION_AMEND_FLAG,new Boolean(true));
	    }else {
	    	actualForward  = ForwardNameConstants.PAGE_DISPLAY_MODIFICATION;
	    }
		if(null != viewBean && null != currentForward){
			if(viewBean instanceof DisplayModificationViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}
		if (!valid) {
			session.setCurrentViewBean(new DisplayModificationViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}
		if(customDto == null) {
			valid = false;
		}
		return valid;
	}	
}
	

