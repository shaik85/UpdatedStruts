/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.*;
import java.util.Iterator;
import java.util.TreeMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.*;
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
public class DisplayErrorDetailsTag extends OPPTTag
{
	private List errorDetails = null;
	private String headerStyle = "lgray";  //$NON-NLS-1$
	
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
			if(null != errorDetails && 0 < errorDetails.size())
			{
				int size = errorDetails.size();
				if(0 < size)
				{
					out.println("<tr style=\"background-color:#cccccc;\" class=\"dark\">");  //$NON-NLS-1$
					out.println("<td nowrap=\"nowrap\" width=\"97\" height=\"18\">Exception code</td>");  //$NON-NLS-1$
					out.println("<td nowrap=\"nowrap\" width=\"77\">Sales doc no.</td>");  //$NON-NLS-1$
					out.println("<td nowrap=\"nowrap\" width=\"97\">Item position no.</td>");  //$NON-NLS-1$
					out.println("<td nowrap=\"nowrap\" width=\"117\">Internal contract no.</td>");  //$NON-NLS-1$
					out.println("<td nowrap=\"nowrap\" width=\"197\">Message</td>");  //$NON-NLS-1$
					out.println("</tr>");  //$NON-NLS-1$
                    
					int count = 1; 
					for(int i=0; i<size; i++)
					{
						ErrorDetailsViewBean errorDetail = (ErrorDetailsViewBean)errorDetails.get(i);
						if(null != errorDetail)
						{
							if((count % 2) == 1) {
								out.println("<tr class=\"white\">");  //$NON-NLS-1$
							}
							else {
								out.println("<tr class=\"gray\">");  //$NON-NLS-1$
							}
							out.println("<td>"+getValue(errorDetail.getExceptionCode(), ""));  //$NON-NLS-1$  //$NON-NLS-2$
							out.println("</td>");  //$NON-NLS-1$
							out.println("<td>"+getValue(errorDetail.getSalesDocNumber(), ""));  //$NON-NLS-1$  //$NON-NLS-2$
							out.println("</td>");  //$NON-NLS-1$
							out.println("<td>"+getValue(errorDetail.getItemPositionNumber(), ""));  //$NON-NLS-1$  //$NON-NLS-2$
							out.println("</td>");  //$NON-NLS-1$
							out.println("<td>"+getValue(errorDetail.getInternalContractNumber(), ""));  //$NON-NLS-1$  //$NON-NLS-2$
							out.println("</td>");  //$NON-NLS-1$
							out.println("<td>"+getValue(errorDetail.getMessage(), ""));  //$NON-NLS-1$  //$NON-NLS-2$
							out.println("</td>");  //$NON-NLS-1$
							out.println("</tr>");  //$NON-NLS-1$
						}
						count++;
					}
				}

			}
			out.flush();
		}
		catch(IOException ioe){
			throw new JspException( "I/O Error : " + ioe.getMessage() );  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}
	
	/**
	 * Returns header style 
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
	public String getHeaderStyle() {
		return headerStyle;
	}

	/**
	 * Sets header style 
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
	 * @param newHeaderStyle String 
	 */
	public void setHeaderStyle(String newHeaderStyle) {
		headerStyle = newHeaderStyle;
	}

	/**
	 * Returns error details collection 
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
	public List getErrorDetails() {
		return errorDetails;
	}

	/**
	 * Sets error details collection 
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
	 * @param newErrorDetails List 
	 */
	public void setErrorDetails(List newErrorDetails) {
		errorDetails = newErrorDetails;
	}
}
