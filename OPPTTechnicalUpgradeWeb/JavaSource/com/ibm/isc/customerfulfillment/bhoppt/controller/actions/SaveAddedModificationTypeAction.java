/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;



import java.util.StringTokenizer;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ChangeModificationTypeActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationTypesListViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationTypesViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO;

/**
 * This is save added modification type
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SaveAddedModificationTypeAction extends OPPTLongAction {

    /** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Sep 11,2006 
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
    protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
        OPPTViewBean viewBean = null;
        ErrorReport errorReport = null;
        String salesOrganisation= null;
        ChangeModificationTypeActionForm actionForm = null;
        ModificationTypeCustomDTO customDTO = null;
        ModificationTypesListViewBean modificationTypesListViewBean = null;
        actionForm = (ChangeModificationTypeActionForm)form;
        modificationTypesListViewBean = (ModificationTypesListViewBean)session.getObjectFromSession(SessionConstants.SESSION_MODIFICATION_TYPELIST_VIEWBEAN);
        String salesOrg =modificationTypesListViewBean.getSelectedSalesOrg();
        StringTokenizer salesOrgToken = new StringTokenizer(salesOrg,"-");  /* NOI18N */
        while(salesOrgToken.hasMoreTokens()){
            salesOrgToken.nextToken();
            salesOrganisation = salesOrgToken.nextToken();
        }
        customDTO = new ModificationTypeCustomDTO ();
        customDTO.setSelectedSalesOrg(salesOrganisation);
        customDTO.setTypeCode(actionForm.getTypeCode());
        customDTO.setDescription(actionForm.getDescription());
        setTransactionInformation(customDTO,session);
        try{
       customDTO = getBaseAgreementDataManager().addModificationType(customDTO);
            errorReport = customDTO.getMessageReport();
        if(null == errorReport){
		     setForwardName(ForwardNameConstants.PAGE_REFRESH_MODIFICATION_MAINTENANCE);  //$NON-NLS-1$
		}
        else{
		    viewBean = new MessageViewBean();
		    viewBean.setErrorReport(errorReport);
			setForwardName(ForwardNameConstants.PAGE_ADD_MODIFICATION_TYPE);  //$NON-NLS-1$
		}
        
       }catch(ServiceException ex){
		 viewBean = handleServiceException(session, ex.getErrorReport());
		}
        return viewBean;
    }
    
    /**
     * getUserManager
     * 
     * @throws java.lang.Exception
     * @return BaseAgreementManager
     * @author Ravi Yandapalli
     */
    protected BaseAgreementDataManager getBaseAgreementDataManager() throws Exception {
        BaseAgreementDataManagerHome baseAgreementDataManagerHome = (BaseAgreementDataManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("BaseAgreementDataManagerHome");  //$NON-NLS-1$
		return baseAgreementDataManagerHome.create();
	}
    
    /** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Sep 11,2006 
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
		return ActionNameConstants.SAVE_ADDMODIFICATION_TYPE;
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
		String actualForward = ForwardNameConstants.PAGE_ADD_MODIFICATION_TYPE;

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof ModificationTypesViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if (!valid) {
			session.setCurrentViewBean(new ModificationTypesViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}
		
		return valid;
    }

}
