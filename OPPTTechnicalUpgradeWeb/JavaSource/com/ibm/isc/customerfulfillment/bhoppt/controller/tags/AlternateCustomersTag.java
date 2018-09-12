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

import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerListCustomerViewBean;

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
public class AlternateCustomersTag extends OPPTTag {
	private Map alternateCustomers = null;
	private String alternateSeperator = "alternate";  /* NOI18N */
	private String stpProperty = "selectedSTP";  /* NOI18N */
	private String invProperty = "selectedINV";  /* NOI18N */

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
			if(null != alternateCustomers && 0 < alternateCustomers.size()) 
			{
				Iterator customersIterator = alternateCustomers.values().iterator();
				out.println("<table cellpadding=\"1\" cellspacing=\"1\" width=\"600\" summary=\"Alternate Customer List\">");  /* NOI18N */
				while(customersIterator.hasNext()){
					CustomerListCustomerViewBean customer = (CustomerListCustomerViewBean)customersIterator.next();
					String id = alternateSeperator+Constants.STRING_SEPERATOR+customer.getCustomerNumber();
					out.println("<tr valign=\"bottom\">");  /* NOI18N */
					if(customer.isSelectedSTP()){
						out.println("<td width=\"32\" align=\"center\">&nbsp;<input type=\"radio\" name=\""+stpProperty+"\" id=\"radLegCustNo\" value=\""+id+"\" checked=\"checked\" /><br />");  /* NOI18N */  /* NOI18N */  /* NOI18N */
					} 
					else{
						out.println("<td width=\"32\" align=\"center\">&nbsp;<input type=\"radio\" name=\""+stpProperty+"\" id=\"radLegCustNo\" value=\""+id+"\" /><br />");  /* NOI18N */  /* NOI18N */  /* NOI18N */
					}
					out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  /* NOI18N */
					if(customer.isInvSelected()){
						out.println("<td width=\"32\" align=\"center\">&nbsp;*<br />");  /* NOI18N */
						out.println("<input type=\"hidden\" name=\""+invProperty+"\" value=\""+id+"\" />");  /* NOI18N */  /* NOI18N */  /* NOI18N */
					}
					else if(customer.isUserINVSelection()){
						out.println("<td width=\"32\" align=\"center\">&nbsp;<input type=\"checkbox\" name=\""+invProperty+"\" id=\""+customer.getCustomerNumber()+"\" value=\""+id+"\" checked=\"checked\" /><br />");  /* NOI18N */  /* NOI18N */  /* NOI18N */  /* NOI18N */
					}
					else{
						out.println("<td width=\"32\" align=\"center\">&nbsp;<input type=\"checkbox\" name=\""+invProperty+"\" id=\""+customer.getCustomerNumber()+"\" value=\""+id+"\" /><br />");  /* NOI18N */  /* NOI18N */  /* NOI18N */  /* NOI18N */
					}
					out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  /* NOI18N */
					out.println("<td width=\"155\">&nbsp;&nbsp;<label for=\"radLegCustNo\">"+getValue(customer.getLegacyCustomerNumberWithAS(), "")+"</label><br />");  //$NON-NLS-2$  //$NON-NLS-3$  /* NOI18N */
					out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					out.println("<td width=\"105\">&nbsp;&nbsp;<label for=\""+customer.getCustomerNumber()+"\">"+getValue(customer.getCustomerNumber(), "")+"</label><br />");  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
					out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					out.println("<td width=\"261\">&nbsp;&nbsp;"+getValue(customer.getCustomerName(), "")+"<br />");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
					out.println("</tr>");  //$NON-NLS-1$
				}
				out.println("</table>");  //$NON-NLS-1$
			}
			out.flush();
		} catch (IOException ioe) {
			throw new JspException("I/O Error : " + ioe.getMessage());  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}

	/**
	 * Returns inventory property value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getInvProperty() {
		return invProperty;
	}

	/**
	 * Sets inventory property value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getStpProperty() {
		return stpProperty;
	}

	/**
	 * Sets inventory property value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newInvProperty String 
	 */
	public void setInvProperty(String newInvProperty) {
		invProperty = newInvProperty;
	}

	/**
	 * Sets stp property value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStpProperty String 
	 */
	public void setStpProperty(String newStpProperty) {
		stpProperty = newStpProperty;
	}

	/**
	 * Returns the collection of alternate customers 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Map
	 */
	public Map getAlternateCustomers() {
		return alternateCustomers;
	}

	/**
	 * Sets altenate customers collection 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAlternateCustomers Map
	 */
	public void setAlternateCustomers(Map newAlternateCustomers) {
		alternateCustomers = newAlternateCustomers;
	}
	
	/**
	 * Returns alternate seperator value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getAlternateSeperator() {
		return alternateSeperator;
	}

	/**
	 * Sets alternate seperator value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAlternateSeperator String 
	 */
	public void setAlternateSeperator(String newAlternateSeperator) {
		alternateSeperator = newAlternateSeperator;
	}
}