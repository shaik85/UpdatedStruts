/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.StringTokenizer;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalDetailsActionForm;
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
 * Action that handles edit inventory request  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 21, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class EditInventoryAction extends OPPTLongAction 
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		ProposalDetailsActionForm actionForm = (ProposalDetailsActionForm)form;
		if(null != actionForm)
		{
			if(null == actionForm.getSelectedIds() && null == actionForm.getSelectedSandSIds()){
				viewBean = session.getCurrentViewBean();
				viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA51));
				setForwardName(session.getCurrentForward());
			}
			else if(null != actionForm.getSelectedIds() && null != actionForm.getSelectedSandSIds()){
				viewBean = session.getCurrentViewBean();
				viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA50));
				setForwardName(session.getCurrentForward());
			}
			else{
				try{
					boolean isSAnsS = false;
		
					if(null != actionForm.getSelectedSandSIds()){
						isSAnsS = true;
					}

					EditInventoryCustomDTO customDTO = getUserSelection(session, actionForm, isSAnsS);
					customDTO = getProposalManager().editInventory(customDTO);
					addDataStoreEntry(session, customDTO);
					setEditInventory(session, customDTO);
					viewBean = new EditInventoryViewBean(customDTO, isSAnsS);
					setForwardName(getRole(session));
				}
				catch(ServiceException se){
					viewBean = handleServiceException(session, se.getErrorReport());
				}
			}
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA17));
			setForwardName(session.getCurrentForward());
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
		return ActionNameConstants.EDIT_INVENTORY;
	}

	private EditInventoryCustomDTO getUserSelection(OPPTSession session, ProposalDetailsActionForm actionForm, boolean isSAndS){
		EditInventoryCustomDTO customDTO = new EditInventoryCustomDTO();
		setTransactionInformation(customDTO, session);
		customDTO.setProposal(getCurrentProposal(session));

		ProposalDetailsCustomDTO proposalDetails = (ProposalDetailsCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_DETAILS);
		if(null != proposalDetails)
		{
			String selectedIds[] = null;
			
			if(null != actionForm.getSelectedIds()){
				selectedIds = actionForm.getSelectedIds();
			}
			else if(null != actionForm.getSelectedSandSIds()){
				selectedIds = actionForm.getSelectedSandSIds();
			}

			for(int i=0, length=selectedIds.length; i<length; i++){
				int selectionType = -1;
				StringTokenizer st = new StringTokenizer(selectedIds[i], Constants.STRING_SEPERATOR);
				switch (st.countTokens()) {
					case 1: selectionType = Constants.CUSTOMER;
							break;
					case 2: selectionType = Constants.DM;
							break;
					case 3: selectionType = Constants.SWO;
							break;
				    default :
                        break;
                }
				
				if(Constants.CUSTOMER == selectionType){
					customDTO.addSelectedCustomer(selectedIds[i], getSelectedCustomer(proposalDetails, st.nextToken().trim(), isSAndS));
				}
				else if(Constants.DM == selectionType){
					String customerId = st.nextToken().trim();
					String dmId = st.nextToken().trim();
					if(!customDTO.isCustomerPresent(customerId)){
						customDTO.addSelectedDM(selectedIds[i], getSelectedDM(proposalDetails, customerId, dmId, isSAndS));
					}
				}
				else if(Constants.SWO == selectionType){
					String customerId = st.nextToken().trim();
					String dmId = st.nextToken().trim();
					String swoId = st.nextToken().trim();
					if(!customDTO.isDMPresent(customerId, dmId)){
						customDTO.addSelectedSWO(selectedIds[i], getSelectedSWO(proposalDetails, customerId, dmId, swoId, isSAndS));
					}
				}
								
			}
		}
		
		return customDTO;
	}
	
	private EditCustomerCustomDTO getSelectedCustomer(ProposalDetailsCustomDTO proposalDetails, String customerId, boolean isSAndS){
		EditCustomerCustomDTO customDTO = new EditCustomerCustomDTO();

		TreeMap customers = null;

		if(!isSAndS){
			customers = proposalDetails.getCustomers();
		}
		else{
			customers = proposalDetails.getSAndSCustomers();
		}
				
		if(null != customers){
			customDTO.setSelectedCustomer((ProposalCustomerCustomDTO)customers.get(customerId));
		}

		return customDTO;
	}

	private EditDMCustomDTO getSelectedDM(ProposalDetailsCustomDTO proposalDetails, String customerId, String dmId, boolean isSAndS){
		EditDMCustomDTO customDTO = new EditDMCustomDTO();

		DMCustomDTO selectedDM = null;
		ProposalCustomerCustomDTO customer = null;
		
		if(null != customerId && null != dmId)
		{
			TreeMap customers;
			if(!isSAndS){
				customers = proposalDetails.getCustomers();
			}
			else{
				customers = proposalDetails.getSAndSCustomers();
			}
				
			if(null != customers){
				customer = (ProposalCustomerCustomDTO)customers.get(customerId);
				if(null != customer){
					TreeMap dms = customer.getDMs();
					if(null != dms){
						selectedDM = (DMCustomDTO)dms.get(dmId);
					}
				}
			}
		}

		customDTO.setSelectedDM(selectedDM);
		customDTO.setCustomer(customer);

		return customDTO;
	}

	private EditSWOCustomDTO getSelectedSWO(ProposalDetailsCustomDTO proposalDetails, String customerId, String dmId, String swoId, boolean isSAndS){
		EditSWOCustomDTO customDTO = new EditSWOCustomDTO();

		SWOCustomDTO selectedSWO = null;
		DMCustomDTO dm = null;
		ProposalCustomerCustomDTO customer = null;
		if(null != customerId && null != dmId && null != swoId)
		{
			TreeMap customers = null;
			
			if(!isSAndS){
				customers = proposalDetails.getCustomers();
			}
			else{
				customers = proposalDetails.getSAndSCustomers();
			}

			if(null != customers){
				customer = (ProposalCustomerCustomDTO)customers.get(customerId);
				if(null != customer){
					TreeMap dms = customer.getDMs();
					if(null != dms){
						dm = (DMCustomDTO)dms.get(dmId);
						if(null != dm){
							TreeMap swos = dm.getSwos();
							if(null != swos){
								selectedSWO = (SWOCustomDTO)swos.get(swoId);
							}
						}
					}
				}
			}
		}

		customDTO.setSelectedSWO(selectedSWO);
		customDTO.setCustomerDTO(customer);
		customDTO.setDMDTO(dm);

		return customDTO;
	}

	private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
		ProposalCustomDTO currentProposal = null;
		if(null != session){
			currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);			
		}
		return currentProposal;
	}

	/**
     * setEditInventory
     * 
     * @param session
     * @param customDTO
     * @author thirumalai
     */
    public void setEditInventory(OPPTSession session, EditInventoryCustomDTO customDTO){
		if(null != session && null != customDTO){
			session.storeObjectToSession(SessionConstants.SESSION_EDIT_INVENTIORY, customDTO);
		}
	}

	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_EDIT_INVENTORY);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_EDIT_INVENTORY);
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
			if(viewBean instanceof ProposalDetailsViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.PROPOSAL_DETAILS);
			if(null != dataStoreEntry && dataStoreEntry instanceof ProposalDetailsCustomDTO){
				session.setCurrentViewBean(new ProposalDetailsViewBean((ProposalDetailsCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSAL_DETAILS;
								break;
			
			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_PROPOSAL_DETAILS;
								break;
		}
		
		return currentForwardName;
	}
}