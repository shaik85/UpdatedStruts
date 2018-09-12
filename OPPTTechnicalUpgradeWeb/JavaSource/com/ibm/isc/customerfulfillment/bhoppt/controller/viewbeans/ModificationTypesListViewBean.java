/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;


import java.util.Iterator;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SalesOrgActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypesCustomDTO;

/**
 * Holds the detail information about an modification type list
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date sep 8, 2006
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravi Yandapalli
 * 
 */

public class ModificationTypesListViewBean extends OPPTViewBean {
	
	private TreeMap modificationTypesMap = null; 
	private TreeMap salesOrgMap = null;
	private String selectedSalesOrg = null;
	
	
	/**
     * default constructor
     */
	
	public ModificationTypesListViewBean(){
	      
	  }
	/**
	 *Constructor of ModificationTypesListViewBean.java
	 *@author Ravi Yandapalli
	 *
	 *Dec 27, 2006   6:16:31 PM
	 * @param modificationTypesCustomDTO
	 */
	
	  public ModificationTypesListViewBean(ModificationTypesCustomDTO modificationTypesCustomDTO){
	      TreeMap staticSalesOrgMap = new TreeMap();
	         staticSalesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
	        
	      if(null != staticSalesOrgMap){
	          setSalesOrgMap(staticSalesOrgMap);
	      }
	      setSelectedSalesOrg(setSalesOrg(modificationTypesCustomDTO.getSalesOrg()));
	      
	      TreeMap modificationTypeMap =modificationTypesCustomDTO.getModificationTypesMap();
	      Iterator modificationTypeIterator = modificationTypeMap.keySet().iterator();
	      TreeMap modificationTypeViewBeanMap = new TreeMap(); 
	      while(modificationTypeIterator.hasNext()){
	           String typeCode =(String)modificationTypeIterator.next();
	           ModificationTypeCustomDTO modificationTypeCustomDTO = (ModificationTypeCustomDTO)modificationTypeMap.get(typeCode);
	           ModificationTypesViewBean modificationTypesViewBean = new ModificationTypesViewBean(modificationTypeCustomDTO);
	           modificationTypeViewBeanMap.put(typeCode,modificationTypesViewBean);
	        }
	      setModificationTypesMap(modificationTypeViewBeanMap);
	      
	      SalesOrgActionForm actionForm = new SalesOrgActionForm();
	      actionForm.setSalesOrganization(modificationTypesCustomDTO.getSalesOrg());
	      setActionForm(actionForm);
	  }

	
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
     *gets the  salesOrgMap
     *
     * @return Returns the salesOrgMap.
     */
    public TreeMap getSalesOrgMap() {
        return salesOrgMap;
    }
    /**
     * sets the salesOrgMap
     * @param lsalesOrgMap The salesOrgMap to set.
     */
    public void setSalesOrgMap(TreeMap lsalesOrgMap) {
        salesOrgMap = lsalesOrgMap;
    }
    
    
    
    /**
     *gets the  selectedSalesOrg
     *
     * @return Returns the selectedSalesOrg.
     */
    public String getSelectedSalesOrg() {
        return selectedSalesOrg;
    }
    /**
     * sets the selectedSalesOrg
     * @param lselectedSalesOrg The selectedSalesOrg to set.
     */
    public void setSelectedSalesOrg(String lselectedSalesOrg) {
        
      selectedSalesOrg = lselectedSalesOrg;
    }
    /**
     * 
     *getSalesOrgDetails
     *
     *@author Ravi Yandapalli
     *
     * Dec 27, 20066:16:50 PM
     * @return
     */
    public TreeMap getSalesOrgDetails(){
    	TreeMap lsalesOrgMap = new TreeMap();
    	TreeMap treeMap = getSalesOrgMap();
    	Iterator iterator = treeMap.keySet().iterator();
    	while(iterator.hasNext()){
    		String key = (String)iterator.next();
    		String value = (String)treeMap.get(key);
    		lsalesOrgMap.put(key,value +"-"+ key);  /* NOI18N */
    	}
    	return lsalesOrgMap;
    }
    /**
     *setSalesOrg
     *@author Ravi Yandapalli
     *Dec 27, 20066:17:01 PM
     * @param lselectedSalesOrg
     * @return
     */
    public String setSalesOrg(String lselectedSalesOrg ){
       String salesOrg = null;
       String value = (String)getSalesOrgMap().get(lselectedSalesOrg);
       salesOrg = value+"-"+lselectedSalesOrg;  /* NOI18N */
        return salesOrg;
        
    }
    /**
     * 
     *getSalesOrgActionForm
     *
     *@author Ravi Yandapalli
     *
     * Dec 27, 20066:17:15 PM
     * @return
     */
   public SalesOrgActionForm getSalesOrgActionForm(){
        SalesOrgActionForm salesOrgActionForm = null;
        if(null != getActionForm() && getActionForm() instanceof SalesOrgActionForm){
            salesOrgActionForm = (SalesOrgActionForm)getActionForm();
        }
        else{
            salesOrgActionForm = new SalesOrgActionForm();
        }
        return salesOrgActionForm;
    }
}
