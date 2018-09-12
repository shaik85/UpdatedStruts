/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.BaseAgreementActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationContactActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementDetailViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementFormViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationDetailViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ROLModificationCustomDTO;

/**
 * DisplayModificationAction
 * 
 * <br/><b>Known Bugs </b> <br/>
 * 
 * <br/>
 * 
 * <PRE>
 * 
 * date jun 20,2006
 * 
 * revision date author reason
 * 
 * </PRE>
 * 
 * <br/>
 * 
 * @author Gavaskar Bhojan
 *  
 */

public class DisplayModificationAction extends OPPTLongAction {
    /** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date jun 22, 2006
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Gavaskar Bhojan
	 * @param form ActionForm
	 * @param session OPPTSession
	 * @return OPPTViewBean
	 * @throws Exception 
	 * 
	 */
    protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
            throws Exception {
          	    	
    	OPPTViewBean viewBean = null;
        BaseAgreementDetailsCustomDTO customDto = null;
        DisplayModificationViewBean displayModificationViewBean = null;
        ErrorReport errorReport = null;
        Date acceptedDate = null;
        Date expirationDate = null;
        SimpleDateFormat format = null;
        TreeMap modificationTypeMap = new TreeMap();
        
        boolean amend = false;
	    String currentForward = session.getCurrentForward();
	    if(currentForward != null && currentForward.equals(ForwardNameConstants.PAGE_AMEND_BASEAGREEMENT)) {
	    	amend = true;
	    }
	    
        
        BaseAgreementActionForm baseAgreementActionForm	=(BaseAgreementActionForm)form;
        BaseAgreementDetailsCustomDTO sessionCustomDto = (BaseAgreementDetailsCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
          
        if(null != sessionCustomDto) {
        	customDto = sessionCustomDto;
        	
        }else {
        	customDto = new BaseAgreementDetailsCustomDTO(); 
        }
	    format = new SimpleDateFormat("MM/dd/yyyy");  /* NOI18N */
	    try
		{
		    acceptedDate = format.parse(baseAgreementActionForm.getAcceptedDate());
		}catch (Exception e)
		  { }
        customDto.setAcceptedDate(acceptedDate);
        customDto.setFormNumber(baseAgreementActionForm.parseFormNumber(baseAgreementActionForm.getFormNo()));
		// For Sales Org
        StringTokenizer tok = new StringTokenizer(baseAgreementActionForm.getSalesOrg(),"-");  /* NOI18N */
        while(tok.hasMoreTokens()) {
        	customDto.setSalesOrganization(tok.nextToken());
        	// The last token is the actual value
        }
        if(amend) {
        	customDto.setAgreementId(baseAgreementActionForm.getAgreementId());
        }else {
        	customDto.setAgreementId(0);
        }
		customDto.setAgreementNumber(baseAgreementActionForm.getAgreementNumber());
		customDto.setAgreementStatus(baseAgreementActionForm.getAgreementStatus());
		customDto.setBranchOffice(baseAgreementActionForm.getBranchOffice());
		customDto.setCoverageType(baseAgreementActionForm.getCoverageType());
		customDto.setCreatedBy(baseAgreementActionForm.getCreatedBy());
		customDto.setCustomerName(baseAgreementActionForm.getCustomerName());
		customDto.setCustomerNumber(baseAgreementActionForm.getCustomerNumber());
		customDto.setCustomerRepresentative(baseAgreementActionForm.getCustomerRepresentive());
		customDto.setEnterpriseNumber(baseAgreementActionForm.getEnterpriseNumber());
		customDto.setEnterpriseName(baseAgreementActionForm.getEnterpriseName());
		customDto.setEntryDate(new Date());
		customDto.setFileNumber(baseAgreementActionForm.getFileNo());
		customDto.setFormLongDescription(baseAgreementActionForm.getFormLongDescripton());
		customDto.setFormShortDescription(baseAgreementActionForm.getFormShortDescripton());
		customDto.setImageReferenceNumber(baseAgreementActionForm.getImageReferenceNumber());
		customDto.setIsElectronicSumbmitter(baseAgreementActionForm.getIsElectronicSubmitter());
		customDto.setLegacyCustomerNumber(baseAgreementActionForm.getLegacyCustomerNumber());
		customDto.setInac(baseAgreementActionForm.getInac());
		
		
		if(null == customDto.getModificationDetailsMap()) {
			customDto.setModificationDetailsMap(new TreeMap());
		}
		customDto.setIsModified("N");  /* NOI18N */
		
		try{
	    	if(null != baseAgreementActionForm.getExpirationDate()){
	    		expirationDate = format.parse(baseAgreementActionForm.getExpirationDate());
	    	}
		}catch(Exception e)
		{ }
		customDto.setExpirationDate(expirationDate);
		
		
		setTransactionInformation(customDto, session);
        
        try {
            
            customDto = getBaseAgreementManager().validateAgreementHeader(customDto);
			errorReport = customDto.getMessageReport();
			if(null == errorReport){
				session.storeObjectToSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS,customDto);
				
				 modificationTypeMap.putAll(OPPTStaticDataHolder.modificationTypeMap);
				

				TreeMap selectedModificationsMap = customDto.getModificationDetailsMap();
                displayModificationViewBean = new DisplayModificationViewBean();
               if (null != modificationTypeMap) {
               		displayModificationViewBean.setModificationTypes(modificationTypeMap);
               }
               if(null != selectedModificationsMap){
                  displayModificationViewBean.setSelectedModifications(convertToViewBeanMap(selectedModificationsMap));  
               }
               //Start changes Nayanatara L Pai
               ModificationContactActionForm  modificationContactActionForm = new ModificationContactActionForm();
               modificationContactActionForm.setAccountingContact(customDto.getAccountingContactHdr());
               modificationContactActionForm.setLegalContact(customDto.getLegalContactHdr());
               displayModificationViewBean.setActionForm(modificationContactActionForm);
               //End changes Nayanatara L Pai
               storeInSession(displayModificationViewBean, session);
               viewBean = displayModificationViewBean;
               // Changes by Balaji -  starts
               if(amend && customDto.getAgreementId() > 0) {
               		setForwardName(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION_FOR_AMEND);
               		session.storeObjectToSession(SessionConstants.SESSION_AMEND_FLAG,new Boolean(true));
               }else {
               		setForwardName(ForwardNameConstants.PAGE_DISPLAY_MODIFICATION);
               }
               // Changes by Balaji -  ends
			}
             else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(errorReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);  //$NON-NLS-1$
			}
	
		}
		catch(ServiceException ex){
			viewBean = handleServiceException(session, ex.getErrorReport());
			
		}
     
