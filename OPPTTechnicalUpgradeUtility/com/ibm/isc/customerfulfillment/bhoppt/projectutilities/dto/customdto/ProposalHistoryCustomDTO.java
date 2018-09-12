/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.ArrayList;

/**
 * Custom dto that holds access information about a proposal.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 26, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ProposalHistoryCustomDTO extends OPPTCustomDTO
{
	private ProposalCustomDTO proposalDTO = null;
	private ArrayList accessHistory = null;

	/**
	 * Returns proposal history collection values. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 26, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ArrayList
	 */
	public ArrayList getAccessHistory() {
		return accessHistory;
	}

	/**
	 * Returns proposal for which the access history is fetched 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 26, 2003 
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
	 * Sets access history details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 26, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAccessHistory ArrayList 
	 */
	public void setAccessHistory(ArrayList newAccessHistory) {
		accessHistory = newAccessHistory;
	}

	/**
	 * Sets proposal to which the access history need to be fetched 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 26, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalDTO ProposalCustomDTO 
	 */
	public void setProposalDTO(ProposalCustomDTO newProposalDTO) {
		proposalDTO = newProposalDTO;
	}
	
	/**
	 * Adds a new ProposalHistoryDataCustomDTO to the collection of proposal history objects   
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 26, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAccessHistory ProposalHistoryDataCustomDTO
	 */
	public void addAccessHistory(ProposalHistoryDataCustomDTO newAccessHistory){
		if(null != newAccessHistory){
			if(null == accessHistory){
				accessHistory = new ArrayList();
			}
			accessHistory.add(newAccessHistory);
		}
	}
}
