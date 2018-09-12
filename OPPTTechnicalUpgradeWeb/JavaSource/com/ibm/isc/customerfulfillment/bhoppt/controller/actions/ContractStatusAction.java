/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ContractMaintenanceActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.StatusViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 *  
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Mar 3, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */
public class ContractStatusAction extends OPPTLongAction{
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
		ContractMaintenanceActionForm actionForm = (ContractMaintenanceActionForm)form;
		if(null != actionForm)
		{
			String selectedIds[] = actionForm.getSelectedContractIds();
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
		return ActionNameConstants.CONTRACT_STATUS;
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
		return true;
	}
	
	/**
	 *  
	 * Retrieve UserContractsCustomDTO from session
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session
	 * @return
	 */
	private ProposalCustomDTO getProposal(OPPTSession session, String selectedId){
		UserContractsCustomDTO customDTO = null;
		ProposalCustomDTO proposalDto = null;

		if(null != session){
			customDTO = (UserContractsCustomDTO)session.getObjectFromSession(SessionConstants.USER_CONTRACT);
		}
		
		if(null != customDTO){
			proposalDto = (ProposalCustomDTO)customDTO.getContractCustomDTO().get(selectedId);
		}

		return proposalDto;
	}
}
