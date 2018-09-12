/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;

import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.FormDetailViewBean;

/**
 * Custom tag that is used for displaying the Modification types
 * 
 * <br /><PRE> 
 * date Oct 14,2006
 * 
 * revision date author reason 
 * 
 * </PRE><br /> 
 * @author Nayanatara L Pai
 */
public class DisplayFormDetailsTag extends OPPTTag {
	
	private TreeMap formDetailsMap = null;
	
	
	/**
     * return the formDetailsMap 
     *
     * @return Returns the formDetailsMap.
     */
	public TreeMap getFormDetailsMap() {
		return formDetailsMap;
	}
	
	/**
     * sets the formDetailsMap
     *
     * @param lFormDetailsMap The formDetailsMap to set.
     */
	public void setFormDetailsMap(TreeMap lFormDetailsMap) {
		formDetailsMap = lFormDetailsMap;
	}
	
	 /**
	 * Overridden method -  
	 * 
	 * <br /><PRE> 
	 * date Oct 14, 2003 
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
		StringBuffer result = new StringBuffer();
		
		if (null != formDetailsMap && 0 < formDetailsMap.size()) {
		    
		    result.append("<table class=\"ibm-data-table\" width=\"700\" cellpadding=\"1\" cellspacing=\"1\" border=\"0\">");  //$NON-NLS-1$
			result.append("<tr style=\"background-color:#cccccc;\" class=\"dark\">");  //$NON-NLS-1$
			result.append("<th width=\"50\" height=\"18\" id=\"formTypeSelector\"><strong class=\"black\">*</strong>Required</th>");  /* NOI18N */
			result.append("<th nowrap=\"nowrap\" width=\"150\" id=\"formNumber\">Form&nbsp;number</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"250\" id=\"longDescription\">Long&nbsp;description</th>");  //$NON-NLS-1$  
			result.append("<th nowrap=\"nowrap\" width=\"150\" id=\"shortDescription\">Short&nbsp;description</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"100\" id=\"language\">Language</th>");  //$NON-NLS-1$
			result.append("</tr>"); //$NON-NLS-1$
			int count = 1;
			
			Iterator formDetailsIterator = formDetailsMap.values().iterator();
			
			while (formDetailsIterator.hasNext()) {
			 
			    
				FormDetailViewBean formDetails = (FormDetailViewBean)formDetailsIterator.next();
			    
			    if (null != formDetails) {
			        String formNumber = formDetails.getFormNumber();
			        
			        if((count % 2) == 1) {
						result.append("<tr class=\"white\">");  //$NON-NLS-1$
					}
					else {
						result.append("<tr class=\"gray\">");  //$NON-NLS-1$
					} 
			        result.append("<td valign=\"bottom\" align=\"center\" headers=\"formTypeSelector\"><input type=\"radio\" name=\"formNumber\" value=\""+getValue(formDetails.getFormNumber(),"")+"\" id=\""+"formNumber"+formNumber+"\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$  /* NOI18N */  /* NOI18N */
			        result.append("<td valign=\"bottom\"  headers=\"formNumber\">"+getValue(formDetails.getFormNumber(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        result.append("<td valign=\"bottom\"  headers=\"longDescription\">"+getValue(formDetails.getFormLongDescription(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        result.append("<td valign=\"bottom\"  headers=\"shortDescription\">"+getValue(formDetails.getFormShortDescription(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        result.append("<td valign=\"bottom\"  headers=\"language\">"+getValue(formDetails.getLanguage(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			      result.append("</tr>");
			      /* NOI18N */
			    }
			    count++;
			    
			}
			result.append("</table>");
}
		JspWriter out = pageContext.getOut();
		try {
			out.print(result.toString());
			out.flush();
		} catch (IOException ioe) {
			throw new JspException("I/O Error : " + ioe.getMessage());  //$NON-NLS-1$
		}
		return Tag.SKIP_BODY;
		
}
    
}
