/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.DateDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;


/**
 * Action form used for amend swo view. This action form checks whether propoer from and to dates
 * are selected and checks if the to date is after from date  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 25, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */


public class AmendSWOActionForm extends OPPTActionForm {
	private DateDataBean fromDate = null;
	private DateDataBean toDate = null;
	
	/**
	 * Returns from date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DateDataBean
	 */
	public DateDataBean getFromDate() {
		if(null == fromDate){
			fromDate = new DateDataBean();
		}
		return fromDate;
	}

	/**
	 * Returns to date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DateDataBean
	 */
	public DateDataBean getToDate() {
		if(null == toDate){
			toDate = new DateDataBean();
		}
		return toDate;
	}

	/**
	 * Sets from date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newFromDate DateDataBean 
	 */
	public void setFromDate(DateDataBean newFromDate) {
		fromDate = newFromDate;
	}

	/**
	 * Sets to date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newToDate DateDataBean 
	 */
	public void setToDate(DateDataBean newToDate) {
		toDate = newToDate;
	}

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#validate()
	 */
	public ErrorReport validate() {
		ErrorReport errorReport = new ErrorReport();
		if(isDateEmpty(getFromDate())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF40, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
		if(isDateEmpty(getToDate())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF41, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
	
		return errorReport;
	}
}