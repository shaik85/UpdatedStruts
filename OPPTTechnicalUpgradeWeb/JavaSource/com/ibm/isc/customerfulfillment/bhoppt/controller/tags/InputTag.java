/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

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
public class InputTag extends OPPTTag
{
	private String type = "hidden";  //$NON-NLS-1$
	private String name = null;
	private String value = null;
	private String defaultValue = null;
	 
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
		if(null != value){
			buffer.append("<input ");  //$NON-NLS-1$
			buffer.append("type=\""+type+"\" ");  //$NON-NLS-2$  //$NON-NLS-1$
			buffer.append("name=\""+name+"\" ");  //$NON-NLS-2$  //$NON-NLS-1$
			buffer.append("value=\""+value+"\" ");  //$NON-NLS-2$  //$NON-NLS-1$
			buffer.append("/>");  //$NON-NLS-1$
		}
		else if(null != defaultValue){
			buffer.append("<input ");  //$NON-NLS-1$
			buffer.append("type=\""+type+"\" ");  //$NON-NLS-2$  //$NON-NLS-1$
			buffer.append("name=\""+name+"\" ");  //$NON-NLS-2$  //$NON-NLS-1$
			buffer.append("value=\""+defaultValue+"\" ");  //$NON-NLS-2$  //$NON-NLS-1$
			buffer.append("/>");  //$NON-NLS-1$
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
	 * Returns the name of the input field 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets input type value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Returns input fields value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the input name value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newName String 
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Sets input type value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newType String 
	 */
	public void setType(String newType) {
		type = newType;
	}

	/**
	 * Sets input fields value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newValue String 
	 */
	public void setValue(String newValue) {
		value = newValue;
	}
	
	/**
	 * Returns defaule value of the input field 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * Sets default value of the input field 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDefaultValue String 
	 */
	public void setDefaultValue(String newDefaultValue) {
		defaultValue = newDefaultValue;
	}
}