/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;

import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ConfigureDMEEViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ConfigureDMSWOViewBean;

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
public class DisplayConfigureDMSwosTag extends OPPTTag
{
	private List swos = null;
	private String property = null;

	private String styleDefault = "defaultedEE";  //$NON-NLS-1$
	private String styleCopied = "copiedEE";  //$NON-NLS-1$
	private String styleInvalid = "invalidEE";  //$NON-NLS-1$
	
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
			if(null != swos){
				for(int swoIndex=0, swoSize=swos.size(); swoIndex<swoSize; swoIndex++){
					ConfigureDMSWOViewBean swo = (ConfigureDMSWOViewBean)swos.get(swoIndex);
					if(null != swo){
						out.println("<table cellpadding=\"1\" cellspacing=\"1\" width=\"650\" summary=\"SWO Details\">");  //$NON-NLS-1$
						out.println("<tr>");  //$NON-NLS-1$
						out.println("<th width=\"27\" height=\"18\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\">&nbsp;</th>");  //$NON-NLS-1$
						out.println("<th width=\"276\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\">&nbsp;&nbsp;Swo number / Serial number</th>");  //$NON-NLS-1$
						out.println("<th width=\"340\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\">&nbsp;&nbsp;SWO description</th>");  //$NON-NLS-1$
						out.println("</tr>");  //$NON-NLS-1$
						out.println("<tr valign=\"bottom\">");  //$NON-NLS-1$
						out.println("<td align=\"center\"><input type=\"checkbox\" name=\""+getProperty()+"\" id=\""+getProperty()+"\" value=\""+swo.getSwoId()+"\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-2$  //$NON-NLS-3$
						out.println("<td>&nbsp;&nbsp;"+getValue(swo.getSwoNumber(), swo.getSwoSerialNumber(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
						out.println("<td>&nbsp;&nbsp;"+getValue(swo.getSwoDescription(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-4$  //$NON-NLS-1$
						out.println("</tr>");						//$NON-NLS-1$
						/* CR0531074816 - CBS OPPT accessibility issues
						out.println("<tr>");  //$NON-NLS-1$
						out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
						out.println("</tr>");  //$NON-NLS-1$
						out.println("</table>");  //$NON-NLS-1$ */
						out.println("&nbsp;<br />");  //$NON-NLS-1$

						List ees = swo.getEEViewBeans();
						if(null != ees){
							int eeSize = ees.size();
							if(0 < eeSize){
								out.println("<table cellpadding=\"1\" cellspacing=\"1\" border=\"0\" width=\"650\" summary=\"layout\">");  //$NON-NLS-1$
								out.println("<tr>");  //$NON-NLS-1$
								out.println("<th width=\"27\" height=\"18\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">&nbsp;&nbsp;</th>");  //$NON-NLS-1$
								out.println("<th width=\"97\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">EE number</th>");  //$NON-NLS-1$
								out.println("<th width=\"207\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Value metric description</th>");  //$NON-NLS-1$
								out.println("<th width=\"97\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">License&nbsp;type</th>");  //$NON-NLS-1$
								out.println("<th width=\"97\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Use level</th>");  //$NON-NLS-1$
								out.println("<th width=\"107\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Charge&nbsp;option</th>");  //$NON-NLS-1$
								out.println("</tr>");  //$NON-NLS-1$
								
								for(int eeIndex=0; eeIndex<eeSize; eeIndex++){
									ConfigureDMEEViewBean ee = (ConfigureDMEEViewBean)ees.get(eeIndex);
									if(null != ee){
										String id = swo.getSwoId()+Constants.STRING_SEPERATOR+ee.getId();
										String style = "ee";  //$NON-NLS-1$
										if(ee.isInvalid()){
											style = styleInvalid;
										}
										else if(ee.isCopied()){
											style = styleCopied;
										}
										else if(ee.isDefaulted()){
											style = styleDefault;
										}

										out.println("<tr class=\""+style+"\" valign=\"bottom\">");  //$NON-NLS-1$  //$NON-NLS-2$
										out.println("<td align=\"center\"><input type=\"checkbox\" name=\""+getProperty()+"\" id=\""+id+"\" value=\""+id+"\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-2$  //$NON-NLS-3$
										out.println("<td>"+getValue(ee.getEENumber(), "")+"</td>");  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-1$  //$NON-NLS-4$
										out.println("<td>"+getValue(ee.getValueMetricDescription(), "")+"</td>");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
										out.println("<td>"+getValue(ee.getLicenseType() ,"")+"</td>");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
										out.println("<td>"+getValue(ee.getUseLevel(), "")+"</td>");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
										out.println("<td>"+getValue(ee.getChargeOption(), "")+"</td>");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
										out.println("</tr>");  //$NON-NLS-1$
										/* CR0531074816 - CBS OPPT accessibility issues
										out.println("<tr>");  //$NON-NLS-1$
										out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
										out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
										out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
										out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
										out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
										out.println("<td><div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
										out.println("</tr>");  //$NON-NLS-1$ */
									}
								}
								out.println("</table>");  //$NON-NLS-1$
								out.println("&nbsp; <br />");  //$NON-NLS-1$
							}
						}
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
	 * @return List
	 */
	public List getSwos() {
		return swos;
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
	 * @param newSwos List 
	 */
	public void setSwos(List newSwos) {
		swos = newSwos;
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
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getStyleCopied() {
		return styleCopied;
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
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getStyleDefault() {
		return styleDefault;
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
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getStyleInvalid() {
		return styleInvalid;
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
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setStyleCopied(String string) {
		styleCopied = string;
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
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setStyleDefault(String string) {
		styleDefault = string;
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
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setStyleInvalid(String string) {
		styleInvalid = string;
	}

}
