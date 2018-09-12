/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.*;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;

import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.IneligibleEEViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.IneligibleSWOViewBean;

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
public class DisplayIneligibleLicensesTag extends OPPTTag 
{
	private TreeMap licenses = null;
	private boolean input = false;
	private int type = -1;
	
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
			if(null != licenses && 0 < licenses.size()){
				Iterator licenseIterator = licenses.values().iterator();
				if(null != licenseIterator)
				{
					while(licenseIterator.hasNext())
					{
						IneligibleSWOViewBean license = (IneligibleSWOViewBean)licenseIterator.next();
						if(null != license){
							out.print("<table border=\"0\" cellspacing=\"1\" cellpadding=\"1\" width=\"600\" summary=\"Ineligible Licenses\">");  //$NON-NLS-1$
							out.print("<tr>");  //$NON-NLS-1$
							out.print("<th width=\"30\" height=\"18\" style=\"background-color:#999999;\" class=\"bar-blue-med-dark\">&nbsp;&nbsp;</th>");  //$NON-NLS-1$
							out.print("<th width=\"90\"  style=\"background-color:#999999;\"class=\"bar-blue-med-dark\">SAP	stp no.</th>");  //$NON-NLS-1$
							out.print("<th width=\"125\" style=\"background-color:#999999;\"class=\"bar-blue-med-dark\">SWO no/ SWO Sl no</th>");  //$NON-NLS-1$
							out.print("<th width=\"130\" style=\"background-color:#999999;\"class=\"bar-blue-med-dark\">Desg. machine no.</th>");  //$NON-NLS-1$				
							out.print("<th width=\"90\" style=\"background-color:#999999;\"class=\"bar-blue-med-dark\">L.E.D.</th>");  //$NON-NLS-1$
							out.print("<th width=\"117\" colspan=\"3\" style=\"background-color:#999999;\"class=\"bar-blue-med-dark\">Comment</th>");  //$NON-NLS-1$
							out.print("</tr>");  //$NON-NLS-1$
							out.print("<tr>");  //$NON-NLS-1$
							if(isInput() && !license.isLicensePulled()){
								out.print("<td valign=\"bottom\">");  //$NON-NLS-1$
								if(license.isSelected()){
									out.print("<input type=\"checkbox\" value=\""+getType()+Constants.STRING_SEPERATOR_PLUS+license.getId()+"\" name=\"selectedLicensesIds\" id=\""+license.getId()+"\" checked=\"checked\" />");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
								}
								else{
									out.print("<input type=\"checkbox\" value=\""+getType()+Constants.STRING_SEPERATOR_PLUS+license.getId()+"\" name=\"selectedLicensesIds\" id=\""+license.getId()+"\" />");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
								}
								out.print("<br />");  //$NON-NLS-1$
							}
							else{
								out.print("<td valign=\"bottom\">&nbsp;<br />");  //$NON-NLS-1$
							}
							out.print("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.print("<td valign=\"bottom\">"+getValue(license.getSapSTPNumber(), "")+"<br />");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
							out.print("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.print("<td valign=\"bottom\">"+getValue(license.getSwoNumber(), "")+"/&nbsp;"+getValue(license.getSwoSerialNumber(), "")+"<br />");  //$NON-NLS-1$  //$NON-NLS-5$  //$NON-NLS-3$  //$NON-NLS-4$  //$NON-NLS-2$
							out.print("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.print("<td valign=\"bottom\">"+getValue(license.getDMNumber(), "")+"<br />");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
							out.print("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.print("<td valign=\"bottom\">"+getDateValue(license.getLicenseEffectiveDate(), "")+"<br />");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
							out.print("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.print("<td valign=\"bottom\">"+getValue(license.getComment(), "")+"<br />");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
							out.print("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
							out.print("</tr>");  //$NON-NLS-1$
							out.print("</table>");  //$NON-NLS-1$
							
							out.print("&nbsp;<br />");  //$NON-NLS-1$
	
							ArrayList ees = license.getIneligibleEEs();
							if(null != ees && 0 < ees.size()){
								out.print("<table align=\"center\" border=\"0\" cellspacing=\"1\" cellpadding=\"1\" width=\"600\" summary=\"layout\">");  //$NON-NLS-1$
	
								out.print("<tr>");  //$NON-NLS-1$
								out.print("<th colspan=\"3\" height=\"18\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">EE details</th>");  //$NON-NLS-1$
								out.print("<th style=\"background-color:#cccccc;\" class=\"bar-blue-med\">EE material no</th>");  //$NON-NLS-1$
								out.print("<th style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Sales order no</th>");  //$NON-NLS-1$
								out.print("<th colspan=\"3\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">Item no</th>");  //$NON-NLS-1$
								out.print("</tr>");  //$NON-NLS-1$
	
								for(int i=0, size=ees.size(); i<size; i++){
									IneligibleEEViewBean ee = (IneligibleEEViewBean)ees.get(i);
									if(null != ee){
										out.print("<tr>");  //$NON-NLS-1$
										out.print("<td valign=\"bottom\" colspan=\"3\">"+getValue(ee.getEEDetails(), "")+"<br />");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
										out.print("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
										out.print("<td valign=\"bottom\">"+getValue(ee.getEEMaterialNumber(), "")+"<br />");  //$NON-NLS-2$  //$NON-NLS-1$  //$NON-NLS-3$
										out.print("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
										out.print("<td valign=\"bottom\">"+getValue(ee.getSalesOrderNumber(), "")+"<br />");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
										out.print("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
										out.print("<td valign=\"bottom\" colspan=\"3\">"+getValue(ee.getItemNumber(), "")+"<br />");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
										out.print("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
										out.print("</tr>");  //$NON-NLS-1$
									}
								}
								out.print("</table>");  //$NON-NLS-1$
								out.print("&nbsp;<br />");  //$NON-NLS-1$
							}
						}
					}
				}
			}
			else{
				out.print("<table align=\"center\" border=\"0\" cellspacing=\"1\" cellpadding=\"1\" width=\"600\" summary=\"layout\">");  //$NON-NLS-1$
				out.print("<tr>");  //$NON-NLS-1$
				out.print("<td valign=\"bottom\">&nbsp;&nbsp;"+Constants.NO_INELIGIBLE_LICENSES+"<br />");  //$NON-NLS-1$  //$NON-NLS-2$
				out.print("<div class=\"ibm-alternate-rule\">&nbsp;<hr/></div></td>");  //$NON-NLS-1$
				out.print("</tr>");  //$NON-NLS-1$
				out.print("</table>");  //$NON-NLS-1$
			}
			out.flush();
		}
		catch(IOException ioe){
			throw new JspException( "I/O Error : " + ioe.getMessage() );  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}

	/**
	 * Returns license information 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getLicenses() {
		return licenses;
	}

	/**
	 * Sets license that need to be displayed 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLicenses TreeMap 
	 */
	public void setLicenses(TreeMap newLicenses) {
		licenses = newLicenses;
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
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isInput() {
		return input;
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
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public int getType() {
		return type;
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
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setInput(boolean b) {
		input = b;
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
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param i 
	 */
	public void setType(int i) {
		type = i;
	}

}
