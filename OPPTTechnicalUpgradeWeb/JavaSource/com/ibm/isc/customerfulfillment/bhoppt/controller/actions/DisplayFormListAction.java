/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SalesOrgActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.FormMaintenanceViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormMaintenanceCustomDTO;

/**
 * This is to get the form details depending on the sales org selected
 * 
 * @author Nayanatara L Pai
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DisplayFormListAction extends OPPTAction {

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
		
		OPPTViewBean  viewBean = null ; 
        ErrorReport errorReport = null;
        FormMaintenanceCustomDTO formMaintenanceCustomDTO = null;
        String salesOrg = null;
        UserInfoDataBean userInfoBean = null;
        
        SalesOrgActionForm actionForm=(SalesOrgActionForm) form;
        salesOrg = actionForm.getSalesOrganization();
          
        userInfoBean =session.getUserInfo();
        
        if(salesOrg == null || salesOrg.equals("")){  /* NOI18N */
        	//salesOrg = userInfoBean.getPrimarySalesOrg();
        	salesOrg = (String)session.getObjectFromSession(SessionConstants.SESSION_FORM_SALESORG);
        }
        
        formMaintenanceCustomDTO = new FormMaintenanceCustomDTO();
        formMaintenanceCustomDTO.setSalesOrg(salesOrg);
        
        
        try {
            formMaintenanceCustomDTO = getBaseAgreementDataManager().getAllForms(formMaintenanceCustomDTO);
            errorReport = formMaintenanceCustomDTO.getMessageReport();
			setTransactionInformation(formMaintenanceCustomDTO,session);
			if(null == errorReport){
			    viewBean = new FormMaintenanceViewBean(formMaintenanceCustomDTO);
			    setForwardName(ForwardNameConstants.PAGE_FORM_MAINTENANCE);
			}
			else{
			    viewBean = new MessageViewBean();
			    viewBean.setErrorReport(errorReport);
				setForwardName(ForwardNameConstants.PAGE_FORM_MAINTENANCE_ACTION);  //$NON-NLS-1$
			}
	
		}catch(ServiceException ex){
		    viewBean = handleServiceException(session, ex.getErrorReport());
		}
		
		session.storeObjectToSession(SessionConstants.SESSION_FORM_MAINTENANCE_VIEWBEAN,viewBean);
		session.storeObjectToSession(SessionConstants.SESSION_FORM_SALESORG,salesOrg);
		
		return viewBean;
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
		
		return ActionNameConstants.DISPLAY_FORM_LIST_ACTION;
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
		
		return true;
	}

}
