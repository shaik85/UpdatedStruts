/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.NonBPUserActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.NonBPUserViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class EditNonBPUserAction extends OPPTLongAction 
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
		TreeMap accessSalesOrg;
		OPPTViewBean viewBean=null;
		ErrorReport errorReport=null;
		NonBPUserCustomDTO customDto;
		NonBPUserActionForm actionForm;
		NonBPUserViewBean nonBpViewBean;
		customDto = new NonBPUserCustomDTO();
		setTransactionInformation(customDto, session);
		actionForm = (NonBPUserActionForm)form;
		nonBpViewBean = (NonBPUserViewBean)session.getCurrentViewBean();
//		Used for activity log, to get current login gec sec officer user id.
		customDto.setGeoSecOff(session.getUserInfo().getUserId());
		if((((nonBpViewBean.getSelectedRole()!=null) && !nonBpViewBean.getSelectedRole().equals(actionForm.getNonBPUserDataBean().getRole())) || (! nonBpViewBean.getPrimarySalesArea().equals(actionForm.getNonBPUserDataBean().getPrimarySalesOrganization())))&& ((nonBpViewBean.getSelectedUserType().equals(Constants.SOFTWARE_USER)))){
		    errorReport = new ErrorReport();    
	     	   if(((nonBpViewBean.getSelectedRole()!=null) && !nonBpViewBean.getSelectedRole().equals(actionForm.getNonBPUserDataBean().getRole()))){
	     	      errorReport.put(new ErrorKey(ErrorCodeConstants.PA52, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		       }
        		if((! nonBpViewBean.getPrimarySalesArea().equals(actionForm.getNonBPUserDataBean().getPrimarySalesOrganization()))&& (nonBpViewBean.getSelectedUserType().equals(Constants.SOFTWARE_USER))){
		    	   errorReport.put(new ErrorKey(ErrorCodeConstants.PA33, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}		
         	viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(errorReport);
			setForwardName(ForwardNameConstants.PAGE_EDIT_NON_BP_USER);
		} 
		else{
			customDto = populateCustomDto(customDto, actionForm, session);

			try {
				customDto = getUserManager().saveEditNonBPUser(customDto);
				errorReport = customDto.getMessageReport();
				if(null == errorReport){
					setForwardName(ForwardNameConstants.ACTION_ADMINISTRATOR);
				}
				else{
					viewBean = new MessageViewBean(ForwardNameConstants.PAGE_EDIT_NON_BP_USER, true);
					viewBean.setErrorReport(errorReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);
				}
			}
			catch(ServiceException se){
				viewBean = handleServiceException(session, se.getErrorReport(), session.getCurrentForward(), session.getCurrentForward());
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
		return ActionNameConstants.EDIT_NONBP_USER;
	}

	private NonBPUserCustomDTO populateCustomDto(NonBPUserCustomDTO customDto, NonBPUserActionForm actionForm, OPPTSession session){
		TreeMap accessSalesOrg;
		String[] salesAreas=null;
		String[] accessTypes=null;
		String primarySalesArea;
		String primaryAccessType;
		String userType;

		primarySalesArea = actionForm.getNonBPUserDataBean().getPrimarySalesOrganization();
		primaryAccessType = actionForm.getNonBPUserDataBean().getPrimaryAccessType();
		userType = actionForm.getNonBPUserDataBean().getUserType();
		customDto.setUserId(getCustomDtoFromSession(session).getUserId());
		customDto.setUserType(userType);
		customDto.setPrimarySalesArea(primarySalesArea);
		customDto.setPrimarySalesAreaAuthorization(primaryAccessType);
		customDto.setSelectedManager(actionForm.getNonBPUserDataBean().getManager());
		accessSalesOrg = new TreeMap();
		if(userType.equals(Constants.SOFTWARE_USER))
		{
			customDto.setSelectedRole(actionForm.getNonBPUserDataBean().getRole());
			salesAreas = actionForm.getNonBPUserDataBean().getSalesArea();
			accessTypes = actionForm.getNonBPUserDataBean().getAccessType();
			int strLength = accessTypes.length;
			for(int i=0; i < strLength; i++){
				if(!Constants.DEFAULT_SELECT.equalsIgnoreCase(salesAreas[i]) && !Constants.DEFAULT_SELECT.equalsIgnoreCase(accessTypes[i])){
					accessSalesOrg.put(salesAreas[i], accessTypes[i] );
				}
			}
			accessSalesOrg.put(primarySalesArea, primaryAccessType);
//			customDto.setSelectedGroup(actionForm.getNonBPUserDataBean().getGroupName());
			customDto.setSelectedGroups(toTreeSet(actionForm.getNonBPUserDataBean().getGroupName()));
			customDto.setSalesAreaAccessType(accessSalesOrg);

		} else {
			customDto.setSelectedBaRole(actionForm.getNonBPUserDataBean().getRole());
			accessSalesOrg.put(primarySalesArea, primaryAccessType);
			customDto.setSalesAreaAccessType(accessSalesOrg);
		}
		return customDto;
	}
	
	
	private UserCustomDTO getCustomDtoFromSession(OPPTSession session){
		return (UserCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_SELECTED_USER_DETAIL);
		
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
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = ForwardNameConstants.PAGE_EDIT_NON_BP_USER;

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof NonBPUserViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.EDIT_USER);
			if(null != dataStoreEntry && dataStoreEntry instanceof NonBPUserCustomDTO){
				session.setCurrentViewBean(new NonBPUserViewBean((NonBPUserCustomDTO)dataStoreEntry));
				session.setCurrentForward(actualForward);
				valid = true;
			}
		}
		
		return valid;
	}
	private TreeSet toTreeSet(String stringArray []) {
		TreeSet set = new TreeSet();
		if(stringArray != null) {
			for(int i=0;i<stringArray.length;i++) {
				set.add(stringArray[i]);
			}
		}
		return set;
	}
}