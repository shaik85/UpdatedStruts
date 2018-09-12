/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.TreeMap;

/**
 * Custom dto that holds data related to a user access on a proposal. 
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

public class ProposalsForApprovalCustomDTO extends OPPTCustomDTO {
	private TreeMap proposalsForApproval = null;
	private GroupUserCustomDTO groupUserInfo = null;

	/**
	 * Returns group user information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return GroupUseCustomDTO
	 */
	public GroupUserCustomDTO getGroupUserInfo() {
		return groupUserInfo;
	}

	/**
	 * Returns proposals for approval collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getProposalsForApproval() {
		return proposalsForApproval;
	}

	/**
	 * Sets group user information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGroupUserInfo GroupUserCustomDTO
	 */
	public void setGroupUserInfo(GroupUserCustomDTO newGroupUserInfo) {
		groupUserInfo = newGroupUserInfo;
	}

	/**
	 * Sets proposals for approval collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalsForApproval TreeMap
	 */
	public void setProposalsForApproval(TreeMap newProposalsForApproval) {		
		proposalsForApproval = newProposalsForApproval;
	}

	/**
     * Sets proposals for approval collection
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 24, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param iproposalForApproval 
     */
	
	public void addProposalForApproval(ProposalForApprovalCustomDTO iproposalForApproval){
		if(null != iproposalForApproval){
			if(null == proposalsForApproval){
				proposalsForApproval = new TreeMap();
			}
			proposalsForApproval.put(iproposalForApproval.getId()+"", iproposalForApproval);  /* NOI18N */
		}
	}
}
