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
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ErrorActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;


/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ErrorViewAction extends OPPTForwardAction 
{
	/**
	 * Overridden method - This method is overridden to forward the control to the actual view when user 
	 * clicks on Cancel button. This method gets the current process name and the process's initial view
	 * bean and forwards the control to the initial view.  
	 * 
	 * <br/><PRE> 
	 * date Nov 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse) 
	 * @param mapping ActionMapping value which holds all the action mapping setting done in struts-config.
	 * @param form ActionForm value which holds the form information that is assigned to this action.
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception 
	 *
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String type = (String)request.getAttribute("errorView");  //$NON-NLS-1$
		if(null == type){
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
				opptSession.setCurrentMessageViewBean(new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA00)));
			}
			else{
				opptSession.setCurrentForward(currentForward);
			}
		
			return mapping.findForward(currentForward);
		}
		else{
			return mapping.findForward(ForwardNameConstants.PAGE_ERROR);
		}
	}
}