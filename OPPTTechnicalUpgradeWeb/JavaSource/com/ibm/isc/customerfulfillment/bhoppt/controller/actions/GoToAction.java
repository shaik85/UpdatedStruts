/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actions;

import org.apache.struts.action.ActionForm;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTAction;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.GoToActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.OPPTSession;
import com.ibm.isc.customerfulfillment.bhoppt.controller.session.SessionConstants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.ForwardNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *
 * @author thirumalai
 */
public class GoToAction extends OPPTAction 
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
		
		GoToActionForm actionForm = (GoToActionForm)form;
		ErrorReport errorReport = validateActionForm(actionForm);
		if(0 == errorReport.size()){
			updateInProposalDetails(session, actionForm.getTotalPages(), actionForm.getPageNumber(), actionForm.getMlcTotalPages(), actionForm.getMlcExcess(), actionForm.isSearchLicenses(), actionForm.isDuplicateSerial());
			setForwardName(ForwardNameConstants.ACTION_REFRESH_PROPOSAL_DETAILS);
		}
		else{
			viewBean = session.getCurrentViewBean();
			viewBean.setErrorReport(errorReport); 	
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
		return ActionNameConstants.GOTO;
	}

	private void updateInProposalDetails(OPPTSession session, int totalPages, int pageIndex, int mlcTotalPages, int mlcExcess, boolean searchLicenses,boolean duplicateSerial){
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_TOTAL_PAGES, new Integer(totalPages));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_PAGE_INDEX, new Integer(pageIndex));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_MLC_TOTAL_PAGES, new Integer(mlcTotalPages));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_MLC_EXCESS, new Integer(mlcExcess));
		session.storeObjectToSession(SessionConstants.PROPOSAL_DETAILS_SEARCH_LICENSES, new Boolean(searchLicenses));
		session.storeObjectToSession(SessionConstants.DUPLICATE_SERIAL_NUMBERS, new Boolean(duplicateSerial));
	}

	private ErrorReport validateActionForm(GoToActionForm actionForm){
		ErrorReport errorReport = new ErrorReport();
		if(null != actionForm){
			String pageNumberValue = actionForm.getPageNumberValue();
			String totalPagesValue = actionForm.getTotalPagesValue();

			
			if(null == pageNumberValue || null == totalPagesValue){
				errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF32, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
			else{
				int pageNumber = getIntValue(pageNumberValue);
				int totalPages = getIntValue(totalPagesValue);
				if(pageNumber <= 0 || pageNumber > totalPages){
					errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF33, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}
		}
		return errorReport;
	}

	/**
     * getIntValue
     * 
     * @param stringValue
     * @return
     * @author thirumalai
     */
    protected int getIntValue(String stringValue){
		int intValue = 0;
		try{
			if(null != stringValue && 0 < stringValue.length()){
				intValue = Integer.parseInt(stringValue);
			}
		}
		catch(NumberFormatException ne){
			intValue = 0;
		}
	
		return intValue;
	}

	/**
     * validateCurrentViewContent
     * 
     * @param session
     * @return boolean
     * @author thirumalai
     */
    protected boolean validateCurrentViewContent(OPPTSession session) {
		return true;
	}
}