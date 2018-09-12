/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SearchListActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ConfirmationConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementConfirmationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
/** 
 * Overridden method - Enter your description here. 
 * 
 * <br/><PRE> 
 * date Sep 22, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * 
 * @param form
 * @param session
 * @return
 * @throws Exception 
 * 
 */

public class ConfirmReactiveBaseAgreementAction extends OPPTLongAction {

    /** 
     * Overridden method - Enter your description here. 
     * 
     * <br/><PRE> 
     * date Nov 14, 2003 
     * 
     * revision date author reason 
     * 
     * </PRE><br/> 
     * @author Tapan Malhothra
     * @param form ActionForm
     * @param session OPPTSession
     * @return OPPTViewBean
     * @throws Exception 
     * 
     */
    protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
            throws Exception {
        OPPTViewBean viewBean = null;
		SearchListActionForm actionForm = (SearchListActionForm)form;
	    //Integer agreementId = new Integer(actionForm.getAgreementId());
	    ArrayList baseAgreementList = (ArrayList)session.getObjectFromSession(SessionConstants.SESSION_BASEAGREEMENT_MAP);	
	    //BaseAgreementViewBean baseAgreementViewBean = (BaseAgreementViewBean)baseAgreementMap.get(agreementId);
	    Iterator baseAgreementIterator=baseAgreementList.iterator();
	    while(baseAgreementIterator.hasNext()){
	    BaseAgreementViewBean baseAgreementViewBean = (BaseAgreementViewBean)baseAgreementIterator.next();
	 if(baseAgreementViewBean.getAgreementId()== actionForm.getAgreementId()){
	    
	    
	    if(baseAgreementViewBean.getAgreementStatus().equals("InActive")){  /* NOI18N */
	    	BaseAgreementConfirmationViewBean bAConfirmationViewBean = new BaseAgreementConfirmationViewBean();
		    bAConfirmationViewBean.setInitiator(ConfirmationConstants.CONFIRM_REACTIVE_ACTION);
		    bAConfirmationViewBean.setFooter(Constants.CONFIRMATION_REACTIVATE_FOOTER);
		    viewBean=bAConfirmationViewBean;
		   	setForwardName(ForwardNameConstants.PAGE_BASEAGREEMENT_CONFIRMATION); 
		}else
		{
			ErrorReport errorReport = new ErrorReport();
			errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF245 , OPPTMessageCatalog.TYPE_PRESENTATION), null);
			viewBean = new MessageViewBean();
			viewBean.setErrorReport(errorReport);
			session.setFirstActionForwardName(ForwardNameConstants.PAGE_REFRESH_BASEAGREEMENT);
			setForwardName(ForwardNameConstants.PAGE_MESSAGE);
		}
	 }
	    }
	    	
		session.storeObjectToSession(SessionConstants.SESSION_SEARCHLIST_ACTIONFORM,actionForm);
		
		return viewBean;	
        
    }

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Sep 22, 2006 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return 
	 * 
	 */
    protected String getActionName() {
        return ActionNameConstants.CONFIRM_REACTIVE_ACTION;
    }

    /** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Sep 22, 2006 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param session
	 * @return 
	 * 
	 */
	protected boolean validateCurrentViewContent(OPPTSession session) {
		// TODO Auto-generated method stub
		return true;
	}
}
