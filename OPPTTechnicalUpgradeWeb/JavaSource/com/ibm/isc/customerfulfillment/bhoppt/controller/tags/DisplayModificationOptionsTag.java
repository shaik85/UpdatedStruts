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

import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.ModificationOptionsViewBean;

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
public class DisplayModificationOptionsTag extends OPPTTag {

    private TreeMap modificationOptionsMap = null;
    
    private String option = null;
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
		ModificationOptionsViewBean modificationOptions = null;
		if (null != modificationOptionsMap && 0 < modificationOptionsMap.size()) {
		    
		    result.append("<table class=\"ibm-data-table\" width=\"600\" cellpadding=\"1\" cellspacing=\"1\" border=\"0\">");  //$NON-NLS-1$
			result.append("<tr style=\"background-color:#cccccc;\" class=\"dark\">");  //$NON-NLS-1$
			result.append("<th width=\"50\" height=\"18\" id=\"modificationTypeSelector\"><strong class=\"black\">*</strong>Required</th>");  /* NOI18N */
			result.append("<th nowrap=\"nowrap\" width=\"125\" id=\"modificationOptions\">Modification&nbsp;options</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"125\" id=\"modificationOptionsDescription\">Modification&nbsp;options&nbsp;description</th>");  //$NON-NLS-1$  
			result.append("</tr>"); //$NON-NLS-1$
			int count = 1;
			
			Iterator modificationOptionsIterator = modificationOptionsMap.values().iterator();
			
			while (modificationOptionsIterator.hasNext()) {
			 
			    modificationOptions = (ModificationOptionsViewBean)modificationOptionsIterator.next();
			    
			    if (null != modificationOptions) {
			        String modificationOption = modificationOptions.getModificationOption();
			        
			        if((count % 2) == 1) {
						result.append("<tr class=\"white\">");  //$NON-NLS-1$
					}
					else {
						result.append("<tr class=\"gray\">");  //$NON-NLS-1$
					}
			        if(getOption()!=null && getOption().equals(modificationOptions)) {
			        	result.append("<td valign=\"bottom\" align=\"center\" headers=\"modificationOptionSelector\"><input type=\"radio\" name=\"modificationOption\" value=\""+getValue(modificationOptions.getModificationOption(),"")+"\" checked=\"checked\" id=\""+"modificationOption"+modificationOption+"\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$  /* NOI18N */  /* NOI18N */
			        }else {
			        	result.append("<td valign=\"bottom\" align=\"center\" headers=\"modificationOptionSelector\"><input type=\"radio\" name=\"modificationOption\" value=\""+getValue(modificationOptions.getModificationOption(),"")+"\" id=\""+"modificationOption"+modificationOption+"\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$  /* NOI18N */  /* NOI18N */
			        }
			        result.append("<td valign=\"bottom\"  headers=\"modificationOptions\">"+getValue(modificationOptions.getModificationOption(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        result.append("<td valign=\"bottom\"  headers=\"modificationOptionsDescription\">"+getValue(modificationOptions.getModificationDescription(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			      result.append("</tr>");  /* NOI18N */
			    }
			    count++;
			    
			}

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
    

    /**
     * return the modificationOptionsMap 
     *
     * @return Returns the modificationOptionsMap.
     */
    public TreeMap getModificationOptionsMap() {
        return modificationOptionsMap;
    }
    /**
     * sets the modificationOptionsMap
     *
     * @param lmodificationOptionsMap The modificationOptionsMap to set.
     */
    public void setModificationOptionsMap(TreeMap lmodificationOptionsMap) {
        modificationOptionsMap = lmodificationOptionsMap;
    }
    
    /**
     *gets the  option
     *
     * @return Returns the option.
     */
    public String getOption() {
        return option;
    }
    /**
     * sets the option
     * @param loption The option to set.
     */
    public void setOption(String loption) {
        option = loption;
    }
}
