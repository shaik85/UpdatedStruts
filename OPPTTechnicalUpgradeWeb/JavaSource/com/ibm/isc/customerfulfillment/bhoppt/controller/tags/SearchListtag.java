/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.tags;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;

import com.ibm.isc.customerfulfillment.bhoppt.controller.tags.*;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.BaseAgreementViewBean;

/**
 * Custom tag that is used for displaying the Search List
 * 
 * <br /><PRE> 
 * date jun 14, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br /> 
 * @author RaviYandapalli
 */
public class SearchListtag extends OPPTTag {
    
    private ArrayList baseAgreementList = null;
    private String agreementId = "0";  /* NOI18N */
        
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
	 *
	 *revision date author reason'
	 *</PRE><br /> 
	 *4 new fields added
	 *author
	 * tapan malhotra
	 */
    
    public int doStartTag() throws JspException {
		StringBuffer result = new StringBuffer();
		
		if (null != baseAgreementList && 0 < baseAgreementList.size()) {
		    //changes by tapan malhotra-starts
		    result.append("<table class=\"ibm-data-table\" width=\"600\" cellpadding=\"1\" cellspacing=\"1\" summary=\"Search Result\" border=\"0\">");  //$NON-NLS-1$
			result.append("<tr style=\"background-color:#cccccc;\" class=\"dark\">");  //$NON-NLS-1$
			result.append("<th width=\"30\" height=\"18\" id=\"baseAreementSelector\"><strong class=\"black\">*</strong>Required</th>");  /* NOI18N */
			result.append("<th nowrap=\"nowrap\" width=\"60\" id=\"customerNumber\">SAP&nbsp;customer number/<br>Customer&nbsp;name</br></th>");  //$NON-NLS-1$
			//result.append("<th nowrap=\"nowrap\" width=\"50\" id=\"customerLegacyNumber\"> Legacy customer number</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"60\" id=\"formNumber\">Form&nbsp;number/<br>Image&nbsp;reference number</br></th>");  //$NON-NLS-1$  
			result.append("<th nowrap=\"nowrap\" width=\"50\" id=\"agreementNumber\">Agreement number</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"60\" id=\"enterpriseNumber\">Enterprise number</th>" );  /* NOI18N */
					//"/INAC</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"50\" id=\"agreementStatus\">Status</th>");  //$NON-NLS-1$
			result.append("</tr>"); //$NON-NLS-1$
			Iterator baseAgreementIterator = baseAgreementList.iterator();
			int count = 1;
			while (baseAgreementIterator.hasNext()) {
			    BaseAgreementViewBean baseagreement = (BaseAgreementViewBean)baseAgreementIterator.next();   
			    if (null != baseagreement) {
			        int lagreementId = baseagreement.getAgreementId();
			        
			        if((count % 2) == 1) {
						result.append("<tr class=\"white\">");  //$NON-NLS-1$
					}
					else {
						result.append("<tr class=\"gray\">");  //$NON-NLS-1$
					} 
			        
			        if(getAgreementId().equals(""+baseagreement.getAgreementId())) {  /* NOI18N */
			        	result.append("<td valign=\"bottom\" align=\"center\" headers=\"baseAreementSelector\"><input type=\"radio\" name=\"agreementId\" value=\""+baseagreement.getAgreementId()+"\" checked=\"checked\" id=\""+"agreementId"+lagreementId+"\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$
			        }else {
			        	result.append("<td valign=\"bottom\" align=\"center\" headers=\"baseAreementSelector\"><input type=\"radio\" name=\"agreementId\" value=\""+baseagreement.getAgreementId()+"\" id=\""+"agreementId"+lagreementId+"\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$
			        }
			        result.append("<td valign=\"bottom\"  headers=\"customerNumber\">"+getValue(baseagreement.getCustomerNumber(), "")+"<br>"+getValue(baseagreement.getCustomerName(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$  /* NOI18N */  /* NOI18N */  /* NOI18N */  /* NOI18N */
			        
			        //result.append("<td valign=\"bottom\"  headers=\"legacyCustomerNumber\">"+getValue(baseagreement.getCustomerLegacyNumber(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        result.append("<td valign=\"bottom\"  headers=\"formNumber\">"+getValue(baseagreement.getFormNumber(), "") +"<br>"+getValue(baseagreement.getImageReferenceNumber(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$  /* NOI18N */  /* NOI18N */  /* NOI18N */  /* NOI18N */
			       
			        result.append("<td valign=\"bottom\"  headers=\"agreementNumber\">"+getValue(baseagreement.getAgreementNumber(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        result.append("<td valign=\"bottom\"  headers=\"enterpriseNumber\">"+getValue(baseagreement.getEnterpriseNumber(), "")+"<br>"+getValue(baseagreement.getINAC(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$  /* NOI18N */  /* NOI18N */  /* NOI18N */  /* NOI18N */
			        //
			        //changes by tapan malhotra-ends
			        result.append("<td valign=\"bottom\"  headers=\"agreementStatus\">"+getValue(baseagreement.getAgreementStatus(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        result.append("</tr>");  /* NOI18N */
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
     *this is the getter method for baseAgreementList 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:44:11 PM
     *
     * @return ArrayList.
     */
    public ArrayList getBaseAgreementList() {
        return baseAgreementList;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:44:12 PM
     * @param lBaseAgreementList baseAgreementList.
     */
    public void setBaseAgreementList(ArrayList lBaseAgreementList) {
        baseAgreementList = lBaseAgreementList;
    }

    /**
     *this is the getter method for agreementId 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:46:22 PM
     *
     * @return String.
     */
    public String getAgreementId() {
        return agreementId;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:46:22 PM
     * @param lAgreementId agreementId.
     */
    public void setAgreementId(String lAgreementId) {
        agreementId = lAgreementId;
    }
}
