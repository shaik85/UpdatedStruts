/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalsForApprovalActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalHistoryViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalsForApprovalViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ProposalForApprovalHistoryAction extends OPPTLongAction 
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
		
		ProposalsForApprovalActionForm actionForm = (ProposalsForApprovalActionForm)form;
		if(null != actionForm)
		{
			String selectedIds[] = actionForm.getSelectedIds();
			if(null != selectedIds)
			{
				if(selectedIds.length == 1)
				{
					ProposalCustomDTO selectedProposal = getProposal(session, selectedIds[0]);
					if(null != selectedProposal)
					{
						ProposalHistoryCustomDTO customDTO = new ProposalHistoryCustomDTO();
						customDTO.setProposalDTO(selectedProposal); 
						setTransactionInformation(customDTO, session);

						try{
							customDTO = getProposalManager().getProposalHistory(customDTO);
							addDataStoreEntry(session, customDTO);
							viewBean = new ProposalHistoryViewBean(customDTO, false, true);
							setForwardName(getRole(session));
						}
						catch(ServiceException se)
						{
							viewBean = handleServiceException(session, se.getErrorReport());
						}
					}
				}
				else{
					viewBean = session.getCurrentViewBean();
					viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA19));
					setForwardName(session.getCurrentForward());
				}
			}
			else{
				viewBean = session.getCurrentViewBean();
				viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA17));
				setForwardName(session.getCurrentForward());
			}
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA17));
			setForwardName(session.getCurrentForward());
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
		return ActionNameConstants.PROPOSAL_FOR_APPROVAL_HISTORY;
	}

	private ProposalCustomDTO getProposal(OPPTSession session, String id) 
	{
		ProposalCustomDTO customDTO = null;

		if (null != session && null != id)
		{
			ProposalsForApprovalCustomDTO userProposalsDTO = (ProposalsForApprovalCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSALS_FOR_APPROVAL);
			if (null != userProposalsDTO) 
			{
				TreeMap userProposals = userProposalsDTO.getProposalsForApproval();
				if (null != userProposals) 
				{
					int proposalId = -1;
					try 
					{
						proposalId = Integer.parseInt(id);
					}
					catch (NumberFormatException e) {}
					customDTO = (ProposalCustomDTO) userProposals.get(new Integer(id));
				}
			}
		}
		return customDTO;
	}

	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSALS_FOR_APPROVAL_HISTORY);
								break;

			case Constants.PROPOSAL_APPROVER:
			default:
								setForwardName(ForwardNameConstants.PAGE_PROPOSAL_FOR_APPROVAL_HISTORY);
								break;
		}
	}

	/** 
	 * Overridden method - Check if the current view bean stored in session is what is expected. 
	 * If it is not valid, try to create the current view using the custom dto stored in session 
	 * and set it as current view. If current view cannot be created, return false. 
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
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = getCurrentForwardName(getRole(session));

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof ProposalsForApprovalViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.PROPOSALS_FOR_APPROVAL);
			if(null != dataStoreEntry && dataStoreEntry instanceof ProposalsForApprovalCustomDTO){
				session.setCurrentViewBean(new ProposalsForApprovalViewBean((ProposalsForApprovalCustomDTO)dataStoreEntry));
				session.setCurrentForward(actualForward);
				valid = true;
			}
		}

		return valid;
	}

	private String getCurrentForwardName(int role){
		String currentForwardName = null;
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSALS_FOR_APPROVAL_MAINTENACE;
								break;

			case Constants.PROPOSAL_APPROVER:
			default:
								currentForwardName = ForwardNameConstants.PAGE_PROPOSAL_FOR_APPROVAL_MAINTENANCE;
								break;
		}
		
		return currentForwardName;
	}
}
