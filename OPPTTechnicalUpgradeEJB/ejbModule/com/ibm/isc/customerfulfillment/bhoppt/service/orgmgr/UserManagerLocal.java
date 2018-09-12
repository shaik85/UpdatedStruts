/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserGroupProfileDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserProfileDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import java.util.HashMap;
/**
 * Local interface for Enterprise Bean: UserManager
 */
public interface UserManagerLocal extends javax.ejb.EJBLocalObject {
	/**
	 *  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public UserGroupProfileDomainDTO findUserForGroup(String groupName)
		throws ServiceException;
		
	// Get Eligible Approvers to Approve a Contract/ Proposal for Registration 
	
	public List getEligibleApprover() throws ServiceException;
	/**
	 *  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param userId
	 * @return UserProfileDomainDTO
	 * @throws ServiceException
	 * @author balajiv 
	 */

	public UserProfileDomainDTO getUserProfile(String userId)
		throws ServiceException;
		
		

	/**
	 *  This method will get the users from same group
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @author Kedar Harischandrakar
	 */
	public UserGroupProfileDomainDTO getUsersFromSameGrp(
	    String userId,
		String groupName,
		int role)
		throws ServiceException;
	/**
	 * This method checks if the proposal is shared to loggedUser 
	 * OR Shared to someone in loggedUser group
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param Hashmap
	 * @return boolean
	 * @throws ServiceException
	 * @author Prakash
	 */

	public boolean validateForSharing(HashMap compareValues) throws ServiceException;
	public boolean isUserFromSameGroup(String user1, String user2) throws ServiceException;
	public boolean isTargetUserEligibleForTransfer(String user, String targetUser) throws ServiceException;
}
