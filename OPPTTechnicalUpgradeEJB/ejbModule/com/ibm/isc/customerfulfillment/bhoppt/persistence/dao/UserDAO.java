/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.UserProfileBO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ReverificationReportDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.ReverificationReportUserDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.DeletedUsersReportUserDomainDTO;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Sep 24, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1x
 */
public class UserDAO extends OPPTDAO {
	private static final String USER_REVERIFICATION_PROFILE = "select user_id, group_name, last_login_date, asso_sales_org, authorization,role, first_name,last_name,user_type,ba_role from BH.userprofile";
	private static final String DELETED_USER_PROFILE = "select user_id, group_name, deleted_date, asso_sales_org, authorization,role, first_name,last_name,user_type,deleted_admin_id from BH.deleted_userprofile where asso_sales_org =?";
	private static final String UPDATE_USERPROFILE = "update BH.userprofile set first_name=?,last_name=? where user_id=?";
	private static final String INSERT_DELETEDUSERPROFILE = "insert into  BH.deleted_userprofile values (?,?,?,?,?,?,?,?,?,?)";
	
	//	EF0621051852 - User Reverifcation Report, shows only the primary group.
	//	Changes starts from here : Thirumalaikumar
	private static final String USER_GROUPS = "select group_name from BH.usergroup where user_id=?";
    //	Changes end here
	private static final String CLASS_NAME = "UserDAO";
	
	public static ReverificationReportDomainDTO retriveDataForUserReverification(ReverificationReportDomainDTO domainDTO)
	{
		final String methodName = "retriveDataForUserReverification";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Map users = domainDTO.getUsers();
		if(null != users){
			try
			{
				connection = getConnection();
				preparedStatement = connection.prepareStatement(USER_REVERIFICATION_PROFILE);
				resultSet = preparedStatement.executeQuery();
			
				while (resultSet.next()){
					String userID = OPPTHelper.trimString(resultSet.getString("user_id"));
					if(null != userID){
						ReverificationReportUserDomainDTO user = (ReverificationReportUserDomainDTO)users.get(userID);
						if(null != user){
					  	    //EF0621051852 - Changes starts from here : Thirumalaikumar
							user.setGroupNames(getUserGroupNames(userID));
							// Changes end here
							user.setLastLogInDate(resultSet.getDate("last_login_date"));
							user.setPrimarySalesOrg(OPPTHelper.trimString(resultSet.getString("asso_sales_org")));
							user.setPrimaryAccessType(OPPTHelper.trimString(resultSet.getString("authorization")));
							user.setRole(OPPTHelper.trimString(resultSet.getString("role")));
							user.setFirstName(OPPTHelper.trimString(resultSet.getString("first_name")));
							user.setLastName(OPPTHelper.trimString(resultSet.getString("last_name")));
							user.setUserType(OPPTHelper.trimString(resultSet.getString("user_type")));
							user.setBa_role(OPPTHelper.trimString(resultSet.getString("ba_role")));
							user.setUserPresentInOPPT(true);
							user.removePrimarySalesOrg();
						}
					}
				}
			}
			catch(SQLException ex){
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			}
			finally{
				closeConnection(connection, resultSet, preparedStatement);
			}
		}

		return domainDTO;
	}
	
