/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CustomerSelectionActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerSelectionViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerSelectionViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ESWCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomersCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchPartnerInformationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Action class that is responsible for getting partner selection details for the 
 * selected sold to party and storing the selected customers for fetching inventory 
 * into session.  
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
public class CustomerSelectionAction extends OPPTLongAction {
	/** 
	 * Overridden method - Has logic for storing the selected customers for fetching 
	 * inventory into session and gets the partner selection data for the selected 
	 * sold to party. 
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
		FetchPartnerInformationCustomDTO customDTO = new FetchPartnerInformationCustomDTO();
		setTransactionInformation(customDTO, session);
		
		ProposalHeaderCustomDTO proposalHeader = getProposalHeader(session);

		if(null != proposalHeader){
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
		
			CustomerSelectionActionForm actionForm = (CustomerSelectionActionForm)form;
			FetchCustomersCustomDTO customers = (FetchCustomersCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_CREATION_CUSTOMERS);
			String selectedIds[] = actionForm.getSelectedINV();
			//DADO02
			String selectedSTP1 = actionForm.getSelectedSTP();
								
			if(null != customers){
				proposalHeader.setCustomerLists(getSelectedCustomers(session, customers.getSelectedCustomers(), selectedIds));
			   
			}

			String selectedSTP = actionForm.getSelectedSTP();
			
			boolean alternatePartner = false;
			
			if(null != selectedSTP){
				/*  DADO02&DAO09 if(Constants.CUSTOMER_SELECTION_ALTERNATE_CUSTOMER.equalsIgnoreCase(selectedSTP)){
					customDTO.setCustomer(getCustomer(actionForm.getLegacyCustomerNumber(), actionForm.getSequenceNumber(), actionForm.getCountryCode()));
					alternatePartner = true;
				}
				else{*/ 
					//DADO02&DAO09 getSelectedSTP(customers.getSelectedCustomerLists(), customers.getAlternatePartners(), selectedSTP, customDTO);
					getSelectedSTP(customers.getSelectedCustomers(),selectedSTP, customDTO);
				//}
			}
		
			try {
				customDTO = getProposalManager().fetchPartnerInformationForCustomer(customDTO);
				ErrorReport errorReport = customDTO.getMessageReport();
				if(null == errorReport){
					addDataStoreEntry(session, customDTO);
					savePartnerSelectionInformation(session, customDTO);
					if(alternatePartner){
						updateProposalHeader(session, proposalHeader, customDTO.getSelectedSoldToParty(), actionForm.getComments());
					}
					else{
						updateProposalHeader(session, proposalHeader, null, actionForm.getComments());
					}
					if(customDTO.isIGFFlag() && !proposalHeader.isChangeProposal()){
						customDTO.setSelectedBillToParty(null);
						customDTO.setSelectedPayer(null);
					}
					//DADO02&DADO09 viewBean = new PartnerSelectionViewBean(customDTO, customers.getSelectedCustomerLists(), actionForm.getComments());
					
					//this selected customers we are using for display purpose in next page
					if(null!=customers){
						customers.setSelectedCustomers(getTotalCustomers(session,customers.getSelectedCustomers(),selectedIds));
					}
					
					
					viewBean = new PartnerSelectionViewBean(customDTO, customers.getSelectedCustomers(), actionForm.getComments());
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
		else{
			viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA00), session.getCurrentForward());
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
		return ActionNameConstants.CUSTOMER_SELECTION;
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
			session.storeObjectToSession(com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants.PROPOSAL_CREATION_PARTNERS, dto);
		}
	}
	
	private void updateProposalHeader(OPPTSession session, ProposalHeaderCustomDTO proposalHeader, ESWCustomerCustomDTO alternatePartner, String comments){
		proposalHeader.addAlternatePartner(alternatePartner);
		proposalHeader.getSecondaryProposalCustomDTO().setComments(comments);
		session.storeObjectToSession(SessionConstants.PROPOSAL_HEADER, proposalHeader);
	}

	private ProposalHeaderCustomDTO getProposalHeader(OPPTSession session){
		return (ProposalHeaderCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_HEADER);
	}

	/**
	 * Saves selected customer for fetching inventory into proposal into session.  
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
	 * @param selectedCustomers TreeMap
	 */
	private void saveInventoryCustomers(OPPTSession session, TreeMap selectedCustomers){
		if(null != session && null != selectedCustomers){
			ProposalHeaderCustomDTO customDTO = (ProposalHeaderCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_HEADER);
			customDTO.setCustomerLists(selectedCustomers);
			session.storeObjectToSession(SessionConstants.PROPOSAL_HEADER, customDTO);
		}
	}
	
	/**
	 * Returns the collection of selected customers along with customer lists  
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
	 * @param customerLists TreeMap
	 * @param selectedIds String[]
	 * @return TreeMap
	 */
	//DADO02 &DADO09
	private TreeMap getSelectedCustomers(OPPTSession session, TreeMap customers, String selectedIds[]){
		//if(null != customerLists && null != selectedIds){  
			List newCustomers = new ArrayList();
			TreeMap selectedCustomers = new TreeMap();
			for(int i=0, size=selectedIds.length; i<size; i++){
			/*	StringTokenizer st = new StringTokenizer(selectedIds[i],Constants.STRING_SEPERATOR);
				if(null != st && 2 == st.countTokens()){
					String customerListId = st.nextToken();
					String customerId = st.nextToken();
					CustomerListCustomDTO customerList = (CustomerListCustomDTO)customerLists.get(customerListId);
					if(null != customerList){
			*/			
						if(null != customers){
							CustomerListCustomDTO customer = (CustomerListCustomDTO)customers.get(selectedIds[i]);
							if(null != customer){
								
								customer.setInventorySelected(true);
								
								if(!customer.isAlreadyExists()){
									selectedCustomers.put(customer.getCustomerNumber(),customer); //to store in proposal
									newCustomers.add(customer);
								}
							}
						}
					}
				//}
			//}
			if(0 < newCustomers.size()){
				session.storeObjectToSession(SessionConstants.NEW_CUSTOMERS_FOR_INVENTORY, newCustomers);
			}
		//}
		return selectedCustomers;	
	}
	//DADO02&DADO09
	private void getSelectedSTP(TreeMap customers,String selectedSTP, FetchPartnerInformationCustomDTO customDTO)
	{
		CustomerListCustomDTO customer = (CustomerListCustomDTO)customers.get(selectedSTP);
				if(null != customer){
					
				/*customDTO.setSlectedCustomerName(customer.getCustomerName());
				customDTO.setSelectedCustomerNumber(customer.getCustomerNumber());*/
				customDTO.setCustomer(getCustomer(customer.getCustomerNumber()));
				customDTO.setCustomerName(customer.getCustomerName());	// Anand DAD001	
					
				
			}
		}
	
	
