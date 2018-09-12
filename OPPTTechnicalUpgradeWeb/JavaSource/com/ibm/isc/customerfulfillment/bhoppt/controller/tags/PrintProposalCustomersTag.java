/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DMViewBean;
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
public class PrintProposalCustomersTag extends OPPTTag 
{
	private Map customers = null;
	private String billToPartyNumber = null;
	private String payerNumber = null;
	
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
			if(null != getCustomers())
			{
				OPPTCalender calender = new OPPTCalender();
				Iterator customerIterator = customers.values().iterator();
				while(customerIterator.hasNext()){
					CustomerViewBean customer = (CustomerViewBean)customerIterator.next();
					if(null != customer){
						out.println("<table border=\"0\" width=\"100%\" cellspacing=\"1\" cellpadding=\"1\" summary=\"Proposal Customers\">");
						out.println("<tr class=\"tdblue\">");
						out.println("<th colspan=\"2\" height=\"18\" align=\"left\">&nbsp;&nbsp;Sold-to-party: "+getValue(customer.getSoldToParty(), "")+"</th>");
						out.println("<th colspan=\"2\" align=\"left\">&nbsp;&nbsp;SAP sold-to-party: "+getValue(customer.getSapCustomerNumber(), "")+"</th>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td width=\"25%\">&nbsp;&nbsp;Bill-to-party</td>");
						out.println("<td width=\"25%\">&nbsp;&nbsp;"+getValue(billToPartyNumber, "")+"</td>");
						out.println("<td width=\"25%\">&nbsp;&nbsp;Plan start date</td>");
						out.println("<td align=\"right\" width=\"25%\">&nbsp;&nbsp;"+getDateValue(customer.getPlanStartDate(), "-")+"</td>");
						out.println("</tr>");
						out.println("<tr>");
						out.println("<td>&nbsp;&nbsp;Payer</td>");
						out.println("<td>&nbsp;&nbsp;"+getValue(payerNumber, "")+"</td>");
						out.println("<td>&nbsp;&nbsp;Plan end date</td>");
						out.println("<td align=\"right\">&nbsp;&nbsp;"+getDateValue(customer.getPlanEndDate(), "-")+"</td>");
						out.println("</tr>");
						out.println("</table>");

						out.println("<br />");

						Map dms = customer.getDMs();
						if(null != dms){
							Iterator dmIterator = dms.values().iterator();
							while(dmIterator.hasNext()){
								DMViewBean dm = (DMViewBean)dmIterator.next();

								out.println("<table border=\"0\" width=\"100%\" cellspacing=\"1\" cellpadding=\"1\" summary=\"layout\">");
								out.println("<tr class=\"tblue\">");
								out.println("<th colspan=\"2\" align=\"left\" height=\"18\">&nbsp;&nbsp;Designated machine: "+getValue(dm.getDMNumber(), "")+"</th>");
								out.println("<th colspan=\"2\" align=\"left\">&nbsp;&nbsp;Description: "+getValue(dm.getDMNumber(), "")+"</th>");
								out.println("</tr>");
								out.println("<tr>");
								out.println("<td width=\"25%\">&nbsp;&nbsp;Plan start date</td>");
								out.println("<td width=\"25%\">&nbsp;&nbsp;"+getDateValue(dm.getPlanStartDate(), "-")+"</td>");
								out.println("<td width=\"25%\">&nbsp;&nbsp;Plan end date</td>");
								out.println("<td width=\"25%\" align=\"right\">&nbsp;&nbsp;"+getDateValue(dm.getPlanEndDate(), "-")+"</td>");
								out.println("</tr>");
								out.println("</table>");

								out.println("<br />");

								Map swos = dm.getSwos();
								if(null != swos){
									Iterator swoIterator = swos.values().iterator();
									while(swoIterator.hasNext()){
										SWOViewBean swo = (SWOViewBean)swoIterator.next();
										if(null != swo){
											out.println("<table border=\"0\" width=\"100%\" cellspacing=\"1\" cellpadding=\"1\" summary=\"layout\">");
											out.println("<tr class=\"lgray\">");
											out.println("<th align=\"left\" colspan=\"2\" height=\"18\" >&nbsp;&nbsp;SWO/SWOSno: "+getValue(swo.getSwoNumberSerialNumber(), "")+"</th>");
											out.println("<th align=\"left\" colspan=\"2\">&nbsp;&nbsp;Description: "+getValue(swo.getDescription(), "")+"</th>");
											out.println("</tr>");
											out.println("<tr>");
											out.println("<td width=\"25%\">&nbsp;&nbsp;Reference S/N</td>");
											out.println("<td width=\"25%\">&nbsp;&nbsp;"+getValue(swo.getSwoReferenceSN(), "-")+"</td>");
											out.println("<td width=\"25%\">&nbsp;&nbsp;ESW price</td>");
											out.println("<td width=\"25%\" align=\"right\">&nbsp;&nbsp;"+getDoubleValue(swo.getEswPrice(), "-")+"</td>");
											out.println("</tr>");
											out.println("<tr>");
											out.println("<td>&nbsp;&nbsp;Reference D/N</td>");
											out.println("<td>&nbsp;&nbsp;"+getValue(swo.getSwoReferenceDN(), "-")+"</td>");
											out.println("<td>&nbsp;&nbsp;Alternate price</td>");
											out.println("<td align=\"right\">&nbsp;&nbsp;"+getDoubleValue(swo.getAlternatePrice(), "-")+"</td>");
											out.println("</tr>");
											out.println("<tr>");
											out.println("<td>&nbsp;&nbsp;Plan start date</td>");
											out.println("<td>&nbsp;&nbsp;"+getDateValue(swo.getPlanStartDate(), "-")+"</td>");
											out.println("<td>&nbsp;&nbsp;Calculated price</td>");
											out.println("<td align=\"right\">&nbsp;&nbsp;"+getDoubleValue(swo.getCalculatedPrice(), "-")+"</td>");
											out.println("</tr>");
											out.println("<tr>");
											out.println("<td>&nbsp;&nbsp;Plan end date</td>");
											out.println("<td>&nbsp;&nbsp;"+getDateValue(swo.getPlanEndDate(), "-")+"</td>");
											out.println("<td>&nbsp;&nbsp;Contract status</td>");
											out.println("<td align=\"right\">&nbsp;&nbsp;"+getValue(swo.getSwoContractStatus(), "-")+"</td>");
											out.println("</tr>");
											out.println("<tr>");
											out.println("<td>&nbsp;&nbsp;Contract number</td>");
											out.println("<td>&nbsp;&nbsp;"+getValue(swo.getSwoContractNumber(), "-")+"</td>");
											out.println("<td>&nbsp;&nbsp;Contract type</td>");
											out.println("<td align=\"right\">&nbsp;&nbsp;"+getValue(swo.getSwoContractType(), "-")+"</td>");
											out.println("</tr>");
											out.println("</table>");
											if(swoIterator.hasNext()){
												out.println("<br />");
											}
										}
									}
								}
								out.println("<br />");
							}
						}
						out.println("<br />");
					}
				}
			}
			out.flush();
		}
		catch(IOException ioe){
			throw new JspException( "I/O Error : " + ioe.getMessage() );
		}
		return Tag.SKIP_BODY;
	}

	/**
	 * Returns customers collection 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Map
	 */
	public Map getCustomers() {
		return customers;
	}

	/**
	 * Sets customers collection 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomers Map
	 */
	public void setCustomers(Map newCustomers) {
		customers = newCustomers;
	}
	
	/**
	 * Returns bill to party number value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getBillToPartyNumber() {
		return billToPartyNumber;
	}

	/**
	 * Returns payer number value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPayerNumber() {
		return payerNumber;
	}

	/**
	 * Sets bill to party number value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillToPartyNumber String 
	 */
	public void setBillToPartyNumber(String newBillToPartyNumber) {
		billToPartyNumber = newBillToPartyNumber;
	}

	/**
	 * Sets payer number value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPayerNumber String 
	 */
	public void setPayerNumber(String newPayerNumber) {
		payerNumber = newPayerNumber;
	}
}
