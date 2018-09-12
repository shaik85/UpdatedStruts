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
 * Confirm Inactivate Action
 * 
 * @author Nayantara L Pai
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ConfirmInactivateAction extends OPPTLongAction {

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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
			throws Exception {
			OPPTViewBean viewBean = null;
			SearchListActionForm actionForm = (SearchListActionForm)form;
		     //Integer agreementId = new Integer(actionForm.getAgreementId());
		    ArrayList baseAgreementList = (ArrayList)session.getObjectFromSession(SessionConstants.SESSION_BASEAGREEMENT_MAP);	
		   
		    Iterator baseAgreementIterator=baseAgreementList.iterator();
		    while(baseAgreementIterator.hasNext()){
		    BaseAgreementViewBean baseAgreementViewBean = (BaseAgreementViewBean)baseAgreementIterator.next();
		 if(baseAgreementViewBean.getAgreementId()== actionForm.getAgreementId()){
		    
		    if(baseAgreementViewBean.getAgreementStatus().equals("Active")){  /* NOI18N */
		        BaseAgreementConfirmationViewBean bAConfirmationViewBean = new BaseAgreementConfirmationViewBean();
		    bAConfirmationViewBean.setInitiator(ConfirmationConstants.CONFIRM_INACTIVATE);
		    bAConfirmationViewBean.setFooter(Constants.CONFIRMATION_INACTIVATE_FOOTER);
		    viewBean=bAConfirmationViewBean;
				setForwardName(ForwardNameConstants.PAGE_BASEAGREEMENT_CONFIRMATION);  //$NON-NLS-1$
			}else
			{
				ErrorReport errorReport = new ErrorReport();
				errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF228 , OPPTMessageCatalog.TYPE_PRESENTATION), null);
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
		// TODO Auto-generated method stub
		return ActionNameConstants.CONFIRM_INACTIVATE;
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
