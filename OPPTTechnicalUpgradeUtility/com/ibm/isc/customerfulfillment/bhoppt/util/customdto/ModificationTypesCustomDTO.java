/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * Custom dto that holds modification map.  
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
public class ModificationTypesCustomDTO extends OPPTCustomDTO {
    
   private TreeMap modificationTypesMap = null;
   
   private String salesOrg = null;
   /**
    * Default constructor 
    *
    */ 
   public ModificationTypesCustomDTO(){
       
   }

/**
 * return the modificationTypesList 
 *
 * @return Returns the modificationTypesList.
 */
public TreeMap getModificationTypesMap() {
    return modificationTypesMap;
}
/**
 * sets the modificationTypesList
 *
 * @param lmodificationTypesMap The modificationTypesList to set.
 */
public void setModificationTypesMap(TreeMap lmodificationTypesMap) {
    modificationTypesMap = lmodificationTypesMap;
}



/**
 *gets the  salesOrg
 *
 * @return Returns the salesOrg.
 */
public String getSalesOrg() {
    return salesOrg;
}
/**
 * sets the salesOrg
 * @param lsalesOrg The salesOrg to set.
 */
public void setSalesOrg(String lsalesOrg) {
    salesOrg = lsalesOrg;
}
}
