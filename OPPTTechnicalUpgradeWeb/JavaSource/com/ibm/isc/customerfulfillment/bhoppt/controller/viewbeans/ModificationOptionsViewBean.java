/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationOptionActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationOptionCustomDTO;

/**
 * Holds the detail information modification options  
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
public class ModificationOptionsViewBean extends OPPTViewBean {
    
   private String typeCode = null;
    
   private String modificationOption = null;

   private String modificationDescription = null;
    
    /**
     * 
     * constructor
     * 
     * 
     */
      public ModificationOptionsViewBean(){
          
      }
      
      /**
       *Constructor of ModificationOptionsViewBean
       *@author Ravi Yandapalli
       *
       *Dec 27, 2006   6:15:45 PM
       * @param modificationOptionCustomDTO
       */
      
      public ModificationOptionsViewBean(ModificationOptionCustomDTO modificationOptionCustomDTO){
          
          setModificationDescription(modificationOptionCustomDTO.getModificationDescription());
          setModificationOption(modificationOptionCustomDTO.getModificationOption());
          setTypeCode(modificationOptionCustomDTO.getTypeCode());
          ModificationOptionActionForm actionForm = new ModificationOptionActionForm();
          actionForm.setTypeCode(getTypeCode());
          actionForm.setModificationOption(getModificationOption());
          actionForm.setModificationDescription(getModificationDescription());  
          setActionForm(actionForm);
      }
    
    /**
     * return the modificationDescription 
     *
     * @return Returns the modificationDescription.
     */
    public String getModificationDescription() {
        return modificationDescription;
    }
    
    
/**
 *this is the getter method for modificationOption 
 *
 *@author Ravi Yandapalli
 *
 *Dec 27, 2006   6:16:08 PM
 *
 * @return String.
 */
public String getModificationOption() {
    return modificationOption;
}
/**
 * Setere method
 *@author Ravi Yandapalli
 *
 *Dec 27, 2006   6:16:08 PM
 * @param lModificationOption modificationOption.
 */
public void setModificationOption(String lModificationOption) {
    modificationOption = lModificationOption;
}
/**
 *this is the getter method for typeCode 
 *
 *@author Ravi Yandapalli
 *
 *Dec 27, 2006   6:16:08 PM
 *
 * @return String.
 */
public String getTypeCode() {
    return typeCode;
}
/**
 * Setere method
 *@author Ravi Yandapalli
 *
 *Dec 27, 2006   6:16:08 PM
 * @param lTypeCode typeCode.
 */
public void setTypeCode(String lTypeCode) {
    typeCode = lTypeCode;
}
/**
 * Setere method
 *@author Ravi Yandapalli
 *
 *Dec 27, 2006   6:16:08 PM
 * @param lModificationDescription modificationDescription.
 */
public void setModificationDescription(String lModificationDescription) {
    modificationDescription = lModificationDescription;
}
    /**
     * sets the enterpriseName
     *
     * @return  BaseAgreementActionForm
     */
    public ModificationOptionActionForm getModificationOptionActionForm(){
        ModificationOptionActionForm modificationOptionActionForm = null;
        if(null != getActionForm() && getActionForm() instanceof ModificationOptionActionForm){
            modificationOptionActionForm = (ModificationOptionActionForm)getActionForm();
        }
        else{
            modificationOptionActionForm = new ModificationOptionActionForm();
        }
        return modificationOptionActionForm;
               
    }
}
