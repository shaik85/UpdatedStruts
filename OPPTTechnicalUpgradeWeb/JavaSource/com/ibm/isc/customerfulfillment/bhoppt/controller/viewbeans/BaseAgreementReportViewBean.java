/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * BaseAgreement Report ViewBean
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAgreementReportViewBean extends OPPTViewBean {

	  private TreeMap salesOrg = null;
	  
	  private TreeMap status = null;
	
    /**
     *this is the getter method for salesOrg 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:05:07 PM
     *
     * @return TreeMap.
     */
    public TreeMap getSalesOrg() {
        return salesOrg;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:05:07 PM
     * @param lSalesOrg salesOrg.
     */
    public void setSalesOrg(TreeMap lSalesOrg) {
        salesOrg = lSalesOrg;
    }
    /**
     *this is the getter method for status 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:05:07 PM
     *
     * @return TreeMap.
     */
    public TreeMap getStatus() {
        return status;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:05:07 PM
     * @param lStatus status.
     */
    public void setStatus(TreeMap lStatus) {
        status = lStatus;
    }
	/**
	 *getSalesOrgDetails
	 *
	 *@author Ravi Yandapalli
	 *
	 * Dec 27, 20066:05:13 PM
	 * @return
	 */
	public TreeMap getSalesOrgDetails(){
    	TreeMap salesOrgMap = new TreeMap();
    	TreeMap treeMap = getSalesOrg();
    	for(Iterator iterator = treeMap.keySet().iterator();iterator.hasNext();){
    		String key = (String)iterator.next();
    		String value = (String)treeMap.get(key);
    		salesOrgMap.put(key,value +"-"+ key);  /* NOI18N */
       	}
   	return salesOrgMap;
    }
}
