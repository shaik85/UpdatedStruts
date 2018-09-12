/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.BaseAgreementActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CCMSApplyToBaseAgreementActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementFormViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CCMSCustomerSelectionViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;

/**
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CCMSApplyToBaseAgreementAction extends OPPTLongAction {

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
    protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
            throws Exception {
      
        OPPTViewBean  viewBean = null ; 
        CCMSApplyToBaseAgreementActionForm actionForm = null;
        BaseAgreementFormViewBean baseAgreementFormviewBean = null;
        MessageViewBean messageBean = null;
        TreeMap FormDetailsMap = null;
        TreeMap coverageTypeMap = null;
        TreeMap salesOrgMap = null;
        TreeMap languageMap = null;
        String formNumber = null;
        String sapCustomerNumber = null;
        String enterpriseNumber = null;
        String customerName = null;
        String countryCode = null;
        
        CCMSCustomerSelectionViewBean customerSelectionViewBean = null;
        BaseAgreementActionForm BAActionForm =new BaseAgreementActionForm(); 
        actionForm = (CCMSApplyToBaseAgreementActionForm)form;
       
            String details = actionForm.getSapCustomerNumber();
            StringTokenizer st = new StringTokenizer(details,"#");
       
       if(st.hasMoreTokens()){
           
           String count = st.nextToken();
           sapCustomerNumber=st.nextToken();
           enterpriseNumber=st.nextToken();
           customerName =st.nextToken();
           countryCode=st.nextToken();
       }
      
               BAActionForm.setCustomerNumber(sapCustomerNumber);
               BAActionForm.setEnterpriseNumber(enterpriseNumber);
               BAActionForm.setCustomerName(customerName);
               if(countryCode!=null && countryCode.length()!=0){
               if(countryCode.equals("897")){
                   BAActionForm.setSalesOrg("0147");
               }else{
                   if(countryCode.equals("649")){
                       BAActionForm.setSalesOrg("0026");
                   }
                  }
               }
    try{
    	
    	coverageTypeMap = new TreeMap();
    	FormDetailsMap = new TreeMap();
    	salesOrgMap = new TreeMap();
    	coverageTypeMap.putAll(OPPTStaticDataHolder.coverageTypeMap);
    	Map map = OPPTStaticDataHolder.formNumberMap;
    	Iterator iterator = map.keySet().iterator();
    	if(iterator.hasNext()){
    		formNumber = (String)iterator.next();
    	}
    	FormDetailsMap.putAll(OPPTStaticDataHolder.formNumberMap);
    	salesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
       }catch(Exception e){e.printStackTrace();}
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
        viewBean.setActionForm(BAActionForm);
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
       return ActionNameConstants.CCMS_APPLYTO_BASEAGREEMENT;
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
		String actualForward = ForwardNameConstants.PAGE_CCMSCUSTOMER_FETCH;

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof CCMSCustomerSelectionViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if (!valid) {
			session.setCurrentViewBean(new CCMSCustomerSelectionViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}
		
		return valid;
    }

}
