/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.tiles.GetAttributeTag;

import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.QuoteViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;

/**
 * Custom tag that is used for displaying the license
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
public class DisplayQuotesTag extends OPPTTag 
{
	private Map quotes = null;
	private String property = null;
	private boolean requiredError = false;
	
	/**
	 * Overridden method -  
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
		JspWriter out = pageContext.getOut();
		try
		{
			if(null != getQuotes() && 0 < quotes.size())
			{
				out.println("<table align=\"left\" cellspacing=\"1\" cellpadding=\"1\"   summary=\"List of Quotes\"  width=\"600\">" );  //$NON-NLS-1$
				out.println("<tr >");  //$NON-NLS-1$
				if(isRequiredError()){
					out.println("<th width=\"17\" height=\"18\" headers=\"quoteSelector\" class=\"error\">&nbsp;</th>");  //$NON-NLS-1$
				}
				else{
					out.println("<th width=\"17\" height=\"18\" headers=\"quoteSelector\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">&nbsp;</th>");  //$NON-NLS-1$
				}

				out.println("<th width=\"77\" headers=\"inc\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">&nbsp;&nbsp;Inc</th>");  //$NON-NLS-1$
				out.println("<th width=\"125\" headers=\"quote\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">&nbsp;&nbsp;Quote</th>");  //$NON-NLS-1$
				out.println("<th width=\"100\" headers=\"crad\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">&nbsp;&nbsp;CRAD</th>");  //$NON-NLS-1$
				out.println("<th width=\"279\" headers=\"details\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">&nbsp;&nbsp;Details</th>");  //$NON-NLS-1$
				out.println("</tr>");  //$NON-NLS-1$

				Iterator quotesIterator = quotes.keySet().iterator();
				while(quotesIterator.hasNext()){
					String id = (String)quotesIterator.next();
					QuoteViewBean quote = (QuoteViewBean)quotes.get(id);
					if(null != quote){
						out.println("<tr valign=\"bottom\">");  //$NON-NLS-1$
						out.println("<td id=\"quoteSelector\">");  //$NON-NLS-1$
						if(quote.isSelected()){
							out.println("<input type=\"checkbox\" value=\""+id+"\" name=\""+property+"\" id=\""+quote.getId()+"\" checked=\"checked\" />");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$
						}
						else{
							out.println("<input type=\"checkbox\" value=\""+id+"\" name=\""+property+"\" id=\""+quote.getId()+"\" />");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$
						}
						out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						if(quote.isQuoteAdded()){
							out.println("<td id=\"inc\" align=\"center\">&nbsp;&nbsp;*<br />");  //$NON-NLS-1$
						}
						else{
							out.println("<td id=\"inc\" align=\"center\">&nbsp;&nbsp;"+getValue(quote.getInc(), ""));  //$NON-NLS-2$  //$NON-NLS-1$
						}
						out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td id=\"quote\">&nbsp;&nbsp;<label for=\""+quote.getId()+"\">"+getValue(quote.getQuoteNumber(), "")+"</label>");  //$NON-NLS-3$  //$NON-NLS-4$  //$NON-NLS-1$  //$NON-NLS-2$
						out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td id=\"crad\">&nbsp;&nbsp;"+getDateValue(quote.getCraid(), ""));  //$NON-NLS-2$  //$NON-NLS-1$
						out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td id=\"details\">&nbsp;&nbsp;"+getValue(quote.getDetails(), ""));  //$NON-NLS-2$  //$NON-NLS-1$
						out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("</tr>");  //$NON-NLS-1$
						/* CR0531074816 - CBS OPPT accessibility issues
						out.println("<tr>");  //$NON-NLS-1$
						out.println("<td valign=\"bottom\"><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td valign=\"bottom\"><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td valign=\"bottom\"><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td valign=\"bottom\"><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td valign=\"bottom\"><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("</tr>");  //$NON-NLS-1$	*/					
					}
				}
				out.println("</table>");  //$NON-NLS-1$
			}
			else{
				out.println("<p>"+Constants.NO_QUOTES+"</p>");  //$NON-NLS-2$  //$NON-NLS-1$
			}
			
			out.flush();
		}
		catch(IOException ioe){
			throw new JspException( "I/O Error : " + ioe.getMessage() );  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}

	/**
	 * Returns selected property value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * Returns quotes collection 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Map
	 */
	public Map getQuotes() {
		return quotes;
	}

	/**
	 * Sets property value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProperty String 
	 */
	public void setProperty(String newProperty) {
		property = newProperty;
	}

	/**
	 * Sets quotes collection 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newQuotes Map 
	 */
	public void setQuotes(Map newQuotes) {
		quotes = newQuotes;
	}

	/**
	 * Returns if the required field error occured 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isRequiredError() {
		return requiredError;
	}

	/**
	 * Sets required error flag value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newRequiredError boolean
	 */
	public void setRequiredError(boolean newRequiredError) {
		requiredError = newRequiredError;
	}
}