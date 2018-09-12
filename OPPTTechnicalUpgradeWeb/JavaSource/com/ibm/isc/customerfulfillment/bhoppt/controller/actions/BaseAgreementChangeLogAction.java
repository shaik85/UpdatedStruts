/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2006, 2008
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.BaseAgreementChangeLogActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementChangeLogDetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement.BaseAgreementManagerHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementChangeLogDetailsCustomDTO;

/**
* This is the Base Agreement Change Log Action 
* 
* @author Ravi Yandapalli
*
* 
* Window - Preferences - Java - Code Style - Code Templates
*/
public class BaseAgreementChangeLogAction extends OPPTLongAction {

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
    protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
            throws Exception {
        ErrorReport errorReport = null;
		OPPTViewBean viewBean = null;
		BaseAgreementChangeLogDetailsCustomDTO customDto;
		BaseAgreementChangeLogActionForm actionForm ; 
		actionForm =(BaseAgreementChangeLogActionForm)form;
		customDto = new BaseAgreementChangeLogDetailsCustomDTO();
		customDto.setSalesOrg(actionForm.getSalesOrganization());
		customDto.setAgreementNumber(actionForm.getAgreementNumber());
		customDto.setCustomerNumber(actionForm.getCustomerNumber());
		customDto.setINACNumber(actionForm.getINACNumber());
		customDto.setEnterpriseNumber(actionForm.getEnterpriseNumber());
		
		try {
		    customDto = getBaseAgreementManager().getBaseAgreementChangeLogDetails(customDto);
			errorReport = customDto.getMessageReport();
					
			if(null == errorReport){
			   viewBean = new BaseAgreementChangeLogDetailsViewBean(customDto);
			   setForwardName(ForwardNameConstants.PAGE_BASEAGREEMENT_CHANGELOG);  //$NON-NLS-1$
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
        
        return ActionNameConstants.BASEAGREEMENT_CHANGELOG;
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
		String actualForward = ForwardNameConstants.PAGE_BASEAGREEMENT_CHANGELOG;

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof BaseAgreementChangeLogDetailsViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if (!valid) {
			session.setCurrentViewBean(new BaseAgreementChangeLogDetailsViewBean());
			session.setCurrentForward(actualForward);
			valid = true;
		}
		
		return valid;
    }

}
