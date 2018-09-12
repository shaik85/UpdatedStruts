/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.NewProposalNameActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.NewProposalNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Action that is used for submitting the new proposal name 
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
public class NewProposalNameAction extends OPPTLongAction {

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 23, 2003 
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception 
	{
		OPPTViewBean viewBean = null;
		
		NewProposalNameActionForm actionForm = (NewProposalNameActionForm)form;
		if(null != actionForm){
			String initiator = actionForm.getInitiator();
			if(null != initiator){
				if(NewProposalNameConstants.RENAME_PROPOSAL.equalsIgnoreCase(initiator)){
					viewBean = renameProposal(session, actionForm.getNewProposalName());
				}
				else if(NewProposalNameConstants.COPY_PROPOSAL.equalsIgnoreCase(initiator)){
					viewBean = copyProposal(session, actionForm.getNewProposalName());
				}
				else if(NewProposalNameConstants.COPY_CONTRACT_EAS.equalsIgnoreCase(initiator)){
					viewBean = copyContractEAS(session, actionForm.getNewProposalName());
				}
				else if(NewProposalNameConstants.RENEW_CONTRACT.equalsIgnoreCase(initiator)){
					viewBean = renewContract(session, actionForm.getNewProposalName());
				}
				else if(NewProposalNameConstants.CREATE_VARIANCE_PROPOSAL.equalsIgnoreCase(initiator)){
					viewBean = createVarianceProposal(session, actionForm.getNewProposalName());
				}
				else if(NewProposalNameConstants.COPY_REPLACE_CONTRACT.equalsIgnoreCase(initiator)){
					viewBean = copyReplaceContract(session, actionForm.getNewProposalName());
				}
			}
		}
		
		return viewBean;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 23, 2003 
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
		return ActionNameConstants.NEW_PROPOSALNAME;
	}

