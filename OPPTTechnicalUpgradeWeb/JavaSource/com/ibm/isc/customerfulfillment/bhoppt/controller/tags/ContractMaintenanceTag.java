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

import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ContractViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;

/* start change CR 6153 */
/* end change CR 6153 */

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
public class ContractMaintenanceTag extends OPPTTag {
	private TreeMap contracts = null;
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
		StringBuffer result1 = new StringBuffer();
		if (null != contracts && 0 < contracts.size()) {
			result.append("<table class=\"ibm-data-table ibm-alternating\" width=\"600\" summary=\"List of Contracts for the User ID\" cellpadding=\"1\" cellspacing=\"1\" border=\"0\">");  //$NON-NLS-1$
			result.append("<tr style=\"background-color: #cccccc;\" class=\"dark\">");  //$NON-NLS-1$
			if(isRequiredError()){
				result.append("<th align=\"left\" width=\"20\" height=\"18\" id=\"contractSelector\" class=\"error\"><strong class=\"black\">*</strong>Required</th>");  //$NON-NLS-1$
			}
			else{
				result.append("<th align=\"left\" width=\"40\" height=\"18\" id=\"contractSelector\"><strong class=\"black\">*</strong>Required</th>");  //$NON-NLS-1$
			}
			result.append("<th align=\"left\" width=\"199\" id=\"proposalName\">Proposal&nbsp;name</th>");  //$NON-NLS-1$
			result.append("<th align=\"left\" width=\"40\" id=\"type\">Type</th>");  //$NON-NLS-1$
			result.append("<th align=\"left\" width=\"80\" id=\"contractNumber\">Contract&nbsp;no.</th>");  //$NON-NLS-1$
			
			  //OPPT BH 1.0-DAD001-Srinivas
			result.append("<th align=\"left\" width=\"80\" id=\"contractPeriodbegining\"> Period&nbsp;Start&nbsp;Date</th>");  //$NON-NLS-1$
			   //OPPT BH 1.0-DAD001-Srinivas
			result.append("<th align=\"left\" width=\"80\" id=\"contractPeriodEnd\"> Period&nbsp;End&nbsp;Date</th>");  //$NON-NLS-1$
			
			if(isGroupUser()){
				result.append("<th align=\"left\" width=\"136\" id=\"status\">Status</th>");  //$NON-NLS-1$
			}
			else{
				result.append("<th align=\"left\" width=\"236\" id=\"status\">Status</th>");  //$NON-NLS-1$
			}
			if(isGroupUser()){
				result.append("<th align=\"left\" width=\"97\" id=\"lockedBy\" nowrap=\"nowrap\">Locked&nbsp;by</th>");  //$NON-NLS-1$
			}
			result.append("</tr>");  //$NON-NLS-1$
			
			int count = 1;
			Iterator contractIterator1 = contracts.values().iterator();
			while (contractIterator1.hasNext()) {
				ContractViewBean contract = (ContractViewBean)contractIterator1.next();
				if (null != contract) {
					String contractId = contract.getId();
					String contractIdCheck = "check" + contract.getId();  //$NON-NLS-1$
					String contractName = contract.getProposalName();
					/* start change CR6153 */
					String extendIndicator = "";
					if(contract.getExtendPeriod()!= null)
						extendIndicator = ((contract.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))?"Extended":"");
					/* end change CR6153 */
				//Added by srinivas-OPPT BH-DAD001
					if(!"CLOSED".equalsIgnoreCase(contract.getStatus())){
					if((count % 2) == 1) {
						result.append("<tr class=\"white\">");  //$NON-NLS-1$
						}
					else {
						result.append("<tr class=\"gray\">");  //$NON-NLS-1$
					}
					result.append("<td valign=\"bottom\" align=\"center\" headers=\"contractSelector\"><input type=\"checkbox\" name=\""+property+"\" value=\""+contractId+"\" id=\""+contractIdCheck+"\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$
					result.append("<th valign=\"bottom\" headers=\"proposalName\" class=\"tabledata\" align=\"left\"><label for=\""+contractIdCheck+"\"><a href=\"ContractLink.wss?proposalId="+contractId+ "\">"+getValue(contractName, 17)+"</a></label></th>");  //$NON-NLS-4$  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
					result.append("<td valign=\"bottom\" headers=\"type\">"+getValue(contract.getProposalType(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					/* start change CR6153 */
					result.append("<td valign=\"bottom\" headers=\"contractNumber\">"+getValue(contract.getContractNumber(), "")+"<br /><p style=\"font-size:1 em;\">"+extendIndicator+"</p></td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					   //OPPT BH 1.0-DAD001-Srinivas
					result.append("<td valign=\"bottom\" headers=\"contractPeriodbegining\">"+getValue(contract.getContractPeriodStartDate(), "")+"<br /><p style=\"font-size:1 em;\">"+extendIndicator+"</p></td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					   //OPPT BH 1.0-DAD001-Srinivas
					result.append("<td valign=\"bottom\" headers=\"contractPeriodEnd\">"+getValue(contract.getContractPeriodEndDate(), "")+"<br /><p style=\"font-size:1 em;\">"+extendIndicator+"</p></td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					/* start change CR6153 */
					result.append("<td valign=\"bottom\" headers=\"status\">"+getValue(contract.getStatus(), ""));  //$NON-NLS-1$  //$NON-NLS-2$
					if(isGroupUser()){
						result.append("</td>");  //$NON-NLS-1$
					} 
					else{
						result.append("</td>");  //$NON-NLS-1$
					}
					if(isGroupUser()){
						result.append("<td valign=\"bottom\" headers=\"lockedBy\">"+getValue(getValue(contract.getLockedBy(), ""), 12)+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					}
					result.append("</tr>");  //$NON-NLS-1$
					count++;
				
				}
				}
					     	
			}
			//Added By Srinivas-DAD001 OPPT-BH
			Iterator contractIterator2 = contracts.values().iterator();
			while (contractIterator2.hasNext()) {
				ContractViewBean contract = (ContractViewBean)contractIterator2.next();
				if (null != contract) {
					String contractId = contract.getId();
					String contractIdCheck = "check" + contract.getId();  //$NON-NLS-1$
					String contractName = contract.getProposalName();
					/* start change CR6153 */
					String extendIndicator = "";
					if(contract.getExtendPeriod()!= null)
						extendIndicator = ((contract.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))?"Extended":"");
					/* end change CR6153 */
				//Added by srinivas-OPPT BH-DAD001
					if("CLOSED".equalsIgnoreCase(contract.getStatus())){
					if((count % 2) == 1) {
						result.append("<tr class=\"white\">");  //$NON-NLS-1$
						}
					else {
						result.append("<tr class=\"gray\">");  //$NON-NLS-1$
					}
					result.append("<td valign=\"bottom\" align=\"center\" headers=\"contractSelector\"><input type=\"checkbox\" name=\""+property+"\" value=\""+contractId+"\" id=\""+contractIdCheck+"\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$
					result.append("<th valign=\"bottom\" headers=\"proposalName\" class=\"tabledata\" align=\"left\"><label for=\""+contractIdCheck+"\"><a href=\"ContractLink.wss?proposalId="+contractId+ "\">"+getValue(contractName, 17)+"</a></label></th>");  //$NON-NLS-4$  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
					result.append("<td valign=\"bottom\" headers=\"type\">"+getValue(contract.getProposalType(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					/* start change CR6153 */
					result.append("<td valign=\"bottom\" headers=\"contractNumber\">"+getValue(contract.getContractNumber(), "")+"<br /><p style=\"font-size:1 em;\">"+extendIndicator+"</p></td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					   //OPPT BH 1.0-DAD001-Srinivas
					result.append("<td valign=\"bottom\" headers=\"contractPeriodbegining\">"+getValue(contract.getContractPeriodStartDate(), "")+"<br /><p style=\"font-size:1 em;\">"+extendIndicator+"</p></td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					   //OPPT BH 1.0-DAD001-Srinivas
					result.append("<td valign=\"bottom\" headers=\"contractPeriodEnd\">"+getValue(contract.getContractPeriodEndDate(), "")+"<br /><p style=\"font-size:1 em;\">"+extendIndicator+"</p></td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					/* start change CR6153 */
					result.append("<td valign=\"bottom\" headers=\"status\">"+getValue(contract.getStatus(), ""));  //$NON-NLS-1$  //$NON-NLS-2$
					if(isGroupUser()){
						result.append("</td>");  //$NON-NLS-1$
					} 
					else{
						result.append("</td>");  //$NON-NLS-1$
					}
					if(isGroupUser()){
						result.append("<td valign=\"bottom\" headers=\"lockedBy\">"+getValue(getValue(contract.getLockedBy(), ""), 12)+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					}
					result.append("</tr>");  //$NON-NLS-1$
					count++;
				}
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
	 * Retuns the collection of contracts
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
	public TreeMap getContracts() {
		return contracts;
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
	 * Sets contracts collection value 
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
	 * @param newContracts TreeMap
	 */
	public void setContracts(TreeMap newContracts) {
		contracts = newContracts;
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