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
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationDetailViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO;

/**
 * This is Edit Modification Action
 * 
 * @author Ravi Yandapalli
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class EditModificationAction extends OPPTLongAction {
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
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
    
    protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
            throws Exception {
        
		OPPTViewBean viewBean = null;
		ModificationTypeCodeActionForm actionForm;
		actionForm = (ModificationTypeCodeActionForm)form;
		//session.storeObjectToSession(SessionConstants.SESSION_MODIFICATION_ACTIONFORM,actionForm);
		//ModificationActionForm modificationActionForm = (ModificationActionForm)session.getObjectFromSession(SessionConstants.SESSION_MODIFICATION_ACTIONFORM);
		session.setFirstActionForwardName(ForwardNameConstants.PAGE_REFRESH_DETAILS_MODIFICATION);
		DisplayModificationViewBean displayModificationViewBean = (DisplayModificationViewBean)session.getObjectFromSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN);
		TreeMap selectedmodificationMap = displayModificationViewBean.getSelectedModifications();
		String typeCode = actionForm.getModificationTypeCode();
		DisplayModificationDetailViewBean displayModificationDetailViewBean =(DisplayModificationDetailViewBean) selectedmodificationMap.get(typeCode);
	//	ModificationActionForm af = (ModificationActionForm)displayModificationDetailViewBean.getActionForm();
	
		viewBean=displayModificationDetailViewBean;
		
//		 Added by Balaji for UI standards - Starts
	    BaseAgreementDetailsCustomDTO customDto = (BaseAgreementDetailsCustomDTO) session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
	    if(customDto != null && customDto.getAgreementId() > 0) {
	    	setForwardName(ForwardNameConstants.PAGE_EDIT_MODIFICATION_DETAILS_FOR_AMEND);  //$NON-NLS-1$
	    	session.storeObjectToSession(SessionConstants.SESSION_AMEND_FLAG,new Boolean(true));
	    }else {
	    	setForwardName(ForwardNameConstants.PAGE_EDIT_MODIFICATION_DETAILS);  //$NON-NLS-1$
	    }
	    // Added by Balaji for UI standards - Ends
	    
		
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
		return ActionNameConstants.EDIT_MODIFICATION;
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
		String actualForward = ForwardNameConstants.PAGE_EDIT_MODIFICATION_DETAILS;
		

//		 Added by Balaji for UI standards - Starts
	    BaseAgreementDetailsCustomDTO customDto = (BaseAgreementDetailsCustomDTO) session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
	    if(customDto != null && customDto.getAgreementId() > 0) {
	    	actualForward = ForwardNameConstants.PAGE_EDIT_MODIFICATION_DETAILS_FOR_AMEND;  //$NON-NLS-1$
	    	session.storeObjectToSession(SessionConstants.SESSION_AMEND_FLAG,new Boolean(true));
	    }else {
	    	actualForward = ForwardNameConstants.PAGE_EDIT_MODIFICATION_DETAILS;  //$NON-NLS-1$
	    }
	    // Added by Balaji for UI standards - Ends
	    
		

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof DisplayModificationDetailViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if (!valid) {
			TreeMap rolOptionsMap = new TreeMap();
			rolOptionsMap.putAll(OPPTStaticDataHolder.rolOptionsMap);
			DisplayModificationDetailViewBean displayModificationDetailViewBean = new DisplayModificationDetailViewBean();
			displayModificationDetailViewBean.setRolOptions(rolOptionsMap);
			session.setCurrentViewBean(displayModificationDetailViewBean);
			session.setCurrentForward(actualForward);
			valid = true;
		}
		
		if(customDto == null) {
			valid = false;
		}
		
		
		return valid;
	}


}
