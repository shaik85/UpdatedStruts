/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BPCustomerListBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BPLegacyBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.UserProfileBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.RoleConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;

/** 
 * UserProfileBOFactory class. 
 * This class will create & consume Business Objects.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * Revised:
 * 	Code clean up and review done by Muruganantham.
 *  Exception handled.
 *  Empty throwns are changed with corresponding error codes.
 * 
 * </PRE><br/> 
 * @author Kedar Harischandrakar
 * @version 5.1A 
 */
public class UserProfileBOFactory
{
	private static final String CLASS_NAME = "UserProfileBOFactory";
	private static final String EXCEPTION = "EXCEPTION";

	/** 
	 * UserProfileBOFactory constructor 
	 * This class creates a object of UserProfileBO
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @return  
	 */
	public UserProfileBOFactory()
	{
	}

	/** 
	 * This method finds userprofiles for the group	 
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @return  List
	 * @param   groupName
	 * @throws  DomainException
	 */
	public List findUserProfileBOForGroup(String groupName) throws DomainException
	{
		String methodName = "findUserProfileBOForGroup";

		UserProfileLocalHome userProfileHome =
			(UserProfileLocalHome) HomeProvider.getLocal(HomeProvider.USER_PROFILE_LOCAL_HOME);
		Collection userCollection = null;

		try
		{
			userCollection = userProfileHome.findByGroupName(groupName);
		}
		catch (FinderException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0601);
		}

		Iterator userProfileIterator = userCollection.iterator();
		List userProfileList = new ArrayList();

		UserProfileLocal userProfileLocal;

		while (userProfileIterator.hasNext())
		{
			userProfileLocal = (UserProfileLocal) userProfileIterator.next();
			userProfileList.add(getUserProfileBOFromLocal(userProfileLocal));
		}

