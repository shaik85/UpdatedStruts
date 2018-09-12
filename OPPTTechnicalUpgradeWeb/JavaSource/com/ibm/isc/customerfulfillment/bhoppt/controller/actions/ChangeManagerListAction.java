/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.BPUserActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BPUserViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;

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
public class ChangeManagerListAction extends OPPTLongAction 
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
		CreateUserCustomDTO customDto=null;
		String accessType=null;
		ArrayList customerNumbers = null;
		HashMap legacyNos = null;
		BPUserActionForm actionForm;
		actionForm = (BPUserActionForm)form;
		String source = actionForm.getSource();
		String salesOrg = actionForm.getPrimarySalesOrganization();
		
		if("".equals(salesOrg) || "Select one".equalsIgnoreCase(salesOrg)){  //$NON-NLS-1$  //$NON-NLS-2$
			errorReport = new ErrorReport();
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF47, OPPTMessageCatalog.TYPE_PRESENTATION),null);
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(errorReport);
			if("edit".equalsIgnoreCase(source)){  //$NON-NLS-1$
				
				setForwardName("editbpuser");  //$NON-NLS-1$
			}
			else if("register".equalsIgnoreCase(source)){  //$NON-NLS-1$
				setForwardName("registerbpuser");  //$NON-NLS-1$
			}
			else{
				setForwardName("bpuser");  //$NON-NLS-1$
			}
				
		}
		else{
			customDto = getFromSession(session, source);
			setTransactionInformation(customDto, session);
			customDto.setPrimarySalesArea(salesOrg);
			try {
				customDto = getUserManager().processCreateNewUser(customDto);
				setInSession(customDto,session, source);
				errorReport = customDto.getMessageReport();
				if(null == errorReport){
					BPUserViewBean localBean;
					localBean = (BPUserViewBean)session.getCurrentViewBean();
					localBean.setManagers(customDto.getManagers());
					localBean.setPrimarySalesArea(salesOrg);
					localBean.setErrorReport(null);
					if("edit".equalsIgnoreCase(source)){  //$NON-NLS-1$
						setForwardName("editbpuser");  //$NON-NLS-1$
					}
					else if("register".equalsIgnoreCase(source)){  //$NON-NLS-1$
						setForwardName("registerbpuser");  //$NON-NLS-1$
					}
					else{
						setForwardName("bpuser");  //$NON-NLS-1$
					}
					viewBean = new BPUserViewBean(customDto);
					
					if("edit".equalsIgnoreCase(source)){  //$NON-NLS-1$
						setForwardName("editbpuser");  //$NON-NLS-1$
					}
					else if("register".equalsIgnoreCase(source)){  //$NON-NLS-1$
						setForwardName("registerbpuser");  //$NON-NLS-1$
					}
					else{
						setForwardName("bpuser");  //$NON-NLS-1$
					}
					viewBean = localBean;
				}
				else{
					viewBean = new MessageViewBean();
					viewBean.setErrorReport(errorReport);
					setForwardName("message");  //$NON-NLS-1$
				}

			}
			catch(ServiceException ex){
				viewBean = handleServiceException(session, ex.getErrorReport());
//				if(isBackEndError(ex.getErrorReport())){
//					viewBean = new ErrorViewBean();
//					viewBean.setErrorReport(ex.getErrorReport());
//					setForwardName("error");
//				}
//				else{
//					viewBean = session.getCurrentViewBean();
//					viewBean.setErrorReport(ex.getErrorReport());
//					if("edit".equalsIgnoreCase(source)){
//						setForwardName("editbpuser");
//					}
//					else if("register".equalsIgnoreCase(source)){
//						setForwardName("registerbpuser");
//					}
//					else{
//						setForwardName("bpuser");
//					}
//				}
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
		if("edit".equalsIgnoreCase(source)){  //$NON-NLS-1$
			customDto = (CreateUserCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_SELECTED_BP_USER_DETAIL);
		}
		else if("register".equalsIgnoreCase(source)){  //$NON-NLS-1$
			customDto = (CreateUserCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_REGISTER_USER_DETAIL);
		}
		else{
			customDto = (CreateUserCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_CREATE_USER_DETAIL);
		}
		return customDto;
	}
	
	private void setInSession(CreateUserCustomDTO customDto, OPPTSession session, String source){
		if(null != session){
			if("edit".equalsIgnoreCase(source)){  //$NON-NLS-1$
				session.storeObjectToSession(SessionConstants.SESSION_SELECTED_BP_USER_DETAIL, customDto);
			}
			else if("register".equalsIgnoreCase(source)){  //$NON-NLS-1$
				session.storeObjectToSession(SessionConstants.SESSION_REGISTER_USER_DETAIL, customDto);
			}
			else{
				session.storeObjectToSession(SessionConstants.SESSION_CREATE_USER_DETAIL, customDto);
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
