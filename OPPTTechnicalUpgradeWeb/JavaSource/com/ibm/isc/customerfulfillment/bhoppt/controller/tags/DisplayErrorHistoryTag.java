/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.sql.Time;
import java.util.*;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ErrorInfoViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;

/**
 * Custom tag that is used for displaying the license
 * 
 * <strong>r /><PRE> 
 * date Nov 12, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><strong>r /> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class DisplayErrorHistoryTag extends OPPTTag 
{
	private Map errorHistory = null;
	private String property = "selectedIds";  //$NON-NLS-1$
	
	private String headerStyle = "lgray";  //$NON-NLS-1$
	private String url = null;
	private boolean editable = true;
	
	/**
	 * Overridden method -  
	 * 
	 * <strong>r /><PRE> 
	 * date Nov 13, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><strong>r /> 
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag() 
	 * @return
	 * @throws JspException 
	 *
	 */
	public int doStartTag() throws JspException 
	{
		JspWriter out = pageContext.getOut();
		try
		{
			if(null != errorHistory && 0 < errorHistory.size())
			{
				Iterator iterator = errorHistory.values().iterator();
				if(null != iterator)
				{ 
					out.println("<table class=\"ibm-data-table\" cellpadding=\"1\" cellspacing=\"1\" border=\"0\" summary=\"Display Error details\" width=\"650\">");  //$NON-NLS-1$
					out.println("<tr style=\"background-color:#cccccc;\" class=\"dark\">");  //$NON-NLS-1$
					out.println("<th nowrap=\"nowrap\" width=\"12\" height=\"18\" id=\"errorHistorySelector\">&nbsp;&nbsp;</th>");  //$NON-NLS-1$
					out.println("<th nowrap=\"nowrap\" width=\"150\" height=\"18\" id=\"userId\">User id</th>");  //$NON-NLS-1$
					out.println("<th nowrap=\"nowrap\" width=\"80\" height=\"18\" id=\"messageNo\">Message&nbsp;no.</th>");  //$NON-NLS-1$
					out.println("<th nowrap=\"nowrap\" width=\"240\" height=\"18\" id=\"messageDescription\">Message description</th>");  //$NON-NLS-1$
					out.println("<th nowrap=\"nowrap\" width=\"135\" height=\"18\" id=\"dateTime\">Date - Time</th>");  //$NON-NLS-1$
					out.println("</tr>");  //$NON-NLS-1$
					int count =1;
					while(iterator.hasNext())
					{
						ErrorInfoViewBean errorInfo = (ErrorInfoViewBean)iterator.next();
						if(null != errorInfo)
						{
							if((count % 2) == 1) {
								out.println("<tr class=\"white\">");  //$NON-NLS-1$
							}
							else {
								out.println("<tr class=\"gray\">");  //$NON-NLS-1$
							}
							out.print("<td align=\"center\" valign=\"bottom\" headers=\"errorHistorySelector\">");  //$NON-NLS-1$
							if(isEditable()){
								out.print("<input type=\"checkbox\" name=\""+property+"\" id=\""+errorInfo.getId()+"\" value=\""+errorInfo.getId()+"\" />");  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-4$  //$NON-NLS-1$
							}
							else{
								out.print("&nbsp;");  //$NON-NLS-1$
							}
							out.println("</td>");  //$NON-NLS-1$
							out.println("<td valign=\"bottom\" headers=\"userId\">"+errorInfo.getUserId());  //$NON-NLS-1$
							out.println("</td>");  //$NON-NLS-1$
							if(null != errorInfo.getErrorDetails() && null != url){
								out.println("<td valign=\"bottom\" headers=\"messageNo\"><label for=\""+errorInfo.getId()+"\"><a href=\""+url+"?errorId="+errorInfo.getId()+"\">"+errorInfo.getMessageNumber()+"</a></label><strong>");  //$NON-NLS-2$  //$NON-NLS-4$  //$NON-NLS-1$  //$NON-NLS-5$  //$NON-NLS-3$
							}
							else{
								out.println("<td valign=\"bottom\" headers=\"messageNo\"><label for=\""+errorInfo.getId()+"\">"+errorInfo.getMessageNumber()+"</label>");  //$NON-NLS-2$  //$NON-NLS-1$  //$NON-NLS-3$
							}
							out.println("</td>");  //$NON-NLS-1$
							out.println("<td valign=\"bottom\" headers=\"messageDescription\">"+errorInfo.getMessageDescription());  //$NON-NLS-1$
							out.println("</td>");  //$NON-NLS-1$
							out.println("<td valign=\"bottom\" headers=\"dateTime\">"+getDateTime(errorInfo.getDate(), errorInfo.getTime()));  //$NON-NLS-1$
							out.println("</td>");  //$NON-NLS-1$
							out.println("</tr>");  //$NON-NLS-1$
						}
						count++;
					}
					out.println("</table>");  //$NON-NLS-1$
				}
			}
			else{
				out.println("<p>"+Constants.NO_ERROR_HISTORY_FOR_PROPOSAL+"</p>");  //$NON-NLS-1$  //$NON-NLS-2$
			}
			out.flush();
		}
		catch(IOException ioe){
			throw new JspException( "I/O Error : " + ioe.getMessage() );  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}
	
	/**
	 * Returns errorHistory collection 
	 * 
	 * <strong>r><strong>>Known Bugs</strong><strong>r> 
	 * 
	 * <strong>r><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><strong>r> 
	 * 
	 * @return Map 
	 */
	public Map getErrorHistory() {
		return errorHistory;
	}

	/**
	 *  Sets error history collection
	 * 
	 * <strong>r><strong>>Known Bugs</strong><strong>r> 
	 * 
	 * <strong>r><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><strong>r> 
	 * 
	 * @param newErrorHistory Map 
	 */
	public void setErrorHistory(Map newErrorHistory) {
		errorHistory = newErrorHistory;
	}
	
	/**
	 * Returns header style 
	 * 
	 * <strong>r><strong>>Known Bugs</strong><strong>r> 
	 * 
	 * <strong>r><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><strong>r> 
	 * 
	 * @return String
	 */
	public String getHeaderStyle() {
		return headerStyle;
	}

	/**
	 * Sets header style 
	 * 
	 * <strong>r><strong>>Known Bugs</strong><strong>r> 
	 * 
	 * <strong>r><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><strong>r> 
	 * 
	 * @param newHeaderStyle String 
	 */
	public void setHeaderStyle(String newHeaderStyle) {
		headerStyle = newHeaderStyle;
	}

	/**
	 * Returne input property name 
	 * 
	 * <strong>r><strong>>Known Bugs</strong><strong>r> 
	 * 
	 * <strong>r><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><strong>r> 
	 * 
	 * @return String
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * Sets input property name 
	 * 
	 * <strong>r><strong>>Known Bugs</strong><strong>r> 
	 * 
	 * <strong>r><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><strong>r> 
	 * 
	 * @param newProperty String 
	 */
	public void setProperty(String newProperty) {
		property = newProperty;
	}
	
	/**
	 * Error details url 
	 * 
	 * <strong>r><strong>>Known Bugs</strong><strong>r> 
	 * 
	 * <strong>r><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><strong>r> 
	 * 
	 * @return String
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets error details url 
	 * 
	 * <strong>r><strong>>Known Bugs</strong><strong>r> 
	 * 
	 * <strong>r><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><strong>r> 
	 * 
	 * @param newUrl String 
	 */
	public void setUrl(String newUrl) {
		url = newUrl;
	}
	
	private String getDateTime(Date date, Time time){
		String dateTime = null;
		dateTime = getDateValue(date, "")+" "+time;  //$NON-NLS-2$  //$NON-NLS-1$
		return dateTime;
	}
	
	/**
	 * Returns if error history is editable 
	 * 
	 * <strong>r><strong>>Known Bugs</strong><strong>r> 
	 * 
	 * <strong>r><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><strong>r> 
	 * 
	 * @return boolean
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * Sets error history editable flag. By default it is true. 
	 * 
	 * <strong>r><strong>>Known Bugs</strong><strong>r> 
	 * 
	 * <strong>r><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><strong>r> 
	 * 
	 * @param newEditable boolean 
	 */
	public void setEditable(boolean newEditable) {
		editable = newEditable;
	}
}