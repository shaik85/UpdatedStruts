/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.UserProposalsActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalMaintenanceViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserProposalsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class RefreshProposalMaintenanceAction extends OPPTLongAction {
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

		UserProposalsCustomDTO customDTO = new UserProposalsCustomDTO();
		setTransactionInformation(customDTO, session);

		UserInfoDataBean userInfo = session.getUserInfo();
		if (null != userInfo && null != userInfo.getGroupName() && null != userInfo.getGroupUserId()) {
			GroupUserCustomDTO groupUser = new GroupUserCustomDTO();
			groupUser.setSelectedUser(userInfo.getGroupUserId());
			groupUser.setGroupName(userInfo.getGroupName());
			groupUser.setUserGroups(userInfo.getUserGroups());
			groupUser.setSelectedGroupName(userInfo.getSelectedGroup());
			customDTO.setGroupUserInfo(groupUser);
			if (null != userInfo) {
				userInfo.setGroupUserId(userInfo.getUserId());
				session.setUserInfo(userInfo);
			}
		}
		
		

		try {
			customDTO = getProposalManager().listAllProposalsOfUser(customDTO);
			if(null != customDTO.getGroupUserInfo() ) {
				customDTO.getGroupUserInfo().setUserGroups(userInfo.getUserGroups());		
				customDTO.getGroupUserInfo().setGroupName(userInfo.getGroupName());
			}
			addDataStoreEntry(session, customDTO);
			saveUserProposals(session, customDTO);
			setForwardName(getRole(session));
			viewBean = new ProposalMaintenanceViewBean(customDTO);
			} catch (ServiceException se) {
			viewBean = new ErrorViewBean(se.getErrorReport());
			setForwardName(ForwardNameConstants.PAGE_ERROR);
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
		return ActionNameConstants.PROPOSAL_MAINTENANCE;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#isFirstActionOfProcess() 
	 * @return 
	 * 
	 */
	protected boolean isFirstActionOfProcess() {
		return true;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#getFirstActionForwardName() 
	 * @return 
	 * 
	 */
	protected String getFirstActionForwardName() {
		return ForwardNameConstants.ACTION_REFRESH_PROPOSAL_MAINTENANCE;
	}

	private void saveUserProposals(OPPTSession session, UserProposalsCustomDTO dto) {
		if (null != session && null != dto) {
			session.storeObjectToSession(SessionConstants.USER_PROPOSALS, dto);
		}
	}

	private UserProposalsCustomDTO getUserProposals(OPPTSession session) {
		UserProposalsCustomDTO customDTO = null;

		if (null != session) {
			customDTO = (UserProposalsCustomDTO) session.getObjectFromSession(SessionConstants.USER_PROPOSALS);
		}

		return customDTO;
	}

	private void setForwardName(int role) {
		switch (role) {
			case Constants.PROPOSAL_CREATE_APPROVER :
				setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_MAINTENANCE);
				break;

			case Constants.PROPOSAL_ADMINISTRATOR :
			default :
				setForwardName(ForwardNameConstants.PAGE_PROPOSAL_MAINTENANCE);
				break;
		}
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