/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.RemoveProposalSharingActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ShareProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Mar 8, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class SubmitRemoveProposalSharingAction extends OPPTLongAction {

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 8, 2004 
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
		
		ShareProposalCustomDTO customDTO = getShareProposal(session);
		customDTO.setUsers(getSelectedUsers(form));
		customDTO.setTransactionName(getActionName());
		
		try{
			customDTO = getProposalManager().removeShare(customDTO);
			ErrorReport messageReport = customDTO.getMessageReport();
			if(null == messageReport){
				removeShareProposal(session);
				setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_MAINTENANCE);
			}
			else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(messageReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);
			}
		}
		catch(ServiceException se){
			viewBean = handleServiceException(session, se.getErrorReport());
		}
		
		return viewBean;
	}

	private ShareProposalCustomDTO getShareProposal(OPPTSession session){
		ShareProposalCustomDTO customDTO = null;
		if(null != session){
			customDTO = (ShareProposalCustomDTO)session.getObjectFromSession(SessionConstants.SHARE_PROPOSAL);
		}
		return customDTO;
	}

	private void removeShareProposal(OPPTSession session){
		session.removeObjectFromSession(SessionConstants.SHARE_PROPOSAL);
	}

	private TreeMap getSelectedUsers(ActionForm form){
		TreeMap selectedUsers = new TreeMap();
		
		if(null != form){
			RemoveProposalSharingActionForm actionForm = (RemoveProposalSharingActionForm)form;
			String users[] = actionForm.getUsers();
			if(null != users & 0 < users.length){
				for(int i=0, length = users.length; i<length; i++){
					selectedUsers.put(users[i], users[i]);
				}
			}
		}
		
		return selectedUsers;
	}
	
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#getActionName() 
	 * @return 
	 * 
	 */
	protected String getActionName() {
		return ActionNameConstants.SUBMIT_REMOVE_PROPOSAL_SHARING;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 8, 2004 
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