/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



/**
 * This action is used for initiating the progress bar. It sets the refresh time information into the 
 * response header and forwards the control to Progress bar page.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 11, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ProgressAction extends OPPTForwardAction {
	
	/**
	 * Overridden method - Overridden to check if the action thread is still running. If running
	 * it sets the Refresh property into the reponse header and forwards to progress page. If not 
	 * running gets the action name from the task running and based on the action name it forwards
	 * to corresponding page. 
	 * 
	 * <br/><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse) 
	 * @param mapping ActionMapping value which holds all the action mapping setting done in struts-config.
	 * @param actionForm ActionForm value which holds the form information that is assigned to this action.
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception 
	 *
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		HttpSession session = request.getSession();
		OPPTLongAction task = (OPPTLongAction)session.getAttribute("task");  //$NON-NLS-1$
		String forwardName = "progress";  //$NON-NLS-1$
		
		if(task.isRunning()){
			int count = 0;
			long millSeconds = 0;
			Date startTime = null;
			Date currentTime = null;

			try{
				startTime = (Date)session.getAttribute("startTime");  //$NON-NLS-1$
				currentTime = new Date();
				count = (int)(currentTime.getTime() - startTime.getTime());
			}
			catch(NullPointerException ne){
				startTime = new Date();
				session.setAttribute("startTime", startTime);  //$NON-NLS-1$
				count = 0;
			}
			
			session.setAttribute("count", new Integer(count));  //$NON-NLS-1$
			
			// Removed this block as code change for MN19932422.
			
			/**
				if(600000  > count){
					response.setHeader("Refresh", "1; URL=ProgressAction.wss");
				}
				else{
					session.removeAttribute("count");
					session.removeAttribute("startTime");
					OPPTSession opptSession = new OPPTSession(session);
					MessageViewBean viewBean = new MessageViewBean();
					viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA29));
					opptSession.setCurrentMessageViewBean(viewBean);
					forwardName = ForwardNameConstants.PAGE_MESSAGE;
				}
			*/

			// Addeded this block as code change for MN19932422.
			response.setHeader("Refresh", "1; URL=ProgressAction.wss");  //$NON-NLS-2$  //$NON-NLS-1$
		}
		else
		{
			session.removeAttribute("count");  //$NON-NLS-1$
			session.removeAttribute("startTime");  //$NON-NLS-1$
			forwardName = task.getForwardName();
		}
		return mapping.findForward(forwardName);
	}
}
