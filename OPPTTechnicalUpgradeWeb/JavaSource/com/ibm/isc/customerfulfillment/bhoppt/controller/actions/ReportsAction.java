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
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerHome;

/**
 *  
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 8, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */
public class ReportsAction extends OPPTLongAction 
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
	
	protected OPPTViewBean executeAction(ActionForm form, OPPTSession session)
		throws Exception {
		ReportsCustomDTO customDto = new ReportsCustomDTO();
		ReportManagerHome reportHome=null;
		ReportManager reportBean=null;
		OPPTViewBean viewBean = null;
		UserInfoDataBean userInfo = null;
		viewBean = new ReportsViewBean();
		setTransactionInformation(customDto,session);
		reportHome = (ReportManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("ReportManagerHome");  //$NON-NLS-1$
		reportBean = reportHome.create();
		
		try {
			customDto = reportBean.listProposals(customDto);
			ErrorReport errorReport = customDto.getMessageReport();
			if(null == errorReport){
				addDataStoreEntry(session, customDto);
				viewBean = new ReportsViewBean(customDto);
				session.storeObjectToSession(SessionConstants.SESSION_REPOTRS_PROPOSAL_DETAIL, customDto);
				setForwardName(getRole(session));
			}
			else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(errorReport);
				session.setFirstActionForwardName(getInitiator(getRole(session)));
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
		return ActionNameConstants.REPORTS;
	}
	
	private void setForwardName(int role){
		switch(role){
			case Constants.PROPOSAL_ADMINISTRATOR:
						setForwardName(ForwardNameConstants.PAGE_REPORTS);
						break;
			case Constants.PROPOSAL_APPROVER:
						setForwardName(ForwardNameConstants.PAGE_PROPOSAL_FOR_APPROVAL_REPORTS);
						break;
			case Constants.PROPOSAL_CREATE_APPROVER:
						setForwardName(ForwardNameConstants.PAGE_CREATE_APPROVE_REPORTS);
						break;
		    default :
                break;
        }
	}
	
	private String getInitiator(int role){
		String initiator="";
		switch(role){
			case Constants.PROPOSAL_ADMINISTRATOR:
						initiator = ForwardNameConstants.ACTION_PROPOSAL_ADMINISTRATOR;
						break;
			case Constants.PROPOSAL_APPROVER:
						initiator = ForwardNameConstants.ACTION_PROPOSAL_APPROVER;
						break;
			case Constants.PROPOSAL_CREATE_APPROVER:
						initiator = ForwardNameConstants.ACTION_PROPOSAL_CREATE_APPROVER;
						break;
		    default :
                break;
        }
		return initiator;
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
		return true;
	}
}