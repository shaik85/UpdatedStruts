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
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.SWOViewBean;
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
public class RemoveProposalSharingTag extends OPPTTag
{
	private TreeMap users = null;
	private String message = null;
	private String id = "users";  //$NON-NLS-1$
	
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
		StringBuffer buffer = new StringBuffer();
		try
		{
			if(null != users && 0 < users.size()){
				buffer.append("<tr align=\"left\">");  //$NON-NLS-1$
				buffer.append("<td style=\"background-color:#cccccc;\" class=\"bar-blue-med\" width=\"27\" height=\"18\" id=\"userId\">&nbsp;</td>");  //$NON-NLS-1$
				buffer.append("<td style=\"background-color:#cccccc;\" class=\"bar-blue-med\" width=\"410\" id=\"userName\">&nbsp;&nbsp;User name</td>");  //$NON-NLS-1$
				buffer.append("</tr>");  //$NON-NLS-1$

				Iterator iterator = users.keySet().iterator();
				while(iterator.hasNext()){
					String userId = (String)iterator.next();
					String userName = (String)users.get(userId);

					buffer.append(getUserRow(userId, userName));
					buffer.append("\n");  //$NON-NLS-1$
				}
			}
			else{
				buffer.append("<tr >");  //$NON-NLS-1$
				buffer.append("<td style=\"background-color:#cccccc;\" class=\"bar-blue-med\" colspan=\"2\">");  //$NON-NLS-1$
				buffer.append(getValue(message, ""));  //$NON-NLS-1$
				buffer.append("</td>");  //$NON-NLS-1$
				buffer.append("</tr>");  //$NON-NLS-1$
			}
			
			out.println(buffer.toString());
			out.flush();
		}
		catch(IOException ioe){
			throw new JspException( "I/O Error : " + ioe.getMessage() );  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}
	
	/**
	 * Returns users to whom the proposal is shared. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getUsers() {
		return users;
	}

	/**
	 * Sets users collection to whom the proposal is shared 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newUsers TreeMap 
	 */
	public void setUsers(TreeMap newUsers) {
		users = newUsers;
	}
	
	private String getUserRow(String userId, String userName){
		StringBuffer buffer = new StringBuffer();
		
		if(null != userId){
			if(null == userName){
				userName = userId;
			}
			buffer.append("<tr valign=\"bottom\">");  //$NON-NLS-1$

			buffer.append("<td  width=\"40\" align=\"center\" headers=\"userId\">&nbsp;&nbsp;");  //$NON-NLS-1$
			buffer.append("<input type=\"checkbox\" name=\""+id+"\" value=\""+userId+"\" id=\"check"+userId+"\" /> <br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$
			buffer.append("<td width=\"410\" headers=\"userName\">&nbsp;&nbsp;");  //$NON-NLS-1$
			buffer.append("<label for=\"check"+userId+"\">"+userName+"</label> <br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
			buffer.append("</tr>");  //$NON-NLS-1$
			/* CR0531074816 - CBS OPPT accessibility issues
			buffer.append("<tr>");  //$NON-NLS-1$
			buffer.append("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
			buffer.append("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
			buffer.append("</tr>");  //$NON-NLS-1$ */
		}
		
		return buffer.toString(); 
	}
	
	/**
	 * Returns message to be displayed when there are no users to whom the proposal is shared 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message to be displayes when there are no users to whom the proposal is shared 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMessage String 
	 */
	public void setMessage(String newMessage) {
		message = newMessage;
	}
	
	/**
	 * Returns the check box identifier name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets check box identifier name. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newId String 
	 */
	public void setId(String newId) {
		id = newId;
	}
}