/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CustomerListSelectionActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
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
public class CustomerListSelectionAction extends OPPTLongAction {
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
		
		CustomerListSelectionActionForm actionForm = (CustomerListSelectionActionForm)form;
		if(null != actionForm){
		
			
			String[] selectedListIds = actionForm.getSelectedCustomers();
			ErrorReport errorReport = null;
			if(null != selectedListIds){
				if(selectedListIds.length == 0){
					errorReport = getErrorReport(ErrorCodeConstants.PAF26);
				}
			}
			else{
				errorReport = getErrorReport(ErrorCodeConstants.PAF26);
			}
			if(null != errorReport){
				viewBean = session.getCurrentViewBean();
				viewBean.setErrorReport(errorReport);
				setForwardName(session.getCurrentForward());
			}
			else{
				FetchCustomerListCustomDTO customerLists = (FetchCustomerListCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_CREATION_CUSTOMER_LISTS);
		
				FetchCustomersCustomDTO customDTO = new FetchCustomersCustomDTO();
				setTransactionInformation(customDTO, session);
				
				

				ProposalHeaderCustomDTO proposalHeader = getProposalHeader(session);

				customDTO.setDivisionCode(proposalHeader.getBasicProposalCustomDTO().getDivision());
				customDTO.setDistributionChannel(proposalHeader.getBasicProposalCustomDTO().getDistributionChannel());
				customDTO.setSelectedSalesOrg(proposalHeader.getBasicProposalCustomDTO().getSalesOrganization());
				customDTO.setProposalDTO(proposalHeader.getProposal());

				if(null != customerLists){
					//customDTO.setSelectedCustomerLists(getSelectedCustomerLists(customerLists.getCustomerLists(), selectedListIds)); DADO02
					customDTO.setSelectedCustomers(getSelectedCustomers(customerLists.getSiteIDLists(), selectedListIds));
				}
				//DADO02
				FetchCustomersCustomDTO previousSiteIDCustomers = new FetchCustomersCustomDTO();
				 previousSiteIDCustomers = getPreviousSiteIDCustomers(session);
				 deletePreviousSiteIDCustomers(session);
				if(null!=previousSiteIDCustomers){
					TreeMap newCustomerList = customDTO.getSelectedCustomers();
					TreeMap oldCustomerList = previousSiteIDCustomers.getSelectedCustomers();
					
					Iterator customer = oldCustomerList.entrySet().iterator();
					while(customer.hasNext()){
						Map.Entry entry = (Map.Entry) customer.next();
						CustomerListCustomDTO customerListCustomDTO =  (CustomerListCustomDTO)entry.getValue(); 
						newCustomerList.put(customerListCustomDTO.getCustomerNumber(),customerListCustomDTO);
					}
					customDTO.setSelectedCustomers(newCustomerList);
				}
		
				try {
					
					// customDTO = getProposalManager().fetchCustomersFromCustomerLists(customDTO);
					 customDTO = getProposalManager().fetchCustomes(customDTO); //DADO02
					 
					ErrorReport messageReport = customDTO.getMessageReport();
					if(null == messageReport){
						addDataStoreEntry(session, customDTO);
						saveCustomers(session, customDTO);
						updateProposalHeaderComments(session, proposalHeader, actionForm.getComments());
						viewBean = new CustomerSelectionViewBean(customDTO, actionForm.getComments(), proposalHeader.isChangeProposal());
						setForwardName(getRole(session));
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
		return ActionNameConstants.CUSTOMER_LIST_SELECTION;
	}

	/**
	 * Stores customers for selected customer lists into session.  
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
	 * @param dto FetchCustomersCustomDTO
	 */
	public void saveCustomers(OPPTSession session, FetchCustomersCustomDTO dto) {
		if(null != session && null != dto){
			session.storeObjectToSession(SessionConstants.PROPOSAL_CREATION_CUSTOMERS, dto);
		}
	}
	
	/**
	 * Given the collection of customer lists and selected customer list ids, this method 
	 * returns the collection of customer lists.  
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
	 *//*	
	private TreeMap getSelectedCustomerLists(TreeMap customerLists, String[] selectedIds){
		TreeMap selectedCustomerLists = null;
		if(null != customerLists && null != selectedIds){
			selectedCustomerLists = new TreeMap();
			for(int i=0, size=selectedIds.length; i<size; i++){
				CustomerListCustomDTO listCustomDTO = (CustomerListCustomDTO)customerLists.get(selectedIds[i]);
				if(null != listCustomDTO){
					selectedCustomerLists.put(listCustomDTO.getListNumber(), listCustomDTO);				
				}
			}
		}
		return selectedCustomerLists;
	}*/
	//DADO02
	private TreeMap getSelectedCustomers(TreeMap customerLists, String[] selectedIds){
		TreeMap selectedCustomers = null;
		if(null != customerLists && null != selectedIds){
			selectedCustomers = new TreeMap();
			for(int i=0, size=selectedIds.length; i<size; i++){
				CustomerListCustomDTO listCustomDTO = (CustomerListCustomDTO)customerLists.get(selectedIds[i]);
				if(null != listCustomDTO){
					selectedCustomers.put(listCustomDTO.getCustomerNumber(), listCustomDTO);
					
				}
			}
		}
		return selectedCustomers;
	}

	private void updateProposalHeaderComments(OPPTSession session, ProposalHeaderCustomDTO proposalHeader, String comments){
		proposalHeader.getSecondaryProposalCustomDTO().setComments(comments);
		session.storeObjectToSession(SessionConstants.PROPOSAL_HEADER, proposalHeader);
	}
	
	private ProposalHeaderCustomDTO getProposalHeader(OPPTSession session){
		return (ProposalHeaderCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_HEADER);
	}

	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CUSTOMER_SELECTION);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_CUSTOMER_SELECTION);
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
			if(viewBean instanceof CustomerListSelectionViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.FETCH_CUSTOMER_LIST);
			if(null != dataStoreEntry && dataStoreEntry instanceof FetchCustomerListCustomDTO){
				session.setCurrentViewBean(new CustomerListSelectionViewBean((FetchCustomerListCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_CUSTOMER_LIST_SELECTION;
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_CUSTOMER_LIST_SELECTION;
								break;
		}
		
		return currentForwardName;
	}
	
	//DADO02
	/*private FetchCustomerListCustomDTO getStoredCustomers(OPPTSession session){
		return (FetchCustomerListCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_CREATION_CUSTOMER_LISTS);
	}*/
	private FetchCustomersCustomDTO getPreviousSiteIDCustomers(OPPTSession session){
		
		return (FetchCustomersCustomDTO)session.getObjectFromSession(SessionConstants.CUSTOMERS_FOR_PREVIOUS_SITEID);
		
	}
	private void deletePreviousSiteIDCustomers(OPPTSession session){
		session.removeObjectFromSession(SessionConstants.CUSTOMERS_FOR_PREVIOUS_SITEID);
	}
}