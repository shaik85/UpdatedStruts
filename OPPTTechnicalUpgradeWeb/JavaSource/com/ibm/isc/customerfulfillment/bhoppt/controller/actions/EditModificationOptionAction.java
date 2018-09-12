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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.EditModificationOptionActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationOptionsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationTypesViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;

/**
 * This is edit modification option 
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EditModificationOptionAction extends OPPTLongAction {

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
        ModificationTypesViewBean modificationTypesViewBean = null;
        EditModificationOptionActionForm actionForm = null;
        actionForm = (EditModificationOptionActionForm)form;
        session.storeObjectToSession(SessionConstants.SESSION_EDITMODIFICATION_OPTION_ACTIONFORM,actionForm);
        String modificationOption = actionForm.getModificationOption();
        modificationTypesViewBean= (ModificationTypesViewBean)session.getObjectFromSession(SessionConstants.SESSION_MODIFICATION_TYPE_VIEWBEAN);
        String typeCode = modificationTypesViewBean.getTypeCode();
        TreeMap modificationTypesMap =modificationTypesViewBean.getModificationOptionsMap();
        TreeMap  modificationOptionsMap = (TreeMap)modificationTypesMap.get(typeCode);   
        viewBean =(ModificationOptionsViewBean) modificationOptionsMap.get(modificationOption);            
        session.setFirstActionForwardName(ForwardNameConstants.PAGE_EDIT_MODIFICATIONTYPE_ACTION);
        session.storeObjectToSession(SessionConstants.SESSION_MODIFICATION_OPTIONS_VIEWBEAN,viewBean);
        setForwardName(ForwardNameConstants.PAGE_EDIT_MODIFICATION_OPTIONS);
      
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
		return ActionNameConstants.EDIT_MODIFICATION_OPTION;
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
		String actualForward = ForwardNameConstants.PAGE_EDIT_MODIFICATION_TYPE;
		
		if(null != viewBean && null != currentForward){
			if(viewBean instanceof ModificationTypesViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if (!valid) {
			session.setCurrentViewBean(new ModificationTypesViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}
		
		return valid;
	}

}
