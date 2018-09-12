/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

/**
 * Custom dto that holds proposal for Approval  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 3, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */

public class ProposalForApprovalCustomDTO extends ProposalCustomDTO 
{
   private String createdBy = null;
   
   /**
    * constructor
    *    @roseuid 3FB4723E0238
    */
   public ProposalForApprovalCustomDTO() 
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
 * date Jan 6, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return String
 */
public String getCreatedBy() {
	return createdBy;
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
 * date Jan 6, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param string 
 */
public void setCreatedBy(String string) {
	createdBy = string;
}

}
