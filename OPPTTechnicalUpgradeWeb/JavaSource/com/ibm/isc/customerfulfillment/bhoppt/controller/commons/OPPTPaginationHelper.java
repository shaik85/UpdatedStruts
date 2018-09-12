/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerListSelectionViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans.CustomerListViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;

/**
 * @author balajiv
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class OPPTPaginationHelper {
    /**
     * itemsPerPage
     */
    public static int itemsPerPage = 30;
    /**
     * paginateViewBean
     * 
     * @param customerListSelectionViewBean
     * @author thirumalai
     */
    public static void paginateViewBean(CustomerListSelectionViewBean customerListSelectionViewBean) {
        try {
			itemsPerPage = (new Integer(OPPTPropertiesReader.getAString("itemsPerPage"))).intValue();  //$NON-NLS-1$
		} catch (Exception e) {
			// We do not handle this exception
		}        
        if(customerListSelectionViewBean.getSearchString() == null) {
            TreeMap customerLists = customerListSelectionViewBean.getCustomerLists();
            int totalItems = customerListSelectionViewBean.getCustomerLists().size();
            if(totalItems  <  itemsPerPage) {
                customerListSelectionViewBean.setCurrentPage(1);
                customerListSelectionViewBean.setTotalNumberOfPages(1);      
                TreeMap customerListArray[] = new TreeMap [1];
                customerListArray[0] = customerLists;
                customerListSelectionViewBean.setCustomerListArray(customerListArray);
            } else {
                int totalNumberOfPages = totalItems/itemsPerPage;
                if(0 < totalItems%itemsPerPage) {
                    totalNumberOfPages++;
                }
                
                TreeMap customerListArray[] = new TreeMap [totalNumberOfPages];
                Set keySet = customerLists.keySet();
                Iterator iter = keySet.iterator();
                int counter = 0;
                int arrayCounter = 0;
                TreeMap arrayMap = new TreeMap();
                while(iter.hasNext()) {
                    String key = (String) iter.next();
                    CustomerListViewBean viewBean = (CustomerListViewBean) customerLists.get(key);
                    arrayMap.put(key,viewBean);
                    counter++;
                    if(counter == itemsPerPage) {
                        customerListArray [arrayCounter] = arrayMap;
                        counter = 0;
                        arrayCounter++;
                        arrayMap = new TreeMap();
                    }      
                }
                if(arrayMap.size() > 0) {
                    customerListArray [arrayCounter] = arrayMap;
                }
                
                customerListSelectionViewBean.setCurrentPage(1);
                customerListSelectionViewBean.setTotalNumberOfPages(totalNumberOfPages);      
                customerListSelectionViewBean.setCustomerListArray(customerListArray);     
                customerListSelectionViewBean.setCustomerLists(customerListArray[0]);
            }
        }
    }
}
