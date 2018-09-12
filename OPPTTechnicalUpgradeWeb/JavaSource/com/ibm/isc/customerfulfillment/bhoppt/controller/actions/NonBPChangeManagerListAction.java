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
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.NonBPUserActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.NonBPUserViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
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
public class NonBPChangeManagerListAction extends OPPTLongAction 
{
	/**
	 *  
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Feb 16, 2004 
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
		OPPTViewBean viewBean=null;
		ErrorReport errorReport=null;
		CreateUserCustomDTO customDto;
		NonBPUserActionForm actionForm;
		actionForm = (NonBPUserActionForm)form;
		String source = actionForm.getSource();
		String salesOrg = actionForm.getNonBPUserDataBean().getPrimarySalesOrganization();
		String userType = actionForm.getNonBPUserDataBean().getUserType();
		
		if("".equals(salesOrg) || "Select one".equalsIgnoreCase(salesOrg)){  //$NON-NLS-1$  //$NON-NLS-2$
			errorReport = new ErrorReport();
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF47, OPPTMessageCatalog.TYPE_PRESENTATION),null);
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(errorReport);
			if("create".equalsIgnoreCase(source)){  //$NON-NLS-1$
				setForwardName(ForwardNameConstants.PAGE_NON_BP_USER);
			}
			else if("edit".equalsIgnoreCase(source)){  //$NON-NLS-1$
				setForwardName(ForwardNameConstants.PAGE_EDIT_NON_BP_USER);
			}
			else{
				setForwardName(ForwardNameConstants.PAGE_REGISTER_NON_BP_USER);
			}
		}
		else{
			customDto = getFromSession(session, source);
			setTransactionInformation(customDto, session);
			customDto.setPrimarySalesArea(salesOrg);
			customDto.setUserType(userType);
			customDto.setSelectedRole(actionForm.getNonBPUserDataBean().getRole());
			try {
				customDto = getUserManager().processCreateNewUser(customDto);
				setInSession(customDto,session, source);
				errorReport = customDto.getMessageReport();
				if(null == errorReport){
					NonBPUserViewBean localBean = (NonBPUserViewBean)session.getCurrentViewBean();
					localBean.setManagers(customDto.getManagers());
					localBean.setGroups(customDto.getGroups());
					localBean.setPrimarySalesArea(customDto.getPrimarySalesArea());
					localBean.setSelectedRole(customDto.getSelectedRole());
					localBean.setErrorReport(null);
					if("create".equalsIgnoreCase(source)){  //$NON-NLS-1$
						setForwardName(ForwardNameConstants.PAGE_NON_BP_USER);
					}
					else if("edit".equalsIgnoreCase(source)){  //$NON-NLS-1$
						setForwardName(ForwardNameConstants.PAGE_EDIT_NON_BP_USER);
					}
					else{
						setForwardName(ForwardNameConstants.PAGE_REGISTER_NON_BP_USER);
					}
					viewBean = localBean;
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
		return ActionNameConstants.CHANGE_MANAGER_LIST;
	}

	private CreateUserCustomDTO getFromSession(OPPTSession session, String source){
		CreateUserCustomDTO customDto;
		if("create".equalsIgnoreCase(source)){  //$NON-NLS-1$
			customDto = (CreateUserCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_CREATE_USER_DETAIL);
		}
		else if("edit".equalsIgnoreCase(source)){  //$NON-NLS-1$
			customDto = (CreateUserCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_NON_BP_USER_DETAIL);
		}
		else{
			customDto = (CreateUserCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_REGISTER_USER_DETAIL);
		}
		return customDto;
	}
	
	private void setInSession(CreateUserCustomDTO customDto, OPPTSession session, String source){
		if(null != session){
			if("create".equalsIgnoreCase(source)){  //$NON-NLS-1$
				session.storeObjectToSession(SessionConstants.SESSION_CREATE_USER_DETAIL, customDto);
			}
			else if("edit".equalsIgnoreCase(source)){  //$NON-NLS-1$
				session.storeObjectToSession(SessionConstants.SESSION_NON_BP_USER_DETAIL, customDto);
			}
			else{
				session.storeObjectToSession(SessionConstants.SESSION_REGISTER_USER_DETAIL, customDto);
			}
		}
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
