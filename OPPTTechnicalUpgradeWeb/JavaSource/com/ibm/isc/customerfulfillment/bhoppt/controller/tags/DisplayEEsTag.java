/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;

import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.EEViewBean;

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
public class DisplayEEsTag extends OPPTTag
{
	private TreeMap ees = null;
	private String property = null;
	private String discount = null;
	private boolean sands = false;
	
	/**
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date May 31, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag() 
	 * @return
	 * @throws JspException 
	 *
	 * revision date author reason
	 * 31/05/2004    Vinod 	Added as part of MN19387428 - CMVCDEFECT <351> for checking if alternate price returned 
	 * 						from service layer is -1 and if so, return empty value else return string value.
	 *
	 */
	public int doStartTag() throws JspException 
	{
		JspWriter out = pageContext.getOut();
		try
		{
			if(null != ees && 0 < ees.size()){
				Collection eeCollection = ees.values();
				Iterator eeIterator = eeCollection.iterator();
				while(eeIterator.hasNext()){
					EEViewBean ee = (EEViewBean)eeIterator.next();
					if(null != ee){
						out.println("<input type=\"hidden\" name=\"eeIds\" value=\""+ee.getId()+"\" />");  //$NON-NLS-1$  //$NON-NLS-2$
						out.println("<table cellpadding=\"1\" cellspacing=\"1\" width=\"600\" summary=\"Display EE\">");  //$NON-NLS-1$
						out.println("<tr>");  //$NON-NLS-1$
						out.println("<th colspan=\"2\" height=\"18\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">EE : "+getValue(ee.getNumber(), "")+"</th>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$	
						out.println("<th colspan=\"2\" height=\"18\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Description: "+getValue(ee.getDescription(), "")+"</th>");  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-1$
						out.println("</tr>");  //$NON-NLS-1$

						out.println("<tr valign=\"bottom\">");  //$NON-NLS-1$
						out.println("<td width=\"150\">Value metric:<br />");  //$NON-NLS-1$
						out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td width=\"144\">"+getValue(ee.getValueMetric(), "")+"<br />");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
						out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						if(isSands()){
							out.println("<td width=\"150\">&nbsp;&nbsp;ESW S&amp;S price:<br />");  //$NON-NLS-1$
						}
						else{
							out.println("<td width=\"150\">ESW price:<br />");  //$NON-NLS-1$
						}
						out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td align=\"right\" width=\"144\"><span class=\"orange-med\">"+getDoubleValue(ee.getEswPrice(), "0.00")+"</span><br />");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
						out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("</tr>");  //$NON-NLS-1$

						out.println("<tr valign=\"bottom\">");  //$NON-NLS-1$
						out.println("<td>Use level:");  //$NON-NLS-1$
						out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td>"+getValue(ee.getUseLevel(), ""));  //$NON-NLS-2$  //$NON-NLS-1$
						out.println("<br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						if(isSands()){
							out.println("<td><label for=\""+ee.getId()+"\">Alternate S&amp;S price:</label>");  //$NON-NLS-1$  //$NON-NLS-2$
							}
						else{
							out.println("<td><label for=\""+ee.getId()+"\">Alternate price:</label>");  //$NON-NLS-1$  //$NON-NLS-2$
							}
						out.println(" <br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						if(ee.isEditable()){
							out.println("<td align=\"right\"><input type=\"text\" name=\""+property+"\" id=\""+ee.getId()+"\" size=\"10\" maxlength=\"17\" value=\"" +getDoubleValue(ee.getAlternatePrice())+ "\" />");  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-1$  //$NON-NLS-4$
						}
						else{
							out.println("<td align=\"right\"><input type=\"text\" name=\""+property+"\" id=\""+ee.getId()+"\" readonly=\"readonly\" size=\"10\" maxlength=\"17\" value=\""+getDoubleValue(ee.getAlternatePrice())+"\" />");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-2$  //$NON-NLS-3$
						}
						out.println(" <br /><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("</tr>");  //$NON-NLS-1$
						/* CR0531074816 - CBS OPPT accessibility issues
						out.println("<tr>");  //$NON-NLS-1$
						out.println("<td valign=\"bottom\"><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td valign=\"bottom\"><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td valign=\"bottom\"><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td valign=\"bottom\"><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("</tr>");  //$NON-NLS-1$ */
						

						if(!isSands()){
							out.println("<tr valign=\"bottom\">");  //$NON-NLS-1$
							out.println("<td>Licence type:<br />");  //$NON-NLS-1$
							out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.println("<td>"+getValue(ee.getLicenceType(), "")+"<br />");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
							out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.println("<td>Calculated price:<br />");  //$NON-NLS-1$
							out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.println("<td align=\"right\"><span class=\"orange-med\">"+getDoubleValue(ee.getCalculatedPrice())+"</span><br />");  //$NON-NLS-1$
							out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.println("</tr>");  //$NON-NLS-1$
						}
						else{
							out.println("<tr valign=\"bottom\">");  //$NON-NLS-1$
							out.println("<td>Licence type:<br />");  //$NON-NLS-1$
							out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.println("<td>"+getValue(ee.getLicenceType(), "")+"<br />");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
							out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.println("<td><label for=\"discount\">Discount:</label><br />");  //$NON-NLS-1$
							out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							if(ee.isDiscountEditable()){
								out.println("<td align=\"right\"><input type=\"text\" name=\""+discount+"\" id=\"Discount\" size=\"8\" maxlength=\"17\" value=\""+getDoubleValue(ee.getSAndSDiscountPercent())+ "\" />%<br />");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
							}
							else{
								out.println("<td align=\"right\"><input type=\"text\" name=\""+discount+"\" readonly=\"readonly\" id=\"Discount\" size=\"8\" maxlength=\"17\" value=\""+getDoubleValue(ee.getSAndSDiscountPercent())+ "\" />%<br />");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
							}
							out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.println("</tr>");  //$NON-NLS-1$
							
							out.println("<tr valign=\"bottom\">");  //$NON-NLS-1$
							out.println("<td>&nbsp;&nbsp;&nbsp;&nbsp;<br />");  //$NON-NLS-1$
							out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.println("<td>&nbsp;&nbsp;&nbsp;&nbsp;<br />");  //$NON-NLS-1$
							out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.println("<td>Calculated S&amp;S price:<br />");  //$NON-NLS-1$
							out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.println("<td align=\"right\"><span class=\"orange-med\">"+getDoubleValue(ee.getCalculatedPrice())+"</span><br />");  //$NON-NLS-2$  //$NON-NLS-1$
							out.println("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.println("</tr>");  //$NON-NLS-1$
							
						}
						
						out.println("</table>");  //$NON-NLS-1$
						out.println("&nbsp;<br />");  //$NON-NLS-1$
					}
				}
			}
			out.flush();
		}
		catch(IOException ioe){
			throw new JspException( "I/O Error : " + ioe.getMessage() );  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}

	/**
	 * Returns ees collection  
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Collection
	 */
	public TreeMap getEes() {
		return ees;
	}

	/**
	 * Sets ees collection 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEEs Collection 
	 */
	public void setEes(TreeMap newEEs) {
		ees = newEEs;
	}
	
	/**
	 * Returns property value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 8, 2004 
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
	 * Sets property value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 8, 2004 
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
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 20, 2004 
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
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 20, 2004 
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
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getDiscount() {
		return discount;
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
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setDiscount(String string) {
		discount = string;
	}


	/**
     * getDoubleValue
     * 
     * @param doubleValue
     * @return
     * @author thirumalai
     */
    protected String getDoubleValue(double doubleValue) {
		String value = "";  //$NON-NLS-1$

		if(0 <= doubleValue){
			BigDecimal initialDouble = new BigDecimal((new Double(doubleValue)).toString());
//			BigDecimal scaledDouble = initialDouble.setScale(2, BigDecimal.ROUND_DOWN);
			/*
			* This is a fix for display issue of rounding
			* Balaji 
			*/
			BigDecimal scaledDouble = initialDouble.setScale(2, BigDecimal.ROUND_HALF_EVEN);

			value = scaledDouble.toString();
		}
		
		return value;
	}
}
