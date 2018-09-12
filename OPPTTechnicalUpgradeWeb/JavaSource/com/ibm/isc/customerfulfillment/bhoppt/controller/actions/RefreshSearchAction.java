/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

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
 * RefreshSearchAction
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date jun 19,2006
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravi 
 * 
 */
public class RefreshSearchAction extends OPPTLongAction {
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
		SearchBaseAgreementCustomDTO searchBACustomDto = new SearchBaseAgreementCustomDTO();
		SearchParamActionForm actionForm = null;
		actionForm = (SearchParamActionForm)session.getObjectFromSession(SessionConstants.SESSION_SEARCH_PARAM_ACTIONFORM);
		
		searchBACustomDto = new SearchBaseAgreementCustomDTO();
		searchBACustomDto.setCustomerNumber(actionForm.getCustomerNumber());
		searchBACustomDto.setEnterpriseNumber(actionForm.getEnterpriseNumber());
		searchBACustomDto.setFormNumber(actionForm.getFormNumber());
		searchBACustomDto.setAgreementNumber(actionForm.getAgreementNumber());
		searchBACustomDto.setCustomerName(actionForm.getCustomerName());
		searchBACustomDto.setImageReferenceNumber(actionForm.getImageReferenceNumber());
		setTransactionInformation(searchBACustomDto, session);
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
				setForwardName(ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT);  //$NON-NLS-1$
			}
	
		}
		catch(ServiceException ex){
			viewBean = handleServiceException(session, ex.getErrorReport());
		}
		session.storeObjectToSession(SessionConstants.SESSION_SEARCH_BASE_AGREEMENT,searchBACustomDto);
		session.storeObjectToSession(SessionConstants.SESSION_SEARCH_PARAM_ACTIONFORM,actionForm);
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
		return ActionNameConstants.REFRESH_SEARCH_BASEAGREEMENT;
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
     * validate current view bean
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
