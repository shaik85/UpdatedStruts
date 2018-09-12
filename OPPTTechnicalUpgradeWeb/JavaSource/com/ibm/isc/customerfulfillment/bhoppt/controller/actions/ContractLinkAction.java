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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 27, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class ContractLinkAction extends OPPTLongAction {
	/** 
	 * Overridden method - Enter your description here.
	 *  
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
		ContractCustomDTO currentContract = null;
		ProposalActionForm actionForm = (ProposalActionForm)form;
		if(null == actionForm.getProposalId()){
			currentContract = getCurrentContract(session);
		}
		else{
			currentContract = getSelectedContract(session, actionForm.getProposalId());
		}

		
		if(null != currentContract){
//			Added for the change DAD O11 Remove approval step,Blue Harmony -Ramesh
//			After clicking on the regected by ECC
			String curntContractStatus =currentContract.getStatus();
			OPPTLogger.debug("curntContractStatus"+curntContractStatus, "ContractLinkAction", "executeAction");
			if (curntContractStatus.equalsIgnoreCase("AA")||curntContractStatus.equalsIgnoreCase("VA")||curntContractStatus.equalsIgnoreCase("EA")){
				RejectProposalCustomDTO customDTO1 = new RejectProposalCustomDTO();
				setTransactionInformation(customDTO1, session);
				customDTO1.setProposalDTO(currentContract);
				customDTO1.setConfirmationRequired(false);
				try{
					getProposalManager().rejectRequest(customDTO1);
					OPPTLogger.debug("After execution of reject Request", "ContractLinkAction", "executeAction");
				}
				catch(ServiceException se){
					viewBean = handleErrorReport(session, se.getErrorReport());
				}
			}
//End Ramesh
		
			saveCurrentContract(session, currentContract);
			
			ProposalDetailsCustomDTO customDTO = new ProposalDetailsCustomDTO();
			setTransactionInformation(customDTO, session);
			customDTO.setProposalDTO(currentContract);
			customDTO.setPageIndex(1);
			customDTO.setRequestFor(UtilityConstants.GOTO_PAGE);
			
			try {
				OPPTLogger.debug("Before calling fetchProposal", "ContractLinkAction", "executeAction");
				customDTO = getProposalManager().fetchProposalDetails(customDTO);
				OPPTLogger.debug("After execution of fetchProposal", "ContractLinkAction", "executeAction");
				ErrorReport messageReport = customDTO.getMessageReport();
				if(null == messageReport)
				{
					if(customDTO.getProposalEditable())
					{
						addDataStoreEntry(session, customDTO);
						setProposalDetails(session, customDTO);
						updateInProposalDetails(session, customDTO.getTotalNoOfPages(), customDTO.getPageIndex(), customDTO.getMLCTotalNoOfPages(), customDTO.getMLCExcess());
						viewBean = new ProposalDetailsViewBean(customDTO);
						setForwardName(getRole(session));
					}
					else{
						setForwardName(ForwardNameConstants.ACTION_PROPOSAL_HEADER);
					}
				}					
				else{
					viewBean = new MessageViewBean(ForwardNameConstants.ACTION_CONTRACT_MAINTENANCE, true);
					viewBean.setErrorReport(messageReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);
				}
			}
			catch(ServiceException se){
				viewBean = handleErrorReport(se.getErrorReport(), ForwardNameConstants.ACTION_CONTRACT_MAINTENANCE, true);
			}
		}
		else{
			viewBean = new ErrorViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA00));
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
		return ActionNameConstants.PROPOSAL_DETAILS;
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
		return ForwardNameConstants.ACTION_PROPOSAL_DETAILS;
	}
	
	private void setProposalDetails(OPPTSession session, ProposalDetailsCustomDTO dto) {
		if(null != session & null != dto){
			session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS, dto);
		}
	}
	private void updateInProposalDetails(OPPTSession session, int totalPages, int pageIndex, int mlcTotalPages, int mlcExcess){
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_TOTAL_PAGES, new Integer(totalPages));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_PAGE_INDEX, new Integer(pageIndex));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_MLC_TOTAL_PAGES, new Integer(mlcTotalPages));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_MLC_EXCESS, new Integer(mlcExcess));
	}


	private ContractCustomDTO getSelectedContract(OPPTSession session, String contractId){
		ContractCustomDTO selectedContract = null;
		UserContractsCustomDTO userContracts = null;
		if(null != session && null != contractId){
			 userContracts = (UserContractsCustomDTO)session.getObjectFromSession(SessionConstants.USER_CONTRACT);
			if(null != userContracts){
				TreeMap contracts = userContracts.getContractCustomDTO();
				if(null != contracts){
					selectedContract = (ContractCustomDTO)contracts.get(contractId);
				}
			}
			
			else{
				
				userContracts = (UserContractsCustomDTO)session.getObjectFromSession(SessionConstants.USER_ARCHIVE);
				if(null != userContracts){
					TreeMap contracts = userContracts.getContractCustomDTO();
					if(null != contracts){
						selectedContract = (ContractCustomDTO)contracts.get(contractId);
					}
				}
			
			
			}
		}
		
		return selectedContract;
	}

	private ContractCustomDTO getCurrentContract(OPPTSession session){
		ContractCustomDTO contractDto = null;
		
		if(null != session){
			contractDto = (ContractCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);
		}
		
		return contractDto;
	}
	
	private void saveCurrentContract(OPPTSession session, ContractCustomDTO currentContract){
		if(null != session && null != currentContract){
			session.storeObjectToSession(SessionConstants.CURRENT_PROPOSAL, currentContract);
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

	private void setForwardName(int role){
		setFirstActionOfProcess(true);
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_DETAILS);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_CONTRACT_DETAILS);
								break;
		}
	}
}