/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto;
/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 22, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */
public class PriceDomainDTO 
{
    /**
     * public variabl
     *    
     */
   public EEDomainDTO theEEDomainDTO = null;
   
   /**
    * constructor
    *    @roseuid 3FB4745B02AE
    */
   public PriceDomainDTO() 
   {
    
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
