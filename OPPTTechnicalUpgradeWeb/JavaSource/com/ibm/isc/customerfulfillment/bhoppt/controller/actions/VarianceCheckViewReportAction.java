/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;


import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.VarianceCheckReportsActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.VarianceHeaderInformationViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.reports.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ReportTypeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
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
public class VarianceCheckViewReportAction extends OPPTAction {

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
		
		VarianceCheckReportsActionForm actionForm = (VarianceCheckReportsActionForm)form;
		if(null != actionForm){
			String reportType = actionForm.getReportType();
			if(null != reportType){
				ProposalCustomDTO selectedProposal = getCurrentProposalDto(session);
				
				if(null != selectedProposal){
					if(ReportTypeConstants.VARIANCE_REPORT_ALL.equalsIgnoreCase((actionForm.getReportType()))) {
						session.storeObjectToSession(SessionConstants.REPORT_REPORT_TYPE, ReportTypeConstants.VARIANCE_REPORT_ALL);
					}
					else if(ReportTypeConstants.VARIANCE_REPORT_PRICE_CHANGE.equalsIgnoreCase((actionForm.getReportType()))) {
						session.storeObjectToSession(SessionConstants.REPORT_REPORT_TYPE, ReportTypeConstants.VARIANCE_REPORT_PRICE_CHANGE);
					}
					setForwardName(ForwardNameConstants.ACTION_REPORT_GENERATOR);
				}
				else{
					viewBean = session.getCurrentViewBean();
					viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PAF76));
					setForwardName(session.getCurrentForward());
				}
			}
			else{
				viewBean = session.getCurrentViewBean();
				viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PAF77));
				setForwardName(session.getCurrentForward());
			}
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(getErrorReport(ErrorCodeConstants.PAF77));
			viewBean.getErrorReport().addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF76, OPPTMessageCatalog.TYPE_PRESENTATION), null);
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
		return ActionNameConstants.VIEW_CHECK_REPORT;
	}

	private OPPTViewBean getVarianceReport(OPPTSession session, ProposalCustomDTO selectedProposal, boolean priceChange) throws Exception{
		OPPTViewBean viewBean = null;
		VarianceRptCustomDTO customDTO = new VarianceRptCustomDTO();
		customDTO.setProposalDTO(selectedProposal);
		setTransactionInformation(customDTO, session);
		
		try {
			if(priceChange){
				customDTO = getReportManager().getVariancePriceRpt(customDTO);
			}
			else{
				customDTO = getReportManager().getVarianceAllRpt(customDTO);
			}
			if(null == customDTO || null == customDTO.getReportDTO()) {
				viewBean = new ErrorViewBean();
				setForwardName(ForwardNameConstants.PAGE_ERROR);
			}
			else{
				viewBean = new VarianceReportViewBean(customDTO, "variancereportview");  //$NON-NLS-1$
				setForwardName(ForwardNameConstants.ACTION_REPORT_GENERATOR);
			}
		}
		catch(ServiceException se) {
			throw se;
		}
		return viewBean;
	}
	
	
	private ReportManager getReportManager() throws Exception {
		ReportManagerHome reportHome = (ReportManagerHome) ServiceLocator.getEJBHomeFactory().getRemoteHome("ReportManagerHome");  //$NON-NLS-1$
		return reportHome.create();
	}
	
	private void storeReportViewBean(OPPTSession session, OPPTViewBean viewBean){
		if(null != session && null != viewBean){
			session.storeObjectToSession(SessionConstants.REPORT_VIEW_BEAN, viewBean);
		}
	}
	
	private ContractCustomDTO getCurrentProposalDto(OPPTSession session) 
	{
		ContractCustomDTO currentProposal = null;
		VarianceHeaderInformationCustomDTO headerDto = null;
		if(null != session){
			headerDto = (VarianceHeaderInformationCustomDTO)session.getObjectFromSession(SessionConstants.VARIANCE_CHECK);
			currentProposal = headerDto.getContractDTO();			
		}
		return currentProposal;
	}

	private String getCurrentForwardName(int role){
		String currentForwardName = null;
		switch(role){
			case Constants.PROPOSAL_CREATE_APPROVER: 
							currentForwardName = ForwardNameConstants.PAGE_CREATE_APPROVE_CHECK_VARIANCE_STATUS;
							break;

			case Constants.PROPOSAL_ADMINISTRATOR:
			default:
							currentForwardName = ForwardNameConstants.PAGE_CHECK_VARIANCE_STATUS;
							break;
		}
		
		return currentForwardName;
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
		boolean valid = false;
		
		OPPTViewBean viewBean = session.getCurrentViewBean();
		String currentForward = session.getCurrentForward();
		String actualForward = getCurrentForwardName(getRole(session));

		if(null != viewBean && null != currentForward){
			if(viewBean instanceof VarianceHeaderInformationViewBean && currentForward.equals(actualForward)){
				valid = true;
			}
		}

		if(!valid){
			Object dataStoreEntry = session.getDataStoreEntry(ActionNameConstants.VARIANCE_CHECK);
			if(null != dataStoreEntry && dataStoreEntry instanceof VarianceHeaderInformationCustomDTO){
				session.setCurrentViewBean(new VarianceHeaderInformationViewBean((VarianceHeaderInformationCustomDTO)dataStoreEntry));
				session.setCurrentForward(actualForward);
				valid = true;
			}
		}
		return valid;
	}
}