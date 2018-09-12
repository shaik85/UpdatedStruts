/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.Iterator;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.TransferSalesOrgActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.TransferProposalsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.TransferProposalsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UsersCustomDTO;
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

public class TransferSalesOrgAction extends OPPTLongAction 
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
		TransferSalesOrgActionForm actionForm = (TransferSalesOrgActionForm)form;
		
		
		UserCustomDTO userCustomDto =  getUserFromSession(session);
		userCustomDto.setSalesOrg(actionForm.getSalesArea());

		customDto.setSourceUser(userCustomDto);
		customDto.setSelectedSalesArea(actionForm.getSalesArea());
		populateSalesAreaList(customDto, session);

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
		return ActionNameConstants.TRANSFER_SALES_ORG;
	}
	
	private UserCustomDTO getUserCustomDto(OPPTSession session, String selectedUser){
		UserCustomDTO customDto;
		UsersCustomDTO usersCustomDto = (UsersCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_USER_LIST_DETAIL);
		
		customDto = (UserCustomDTO)usersCustomDto.getUsers().get(selectedUser);
		
		return customDto;
		
	}
	
	private UserCustomDTO getUserFromSession(OPPTSession session){
		UserCustomDTO customDto;
		customDto = (UserCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_SINGLE_USER_DETAIL);
		return customDto;
	}
	
	private void populateSalesAreaList(TransferProposalsCustomDTO customDto, OPPTSession session){
		UsersCustomDTO usersCustomDto = (UsersCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_USER_LIST_DETAIL);
		customDto.setSalesAreas(formatSalesArea(usersCustomDto.getSalesAreas()));
	}
	
	private void saveUserProposals(OPPTSession session, TransferProposalsCustomDTO customDto){
		if(null != session){
			session.storeObjectToSession(SessionConstants.SESSION_TRANSFER_PROPOSAL_DETAIL,customDto);
		}
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