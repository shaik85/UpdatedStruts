/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto;

import java.util.ArrayList;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Sep 24, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1x
 */
public class SWODomainDTO 
{
   private ArrayList eeDTO;
   /** public variable */
   public EEDomainDTO theEEDomainDTO;
   /** public variable */
   public DMDomainDTO theDMDomainDTO;
   
   /**
    * constructor
    *    @roseuid 3FB4745B03B3
    */
   public SWODomainDTO() 
   {
    
   }
   
   /**
    *    @param swoBO
    *    @roseuid 3F968CBC02AC
    */
//   public void SWODTO(SWOBO swoBO) 
//   {
//    
//   }
/**
 * return the eeDTO 
 *
 * @return Returns the eeDTO.
 */
public ArrayList getEeDTO() {
    return eeDTO;
}
/**
 * sets the eeDTO
 *
 * @param lEeDTO The eeDTO to set.
 */
public void setEeDTO(ArrayList lEeDTO) {
    eeDTO = lEeDTO;
}
/**
 * return the theDMDomainDTO 
 *
 * @return Returns the theDMDomainDTO.
 */
public DMDomainDTO getTheDMDomainDTO() {
    return theDMDomainDTO;
}
/**
 * sets the theDMDomainDTO
 *
 * @param lTheDMDomainDTO The theDMDomainDTO to set.
 */
public void setTheDMDomainDTO(DMDomainDTO lTheDMDomainDTO) {
    theDMDomainDTO = lTheDMDomainDTO;
}
/**
 * return the theEEDomainDTO 
 *
 * @return Returns the theEEDomainDTO.
 */
public EEDomainDTO getTheEEDomainDTO() {
    return theEEDomainDTO;
}
/**
 * sets the theEEDomainDTO
 *
 * @param lTheEEDomainDTO The theEEDomainDTO to set.
 */
public void setTheEEDomainDTO(EEDomainDTO lTheEEDomainDTO) {
    theEEDomainDTO = lTheEEDomainDTO;
}
}
