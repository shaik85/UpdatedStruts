/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ContractPlanningRptDomainDTO;

/**
 * Custom dto that holds basic report about a contract  
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

public class ContractPlanningReportCustomDTO extends OPPTCustomDTO
{
   private ProposalCustomDTO proposalDTO = null;
   private ContractPlanningRptDomainDTO reportDTO = null;
   
   /**
    * contract planning report dto
    *
    */

   public ContractPlanningReportCustomDTO() 
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
 * date Jan 5, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return ContractPlanningRptDomainDTO 
 */
public ContractPlanningRptDomainDTO getReportDTO() {
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
 * date Jan 5, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param domainDTO 
 */
public void setReportDTO(ContractPlanningRptDomainDTO domainDTO) {
	reportDTO = domainDTO;
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
 * date Jan 22, 2004 
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
 * date Jan 22, 2004 
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

}
