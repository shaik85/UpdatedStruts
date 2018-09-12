/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.DateDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.multipleaction.MultipleButtonManager;
import com.ibm.isc.customerfulfillment.bhoppt.controller.multipleaction.MultipleButtonManagerFactory;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;

/**
 * <p>Parent class for all the action forms in OPPT application. In general an HTML form supports 
 * only one action. But in OPPT all the html forms should suppoer more than one form.</p> 
 * 
 * <p>As we are going for struts, struts image tag has one propoerty <code>property</code>. This holds 
 * a name for the image button. We will manipulate this image property to suppoer multiple form 
 * actions. For this purpose we have one class <code>com.ibm.support.oppt.multipleaction.MultipleButtonManager</code> 
 * This class holds the information about all the buttons. So in the jsp file we will be defining a 
 * image button as follows:</p>
 * 
 * 		<p><code><html:image src="/image/create.gif" property="multipleButtonManager.create" /></code></p>
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

public class OPPTActionForm extends ActionForm
{
	/**
	 * This is mainly used when we are having multiple buttons acting on same form. Each button 
	 * <html:image> button will be associated with an parameter property. Use this to set the 
	 * actual button name along with this MultipleButtonManager. 
	 * 
	 * For Eg. for create button set it as
	 * 		<html:image src="/image/create.gif" property="multipleButtonManager.create" />
	 */
	private MultipleButtonManager multipleButtonManager = null;

	/**
	 * Creates a new OPPTActionForm object. This initiates MultipleButtonManager.
	 * 
	 * <br/><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */	
	public OPPTActionForm() {
		super();
		multipleButtonManager = MultipleButtonManagerFactory.createFactory().createImageButtonBeanManager();
	}
	
	/**
	 * Returns MultipleButtonManager
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
	 * @return MultipleButtonManager
	 */
	public MultipleButtonManager getMultipleButtonManager() {
		return multipleButtonManager;
	}

	/**
	 * Sets the multipleButtonManager
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
	 * @param multipleButtonManager MultipleButtonManager
	 */
	public void setMultipleButtonManager(MultipleButtonManager multipleButtonManager) {
		this.multipleButtonManager = multipleButtonManager;
	}
	
	/**
	 * Overridden method - Overridden to reset the multipleButtonManager. 
	 * 
	 * <br/><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest) 
	 * @param mapping ActionMapping value which holds all the action mapping setting done in struts-config.
	 * @param request HttpServletRequest 
	 *
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		getMultipleButtonManager().reset(mapping, request);
	}

	/**
	 * reset() method 
	 */
	public void reset() {
	}
	
	/**
	 * This method is used to check contents of given OPPTActionForm with the existing ActionForm.
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
	 * @param form OPPTActionForm
	 * @return boolean
	 */
	public boolean equals(OPPTActionForm form)
	{
		boolean equal = false;
		final String method_name = "equals";  //$NON-NLS-1$
		try
		{
			if ((form == null) || (!form.getClass().getName().equalsIgnoreCase(this.getClass().getName())))
			{
				equal = false;
			}
			else{
				Method method[] = this.getClass().getDeclaredMethods();
				for (int i = 0; i < method.length; i++)
				{
					String methodname = method[i].getName();
					if (methodname.startsWith("get"))  //$NON-NLS-1$
					{
						Object value1 = method[i].invoke(this, null);
						Object value2 = method[i].invoke(form, null);
						
						if(null != value1){
							if(null != value2){
								if(!value1.equals(value2)){
									equal = false;
									break;
								}
							}
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			equal = false;
		}
		
		return equal;
	}

	/**
	 * Given a string value it checks the validity of the string as an select value. If the string 
	 * value is either null or is equal to Select one thie method returns true.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param selectValue String
	 * @return boolean
	 */
	protected boolean isSelectEmpty(String selectValue){
		boolean empty = false;
		if(null == selectValue){
			empty = true;
		}
		else if(0 != selectValue.length() && selectValue.equalsIgnoreCase("Select one")){  //$NON-NLS-1$
			empty = true;
		}
		return empty;		
	}

	/**
	 * Given a string value it checks the validity of the string. If the string value is 
	 * eithern null or its length is 0 this method returns true.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param fieldValue String
	 * @return boolean
	 */
	protected boolean isFieldEmpty(String fieldValue){
		boolean empty = false;
		if(null == fieldValue){
			empty = true;
		}
		else if(0 == fieldValue.trim().length()){
			empty = true;
		}
		return empty;		
	}
	
	/**
	 * Given a DateDataBean it checks whether the date is empty or not. If the date associated 
	 * with the DateDataBean is valid it returns true.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date DateDataBean
	 * @return boolean
	 */
	protected boolean isDateEmpty(DateDataBean date){
		boolean empty = true;
		try{
			if(null != date && null != date.getDate()){
				empty = false;
			}
		}
		catch(Exception e){
			empty = true;
		}
		return empty;
	}
	
	/**
     * isDayEmpty
     * 
     * @param day
     * @return
     * @author thirumalai
     */
    protected boolean isDayEmpty(String day){
		boolean empty = false;
		if(null == day || "".equals(day) || "dd".equalsIgnoreCase(day)){  //$NON-NLS-1$  //$NON-NLS-2$
			empty = true;
		}
		return empty;
	}

	/**
     * isMonthEmpty
     * 
     * @param month
     * @return
     * @author thirumalai
     */
    protected boolean isMonthEmpty(String month){
		boolean empty = false;
		if(null == month || "".equals(month) || "mm".equalsIgnoreCase(month)){  //$NON-NLS-1$  //$NON-NLS-2$
			empty = true;
		}
		return empty;
	}
	
	/**
     * isYearEmpty
     * 
     * @param year
     * @return
     * @author thirumalai
     */
    protected boolean isYearEmpty(String year){
		boolean empty = false;
		if(null == year || "".equals(year) || "yyyy".equalsIgnoreCase(year)){  //$NON-NLS-1$  //$NON-NLS-2$
			empty = true;
		}

		return empty;
	}
	
	/**
     * Saves the errors to current view's view bean. If there are any errors associated with the
     * view it returns an empty ActionErrors object else it returns null ActionErrors object.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 2, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @return ActionErrors
     * @param optionValue 
     */
//	protected ActionErrors saveErrors(HttpServletRequest request, ErrorReport errorReport){
//		ActionErrors actionErrors  = null;
//		if(null != errorReport){
//			OPPTSession opptSession = new OPPTSession(request.getSession());
//			OPPTViewBean viewBean = opptSession.getCurrentViewBean();
//			if(null != viewBean){
//				try{
//					viewBean.setActionForm((OPPTActionForm)BeanUtils.cloneBean(this));
//				}
//				catch(Exception e){
//					// Deliberately left empty.
//				}
//
//				if(0 < errorReport.size()){
//					reset();
//					OPPTMessageCatalog.getInstance().populateErrorReport(errorReport);
//					actionErrors = new ActionErrors();
//					actionErrors.add("userName", new ActionError("error.userName.required"));
//				}
//				viewBean.setErrorReport(errorReport);
//			}
//		}
//		return actionErrors;
//	}
	
	protected String getDefaultOptionValue(String optionValue){
		if(null != optionValue){
			optionValue = optionValue.trim();
			if("Select one".equalsIgnoreCase(optionValue) || "null".equalsIgnoreCase(optionValue)){  //$NON-NLS-1$  //$NON-NLS-2$
				optionValue = null;
			}
		}
		return optionValue;
	}

	/**
     * isAlphaNumeric
     * 
     * @param stringValue
     * @return
     * @author thirumalai
     */
    protected boolean isAlphaNumeric(String stringValue){
		boolean alphaNumeric = true;
		
		if(null != stringValue && 0 < stringValue.trim().length()){
			stringValue = stringValue.trim();
			int length = stringValue.length();
			char lastChar = stringValue.charAt(length-1);

			// Check for proposal name for special characters	
			for(int j=0; j<length; j++)
			{	
				char currentChar = stringValue.charAt(j);
				if (j == 0 && (currentChar == ' ' || lastChar == ' '  || currentChar == '-' || currentChar == '_'))
				{
					alphaNumeric = false;
					break;
				}
				if(!((currentChar >= 'a' && currentChar <= 'z')  || (currentChar >= 'A' && currentChar <= 'Z') || (currentChar >='0' && currentChar <= '9')))
				{
					if(!(( currentChar == '-') || ( currentChar == '_') || ( currentChar == ' ')))
					{
						alphaNumeric = false;
						break;
					}	
				}
				// End of proposal name checking for special characters
			}
		}
		
		return alphaNumeric;
	}

	/**
     * isValidDouble
     * 
     * @param doubleValue
     * @param decimalCount
     * @return
     * @author thirumalai
     */
    protected boolean isValidDouble(double doubleValue, int decimalCount){
		return isValidDouble(String.valueOf(doubleValue), decimalCount);
	}

	/**
     * isValidDouble
     * 
     * @param stringValue
     * @param decimalCount
     * @return
     * @author thirumalai
     */
    protected boolean isValidDouble(String stringValue, int decimalCount){
		boolean validDouble = false;
		if(null != stringValue && 0 < stringValue.length()){
			try{
				Double.parseDouble(stringValue);
				StringTokenizer st = new StringTokenizer(stringValue, ".");  //$NON-NLS-1$
				if(null != st){
					if(1 == st.countTokens()){
						validDouble = true;
					}
					else if(2 == st.countTokens()){
						st.nextToken();
						if(decimalCount >= st.nextToken().length()){
							validDouble = true;
						}
					}
				}
			}
			catch(NumberFormatException ne){
				validDouble = false;
			}
		}
		else{
			validDouble = true;
		}
		
		return validDouble;
	}
	
	/**
     * isValidDouble
     * 
     * @param stringValue
     * @return
     * @author thirumalai
     */
    protected boolean isValidDouble(String stringValue){
		boolean validDouble = true;
		try{
			if(null != stringValue && 0 < stringValue.length()){
				Double.parseDouble(stringValue);
			}
		}
		catch(NumberFormatException ne){
			validDouble = false;
		}
	
		return validDouble;
	}
		
	/**
     * getDoubleValue
     * 
     * @param stringValue
     * @return
     * @author thirumalai
     */
    protected double getDoubleValue(String stringValue){
		return getDoubleValue(stringValue, 0);
	}
	/**
     * getDoubleValue
     * 
     * @param stringValue
     * @param defaultValue
     * @return
     * @author thirumalai
     */
    protected double getDoubleValue(String stringValue, double defaultValue){
		double doubleValue = defaultValue;
		try{
			if(null != stringValue && 0 < stringValue.length()){
				doubleValue = Double.parseDouble(stringValue);
			}
		}
		catch(NumberFormatException ne){
			doubleValue = defaultValue;
		}
	
		return doubleValue;
	}

	/**
     * isValidInt
     * 
     * @param stringValue
     * @return
     * @author thirumalai
     */
    protected boolean isValidInt(String stringValue){
		boolean validInt = true;
		try{
			if(null != stringValue && 0 < stringValue.length()){
				Double.parseDouble(stringValue);
			}
		}
		catch(NumberFormatException ne){
			validInt = false;
		}
	
		return validInt;
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
     * ErrorReport
     * 
     * @return
     * @author thirumalai
     */
    public ErrorReport validate() {
		return new ErrorReport();
	}
    /**
	 * added for contract registration 
     * isAcceptedDateValid
     * 
     * @return boolean
     * @author Gavaskar Bhojan
     */
    public boolean isValidDate(String string){
        OPPTCalender oPPTCalender = null;
        Calendar calender = null;
        Date parsedDate = null;
        int month = 0;
        int day = 0;
        int year =0;
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		 try{  
		 	if(null != string){
		     parsedDate =   format.parse(string);
		     calender =  new  GregorianCalendar();
             calender.setTime(parsedDate);
              month = calender.get(Calendar.MONTH);
              day  = calender.get(Calendar.DATE);
              year = calender.get(Calendar.YEAR);
		 }
    }catch(Exception e){}
           oPPTCalender = new OPPTCalender();
   return oPPTCalender.isValidDate(day,month,year);
}
}