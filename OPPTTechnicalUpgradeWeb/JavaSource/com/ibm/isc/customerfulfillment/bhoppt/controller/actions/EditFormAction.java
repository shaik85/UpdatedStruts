/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.EditFormActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.FormDetailsActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.FormDetailViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.FormMaintenanceViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;

/**
 * This is to edit an existing form
 * 
 * @author Nayanatara L Pai
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EditFormAction extends OPPTAction {

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Oct 13, 2006 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Nayanatara L Pai
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
			throws Exception {
		
		OPPTViewBean viewBean = null;
        
        FormMaintenanceViewBean formMaintenanceViewBean = null;
        FormDetailViewBean formDetailViewBean = null;
        FormDetailsActionForm actionForm = null;
        TreeMap formDetailsMap = null;
        actionForm = (FormDetailsActionForm)form;
        formMaintenanceViewBean = (FormMaintenanceViewBean)session.getObjectFromSession(SessionConstants.SESSION_FORM_MAINTENANCE_VIEWBEAN);
        String formNumber = actionForm.getFormNumber();
        formDetailsMap =formMaintenanceViewBean.getFormDetailsMap();
        formDetailViewBean = (FormDetailViewBean)formDetailsMap.get(formNumber);
        EditFormActionForm editFormActionForm = new EditFormActionForm();
        editFormActionForm.setFormNumber(formDetailViewBean.getFormNumber());
        editFormActionForm.setFormLongDescription(formDetailViewBean.getFormLongDescription());
        editFormActionForm.setFormShortDescription(formDetailViewBean.getFormShortDescription());
        editFormActionForm.setLanguage(formDetailViewBean.getLanguage());      
        viewBean = formDetailViewBean;
        viewBean.setActionForm(editFormActionForm);           
        session.setFirstActionForwardName(ForwardNameConstants.PAGE_DISPLAY_FORM_LIST_ACTION);
        session.storeObjectToSession(SessionConstants.SESSION_FORM_DETAIL_VIEWBEAN,formDetailViewBean);
        setForwardName(ForwardNameConstants.PAGE_EDIT_FORM);
        return viewBean;
	}

	 
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Oct 13, 2006 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Nayanatara L Pai
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return String
	 * 
	 */
	protected String getActionName() {
		return ActionNameConstants.EDIT_FORM_ACTION;
	}

	/**
     * validate current view bwan
     * 
     * 
     * @return
     * @author Nayanatara L Pai
     * @param session
     */
	protected boolean validateCurrentViewContent(OPPTSession session) {
		
		boolean valid = false;
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		//String actualForward = ForwardNameConstants.PAGE_FORM_MAINTENANCE;
		String actualForward = ForwardNameConstants.PAGE_DISPLAY_FORM_LIST_ACTION;
		if(null != viewBean && null != currentForward){
			if(viewBean instanceof FormMaintenanceViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}
		if (!valid) {
			session.setCurrentViewBean(new FormMaintenanceViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}
		return valid;
	}

}
