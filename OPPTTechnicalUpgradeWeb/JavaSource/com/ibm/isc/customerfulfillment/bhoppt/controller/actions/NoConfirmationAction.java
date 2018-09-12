/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ConfirmationActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalHeaderActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ConfirmationConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ConfigureDMViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalHeaderDetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeleteProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class NoConfirmationAction extends OPPTAction
{
	/**
     * execute
     * 
     * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#executeAction(org.apache.struts.action.ActionForm, com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession)
     * @author thirumalai
     */
    protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception 
	{
		OPPTViewBean viewBean = null;
		
		ConfirmationActionForm actionForm = (ConfirmationActionForm)form;
		if(null != actionForm){
			String initiator = actionForm.getInitiator();
			if(null != initiator){
				if(ConfirmationConstants.DELETE_PROPOSALS.equalsIgnoreCase(initiator)){
					viewBean = deleteProposals(session);
				}
				else if(ConfirmationConstants.DELETE_ARCHIVE.equalsIgnoreCase(initiator)){
					viewBean = deleteArchives(session);
				}
				else if(ConfirmationConstants.REMOVE_SVC_LICENSES.equalsIgnoreCase(initiator)){
					viewBean = removeSVCLicenses(session);
				}
				else if(ConfirmationConstants.DELETE_INVENTORY.equalsIgnoreCase(initiator)){
					viewBean = deleteInventory(session);
				}
				else if(ConfirmationConstants.CANCEL_CONFIGURE_DM.equalsIgnoreCase(initiator)){
					viewBean = cancelConfigureDM(session);
				}
				else if(ConfirmationConstants.CREATE_PROPOSAL.equalsIgnoreCase(initiator)){
					viewBean = createProposal(session);
				}
				else if(ConfirmationConstants.CHANGE_PROPOSAL_HEADER.equalsIgnoreCase(initiator)){
					viewBean = changeProposalHeader(session);
				}
				else if(ConfirmationConstants.APPROVE_PROPOSAL.equalsIgnoreCase(initiator)){
					viewBean = approveProposal(session);
				}
				else if(ConfirmationConstants.REVERT_PROPOSAL.equalsIgnoreCase(initiator)){
					viewBean = revertProposal(session);
				}
				else if(ConfirmationConstants.REMOVE_QUOTES.equalsIgnoreCase(initiator)){
					viewBean = removeQuotes(session);
				}
				//Added by Nayantara L Pai
				else if(ConfirmationConstants.CONFIRM_INACTIVATE.equalsIgnoreCase(initiator)){
					viewBean = inactivateBaseAgreement(session);
				}
				else if(ConfirmationConstants.INACTIVE_MODIFICATION_DETAILS.equalsIgnoreCase(initiator)){
					viewBean = inactiveModificationDetails(session);
				}
				

				else if(ConfirmationConstants.CONFIRM_DELETE_FORM_ACTION.equalsIgnoreCase(initiator)){
					viewBean = deleteForm(session);
				}
				else if(ConfirmationConstants.CONFIRM_REACTIVE_ACTION.equalsIgnoreCase(initiator)){
					viewBean = reactivateBaseAgreement(session);
				}
				//Added by Tapan Malhotra
				else if(ConfirmationConstants.APPLYTOALL_MODIFICATION.equalsIgnoreCase(initiator)){
					viewBean = applyToAllModification(session);
				}
				else if(ConfirmationConstants.CONFIRM_REACTIVATE_MODIFICATION.equalsIgnoreCase(initiator)){
					viewBean = reactiveModificationDetails(session);
				}
			}
		}
		
		return viewBean;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Feb 17, 2004 
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
		return ActionNameConstants.NO_CONFIRMATION;
	}

	private DeleteProposalCustomDTO getProposalToBeDeleted(OPPTSession session){
		DeleteProposalCustomDTO customDTO = null;
		if(null != session){
			customDTO = (DeleteProposalCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_PROPOSALS_TO_BE_DELETED);
		}
		return customDTO;
	}
	private OPPTViewBean deleteProposals(OPPTSession session) throws Exception {
		DeleteProposalCustomDTO customDTO = getProposalToBeDeleted(session);
		if(null != customDTO){
			if(ActionNameConstants.DELETE_PROPOSAL.equalsIgnoreCase(customDTO.getTransactionName())){
				setForwardName("proposalmaintenanceaction");  //$NON-NLS-1$
			}
			else{
				setForwardName("contractmaintenanceaction"); 
				

			}
			session.removeObjectFromSession(SessionConstants.SESSION_PROPOSALS_TO_BE_DELETED);
		}
		
		return null;
	}
	
	private OPPTViewBean deleteArchives(OPPTSession session) throws Exception {
		DeleteProposalCustomDTO customDTO = getProposalToBeDeleted(session);
		if(null != customDTO){
			
			setForwardName(ForwardNameConstants.ARCHIVE_CONTRACT_MAINTENANCE); 
			session.removeObjectFromSession(SessionConstants.SESSION_PROPOSALS_TO_BE_DELETED);
		}
		
		return null;
	}

	private OPPTViewBean removeSVCLicenses(OPPTSession session) throws Exception {
		setForwardName("proposaldetailsaction");  //$NON-NLS-1$
		return null;
	}

	private OPPTViewBean deleteInventory(OPPTSession session) throws Exception {
		session.removeObjectFromSession(SessionConstants.SESSION_INVENTIORY_TO_BE_DELETED);
		setForwardName("proposaldetailsaction");  //$NON-NLS-1$
		return null;
	}

	private ConfigureDMCustomDTO getConfigureDM(OPPTSession session){
		ConfigureDMCustomDTO customDTO = null;
		if(null != session){
			customDTO = (ConfigureDMCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_CONFIGURE_DM);
		}
		return customDTO;
	}
	private OPPTViewBean cancelConfigureDM(OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		ConfigureDMCustomDTO customDTO = getConfigureDM(session);
		if(null != customDTO){
			viewBean = new ConfigureDMViewBean(customDTO);
			setForwardName("configuredm");  //$NON-NLS-1$
		}
		return viewBean;
	}

	private OPPTViewBean inactivateBaseAgreement(OPPTSession session) throws Exception {
		setForwardName(ForwardNameConstants.PAGE_REFRESH_BASEAGREEMENT);  //$NON-NLS-1$
		return null;
	}
	private OPPTViewBean reactivateBaseAgreement(OPPTSession session) throws Exception {
		setForwardName(ForwardNameConstants.PAGE_REFRESH_BASEAGREEMENT);  //$NON-NLS-1$
		return null;
	}

	private OPPTViewBean inactiveModificationDetails(OPPTSession session) throws Exception {
	    OPPTViewBean viewBean = null;
	    DisplayModificationViewBean displayModificationViewBean = (DisplayModificationViewBean)session.getObjectFromSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN);
	    BaseAgreementDetailsCustomDTO customDto = (BaseAgreementDetailsCustomDTO) session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
	    if(customDto != null && customDto.getAgreementId() > 0) {
	      	setForwardName(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION_FOR_AMEND);
	      	session.storeObjectToSession(SessionConstants.SESSION_AMEND_FLAG,new Boolean(true));
	    }else {
          setForwardName(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION);
	    }
	    viewBean = displayModificationViewBean;
	    return viewBean;
	}
	
	private OPPTViewBean reactiveModificationDetails(OPPTSession session) throws Exception {
	    OPPTViewBean viewBean = null;
	    DisplayModificationViewBean displayModificationViewBean = (DisplayModificationViewBean)session.getObjectFromSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN);
	    BaseAgreementDetailsCustomDTO customDto = (BaseAgreementDetailsCustomDTO) session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
	    if(customDto != null && customDto.getAgreementId() > 0) {
	      	setForwardName(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION_FOR_AMEND);
	      	session.storeObjectToSession(SessionConstants.SESSION_AMEND_FLAG,new Boolean(true));
	    }else {
          setForwardName(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION);
	    }
	    viewBean = displayModificationViewBean;
	    return viewBean;
	}
	
	//Method added by Tapan Malhotra
	private OPPTViewBean applyToAllModification(OPPTSession session) throws Exception {
	    OPPTViewBean viewBean = null;
	    DisplayModificationViewBean displayModificationViewBean = (DisplayModificationViewBean)session.getObjectFromSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN);
	    BaseAgreementDetailsCustomDTO customDto = (BaseAgreementDetailsCustomDTO) session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
	    if(customDto != null && customDto.getAgreementId() > 0) {
	      	setForwardName(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION_FOR_AMEND);
	      	session.storeObjectToSession(SessionConstants.SESSION_AMEND_FLAG,new Boolean(true));
	    }else {
          setForwardName(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION);
	    }
	    viewBean = displayModificationViewBean;
	    return viewBean;
}
	//	Method added by Nayantara L Pai for Form Maintenance
	private OPPTViewBean deleteForm(OPPTSession session) throws Exception {
		setForwardName(ForwardNameConstants.PAGE_FORM_MAINTENANCE_ACTION);  //$NON-NLS-1$
		return null;
	}
	private ProposalHeaderCustomDTO getProposalHeader(OPPTSession session){
		ProposalHeaderCustomDTO customDTO = null;
		if(null != session){
			customDTO = (ProposalHeaderCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_HEADER);
		}
		return customDTO;
	}
	private OPPTViewBean changeProposalHeader(OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		ProposalHeaderCustomDTO customDTO = getProposalHeader(session);
		if(null != customDTO){
			viewBean = new ProposalHeaderDetailsViewBean(customDTO);
			setChangeProposalForwardName(getRole(session), customDTO.isChangeProposal());
		}
		return viewBean;
	}
	private void setChangeProposalForwardName(int role, boolean varianceProposal){
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


	private OPPTViewBean createProposal(OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		ProposalHeaderCustomDTO customDTO = getProposalHeader(session);
		if(null != customDTO){
			viewBean = session.getCurrentViewBean();
			
			ProposalHeaderActionForm actionForm = new ProposalHeaderActionForm();
			actionForm.setBasicProposalData(new BasicProposalDataBean(customDTO.getBasicProposalCustomDTO()));
			actionForm.setPricingInformation(new PricingInformationDataBean(customDTO.getPricingInformationCustomDTO()));
			actionForm.setVarianceData(new VarianceDataBean(customDTO.getVarianceInformationCustomDTO()));
			actionForm.setSecondaryProposalData(new SecondaryProposalDataBean(customDTO.getSecondaryProposalCustomDTO()));
			actionForm.setPurchaseOrderDate(new DateDataBean(actionForm.getSecondaryProposalData().getPurchaseOrderDate()));
			actionForm.setFixedValueDate(new DateDataBean(actionForm.getSecondaryProposalData().getFixedValDate()));
			actionForm.getBasicProposalData().setSalesOrganization(customDTO.getBasicProposalCustomDTO().getSalesOrganizationValue());
			
			actionForm.setCapAmount(String.valueOf(actionForm.getVarianceData().getCapAmount()));
			actionForm.setCapMinus(String.valueOf(actionForm.getVarianceData().getCapMinus()));
			actionForm.setCapPlus(String.valueOf(actionForm.getVarianceData().getCapPlus()));
			actionForm.setContractStartDate(new DateDataBean(actionForm.getBasicProposalData().getContractStartDate()));
			actionForm.setContractEndDate(new DateDataBean(actionForm.getBasicProposalData().getContractEndDate()));
			actionForm.setContractPeriodStartDate(new DateDataBean(actionForm.getBasicProposalData().getContractPeriodBeginning()));
			actionForm.setContractPeriodEndDate(new DateDataBean(actionForm.getBasicProposalData().getContractPeriodEnding()));
			viewBean.setActionForm(actionForm);
		}
		setCreateProposalForwardName(getRole(session));
		return viewBean;
	}
	private void setCreateProposalForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CREATE_PROPOSAL);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_CREATE_PROPOSAL);
								break;
		}
	}

	private OPPTViewBean approveProposal(OPPTSession session) throws Exception {
		session.removeObjectFromSession(SessionConstants.PROPOSAL_TO_BE_APPROVED);
//		Commented and added for the change DAD O11 Remove approval step,Blue Harmony -Ramesh
		//setForwardName(ForwardNameConstants.ACTION_PROPOSALS_FOR_APPROVAL);
		setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_MAINTENANCE);
		
		return null;
	}

	private OPPTViewBean revertProposal(OPPTSession session) throws Exception {
		session.removeObjectFromSession(SessionConstants.REVERT_PROPOSAL);
		setForwardName(ForwardNameConstants.ACTION_CONTRACT_MAINTENANCE);
		return null;
	}
	
	private OPPTViewBean removeQuotes(OPPTSession session) throws Exception {
		setForwardName("proposaldetailsaction");  //$NON-NLS-1$
		return null;
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