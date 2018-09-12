/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SignInViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.UserMaintenanceViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SigninCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;

/**
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 *
 * @author thirumalai
 */
public class SigninAction extends OPPTLongAction {
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
		if(null == session.getUserInfo()){
			session.setCurrentViewBean(new SignInViewBean());
		}

		// Changes for IIP starts
		//SigninActionForm actionForm = (SigninActionForm) form;
	//	ErrorReport report = actionForm.validate();
	//	if (null != report && 0 < report.size()) {
	//		viewBean = getSignInViewBean(session);
	//		viewBean.setErrorReport(report);
	//		setForwardName(session.getCurrentForward());
	//	} else {
			SigninCustomDTO customDto = new SigninCustomDTO();
			if(null == userId) {
			    // Will be your test id, please configure it for testing. 
		//  userId = "sateanne@in.ibm.com";  //$NON-NLS-1$
				// userId = "bprakash.p@in.ibm.com";
		//	userId = "saranya.m@in.ibm.com";
		//	userId = "subakshi@in.ibm.com"; 
		userId = "manoj.swain@in.ibm.com";
				//userId = "jsadhana@in.ibm.com";
				//userId = "sahshaik@in.ibm.com";
				//userId="GDBM2@pl.ibm.com";
				 //userId = "shwetrip@in.ibm.com";

			}
			customDto.setUserId(userId);
	//		customDto.setUserId(actionForm.getUserId().trim());
	//		customDto.setPassword(actionForm.getPassword().trim());
			// Changes for IIP ends
			try {

				customDto = getUserManager().signIn(customDto);
				if (customDto.isOPPTUser()) {
						int role = customDto.getRole();
						int baRole = customDto.getBaUserRole();
						String userType = customDto.getUserType();


						if(userType.equals(Constants.BASE_CONTRACT_USER))
						{
							switch (baRole) {
								case RoleConstants.READ_ONLY :
									setForwardName(ForwardNameConstants.PAGE_FORWARD_SEARCH_BASEAGREEMENT);
									break;
								case RoleConstants.READ_LIMITED :
									setForwardName(ForwardNameConstants.PAGE_FORWARD_SEARCH_BASEAGREEMENT);
									break;
								case RoleConstants.CREATE_UPDATE :
									setForwardName(ForwardNameConstants.PAGE_FORWARD_SEARCH_BASEAGREEMENT);
									break;
								case RoleConstants.BA_ADMINISTRATOR :
								    	setForwardName(ForwardNameConstants.PAGE_MODIFICATION_MAINTENANCE);
								    break;
							}	
						}
						else
						{	
							switch (role) {
								case RoleConstants.ADMINISTRATOR :
									setForwardName(ForwardNameConstants.ACTION_ADMINISTRATOR);
									viewBean = new UserMaintenanceViewBean();
									break;
								case RoleConstants.MARKETING_REP :
									setForwardName(ForwardNameConstants.ACTION_PROPOSAL_ADMINISTRATOR);
									break;
								case RoleConstants.PROPOSAL_APPROVER :
									setForwardName(ForwardNameConstants.ACTION_PROPOSAL_APPROVER);
									break;
								case RoleConstants.CSO :
									setForwardName(ForwardNameConstants.ACTION_PROPOSAL_ADMINISTRATOR);
									break;
								case RoleConstants.BUSINESS_PARTNER :
									setForwardName(ForwardNameConstants.ACTION_PROPOSAL_ADMINISTRATOR);
									break;
								case RoleConstants.MANAGER :
									ErrorReport errorReport = new ErrorReport();
									String[] msgStr = { userId};
									ErrorEntry errorEntry = new ErrorEntry(msgStr);
									errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA32, OPPTMessageCatalog.TYPE_PRESENTATION), errorEntry);
									MessageViewBean messageBean = new MessageViewBean();
									messageBean.setErrorReport(errorReport);
									messageBean.setRedirectTohomePage(true);
									viewBean = messageBean;
									setForwardName(ForwardNameConstants.PAGE_MESSAGE);
									break;
								case RoleConstants.CREATE_APPROVE :
									setForwardName(ForwardNameConstants.ACTION_PROPOSAL_CREATE_APPROVER);
									break;
								case RoleConstants.BHD :
									setForwardName(ForwardNameConstants.ACTION_PROPOSAL_ADMINISTRATOR);
									break;
									// DM Changes start-- Saheer Shaik
								case RoleConstants.OPPT_READ:
									setForwardName(ForwardNameConstants.ACTION_PROPOSAL_ADMINISTRATOR);
									break;

							// DM Changes start-- Nomita		
								case RoleConstants.DATA_MIGRATOR :

									setForwardName(ForwardNameConstants.ACTION_PROPOSAL_ADMINISTRATOR);
									break;
									// DM Changes end-- Nomita
								default :
									viewBean = new ErrorViewBean();
									setForwardName(ForwardNameConstants.PAGE_ERROR);
									break;
							}
						}		
					} else {
						setForwardName(ForwardNameConstants.ACTION_REGISTER_USER);
					}
					populateSession(customDto, session);
					setTransactionInformation(customDto, session);
			} catch (ServiceException ex) {
				viewBean = new ErrorViewBean(ex.getErrorReport(), session.getCurrentForward());
				setForwardName(ForwardNameConstants.PAGE_ERROR);
			}
//		}

		return viewBean;
	}

	private void populateSession(SigninCustomDTO customDto, OPPTSession session) {
		UserInfoDataBean userInfoBean = new UserInfoDataBean();
		userInfoBean.setRole(customDto.getRole());
		if (null != customDto.getPrimarySalesOrg()) {
			userInfoBean.setPrimarySalesOrg(customDto.getPrimarySalesOrg().trim());
		}
		if (null != customDto.getUserId()) {
			userInfoBean.setUserId(customDto.getUserId().trim());
		}
		if (null != customDto.getGroupName()) {
			userInfoBean.setGroupName(customDto.getGroupName().trim());
		}
		if (null != customDto.getEmailAddress()) {
			userInfoBean.setEmailAddress(customDto.getEmailAddress().trim());
		}
		if (null != customDto.getUserType()) {
			userInfoBean.setUserType(customDto.getUserType().trim());
		}
        userInfoBean.setBaRole(customDto.getBaUserRole());
		userInfoBean.setFirstName(customDto.getFirstName());
		userInfoBean.setLastName(customDto.getLastName());
		userInfoBean.setUserGroups(customDto.getUserGroups());
		session.setUserInfo(userInfoBean);
		session.finalize();
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
		return ActionNameConstants.SIGNIN;
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
		String actualForward = ForwardNameConstants.PAGE_SIGN_IN;

		if (null != viewBean && null != currentForward) {
			if (viewBean instanceof SignInViewBean && currentForward.equals(actualForward)) {
				valid = true;
			}
		}

		if (!valid) {
			session.setCurrentViewBean(new SignInViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}

		return valid;
	}

	private SignInViewBean getSignInViewBean(OPPTSession session) {
		SignInViewBean viewBean = (SignInViewBean) session.getCurrentViewBean();

		if (null == viewBean) {
			viewBean = new SignInViewBean();
		}

		return viewBean;
	}
} 