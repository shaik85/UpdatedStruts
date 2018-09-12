/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalHeaderActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalHeaderDetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalForApprovalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ProposalHeaderDetailsAction extends OPPTLongAction 
{
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
		
		ProposalCustomDTO currentProposal = getCurrentProposal(session);
		if(null != currentProposal){
			ProposalHeaderCustomDTO  customDTO = new ProposalHeaderCustomDTO();
			setTransactionInformation(customDTO, session);
			customDTO.setProposal(currentProposal);
			
			try {
				customDTO = getProposalManager().getHeaderInformation(customDTO);
				ErrorReport messageReport = customDTO.getMessageReport();
				if(null == messageReport){
					addDataStoreEntry(session, customDTO);
					setProposalHeaderActionForm(session, getProposalHeaderActionForm(customDTO));
					viewBean = new ProposalHeaderDetailsViewBean(customDTO);
					setForwardName(session, currentProposal, customDTO.isChangeVarianceProposal());
				}
				else{
					viewBean = new MessageViewBean();
					viewBean.setErrorReport(messageReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);
				}
			}
			catch(ServiceException se){
				viewBean = new ErrorViewBean(se.getErrorReport());
				setForwardName(ForwardNameConstants.PAGE_ERROR);
			}
		}
		else{
			viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA26));
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
		return ActionNameConstants.PROPOSAL_HEADER_DETAILS;
	}

	/**
	 * Gets the current proposal stored as part of the session  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session OPPTSession
	 * @return ProposalCustomDTO
	 */
	private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
		ProposalCustomDTO currentProposal = null;
		
		if(null != session){
			currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);
		}
		
		return currentProposal;
	}

	private void setProposalHeaderActionForm(OPPTSession session, ProposalHeaderActionForm proposalHeaderActionForm) {
		if(null != proposalHeaderActionForm){
			session.storeObjectToSession(SessionConstants.PROPOSAL_HEADER_ACTION_FORM, proposalHeaderActionForm);
		}
	}

	private void setForwardName(OPPTSession session, ProposalCustomDTO currentProposal, boolean varianceProposal){
		if(currentProposal instanceof ContractCustomDTO){
			setContractHeaderForwardName(getRole(session), varianceProposal);
		}
		else if(currentProposal instanceof ProposalForApprovalCustomDTO){
			setProposalForApprovalHeaderForwardName(getRole(session), varianceProposal);
		}
		else{
			setProposalHeaderForwardName(getRole(session), varianceProposal);
		}
	}
	
	private void setProposalHeaderForwardName(int role, boolean varianceProposal){
		// setFirstActionOfProcess(true);
		if(varianceProposal){
			switch(role){
				case Constants.PROPOSAL_CREATE_APPROVER: 
									setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_VARIANCE_PROPOSAL_HEADER);
									break;

				case Constants.PROPOSAL_ADMINISTRATOR:
				default:
									setForwardName(ForwardNameConstants.PAGE_VARIANCE_PROPOSAL_HEADER);
									break;
			}
		}
		else{
			switch(role){
				case Constants.PROPOSAL_CREATE_APPROVER: 
									setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSAL_HEADER);
									break;

				case Constants.PROPOSAL_ADMINISTRATOR:
				default:
									setForwardName(ForwardNameConstants.PAGE_PROPOSAL_HEADER);
									break;
			}
		}
	}

	private void setContractHeaderForwardName(int role, boolean varianceProposal){
		// setFirstActionOfProcess(true);
		if(varianceProposal){
			switch(role){
				case Constants.PROPOSAL_CREATE_APPROVER: 
									setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_VARIANCE_CONTRACT_HEADER);
									break;

				case Constants.PROPOSAL_ADMINISTRATOR:
				default:
									setForwardName(ForwardNameConstants.PAGE_VARIANCE_CONTRACT_HEADER);
									break;
			}
		}
		else{
			switch(role){
				case Constants.PROPOSAL_CREATE_APPROVER: 
									setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_HEADER);
									break;

				case Constants.PROPOSAL_ADMINISTRATOR:
				default:
									setForwardName(ForwardNameConstants.PAGE_CONTRACT_HEADER);
									break;
			}
		}
	}

	private void setProposalForApprovalHeaderForwardName(int role, boolean varianceProposal){
		setFirstActionOfProcess(true);
		if(varianceProposal){
			switch(role){
				case Constants.PROPOSAL_CREATE_APPROVER: 
									setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSALS_FOR_APPROVAL_VARIANCE_HEADER);
									break;

				case Constants.PROPOSAL_APPROVER:
				default:
									setForwardName(ForwardNameConstants.PAGE_PROPOSAL_FOR_APPROVAL_VARIANCE_HEADER);
									break;
			}
		}
		else{
			switch(role){
				case Constants.PROPOSAL_CREATE_APPROVER: 
									setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSALS_FOR_APPROVAL_HEADER);
									break;

				case Constants.PROPOSAL_APPROVER:
				default:
									setForwardName(ForwardNameConstants.PAGE_PROPOSAL_FOR_APPROVAL_HEADER);
									break;
			}
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
	
	private ProposalHeaderActionForm getProposalHeaderActionForm(ProposalHeaderCustomDTO customDTO){
		ProposalHeaderActionForm actionForm = new ProposalHeaderActionForm();
		
		actionForm.setBasicProposalData(new BasicProposalDataBean(customDTO.getBasicProposalCustomDTO()));
		actionForm.setPricingInformation(new PricingInformationDataBean(customDTO.getPricingInformationCustomDTO()));
		actionForm.setVarianceData(new VarianceDataBean(customDTO.getVarianceInformationCustomDTO()));
		actionForm.setSecondaryProposalData(new SecondaryProposalDataBean(customDTO.getSecondaryProposalCustomDTO()));
		
		actionForm.setContractStartDate(new DateDataBean(customDTO.getBasicProposalCustomDTO().getContractStartDate()));		
		actionForm.setContractEndDate(new DateDataBean(customDTO.getBasicProposalCustomDTO().getContractEndDate()));		
		actionForm.setContractPeriodStartDate(new DateDataBean(customDTO.getBasicProposalCustomDTO().getContractPeriodBeginning()));		
		actionForm.setContractPeriodEndDate(new DateDataBean(customDTO.getBasicProposalCustomDTO().getContractPeriodEnding()));		
		actionForm.setPurchaseOrderDate(new DateDataBean(customDTO.getSecondaryProposalCustomDTO().getPurchaseOrderDate()));		
		actionForm.setFixedValueDate(new DateDataBean(customDTO.getSecondaryProposalCustomDTO().getFixedValDate()));
		actionForm.setReplacementDate(new DateDataBean(customDTO.getBasicProposalCustomDTO().getReplacementContractDate()));

		actionForm.setCapAmount(String.valueOf(customDTO.getVarianceInformationCustomDTO().getCapAmount()));
		actionForm.setCapMinus(String.valueOf(customDTO.getVarianceInformationCustomDTO().getCapMinus()));
		actionForm.setCapPlus(String.valueOf(customDTO.getVarianceInformationCustomDTO().getCapPlus()));

		return actionForm;
	}
}