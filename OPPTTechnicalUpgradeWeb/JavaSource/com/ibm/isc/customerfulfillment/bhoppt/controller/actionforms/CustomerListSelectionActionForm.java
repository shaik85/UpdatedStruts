/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;

/**
 * Action form for customer list selection screen  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 4, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class CustomerListSelectionActionForm extends OPPTActionForm {
	private String[] selectedCustomers = null;
	private String[] deleteCustomers = null;
	private String comments = null;
	private String[] deleteCustomerList = null;
	
	/**
	 * Returns collection of selected customer list ids 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String[]
	 */
	public String[] getSelectedCustomers() {
		return selectedCustomers;
	}

	/**
	 * Sets collection of selected customer list ids 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedCustomerList strings 
	 */
	public void setSelectedCustomers(String[] newSelectedCustomers) {
		selectedCustomers = newSelectedCustomers;
	}
	
	/** 
	 * Overridden method - Checks whether at least one customer list is selected 
	 * 
	 * <br/><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest) 
	 * @param actionMapping ActionMapping
	 * @param request HttpServletRequest
	 * @return  ActionErrors
	 * 
	 */
//	public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
//		ErrorReport errorReport = new ErrorReport();
//		if(null != getSelectedCustomerList()){
//			if(getSelectedCustomerList().length == 0){
//				errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF26, OPPTMessageCatalog.TYPE_PRESENTATION), null);
//			}
//		}
//		else{
//			errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF26, OPPTMessageCatalog.TYPE_PRESENTATION), null);
//		}
//		return saveErrors(request, errorReport);
//	}
	
	/**
	 * Returns comments value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Sets comments value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newComments String 
	 */
	public void setComments(String string) {
		comments = string;
	}
	
	/**
	 * Returns selected collection of customer lists for deletion 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String[]
	 */
	public String[] getDeleteCustomers() {
		return deleteCustomers;
	}

	/**
	 * Sets selected collection of customer lists for delection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDeleteCustomerList String[] 
	 */
	public void setDeleteCustomers(String[] newDeleteCustomers) {
		deleteCustomers = newDeleteCustomers;
	}

	public void reset(){
		selectedCustomers = null;
		deleteCustomers = null;
		comments = null;
	}
	
	/**
	 * @return Returns the deleteCustomerList.
	 */
	public String[] getDeleteCustomerList() {
		return deleteCustomerList;
	}
	/**
	 * @param deleteCustomerList The deleteCustomerList to set.
	 */
	public void setDeleteCustomerList(String[] newdeleteCustomerList) {
		deleteCustomerList = newdeleteCustomerList;
	}
}
