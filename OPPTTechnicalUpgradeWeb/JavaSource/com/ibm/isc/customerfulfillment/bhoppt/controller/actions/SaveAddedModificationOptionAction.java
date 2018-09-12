/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationOptionActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationOptionsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationTypesViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementDataManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationOptionCustomDTO;

/**
 * This is save added modification option 
 * 
 * @author Ravi Yandapalli
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SaveAddedModificationOptionAction extends OPPTLongAction {

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
        ErrorReport errorReport = null;
        ModificationOptionActionForm actionForm=null;
        ModificationTypesViewBean modificationTypesViewBean = null;
        ModificationOptionCustomDTO customDto = null;
        customDto = new ModificationOptionCustomDTO();
        actionForm =(ModificationOptionActionForm)form; 
        modificationTypesViewBean= (ModificationTypesViewBean)session.getObjectFromSession(SessionConstants.SESSION_MODIFICATION_TYPE_VIEWBEAN);
        customDto.setTypeCode(modificationTypesViewBean.getTypeCode());
        customDto.setModificationOption(actionForm.getModificationOption());
        customDto.setModificationDescription(actionForm.getModificationDescription());
 try{
            customDto = getBaseAgreementDataManager().addModificationOption(customDto);
            errorReport = customDto.getMessageReport();
            if(null == errorReport){
              setForwardName(ForwardNameConstants.PAGE_EDIT_MODIFICATIONTYPE_ACTION);  //$NON-NLS-1$
		   }
		   else{
		    viewBean = new MessageViewBean();
		    viewBean.setErrorReport(errorReport);
			setForwardName(ForwardNameConstants.PAGE_ADD_MODIFICATION_OPTION);  //$NON-NLS-1$
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
		return ActionNameConstants.SAVE_ADDMODIFICATION_OPTION;
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
		String actualForward = ForwardNameConstants.PAGE_ADD_MODIFICATION_OPTION;

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof ModificationOptionsViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if (!valid) {
			session.setCurrentViewBean(new ModificationOptionsViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}
		
		return valid;
    }

    }


