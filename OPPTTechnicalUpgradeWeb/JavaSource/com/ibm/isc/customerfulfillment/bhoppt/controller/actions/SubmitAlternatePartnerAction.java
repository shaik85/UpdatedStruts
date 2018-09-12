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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.AlternatePartnerActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerSelectionViewBean;
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
public class SubmitAlternatePartnerAction extends OPPTLongAction {
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
		
		AlternatePartnerActionForm actionForm = (AlternatePartnerActionForm)form;
		FetchPartnerInformationCustomDTO partnerCustomDTO = getPartnerSelectionInformation(session);
		
		if(checkPartnerAlteadyExists(partnerCustomDTO, actionForm)){
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA16));
			setForwardName(session.getCurrentForward());
		}
		else{
			AlternatePartnerCustomDTO customDTO = new AlternatePartnerCustomDTO();
			setTransactionInformation(customDTO, session);
			/*customDTO.setLegacyCustomerNumber(actionForm.getLegacyNumber()); //DADO02 Sateesh Anne BHWave1
			customDTO.setSequenceNumber(actionForm.getSequenceNumber());*/
			customDTO.setSAPCustomerNumber(actionForm.getSapCustomerNumber()); //DADO02 Sateesh Anne BHWave1
			customDTO.setPartnerType(actionForm.getPartnerTypeValue());
			// customDTO.setCountryCode(actionForm.getCountryCode()); DADO02 Sateesh Anne BHWave1
			ProposalHeaderCustomDTO proposalHeaderCustomDTO = (ProposalHeaderCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_HEADER);
			customDTO.setDivision(proposalHeaderCustomDTO.getBasicProposalCustomDTO().getDivision());
			customDTO.setDistributionChannel(proposalHeaderCustomDTO.getBasicProposalCustomDTO().getDistributionChannel());
			customDTO.setSalesGroup(proposalHeaderCustomDTO.getBasicProposalCustomDTO().getSalesGroup());
			customDTO.setChannelRole(proposalHeaderCustomDTO.getBasicProposalCustomDTO().getChannelRole());
			customDTO.setSubmitterRole(proposalHeaderCustomDTO.getBasicProposalCustomDTO().getSubmitterRole());
			customDTO.setSelectedSalesOrg(proposalHeaderCustomDTO.getBasicProposalCustomDTO().getSalesOrganization());


			try {
				customDTO = getProposalManager().fetchAlternatePartner(customDTO);

				ErrorReport errorReport = customDTO.getMessageReport();
				if(null == errorReport)
				{
					addDataStoreEntry(session, customDTO);
					saveAlternatePartner(session, partnerCustomDTO, customDTO);
					viewBean = new PartnerSelectionViewBean(partnerCustomDTO, getProposalHeaderInformation(session).getCustomerLists(), proposalHeaderCustomDTO.getSecondaryProposalCustomDTO().getComments());
					setForwardName(getRole(session));
				}
				else{
					viewBean = new MessageViewBean(session.getCurrentForward());
					viewBean.setErrorReport(errorReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);
				}
			}
			catch(ServiceException se){
				viewBean = handleServiceException(session, se.getErrorReport(), session.getCurrentForward(), session.getCurrentForward());
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
		return ActionNameConstants.SUBMIT__ALTERNATE_PARTNER;
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
	
	private boolean checkPartnerAlteadyExists(FetchPartnerInformationCustomDTO customDTO, AlternatePartnerActionForm actionForm){
		boolean partnerExists = false;
		
		if(null != customDTO && null != actionForm){
			int partnerType = actionForm.getPartnerTypeValue();
			
			switch(partnerType){
				case Constants.SOLD_TO_PARTY: 
						TreeMap soldToParty = customDTO.getSoldToParty();
						if(null != soldToParty){
							
							/*DADO02 Sateesh Anne BHWave1
							 * Lagacy number is replaced with SAPCustomernumber in entire class
							 */
							 //if(null != soldToParty.get(actionForm.getLegacyNumber())){ 
							if(null != soldToParty.get(actionForm.getSapCustomerNumber())){
								partnerExists = true;
							}
						}
						break;

				case Constants.BILL_TO_PARTY: 
						TreeMap billToParty = customDTO.getSoldToParty();
						if(null != billToParty){
							
							//if(null != billToParty.get(actionForm.getLegacyNumber())){  DADO02 Sateesh Anne BHWave1
							if(null != billToParty.get(actionForm.getSapCustomerNumber())){
								partnerExists = true;
							}
						}
						break;

				case Constants.SHIP_TO_PARTY: 
						TreeMap shipToParty = customDTO.getSoldToParty();
						if(null != shipToParty){
						//if(null != shipToParty.get(actionForm.getLegacyNumber())){ DADO02 Sateesh Anne BHWave1
							if(null != shipToParty.get(actionForm.getSapCustomerNumber())){
								partnerExists = true;
							}
						}
						break;

				case Constants.PAYER: 
						TreeMap payer = customDTO.getSoldToParty();
						if(null != payer){
							//if(null != payer.get(actionForm.getLegacyNumber())){
							if(null != payer.get(actionForm.getSapCustomerNumber())){
								partnerExists = true;
							}
						}
						break;
			    default :
                    break;
            }				
		}
		
		return partnerExists;
	}
	
	private void saveAlternatePartner(OPPTSession session, FetchPartnerInformationCustomDTO partnerCustomDTO, AlternatePartnerCustomDTO customDTO){
		if(null != session && null != customDTO && null != partnerCustomDTO){
			ESWCustomerCustomDTO customer = customDTO.getPartnerInfo();
			if(null != customer){
				switch(customDTO.getPartnerType()){
					case Constants.SOLD_TO_PARTY:
							TreeMap soldToParty = partnerCustomDTO.getSoldToParty();
							soldToParty.put(customer.getSAPCustomerNumber(), customer);
							partnerCustomDTO.setSoldToParty(soldToParty);
							partnerCustomDTO.setSelectedSoldToParty(customer);
							break;
	
					case Constants.BILL_TO_PARTY:
							TreeMap billToParty = partnerCustomDTO.getBillToParty();
							billToParty.put(customer.getSAPCustomerNumber(), customer);
							partnerCustomDTO.setBillToParty(billToParty);
							partnerCustomDTO.setSelectedBillToParty(customer);
							break;
					
					case Constants.SHIP_TO_PARTY:
							TreeMap shipToParty = partnerCustomDTO.getShipToParty();
							shipToParty.put(customer.getSAPCustomerNumber(), customer);
							partnerCustomDTO.setShipToParty(shipToParty);
							partnerCustomDTO.setSelectedShipToParty(customer);
							break;
					
					case Constants.PAYER:
							TreeMap payer = partnerCustomDTO.getPayer();
							payer.put(customer.getSAPCustomerNumber(), customer);
							partnerCustomDTO.setPayer(payer);
							partnerCustomDTO.setSelectedPayer(customer);
							break;
				    default :
                        break;
                }
			}
			session.storeObjectToSession(SessionConstants.PROPOSAL_CREATION_PARTNERS, partnerCustomDTO);
		}
	}

	private void setForwardName(int role){
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