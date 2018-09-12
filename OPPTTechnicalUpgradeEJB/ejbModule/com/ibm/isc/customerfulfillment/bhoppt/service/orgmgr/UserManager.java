/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;

import java.rmi.RemoteException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserProfileDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ActivityLogCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BPUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.NonBPUserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SigninCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UsersCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.UserCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReverificationCustomDTO;
/**
 * Remote interface for Enterprise Bean: UserManager
 */
public interface UserManager extends javax.ejb.EJBObject 
{
	

	
	/**
	 * createBPUser
	 */
	public BPUserCustomDTO createBPUser(BPUserCustomDTO bpUserCustom)
		throws ServiceException, java.rmi.RemoteException;
	/**
	 * createNonBPUser
	 */
	public NonBPUserCustomDTO createNonBPUser(NonBPUserCustomDTO nonBPUserCustom)
		throws ServiceException, java.rmi.RemoteException;
	/**
	 * createNewUser : To Display SalesOrgs and Roles
	 */
	public CreateUserCustomDTO createNewUser(CreateUserCustomDTO createUserCustom)
		throws ServiceException, java.rmi.RemoteException;
	
	/**
	 * activityLog : To Display activityLog added by Nomita
	 */
	
	public ActivityLogCustomDTO getActivityLog(ActivityLogCustomDTO activityLogCustom)
	throws ServiceException, java.rmi.RemoteException;

	/**
	 * editBPUser
	 */
	public BPUserCustomDTO editBPUser(BPUserCustomDTO bpUserCustom)
		throws ServiceException, java.rmi.RemoteException;
	/**
	 * editNonBPUser
	 */
	public NonBPUserCustomDTO editNonBPUser(NonBPUserCustomDTO nonBPUserCustom)
		throws ServiceException, java.rmi.RemoteException;
	/**
	 * listUsersInSalesOrg : To Display the users in the SalesOrg
	 */
	public UsersCustomDTO listUsersInSalesOrg(UsersCustomDTO usersCustom)
		throws ServiceException, java.rmi.RemoteException;
	/**
	 * registerBPUser
	 */
	public BPUserCustomDTO registerBPUser(BPUserCustomDTO bpUserCustom)
		throws ServiceException, java.rmi.RemoteException;
	/**
	 * registerNonBPUser - registers a NonBP User
	 */
	public NonBPUserCustomDTO registerNonBPUser(NonBPUserCustomDTO nonBPUserCustom)
		throws ServiceException, java.rmi.RemoteException;
	/**
	 * processCreateNewUser :  To display the Groups,Managers and other information depending upon the SalesOrg selection
	 */
	public CreateUserCustomDTO processCreateNewUser(CreateUserCustomDTO createUserCustom)
		throws ServiceException, java.rmi.RemoteException;
	/**
	 * saveEditBPUser
	 */
	public BPUserCustomDTO saveEditBPUser(BPUserCustomDTO bpUserCustom)
		throws ServiceException, java.rmi.RemoteException;
	/**
	 * removeUser : To remove a user
	 */
	public UserCustomDTO removeUser(UserCustomDTO userCustom)
		throws ServiceException, java.rmi.RemoteException;
	/**
	 * saveEditNonBPUser
	 */
	public NonBPUserCustomDTO saveEditNonBPUser(NonBPUserCustomDTO nonBPUserCustom)
		throws ServiceException, RemoteException;
	
	/**
	 *  signIn: Validate a user
	 */	
	public SigninCustomDTO signIn(SigninCustomDTO customDto) 
		throws ServiceException, RemoteException;
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
		throws ServiceException, java.rmi.RemoteException;
	public ReverificationCustomDTO listAllSalesOrgs(ReverificationCustomDTO customDTO)
		throws ServiceException, java.rmi.RemoteException;
}
