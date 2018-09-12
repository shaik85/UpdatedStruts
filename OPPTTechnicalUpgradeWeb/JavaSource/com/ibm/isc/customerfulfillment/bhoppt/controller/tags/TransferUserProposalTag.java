/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.HttpJspPage;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.TransferProposalsActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.UserInfoViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
;

/**
 *  
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</strong><br/> 
 * 
 * <br/><PRE> 
 * date Mar 17, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A
 */
public class TransferUserProposalTag extends OPPTTag 
{
	private ArrayList targetlist = null;
	private ArrayList createapprovelist = null;
	private ArrayList approverlist = null;
	private String message = null;
	private int userrole = 0;
	 
	/**
	 * Overridden method - All the processing that is required to display the date should 
	 * be done at the start of the tag. So override the doStartTag to have logic for displaying 
	 * the date. 
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
		JspWriter out = null;
		

		try {
			out = pageContext.getOut();
			
			out.write("<table border=\"0\" class=\"ibm-data-table ibm-alternating\" width=\"600\" cellpadding=\"1\" summary=\"Select the User to Transfer the Proposal\" cellspacing=\"1\">");  //$NON-NLS-1$
			if(null == message || message.trim().length() == 0 ){
				if(RoleConstants.CREATE_APPROVE != userrole){
					out.write("<tr style=\"background-color:#cccccc;\" class=\"dark\">");  //$NON-NLS-1$
					out.write("<th nowrap=\"nowrap\" width=\"22\" scope=\"col\">&nbsp;</th>");  //$NON-NLS-1$
					out.write("<th nowrap=\"nowrap\" width=\"572\" scope=\"col\">&nbsp;&nbsp;User ID</th>");  //$NON-NLS-1$
					out.write("</tr>");  //$NON-NLS-1$
					displayData(out, targetlist, "selectedUserId");  //$NON-NLS-1$
				}
				else{
					out.write("<tr style=\"background-color:#cccccc;\" class=\"dark\">");  //$NON-NLS-1$
					out.write("<th nowrap=\"nowrap\" width=\"22\" scope=\"col\">&nbsp;</th>");  //$NON-NLS-1$
					out.write("<th nowrap=\"nowrap\" width=\"572\" scope=\"col\">&nbsp;&nbsp;CreateApprove User ID's</th>");  //$NON-NLS-1$
					out.write("</tr>");  //$NON-NLS-1$
					displayData(out, createapprovelist, "createApproverId");  //$NON-NLS-1$
			
					out.write("<tr style=\"background-color:#cccccc;\" class=\"dark\">");  //$NON-NLS-1$
					out.write("<th nowrap=\"nowrap\" width=\"22\" scope=\"col\">&nbsp;</th>");  //$NON-NLS-1$
					out.write("<th nowrap=\"nowrap\" width=\"572\" scope=\"col\">&nbsp;&nbsp;Approver Role User ID's</th>");  //$NON-NLS-1$
					out.write("</tr>");  //$NON-NLS-1$
					displayData(out, approverlist,"approverId");  //$NON-NLS-1$

					out.write("<tr style=\"background-color:#cccccc;\" class=\"dark\">");  //$NON-NLS-1$
					out.write("<th nowrap=\"nowrap\" width=\"22\" scope=\"col\">&nbsp;</th>");  //$NON-NLS-1$
					out.write("<th nowrap=\"nowrap\" width=\"572\" scope=\"col\">&nbsp;&nbsp;CSO/ Marketing Representative role user ID's</th>");  //$NON-NLS-1$
					out.write("</tr>");  //$NON-NLS-1$
					displayData(out, targetlist, "generalUserId");  //$NON-NLS-1$
					
				}
			}
			else{
				out.write("<tr>");  //$NON-NLS-1$
				out.write("<td colspan=\"2\">" + message + "</td>");  //$NON-NLS-2$  //$NON-NLS-1$
				out.write("</tr>");  //$NON-NLS-1$
			}
			out.write("<tr>");  //$NON-NLS-1$
			out.write("<td colspan=\"2\"><input type=\"hidden\" name=\"sourceUserRole\" value=\"" + userrole + "\"/></td>");  //$NON-NLS-1$  //$NON-NLS-2$
			out.write("</tr>");  //$NON-NLS-1$
			out.write("</table>");  //$NON-NLS-1$
	
			out.flush();
		} catch( IOException ioe ) {
			throw new JspException( "I/O Error : " + ioe.getMessage() );  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}
	
	private void displayData(JspWriter out, ArrayList userList, String tagName) throws IOException{
		String userId;
		String labelValue;
		UserInfoViewBean userInfoBean;
		int listSize = userList.size();
		
		for(int i=0; i < listSize; i++)	{
			userInfoBean = (UserInfoViewBean)userList.get(i);
			userId = userInfoBean.getUserId();
			labelValue = "userId" + userId;  //$NON-NLS-1$
			if(((i+1) % 2) == 1) {
				out.write("<tr class=\"white\">");  //$NON-NLS-1$
			}
			else {
				out.write("<tr class=\"gray\">");  //$NON-NLS-1$
			}
			out.write("<td>&nbsp;<input type=\"radio\" name=\"" + tagName + "\" id=\"" + labelValue + "\" value=\"" + userId + "\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-2$  //$NON-NLS-3$
			out.write("<td>&nbsp;&nbsp;<label for=\"" + labelValue + "\">"+ userId + "</label></td>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
			out.write("</tr>");  //$NON-NLS-1$
		}
		out.write("<tr><td colspan=\"2\">&nbsp;</td></tr>");  //$NON-NLS-1$
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
	 * date Mar 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public ArrayList getTargetlist() {
		return targetlist;
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
	 * date Mar 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
	public void setTargetlist(ArrayList list) {
		targetlist = list;
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
	 * date Mar 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public int getUserrole() {
		return userrole;
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
	 * date Mar 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param i 
	 */
	public void setUserrole(int i) {
		userrole = i;
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
	 * date Mar 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public ArrayList getApproverlist() {
		return approverlist;
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
	 * date Mar 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public ArrayList getCreateapprovelist() {
		return createapprovelist;
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
	 * date Mar 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
	public void setApproverlist(ArrayList list) {
		approverlist = list;
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
	 * date Mar 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
	public void setCreateapprovelist(ArrayList list) {
		createapprovelist = list;
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
	 * date Mar 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getMessage() {
		return message;
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
	 * date Mar 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setMessage(String string) {
		message = string;
	}

}
