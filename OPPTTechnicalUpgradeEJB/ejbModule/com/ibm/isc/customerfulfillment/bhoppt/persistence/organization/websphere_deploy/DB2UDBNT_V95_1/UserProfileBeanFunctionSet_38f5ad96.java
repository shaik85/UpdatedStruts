package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * UserProfileBeanFunctionSet_38f5ad96
 */
public class UserProfileBeanFunctionSet_38f5ad96 extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO BH.USERPROFILE (USER_ID, ROLE, ASSO_SALES_ORG, AUTHORIZATION, APPROVER_ID, GROUP_NAME, BP_ACCESS_INDICATOR, LAST_LOGIN_DATE, FIRST_NAME, LAST_NAME, BA_ROLE, USER_TYPE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ROLE
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column ASSO_SALES_ORG
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.CHAR);
			}
			// For column AUTHORIZATION
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.CHAR);
			}
			// For column APPROVER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column GROUP_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column BP_ACCESS_INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			// For column LAST_LOGIN_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(7);
				if(tempDate != null)
					pstmt.setDate(8,tempDate);
				else
					pstmt.setNull(8,java.sql.Types.DATE);
			}
			// For column FIRST_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column LAST_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column BA_ROLE
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.CHAR);
			}
			// For column USER_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.CHAR);
			}
			if (executeUpdate(connection, pstmt, CreateQuery_0)==0)
				throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	private static String RemoveQuery_0 = "DELETE FROM BH.USERPROFILE  WHERE USER_ID = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			if (executeUpdate(connection, pstmt, RemoveQuery_0)==0)
				throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	private static String StoreQuery_0 = "UPDATE BH.USERPROFILE  SET ROLE = ?, ASSO_SALES_ORG = ?, AUTHORIZATION = ?, APPROVER_ID = ?, GROUP_NAME = ?, BP_ACCESS_INDICATOR = ?, LAST_LOGIN_DATE = ?, FIRST_NAME = ?, LAST_NAME = ?, BA_ROLE = ?, USER_TYPE = ? WHERE USER_ID = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
			}
			// For column ROLE
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column ASSO_SALES_ORG
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column AUTHORIZATION
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.CHAR);
			}
			// For column APPROVER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.CHAR);
			}
			// For column GROUP_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column BP_ACCESS_INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column LAST_LOGIN_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(7);
				if(tempDate != null)
					pstmt.setDate(7,tempDate);
				else
					pstmt.setNull(7,java.sql.Types.DATE);
			}
			// For column FIRST_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column LAST_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column BA_ROLE
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column USER_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.CHAR);
			}
			if (executeUpdate(connection, pstmt, StoreQuery_0)==0)
				throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	private static String StoreOCCQuery_0 = "UPDATE BH.USERPROFILE  SET ROLE = ?, ASSO_SALES_ORG = ?, AUTHORIZATION = ?, APPROVER_ID = ?, GROUP_NAME = ?, BP_ACCESS_INDICATOR = ?, LAST_LOGIN_DATE = ?, FIRST_NAME = ?, LAST_NAME = ?, BA_ROLE = ?, USER_TYPE = ? WHERE USER_ID = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
			}
			// For column ROLE
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column ASSO_SALES_ORG
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column AUTHORIZATION
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.CHAR);
			}
			// For column APPROVER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.CHAR);
			}
			// For column GROUP_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column BP_ACCESS_INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column LAST_LOGIN_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(7);
				if(tempDate != null)
					pstmt.setDate(7,tempDate);
				else
					pstmt.setNull(7,java.sql.Types.DATE);
			}
			// For column FIRST_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column LAST_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column BA_ROLE
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column USER_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.CHAR);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			if (executeUpdate(connection, pstmt, StoreOCCQuery_0)==0)
				throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	private static String findAllForSalesOrgAndRoleQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"ASSO_SALES_ORG\" = ?)  and  ( q1.\"ROLE\" = ?) ";
	/**
	 * FindAllForSalesOrgAndRole
	 */
	public javax.resource.cci.Record FindAllForSalesOrgAndRole(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where o.assoSalesOrg = ?1 and o.role = ?2 */
			pstmt = prepareStatement(connection, findAllForSalesOrgAndRoleQuery_0);

			// For ?1 (salesOrg)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (role)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllForSalesOrgAndRoleQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findAllForSalesOrgAndRoleForUpdateQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"ASSO_SALES_ORG\" = ?)  and  ( q1.\"ROLE\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindAllForSalesOrgAndRole444Update
	 */
	public javax.resource.cci.Record FindAllForSalesOrgAndRole444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where o.assoSalesOrg = ?1 and o.role = ?2 */
			pstmt = prepareStatement(connection, findAllForSalesOrgAndRoleForUpdateQuery_0);

			// For ?1 (salesOrg)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (role)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllForSalesOrgAndRoleForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findAllForSalesOrgAndRoleForUpdateWithRRQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"ASSO_SALES_ORG\" = ?)  and  ( q1.\"ROLE\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindAllForSalesOrgAndRoleForUpdateWithRR
	 */
	public javax.resource.cci.Record FindAllForSalesOrgAndRoleForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where o.assoSalesOrg = ?1 and o.role = ?2 */
			pstmt = prepareStatement(connection, findAllForSalesOrgAndRoleForUpdateWithRRQuery_0);

			// For ?1 (salesOrg)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (role)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllForSalesOrgAndRoleForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findAllForSalesOrgAndRoleForUpdateWithRSQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"ASSO_SALES_ORG\" = ?)  and  ( q1.\"ROLE\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindAllForSalesOrgAndRoleForUpdateWithRS
	 */
	public javax.resource.cci.Record FindAllForSalesOrgAndRoleForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where o.assoSalesOrg = ?1 and o.role = ?2 */
			pstmt = prepareStatement(connection, findAllForSalesOrgAndRoleForUpdateWithRSQuery_0);

			// For ?1 (salesOrg)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (role)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findAllForSalesOrgAndRoleForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findBySalesOrgQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"ASSO_SALES_ORG\" = ?) ";
	/**
	 * FindBySalesOrg
	 */
	public javax.resource.cci.Record FindBySalesOrg(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where  o.assoSalesOrg = ?1 */
			pstmt = prepareStatement(connection, findBySalesOrgQuery_0);

			// For ?1 (salesOrg)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySalesOrgQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findBySalesOrgForUpdateQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"ASSO_SALES_ORG\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySalesOrg444Update
	 */
	public javax.resource.cci.Record FindBySalesOrg444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where  o.assoSalesOrg = ?1 */
			pstmt = prepareStatement(connection, findBySalesOrgForUpdateQuery_0);

			// For ?1 (salesOrg)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySalesOrgForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findBySalesOrgForUpdateWithRRQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"ASSO_SALES_ORG\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySalesOrgForUpdateWithRR
	 */
	public javax.resource.cci.Record FindBySalesOrgForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where  o.assoSalesOrg = ?1 */
			pstmt = prepareStatement(connection, findBySalesOrgForUpdateWithRRQuery_0);

			// For ?1 (salesOrg)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySalesOrgForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findBySalesOrgForUpdateWithRSQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"ASSO_SALES_ORG\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySalesOrgForUpdateWithRS
	 */
	public javax.resource.cci.Record FindBySalesOrgForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where  o.assoSalesOrg = ?1 */
			pstmt = prepareStatement(connection, findBySalesOrgForUpdateWithRSQuery_0);

			// For ?1 (salesOrg)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySalesOrgForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByGroupNameQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"GROUP_NAME\" = ?) ";
	/**
	 * FindByGroupName
	 */
	public javax.resource.cci.Record FindByGroupName(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where  o.groupName = ?1 */
			pstmt = prepareStatement(connection, findByGroupNameQuery_0);

			// For ?1 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByGroupNameQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByGroupNameForUpdateQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"GROUP_NAME\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByGroupName444Update
	 */
	public javax.resource.cci.Record FindByGroupName444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where  o.groupName = ?1 */
			pstmt = prepareStatement(connection, findByGroupNameForUpdateQuery_0);

			// For ?1 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByGroupNameForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByGroupNameForUpdateWithRRQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"GROUP_NAME\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByGroupNameForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByGroupNameForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where  o.groupName = ?1 */
			pstmt = prepareStatement(connection, findByGroupNameForUpdateWithRRQuery_0);

			// For ?1 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByGroupNameForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByGroupNameForUpdateWithRSQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"GROUP_NAME\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByGroupNameForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByGroupNameForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where  o.groupName = ?1 */
			pstmt = prepareStatement(connection, findByGroupNameForUpdateWithRSQuery_0);

			// For ?1 (groupName)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByGroupNameForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.USER_ID, T1.ROLE, T1.ASSO_SALES_ORG, T1.AUTHORIZATION, T1.APPROVER_ID, T1.GROUP_NAME, T1.BP_ACCESS_INDICATOR, T1.LAST_LOGIN_DATE, T1.FIRST_NAME, T1.LAST_NAME, T1.BA_ROLE, T1.USER_TYPE FROM BH.USERPROFILE  T1 WHERE T1.USER_ID = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, FindByPrimaryKeyQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.USER_ID, T1.ROLE, T1.ASSO_SALES_ORG, T1.AUTHORIZATION, T1.APPROVER_ID, T1.GROUP_NAME, T1.BP_ACCESS_INDICATOR, T1.LAST_LOGIN_DATE, T1.FIRST_NAME, T1.LAST_NAME, T1.BA_ROLE, T1.USER_TYPE FROM BH.USERPROFILE  T1 WHERE T1.USER_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, FindByPrimaryKeyForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String FindByPrimaryKeyForUpdateWithRRQuery_0 = " SELECT T1.USER_ID, T1.ROLE, T1.ASSO_SALES_ORG, T1.AUTHORIZATION, T1.APPROVER_ID, T1.GROUP_NAME, T1.BP_ACCESS_INDICATOR, T1.LAST_LOGIN_DATE, T1.FIRST_NAME, T1.LAST_NAME, T1.BA_ROLE, T1.USER_TYPE FROM BH.USERPROFILE  T1 WHERE T1.USER_ID = ? FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRRQuery_0);

			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, FindByPrimaryKeyForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String FindByPrimaryKeyForUpdateWithRSQuery_0 = " SELECT T1.USER_ID, T1.ROLE, T1.ASSO_SALES_ORG, T1.AUTHORIZATION, T1.APPROVER_ID, T1.GROUP_NAME, T1.BP_ACCESS_INDICATOR, T1.LAST_LOGIN_DATE, T1.FIRST_NAME, T1.LAST_NAME, T1.BA_ROLE, T1.USER_TYPE FROM BH.USERPROFILE  T1 WHERE T1.USER_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRSQuery_0);

			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, FindByPrimaryKeyForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByRoleQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"ROLE\" = ? or  q1.\"ROLE\" = ?) ";
	/**
	 * FindByRole
	 */
	public javax.resource.cci.Record FindByRole(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where o.role  in (?1, ?2) */
			pstmt = prepareStatement(connection, findByRoleQuery_0);

			// For ?1 (userid1)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (userid2)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByRoleQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByRoleForUpdateQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"ROLE\" = ? or  q1.\"ROLE\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByRole444Update
	 */
	public javax.resource.cci.Record FindByRole444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where o.role  in (?1, ?2) */
			pstmt = prepareStatement(connection, findByRoleForUpdateQuery_0);

			// For ?1 (userid1)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (userid2)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByRoleForUpdateQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByRoleForUpdateWithRRQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"ROLE\" = ? or  q1.\"ROLE\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByRoleForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByRoleForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where o.role  in (?1, ?2) */
			pstmt = prepareStatement(connection, findByRoleForUpdateWithRRQuery_0);

			// For ?1 (userid1)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (userid2)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByRoleForUpdateWithRRQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	private static String findByRoleForUpdateWithRSQuery_0 = " select  q1.\"USER_ID\",  q1.\"ROLE\",  q1.\"ASSO_SALES_ORG\",  q1.\"AUTHORIZATION\",  q1.\"APPROVER_ID\",  q1.\"GROUP_NAME\",  q1.\"BP_ACCESS_INDICATOR\",  q1.\"LAST_LOGIN_DATE\",  q1.\"FIRST_NAME\",  q1.\"LAST_NAME\",  q1.\"BA_ROLE\",  q1.\"USER_TYPE\" from BH.USERPROFILE q1 where  ( q1.\"ROLE\" = ? or  q1.\"ROLE\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByRoleForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByRoleForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from UserProfile o where o.role  in (?1, ?2) */
			pstmt = prepareStatement(connection, findByRoleForUpdateWithRSQuery_0);

			// For ?1 (userid1)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (userid2)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByRoleForUpdateWithRSQuery_0);

		}
		catch (java.lang.Throwable e) {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored){}
			throw createResourceException(e, this.getClass());
		}
		return createCCIRecord(connection, result);
	}
	/**
	 * UserProfileBeanFunctionSet_38f5ad96
	 */
	public UserProfileBeanFunctionSet_38f5ad96() {
		functionHash=new java.util.HashMap(28);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindAllForSalesOrgAndRole",new Integer(4));
		functionHash.put("FindAllForSalesOrgAndRole444Update",new Integer(5));
		functionHash.put("FindAllForSalesOrgAndRoleForUpdateWithRR",new Integer(6));
		functionHash.put("FindAllForSalesOrgAndRoleForUpdateWithRS",new Integer(7));
		functionHash.put("FindBySalesOrg",new Integer(8));
		functionHash.put("FindBySalesOrg444Update",new Integer(9));
		functionHash.put("FindBySalesOrgForUpdateWithRR",new Integer(10));
		functionHash.put("FindBySalesOrgForUpdateWithRS",new Integer(11));
		functionHash.put("FindByGroupName",new Integer(12));
		functionHash.put("FindByGroupName444Update",new Integer(13));
		functionHash.put("FindByGroupNameForUpdateWithRR",new Integer(14));
		functionHash.put("FindByGroupNameForUpdateWithRS",new Integer(15));
		functionHash.put("FindByPrimaryKey",new Integer(16));
		functionHash.put("FindByPrimaryKey444Update",new Integer(17));
		functionHash.put("FindByPrimaryKeyForUpdateWithRR",new Integer(18));
		functionHash.put("FindByPrimaryKeyForUpdateWithRS",new Integer(19));
		functionHash.put("FindByRole",new Integer(20));
		functionHash.put("FindByRole444Update",new Integer(21));
		functionHash.put("FindByRoleForUpdateWithRR",new Integer(22));
		functionHash.put("FindByRoleForUpdateWithRS",new Integer(23));
		functionHash.put("ReadReadChecking",new Integer(24));
		functionHash.put("ReadReadCheckingForUpdate",new Integer(25));
		functionHash.put("PartialStore",new Integer(26));
		functionHash.put("PartialStoreUsingOCC",new Integer(27));
	}
	/**
	 * execute
	 */
	public Record execute(WSInteractionSpec interactionSpec, IndexedRecord inputRecord, Object connection) throws javax.resource.ResourceException {
		String functionName=interactionSpec.getFunctionName();
		Record outputRecord=null;
		int functionIndex=((Integer)functionHash.get(functionName)).intValue();

		switch (functionIndex) {
		case 0:
			Create(inputRecord,connection,interactionSpec);
			break;
		case 1:
			Remove(inputRecord,connection,interactionSpec);
			break;
		case 2:
			Store(inputRecord,connection,interactionSpec);
			break;
		case 3:
			StoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		case 4:
			outputRecord=FindAllForSalesOrgAndRole(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindAllForSalesOrgAndRole444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindAllForSalesOrgAndRoleForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindAllForSalesOrgAndRoleForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=FindBySalesOrg(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindBySalesOrg444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=FindBySalesOrgForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=FindBySalesOrgForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 12:
			outputRecord=FindByGroupName(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=FindByGroupName444Update(inputRecord,connection,interactionSpec);
			break;
		case 14:
			outputRecord=FindByGroupNameForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 15:
			outputRecord=FindByGroupNameForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 16:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 17:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 18:
			outputRecord=FindByPrimaryKeyForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 19:
			outputRecord=FindByPrimaryKeyForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 20:
			outputRecord=FindByRole(inputRecord,connection,interactionSpec);
			break;
		case 21:
			outputRecord=FindByRole444Update(inputRecord,connection,interactionSpec);
			break;
		case 22:
			outputRecord=FindByRoleForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 23:
			outputRecord=FindByRoleForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 24:
			ReadReadChecking(inputRecord,connection,interactionSpec);
			break;
		case 25:
			ReadReadCheckingForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 26:
			PartialStore(inputRecord,connection,interactionSpec);
			break;
		case 27:
			PartialStoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		}
		return outputRecord;
	}
	private static String ReadReadQuery_0 = " SELECT 1 FROM BH.USERPROFILE  T1 WHERE T1.USER_ID = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			executeQuery(connection, pstmt, ReadReadQuery_0);

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM BH.USERPROFILE  T1 WHERE T1.USER_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			executeQuery(connection, pstmt, ReadReadForUpdateQuery_0);

		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	/**
	 * initializeUpdateTemplates
	 */
	private void initializeUpdateTemplates() throws javax.resource.ResourceException {
		updateTemplateList = UserProfileBeanPartialUpdateQueryHelper.getUpdateTemplates();
	}
	private java.util.List updateTemplateList = null;
	/**
	 * PartialStore
	 */
	public void PartialStore(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			boolean[] changedFieldIndexes = interactionSpec.getChangedFieldsIndexes();
			if (updateTemplateList == null)
				initializeUpdateTemplates();
			{
				com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate aTemplate = (com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate) updateTemplateList.get(0);
				String updateQuery = aTemplate.nativeQuery(changedFieldIndexes);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[1])
					{
						// For column ROLE
						String tempString;


						tempString=(String)inputRecord.get(1);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[2])
					{
						// For column ASSO_SALES_ORG
						String tempString;


						tempString=(String)inputRecord.get(2);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[3])
					{
						// For column AUTHORIZATION
						String tempString;


						tempString=(String)inputRecord.get(3);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column APPROVER_ID
						String tempString;


						tempString=(String)inputRecord.get(4);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column GROUP_NAME
						String tempString;


						tempString=(String)inputRecord.get(5);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[6])
					{
						// For column BP_ACCESS_INDICATOR
						String tempString;


						tempString=(String)inputRecord.get(6);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column LAST_LOGIN_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(7);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column FIRST_NAME
						String tempString;


						tempString=(String)inputRecord.get(8);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[9])
					{
						// For column LAST_NAME
						String tempString;


						tempString=(String)inputRecord.get(9);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column BA_ROLE
						String tempString;


						tempString=(String)inputRecord.get(10);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column USER_TYPE
						String tempString;


						tempString=(String)inputRecord.get(11);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column USER_ID
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					if (executeUpdate(connection, pstmt, updateQuery)==0)
						throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

				}
			}
		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
	/**
	 * PartialStoreUsingOCC
	 */
	public void PartialStoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			boolean[] changedFieldIndexes = interactionSpec.getChangedFieldsIndexes();
			if (updateTemplateList == null)
				initializeUpdateTemplates();
			{
				com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate aTemplate = (com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate) updateTemplateList.get(0);
				String updateQuery = aTemplate.nativeQuery(changedFieldIndexes);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[1])
					{
						// For column ROLE
						String tempString;


						tempString=(String)inputRecord.get(1);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[2])
					{
						// For column ASSO_SALES_ORG
						String tempString;


						tempString=(String)inputRecord.get(2);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[3])
					{
						// For column AUTHORIZATION
						String tempString;


						tempString=(String)inputRecord.get(3);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column APPROVER_ID
						String tempString;


						tempString=(String)inputRecord.get(4);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column GROUP_NAME
						String tempString;


						tempString=(String)inputRecord.get(5);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[6])
					{
						// For column BP_ACCESS_INDICATOR
						String tempString;


						tempString=(String)inputRecord.get(6);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column LAST_LOGIN_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(7);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column FIRST_NAME
						String tempString;


						tempString=(String)inputRecord.get(8);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[9])
					{
						// For column LAST_NAME
						String tempString;


						tempString=(String)inputRecord.get(9);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column BA_ROLE
						String tempString;


						tempString=(String)inputRecord.get(10);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column USER_TYPE
						String tempString;


						tempString=(String)inputRecord.get(11);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column USER_ID
						String tempString;


						tempString=(String)inputRecord.get(0);
						pstmt.setString(stmtIndex,tempString);
							stmtIndex++;

					}
					if (executeUpdate(connection, pstmt, updateQuery)==0)
						throw createResourceException(new javax.ejb.NoSuchEntityException(), this.getClass());

				}
			}
		}
		catch (SQLException e) {
			throw createResourceException(e, this.getClass());
		}
		finally {
			try {
				if(pstmt != null) {
					returnPreparedStatement(connection, pstmt);
				}
			}
			catch (SQLException ignored)
			{}
		}
	}
}
