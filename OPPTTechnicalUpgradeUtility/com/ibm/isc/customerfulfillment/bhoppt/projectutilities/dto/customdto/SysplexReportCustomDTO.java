/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.SysplexRptDomainDTO;
/**
 * Sysplex Report Custom DTO
 * 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 19, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */


public class SysplexReportCustomDTO extends OPPTCustomDTO
{
   private ProposalCustomDTO proposalDTO;
   private SysplexRptDomainDTO reportDTO;
   
   /**
    * get the data
    *    @roseuid 3FB471E900A5
    */
   public SysplexReportCustomDTO() 
   {
    
   }
   
   /**
    * get the data
    *    @roseuid 3FA0FD5E0314
    */
   public void getData() 
   {
    
   }
   
   /**
    * set the data
    *    @roseuid 3FA0FD640024
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
 * date Jan 27, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br> 
 * 
 * @return 
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
 * @return 
 */
public SysplexRptDomainDTO getReportDTO() {
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
public void setReportDTO(SysplexRptDomainDTO domainDTO) {
	reportDTO = domainDTO;
}

}
