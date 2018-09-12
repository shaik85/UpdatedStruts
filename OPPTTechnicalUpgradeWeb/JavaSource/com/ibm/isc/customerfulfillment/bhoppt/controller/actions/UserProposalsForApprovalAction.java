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
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalsForApprovalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class UserProposalsForApprovalAction extends OPPTAction 
{
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
		
		ProposalsForApprovalCustomDTO customDTO = new ProposalsForApprovalCustomDTO();
		setTransactionInformation(customDTO, session);

		UserProposalsActionForm actionForm = (UserProposalsActionForm)form;
		ErrorReport errorReport = validateSelectedUser(actionForm);
		if(null != errorReport && 0 < errorReport.size()){
			viewBean = new ErrorViewBean(errorReport);
			setForwardName(ForwardNameConstants.PAGE_ERROR);
			return viewBean;
		}

		UserInfoDataBean userInfo = session.getUserInfo();
		if(null != userInfo){
			userInfo.setGroupUserId(actionForm.getSelectedUser());
			userInfo.setSelectedGroup(actionForm.getSelectedGroup());			
			session.setUserInfo(userInfo);
		}
		
		setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSALS_FOR_APPROVAL);
		
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
		return ActionNameConstants.PROPOSALS_FOR_APPROVAL;
	}

	private ErrorReport validateSelectedUser(UserProposalsActionForm actionForm){
		ErrorReport errorReport = new ErrorReport();
		if(null != actionForm){
			String selectedUser = actionForm.getSelectedUser();
			if(isSelectEmpty(selectedUser)){
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