/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationTypeCodeActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationTypesListViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationTypesViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;

/**
 * This is edit modification type 
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EditModificationTypeAction extends OPPTLongAction {

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
        OPPTViewBean viewBean = null;
        ModificationTypesListViewBean modificationTypesListViewBean = null;
        ModificationTypesViewBean modificationTypesViewBean = null;
        ModificationTypeCodeActionForm actionForm = null;
        actionForm = (ModificationTypeCodeActionForm)form;
      session.storeObjectToSession(SessionConstants.SESSION_MODIFICATION_TYPECODE_ACTIONFORM,actionForm);
        TreeMap modificationTypesMap = null;
        modificationTypesListViewBean = (ModificationTypesListViewBean)session.getObjectFromSession(SessionConstants.SESSION_MODIFICATION_TYPELIST_VIEWBEAN);
        String typeCode = actionForm.getModificationTypeCode();
            modificationTypesMap =modificationTypesListViewBean.getModificationTypesMap();
            modificationTypesViewBean = (ModificationTypesViewBean)modificationTypesMap.get(typeCode);
            viewBean = modificationTypesViewBean;
            setForwardName(ForwardNameConstants.PAGE_EDIT_MODIFICATION_TYPE);
            session.setFirstActionForwardName(ForwardNameConstants.PAGE_REFRESH_MODIFICATION_MAINTENANCE);
            session.storeObjectToSession(SessionConstants.SESSION_MODIFICATION_TYPE_VIEWBEAN,modificationTypesViewBean);
            session.storeObjectToSession(SessionConstants.SESSION_MODIFICATION_TYPECODE ,actionForm);
           
        return viewBean;
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
		return ActionNameConstants.EDIT_MODIFICATION_TYPE;
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
		String actualForward = ForwardNameConstants.MODIFICATION_MAINTENANCE;

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof ModificationTypesListViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if (!valid) {
			session.setCurrentViewBean(new ModificationTypesListViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}
		
		return valid;
	}

}
