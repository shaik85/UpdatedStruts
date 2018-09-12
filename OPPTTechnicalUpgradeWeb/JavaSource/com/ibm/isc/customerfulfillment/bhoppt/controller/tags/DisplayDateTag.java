/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.HttpJspPage;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
;

/** 
 * Given date object to this tag, this tag is used to display the date in readable format.  
 * 
 * <br /><b>Known Bugs</b><br /> 
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
public class DisplayDateTag extends OPPTTag 
{
	private Date date = null;
	private String name = null;
	private boolean hidden = false;
	 
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
		StringBuffer buffer = new StringBuffer();

		if(isHidden()){
			String month = "Mmm";
			String year = "yyyy";
			String day = "dd";
			if(null != getDate()){
				OPPTCalender calender = new OPPTCalender();
				calender.setDate(getDate());
				if(9 >= calender.getDay()){
					day = "0"+calender.getDay();
				}
				else{
					day = calender.getDay()+"";
				}
				if(9 >= calender.getMonth()){
					month = "0"+calender.getMonth();
				}
				else{
					month = calender.getMonth()+"";
				}
				year = calender.getYear()+"";
			}

			buffer.append("<input type=\"hidden\" id=\""+getName()+"Day\" name=\""+getName()+".day\" value=\""+day+"\" />");
			buffer.append("<input type=\"hidden\" id=\""+getName()+"Month\" name=\""+getName()+".month\" value=\""+month+"\" />");
			buffer.append("<input type=\"hidden\" id=\""+getName()+"Year\" name=\""+getName()+".year\" value=\""+year+"\" />");
		}

		buffer.append(getDateValue(getDate(), ""));

		try {
			JspWriter out = null;
			out = pageContext.getOut();
			out.print(buffer.toString());
			out.flush();
		} catch( IOException ioe ) {
			throw new JspException( "I/O Error : " + ioe.getMessage() );
		}

		return Tag.SKIP_BODY;
	}

	/**
	 * Returns the date object  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getDate() {
		return date;
	}

	/**
     * Sets the date object
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 2, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newDate 
     */
	public void setDate(Date newDate) {
		this.date = newDate;
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
	 * date Jan 31, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isHidden() {
		return hidden;
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
	 * date Jan 31, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setHidden(boolean b) {
		hidden = b;
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
	 * date Jan 31, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getName() {
		return name;
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
	 * date Jan 31, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setName(String string) {
		name = string;
	}

}
