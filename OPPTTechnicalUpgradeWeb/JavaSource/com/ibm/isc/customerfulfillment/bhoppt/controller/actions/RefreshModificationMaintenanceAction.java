/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SalesOrgActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationTypesListViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypesCustomDTO;

/**
 * This is the modification maintenance 
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RefreshModificationMaintenanceAction extends OPPTLongAction {

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
    protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)throws Exception {
        OPPTViewBean viewBean = null;
        ErrorReport errorReport = null;
        ModificationTypesCustomDTO modificationTypesCustomDTO = null;
        SalesOrgActionForm actionForm = null;
        String salesOrg = null; 
        actionForm=(SalesOrgActionForm)session.getObjectFromSession(SessionConstants.SESSION_SALESORG_ACTIONFORM);
        salesOrg = actionForm.getSalesOrganization();
        modificationTypesCustomDTO = new ModificationTypesCustomDTO();
        modificationTypesCustomDTO.setSalesOrg(salesOrg);
        try {
            modificationTypesCustomDTO = getBaseAgreementDataManager().getAllModificationTypes(modificationTypesCustomDTO);
            errorReport = modificationTypesCustomDTO.getMessageReport();
			setTransactionInformation(modificationTypesCustomDTO,session);
			if(null == errorReport){
			    viewBean = new ModificationTypesListViewBean(modificationTypesCustomDTO);
			    setForwardName(ForwardNameConstants.MODIFICATION_MAINTENANCE);  //$NON-NLS-1$
			}
			else{
			    viewBean = new MessageViewBean();
			    viewBean.setErrorReport(errorReport);
				setForwardName(ForwardNameConstants.PAGE_MODIFICATION_MAINTENANCE);  //$NON-NLS-1$
			}
		}catch(ServiceException ex){
		    viewBean = handleServiceException(session, ex.getErrorReport());
		}
		session.storeObjectToSession(SessionConstants.SESSION_MODIFICATION_TYPES_CUSTOMDTO,modificationTypesCustomDTO);
		session.storeObjectToSession(SessionConstants.SESSION_MODIFICATION_TYPELIST_VIEWBEAN,viewBean);
		session.storeObjectToSession(SessionConstants.SESSION_SALESORG_ACTIONFORM,actionForm);
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
		return ActionNameConstants.MODIFICATION_MAINTENANCE;
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
		String actualForward = ForwardNameConstants.MODIFICATION_MAINTENANCE;
		if(null != viewBean && null != currentForward){
			if(viewBean instanceof ModificationTypesListViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}
		if (!valid) {
			session.setCurrentViewBean(new ModificationTypesListViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}
		return valid;
	}
}
