/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationConstants;
import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementStatusConstant;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationTypeCodeActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationDetailViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ROLModificationCustomDTO;

/**
 * This is the search the Base agreement 
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class SaveEditedModificationAction extends OPPTLongAction {

    /** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Ravi Yandapalli
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
    protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)throws Exception {
    	ErrorReport errorReport = null;
		OPPTViewBean viewBean = null;
		SimpleDateFormat simpleDateFormat = null;
		Date rolStartDate = null;
		Date rolEndDate = null;
		ModificationTypeCodeActionForm modificationTypeCodeActionForm = null;
		DisplayModificationDetailViewBean displayModificationDetailViewBean = null;
		DisplayModificationViewBean displayModificationViewBean = (DisplayModificationViewBean)session.getObjectFromSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN);
		ModificationActionForm actionForm =(ModificationActionForm)form; 
		BaseAgreementDetailsCustomDTO baseAgreementDetailsCustomDTO = (BaseAgreementDetailsCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);	
		if(BaseAgreementModificationConstants.ROL.equals(actionForm.getModificationTypeCode())){
		    ROLModificationCustomDTO rOLCustomDto = new ROLModificationCustomDTO();
		    rOLCustomDto.setLegalContract(actionForm.getLegalContact());
		    rOLCustomDto.setAccountingContact(actionForm.getAccountingContact());
		    rOLCustomDto.setAccountingContact(actionForm.getAccountingContact());
		    if("true".equals(actionForm.getModifiedIBMLetterHead())) {
		    	rOLCustomDto.setModifiedLetterHead(UtilityConstants.YES);
		    }else {
		    	rOLCustomDto.setModifiedLetterHead(UtilityConstants.NO);
		    }
		    if("true".equals(actionForm.getRevenueRecognition())) {
		    	rOLCustomDto.setRevenueRecognition(UtilityConstants.YES);
		    }else {
		    	rOLCustomDto.setRevenueRecognition(UtilityConstants.NO);
		    }		    
		    rOLCustomDto.setModificationTypeCode(actionForm.getModificationTypeCode());
		   	simpleDateFormat  =  new SimpleDateFormat("MM/dd/yyyy");
		   
		    	if(null != actionForm.getRolStartDate()) {
		    		rolStartDate = simpleDateFormat.parse(actionForm.getRolStartDate());
		    	}
		    	if(null != actionForm.getRolEndDate() && actionForm.getRolEndDate().length() > 0) {
		    		rolEndDate = simpleDateFormat.parse(actionForm.getRolEndDate());
		    	}
		     
		    rOLCustomDto.setRolStartDate(rolStartDate);
		    rOLCustomDto.setRolEndDate(rolEndDate);
		    rOLCustomDto.setModificationOption(actionForm.getRolOptions());
		    rOLCustomDto.setAgreementId(actionForm.getagreementId());
		    rOLCustomDto.setDetails(actionForm.getDetails());
		    rOLCustomDto.setStatus(BaseAgreementStatusConstant.Active);
		    TreeMap selectedModificationsMap = baseAgreementDetailsCustomDTO.getModificationDetailsMap();
		    selectedModificationsMap.put(actionForm.getModificationTypeCode(),rOLCustomDto);
		    baseAgreementDetailsCustomDTO.setModificationDetailsMap(selectedModificationsMap);
			session.storeObjectToSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS,baseAgreementDetailsCustomDTO);
			displayModificationDetailViewBean= new DisplayModificationDetailViewBean(actionForm,BaseAgreementStatusConstant.Active);
			TreeMap selectedMap = displayModificationViewBean.getSelectedModifications();
			selectedMap.put(actionForm.getModificationTypeCode(),displayModificationDetailViewBean);//  selectedModificationsMap.put(actionForm.getModificationTypeCode(),displayModificationDetailViewBean);
			displayModificationViewBean.setSelectedModifications(selectedMap);
			session.storeObjectToSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN,displayModificationViewBean);
		}
		else
		{
		    ModificationCustomDTO modificationCustomDto = new ModificationCustomDTO();
		    modificationCustomDto.setLegalContract(actionForm.getLegalContact());
		    modificationCustomDto.setAccountingContact(actionForm.getAccountingContact());
		    modificationCustomDto.setAccountingContact(actionForm.getAccountingContact());
		    if("true".equals(actionForm.getModifiedIBMLetterHead())) {
		    	modificationCustomDto.setModifiedLetterHead(UtilityConstants.YES);
		    }else {
		    	modificationCustomDto.setModifiedLetterHead(UtilityConstants.NO);
		    }
		    if("true".equals(actionForm.getRevenueRecognition())) {
		    	modificationCustomDto.setRevenueRecognition(UtilityConstants.YES);
		    }else {
		    	modificationCustomDto.setRevenueRecognition(UtilityConstants.NO);
		    }	
		    modificationCustomDto.setAgreementId(actionForm.getagreementId());
		    modificationCustomDto.setDetails(actionForm.getDetails());
		    modificationCustomDto.setModificationTypeCode(actionForm.getModificationTypeCode());
		    modificationCustomDto.setStatus(BaseAgreementStatusConstant.Active);		  
		    TreeMap selectedModificationsMap = baseAgreementDetailsCustomDTO.getModificationDetailsMap();
		    selectedModificationsMap.put(actionForm.getModificationTypeCode(),modificationCustomDto);
		    baseAgreementDetailsCustomDTO.setModificationDetailsMap(selectedModificationsMap);
			session.storeObjectToSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS,baseAgreementDetailsCustomDTO);
			displayModificationDetailViewBean= new DisplayModificationDetailViewBean(actionForm,BaseAgreementStatusConstant.Active);
			TreeMap selectedMap = displayModificationViewBean.getSelectedModifications();
		    selectedMap.put(actionForm.getModificationTypeCode(),displayModificationDetailViewBean);
			displayModificationViewBean.setSelectedModifications(selectedMap);
			session.storeObjectToSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN,displayModificationViewBean);
		}
		viewBean = displayModificationViewBean;
//		 Added by Balaji for UI standards - Starts
	    BaseAgreementDetailsCustomDTO customDto = (BaseAgreementDetailsCustomDTO) session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
	    if(customDto != null && customDto.getAgreementId() > 0) {
	    	setForwardName(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION_FOR_AMEND);  //$NON-NLS-1$
	    	session.storeObjectToSession(SessionConstants.SESSION_AMEND_FLAG,new Boolean(true));
	    }else {
	    	setForwardName(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION);  //$NON-NLS-1$
	    }
	    // Added by Balaji for UI standards - Ends
		
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
	 * @author Ravi Yandapalli
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return String
	 * 
	 */
	protected String getActionName() {
		return ActionNameConstants.SAVE_EDIT_MODIFICATION;
	}

	  /**
     * validate current view bwan
     * 
     * 
     * @return
     * @author Ravi Yandapalli
     * @param session
     */  
    
	 protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = ForwardNameConstants.PAGE_DISPLAY_MODIFICATION;
