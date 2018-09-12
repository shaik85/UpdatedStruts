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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ReportInfoActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementReportExcelViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportsCustomDTO;

	/**
	 * Generate Modification Report Action
	 * @author Administrator
	 *
	 * TODO To change the template for this generated type comment go to
	 * Window - Preferences - Java - Code Style - Code Templates
	 */
	public class GenerateModificationReportAction extends OPPTLongAction {
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
			ReportInfoActionForm actionForm = (ReportInfoActionForm)form;	
			baseAgreementReportCustomDTO.setSalesOrg(actionForm.getSalesOrg());
			baseAgreementReportCustomDTO.setStatus( actionForm.getStatus());
			errorReport = validate(actionForm);
			if(errorReport.size() != 0){
			    viewBean = new ErrorViewBean();
				viewBean.setErrorReport(errorReport);
				setForwardName(ForwardNameConstants.PAGE_ERROR);
				session.setFirstActionForwardName(ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS_MOD);
			}else{
			try{
			   	baseAgreementReportsCustomDTO =	getReportManager().getAllBAModificationReports(baseAgreementReportCustomDTO);
			 	setForwardName(ForwardNameConstants.ACTION_REPORT_GENERATOR);
			 	baseAgreementReportExcelViewBean.setBaseAgreementReportsCustomDTO(baseAgreementReportsCustomDTO);
			 	session.setCurrentViewBean(baseAgreementReportExcelViewBean);
			 	session.setFirstActionForwardName(ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS);
			 	viewBean = baseAgreementReportExcelViewBean;
			}catch(ServiceException ex){
				viewBean = handleServiceException(session, ex.getErrorReport());
			}
		}
			return viewBean;
	    }
/**
 * Dec 27, 2006
 * validate
 * @param actionForm
 * @return
 */
	    public ErrorReport validate(ReportInfoActionForm actionForm) {
		 	
			ErrorReport errorReport = new ErrorReport();
		 	if(isSelectEmpty(actionForm.getSalesOrg())){
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF01, OPPTMessageCatalog.TYPE_PRESENTATION),null);
			}
		 	if(isSelectEmpty(actionForm.getStatus())){
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF246, OPPTMessageCatalog.TYPE_PRESENTATION),null);
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
			return ActionNameConstants.GENERATE_REPORTS_MODIFICATION;
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
			String actualForward = ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS_MOD;
			TreeMap statusMap = new TreeMap();
			TreeMap salesOrgMap = new TreeMap();
			salesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
			statusMap.putAll(OPPTStaticDataHolder.statusMap);
			if(null != viewBean && null != currentForward){
				if(viewBean instanceof BaseAgreementReportViewBean && currentForward.equals(actualForward)){
					valid = true;
				}
			}
			if (!valid) {
				BaseAgreementReportViewBean baseAgreementReportViewBean = new BaseAgreementReportViewBean();
				baseAgreementReportViewBean.setStatus(statusMap);
				baseAgreementReportViewBean.setSalesOrg(salesOrgMap);
			    session.setCurrentViewBean(baseAgreementReportViewBean);
			    session.setCurrentForward(actualForward);
				valid = true;
			}
	    return valid;
	    }
	}


