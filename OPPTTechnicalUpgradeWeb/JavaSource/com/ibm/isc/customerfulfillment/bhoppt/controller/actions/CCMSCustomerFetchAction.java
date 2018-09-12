/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CCMSCustomerSelectionViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;

/**
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CCMSCustomerFetchAction extends OPPTLongAction {

    /** 
	 * Oexecute the action and return the oppt viewbean 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Ravi Yandapalli
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
    protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
            throws Exception {
    	ErrorReport errorReport = null;
		OPPTViewBean viewBean = null;
		viewBean = new CCMSCustomerSelectionViewBean();
		setForwardName(ForwardNameConstants.PAGE_CCMSCUSTOMER_FETCH);  
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
        return ActionNameConstants.CCMSCUSTOMER_FETCH;
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
		String actualForward = ForwardNameConstants.PAGE_CCMSCUSTOMER_FETCH;

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof CCMSCustomerSelectionViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if (!valid) {
			session.setCurrentViewBean(new CCMSCustomerSelectionViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}
		
		return valid;
    }

}
