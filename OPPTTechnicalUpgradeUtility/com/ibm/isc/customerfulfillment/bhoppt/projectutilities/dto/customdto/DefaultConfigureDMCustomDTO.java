/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

/**
 * Custom dto that holds customer information   
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 4, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */

public class DefaultConfigureDMCustomDTO 
{
   private ConfigureDMEECustomDTO selectedEE=null;
   private ConfigureDMCustomDTO configureDMDTO=null;
   
   /**
    * constructor
    *    @roseuid 3FB471E600B5
    */
   public DefaultConfigureDMCustomDTO() 
   {
    
   }
   
   /**
    * Sets the data
    *    @roseuid 3F77F45B018E
    */
   public void setData() 
   {
    
   }
   
   /**
    * gets the data
    *   @roseuid 3F77F53F03B3
    */
   public void getData() 
   {
    
   }
/**
 * return the configureDMDTO 
 *
 * @return Returns the configureDMDTO.
 */
public ConfigureDMCustomDTO getConfigureDMDTO() {
    return configureDMDTO;
}
/**
 * sets the configureDMDTO
 *
 * @param lConfigureDMDTO The configureDMDTO to set.
 */
public void setConfigureDMDTO(ConfigureDMCustomDTO lConfigureDMDTO) {
    configureDMDTO = lConfigureDMDTO;
}
/**
 * return the selectedEE 
 *
 * @return Returns the selectedEE.
 */
public ConfigureDMEECustomDTO getSelectedEE() {
    return selectedEE;
}
/**
 * sets the selectedEE
 *
 * @param lSelectedEE The selectedEE to set.
 */
public void setSelectedEE(ConfigureDMEECustomDTO lSelectedEE) {
    selectedEE = lSelectedEE;
}
}
