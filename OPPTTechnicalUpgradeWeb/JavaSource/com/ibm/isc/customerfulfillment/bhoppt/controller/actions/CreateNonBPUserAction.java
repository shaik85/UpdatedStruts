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
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class CreateNonBPUserAction extends OPPTLongAction 
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
		NonBPUserCustomDTO nonBPCustomDto;
		CreateUserCustomDTO customDto;
		NonBPUserActionForm actionForm;
		NonBPUserViewBean nonBpViewBean;

		nonBPCustomDto = new NonBPUserCustomDTO();
//		Used for activity log, to get current login gec sec officer user id.
		nonBPCustomDto.setGeoSecOff(session.getUserInfo().getUserId());
	
		actionForm = (NonBPUserActionForm)form; 
		nonBpViewBean = (NonBPUserViewBean)session.getCurrentViewBean();
try{
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
			setForwardName(ForwardNameConstants.PAGE_NON_BP_USER);
		} 
		else{
			setTransactionInformation(nonBPCustomDto, session);
			nonBPCustomDto = populateCustomDto(nonBPCustomDto, actionForm);

			if(RoleConstants.BUSINESS_PARTNER == Integer.parseInt(actionForm.getNonBPUserDataBean().getRole())){
				customDto = getCreateUserCustomDto(actionForm, session);
				viewBean = new BPUserViewBean(customDto);
				setForwardName(ForwardNameConstants.PAGE_BP_USER);
			}
			else{
	
				try {
					nonBPCustomDto = getUserManager().createNonBPUser(nonBPCustomDto);
					errorReport = nonBPCustomDto.getMessageReport();
					if(null == errorReport){
						setForwardName(ForwardNameConstants.ACTION_ADMINISTRATOR);
					}
					else{
						viewBean = new MessageViewBean(ForwardNameConstants.PAGE_NON_BP_USER, true);
						viewBean.setErrorReport(errorReport);
						setForwardName(ForwardNameConstants.PAGE_MESSAGE);
					}

				}
				catch(ServiceException ex){
					viewBean = handleServiceException(session, ex.getErrorReport());
				}
			}
		}
	}catch(Exception e){
		    e.printStackTrace();
		}
		
		
		return viewBean;
	}
	
	private NonBPUserCustomDTO populateCustomDto(NonBPUserCustomDTO customDto, NonBPUserActionForm actionForm){
		TreeMap accessSalesOrg;
		String[] salesAreas=null;
		String[] accessTypes=null;
		String primarySalesArea;
		String primaryAccessType;
		String userType;
		
		primarySalesArea = actionForm.getNonBPUserDataBean().getPrimarySalesOrganization();
		primaryAccessType = actionForm.getNonBPUserDataBean().getPrimaryAccessType();
		userType = actionForm.getNonBPUserDataBean().getUserType();
		customDto.setUserId(actionForm.getNonBPUserDataBean().getUserId());
		customDto.setPrimarySalesArea(primarySalesArea);
		customDto.setUserType(userType);
		customDto.setPrimarySalesAreaAuthorization(primaryAccessType);
		customDto.setSelectedManager(actionForm.getNonBPUserDataBean().getManager());
		accessSalesOrg = new TreeMap();

		if(actionForm.getNonBPUserDataBean().getUserType().equals(Constants.SOFTWARE_USER))
		{	
			customDto.setSelectedRole(actionForm.getNonBPUserDataBean().getRole());
			salesAreas = actionForm.getNonBPUserDataBean().getSalesArea();
			accessTypes = actionForm.getNonBPUserDataBean().getAccessType();
			int strLength = accessTypes.length;
			for(int i=0; i < strLength; i++){
				if(!Constants.DEFAULT_SELECT.equalsIgnoreCase(salesAreas[i])&& !"".equalsIgnoreCase(accessTypes[i])){  //$NON-NLS-1$
					accessSalesOrg.put(salesAreas[i], accessTypes[i] );
				}
			}
			accessSalesOrg.put(primarySalesArea, primaryAccessType);
			customDto.setSalesAreaAccessType(accessSalesOrg);
			customDto.setSelectedGroups(toTreeSet(actionForm.getNonBPUserDataBean().getGroupName()));
		} else {
			accessSalesOrg.put(primarySalesArea, primaryAccessType);
			customDto.setSelectedBaRole(actionForm.getNonBPUserDataBean().getRole());
			customDto.setSalesAreaAccessType(accessSalesOrg);
		}
		return customDto;
	}
	
	private CreateUserCustomDTO getCreateUserCustomDto(NonBPUserActionForm actionForm, OPPTSession session){
		
		CreateUserCustomDTO customDto = getFromSession(session);
	
		customDto.setSelectedRole(String.valueOf(RoleConstants.BUSINESS_PARTNER));
		customDto.setSelectedManager(actionForm.getNonBPUserDataBean().getManager());
		customDto.setPrimarySalesArea(actionForm.getNonBPUserDataBean().getPrimarySalesOrganization());
		customDto.setUserId(actionForm.getNonBPUserDataBean().getUserId());
		
		return customDto;
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
		return ActionNameConstants.CREATE_NONBPUSER;
	}
	
	private CreateUserCustomDTO getFromSession(OPPTSession session){
		CreateUserCustomDTO customDto;
		customDto = (CreateUserCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_CREATE_USER_DETAIL);
	
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
