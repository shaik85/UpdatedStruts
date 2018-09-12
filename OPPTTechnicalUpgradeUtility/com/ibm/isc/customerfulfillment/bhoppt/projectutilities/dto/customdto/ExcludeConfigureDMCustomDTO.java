/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

/**
 * Exclude Configure DM Custom DTO
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 5, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */

public class ExcludeConfigureDMCustomDTO 
{
   private ConfigureDMSWOCustomDTO[] selectedSWOs = null;
   private ConfigureDMCustomDTO configureDMDTO=null;
   
   /**
    * constructor
    *    @roseuid 3FB471E60322
    */
   public ExcludeConfigureDMCustomDTO() 
   {
    
   }
   
   /**
    * setdata
    *    @roseuid 3F77F14B0187
    */
   public void setData() 
   {
    
   }
   
   /**get data
    * 
    *    @roseuid 3F86795900B5
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
 * return the selectedSWOs 
 *
 * @return Returns the selectedSWOs.
 */
public ConfigureDMSWOCustomDTO[] getSelectedSWOs() {
    return selectedSWOs;
}
/**
 * sets the selectedSWOs
 *
 * @param lSelectedSWOs The selectedSWOs to set.
 */
public void setSelectedSWOs(ConfigureDMSWOCustomDTO[] lSelectedSWOs) {
    selectedSWOs = lSelectedSWOs;
}
}
