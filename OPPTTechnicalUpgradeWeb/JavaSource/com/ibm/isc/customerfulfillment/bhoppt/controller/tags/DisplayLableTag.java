/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.HttpJspPage;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;

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
public class DisplayLableTag extends OPPTTag
{
	private String label = null;
	private String defaultLabel = "";  //$NON-NLS-1$
	private String id = null;
	private HashSet errorLables  = null;
	private String errorStyle = "color: #cc0000";  //$NON-NLS-1$
	private String labelStyle = "color: #000000";  //$NON-NLS-1$
	private int wordLength = -1;
	 
	/**
	 * Overridden method - All the processing that is required to display the label with style should 
	 * be done at the start of the tag. So override the doStartTag to have logic for displaying the 
	 * label. 
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
		if(null != label){
			if(-1 != wordLength){
				label = getValue(label,wordLength);
			}
			
			if(null != errorLables && errorLables.contains(id)){
				System.out.println("DisplayLableTag.doStartTag()+erororor"+errorLables);
				System.out.println("DisplayLableTag.doStartTag()erorro2"+errorLables.contains(id));
				buffer.append("<input type=\"hidden\" name=\"validationErrorElements\" value=\""+id+"\">");
				buffer.append("<span  title = \"Enter the proposal name\"  style=\""+errorStyle+"\">"+label+  "</span>");  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-1$
			}
			else {
				//buffer.append("<input type=\"hidden\" name=\"validationErrorElements\" value=\""+id+"\">");
				buffer.append("<span style=\""+labelStyle+"\">"+label+"</span>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
			}
		}
		else {
			buffer.append("<span style=\""+labelStyle+"\">"+defaultLabel+"</span>");  //$NON-NLS-3$  //$NON-NLS-1$  //$NON-NLS-2$
		}

		try{
			pageContext.getOut().println(buffer.toString());
		}
		catch(IOException ioe){
			throw new JspException( "I/O Error : " + ioe.getMessage() );  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}

	/**
	 * Returns error lables collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return HashSet
	 */
	public HashSet getErrorLables() {
		return errorLables;
	}

	/**
	 * Returns error style value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getErrorStyle() {
		return errorStyle;
	}

	/**
	 * Returns label value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Returns lable style 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getLabelStyle() {
		return labelStyle;
	}

	/**
	 * Sets error lables collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newErrorLables HashSet 
	 */
	public void setErrorLables(HashSet newErrorLables) {
		errorLables = newErrorLables;
	}

	/**
	 * Sets error style value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newErrorStyle String 
	 */
	public void setErrorStyle(String newErrorStyle) {
		errorStyle = newErrorStyle;
	}

	/**
	 * Sets label value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLabel String 
	 */
	public void setLabel(String newLabel) {
		label = newLabel;
	}

	/**
	 * Sets lable style 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLabelStyle String 
	 */
	public void setLabelStyle(String newLabelStyle) {
		labelStyle = newLabelStyle;
	}
	
	/**
	 * Returns label identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 27, 2003 
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
	 * Sets label identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 27, 2003 
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
	 * If label value is null this default value id used 
	 * 
	 * <br><b>Known Bugs</b><br> 
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
	public String getDefaultLabel() {
		return defaultLabel;
	}

	/**
	 * Sets defautlt label that need to be used when label value is null 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDefaultLabel String
	 */
	public void setDefaultLabel(String newDefaultLabel) {
		defaultLabel = newDefaultLabel;
	}
	
	/**
	 * Returns word length allowed at a stretch 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getWordLength() {
		return wordLength;
	}

	/**
	 * Sets word length value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newWordLenth int
	 */
	public void setWordLength(int newWordLenth) {
		wordLength = newWordLenth;
	}
}