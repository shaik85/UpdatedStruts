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

public class ProposalDomainDTO 
{
   private ArrayList customerDTO =null;
   /**
    * theCustomerDomainDTO
    */
   public CustomerDomainDTO theCustomerDomainDTO=null;
   
   /**
    * constructor
    *    @roseuid 3FB4745B0381
    */
   public ProposalDomainDTO() 
   {
    
   }
/**
 * return the customerDTO 
 *
 * @return Returns the customerDTO.
 */
public ArrayList getCustomerDTO() {
    return customerDTO;
}
/**
 * sets the customerDTO
 *
 * @param lCustomerDTO The customerDTO to set.
 */
public void setCustomerDTO(ArrayList lCustomerDTO) {
    customerDTO = lCustomerDTO;
}
/**
 * return the theCustomerDomainDTO 
 *
 * @return Returns the theCustomerDomainDTO.
 */
public CustomerDomainDTO getTheCustomerDomainDTO() {
    return theCustomerDomainDTO;
}
/**
 * sets the theCustomerDomainDTO
 *
 * @param lTheCustomerDomainDTO The theCustomerDomainDTO to set.
 */
public void setTheCustomerDomainDTO(CustomerDomainDTO lTheCustomerDomainDTO) {
    theCustomerDomainDTO = lTheCustomerDomainDTO;
}
}
