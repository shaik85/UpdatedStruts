/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;

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
public class DisplayButtonTag extends OPPTTag
{
	private String name = null;
	private String value = null;
	private String alt = null;
	private String id = null;
	private String onclick = null;
	private boolean primary = false;
	private ArrayList buttonFlags = null;
	//private String buttonPath = OPPTPropertiesReader.getOPPTImagePath()+"buttons/";
	private String buttonType = "submit"; //$NON-NLS-1$
	
	/**
	 * Overridden method - All the processing that is required to display the messages should 
	 * be done at the start of the tag. So override the doStartTag to have logic for displaying 
	 * the confirmation messages. 
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
			if(canButtonBeDisplayed())
			{
				if(null == getName()){
					setName(getId());
				}
				
				StringBuffer buffer = new StringBuffer();
				if(isPrimary()){
					buffer.append("<span class=\"button-blue\">");
					
					
					//$NON-NLS-1$
				}
				else{
					buffer.append("<span class=\"button-gray\">"); //$NON-NLS-1$
				}
				//buffer.append("<label >");
				buffer.append("<input type=\""+getButtonType()+"\""); //$NON-NLS-1$  //$NON-NLS-2$
				if(isPrimary())
				{
					buffer.append("class=\"ibm-btn-arrow-pri \"");
					//buffer.append("ibm-button-link-alternate");
				}
				else
				{
					buffer.append("class=\"ibm-btn-arrow-sec\"");
					//buffer.append("ibm-button-link-alternate");
				}	
				buffer.append(" id=\""+getId()+"\""); //$NON-NLS-1$  //$NON-NLS-2$
				buffer.append(" name=\""+getName()+"\""); //$NON-NLS-1$  //$NON-NLS-2$
				buffer.append(" value=\""+getValue()+"\"");	 //$NON-NLS-1$  //$NON-NLS-2$
				buffer.append(" style=\"width:13em;\""); //$NON-NLS-1$
				buffer.append(" alt=\""+getAlt()+"\""); //$NON-NLS-1$  //$NON-NLS-2$
				if(null != getOnclick()){
					buffer.append(" onclick=\""+getOnclick()+"\""); //$NON-NLS-1$  //$NON-NLS-2$
				}
				buffer.append(" />"); //$NON-NLS-1$
				//buffer.append("</label>"); //$NON-NLS-1$  //$NON-NLS-2$
				buffer.append("</span>"); //$NON-NLS-1$
				//buffer.append("&nbsp;&nbsp;&nbsp;");
				
				out.println(buffer.toString());
			}
			out.flush();
		} 
		catch (IOException ioe){
			// Intentionally left blank
		}
		return Tag.SKIP_BODY;
	}
	
	/**
	 * Returns button flags collection  
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
	 * @return ArrayList
	 */
	public ArrayList getButtonFlags() {
		return buttonFlags;
	}

	/**
	 * Sets button flags collection 
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
	 * @param newButtonFlags ArrayList 
	 */
	public void setButtonFlags(ArrayList newButtonFlags) {
		buttonFlags = newButtonFlags;
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
	 * Returns true if the button is an primary button 
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
	 * @return boolean
	 */
	public boolean isPrimary() {
		return primary;
	}

	/**
	 * Sets primary property value 
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
	 * Returns butons onclick property value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getOnclick() {
		return onclick;
	}

	/**
	 * Sets buttons onclick property value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 13, 2004 
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
	
	private boolean canButtonBeDisplayed(){
		boolean displayButton = false;
		if(null != getButtonFlags())
		{
			if(null != getId())
			{
				if(!getButtonFlags().contains(getId()))
				{
					displayButton = true;
				}
			}
		}
		else{
			displayButton = true;
		}
		return displayButton;
	}
	
	/**
	 * Returns the type of the button value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getButtonType() {
		return buttonType;
	}

	/**
	 * Sets button type value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newButtonType String 
	 */
	public void setButtonType(String newButtonType) {
		buttonType = newButtonType;
	}
}