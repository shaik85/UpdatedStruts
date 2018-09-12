/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.Iterator;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ReportByFormNumberActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementFormReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementReportExcelViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
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
import com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormNumbersBySalesOrgCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SalesOrgForReportsCustomDTO;


/**
 * Generate Reports By Form Number Action
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class GenerateReportsByFormNumberAction extends OPPTLongAction {
	 /** 
	 * Overridden method - it's return the baseagreementviewbean 
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
         	    	
        ErrorReport errorReport = null;
		OPPTViewBean viewBean =  null;
		BaseAgreementReportExcelViewBean baseAgreementReportExcelViewBean = new BaseAgreementReportExcelViewBean();
		BaseAgreementReportCustomDTO baseAgreementReportCustomDTO= new BaseAgreementReportCustomDTO();
		BaseAgreementReportsCustomDTO baseAgreementReportsCustomDTO = new BaseAgreementReportsCustomDTO();
		BaseAgreementFormReportViewBean view = null;
		FormDetailsCustomDTO customDto = null;
		setTransactionInformation(baseAgreementReportCustomDTO, session);
		ReportByFormNumberActionForm actionForm = (ReportByFormNumberActionForm)form;	
		UserInfoDataBean userInfoDataBean= session.getUserInfo();
		if(null != actionForm.getSalesOrg()&&actionForm.getSalesOrg().length()>0){
			baseAgreementReportCustomDTO.setSalesOrg(actionForm.getSalesOrg());
        }
		else{
			baseAgreementReportCustomDTO.setSalesOrg(userInfoDataBean.getPrimarySalesOrg());
		}
		baseAgreementReportCustomDTO.setStatus( actionForm.getStatus());
		if(null != actionForm.getFormInput() && !(actionForm.getFormInput().equals(""))){  /* NOI18N */
			String[] formInputs =  actionForm.getFormInput().split(",");  /* NOI18N */
			baseAgreementReportCustomDTO.setFormNumbers(formInputs);
		}
		else{
		 	baseAgreementReportCustomDTO.setFormNumbers(actionForm.getFormNumber());
		}
		errorReport = validate(actionForm);
			if(null != session.getObjectFromSession(SessionConstants.SESSION_FORM_REPORT_VIEWBEAN)){
    	    view = (BaseAgreementFormReportViewBean)session.getObjectFromSession(SessionConstants.SESSION_FORM_REPORT_VIEWBEAN);
    	 }
	     	for(Iterator i = view.getFormNumbers().keySet().iterator();i.hasNext();){
	  		  String key = (String)i.next();
	  	      customDto= (FormDetailsCustomDTO)view.getFormNumbers().get(key);
	  	       }
	    	if(null ==  customDto){
	     		customDto = new FormDetailsCustomDTO();
	     		customDto.setSalesOrg((String)session.getObjectFromSession(SessionConstants.SESSION_FORM_SALESORG));
	     	}
		 if(errorReport.size() != 0){
		     viewBean = new ErrorViewBean();
				viewBean.setErrorReport(errorReport);
				setForwardName(ForwardNameConstants.PAGE_ERROR);
				BaseAgreementFormReportViewBean baseAgreementFormReportViewBean = (BaseAgreementFormReportViewBean)session.getObjectFromSession(SessionConstants.SESSION_FORM_REPORT_VIEWBEAN);
				baseAgreementFormReportViewBean.setSelectedStatus(actionForm.getStatus());
				baseAgreementFormReportViewBean.setActionForm(actionForm);
				session.setCurrentViewBean(baseAgreementFormReportViewBean);
				session.setFirstActionForwardName(ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS_FORMNUMBER);	
		}
		else if(!actionForm.getSalesOrg().equals(customDto.getSalesOrg())){
		  			errorReport = new ErrorReport();
		  			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF250, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		  			view.setSelectedSalesOrg(actionForm.getSalesOrg());
		  			view.setSelectedStatus(actionForm.getStatus());
		  			view.setActionForm(actionForm);
				  	session.setCurrentViewBean(view);
				   	viewBean = new ErrorViewBean();
				  	viewBean.setErrorReport(errorReport);
				  	setForwardName(ForwardNameConstants.PAGE_ERROR);
				  	session.setFirstActionForwardName(ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS_FORMNUMBER);
	  		
		  	 }
		  else{
		           try{
		           		baseAgreementReportsCustomDTO = getReportManager().getBAReportsbyFormNumbers(baseAgreementReportCustomDTO);
		           		session.setCurrentViewBean(baseAgreementReportExcelViewBean);
		         		setForwardName(ForwardNameConstants.ACTION_REPORT_GENERATOR);
		         		baseAgreementReportExcelViewBean.setBaseAgreementReportsCustomDTO(baseAgreementReportsCustomDTO);
		         		session.storeObjectToSession(SessionConstants.SESSION_EXCEL_VIEWBEAN,baseAgreementReportExcelViewBean);
		         		viewBean = baseAgreementReportExcelViewBean;
		           		}catch(ServiceException e){
		           			handleServiceException(session,e.getErrorReport());
		           			
		           		}
		           		}
        return viewBean;
    }
    /**
     * 
     * Dec 27, 2006
     * validate
     * @param actionForm
     * @return
     */

    public ErrorReport validate(ReportByFormNumberActionForm actionForm) {
	 	String temp[] = null;
	 	if(actionForm.getFormNumber() != null){
	 		temp = actionForm.getFormNumber();
	 	}
	 	ErrorReport errorReport = new ErrorReport();
	 	if(isSelectEmpty(actionForm.getSalesOrg())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF01, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
	 	if(isSelectEmpty(actionForm.getStatus())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF246, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		} 
		if( temp==null  && isFieldEmpty(actionForm.getFormInput())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF247, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
		if( temp!=null  && !isFieldEmpty(actionForm.getFormInput())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF251, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
	 	return errorReport;
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
		return ActionNameConstants.GENERATE_REPORTS_BYFORMNUMBER;
	}
	/**
     * getUserManager
     * 
     * @throws java.lang.Exception
     * @return BaseAgreementManager
     * @author Ravi Yandapalli
     */
    protected ReportManager getReportManager() throws Exception {
    	ReportManagerHome reportManagerHome = (ReportManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("ReportManagerHome");  //$NON-NLS-1$
		return reportManagerHome.create();
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
     * validate current view bwan
     * 
     * 
     * @return
     * @author Ravi Yandapalli
     * @param session
     */  
    
    protected boolean validateCurrentViewContent(OPPTSession session){
    	boolean valid = false;
    	OPPTViewBean viewBean = session.getCurrentViewBean();
		viewBean.setErrorReport(null);
		String currentForward = session.getCurrentForward();
		String actualForward = ForwardNameConstants.PAGE_MESSAGE;//PAGE_BASEAGREEMENT_REPORTS_FORMNUMBER;
		TreeMap statusMap = new TreeMap();
		TreeMap salesOrgMap = new TreeMap();
		TreeMap formNumbersMap = new TreeMap();
		salesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
		statusMap.putAll(OPPTStaticDataHolder.statusMap);
		UserInfoDataBean userInfoDataBean= session.getUserInfo();
		if(null != viewBean && null != currentForward){
			if(viewBean instanceof BaseAgreementFormReportViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}
		if (!valid) {
			viewBean = new MessageViewBean();
			BaseAgreementFormReportViewBean baseAgreementFormReportViewBean= new BaseAgreementFormReportViewBean();
			FormNumbersBySalesOrgCustomDTO formNumbersBySalesOrgCustomDTO = new FormNumbersBySalesOrgCustomDTO();
			SalesOrgForReportsCustomDTO salesOrgForReportsCustomDTO = new SalesOrgForReportsCustomDTO();
			try{
			   	//formNumbersBySalesOrgCustomDTO = getBaseAgreementDataManager().getFormNumbersBySalesOrg(userInfoDataBean.getPrimarySalesOrg());
				salesOrgForReportsCustomDTO.setSalesOrg(userInfoDataBean.getPrimarySalesOrg());
				formNumbersBySalesOrgCustomDTO = getBaseAgreementDataManager().getFormNumbersBySalesOrg(salesOrgForReportsCustomDTO);
			   	formNumbersMap = formNumbersBySalesOrgCustomDTO.getFormNumbersMap();
			} catch(Exception e){
								 
				ErrorReport error = new ErrorReport();
				error.put("",e);
				 ServiceException ex = new ServiceException();
				ex.setErrorReport(error);
		    	handleServiceException(session,ex.getErrorReport());
		    }
			baseAgreementFormReportViewBean.setSalesOrg(salesOrgMap);
			baseAgreementFormReportViewBean.setStatus(statusMap);
			baseAgreementFormReportViewBean.setFormNumbers(formNumbersMap);
			baseAgreementFormReportViewBean.setDefaultSalesOrg(userInfoDataBean.getPrimarySalesOrg());
			session.setCurrentForward(actualForward);
			valid = true;
		}	
    return valid;
    }
}
