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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ErrorHistoryActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorHistoryViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class DeleteErrorHistoryAction extends OPPTLongAction {
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
	 * @see com.ibm.support.oppt.OPPTAction#executeAction(org.apache.struts.action.ActionForm, com.ibm.support.oppt.session.OPPTSession) 
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		ErrorHistoryActionForm actionForm = (ErrorHistoryActionForm)form;
		if (null != actionForm) 
		{
			ErrorHistoryCustomDTO customDTO = getErrorHistoryToBeDeleted(session, actionForm.getSelectedIds());
			if(null != customDTO){
				setTransactionInformation(customDTO, session);

				try{
					getProposalManager().deleteErrorHistory(customDTO);
					setForwardName(ForwardNameConstants.ACTION_ERROR_HISTORY);
				}
				catch(ServiceException se){
					viewBean = handleServiceException(session, se.getErrorReport());
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
		return ActionNameConstants.DELETE_ERROR_HISTORY;
	}

	private ErrorHistoryCustomDTO getErrorHistoryToBeDeleted(OPPTSession session, String selectedIds[]) {
		ErrorHistoryCustomDTO customDTO = null;
		
		if(null != session && null != selectedIds && 0 < selectedIds.length)
		{

			ErrorHistoryCustomDTO errorHistory = (ErrorHistoryCustomDTO)session.getObjectFromSession(SessionConstants.ERROR_HISTORY);
			if(null != errorHistory)
			{
				TreeMap errorInfos = errorHistory.getErrorInfos();
				if(null != errorHistory)
				{
					for(int i=0, size=selectedIds.length; i<size; i++){
						if(null == customDTO){
							customDTO = new ErrorHistoryCustomDTO();
							customDTO.setProposalDTO(errorHistory.getProposalDTO());
						}
						customDTO.addErrorInfo((ErrorInfoCustomDTO)errorInfos.get(new Integer(selectedIds[i])));
					}
				}
			}
		}
		
		return customDTO;
	}

	private void setErrorHistory(OPPTSession session, ErrorHistoryCustomDTO dto) 
	{
		if(null != session && null != dto){
			session.storeObjectToSession(SessionConstants.ERROR_HISTORY, dto);
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
		String actualForward = getCurrentForwardName(session, getRole(session));

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof ErrorHistoryViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.ERROR_HISTORY);
			if(null == dataStoreEntry){
				dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.CONTRACT_ERROR_HISTORY);
			}
			if(null != dataStoreEntry && dataStoreEntry instanceof ErrorHistoryCustomDTO){
				session.setCurrentViewBean(new ErrorHistoryViewBean((ErrorHistoryCustomDTO)dataStoreEntry));
				session.setCurrentForward(actualForward);
				valid = true;
			}
		}
		
		return valid;
	}

	private String getCurrentForwardName(OPPTSession session, int role){
		String currentForwardName = null;
		ProposalCustomDTO proposal = null;

		ErrorHistoryCustomDTO errorHistory = (ErrorHistoryCustomDTO)session.getObjectFromSession(SessionConstants.ERROR_HISTORY);
		if(null != errorHistory){
			proposal = errorHistory.getProposalDTO();
		}
		
		if(null != proposal){
			if(proposal instanceof ContractCustomDTO){
				switch(role){
					case Constants.PROPOSAL_CREATE_APPROVER: 
										currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_ERROR_HISTORY;
										break;

					case Constants.PROPOSAL_ADMINISTRATOR:
					default:
										currentForwardName = ForwardNameConstants.PAGE_CONTRACT_ERROR_HISTORY;
										break;
				}
			}
			else if(proposal instanceof ProposalCustomDTO){
				switch(role){
					case Constants.PROPOSAL_CREATE_APPROVER: 
										currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_ERROR_HISTORY;
										break;
			
					case Constants.PROPOSAL_ADMINISTRATOR:
					default:
										currentForwardName = ForwardNameConstants.PAGE_ERROR_HISTORY;
										break;
				}
			}
		}
		
		return currentForwardName;
	}
}