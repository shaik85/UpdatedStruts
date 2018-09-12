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
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Tag that helps in displaying the show or hide toll bar 
 * 
 * <br /><b>Known Bugs</b><br /> 
 * 
 * <br /><PRE> 
 * date Dec 19, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br /> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class DisplayShowHideTag extends OPPTTag
{
	private boolean show = false;
	private String url = null;
	private int type = 1;
	private int block = 1;
	private String link = null;

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br /><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * Changed by Balaji for W3V8 comments
	 * 
	 * </PRE><br /> 
	 * 
		<a href="/ShowFetchIneligibleLicenses?show=true&type=1">show</a>&nbsp;&nbsp;|&nbsp;&nbsp;hide&nbsp;&nbsp;
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag() 
	 * @return int
	 * @throws javax.servlet.jsp.JspException 
	 * 
	 */
	public int doStartTag() throws JspException 
	{
		JspWriter out = pageContext.getOut();

		try 
		{
			String url = "";  //$NON-NLS-1$
			String content = "";  //$NON-NLS-1$
						
			if(isShow()){
			//	content += "show&nbsp;&nbsp;|&nbsp;&nbsp;<a href=\""+getUrl()+"?show=false&type="+getType()+"&block="+getBlock()+"\">hide</a>&nbsp;&nbsp;";
				content += "<a href=\""+getUrl()+"?show=false&type="+getType()+"&block="+getBlock()+"\"> <img src=\"//w3.ibm.com/ui/v8/images/icon-link-collapse-dark.gif\" width=\"13\" height=\"13\" alt=\"Hide\" /></a>";  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-4$
				content +="&nbsp;&nbsp;<a href=\""+getUrl()+"?show=false&type="+getType()+"&block="+getBlock()+"\">"+getLink()+"</a>";  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-5$  //$NON-NLS-2$  //$NON-NLS-4$
			}
			else{
				
			//	content += "<a href=\""+getUrl()+"?show=true&type="+getType()+"&block="+getBlock()+"\">show</a>&nbsp;&nbsp;|&nbsp;&nbsp;hide&nbsp;&nbsp;";
				content += "<a href=\""+getUrl()+"?show=true&type="+getType()+"&block="+getBlock()+"\"> <img src=\"//w3.ibm.com/ui/v8/images/icon-link-expand-dark.gif\" width=\"13\" height=\"13\" alt=\"Show\" /></a>";  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-4$
				content += "&nbsp;&nbsp;<a href=\""+getUrl()+"?show=true&type="+getType()+"&block="+getBlock()+"\">"+getLink()+"</a>";  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-5$  //$NON-NLS-2$  //$NON-NLS-4$
			}
			
			
			out.print(content);
			out.flush();
		} 
		catch (IOException ioe) 
		{
		}
		return Tag.SKIP_BODY;
	}

	/**
	 * Returns true if the show should be made as link or returns false if hide should be made as link 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isShow() {
		return show;
	}

	/**
	 * Returns type of the show. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getType() {
		return type;
	}

	/**
	 * Returns url to which the show or hide has to be linked
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets show flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newShow boolean 
	 */
	public void setShow(boolean newShow) {
		show = newShow;
	}

	/**
	 * Sets type value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newType int 
	 */
	public void setType(int newType) {
		type = newType;
	}

	/**
	 * Sets show or hide link url. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newUrl String 
	 */
	public void setUrl(String newUrl) {
		url = newUrl;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public int getBlock() {
		return block;
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
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param i 
	 */
	public void setBlock(int i) {
		block = i;
	}

	/**
     * getLink
     *
     * @return Returns the link.
     */
	public String getLink() {
		return link;
	}
	/**
     *  setLink
     *
     *  @param link The link to set.
     */
	public void setLink(String link) {
		this.link = link;
	}
}
