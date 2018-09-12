/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalForApprovalCustomDTO;

/**
 * Holds complete information required for proposal for approval view.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ProposalForApprovalViewBean extends ProposalViewBean {
	private String iCreatedBy = null;

	/**
	 * Returns created by user id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCreatedBy() {
		return iCreatedBy;
	}

	/**
	 * Sets created by property 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCreatedBy String 
	 */
	public void setCreatedBy(String newCreatedBy) {
		iCreatedBy = newCreatedBy;
	}
	
	/**
	 * Sets complete data in a single method call.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param id String
	 * @param proposalName String
	 * @param proposalType String
	 * @param status String
	 * @param oldContractNumber String
	 * @param lockedBy String
	 * @param accessType String
	 * @param createdBy String
	 */
	public void setData(String id, String proposalName, String proposalType, String status, 
						String oldContractNumber, String lockedBy, String accessType, String createdBy){
		super.setData(id, proposalName, proposalType, status, oldContractNumber, lockedBy, accessType);
		setCreatedBy(createdBy);
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(ProposalForApprovalCustomDTO customDTO){
		if(null != customDTO){
			setId(String.valueOf(customDTO.getId()));
			setProposalName(customDTO.getName());
			setProposalType(customDTO.getType());
			setStatus(customDTO.getStatus());
			setOldContractNumber(customDTO.getOldContractNumber());
			setLockedBy(customDTO.getLockedBy());
			setAccessType(customDTO.getAccess());
			setCreatedBy(customDTO.getCreatedBy());
		}
	}
	
	/**
     * ProposalForApprovalViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public ProposalForApprovalViewBean(ProposalForApprovalCustomDTO customDTO){
		setData(customDTO);
	}
}
