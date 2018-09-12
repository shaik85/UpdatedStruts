/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.Iterator;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.UserMaintenanceActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.TransferProposalsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.UserMaintenanceViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 *  
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 10, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */

public class TransferProposalsAction extends OPPTLongAction 
{
 
	/** 
	 * Overridden method - Enter your description here. 
	 * tu 
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
		
		ErrorReport errorReport=null;
		OPPTViewBean viewBean=null;
		TransferProposalsCustomDTO customDto = new TransferProposalsCustomDTO();
		setTransactionInformation(customDto, session);
	
		UserMaintenanceActionForm actionForm = (UserMaintenanceActionForm)form;
		
		if(null == actionForm.getUserId() || 0 == actionForm.getUserId().trim().length()){
			viewBean = session.getCurrentViewBean();
			viewBean.setActionForm(actionForm);
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PAF43));
			setForwardName(session.getCurrentForward());
		}
		else{
			UserCustomDTO userCustomDto =  getUserCustomDto(session,actionForm.getUserId(),customDto);
		
			customDto.setSelectedSalesArea(userCustomDto.getSalesOrg());

			customDto.setSourceUser(userCustomDto);
			storeInSession(userCustomDto, session);

			try {
				customDto = getProposalManager().getTargetUsers(customDto);
				addDataStoreEntry(session, customDto);
				saveUserProposals(session, customDto);
				viewBean = new TransferProposalsViewBean(customDto);
				setForwardName(ForwardNameConstants.PAGE_TRANSFER_PROPOSAL);
			}
			catch(ServiceException ex){
				viewBean = handleServiceException(session, ex.getErrorReport());
			}
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
		return ActionNameConstants.TRANSFER_PROPOSALS;
	}
	
	private void saveUserProposals(OPPTSession session, TransferProposalsCustomDTO customDto){
		if(null != session){
			session.storeObjectToSession(SessionConstants.SESSION_TRANSFER_PROPOSAL_DETAIL,customDto);
		}
	}
	
	private UserCustomDTO getUserCustomDto(OPPTSession session, String selectedUser, 
		TransferProposalsCustomDTO transferDto){
		UserCustomDTO customDto;
		UsersCustomDTO usersCustomDto = (UsersCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_USER_LIST_DETAIL);
		transferDto.setSalesAreas(formatSalesArea(usersCustomDto.getSalesAreas()));
		customDto = (UserCustomDTO)usersCustomDto.getUsers().get(selectedUser);
		return customDto;
		
	}
	
	private TreeMap formatSalesArea(TreeMap salesArea){
		TreeMap newSalesArea = new TreeMap();
		Iterator itr = salesArea.keySet().iterator();
		while(itr.hasNext()){
			String key = (String)itr.next();
			String value = (String)salesArea.get(key);
			value = value + " - " + key;  //$NON-NLS-1$
			newSalesArea.put(key, value);
		}
		return newSalesArea;
	}
	
	private void storeInSession(UserCustomDTO userCustomDto, OPPTSession session){
		session.storeObjectToSession(SessionConstants.SESSION_SINGLE_USER_DETAIL,userCustomDto);
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
		String actualForward = ForwardNameConstants.PAGE_USER_MAINTENACE;

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof UserMaintenanceViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.SALESAREA_USERS);
			if(null != dataStoreEntry && dataStoreEntry instanceof UsersCustomDTO){
				session.setCurrentViewBean(new UserMaintenanceViewBean((UsersCustomDTO)dataStoreEntry));
				session.setCurrentForward(actualForward);
				valid = true;
			}
		}
		
		return valid;
	}

}
