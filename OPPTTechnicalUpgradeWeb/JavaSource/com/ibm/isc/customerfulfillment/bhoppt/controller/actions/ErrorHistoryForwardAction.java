/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorHistoryViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 27, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class ErrorHistoryForwardAction extends OPPTLongAction {
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

		ErrorHistoryCustomDTO customDTO = getErrorHistory(session);
		if(null != customDTO){
			customDTO.setErrorInfos(null);

			try 
			{
				customDTO = getProposalManager().viewErrorHistory(customDTO);
				ErrorReport messageReport = customDTO.getMessageReport();
				if(null == messageReport){
					addDataStoreEntry(session, customDTO);
					viewBean = new ErrorHistoryViewBean(customDTO);
					setErrorHistory(session, customDTO);
					setForwardName(getForwardName(customDTO, getRole(session)));
				}
				else{
					viewBean = new MessageViewBean(MessageConstants.ERROR_HISTORY);
					viewBean.setErrorReport(messageReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);
				}
			} 
			catch (ServiceException se){
				viewBean = handleErrorReport(se.getErrorReport());
			}
		}
		else{
			viewBean = handleErrorReport(getErrorReport(ErrorCodeConstants.PA17));
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
		return ActionNameConstants.ERROR_HISTORY;
	}

	private void setErrorHistory(OPPTSession session, ErrorHistoryCustomDTO dto){
		if(null != session && null != dto){
			session.storeObjectToSession(SessionConstants.ERROR_HISTORY, dto);
		}
	}

	private ErrorHistoryCustomDTO getErrorHistory(OPPTSession session) {
		ErrorHistoryCustomDTO customDTO = null;
		if(null != session){
			customDTO = (ErrorHistoryCustomDTO)session.getObjectFromSession(SessionConstants.ERROR_HISTORY);
		}
		return customDTO;
	}

	private String getForwardName(ErrorHistoryCustomDTO errorHistory, int role){
		String forwardName = null;
		ProposalCustomDTO proposal = errorHistory.getProposalDTO();

		if(null != proposal){
			if(proposal instanceof ContractCustomDTO){
				switch(role){
					case Constants.PROPOSAL_CREATE_APPROVER: 
										forwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_ERROR_HISTORY;
										break;

					case Constants.PROPOSAL_ADMINISTRATOR:
					default:
										forwardName = ForwardNameConstants.PAGE_CONTRACT_ERROR_HISTORY;
										break;
				}
			}
			else if(proposal instanceof ProposalCustomDTO){
				switch(role){
					case Constants.PROPOSAL_CREATE_APPROVER: 
										forwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_ERROR_HISTORY;
										break;
			
					case Constants.PROPOSAL_ADMINISTRATOR:
					default:
										forwardName = ForwardNameConstants.PAGE_ERROR_HISTORY;
										break;
				}
			}
		}
		
		return forwardName;
	}

	/**
     * validateCurrentViewContent
     * 
     * @param session
     * @return boolean
     * @author thirumalai
     */
	protected boolean validateCurrentViewContent(OPPTSession session) {
		return true;
	}
}