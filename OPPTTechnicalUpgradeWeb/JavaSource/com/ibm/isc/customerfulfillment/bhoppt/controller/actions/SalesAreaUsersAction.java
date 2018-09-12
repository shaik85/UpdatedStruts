/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SalesAreaUsersActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.UserMaintenanceViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UsersCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class SalesAreaUsersAction extends OPPTLongAction 
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
		
		String salesArea;
		UsersCustomDTO customDto;
		UserInfoDataBean userInfo;
		ErrorReport errorReport=null;
		OPPTViewBean viewBean=null;
		boolean error = false;
		SalesAreaUsersActionForm actionForm;
		
		actionForm = (SalesAreaUsersActionForm)form;
		
		salesArea = actionForm.getSalesArea();
		userInfo = session.getUserInfo();
		customDto = getUserCustomDto(session);
		
		if(null == customDto.getSelectedSalesArea() || (null == salesArea && null != customDto.getSelectedSalesArea())){
			salesArea =userInfo.getPrimarySalesOrg();
		}
		
		if(null != salesArea && Constants.DEFAULT_SELECT.equalsIgnoreCase(salesArea)){
			error = true;
		}
		
		if(error){
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PAF37));
			setForwardName(session.getCurrentForward());
		}
		else{
			setTransactionInformation(customDto, session);
			customDto.setSelectedSalesArea(salesArea);

			try {
				customDto = getUserManager().listUsersInSalesOrg(customDto);
	
				viewBean = new UserMaintenanceViewBean(customDto);
				addDataStoreEntry(session, customDto);
				storeUserCustomDto(session, customDto);
				setForwardName(ForwardNameConstants.PAGE_USER_MAINTENACE);

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
	 * date Feb 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#isFirstActionOfProcess() 
	 * @return 
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
		return ForwardNameConstants.ACTION_USER_MAINTENACE;
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
		return ActionNameConstants.SALESAREA_USERS;
	}
	
	/**
	 *  
	 * Checks UsersCustomDTO in session. It returns the object if its present
	 * in session otherwise creates a new instance and returns. 
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

		if(null != session && session.getObjectFromSession(SessionConstants.SESSION_USER_LIST_DETAIL) != null){
			customDTO = (UsersCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_USER_LIST_DETAIL);
			customDTO.setUsers(null);
			customDTO.setMessageReport(null);
		}
		else{
			customDTO = new UsersCustomDTO();
		}

		return customDTO;
	}
	
	/**
	 *  
	 * Strore UsersCustomDTO in serssion
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
	 * @param session
	 * @param customDto
	 */
	private void storeUserCustomDto(OPPTSession session, UsersCustomDTO customDto){
		session.storeObjectToSession(SessionConstants.SESSION_USER_LIST_DETAIL,customDto);
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