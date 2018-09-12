/*
 * Created on Oct 3, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/*
* IBM Confidential
*
* ©  Copyright IBM Corp. 2004, 2005  All Rights Reserved.

* The source code for this program is not published or otherwise divested of
* its trade secrets, irrespective of what has been deposited with the U.S. Copyright office.
*/
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.util.TreeMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;


/**
 * Custom tag to display all the DisplayChangeLogDetails for Base Agreement 
 * 
 * @author Ravi Yandapalli
 * Date jun 14,2006
 *

 */
public class DisplayChangeLogDetails extends OPPTTag {
    
    private TreeMap changeLogDetailsMap = null;
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
		
		
		
		return Tag.SKIP_BODY;
    
    }
	

    /**
     *gets the  changeLogDetailsMap
     *
     * @return Returns the changeLogDetailsMap.
     */
    public TreeMap getChangeLogDetailsMap() {
        return changeLogDetailsMap;
    }
   
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:36:11 PM
     * @param lChangeLogDetailsMap changeLogDetailsMap.
     */
    public void setChangeLogDetailsMap(TreeMap lChangeLogDetailsMap) {
        changeLogDetailsMap = lChangeLogDetailsMap;
    }
}
