/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2006, 2008
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;

import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementChangeDetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
/**
 * Custom tag to display all the DisplayChangeLogDetailsTag for Base Agreement 
 * 
 * @author Ravi Yandapalli
 * Date jun 14,2006
 *

 */
public class DisplayChangeLogDetailsTag extends OPPTTag {
    
    private ArrayList changeLogDetailsList = null;
	/**
	 * Overridden method -  
	 * 
	 * <strong>r /><PRE> 
	 * date Nov 13, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><strong>r /> 
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag() 
	 * @return
	 * @throws JspException 
	 *
	 */
    
    public int doStartTag() throws JspException {
		StringBuffer result = new StringBuffer();
		if (null != changeLogDetailsList && 0 < changeLogDetailsList.size()) {
		    
		    result.append("<table class=\"ibm-data-table\" width=\"600\" cellpadding=\"1\" cellspacing=\"1\" border=\"0\">");  //$NON-NLS-1$
		    result.append("<tr style=\"background-color:#cccccc;\" class=\"dark\">");  //$NON-NLS-1$
		    result.append("<th nowrap=\"nowrap\" width=\"100\" id=\"userId\">&nbsp;&nbsp;User&nbsp;ID</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"125\" id=\"dateTime\">Date - Time</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"200\" id=\"fileChangeHasOccured\">Field&nbsp;has&nbsp;occured</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"125\" id=\"oldValue\">&nbsp;&nbsp;Old&nbsp;value</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"50\" id=\"newValue\">New&nbsp;Value</th>");  //$NON-NLS-1$
			result.append("</tr>"); //$NON-NLS-1$
			Iterator changeLogDetailsIterator = changeLogDetailsList.iterator();
			int count = 1;
			while (changeLogDetailsIterator.hasNext()) {
			    BaseAgreementChangeDetailsViewBean viewBean = (BaseAgreementChangeDetailsViewBean)changeLogDetailsIterator.next();
			    if(null!=viewBean) {  /* NOI18N */
			    	ArrayList changeDetailsList = getChangeDetailList(viewBean.getChangedValue());
			    	for(int i=0;i < changeDetailsList.size();i++) {
			          	String changeDetail = (String) changeDetailsList.get(i);
			          	String key = changeDetail.substring(0,changeDetail.indexOf(","));  /* NOI18N */
			           	String oldValue =  changeDetail.substring(changeDetail.indexOf(",")+1, changeDetail.lastIndexOf(","));  /* NOI18N */  /* NOI18N */
			           	String newValue = changeDetail.substring(changeDetail.lastIndexOf(",")+1);  /* NOI18N */
			    	    if((count % 2) == 1) {
							result.append("<tr class=\"white\">");  //$NON-NLS-1$
						}
						else {
							result.append("<tr class=\"gray\">");  //$NON-NLS-1$
						} 
			           	if(i == 0) {
					        result.append("<td valign=\"bottom\"  headers=\"userId\">"+getValue(viewBean.getUserId(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					        result.append("<td valign=\"bottom\"  headers=\"dateTime\">"+getDateTime(viewBean.getChangeOfDate(),viewBean.getChangedTime())+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					        result.append("<td valign=\"bottom\"  headers=\"fileChangeHasOccured\">"+getValue(key, "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					        result.append("<td valign=\"bottom\"  headers=\"oldValue\">"+getValue(oldValue, "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					        result.append("<td valign=\"bottom\"  headers=\"newValue\">"+getValue(newValue, "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					        
			           	} else {
					        result.append("<td valign=\"bottom\"  headers=\"userId\">&nbsp;&nbsp;</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					        result.append("<td valign=\"bottom\"  headers=\"dateTime\">&nbsp;&nbsp;</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					        result.append("<td valign=\"bottom\"  headers=\"fileChangeHasOccured\">"+getValue(key, "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					        result.append("<td valign=\"bottom\"  headers=\"oldValue\">"+getValue(oldValue, "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
					        result.append("<td valign=\"bottom\"  headers=\"newValue\">"+getValue(newValue, "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			           	}
			           	result.append("</tr>");  /* NOI18N */
			    	}
			        
			    }
			    count++;
			}
			result.append("</table>");  /* NOI18N */
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
     *gets the  changeLogDetailsList
     *
     * @return Returns the changeLogDetailsList.
     */
    public ArrayList getChangeLogDetailsList() {
        return changeLogDetailsList;
    }
  
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:37:09 PM
     * @param lChangeLogDetailsList changeLogDetailsList.
     */
    public void setChangeLogDetailsList(ArrayList lChangeLogDetailsList) {
        changeLogDetailsList = lChangeLogDetailsList;
    }
    /**
     * 
     *getChangeDetailList
     *
     *@author Ravi Yandapalli
     *
     * Dec 27, 200611:51:59 AM
     * @param changeDetails
     * @return
     */
    private ArrayList getChangeDetailList(String changeDetails) {
        ArrayList changeDetailsList = new ArrayList(); 
    	StringTokenizer changeDetailsTokenizer = new StringTokenizer(changeDetails,UtilityConstants.CHANGEDETAILS_VARIETOR); 
        while(changeDetailsTokenizer.hasMoreTokens()){
            String changeValue = changeDetailsTokenizer.nextToken();
            changeDetailsList.add(changeValue);
        }
        return changeDetailsList;
    }
    /**
     * 
     *getDateTime
     *
     *@author Ravi Yandapalli
     *
     * Dec 27, 200611:52:03 AM
     * @param date
     * @param time
     * @return
     */
    private String getDateTime(Date date, Time time){
		String dateTime = null;
		dateTime = getDateValue(date, "")+" "+time;  //$NON-NLS-2$  //$NON-NLS-1$
		return dateTime;
	}
    
}
