/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.StringTokenizer;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.EditFormActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.FormDetailViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.FormMaintenanceViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO;

/**
 * This is to edit a form  
 * 
 * @author Nayanatara L Pai
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SaveEditFormAction extends OPPTAction {

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Oct 14, 2006 
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

		ErrorReport errorReport = null;
		OPPTViewBean viewBean = null;
		FormDetailViewBean formDetailViewBean = null;
		FormDetailsCustomDTO formDetailsCustomDTO = null;
		EditFormActionForm actionForm =(EditFormActionForm)form;
		FormMaintenanceViewBean formMaintenanceViewBean = null;
		String salesOrganisation= null;
		String salesOrg = null;
		String formNumber = null;
		
		formMaintenanceViewBean = (FormMaintenanceViewBean)session.getObjectFromSession(SessionConstants.SESSION_FORM_MAINTENANCE_VIEWBEAN);
		formDetailViewBean = (FormDetailViewBean)session.getObjectFromSession(SessionConstants.SESSION_FORM_DETAIL_VIEWBEAN);
		salesOrg = formMaintenanceViewBean.getSelectedSalesOrg();
		formNumber = formDetailViewBean.getFormNumber();
		
        StringTokenizer salesOrgToken = new StringTokenizer(salesOrg,"-");  /* NOI18N */
        while(salesOrgToken.hasMoreTokens()){
            salesOrgToken.nextToken();
            salesOrganisation = salesOrgToken.nextToken();
        }
        formDetailsCustomDTO = new FormDetailsCustomDTO();
        
        formDetailsCustomDTO.setSalesOrg(salesOrganisation);
		formDetailsCustomDTO.setFormNumber(formNumber);
		formDetailsCustomDTO.setFormShortDescription(actionForm.getFormShortDescription());
        formDetailsCustomDTO.setFormLongDescription(actionForm.getFormLongDescription());
        formDetailsCustomDTO.setLanguage("");  /* NOI18N */
        try{
        	formDetailsCustomDTO = getBaseAgreementDataManager().updateForm(formDetailsCustomDTO);
        	errorReport = formDetailsCustomDTO.getMessageReport();
        	if(null == errorReport){
        		setForwardName(ForwardNameConstants.PAGE_DISPLAY_FORM_LIST_ACTION);
        	}
		}
		catch(ServiceException se){
			viewBean = new ErrorViewBean();
			viewBean.setErrorReport(se.getErrorReport());
			setForwardName(ForwardNameConstants.PAGE_ERROR);
		}
		
		return viewBean;
	}
  /**
   *getBaseAgreementDataManager
   *
   *@author Ravi Yandapalli
   *
   * Dec 27, 20063:07:08 PM
   * @return
   * @throws Exception
   */
	 protected BaseAgreementDataManager getBaseAgreementDataManager() throws Exception {
        BaseAgreementDataManagerHome baseAgreementDataManagerHome = (BaseAgreementDataManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("BaseAgreementDataManagerHome");  //$NON-NLS-1$
		return baseAgreementDataManagerHome.create();
	}
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Oct 14, 2006 
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
		
		return ActionNameConstants.SAVE_EDIT_FORM_ACTION;
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
