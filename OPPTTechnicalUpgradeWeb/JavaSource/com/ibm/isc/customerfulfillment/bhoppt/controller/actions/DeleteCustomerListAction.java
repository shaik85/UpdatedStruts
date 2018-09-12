/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CustomerListSelectionActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerListSelectionViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 4, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */
public class DeleteCustomerListAction extends OPPTLongAction {

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Feb 4, 2004 
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
		
		CustomerListSelectionActionForm actionForm = (CustomerListSelectionActionForm)form;
		if(null != actionForm){
			String[] selectedListIds = actionForm.getDeleteCustomerList();
			
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
		
				DeleteCustomerListCustomDTO customDTO = new DeleteCustomerListCustomDTO();
				setTransactionInformation(customDTO, session);
				customDTO.setProposal(getCurrentProposal(session));
				TreeMap selectedCustomerLists = getSelectedCustomerLists(customerLists.getCustomerLists(), selectedListIds);
				if(null != selectedCustomerLists){
					customDTO.setSelectedCustomerList(selectedCustomerLists);
					try {
						getProposalManager().deleteCustomerList(customDTO);
						ErrorReport messageReport = customDTO.getMessageReport();
						if(null == messageReport){
							addDataStoreEntry(session, customDTO);
							customerLists = removeCustomerLists(session, customerLists, selectedListIds);
							viewBean = new CustomerListSelectionViewBean(customerLists, true);
							setForwardName(session.getCurrentForward());
						}
						else{
							viewBean = new MessageViewBean();
							viewBean.setErrorReport(messageReport);
							setForwardName(ForwardNameConstants.PAGE_MESSAGE);
						}
					}
					catch(ServiceException se){
						viewBean = handleServiceException(session, se.getErrorReport());
					}
				}
				else{
					viewBean = session.getCurrentViewBean();
					viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PAF26));
					setForwardName(session.getCurrentForward());
				}
			}
		}
		return viewBean;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Feb 4, 2004 
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
		return ActionNameConstants.DELETE_CUSTOMER_LIST;
	}

	private ProposalCustomDTO getCurrentProposal(OPPTSession session) 
	{
		ProposalCustomDTO currentProposal = null;
		if(null != session){
			currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);
		}
		return currentProposal;
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
	 */	
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
	}
	
	private FetchCustomerListCustomDTO removeCustomerLists(OPPTSession session, FetchCustomerListCustomDTO customDTO, String[] selectedIds){
		if(null != session && null != customDTO && null != selectedIds){
			TreeMap customerLists = customDTO.getCustomerLists();
			if(null != customerLists){
				for(int i=0, size=selectedIds.length; i<size; i++){
					customerLists.remove(selectedIds[i]);			
				}
			}
			customDTO.setCustomerLists(customerLists);
			session.storeObjectToSession(SessionConstants.PROPOSAL_CREATION_CUSTOMER_LISTS, customDTO);
		}
		return customDTO;
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
}