/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ConfigureDMActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ConfigureDMViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ConfigureDMCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class ValidateConfigureDMAction extends OPPTLongAction 
{
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 14, 2003 
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception {
		OPPTViewBean viewBean = null;
		
		ConfigureDMCustomDTO customDTO = getConfigureDM(session);
		if(null != customDTO){
			setTransactionInformation(customDTO, session);
			customDTO = ((ConfigureDMActionForm)form).getInputValues(customDTO);
						
			try{
				customDTO = getProposalManager().validateConfigWhenConfigureDM(customDTO);
				ErrorReport messageReport = customDTO.getMessageReport();
				if(null == messageReport){
					addDataStoreEntry(session, customDTO);
					setConfigureDM(session, customDTO);
					viewBean = new ConfigureDMViewBean(customDTO);
					setForwardName(session.getCurrentForward());
				}
				else{
					viewBean = new MessageViewBean();
					viewBean.setErrorReport(messageReport);
					setForwardName(ForwardNameConstants.PAGE_MESSAGE);
				}
			}
			catch(ServiceException se)
			{
				viewBean = handleServiceException(session, se.getErrorReport());
			}
		}
		else{
			viewBean = session.getCurrentViewBean();
			setForwardName(session.getCurrentForward());
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
	 * 
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return 
	 * 
	 */
	protected String getActionName() {
		return ActionNameConstants.VALIDATE_CONFIGURE_DM;
	}

	private ConfigureDMCustomDTO getConfigureDM(OPPTSession session){
		ConfigureDMCustomDTO customDTO = null;
		if(null != session){
			customDTO = (ConfigureDMCustomDTO)session.getObjectFromSession(SessionConstants.SESSION_CONFIGURE_DM);
		}
		return customDTO;
	}
   
	private void setConfigureDM(OPPTSession session, ConfigureDMCustomDTO customDTO){
		if(null != session && null != customDTO){
			session.storeObjectToSession(SessionConstants.SESSION_CONFIGURE_DM, customDTO);
		}
	}

    /**
     * validateCurrentViewContent
     * 
     * @param session
     * @return boolean
     * @author thirumalai
     */
    protected boolean validateCurrentViewContent(OPPTSession session) {
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = getCurrentForwardName(getRole(session));

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof ConfigureDMViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.CONFIGURE_DM);
			if(null != dataStoreEntry && dataStoreEntry instanceof ConfigureDMCustomDTO){
				session.setCurrentViewBean(new ConfigureDMViewBean((ConfigureDMCustomDTO)dataStoreEntry));
				session.setCurrentForward(actualForward);
				valid = true;
			}
		}
		
		return valid;
	}

	private String getCurrentForwardName(int role){
		String currentForwardName = null;
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
								currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_CONFIGURE_DM;
								break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
								currentForwardName = ForwardNameConstants.PAGE_CONFIGURE_DM;
								break;
		}
		
		return currentForwardName;
	}
}