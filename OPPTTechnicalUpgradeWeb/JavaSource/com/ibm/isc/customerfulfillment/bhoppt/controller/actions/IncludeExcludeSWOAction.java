/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.*;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalDetailsActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalDetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Action class that handles include or exclude swos from the proposal.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 19, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class IncludeExcludeSWOAction extends OPPTLongAction 
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
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		ProposalDetailsActionForm actionForm = (ProposalDetailsActionForm)form;
		if(null != actionForm)
		{
			IncludeExcludeSWOCustomDTO customDTO = getSelectedSWOs(session, actionForm.getSelectedIds());
			if(null != customDTO)
			{
				setTransactionInformation(customDTO, session);
				customDTO.setProposalDTO(getCurrentProposal(session));
				customDTO.setTransactionName(ActionNameConstants.INCLUDE_EXCLUDE_SWO);

				try{
					getProposalManager().excludeIncludeSWO(customDTO);
					setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS);
				}
				catch(ServiceException se)
				{
					viewBean= handleServiceException(session, se.getErrorReport());
				}
			}
			else{
				viewBean = session.getCurrentViewBean();
				viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA17));
				setForwardName(session.getCurrentForward());
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
		return ActionNameConstants.INCLUDE_EXCLUDE_SWO;
	}

	private IncludeExcludeSWOCustomDTO getSelectedSWOs(OPPTSession session, String selectedIds[]) 
	{
		IncludeExcludeSWOCustomDTO customDTO = null;
		
		if(null != session && null != selectedIds){
			int size = selectedIds.length;
			if(0 < size){
				ProposalDetailsCustomDTO proposalDetails = (ProposalDetailsCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_DETAILS);
				if(null != proposalDetails)
				{
					ArrayList customers = new ArrayList();
					ArrayList dms = new ArrayList();
					ArrayList swos = new ArrayList();
					
					for(int i=0; i<size; i++){
						StringTokenizer st = new StringTokenizer(selectedIds[i], Constants.STRING_SEPERATOR);
						if(3 == st.countTokens()){
							SWOCustomDTO swoCustomDTO = getSWO(proposalDetails, st.nextToken().trim(), st.nextToken().trim(), st.nextToken().trim());
							if(null != swoCustomDTO){
								swos.add(swoCustomDTO);
							}
						}
						else if(2 == st.countTokens()){
							DMCustomDTO dmCustomDTO = getDM(proposalDetails, st.nextToken().trim(), st.nextToken().trim());
							if(null != dmCustomDTO){
								dms.add(dmCustomDTO);
							}
						}
						else if(1 == st.countTokens()){
							ProposalCustomerCustomDTO customerCustomDTO = getCustomer(proposalDetails, st.nextToken().trim());
							if(null != customerCustomDTO){
								customers.add(customerCustomDTO);
							}
						}
					}

					int arraySize = customers.size();
					if(0 < arraySize){
						ProposalCustomerCustomDTO customerArray[] = new ProposalCustomerCustomDTO[arraySize];
						customerArray = (ProposalCustomerCustomDTO[])customers.toArray(customerArray);
						if(null == customDTO){
							customDTO = new IncludeExcludeSWOCustomDTO();
						}
						customDTO.setSelectedCustomers(customerArray);
					}
					
					arraySize = dms.size();					
					if(0 < arraySize){
						DMCustomDTO dmArray[] = new DMCustomDTO[arraySize];
						dmArray = (DMCustomDTO[])dms.toArray(dmArray);
						if(null == customDTO){
							customDTO = new IncludeExcludeSWOCustomDTO();
						}
						customDTO.setSelectedDMs(dmArray);
					}
					
					arraySize = swos.size();					
					if(0 < arraySize){
						SWOCustomDTO swoArray[] = new SWOCustomDTO[arraySize];
						swoArray = (SWOCustomDTO[])swos.toArray(swoArray);
						if(null == customDTO){
							customDTO = new IncludeExcludeSWOCustomDTO();
						}
						customDTO.setSelectedSWOs(swoArray);
					}
					
					customers = null;
					dms = null;
					swos = null;
				}
			}
		}
		return customDTO;
	}
	
	private SWOCustomDTO getSWO(ProposalDetailsCustomDTO proposalDetails, String customerId, String dmId, String swoId) 
	{
		SWOCustomDTO customDTO = null;
		if(null != customerId && null != dmId && null != swoId)
		{
			TreeMap customers = proposalDetails.getCustomers();
			if(null != customers){
				ProposalCustomerCustomDTO customer = (ProposalCustomerCustomDTO)customers.get(customerId);
				if(null != customer){
					TreeMap dms = customer.getDMs();
					if(null != dms){
						DMCustomDTO dm = (DMCustomDTO)dms.get(dmId);
						if(null != dm){
							TreeMap swos = dm.getSwos();
							if(null != swos){
								customDTO = (SWOCustomDTO)swos.get(swoId);
							}
						}
					}
				}
			}
		}
		return customDTO;
	}

	private DMCustomDTO getDM(ProposalDetailsCustomDTO proposalDetails, String customerId, String dmId) 
	{
		DMCustomDTO customDTO = null;
		if(null != customerId && null != dmId)
		{
			TreeMap customers = proposalDetails.getCustomers();
			if(null != customers){
				ProposalCustomerCustomDTO customer = (ProposalCustomerCustomDTO)customers.get(customerId);
				if(null != customer){
					TreeMap dms = customer.getDMs();
					if(null != dms){
						customDTO = (DMCustomDTO)dms.get(dmId);
					}
				}
			}
		}
		return customDTO;
	}

	private ProposalCustomerCustomDTO getCustomer(ProposalDetailsCustomDTO proposalDetails, String customerId) 
	{
		ProposalCustomerCustomDTO customDTO = null;
		if(null != customerId)
		{
			TreeMap customers = proposalDetails.getCustomers();
			if(null != customers){
				customDTO = (ProposalCustomerCustomDTO)customers.get(customerId);
			}
		}
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
