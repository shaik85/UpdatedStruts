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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalMaintenanceActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalMaintenanceViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.StatusViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.StatusCheckCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserProposalsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ProposalStatusAction extends OPPTLongAction {
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
		
		ProposalMaintenanceActionForm actionForm = (ProposalMaintenanceActionForm)form;
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
						StatusCheckCustomDTO customDTO = getStatusCheckCustomDTO(selectedProposal);
						setTransactionInformation(customDTO, session);

						try
						{
							customDTO = getProposalManager().checkProposalStatus(customDTO);
							ErrorReport messageReport = customDTO.getMessageReport();
							if(null == messageReport){
								addDataStoreEntry(session, selectedProposal);
								setForwardName(ForwardNameConstants.ACTION_CONTRACT_MAINTENANCE_STATUS);
							}
							else{
								if(customDTO.isMessageForward()){
									viewBean = new MessageViewBean();
									viewBean.setErrorReport(messageReport);
									setForwardName(ForwardNameConstants.PAGE_MESSAGE);
								}
								else{
									viewBean = new StatusViewBean(messageReport, selectedIds[0]);
									setForwardName(ForwardNameConstants.PAGE_STATUS_INFORMATION);
								}
							}
						}
						catch(ServiceException se){
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
		return ActionNameConstants.PROPOSAL_STATUS;
	}

	private ProposalCustomDTO getProposal(OPPTSession session, String id) 
	{
		ProposalCustomDTO customDTO = null;

		if (null != session && null != id)
		{
			UserProposalsCustomDTO userProposalsDTO = (UserProposalsCustomDTO)session.getObjectFromSession(SessionConstants.USER_PROPOSALS);
			if (null != userProposalsDTO) 
			{
				TreeMap userProposals = userProposalsDTO.getProposals();
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

	private StatusCheckCustomDTO getStatusCheckCustomDTO(ProposalCustomDTO selectedProposal){
		StatusCheckCustomDTO customDTO = new StatusCheckCustomDTO();
		
		customDTO.setId(selectedProposal.getId());
		customDTO.setName(selectedProposal.getName());
		customDTO.setType(selectedProposal.getType());
		customDTO.setStatus(selectedProposal.getStatus());
		customDTO.setOldContractNumber(selectedProposal.getOldContractNumber());
		customDTO.setLockedBy(selectedProposal.getLockedBy());
		customDTO.setAccess(selectedProposal.getAccess());
		customDTO.setFullAccess(selectedProposal.isFullAccess());
		
		return customDTO;
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
			if(viewBean instanceof ProposalMaintenanceViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.PROPOSAL_MAINTENANCE);
			if(null != dataStoreEntry && dataStoreEntry instanceof UserProposalsCustomDTO){
				session.setCurrentViewBean(new ProposalMaintenanceViewBean((UserProposalsCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_MAINTENANCE;
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_PROPOSAL_MAINTENANCE;
								break;
		}
		
		return currentForwardName;
	}
}
