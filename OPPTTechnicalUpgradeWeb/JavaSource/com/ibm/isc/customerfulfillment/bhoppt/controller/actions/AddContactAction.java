/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.Iterator;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationContactActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationDetailViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationCustomDTO;

/**
 * This is to set the C&N/Legal Contact and Accounting Contact to all the Modifcations 
 * 
 * @author Nayanatara L Pai
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AddContactAction extends OPPTLongAction {

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Sep 28, 2006 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Nayanatara L Pai
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
			throws Exception {
		
		OPPTViewBean viewBean = null;
		DisplayModificationDetailViewBean displayModificationDetailViewBean = null;
		ModificationContactActionForm actionForm =(ModificationContactActionForm)form;
		//session.storeObjectToSession(SessionConstants.SESSION_MODIFICATIONADDCONTACT_ACTIONFORM,actionForm);
		displayModificationDetailViewBean = new DisplayModificationDetailViewBean();
		session.storeObjectToSession(SessionConstants.SESSION_ACCOUNTING_CONTACT,actionForm.getAccountingContact());
		session.storeObjectToSession(SessionConstants.SESSION_LEGAL_CONTACT,actionForm.getLegalContact());
    	 BaseAgreementDetailsCustomDTO customDto = (BaseAgreementDetailsCustomDTO) session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
    	 customDto.setAccountingContactHdr(actionForm.getAccountingContact());
	     customDto.setLegalContactHdr(actionForm.getLegalContact());
    	TreeMap map = customDto.getModificationDetailsMap();
    	if(customDto.getModificationDetailsMap().size()!= 0){
	    	String key = null;
	    	ModificationCustomDTO  modificationCustomDTO = null;
	    	for(Iterator i = map.keySet().iterator();i.hasNext();){
	    		
	    	    key = (String)i.next();
	        	modificationCustomDTO =(ModificationCustomDTO) map.get(key);
	        	modificationCustomDTO.setLegalContract(actionForm.getLegalContact());
	        	modificationCustomDTO.setAccountingContact(actionForm.getAccountingContact());	
	    	}
	    	customDto.setModificationDetailsMap(map);
	    }
    
    	session.storeObjectToSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS,customDto);   
     DisplayModificationViewBean displayModificationViewBean = (DisplayModificationViewBean)session.getObjectFromSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN);
     TreeMap viewbeanMap = displayModificationViewBean.getSelectedModifications();
     String key1 = null;
      for(Iterator i = viewbeanMap.keySet().iterator();i.hasNext();){
     	key1= (String)i.next();
     	displayModificationDetailViewBean =(DisplayModificationDetailViewBean)viewbeanMap.get(key1);
     	displayModificationDetailViewBean.setLegalContact(actionForm.getLegalContact());
     	displayModificationDetailViewBean.setAccountingContact(actionForm.getAccountingContact());
      }
      	displayModificationViewBean.setActionForm(actionForm);
      	displayModificationViewBean.setSelectedModifications(viewbeanMap);
      	session.storeObjectToSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN,displayModificationViewBean);	
      	viewBean = displayModificationViewBean;	
      	setForwardName(ForwardNameConstants.PAGE_REFRESH_DETAILS_MODIFICATION);
		return viewBean;
	}

	 /** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Sep 28, 2006 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Nayanatara L Pai
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return String
	 * 
	 */
	protected String getActionName() {
		return ActionNameConstants.ADD_CONTACT_MODIFICATION;
	}

	 /**
     * validate current view bwan
     * 
     * 
     * @return
     * @author Nayanatara L Pai
     * @param session
     */
	protected boolean validateCurrentViewContent(OPPTSession session) {
		
		return true;
	}

}
