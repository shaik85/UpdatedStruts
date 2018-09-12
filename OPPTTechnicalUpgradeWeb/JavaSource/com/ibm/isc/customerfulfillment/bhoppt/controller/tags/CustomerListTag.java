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

import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerListViewBean;

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
public class CustomerListTag extends OPPTTag {
	//private TreeMap customerLists = null;
	private String selectProperty = "selectedCustomers";  //$NON-NLS-1$
	private String deleteProperty = "deleteCustomers";  //$NON-NLS-1$
	private boolean changeProposal = false;
	//DADO02
	private TreeMap siteIDLists = null;

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
			if (null != siteIDLists) 
			{
				int size = siteIDLists.size();
				if (0 < size) 
				{
					out.println("<table   cellspacing=\"1\" cellpadding=\"1\" width=\"500\" summary=\"Customer List Details\">");  //$NON-NLS-1$
					out.println("<tr align=\"left\" style=\"background-color:#cccccc;\" valign=\"bottom\">");  //$NON-NLS-1$
					if (isChangeProposal()) 
					{
						out.println("<th width=\"50\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Add</th>");  //$NON-NLS-1$
						//out.println("<th width=\"50\" class=\"bar-blue-med\">Delete</th>");  //$NON-NLS-1$
						out.println("<th width=\"195\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Customer  number</th>");  //$NON-NLS-1$
						out.println("<th width=\"371\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Customer  name</th>");  //$NON-NLS-1$
					} 
					else 
					{
						out.println("<th width=\"25\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">&nbsp;</th>"); //$NON-NLS-1$
						out.println("<th width=\"195\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Customer number</th>"); //$NON-NLS-1$
						out.println("<th width=\"371\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Customer name</th>"); //$NON-NLS-1$
					}
					out.println("</tr>");  //$NON-NLS-1$

					Iterator customerListIterator = siteIDLists.keySet().iterator();
					while (customerListIterator.hasNext()) 
					{
						String key = customerListIterator.next().toString();
						
						CustomerListViewBean viewBean = (CustomerListViewBean) siteIDLists.get(key);
						if (null != viewBean) 
						{
							if(changeProposal){
							 
							 	out.println("<tr>"); //$NON-NLS-1$
								out.println("<td align=\"center\">"); //$NON-NLS-1$
								if (viewBean.isAlreadyExists()) 
								{   out.println("*<br />"); //$NON-NLS-1$
								    out.println("<input type=\"hidden\" name=\""+selectProperty+"\" value=\""+key+"\" />"); //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
								} 
								else 
								{
									if(viewBean.isSelected()){
										out.println("<input type=\"checkbox\" name=\""+selectProperty+"\" id=\"" + key + "\" value=\"" + key + "\" checked=\"checked\" /><br />"); //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-2$  //$NON-NLS-3$
									}
									else{
										out.println("<input type=\"checkbox\" name=\""+selectProperty+"\" id=\"" + key + "\" value=\"" + key + "\" /><br />"); //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-2$  //$NON-NLS-3$
									}
								}
								/*DADO02 Sateesh Anne BlueHarmony out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); //$NON-NLS-1$
								out.println("<td align=\"center\">"); //$NON-NLS-1$
								  if (viewBean.isAlreadyExists()) 
								{
									if (viewBean.isCanBeDeleted()) 
									{
										 	if(viewBean.isDeleteSelected()){
										
											out.println("<input type=\"checkbox\" name=\""+deleteProperty+"\" id=\"" + key + "\" value=\"" + key + "\" selected=\"selected\" /><br />"); //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-4$  //$NON-NLS-3$
										}
										else{
											out.println("<input type=\"checkbox\" name=\""+deleteProperty+"\" id=\"" + key + "\" value=\"" + key + "\" /><br />"); //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-2$  //$NON-NLS-3$
										}
									} 
									else 
									{   
										out.println("*<br />");  //$NON-NLS-1$
									}
								} 
								else 
								{   
									out.println("&nbsp");  //$NON-NLS-1$
								}*/
								out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); //$NON-NLS-1$
								out.println("<td>&nbsp;&nbsp;<label for=\"" + key + "\">" + getValue(viewBean.getCustomerNumber(), "") + "</label><br />"); //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-4$  //$NON-NLS-2$
								out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); //$NON-NLS-1$
								out.println("<td> &nbsp;&nbsp;"+ getValue(viewBean.getCustomerName(), "") + "<br />"); //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
								out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); //$NON-NLS-1$
								out.println("</tr>"); //$NON-NLS-1$
								/* CR0531074816 - CBS OPPT accessibility issues
								out.println("<tr>"); //$NON-NLS-1$
								out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); //$NON-NLS-1$
								out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); //$NON-NLS-1$
								out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); //$NON-NLS-1$
								out.println("</tr>"); //$NON-NLS-1$ 		
*/								
							}
							else{
								out.println("<tr valign=\"bottom\">"); //$NON-NLS-1$
								out.println("<td align=\"center\">"); //$NON-NLS-1$
								if (viewBean.isAlreadyExists()) 
								{
									out.println("*<br />"); //$NON-NLS-1$
								} 
								else 
								{
									if(viewBean.isSelected()){
										out.println("<input type=\"checkbox\" name=\""+selectProperty+"\" id=\"" + key + "\" value=\"" + key + "\" checked=\"checked\" /><br />"); //$NON-NLS-1$  //$NON-NLS-3$  /* NOI18N */  /* NOI18N */
									}
									else{
										out.println("<input type=\"checkbox\" name=\""+selectProperty+"\" id=\"" + key + "\" value=\"" + key + "\" /><br />"); //$NON-NLS-1$  /* NOI18N */  //$NON-NLS-2$  //$NON-NLS-3$
									}
								}
								out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); //$NON-NLS-1$
								out.println("<td>&nbsp;&nbsp;<label for=\"" + key + "\">" + getValue(viewBean.getCustomerNumber(), "") + "</label><br />"); //$NON-NLS-1$  /* NOI18N */  /* NOI18N */  /* NOI18N */
								out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); //$NON-NLS-1$
								out.println("<td>&nbsp;&nbsp;" + getValue(viewBean.getCustomerName(), "") + "<br />"); //$NON-NLS-1$  /* NOI18N */  /* NOI18N */
								out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); //$NON-NLS-1$
								out.println("</tr>"); //$NON-NLS-1$
								/* CR0531074816 - CBS OPPT accessibility issues
								out.println("<tr>"); //$NON-NLS-1$
								out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); //$NON-NLS-1$
								out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); //$NON-NLS-1$
								out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>"); //$NON-NLS-1$
								out.println("</tr>"); //$NON-NLS-1$ */
							}
						}
					}
					out.println("</table>"); //$NON-NLS-1$
				}
			}
			out.flush();
		} catch (IOException ioe) {
			throw new JspException("I/O Error : " + ioe.getMessage());  //$NON-NLS-1$
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
	/*public TreeMap getCustomerLists() {
		return customerLists;
	}*/

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
	/*public void setCustomerLists(TreeMap newCustomerLists) {
		customerLists = newCustomerLists;
	}
*/
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
	public String getSelectProperty() {
		return selectProperty;
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
	 * @param newSelectProperty String 
	 */
	public void setSelectProperty(String newSelectProperty) {
		selectProperty = newSelectProperty;
	}

	/**
	 * Returns change proposal flag value 
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
	 * @return boolean
	 */
	public boolean isChangeProposal() {
		return changeProposal;
	}

	/**
	 * Sets change proposal fla value 
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
	 * @param newChangeProposal boolean
	 */
	public void setChangeProposal(boolean newChangeProposal) {
		changeProposal = newChangeProposal;
	}
	
	/**
	 * Returns delete check box property name value 
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
	public String getDeleteProperty() {
		return deleteProperty;
	}

	/**
	 *Sets delete property name value 
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
	 * @param newDeleteProperty String 
	 */
	public void setDeleteProperty(String newDeleteProperty) {
		deleteProperty = newDeleteProperty;
	}
	/**
	 * @return Returns the siteIDLists.
	 */
	public TreeMap getSiteIDLists() {
		return siteIDLists;
	}
	/**
	 * @param siteIDLists The siteIDLists to set.
	 */
	public void setSiteIDLists(TreeMap siteIDLists) {
		this.siteIDLists = siteIDLists;
	}
}
