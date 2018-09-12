/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;
import java.util.ArrayList;
import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SearchParamActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SearchBaseAgreementViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SearchBaseAgreementCustomDTO;

/**
 * This is the search the Base agreement 
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SearchBaseAgreementAction extends OPPTLongAction {
  
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
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
    protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception 
	{
	
    	ErrorReport errorReport = null;
		OPPTViewBean viewBean = null;
		SearchBaseAgreementCustomDTO searchBACustomDto;
		SearchParamActionForm actionForm;

		actionForm = (SearchParamActionForm)form;

		searchBACustomDto = new SearchBaseAgreementCustomDTO();
		setTransactionInformation(searchBACustomDto, session);
        
		searchBACustomDto.setCustomerNumber(actionForm.getCustomerNumber());
		searchBACustomDto.setEnterpriseNumber(actionForm.getEnterpriseNumber());
		searchBACustomDto.setFormNumber(actionForm.getFormNumber());
		searchBACustomDto.setAgreementNumber(actionForm.getAgreementNumber());
		//searchBACustomDto.setCustomerLegacyNumber(actionForm.getCustomerLegacyNumber());
		//searchBACustomDto.setImageReferenceNumber(actionForm.getImageReferenceNumber());
		//searchBACustomDto.setINAC(actionForm.getAccountNumber());
		//searchBACustomDto.setCustomerName(actionForm.getCustomerName());
		/**
		 * 4 new fields ImageReferenceNumber,CustomerName,CustomerLegacyNumber,INACNumber added
		 * author tapan malhotra
		 */
		searchBACustomDto.setImageReferenceNumber(actionForm.getImageReferenceNumber());
		searchBACustomDto.setCustomerName(actionForm.getCustomerName());
		searchBACustomDto.setCustomerLegacyNumber(actionForm.getCustomerLegacyNumber());
		searchBACustomDto.setINAC(actionForm.getAccountNumber());
		try {
		    searchBACustomDto = getBaseAgreementManager().getAllBaseAgreements(searchBACustomDto);
			errorReport = searchBACustomDto.getMessageReport();
					
			if(null == errorReport){
			   viewBean = new SearchBaseAgreementViewBean(searchBACustomDto);
			   setForwardName(ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT);  //$NON-NLS-1$
			}
			else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(errorReport);
				// changed by Balaji 
				setForwardName(ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT);  //$NON-NLS-1$
			}
	
		}
		catch(ServiceException ex){
			/* Since Action form was not used for showing the fields we are in trouble with the refresh
			 * So I am doing a change in view bean to handle this. Please follow one standard and use actionForms 
			 * in all the forms. Thanks Balaji s
			 */			
			viewBean = handleServiceException(session, ex.getErrorReport());
			if(viewBean instanceof SearchBaseAgreementViewBean) {
				((SearchBaseAgreementViewBean)viewBean).setCustomerNumber(actionForm.getCustomerNumber());
				((SearchBaseAgreementViewBean)viewBean).setEnterpriseNumber(actionForm.getEnterpriseNumber());
				((SearchBaseAgreementViewBean)viewBean).setFormNumber(actionForm.getFormNumber());
				((SearchBaseAgreementViewBean)viewBean).setAgreementNumber(actionForm.getAgreementNumber());
				((SearchBaseAgreementViewBean)viewBean).setBaseAgreementList(new ArrayList());
				((SearchBaseAgreementViewBean)viewBean).setCustomerLegacyNumber(actionForm.getCustomerLegacyNumber());
				((SearchBaseAgreementViewBean)viewBean).setCustomerName(actionForm.getCustomerName());
				((SearchBaseAgreementViewBean)viewBean).setImageReferenceNumber(actionForm.getImageReferenceNumber());
				((SearchBaseAgreementViewBean)viewBean).setINAC(actionForm.getAccountNumber());
			}
			
		}
		session.storeObjectToSession(SessionConstants.SESSION_SEARCH_BASE_AGREEMENT,searchBACustomDto);
		session.storeObjectToSession(SessionConstants.SESSION_SEARCH_PARAM_ACTIONFORM,actionForm);
		session.storeObjectToSession(SessionConstants.SEARCH_BASEAGREEMENT_VIEW_BEAN,viewBean);
		session.storeObjectToSession(SessionConstants.SESSION_BASEAGREEMENT_MAP,((SearchBaseAgreementViewBean)viewBean).getBaseAgreementList());
		return viewBean;
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
		return ActionNameConstants.SEARCH_BASEAGREEMENT;
	}
	
	/**
     * getUserManager
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
		String actualForward = ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT;

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof SearchBaseAgreementViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if (!valid) {
			session.setCurrentViewBean(new SearchBaseAgreementViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}
		
		return valid;
	}
}
