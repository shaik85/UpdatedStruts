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

import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationTypesViewBean;

/**
 * Custom tag that is used for displaying the Modification types
 * 
 * <br /><PRE> 
 * date Sep 08,2006
 * 
 * revision date author reason 
 * 
 * </PRE><br /> 
 * @author RaviYandapalli
 */
public class DisplayModificationTypesTag extends OPPTTag {
    
    private TreeMap modificationTypesMap = null;
    private String modificationType = null; 
    
    
    
    /**
     * return the modificationTypesMap 
     *
     * @return Returns the modificationTypesMap.
     */
    public TreeMap getModificationTypesMap() {
        return modificationTypesMap;
    }
    /**
     * sets the modificationTypesMap
     *
     * @param lmodificationTypesMap The modificationTypesMap to set.
     */
    public void setModificationTypesMap(TreeMap lmodificationTypesMap) {
       modificationTypesMap = lmodificationTypesMap;
    }
    
    

    /**
     *this is the getter method for modificationType 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:41:58 PM
     *
     * @return String.
     */
    public String getModificationType() {
        return modificationType;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:41:58 PM
     * @param lModificationType modificationType.
     */
    public void setModificationType(String lModificationType) {
        modificationType = lModificationType;
    }
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
		StringBuffer result = new StringBuffer();
		
		if (null != modificationTypesMap && 0 < modificationTypesMap.size()) {
		    
		    result.append("<table class=\"ibm-data-table\" width=\"600\" cellpadding=\"1\" cellspacing=\"1\" border=\"0\">");  //$NON-NLS-1$
			result.append("<tr style=\"background-color:#cccccc;\" class=\"dark\">");  //$NON-NLS-1$
			result.append("<th width=\"100\" height=\"18\" id=\"modificationTypeSelector\"><strong class=\"black\">*</strong>Required</th>");  /* NOI18N */
			result.append("<th nowrap=\"nowrap\" width=\"150\" id=\"modificationTypeCode\">Modification&nbsp;type&nbsp;code</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"350\" id=\"modificationDescription\">Modification&nbsp;description</th>");  //$NON-NLS-1$  
			result.append("</tr>"); //$NON-NLS-1$
			int count = 1;
			
			Iterator modificationTypesIterator = modificationTypesMap.values().iterator();
			
			while (modificationTypesIterator.hasNext()) {
			 
			    ModificationTypesViewBean modificationTypes = (ModificationTypesViewBean)modificationTypesIterator.next();
			    
			    if (null != modificationTypes) {
			        String typeCode = modificationTypes.getTypeCode();
			        
			        if((count % 2) == 1) {
						result.append("<tr class=\"white\">");  //$NON-NLS-1$
					}
					else {
						result.append("<tr class=\"gray\">");  //$NON-NLS-1$
					} 
			        if(getModificationType()!=null && getModificationType().equals(typeCode)) {
			        	result.append("<td valign=\"bottom\" align=\"center\" headers=\"modificationTypeSelector\"><input type=\"radio\" name=\"modificationTypeCode\" value=\""+getValue(modificationTypes.getTypeCode(),"")+"\" checked=\"checked\" id=\""+"typecode"+typeCode+"\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$  /* NOI18N */  /* NOI18N */
			        }else {
			        	result.append("<td valign=\"bottom\" align=\"center\" headers=\"modificationTypeSelector\"><input type=\"radio\" name=\"modificationTypeCode\" value=\""+getValue(modificationTypes.getTypeCode(),"")+"\" id=\""+"typecode"+typeCode+"\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$  /* NOI18N */  /* NOI18N */
			        }
			        result.append("<td valign=\"bottom\"  headers=\"modificationTypeCode\">"+getValue(modificationTypes.getTypeCode(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        result.append("<td valign=\"bottom\"  headers=\"modificationDescription\">"+getValue(modificationTypes.getDescription(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			      result.append("</tr>");  /* NOI18N */
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