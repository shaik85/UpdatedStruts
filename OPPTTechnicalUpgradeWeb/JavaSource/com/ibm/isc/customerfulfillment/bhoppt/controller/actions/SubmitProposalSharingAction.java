/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalSharingActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalSharingViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ShareProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class SubmitProposalSharingAction extends OPPTLongAction 
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
		
		ProposalSharingActionForm actionForm = (ProposalSharingActionForm)form;
		ShareProposalCustomDTO customDTO = getShareProposal(session);
		if(null != customDTO){
			ErrorReport errorReport = validateUserSelection(actionForm);
			if(null != errorReport && 0 < errorReport.size()){
				viewBean = session.getCurrentViewBean();
				viewBean.setErrorReport(errorReport);
				setForwardName(session.getCurrentForward());
			}
			else{
				customDTO.setAccessType(actionForm.getRequestParams());

				try
				{
					customDTO = getProposalManager().shareProposal(customDTO);
					removeShareProposal(session);
					setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_MAINTENANCE);
				}
				catch(ServiceException se){
					viewBean = handleServiceException(session, se.getErrorReport(), session.getCurrentForward(), session.getCurrentForward());
				}
			}
		}
		else{
			viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA42));
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
		return ActionNameConstants.SUBMIT_PROPOSAL_SHARING;
	}

	private ShareProposalCustomDTO getShareProposal(OPPTSession session) {
		ShareProposalCustomDTO customDTO = null;

		if (null != session) {
			customDTO = (ShareProposalCustomDTO) session.getObjectFromSession(SessionConstants.SHARE_PROPOSAL);
		}

		return customDTO;
	}
	
	private void removeShareProposal(OPPTSession session){
		if(null != session){
			session.removeObjectFromSession(SessionConstants.SHARE_PROPOSAL);
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
			if(viewBean instanceof ProposalSharingViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.PROPOSAL_DETAILS);
			if(null != dataStoreEntry && dataStoreEntry instanceof ShareProposalCustomDTO){
				session.setCurrentViewBean(new ProposalSharingViewBean((ShareProposalCustomDTO)dataStoreEntry));
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
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_PROPOSAL_SHARING;
								break;
			
			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_PROPOSAL_SHARING;
								break;
		}
		
		return currentForwardName;
	}
	
	private ErrorReport validateUserSelection(ProposalSharingActionForm actionForm){
		ErrorReport errorReport = new ErrorReport();
		
		if(null != actionForm){
			Set userSet = new HashSet();
			
			String user = actionForm.getAccessUser1();
			if(null != user && !isSelectEmpty(user)){
				userSet.add(actionForm.getAccessUser1());
			}
			
			user = actionForm.getAccessUser2();
			if(null != user && !isSelectEmpty(user)){
				if(userSet.contains(user)){
					errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA41, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
				else{
					userSet.add(user);

					user = actionForm.getAccessUser3();
					if(null != user && !isSelectEmpty(user)){
						if(userSet.contains(user)){
							errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA41, OPPTMessageCatalog.TYPE_PRESENTATION), null);
						}
					}
				}
			}
		}
		
		return errorReport;
	}
}