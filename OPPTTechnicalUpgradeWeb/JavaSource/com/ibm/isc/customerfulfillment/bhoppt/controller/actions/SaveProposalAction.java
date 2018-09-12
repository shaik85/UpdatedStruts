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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.PartnerSelectionActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 9, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class SaveProposalAction extends OPPTLongAction {
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
		
		ProposalHeaderCustomDTO proposalHeader = getProposalHeader(session);
		setTransactionInformation(proposalHeader, session);
		
		PartnerSelectionActionForm actionForm = (PartnerSelectionActionForm) form;
		ErrorReport errorReport = checkValidity(session, actionForm); 
		if(0 < errorReport.size()){
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(errorReport);
			setForwardName(session.getCurrentForward());
		}
		else {
			errorReport = validatePartners(actionForm, session);
			if(null == errorReport || 0 == errorReport.size()){
				PartnerInformationCustomDTO partnerInformation = getSelectedPartners(actionForm, session);
				proposalHeader.getSecondaryProposalCustomDTO().setComments(actionForm.getComments());
				if(null == proposalHeader.getCustomerLists()){
				     if(null != proposalHeader.getPartnerInformationCustomDTO()){
												
						partnerInformation.setCustomerLists(proposalHeader.getPartnerInformationCustomDTO().getCustomerLists());
					}
				}
				else{
					partnerInformation.setCustomerLists(proposalHeader.getCustomerLists());
				}
				proposalHeader.setPartnerInformationCustomDTO(partnerInformation);

				try {
					proposalHeader.setMessageReport(null);
					proposalHeader = getProposalManager().saveProposal(proposalHeader);
					errorReport = proposalHeader.getMessageReport();
					if(null == errorReport){
						addDataStoreEntry(session, proposalHeader);
						setCurrentProposal(session, proposalHeader);
						if(proposalHeader.isProposalDetails()){
							if(proposalHeader.isFetchInventory()){
								setForwardName(ForwardNameConstants.ACTION_FETCH_INVENTORY);
							}
							else{
								setForwardName(ForwardNameConstants.ACTION_PROPOSAL_DETAILS);
							}
						}
						else{
							// partnerInformation.setCustomerLists(proposalHeader.getCustomerLists());
							partnerInformation.setSelectedCustomers(proposalHeader.getSelectedCustomers());//DADO02
							partnerInformation.setComments(proposalHeader.getSecondaryProposalCustomDTO().getComments());
							viewBean = new PartnerInformationViewBean(partnerInformation);
							setForwardName(getRole(session));
						}
					}
					else{
						viewBean = new MessageViewBean();
						viewBean.setErrorReport(errorReport);
						setForwardName(ForwardNameConstants.PAGE_MESSAGE);
					}
					removeProposalHeaderInformation(session);
				}
				catch(ServiceException se){
					viewBean = handleServiceException(session, se.getErrorReport(), session.getCurrentForward(), session.getCurrentForward());
				}
			}
			else{
				viewBean = handleServiceException(session, errorReport, session.getCurrentForward(), session.getCurrentForward());
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
		return ActionNameConstants.SAVE_PROPOSAL;
	}

	/** 
	 * Overridden method - Returns false if back button is not allowed. 
	 * 
	 * <br/><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#isBackButtonAllowed() 
	 * @return boolean
	 * 
	 */
	protected boolean isBackButtonAllowed() {
		return false;
	}

	/**
	 * This method checks whether the selected values for the partner are valid or not. If valid the 
	 * ErrorReport object will be empty else it will be filled with error entries.  
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
	 * @param actionForm PartnerSelectionActionForm
	 * @return ErrorReport
	 */
	private ErrorReport checkValidity(OPPTSession session, PartnerSelectionActionForm actionForm) 
	{
		ErrorReport errorReport = new ErrorReport();

		if (null != actionForm.getNineDPartnerNumber() && 0 < actionForm.getNineDPartnerNumber().length()) {
			FetchPartnerInformationCustomDTO partnerSelectionCustomDTO = getPartnerSelectionInformation(session);
			if(null == partnerSelectionCustomDTO || null == partnerSelectionCustomDTO.getSelectedNineDPartner()){
				errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA38, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		} 
		else 
		{
			// Testing sold to party values
			String soldToPartyNumber = actionForm.getSoldToPartyNumber();
			if (null != soldToPartyNumber && 0 < soldToPartyNumber.length() 
				&& !("Other".equalsIgnoreCase(soldToPartyNumber)) && !("Select one".equalsIgnoreCase(soldToPartyNumber)))  //$NON-NLS-1$  //$NON-NLS-2$ 
			{
				String soldToPartyName = actionForm.getSoldToPartyName();
				if (null != soldToPartyName && 0 < soldToPartyName.length()
					&& !("Other".equalsIgnoreCase(soldToPartyName)) && !("Select one".equalsIgnoreCase(soldToPartyName)))  //$NON-NLS-1$  //$NON-NLS-2$ 
				{
					if (!soldToPartyName.equals(soldToPartyNumber)) 
					{
						errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA06, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
				}
				else 
				{
					errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA05, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}
			else{
				errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA04, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}

			// Testing bill to party
			if(actionForm.isIgfNumber()){
				String billToPartyNumber = actionForm.getBillToPartyNumber();
				if (null == billToPartyNumber || 0 == billToPartyNumber.length()){
					errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA07, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}
			else{
				String billToPartyNumber = actionForm.getBillToPartyNumber();
				if (null != billToPartyNumber && 0 < billToPartyNumber.length()
					&& !("Other".equalsIgnoreCase(billToPartyNumber)) && !("Select one".equalsIgnoreCase(billToPartyNumber)))  //$NON-NLS-1$  //$NON-NLS-2$ 
				{
					String billToPartyName = actionForm.getBillToPartyName();
					if (null != billToPartyName && 0 < billToPartyName.length()
						&& !("Other".equalsIgnoreCase(billToPartyName)) && !("Select one".equalsIgnoreCase(billToPartyName)))  //$NON-NLS-1$  //$NON-NLS-2$ 
					{
						if (!billToPartyName.equals(billToPartyNumber)) {
							errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA09, OPPTMessageCatalog.TYPE_PRESENTATION), null);
						}
					}
					else 
					{
						errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA08, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
				}
				else 
				{
					errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA07, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}

			// Testing payer
			if(actionForm.isIgfNumber()){
				String payerNumber = actionForm.getPayerNumber();
				if (null == payerNumber || 0 == payerNumber.length()){
					errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA10, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}
			else{
				String payerNumber = actionForm.getPayerNumber();
				if (null != payerNumber && 0 < payerNumber.length()
					&& !("Other".equalsIgnoreCase(payerNumber)) && !("Select one".equalsIgnoreCase(payerNumber)))  //$NON-NLS-1$  //$NON-NLS-2$ 
				{
					String payerName = actionForm.getPayerName();
					if (null != payerName && 0 < payerName.length()
						&& !("Other".equalsIgnoreCase(payerName)) && !("Select one".equalsIgnoreCase(payerName)))  //$NON-NLS-1$  //$NON-NLS-2$ 
					{
						if (!payerName.equals(payerNumber)) {
							errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA12, OPPTMessageCatalog.TYPE_PRESENTATION), null);
						}
					}
					else 
					{
						errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA11, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
				}
				else 
				{
					errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA10, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}

			// Testing ship to party 
			String shipToPartyNumber = actionForm.getShipToPartyNumber();
			if (null != shipToPartyNumber && 0 < shipToPartyNumber.length()
				&& !("Other".equalsIgnoreCase(shipToPartyNumber)) && !("Select one".equalsIgnoreCase(shipToPartyNumber)))  //$NON-NLS-1$  //$NON-NLS-2$ 
			{
				String shipToPartyName = actionForm.getShipToPartyName();
				if (null != shipToPartyName && 0 < shipToPartyName.length()
					&& !("Other".equalsIgnoreCase(shipToPartyName)) && !("Select one".equalsIgnoreCase(shipToPartyName)))  //$NON-NLS-1$  //$NON-NLS-2$ 
				{
					if (!shipToPartyName.equals(shipToPartyNumber)) {
						errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA15, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
				}
				else 
				{
					errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA14, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}
			else 
			{
				errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA13, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		
		return errorReport;
	}
	
	private ErrorReport validatePartners(PartnerSelectionActionForm actionForm, OPPTSession session) throws Exception{
		ErrorReport errorReport = null;
		
		if(actionForm.isIgfNumber()){
			ProposalHeaderCustomDTO proposalHeader = (ProposalHeaderCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_HEADER);
			FetchPartnerInformationCustomDTO partners = (FetchPartnerInformationCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_CREATION_PARTNERS);

			ESWCustomerCustomDTO payer = partners.getSelectedPayer();
			//if(null != payer && payer.getLegacyCustomerNumber().equals(actionForm.getPayerNumber())){ //commented above line and added for defect BHALM00083160
				if(null != payer && payer.getSAPCustomerNumber().equals(actionForm.getPayerNumber())){
				ESWCustomerCustomDTO billToParty = partners.getSelectedBillToParty();
				//if(null != billToParty && !billToParty.getLegacyCustomerNumber().equals(actionForm.getBillToPartyNumber())){ //commented above line and added for defect BHALM00083160
					if(null != billToParty && !billToParty.getSAPCustomerNumber().equals(actionForm.getBillToPartyNumber())){
					errorReport = getErrorReport(ErrorCodeConstants.PA37);
				}
			}
			else{
				errorReport = getErrorReport(ErrorCodeConstants.PA37);
			}
		}
		
		return errorReport;
	}
	
	/**
	 * Tis method returns the selected partners for the proposal.  
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
	 * @param actionForm PartnerSelectionActionForm
	 * @param session OPPTSession
	 * @return PartnerInformationCustomDTO
	 */
	private PartnerInformationCustomDTO getSelectedPartners(PartnerSelectionActionForm actionForm, OPPTSession session){
		PartnerInformationCustomDTO customDTO = null;
		
		if(null != actionForm && null != session){
			customDTO = new PartnerInformationCustomDTO();
			FetchPartnerInformationCustomDTO partners = (FetchPartnerInformationCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_CREATION_PARTNERS);
			customDTO.setSlectedCustomerName(partners.getCustomerName());
			// Anand DAD001
			if(null != partners){
				String nineDPartnerNumber = actionForm.getNineDPartnerNumber();
				if(null != nineDPartnerNumber && 0 < nineDPartnerNumber.length()){
					customDTO.setNineDPartner(partners.getSelectedNineDPartner());
				}

				String soldToParty = actionForm.getSoldToPartyNumber();
				TreeMap soldToPartys = partners.getSoldToParty();
				if(null != soldToPartys && null != soldToParty){
					customDTO.setSoldToParty((ESWCustomerCustomDTO)soldToPartys.get(soldToParty));
				}

				if(partners.isIGFFlag()){
					customDTO.setBillToParty(partners.getSelectedBillToParty());
				}
				else{
					String billToParty = actionForm.getBillToPartyNumber();
					TreeMap billToPartys = partners.getBillToParty();
					if(null != billToPartys && null != billToParty){
						customDTO.setBillToParty((ESWCustomerCustomDTO)billToPartys.get(billToParty));
					}
				}

				if(partners.isIGFFlag()){
					customDTO.setPayer(partners.getSelectedPayer());
				}
				else{
					String payer = actionForm.getPayerNumber();
					TreeMap payers = partners.getPayer();
					if(null != payers && null != payer){
						customDTO.setPayer((ESWCustomerCustomDTO)payers.get(payer));
					}
				}

				String shipToParty = actionForm.getShipToPartyNumber();
				TreeMap shipToPartys = partners.getShipToParty();
				if(null != shipToPartys && null != shipToParty){
					customDTO.setShipToParty((ESWCustomerCustomDTO)shipToPartys.get(shipToParty));
				}
			}
		}
		return customDTO;
	}
	
	/**
	 * Creates a ProposalCustomDTO out of ProposalHeaderCustomDTO and stores as part of session  
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
	 * @param proposalHeader ProposalHeaderCustomDTO
	 */
	private void setCurrentProposal(OPPTSession session, ProposalHeaderCustomDTO proposalHeader){
		if(null != session && null != proposalHeader){
			ProposalCustomDTO currentProposal = proposalHeader.getProposal();
			currentProposal.setName(proposalHeader.getBasicProposalCustomDTO().getProposalName());
			currentProposal.setType(proposalHeader.getBasicProposalCustomDTO().getProposalType());
			
			session.storeObjectToSession(SessionConstants.CURRENT_PROPOSAL, currentProposal);
		}
	}

	private void removeProposalHeaderInformation(OPPTSession session) {
		session.removeObjectFromSession(SessionConstants.PROPOSAL_HEADER);
	}
	private FetchPartnerInformationCustomDTO getPartnerSelectionInformation(OPPTSession session) {
		FetchPartnerInformationCustomDTO customDTO = null;
		if(null != session){
			customDTO = (FetchPartnerInformationCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_CREATION_PARTNERS);
		}
		return customDTO;
	}

	/**
	 * Returns the proposal header information that is stored as part of session  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session OPPTSession
	 * @return ProposalHeaderCustomDTO
	 */
	private ProposalHeaderCustomDTO getProposalHeader(OPPTSession session){
		return (ProposalHeaderCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_HEADER);
	}

	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_PARTNER_INFORMATION);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_PARTNER_INFORMATION);
								break;
		}
	}
	
	
	
    /**
     * validateCurrentViewContent
     * 
     * @param session
     * @return boolean
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