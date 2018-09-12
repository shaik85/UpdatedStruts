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
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementDetailViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementFormViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SearchBaseAgreementViewBean;

/**
 * This is the Cancel the Base agreement 
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CancelBaseAgreementAction extends OPPTAction {
    /** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Oct 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		viewBean = new SearchBaseAgreementViewBean();
		session.setCurrentViewBean(viewBean);
	 	setForwardName(ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT); 
	 	if(session.getLastViewBean() instanceof BaseAgreementDetailViewBean){
	 		setForwardName(ForwardNameConstants.PAGE_REFRESH_BASEAGREEMENT); 
	 	}
		return viewBean;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Oct 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#getActionName() 
	 * @return 
	 * 
	 */
	protected String getActionName() {
		// TODO Auto-generated method stub
		return "CancelBaseAgreementAction";  //$NON-NLS-1$
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Oct 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param session
	 * @return 
	 * 
	 */
	  protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String forwardToAmend = null;
		String forwardCreate = null;
		String actualForward = null;
	if(null != viewBean && null != currentForward && currentForward.equals(ForwardNameConstants.PAGE_CREATE_BASEAGREEMENT)){
		    forwardCreate = ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT;
		    actualForward = forwardCreate;
			if(viewBean instanceof BaseAgreementFormViewBean && currentForward.equals(actualForward)){
				valid = true;
			} else {
				session.setCurrentViewBean(new SearchBaseAgreementViewBean());
				session.setCurrentForward(actualForward);
				valid = true;
			}
	 }
	if(null != viewBean && null != currentForward && currentForward.equals( ForwardNameConstants. PAGE_AMEND_BASEAGREEMENT)){ 
			forwardCreate = ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT;
			actualForward = forwardToAmend ;
		if(viewBean instanceof BaseAgreementDetailViewBean && currentForward.equals(actualForward)){
		   valid = true;
		}
		else
		{
			session.setCurrentViewBean(new SearchBaseAgreementViewBean());
		    session.setCurrentForward(actualForward);
		    valid = true;
		}	
		}
	return valid;
	 }

}
