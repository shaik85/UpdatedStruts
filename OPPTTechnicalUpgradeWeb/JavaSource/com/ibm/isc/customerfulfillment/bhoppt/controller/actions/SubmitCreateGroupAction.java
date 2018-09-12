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
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateGroupCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.GroupManagerHome;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class SubmitCreateGroupAction extends OPPTLongAction 
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
			
		GroupActionForm actionForm;
		OPPTViewBean viewBean=null;
		CreateGroupCustomDTO customDto;
		ErrorReport prerequisiteError;
		boolean error = false;
	
		actionForm = (GroupActionForm)form;
		customDto = new CreateGroupCustomDTO();
		prerequisiteError = new ErrorReport();
		
		if(null == actionForm.getGroupName() || 0 == actionForm.getGroupName().trim().length()){
			prerequisiteError.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF36, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			error = true;
		}

		if(null == actionForm.getSalesArea() || "Select one".equalsIgnoreCase(actionForm.getSalesArea())){  //$NON-NLS-1$
			prerequisiteError.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF37, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			error = true;
		}

		if(error){
			viewBean = session.getCurrentViewBean();
			viewBean.setActionForm(actionForm);
			viewBean.setErrorReport(prerequisiteError);
			setForwardName(session.getCurrentForward());
		}
		else{
			setTransactionInformation(customDto, session);
		
			customDto.setGroupName(actionForm.getGroupName());
			customDto.setSelectedSalesArea(actionForm.getSalesArea());


			GroupManagerHome beanHome = (GroupManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("GroupManagerHome");  //$NON-NLS-1$
			GroupManager beanRemote = beanHome.create();

			try {
				customDto = beanRemote.createGroup(customDto);
				ErrorReport errorReport = null;

				errorReport = customDto.getMessageReport();
				if(null == errorReport){
					setForwardName(ForwardNameConstants.ACTION_GROUP_MAINTENANCE);
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
		return ActionNameConstants.SUBMIT_CREATE_GROUP;
	}

	
	/** 
	 * Overridden method - Usage of back button is not allowed for this action. So return false. 
	 * 
	 * <br/><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#isBackButtonAllowed() 
	 * @return 
	 * 
	 */
	protected boolean isBackButtonAllowed() {
		return false;
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