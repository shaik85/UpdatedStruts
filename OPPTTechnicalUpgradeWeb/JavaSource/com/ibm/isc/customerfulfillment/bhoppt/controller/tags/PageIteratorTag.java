/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Given the page index, total no of pages and the url to be called this tag helps 
 * us in displaying the page iterator content. It provides the facility to traverse 
 * to first page, previous page, next page and last page. 
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
public class PageIteratorTag extends OPPTTag 
{
	private int pageIndex = 1;
	private int totalPages = 1;
	private int mlcTotalPages = -1;
	private int mlcExcessValue = -1;
	private boolean searchLicenses = false;
	// CR 2031 
	private boolean duplicateSerial = false;
	
	private String url = null;
	
	/**
	 * Overridden method - All the processing that is required to display the page iterator should 
	 * be done at the start of the tag. So override the doStartTag to have logic for page iterator  
	 * content. 
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
			int nextPage = getPageIndex()+1;
			int prevPage = getPageIndex()-1;
			
			StringBuffer buffer = new StringBuffer();
			if(1 < totalPages){
				if(0 >= prevPage){
				    buffer.append("&nbsp;&lt;&nbsp;First");  //$NON-NLS-1$
					buffer.append("&nbsp;Prev");  //$NON-NLS-1$
				}
				else{
					buffer.append("&nbsp;<a href=\""+getUrlValue(1)+"\">&nbsp First</a>");  //$NON-NLS-1$  //$NON-NLS-2$
					buffer.append("&nbsp;<a href=\""+getUrlValue(prevPage)+"\">Prev</a>");  //$NON-NLS-1$  //$NON-NLS-2$
				}
			}

			buffer.append("&nbsp;Showing "+getPageIndex()+" of "+getTotalPages());  //$NON-NLS-2$  //$NON-NLS-1$
			
			if(1 < totalPages){
				if(nextPage > totalPages){
					buffer.append("&nbsp;Next");  //$NON-NLS-1$
					buffer.append("&nbsp;Last&nbsp;&gt;");  //$NON-NLS-1$
				}
				else{
					buffer.append("&nbsp;<a href=\""+getUrlValue(nextPage)+"\">Next</a>");  //$NON-NLS-1$  //$NON-NLS-2$
					buffer.append("&nbsp;<a href=\""+getUrlValue(totalPages)+"\">Last </a>"); //$NON-NLS-1$  //$NON-NLS-2$ 
				}
			}
					
			out.println(buffer.toString());
			out.flush();
		} 
		catch (IOException ioe){
		}
		return Tag.SKIP_BODY;
	}
	
	/**
	 * Returns page index value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 16, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * Returns total number of pages value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 16, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * Returns traversal url value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 16, 2003 
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
	 * Sets page index value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 16, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPageIndex int 
	 */
	public void setPageIndex(int newPageIndex) {
		pageIndex = newPageIndex;
	}

	/**
	 * Sets total number of pages value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 16, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newTotalPages int 
	 */
	public void setTotalPages(int newTotalPages) {
		totalPages = newTotalPages;
	}

	/**
	 * Sets traversal url value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 16, 2003 
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
	 * date Mar 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public int getMlcExcessValue() {
		return mlcExcessValue;
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
	 * date Mar 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public int getMlcTotalPages() {
		return mlcTotalPages;
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
	 * date Mar 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param i 
	 */
	public void setMlcExcessValue(int i) {
		mlcExcessValue = i;
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
	 * date Mar 1, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param i 
	 */
	public void setMlcTotalPages(int i) {
		mlcTotalPages = i;
	}

	private String getUrlValue(int pageIndex){
		StringBuffer iteratorUrl = new StringBuffer();
		iteratorUrl.append(getUrl());
		iteratorUrl.append("?");  //$NON-NLS-1$
		iteratorUrl.append("pageNumberValue="+pageIndex);  //$NON-NLS-1$
		iteratorUrl.append("&totalPagesValue="+getTotalPages());  //$NON-NLS-1$
		iteratorUrl.append("&mlcTotalPagesValue="+getMlcTotalPages());  //$NON-NLS-1$
		iteratorUrl.append("&mlcExcessValue="+getMlcExcessValue());  //$NON-NLS-1$
		iteratorUrl.append("&searchLicenses="+String.valueOf(isSearchLicenses()));  //$NON-NLS-1$
		iteratorUrl.append("&duplicateSerial="+String.valueOf(isDuplicateSerial()));  //$NON-NLS-1$
		return iteratorUrl.toString();
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
	 * date Apr 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSearchLicenses() {
		return searchLicenses;
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
	 * date Apr 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSearchLicenses(boolean b) {
		searchLicenses = b;
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
