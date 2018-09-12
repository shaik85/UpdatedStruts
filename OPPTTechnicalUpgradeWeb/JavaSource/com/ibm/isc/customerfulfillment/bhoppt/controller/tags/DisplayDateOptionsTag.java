/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;

/** 
 * Given date object to this tag, this tag is used to display the date in readable format.  
 * 
 * <br /><b>Known Bugs</b><br /> 
 * 
 * <br /><PRE> 
 * date Nov 12, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br /> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class DisplayDateOptionsTag extends OPPTTag 
{
	private List years = null;
	private String name = null;
	private Date date = null;
	private String styleClass = "iform";  /* NOI18N */
	private String alt = null;
	private String month = "Mmm";  /* NOI18N */
	private String year = "yyyy";  /* NOI18N */
	private String day = "dd";  /* NOI18N */
	private String onchange = null;
	private String onclick = null;
	private List nonEditableFields = null;
	private int dateType = 1;
	private boolean mandatory ; 
	private boolean checkMandatory;  
	/**
	 * @return Returns the mandatory.
	 */
	public boolean getMandatory() {
		return mandatory;
	}
	/**
	 * @param mandatory The mandatory to set.
	 */
	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}
	/**
	 * Overridden method - All the processing that is required to display the date should 
	 * be done at the start of the tag. So override the doStartTag to have logic for displaying 
	 * the date. 
	 * 
	 * <br /><PRE> 
	 * date Nov 13, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br /> 
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag() 
	 * @return
	 * @throws JspException 
	 * 			<oppt:date date="<%=view.getContractStartDate()%>" />
			<input type="hidden" name="contractStartDate.day" value="<%=view.getContractStartDateDay() %>" />
			<input type="hidden" name="contractStartDate.month" value="<%=view.getContractStartDateMonth() %>" />
			<input type="hidden" name="contractStartDate.year" value="<%=view.getContractStartDateYear() %>" />
	 *
	 * Changed by Balaji for displaying as per W3V8 standards
	 */
	public int doStartTag() throws JspException 
	{
		JspWriter out = null;
		
		String dayTitle = getAlt()+" day";
		String monthTitle = getAlt()+" month";
		String yearTitle = getAlt()+" year";
		String mandatoryDelimiter ="";


		if(null != getDate()){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(getDate());
			if(9 >= calender.getDay()){
				day = "0"+calender.getDay();  //$NON-NLS-1$
			}
			else{
				day = calender.getDay()+"";  //$NON-NLS-1$
			}
			if(9 >= calender.getMonth()){
				month = "0"+calender.getMonth();  /* NOI18N */
			}
			else{
				month = calender.getMonth()+"";  /* NOI18N */
			}
			year = calender.getYear()+"";  /* NOI18N */
		}
		if(null == getAlt()){
			setAlt(getName());
		}
		
		StringBuffer buffer = new StringBuffer();
		 
		checkMandatory = getMandatory();	
if(checkMandatory){
	mandatoryDelimiter = UtilityConstants.MANDATORY_CHAR;	
}
		if(isFieldEditable()){		
			
//			 Starting with day			
			//buffer.append("<label for=\""+getName()+"Day\"></label>");  /* NOI18N */  /* NOI18N */
			buffer.append("<select aria-required=\"true\" name=\""+getName()+".day\" class=\""+getStyleClass()+"\" title=\""+mandatoryDelimiter+dayTitle+"\"  id=\""+getName()+"Day\" onchange=\""+getOnchangeQuery(3)+ "\">");  //$NON-NLS-2$  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-5$
			if("dd".equalsIgnoreCase(day)){  //$NON-NLS-1$
				buffer.append("<option value=\"dd\" selected=\"selected\">dd</option>");  //$NON-NLS-1$
			}
			else{
				buffer.append("<option value=\"dd\">dd</option>");  //$NON-NLS-1$
			}
			for(int i=1; i<=9; i++)
			{
				String value = "0"+i;  //$NON-NLS-1$
				if(day.equalsIgnoreCase(value)){
					buffer.append("<option value=\""+value+"\" selected=\"selected\">"+value+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
				}
				else{
					buffer.append("<option value=\""+value+"\">"+value+"</option>");  //$NON-NLS-3$  /* NOI18N */  /* NOI18N */
				}
			}
			for(int i=10; i<=31; i++){
				String value = i+"";  //$NON-NLS-1$
				if(day.equalsIgnoreCase(value)){
					buffer.append("<option value=\""+value+"\" selected=\"selected\">"+value+"</option>");  //$NON-NLS-2$  /* NOI18N */  //$NON-NLS-3$
				}
				else{
					buffer.append("<option value=\""+value+"\">"+value+"</option>");  //$NON-NLS-1$  //$NON-NLS-3$  /* NOI18N */
				}
			}
			buffer.append("</select>");  //$NON-NLS-1$
					
			
			
			//buffer.append("<label for=\""+getName()+"Month\">&nbsp;</label>");  //$NON-NLS-2$  //$NON-NLS-1$
			//buffer.append("<select name=\""+getName()+".month\" class=\""+getStyleClass()+"\"  id=\""+getName()+"Month\" onchange=\""+getOnchangeQuery(2)+"\">");  //$NON-NLS-2$  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-5$
			buffer.append("<select aria-required=\"true\" name=\""+getName()+".month\" class=\""+getStyleClass()+"\" title=\""+mandatoryDelimiter+monthTitle+"\" id=\""+getName()+"Month\" onchange=\""+getOnchangeQuery(2)+"\">");  //$NON-NLS-2$  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-5$
			if("mm".equalsIgnoreCase(month)){  /* NOI18N */
				buffer.append("<option value=\"Mmm\" selected=\"selected\">Mmm</option>");  //$NON-NLS-1$
			}
			else{
				buffer.append("<option value=\"Mmm\">Mmm</option>");  //$NON-NLS-1$
			}
			for(int i=1; i<=9; i++)
			{
				String value = "0"+i;  //$NON-NLS-1$
				if(month.equalsIgnoreCase(value)){
					buffer.append("<option value=\""+value+"\" selected=\"selected\">"+OPPTCalender.getMonthDesc(value)+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
				}
				else{
					buffer.append("<option value=\""+value+"\">"+OPPTCalender.getMonthDesc(value)+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
				}
			}
			for(int i=10; i<=12; i++){
				String value = i+"";  //$NON-NLS-1$
				if(month.equalsIgnoreCase(value)){
					buffer.append("<option value=\""+value+"\" selected=\"selected\">"+OPPTCalender.getMonthDesc(value)+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
				}
				else{
					buffer.append("<option value=\""+value+"\">"+OPPTCalender.getMonthDesc(value)+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
				}
			}
			buffer.append("</select>");  //$NON-NLS-1$
			
			//buffer.append("<label for=\""+getName()+"Year\">&nbsp;</label>");  //$NON-NLS-2$  //$NON-NLS-1$
			//buffer.append("<select name=\""+getName()+".year\" class=\""+getStyleClass()+"\"  id=\""+getName()+"Year\" onchange=\""+getOnchangeQuery(1)+"\">");  //$NON-NLS-2$  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-5$
			buffer.append("<select aria-required=\"true\" name=\""+getName()+".year\" class=\""+getStyleClass()+"\" title=\""+mandatoryDelimiter+yearTitle+"\" id=\""+getName()+"Year\" onchange=\""+getOnchangeQuery(1)+"\">");  //$NON-NLS-2$  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-5$

			if("yyyy".equalsIgnoreCase(year)){  //$NON-NLS-1$
				buffer.append("<option value=\"yyyy\" selected=\"selected\">yyyy</option>");  //$NON-NLS-1$
			}
			else{
				buffer.append("<option value=\"yyyy\">yyyy</option>");  //$NON-NLS-1$
			}
			if(null != getYears()){
				for(int i=0, size=getYears().size(); i<size; i++){
					String newYear = getYears().get(i)+"";  //$NON-NLS-1$
					if(year.equalsIgnoreCase(newYear)){
						buffer.append("<option value=\""+newYear+"\" selected=\"selected\">"+newYear+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
					}
					else{
						buffer.append("<option value=\""+newYear+"\">"+newYear+"</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
					}
				}
			}
			buffer.append("</select>");  //$NON-NLS-1$

			
		}
		else{
		//	buffer.append(year+"-"+month+"-"+day);
			buffer.append(day+"-"+OPPTCalender.getMonthDesc(month)+"-"+year);  //$NON-NLS-1$  //$NON-NLS-2$
			
			buffer.append("<input type=\"hidden\" id=\""+getName()+"Day\" name=\""+getName()+".day\" value=\""+day+"\" />");  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
			buffer.append("<input type=\"hidden\" id=\""+getName()+"Month\" name=\""+getName()+".month\" value=\""+month+"\" />");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-4$
			buffer.append("<input type=\"hidden\" id=\""+getName()+"Year\" name=\""+getName()+".year\" value=\""+year+"\" />");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-4$
		}

		try{
			out = pageContext.getOut();
			out.println(buffer.toString());
			out.flush();
		} catch( IOException ioe ) {
			throw new JspException( "I/O Error : " + ioe.getMessage() );  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}

	/**
	 * Returns the date object  
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
	 * @return Date
	 */
	public Date getDate() {
		return date;
	}

	/**
     * Sets the date object
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 2, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param Date newDate
     * @param newDate 
     */
	public void setDate(Date newDate) {
		this.date = newDate;
	}
	
	/**
	 * Returns property name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns collection of years 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getYears() {
		return years;
	}

	/**
	 * Sets property value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newName String
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Sets years collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newYears List 
	 */
	public void setYears(List newYears) {
		years = newYears;
	}

	/**
	 * Returns drop down style class 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getStyleClass() {
		return styleClass;
	}

	/**
	 * Sets style class value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStyleClass String 
	 */
	public void setStyleClass(String newStyleClass) {
		styleClass = newStyleClass;
	}

	/**
	 * Returns alternate text value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getAlt() {
		return alt;
	}

	/**
	 * Sets alternate text value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAlt String 
	 */
	public void setAlt(String newAlt) {
		alt = newAlt;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getDay() {
		return day;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getMonth() {
		return month;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getYear() {
		return year;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setDay(String string) {
		day = string;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setMonth(String string) {
		month = string;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setYear(String string) {
		year = string;
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
	 * date Feb 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getOnchange() {
		return onchange;
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
	 * date Feb 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setOnchange(String string) {
		onchange = string;
	}

	private String getOnchangeQuery(int currentElement){
		StringBuffer buffer = new StringBuffer();
		
		if(null != onchange){
			buffer.append(onchange);
			buffer.append("(");  //$NON-NLS-1$
			buffer.append("this.form."+getName()+"Month, ");  //$NON-NLS-1$  //$NON-NLS-2$
			buffer.append("this.form."+getName()+"Day, ");  //$NON-NLS-1$  //$NON-NLS-2$
			buffer.append("this.form."+getName()+"Year, ");
			buffer.append(currentElement+", ");
			buffer.append(dateType+")");
		}
		
		if(null != onclick){
			buffer.append(onclick);
			buffer.append("(");  //$NON-NLS-1$
			buffer.append("this.form."+getName()+"Month, ");  //$NON-NLS-1$  //$NON-NLS-2$
			buffer.append("this.form."+getName()+"Day, ");  //$NON-NLS-1$  //$NON-NLS-2$
			buffer.append("this.form."+getName()+"Year, ");
			buffer.append(currentElement+", ");
			buffer.append(dateType+")");
		}
		
		return buffer.toString();
	}

	
	/**
	 * Returns collection of non editable field names 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getNonEditableFields() {
		return nonEditableFields;
	}

	/**
	 * Sets collection of non editable field names 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNonEditableFields List
	 */
	public void setNonEditableFields(List newNonEditableFields) {
		nonEditableFields = newNonEditableFields;
	}

	private boolean isFieldEditable(){
		boolean fieldEditable = false;
		if(null != getNonEditableFields())
		{
			if(null != getName())
			{
				if(!getNonEditableFields().contains(getName())){
					fieldEditable = true;
				}
			}
		}
		else{
			fieldEditable = true;
		}
		return fieldEditable;
	}
	
	/**
	 * Returns date type value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getDateType() {
		return dateType;
	}

	/**
	 * Sets date type value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param i 
	 */
	public void setDateType(int i) {
		dateType = i;
	}

	/**
	 * @return Returns the onclick.
	 */
	public String getOnclick() {
		return onclick;
	}
	/**
	 * @param onclick The onclick to set.
	 */
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}
}