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

import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CCMSCustomerDetailsViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;

/**
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CCMSDisplayCustomerDetailstag extends OPPTTag {

    private ArrayList customerList = null;
    private String sapCustomerNumber = null;

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
       
        if (null != customerList && 0 < customerList.size()) {
        	if(customerList.size() > 2) {
        	result.append("<div style=\"border:1px  solid; width:600px; height:199px; overflow:auto;\">");  //$NON-NLS-1$
        	} else {
        	  result.append("<div style=\"border:1px  solid; width:600px; height:").append(customerList.size()*110).append("px; overflow:auto;\">");  //$NON-NLS-1$
            }	
        	result.append("<table width=\"600\" nowrap=\"nowrap\" cellpadding=\"1\" cellspacing=\"1\" border=\"0\" id=\"CCMSCustomerList\">");  //$NON-NLS-1$
            result.append("<thead><tr style=\"background-color:#cccccc;\" class=\"dark\">");  //$NON-NLS-1$
			result.append("<th width=\"70\" height=\"25\" id=\"customerSelector\"><strong class=\"black\">*</strong>Required</th>");
			result.append("<th nowrap=\"nowrap\" width=\"80\" height=\"25\" id=\"sapCustomerNumber\" onclick=\"javascript:sortTable('CCMSCustomerList', 1, -1, 'n', 'CustomerNumber')\" >SAP&nbsp;customer number<img id=\"customerNumber\" name=\"customerNumber\" height=\"6\" width=\"19\" alt=\"Sort the column\" src=\"//w3.ibm.com/ui/v8/images/icon-link-sort-u-dark.gif\"/></th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"130\" id=\"CCMScustomerName\" onclick=\"javascript:sortTable('CCMSCustomerList', 2, -1, 's', 'customerName')\">Customer&nbsp;name<img id=\"customerName\" name=\"customerName\" height=\"6\" width=\"19\" alt=\"Sort the column\" src=\"//w3.ibm.com/ui/v8/images/icon-link-sort-u-dark.gif\"/></th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"80\" height=\"25\" id=\"cMRNumber\">CMR number</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"80\" height=\"25\" id=\"enterPriseNumber\">EnterPrise number</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"60\" height=\"25\" id=\"iNAC\">INAC</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"60\" height=\"25\" id=\"country\">Country</th>" );//"/INAC</th>");  //$NON-NLS-1$
			result.append("<th nowrap=\"nowrap\" width=\"120\" height=\"25\" id=\"city\">City/Street</th>");  //$NON-NLS-1$
			result.append("</tr></thead><tbody>"); //$NON-NLS-1$

			Iterator customerIterator = customerList.iterator();
			int count = 1;
			while (customerIterator.hasNext()) {
			    String countryName=null;
			    CCMSCustomerDetailsViewBean viewBean = (CCMSCustomerDetailsViewBean)customerIterator.next();
			    if(viewBean != null){
			        String sapCustomerNumber= count+"#"+((viewBean.getSapCustomerNumber()!=null && viewBean.getSapCustomerNumber().length()!=0) ?viewBean.getSapCustomerNumber():" ");
			        sapCustomerNumber=sapCustomerNumber+"#"+((viewBean.getEnterPriseNumber()!=null && viewBean.getEnterPriseNumber().length()!=0) ?viewBean.getEnterPriseNumber():" ");
			        sapCustomerNumber=sapCustomerNumber+"#"+((viewBean.getLegalName()!=null && viewBean.getLegalName().length()!=0) ?viewBean.getLegalName():" ");
			        sapCustomerNumber=sapCustomerNumber+"#"+(viewBean.getCountry()!=null ?viewBean.getCountry():" ");
			        if((count % 2) == 1) {
						result.append("<tr class=\"white\">");  //$NON-NLS-1$
					}
					else {
						result.append("<tr class=\"gray\">");  //$NON-NLS-1$
					}
			        if(getSapCustomerNumber()!= null && getSapCustomerNumber().equals(""+viewBean.getSapCustomerNumber())) {
			            result.append("<td valign=\"bottom\" align=\"center\" headers=\"customerSelector\"><input type=\"radio\" name=\"sapCustomerNumber\" value=\""+sapCustomerNumber+"\" checked=\"checked\" id=\""+"sapCustomerNumber"+sapCustomerNumber+"\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$
			        
			        }else {
			        	result.append("<td valign=\"bottom\" align=\"center\" headers=\"customerSelector\"><input type=\"radio\" name=\"sapCustomerNumber\" value=\""+sapCustomerNumber+"\" id=\""+"sapCustomerNumber"+sapCustomerNumber+"\" /></td>");  //$NON-NLS-1$  //$NON-NLS-4$  //$NON-NLS-3$  //$NON-NLS-2$
			       }
			  	
			        if(viewBean.getCustomerAccountGroup()!= null && viewBean.getCustomerAccountGroup().equals("ZS01")){
			        result.append("<td valign=\"bottom\"  class=\"blue-dark\" headers=\"sapCustomerNumber\"><strong>"+getValue(viewBean.getSapCustomerNumber(), "")+"</strong></td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        }
			        else{
			            result.append("<td valign=\"bottom\"   headers=\"sapCustomerNumber\">"+getValue(viewBean.getSapCustomerNumber(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        }
			        if(viewBean.getBusinessName()!=null &&viewBean.getBusinessName().length()!=0 && viewBean.getLegalName()!=null && viewBean.getLegalName().length()!=0 ){
			        result.append("<td valign=\"bottom\"  headers=\"CCMScustomerName\">"+getValue(viewBean.getBusinessName(), "")+" / "+getValue(viewBean.getLegalName(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        }else{
			        	if(viewBean.getBusinessName()!=null && viewBean.getBusinessName().length()!=0 ){
			        		result.append("<td valign=\"bottom\"  headers=\"customerName\">"+getValue(viewBean.getBusinessName(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        	}else{
			        		if(viewBean.getLegalName()!=null && viewBean.getLegalName().length()!=0 ){
				        		result.append("<td valign=\"bottom\"  headers=\"customerName\">"+getValue(viewBean.getLegalName(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
				        	}
			        	}
			        	
			        }
			        
			        result.append("<td valign=\"bottom\" headers=\"cMRNumber\">"+getValue(viewBean.getCMRNumber(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        result.append("<td valign=\"bottom\" headers=\"enterPriseNumber\">"+getValue(viewBean.getEnterPriseNumber(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        result.append("<td valign=\"bottom\" headers=\"iNAC\">"+getValue(viewBean.getINAC(), "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        if(OPPTStaticDataHolder.countryCodeMap.containsKey(viewBean.getCountry())){
			            countryName = (String)OPPTStaticDataHolder.countryCodeMap.get(viewBean.getCountry());
			           }else{
			               countryName =viewBean.getCountry();
			           }
			        
			        result.append("<td valign=\"bottom\" headers=\"country\">"+getValue(countryName, "")+"</td>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$
			        result.append("<td valign=\"bottom\" headers=\"city\">"+getValue(viewBean.getCity(), "")+"<br>"+getValue(viewBean.getStreet(), "")+"</td></tr>");  //$NON-NLS-2$  //$NON-NLS-3$  //$NON-NLS-1$

			    }
			    count++;
			}
			result.append("</tbody></table>");
			result.append("</div>");
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
     *gets the  customerList
     *
     * @return Returns the customerList.
     */
    public ArrayList getCustomerList() {
        return customerList;
    }
    /**
     * sets the customerList
     * @param customerList The customerList to set.
     */
    public void setCustomerList(ArrayList customerList) {
        this.customerList = customerList;
    }
    /**
     *gets the  sapCustomerNumber
     *
     * @return Returns the sapCustomerNumber.
     */
    public String getSapCustomerNumber() {
        return sapCustomerNumber;
    }
    /**
     * sets the sapCustomerNumber
     * @param sapCustomerNumber The sapCustomerNumber to set.
     */
    public void setSapCustomerNumber(String sapCustomerNumber) {
        this.sapCustomerNumber = sapCustomerNumber;
    }
}
