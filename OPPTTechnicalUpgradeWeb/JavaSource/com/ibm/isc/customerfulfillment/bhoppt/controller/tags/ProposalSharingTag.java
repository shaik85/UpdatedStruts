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

import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalSharingActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;

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
public class ProposalSharingTag extends OPPTTag {
	private TreeMap users = null;
	private TreeMap accessTypes = null;
	private ProposalSharingActionForm actionForm = null;

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
		int count = 0;
		try {
			StringBuffer buffer = new StringBuffer();
			boolean anyUserWithFullAccess = isAnyUserFullAccess();

			buffer.append("<tr>");  //$NON-NLS-1$
			if(anyUserWithFullAccess){
				buffer.append("<th class=\"bar-blue-med\" style=\"background-color:#cccccc;\" height=\"18\">Access type</th>");  //$NON-NLS-1$
			}
			else{
				buffer.append("<th class=\"bar-blue-med\" style=\"background-color:#cccccc;\"colspan=\"2\" height=\"18\">Access type</th>");  //$NON-NLS-1$
			}
			buffer.append("<th class=\"bar-blue-med\" style=\"background-color:#cccccc;\">Access to</th>");  //$NON-NLS-1$
			buffer.append("</tr>");  //$NON-NLS-1$
			
			if (null != actionForm) {
				buffer.append(getUserAccessTypeRow(actionForm.getAccessUser1(), actionForm.getAccessType1(), users, 1, anyUserWithFullAccess));
				buffer.append(getUserAccessTypeRow(actionForm.getAccessUser2(), actionForm.getAccessType2(), users, 2, anyUserWithFullAccess));
				buffer.append(getUserAccessTypeRow(actionForm.getAccessUser3(), actionForm.getAccessType3(), users, 3, anyUserWithFullAccess));
			} else {
				if (null != accessTypes) {
					Iterator sharedUsers = accessTypes.keySet().iterator();
					if (null != sharedUsers) {
						while (sharedUsers.hasNext()) {
							String sharedUserId = (String) sharedUsers.next();
							if (null != sharedUserId) {
								String accessType = (String)accessTypes.get(sharedUserId);
								buffer.append(getUserAccessTypeRow(sharedUserId, accessType, users, ++count, anyUserWithFullAccess));
							}
						}
					}
				}
				++count;
				if (count <= 3) {
					for (int i = count; i <= 3; i++) {
						buffer.append(getUserAccessTypeRow("None", null, users, i, anyUserWithFullAccess));  //$NON-NLS-1$
					}
				}
			}

			out.print(buffer.toString());
			out.flush();
		} catch (IOException ioe) {
			throw new JspException("I/O Error : " + ioe.getMessage());  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}

	/**
	 * Returs user access types collection 
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
	public TreeMap getAccessTypes() {
		return accessTypes;
	}

	/**
	 * Returns users to whom the proposal can be shared collection 
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
	 * Sets user access types collection 
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
	 * @param newAccessTypes TreeMap
	 */
	public void setAccessTypes(TreeMap newAccessTypes) {
		accessTypes = newAccessTypes;
	}

