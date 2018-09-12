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

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementFormViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;

/**
 * BaseAgreementformAction
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date jun 19,2006
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Gavaskar Bhojan
 * 
 */
public class BaseAgreementformAction extends OPPTAction 
{
    /** 
     * Overridden method - Enter your description here. 
     * 
     * <br/><PRE> 
     * date jun 19,2006
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
    protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception
    {
        OPPTViewBean  viewBean = null ;  
        BaseAgreementFormViewBean baseAgreementFormviewBean = null;
        TreeMap FormDetailsMap = null;
        TreeMap coverageTypeMap = null;
        TreeMap salesOrgMap = null;
        TreeMap languageMap = null;
        String formNumber = null;
    try{
    	if(null != session.getObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS)) {
    		session.removeObjectFromSession(SessionConstants.SESSION_BASE_AGREEMENT_DETAILS);
    		session.removeObjectFromSession(SessionConstants.SESSION_ACCOUNTING_CONTACT);
    		session.removeObjectFromSession(SessionConstants.SESSION_LEGAL_CONTACT);
    	}
    	coverageTypeMap = new TreeMap();
    	FormDetailsMap = new TreeMap();
    	salesOrgMap = new TreeMap();
    	languageMap = new TreeMap();
    	coverageTypeMap.putAll(OPPTStaticDataHolder.coverageTypeMap);
    	Map map = OPPTStaticDataHolder.formNumberMap;
    	Iterator iterator = map.keySet().iterator();
    	if(iterator.hasNext()){
    		formNumber = (String)iterator.next();
    	}
    	FormDetailsMap.putAll(OPPTStaticDataHolder.formNumberMap);
    	salesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
       }catch(Exception e){
           e.printStackTrace();
           }
          baseAgreementFormviewBean = new BaseAgreementFormViewBean();
        if(null != coverageTypeMap){
            baseAgreementFormviewBean.setCoverageTypeDetails(coverageTypeMap);
            }
        if(null != FormDetailsMap){
            baseAgreementFormviewBean.setFormDetails(FormDetailsMap);
           }
        if(null != salesOrgMap){
            baseAgreementFormviewBean.setSalesOrg(salesOrgMap);
           }
        
        if(null != formNumber){
        	baseAgreementFormviewBean.setFormDetailKey(formNumber);
        }
        setForwardName(ForwardNameConstants.PAGE_CREATE_BASEAGREEMENT);
        session.setFirstActionForwardName(ForwardNameConstants.PAGE_SEARCH_BASEAGREEMENT);
        session.setCurrentForward(ActionNameConstants.CREATE_BASEAGREEMENT);
        viewBean = baseAgreementFormviewBean;
    	
	return viewBean;
    }
	/** 
	 * Returns action name 
	 * 
	 * <br/><PRE> 
	 * date jun 19,2006
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return String
	 * 
	 */
    protected String getActionName() {
        return  ActionNameConstants.CREATE_BASEAGREEMENT;
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
		String actualForward = ForwardNameConstants.PAGE_CREATE_BASEAGREEMENT;

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof BaseAgreementFormViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if (!valid) {
			session.setCurrentViewBean(new BaseAgreementFormViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}
		
		return valid;
	}
  
  }
    