		return userProfileList;
	}

	/** 
	 * This method in the factory gets userprofile for the UserId given.	  
	 * If the UserId is business partner, it will get the BPLegacy nos or Customers nos
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @param	String userId
	 * @throws  DomainException
	 * @return  UserProfileBO
	 */
	public UserProfileBO getUserProfileBO(String userId) throws DomainException
	{
		String methodName = "getUserProfileBO";

		UserProfileLocalHome userProfileHome =
			(UserProfileLocalHome) HomeProvider.getLocal(HomeProvider.USER_PROFILE_LOCAL_HOME);
		UserProfileLocal userProfileLocal = null;

		try
		{
			userProfileLocal = userProfileHome.findByPrimaryKey(userId);
		}
		catch (FinderException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
			return null;
		}

		UserProfileBO userProfileBO = getUserProfileBOFromLocal(userProfileLocal);

		String bpIndicator = userProfileBO.getBPAccessIndicator();

		OPPTLogger.debug(
			new StringBuffer("userProfileLocal.getBpAccessIndicator() = ").append(bpIndicator).toString(),
			CLASS_NAME,
			methodName);

		if (bpIndicator != null)
		{
			if (UtilityConstants.BPLEGACYNO_ACCESS_TYPE_OPPT.equals(bpIndicator))
			{
				Collection bpLegacyNoCollection;
				BPLegacyNoLocalHome bpLegacyNoLocalHome =
					(BPLegacyNoLocalHome) HomeProvider.getLocal(HomeProvider.BP_LEGACY_NO_LOCAL_HOME);
				try
				{
					bpLegacyNoCollection = bpLegacyNoLocalHome.findByUser(userId);
				}
				catch (FinderException ex)
				{
					OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
					throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0601);
				}

				Iterator bpLegacyNoIterator = bpLegacyNoCollection.iterator();
				List bpLegacyNoList = new ArrayList();

				BPLegacyNoLocal bpLegacyNoLocal;

				while (bpLegacyNoIterator.hasNext())
				{
					bpLegacyNoLocal = (BPLegacyNoLocal) bpLegacyNoIterator.next();

					BPLegacyBDO bpLegacyBDO = new BPLegacyBDO();
					bpLegacyBDO.setUserId(OPPTHelper.trimString(bpLegacyNoLocal.getUserId()));
					bpLegacyBDO.setLegacyNumber(OPPTHelper.trimString(bpLegacyNoLocal.getLegacyNo()));
					bpLegacyBDO.setAddressSeqNumber(OPPTHelper.trimString(bpLegacyNoLocal.getAddressSeqNo()));
					bpLegacyBDO.setCustomerName(OPPTHelper.trimString(bpLegacyNoLocal.getCustomerName()));
					bpLegacyNoList.add(bpLegacyBDO);
				}

				userProfileBO.setBPLegactNoList(bpLegacyNoList);
			}
			else if (UtilityConstants.BPCUSTOMERLIST_ACCESS_TYPE_OPPT.equals(bpIndicator))
			{
				Collection bpCustListCollection;
				BPCustListLocalHome bpCustListLocalHome =
					(BPCustListLocalHome) HomeProvider.getLocal(HomeProvider.BP_CUST_LIST_LOCAL_HOME);
				try
				{
					bpCustListCollection = bpCustListLocalHome.findByUser(userId);
				}
				catch (FinderException ex)
				{
					OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
					throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0601);
				}

				Iterator bpCustListIterator = bpCustListCollection.iterator();
				List bpCustListList = new ArrayList();

				BPCustListLocal bpCustListLocal;
				while (bpCustListIterator.hasNext())
				{
					bpCustListLocal = (BPCustListLocal) bpCustListIterator.next();
					BPCustomerListBDO bpCustomerListBDO = new BPCustomerListBDO();
					bpCustomerListBDO.setUserId(OPPTHelper.trimString(bpCustListLocal.getUserId()));
					bpCustomerListBDO.setCustListNo(OPPTHelper.trimString(bpCustListLocal.getCustListNo()));
					bpCustomerListBDO.setCustListName(OPPTHelper.trimString(bpCustListLocal.getCustListName()));
					bpCustListList.add(bpCustomerListBDO);
				}
				userProfileBO.setBPCustomerList(bpCustListList);
			}
		}

		OPPTLogger.debug("Before logging out", CLASS_NAME, methodName);
		return userProfileBO;
	}

	/** 
	 * This method in the factory deletes the UserId from OPPT 
	 * If the UserId is a Business Partner it deletes the records from BPLegacy or BPCustList table 
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @param  String userId
	 * @throws DomainException
	 * @return void
	 */
	public void deleteUserProfileBO(String userId) throws DomainException
	{
		String methodName = "deleteUserProfileBO";

		UserProfileLocalHome userProfileHome =
			(UserProfileLocalHome) HomeProvider.getLocal(HomeProvider.USER_PROFILE_LOCAL_HOME);
		UserProfileLocal userProfileLocal;

		try
		{
			userProfileLocal = userProfileHome.findByPrimaryKey(userId);
		}
		catch (FinderException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0601);
		}

		String bpAccessIndicator = OPPTHelper.trimString(userProfileLocal.getBpAccessIndicator());

		if (bpAccessIndicator != null)
		{
			if (UtilityConstants.BPLEGACYNO_ACCESS_TYPE_OPPT.equals(bpAccessIndicator))
			{
				//To delete from BPLegacyNo table
				BPLegacyNoLocalHome bpLegacyNoLocalHome =
					(BPLegacyNoLocalHome) HomeProvider.getLocal(HomeProvider.BP_LEGACY_NO_LOCAL_HOME);
				Collection bpLegacyNoCollection;
				try
				{
					bpLegacyNoCollection = bpLegacyNoLocalHome.findByUser(userId);
				}
				catch (FinderException ex)
				{
					OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
					throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0601);
				}

				Iterator bpLegacyNoIterator = bpLegacyNoCollection.iterator();
				BPLegacyNoLocal bpLegacyNoLocal;

				while (bpLegacyNoIterator.hasNext())
				{
					bpLegacyNoLocal = (BPLegacyNoLocal) bpLegacyNoIterator.next();
					try
					{
						bpLegacyNoLocal.remove();
					}
					catch (RemoveException ex)
					{
						OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
						throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0625);
					}
				}
			}
			else
			{
				//To delete from BPCustListNo table
				BPCustListLocalHome bpCustListLocalHome =
					(BPCustListLocalHome) HomeProvider.getLocal(HomeProvider.BP_CUST_LIST_LOCAL_HOME);
				Collection bpCustListCollection;
				try
				{
					bpCustListCollection = bpCustListLocalHome.findByUser(userId);
				}
				catch (FinderException ex)
				{
					OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
					throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0601);
				}

				Iterator bpCustListIterator = bpCustListCollection.iterator();
				BPCustListLocal bpCustListLocal;

				while (bpCustListIterator.hasNext())
				{
					bpCustListLocal = (BPCustListLocal) bpCustListIterator.next();
					try
					{
						bpCustListLocal.remove();
					}
					catch (RemoveException ex)
					{
						OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
						throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0626);
					}
				}
			}
		}
		try
		{
			userProfileLocal.remove();
		}
		catch (RemoveException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0627);
		}
	}

	/** 
	 * This factory method create the userprofile in OPPT 
	 * If the userId is a business partner role, it will create the BPLegacy or BPCustList nos 
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @param   UserProfileBO userProfileBO
	 * @throws  DomainException
	 * @return  void
	 */
	public void createUserProfileBO(UserProfileBO userProfileBO) throws DomainException
	{
		String methodName = "createUserProfileBO";
		UserProfileLocalHome userProfileHome =
			(UserProfileLocalHome) HomeProvider.getLocal(HomeProvider.USER_PROFILE_LOCAL_HOME);
		UserProfileLocal userProfileLocal;

		try
		{
			userProfileLocal =
				userProfileHome.create(userProfileBO.getUserId(), Integer.toString(userProfileBO.getRole()));
		}
		catch (CreateException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0628);
		}

		userProfileLocal = getUserProfileLocalFromBO(userProfileLocal, userProfileBO);
		String accessIndicator = OPPTHelper.trimString(userProfileBO.getBPAccessIndicator());
		 
		if (accessIndicator != null)
		{
			if (UtilityConstants.BPLEGACYNO_ACCESS_TYPE_OPPT.equals(accessIndicator))
			{
				BPLegacyNoLocalHome bpLegacyNoHome =
					(BPLegacyNoLocalHome) HomeProvider.getLocal(HomeProvider.BP_LEGACY_NO_LOCAL_HOME);
				List bpLegacyNoList = userProfileBO.getBPLegactNoList();
				Iterator bpLegacyNoIterator = bpLegacyNoList.iterator();
				while (bpLegacyNoIterator.hasNext())
				{
					BPLegacyBDO bpLegacyBDO = (BPLegacyBDO) bpLegacyNoIterator.next();
					try
					{
						BPLegacyNoLocal bpLegacyNoLocal =
							bpLegacyNoHome.create(
								bpLegacyBDO.getUserId(),
								bpLegacyBDO.getLegacyNumber(),
								bpLegacyBDO.getAddressSeqNumber());
					}
					catch (CreateException ex)
					{
						OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
						throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0629);
					}
				}
			}
			else
			{
				BPCustListLocalHome bpCustListLocalHome =
					(BPCustListLocalHome) HomeProvider.getLocal(HomeProvider.BP_CUST_LIST_LOCAL_HOME);

				List bpCustListList = userProfileBO.getBPCustomerList();
				Iterator bpCustListIterator = bpCustListList.iterator();

				BPCustomerListBDO bpCustomerListBDO;
				while (bpCustListIterator.hasNext())
				{
					bpCustomerListBDO = (BPCustomerListBDO) bpCustListIterator.next();
					try
					{
						BPCustListLocal bpCustListLocal =
							bpCustListLocalHome.create(
								bpCustomerListBDO.getUserId(),
								bpCustomerListBDO.getCustListNo());
					}
					catch (CreateException ex)
					{
						OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
						throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0630);
					}
				}
			}
		}

	}

	/** 
	 * This factory method will update the userprofile. 
	 * In case of Business Partner, it also updates the BPLegacyNos and BPCustList nos 
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @param   UserProfileBO userProfileBO
	 * @throws  DomainException
	 * @return  void
	 */
	public void updateUserProfileBO(UserProfileBO userProfileBO) throws DomainException
	{
		String methodName = "updateUserProfileBO";

		String userId = userProfileBO.getUserId();
		UserProfileLocalHome userProfileHome =
			(UserProfileLocalHome) HomeProvider.getLocal(HomeProvider.USER_PROFILE_LOCAL_HOME);
		UserProfileLocal userProfileLocal;
		try
		{
			userProfileLocal = userProfileHome.findByPrimaryKey(userId);
		}
		catch (FinderException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0601);
		}

		userProfileLocal = getUserProfileLocalFromBO(userProfileLocal, userProfileBO);
		String accessIndicator = OPPTHelper.trimString(userProfileBO.getBPAccessIndicator());
		
		if (accessIndicator != null)
		{
			if (UtilityConstants.BPLEGACYNO_ACCESS_TYPE_OPPT.equals(accessIndicator))
			{
				BPLegacyNoLocalHome bpLegacyNoHome =
					(BPLegacyNoLocalHome) HomeProvider.getLocal(HomeProvider.BP_LEGACY_NO_LOCAL_HOME);
				List bpLegacyNoList = userProfileBO.getBPLegactNoList();
				Iterator bpLegacyNoIterator = bpLegacyNoList.iterator();

				BPLegacyBDO bpLegacyBDO;
				while (bpLegacyNoIterator.hasNext())
				{
					bpLegacyBDO = (BPLegacyBDO) bpLegacyNoIterator.next();
					BPLegacyNoKey bpLegacyNoKey =
						new BPLegacyNoKey(
							bpLegacyBDO.getUserId(),
							bpLegacyBDO.getLegacyNumber(),
							bpLegacyBDO.getAddressSeqNumber());
					try
					{
						BPLegacyNoLocal bpLegacyNoLocal = bpLegacyNoHome.findByPrimaryKey(bpLegacyNoKey);

						bpLegacyNoLocal.setUserId(OPPTHelper.trimString(bpLegacyBDO.getUserId()));
						bpLegacyNoLocal.setLegacyNo(OPPTHelper.trimString(bpLegacyBDO.getLegacyNumber()));
						bpLegacyNoLocal.setAddressSeqNo(OPPTHelper.trimString(bpLegacyBDO.getAddressSeqNumber()));
						bpLegacyNoLocal.setCustomerName(OPPTHelper.trimString(bpLegacyBDO.getCustomerName()));
					}
					catch (FinderException ex)
					{
						OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
						throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0631);
					}
				}
			}
			else
			{
				BPCustListLocalHome bpCustListHome =
					(BPCustListLocalHome) HomeProvider.getLocal(HomeProvider.BP_CUST_LIST_LOCAL_HOME);

				List bpCustList = userProfileBO.getBPCustomerList();
				Iterator bpCustListIter = bpCustList.iterator();

				BPCustomerListBDO bpCustListBO;

				while (bpCustListIter.hasNext())
				{
					bpCustListBO = (BPCustomerListBDO) bpCustListIter.next();
					BPCustListKey bpCustListKey =
						new BPCustListKey(bpCustListBO.getUserId(), bpCustListBO.getCustListNo());
					try
					{
						BPCustListLocal bpCustListLocal = bpCustListHome.findByPrimaryKey(bpCustListKey);
						bpCustListLocal.setUserId(OPPTHelper.trimString(bpCustListBO.getUserId()));
						bpCustListLocal.setCustListNo(OPPTHelper.trimString(bpCustListBO.getCustListNo()));
						bpCustListLocal.setCustListName(OPPTHelper.trimString(bpCustListBO.getCustListName()));
					}
					catch (FinderException ex)
					{
						OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
						throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0632);
					}
				}
			}
		}
	}

	/** 
	 * This factory method will get the userprofiles for the users of a salesOrg  
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @param   String salesOrg
	 * @throws  DomainException
	 * @return  List
	 */
	public List findUserProfileBOForSalesOrg(String salesOrg) throws DomainException
	{
		String methodName = "findUserProfileBOForSalesOrg";

		UserProfileLocalHome userProfileHome =
			(UserProfileLocalHome) HomeProvider.getLocal(HomeProvider.USER_PROFILE_LOCAL_HOME);
		Collection userProfileCollection;

		try
		{
			userProfileCollection = userProfileHome.findBySalesOrg(salesOrg);
		}
		catch (FinderException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0633);
		}

		Iterator userProfileIterator = userProfileCollection.iterator();

		List userProfileList = new ArrayList();
		UserProfileLocal userProfileLocal;

		while (userProfileIterator.hasNext())
		{
			userProfileLocal = (UserProfileLocal) userProfileIterator.next();
			userProfileList.add(getUserProfileBOFromLocal(userProfileLocal));
		}

		return userProfileList;
	}

	/** 
	 * This factory method will check whether the UserID is existing in OPPT	  
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
		 * @param   String userId
	 * @throws  DomainException 
	 * @return  boolean
	 */
	public boolean isUserIdExists(String userId) throws DomainException
	{
		boolean isUserExists = false;

		UserProfileLocalHome userProfileHome =
			(UserProfileLocalHome) HomeProvider.getLocal(HomeProvider.USER_PROFILE_LOCAL_HOME);

		try
		{
			UserProfileLocal userProfileLocal = userProfileHome.findByPrimaryKey(userId);
			isUserExists = true;
		}
		catch (FinderException ex)
		{
			// ignore this error
		}

		return isUserExists;
	}

	/** 
	 * This factory method will get all the managers for a salesOrg	  
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
		 * @param   String salesOrg
	 * @throws  DomainException 
	 * @return  List
	 */
	public List findAllManagersForSalesOrg(String salesOrg) throws DomainException
	{
		return findAllForSalesOrgAndRole(salesOrg, Integer.toString(RoleConstants.PROPOSAL_APPROVER));
	}

	/**
	 * To find the users for the given sales org and role 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param salesOrg
	 * @param role
	 * @return
	 * @throws DomainException
	 */
	public List findAllForSalesOrgAndRole(String salesOrg, String role) throws DomainException
	{
		String methodName = "findAllForSalesOrgAndRole";

		UserProfileLocalHome home =
			(UserProfileLocalHome) HomeProvider.getLocal(HomeProvider.USER_PROFILE_LOCAL_HOME);
		List list = new ArrayList();

		try
		{
			Collection collection = home.findAllForSalesOrgAndRole(salesOrg, role);

			Iterator iter = collection.iterator();

			while (iter.hasNext())
			{
				list.add(getUserProfileBOFromLocal((UserProfileLocal) iter.next()));
			}
		}
		catch (FinderException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0633);
		}

		return list;
	}
	/**
	 * To find the users for the given role 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Oct 28, 2006 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param role
	 * @return
	 * @throws DomainException
	 */
	public List findUserByRole(String role) throws DomainException
	{
		String methodName = "findUserByRole";
		UserProfileLocalHome home =	(UserProfileLocalHome) HomeProvider.getLocal(HomeProvider.USER_PROFILE_LOCAL_HOME);
		List list = new ArrayList();

		try
		{
			Collection collection = home.findByRole(role,role);
			Iterator iter = collection.iterator();
			while (iter.hasNext())
			{
				list.add(getUserProfileBOFromLocal((UserProfileLocal) iter.next()));
			}
		}
		catch (FinderException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0633);
		}

		return list;
	}
	


	private UserProfileBO getUserProfileBOFromLocal(UserProfileLocal local)
	{
		UserProfileBO bo = new UserProfileBO();

		bo.setUserId(OPPTHelper.trimString(local.getUserId()));
		bo.setApproverId(OPPTHelper.trimString(local.getApproverId()));
		bo.setAthorization(OPPTHelper.trimString(local.getAuthorization()));
		bo.setBPAccessIndicator(OPPTHelper.trimString(local.getBpAccessIndicator()));
		bo.setGroupName(OPPTHelper.trimString(local.getGroupName()));
		if(local.getRole() == null) {
			bo.setRole(Integer.parseInt("0"));
		} else {
			bo.setRole(Integer.parseInt(local.getRole()));	
		}
		
		bo.setPrimarySalesOrg(OPPTHelper.trimString(local.getAssoSalesOrg()));
		bo.setLastLoginDate(local.getLastLoginDate());
		bo.setFirstName(OPPTHelper.trimString(local.getFirstName()));
		bo.setLastName(OPPTHelper.trimString(local.getLastName()));
//		 Changes for Base agreement starts
		
		bo.setUserType(OPPTHelper.trimString(local.getUserType()));
		if(local.getBaRole() == null)	{	
			bo.setBaRole(Integer.parseInt("0"));
		} else {
			bo.setBaRole(Integer.parseInt(local.getBaRole()));
		}
			
		
//		 Changes for Base agreement ends		
		return bo;
	}

	private UserProfileLocal getUserProfileLocalFromBO(UserProfileLocal local, UserProfileBO bo)
	{
		local.setGroupName(OPPTHelper.trimString(bo.getGroupName()));
		local.setRole(Integer.toString(bo.getRole()));
		local.setApproverId(OPPTHelper.trimString(bo.getApproverId()));
		local.setAssoSalesOrg(OPPTHelper.trimString(bo.getPrimarySalesOrg()));
		local.setAuthorization(OPPTHelper.trimString(bo.getAthorization()));
		local.setBpAccessIndicator(OPPTHelper.trimString(bo.getBPAccessIndicator()));
		local.setLastLoginDate(bo.getLastLoginDate());
		local.setFirstName(OPPTHelper.trimString(bo.getFirstName()));
		local.setLastName(OPPTHelper.trimString(bo.getLastName()));
//		 Changes for Base agreement starts
		
		local.setUserType(OPPTHelper.trimString(bo.getUserType()));
		local.setBaRole(Integer.toString(bo.getBaRole()));
		
//		 Changes for Base agreement ends		
		return local;
	}

	/** 
	 * This method in the factory gets all the Users that are eligible for Approving a Contract/Proposal for Registraton	  
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 *
	 * </PRE><br> 
	 * 
	 * @param 
	 * @throws  DomainException
	 * @author prakash
	 * @return  ArrayList
	 */
	public List findEligibleApprovers() throws DomainException
	{
		String methodName = "findEligibleApprovers";

		UserProfileLocalHome userProfileHome =
			(UserProfileLocalHome) HomeProvider.getLocal(HomeProvider.USER_PROFILE_LOCAL_HOME);

		UserProfileLocal userProfileLocal = null;
		Collection userProfileCollection = null;

		try
		{
			userProfileCollection =
				userProfileHome.findByRole(
					Integer.toString(RoleConstants.CREATE_APPROVE),
					Integer.toString(RoleConstants.PROPOSAL_APPROVER));
		}
		catch (FinderException ex)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.DEBUG, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0634);
		}

		Iterator userProfileIterator = userProfileCollection.iterator();
		List userProfileList = new ArrayList();

		while (userProfileIterator.hasNext())
		{
			userProfileList.add(getUserProfileBOFromLocal((UserProfileLocal) userProfileIterator.next()));
		}

		return userProfileList;
	}
}