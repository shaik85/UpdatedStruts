/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;

/**
 * <p>This is the base class for all the view beans in the OPPT application. All the view bean will have an 
 * ErrorReport object associated with it. If there are any error messages to be shown along with the actual 
 * content of the page this ErrorReport will be set.</p> 
 * 
 * <p>If the errorReport is not null, all the error messages in ErrorReport are displayed at the top of the page,
 * and all the fields that are involved in getting these error messages are stored with red color.</p> 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 11, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class OPPTViewBean implements Serializable
{
	private ErrorReport errorReport = null;
	private ArrayList buttonFlags = null;
	private OPPTActionForm actionForm = null;
	private String userName = null;

	/**
	 * Returns the ErrorReport object associated with the view bean. If there are any 
	 * error messages to be displayed at the top of the page, this error report object
	 * will be not null. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public ErrorReport getErrorReport() {
		if(errorReport == null){
			errorReport = new ErrorReport();
		}
		return errorReport;
	}
	
	/**
	 * Set the ErrorReport passed as the errorReport associated with the view bean 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newErrorReport ErrorReport
	 */
	public void setErrorReport(ErrorReport newErrorReport) {
		errorReport = newErrorReport;
		if(null != errorReport){
			OPPTMessageCatalog.getInstance().populateErrorReport(errorReport);
		}
	}
	
	/**
	 * Returns button flags collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ArrayList
	 */
	public ArrayList getButtonFlags() {
		return buttonFlags;
	}

	/**
	 * Sets button flags collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newButtonFlags ArrayList 
	 */
	public void setButtonFlags(ArrayList newButtonFlags) {
		buttonFlags = newButtonFlags;
	}

	/**
     * To replace null by empty.
     * <br/><b>Known Bugs</b><br/>
     * <br/><PRE>
     * date Jan 15, 2004
     * revision date author reason
     * </PRE><br/>
     *
     * @author Anshuman Singh
     * @version 5.1A
     * @return String
     * @param value 
     */
	protected String replaceNullValue(String value){
		if(null == value){
			return "";  //$NON-NLS-1$ 
		}
		else{
			return value;
		}
	}
	
	/**
     * @param flags
     * @author thirumalai
     */
    public void setButtonFlags(Map flags){
		if(null != flags){
			Iterator iterator = flags.keySet().iterator();
			while(iterator.hasNext()){
				addButtonFlag((String)iterator.next()); 
			}
		}
	}
	
	/**
     * @param id
     * @author thirumalai
     */
    public void addButtonFlag(String id){
		if(null != id){
			if(null == buttonFlags){
				buttonFlags = new ArrayList();
			}
			buttonFlags.add(id);
		}
	}
	
	/**
	 * Returns the action form associated with the view bean 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return OPPTActionForm
	 */
	public OPPTActionForm getActionForm() {
		return actionForm;
	}

	/**
	 * Sets the action form associated with the view bean 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newActionForm OPPTActionForm
	 */
	public void setActionForm(OPPTActionForm newActionForm) {
		actionForm = newActionForm;
	}
	
	/**
	 * Returns flag suggesting whether this view can be current view bean. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isCurrentViewBean() {
		return true;
	}

	/**
	 * Returns user name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets user name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newUserName String 
	 */
	public void setUserName(String newUserName) {
		userName = newUserName;
	}
	
	/**
	 * This method is used by Select all action. All the view bean, which need to provide select 
	 * all functionality should override thid method.   
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *
	 */
	public void selectAll(){
	}

	/**
	 * This method is used by Clear all action. All the view bean, which need to provide clear 
	 * all functionality should override thid method. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *
	 */
	public void clearAll(){
	}
}