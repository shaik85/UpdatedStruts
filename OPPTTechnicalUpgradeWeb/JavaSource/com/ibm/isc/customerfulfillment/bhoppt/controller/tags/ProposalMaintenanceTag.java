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
public class ProposalMaintenanceTag extends OPPTTag {
	private TreeMap proposals = null;
	private boolean groupUser = false;
	private String message = null;
	private String property = "selectedIds";  //$NON-NLS-1$
	private String sharedProposalStyle = "sharedProposal";  //$NON-NLS-1$
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
			//DQA result.append("<table role=\"presentation\" class=\"ibm-data-table\" width=\"600\" cellpadding=\"1\" cellspacing=\"1\" summary=\"List of Proposals for the User ID\" border=\"0\">");  //$NON-NLS-1$
			result.append("<table  class=\"ibm-data-table ibm-alternating\" width=\"600\" cellpadding=\"1\" cellspacing=\"1\" summary=\"List of Proposals for the User ID\" border=\"0\">");  //$NON-NLS-1$
			
			result.append("<tr style=\"background-color:#cccccc;\" class=\"dark\">");  //$NON-NLS-1$
			if(isRequiredError()){
				
				  result.append("<th align=\"left\" width=\"20\" height=\"18\" id=\"proposalSelector\" class=\"error\"><strong class=\"black\">*</strong>Required</th>"); //$NON-NLS-1$
							}
			else{				
				result.append("<th align=\"left\" width=\"40\" height=\"18\" id=\"proposalSelector\"><strong class=\"black\">*</strong>Required</th>");
				
			}
			result.append("<th nowrap=\"nowrap\" width=\"199\" id=\"proposalName\">Proposal name</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"40\" id=\"type\">Type</th>");  //$NON-NLS-1$
			if(isGroupUser()){
				result.append("<th nowrap=\"nowrap\" align=\"left\" width=\"150\" id=\"status\">Status</th>");  //$NON-NLS-1$
			}
			else{
				result.append("<th nowrap=\"nowrap\" align=\"left\" width=\"150\" id=\"status\">Status</th>");  //$NON-NLS-1$
			}
			result.append("<th nowrap=\"nowrap\" align=\"left\" width=\"80\" id=\"oldContract\">Old&nbsp;contract</th>");  //$NON-NLS-1$
			if(isGroupUser()){
				result.append("<th nowrap=\"nowrap\" align=\"left\" width=\"97\" id=\"lockedBy\">Locked&nbsp;by</th>");  //$NON-NLS-1$
			}
			result.append("<th nowrap=\"nowrap\" align=\"left\" width=\"48\" id=\"access\">Access</th>");  //$NON-NLS-1$
			result.append("</tr>");  //$NON-NLS-1$
			
			Iterator proposalIterator = proposals.values().iterator();
			int count = 1;
			while (proposalIterator.hasNext()) {
				ProposalViewBean proposal = (ProposalViewBean) proposalIterator.next();
				if (null != proposal) {
					String proposalId = proposal.getId();
					String proposalIdCheck = "check" + proposal.getId();  //$NON-NLS-1$
					String proposalName = proposal.getProposalName();
					if((count % 2) == 1) {
						result.append("<tr class=\"white\">");  //$NON-NLS-1$
					}
					else {
						result.append("<tr class=\"gray\">");  //$NON-NLS-1$
					}
					
					
//					if(proposal.isFullAccess()){
//						result.append("<tr class=\""+sharedProposalStyle+"\">");
//					}
//					else{
//						result.append("<tr class=\"tbwhite\">");
//					}
					result.append("<td valign=\"bottom\" align=\"center\" headers=\"proposalSelector\"><input type=\"checkbox\" name=\""+property+"\" value=\""+proposalId+"\" id=\""+proposalIdCheck+"\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$
					result.append("<th nowrap=\"nowrap\"  valign=\"bottom\" headers=\"proposalName\" class=\"tabledata\" align=\"left\"><label for=\""+proposalIdCheck+"\"><a href=\"ProposalLink.wss?proposalId="+proposalId+ "\">"+getValue(proposalName, 30)+"</a></label></th>");  //$NON-NLS-4$  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
					result.append("<td valign=\"bottom\" headers=\"type\">"+getValue(proposal.getProposalType(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					result.append("<td valign=\"bottom\" headers=\"status\">"+getValue(proposal.getStatus(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
//					if(isGroupUser()){
//						result.append("</td>");
//					}
//					else{
//						result.append("</td>");
//					}
					result.append("<td valign=\"bottom\" headers=\"oldContract\">"+getValue(proposal.getOldContractNumber(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					if(isGroupUser()){
						result.append("<td valign=\"bottom\" headers=\"lockedBy\">"+getValue(getValue(proposal.getLockedBy(), ""), 12)+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					}
					result.append("<td valign=\"bottom\" headers=\"access\">"+getValue(getAccessType(proposal.getAccessType()), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					result.append("</tr>");  //$NON-NLS-1$
					count++;
				}
			}
			result.append("</table>");  //$NON-NLS-1$
		}
		else {
			result.append(getValue(message, ""));  //$NON-NLS-1$
		}

		JspWriter out = pageContext.getOut();
		try {
			out.print(result.toString());
			out.flush();
		} catch (IOException ioe) {
			throw new JspException("I/O Error : " + ioe.getMessage());  //$NON-NLS-1$
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
	 * Returns style value associated with a shared proposal 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSharedProposalStyle() {
		return sharedProposalStyle;
	}

	/**
	 * Sets style value associated with a shared proposal 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSharedProposalStyle String 
	 */
	public void setSharedProposalStyle(String newSharedProposalStyle) {
		sharedProposalStyle = newSharedProposalStyle;
	}
	
	private String getAccessType(String sourceAccess){
		String accessType = null;
		
		if(null != sourceAccess){
			if(sourceAccess.equalsIgnoreCase("F")){  //$NON-NLS-1$
				accessType = "Full";  //$NON-NLS-1$
			}
			else if(sourceAccess.equalsIgnoreCase("R")){  //$NON-NLS-1$
				accessType = "Read";  //$NON-NLS-1$
			}
		}
		
		return accessType;
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
	 * <br><strong>Known Bugs</b><br> 
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