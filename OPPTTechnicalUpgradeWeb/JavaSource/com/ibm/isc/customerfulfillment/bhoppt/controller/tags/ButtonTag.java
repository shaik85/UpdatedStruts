/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import javax.servlet.jsp.JspException;

import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.OPPTButton;

/**
 * 
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
public class ButtonTag extends OPPTTag
{
	private String name = null;
	private String alt = null;
	private String id = null;
	private String value = null;	
	private String onclick = null;
	private boolean primary = false;

	/**
	 * doStartTag 
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
	 * @return 
	 */
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}

	/**
     * doEndTag
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Feb 18, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return
     * @throws javax.servlet.jsp.JspException 
     */	
	public int doEndTag() throws JspException {
		ButtonsTag parent = (ButtonsTag)getParent();
		if (parent != null){
			parent.addButton(new OPPTButton(getName(), getAlt(), getId(), getValue(),getOnclick(), isPrimary()));
		}
		return SKIP_BODY;
	}

	
	/**
	 * Returns alternate text for the button 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
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
	 * Returns name of the button 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
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
	 * Returns image source of the button 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
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
	 * Sets alternate text of the button 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
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
	 * Sets name of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
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
     * Sets image source of the proposal
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 15, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newValue 
     */
	public void setValue(String newValue) {
		value = newValue;
	}
	
	/**
	 * Returns button identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
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
	 * Sets button identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
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
	 * Returns true if this button is an primary button 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isPrimary() {
		return primary;
	}

	/**
	 * Sets if this button is an primary button 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPrimary boolean
	 */
	public void setPrimary(boolean newPrimary) {
		primary = newPrimary;
	}
	/** 
	 * Returns the target value that should be executed on click of the button. 
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
	 * @return 
	 */
	public String getOnclick() {
		return onclick;
	}

	/**
	 * Sets the target value that should be executed on click of the button. 
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
	 * @param newOnclick String 
	 */
	public void setOnclick(String newOnclick) {
		onclick = newOnclick;
	}
}
