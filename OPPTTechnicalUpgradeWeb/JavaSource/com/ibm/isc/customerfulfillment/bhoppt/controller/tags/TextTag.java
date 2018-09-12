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
 * JSP custom tag that is used for displayng text box in the oppt application.
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
public class TextTag extends OPPTTag
{
	private String name = null;
	private String styleId = null;
	private String styleClass = "iform";  //$NON-NLS-1$
	// BH Wave1 DAD003-Complex Contract Identifiers - Begin - Bhanu
	private String style = null;
	// BH Wave1 DAD003-Complex Contract Identifiers - End - Bhanu
	private String value = null;
	private String alt = null;
	private boolean readonly = false;
	private boolean disabled = false;

	private String size = null;
	private String maxlength = null;
	private int wordLength = -1;
	private List nonEditableFields = null;
	private String title = null;
	

	/**
	 * Overridden method - All the processing to create an html text field is done here. 
	 * 
	 * <br /><PRE> 
	 * date Feb 10, 2004 
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
		StringBuffer results = new StringBuffer();
		if(isFieldEditable()){
			results.append("<input type=\"text\"");  //$NON-NLS-1$
			results.append(" name=\"");  //$NON-NLS-1$
			results.append(name);
			results.append("\"");  //$NON-NLS-1$
			if(null != maxlength)
			{
				results.append(" maxlength=\"");  //$NON-NLS-1$
				results.append(maxlength);
				results.append("\"");  //$NON-NLS-1$
			}
			if(null != size)
			{
				results.append(" size=\"");  //$NON-NLS-1$
				results.append(size);
				results.append("\"");  //$NON-NLS-1$
			}
			results.append(" value=\"");  //$NON-NLS-1$
			results.append(getValue(value, ""));  //$NON-NLS-1$
			results.append("\"");  //$NON-NLS-1$

			if(null != styleClass)
			{
				results.append(" class=\"");  //$NON-NLS-1$
				results.append(styleClass);
				results.append("\"");  //$NON-NLS-1$
			}
			if(null != styleId)
			{
				results.append(" id=\"");  //$NON-NLS-1$
				results.append(styleId);
				results.append("\"");  //$NON-NLS-1$
			}
			// BH Wave1 DAD003-Complex Contract Identifiers - Begin - Bhanu
			if(null != style)
			{
				results.append(" style=\"");  //$NON-NLS-1$
				results.append(style);
				results.append("\"");  //$NON-NLS-1$
			}
			// BH Wave1 DAD003-Complex Contract Identifiers - End - Bhanu
			if(null != alt)
			{
				results.append(" alt=\"");
				results.append(alt);
				results.append("\"");
			}
			if(null != title)
			{
				results.append(" title=\"");
				results.append(title);
				results.append("\"");
			}
			if(disabled)
				results.append(" disabled=\"disabled\"");
			if(readonly)
				results.append(" readonly=\"readonly\"");

			results.append(" />");
		}
		else{
			if(-1 != wordLength){
				results.append(getValue(getValue(), wordLength));
			}
			else{
				results.append(getValue(getValue(), ""));
			}
			if(null != getValue()){
				results.append("<input type=\"hidden\" name=\""+getName()+"\" value=\""+getValue()+"\" />");
			}
		}

		JspWriter out = pageContext.getOut();
		try{
			pageContext.getOut().print(results.toString());
		}
		catch (IOException ioe) {
			// Intentionally left blank. IOException occured when printing the content
		} 
		finally {
			try {
				out.flush();
			} catch (IOException ioe) {
				// Intentionally left blank. IOException occured when flushing the content
				// back to the browser.
			}
		}
		return SKIP_BODY;
	}
	
	/**
	 * Returns alternate text for the text field 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getAlt() {
		return alt;
	}

	/**
	 * Resturns number of columns allowed for the text field 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Returns maximum number of columns availble for the text field 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getMaxlength() {
		return maxlength;
	}

	/**
	 * Returns text field property value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
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
	 * Returns style class value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getStyleClass() {
		return styleClass;
	}

	/**
	 * Returns style id value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
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
	 * Returns value associated with the text field 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
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
	 * Sets alternate text for the text field 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAlt String 
	 */
	public void setAlt(String newAlt) {
		alt = newAlt;
	}

	/**
	 * Sets column width value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSize String
	 */
	public void setSize(String newSize) {
		size = newSize;
	}

	/**
	 * Sets maximum length of the text field value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMaxLength String
	 */
	public void setMaxlength(String newMaxLength) {
		maxlength = newMaxLength;
	}

	/**
	 * Sets text field property value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
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
	 * Sets style class value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStyleClass String 
	 */
	public void setStyleClass(String newStyleClass) {
		styleClass = newStyleClass;
	}

	/**
	 * Sets style id value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
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
	 * Sets text value available for the text field 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
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
	 * Returns true if the text field is editable 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isReadonly() {
		return readonly;
	}

	/**
	 * Sets editable property of the text field 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newReadonly boolean 
	 */
	public void setReadonly(boolean newReadonly) {
		readonly = newReadonly;
	}

	/**
	 * Returns disabled property of the text field 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isDisabled() {
		return disabled;
	}

	/**
	 * Sets disabled property of the text field. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDisabled boolean
	 */
	public void setDisabled(boolean newDisabled) {
		disabled = newDisabled;
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
	// BH Wave1 DAD003-Complex Contract Identifiers - Begin - Bhanu
	/**
	 * @return Returns the style.
	 */
	public String getStyle() {
		return style;
	}
	/**
	 * @param style The style to set.
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	// BH Wave1 DAD003-Complex Contract Identifiers - End - Bhanu
}