	public static ReverificationReportDomainDTO retriveDataForDeletedUsersReport(ReverificationReportDomainDTO domainDTO)
	{
		final String methodName = "retriveDataForDeletedUsersReport";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DeletedUsersReportUserDomainDTO user = null;
		
		String salesOrg = domainDTO.getSalesOrg();
		System.out.println("salesOrg salesOrg" +salesOrg);
		
		Map users = new TreeMap();
		List userList = new ArrayList();
		try
			{
				connection = getConnection();
				preparedStatement = connection.prepareStatement(DELETED_USER_PROFILE);
				preparedStatement.setString(1,salesOrg);
				resultSet = preparedStatement.executeQuery();
			
				while (resultSet.next()){
					user = new DeletedUsersReportUserDomainDTO();
					
					String userID = OPPTHelper.trimString(resultSet.getString("user_id"));
					System.out.println("User id"  +userID);
					user.setDeletedDate(resultSet.getTimestamp("deleted_date"));
					user.setPrimarySalesOrg(OPPTHelper.trimString(resultSet.getString("asso_sales_org")));
					user.setPrimaryAccessType(OPPTHelper.trimString(resultSet.getString("authorization")));
					user.setRole(OPPTHelper.trimString(resultSet.getString("role")));
					user.setFirstName(OPPTHelper.trimString(resultSet.getString("first_name")));
					user.setLastName(OPPTHelper.trimString(resultSet.getString("last_name")));
					user.setUserType(OPPTHelper.trimString(resultSet.getString("user_type")));
					user.setDeletedAdminEmail(OPPTHelper.trimString(resultSet.getString("deleted_admin_id")));
					user.setGroupName(OPPTHelper.trimString(resultSet.getString("group_name")));
					user.setUserID(userID);
					if (users.containsKey(userID)) {
					 userList = (ArrayList) users.get(userID);
					 userList.add(user);
					 System.out.println("User id size "+ userList.size() );
					} else {
						List newUser = new ArrayList();
						newUser.add(user);
						users.put(userID,newUser);
					}
				}
				domainDTO.setUsers(users);
			}
			catch(SQLException ex){
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			}
			finally{
				closeConnection(connection, resultSet, preparedStatement);
			}
			
			return domainDTO;
	}
	
	
	
	
	public static void updateUserProfile(String firstName,String lastName,String userID)
	{
		final String methodName = "updateUserProfile";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_USERPROFILE);
			preparedStatement.setString(1,firstName);
			preparedStatement.setString(2,lastName);
			preparedStatement.setString(3,userID);
			preparedStatement.executeUpdate();
		}
		catch(SQLException ex){
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
		}
		finally{
			closeConnection(connection, null, preparedStatement);
		}
	}
	
    //	EF0621051852 - User Reverifcation Report, shows only the primary group.
    //	Changes starts from here : Thirumalaikumar
	private static List getUserGroupNames(String userID)
	{
		final String methodName = "getUserGroupNames";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;
		ArrayList userList = new ArrayList();
		try
		{
			connection = getConnection();
			preparedStatement = connection.prepareStatement(USER_GROUPS);
			preparedStatement.setString(1,userID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				userList.add(OPPTHelper.trimString(resultSet.getString("group_name")));
			}
		}
		catch(SQLException ex){
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
		}
		finally{
			closeConnection(connection, null, preparedStatement);
		}
		return userList;
	}
    // Changes end here



	public static void insertDeletedUserProfile(UserProfileBO userProfileBO ,String deletedByAdmin, String firstName ,String lastName)
	{
		final String methodName = "insertDeletedUserProfile";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try
		{
			
			connection = getConnection();
			preparedStatement = connection.prepareStatement(INSERT_DELETEDUSERPROFILE);
			preparedStatement.setString(1,userProfileBO.getUserId());
			preparedStatement.setString(2,Integer.toString(userProfileBO.getRole()));
			preparedStatement.setString(3,userProfileBO.getPrimarySalesOrg());
			preparedStatement.setString(4,deletedByAdmin);
			preparedStatement.setString(5,userProfileBO.getAthorization());
			preparedStatement.setString(6,userProfileBO.getGroupName());
			Timestamp cuttentdate = new Timestamp(new Date().getTime());
			preparedStatement.setString(7,cuttentdate.toString());
			preparedStatement.setString(8,lastName);
			preparedStatement.setString(9,firstName);
			preparedStatement.setString(10,userProfileBO.getUserType());
			preparedStatement.executeUpdate();
			
		}
		catch(SQLException ex){
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
		}
		finally{
			closeConnection(connection, null, preparedStatement);
		}
	}

}
