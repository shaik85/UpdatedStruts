/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.CashFlowRptDomainDTO;

/**
 * Cash Flow Report Custom DTO  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 1, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */

public class CashFlowReportCustomDTO 
{
   private ProposalCustomDTO proposalDTO;
   private CashFlowRptDomainDTO reportDTO;
   
   /**
    * constructor
    *  @roseuid 3FB471E4038D
    */
   public CashFlowReportCustomDTO() 
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
 * return the reportDTO 
 *
 * @return Returns the reportDTO.
 */
public CashFlowRptDomainDTO getReportDTO() {
    return reportDTO;
}
/**
 * sets the reportDTO
 *
 * @param lReportDTO The reportDTO to set.
 */
public void setReportDTO(CashFlowRptDomainDTO lReportDTO) {
    reportDTO = lReportDTO;
}
}
