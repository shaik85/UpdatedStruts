/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.TreeMap;

/**
 * Share Proposal Custom DTO   
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

public class ShareProposalCustomDTO extends OPPTCustomDTO{
	private ProposalCustomDTO proposalDTO = null;
	private TreeMap accessType = null;
	private TreeMap users = null;
	private boolean accessProvidedByAnotherUser = false;
	// private int selectedUser;
	
	/**
	 * Returns user accesstype collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getAccessType() {
		return accessType;
	}

	/**
	 * Returns the proposal to be shared details
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
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
	 * Returns users collection to whom the proposal can be shared. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getUsers() {
		return users;
	}

	/**
	 * Sets the user accesstype collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAccessType TreeMap 
	 */
	public void setAccessType(TreeMap newAccessType) {
		accessType = newAccessType;
	}

	/**
	 * Sets the proposal to be shared 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
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
	 * Sets the collection of users to whom the proposal can be shared 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newUsers TreeMap 
	 */
	public void setUsers(TreeMap newUsers) {
		users = newUsers;
	}
	
	/**
	 * Adds a new user to the collection of users available  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param userId String
	 * @param name String
	 */
	public void addUser(String userId, String name){
		if(null != userId){
			if(null == users){
				users = new TreeMap();
			}
			users.put(userId, name);
		}
	}
	
	/**
	 * Adds new user access type to the collection of user access types.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param iuserId String
	 * @param iaccessType String
	 */
	public void addAccessType(String iuserId, String iaccessType){
		if(null != iuserId && null != iaccessType){
			if(null == accessType){
				accessType = new TreeMap();
			}
			accessType.put(iuserId, iaccessType);
		}
	}
	
	/**
	 * Sets complete data in a single method call.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param iproposalDTO ProposalCustomDTO
	 * @param iaccessType TreeMap
	 * @param iusers TreeMap
	 */
	public void setData(ProposalCustomDTO iproposalDTO, TreeMap iaccessType, TreeMap iusers){
		setProposalDTO(iproposalDTO);
		setAccessType(iaccessType);
		setUsers(iusers);
	}
	
	/**
	 * Returns true if user was provided access by another user 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isAccessProvidedByAnotherUser() {
		return accessProvidedByAnotherUser;
	}

	/**
	 * Sets access provided by another user flag. If access to the proposal is provided to 
	 * the user by another user this flag should be set to true. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAccessProvidedByAnotherUser boolean 
	 */
	public void setAccessProvidedByAnotherUser(boolean newAccessProvidedByAnotherUser) {
		accessProvidedByAnotherUser = newAccessProvidedByAnotherUser;
	}
}
