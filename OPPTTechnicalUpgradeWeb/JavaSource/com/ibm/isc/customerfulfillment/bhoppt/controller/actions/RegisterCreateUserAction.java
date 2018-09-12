/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CreateUserActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateUserCustomDTO;
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
 * date Jan 2, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */
public class RegisterCreateUserAction extends OPPTLongAction 
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
	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction#executeAction(org.apache.struts.action.ActionForm, com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession)
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
		throws Exception {
		OPPTViewBean viewBean=null;
		ErrorReport errorReport=null;
		CreateUserCustomDTO customDto;
		CreateUserActionForm actionForm;
		
		actionForm = (CreateUserActionForm)form; 
		
		customDto =  getFromSession(session);
		setTransactionInformation(customDto, session);
		customDto.setUserType(actionForm.getUserDataBean().getUserType());
		customDto.setSelectedUserType(actionForm.getUserDataBean().getUserType());
		customDto.setPrimarySalesArea(actionForm.getUserDataBean().getPrimarySalesOrganization());
		customDto.setUserId(actionForm.getUserDataBean().getUserId());
	
		try {
			customDto = getUserManager().processCreateNewUser(customDto);
			errorReport = customDto.getMessageReport();
			if(null == errorReport){
				setToSession(customDto, session);
		    	viewBean = new NonBPUserViewBean(customDto);
				setForwardName(ForwardNameConstants.PAGE_REGISTER_NON_BP_USER);
//				if(RoleConstants.BUSINESS_PARTNER == Integer.parseInt(actionForm.getUserDataBean().getRole())){
//					viewBean = new BPUserViewBean(customDto);
//					setForwardName(ForwardNameConstants.PAGE_REGISTER_BP_USER);
//				}
//				else{
//   			    viewBean = new NonBPUserViewBean(customDto);
//					setForwardName(ForwardNameConstants.PAGE_REGISTER_NON_BP_USER);
//				}
			}
			else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(errorReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);
			}

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
		return ActionNameConstants.REGISTER_CREATE_USER;
	}
	
	private CreateUserCustomDTO getFromSession(OPPTSession session){
		CreateUserCustomDTO customDto;
		customDto = (CreateUserCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_REGISTER_USER_DETAIL);
	
		return customDto;
	}
	
	private void setToSession(CreateUserCustomDTO customDto, OPPTSession session){
		if(null != session){
			session.storeObjectToSession(SessionConstants.SESSION_REGISTER_USER_DETAIL,customDto);
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