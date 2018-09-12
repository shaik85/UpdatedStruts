/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementStatusConstant;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.BaseAgreementActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementDetailViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementFormViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SearchBaseAgreementViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO;


/**
 * BaseAgreementRegisterAction
 * 
 * <br/><b>Known Bugs </b> <br/>
 * 
 * <br/>
 * 
 * <PRE>
 * 
 * date jun 20,2006
 * 
 * revision date author reason
 * 
 * </PRE>
 * 
 * <br/>
 * 
 * @author Gavaskar Bhojan
 *  
 */
public class BaseAgreementRegisterAction extends OPPTLongAction
{
    /** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date jun 22, 2006 
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
    protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
    	
    	OPPTViewBean viewBean = null;
		ErrorReport errorReport = null;
		Date acceptedDate = null;
		Date expirationDate = null;
		SimpleDateFormat format = null;
		BaseAgreementDetailsCustomDTO customDto = null;
		BaseAgreementActionForm baseAgreementActionForm	=(BaseAgreementActionForm)form;
		customDto = new BaseAgreementDetailsCustomDTO();
	    format = new SimpleDateFormat("MM/dd/yyyy");  /* NOI18N */
	    
	    boolean amend = false;
	    String currentForward = session.getCurrentForward();
	    if(currentForward != null && currentForward.equals(ForwardNameConstants.PAGE_AMEND_BASEAGREEMENT)) {
	    	amend = true;
	    }
	    
	    try
		{
	    	if(null != baseAgreementActionForm.getAcceptedDate()){
	    	acceptedDate = format.parse(baseAgreementActionForm.getAcceptedDate());
	    	}
		}catch(Exception e)
		{ }
		customDto.setAcceptedDate(acceptedDate);
		// customDto.setAgreementId(baseAgreementActionForm.getAgreementId());
		customDto.setFormNumber(baseAgreementActionForm.parseFormNumber(baseAgreementActionForm.getFormNo()));
//		 For Sales Org
        StringTokenizer tok = new StringTokenizer(baseAgreementActionForm.getSalesOrg(),"-");  /* NOI18N */
        while(tok.hasMoreTokens()) {
        	customDto.setSalesOrganization(tok.nextToken());
        	// The last token is the actual value
        }
		customDto.setAgreementId(baseAgreementActionForm.getAgreementId());
		customDto.setAgreementNumber(baseAgreementActionForm.getAgreementNumber());
		customDto.setAgreementStatus(baseAgreementActionForm.getAgreementStatus());
		customDto.setBranchOffice(baseAgreementActionForm.getBranchOffice());
		customDto.setCoverageType(baseAgreementActionForm.getCoverageType());
		customDto.setCreatedBy(baseAgreementActionForm.getCreatedBy());
		customDto.setCustomerName(baseAgreementActionForm.getCustomerName());
		customDto.setCustomerNumber(baseAgreementActionForm.getCustomerNumber());
		customDto.setCustomerRepresentative(baseAgreementActionForm.getCustomerRepresentive());
		customDto.setEnterpriseNumber(baseAgreementActionForm.getEnterpriseNumber());
		customDto.setEnterpriseName(baseAgreementActionForm.getEnterpriseName());
		customDto.setFileNumber(null);
		customDto.setFormLongDescription(baseAgreementActionForm.getFormLongDescripton());
		customDto.setFormShortDescription(baseAgreementActionForm.getFormShortDescripton());
		customDto.setImageReferenceNumber(baseAgreementActionForm.getImageReferenceNumber());
		customDto.setIsElectronicSumbmitter(baseAgreementActionForm.getIsElectronicSubmitter());
		customDto.setOneWay(baseAgreementActionForm.getOneWay());
		customDto.setLegacyCustomerNumber(baseAgreementActionForm.getLegacyCustomerNumber());
		customDto.setInac(baseAgreementActionForm.getInac());
		customDto.setAgreementStatus(BaseAgreementStatusConstant.Active);
	/*	if("Select one".equals(baseAgreementActionForm.getLanguage())){
			customDto.setLanguage(" ");
			
		}else{
			customDto.setLanguage(baseAgreementActionForm.getLanguage());	
		}*/
		
		
		try
		{
			if(null != baseAgreementActionForm.getExpirationDate() && baseAgreementActionForm.getExpirationDate().length() > 0){
	    		expirationDate = format.parse(baseAgreementActionForm.getExpirationDate());
	    	}
		}catch(Exception e)
		{ }
		   
