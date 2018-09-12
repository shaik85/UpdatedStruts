/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;

import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerViewBean;
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
public class DisplayCustomerTag extends OPPTTag {
	private CustomerViewBean customer = null;
	private String id = null;
	private boolean proposalEditable = true;
	private boolean sands = false;
	// CR 2031
	private boolean duplicateSerial = false;

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
		try {
			if (null != customer) {
				OPPTCalender calender = new OPPTCalender();

				out.println("<tr>");  //$NON-NLS-1$
				if (isProposalEditable()) {
					if (isDuplicateSerial()) {
						if (isSands()) {
							out.println("<td width=\"20\" height=\"18\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\"></td>");  /* NOI18N */
							out.println("<td width=\"205\" colspan=\"2\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\" nowrap=\"nowrap\"><label for=\"check" + getId() + "\">Sold-to-party:&nbsp;</label> " + getValue(customer.getSoldToParty(), "") + "</td>");  /* NOI18N */  /* NOI18N */  /* NOI18N */  /* NOI18N */
						} else {
							out.println("<td width=\"20\" height=\"18\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\"></td>");  /* NOI18N */
							out.println("<td width=\"205\" colspan=\"2\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\" nowrap=\"nowrap\"><label for=\"check" + getId() + "\">Sold-to-party:&nbsp;</label> " + getValue(customer.getSoldToParty(), "") + "</td>");  /* NOI18N */  /* NOI18N */  /* NOI18N */  /* NOI18N */
						}

					} else {
						if (isSands()) {
							out.println("<td width=\"20\" height=\"18\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\" nowrap=\"nowrap\"><input type=\"checkbox\" name=\"selectedSandSIds\" id=\"check" + getId() + "\" value=\"" + getId() + "\" /></td>");  /* NOI18N */  /* NOI18N */  /* NOI18N */
							out.println("<td width=\"205\" colspan=\"2\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\" nowrap=\"nowrap\">Sold-to-party:&nbsp;<aria-hidden=\"true\" a  class=\"rlinks\" href=\"CustomerDetails.wss?type=sands&customerId=" + getId() + "\">" + getValue(customer.getSoldToParty(), "") + "</a></td>");  /* NOI18N */  /* NOI18N */  /* NOI18N */  /* NOI18N */  /* NOI18N */
						} else {
							out.println("<td width=\"20\" height=\"18\" style=\"background-color:#999999;\"class=\"bar-blue-med-dark\" nowrap=\"nowrap\"><input type=\"checkbox\" name=\"selectedIds\" title=\" selected\"id=\"check" + getId() + "\" value=\"" + getId() + "\" /></td>");  /* NOI18N */  /* NOI18N */  /* NOI18N */
							out.println("<td width=\"205\" colspan=\"2\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\" nowrap=\"nowrap\">Sold-to-party:&nbsp;<aria-hidden=\"true\" a  class=\"rlinks\" href=\"CustomerDetails.wss?customerId=" + getId() + "\">" + getValue(customer.getSoldToParty(), "") + "</a></td>");  /* NOI18N */  /* NOI18N */  /* NOI18N */  /* NOI18N */  /* NOI18N */
						}
					}

				} else {
					if (isSands()) {
						out.println("<td width=\"225\" colspan=\"2\" height=\"18\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\" nowrap=\"nowrap\">Sold-to-party:&nbsp;<aria-hidden=\"true\" a class=\"rlinks\" href=\"CustomerDetails.wss?type=sands&customerId=" + getId() + "\">" + getValue(customer.getSoldToParty(), "") + "</a></td>");  /* NOI18N */  /* NOI18N */  /* NOI18N */  /* NOI18N */
					} else {
						out.println("<td width=\"225\" colspan=\"2\" height=\"18\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\" nowrap=\"nowrap\">Sold-to-party:&nbsp;<aria-hidden=\"true\" a class=\"rlinks\" href=\"CustomerDetails.wss?customerId=" + getId() + "\">" + getValue(customer.getSoldToParty(), "") + "</a></td>");  /* NOI18N */  /* NOI18N */  /* NOI18N */  /* NOI18N */
					}
				}
				out.println("<td width=\"180\" colspan=\"3\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\">"+getValue(customer.getDescription(), "") + "</td>");  /* NOI18N */  /* NOI18N */  /* NOI18N */
				out.println("<td width=\"110\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\" align=\"left\">"+getDateValue(customer.getPlanStartDate(), "") + "</td>");  /* NOI18N */  /* NOI18N */  /* NOI18N */
				out.println("<td width=\"110\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\" align=\"left\">"+getDateValue(customer.getPlanEndDate(), "") + "</td>");  /* NOI18N */  /* NOI18N */  /* NOI18N */
				out.println("<td width=\"37\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\">&nbsp;</td>");  /* NOI18N */
				out.println("</tr>");  /* NOI18N */
			}
			out.flush();
		} catch (IOException ioe) {
			throw new JspException("I/O Error : " + ioe.getMessage());  /* NOI18N */
		}
		return Tag.SKIP_BODY;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isProposalEditable() {
		return proposalEditable;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setProposalEditable(boolean b) {
		proposalEditable = b;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public CustomerViewBean getCustomer() {
		return customer;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bean 
	 */
	public void setCustomer(CustomerViewBean bean) {
		customer = bean;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSands() {
		return sands;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSands(boolean b) {
		sands = b;
	}

	/**
	 * Returns customer identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 8, 2004 
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
	 * Sets customer identifier value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 8, 2004 
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
	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Oct 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isDuplicateSerial() {
		return duplicateSerial;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Oct 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setDuplicateSerial(boolean b) {
		duplicateSerial = b;
	}

}