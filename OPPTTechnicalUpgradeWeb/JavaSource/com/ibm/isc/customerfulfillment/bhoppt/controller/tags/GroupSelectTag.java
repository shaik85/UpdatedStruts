/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;

import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Apr 25, 2005 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version CBS 0.5 
 */
public class GroupSelectTag extends OPPTTag {
	private static final String CLASS_NAME = "SelectTag";  //$NON-NLS-1$
	private String name = null;
	private String style = "iform";  //$NON-NLS-1$
	private String id = null;
	private String onchange = null;
	private TreeMap options = null;
	private String[] selectedOption = null;
	private String[] groupsThatCannotBeDeleted = null;
	private boolean reverse = false;
	private List nonEditableFields = null;
	private String value = null;
	private boolean editable = true;
	private boolean displayValue = true;

	/**
	 * Overridden method - Displays drop down menu 
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
		String methodName = "doStartTag";  //$NON-NLS-1$
		StringBuffer buffer = new StringBuffer();

		if (null != getName()) {
			if (isFieldEditable()) {

				Set keys = options.keySet();
				Iterator groupsIterator = keys.iterator();
				int i = 0;
				boolean tagEnded = false;
				while (groupsIterator.hasNext()) {
					value = (String) options.get(groupsIterator.next());
					if (i == 0) {
						buffer.append("<tr>");  //$NON-NLS-1$
						tagEnded = false;
					}
					buffer.append("<td width=\"12\">");  //$NON-NLS-1$
					/*if (null != getGroupsThatCannotBeDeleted() && isNonEditable(value)) {
						buffer.append("*");  //$NON-NLS-1$
						buffer.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\" />");  //$NON-NLS-1$  //$NON-NLS-3$  //$NON-NLS-2$
					} else if (null != getSelectedOption() && isSelected(value)) {*/
					if (null != getSelectedOption() && isSelected(value)) {
						buffer.append("<input type= \"checkbox\" name=\"" + name + "\" title=\"" + value + "\" value=\"" + value + "\" checked=\"checked\" /><br /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-2$  //$NON-NLS-3$
					} else {
						buffer.append("<input type= \"checkbox\" name=\"" + name + "\" title=\"" + value + "\" value=\"" + value + "\"/><br /></td>");  //$NON-NLS-1$  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-4$
					}
					buffer.append("<td width=\"282\" height=\"18\">");  //$NON-NLS-1$
					buffer.append(value);
					buffer.append("</td>");  //$NON-NLS-1$
					if (i == 1) {
						buffer.append("</tr>");  //$NON-NLS-1$
						tagEnded = true;
						i = 0;
					} else {
						i++;
					}
				}
				if (!tagEnded) {
					buffer.append("</tr>");  //$NON-NLS-1$
				}
			}

			JspWriter out = pageContext.getOut();
			try {
				out.print(buffer.toString());
				out.flush();
			} catch (IOException ioe) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ioe);  //$NON-NLS-1$
			}
		}
		return Tag.SKIP_BODY;
	}

	private boolean isNonEditable(String value) {
		
		boolean selected = false;
		if (value == null) {
		} else if (null != getGroupsThatCannotBeDeleted()) {
			for (int i = 0; i < getGroupsThatCannotBeDeleted().length; i++) {
				
				if (OPPTHelper.trimString(value).equals(getGroupsThatCannotBeDeleted()[i])) {
					selected = true;
					break;
				}
			}
		}

		return selected;
	}
	private boolean isSelected(String value) {
		boolean selected = false;
		if (value == null) {
		} else if (null != getSelectedOption()) {
			for (int i = 0; i < getSelectedOption().length; i++) {
				if (OPPTHelper.trimString(value).equals(getSelectedOption()[i])) {
					selected = true;
					break;
				}
			}
		}

		return selected;
	}
	/**
	 * Returns the identifier for the drop down menu 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
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
	 * Returns the name of the drop down menu 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
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
	 * Returns the collection of options available for the drop down menu
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getOptions() {
		return options;
	}

	/**
	 * Returns the style of the drop down menu 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
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
	 * Sets the drop down menu identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
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
	 * Sets the name of the drop down menu 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
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
	 * Sets collection of options available for the drop down menu 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newOptions TreeMap 
	 */
	public void setOptions(TreeMap newOptions) {
		options = newOptions;
	}

	/**
	 * Sets the style of the drop down menu 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
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
	 * Returns selected option value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String[] getSelectedOption() {
		return selectedOption;
	}

	/**
	 * Sets selected option value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedOption String 
	 */
	public void setSelectedOption(String newSelectedOption[]) {
		selectedOption = newSelectedOption;
	}

	private boolean isSelected(String selectedOption, String option) {
		boolean selected = false;

		if (null != selectedOption && null != option) {
			if (selectedOption.equalsIgnoreCase(option)) {
				selected = true;
			}
		}

		return selected;
	}

	/**
	 * Returns true if value should be used as key and key to be used as value. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isReverse() {
		return reverse;
	}

	/**
	 * Sets the reverse flag value. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newReverse boolean
	 */
	public void setReverse(boolean newReverse) {
		reverse = newReverse;
	}

	/** 
	 * Returns the target value that need to be excuted on change of any value in the drop down. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 18, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getOnchange() {
		return onchange;
	}

	/** 
	 * Sets the target value that need to be excuted on change of any value in the drop down. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 18, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newOnchange String 
	 */
	public void setOnchange(String newOnchange) {
		onchange = newOnchange;
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

	private boolean isFieldEditable() {
		boolean fieldEditable = false;
		if (null != getNonEditableFields()) {
			if (null != getName()) {
				if (!getNonEditableFields().contains(getName())) {
					fieldEditable = true;
				}
			}
		} else {
			if (isEditable()) {
				fieldEditable = true;
			} else {
				fieldEditable = false;
			}
		}
		return fieldEditable;
	}

	/**
	 * Returns string value which need to be used, when the drop down menu is not editable. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 30, 2004 
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
	 * Sets string as value which need to be used, when the drop down is not editable 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 30, 2004 
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
	 * Returns true, if the value the value associated with the selected content 
	 * need to be displayed when the select is non editable 
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
	 * @return boolean
	 */
	public boolean isDisplayValue() {
		return displayValue;
	}

	/**
	 * Returns true if the select box is editable. 
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
	 * @return boolean
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * Sets the flag value for displaying the select content when the select is non editable 
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
	 * @param newDisplayValue boolean
	 */
	public void setDisplayValue(boolean newDisplayValue) {
		displayValue = newDisplayValue;
	}

	/**
	 * Sets select box editable flag value 
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
	 * @param newEditable boolean
	 */
	public void setEditable(boolean newEditable) {
		editable = newEditable;
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
	 * date Jun 24, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String[] getGroupsThatCannotBeDeleted() {
		String[] groups = null;
		if (groupsThatCannotBeDeleted == null) {
			if (nonEditableFields != null) {
				groups = new String[nonEditableFields.size()];
				for (int k = 0; k < nonEditableFields.size(); k++) {
					groups[k] = (String) nonEditableFields.get(k);
				}
			}
			groupsThatCannotBeDeleted = groups;
		}

		return groupsThatCannotBeDeleted;
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
	 * date Jun 24, 2005 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param strings 
	 */
	public void setGroupsThatCannotBeDeleted(String[] strings) {
		groupsThatCannotBeDeleted = strings;
	}

}