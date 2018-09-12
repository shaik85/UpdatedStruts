/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.VarianceRptDomainDTO;

/**
 * Variance Rpt Custom DTO  
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

public class VarianceRptCustomDTO extends OPPTCustomDTO 
{
   private ProposalCustomDTO proposalDTO = null;
   private VarianceRptDomainDTO reportDTO = null;
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
 * date Jan 27, 2004 
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
 * date Jan 27, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return VarianceRptDomainDTO
 */
public VarianceRptDomainDTO getReportDTO() {
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
 * date Jan 27, 2004 
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
 * date Jan 27, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @param domainDTO 
 */
public void setReportDTO(VarianceRptDomainDTO domainDTO) {
	reportDTO = domainDTO;
}

}
