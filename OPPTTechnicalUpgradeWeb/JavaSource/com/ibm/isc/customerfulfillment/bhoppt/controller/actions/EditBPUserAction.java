/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.*;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.BPUserActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BPUserViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class EditBPUserAction extends OPPTLongAction 
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
		BPUserCustomDTO customDto;
		BPUserActionForm actionForm;
		BPUserViewBean bpViewBean;

		customDto = new BPUserCustomDTO();
		setTransactionInformation(customDto, session);
		actionForm = (BPUserActionForm)form; 
		bpViewBean = (BPUserViewBean)session.getCurrentViewBean();

		if(!(bpViewBean.getPrimarySalesArea().equals(actionForm.getPrimarySalesOrganization()))){
			errorReport = new ErrorReport();
			errorReport.put(new ErrorKey(ErrorCodeConstants.PA33, OPPTMessageCatalog.TYPE_PRESENTATION),null);
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(errorReport);
			setForwardName(ForwardNameConstants.PAGE_EDIT_BP_USER);
		} 
		else{
			customDto = populateCustomDto(customDto, actionForm, session);
		
			try {
				customDto = getUserManager().saveEditBPUser(customDto);
				errorReport = customDto.getMessageReport();
				if(null == errorReport){
					setForwardName(ForwardNameConstants.ACTION_ADMINISTRATOR);
				}
				else{
					viewBean = new MessageViewBean(ForwardNameConstants.PAGE_EDIT_BP_USER, true);
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
		return ActionNameConstants.EDIT_BPUSER;
	}
	
	
	private BPUserCustomDTO populateCustomDto(BPUserCustomDTO customDto, BPUserActionForm actionForm, OPPTSession session){	
		if("C".equalsIgnoreCase(actionForm.getAccessRequired())){  //$NON-NLS-1$
			customDto.setCustomerNumbers(getUserList(actionForm));
		}
		else{
			customDto.setLegacyNos(getUserLegacy(actionForm));
		}
		customDto.setAccessType(getCustomDtoFromSession(session).getAccessType());
		customDto.setSelectedManager(actionForm.getManager());
		customDto.setUserId(getCustomDtoFromSession(session).getUserId());
		customDto.setRole(Integer.parseInt(actionForm.getRole()));
		customDto.setPrimarySalesArea(actionForm.getPrimarySalesOrganization());
	
		return customDto;
	}
	
	private BPUserCustomDTO getCustomDtoFromSession(OPPTSession session){
		return (BPUserCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_SELECTED_BP_USER_DETAIL);
	
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
		String actualForward = ForwardNameConstants.PAGE_EDIT_BP_USER;

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof BPUserViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.EDIT_USER);
			if(null != dataStoreEntry && dataStoreEntry instanceof BPUserCustomDTO){
				session.setCurrentViewBean(new BPUserViewBean((BPUserCustomDTO)dataStoreEntry));
				session.setCurrentForward(actualForward);
				valid = true;
			}
		}

		return valid;
	}
}
