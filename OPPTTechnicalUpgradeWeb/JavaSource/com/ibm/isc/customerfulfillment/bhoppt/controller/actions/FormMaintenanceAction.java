/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
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
 * This is to display the Form Maintenance screen 
 * 
 * @author Nayanatara L Pai
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FormMaintenanceAction extends OPPTAction {

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Oct 12, 2006 
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
	 protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception
	    {
	        OPPTViewBean  viewBean = null ; 
	        ErrorReport errorReport = null;
	        FormMaintenanceCustomDTO formMaintenanceCustomDTO = null;
	        String salesOrg = null;
	        UserInfoDataBean userInfoBean = null;
	        	                
	        userInfoBean =session.getUserInfo();
	        
	        //salesOrg = (String)session.getObjectFromSession(SessionConstants.SESSION_FORM_SALESORG);
	       // if(salesOrg == null || salesOrg.equals("")){
	        	salesOrg = userInfoBean.getPrimarySalesOrg(); 
	       // }
	        
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
	 * date Oct 12, 2006 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Nayanatara L Pai
	 * @return String
	 * 
	 */
	protected String getActionName() {
		
		return ActionNameConstants.FORM_MAINTENANCE_ACTION;
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
