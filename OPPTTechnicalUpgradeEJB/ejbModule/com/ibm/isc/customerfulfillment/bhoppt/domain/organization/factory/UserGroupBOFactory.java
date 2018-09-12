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
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.UserGroupBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.UserGroupLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Apr 19, 2005 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */
public class UserGroupBOFactory {

	private static final String CLASS_NAME = "UserGroupBOFactory";
	private static final String EXCEPTION = "EXCEPTION";

	public UserGroupBOFactory() {
	}

	public void createUserGroupBO(UserGroupBO userGroupBO) throws DomainException {
		String methodName = "createUserGroupBO";
		UserGroupLocalHome userGroupLocalHome = (UserGroupLocalHome) HomeProvider.getLocal(HomeProvider.USER_GROUP_LOCAL_HOME);
		UserGroupLocal userGroupLocal;

		try {
			userGroupLocal = userGroupLocalHome.create(userGroupBO.getUserId(), userGroupBO.getGroupName());
		} catch (CreateException ex) {
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
	}

	public List findUserGroupBO(String userId)  {
		String methodName = "createUserGroupBO";
		UserGroupLocalHome userGroupLocalHome = (UserGroupLocalHome) HomeProvider.getLocal(HomeProvider.USER_GROUP_LOCAL_HOME);
		List userGroupList = new ArrayList();
		
		try {
			Collection userGroupLocalCollection = userGroupLocalHome.findByUser(userId);
			Iterator userGroupLocalIter = userGroupLocalCollection.iterator();
			while(userGroupLocalIter.hasNext()) {
				UserGroupLocal userGroupLocal = (UserGroupLocal)userGroupLocalIter.next();
				UserGroupBO userGroupBO = new UserGroupBO();
				userGroupBO.setUserId(OPPTHelper.trimString(userGroupLocal.getUserId()));
				userGroupBO.setGroupName(OPPTHelper.trimString(userGroupLocal.getGroupName()));
				userGroupList.add(userGroupBO);   	
			}
		} catch (FinderException ex) {
			// This means the user dose not belong to any Group			
		}
		
		return userGroupList;
	}
	
	
	public List findUserforGroup(String groupName) {
		String methodName = "createUserGroupBO";
		UserGroupLocalHome userGroupLocalHome = (UserGroupLocalHome) HomeProvider.getLocal(HomeProvider.USER_GROUP_LOCAL_HOME);
		List userGroupList = new ArrayList();
		
		try {
			Collection userGroupLocalCollection = userGroupLocalHome.findByGroup(groupName);
			Iterator userGroupLocalIter = userGroupLocalCollection.iterator();
			while(userGroupLocalIter.hasNext()) {
				UserGroupLocal userGroupLocal = (UserGroupLocal)userGroupLocalIter.next();
				UserGroupBO userGroupBO = new UserGroupBO();
				userGroupBO.setUserId(OPPTHelper.trimString(userGroupLocal.getUserId()));
				userGroupBO.setGroupName(OPPTHelper.trimString(userGroupLocal.getGroupName()));
				userGroupList.add(userGroupBO);   	
			}
		} catch (FinderException ex) {
			// This means the user dose not belong to any Group			
		}
		
		return userGroupList;
	}
	
	public List deleteUserGroups(String userId)  {
		String methodName = "deleteUserGroups";
		UserGroupLocalHome userGroupLocalHome = (UserGroupLocalHome) HomeProvider.getLocal(HomeProvider.USER_GROUP_LOCAL_HOME);
		List userGroupList = new ArrayList();
		
		try {
			Collection userGroupLocalCollection = userGroupLocalHome.findByUser(userId);
			Iterator userGroupLocalIter = userGroupLocalCollection.iterator();
			while(userGroupLocalIter.hasNext()) {
				UserGroupLocal userGroupLocal = (UserGroupLocal)userGroupLocalIter.next();
				try {
					userGroupLocal.remove();
				} catch (EJBException e) {
					// TODO Auto-generated catch block
					
				} catch (RemoveException e) {
					// TODO Auto-generated catch block
					
				}
			}
		} catch (FinderException ex) {
			// This means the user dose not belong to any Group			
		}
		
		return userGroupList;
	}
	
	


	

}
