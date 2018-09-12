/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ibm.isc.customerfulfillment.bhoppt.controller.actions.AmendContractAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actions.AmendSWOAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actions.ChangeContractAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actions.CloseContractAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actions.ContractMaintenanceDateRangeAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actions.CreateVarianceAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actions.ExtendContractAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actions.ReplaceContractAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actions.SimulateVarianceAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.authorization.RoleAuthorization;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.ObjectCloner;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerHome;

/** 
 * This is the base class for all the actions that are involved in OPPT application. 
 * Before actual action is executed it does certain validation like checking if this 
 * action is the first action of the process. It is the first action of the process 
 * it clears the action data store. Then it checks if user has submitted the same form 
 * twice, if it detects double submition, it gets the last view bean and displays to 
 * the user. If no double submission it checks if user has performed back operation. 
 * If it detects the usage of back operation, it checks whether the back button usage 
 * is allowed for this particular action. If allowed it continues with the execution 
 * of the actual action logic. If back button usage is not allowed it throws an error 
 * page stating back button usage is not allowed for this particular action.
 * 
 * Once ofter completion of execution of actual action, it performs some operation like 
 * storing the last view bean, last action id, last action form etc into the session 
 * before throwing actual view the user.    
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 11, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */

public abstract class OPPTAction extends Action
{
	private String forwardName = "valid";  //$NON-NLS-1$
	private boolean firstActionOfProcess = false;
	private String[] BASE_ACTIONS = {ActionNameConstants.PROPOSAL_MAINTENANCE, ActionNameConstants.CONTRACT_MAINTENANCE, ActionNameConstants.PROPOSALS_FOR_APPROVAL};

