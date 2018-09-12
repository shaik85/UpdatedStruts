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
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ContractDetailsAction extends OPPTLongAction {
	/** 
	 * Overridden method - Enter your description here.
	 *  
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
		
		ContractCustomDTO currentContract = getCurrentContract(session);

		if(null != currentContract){
			ProposalDetailsCustomDTO customDTO = new ProposalDetailsCustomDTO();
			setTransactionInformation(customDTO, session);
			customDTO.setProposalDTO(currentContract);
			customDTO.setPageIndex(1);
			customDTO.setRequestFor(UtilityConstants.GOTO_PAGE);
			
			try {
				customDTO = getProposalManager().fetchProposalDetails(customDTO);
				ErrorReport errorReport = customDTO.getMessageReport();
				if(null == errorReport)
				{
					addDataStoreEntry(session, customDTO);
					setProposalDetails(session, customDTO);
					viewBean = new ProposalDetailsViewBean(customDTO);
					setForwardName(getRole(session));
				}
				else{
					viewBean = new MessageViewBean();
					viewBean.setErrorReport(errorReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);
				}
			}
			catch(ServiceException se){
				viewBean = handleServiceException(session, se.getErrorReport());
			}
		}
		else{
			viewBean = new ErrorViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA00));
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
		return ActionNameConstants.CONTRACT_DETAILS;
	}

	/** 
	 * Overridden method - Returns true as this action is the first action of the process. 
	 * 
	 * <br/><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#isFirstActionOfProcess() 
	 * @return boolean 
	 * 
	 */
	protected boolean isFirstActionOfProcess() {
		return true;
	}
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#getFirstActionForwardName() 
	 * @return 
	 * 
	 */
	protected String getFirstActionForwardName() {
		return ForwardNameConstants.ACTION_PROPOSAL_DETAILS;
	}
	

	/**
	 * Gets the current proposal stored as part of the session  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session OPPTSession
	 * @return ContractCustomDTO
	 */
	private ContractCustomDTO getCurrentContract(OPPTSession session) {
		ContractCustomDTO currentContract = null;
		if(null != session){
			currentContract = (ContractCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);
		}
		return currentContract;
	}

	/**
	 * Stores proposal details as part of session  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session OPPTSession
	 * @param dto ProposalDetailsCustomDTO
	 */
	private void setProposalDetails(OPPTSession session, ProposalDetailsCustomDTO dto) {
		if(null != session & null != dto){
			session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS, dto);
		}
	}

	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_DETAILS);
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								setForwardName(ForwardNameConstants.PAGE_CONTRACT_DETAILS);
								break;
		}
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Feb 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param session
	 * @return 
	 * 
	 */
	protected boolean validateCurrentViewContent(OPPTSession session) {
		return true;
	}
}