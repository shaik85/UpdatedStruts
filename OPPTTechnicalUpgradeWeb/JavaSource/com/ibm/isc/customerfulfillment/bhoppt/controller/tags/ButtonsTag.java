/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.OPPTButton;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;

/**
 * Given collection of buttons, it helps in displaying buttons based on whether a particular
 * buttons can be displayed or not.
 * 
 * <br /><strong>Known Bugs</strong><br /> 
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
public class ButtonsTag extends OPPTTag {
	/** Automatically generated javadoc for: TABLEWIDTH */
    private static final int TABLEWIDTH = 600;
    private List buttons = null;

	private List buttonFlags = null;
	private int cellCount = 4;
	private int tableWidth = TABLEWIDTH;
	private String buttonPath = OPPTPropertiesReader.getOPPTImagePath() + "buttons/";  //$NON-NLS-1$

	/**
	 * Overridden method - All the processing that is required to display the buttons should 
	 * be done at the start of the tag. So override the doStartTag to have logic for displaying 
	 * the buttons. 
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
		return EVAL_BODY_INCLUDE;
	}
	
	/**
	 * doEndTag
	 * 
     * @see javax.servlet.jsp.tagext.Tag#doEndTag()
     * @author thirumalai
     */
    public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			if(null != getButtons()){
				int cellWidth = tableWidth / cellCount;
				
				StringBuffer content = new StringBuffer();
				
				//DQA content.append("<table role=\"presentation\" align=\"left\" summary=\"This table contains a set of buttons to performthe activities on this form\">");  //$NON-NLS-1$
				content.append("<table role=\"presentation\" align=\"left\" >");  //$NON-NLS-1$
				for(int i=0, size=getButtons().size(); i<size;){
					int columnCount = 0;
					content.append("<tr>");  //$NON-NLS-1$

					while(4 > columnCount && i<size){
						OPPTButton button = (OPPTButton)buttons.get(i);
						i = i+1;
						if(canButtonBeDisplayed(button.getId())){
							columnCount = columnCount + 1;
							content.append(createButton(button, cellWidth));
						}
					}
					content.append("</tr>");  //$NON-NLS-1$
					content.append("<tr>");  //$NON-NLS-1$
					content.append("<td colspan=\""+cellCount+"\"><br /></td>");  //$NON-NLS-1$  //$NON-NLS-2$
					content.append("</tr>");  //$NON-NLS-1$
						
				}
				content.append("</table>");  //$NON-NLS-1$
				out.print(content);
			}
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
	 * createButton 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 18, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param button
	 * @param buttonWidth
	 * @return 
	 */	
	private String createButton(OPPTButton button, int buttonWidth) {
		StringBuffer buttonContent = new StringBuffer();
		if(null != button){
			buttonContent.append("<td width=\"" + buttonWidth + "\">");  //$NON-NLS-1$  //$NON-NLS-2$

			if(button.isPrimary()){
				buttonContent.append("<span class=\"button-blue\">");  //$NON-NLS-1$
			}
			else{
				buttonContent.append("<span class=\"button-gray\">");  //$NON-NLS-1$
			}
			//buttonContent.append("<label for=\""+button.getId()+"\">");
			buttonContent.append("<input type=\"submit\"");  //$NON-NLS-1$
			if(button.isPrimary())
			{
				buttonContent.append("class=\"ibm-btn-arrow-pri \"");
				//buffer.append("ibm-button-link-alternate");
			}
			else
			{
				buttonContent.append("class=\"ibm-btn-arrow-sec\"");
				//buffer.append("ibm-button-link-alternate");
			}
			buttonContent.append(" id=\""+button.getId()+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
			buttonContent.append(" name=\""+button.getName()+"\"");  //$NON-NLS-2$  //$NON-NLS-1$
			buttonContent.append(" value=\""+button.getValue()+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
			buttonContent.append(" alt=\""+button.getAlt()+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
			if(button.getName().equals("multipleButtonManager.fetchPlannedInventory")) {
				buttonContent.append(" style=\"width:20em;\""); 
			}	
			else { 	
				buttonContent.append(" style=\"width:13em;\"");  //$NON-NLS-1$
			}
			if(null != button.getOnclick()){
				buttonContent.append(" onclick=\""+button.getOnclick()+"\"");  //$NON-NLS-1$  //$NON-NLS-2$
			}
			buttonContent.append("/>");  //$NON-NLS-1$
			//buttonContent.append("</label>");  //$NON-NLS-1$  //$NON-NLS-2$
			buttonContent.append("</span>");  //$NON-NLS-1$
			buttonContent.append("</td>");  //$NON-NLS-1$
		}

		return buttonContent.toString();
	}

	/**
	 * canButtonBeDisplayed 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 18, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param id
	 * @return 
	 */	
	private boolean canButtonBeDisplayed(String id) {
		boolean displayButton = false;
		if(null != buttonFlags) {
			if (null != id && !buttonFlags.contains(id)) {
				displayButton = true;
			}
		}
		else{
			displayButton = true;
		}
		return displayButton;
	}

	/**
	 * addButton 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 18, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param button
	 */	
	public void addButton(OPPTButton button){
		if(null != button){
			if(null == buttons){
				buttons = new ArrayList();
			}
			buttons.add(button);
		}
	}


	/**
	 * Returnc button flag collcetion. If a button is present in this collection, 
	 * the button need to be hidden. 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getButtonFlags() {
		return buttonFlags;
	}

	/**
	 * Returns the button images path  
	 * 
	 * <br><strong>Known Bugs</strong><br> 
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
	public String getButtonPath() {
		return buttonPath;
	}

	/**
	 * Retuns available buttons collection 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getButtons() {
		return buttons;
	}

	/**
	 * Returns total number of buttons need to be displayed in a row 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getCellCount() {
		return cellCount;
	}

	/**
	 * Returns table width value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getTableWidth() {
		return tableWidth;
	}

	/**
	 * Sets button flags colelction 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newButtonFlags List 
	 */
	public void setButtonFlags(List newButtonFlags) {
		buttonFlags = newButtonFlags;
	}

	/**
	 * Sets button path value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newButtonPath String 
	 */
	public void setButtonPath(String newButtonPath) {
		buttonPath = newButtonPath;
	}

	/**
	 * Sets buttons collection 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newButtons List 
	 */
	public void setButtons(List newButtons) {
		buttons = newButtons;
	}

	/**
	 * Sets cell count value which is the number of cells for an row 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCellCount int 
	 */
	public void setCellCount(int newCellCount) {
		cellCount = newCellCount;
	}

	/**
	 * Sets table width value 
	 * 
	 * <br><strong>Known Bugs</strong><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newTableWidth int
	 */
	public void setTableWidth(int newTableWidth) {
		tableWidth = newTableWidth;
	}
}