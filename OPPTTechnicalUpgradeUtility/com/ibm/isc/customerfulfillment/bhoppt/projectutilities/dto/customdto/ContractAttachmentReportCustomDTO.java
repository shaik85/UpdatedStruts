/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ContractAttchRptDomainDTO;

/**
 * Custom dto for contract attachment report
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 23, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ContractAttachmentReportCustomDTO extends OPPTCustomDTO {
	private ProposalCustomDTO proposalDTO = null;
	private ContractAttchRptDomainDTO reportDTO = null;
	private boolean draft = false;

	/**
	 * Returns proposal information 
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
	 * @return ProposalCustomDTO
	 */
	public ProposalCustomDTO getProposalDTO() {
		return proposalDTO;
	}

	/**
	 * Returns report information 
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
	 * @return ContractAttchRptDomainDTO 
	 */
	public ContractAttchRptDomainDTO getReportDTO() {
		return reportDTO;
	}

	/**
	 * Sets proposal information 
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
	 * @param newProposalDTO
	 * 
	 */
	public void setProposalDTO(ProposalCustomDTO newProposalDTO) {
		proposalDTO = newProposalDTO;
	}

	/**
	 * Sets report information 
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
	 * @param newReportDTO
	 */
	public void setReportDTO(ContractAttchRptDomainDTO newReportDTO) {
		reportDTO = newReportDTO;
	}

	/**
	 * Resturn if the report is a draft or final report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isDraft() {
		return draft;
	}

	/**
	 * Sets report type flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDraft 
	 */
	public void setDraft(boolean newDraft) {
		draft = newDraft;
	}
}