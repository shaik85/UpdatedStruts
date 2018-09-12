/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.multipleaction;

import java.io.Serializable;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * <p>This action functions as a Struts Action in order to evaluate the selected ImageButtonBean, 
 * then dispatch to a corresponding ActionForward.</p>
 */

public class MultipleButtonDispatchAction extends Action implements Serializable
{
	/**
     * execute
     * 
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     * @author thirumalai
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		String value ="";  //$NON-NLS-1$
		String key = "";  //$NON-NLS-1$
		Enumeration enumeration = request.getParameterNames();
		while(enumeration.hasMoreElements())
		{
			key = (String)enumeration.nextElement();
			if(key.startsWith("multipleButtonManager")) {  //$NON-NLS-1$
				value = key.substring(key.indexOf(".")+1);  //$NON-NLS-1$
				break;
			}
		}
		
		ActionForward actionForward = mapping.findForward(value);
		if(null == actionForward){
			OPPTSession session = new OPPTSession(request.getSession());
			ErrorReport messageReport = new ErrorReport();
			messageReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA48, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			MessageViewBean viewBean = new MessageViewBean(session.getCurrentForward());
			viewBean.setErrorReport(messageReport);
			session.setCurrentMessageViewBean(viewBean);
			actionForward = mapping.findForward(ForwardNameConstants.PAGE_INVALID_SELECTION);
		}
		return actionForward;
	}
	
   /*	MultipleButtonManager imageButtonBeanManager = MultipleButtonManagerFactory.createFactory().getImageButtonBeanManager(form);
		if (null == imageButtonBeanManager){
			OPPTSession session = new OPPTSession(request.getSession());

			ErrorReport errorReport = new ErrorReport();
			errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA49, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			
			ErrorViewBean viewBean = new ErrorViewBean(errorReport);
			viewBean.setErrorReport(errorReport);
			session.setCurrentMessageViewBean(viewBean);

			actionForward = mapping.findForward(ForwardNameConstants.PAGE_ERROR);
		}
		else{
			// route to the ActionForward mapped to the selected ImageButtonBean
			actionForward = imageButtonBeanManager.getActionForward(mapping, form, request);
			if(null == actionForward){
				OPPTSession session = new OPPTSession(request.getSession());

				ErrorReport messageReport = new ErrorReport();
				messageReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA48, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				
				MessageViewBean viewBean = new MessageViewBean(session.getCurrentForward());
				viewBean.setErrorReport(messageReport);
				session.setCurrentMessageViewBean(viewBean);
				
				actionForward = mapping.findForward(ForwardNameConstants.PAGE_INVALID_SELECTION);
			}
		}
		return actionForward; */
}
