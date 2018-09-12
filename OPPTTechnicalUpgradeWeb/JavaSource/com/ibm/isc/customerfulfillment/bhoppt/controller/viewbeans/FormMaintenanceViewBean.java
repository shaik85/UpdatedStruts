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
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormMaintenanceCustomDTO;

/**
 * Holds the basic information about a form  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date oct 11, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Nayanatara L Pai
 *
 */
public class FormMaintenanceViewBean extends OPPTViewBean {
	
	private TreeMap formDetailsMap = null;
	
	private TreeMap salesOrgMap = null;
	
	private String selectedSalesOrg = null;
	
	/**
	 * Defsult constructor
	 * 
	 */
	public FormMaintenanceViewBean(){
		
	}
	
	/**
     * Constructor - sets the FormMaintenanceCustomDTO
     *
     * @param formMaintenanceCustomDTO The formMaintenanceCustomDTO to set.
     */
	
	  public FormMaintenanceViewBean(FormMaintenanceCustomDTO formMaintenanceCustomDTO){
	      TreeMap staticSalesOrgMap = new TreeMap();
	         staticSalesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
	      if(null != staticSalesOrgMap){
	          setSalesOrgMap(staticSalesOrgMap);
	      }
	      setSelectedSalesOrg(setSalesOrg(formMaintenanceCustomDTO.getSalesOrg()));
	      
	      TreeMap lformDetailsMap =formMaintenanceCustomDTO.getFormDetailsMap();
	      Iterator formDetailsIterator = lformDetailsMap.keySet().iterator();
	      TreeMap formDetailsViewBeanMap = new TreeMap();
	      while(formDetailsIterator.hasNext()){
	      	String typeCode = (String)formDetailsIterator.next();
	      	FormDetailsCustomDTO formDetailsCustomDTO = (FormDetailsCustomDTO)lformDetailsMap.get(typeCode);
	      	FormDetailViewBean formDetailViewBean = new FormDetailViewBean(formDetailsCustomDTO);
	      	formDetailsViewBeanMap.put(typeCode,formDetailViewBean);
	      }
	      setFormDetailsMap(formDetailsViewBeanMap);
	      	         
	      SalesOrgActionForm actionForm = new SalesOrgActionForm();
	      actionForm.setSalesOrganization(formMaintenanceCustomDTO.getSalesOrg());
	      setActionForm(actionForm);
	  }
	  
	
	
	
    /**
     *this is the getter method for formDetailsMap 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:14:51 PM
     *
     * @return TreeMap.
     */
    public TreeMap getFormDetailsMap() {
        return formDetailsMap;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:14:52 PM
     * @param lFormDetailsMap formDetailsMap.
     */
    public void setFormDetailsMap(TreeMap lFormDetailsMap) {
        formDetailsMap = lFormDetailsMap;
    }
    /**
     *this is the getter method for salesOrgMap 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:14:52 PM
     *
     * @return TreeMap.
     */
    public TreeMap getSalesOrgMap() {
        return salesOrgMap;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:14:52 PM
     * @param lSalesOrgMap salesOrgMap.
     */
    public void setSalesOrgMap(TreeMap lSalesOrgMap) {
        salesOrgMap = lSalesOrgMap;
    }
    /**
     *this is the getter method for selectedSalesOrg 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:14:52 PM
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
     *Dec 27, 2006   6:14:52 PM
     * @param lSelectedSalesOrg selectedSalesOrg.
     */
    public void setSelectedSalesOrg(String lSelectedSalesOrg) {
        selectedSalesOrg = lSelectedSalesOrg;
    }
    /**
     *getSalesOrgDetails
     *
     *@author Ravi Yandapalli
     *
     * Dec 27, 20066:14:57 PM
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
     *
     *@author Ravi Yandapalli
     *
     * Dec 27, 20066:15:19 PM
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
     *getSalesOrgActionForm
     *
     *@author Ravi Yandapalli
     *
     * Dec 27, 20066:15:30 PM
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
