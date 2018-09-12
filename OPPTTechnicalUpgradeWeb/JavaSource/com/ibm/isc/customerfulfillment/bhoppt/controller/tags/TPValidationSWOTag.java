/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;

import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SWOTPViewBean;

/**
 * Custom tag that is used for displaying ineligible licenses
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
public class TPValidationSWOTag extends OPPTTag {
	private List swos = null;

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
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try 
		{
			if (null != swos) 
			{
				for(int i=0, size=swos.size(); i<size; i++){
					SWOTPViewBean swo = (SWOTPViewBean)swos.get(i);
					if(null != swo){
						out.println("<tr>");  //$NON-NLS-1$
						out.println("<td>&nbsp;&nbsp;"+getValue(swo.getNumber(), "")+"<br />");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
						out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td>&nbsp;&nbsp;"+getValue(swo.getSerialNumber(), "")+"<br />");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
						out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td>&nbsp;&nbsp;"+getValue(swo.getContractNumber(), "")+"<br />");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
						out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td>&nbsp;&nbsp;"+getValue(swo.getContractType(), "")+"<br />");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
						out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("</tr>");  //$NON-NLS-1$
					}
				}
			}
			out.flush();
		} catch (IOException ioe) {
			throw new JspException("I/O Error : " + ioe.getMessage());  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}

	/**
	 * Returns swos collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getSwos() {
		return swos;
	}

	/**
	 * Sets swos collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
	public void setSwos(List list) {
		swos = list;
	}
}
