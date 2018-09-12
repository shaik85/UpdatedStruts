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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ErrorDetailsActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorInfoViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ErrorDetailsAction extends OPPTLongAction 
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
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;

		ErrorDetailsActionForm actionForm = (ErrorDetailsActionForm)form;
	
		if(null != actionForm){	
			ErrorHistoryCustomDTO customDTO = (ErrorHistoryCustomDTO)session.getObjectFromSession(SessionConstants.ERROR_HISTORY);
			viewBean = getErrorDetails(customDTO, actionForm.getErrorId());
			if(null != viewBean){
				setForwardName(customDTO, getRole(session));
			}
			else{
				viewBean = handleErrorReport(getErrorReport(ErrorCodeConstants.PA20));
			}
		}
		else{
			viewBean = handleErrorReport(getErrorReport(ErrorCodeConstants.PA20));
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
	protected String getActionName(){
		return ActionNameConstants.ERROR_DETAILS;
	}
	
	private ErrorInfoViewBean getErrorDetails(ErrorHistoryCustomDTO customDTO, String errorId) 
	{
		ErrorInfoViewBean viewBean = null;
				
		if(null != customDTO && null != errorId){
			if(null != customDTO){
				TreeMap errorInfos = customDTO.getErrorInfos();
				if(null != errorInfos){
					ErrorInfoCustomDTO errorInfo = (ErrorInfoCustomDTO)errorInfos.get(new Integer(errorId));
					if(null != errorInfo){
						viewBean = new ErrorInfoViewBean(errorInfo);
					}
				}
			}
		}
		
		return viewBean;
	}


	private void setForwardName(ErrorHistoryCustomDTO customDTO, int role){
		if(null != customDTO){
			ProposalCustomDTO proposal = customDTO.getProposalDTO();
			if(null != proposal){
				if(proposal instanceof ContractCustomDTO){
					switch(role){
						case Constants.PROPOSAL_CREATE_APPROVER: 
											setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_CONTRACT_ERROR_DETAILS);
											break;

						case Constants.PROPOSAL_ADMINISTRATOR:
						default:
											setForwardName(ForwardNameConstants.PAGE_CONTRACT_ERROR_DETAILS);
											break;
					}
				}
				else{
					switch(role){
						case Constants.PROPOSAL_CREATE_APPROVER: 
											setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_ERROR_DETAILS);
											break;

						case Constants.PROPOSAL_ADMINISTRATOR:
						default:
											setForwardName(ForwardNameConstants.PAGE_ERROR_DETAILS);
											break;
					}
				}
			}
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