		customDto.setExpirationDate(expirationDate);
		setTransactionInformation(customDto, session);
		
		try {
			if(amend){
				
				session.setCurrentForward(ForwardNameConstants.PAGE_AMEND_BASEAGREEMENT);
				
				BaseAgreementDetailsCustomDTO sessionBADTO = (BaseAgreementDetailsCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
				if(null != sessionBADTO && null != sessionBADTO.getModificationDetailsMap() && sessionBADTO.getModificationDetailsMap().size() > 0) {
					// Modification is available
					customDto.setModificationDetailsMap(sessionBADTO.getModificationDetailsMap());
					customDto.setAgreementId(sessionBADTO.getAgreementId());
				}else {
					// 	NO Modification
					customDto.setModificationDetailsMap(new TreeMap());
				}
				customDto = getBaseAgreementManager().amendBaseAgreement(customDto);
				session.removeObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
				errorReport = customDto.getMessageReport();
				if(null == errorReport){
					viewBean = (SearchBaseAgreementViewBean) session.getObjectFromSession(SessionConstants.SEARCH_BASEAGREEMENT_VIEW_BEAN);
					setForwardName(ForwardNameConstants.PAGE_REFRESH_BASEAGREEMENT); //$NON-NLS-1$
				} else {
					viewBean = new MessageViewBean(ForwardNameConstants.PAGE_REFRESH_BASEAGREEMENT);
					viewBean.setErrorReport(errorReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);  //$NON-NLS-1$
					session.setFirstActionForwardName(ForwardNameConstants.PAGE_REFRESH_BASEAGREEMENT);
				}
			} else{
				
				session.setCurrentForward(ForwardNameConstants.PAGE_CREATE_BASEAGREEMENT);
				
				customDto = getBaseAgreementManager().registerBaseAgreement(customDto);
				session.removeObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
				errorReport = customDto.getMessageReport();
				if(null == errorReport){
					setForwardName(ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT); //$NON-NLS-1$
				}  else {
					viewBean = new MessageViewBean(ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT);
					viewBean.setErrorReport(errorReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);  //$NON-NLS-1$
					session.setFirstActionForwardName(ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT);
				}
			}
		}catch(ServiceException se){
			viewBean = handleServiceException(session, se.getErrorReport(), session.getCurrentForward(), session.getCurrentForward());
		}
		    
		return viewBean;
			
    }
    /** 
	 * Returns action name 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return String
	 * 
	 */
    protected String getActionName() {
        return  ActionNameConstants.REGISTER_BASEAGREEMENT;
    }
	/**
     * getBaseAgreementManager
     * 
     * @throws java.lang.Exception
     * @return BaseAgreementManager
     * @author Ravi Yandapalli
     */
    protected BaseAgreementManager getBaseAgreementManager() throws Exception {
        BaseAgreementManagerHome baseAgreementManagerHome = (BaseAgreementManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("BaseAgreementManagerHome");  //$NON-NLS-1$
		return baseAgreementManagerHome.create();
	}
   
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Jul 07, 2006 
	 * 
	 * revision date author reason 
	 * @author Gavaskar Bhojan
	 * </PRE><br/> 
	 * 
	 * @param session
	 * @return 
	 * 
	 */
    protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String forwardToAmend = null;
		String forwardCreate = null;
		String actualForward = null;
		if(null != viewBean && null != currentForward && currentForward.equals(ForwardNameConstants.PAGE_CREATE_BASEAGREEMENT)){
			    forwardCreate = ForwardNameConstants.PAGE_CREATE_BASEAGREEMENT;
			    actualForward = forwardCreate;
				if(viewBean instanceof BaseAgreementFormViewBean && currentForward.equals(actualForward)){
				valid = true;
				
			}
		
		else {
			 	session.setCurrentViewBean(new BaseAgreementFormViewBean());
				session.setCurrentForward(actualForward);
				valid = true;
			}
	 }
		if(null != viewBean && null != currentForward && currentForward.equals( ForwardNameConstants.PAGE_AMEND_BASEAGREEMENT)){ 
			forwardToAmend = ForwardNameConstants. PAGE_AMEND_BASEAGREEMENT;
			actualForward = forwardToAmend ;
			if(viewBean instanceof BaseAgreementDetailViewBean && currentForward.equals(actualForward)){
			   valid = true;
			}
		else
		{
			session.setCurrentViewBean(new BaseAgreementDetailViewBean());
		    session.setCurrentForward(actualForward);
		    valid = true;
		}

	}		
	return valid;
	}
}
  

