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

import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorEntry;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * This is a tag that will be used to display confirmation messages to the user. Given the 
 * collection of confirmation messages, this tag creates the headers, footers and title for 
 * confirmation.
 *
 * Usage of the tag:
 * 		<code><oppt:displayConfirmation messages="<%=bean.getMessages()%>" /></code>  
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
public class DisplayConfirmationTag extends OPPTTag 
{
	private static final String CLASS_NAME="DisplayConfirmationTag";  //$NON-NLS-1$
	private ErrorReport messages = null;
	private String header = Constants.CONFIRMATION_HEADER;
	private String footer = Constants.CONFIRMATION_FOOTER;
	
	/**
	 * Overridden method - All the processing that is required to display the messages should 
	 * be done at the start of the tag. So override the doStartTag to have logic for displaying 
	 * the confirmation messages. 
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
		String methodName="doStartTag";  //$NON-NLS-1$
		JspWriter out = pageContext.getOut();
		
		try {
			if(null != messages && 0 < messages.size())
			{
				out.println("<p><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></p>");  //$NON-NLS-1$
				out.println(getHeader());
				Iterator iterator = messages.values().iterator();
				out.println("<ul>");  //$NON-NLS-1$
				while(iterator.hasNext()) 
				{
					ErrorEntry errorEntry = (ErrorEntry)iterator.next();
					if(null != errorEntry){
						out.println("<li>"+getValue(errorEntry.getErrorMessage(), "")+"</li>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					}
				}
				out.println("</ul>");  //$NON-NLS-1$
				out.println("<p><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></p>");  //$NON-NLS-1$
			}
			out.println("<p>"+getFooter()+"</p>");  //$NON-NLS-2$  //$NON-NLS-1$
			out.flush();
		}
		catch(IOException ioe) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ioe);  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}
	
	/**
	 * Return the collection of messages that are given to the DisplayConfirmationTag for display.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 13, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ErrorReport
	 */
	public ErrorReport getMessages() {
		return messages;
	}
	
	/**
	 * Sets the collection passed as the messages to be diplayed for confirmation.
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 13, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMessages ErrorReport value which is the collection of confirmation messages.
	 */
	public void setMessages(ErrorReport newMessages) {
		messages = newMessages;
	}
	
	/**
	 * Returns the footer value for the confirmation view 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getFooter() {
		return footer;
	}

	/**
	 * Returns the header value for the confirmation view 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String 
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * Sets the footer value for the confirmation view 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newFooter String 
	 */
	public void setFooter(String newFooter) {
		footer = newFooter;
	}

	/**
	 * Sets the header value for the confirmation view 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newHeader String 
	 */
	public void setHeader(String newHeader) {
		header = newHeader;
	}
}
