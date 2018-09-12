/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * Custom dto that holds modification type details.  
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
public class ModificationTypeCustomDTO extends OPPTCustomDTO {
    
    private String typeCode = null;

   private String description = null;

   private String selectedSalesOrg = null;
   
    private TreeMap modificationOptionsMap = null;

    /**
     * Default constructor 
     *
     */
    public ModificationTypeCustomDTO(){
        
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
 * @param description The description to set.
 */
public void setDescription(String ldescription) {
    description = ldescription;
}
    /**
     * return the modificationTypeMap 
     *
     * @return Returns the modificationTypeMap.
     */
    public TreeMap getModificationTypeMap() {
        return modificationOptionsMap;
    }
    /**
     * sets the modificationTypeMap
     *
     * @param lmodificationTypeMap The modificationTypeMap to set.
     */
    public void setModificationTypeMap(TreeMap lmodificationOptionsMap) {
        modificationOptionsMap = lmodificationOptionsMap;
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
    public void addModificationOption(String modificationOption,String modificationOptionDesc) {
        if(null == modificationOptionsMap) {
            
        }
        modificationOptionsMap.put(modificationOption,modificationOptionDesc);
    }
}
