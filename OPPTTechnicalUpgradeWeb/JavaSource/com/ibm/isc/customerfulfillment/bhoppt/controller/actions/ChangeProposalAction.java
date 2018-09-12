/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.math.BigDecimal;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalHeaderActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalMaintenanceActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.BasicProposalDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.DateDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.PricingInformationDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.SecondaryProposalDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.VarianceDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalHeaderDetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalMaintenanceViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ComplexContractIdentifiers;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserProposalsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ChangeProposalAction extends OPPTLongAction
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
		boolean selected_changeproposal=false;
		ProposalMaintenanceActionForm actionForm = (ProposalMaintenanceActionForm)form;
		//BH Wave1 - DAD 003 - Begin - Manoj
		ComplexContractIdentifiers complexContractIdentifiers = ComplexContractIdentifiers.getComplexContractIdentifiers();
		complexContractIdentifiers.ResetComplexContractIdentifiers();		
		// BH Wave1 - DAD 003 - End - Manoj
		if(null != actionForm)
		{
			String selectedIds[] = actionForm.getSelectedIds();
			if(null != selectedIds)
			{
				if(selectedIds.length == 1){
					ProposalCustomDTO selectedProposal = getProposal(session, selectedIds[0]);

					ProposalHeaderCustomDTO customDTO = new ProposalHeaderCustomDTO();
					setTransactionInformation(customDTO, session);
					customDTO.setProposal(selectedProposal);

					try{
						customDTO = getProposalManager().getHeaderInformation(customDTO);
						addDataStoreEntry(session, customDTO);
						setChangePrposalStatus(session,"true");
						setCurrentProposal(session, selectedProposal);
						setChangeProposalHeader(session, customDTO);
						setProposalHeaderActionForm(session, getProposalHeaderActionForm(customDTO));
						viewBean = new ProposalHeaderDetailsViewBean(customDTO);
						setForwardName(getRole(session), customDTO.isChangeVarianceProposal());
					}
					catch(ServiceException se){
						viewBean = handleServiceException(session, se.getErrorReport());
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
  
		/** Changes starts from here : Thirumalaikumar */

		actionForm.setCapAmount(getDoubleValue(customDTO.getVarianceInformationCustomDTO().getCapAmount()));
		actionForm.setCapMinus(getDoubleValue(customDTO.getVarianceInformationCustomDTO().getCapMinus()));
		actionForm.setCapPlus(getDoubleValue(customDTO.getVarianceInformationCustomDTO().getCapPlus()));

		//actionForm.setCapAmount(String.valueOf(customDTO.getVarianceInformationCustomDTO().getCapAmount()));
		//actionForm.setCapMinus(String.valueOf(customDTO.getVarianceInformationCustomDTO().getCapMinus()));
		//actionForm.setCapPlus(String.valueOf(customDTO.getVarianceInformationCustomDTO().getCapPlus()));
		
        // Changes end here
		return actionForm;
	}

	private String getDoubleValue(double doubleValue) {
		BigDecimal initialDouble = new BigDecimal((new Double(doubleValue)).toString());
		BigDecimal scaledDouble = initialDouble.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return scaledDouble.toString();
	}
	//ramesh
	private void setChangePrposalStatus(OPPTSession session,String selected_changeproposal) {
			session.storeObjectToSession(SessionConstants.CHANGE_PROPOSAL,selected_changeproposal);
	}
}