	private OPPTViewBean renameProposal(OPPTSession session, String newProposalName) throws Exception{
		OPPTViewBean viewBean = null;
		
		if(null != newProposalName)
		{
			ProposalCustomDTO customDTO = getProposalToBeRenamed(session);
			if(null != customDTO){
				customDTO.setName(newProposalName);
				customDTO.setConfirmationRequired(false);
				
				try {
					getProposalManager().renameProposal(customDTO);
					removeProposalToBeRenamed(session);
					setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_MAINTENANCE);
				}
				catch(ServiceException se){
					viewBean = handleErrorReport(se.getErrorReport());
				}
			}
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA20));
			setForwardName(session.getCurrentForward());
		}
		
		return viewBean;
	}
	private ProposalCustomDTO getProposalToBeRenamed(OPPTSession session){
		ProposalCustomDTO customDTO = null;
		if(null != session){
			customDTO = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_PROPOSAL_TO_BE_RENAMED);
		}
		return customDTO;
	}
	private void removeProposalToBeRenamed(OPPTSession session){
		if(null != session){
			session.removeObjectFromSession(SessionConstants.SESSION_PROPOSAL_TO_BE_RENAMED);
		}
	}


	private OPPTViewBean copyProposal(OPPTSession session, String newProposalName) throws Exception{
		OPPTViewBean viewBean = null;
		
		if(null != newProposalName)
		{
			ProposalCustomDTO customDTO = getProposalToBeCopied(session);
			if(null != customDTO){
				CopyProposalCustomDTO copyCustomDTO = new CopyProposalCustomDTO();
				copyCustomDTO.setSourceProposal(customDTO);
				setTransactionInformation(copyCustomDTO, session);
				copyCustomDTO.setTransactionName(customDTO.getTransactionName());
				copyCustomDTO.setNewProposalName(newProposalName);
				
				try {
					getProposalManager().copyProposal(copyCustomDTO);
					removeProposalToBeCopied(session);
					setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_MAINTENANCE);
				}
				catch(ServiceException se){
					viewBean = handleErrorReport(se.getErrorReport());
				}
			}
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA20));
			setForwardName(session.getCurrentForward());
		}
		
		return viewBean;
	}
	private ProposalCustomDTO getProposalToBeCopied(OPPTSession session){
		ProposalCustomDTO customDTO = null;
		if(null != session){
			customDTO = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_PROPOSAL_TO_BE_COPIED);
		}
		return customDTO;
	}
	private void removeProposalToBeCopied(OPPTSession session){
		if(null != session){
			session.removeObjectFromSession(SessionConstants.SESSION_PROPOSAL_TO_BE_COPIED);
		}
	}
	
	private OPPTViewBean copyContractEAS(OPPTSession session, String newProposalName) throws Exception{
		OPPTViewBean viewBean = null;

		if(null != newProposalName)
		{
			EASIICopyCustomDTO customDTO = new EASIICopyCustomDTO();
			customDTO.setContractDTO((ContractCustomDTO)getFromSesession(session,SessionConstants.SESSION_CONTRACT_TO_BE_COPIED));
			customDTO.setNewProposalName(newProposalName);
			setTransactionInformation(customDTO, session);
		
			try {
				customDTO = getProposalManager().easIICopy(customDTO);
				callChangeProposal(customDTO.getContractDTO(), session);
				removeFromSession(session, SessionConstants.SESSION_CONTRACT_TO_BE_COPIED);
				setForwardName(ForwardNameConstants.ACTION_CONTRACT_CHANGE_PROPOSAL);
			}
			catch(ServiceException se){
				viewBean = handleErrorReport(se.getErrorReport());
			}
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA20));
			setForwardName(session.getCurrentForward());
		}
	
		return viewBean;
	}
	
	/**
	 *  
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session
	 * @param newProposalName
	 * @return
	 * @throws Exception
	 */
	private OPPTViewBean renewContract(OPPTSession session, String newProposalName) throws Exception{
		OPPTViewBean viewBean = null;
		RenewContractCustomDTO renewCustomDto;

		if(null != newProposalName)
		{
			renewCustomDto = (RenewContractCustomDTO)getFromSesession(session, SessionConstants.SESSION_CONTRACT_RENEW);
			
			if(null != renewCustomDto){
				renewCustomDto.setNewProposalName(newProposalName);
				try {
					setTransactionInformation(renewCustomDto, session);
					renewCustomDto = getProposalManager().enterRenewContractInfo(renewCustomDto);
					callChangeProposal(renewCustomDto.getContractDTO(), session);
					removeFromSession(session,SessionConstants.SESSION_CONTRACT_RENEW);
					setForwardName(ForwardNameConstants.ACTION_CONTRACT_CHANGE_PROPOSAL);
				}
				catch(ServiceException se){
					viewBean = handleErrorReport(se.getErrorReport());
				}
			}
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA20));
			setForwardName(session.getCurrentForward());
		}

		return viewBean;
	}
	
	
	
	private OPPTViewBean createVarianceProposal(OPPTSession session, String newProposalName) throws Exception{
		OPPTViewBean viewBean = null;
		VarianceHeaderInformationCustomDTO headerCustomDto=null;

		if(null != newProposalName)
		{
			headerCustomDto = (VarianceHeaderInformationCustomDTO)getFromSesession(session, SessionConstants.VARIANCE_CHECK);
		
			if(null != headerCustomDto){
				headerCustomDto.setNewProposalName(newProposalName);
				headerCustomDto.setConfirmationRequired(false);
				try {
					setTransactionInformation(headerCustomDto, session);
					headerCustomDto = getProposalManager().createVarianceProposal(headerCustomDto);
					callChangeProposal(getProposal(headerCustomDto.getContractDTO()), session);
					removeFromSession(session,SessionConstants.VARIANCE_CHECK);
					setForwardName(ForwardNameConstants.ACTION_CONTRACT_CHANGE_PROPOSAL);
				}
				catch(ServiceException se){
					viewBean = handleErrorReport(se.getErrorReport());
				}
			}
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA20));
			setForwardName(session.getCurrentForward());
		}

		return viewBean;
	}
	
	
	/**
	 *  
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session
	 * @param newProposalName
	 * @return
	 * @throws Exception
	 */
	private OPPTViewBean copyReplaceContract(OPPTSession session, String newProposalName) throws Exception{
		OPPTViewBean viewBean = null;
		ReplaceContractCustomDTO replaceCustomDto;
		CopyReplacementCustomDTO copyCustomDto = new CopyReplacementCustomDTO();
		if(null != newProposalName)
		{
			replaceCustomDto = (ReplaceContractCustomDTO)getFromSesession(session, SessionConstants.SESSION_REPLACE_CONTRACT);
		
			if(null != replaceCustomDto){
				copyCustomDto.setReplaceContractDTO(replaceCustomDto);
				copyCustomDto.setNewProposalName(newProposalName);

				try {
					setTransactionInformation(copyCustomDto, session);
					copyCustomDto = getProposalManager().copyReplaceContract(copyCustomDto);
					callChangeProposal(getProposal(copyCustomDto.getReplaceContractDTO().getContractDTO()), session);
					removeFromSession(session,SessionConstants.SESSION_REPLACE_CONTRACT);
					setForwardName(ForwardNameConstants.ACTION_CONTRACT_CHANGE_PROPOSAL);
				}
				catch(ServiceException se){
					viewBean = handleErrorReport(se.getErrorReport());
				}
			}
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA20));
			setForwardName(session.getCurrentForward());
		}

		return viewBean;
	}
	
	private ProposalCustomDTO getProposal(ContractCustomDTO contract){
		ProposalCustomDTO proposal = null;
		if(null != contract){
			proposal = new ProposalCustomDTO();
			proposal.setId(contract.getId());
			proposal.setName(contract.getName());
			proposal.setType(contract.getType());
			proposal.setStatus(contract.getStatus());
			proposal.setOldContractNumber(contract.getOldContractNumber());
			proposal.setLockedBy(contract.getLockedBy());
			proposal.setAccess(contract.getAccess());
			proposal.setFullAccess(contract.isFullAccess());
		}
		return proposal;
	}
	
///// Common Functions Created By Anshuman
	/**
	 *  
	 * For Change Proposal, stores ContractCustomDTO in session
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session
	 */
	private void callChangeProposal(ProposalCustomDTO customDTO, OPPTSession session){
		session.storeObjectToSession(SessionConstants.PROPOSAL_TO_BE_CHANGED, customDTO);
	}
	
	/**
	 *  
	 * Retrieve a DTO from session
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
	 * @param key
	 * @return
	 */
	private OPPTCustomDTO getFromSesession(OPPTSession session, String key){
		OPPTCustomDTO customDto=null;
		customDto = (OPPTCustomDTO)session.getObjectFromSession(key);
		
		return customDto;
	}
	
	
	/**
	 *  
	 * Remove a DTO from session
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
	 * @param key
	 */
	private void removeFromSession(OPPTSession session, String key){
		session.removeObjectFromSession(key);
	}
	
	
	/** 
	 * Overridden method - Usage of back button is not allowed for this action. So return false. 
	 * 
	 * <br/><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#isBackButtonAllowed() 
	 * @return 
	 * 
	 */
	protected boolean isBackButtonAllowed() {
		return false;
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
