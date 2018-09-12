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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ReportTypeActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementFormReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementModificationReportViewBean;
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
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormNumbersBySalesOrgCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationsBySalesOrgCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SalesOrgForReportsCustomDTO;
/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAgreementReportChoiceAction extends OPPTLongAction{
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
    	    	
    	ErrorReport errorReport = null;
		OPPTViewBean viewBean = null;
		int type = 0;
		ReportTypeActionForm actionForm  = (ReportTypeActionForm)form;
		
		errorReport = validate(actionForm);
		
		if(errorReport.size() != 0){
			viewBean = new ErrorViewBean();
			viewBean.setErrorReport(errorReport);
			setForwardName(ForwardNameConstants.PAGE_ERROR);
			session.setFirstActionForwardName(ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS);
		}
		else{
          try{
        	 if(null != actionForm.getReportType()){
        	   type  = Integer.parseInt(actionForm.getReportType());
        	 }
          }catch(Exception e){e.printStackTrace();}
		  session.setCurrentForward(getReportType(type));
		  session.setCurrentViewBean(getViewBean(type,session));
		  viewBean = getViewBean(type,session);
		  setForwardName(getReportType(type));  
		  session.setFirstActionForwardName(ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS);
		  session.storeObjectToSession("reportType",getReportType(type));
		}
		  return viewBean;
    }

    /**
     *validate
     *@author Ravi Yandapalli
     *Dec 27, 2006  4:47:51 PM
     *@return
     */
    public ErrorReport validate(ReportTypeActionForm actionForm) {
    	ErrorReport errorReport = new ErrorReport();
    	 if(null == actionForm.getReportType()){
            errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF258, OPPTMessageCatalog.TYPE_PRESENTATION), null);
            
           
     }
    	 return errorReport;	
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
		return ActionNameConstants.BASEAGREEMENT_REPORT_CHOICE;
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
     * getBaseAgreementManager
     * 
     * @throws java.lang.Exception
     * @return BaseAgreementManager
     * @author Ravi Yandapalli
     */
	private String  getReportType(int type){
		TreeMap statusMap = new TreeMap();
		TreeMap salesOrgMap = new TreeMap();
		salesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
		statusMap.putAll(OPPTStaticDataHolder.statusMap);
		String initiator="";
		switch(type){
			case Constants.BA_REPORT:
						initiator = ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS_ALL;
						break;
			case Constants.BA_REPORT_FORMNUMBER:
			
						initiator = ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS_FORMNUMBER;
						break;
			case Constants.BA_REPORT_MODIFICATION:
						initiator = ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS_MOD;
						break;
						
			case Constants.BA_REPORT_MODTYPE:
			            initiator = ForwardNameConstants.PAGE_BASEAGREEMENT_REPORTS_MODTYPE;
			           break;
		    default :
                break;
        }
		return initiator;
	}
	 /**
     * validate current view bwan
     * 
     * 
     * @return
     * @author Ravi Yandapalli
     * @param session
     */ 
	private OPPTViewBean  getViewBean(int type,OPPTSession session)throws Exception{
		OPPTViewBean lOPPTViewBean= new OPPTViewBean();
		TreeMap statusMap = new TreeMap();
		TreeMap salesOrgMap = new TreeMap();
		salesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
		statusMap.putAll(OPPTStaticDataHolder.statusMap);
		UserInfoDataBean userInfoDataBean= session.getUserInfo();
		SalesOrgForReportsCustomDTO salesOrgForReportsCustomDTO = new SalesOrgForReportsCustomDTO();
		switch(type){
			case Constants.BA_REPORT:
			            BaseAgreementReportViewBean baseAgreementReportViewBean= new BaseAgreementReportViewBean();
						baseAgreementReportViewBean.setStatus(statusMap);
						baseAgreementReportViewBean.setSalesOrg(salesOrgMap);
			            return baseAgreementReportViewBean;
					
			case Constants.BA_REPORT_FORMNUMBER:
			           BaseAgreementFormReportViewBean baseAgreementFormReportViewBean= new BaseAgreementFormReportViewBean();
					   TreeMap formNumberTreeMap = new TreeMap();
					   FormNumbersBySalesOrgCustomDTO formNumbersBySalesOrgCustomDTO = new FormNumbersBySalesOrgCustomDTO();
					   try{
					   	//formNumbersBySalesOrgCustomDTO = getBaseAgreementDataManager().getFormNumbersBySalesOrg(userInfoDataBean.getPrimarySalesOrg());
					   	salesOrgForReportsCustomDTO.setSalesOrg(userInfoDataBean.getPrimarySalesOrg());
					   	formNumbersBySalesOrgCustomDTO = getBaseAgreementDataManager().getFormNumbersBySalesOrg(salesOrgForReportsCustomDTO);
					   	formNumberTreeMap = formNumbersBySalesOrgCustomDTO.getFormNumbersMap();
						}
					   catch(ServiceException e){
				    	handleServiceException(session,e.getErrorReport());
				    }
					   baseAgreementFormReportViewBean.setSalesOrg(salesOrgMap);
					   baseAgreementFormReportViewBean.setStatus(statusMap);
					   baseAgreementFormReportViewBean.setFormNumbers(formNumberTreeMap);
					   baseAgreementFormReportViewBean.setDefaultSalesOrg(userInfoDataBean.getPrimarySalesOrg());
					   session.storeObjectToSession(SessionConstants.SESSION_FORM_REPORT_VIEWBEAN,baseAgreementFormReportViewBean);
					   return baseAgreementFormReportViewBean;
						
			case Constants.BA_REPORT_MODIFICATION:
						BaseAgreementReportViewBean baseAgreementReportViewBean1 = new BaseAgreementReportViewBean();
						baseAgreementReportViewBean1.setStatus(statusMap);
						baseAgreementReportViewBean1.setSalesOrg(salesOrgMap);
						
						return baseAgreementReportViewBean1;
						
						
			case Constants.BA_REPORT_MODTYPE:
				        TreeMap modTypeTreeMap = new TreeMap();
			         	BaseAgreementModificationReportViewBean baseAgreementModificationReportViewBean= new BaseAgreementModificationReportViewBean();
						ModificationsBySalesOrgCustomDTO modificationsBySalesOrgCustomDTO = new ModificationsBySalesOrgCustomDTO();
						try{
							//modificationsBySalesOrgCustomDTO = getBaseAgreementDataManager().getModificationsBySalesOrg(userInfoDataBean.getPrimarySalesOrg());
							salesOrgForReportsCustomDTO.setSalesOrg(userInfoDataBean.getPrimarySalesOrg());
							modificationsBySalesOrgCustomDTO = getBaseAgreementDataManager().getModificationsBySalesOrg(salesOrgForReportsCustomDTO);
							modTypeTreeMap = modificationsBySalesOrgCustomDTO.getModificationsMap();
						}catch(ServiceException e){
					    	handleServiceException(session,e.getErrorReport());
					    }
						baseAgreementModificationReportViewBean.setSalesOrg(salesOrgMap);
						baseAgreementModificationReportViewBean.setStatus(statusMap);
						baseAgreementModificationReportViewBean.setDefaultSalesOrg(userInfoDataBean.getPrimarySalesOrg());
						baseAgreementModificationReportViewBean.setModTypes(modTypeTreeMap);
						session.storeObjectToSession(SessionConstants.SESSION_MODTYPE_REPORT_VIEWBEAN,baseAgreementModificationReportViewBean);
			           return baseAgreementModificationReportViewBean;
		    default :
                break;
        }
		return lOPPTViewBean;
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
    return true;
    }


}
