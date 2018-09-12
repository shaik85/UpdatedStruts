/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.PartnerSelectionActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.AlternatePartnerViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerSelectionViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.PartnerTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AlternatePartnerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ESWCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchPartnerInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class AlternatePartnerAction extends OPPTAction {
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
		
		PartnerSelectionActionForm actionForm = (PartnerSelectionActionForm)form;
		String alternateSource = null;
		boolean otherSelected = false;
		int partnerType = -1;
	
		String source = actionForm.getSoldToPartyNumber();
		
		if(null != source && source.equalsIgnoreCase(Constants.ALTERNATE_PARTNER_SOURCE)){
			otherSelected = true;
			alternateSource = Constants.ALTERNATE_PARTNER_SOLD_TO_PARTY;
			partnerType = Constants.SOLD_TO_PARTY;
		}
		if(!otherSelected){
			source = actionForm.getSoldToPartyName();
			if(null != source && source.equalsIgnoreCase(Constants.ALTERNATE_PARTNER_SOURCE)){
				otherSelected = true;
				alternateSource = Constants.ALTERNATE_PARTNER_SOLD_TO_PARTY;
				partnerType = Constants.SOLD_TO_PARTY;
			}
		}
		if(!otherSelected){
			source = actionForm.getBillToPartyNumber();
			if(null != source && source.equalsIgnoreCase(Constants.ALTERNATE_PARTNER_SOURCE)){
				otherSelected = true;
				alternateSource = Constants.ALTERNATE_PARTNER_BILL_TO_PARTY;
				partnerType = Constants.BILL_TO_PARTY;
			}
		}
		if(!otherSelected){
			source = actionForm.getBillToPartyName();
			if(null != source && source.equalsIgnoreCase(Constants.ALTERNATE_PARTNER_SOURCE)){
				otherSelected = true;
				alternateSource = Constants.ALTERNATE_PARTNER_BILL_TO_PARTY;
				partnerType = Constants.BILL_TO_PARTY;
			}
		}
		if(!otherSelected){
			source = actionForm.getPayerNumber();
			if(null != source && source.equalsIgnoreCase(Constants.ALTERNATE_PARTNER_SOURCE)){
				otherSelected = true;
				alternateSource = Constants.ALTERNATE_PARTNER_PAYER;
				partnerType = Constants.PAYER;
			}
		}
		if(!otherSelected){
			source = actionForm.getPayerName();
			if(null != source && source.equalsIgnoreCase(Constants.ALTERNATE_PARTNER_SOURCE)){
				otherSelected = true;
				alternateSource = Constants.ALTERNATE_PARTNER_PAYER;
				partnerType = Constants.PAYER;
			}
		}
		if(!otherSelected){
			source = actionForm.getShipToPartyNumber();
			if(null != source && source.equalsIgnoreCase(Constants.ALTERNATE_PARTNER_SOURCE)){
				otherSelected = true;
				alternateSource = Constants.ALTERNATE_PARTNER_SHIP_TO_PARTY;
				partnerType = Constants.SHIP_TO_PARTY;
			}
		}
		if(!otherSelected){
			source = actionForm.getShipToPartyName();
			if(null != source && source.equalsIgnoreCase(Constants.ALTERNATE_PARTNER_SOURCE)){
				otherSelected = true;
				alternateSource = Constants.ALTERNATE_PARTNER_SHIP_TO_PARTY;
				partnerType = Constants.SHIP_TO_PARTY;
			}
		}
		if(otherSelected){
			viewBean = new AlternatePartnerViewBean(partnerType);
			setForwardName(getRole(session));
		}
		else{
			source = actionForm.getNineDPartnerNumber();
			if(null != source && 0 < source.length()){
				viewBean = handleNineDPartner(session, actionForm);
			}
			else{
				source = actionForm.getPayerNumber();
				if(null != source && 0 < source.length() && changeInPayer(session, actionForm)){
					viewBean = handlePayer(session, actionForm);
				}
				else{
					source = actionForm.getBillToPartyNumber();
					if(null != source && 0 < source.length() && changeInBillToParty(session, actionForm)){
						viewBean = handleBillToParty(session, actionForm);
					}
					else{
						viewBean = session.getCurrentViewBean();
						viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA03));
						setForwardName(session.getCurrentForward());
					}
				}
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
		return ActionNameConstants.ALTERNATE_PARTNER;
	}

	private OPPTViewBean handleNineDPartner(OPPTSession session, PartnerSelectionActionForm actionForm) throws Exception{
		OPPTViewBean viewBean = null;
		
		FetchPartnerInformationCustomDTO partnerCustomDTO = getPartnerSelectionInformation(session);
		AlternatePartnerCustomDTO customDTO = new AlternatePartnerCustomDTO();
		setTransactionInformation(customDTO, session);
		customDTO.setSAPCustomerNumber(actionForm.getNineDPartnerNumber());
		customDTO.setCustomerName(actionForm.getNineDPartnerName());
		customDTO.setPartnerType(Constants.NINED_PARTNER);
		ProposalHeaderCustomDTO proposalHeader = getProposalHeaderInformation(session);
		customDTO.setDivision(proposalHeader.getBasicProposalCustomDTO().getDivision());
		customDTO.setDistributionChannel(proposalHeader.getBasicProposalCustomDTO().getDistributionChannel());
		customDTO.setSalesGroup(proposalHeader.getBasicProposalCustomDTO().getSalesGroup());
		customDTO.setChannelRole(proposalHeader.getBasicProposalCustomDTO().getChannelRole());
		customDTO.setSubmitterRole(proposalHeader.getBasicProposalCustomDTO().getSubmitterRole());
		customDTO.setSelectedSalesOrg(proposalHeader.getBasicProposalCustomDTO().getSalesOrganization());

		try {
			customDTO = getProposalManager().fetchAlternatePartner(customDTO);

			ErrorReport messageReport = customDTO.getMessageReport();
			if(null == messageReport)
			{
				addDataStoreEntry(session, customDTO);
				saveAlternatePartner(session, partnerCustomDTO, customDTO.getPartnerInfo(), Constants.NINED_PARTNER);
				viewBean = new PartnerSelectionViewBean(partnerCustomDTO, proposalHeader.getCustomerLists(), actionForm.getComments());
				setPartnerSelectionForwardName(getRole(session));
			}
			else{
				viewBean = new MessageViewBean(session.getCurrentForward());
				viewBean.setErrorReport(messageReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);
			}
		}
		catch(ServiceException se){
			viewBean = handleServiceException(session, se.getErrorReport(), session.getCurrentForward(), session.getCurrentForward());
		}
		
		
		return viewBean;
	}

	private OPPTViewBean handleBillToParty(OPPTSession session, PartnerSelectionActionForm actionForm) throws Exception{
		OPPTViewBean viewBean = null;
		
		if(isFieldEmpty(actionForm.getPayerNumber()) || isFieldEmpty(actionForm.getPayerASNumber())){
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA36));
			setForwardName(session.getCurrentForward());
		}
		else{
			FetchPartnerInformationCustomDTO partnerCustomDTO = getPartnerSelectionInformation(session);
			AlternatePartnerCustomDTO customDTO = new AlternatePartnerCustomDTO();
			setTransactionInformation(customDTO, session);
			customDTO.setTransactionName(ActionNameConstants.IGF_ACTION);
			customDTO.setSAPCustomerNumber(actionForm.getBillToPartyNumber()); //fix for Defectid 83160
			customDTO.setLegacyCustomerNumber(actionForm.getBillToPartyNumber());
			customDTO.setSequenceNumber(actionForm.getBillToPartyASNumber());
			customDTO.setCustomerName(actionForm.getBillToPartyName());
			customDTO.setPartnerType(Constants.BILL_TO_PARTY);

			ProposalHeaderCustomDTO proposalHeader = getProposalHeaderInformation(session);
			customDTO.setDivision(proposalHeader.getBasicProposalCustomDTO().getDivision());
			customDTO.setDistributionChannel(proposalHeader.getBasicProposalCustomDTO().getDistributionChannel());
			customDTO.setSalesGroup(proposalHeader.getBasicProposalCustomDTO().getSalesGroup());
			customDTO.setChannelRole(proposalHeader.getBasicProposalCustomDTO().getChannelRole());
			customDTO.setSubmitterRole(proposalHeader.getBasicProposalCustomDTO().getSubmitterRole());
			customDTO.setSelectedSalesOrg(proposalHeader.getBasicProposalCustomDTO().getSalesOrganization());

			try {
				customDTO = getProposalManager().fetchAlternatePartner(customDTO);

				ErrorReport messageReport = customDTO.getMessageReport();
				if(null == messageReport)
				{
					addDataStoreEntry(session, customDTO);
					saveAlternatePartner(session, partnerCustomDTO, customDTO.getPartnerInfo(), Constants.BILL_TO_PARTY);
					viewBean = new PartnerSelectionViewBean(partnerCustomDTO, proposalHeader.getCustomerLists(), actionForm.getComments());
					setPartnerSelectionForwardName(getRole(session));
				}
				else{
					viewBean = new MessageViewBean(session.getCurrentForward());
					viewBean.setErrorReport(messageReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);
				}
			}
			catch(ServiceException se){
				viewBean = handleServiceException(session, se.getErrorReport(), session.getCurrentForward(), session.getCurrentForward());
			}
		}
		return viewBean;
	}

	private boolean changeInPayer(OPPTSession session, PartnerSelectionActionForm actionForm){
		boolean changeInPayer = false;
		
		FetchPartnerInformationCustomDTO partnerCustomDTO = getPartnerSelectionInformation(session);
		ESWCustomerCustomDTO selectedPayer = partnerCustomDTO.getSelectedPayer();
		if(null != selectedPayer){
			if(isDifferent(selectedPayer.getLegacyCustomerNumber(), actionForm.getPayerNumber())){
				changeInPayer = true;
			}
		}
		else{
			changeInPayer = true;
		}
		return changeInPayer;
	}

	private boolean changeInBillToParty(OPPTSession session, PartnerSelectionActionForm actionForm){
		boolean changeInBillToParty = false;
		
		FetchPartnerInformationCustomDTO partnerCustomDTO = getPartnerSelectionInformation(session);
		ESWCustomerCustomDTO selectedBillToParty = partnerCustomDTO.getSelectedBillToParty();
		if(null != selectedBillToParty){
			if(isDifferent(selectedBillToParty.getLegacyCustomerNumber(), actionForm.getBillToPartyNumber())){
				changeInBillToParty = true;
			}
		}
		else{
			changeInBillToParty = true;
		}
		return changeInBillToParty;
	}

	private OPPTViewBean handlePayer(OPPTSession session, PartnerSelectionActionForm actionForm) throws Exception{
		OPPTViewBean viewBean = null;
		FetchPartnerInformationCustomDTO partnerCustomDTO = getPartnerSelectionInformation(session);
		AlternatePartnerCustomDTO customDTO = new AlternatePartnerCustomDTO();
		setTransactionInformation(customDTO, session);
		customDTO.setTransactionName(ActionNameConstants.IGF_ACTION);
		customDTO.setSAPCustomerNumber(actionForm.getPayerNumber()); //fix for Defectid 83160
		customDTO.setLegacyCustomerNumber(actionForm.getPayerNumber());
		customDTO.setSequenceNumber(actionForm.getPayerASNumber());
		customDTO.setCustomerName(actionForm.getPayerName());
		customDTO.setPartnerType(Constants.PAYER);

		ProposalHeaderCustomDTO proposalHeader = getProposalHeaderInformation(session);
		
		String igfNumber = proposalHeader.getSecondaryProposalCustomDTO().getIgfOfferNumber();
		if(igfNumber != null && igfNumber.trim().length() > 0) {
			customDTO.setFinancingFlag(true);
		}
		customDTO.setDivision(proposalHeader.getBasicProposalCustomDTO().getDivision());
		customDTO.setDistributionChannel(proposalHeader.getBasicProposalCustomDTO().getDistributionChannel());
		customDTO.setSalesGroup(proposalHeader.getBasicProposalCustomDTO().getSalesGroup());
		customDTO.setChannelRole(proposalHeader.getBasicProposalCustomDTO().getChannelRole());
		customDTO.setSubmitterRole(proposalHeader.getBasicProposalCustomDTO().getSubmitterRole());
		customDTO.setSelectedSalesOrg(proposalHeader.getBasicProposalCustomDTO().getSalesOrganization());

		try {
			customDTO = getProposalManager().fetchAlternatePartner(customDTO);

			ErrorReport messageReport = customDTO.getMessageReport();
			if(null == messageReport)
			{
				addDataStoreEntry(session, customDTO);
				saveAlternatePartner(session, partnerCustomDTO, customDTO.getPartnerInfo(), Constants.PAYER);
				viewBean = new PartnerSelectionViewBean(partnerCustomDTO, proposalHeader.getCustomerLists(), actionForm.getComments(), customDTO.isBtpEditable());
				setPartnerSelectionForwardName(getRole(session));
			}
			else{
				viewBean = new MessageViewBean(session.getCurrentForward());
				viewBean.setErrorReport(messageReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);
			}
		}
		catch(ServiceException se){
			viewBean = handleServiceException(session, se.getErrorReport(), session.getCurrentForward(), session.getCurrentForward());
		}

		return viewBean;
	}

	private FetchPartnerInformationCustomDTO getPartnerSelectionInformation(OPPTSession session) {
		FetchPartnerInformationCustomDTO customDTO = null;
		if(null != session){
			customDTO = (FetchPartnerInformationCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_CREATION_PARTNERS);
		}
		return customDTO;
	}
	private ProposalHeaderCustomDTO getProposalHeaderInformation(OPPTSession session) {
		return (ProposalHeaderCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_HEADER);
	}

	private void saveAlternatePartner(OPPTSession session, FetchPartnerInformationCustomDTO partnerCustomDTO, ESWCustomerCustomDTO alternatePartner, int partnerType){
		if(null != alternatePartner && null != partnerCustomDTO){
			switch(partnerType){
				case Constants.NINED_PARTNER:
							partnerCustomDTO.setSelectedNineDPartner(alternatePartner);
							break;
				case Constants.PAYER:
							partnerCustomDTO.setSelectedPayer(alternatePartner);
							partnerCustomDTO.setSelectedBillToParty(alternatePartner);
							break;
				case Constants.BILL_TO_PARTY:
							partnerCustomDTO.setSelectedBillToParty(alternatePartner);
							break;					
			    default :
                    break;
            }
			
			session.storeObjectToSession(SessionConstants.PROPOSAL_CREATION_PARTNERS, partnerCustomDTO);
		}
	}
	
	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_ALTERNATE_PARTNER);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_ALTERNATE_PARTNER);
								break;
		}
	}

	private void setPartnerSelectionForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PARTNER_SELECTION);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_PARTNER_SELECTION);
								break;
		}
	}
	
	/**
     * validateCurrentViewContent
     * 
     * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#validateCurrentViewContent(com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession)
     * @author thirumalai
     */
    protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = getCurrentForwardName(getRole(session));

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof PartnerSelectionViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.CUSTOMER_SELECTION);
			if(null != dataStoreEntry && dataStoreEntry instanceof FetchPartnerInformationCustomDTO){
				session.setCurrentViewBean(new PartnerSelectionViewBean((FetchPartnerInformationCustomDTO)dataStoreEntry, null, null));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_PARTNER_SELECTION;
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_PARTNER_SELECTION;
								break;
		}
		
		return currentForwardName;
	}
}