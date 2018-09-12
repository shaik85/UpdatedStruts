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
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationTypesListViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationTypesViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO;

/**
 * This is edit modification type 
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RefreshEditModificationTypeAction extends OPPTLongAction {

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
        ErrorReport errorReport = null;
        ModificationTypesListViewBean modificationTypesListViewBean = null;
        ModificationTypesViewBean modificationTypesViewBean = null;
        ModificationTypeCodeActionForm actionForm = null;
        ModificationTypeCustomDTO customDto = null;
        TreeMap modificationTypesMap = null;
        actionForm = (ModificationTypeCodeActionForm)session.getObjectFromSession(SessionConstants.SESSION_MODIFICATION_TYPECODE);
        modificationTypesListViewBean = (ModificationTypesListViewBean)session.getObjectFromSession(SessionConstants.SESSION_MODIFICATION_TYPELIST_VIEWBEAN);
        String typeCode = actionForm.getModificationTypeCode();
        modificationTypesMap =modificationTypesListViewBean.getModificationTypesMap();
        modificationTypesViewBean = (ModificationTypesViewBean)modificationTypesMap.get(typeCode);
        customDto = new ModificationTypeCustomDTO(); 
        customDto.setTypeCode(actionForm.getModificationTypeCode());
        customDto.setSelectedSalesOrg(modificationTypesViewBean.getSelectedSalesOrg());
        customDto.setDescription(modificationTypesViewBean.getDescription());
        
        try{
            customDto = getBaseAgreementDataManager().getModificationOptions(customDto);
            errorReport = customDto.getMessageReport();
             if(null == errorReport){
                
                 viewBean = new ModificationTypesViewBean(customDto);
                session.setFirstActionForwardName(ForwardNameConstants.PAGE_MODIFICATION_MAINTENANCE);
                setForwardName(ForwardNameConstants.PAGE_EDIT_MODIFICATION_TYPE);  //$NON-NLS-1$
		   }
		   else{
		    viewBean = new MessageViewBean();
		    viewBean.setErrorReport(errorReport);
			setForwardName(ForwardNameConstants.PAGE_EDIT_MODIFICATION_TYPE);  //$NON-NLS-1$
		}
        
        }catch(ServiceException ex){
		    viewBean = handleServiceException(session, ex.getErrorReport());
		}
        
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
		return ActionNameConstants.REFRESH_EDITMODIFICATION_TYPE;
	}
	   /**
     * getUserManager
     * 
     * @throws java.lang.Exception
     * @return BaseAgreementManager
     * @author Ravi Yandapalli
     */
    protected BaseAgreementDataManager getBaseAgreementDataManager() throws Exception {
        BaseAgreementDataManagerHome baseAgreementDataManagerHome = (BaseAgreementDataManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("BaseAgreementDataManagerHome");  //$NON-NLS-1$
		return baseAgreementDataManagerHome.create();
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
