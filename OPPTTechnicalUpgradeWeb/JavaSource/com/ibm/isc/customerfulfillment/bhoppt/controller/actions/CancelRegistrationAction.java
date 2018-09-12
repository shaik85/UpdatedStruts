/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTForwardAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerHome;
//import com.ibm.jvm.zseries.SetFPC;

/**
 *  
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 17, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */
public class CancelRegistrationAction extends OPPTForwardAction 
{
	/** 
	* Invalidates the session and redirects to the home page.
	* 
	* <br/><PRE> 
	* date Nov 14, 2003 
	* 
	* revision date author reason 
	* 
	* </PRE><br/> 
	* 
	* @return
	* @throws Exception 
	* 
	*/
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception
	{ 
		OPPTViewBean viewBean = null;
		String forwardName = null;
		OPPTCustomDTO customDTO = new OPPTCustomDTO();
		OPPTSession session = new OPPTSession(request.getSession());
		UserInfoDataBean userInfo = session.getUserInfo();
		if(null != userInfo){
			customDTO.setUserInfo(userInfo.getGroupName(), userInfo.getUserId(), userInfo.getRole(), userInfo.getEmailAddress(), userInfo.getPrimarySalesOrg(),userInfo.getUserGroups());
		}
		customDTO.setSessionId(session.getSessionId());
	
		try {
			getProposalManager().deleteTempValues(customDTO);
			if(null != session){
				session.setUserInfo(null);
				session.invalidate();
			}
			forwardName = ForwardNameConstants.ACTION_INDEX;
		}
		catch(ServiceException ex){
			viewBean = new ErrorViewBean(ex.getErrorReport());
			session.setCurrentMessageViewBean(viewBean);
			forwardName = ForwardNameConstants.PAGE_ERROR;
	   }

	   return mapping.findForward(forwardName);
	}

	/**
     * getProposalManager
     * 
     * @throws java.lang.Exception
     * @return
     * @author thirumalai
     */
    protected ProposalManager getProposalManager() throws Exception {
		ProposalManagerHome pcmHome = (ProposalManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("ProposalManagerHome");  //$NON-NLS-1$
		return pcmHome.create();
	}
}