	/**
	 * Sets users collection to whom the proposal can be shared 
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

	private String getUserAccessTypeRow(String userId, String accessType, TreeMap users, int index, boolean anyFullAccessUser) {
		StringBuffer userAccessTypeRow = new StringBuffer();

		userAccessTypeRow.append("<tr valign=\"bottom\">");  //$NON-NLS-1$

		if(anyFullAccessUser && UtilityConstants.SHARED_FULL_MODE.equals(accessType)) 
		{
			userAccessTypeRow.append("<td width=\"297\" height=\"20\">&nbsp;&nbsp;");  //$NON-NLS-1$
			userAccessTypeRow.append("Full");  //$NON-NLS-1$
			userAccessTypeRow.append("</td>");  //$NON-NLS-1$
			userAccessTypeRow.append("<td width=\"297\" height=\"20\">&nbsp;&nbsp;");  //$NON-NLS-1$
			userAccessTypeRow.append(getValue(userId, ""));  //$NON-NLS-1$
			userAccessTypeRow.append("</td>");  //$NON-NLS-1$
		} 
		else 
		{
			String id = "radioRead" + index;  //$NON-NLS-1$
			String accessTypeName = "accessType" + index;  //$NON-NLS-1$
			if (anyFullAccessUser) {
				userAccessTypeRow.append("<td width=\"297\" height=\"30\">&nbsp;&nbsp;");  //$NON-NLS-1$
			} else {
				userAccessTypeRow.append("<td width=\"147\" height=\"30\">&nbsp;&nbsp;");  //$NON-NLS-1$
			}
			
			if(null != accessType && "R".equalsIgnoreCase(accessType)) {  //$NON-NLS-1$
				userAccessTypeRow.append("<input type=\"radio\" name=\""+accessTypeName+"\" value=\"R\" id=\""+id+"\" checked=\"checked\" />");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
			}else {
				userAccessTypeRow.append("<input type=\"radio\" name=\"" + accessTypeName + "\" value=\"R\" id=\"" + id + "\" />");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
			}
			
			userAccessTypeRow.append("&nbsp;<label for=\"" + id + "\">Read</label>");  //$NON-NLS-1$  //$NON-NLS-2$
			if (anyFullAccessUser) {
				userAccessTypeRow.append("<br /><div class=\"ibm-alternate-rule\"><hr/>&nbsp;</div></td>");  //$NON-NLS-1$
			}
			else{
				userAccessTypeRow.append("<br /><div class=\"ibm-alternate-rule\"><hr/>&nbsp;</div></td>");  //$NON-NLS-1$
				id = "radioFull" + index;  //$NON-NLS-1$
				userAccessTypeRow.append("<td width=\"147\">&nbsp;&nbsp;");  //$NON-NLS-1$
				if(null != accessType && "F".equalsIgnoreCase(accessType)) {  //$NON-NLS-1$
					userAccessTypeRow.append("<input type=\"radio\" title=\"radioattr \" name=\""+accessTypeName+ "\" value=\"F\" id=\""+ id+ "\" checked=\"checked\" />");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
				}
				else {
					userAccessTypeRow.append("<input type=\"radio\" title=\"radioattr1 \" name=\"" + accessTypeName + "\" value=\"F\" id=\"" + id + "\" />");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
				}
				userAccessTypeRow.append("&nbsp;Full");  //$NON-NLS-1$  //$NON-NLS-2$
				userAccessTypeRow.append("<br /><div class=\"ibm-alternate-rule\"><hr/>&nbsp;</div></td>");  //$NON-NLS-1$
			}

			String accessUserName = "accessUser" + index;  //$NON-NLS-1$
			id = "selectUser" + index;  //$NON-NLS-1$
			userAccessTypeRow.append("<td width=\"297\">");  //$NON-NLS-1$  //$NON-NLS-2$
			userAccessTypeRow.append("<select id=\"" + id + "\" title=\"Access To\" name=\"" + accessUserName + "\" class=\"iform\">");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
			userAccessTypeRow.append("<option value=\"Select one\">Select one</option>");  //$NON-NLS-1$
			if (null != users) {
				Iterator iterator = users.keySet().iterator();
				if (null != iterator) {
					while (iterator.hasNext()) {
						String newUserId = (String) iterator.next();
						if (null != newUserId) {
							String name = (String) users.get(newUserId);
							if (null == name) {
								name = newUserId;
							}
							if (null != userId && userId.equalsIgnoreCase(newUserId)) {
								userAccessTypeRow.append("<option value=\""+ newUserId+ "\" selected=\"selected\">"+ name+ "</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
							} else {
								userAccessTypeRow.append("<option value=\"" + newUserId + "\">" + name + "</option>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
							}
						}
					}
				}
			}
			
			if(null == userId) {
				userAccessTypeRow.append("<option value=\"None\" selected=\"selected\">None</option>");  //$NON-NLS-1$
			}
			else {
				userAccessTypeRow.append("<option value=\"None\">None</option>");  //$NON-NLS-1$
			}
			userAccessTypeRow.append("</select> <br /><div class=\"ibm-alternate-rule\"><hr/>&nbsp;</div>");  //$NON-NLS-1$
			userAccessTypeRow.append("</td>");  //$NON-NLS-1$
		}
		userAccessTypeRow.append("</tr>");  //$NON-NLS-1$
		/* CR0531074816 - CBS OPPT accessibility issues
		userAccessTypeRow.append("<tr>");  //$NON-NLS-1$
		userAccessTypeRow.append("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
		userAccessTypeRow.append("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
		userAccessTypeRow.append("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
		userAccessTypeRow.append("</tr>");  //$NON-NLS-1$ */

		return userAccessTypeRow.toString();
	}

	/**
	 * Returns action form associated with the proposal sharing view 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalSharingActionForm
	 */
	public ProposalSharingActionForm getActionForm() {
		return actionForm;
	}

	/**
	 * Sets action form 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newActionForm ProposalSharingActionForm
	 */
	public void setActionForm(ProposalSharingActionForm newActionForm) {
		actionForm = newActionForm;
	}

	private boolean isAnyUserFullAccess() {
		boolean userFullAccess = false;

		if (null != getAccessTypes()) {
			Iterator iterator = getAccessTypes().values().iterator();
			while (iterator.hasNext()) {
				String value = (String) iterator.next();
				if (UtilityConstants.SHARED_FULL_MODE.equalsIgnoreCase(value)) {
					userFullAccess = true;
					break;
				}
			}
		}

		return userFullAccess;
	}
}