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

import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerListCustomerViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerListViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;

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
public class CustomerListCustomerTag extends OPPTTag {
	private TreeMap customerLists = null;
	private String stpProperty = "selectedSTP";  //$NON-NLS-1$
	private String invProperty = "selectedINV";  //$NON-NLS-1$
	

	
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
		try 
		{
			if (null != customerLists) 
			{
				int size = customerLists.size();
				if (0 < size) 
				{
					Iterator customerListIterator = customerLists.values().iterator();
					while(customerListIterator.hasNext())
					{
						CustomerListViewBean customerList = (CustomerListViewBean)customerListIterator.next();
						if(null != customerList)
						{
							//out.println("<table cellpadding=\"1\" cellspacing=\"1\" width=\"700\" summary=\"Customer List Details\">");  //$NON-NLS-1$
							//out.println("<tr>");  //$NON-NLS-1$
						//	out.println("<td width=\"352\" height=\"18\" class=\"bar-blue-med-dark\">&nbsp;&nbsp;Customer list number: "+getValue(customerList.getListNumber(), "")+"</td>");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
							//out.println("<td width=\"340\" height=\"18\" class=\"bar-blue-med-dark\">&nbsp;&nbsp;Customer list name: "+getValue(customerList.getListName(), "")+"</td>");  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-1$
							//out.println("</tr>");  //$NON-NLS-1$
							//out.println("</table>");  //$NON-NLS-1$
							out.println("<table  cellpadding=\"1\" cellspacing=\"1\" width=\"700\" summary=\"Selecting STP & INV\">");  //$NON-NLS-1$
							out.println("<tr>");  //$NON-NLS-1$
							out.println("<th width=\"32\" height=\"18\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">&nbsp;&nbsp;STP</th>");  //$NON-NLS-1$
							out.println("<th width=\"32\" height=\"18\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">&nbsp;&nbsp;INV</th>");  //$NON-NLS-1$
							//DADO02 out.println("<th width=\"140\" height=\"18\" class=\"bar-blue-med\">&nbsp;&nbsp;Legacy cust. no.</th>");  //$NON-NLS-1$
							out.println("<th width=\"130\" height=\"18\" style=\"background-color:#cccccc;\" class=\"bar-blue-med\">&nbsp;&nbsp;Customer no.</th>");  //$NON-NLS-1$
							out.println("<th width=\"360\" height=\"18\" style=\"background-color:#cccccc;\"class=\"bar-blue-med\">&nbsp;&nbsp;Customer name</th>");  //$NON-NLS-1$
							out.println("</tr>");  //$NON-NLS-1$

							/*TreeMap customers = customerList.getCustomers();
							if(null != customers){
								Iterator customersIterator = customers.values().iterator();
								while(customersIterator.hasNext()){
									CustomerListCustomerViewBean customer = (CustomerListCustomerViewBean)customersIterator.next();
							*/	
							String id = customerList.getCustomerNumber();
									out.println("<tr valign=\"bottom\">");  //$NON-NLS-1$
									if(customerList.isSelectedSTP()){
										if(customerList.isInvSelected()){
											out.println("<td align=\"center\">&nbsp;<input type=\"radio\" name=\""+stpProperty+"\" id=\"radLegCustNo\" title=\"STP_"+customerList.getCustomerNumber()+"\" value=\""+id+"\" checked=\"checked\" />");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
										}
										else{
											out.println("<td align=\"center\">&nbsp;<input type=\"radio\" name=\""+stpProperty+"\" id=\"radLegCustNo\" title=\"STP_"+customerList.getCustomerNumber()+"\" value=\""+id+"\" onclick = \"selectINV(document.CustomerSelectionActionForm.id"+customerList.getCustomerNumber()+")\" checked=\"checked\" />");  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-1$  //$NON-NLS-4$
										}
									} 
									else{
										if(customerList.isInvSelected()){
											out.println("<td align=\"center\">&nbsp;<input type=\"radio\" title=\"STP_"+customerList.getCustomerNumber()+"\" name=\""+stpProperty+"\"  value=\""+id+"\" />");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
										}
										else{
											out.println("<td align=\"center\">&nbsp;<input type=\"radio\"  title=\"STP_"+customerList.getCustomerNumber()+"\" name=\""+stpProperty+"\"  value=\""+id+"\" onclick = \"selectINV(document.CustomerSelectionActionForm.id"+customerList.getCustomerNumber()+")\" /> " );  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-1$  //$NON-NLS-4$
										}
									}
									// asasas out.println("<br /><div class=\"ibm-alternate-rule\"><hr /> &nbsp;</div></td>");  //$NON-NLS-1$
									
									
									if(customerList.isInvSelected()){
													if(customerList.isAlreadyExists()){ //DADO02 Sateesh Anne
											out.println("<td align=\"center\">&nbsp;*");    
											out.println("<input type=\"hidden\" name=\""+invProperty+"\" value=\""+id+"\" />");
										}else{
											out.println("<td align=\"center\">&nbsp;<input type=\"checkbox\" title=\"INV_"+customerList.getCustomerNumber()+"\" name=\""+invProperty+"\" id=\"id"+customerList.getCustomerNumber()+"\" value=\""+id+"\" checked=\"checked\" />");  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-4$  //$NON-NLS-1$	
										}
																			
											
									}
									else if(customerList.isUserINVSelection()){
										out.println("<td align=\"center\">&nbsp;<input type=\"checkbox\" title=\"INV_"+customerList.getCustomerNumber()+"\" name=\""+invProperty+"\" id=\"id"+customerList.getCustomerNumber()+"\" value=\""+id+"\" checked=\"checked\" />");  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-4$  //$NON-NLS-1$
									}
									else{
										if(customerList.isAlreadyExists()){ //DADO02 Sateesh Anne BlueHarmony
											out.println("<td align=\"center\">&nbsp;*");    
											out.println("<input type=\"hidden\" name=\""+invProperty+"\" value=\""+id+"\" />");
										}else{
										out.println("<td align=\"center\">&nbsp;<input type=\"checkbox\" title=\"INV_"+customerList.getCustomerNumber()+"\" name=\""+invProperty+"\" id=\"id"+customerList.getCustomerNumber()+"\" value=\""+id+"\" />");  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-4$  //$NON-NLS-1$
										}
									}
									out.println("<br /><div class=\"ibm-alternate-rule\"><hr /> &nbsp;</div></td>");  //$NON-NLS-1$
									//out.println("<td>&nbsp;&nbsp;<label for=\"radLegCustNo\">"+getValue(customerList.getLegacyCustomerNumberWithAS(), "")+"</label>");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
									out.println("<br /><div class=\"ibm-alternate-rule\"><hr /> &nbsp;</div></td>");  //$NON-NLS-1$
									//out.println("<td>&nbsp;&nbsp;<label for=\"id"+customerList.getCustomerNumber()+"\">"+getValue(customerList.getCustomerNumber(), "")+"</label>");  //$NON-NLS-2$  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$
							
									out.println("<td>&nbsp;&nbsp;<label>"+getValue(customerList.getCustomerNumber(), "")+"</label>");  //$NON-NLS-2$  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$out.println("<br /><div class=\"ibm-alternate-rule\"><hr /> &nbsp;</div></td>");  //$NON-NLS-1$
									out.println("<td>&nbsp;&nbsp;"+getValue(customerList.getCustomerName(), "")+"");  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-1$
									out.println("<br /><div class=\"ibm-alternate-rule\"><hr /> &nbsp;</div></td>");  //$NON-NLS-1$
									out.println("</tr>");  //$NON-NLS-1$
									/* CR0531074816 - CBS OPPT accessibility issues
									out.println("<tr>");  //$NON-NLS-1$
									out.println("<td><div class=\"ibm-alternate-rule\"><hr /> &nbsp;</div></td>");  //$NON-NLS-1$
									out.println("<td><div class=\"ibm-alternate-rule\"><hr /> &nbsp;</div></td>");  //$NON-NLS-1$
									out.println("<td><div class=\"ibm-alternate-rule\"><hr /> &nbsp;</div></td>");  //$NON-NLS-1$
									out.println("<td><div class=\"ibm-alternate-rule\"><hr /> &nbsp;</div></td>");  //$NON-NLS-1$
									out.println("<td><div class=\"ibm-alternate-rule\"><hr /> &nbsp;</div></td>");  //$NON-NLS-1$
									out.println("</tr>");  //$NON-NLS-1$ */
								}
							}
							out.println("</table>");  //$NON-NLS-1$
							out.println("&nbsp;<br />");  //$NON-NLS-1$
						}
					}
				//}
			//}
			out.flush();
		} catch (IOException ioe) {
			throw new JspException("I/O Error : " + ioe.getMessage());  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}
	
	/**
	 * Returns collection of customer lists 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getCustomerLists() {
		return customerLists;
	}

	/**
	 * Sets customer list selection 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerLists TreeMap 
	 */
	public void setCustomerLists(TreeMap newCustomerLists) {
		customerLists = newCustomerLists;
	}

	/**
	 * Returns inventory property value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getInvProperty() {
		return invProperty;
	}

	/**
	 * Sets inventory property value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getStpProperty() {
		return stpProperty;
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
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setInvProperty(String string) {
		invProperty = string;
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
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setStpProperty(String string) {
		stpProperty = string;
	}
	

}
