/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTForwardAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ErrorActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * Action class that handles where the control should be taken on click of continue on the 
 * message page.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Mar 2, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class MessageViewAction extends OPPTForwardAction 
{
	/**
     * execute
     * 
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     * @author thirumalai
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String currentForward = null;
		OPPTSession opptSession = new OPPTSession(request.getSession());

		ErrorActionForm actionForm = (ErrorActionForm)form;
		String initiator = actionForm.getInitiator();
		boolean forwardInitiator = actionForm.isForwardInitiator();
		
		if(null == initiator){
			currentForward = opptSession.getFirstActionForwardName();
		}
		else{
			if(forwardInitiator){
				currentForward = initiator;
			}
			else{
				currentForward = opptSession.getCurrentForward();
				if(null == currentForward || !(initiator.equals(currentForward))){
					currentForward = opptSession.getFirstActionForwardName();
				}
			}
		}

		if(null == currentForward){
			currentForward = ForwardNameConstants.PAGE_ERROR;
			opptSession.setCurrentMessageViewBean(new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA44)));
		}
		else{
			opptSession.setCurrentForward(currentForward);
		}
		
		return mapping.findForward(currentForward);
	}
}