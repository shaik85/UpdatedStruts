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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SWOActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
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
public class SWODetailsAction extends OPPTLongAction 
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
		
		SWOActionForm actionForm = (SWOActionForm)form;
		SWOCustomDTO swoCustomDTO = getSWO(session, actionForm.getCustomerId(), actionForm.getDmId(), actionForm.getSwoId(), actionForm.getType());
		if(null != swoCustomDTO){
			SWODetailsCustomDTO customDTO = createSWODetailsCustomDTO(swoCustomDTO);
			customDTO.setProposal(getCurrentProposal(session));
			setTransactionInformation(customDTO, session);
			
			//CR 2031
			Boolean duplicateSerial = (Boolean)session.getObjectFromSession(SessionConstants.DUPLICATE_SERIAL_NUMBERS);
			if(null != duplicateSerial && duplicateSerial.booleanValue()) {
				customDTO.setSWOEditable(false);		
			}
			//CR 2031
			try{
				customDTO = getProposalManager().getSWODetails(customDTO);
				ErrorReport messageReport = customDTO.getMessageReport();
				if(null == messageReport){
					addDataStoreEntry(session, customDTO);
					saveSWODetails(session, customDTO);
					viewBean = new SWODetailsViewBean(customDTO);
					setForwardName(getCurrentProposal(session), getRole(session));
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
		}
		else{
			viewBean = new ErrorViewBean();
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
		return ActionNameConstants.SWO_DETAILS;
	}

	private ProposalCustomDTO getCurrentProposal(OPPTSession session) {
		ProposalCustomDTO currentProposal = null;
		if(null != session){
			currentProposal = (ProposalCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);			
		}
		return currentProposal;
	}

	private SWOCustomDTO getSWO(OPPTSession session, String customerId, String dmId, String swoId, String type) 
	{
		SWOCustomDTO customDTO = null;
		if(null != session && null != customerId && null != dmId && null != swoId){
			ProposalDetailsCustomDTO proposalDetails = (ProposalDetailsCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_DETAILS);
			if(null != proposalDetails){
				TreeMap customers;
				if(type != null && type.equalsIgnoreCase("sands")){  //$NON-NLS-1$
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
		}
		return customDTO;
	}
   
	private void saveSWODetails(OPPTSession session, SWODetailsCustomDTO dto) 
	{
		if(null != session && null != dto){
			session.storeObjectToSession(SessionConstants.SWO_DETAILS, dto);
		}
	}
	
	private SWODetailsCustomDTO createSWODetailsCustomDTO(SWOCustomDTO swoCustomDTO){
		SWODetailsCustomDTO customDTO = new SWODetailsCustomDTO();
		if(null != swoCustomDTO){
			customDTO.setSerialNumber(swoCustomDTO.getSerialNumber());
			customDTO.setNumber(swoCustomDTO.getNumber());
			customDTO.setDescription(swoCustomDTO.getDescription());
			customDTO.setPlanStartDate(swoCustomDTO.getPlanStartDate());
			customDTO.setPlanEndDate(swoCustomDTO.getPlanEndDate());
			customDTO.setEswPrice(swoCustomDTO.getEswPrice());
			customDTO.setAlternatePrice(swoCustomDTO.getAlternatePrice());
			customDTO.setCalculatedPrice(swoCustomDTO.getCalculatedPrice());
			customDTO.setProposalId(swoCustomDTO.getProposalId());
			customDTO.setCustomerId(swoCustomDTO.getCustomerId());
			customDTO.setDMId(swoCustomDTO.getDMId());
			customDTO.setId(swoCustomDTO.getId());
			customDTO.setSAndS(swoCustomDTO.isSAndS());
		}
		return customDTO;
	}

	private void setForwardName(ProposalCustomDTO currentProposal, int role){
		if(currentProposal instanceof ContractCustomDTO){
			setContractForwardName(role);
		}
		else if(currentProposal instanceof ProposalForApprovalCustomDTO){
			setProposalForApprovalForwardName(role);
		}
		else{
			setProposalForwardName(role);
		}
	}

	private void setProposalForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_SWO_DETAILS);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_SWO_DETAILS);
								break;
		}
	}
	private void setProposalForApprovalForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_SWO_DETAILS);
								break;

			case Constants.PROPOSAL_APPROVER:
			default:
								setForwardName(ForwardNameConstants.PAGE_PROPOSAL_FOR_APPROVAL_SWO_DETAILS);
								break;
		}
	}
	private void setContractForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_SWO_DETAILS);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_CONTRACT_SWO_DETAILS);
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
