/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTForwardAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalHeaderActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class ClearAllAction extends OPPTForwardAction 
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
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception 
	 *
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		OPPTSession opptSession = new OPPTSession(request.getSession());
		if(null != actionForm && actionForm instanceof OPPTActionForm){
			((OPPTActionForm)actionForm).reset();
		}
		OPPTViewBean viewBean = opptSession.getCurrentViewBean();
		String currentForward = opptSession.getCurrentForward();
		
		if(null == currentForward || null == viewBean)
		{
			currentForward = ForwardNameConstants.PAGE_ERROR;
			viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA44));
			opptSession.setCurrentViewBean(viewBean);
		}
		else{
			viewBean.clearAll();
			opptSession.setCurrentViewBean(viewBean);
		}
			
		return mapping.findForward(currentForward);
	}
}
