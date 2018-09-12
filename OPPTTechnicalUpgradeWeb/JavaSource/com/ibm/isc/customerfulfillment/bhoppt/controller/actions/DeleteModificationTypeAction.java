/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationTypeCodeActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationTypesListViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypesCustomDTO;

/**
 * Delete Modification Type Action
 * 
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DeleteModificationTypeAction extends OPPTLongAction {

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
        protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
                throws Exception {
            OPPTViewBean viewBean = null;
            ModificationTypeCodeActionForm actionForm = null;
            ModificationTypeCustomDTO customDTO = null;
            ModificationTypesCustomDTO modificationTypesCustomDTO = null;
            actionForm = (ModificationTypeCodeActionForm)form;
            customDTO = new ModificationTypeCustomDTO ();
            modificationTypesCustomDTO= (ModificationTypesCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_MODIFICATION_TYPES_CUSTOMDTO);
            customDTO.setSelectedSalesOrg(modificationTypesCustomDTO.getSalesOrg());
            customDTO.setTypeCode(actionForm.getModificationTypeCode());
            setTransactionInformation(customDTO,session);
           
            try{
                getBaseAgreementDataManager().deleteModificationType(customDTO);
             }catch(ServiceException ex){
    		    viewBean = handleServiceException(session, ex.getErrorReport());
    		}
            setForwardName(ForwardNameConstants.PAGE_REFRESH_MODIFICATION_MAINTENANCE);  //$NON-NLS-1$  
            
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
        		return ActionNameConstants.DELETE_MODIFICATION_TYPE;
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
