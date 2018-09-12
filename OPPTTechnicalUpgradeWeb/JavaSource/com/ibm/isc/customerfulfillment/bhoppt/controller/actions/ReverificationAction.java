/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.UserInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReportsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReverificationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr.UserManagerHome;

/**
 *  
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Oct 05, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Saravanan Viswanathan
 * @version 5.1X PMR 2005
 */
public class ReverificationAction extends OPPTLongAction 
{
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Oct 05, 2004
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
		ReverificationCustomDTO customDto = new ReverificationCustomDTO();
		
		OPPTViewBean viewBean = null;
		viewBean = new ReverificationViewBean();
		setTransactionInformation(customDto,session);
		
		try {
			customDto = getUserManager().listAllSalesOrgs(customDto);
			ErrorReport errorReport = customDto.getMessageReport();
			if(null == errorReport){
				addDataStoreEntry(session, customDto);
				viewBean = new ReverificationViewBean(customDto);
				session.storeObjectToSession(SessionConstants.SESSION_REVERIFICATION_PROPOSAL_DETAIL, customDto);
				setForwardName();
			}
			else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(errorReport);
				session.setFirstActionForwardName(getInitiator());
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);
			}
		}
		catch(ServiceException se){
			viewBean = new ErrorViewBean();
			viewBean.setErrorReport(se.getErrorReport());
			setForwardName(ForwardNameConstants.PAGE_ERROR);
		}
		return viewBean;
	}
	
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Oct 05, 2004 
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
		return ActionNameConstants.REVERIFICATION_REPORT;
	}
	
	private void setForwardName(){
		setForwardName(ForwardNameConstants.PAGE_REVERIFICATION_REPORT);
	}
	
	private String getInitiator(){
		String initiator="";  //$NON-NLS-1$
		initiator = ForwardNameConstants.ACTION_ADMINISTRATOR;
		return initiator;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Oct 05, 2004
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
		return true;
	}
}