/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ListEntitledPricesRptDomainDTO;

/**
 * Custom dto that holds info for inventory date range view  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 4, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */

public class ListEntitledPricesReportCustomDTO extends OPPTCustomDTO
{
   private ProposalCustomDTO proposalDTO = null;
   private ListEntitledPricesRptDomainDTO reportDTO = null;
   
   /**
    * constructor
    *    @roseuid 3FB471E70201
    */
   public ListEntitledPricesReportCustomDTO() 
   {
    
   }
   
   /**get the data
    *    @roseuid 3FA0A3C703C9
    */
   public void getData() 
   {
    
   }
   
   /**
    * set the data
    *    @roseuid 3FA0A3CD0101
    */
   public void setData() 
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
 * date Jan 23, 2004 
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
 * date Jan 23, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return ListEntitledPricesRptDomainDTO
 */
public ListEntitledPricesRptDomainDTO getReportDTO() {
	return reportDTO;
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
 * date Jan 23, 2004 
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
 * date Jan 23, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param domainDTO 
 */
public void setReportDTO(ListEntitledPricesRptDomainDTO domainDTO) {
	reportDTO = domainDTO;
}

}
