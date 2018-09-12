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
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationOptionsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationTypesViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;

/**
 * This is for add the modification tye 
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AddModificationOptionAction extends OPPTLongAction {
    /** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Sep 11,2006
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
        OPPTViewBean viewbean = null;
        ModificationTypesViewBean modificationTypesViewBean = null;
        modificationTypesViewBean= (ModificationTypesViewBean)session.getObjectFromSession(SessionConstants.SESSION_MODIFICATION_TYPE_VIEWBEAN);
        ModificationOptionsViewBean modificationOptionsViewBean=new ModificationOptionsViewBean();
        modificationOptionsViewBean.setTypeCode(modificationTypesViewBean.getTypeCode());
        viewbean =modificationOptionsViewBean;
        session.setFirstActionForwardName(ForwardNameConstants.PAGE_EDIT_MODIFICATIONTYPE_ACTION);
        setForwardName(ForwardNameConstants.PAGE_ADD_MODIFICATION_OPTION);
        return viewbean;
       
    }
    /** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Sep 11,2006  
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
		return ActionNameConstants.ADD_MODIFICATION_OPTION;
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
		String actualForward = ForwardNameConstants.PAGE_ADD_MODIFICATION_OPTION;

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof ModificationOptionsViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if (!valid) {
			session.setCurrentViewBean(new ModificationOptionsViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}
		
		return valid;
	}

}
