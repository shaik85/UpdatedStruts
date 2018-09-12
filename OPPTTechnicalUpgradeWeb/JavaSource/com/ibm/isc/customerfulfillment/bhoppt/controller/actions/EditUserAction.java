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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.UserMaintenanceActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class EditUserAction extends OPPTLongAction 
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
		throws Exception {
			
		ErrorReport errorReport=null;
		OPPTViewBean viewBean=null;
		UsersCustomDTO customDto;
		UserCustomDTO userCustomDto;
		UserMaintenanceActionForm actionForm;
		
		BPUserCustomDTO bpUserCustomDto = new BPUserCustomDTO();
		setTransactionInformation(bpUserCustomDto, session);
		NonBPUserCustomDTO nonBPUserCustomDto = new NonBPUserCustomDTO();
//		Used for activity log, to get current login gec sec officer user id.
		nonBPUserCustomDto.setGeoSecOff(session.getUserInfo().getUserId());
		setTransactionInformation(nonBPUserCustomDto, session);
		
		actionForm = (UserMaintenanceActionForm)form;
		
		if(null == actionForm.getUserId() || 0 == actionForm.getUserId().trim().length()){
			viewBean = session.getCurrentViewBean();
			viewBean.setActionForm(actionForm);
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PAF43));
			setForwardName(session.getCurrentForward());
		}
		else{
			customDto = getUserCustomDto(session);
			userCustomDto = getSelectedUser(customDto, actionForm.getUserId());
			setUserCustomDtoInSession(userCustomDto, session);

			try {
				if(checkBPUser(userCustomDto)){
					populateBPUserCustomDto(bpUserCustomDto,userCustomDto);
					bpUserCustomDto = getUserManager().editBPUser(bpUserCustomDto);
		
					errorReport = bpUserCustomDto.getMessageReport();
					if(null == errorReport){
						viewBean = new BPUserViewBean(bpUserCustomDto);
						setBPUserCustomDtoInSession(bpUserCustomDto, session);
						addDataStoreEntry(session, bpUserCustomDto);
						setForwardName("editbpuser");  //$NON-NLS-1$
					}
					else{
						viewBean = new MessageViewBean();
						viewBean.setErrorReport(errorReport);
						setForwardName("message");  //$NON-NLS-1$
					}
				}
				else{
					populateNonBPUserCustomDto(nonBPUserCustomDto,userCustomDto);
					nonBPUserCustomDto = getUserManager().editNonBPUser(nonBPUserCustomDto);
		
					errorReport = nonBPUserCustomDto.getMessageReport();
					if(null == errorReport){
						viewBean = new NonBPUserViewBean(nonBPUserCustomDto);
						setNonBPUserCustomDtoInSession(nonBPUserCustomDto, session);
						addDataStoreEntry(session, nonBPUserCustomDto);
						setForwardName("editnonbpuser");  //$NON-NLS-1$
					}
					else{
						viewBean = new MessageViewBean();
						viewBean.setErrorReport(errorReport);
						setForwardName("message");  //$NON-NLS-1$
					}
				}
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
		return ActionNameConstants.EDIT_USER;
	}
	
	/**
	 *  
	 * Retrieve UsersCustomDTO from session
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 14, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param session
	 * @return
	 */
	private UsersCustomDTO getUserCustomDto(OPPTSession session){
		UsersCustomDTO customDTO = null;

		if(null != session){
			customDTO = (UsersCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_USER_LIST_DETAIL);
		}

		return customDTO;
	}
	
	/**
	 *  
	 * Extracts UsersCustomDTO object from TreeMap for given user
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDto
	 * @param userId
	 * @return
	 */
	private UserCustomDTO getSelectedUser(UsersCustomDTO customDto, String userId){
		TreeMap userList = customDto.getUsers();
		UserCustomDTO selectedUser;
		selectedUser = (UserCustomDTO)userList.get(userId);
		return selectedUser;
	}
	
	/**
	 *  
	 * Checks whether a user is BPUser or not.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param userCustomDto
	 * @return
	 */
	private boolean checkBPUser(UserCustomDTO userCustomDto){
		boolean result = false;
		if(RoleConstants.BUSINESS_PARTNER == userCustomDto.getRole()){
			result = true;
		}
		return result;
	}
	
	private void populateBPUserCustomDto(BPUserCustomDTO bpUserCustomDto, UserCustomDTO userCustomDto){
		bpUserCustomDto.setRole(userCustomDto.getRole());
		bpUserCustomDto.setUserId(userCustomDto.getUserId());
		bpUserCustomDto.setGroupName(userCustomDto.getGroup());
		bpUserCustomDto.setPrimarySalesArea(userCustomDto.getPrimarySalesOrg());
	}
	
	private void populateNonBPUserCustomDto(NonBPUserCustomDTO nonBPUserCustomDto,UserCustomDTO userCustomDto){
		nonBPUserCustomDto.setRole(userCustomDto.getRole());
		nonBPUserCustomDto.setUserId(userCustomDto.getUserId());
		nonBPUserCustomDto.setUserType(userCustomDto.getUserType());
		nonBPUserCustomDto.setBaUserRole(userCustomDto.getBaUserRole());
		nonBPUserCustomDto.setGroupName(userCustomDto.getGroup());
		nonBPUserCustomDto.setPrimarySalesArea(userCustomDto.getPrimarySalesOrg());
		nonBPUserCustomDto.setSelectedUserType(userCustomDto.getUserType());
	}
	
	private void setUserCustomDtoInSession(UserCustomDTO userCustomDto, OPPTSession session){
		if(null != session){
			session.storeObjectToSession(SessionConstants.SESSION_SELECTED_USER_DETAIL, userCustomDto);
		}
	}
	
	private void setBPUserCustomDtoInSession(BPUserCustomDTO userCustomDto, OPPTSession session){
		if(null != session){
			session.storeObjectToSession(SessionConstants.SESSION_SELECTED_BP_USER_DETAIL, userCustomDto);
		}
	}
	
	private void setNonBPUserCustomDtoInSession(NonBPUserCustomDTO nonBPUserCustomDto, OPPTSession session){
		if(null != session){
			session.storeObjectToSession(SessionConstants.SESSION_NON_BP_USER_DETAIL, nonBPUserCustomDto);
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
