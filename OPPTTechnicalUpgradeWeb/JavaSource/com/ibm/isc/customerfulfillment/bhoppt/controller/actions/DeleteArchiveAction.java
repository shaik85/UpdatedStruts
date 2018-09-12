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
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ConfirmationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ContractMaintenanceViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Action class that initiates the delete proposal sequence  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 23, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class DeleteArchiveAction extends OPPTLongAction 
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
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		boolean confirmation = false;

		ContractMaintenanceActionForm actionForm = (ContractMaintenanceActionForm)form;
		if(null != actionForm){
			DeleteProposalCustomDTO customDTO = getContractssToBeDeleted(session, actionForm.getSelectedContractIds());
			if(null != customDTO){
				setTransactionInformation(customDTO, session);
				customDTO.setConfirmationRequired(true);
				

				try{
					
					getProposalManager().deleteProposalContract(customDTO);
					addDataStoreEntry(session, customDTO);
					setProposalToBeDeleted(session, customDTO);
					viewBean = new ConfirmationViewBean(ConfirmationConstants.DELETE_ARCHIVE);
					viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA18));
					setForwardName(ForwardNameConstants.PAGE_CONFIRMATION);
					confirmation = true;
				}
				catch(ServiceException se){
					viewBean = handleServiceException(session, se.getErrorReport());
					confirmation = true;
				}
			}
		}
		if(!confirmation){
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
		return ActionNameConstants.ARCHIVE_CONTRACT;
	}

	private DeleteProposalCustomDTO getContractssToBeDeleted(OPPTSession session, String selectedContractId[]){
		DeleteProposalCustomDTO customDTO = null;
		
		if(null != session && null != selectedContractId && 0 < selectedContractId.length)
		{
			UserContractsCustomDTO userContractsDTO = (UserContractsCustomDTO)session.getObjectFromSession(SessionConstants.USER_ARCHIVE);
			if(null != userContractsDTO)
			{
				TreeMap userContracts = userContractsDTO.getContractCustomDTO();
				if(null != userContracts)
				{
					for(int i=0, size=selectedContractId.length; i<size; i++){
						if(null == customDTO){
							customDTO = new DeleteProposalCustomDTO();
						}
						customDTO.addProposal((ContractCustomDTO)userContracts.get(selectedContractId[i]));
					}
				}
			}
		}
		
		return customDTO;
	}

	private void setProposalToBeDeleted(OPPTSession session, DeleteProposalCustomDTO proposalsToBeDeleted){
		if(null != session && null != proposalsToBeDeleted){
			session.storeObjectToSession(SessionConstants.SESSION_PROPOSALS_TO_BE_DELETED, proposalsToBeDeleted);
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
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.ARCHIVE_MAINTENANCE);
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
								currentForwardName = ForwardNameConstants.PAGE_ARCHIVE_CONTRACT;
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_CONTRACT_MAINTENANCE;
								break;
		}
		
		return currentForwardName;
	}
}
