/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.List;

/**
 * Copy Configure DM Custom DTO
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 15, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */

public class CopyConfigureDMCustomDTO 
{
   
   /**
   Collection of swo ids
    */
   private List selectedSWOs = null;
   private ConfigureDMCustomDTO configureDMCustomDTO = null;
   
   /**
    * CopyConfigureDMCustomDTO
    * 
    *   @roseuid 3FB471E501FE
    */
   public CopyConfigureDMCustomDTO() 
   {
    
   }
   
   /**
    * set data
    *   @roseuid 3F780D9C0177
    */
   public void setData() 
   {
    
   }
   
   /**
    * get data
    * 
    *  @roseuid 3F867B6A019C
    */
   public void getData() 
   {
    
   }
/**
 * return the configureDMCustomDTO 
 *
 * @return Returns the configureDMCustomDTO.
 */
public ConfigureDMCustomDTO getConfigureDMCustomDTO() {
    return configureDMCustomDTO;
}
/**
 * sets the configureDMCustomDTO
 *
 * @param lConfigureDMCustomDTO The configureDMCustomDTO to set.
 */
public void setConfigureDMCustomDTO(ConfigureDMCustomDTO lConfigureDMCustomDTO) {
    configureDMCustomDTO = lConfigureDMCustomDTO;
}
/**
 * return the selectedSWOs 
 *
 * @return Returns the selectedSWOs.
 */
public List getSelectedSWOs() {
    return selectedSWOs;
}
/**
 * sets the selectedSWOs
 *
 * @param lSelectedSWOs The selectedSWOs to set.
 */
public void setSelectedSWOs(List lSelectedSWOs) {
    selectedSWOs = lSelectedSWOs;
}
}
