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

import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementModificationStatusConstant;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.DisplayModificationDetailViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;

/**
 * Custom tag to display all the modificationTypes for Base 
 * Agreement creation and AmendBaseAgreement
 * 
 * @author Gavaskar Bhojan
 * Date jun 14,2006
 *

 */
public class DisplayModificationTag extends OPPTTag {
    private TreeMap modTypes = null;
	private TreeMap selectedModTypes=null;
	private String modificationStatus=null;	
	
	
	
    /**
     *this is the getter method for modificationStatus 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:39:15 PM
     *
     * @return String.
     */
    public String getModificationStatus() {
        return modificationStatus;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:39:15 PM
     * @param lModificationStatus modificationStatus.
     */
    public void setModificationStatus(String lModificationStatus) {
        modificationStatus = lModificationStatus;
    }
	/**
	 * 
	 *doStartTag
	 *
	 *@author Ravi Yandapalli
	 *
	 *Dec 27, 2006  11:52:34 AM
	 *
	 *@return
	 *@throws JspException
	 */
	public int doStartTag() throws JspException {
		StringBuffer result = new StringBuffer();
		String key = null;
		String description= null;
		    if(modTypes != null){
			result.append("<table class=\"ibm-data-table\" width=\"600\"  cellpadding=\"1\"  cellspacing=\"1\" border=\"0\">");  //$NON-NLS-1$
			result.append("<tr>");  /* NOI18N */
			result.append("<td style=\"background-color:#cccccc;\" class=\"bar-blue-med\" nowrap=\"nowrap\" width=\"159\" id=\"ModificationTypes\">Modification Terms</td>");  //$NON-NLS-1$
			result.append("<td style=\"background-color:#cccccc;\" nowrap=\"nowrap\" width=\"159\" id=\"typecode\"></td>");  //$NON-NLS-1$
			result.append("</tr>");  /* NOI18N */ 

		   Iterator modTypeKeySetIterator = modTypes.keySet().iterator();
			int count = 1;
			while (modTypeKeySetIterator.hasNext()) {
				
				 key = (String)modTypeKeySetIterator.next();
				 description = (String)modTypes.get(key);
				if (null != description) {
					if((count % 2) == 1) {
						result.append("<tr class=\"white\">");  /* NOI18N */  
					}
					else {
						result.append("<tr class=\"gray\">");  /* NOI18N */  
					}
				}	
				result.append("<td valign=\"bottom\" headers=\"type\">"+description+"</td>");  /* NOI18N */  /* NOI18N */
				result.append("<td>");  /* NOI18N */
				
				if(getSelectedModTypes().containsKey(key)){
					DisplayModificationDetailViewBean viewBean =(DisplayModificationDetailViewBean)getSelectedModTypes().get(key);	
					modificationStatus = (OPPTHelper.trimString(viewBean.getStatus()));	
				}
					else{
					modificationStatus = null;
				}
				if(modificationStatus!= null){
		     		if(BaseAgreementModificationStatusConstant.Active.equals(modificationStatus)&& getSelectedModTypes().containsKey(key) ){
			    		 
				      result.append("<form  action=\"/isc/customerfulfillment/bhoppt/protect/DisplayModificationMultipleAction.wss\">");  /* NOI18N */
				      result.append("<input type=\"hidden\" name=\"modificationTypeCode\" value=\""+key+"\">");  /* NOI18N */  /* NOI18N */
				      result.append("<span class=\"button-gray\"> <input type=\"submit\" name=\"multipleButtonManager.edit\" value=\"Edit\"> </span>&nbsp;");  /* NOI18N */
				      result.append("<span class=\"button-gray\"> <input type=\"submit\" name=\"multipleButtonManager.view\" value=\"View\"> </span>&nbsp;");  /* NOI18N */
				      result.append("<span class=\"button-gray\"> <input type=\"submit\" name=\"multipleButtonManager.inactivate\" value=\"Inactivate\"> </span>");  /* NOI18N */
		              result.append("</form>");  /* NOI18N */
				}	else if(BaseAgreementModificationStatusConstant.Inactive.equals(modificationStatus)&& getSelectedModTypes().containsKey(key)){
			           
					  	result.append("<form  action=\"/isc/customerfulfillment/bhoppt/protect/DisplayModificationMultipleAction.wss\">");  /* NOI18N */
					    result.append("<input type=\"hidden\" name=\"modificationTypeCode\" value=\""+key+"\">");  /* NOI18N */  /* NOI18N */
					    result.append("<span class=\"button-gray\"> <input type=\"submit\" name=\"multipleButtonManager.reactivate\" value=\"Reactivate\"> </span>");  /* NOI18N */
					    result.append("</form>");  /* NOI18N */
					   }
				}else{
				     if(!getSelectedModTypes().containsKey(key)){
			    	  result.append("<form  action=\"/isc/customerfulfillment/bhoppt/protect/DisplayModificationMultipleAction.wss\">");  /* NOI18N */						                                    
				      result.append("<input type=\"hidden\" name=\"modificationTypeCode\" value=\""+key+"\"");  /* NOI18N */  /* NOI18N */
					  result.append("><span class=\"button-gray\"> <input type=\"submit\" id=\"add\" name=\"multipleButtonManager.add\" value=\"Add\"></span>");  /* NOI18N */
		              result.append("</form>");  /* NOI18N */
		             
		}
				} 
				
					    result.append("</td>");  /* NOI18N */
				    result.append("</tr>");  /* NOI18N */  
	          count++;
			}
			result.append("</table>");  /* NOI18N */  
  		}
		    result.append("<table>");  /* NOI18N */
		    result.append("<td>");  /* NOI18N */
		    result.append("<tr>");  /* NOI18N */  
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
     * returns the modTypes
     * 
     * @return Returns the modTypes.
     */
public TreeMap getModTypes() {
    return modTypes;
}
/**
 * sets the modTypes
 * 
 * @param lModTypes
 *            The modTypes to set.
 */
public void setModTypes(TreeMap lModTypes) {
    modTypes = lModTypes;	
}
    /**
     * returns the selectedModTypes
     * 
     * @return Returns the selectedModTypes.
     */
    public TreeMap getSelectedModTypes() {
        return selectedModTypes;
    }
    /**
     * sets the selectedModTypes
     * 
     * @param lSelectedModTypes
     *            The selectedModTypes to set.
     */
    public void setSelectedModTypes(TreeMap lSelectedModTypes) {
        selectedModTypes = lSelectedModTypes;
    }
    
   
}
