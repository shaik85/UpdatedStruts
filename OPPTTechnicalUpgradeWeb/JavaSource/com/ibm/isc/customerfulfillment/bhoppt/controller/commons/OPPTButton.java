/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;


import java.io.Serializable;

/**
 * Holder class for holding button information  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 9, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class OPPTButton implements Serializable {
	private String name = null;
	private String alt = null;
	private String id = null;
	private String value = null;
	private String onclick = null;
	private boolean primary = false;
	
	/**
	 * Returns alternate text associated with the button 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
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
	 * Returns button identifier value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
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
	 * Returns name of the button 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
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
	 * Returns true if the button is an primary button 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isPrimary() {
		return primary;
	}

	/**
	 * Returns image source value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
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
	 * Sets alternate text for the button 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
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
	 * Sets button identifier value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
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
	 * Sets name of the button 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
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
	 * Sets button type value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
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
     * Sets image value value
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Feb 9, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param newvalue 
     */
	public void setValue(String newvalue) {
		value = newvalue;
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

	/**
     * OPPTButton
     * 
     * @author thirumalai
     */
    public OPPTButton(){
	}

	/**
     * OPPTButton
     * 
     * @param name
     * @param alt
     * @param id
     * @param value
     * @param onclick
     * @param primary
     * @author thirumalai
     */
    public OPPTButton(String name, String alt, String id, String value, String onclick, boolean primary){
		setName(name);
		setAlt(alt);
		setId(id);
		setValue(value);
		setOnclick(onclick);
		setPrimary(primary);
	}
	
	/**
     * toString
     * 
     * @see java.lang.Object#toString()
     * @author thirumalai
     */
    public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[OPPTButton] - [id: "+getId()+"] - [Name: "+getName()+"] - [value: "+getValue()+"] - [Alt: "+getAlt()+"] - [Primary: "+isPrimary()+"] - [Onclick: "+getOnclick()+"]");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-2$  //$NON-NLS-6$  //$NON-NLS-5$  //$NON-NLS-3$  //$NON-NLS-7$
		return buffer.toString();
	}
}
