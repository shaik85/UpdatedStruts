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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.QuotesListActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.QuotesListViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class QuotesListAction extends OPPTLongAction 
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception 
	{
		OPPTViewBean viewBean = null;
		
		QuotesListActionForm actionForm = (QuotesListActionForm)form;
		PlannedInventoryCustomDTO customDTO = new PlannedInventoryCustomDTO();
		customDTO.setProposalDTO(getCurrentProposal(session));
		customDTO.setSelectedQuotes(getSelectedQuotes(session, actionForm.getSelectedQuoteIds()));
		setTransactionInformation(customDTO, session);
		
		try{
			if(null != customDTO.getSelectedQuotes() && 0 < customDTO.getSelectedQuotes().size()){
				customDTO = getProposalManager().addPlannedInventory(customDTO);
				ErrorReport messageReport = customDTO.getMessageReport();
				if(null == messageReport){
					addDataStoreEntry(session, customDTO);
					removeQuotesList(session);
					setForwardName(ForwardNameConstants.ACTION_PRICE_PROPOSAL);
				}
				else{
					viewBean = new MessageViewBean();
					viewBean.setErrorReport(messageReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);
				}
			}
			else{
				removeQuotesList(session);
				setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS);
			}
		}
		catch(ServiceException se)
		{
			viewBean = handleServiceException(session, se.getErrorReport());
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
		return ActionNameConstants.QUOTE_LIST;
	}

	private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
		ProposalCustomDTO currentProposal = null;
		if(null != session){
			currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);			
		}
		return currentProposal;
	}

	/**
     * getSelectedQuotes
     * 
     * @param session
     * @param selectedIds
     * @return
     * @author thirumalai
     */
    public TreeMap getSelectedQuotes(OPPTSession session, String selectedIds[]) 
	{
		TreeMap selectedQuotes = null;
		
		if(null != session && null != selectedIds){
			QuotesListCustomDTO quotesListDTO = (QuotesListCustomDTO)session.getObjectFromSession(SessionConstants.QUOTES_LIST);
			if(null != quotesListDTO){
				TreeMap quotes = quotesListDTO.getQuotes();
				if(null != quotes){
					for(int i=0, size=selectedIds.length; i<size; i++){
						QuoteCustomDTO quote = (QuoteCustomDTO)quotes.get(selectedIds[i]);
						if(null != quote){
							if(null == selectedQuotes){
								selectedQuotes = new TreeMap(); 
							}
							selectedQuotes.put(selectedIds[i], quote);
						}
					}
				}
			}
		}
		
		return selectedQuotes;
	}

	private void removeQuotesList(OPPTSession session) {
		if(null != session){
			session.removeObjectFromSession(SessionConstants.QUOTES_LIST);
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
			if(viewBean instanceof QuotesListViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.INVENTORY_DATERANGE);
			if(null != dataStoreEntry && dataStoreEntry instanceof QuotesListCustomDTO){
				session.setCurrentViewBean(new QuotesListViewBean((QuotesListCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_QUOTES_LIST;
								break;
			
			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_QUOTES_LIST;
								break;
		}
		
		return currentForwardName;
	}
}
