/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.RefreshFetchCustomerListActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.OPPTPaginationHelper;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerListSelectionViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.PartnerDetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalHeaderCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Fetch customer list action  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 4, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class RefreshFetchCustomerListAction extends OPPTLongAction {
	/** 
	 * Overridden method - Has the logic to call service layer method to fetch customer lists 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.support.oppt.OPPTAction#executeAction(org.apache.struts.action.ActionForm, com.ibm.support.oppt.session.OPPTSession) 
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
	/**	ProposalHeaderCustomDTO proposalHeader = getProposalHeader(session);

		if(null != proposalHeader){
			FetchCustomerListCustomDTO customDTO = new FetchCustomerListCustomDTO();
			customDTO.setProposal(proposalHeader.getProposal());
			customDTO.setDivisionCode(proposalHeader.getBasicProposalCustomDTO().getDivision());
			customDTO.setDistributionChannel(proposalHeader.getBasicProposalCustomDTO().getDistributionChannel());
			customDTO.setSelectedSalesOrg(proposalHeader.getBasicProposalCustomDTO().getSalesOrganization());
			customDTO.setComments(proposalHeader.getSecondaryProposalCustomDTO().getComments());
			setTransactionInformation(customDTO, session);

			((RefreshFetchCustomerListActionForm)form).getRequestParams(customDTO);
			try {
				if(RoleConstants.BUSINESS_PARTNER == customDTO.getRole()){
					customDTO = getProposalManager().fetchCustomerListsForBP(customDTO);
				}
				else{
					customDTO = getProposalManager().fetchCustomerLists(customDTO);
				}
				ErrorReport messageReport = customDTO.getMessageReport();
				if(null == messageReport){
					addDataStoreEntry(session, customDTO);
					saveCustomerLists(session, customDTO);
					updateProposalHeaderComments(session, proposalHeader, customDTO.getComments());
					viewBean = new CustomerListSelectionViewBean(customDTO, proposalHeader.isChangeProposal());
					OPPTPaginationHelper.paginateViewBean((CustomerListSelectionViewBean)viewBean);
					
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
		else{
			viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA00), session.getCurrentForward());
			setForwardName(ForwardNameConstants.PAGE_ERROR);
		}
**/		
		return viewBean;
	}

	/** 
	 * Overridden method - Returns the action name 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return String
	 * 
	 */
	protected String getActionName() {
		return ActionNameConstants.FETCH_CUSTOMER_LIST;
	}

	/**
	 * Stores the fetched customer lists into session  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dto FetchCustomerListCustomDTO
	 */
	private void saveCustomerLists(OPPTSession session, FetchCustomerListCustomDTO dto) {
		if(null != session && null != dto){
			session.storeObjectToSession(SessionConstants.PROPOSAL_CREATION_CUSTOMER_LISTS, dto);
		}
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
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CUSTOMER_LIST_SELECTION);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_CUSTOMER_LIST_SELECTION);
								break;
		}
	}

	/** 
	 * Overridden method - Check if the current view bean stored in session is what is expected. 
	 * If it is not valid, try to create the current view using the custom dto stored in session 
	 * and set it as current view. If current view cannot be created, return false. 
	 * 
	 * <br/><PRE> 
	 * date Feb 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#validateCurrentViewContent(com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession) 
	 * @param session
	 * @return 
	 * 
	 */
	protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = getCurrentForwardName(getRole(session));

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof PartnerDetailsViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

//		if(!valid){
//			session.setCurrentMessageViewBean(new ErrorViewBean());
//			session.setCurrentForward(ForwardNameConstants.PAGE_ERROR);
//		}
		return valid;
	}

	private String getCurrentForwardName(int role){
		String currentForwardName = null;
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_PARTNER_DETAILS;
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_PARTNER_DETAILS;
								break;
		}
		
		return currentForwardName;
	}
}
