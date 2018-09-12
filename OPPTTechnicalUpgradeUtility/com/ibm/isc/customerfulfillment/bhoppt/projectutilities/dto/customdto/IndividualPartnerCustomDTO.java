/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

/**
 * Custom dto that holds data required for include or exclude swos from the proposal.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 19, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */

public class IndividualPartnerCustomDTO 
{
	private String partnerType = null; 
   private String legacyNumber = null;
   private String sequenceNumber = null;
   private String partnerName = null;
   private ProposalCustomDTO proposalDTO = null;
   
   /**
    * Individual PartnerCustomDTO
    *
    *@roseuid 3FB471E70111
    */
   public IndividualPartnerCustomDTO() 
   {
    
   }
   
   /**get tyhe data
    * 
    *    @roseuid 3F729F0B0386
	*/
   public void getData() 
   {
    
   }
   
   /**
    * set the data
    *    @roseuid 3FA0941D0319
	*/
   public void setData() 
   {
    
   }
/**
 * return the legacyNumber 
 *
 * @return Returns the legacyNumber.
 */
public String getLegacyNumber() {
    return legacyNumber;
}
/**
 * sets the legacyNumber
 *
 * @param lLegacyNumber The legacyNumber to set.
 */
public void setLegacyNumber(String lLegacyNumber) {
    legacyNumber = lLegacyNumber;
}
/**
 * return the partnerName 
 *
 * @return Returns the partnerName.
 */
public String getPartnerName() {
    return partnerName;
}
/**
 * sets the partnerName
 *
 * @param lPartnerName The partnerName to set.
 */
public void setPartnerName(String lPartnerName) {
    partnerName = lPartnerName;
}
    /**
     * return the partnerType 
     *
     * @return Returns the partnerType.
     */
    public String getPartnerType() {
        return partnerType;
    }
    /**
     * sets the partnerType
     *
     * @param lPartnerType The partnerType to set.
     */
    public void setPartnerType(String lPartnerType) {
        partnerType = lPartnerType;
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
 * return the sequenceNumber 
 *
 * @return Returns the sequenceNumber.
 */
public String getSequenceNumber() {
    return sequenceNumber;
}
/**
 * sets the sequenceNumber
 *
 * @param lSequenceNumber The sequenceNumber to set.
 */
public void setSequenceNumber(String lSequenceNumber) {
    sequenceNumber = lSequenceNumber;
}
}
