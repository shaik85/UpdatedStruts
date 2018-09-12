/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;

import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerListCustomerViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerListViewBean;

/**
 * Custom tag that is used for displaying customer lists
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
public class DisplayCustomerListTag extends OPPTTag 
{
	private TreeMap customerLists = null;
	private String property = null;

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
			if(null != customerLists){
				Iterator iterator = customerLists.values().iterator();
				while(iterator.hasNext()){
					CustomerListViewBean customerList = (CustomerListViewBean)iterator.next();
					if(null != customerList){
						TreeMap customers = customerList.getCustomers();
						if(null != customers && 0 <= customers.size()){
							out.println("<table cellspacing=\"1\" cellpadding=\"1\" border=\"0\" width=\"650\" summary=\"Enterprise Details\">");  //$NON-NLS-1$
							out.println("<tr>");  //$NON-NLS-1$
							out.println("<td colspan=\"2\" width=\"241\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\">Enterprise number: "+getValue(customerList.getListNumber(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
							out.println("<td colspan=\"2\" width=\"403\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\">Enterprise name: "+getValue(customerList.getListName(), "")+"</td>");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
							out.println("</tr>");  //$NON-NLS-1$
							out.println("<tr>");  //$NON-NLS-1$
							out.println("<th width=\"28\"  style=\"background-color:#cccccc;\" class=\"bar-blue-med\">&nbsp;&nbsp;INV</th>");  //$NON-NLS-1$
							out.println("<th width=\"210\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">&nbsp;&nbsp;Legacy cust. no.</th>");  //$NON-NLS-1$
							out.println("<th width=\"120\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">&nbsp;&nbsp;Customer no.</th>");  //$NON-NLS-1$
							out.println("<th width=\"280\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">&nbsp;&nbsp;Customer name</th>");  //$NON-NLS-1$
							out.println("</tr>");  //$NON-NLS-1$
							
							
							 
							Iterator customerIterator = customers.values().iterator();
							while(customerIterator.hasNext()){
								CustomerListCustomerViewBean customer = (CustomerListCustomerViewBean)customerIterator.next();
								String value = customerList.getListNumber() + Constants.STRING_SEPERATOR + customer.getCustomerNumber();
								if(null != customer){
									out.println("<tr valign=\"bottom\">");  //$NON-NLS-1$
									if(customer.isInvSelected()){
										out.println("<td align=\"center\"><img src=\"//w3.ibm.com/ui/v8/images/icon-system-status-ok.gif\" width=\"12\" height=\"10\" alt=\"system status ok icon\" />");  //$NON-NLS-1$
									}
									else{
										out.println("<td align=\"center\"><input type=\"checkbox\" name=\""+getProperty()+"\" id=\""+value+"\" value=\""+value+"\" />");  //$NON-NLS-1$  /* NOI18N */  /* NOI18N */  /* NOI18N */
									}
									out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  /* NOI18N */
									out.println("<td>&nbsp;&nbsp;"+getValue(customer.getLegacyCustomerNumberWithAS(), ""));  /* NOI18N */  /* NOI18N */
									out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  /* NOI18N */
									out.println("<td>&nbsp;&nbsp;"+getValue(customer.getCustomerNumber(), ""));  /* NOI18N */  /* NOI18N */
									out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  /* NOI18N */
									out.println("<td>&nbsp;&nbsp;"+getValue(customer.getCustomerName(), ""));  /* NOI18N */  /* NOI18N */
									out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  /* NOI18N */
									out.println("</tr>");  /* NOI18N */
									/* CR0531074816 - CBS OPPT accessibility issues
									out.println("<tr>"); 
									out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  
									out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); 
									out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); 
									out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); 
									out.println("</tr>");  */  
								}
							}
							out.println("&nbsp;</table>");  /* NOI18N */
						}
						//out.println("<br />");
					}
				}
			}
			
			out.flush();
		}
		catch(IOException ioe){
			throw new JspException( "I/O Error : " + ioe.getMessage() );  /* NOI18N */
		}
		return Tag.SKIP_BODY;
	}

	/**
	 * Returns collection of customer lists 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getCustomerLists() {
		return customerLists;
	}

	/**
	 * Sets customer list selection 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerLists TreeMap 
	 */
	public void setCustomerLists(TreeMap newCustomerLists) {
		customerLists = newCustomerLists;
	}

	/**
	 * Returns the select propoerty values 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
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
	 * Sets select property values 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
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
}
