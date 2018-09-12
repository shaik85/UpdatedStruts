/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

/**
 * Selected Customers DM Custom DTO   
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 28, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */

public class SelectedCustomersCustomDTO 
{
   private ProposalCustomDTO proposalDTO = null;
   private CustomerListCustomerCustomDTO selectedCustomers = null;
   
   /**
    * constructor
    *    @roseuid 3FB4723E02D8
    */
   public SelectedCustomersCustomDTO() 
   {
    
   }
   
   /**
    * get the data
    *    @roseuid 3F9F43F30397
    */
   public void getData() 
   {
    
   }
   
   /**
    * set the data
    *    @roseuid 3F9F43F80362
    */
   public void setData() 
   {
    
   }
/**
 * return the proposalDTO 
 *
 * @return Returns the proposalDTO.
 */
public ProposalCustomDTO getProposalDTO() {
    return proposalDTO;
}
/**
 * sets the proposalDTO
 *
 * @param lProposalDTO The proposalDTO to set.
 */
public void setProposalDTO(ProposalCustomDTO lProposalDTO) {
    proposalDTO = lProposalDTO;
}
/**
 * return the selectedCustomers 
 *
 * @return Returns the selectedCustomers.
 */
public CustomerListCustomerCustomDTO getSelectedCustomers() {
    return selectedCustomers;
}
/**
 * sets the selectedCustomers
 *
 * @param lSelectedCustomers The selectedCustomers to set.
 */
public void setSelectedCustomers(
        CustomerListCustomerCustomDTO lSelectedCustomers) {
    selectedCustomers = lSelectedCustomers;
}
}
