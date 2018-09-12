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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.FormDetailsActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ConfirmationConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ConfirmationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.FormDetailViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.FormMaintenanceViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO;

/**
 * Confirm Delete Form Action
 * @author Nayantara L Pai
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ConfirmDeleteFormAction extends OPPTAction {

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Oct 14, 2006 
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
			throws Exception {
		
		OPPTViewBean viewBean;
		FormMaintenanceViewBean formMaintenanceViewBean = null;
		FormDetailViewBean formDetailViewBean = null;
		TreeMap formDetailsMap = null;
		FormDetailsActionForm actionForm = null;
		FormDetailsCustomDTO formDetailsCustomDTO = null;
		
		
		actionForm = (FormDetailsActionForm)form;
		formMaintenanceViewBean = (FormMaintenanceViewBean)session.getObjectFromSession(SessionConstants.SESSION_FORM_MAINTENANCE_VIEWBEAN);
		formDetailsCustomDTO = new FormDetailsCustomDTO();
		
		String formNumber = actionForm.getFormNumber();
		formDetailsMap =formMaintenanceViewBean.getFormDetailsMap();
        formDetailViewBean = (FormDetailViewBean)formDetailsMap.get(formNumber);
        
        formDetailsCustomDTO.setFormNumber(formNumber);
        formDetailsCustomDTO.setSalesOrg(formDetailViewBean.getSalesOrg());
        formDetailsCustomDTO.setFormLongDescription(formDetailViewBean.getFormLongDescription());
        formDetailsCustomDTO.setFormShortDescription(formDetailViewBean.getFormShortDescription());
		//change this later
        formDetailsCustomDTO.setLanguage("");  /* NOI18N */
        
        
		viewBean = new ConfirmationViewBean(ConfirmationConstants.CONFIRM_DELETE_FORM_ACTION);
		session.storeObjectToSession(SessionConstants.SESSION_FORM_DETAILS_CUSTOMDTO,formDetailsCustomDTO);
		setForwardName(ForwardNameConstants.PAGE_CONFIRMATION);  //$NON-NLS-1$
		
		return viewBean;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Oct 14, 2003 
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
		
		return ActionNameConstants.CONFIRM_DELETE_FORM_ACTION;
	}

	 /**
     * validate current view be an
     * 
     * 
     * @return
     * @author Nayanatara L Pai
     * @param session
     */
	protected boolean validateCurrentViewContent(OPPTSession session) {

		return true;
	}

}
