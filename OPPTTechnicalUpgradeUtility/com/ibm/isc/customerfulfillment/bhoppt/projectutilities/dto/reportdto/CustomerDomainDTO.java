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
 * date Nov 22, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */

public class CustomerDomainDTO 
{
   private ArrayList dmDTO = null;
   /** public */
   public ProposalDomainDTO theProposalDomainDTO = null;
   /** public */
   public DMDomainDTO theDMDomainDTO = null;
   
   /**
    * constructor
    *    @roseuid 3FB4745A0022
    */
   public CustomerDomainDTO() 
   {
    
   }
/**
 * return the dmDTO 
 *
 * @return Returns the dmDTO.
 */
public ArrayList getDmDTO() {
    return dmDTO;
}
/**
 * sets the dmDTO
 *
 * @param lDmDTO The dmDTO to set.
 */
public void setDmDTO(ArrayList lDmDTO) {
    dmDTO = lDmDTO;
}
}
