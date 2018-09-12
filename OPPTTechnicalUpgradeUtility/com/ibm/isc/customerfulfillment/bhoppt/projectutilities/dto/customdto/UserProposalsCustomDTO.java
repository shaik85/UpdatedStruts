/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.TreeMap;

/**
 * Custom dto that holds information about group users proposals  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 18, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class UserProposalsCustomDTO extends OPPTCustomDTO {
	private GroupUserCustomDTO groupUserInfo = null;
	private TreeMap proposals = null;
	
	/**
	 * Returns group user information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return GroupUserCustomDTO
	 */
	public GroupUserCustomDTO getGroupUserInfo() {
		return groupUserInfo;
	}

	/**
	 * Returns collection of proposals for the group user 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getProposals() {
		return proposals;
	}

	/**
     * Sets group user information
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 18, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newGroupUserInfo 
     */
	public void setGroupUserInfo(GroupUserCustomDTO newGroupUserInfo) {
		groupUserInfo = newGroupUserInfo;
	}

	/**
	 * Sets group user's proposals 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposals TreeMap 
	 */
	public void setProposals(TreeMap newProposals) {
		proposals = newProposals;
	}

	/**
	 * Adds new proposal to the collection of proposals for the group user  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposal ProposalCustomDTO
	 */
	public void addProposal(ProposalCustomDTO proposal){
		if(null != proposal){
			if(null == proposals){
				proposals = new TreeMap();
			}
			proposals.put(new Integer(proposal.getId()), proposal);
		}
	}
	
	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param igroupUserInfo
	 * @param iproposals
	 */
	public void setData(GroupUserCustomDTO igroupUserInfo, TreeMap iproposals){
		setGroupUserInfo(igroupUserInfo);
		setProposals(iproposals);
	}
}
