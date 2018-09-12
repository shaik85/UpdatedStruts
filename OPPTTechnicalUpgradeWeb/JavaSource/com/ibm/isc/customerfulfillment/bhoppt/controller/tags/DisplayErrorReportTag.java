/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.ibm.isc.customerfulfillment.bhoppt.connector.util.MailMessageConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.PreparedString;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorEntry;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * Given the ErrorReport object this tag is used to diplay all the error messages present in the 
 * ErrorReport to the user. There are two ways in which we can use this page. One is displaying 
 * error messages in an error page and other is displaying the error messages on top of input page 
 * if any errors occur in that page.
 * 
 * When we are displaying the error messages on top of an input page, they have to be displayed 
 * in different color other than red (Usually red). We can specify this color style using style 
 * parameter. 
 * 
 * Sample code:
 * <ul>
 * 		<li>Displaying error report in an error page
 * 			<code><oppt:displayErrorReport errorReport="<%=errorReport%>" style="bbg" errorPage="true" /></code>
 * 		<li>Displaying error report on top of an input page.
 * 			<code><oppt:displayErrorReport errorReport="<%=errorReport%>" style="color: #cc0000" /></code>
 * </ul> 
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
public class DisplayErrorReportTag extends TagSupport 
{
	private static final String CLASS_NAME="DisplayErrorReportTag";
	private ErrorReport errorReport = null;
	private String style = "error";
	private boolean errorPage = false;
	private boolean messagePage = false;

	/**
	 * Overridden method - All the processing that is required to display the error messages should 
	 * be done at the start of the tag. So override the doStartTag to have logic for displaying the 
	 * error messages. 
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
	 *
	 */
	public int doStartTag() throws JspException 
	{
		String methodName="doStartTag";
		if(null != errorReport && 0 < errorReport.size()) {
			JspWriter out = pageContext.getOut();
			Iterator iterator = errorReport.values().iterator();
			try {
		         if(!errorPage && !messagePage)
		         { 
						out.println("<span style=\"color: #CC3333\">");
						out.println("<ul>");
						out.println("<li><a class=\"ibm-error-link\" alt=\"error icon\"></a>");
						out.println("<b>The following needs to be corrected before continuing:</b></li>");
						
						while(iterator.hasNext()) {
							ErrorEntry errorEntry = (ErrorEntry)iterator.next();
							if(null != errorEntry){
								out.println("<li>"+errorEntry.getErrorMessage()+"</li>");
							}
						}
						
						out.println("</span>");
						out.println("</ul>");
						if(!errorPage && !messagePage) {
							out.println("<p><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></p>");	
						}
		         }		
		         else
		         {
		         	out.println("<span style=\"color: #cc0000\">");
		         	out.println("<ul>");
		         	while(iterator.hasNext()) {
						ErrorEntry errorEntry = (ErrorEntry)iterator.next();
						if(null != errorEntry){
							out.println("<li><a class=\"ibm-information-link\" alt=\"information icon\"></a>");
							if(errorEntry.getMessageInputs() == null || errorEntry.getMessageInputs().length == 0) {
								out.println(errorEntry.getErrorMessage()+"</li>");
																			
							}else if(errorEntry.getMessageInputs() != null) {
								try {
									PreparedString str = new PreparedString(errorEntry.getErrorMessage());
									for(int k=0;k<errorEntry.getMessageInputs().length;k++) {
										str.setString(k+1, errorEntry.getMessageInputs()[k]);
									}
									out.println(str.toString());
									
								}catch(Exception e) {
									out.println("<li>"+errorEntry.getErrorMessage()+"</li>");
									
								}
							}
							//out.println("<br />");
						}
					}
		         	out.println("</ul>");
					out.println("</span>");
		         }
				out.flush();
			}
			catch(IOException ioe) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ioe);
			}
		}
		return Tag.SKIP_BODY;
	}
	
	/**
	 * Returns error report object  
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
	 * @return ErrorReport
	 */
	public ErrorReport getErrorReport() {
		return errorReport;
	}
	/**
	 * Returns style object  
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
	 * @return String
	 */
	public String getStyle() {
		return style;
	}
	/**
	 * Returns true if the current page is an error page  
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
	 * @return boolean
	 */
	public boolean isErrorPage() {
		return errorPage;
	}

	/**
	 * Sets error report object  
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
	 * @param newErrorReport ErrorReport
	 */
	public void setErrorReport(ErrorReport newErrorReport) {
		this.errorReport = newErrorReport;
	}
	/**
     * Sets style value
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 2, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newStyle 
     */
	public void setStyle(String newStyle) {
		this.style = newStyle;
	}
	/**
     * Sets error page flag
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 2, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newErrorPage 
     */
	public void setErrorPage(boolean newErrorPage) {
		this.errorPage = newErrorPage;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isMessagePage() {
		return messagePage;
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
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setMessagePage(boolean b) {
		messagePage = b;
	}

}
