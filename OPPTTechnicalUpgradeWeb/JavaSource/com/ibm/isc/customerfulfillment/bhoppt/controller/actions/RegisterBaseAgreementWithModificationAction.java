/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
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
public class RegisterBaseAgreementWithModificationAction extends OPPTLongAction {
	/**
	 * Overridden method - Enter your description here.
	 * 
	 * <br/>
	 * 
	 * <PRE>
	 * 
	 * date jun 22, 2006
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br/>
	 * 
	 * @author Gavaskar Bhojan
	 * @param form
	 *            ActionForm
	 * @param session
	 *            OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception
	 *  
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
			throws Exception {

		OPPTViewBean viewBean = null;
		ErrorReport errorReport = null;
		BaseAgreementDetailsCustomDTO customDto = (BaseAgreementDetailsCustomDTO) session
				.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
		setTransactionInformation(customDto, session);
		try {
			if (customDto.getAgreementId() > 0) {
				customDto = getBaseAgreementManager().amendBaseAgreement(customDto);
				session.removeObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
				errorReport = customDto.getMessageReport();
				if (null == errorReport) {
					//storeInSession(sessionBADTO, session);
					viewBean = (SearchBaseAgreementViewBean) session.getObjectFromSession(SessionConstants.SEARCH_BASEAGREEMENT_VIEW_BEAN);
					setForwardName(ForwardNameConstants.PAGE_REFRESH_BASEAGREEMENT); //$NON-NLS-1$
				} else {
					session.setFirstActionForwardName(ForwardNameConstants.PAGE_REFRESH_BASEAGREEMENT);
					viewBean = new MessageViewBean(ForwardNameConstants.PAGE_REFRESH_BASEAGREEMENT);
					viewBean.setErrorReport(errorReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE); //$NON-NLS-1$	
				}
			}
			else {
				customDto = getBaseAgreementManager().registerBaseAgreement(customDto);
				session.removeObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
				session.removeObjectFromSession(SessionConstants.SESSION_ACCOUNTING_CONTACT);
	    		session.removeObjectFromSession(SessionConstants.SESSION_LEGAL_CONTACT);
				errorReport = customDto.getMessageReport();
				if (null == errorReport) {
					setForwardName(ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT); //$NON-NLS-1$
				} else {
					viewBean = new MessageViewBean(ForwardNameConstants.PAGE_REFRESH_BASEAGREEMENT);
					viewBean.setErrorReport(errorReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE); //$NON-NLS-1$
					session.setCurrentForward(ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT);
					session.setFirstActionForwardName(ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT);
				}
			}

		} catch(ServiceException se){
			viewBean = handleServiceException(session, se.getErrorReport(), session.getCurrentForward(), session.getCurrentForward());
		}

		return viewBean;

	}

	/**
	 * Returns action name
	 * 
	 * <br/>
	 * 
	 * <PRE>
	 * 
	 * date Nov 14, 2003
	 * 
	 * revision date author reason
	 * 
	 * </PRE>
	 * 
	 * <br/>
	 * 
	 * @see com.ibm.support.oppt.OPPTAction#getActionName()
	 * @return String
	 *  
	 */
	protected String getActionName() {
		return ActionNameConstants.REGISTER_BASEAGREEMENT;
	}

	/**
	 * getBaseAgreementManager
	 * 
	 * @throws java.lang.Exception
	 * @return BaseAgreementManager
	 * @author Ravi Yandapalli
	 */
	protected BaseAgreementManager getBaseAgreementManager() throws Exception {
		BaseAgreementManagerHome baseAgreementManagerHome = (BaseAgreementManagerHome) ServiceLocator
				.getEJBHomeFactory().getRemoteHome("BaseAgreementManagerHome"); //$NON-NLS-1$
		return baseAgreementManagerHome.create();
	}


	/**
	 * Overridden method - Enter your description here.
	 * 
	 * <br/>
	 * 
	 * <PRE>
	 * 
	 * date Jul 07, 2006
	 * 
	 * revision date author reason
	 * 
	 * @author Gavaskar Bhojan
	 * 
	 * </PRE>
	 * 
	 * <br/>
	 * 
	 * @param session
	 * @return
	 *  
	 */
	protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = false;

		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();

		if (null != viewBean
				&& null != currentForward
				&& (currentForward.equals(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION) || currentForward.equals(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION_FOR_AMEND))) {
			valid = true;
		}
		
		BaseAgreementDetailsCustomDTO customDto = (BaseAgreementDetailsCustomDTO) session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
		if(customDto == null) {
			valid = false;
		}
		
		return valid;
	}
}
