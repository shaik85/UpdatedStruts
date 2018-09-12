/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.GroupActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.GroupMaintenanceViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManagerHome;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class GroupMaintenanceAction extends OPPTLongAction 
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
			
		String salesArea;
		GroupsCustomDTO customDto;
		UserInfoDataBean userInfo;
		OPPTViewBean viewBean;
		GroupActionForm actionForm;

		actionForm = (GroupActionForm)form;
		userInfo = session.getUserInfo();
		
		salesArea = actionForm.getSalesArea();
		customDto = getFromSession(session);
		setTransactionInformation(customDto, session);
		
		if(salesArea == null || "".equals(salesArea)){  //$NON-NLS-1$
			salesArea =userInfo.getPrimarySalesOrg();
		}
		customDto.setSelectedSalesArea(salesArea);
		
		GroupManagerHome beanHome = (GroupManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("GroupManagerHome");  //$NON-NLS-1$
		
		GroupManager beanRemote = beanHome.create();
		
		try {
			customDto = beanRemote.listGroupsInSalesOrg(customDto);
		
			viewBean = new GroupMaintenanceViewBean(customDto);
			setToSession(session,customDto);
			setForwardName("grouplist");  //$NON-NLS-1$
		}
		catch(ServiceException se){
			viewBean = handleServiceException(session, se.getErrorReport());
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
		return ActionNameConstants.GROUP_MAINTENANCE;
	}
	
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Feb 4, 2004 
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
		return ForwardNameConstants.ACTION_GROUP_MAINTENANCE;
	}

	
	private GroupsCustomDTO getFromSession(OPPTSession session){
		GroupsCustomDTO customDto=null;
		if(null != session && null != session.getObjectFromSession(SessionConstants.SESSION_GROUP_LIST_DETAIL) ){
			customDto = (GroupsCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_GROUP_LIST_DETAIL);
			customDto.setGroups(null);
			customDto.setMessageReport(null);
		}
		else{
			customDto = new GroupsCustomDTO();
		}
			
		return customDto;
	}
	
	
	private void setToSession(OPPTSession session, GroupsCustomDTO customDto){
		session.storeObjectToSession(SessionConstants.SESSION_GROUP_LIST_DETAIL, customDto);
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