	/**
	 * Overridden method - Overridden for managing the session information. It performs certain checks
	 * before giving control to the actual action logic.  
	 * 
	 * <br/><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse) 
	 * @param mapping ActionMapping value which holds all the action mapping setting done in struts-config.
	 * @param form ActionForm value which holds the form information that is assigned to this action.
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception 
	 *
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		try {
			executeLongAction(form, request.getSession());
		}
		catch(Exception e) {
			e.printStackTrace();
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,"OPPTAction","execute",null,e);  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$
			OPPTSession opptSession = new OPPTSession(request.getSession());
			ErrorViewBean viewBean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA00));
			opptSession.setCurrentMessageViewBean(viewBean);
			setForwardName(ForwardNameConstants.PAGE_ERROR);
		}

		if(!isFirstActionOfProcess() && form instanceof OPPTActionForm){
			((OPPTActionForm)form).reset();		
		}
		
		return mapping.findForward(forwardName);
	}
	/**
     * Helper method which actually checks for session management information. It performs 3 checks
     * before forwading the control to the actual action execution.
     * <p><ul>
     * 	<li>First it checks if the current action is first action of the process. It it is first action
     * of process it clears the action data store and sets the back button allowed flag.
     * 	<li>Then it checks if the user has submitted same form twice. If it detects the double submit,
     * it gets the last view bean from session and shows to the user
     * 	<li>Then it checks for the usage of back button. If back button is usage is detected, it checks
     * if this particular action allows the usage of back button. If back button usage is not allowed, it
     * shows a error page to the user stating back button usage is not allowed for this action. If back
     * button usage is allowed it continues with the actual execution of the action.
     * </ul></p>
     * After finishing with the actual action execution it sets some information regarding the current
     * action like last action id, action form, view bean etc. into the session.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 11, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param form ActionForm value which holds the form information that is assigned to this action.
     * @param session HttpSession reference to the current session object
     * @throws Exception
     * @concurrency $none
     */
	protected void executeLongAction(ActionForm form, HttpSession session) throws Exception
	{
		OPPTViewBean viewbean = null;

		synchronized (session.getId())
		{
			OPPTSession opptSession = new OPPTSession(session);
			if( "CancelRegistrationAction".equals(getActionName()) ||  //$NON-NLS-1$
				"HomePageAction".equalsIgnoreCase(getActionName()) ||  //$NON-NLS-1$
				"SubmitHomePageAction".equalsIgnoreCase(getActionName()) ||  //$NON-NLS-1$ 
				"SigninAction".equalsIgnoreCase(getActionName()))  //$NON-NLS-1$
			{
				viewbean = executeAction(form, opptSession);
			}
			else 
			{
				UserInfoDataBean userInfo = opptSession.getUserInfo();
				if(null != userInfo)
				{
					int role = userInfo.getRole();
					boolean checkRole = false;
					String userType=userInfo.getUserType()==null? "" : userInfo.getUserType(); 
					if(!userType.equals(Constants.BASE_CONTRACT_USER)) {
						checkRole = RoleAuthorization.getInstance().isRoleHasAccess(getActionName(), role);
					}
					else {
						checkRole = true;
					}
					if(checkRole)
					{
						// OPPTActionForm copyForm = (OPPTActionForm)BeanUtils.cloneBean(form);
						OPPTActionForm copyForm = (OPPTActionForm)ObjectCloner.deepCopy(form);
						
						if(isFirstActionOfProcess())
						{
							// reset BackButtonAllowed flag
							opptSession.setBackButtonAllowed(isBackButtonAllowed());
							
							// clear ActionDataStore
							if(isBaseAction()){
								opptSession.clearActionDataStore();
							}
							else{
								opptSession.clearActionDataStore(BASE_ACTIONS);
							}
						}
				
						// check for double submit
						if (opptSession.checkDoubleSubmit(getActionName(), copyForm))
						{
							viewbean = opptSession.getLastViewBean();
							viewbean.setErrorReport(null);
						}
						else
						{
							if (!opptSession.checkBackButton(getActionName(), isBackButtonAllowed())) 
							{
								viewbean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA02));
								setForwardName(ForwardNameConstants.PAGE_ERROR);
							}
							else
							{
								if(validateCurrentViewContent(opptSession)){
									ErrorReport errorReport = copyForm.validate();
									if(null != errorReport && 0 < errorReport.size()){
										viewbean = opptSession.getCurrentViewBean();
										viewbean.setActionForm(copyForm);
										viewbean.setErrorReport(errorReport);
										setForwardName(opptSession.getCurrentForward());
									}
									else{
										viewbean = opptSession.getCurrentViewBean();
										viewbean.setActionForm(copyForm);
										opptSession.setCurrentViewBean(viewbean);

										viewbean = executeAction(copyForm, opptSession);
										opptSession.setLastActionID(getActionName());
										if(null != viewbean){
											opptSession.setLastViewBean(viewbean);
										}
										opptSession.setLastActionForm(copyForm);
										opptSession.setBackButtonAllowed(isBackButtonAllowed());
										
										if(isFirstActionOfProcess()){
											if(null != getFirstActionForwardName()){
												opptSession.setFirstActionForwardName(getFirstActionForwardName());
											}
										}
									}
								}
								else{
									viewbean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA34));
									setForwardName(ForwardNameConstants.PAGE_ERROR);
								}
							}
						}
					}
					else
					{
						viewbean = new ErrorViewBean(getErrorReport(ErrorCodeConstants.PA01));
						setForwardName(ForwardNameConstants.PAGE_ERROR);
					}
					opptSession.finalize();
				}
				else
				{
					setForwardName(ForwardNameConstants.PAGE_INVALID_SESSION);
				}
			}
			if(null != viewbean){
				if(viewbean.isCurrentViewBean()){
					opptSession.setCurrentViewBean(viewbean);
					opptSession.setCurrentForward(getForwardName());
				}
				else{
					opptSession.setCurrentMessageViewBean(viewbean);
				}
			}
			else{
				opptSession.setCurrentForward(getForwardName());
			}
		}
	}

	/**
	 * All the subclasses should implement this method to provide the actual implementaion of the action.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param form ActionForm value which holds the form information that is assigned to this action.
	 * @param session OPPTSession wrapper to the HttpSession object
	 * @return OPPTViewBean
	 * @throws Exception
	 */
	protected abstract OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception;

	/**
	 * Returns the action name of the current action. All the subclasses should implement this method. 
	 * This acton name is used as key to populate the action data store. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String action name
	 */
	protected abstract String getActionName();
	
	/** 
	 * Check if the current view bean stored in session is what is expected. If it is not valid, 
	 * try to create the current view using the custom dto stored in session and set it as current 
	 * view. If current view cannot be created, return false. 
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
	protected abstract boolean validateCurrentViewContent(OPPTSession session);
	
	/**
	 * Returns true if back button is allowed for the current action. All the subclasses should
	 * override this method. execute method uses this method for checking usage of back button. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean whether usage of back button is allowed for this action.
	 */
	protected boolean isBackButtonAllowed() {
		return true;
	}
	
	/**
	 * Returns true if this action is the first action of the process. All subclasses should override 
	 * this method. execute method uses this method for clearing the action data store.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean whether this action is the first action of the process
	 */	
	protected boolean isFirstActionOfProcess() {
		return firstActionOfProcess;
	}

	/**
	 * Sets the first action of process value  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newFirstActionOfProcess boolean
	 */
	protected void setFirstActionOfProcess(boolean newFirstActionOfProcess) {
		firstActionOfProcess = newFirstActionOfProcess;;
	}

	/**
	 * Returns forward name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getForwardName() {
		return forwardName;
	}

	/**
	 * Sets forward name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newForwardName String 
	 */
	public void setForwardName(String newForwardName) {
		forwardName = newForwardName;
	}

	/**
     * setTransactionInformation
     * 
     * @param customDTO
     * @param session
     * @author thirumalai
     */
    protected void setTransactionInformation(OPPTCustomDTO customDTO, OPPTSession session){
		if(null != customDTO && null != session){
			UserInfoDataBean userInfo = session.getUserInfo();
			if(null != userInfo){
				customDTO.setUserInfo(userInfo.getGroupName(), userInfo.getUserId(), userInfo.getRole(), userInfo.getEmailAddress(), userInfo.getPrimarySalesOrg(),userInfo.getUserGroups());
				customDTO.setSelectedGroupName(userInfo.getSelectedGroup());
				customDTO.setFirstName(userInfo.getFirstName());
				customDTO.setLastName(userInfo.getLastName());
				if(null != userInfo.getSelectedGroup()) {
					customDTO.setSelectedGroupName(userInfo.getSelectedGroup());
				}
				
				customDTO.setBaUserRole(userInfo.getBaRole());
				customDTO.setUserType(userInfo.getUserType());
			}
			
			customDTO.setSessionId(session.getSessionId());
			customDTO.setTransactionName(getActionName());
		}
	}

	/**
     * addDataStoreEntry
     * 
     * @param opptSession
     * @param customDTO
     * @author thirumalai
     */
    protected void addDataStoreEntry(OPPTSession opptSession, OPPTCustomDTO customDTO){
		if(null != opptSession && null != getActionName()){
			opptSession.addDataStoreEntry(getActionName(), customDTO);
		}
	}

	/**
     * getErrorReport
     * 
     * @param errorId
     * @return
     * @author thirumalai
     */
    protected ErrorReport getErrorReport(String errorId)
	{
		ErrorReport errorReport = null;
		if(null != errorId){
			errorReport = new ErrorReport();
			errorReport.addErrorEntry(new ErrorKey(errorId, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		return errorReport;
	}
	
	/**
     * getProposalManager
     * 
     * @throws java.lang.Exception
     * @return
     * @author thirumalai
     */
    protected ProposalManager getProposalManager() throws Exception {
		ProposalManagerHome pcmHome = (ProposalManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("ProposalManagerHome");  //$NON-NLS-1$
		return pcmHome.create();
	}
	
	/**
     * getUserManager
     * 
     * @throws java.lang.Exception
     * @return
     * @author thirumalai
     */
    protected UserManager getUserManager() throws Exception {
		UserManagerHome userManagerHome = (UserManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("UserManagerHome");  //$NON-NLS-1$
		return userManagerHome.create();
	}
    
    /**
     * getBaseAgreementManager
     * 
     * @throws java.lang.Exception
     * @return
     * @author thirumalai
     */
    protected BaseAgreementManager getBaseAgreementManager() throws Exception {
    	BaseAgreementManagerHome bamHome = (BaseAgreementManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome(HomeProvider.BASE_AGREEMENT_REMOTE_HOME);  //$NON-NLS-1$
		return bamHome.create();
	}
	
	/**
     * isBackEndError
     * 
     * @param errorReport
     * @return
     * @author thirumalai
     */
    protected boolean isBackEndError(ErrorReport errorReport){
		boolean backEndError = false;
		
		if(null != errorReport){
			Iterator errorIterator = errorReport.keySet().iterator();
			while(errorIterator.hasNext()){
				ErrorKey errorKey = (ErrorKey)errorIterator.next();
				if(null != errorKey){
					if(errorKey.getErrorType() == OPPTMessageCatalog.TYPE_BACKEND && !(errorKey.getErrorId().equals("601"))){	
						backEndError = true;
						break;
					}
				}
			}
		}
		
		return backEndError;
	}
	
	/**
     * handleServiceException
     * 
     * @param session
     * @param errorReport
     * @return
     * @author thirumalai
     */
    protected OPPTViewBean handleServiceException(OPPTSession session, ErrorReport errorReport){
		return handleServiceException(session, errorReport, session.getCurrentForward());
	}
	
	/**
     * handleServiceException
     * 
     * @param session
     * @param errorReport
     * @param forwardName
     * @return
     * @author thirumalai
     */
    protected OPPTViewBean handleServiceException(OPPTSession session, ErrorReport errorReport, String forwardName){
		return handleServiceException(session, errorReport, session.getCurrentForward(), null);
	}

	/**
     * handleServiceException
     * 
     * @param session
     * @param errorReport
     * @param forwardName
     * @param initiator
     * @return
     * @author thirumalai
     */
    protected OPPTViewBean handleServiceException(OPPTSession session, ErrorReport errorReport, String forwardName, String initiator){
		OPPTViewBean viewBean = null;
		
		if(isBackEndError(errorReport)){
			viewBean = new ErrorViewBean(errorReport, initiator);
			setForwardName(ForwardNameConstants.PAGE_ERROR);
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(errorReport);
			setForwardName(forwardName);
		}
		
		return viewBean;
	}
    
    //  BH Wave1 - DAD003 - Complex Contract Identifiers - Begin - Manoj
    /**
     * handleServiceExceptionForMessage
     * 
     * @param session
     * @param errorReport
     * @param forwardName
     * @param initiator
     * @return
     * @author Manoj
     */
    protected OPPTViewBean handleServiceExceptionForMessage(OPPTSession session, ErrorReport messageReport, String forwardName, String initiator){
		OPPTViewBean viewBean = null;
		
		viewBean = new MessageViewBean(initiator);
		viewBean.setErrorReport(messageReport);
		setForwardName(ForwardNameConstants.PAGE_MESSAGE);
		
		
		return viewBean;
	}
    //  BH Wave1 - DAD003 - Complex Contract Identifiers - End - Manoj

	/**
     * handleMessageReport
     * 
     * @param messageReport
     * @return
     * @author thirumalai
     */
    protected OPPTViewBean handleMessageReport(ErrorReport messageReport){
		OPPTViewBean viewBean = new MessageViewBean();
		viewBean.setErrorReport(messageReport);
		setForwardName(ForwardNameConstants.PAGE_MESSAGE);
		return viewBean;
	}
	/**
     * handleErrorReport
     * 
     * @param errorReport
     * @return
     * @author thirumalai
     */
    protected OPPTViewBean handleErrorReport(ErrorReport errorReport){
		OPPTViewBean viewBean = new ErrorViewBean(errorReport);
		setForwardName(ForwardNameConstants.PAGE_ERROR);
		return viewBean;
	}

	/**
     * handleErrorReport
     * 
     * @param errorReport
     * @param initiator
     * @param forwardInitiator
     * @return
     * @author thirumalai
     */
    protected OPPTViewBean handleErrorReport(ErrorReport errorReport, String initiator, boolean forwardInitiator){
		OPPTViewBean viewBean = new ErrorViewBean(errorReport, initiator, forwardInitiator);
		setForwardName(ForwardNameConstants.PAGE_ERROR);
		return viewBean;
	}
	
	/**
     * handleErrorReport
     * 
     * @param session
     * @param errorReport
     * @return
     * @author thirumalai
     */
    protected OPPTViewBean handleErrorReport(OPPTSession session, ErrorReport errorReport){
		OPPTViewBean viewBean = null;
		
		if(isBackEndError(errorReport)){
			viewBean = new ErrorViewBean(errorReport);
			setForwardName(ForwardNameConstants.PAGE_ERROR);
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(errorReport);
		}
		
		return viewBean;
	}
	
	/**
     * getRole
     * 
     * @param session
     * @return
     * @author thirumalai
     */
    protected int getRole(OPPTSession session){
		int role = -1;
		if(null!= session){
			switch(session.getUserInfo().getRole())
			{
				case RoleConstants.BHD:
				case RoleConstants.OPPT_READ:
				case RoleConstants.CSO:
				case RoleConstants.MARKETING_REP:
				case RoleConstants.BUSINESS_PARTNER:
							role = Constants.PROPOSAL_ADMINISTRATOR;
							break;
				case RoleConstants.DATA_MIGRATOR :
					role = Constants.DATA_MIGRATOR;
					ContractMaintenanceDateRangeAction action = new ContractMaintenanceDateRangeAction();
					AmendContractAction action1 = new AmendContractAction();
					AmendSWOAction action2 = new AmendSWOAction();
					ChangeContractAction action3 = new ChangeContractAction();
					CloseContractAction action4 = new CloseContractAction();
					CreateVarianceAction action5 = new CreateVarianceAction();
					ExtendContractAction action6 = new ExtendContractAction();
					ReplaceContractAction action7 = new ReplaceContractAction();
					SimulateVarianceAction action8 = new SimulateVarianceAction();
					
					
					action.rol= 9;
					action1.rol= 9;
					action2.rol= 9;
					action3.rol= 9;
					action4.rol= 9;
					action5.rol= 9;
					action6.rol= 9;
					action7.rol= 9;
					action8.rol= 9;
					break;
				case RoleConstants.PROPOSAL_APPROVER:
							role = Constants.PROPOSAL_APPROVER;
							break;
				case RoleConstants.CREATE_APPROVE:
							role = Constants.PROPOSAL_CREATE_APPROVER;
							break;
				case RoleConstants.ADMINISTRATOR: 
							role = Constants.ADMINISTRATOR; 
							break;
			    default :
                    break;
            }
		}
		
		return role;
	}

	/**
     * isSelectEmpty
     * 
     * @param selectValue
     * @return
     * @author thirumalai
     */
    protected boolean isSelectEmpty(String selectValue){
		boolean empty = false;
		if(null == selectValue){
			empty = true;
		}
		else if(0 != selectValue.length() && selectValue.equalsIgnoreCase("Select one")){  //$NON-NLS-1$
			empty = true;
		}
		return empty;		
	}
	/**
     * isFieldEmpty
     * 
     * @param fieldValue
     * @return
     * @author thirumalai
     */
    protected boolean isFieldEmpty(String fieldValue){
		boolean empty = false;
		if(null == fieldValue){
			empty = true;
		}
		else if(0 == fieldValue.length()){
			empty = true;
		}
		return empty;		
	}
	
	/**
     * getFirstActionForwardName
     * 
     * @return
     * @author thirumalai
     */
    protected String getFirstActionForwardName(){
		return null;
	}

	/**
     * isDifferent
     * 
     * @param oldValue
     * @param newValue
     * @return
     * @author thirumalai
     */
    protected boolean isDifferent(String oldValue, String newValue){
		boolean different = true;
		
		if(null != oldValue){
			if(null != newValue){
				if(oldValue.equals(newValue)){
					different = false;
				}
			}
		}
		else{
			if(null == newValue){
				different = false;
			}
		}
		
		return different;
	}

	/**
     * getDoubleValue
     * 
     * @param stringValue
     * @return
     * @author thirumalai
     */
    protected double getDoubleValue(String stringValue){
		return getDoubleValue(stringValue, 0);
	}
	/**
     * getDoubleValue
     * 
     * @param stringValue
     * @param defaultValue
     * @return
     * @author thirumalai
     */
    protected double getDoubleValue(String stringValue, double defaultValue){
		double doubleValue = defaultValue;
		try{
			if(null != stringValue && 0 < stringValue.length()){
				doubleValue = Double.parseDouble(stringValue);
			}
		}
		catch(NumberFormatException ne){
			doubleValue = defaultValue;
		}
	
		return doubleValue;
	}
	
    /**
     * isBaseAction
     * 
     * @author thirumalai
     */
	private boolean isBaseAction(){
		boolean baseAction = false;
		
		for(int i=0, size=BASE_ACTIONS.length; i<size; i++){
			if(getActionName().equalsIgnoreCase(BASE_ACTIONS[i])){
				baseAction = true;
				break;
			}
		}
		
		return baseAction;
	}
}