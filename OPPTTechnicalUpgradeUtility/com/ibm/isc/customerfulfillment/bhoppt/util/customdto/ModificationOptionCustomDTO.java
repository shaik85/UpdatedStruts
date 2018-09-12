/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * Custom dto that holds modification options.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Sep 8,06
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravi Yandapalli
 * @version CBS 2.1
 */
public class ModificationOptionCustomDTO extends OPPTCustomDTO {

  private String typeCode= null;

   private String modificationOption= null;

   private String modificationDescription= null;

    
    /**
     * Default constructor 
     *
     */
    public ModificationOptionCustomDTO(){
        
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
     * sets the modificationDescription
     *
     * @param lmodificationDescription The modificationDescription to set.
     */
    public void setModificationDescription(String lmodificationDescription) {
        modificationDescription = lmodificationDescription;
    }
/**
 * return the modificationOption 
 *
 * @return Returns the modificationOption.
 */
public String getModificationOption() {
    return modificationOption;
}
/**
 * sets the modificationOption
 *
 * @param lmodificationOption The modificationOption to set.
 */
public void setModificationOption(String lmodificationOption) {
    modificationOption = lmodificationOption;
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
}
