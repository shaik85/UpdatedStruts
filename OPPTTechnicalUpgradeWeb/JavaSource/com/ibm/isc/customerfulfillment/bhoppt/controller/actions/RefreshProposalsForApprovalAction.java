/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.Iterator;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalsForApprovalViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalsForApprovalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class RefreshProposalsForApprovalAction extends OPPTLongAction 
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
		
		// CR 2031
		session.removeObjectFromSession(SessionConstants.DUPLICATE_SERIAL_NUMBERS);
		UserInfoDataBean userInfo = session.getUserInfo();

		if(Constants.PROPOSAL_CREATE_APPROVER != getRole(session)){			
			if(null != userInfo && null != userInfo.getGroupName() && null != userInfo.getGroupUserId()){
				GroupUserCustomDTO groupUser = new GroupUserCustomDTO();
				groupUser.setSelectedUser(userInfo.getGroupUserId());
				groupUser.setGroupName(userInfo.getGroupName());
				groupUser.setSelectedGroupName(userInfo.getSelectedGroup());
				customDTO.setGroupUserInfo(groupUser);
			}
		}
		
		try {
			customDTO = getProposalManager().listProposalsForApproval(customDTO);
			if(null != customDTO.getGroupUserInfo() ) {
				customDTO.getGroupUserInfo().setUserGroups(userInfo.getUserGroups());		
				customDTO.getGroupUserInfo().setGroupName(userInfo.getGroupName());
			}
			
			ErrorReport errorReport = customDTO.getMessageReport();
			addDataStoreEntry(session, customDTO);
			setProposalsForApproval(session, customDTO);
			setForwardName(getRole(session));
			viewBean = new ProposalsForApprovalViewBean(customDTO);
		}
		catch(ServiceException se){
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
		return ActionNameConstants.PROPOSALS_FOR_APPROVAL;
	}

	private void setProposalsForApproval(OPPTSession session, ProposalsForApprovalCustomDTO customDTO){
    	if(null != session && null != customDTO){
    		session.storeObjectToSession(SessionConstants.PROPOSALS_FOR_APPROVAL, customDTO);
    	}
	}
	
	private ProposalsForApprovalCustomDTO getProposalsForApproval(OPPTSession session){
		ProposalsForApprovalCustomDTO customDTO = null;
		
		if(null != session){
			customDTO = (ProposalsForApprovalCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSALS_FOR_APPROVAL);
		}
		
		return customDTO;
	}

	private String getMessage(ErrorReport errorReport){
		String message = null;
		
		if(null != errorReport){
			OPPTMessageCatalog.getInstance().populateErrorReport(errorReport);
			Iterator errorReportIterator = errorReport.values().iterator();
			if(errorReportIterator.hasNext()){
				ErrorEntry errorEntry = (ErrorEntry)errorReportIterator.next();
				if(null != errorEntry){
					message = errorEntry.getErrorMessage();
				}
			}
		}
		
		return message;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Feb 10, 2004 
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
		return ForwardNameConstants.ACTION_REFRESH_PROPOSALS_FOR_APPROVAL;
	}

	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSALS_FOR_APPROVAL_MAINTENACE);
								break;

			case Constants.PROPOSAL_APPROVER:
			default:
								setForwardName(ForwardNameConstants.PAGE_PROPOSAL_FOR_APPROVAL_MAINTENANCE);
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