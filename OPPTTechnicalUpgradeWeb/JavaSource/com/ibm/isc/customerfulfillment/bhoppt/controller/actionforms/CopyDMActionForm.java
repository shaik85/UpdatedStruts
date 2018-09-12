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
 * Action form for copy dm view. It first checks for any sold to party is entered. If entered it checks
 * whether any dm entries are made and finally it checks for the validity of the plan dates. 
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


public class CopyDMActionForm extends OPPTActionForm {
	private String soldToParty = null;
	private String dmNumber = null;
	private String dmDescription = null;
	private DateDataBean planStartDate = null;
	private DateDataBean planEndDate = null;
	
	/**
	 * Returns selected dm's description 
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
	 * @return String
	 */
	public String getDmDescription() {
		return dmDescription;
	}

	/**
	 * Returns selected dm's number 
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
	 * @return String
	 */
	public String getDmNumber() {
		return dmNumber;
	}

	/**
	 * Returns plan end date 
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
	public DateDataBean getPlanEndDate() {
		if(null == planEndDate){
			planEndDate = new DateDataBean();
		}
		return planEndDate;
	}

	/**
	 * Returns plan start date 
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
	public DateDataBean getPlanStartDate() {
		if(null == planStartDate){
			planStartDate = new DateDataBean();
		}
		return planStartDate;
	}

	/**
	 * Returns selected sold to party number 
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
	 * @return String
	 */
	public String getSoldToParty() {
		return soldToParty;
	}

	/**
	 * Sets selected dm's description 
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
	 * @param newDmDescription String 
	 */
	public void setDmDescription(String newDmDescription) {
		dmDescription = newDmDescription;
	}

	/**
	 * Sets dm number 
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
	 * @param newDmNumber String 
	 */
	public void setDmNumber(String newDmNumber) {
		dmNumber = newDmNumber;
	}

	/**
	 * Sets plan end date 
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
	 * @param newPlanEndDate DateDataBean 
	 */
	public void setPlanEndDate(DateDataBean newPlanEndDate) {
		planEndDate = newPlanEndDate;
	}

	/**
	 * Sets plan start date 
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
	 * @param newPlanStartDate DateDataBean 
	 */
	public void setPlanStartDate(DateDataBean newPlanStartDate) {
		planStartDate = newPlanStartDate;
	}

	/**
	 * Sets selected sold to party's value 
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
	 * @param newSoldToParty String 
	 */
	public void setSoldToParty(String newSoldToParty) {
		soldToParty = newSoldToParty;
	}

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#validate()
	 */
	public ErrorReport validate() {
		ErrorReport errorReport = new ErrorReport();
		
		if(isSelectEmpty(getSoldToParty())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF59, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		if(isFieldEmpty(getDmNumber())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF60, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		
		return errorReport;
	}

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#reset()
	 */
	public void reset(){
		soldToParty = null;
		dmNumber = null;
		dmDescription = null;
		planStartDate = null;
		planEndDate = null;
	}
}
