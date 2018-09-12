/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.GetPartnersActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerDetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerSelectionViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ESWCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchPartnerInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Action class that helps is getting partner information for selecting differnet partners. 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 10, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class GetPartnersAction extends OPPTLongAction {

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 10, 2003 
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

		
		FetchPartnerInformationCustomDTO customDTO = new FetchPartnerInformationCustomDTO();
		customDTO.setCustomer(getCustomer((GetPartnersActionForm)form));
		setTransactionInformation(customDTO, session);
		
		ProposalHeaderCustomDTO proposalHeader = getProposalHeader(session);

		if(null != proposalHeader){
			if(proposalHeader.isChangeProposal()){
				customDTO.setProposalDTO(proposalHeader.getProposal());
			}
			customDTO.setDivisionCode(proposalHeader.getBasicProposalCustomDTO().getDivision());
			customDTO.setDistributionChannel(proposalHeader.getBasicProposalCustomDTO().getDistributionChannel());
			customDTO.setSalesGroup(proposalHeader.getBasicProposalCustomDTO().getSalesGroup());
			customDTO.setChannelRole(proposalHeader.getBasicProposalCustomDTO().getChannelRole());
			customDTO.setSubmitterRole(proposalHeader.getBasicProposalCustomDTO().getSubmitterRole());
			customDTO.setSelectedSalesOrg(proposalHeader.getBasicProposalCustomDTO().getSalesOrganization());
			String igfOfferNumber = proposalHeader.getSecondaryProposalCustomDTO().getIgfOfferNumber();
			if(null != igfOfferNumber && 0 < igfOfferNumber.length()){
				customDTO.setIGFFlag(true);
			}
		}
		
		try {
			if(RoleConstants.BUSINESS_PARTNER == customDTO.getRole()){
				customDTO = getProposalManager().fetchPartnerInformationForBP(customDTO);
			}
			else{
				customDTO = getProposalManager().fetchPartnerInformationForCustomer(customDTO);
			}
			ErrorReport errorReport = customDTO.getMessageReport();
			if(null == errorReport){
				updateProposalHeader(session, proposalHeader, customDTO.getCustomer());
				savePartnerSelectionInformation(session, customDTO);
				addDataStoreEntry(session, customDTO);
				TreeMap customers = null;
				if(null != proposalHeader.getPartnerInformationCustomDTO()){
					//customerLists = proposalHeader.getPartnerInformationCustomDTO().getCustomerLists(); DADO02
					customers = convertListToMap(proposalHeader.getPartnerInformationCustomDTO().getSelectedCustomers()); //DADO02 Sateesh Anne BlueHarmony
				}
				viewBean = new PartnerSelectionViewBean(customDTO, customers, proposalHeader.getSecondaryProposalCustomDTO().getComments());
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
		
		return viewBean;
	}

	/** 
	 * Overridden method - Returns the action name 
	 * 
	 * <br/><PRE> 
	 * date Dec 10, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#getActionName() 
	 * @return String
	 * 
	 */
	protected String getActionName() {
		return ActionNameConstants.GET_PARTNERS;
	}

	/**
	 * Stores partner information into session  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session OPPTSession
	 * @param dto FetchPartnerInformationCustomDTO
	 */
	private void savePartnerSelectionInformation(OPPTSession session, FetchPartnerInformationCustomDTO dto) {
		if(null != session && null != dto){
			session.storeObjectToSession(SessionConstants.PROPOSAL_CREATION_PARTNERS, dto);
		}
	}

	private void updateProposalHeader(OPPTSession session, ProposalHeaderCustomDTO customDTO, ESWCustomerCustomDTO customer){
		if(null != session && null != customDTO){
			customDTO.addAlternatePartner(customer);
			session.storeObjectToSession(SessionConstants.PROPOSAL_HEADER, customDTO);
		}
	}
	
	private ESWCustomerCustomDTO getCustomer(GetPartnersActionForm actionForm){
		ESWCustomerCustomDTO customer = null;
		
		if(null != actionForm){
			customer = new ESWCustomerCustomDTO();
			customer.setCustomerNumber(actionForm.getLegacyNumber());
			customer.setLegacyCustomerNumber(actionForm.getLegacyNumber());
			customer.setAddressSequenceNumber(actionForm.getSequenceNumber());
			customer.setCountryCode(actionForm.getCountryCode());
		}
		
		return  customer;
	}

	private ProposalHeaderCustomDTO getProposalHeader(OPPTSession session){
		ProposalHeaderCustomDTO customDTO = (ProposalHeaderCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_HEADER);
		return customDTO;
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
			if(viewBean instanceof PartnerDetailsViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

//		if(!valid){
//			session.setCurrentMessageViewBean(new ErrorViewBean());
//			session.setCurrentForward(ForwardNameConstants.PAGE_ERROR);
//			valid = true;
//		}

		return valid;
	}

	private String getCurrentForwardName(int role){
		String currentForwardName = null;
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_PARTNER_DETAILS;
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_PARTNER_DETAILS;
								break;
		}
		
		return currentForwardName;
	}
	
	/*
	 * 
	 * @author Sateesh Anne
	 *
	 * TODO To change the template for this generated type comment go to
	 * Window - Preferences - Java - Code Style - Code Templates
	 */
	
	private TreeMap convertListToMap(List selectedCustomers){
		TreeMap customers = new TreeMap();
		if(null!=selectedCustomers){
			Iterator iterator = selectedCustomers.iterator();
			while(iterator.hasNext()){
				CustomerListCustomDTO customer = (CustomerListCustomDTO)iterator.next();
				customers.put(customer.getCustomerNumber(),customer);
			}
		}
		
		return customers;
		
	}
}
