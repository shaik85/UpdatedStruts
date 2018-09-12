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

import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalForApprovalViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ProposalViewBean;

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
public class ProposalsForApprovalTag extends OPPTTag {
	private TreeMap proposals = null;
	private boolean groupUser = false;
	private String message = null;
	private String property = "selectedIds";  //$NON-NLS-1$
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
	public int doStartTag() throws JspException {
		StringBuffer result = new StringBuffer();
		if (null != proposals && 0 < proposals.size()) {
			result.append("<table cellpadding=\"1\" cellspacing=\"1\" summary=\"List of Proposals for Approval\" width=\"650\">");  //$NON-NLS-1$
			result.append("<tr>");  //$NON-NLS-1$
			if(groupUser){
				if(isRequiredError()){
					result.append("<th align=\"left\" width=\"67\" height=\"18\" id=\"proposalSelector\" class=\"error\"><strong class=\"black\">*</strong>Required</th>");  //$NON-NLS-1$
				}
				else{
					result.append("<th align=\"left\" width=\"67\" height=\"18\" id=\"proposalSelector\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\"><b class=\"black\">*</strong>Required</th>");  //$NON-NLS-1$
				}
				result.append("<th align=\"left\" width=\"197\" id=\"proposalName\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Proposal name</th>");  //$NON-NLS-1$
				result.append("<th align=\"left\" width=\"92\" id=\"proposalType\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Proposal&nbsp;type</th>");  //$NON-NLS-1$
				result.append("<th align=\"left\" width=\"122\" id=\"createdBy\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Created by</th>");  //$NON-NLS-1$
				result.append("<th align=\"left\" width=\"122\" id=\"lockedBy\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Locked by</th>");  //$NON-NLS-1$
			}
			else{
				result.append("<th align=\"left\" width=\"307\" id=\"proposalName\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Proposal name</th>");  //$NON-NLS-1$
				result.append("<th align=\"left\" width=\"117\" id=\"proposalType\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Proposal type</th>");  //$NON-NLS-1$
				result.append("<th align=\"left\" width=\"167\" id=\"createdBy\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Created by</th>");  //$NON-NLS-1$
			}
			result.append("</tr>");  //$NON-NLS-1$
			Iterator proposalIterator = proposals.values().iterator();
			int count = 1;
			while(proposalIterator.hasNext()){
				ProposalForApprovalViewBean proposal = (ProposalForApprovalViewBean)proposalIterator.next();
				if(null != proposal){
					String proposalId = proposal.getId();
					String proposalIdCheck = "check"+proposal.getId();  //$NON-NLS-1$
                    if((count % 2) == 1) {
                    	result.append("<tr class=\"white\">");  //$NON-NLS-1$
                    }
                    else {
                    	result.append("<tr class=\"gray\">");  //$NON-NLS-1$
                    }
					if(groupUser){
						result.append("<td align=\"center\" headers=\"proposalSelector\"><input type=\"checkbox\" name=\""+property+"\" value=\""+proposalId+"\" id=\""+proposalIdCheck+"\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$
						result.append("<td headers=\"proposalName\" class=\"tabledata\" align=\"left\"><label for=\""+proposalId+"\"><a href=\"ProposalForApprovalLink.wss?proposalId="+proposalId+"\">"+getValue(proposal.getProposalName(), "")+"</a></label></td>");  //$NON-NLS-4$  //$NON-NLS-5$  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
						result.append("<td headers=\"proposalType\">"+getValue(proposal.getProposalType(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
						result.append("<td headers=\"createdBy\">"+getValue(proposal.getCreatedBy(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
						result.append("<td headers=\"lockedBy\">"+getValue(proposal.getLockedBy(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					}
					else{
						result.append("<td headers=\"proposalName\"><a href=\"ProposalForApprovalLink.wss?proposalId="+proposalId+"\">"+getValue(proposal.getProposalName(), "")+"</a><br />");  //$NON-NLS-3$  //$NON-NLS-4$  //$NON-NLS-1$  //$NON-NLS-2$
						result.append("<td headers=\"proposalType\">"+getValue(proposal.getProposalType(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
						result.append("<td headers=\"createdBy\">"+getValue(proposal.getCreatedBy(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					}
					result.append("</tr>");  //$NON-NLS-1$
				}
				count++;
			}								
			result.append("</table>");
		}
		else {
			result.append(getValue(message, ""));
		}

		JspWriter out = pageContext.getOut();
		try {
			out.print(result.toString());
			out.flush();
		} catch (IOException ioe) {
			throw new JspException("I/O Error : " + ioe.getMessage());
		}
		return Tag.SKIP_BODY;
	}

	/**
	 * Returns true if the current user is a group user 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isGroupUser() {
		return groupUser;
	}

	/**
	 * Retuns the collection of proposals 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getProposals() {
		return proposals;
	}

	/**
	 * Sets group user flag 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGroupUser boolean
	 */
	public void setGroupUser(boolean newGroupUser) {
		groupUser = newGroupUser;
	}

	/**
	 * Sets proposals collection value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposals TreeMap
	 */
	public void setProposals(TreeMap newProposals) {
		proposals = newProposals;
	}

	/**
	 * Returns the message value that need to be displayed when no proposals available for the user 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
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
	 * Sets the message value that need to be displayed when no proposals available for the user 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
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
	 * Returns check box property value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
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
	 * Sets check box property value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
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