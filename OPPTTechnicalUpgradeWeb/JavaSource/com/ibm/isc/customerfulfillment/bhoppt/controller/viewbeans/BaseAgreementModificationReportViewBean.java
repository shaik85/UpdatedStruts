/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2006, 2008
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;

/**
 * BaseAgreement Modification Report ViewBean
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAgreementModificationReportViewBean extends OPPTViewBean{
  
	private TreeMap salesOrg = null;
	
	private TreeMap status = null;
	
	private TreeMap modTypes = null;
	
	private String defaultSalesOrg = null;
	
	private String selectedSalesOrg = null;
	
	private String selectedStatus = null;
	
	
	
    /**
     *this is the getter method for defaultSalesOrg 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:03:19 PM
     *
     * @return String.
     */
    public String getDefaultSalesOrg() {
        return defaultSalesOrg;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:03:19 PM
     * @param lDefaultSalesOrg defaultSalesOrg.
     */
    public void setDefaultSalesOrg(String lDefaultSalesOrg) {
        defaultSalesOrg = lDefaultSalesOrg;
    }
    /**
     *this is the getter method for modTypes 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:03:19 PM
     *
     * @return TreeMap.
     */
    public TreeMap getModTypes() {
        return modTypes;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:03:19 PM
     * @param lModTypes modTypes.
     */
    public void setModTypes(TreeMap lModTypes) {
        modTypes = lModTypes;
    }
    /**
     *this is the getter method for salesOrg 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:03:19 PM
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
     *Dec 27, 2006   6:03:19 PM
     * @param lSalesOrg salesOrg.
     */
    public void setSalesOrg(TreeMap lSalesOrg) {
        salesOrg = lSalesOrg;
    }
    /**
     *this is the getter method for selectedSalesOrg 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:03:19 PM
     *
     * @return String.
     */
    public String getSelectedSalesOrg() {
        return selectedSalesOrg;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:03:19 PM
     * @param lSelectedSalesOrg selectedSalesOrg.
     */
    public void setSelectedSalesOrg(String lSelectedSalesOrg) {
        selectedSalesOrg = lSelectedSalesOrg;
    }
    /**
     *this is the getter method for selectedStatus 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:03:19 PM
     *
     * @return String.
     */
    public String getSelectedStatus() {
        return selectedStatus;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:03:19 PM
     * @param lSelectedStatus selectedStatus.
     */
    public void setSelectedStatus(String lSelectedStatus) {
        selectedStatus = lSelectedStatus;
    }
    /**
     *this is the getter method for status 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:03:19 PM
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
     *Dec 27, 2006   6:03:19 PM
     * @param lStatus status.
     */
    public void setStatus(TreeMap lStatus) {
        status = lStatus;
    }
	/**
	 * 
	 *getSalesOrgDetails
	 *
	 *@author Ravi Yandapalli
	 *
	 * Dec 27, 20066:03:26 PM
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
	/**
	 *getSelectedFormNumbers
	 *
	 *@author Ravi Yandapalli
	 *Dec 27, 20066:03:31 PM
	 * @param array
	 * @param key
	 * @return
	 */
	public boolean getSelectedFormNumbers(String[] array,String key){
		boolean flag = false;
		for(int j = 0;j < array.length;j++){
		      if(array[j].equals(key)) {
			      	flag = true;
			      	break;
			  }
		}
		return flag;
     }
}
