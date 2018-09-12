/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTLongAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CompareTPReportViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.MessageViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CompareTPReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManager;
import com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr.ReportManagerHome;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class CompareTPAction extends OPPTLongAction 
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
		OPPTViewBean viewBean=null;
		CompareTPReportCustomDTO compareTPDto = new CompareTPReportCustomDTO();
		setTransactionInformation(compareTPDto,session);
		
		ContractCustomDTO customDto = getCurrentDto(session);
		compareTPDto.setContractCustomDTO(customDto);

		ReportManagerHome reportManagerHome = (ReportManagerHome)ServiceLocator.getEJBHomeFactory().getRemoteHome("ReportManagerHome");  //$NON-NLS-1$
		ReportManager reportManager = reportManagerHome.create();

		try {
			compareTPDto = reportManager.getCompareTPRpt(compareTPDto);
			ErrorReport errorReport = compareTPDto.getMessageReport();
				
			if(null == errorReport){
				viewBean = new CompareTPReportViewBean(compareTPDto);
				setForwardName("comparetp");  //$NON-NLS-1$
			}
			else{
				viewBean = new MessageViewBean();
				viewBean.setErrorReport(errorReport);
				setForwardName(ForwardNameConstants.PAGE_MESSAGE);
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
	 * 
	 * @see com.ibm.support.oppt.OPPTAction#getActionName() 
	 * @return 
	 * 
	 */
	protected String getActionName() {
		return ActionNameConstants.COMPARE_TP;
	}
	
	private ContractCustomDTO getCurrentDto(OPPTSession session) 
	{
		ContractCustomDTO currentProposal = null;
		if(null != session){
			currentProposal = (ContractCustomDTO)session.getObjectFromSession(SessionConstants.CURRENT_PROPOSAL);			
		}
		return currentProposal;
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
