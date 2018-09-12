/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.UserProposalsActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class UserProposalsAction extends OPPTAction {
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
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;

		UserProposalsActionForm actionForm = (UserProposalsActionForm) form;
		ErrorReport errorReport = validateSelectedUser(actionForm);
		if (null != errorReport && 0 < errorReport.size()) {
			viewBean = new ErrorViewBean(errorReport, ForwardNameConstants.ACTION_PROPOSAL_MAINTENANCE, true);
			setForwardName(ForwardNameConstants.PAGE_ERROR);
			return viewBean;
		}

		UserInfoDataBean userInfo = session.getUserInfo();
		if (userInfo.getGroupName() != null && OPPTHelper.trimString(userInfo.getGroupName()).equals(OPPTHelper.trimString(actionForm.getSelectedGroup()))) {
			if (null != userInfo) {
				userInfo.setGroupUserId(actionForm.getSelectedUser());
				userInfo.setSelectedGroup(actionForm.getSelectedGroup());
				session.setUserInfo(userInfo);
			}
		} else {
			// Group Name has changed 
			if (null != userInfo) {
				userInfo.setGroupUserId(actionForm.getSelectedUser());
				userInfo.setSelectedGroup(actionForm.getSelectedGroup());
				session.setUserInfo(userInfo);
			}

		}

		setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_MAINTENANCE);

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
		return ActionNameConstants.PROPOSAL_MAINTENANCE;
	}

	private ErrorReport validateSelectedUser(UserProposalsActionForm actionForm) {
		ErrorReport errorReport = new ErrorReport();
		if (null != actionForm) {
			String selectedUser = actionForm.getSelectedUser();
			if (null != selectedUser && selectedUser.equalsIgnoreCase("Select one")) {  //$NON-NLS-1$
				errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF83, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		return errorReport;
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