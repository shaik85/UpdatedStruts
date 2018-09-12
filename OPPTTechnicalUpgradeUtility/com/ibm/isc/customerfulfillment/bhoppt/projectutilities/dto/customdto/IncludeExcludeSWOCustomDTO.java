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
public class IncludeExcludeSWOCustomDTO extends OPPTCustomDTO
{
	private ProposalCustomDTO proposalDTO = null;
	private SWOCustomDTO[] selectedSWOs = null;
	private DMCustomDTO[] selectedDMs = null;
	private ProposalCustomerCustomDTO[] selectedCustomers = null;
	
	/** 
	 * Gets the proposal information
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
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
	 * Gets the selected customers
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalCustomerCustomDTO[]
	 */
	public ProposalCustomerCustomDTO[] getSelectedCustomers() {
		return selectedCustomers;
	}

	/** 
	 * Gets the selected DMs
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DMCustomDTO[]
	 */
	public DMCustomDTO[] getSelectedDMs() {
		return selectedDMs;
	}

	/** 
	 * Gets the selected licenses
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SWOCustomDTO[]
	 */
	public SWOCustomDTO[] getSelectedSWOs() {
		return selectedSWOs;
	}

	/** 
	 * Sets the proposal information
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
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
	 * Sets the selected customers
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedCustomers 
	 */
	public void setSelectedCustomers(ProposalCustomerCustomDTO[] newSelectedCustomers) {
		selectedCustomers = newSelectedCustomers;
	}

	/** 
	 * Sets the selected DMs
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedDMs 
	 */
	public void setSelectedDMs(DMCustomDTO[] newSelectedDMs) {
		selectedDMs = newSelectedDMs;
	}

	/** 
	 * Sets the selected Licenses
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedSWOs 
	 */
	public void setSelectedSWOs(SWOCustomDTO[] newSelectedSWOs) {
		selectedSWOs = newSelectedSWOs;
	}
}
