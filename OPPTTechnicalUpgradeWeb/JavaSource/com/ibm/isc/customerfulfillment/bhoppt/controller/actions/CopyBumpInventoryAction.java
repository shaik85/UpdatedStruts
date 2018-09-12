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
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerHome;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class CopyBumpInventoryAction extends OPPTLongAction 
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
			String selectedIds[] = actionForm.getSelectedIds();
			String selectedSandSIds[] = actionForm.getSelectedSandSIds();
			if(null != selectedIds || null != selectedSandSIds)
			{
				int idLength = 0;
				int sandsidLength = 0;
				boolean isSandS = false;
				if(null != selectedIds){
					idLength = selectedIds.length;
				}
				if(null != selectedSandSIds){
					sandsidLength = selectedSandSIds.length;
				}
				
				if((idLength + sandsidLength) == 1)
				{
					if(null == actionForm.getSelectedIds()){
						selectedIds = actionForm.getSelectedSandSIds();
						isSandS = true;
					}
					ProposalManagerHome pcmHome = (ProposalManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("ProposalManagerHome");  //$NON-NLS-1$
					ProposalManager pcm = pcmHome.create();

					int selectionType = -1;
					StringTokenizer st = new StringTokenizer(selectedIds[0], Constants.STRING_SEPERATOR);
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
						viewBean = session.getCurrentViewBean();
						viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA22));
						setForwardName(session.getCurrentForward());
					}
					else if(Constants.DM == selectionType){
						viewBean = copyBumpDM(session, st.nextToken().trim(), st.nextToken().trim(), isSandS);
					}
					else if(Constants.SWO == selectionType){
						viewBean = copyBumpSWO(session, st.nextToken().trim(), st.nextToken().trim(), st.nextToken().trim(), isSandS);
					}
				}
				else{
					viewBean = session.getCurrentViewBean();
					viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA19));
					setForwardName(session.getCurrentForward());
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
		return ActionNameConstants.COPY_BUMP_INVENTORY;
	}

	private OPPTViewBean copyBumpDM(OPPTSession session, String customerId, String dmId, boolean isSandS) throws Exception {
		OPPTViewBean viewBean = null;
		
		DMCustomDTO selectedDM = null;
		ProposalCustomerCustomDTO customer = null;
		if(null != customerId && null != dmId)
		{
			ProposalDetailsCustomDTO proposalDetails = (ProposalDetailsCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_DETAILS);
			if(null != proposalDetails)
			{
				TreeMap customers;
				if(isSandS){
					customers = proposalDetails.getSAndSCustomers();
				}
				else{
					customers = proposalDetails.getCustomers();
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
		}

		CopyBumpDMCustomDTO customDTO = new CopyBumpDMCustomDTO();
		selectedDM.setProposalId(getCurrentProposal(session).getId());
		setTransactionInformation(customDTO, session);
		customDTO.setDmDTO(selectedDM);
		customDTO.setProposalDTO(getCurrentProposal(session));

		try{
			ErrorReport messageReport = customDTO.getMessageReport();
			if(null == messageReport){
				customDTO = getProposalManager().copyBumpInventory(customDTO);
				addDataStoreEntry(session, customDTO);
				setCopyBumpDM(session, customDTO);
				viewBean = new DMCopyBumpViewBean(customDTO);
				setDMForwardName(getRole(session));
			}
			else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(messageReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);
			}
		}
		catch(ServiceException se)
		{
			viewBean = handleServiceException(session, se.getErrorReport());
		}
		
		return viewBean;
	}

	private OPPTViewBean copyBumpSWO(OPPTSession session, String customerId, String dmId, String swoId, boolean isSandS) throws Exception {
		OPPTViewBean viewBean = null;
		
		SWOCustomDTO selectedSWO = null;
		DMCustomDTO dm = null;
		ProposalCustomerCustomDTO customer = null;
		if(null != customerId && null != dmId && null != swoId)
		{
			ProposalDetailsCustomDTO proposalDetails = (ProposalDetailsCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_DETAILS);
			if(null != proposalDetails)
			{
				TreeMap customers;
				if(isSandS){
					customers = proposalDetails.getSAndSCustomers();
				}
				else{
					customers = proposalDetails.getCustomers();
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
		}

		if(null != selectedSWO){
			CopyBumpSWOCustomDTO customDTO = new CopyBumpSWOCustomDTO();
			selectedSWO.setProposalId(getCurrentProposal(session).getId());
			setTransactionInformation(customDTO, session);
			customDTO.setSwoDTO(selectedSWO);
			customDTO.setProposalDTO(getCurrentProposal(session));

			try{
				customDTO = getProposalManager().copyBumpInventory(customDTO);
				ErrorReport messageReport = customDTO.getMessageReport();
				if(null == messageReport){
					addDataStoreEntry(session, customDTO);
					setCopyBumpSWO(session, customDTO);
					viewBean = new SWOCopyBumpViewBean(customDTO);
					setSWOForwardName(getRole(session));
				}
				else{
					viewBean = new MessageViewBean();
					viewBean.setErrorReport(messageReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);
				}
			}
			catch(ServiceException se)
			{
				viewBean = session.getCurrentViewBean();
				viewBean.setErrorReport(se.getErrorReport());
				setForwardName(session.getCurrentForward());
			}
		}
		
		return viewBean;
	}


	private void setCopyBumpDM(OPPTSession session, CopyBumpDMCustomDTO customDTO){
    	if(null != session && null != customDTO){
    		session.storeObjectToSession(SessionConstants.SESSION_COPY_BUMP_INVENTIORY_DM, customDTO);
    	}
	}
   
	private void setCopyBumpSWO(OPPTSession session, CopyBumpSWOCustomDTO customDTO){
		if(null != session && null != customDTO){
			session.storeObjectToSession(SessionConstants.SESSION_COPY_BUMP_INVENTIORY_SWO, customDTO);
		}
	}

	private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
		ProposalCustomDTO currentProposal = null;
		if(null != session){
			currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);			
		}
		return currentProposal;
	}
	
	private void setSWOForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_COPY_BUMP_SWO);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_COPY_BUMP_SWO);
								break;
		}
	}

	private void setDMForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_COPY_BUMP_DM);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_COPY_BUMP_DM);
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