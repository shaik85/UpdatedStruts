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
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class RegisterBPUserAction extends OPPTLongAction 
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
			
		OPPTViewBean viewBean=null;
		ErrorReport errorReport=null;
		CreateUserCustomDTO customDto;
		BPUserViewBean bpViewBean;
		BPUserCustomDTO bpCustomDto;
		BPUserActionForm actionForm;
		actionForm = (BPUserActionForm)form;
		bpCustomDto = new BPUserCustomDTO();
		setTransactionInformation(bpCustomDto, session);
		
		bpViewBean = (BPUserViewBean)session.getCurrentViewBean();
		
		if(! bpViewBean.getPrimarySalesArea().equals(actionForm.getPrimarySalesOrganization())){
			errorReport = new ErrorReport();
			errorReport.put(new ErrorKey(ErrorCodeConstants.PA33, OPPTMessageCatalog.TYPE_PRESENTATION),null);
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(errorReport);
			setForwardName(ForwardNameConstants.PAGE_REGISTER_BP_USER);
		} 
		else{
			customDto = populateCustomDto(bpCustomDto, actionForm);

			if(RoleConstants.BUSINESS_PARTNER == Integer.parseInt(actionForm.getRole())){
				try {
					customDto = getUserManager().registerBPUser(bpCustomDto);
					errorReport = customDto.getMessageReport();
					if(null == errorReport){
						setForwardName(ForwardNameConstants.PAGE_LOGOUT);
					}
					else{
						MessageViewBean messageBean = new MessageViewBean(ForwardNameConstants.PAGE_REGISTER_BP_USER, true);
						messageBean.setRedirectTohomePage(true);
						messageBean.setErrorReport(errorReport);
						viewBean = messageBean;
						setForwardName(ForwardNameConstants.PAGE_MESSAGE);
					}
				}
				catch(ServiceException ex){
					viewBean = handleServiceException(session, ex.getErrorReport());
				}
			}
			else{
				customDto = getCreateUserCustomDto(actionForm, session);
				viewBean = new NonBPUserViewBean(customDto);
				setForwardName(ForwardNameConstants.PAGE_REGISTER_NON_BP_USER);
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
		return ActionNameConstants.REGISTER_BP_USER;
	}
	
	private BPUserCustomDTO populateCustomDto(BPUserCustomDTO customDto, BPUserActionForm actionForm){
		if("C".equalsIgnoreCase(actionForm.getAccessRequired())){  //$NON-NLS-1$
			customDto.setCustomerNumbers(getUserList(actionForm));
		}
		else{
			customDto.setLegacyNos(getUserLegacy(actionForm));
		}
		customDto.setAccessType(actionForm.getAccessRequired());
		customDto.setSelectedManager(actionForm.getManager());
		customDto.setUserId(actionForm.getUserId());
		customDto.setRole(Integer.parseInt(actionForm.getRole()));
		customDto.setPrimarySalesArea(actionForm.getPrimarySalesOrganization());

		return customDto;
	}

	/**
	 *  
	 * Retrieves data from String array, packs in ArrayList and returns
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param actionForm
	 * @return
	 */
	private ArrayList getUserList(BPUserActionForm actionForm){
		String[] listUser=null;
		ArrayList userList = null;
	
		listUser = actionForm.getListNumbers();
	
		if(null != listUser){
			int size = listUser.length;
			userList = new ArrayList();
			for(int i=0; i < size; i++){
				if(null != listUser[i] && !"".equals(listUser[i])){  //$NON-NLS-1$
					userList.add(listUser[i]);
				}
			}
		}
			
		return userList;
	}

	/**
	 *  
	 * Retrieves data from String array, packs in HashMap and returns
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param actionForm
	 * @return
	 */
	private HashMap getUserLegacy(BPUserActionForm actionForm){
		HashMap userLegacy = null;
		String []legacyNumber=null;
		String []sequenceNumber=null;

		legacyNumber = actionForm.getLegacyNumber();
		sequenceNumber = actionForm.getSequenceNumber();

		if(null != legacyNumber && null != sequenceNumber){
			int size = legacyNumber.length;
			userLegacy = new HashMap();
			for(int i=0; i < size; i++){
				if(null != legacyNumber[i]&& !"".equals(legacyNumber[i]) &&  //$NON-NLS-1$
					null != sequenceNumber[i] && !"".equals(sequenceNumber[i]))  //$NON-NLS-1$
				userLegacy.put(legacyNumber[i], sequenceNumber[i]);
			}
		}
		return userLegacy;
	}

	private CreateUserCustomDTO getCreateUserCustomDto(BPUserActionForm actionForm, OPPTSession session){
	
		CreateUserCustomDTO customDto = getFromSession(session);

		customDto.setSelectedRole(actionForm.getRole());
		customDto.setSelectedManager(actionForm.getManager());
		customDto.setPrimarySalesArea(actionForm.getPrimarySalesOrganization());
		customDto.setUserId(actionForm.getUserId());

		return customDto;
	}
	
	private CreateUserCustomDTO getFromSession(OPPTSession session){
		CreateUserCustomDTO customDto;
		customDto = (CreateUserCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_REGISTER_USER_DETAIL);

		return customDto;
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
