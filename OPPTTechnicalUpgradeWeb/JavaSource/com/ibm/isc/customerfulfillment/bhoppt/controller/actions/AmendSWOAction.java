/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.*;

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
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class AmendSWOAction extends OPPTLongAction 
{
   public static int rol;
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
		throws Exception {
		OPPTViewBean viewBean=null;
		SWOCustomDTO swoCustomDto = null;
		SWODetailsCustomDTO customDTO=null;
		
		String []selectedId;
		ProposalDetailsActionForm actionForm = (ProposalDetailsActionForm)form;
		
		selectedId = actionForm.getSelectedIds();
		if(null != selectedId && selectedId.length == 1){
			StringTokenizer st = new StringTokenizer(selectedId[0], Constants.STRING_SEPERATOR);
			if(3 != st.countTokens()){
				viewBean = session.getCurrentViewBean();
				viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PAF67));
				setForwardName(session.getCurrentForward());
			}
			else{
				swoCustomDto = populateContractDto(session,st.nextToken().trim(), st.nextToken().trim(), st.nextToken().trim());
				if(null != swoCustomDto){
					customDTO = new SWODetailsCustomDTO();
					setTransactionInformation(customDTO, session);
					customDTO = createSWODetailsCustomDTO(customDTO, swoCustomDto);
					customDTO.setProposal(getCurrentProposal(session));
	
					try {
						customDTO = getProposalManager().getSWODetails(customDTO);
						ErrorReport errorReport = customDTO.getMessageReport();

						if(null == errorReport){
							viewBean = new AmendSWOViewBean(customDTO);
							populateYearList(viewBean);
							setInSession(swoCustomDto, session);
							setForwardName(getRole(session));
						}
						else{
							viewBean = new MessageViewBean();
							viewBean.setErrorReport(errorReport);
							setForwardName(ForwardNameConstants.PAGE_MESSAGE);
						}
					}
					catch(ServiceException ex){
						viewBean = handleServiceException(session, ex.getErrorReport());
					}
				}
			}
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PAF52));
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
		return ActionNameConstants.AMEND_SWO;
	}
	
	
	private SWOCustomDTO populateContractDto(OPPTSession session, String customerId, String dmId, String swoId){
		SWOCustomDTO customDTO = null;
		if(null != session && null != customerId && null != dmId && null != swoId){
			ProposalDetailsCustomDTO proposalDetails = (ProposalDetailsCustomDTO)session.getObjectFromSession(SessionConstants.PROPOSAL_DETAILS);
			if(null != proposalDetails){
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
	
	private SWODetailsCustomDTO createSWODetailsCustomDTO(SWODetailsCustomDTO customDTO, SWOCustomDTO swoCustomDTO){
		if(null != swoCustomDTO){
			customDTO.setProposalId(swoCustomDTO.getProposalId());
			customDTO.setDMId(swoCustomDTO.getDMId());
			customDTO.setId(swoCustomDTO.getId());
			customDTO.setSerialNumber(swoCustomDTO.getSerialNumber());
			customDTO.setNumber(swoCustomDTO.getNumber());
			customDTO.setDescription(swoCustomDTO.getDescription());
			customDTO.setEswPrice(swoCustomDTO.getEswPrice());
			customDTO.setAlternatePrice(swoCustomDTO.getAlternatePrice());
			customDTO.setCalculatedPrice(swoCustomDTO.getCalculatedPrice());
			customDTO.setPlanStartDate(swoCustomDTO.getPlanStartDate());
			customDTO.setPlanEndDate(swoCustomDTO.getPlanEndDate());
			customDTO.setAmendedLicense(swoCustomDTO.isAmendedLicense());
			customDTO.setDeltaFetchLicense(swoCustomDTO.isDeltaFetchLicense());
			customDTO.setExcluded(swoCustomDTO.isExcluded());
			customDTO.setForConract(swoCustomDTO.isForConract());
			customDTO.setQuote(swoCustomDTO.isQuote());
			customDTO.setRefetchLicense(swoCustomDTO.isRefetchLicense());
			customDTO.setSvcLicense(swoCustomDTO.isSvcLicense());
			customDTO.setEditedLicense(swoCustomDTO.isEditedLicense());
			customDTO.setCustomerId(swoCustomDTO.getCustomerId());
		}
		return customDTO;
	}
	
	
	private void setInSession(SWOCustomDTO swoCustomDto, OPPTSession session){
		if(null != session){
			session.storeObjectToSession(SessionConstants.SESSION_AMEND_SWO ,swoCustomDto);
		}
	}
	
	/**
	 *  
	 * Populate year list
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param viewBean
	 */
	private void populateYearList(OPPTViewBean viewBean){
		ArrayList yearList = new ArrayList();
		Calendar cal = Calendar.getInstance();
		AmendSWOViewBean yearBean = (AmendSWOViewBean)viewBean;
		
		if(rol==RoleConstants.DATA_MIGRATOR){
			int initialYear = cal.get(Calendar.YEAR) -5;
			int finalYear = initialYear + 15;
			
			for (int i = initialYear; i <= finalYear; i++){
				yearList.add(new Integer(i));
			}
		
		}
		else
		{
			
			int initialYear = cal.get(Calendar.YEAR) -1;
			int finalYear = initialYear + 11;
			
			for (int i = initialYear; i <= finalYear; i++){
				yearList.add(new Integer(i));
			}
			
		}

		yearBean.setYearList(yearList);
	}


	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_AMEND_SWO);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_AMEND_SWO);
								break;
		}
	}

	/**
     * validateCurrentViewContent
     * 
     * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#validateCurrentViewContent(com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession)
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_DETAILS;
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_CONTRACT_DETAILS;
								break;
		}
		
		return currentForwardName;
	}
}