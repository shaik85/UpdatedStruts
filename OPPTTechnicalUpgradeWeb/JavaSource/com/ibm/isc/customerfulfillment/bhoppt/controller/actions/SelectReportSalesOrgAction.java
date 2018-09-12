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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SalesOrgActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementFormReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormNumbersBySalesOrgCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SalesOrgForReportsCustomDTO;

/**
 * Select Report SalesOrg Action
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SelectReportSalesOrgAction extends OPPTLongAction {
	  /** 
	 * Oexecute the action and return the oppt viewbean 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Gavaskar Bhojan
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
    protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
            throws Exception {
    	TreeMap statusMap = new TreeMap();
		TreeMap salesOrgMap = new TreeMap();
    	ErrorReport errorReport = null;
		OPPTViewBean viewBean = null;
		SalesOrgActionForm actionForm  = (SalesOrgActionForm)form;
		FormNumbersBySalesOrgCustomDTO formNumbersBySalesOrgCustomDTO = new FormNumbersBySalesOrgCustomDTO();
		SalesOrgForReportsCustomDTO salesOrgForReportsCustomDTO = new SalesOrgForReportsCustomDTO();
	    	errorReport = validate(actionForm);
	       	if(errorReport.size() != 0){
	    	     viewBean =  new ErrorViewBean();
				 viewBean.setErrorReport(errorReport);
				 setForwardName(ForwardNameConstants.PAGE_ERROR);  //$NON-NLS-1$ 
				 BaseAgreementFormReportViewBean baseAgreementFormReportViewBean = new BaseAgreementFormReportViewBean();
				 	// (BaseAgreementFormReportViewBean)session.getObjectFromSession(SessionConstants.SESSION_FORM_REPORT_VIEWBEAN);
				  salesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
 		 		  statusMap.putAll(OPPTStaticDataHolder.statusMap);
				 baseAgreementFormReportViewBean.setSalesOrg(salesOrgMap);
				 baseAgreementFormReportViewBean.setStatus(statusMap);
				 baseAgreementFormReportViewBean.setFormNumbers(new TreeMap());
				 baseAgreementFormReportViewBean.setSelectedSalesOrg(actionForm.getSalesOrganization());				 
				 session.storeObjectToSession(SessionConstants.SESSION_FORM_SALESORG,actionForm.getSalesOrganization());
				 session.setCurrentViewBean(baseAgreementFormReportViewBean);				 
				 session.storeObjectToSession(SessionConstants.SESSION_FORM_REPORT_VIEWBEAN,baseAgreementFormReportViewBean);
				 session.setFirstActionForwardName(ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS_FORMNUMBER);
	    	  }
	    	else{
	    		 try{
	    	    	
	    		 		BaseAgreementFormReportViewBean view = new BaseAgreementFormReportViewBean();
	    		 		salesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
	    		 		statusMap.putAll(OPPTStaticDataHolder.statusMap);
	    		 		//view.setFormNumbers(getBaseAgreementDataManager().getFormNumbersBySalesOrg(actionForm.getSalesOrganization()));
	    		 		//formNumbersBySalesOrgCustomDTO = getBaseAgreementDataManager().getFormNumbersBySalesOrg(actionForm.getSalesOrganization());
	    		 		salesOrgForReportsCustomDTO.setSalesOrg(actionForm.getSalesOrganization());
	    		 		formNumbersBySalesOrgCustomDTO = getBaseAgreementDataManager().getFormNumbersBySalesOrg(salesOrgForReportsCustomDTO);
	    		 		view.setFormNumbers(formNumbersBySalesOrgCustomDTO.getFormNumbersMap());
	    		 		view.setSalesOrg(salesOrgMap);
	    		 		view.setStatus(statusMap);
	    		 		view.setDefaultSalesOrg(actionForm.getSalesOrganization());
		    	session.storeObjectToSession(SessionConstants.SESSION_FORM_REPORT_VIEWBEAN,view);
		    	setForwardName(ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS_FORMNUMBER); 
		    	viewBean = view;
	    }catch(ServiceException se){
	    	handleServiceException(session,se.getErrorReport());
	    }
	  }
		return viewBean;
    }
    /**
     * 
     *validate
     *
     *@author Ravi Yandapalli
     *
     * Dec 27, 20063:21:55 PM
     * @param actionform
     * @return
     */
    public ErrorReport validate(SalesOrgActionForm actionform) {
		ErrorReport errorReport = new ErrorReport();
		if(isSelectEmpty(actionform.getSalesOrganization())){
			errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF01, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		
		return errorReport;
	}
    /**
     * getBaseAgreementManager
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
	 * Return the action name 
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
		return ActionNameConstants.BASEAGREEMENT_REPORT_SELECT_SALESORG;
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
		String actualForward = ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS_FORMNUMBER;
		TreeMap statusMap = new TreeMap();
		TreeMap salesOrgMap = new TreeMap();
		salesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
		UserInfoDataBean userInfoDataBean= session.getUserInfo();
		statusMap.putAll(OPPTStaticDataHolder.statusMap);
		SalesOrgForReportsCustomDTO salesOrgForReportsCustomDTO = new SalesOrgForReportsCustomDTO();
		FormNumbersBySalesOrgCustomDTO  customDto = new FormNumbersBySalesOrgCustomDTO ();
		if(null != viewBean && null != currentForward){
			if(viewBean instanceof BaseAgreementFormReportViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}
		if (!valid) {
		
			 BaseAgreementFormReportViewBean view = new BaseAgreementFormReportViewBean();
			 view.setSalesOrg(salesOrgMap);
			 view.setStatus(statusMap);
			 salesOrgForReportsCustomDTO.setSalesOrg(userInfoDataBean.getPrimarySalesOrg());
			  try{
			  	customDto  = getBaseAgreementDataManager().getFormNumbersBySalesOrg(salesOrgForReportsCustomDTO);
			}catch(Exception e){e.printStackTrace();}
			view.setFormNumbers(customDto.getFormNumbersMap());
			session.setCurrentForward(actualForward);
			valid = true;
		}
    	
    	
    return valid;
    }
}
