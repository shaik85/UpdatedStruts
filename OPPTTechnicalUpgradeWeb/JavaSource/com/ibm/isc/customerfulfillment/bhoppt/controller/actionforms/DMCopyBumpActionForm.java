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


public class DMCopyBumpActionForm extends OPPTActionForm {
	private DateDataBean originalPlanEndDate = null;
	private DateDataBean bumpPlanStartDate = null;
	private DateDataBean bumpPlanEndDate = null;

	/**
	 * Returns new bump plan end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DateDataBean
	 */
	public DateDataBean getBumpPlanEndDate() {
		if(null == bumpPlanEndDate){
			bumpPlanEndDate = new DateDataBean();
		}
		return bumpPlanEndDate;
	}

	/**
	 * Returns new bump plan start date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DateDataBean
	 */
	public DateDataBean getBumpPlanStartDate() {
		if(null == bumpPlanStartDate){
			bumpPlanStartDate = new DateDataBean();
		}
		return bumpPlanStartDate;
	}

	/**
	 * Returns original plan end date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DateDataBean
	 */
	public DateDataBean getOriginalPlanEndDate() {
		if(null == originalPlanEndDate){
			originalPlanEndDate = new DateDataBean();
		}
		return originalPlanEndDate;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bean 
	 */
	public void setBumpPlanEndDate(DateDataBean bean) {
		bumpPlanEndDate = bean;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bean 
	 */
	public void setBumpPlanStartDate(DateDataBean bean) {
		bumpPlanStartDate = bean;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bean 
	 */
	public void setOriginalPlanEndDate(DateDataBean bean) {
		originalPlanEndDate = bean;
	}

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#validate()
	 */
	public ErrorReport validate() {
		ErrorReport errorReport = new ErrorReport();
		
		if(isDateEmpty(getOriginalPlanEndDate())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF100, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
	
		if(isDateEmpty(getBumpPlanStartDate())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF101, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if(isDateEmpty(getBumpPlanEndDate())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF102, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		
		return errorReport;
	}

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#reset()
	 */
	public void reset(){
		originalPlanEndDate = null;
		bumpPlanStartDate = null;
		bumpPlanEndDate = null;
	}
}