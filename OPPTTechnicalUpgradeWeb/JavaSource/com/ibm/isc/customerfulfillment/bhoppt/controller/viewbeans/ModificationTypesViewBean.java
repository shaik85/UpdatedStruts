/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.TreeMap;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ChangeModificationTypeActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationOptionCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO;

/**
 * Holds the detail information about an modification types  
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
public class ModificationTypesViewBean extends OPPTViewBean {
	
	private String typeCode = null;

	private String description = null;

	private TreeMap modificationOptionsMap = null;
	
	private String selectedSalesOrg = null;
     /**
      * Default Constructor
      * 
      */
  public ModificationTypesViewBean(){
      
  }
	
  /**
   *Constructor of ModificationTypesViewBean
   *@author Ravi Yandapalli
   *
   *Dec 27, 2006   6:17:33 PM
   * @param modificationTypesCustomDTO
   */
   public ModificationTypesViewBean(ModificationTypeCustomDTO modificationTypesCustomDTO){
      
       setDescription(modificationTypesCustomDTO.getDescription());
       setTypeCode(modificationTypesCustomDTO.getTypeCode());
       setSelectedSalesOrg(modificationTypesCustomDTO.getSelectedSalesOrg());
       if(modificationTypesCustomDTO.getModificationTypeMap()!= null && modificationTypesCustomDTO.getModificationTypeMap().size()!=0){
       TreeMap lmodificationOptionsMap = modificationTypesCustomDTO.getModificationTypeMap();
       
       Iterator modificationOptionsMapIterator =lmodificationOptionsMap.keySet().iterator();
       TreeMap modificationTypeOptionsViewBeanMap = new TreeMap();
       TreeMap modificationOptionsViewBeanMap = new TreeMap();
            while(modificationOptionsMapIterator.hasNext()){
                String key = (String)modificationOptionsMapIterator.next();
                
                TreeMap modificationTypeOptionsMap =(TreeMap)lmodificationOptionsMap.get(key);
                Iterator modificationTypeOptionsIterator =modificationTypeOptionsMap.keySet().iterator();
                       while(modificationTypeOptionsIterator.hasNext()){
                      
                               String modificationOption = (String)modificationTypeOptionsIterator.next();
                               ModificationOptionCustomDTO modificationOptionCustomDTO = (ModificationOptionCustomDTO)modificationTypeOptionsMap.get(modificationOption); 
                               ModificationOptionsViewBean modificationOptionsViewBean = new ModificationOptionsViewBean(modificationOptionCustomDTO);
                               modificationOptionsViewBeanMap.put(modificationOption,modificationOptionsViewBean);
                }
                       modificationTypeOptionsViewBeanMap.put(key,modificationOptionsViewBeanMap);
            }
       
       setModificationOptionsMap(modificationTypeOptionsViewBeanMap);
   }
       ChangeModificationTypeActionForm actionForm = new ChangeModificationTypeActionForm();
       actionForm.setSalesOrg(getSelectedSalesOrg());
       actionForm.setTypeCode(getTypeCode());
       actionForm.setDescription(getDescription());
       setActionForm(actionForm);
   }
    /**
     * return the description 
     *
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }
    /**
     * sets the description
     *
     * @param ldescription The description to set.
     */
    public void setDescription(String ldescription) {
        description = ldescription;
    }
 
    /**
     * return the typeCode 
     *
     * @return Returns the typeCode.
     */
    public String getTypeCode() {
        return typeCode;
    }
    /**
     * sets the typeCode
     *
     * @param ltypeCode The typeCode to set.
     */
    public void setTypeCode(String ltypeCode) {
        typeCode = ltypeCode;
    }
    
  
    /**
     * return the modificationOptionsMap 
     *
     * @return Returns the modificationOptionsMap.
     */
    public TreeMap getModificationOptionsMap() {
        return modificationOptionsMap;
    }
    /**
     * sets the modificationOptionsMap
     *
     * @param lmodificationOptionsMap The modificationOptionsMap to set.
     */
    public void setModificationOptionsMap(TreeMap lmodificationOptionsMap) {
        modificationOptionsMap = lmodificationOptionsMap;
    }
    /**
     * sets the enterpriseName
     *
     * @return  BaseAgreementActionForm
     */
    public ChangeModificationTypeActionForm getChangeModificationTypeActionForm(){
        ChangeModificationTypeActionForm changeModificationTypeActionForm = null;
        if(null != getActionForm() && getActionForm() instanceof ChangeModificationTypeActionForm){
            changeModificationTypeActionForm = (ChangeModificationTypeActionForm)getActionForm();
        }
        else{
            changeModificationTypeActionForm = new ChangeModificationTypeActionForm();
        }
        return changeModificationTypeActionForm;
               
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
    


}
