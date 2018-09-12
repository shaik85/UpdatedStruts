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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ReportByModificationTypeActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementModificationReportViewBean;
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
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationsBySalesOrgCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SalesOrgForReportsCustomDTO;

/**
 * Generate Reports By  Modification Type Action
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class GenerateReportsByModTypeAction extends OPPTLongAction {

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
		BaseAgreementModificationReportViewBean view = null;
		ModificationTypeCustomDTO customDto = null;
		ReportByModificationTypeActionForm actionForm = (ReportByModificationTypeActionForm)form;	
		setTransactionInformation(baseAgreementReportCustomDTO, session);
		baseAgreementReportCustomDTO.setStatus( actionForm.getStatus());
		if(null != actionForm.getModTypeCode() && !(actionForm.getModTypeCode().equals(""))){
			String[] modTypes = actionForm.getModTypeCode().split(",");
			baseAgreementReportCustomDTO.setModTypes(modTypes);
		}
		else{
		     baseAgreementReportCustomDTO.setModTypes(actionForm.getTypeCode());
		}
		if(actionForm.getSalesOrg().trim().length() > 0){
			baseAgreementReportCustomDTO.setSalesOrg(actionForm.getSalesOrg());
	     }
		else {
			   UserInfoDataBean userInfoDataBean= session.getUserInfo();
			   baseAgreementReportCustomDTO.setSalesOrg(userInfoDataBean.getPrimarySalesOrg());
		}
		errorReport = validate(actionForm);
		if(null != session.getObjectFromSession(SessionConstants.SESSION_MODTYPE_REPORT_VIEWBEAN)){
			 view = (BaseAgreementModificationReportViewBean)session.getObjectFromSession(SessionConstants.SESSION_MODTYPE_REPORT_VIEWBEAN);
	       }
	  	for(Iterator i = view.getModTypes().keySet().iterator();i.hasNext();){
	  		String key = (String)i.next();
	  	    customDto= (ModificationTypeCustomDTO)view.getModTypes().get(key);
	  	   }
		if(null ==  customDto){
     		customDto = new ModificationTypeCustomDTO();
     		customDto.setSelectedSalesOrg((String)session.getObjectFromSession(SessionConstants.SESSION_FORM_SALESORG));
     	}
		if(errorReport.size() != 0){
		    viewBean = new ErrorViewBean();
			viewBean.setErrorReport(errorReport);
			setForwardName(ForwardNameConstants.PAGE_ERROR);
			BaseAgreementModificationReportViewBean baseAgreementModificationReportViewBean = (BaseAgreementModificationReportViewBean)session.getObjectFromSession(SessionConstants.SESSION_MODTYPE_REPORT_VIEWBEAN);
			baseAgreementModificationReportViewBean.setSelectedStatus(actionForm.getStatus());
			baseAgreementModificationReportViewBean.setActionForm(actionForm);
			session.setCurrentViewBean(baseAgreementModificationReportViewBean);
			session.setFirstActionForwardName(ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS_MODTYPE);
		}		
	  		else if(!actionForm.getSalesOrg().equals(customDto.getSelectedSalesOrg())){
	  			errorReport = new ErrorReport();
	  			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF250, OPPTMessageCatalog.TYPE_PRESENTATION),null);
	  			view.setSelectedSalesOrg(actionForm.getSalesOrg());
	  			view.setSelectedStatus(actionForm.getStatus());
	  			view.setActionForm(actionForm);
			  	viewBean = view ;
			    viewBean = new ErrorViewBean();
	  			viewBean.setErrorReport(errorReport);
	  			setForwardName(ForwardNameConstants.PAGE_ERROR);
	  			session.setFirstActionForwardName(ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS_MODTYPE);
	  		}else{
	  			  try{
	  			  		baseAgreementReportsCustomDTO = getReportManager().getBAReportsbyModTypes(baseAgreementReportCustomDTO);
	  			  		setForwardName(ForwardNameConstants.ACTION_REPORT_GENERATOR);
	  			  		baseAgreementReportExcelViewBean.setBaseAgreementReportsCustomDTO(baseAgreementReportsCustomDTO);
	  			  		session.setCurrentViewBean(baseAgreementReportExcelViewBean);
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
 *validate
 *
 *@author Ravi Yandapalli
 *
 * Dec 27, 20062:59:35 PM
 * @param actionForm
 * @return
 */
  
    public ErrorReport validate(ReportByModificationTypeActionForm actionForm) {
	 	String temp[] = null;
	 	if(actionForm.getTypeCode() != null){
	 		temp = actionForm.getTypeCode();
	 	}
		ErrorReport errorReport = new ErrorReport();
	 	if(isSelectEmpty(actionForm.getSalesOrg())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF01, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
	 	if(isSelectEmpty(actionForm.getStatus())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF246, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		} 
	 	if(temp==null  && isFieldEmpty(actionForm.getModTypeCode())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF248, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		} 
	 	if(temp !=null  && !isFieldEmpty(actionForm.getModTypeCode())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF252, OPPTMessageCatalog.TYPE_PRESENTATION),null);
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
		return ActionNameConstants.GENERATE_REPORTS_BYMODTYPE;
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
    protected boolean validateCurrentViewContent(OPPTSession session) {
    	boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS_MODTYPE;
		TreeMap statusMap = new TreeMap();
		TreeMap salesOrgMap = new TreeMap();
		TreeMap modTypeTreeMap = new TreeMap();
		salesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
		statusMap.putAll(OPPTStaticDataHolder.statusMap);
		UserInfoDataBean userInfoDataBean= session.getUserInfo();
		
		if(null != viewBean && null != currentForward){
			if(viewBean instanceof BaseAgreementModificationReportViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}
		if (!valid) {
			BaseAgreementModificationReportViewBean baseAgreementModificationReportViewBean= new BaseAgreementModificationReportViewBean();
			ModificationsBySalesOrgCustomDTO modificationsBySalesOrgCustomDTO = new ModificationsBySalesOrgCustomDTO();
			SalesOrgForReportsCustomDTO salesOrgForReportsCustomDTO = new SalesOrgForReportsCustomDTO();
			try{
				//modificationsBySalesOrgCustomDTO = getBaseAgreementDataManager().getModificationsBySalesOrg(userInfoDataBean.getPrimarySalesOrg());
				salesOrgForReportsCustomDTO.setSalesOrg(userInfoDataBean.getPrimarySalesOrg());
				modificationsBySalesOrgCustomDTO = getBaseAgreementDataManager().getModificationsBySalesOrg(salesOrgForReportsCustomDTO);
				modTypeTreeMap = modificationsBySalesOrgCustomDTO.getModificationsMap();
			}
			catch(Exception e){
				ErrorReport error = new ErrorReport();
				error.put("",e);
				 ServiceException ex = new ServiceException();
				ex.setErrorReport(error);
		    	handleServiceException(session,ex.getErrorReport());
				}
			baseAgreementModificationReportViewBean.setSalesOrg(salesOrgMap);
			baseAgreementModificationReportViewBean.setStatus(statusMap);
			baseAgreementModificationReportViewBean.setDefaultSalesOrg(userInfoDataBean.getPrimarySalesOrg());
			baseAgreementModificationReportViewBean.setModTypes(modTypeTreeMap);
		    session.setCurrentViewBean(baseAgreementModificationReportViewBean);
		    session.setCurrentForward(actualForward);
			valid = true;
		}
    	    	
    return valid;
    }

}
