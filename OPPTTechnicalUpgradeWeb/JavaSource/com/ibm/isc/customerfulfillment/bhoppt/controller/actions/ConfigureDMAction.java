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
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ConfigureDMAction extends OPPTLongAction 
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
					StringTokenizer st = new StringTokenizer(selectedIds[0], Constants.STRING_SEPERATOR);
					if(2 == st.countTokens()){
						viewBean = configureDM(session, st.nextToken().trim(), st.nextToken().trim(), isSandS);
					}
					else if(1 == st.countTokens()){
						viewBean = session.getCurrentViewBean();
						viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA22));
						setForwardName(session.getCurrentForward());
					}
					else if(3 == st.countTokens()){
						viewBean = session.getCurrentViewBean();
						viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA24));
						setForwardName(session.getCurrentForward());
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
		return ActionNameConstants.CONFIGURE_DM;
	}

	private OPPTViewBean configureDM(OPPTSession session, String customerId, String dmId, boolean isSandS) throws Exception {
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

		ConfigureDMCustomDTO customDTO = new ConfigureDMCustomDTO();
		setTransactionInformation(customDTO, session);
		setInputInformation(selectedDM, customDTO, getCurrentProposal(session));

		try{
			customDTO = getProposalManager().retrieveDM(customDTO);
			ErrorReport messageReport = customDTO.getMessageReport();
			if(null == messageReport){
				addDataStoreEntry(session, customDTO);
				setConfigureDM(session, customDTO);
				viewBean = new ConfigureDMViewBean(customDTO);
				setForwardName(getRole(session));
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
		
		return viewBean;
	}


	private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
		ProposalCustomDTO currentProposal = null;
		if(null != session){
			currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);			
		}
		return currentProposal;
	}
   
	private void setConfigureDM(OPPTSession session, ConfigureDMCustomDTO customDTO) {
    	if(null != session && null != customDTO){
    		session.storeObjectToSession(SessionConstants.SESSION_CONFIGURE_DM, customDTO);
    	}
	}

	private void setInputInformation(DMCustomDTO sourceDM, ConfigureDMCustomDTO configDM, ProposalCustomDTO currentProposal){
		if(null != sourceDM){
			if(null != currentProposal){
				configDM.setProposalId(currentProposal.getId());
			}
			if(null != configDM){
				configDM.setCustomerId(sourceDM.getCustomerId());
				configDM.setId(sourceDM.getId());
				configDM.setNumber(sourceDM.getNumber());
				configDM.setDescription(sourceDM.getDescription());
				configDM.setPlanStartDate(sourceDM.getPlanStartDate());
				configDM.setPlanEndDate(sourceDM.getPlanEndDate());
				configDM.setSAndS(sourceDM.isSAndS());
			}
		}
	}

	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CONFIGURE_DM);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_CONFIGURE_DM);
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