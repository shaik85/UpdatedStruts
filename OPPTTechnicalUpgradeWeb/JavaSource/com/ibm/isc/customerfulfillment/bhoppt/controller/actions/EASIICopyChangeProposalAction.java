/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalHeaderActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalHeaderDetailsViewBean;
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
public class EASIICopyChangeProposalAction extends OPPTLongAction 
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception 
	{
		OPPTViewBean viewBean = null;
		
		ProposalCustomDTO selectedProposal = getProposalForChage(session);
		if(null == selectedProposal){
			viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA46));
			setForwardName(ForwardNameConstants.PAGE_ERROR);
		}
		else
		{
			ProposalHeaderCustomDTO customDTO = new ProposalHeaderCustomDTO();
			setTransactionInformation(customDTO, session);
			customDTO.setProposal(selectedProposal);
				
			try{
				customDTO = getProposalManager().getHeaderInformation(customDTO);
				addDataStoreEntry(session, customDTO);
				removeProposalForChage(session);
				setCurrentProposal(session, selectedProposal);
				setChangeProposalHeader(session, customDTO);
				setProposalHeaderActionForm(session, getProposalHeaderActionForm(customDTO));
				viewBean = new ProposalHeaderDetailsViewBean(customDTO);
				setForwardName(getRole(session), customDTO.isChangeVarianceProposal());
			}
			catch(ServiceException se){
				viewBean = handleErrorReport(session, se.getErrorReport());
			}
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
		return ActionNameConstants.CHANGE_PROPOSAL;
	}

	private ProposalCustomDTO getProposalForChage(OPPTSession session){
		ProposalCustomDTO customDTO = null;
		if(null != session){
			customDTO = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_TO_BE_CHANGED);
		}
		return customDTO;
	}
	private void removeProposalForChage(OPPTSession session){
		session.removeObjectFromSession(SessionConstants.PROPOSAL_TO_BE_CHANGED);
	}
	
	private void setChangeProposalHeader(OPPTSession session, ProposalHeaderCustomDTO customDTO){
		if(null != session && null != customDTO){
			session.storeObjectToSession(SessionConstants.PROPOSAL_HEADER, customDTO);
		}
	}
	private void setProposalHeaderActionForm(OPPTSession session, ProposalHeaderActionForm proposalHeaderActionForm) {
		if(null != proposalHeaderActionForm){
			session.storeObjectToSession(SessionConstants.PROPOSAL_HEADER_ACTION_FORM, proposalHeaderActionForm);
		}
	}

	private void setCurrentProposal(OPPTSession session, ProposalCustomDTO customDTO){
		if(customDTO instanceof ContractCustomDTO){
			ProposalCustomDTO currentProposal = new ProposalCustomDTO();
			currentProposal.setId(customDTO.getId());
			currentProposal.setName(customDTO.getName());
			currentProposal.setType(customDTO.getType());
			currentProposal.setStatus(customDTO.getStatus());
			currentProposal.setOldContractNumber(customDTO.getOldContractNumber());
			currentProposal.setLockedBy(customDTO.getLockedBy());
			currentProposal.setAccess(customDTO.getAccess());
			currentProposal.setFullAccess(customDTO.isFullAccess());
			session.storeObjectToSession(SessionConstants.CURRENT_PROPOSAL, currentProposal);
		}
		else{
			session.storeObjectToSession(SessionConstants.CURRENT_PROPOSAL, customDTO);
		}
	}

	private void setForwardName(int role, boolean varianceProposal){
		if(varianceProposal){
			switch(role){
				case Constants.PROPOSAL_CREATE_APPROVER: 
									setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CHANGE_VARIANCE_PROPOSAL);
									break;

				case Constants.PROPOSAL_ADMINISTRATOR:
				default:
									setForwardName(ForwardNameConstants.PAGE_CHANGE_VARIANCE_PROPOSAL);
									break;
			}
		}
		else{
			switch(role){
				case Constants.PROPOSAL_CREATE_APPROVER: 
									setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CHANGE_PROPOSAL);
									break;

				case Constants.PROPOSAL_ADMINISTRATOR:
				default:
									setForwardName(ForwardNameConstants.PAGE_CHANGE_PROPOSAL);
									break;
			}
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