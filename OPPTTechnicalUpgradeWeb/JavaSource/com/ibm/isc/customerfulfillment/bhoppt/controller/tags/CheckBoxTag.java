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

/**
 * Custom tag that is used for displaying a check box in required state
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
public class CheckBoxTag extends OPPTTag {
	private String name = null;
	private String styleId = null;
	private boolean checked = false;
	private String style = "iform";  //$NON-NLS-1$
	private String value = null;
	private List nonEditableFields = null;
	private boolean editable = true;
	private String title = null;
	private String onclick = null;
		
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
		if(null == styleId){
			styleId = name;
		}
		if(null == value){
			value = "true";  //$NON-NLS-1$
		}
		
		StringBuffer buffer = new StringBuffer();
		if(isEditable()){
			if(isFieldEditable()){
				buffer.append("<input type=\"checkbox\"");  //$NON-NLS-1$
				buffer.append(" name=\""+name+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
				buffer.append(" id=\""+styleId+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
				buffer.append(" value=\""+value+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
				if(isChecked()){
					buffer.append(" checked=\"checked\"");  //$NON-NLS-1$
				}
				if(null != onclick){
					buffer.append(" onclick=\""+getOnclick()+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
				}
				buffer.append(" title=\""+getTitle()+"\""); 
				buffer.append(" />");  //$NON-NLS-1$
			}
			else{
				if(isChecked()){
					buffer.append("Checked");  //$NON-NLS-1$
				}
				else{
					buffer.append("Unchecked");  //$NON-NLS-1$
				}
				buffer.append("<input type=\"hidden\"");  //$NON-NLS-1$
				buffer.append(" name=\""+name+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
				if(isChecked()){
					buffer.append(" value=\"true\"");  //$NON-NLS-1$
				}
				else{
					buffer.append(" value=\"false\"");  //$NON-NLS-1$
				}
				buffer.append(" title=\""+getTitle()+"\"");
				buffer.append(" />");  //$NON-NLS-1$
			}
		}
		else{
			if(isChecked()){
				buffer.append("Checked");  //$NON-NLS-1$
			}
			else{
				buffer.append("Unchecked");  //$NON-NLS-1$
			}
			buffer.append("<input type=\"hidden\"");  //$NON-NLS-1$
			buffer.append(" name=\""+name+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
			if(isChecked()){
				buffer.append(" value=\"true\"");  //$NON-NLS-1$
			}
			else{
				buffer.append(" value=\"false\"");  //$NON-NLS-1$
			}
			buffer.append(" title=\""+getTitle()+"\"");
			buffer.append(" />");  //$NON-NLS-1$
		}

		try 
		{
			JspWriter out = pageContext.getOut();
			out.println(buffer.toString());
			out.flush();
		} catch (IOException ioe) {
			throw new JspException("I/O Error : " + ioe.getMessage());  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
	}
	
	/**
	 * Returns if the check box is already checked or not 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * Returns property value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 29, 2004 
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
	 * Returns style value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * Sets checked flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newChecked boolean
	 */
	public void setChecked(boolean newChecked) {
		checked = newChecked;
	}

	/**
	 * Sets check box property value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 29, 2004 
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
	 * Sets style value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStyle String 
	 */
	public void setStyle(String newStyle) {
		style = newStyle;
	}

	/**
	 * Returns style id value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getStyleId() {
		return styleId;
	}

	/** 
	 * Sets style id value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStyleId String 
	 */
	public void setStyleId(String newStyleId) {
		styleId = newStyleId;
	}
	
	/**
	 * Returns the checkbox value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
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
	 * Sets check box value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
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
	 * Returns collection of non editable field names 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getNonEditableFields() {
		return nonEditableFields;
	}

	/**
	 * Sets collection of non editable field names 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNonEditableFields List
	 */
	public void setNonEditableFields(List newNonEditableFields) {
		nonEditableFields = newNonEditableFields;
	}

	private boolean isFieldEditable(){
		boolean fieldEditable = false;
		if(null != getNonEditableFields())
		{
			if(null != getName())
			{
				if(!getNonEditableFields().contains(getName())){
					fieldEditable = true;
				}
			}
		}
		else{
			fieldEditable = true;
		}
		return fieldEditable;
	}
	
	/**
	 * Returns true if the check box is editable 
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
	 * @return boolean
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * Sets editable flag value 
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
	 * @param newEditable boolean
	 */
	public void setEditable(boolean newEditable) {
		editable = newEditable;
	}
	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return Returns the onclick
	 */
	public String getOnclick() {
		return onclick;
	}
	/**
	 * @param newOnclick
	 */
	public void setOnclick(String newOnclick) {
		onclick = newOnclick;
	}
}