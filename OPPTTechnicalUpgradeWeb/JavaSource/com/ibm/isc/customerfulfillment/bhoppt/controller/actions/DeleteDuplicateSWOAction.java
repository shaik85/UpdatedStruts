/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalDetailsActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalDetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeleteDuplicateSWOCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.DeleteInventoryCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SWOCustomDTO;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 2, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1x
 */
public class DeleteDuplicateSWOAction extends OPPTAction {


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
		String selectedIds []=null;
		String sandsSelectedIds[] = null;
		ProposalDetailsActionForm actionForm = (ProposalDetailsActionForm)form;
		if(null != actionForm)
		{
			selectedIds = actionForm.getSelectedIds();
			sandsSelectedIds = actionForm.getSelectedSandSIds();
		
			List markedForDeletionList = getSelectedDeleteOptions(session, selectedIds, sandsSelectedIds);
			if(null != markedForDeletionList && markedForDeletionList.size() > 0)
			{
				setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS);
				
				if(null != session.getObjectFromSession(SessionConstants.MARKED_FOR_DELETION)) {
					DeleteDuplicateSWOCustomDTO deleteDuplicateSWOCustomDTO = (DeleteDuplicateSWOCustomDTO)session.getObjectFromSession(SessionConstants.MARKED_FOR_DELETION);
					deleteDuplicateSWOCustomDTO.addSwos(markedForDeletionList);
					session.storeObjectToSession(SessionConstants.MARKED_FOR_DELETION,deleteDuplicateSWOCustomDTO);
				}else {
					DeleteDuplicateSWOCustomDTO deleteDuplicateSWOCustomDTO = new DeleteDuplicateSWOCustomDTO();
					deleteDuplicateSWOCustomDTO.addSwos(markedForDeletionList);
					session.storeObjectToSession(SessionConstants.MARKED_FOR_DELETION,deleteDuplicateSWOCustomDTO);
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
		return ActionNameConstants.DELETE_INVENTORY;
	}

	private List getSelectedDeleteOptions(OPPTSession session, String selectedIds[], String sandsSelectedIds[]) 
	{
		List swoList = new ArrayList();
		
		if(null != session){
			int size = 0;
			int sandsSize = 0;
			if(null != selectedIds){
				size = selectedIds.length;
			}
			if(null != sandsSelectedIds){
				sandsSize = sandsSelectedIds.length;
			}
			
			if(0 < (size + sandsSize)){
				ProposalDetailsCustomDTO proposalDetails = (ProposalDetailsCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_DETAILS);
				if(null != proposalDetails)
				{
					for(int i=0; i<size; i++){
						StringTokenizer st = new StringTokenizer(selectedIds[i], Constants.STRING_SEPERATOR);
						if(3 == st.countTokens()){
							SWOCustomDTO swoCustomDTO = getSWO(proposalDetails, st.nextToken().trim(), st.nextToken().trim(), st.nextToken().trim(), false);
							swoCustomDTO.setMarkedForDeletion(true);
							swoList.add(swoCustomDTO);
						}
					}
					
					for(int i=0; i<sandsSize; i++){
						StringTokenizer st = new StringTokenizer(sandsSelectedIds[i], Constants.STRING_SEPERATOR);
						if(3 == st.countTokens()){
							SWOCustomDTO swoCustomDTO = getSWO(proposalDetails, st.nextToken().trim(), st.nextToken().trim(), st.nextToken().trim(), true);
							swoCustomDTO.setMarkedForDeletion(true);
							swoList.add(swoCustomDTO);
						}
						
					}
				}
			}
		}
		return swoList;
	}
	
	private SWOCustomDTO getSWO(ProposalDetailsCustomDTO proposalDetails, String customerId, String dmId, String swoId, boolean isSandS) 
	{
		SWOCustomDTO customDTO = null;
		if(null != customerId && null != dmId && null != swoId)
		{
			TreeMap customers = null;
			if(isSandS){
				customers = proposalDetails.getSAndSCustomers();
			}
			else{
				customers = proposalDetails.getCustomers();
			}
			
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

	
	private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
		ProposalCustomDTO currentProposal = null;
		if(null != session){
			currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);			
		}
		return currentProposal;
	}


	private void setDeleteInventory(OPPTSession session, DeleteInventoryCustomDTO customDTO) 
	{
		if(null != session && null != customDTO){
			session.storeObjectToSession(SessionConstants.SESSION_INVENTIORY_TO_BE_DELETED, customDTO);
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
