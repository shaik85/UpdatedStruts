/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * Action form for add customer view. It checks whether at lease one customer is selected. If selected 
 * it forwards the control to the corresponding action, if not it throws the page back to the user 
 * asking him to select atlease one customer.  
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
public class AddCustomerActionForm extends OPPTActionForm {
	private String[] selectedCustomerIds = null;

	/**
	 * Returns the collection of selected customer ids. 
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
	 * @return String[]
	 */
	public String[] getSelectedCustomerIds() {
		return selectedCustomerIds;
	}

	/**
	 * Sets selected customer ids collection 
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
	 * @param newSelectedCustomerIds String[] 
	 */
	public void setSelectedCustomerIds(String[] newSelectedCustomerIds) {
		selectedCustomerIds = newSelectedCustomerIds;
	}
	
	public void reset(){
		selectedCustomerIds = null;
	}

	public ErrorReport validate() {
		ErrorReport errorReport = new ErrorReport();
		if(null == selectedCustomerIds || 0 >= selectedCustomerIds.length){
			errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PA17, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		return errorReport;
	}
}