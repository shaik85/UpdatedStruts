/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import java.util.List;
import java.util.StringTokenizer;

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
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class DefaultConfigureDMAction extends OPPTLongAction {
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
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session) throws Exception 
	{
		OPPTViewBean viewBean = null;
		
		ConfigureDMActionForm actionForm = (ConfigureDMActionForm)form;
		if(null != actionForm)
		{
			String selectedIds[] = actionForm.getSelectedIds();
			if(null != selectedIds)
			{
				if(selectedIds.length == 1)
				{
					StringTokenizer st = new StringTokenizer(selectedIds[0], Constants.STRING_SEPERATOR);
					if(2 == st.countTokens())
					{
						ConfigureDMCustomDTO customDTO = getDefaultDM(session, st.nextToken().trim(), st.nextToken().trim());
						if(null != customDTO){
							setTransactionInformation(customDTO, session);
							customDTO = actionForm.getInputValues(customDTO);
							customDTO.setConfigChange(false);
						
							try{
								customDTO = getProposalManager().retrieveEEConfigWhenConfigureDM(customDTO);
								ErrorReport messageReport = customDTO.getMessageReport();
								if(null == messageReport){
									addDataStoreEntry(session, customDTO);
									setConfigureDM(session, customDTO);
									// viewBean = new ConfigureDMViewBean(customDTO, actionForm.getBumpPlanStartDate().getDate());
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
					}
					else{
						viewBean = session.getCurrentViewBean();
						viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA24));
						setForwardName(session.getCurrentForward());
					}
				}
				else{
					viewBean = session.getCurrentViewBean();
					viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA19));
					setForwardName(session.getCurrentForward());
				}
			}
			else{
				viewBean = session.getCurrentViewBean();
				viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA17));
				setForwardName(session.getCurrentForward());
			}
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PA17));
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
		return ActionNameConstants.DEFAULT_CONFIGURE_DM;
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
	
	private ConfigureDMCustomDTO getDefaultDM(OPPTSession session, String swoId, String eeId){
		ConfigureDMCustomDTO customDTO = null;
		
		if(null != session && null != swoId && null != eeId)
		{
			customDTO = getConfigureDM(session);
			List swoCollection = customDTO.getSwos();
			if(null != swoCollection)
			{
				for(int i=0, size=swoCollection.size(); i<size; i++){
					ConfigureDMSWOCustomDTO swo = (ConfigureDMSWOCustomDTO)swoCollection.get(i);
					List eeCollection = swo.getEes();
					if(null != eeCollection){
						for(int j=0, eeSize=eeCollection.size(); j<eeSize; j++){
							ConfigureDMEECustomDTO ee = (ConfigureDMEECustomDTO)eeCollection.get(j);
							if(swoId.equals(swo.getId()) && eeId.equals(ee.getId())){
								ee.setSelected(true);
								ee.setDefaultedEE(true);
							}
							else{
								ee.setSelected(false);
								ee.setDefaultedEE(false);
							}
						}
					}
				}
			}
		}
		return customDTO;
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