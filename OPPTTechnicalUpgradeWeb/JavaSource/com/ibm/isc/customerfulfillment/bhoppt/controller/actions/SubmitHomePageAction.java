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
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SignInViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class SubmitHomePageAction extends OPPTLongAction {
	/** 
		* Overridden method - Enter your description here. 
		* 
		* <br/><PRE> 
		* date Nov 14, 2003 
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		if(null == session.getUserInfo()){
			session.setCurrentViewBean(new SignInViewBean());
			setForwardName(ForwardNameConstants.PAGE_SIGN_IN);
		}
		else{
			switch(getRole(session)){
				case Constants.ADMINISTRATOR: 
							setForwardName(ForwardNameConstants.ACTION_ADMINISTRATOR);
							break;
				case Constants.PROPOSAL_ADMINISTRATOR:
							setForwardName(ForwardNameConstants.ACTION_PROPOSAL_ADMINISTRATOR);
							break;
				case Constants.PROPOSAL_APPROVER:
							setForwardName(ForwardNameConstants.ACTION_PROPOSAL_APPROVER);
							break;
				case Constants.PROPOSAL_CREATE_APPROVER:
							setForwardName(ForwardNameConstants.ACTION_PROPOSAL_CREATE_APPROVER);
							break;
				default:
							viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA00));
							setForwardName(ForwardNameConstants.PAGE_ERROR);
							break;
			}
		}
		
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
		* 
		* @see com.ibm.support.oppt.OPPTAction#getActionName() 
		* @return 
		* 
		*/
	protected String getActionName() {
		return "SubmitHomePageAction";  //$NON-NLS-1$
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Feb 28, 2004 
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
		return true;
	}
}