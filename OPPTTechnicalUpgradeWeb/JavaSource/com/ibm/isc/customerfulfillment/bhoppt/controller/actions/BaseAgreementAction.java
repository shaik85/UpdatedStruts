/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2006, 2008
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SearchBaseAgreementViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
/**
 * This is the search the Base agreement 
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAgreementAction extends OPPTLongAction {
    /**
     * Oexecute the action and return the oppt viewbean
     * <br/><PRE>
     * date Nov 14, 2003
     * revision date author reason
     * </PRE><br/>
     *
     * @author Ravi Yandapalli
     * @return OPPTViewBean
     * @throws Exception
     * @param lForm
     * @param lSession 
     */
    protected OPPTViewBean executeAction(ActionForm lForm, OPPTSession lSession)
            throws Exception {

		OPPTViewBean viewBean = null;
		viewBean = new SearchBaseAgreementViewBean();
		
        return viewBean;
    }

    /** 
	 * Return the action name 
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
		return ActionNameConstants.SEARCH_BASEAGREEMENT;
	}

	 /**
     * validate current view bwan
     * 
     * 
     * @return
     * @author Ravi Yandapalli
     * @param session
     */  
    
    protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT;

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof SearchBaseAgreementViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if (!valid) {
			session.setCurrentViewBean(new SearchBaseAgreementViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}
		
		return valid;
	}
}

