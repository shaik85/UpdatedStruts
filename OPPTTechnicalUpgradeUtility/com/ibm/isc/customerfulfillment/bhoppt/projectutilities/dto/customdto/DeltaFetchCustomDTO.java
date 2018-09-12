/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

/**
 * Delta Fetch Custom DTO 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 23, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */

public class DeltaFetchCustomDTO extends OPPTCustomDTO
{
   private ProposalCustomDTO proposalDTO;
   private boolean skip;
   
   /**
    * constructor
    *    @roseuid 3FB471E6014B
    */
   public DeltaFetchCustomDTO() 
   {
    
   }
   
   /**
    * set the data
    *    @roseuid 3F813A280353
    */
   public void setData() 
   {
    
   }
   
   /**
    * get the data
    *    @roseuid 3F9F520C0351
    */
   public void getData() 
   {
    
   }
/** 
 * Enter one sentence as a brief description for this method. 
 * You can enter more text here. Please think of 
 * - visibility decision 
 * - changes that are made to objects, which are passed as parameters 
 * - concurrency issues 
 * - examples how to invoke this methods 
 * - preconditions that this method relies on 
 * 
 * <br><b>Known Bugs</b><br> 
 * 
 * <br><PRE> 
 * date Dec 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return ProposalCustomDTO
 */
public ProposalCustomDTO getProposalDTO() {
	return proposalDTO;
}

/** 
 * Enter one sentence as a brief description for this method. 
 * You can enter more text here. Please think of 
 * - visibility decision 
 * - changes that are made to objects, which are passed as parameters 
 * - concurrency issues 
 * - examples how to invoke this methods 
 * - preconditions that this method relies on 
 * 
 * <br><b>Known Bugs</b><br> 
 * 
 * <br><PRE> 
 * date Dec 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return boolean
 */
public boolean isSkip() {
	return skip;
}

/** 
 * Enter one sentence as a brief description for this method. 
 * You can enter more text here. Please think of 
 * - visibility decision 
 * - changes that are made to objects, which are passed as parameters 
 * - concurrency issues 
 * - examples how to invoke this methods 
 * - preconditions that this method relies on 
 * 
 * <br><b>Known Bugs</b><br> 
 * 
 * <br><PRE> 
 * date Dec 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param customDTO 
 */
public void setProposalDTO(ProposalCustomDTO customDTO) {
	proposalDTO = customDTO;
}

/** 
 * Enter one sentence as a brief description for this method. 
 * You can enter more text here. Please think of 
 * - visibility decision 
 * - changes that are made to objects, which are passed as parameters 
 * - concurrency issues 
 * - examples how to invoke this methods 
 * - preconditions that this method relies on 
 * 
 * <br><b>Known Bugs</b><br> 
 * 
 * <br><PRE> 
 * date Dec 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param b 
 */
public void setSkip(boolean b) {
	skip = b;
}

}