//DADO02
	/*private void getSelectedSTP(TreeMap customerLists, TreeMap alternateCustomers, String selectedSTP, FetchPartnerInformationCustomDTO customDTO)
	{
		StringTokenizer st = new StringTokenizer(selectedSTP,Constants.STRING_SEPERATOR);
		if(null != st && 2 == st.countTokens()){
			String customerListId = st.nextToken().trim();
			String customerId = st.nextToken().trim();
			
			if("alternate".equals(customerListId)){  //$NON-NLS-1$
				CustomerListCustomerCustomDTO customer = (CustomerListCustomerCustomDTO)alternateCustomers.get(customerId);
				if(null != customer){
					customDTO.setCustomer(getCustomer(customer.getLegacyCustomerNumber(), customer.getAddressSequenceNumber(), customer.getCountryCode()));
				}
			}
			else{
				CustomerListCustomDTO customerList = (CustomerListCustomDTO)customerLists.get(customerListId);
				if(null != customerList){
					TreeMap customers = customerList.getCustomers();
					if(null != customers){
						CustomerListCustomerCustomDTO customer = (CustomerListCustomerCustomDTO)customers.get(customerId);
						if(null != customer){
							customDTO.setCustomer(getCustomer(customer.getLegacyCustomerNumber(), customer.getAddressSequenceNumber(), customer.getCountryCode()));
						}
					}
				}
			}
		}
	}
	*/
	private ESWCustomerCustomDTO getCustomer(String customerNumber){
		ESWCustomerCustomDTO customer = null;
		
		if(null != customerNumber){
			customer = new ESWCustomerCustomDTO();
			customer.setCustomerNumber(customerNumber);
		}
		
		return  customer;
	}
	/*private ESWCustomerCustomDTO getCustomer(String customerNumber, String sequenceNumber, String countryCode){
		ESWCustomerCustomDTO customer = null;
		
		if(null != customerNumber || null != sequenceNumber){
			customer = new ESWCustomerCustomDTO();
			customer.setLegacyCustomerNumber(customerNumber);
			customer.setAddressSequenceNumber(sequenceNumber);
			customer.setCountryCode(countryCode);
		}
		
		return  customer;
	}*/
	
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
			if(viewBean instanceof CustomerSelectionViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.CUSTOMER_LIST_SELECTION);
			if(null != dataStoreEntry && dataStoreEntry instanceof FetchCustomersCustomDTO){
				session.setCurrentViewBean(new CustomerSelectionViewBean((FetchCustomersCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_CUSTOMER_SELECTION;
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_CUSTOMER_SELECTION;
								break;
		}
		
		return currentForwardName;
	}
	/*
	 * 
	 * @author Sateesh Anne Blue harmony DADO02
	 *
	 * TODO To display the old and new customers in partnerselection page
	 * Window - Preferences - Java - Code Style - Code Templates
	 */
	private TreeMap getTotalCustomers(OPPTSession session, TreeMap customers, String selectedIds[]){
		
			List newCustomers = new ArrayList();
			TreeMap selectedCustomers = new TreeMap();
			for(int i=0, size=selectedIds.length; i<size; i++){
					if(null != customers){
							CustomerListCustomDTO customer = (CustomerListCustomDTO)customers.get(selectedIds[i]);
							if(null != customer){
								
								customer.setInventorySelected(true);
														
									selectedCustomers.put(customer.getCustomerNumber(),customer); //to store in proposal
								
							}
						}
					}
		
		return selectedCustomers;	
	}
	
	
}
