/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.orgmgr;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.UserGroupProfileDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ActivityLogBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.GroupBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ProfileInputBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.SalesOrgBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.ActivityLogBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.GroupBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.ProfileInputBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.UserProfileBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CreateGroupCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.GroupCustomDTO;



import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.TimeTaken;

/**
 *Bean implementation class for Enterprise Bean: GroupManager
 * 
 * 
 * <br/><PRE> 
 * date Feb 6, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Kedar
 * @version 5.1A
 */
public class GroupManagerBean implements javax.ejb.SessionBean
{
	private static final String EXCEPTION = "EXCEPTION";
	private static final String CLASS_NAME = "GroupManagerBean";
	private ActivityLogBOFactory iActivityLogBOFactory = new ActivityLogBOFactory();

	private javax.ejb.SessionContext mySessionCtx;

	/**
	 * getSessionContext
	 */
	public javax.ejb.SessionContext getSessionContext()
	{
		return mySessionCtx;
	}

	/**
	 * setSessionContext
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx)
	{
		mySessionCtx = ctx;
	}

	/**
	 * ejbCreate
	 */
	public void ejbCreate() throws javax.ejb.CreateException
	{

	}

	/**
	 * ejbActivate
	 */
	public void ejbActivate()
	{

	}

	/**
	 * ejbPassivate
	 */
	public void ejbPassivate()
	{

	}

	/**
	 * ejbRemove
	 */
	public void ejbRemove()
	{

	}

	/**
	 *  
	 * This method goes to the factory and creates a group
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CreateGroupCustomDTO
	 * @throws ServiceException
	 * @param CreateGroupCustomDTO
	 * 
	 */
	public CreateGroupCustomDTO createGroup(CreateGroupCustomDTO createGroupCustomDTO) throws ServiceException
	{
		String methodName = "createGroup";

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);