//		 Added by Balaji for UI standards - Starts
	    BaseAgreementDetailsCustomDTO customDto = (BaseAgreementDetailsCustomDTO) session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
	    if(customDto != null && customDto.getAgreementId() > 0) {
	    	actualForward = ForwardNameConstants.PAGE_DISPLAY_MODIFICATION_FOR_AMEND;  //$NON-NLS-1$
	    	session.storeObjectToSession(SessionConstants.SESSION_AMEND_FLAG,new Boolean(true));
	    }else {
	    	actualForward = ForwardNameConstants.PAGE_DISPLAY_MODIFICATION;  //$NON-NLS-1$
	    }
	    // Added by Balaji for UI standards - Ends
		if(null != viewBean && null != currentForward){
			if(viewBean instanceof DisplayModificationViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}
		if (!valid) {
			TreeMap rolOptionsMap = new TreeMap();
			rolOptionsMap.putAll(OPPTStaticDataHolder.rolOptionsMap);
			DisplayModificationDetailViewBean displayModificationDetailViewBean = new DisplayModificationDetailViewBean();
			displayModificationDetailViewBean.setRolOptions(rolOptionsMap);
			session.setCurrentViewBean(displayModificationDetailViewBean);
			session.setCurrentForward(ForwardNameConstants.PAGE_EDIT_MODIFICATION_DETAILS);
			valid = true;
		}
		return valid;
	}
	 
}