        return viewBean;
    }

    /**
     * Returns action name
     * 
     * <br/>
     * 
     * <PRE>
     * 
     * date jun 19,2006
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br/>
     * 
     * @see com.ibm.support.oppt.OPPTAction#getActionName()
     * @return String
     *  
     */

    private TreeMap convertToViewBeanMap(TreeMap selectedModificationsMap) {
    	
    	Iterator modificationDetailsIterator = selectedModificationsMap.keySet().iterator();
        TreeMap displayModificationviewbeanmap = new TreeMap();
         
        while (modificationDetailsIterator.hasNext()) {
          String key = (String) modificationDetailsIterator.next();
          DisplayModificationDetailViewBean displayModificationDetailViewBean = null;
          if(BaseAgreementModificationConstants.ROL.equals(key)) {
          	ROLModificationCustomDTO rOLModificationDTO = (ROLModificationCustomDTO)selectedModificationsMap.get(key);
          	displayModificationDetailViewBean = new DisplayModificationDetailViewBean(rOLModificationDTO);
          	
          }else {
          	ModificationCustomDTO modificationDTO = (ModificationCustomDTO)selectedModificationsMap.get(key);
          	displayModificationDetailViewBean = new DisplayModificationDetailViewBean(modificationDTO);
          	
          } 
          displayModificationviewbeanmap.put(key,displayModificationDetailViewBean);
         }
    	TreeMap viewBeanmap = new TreeMap();
    	return displayModificationviewbeanmap;
    	
    }

    /**
     * Returns action name
     * 
     * <br/>
     * 
     * <PRE>
     * 
     * date jun 19,2006
     * 
     * revision date author reason
     * 
     * </PRE>
     * 
     * <br/>
     * 
     * @see com.ibm.support.oppt.OPPTAction#getActionName()
     * @return String
     *  
     */
    protected String getActionName() {
        return ActionNameConstants.DISPLAY_MODIFICATION;
    }

     /**
     * getBaseAgreementManager
     * 
     * @throws java.lang.Exception
     * @return BaseAgreementManager
     * @author Ravi Yandapalli
     */
    protected BaseAgreementManager getBaseAgreementManager() throws Exception {
        BaseAgreementManagerHome baseAgreementManagerHome = (BaseAgreementManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("BaseAgreementManagerHome");  //$NON-NLS-1$
		return baseAgreementManagerHome.create();
	}
    /**
     * store in session
     * 
     * @author Ravi Yandapalli
     * @param session
     */
    
    private void storeInSession(DisplayModificationViewBean viewBean, OPPTSession session){
		session.storeObjectToSession(SessionConstants.DISPLAY_MODIFICATION_VIEWBEAN,viewBean);
	}
    /** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Jul 07, 2006 
	 * 
	 * revision date author reason 
	 * @author Gavaskar Bhojan
	 * </PRE><br/> 
	 * 
	 * @param session
	 * @return 
	 * 
	 */
    protected boolean validateCurrentViewContent(OPPTSession session) {
    	
    	// This page can be reached from Baseagreement creat/amend and also from addmodification, view and edit
    	
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String forwardToAmend = null;
		String forwardCreate = null;
		String actualForward = null;
		if(null != viewBean && null != currentForward && currentForward.equals(ForwardNameConstants.PAGE_CREATE_BASEAGREEMENT)){
			    forwardCreate = ForwardNameConstants.PAGE_CREATE_BASEAGREEMENT;
			    actualForward = forwardCreate;
				if(viewBean instanceof BaseAgreementFormViewBean && currentForward.equals(actualForward)){
				valid = true;
				
			}
		
		else {
			 	session.setCurrentViewBean(new BaseAgreementFormViewBean());
				session.setCurrentForward(actualForward);
				valid = true;
			}
	 }
		if(null != viewBean && null != currentForward && currentForward.equals( ForwardNameConstants. PAGE_AMEND_BASEAGREEMENT)){ 
			forwardToAmend = ForwardNameConstants. PAGE_AMEND_BASEAGREEMENT;
			actualForward = forwardToAmend ;
			if(viewBean instanceof BaseAgreementDetailViewBean && currentForward.equals(actualForward)){
			   valid = true;
			   
			}
		else
		{
			session.setCurrentViewBean(new BaseAgreementDetailViewBean());
		    session.setCurrentForward(actualForward);
		    valid = true;
		}

	}		

		
		
		return valid;
	}

}