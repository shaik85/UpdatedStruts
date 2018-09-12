/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SearchListActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementDetailViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SearchBaseAgreementViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO;

/**
 * AmendbaseAgreementAction
 * 
 * <br/><b>Known Bugs </b> <br/>
 * 
 * <br/>
 * 
 * <PRE>
 * 
 * date jun 21,2006
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
public class AmendBaseAgreementAction extends OPPTLongAction{
    /** 
	 * Overridden method - it returns the baseagreementviewbean 
	 * 
	 * <br/><PRE> 
	 * date jun 21 , 2006 
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
    	TreeMap formDetailsMap = new TreeMap();
        TreeMap coverageTypeMap = new TreeMap();
        TreeMap salesOrgMap = new TreeMap();
        ErrorReport errorReport = null;
		OPPTViewBean viewBean =  null;
		 String formNumber = null;
		 BaseAgreementDetailViewBean baseAgreementDetailViewBean = null;
		BaseAgreementDetailsCustomDTO customDto=null;
		SearchListActionForm actionForm = (SearchListActionForm)form;
		session.storeObjectToSession(SessionConstants.SESSION_SEARCHLIST_ACTIONFORM,actionForm);
		customDto = new BaseAgreementDetailsCustomDTO();
		customDto.setAgreementId(actionForm.getAgreementId());
		setTransactionInformation(customDto, session);
		try {
			if(null != session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS)) {
	    		session.removeObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
	    	}
			
		    customDto = getBaseAgreementManager().getBaseAgreement(customDto);
		    // Added by Balaji for validating for Amend
		    customDto.setTransactionName(ActionNameConstants.AMEND_BASEAGREEMENT);
		    errorReport = customDto.getMessageReport();
		    if(null == errorReport){
				storeInSession(customDto, session);
				baseAgreementDetailViewBean = new BaseAgreementDetailViewBean(customDto);
										
				
				coverageTypeMap.putAll(OPPTStaticDataHolder.coverageTypeMap);
				
		    	Map map = OPPTStaticDataHolder.formNumberMap;
		    	Iterator iterator = map.keySet().iterator();
		    	if(iterator.hasNext()){
		    		formNumber = (String)iterator.next();
		    	}
		    	
		      	formDetailsMap.putAll(OPPTStaticDataHolder.formNumberMap);
		       	salesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
		       	if(null != coverageTypeMap){
					baseAgreementDetailViewBean.setCoverageTypeMap(coverageTypeMap);
				
		            }
		        if(null != formDetailsMap){
		        	baseAgreementDetailViewBean.setFormDetailsMap(formDetailsMap);
		           }
		        if(null != salesOrgMap){
		        	baseAgreementDetailViewBean.setSalesOrgMap(salesOrgMap);
		            }
		        
		        if(null != formNumber){
		        	baseAgreementDetailViewBean.setFormDetailKey(formNumber);
		        }
		        viewBean = baseAgreementDetailViewBean;
				setForwardName(ForwardNameConstants.PAGE_AMEND_BASEAGREEMENT); 
				session.setCurrentForward(ForwardNameConstants.PAGE_AMEND_BASEAGREEMENT);
		        session.setFirstActionForwardName(ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT);
			}
			else{
			   	    
				viewBean =  new MessageViewBean();
				viewBean.setErrorReport(errorReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);  //$NON-NLS-1$
			}
    }catch(ServiceException ex){
		viewBean = handleServiceException(session, ex.getErrorReport());
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
		 * @author Ravi Yandapalli
		 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
		 * @return String
		 * 
		 */
		protected String getActionName() {
			return ActionNameConstants.AMEND_BASEAGREEMENT;
		}
		
		/**
	     * getUserManager
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
	    
	    private void storeInSession(BaseAgreementDetailsCustomDTO baseAgreementDetailsCustomDto, OPPTSession session){
			session.storeObjectToSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS,baseAgreementDetailsCustomDto);
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
			String actualForward = ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT;

			if(null != viewBean && null != currentForward){
				if(viewBean instanceof SearchBaseAgreementViewBean && currentForward.equals(actualForward)){
					valid = true;
				}
			}

			if (!valid) {
				session.setCurrentViewBean(new SearchBaseAgreementViewBean());
				session.setCurrentForward(actualForward);
				valid = true;
			}
			
			return valid;
		}

    
    
}


