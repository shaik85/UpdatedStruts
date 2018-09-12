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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ContractMaintenanceActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ContractErrorHistoryAction extends OPPTLongAction {
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

		ContractMaintenanceActionForm actionForm = (ContractMaintenanceActionForm) form;
		if (null != actionForm) 
		{
			String selectedIds[] = actionForm.getSelectedContractIds();
			if (null != selectedIds) 
			{
				if (1 == selectedIds.length) 
				{
					ContractCustomDTO selectedContract = getContract(session, selectedIds[0]);
					if (null != selectedContract) 
					{
						ErrorHistoryCustomDTO customDTO = new ErrorHistoryCustomDTO();
						setTransactionInformation(selectedContract, session);
						customDTO.setProposalDTO(selectedContract);
						setTransactionInformation(customDTO, session);

						try 
						{
							customDTO = getProposalManager().viewErrorHistory(customDTO);
							ErrorReport messageReport = customDTO.getMessageReport();
							if(null == messageReport){
								addDataStoreEntry(session, customDTO);
								viewBean = new ErrorHistoryViewBean(customDTO, true);
								setErrorHistory(session, customDTO);
								setForwardName(getRole(session));
							}
							else{
								viewBean = new MessageViewBean(MessageConstants.ERROR_HISTORY);
								viewBean.setErrorReport(messageReport);
								setForwardName(ForwardNameConstants.PAGE_MESSAGE);
							}
						} 
						catch (ServiceException se) 
						{
							viewBean = session.getCurrentViewBean();
							viewBean.setErrorReport(se.getErrorReport());
							setForwardName(session.getCurrentForward());
						}
					}
				} else {
					viewBean = session.getCurrentViewBean();
					viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA19));
					setForwardName(session.getCurrentForward());
				}
			} else {
				viewBean = session.getCurrentViewBean();
				viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA17));
				setForwardName(session.getCurrentForward());
			}
		} else {
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
		return ActionNameConstants.CONTRACT_ERROR_HISTORY;
	}

	private ContractCustomDTO getContract(OPPTSession session, String id) 
	{
		ContractCustomDTO customDTO = null;

		if (null != session && null != id)
		{
			UserContractsCustomDTO userContractsDTO = (UserContractsCustomDTO)session.getObjectFromSession(SessionConstants.USER_CONTRACT);
			if (null != userContractsDTO) 
			{
				TreeMap userContracts = userContractsDTO.getContractCustomDTO();
				if (null != userContracts){
					customDTO = (ContractCustomDTO) userContracts.get(id);
				}
			}
		}
		return customDTO;
	}

	private void setErrorHistory(OPPTSession session, ErrorHistoryCustomDTO dto) 
	{
		if(null != session && null != dto){
			session.storeObjectToSession(SessionConstants.ERROR_HISTORY, dto);
		}
	}

	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_ERROR_HISTORY);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_CONTRACT_ERROR_HISTORY);
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
			if(viewBean instanceof ContractMaintenanceViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.CONTRACT_MAINTENANCE);
			if(null != dataStoreEntry && dataStoreEntry instanceof UserContractsCustomDTO){
				session.setCurrentViewBean(new ContractMaintenanceViewBean((UserContractsCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_MAINTENANCE;
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_CONTRACT_MAINTENANCE;
								break;
		}
		
		return currentForwardName;
	}
}