		try
		{
			GroupBOFactory groupBOFactory = new GroupBOFactory();

			try
			{
				if (groupBOFactory
					.isGroupNameExistsForSalesOrg(
						createGroupCustomDTO.getGroupName(),
						createGroupCustomDTO.getSelectedSalesArea()))
				{
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0212);
				}
			}
			catch (DomainException ex)
			{
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			GroupBO groupBO = new GroupBO();
			groupBO.setGroupName(createGroupCustomDTO.getGroupName());
			groupBO.setSalesOrg(createGroupCustomDTO.getSelectedSalesArea());

			try
			{
				groupBOFactory.createGroupBO(groupBO);
			}
			catch (DomainException ex)
			{
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}
			String message= "Geo Security officer "+createGroupCustomDTO.getUserId() + " successfully created the group " + createGroupCustomDTO.getGroupName()+ "!";
			System.out.println("GroupManagerBean.createGroup()"+createGroupCustomDTO.getUserId() );
			createActivityLog(createGroupCustomDTO.getUserId(),message);
			return createGroupCustomDTO;
		}
		catch (ServiceException ex)
		{
			throw ex;
		}
		finally
		{
			timeTaken.end();
		}
	}

	/**
	 *  
	 * This method goes to the factory and removes a group
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return GroupCustomDTO
	 * @throws ServiceException
	 * @param GroupCustomDTO
	 * 
	 */
	public GroupCustomDTO removeGroup(GroupCustomDTO groupCustomDTO) throws ServiceException
	{
		String methodName = "removeGroup";

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);
		try
		{
			UserManagerLocalHome userManagerLocalHome =
				(UserManagerLocalHome) HomeProvider.getLocal(HomeProvider.USER_MANAGER_LOCAL_HOME);

			UserManagerLocal userManagerLocal;
			UserGroupProfileDomainDTO userGroupProfileDomainDTO;
			try
			{
				userManagerLocal = userManagerLocalHome.create();
			}
			catch (CreateException ex)
			{
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
			}

			//checks for users associated with groups
			userGroupProfileDomainDTO = userManagerLocal.findUserForGroup(groupCustomDTO.getName());
			if (userGroupProfileDomainDTO.getUserGroupProfileDomainDTOList().size() > 0)
			{
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0211);
			}

			GroupBOFactory groupBOFactory = new GroupBOFactory();
			String groupName=groupCustomDTO.getName();
			try
			{
				groupBOFactory.removeGroup(groupCustomDTO.getName());
			}
			catch (DomainException ex)
			{
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}
			String message= "Geo Security officer "+groupCustomDTO.getUserId() + " successfully removed the group " +groupName + "!";
			System.out.println("GroupManagerBean.createGroup()"+groupCustomDTO.getUserId() );
			createActivityLog(groupCustomDTO.getUserId(),message);
			return groupCustomDTO;
		}
		catch (ServiceException ex)
		{
			throw ex;
		}
		finally
		{
			timeTaken.end();
		}
	}

	/**
	 *  
	 * This method goes to the factory and Lists groups for Sales Org
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return GroupsCustomDTO
	 * @throws ServiceException
	 * @param GroupsCustomDTO
	 * 
	 */
	public GroupsCustomDTO listGroupsInSalesOrg(GroupsCustomDTO groupsCustom) throws ServiceException
	{
		String methodName = "listGroupsInSalesOrg";
		ErrorReport errorReport = null;
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);
		try
		{
			GroupBOFactory groupBOFactory = new GroupBOFactory();

			String primarySalesOrg = groupsCustom.getSelectedSalesArea();
			TreeMap salesOrgMap = groupsCustom.getSalesAreas();

			if (salesOrgMap == null || primarySalesOrg == null)
			{
				ProfileInputBOFactory profileInputBOFactory = new ProfileInputBOFactory();
				ProfileInputBO profileInputBO = null;

				try
				{
					profileInputBO = profileInputBOFactory.getSalesOrg();
				}
				catch (DomainException ex)
				{
					OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
					throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
				}

				salesOrgMap = new TreeMap();

				List salesOrgList = profileInputBO.getSalesOrgList();
				SalesOrgBDO salesOrgBDO;

				for (int i = 0; i < salesOrgList.size(); i++)
				{
					salesOrgBDO = (SalesOrgBDO) salesOrgList.get(i);
					salesOrgMap.put(salesOrgBDO.getSalesOrg(), salesOrgBDO.getSalesOrgDesc());
				}
				groupsCustom.setSalesAreas(salesOrgMap);
			}

			List groupList = null;

			try
			{
				groupList = groupBOFactory.findGroupBOForSalesOrg(primarySalesOrg);
			}
			catch (DomainException ex)
			{
				OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}

			if (groupList.size() == 0)
			{
				//throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0203);
				errorReport = new ErrorReport();
				errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.SE0203,OPPTMessageCatalog.TYPE_SERVICE), null);			
				groupsCustom.setMessageReport(errorReport);
				return groupsCustom;
			}

			Iterator iter = groupList.iterator();
			GroupsCustomDTO groupsCustomDTO;

			GroupBO groupBO;
			ArrayList groupsCustomList = new ArrayList();

			while (iter.hasNext())
			{
				groupBO = (GroupBO) iter.next();
				groupsCustomList.add(groupBO.getGroupName());
			}

			groupsCustom.setGroups(groupsCustomList);

			return groupsCustom;
		}
		catch (ServiceException ex)
		{
			throw ex;
		}
		finally
		{
			timeTaken.end();
		}
	}

	/**
	 *  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 * @throws 
	 * @param 
	 * 
	 */
	public void getUsersOfGroup() throws ServiceException
	{
	}
	

//creating activity Log added by Nomita
	private void createActivityLog(String userID,
			String message) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "createActivityLog");
		ActivityLogBO activityLogBO = new ActivityLogBO();
		activityLogBO.setUserId(userID);
		activityLogBO.setMessage(message);
		try {
			iActivityLogBOFactory.create(activityLogBO);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e
					.getErrorReport());
		} finally {
			timeTaken.end();
		}
	}
	
	// added by Nomita
	
}