package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * ErrorListBeanFunctionSet_889e0b9b
 */
public class ErrorListBeanFunctionSet_889e0b9b extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO BH.ERRORLIST (MESSAGE_ID, PROPOSAL_ID, MSG_NO, CLASS_NAME, METHOD_NAME, MSG_DESC, MSG_DETAIL, USER_ID, DATE, TIME) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column MESSAGE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column MSG_NO
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(2);
				if(tempDouble != null)
					pstmt.setDouble(3,tempDouble.doubleValue());
				else
					pstmt.setNull(3,java.sql.Types.DECIMAL);
			}
			// For column CLASS_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column METHOD_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For column MSG_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column MSG_DETAIL
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(8);
				if(tempDate != null)
					pstmt.setDate(9,tempDate);
				else
					pstmt.setNull(9,java.sql.Types.DATE);
			}
			// For column TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(9);
				if(tempTime != null)
					pstmt.setTime(10,tempTime);
				else
					pstmt.setNull(10,java.sql.Types.TIME);
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
	private static String RemoveQuery_0 = "DELETE FROM BH.ERRORLIST  WHERE MESSAGE_ID = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column MESSAGE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
	private static String StoreQuery_0 = "UPDATE BH.ERRORLIST  SET PROPOSAL_ID = ?, MSG_NO = ?, CLASS_NAME = ?, METHOD_NAME = ?, MSG_DESC = ?, MSG_DETAIL = ?, USER_ID = ?, DATE = ?, TIME = ? WHERE MESSAGE_ID = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column MESSAGE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column MSG_NO
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(2);
				if(tempDouble != null)
					pstmt.setDouble(2,tempDouble.doubleValue());
				else
					pstmt.setNull(2,java.sql.Types.DECIMAL);
			}
			// For column CLASS_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column METHOD_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column MSG_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column MSG_DETAIL
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			// For column DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(8);
				if(tempDate != null)
					pstmt.setDate(8,tempDate);
				else
					pstmt.setNull(8,java.sql.Types.DATE);
			}
			// For column TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(9);
				if(tempTime != null)
					pstmt.setTime(9,tempTime);
				else
					pstmt.setNull(9,java.sql.Types.TIME);
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
	private static String StoreOCCQuery_0 = "UPDATE BH.ERRORLIST  SET PROPOSAL_ID = ?, MSG_NO = ?, CLASS_NAME = ?, METHOD_NAME = ?, MSG_DESC = ?, MSG_DETAIL = ?, USER_ID = ?, DATE = ?, TIME = ? WHERE MESSAGE_ID = ? AND PROPOSAL_ID = ? AND MSG_NO = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column MESSAGE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column MSG_NO
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(2);
				if(tempDouble != null)
					pstmt.setDouble(2,tempDouble.doubleValue());
				else
					pstmt.setNull(2,java.sql.Types.DECIMAL);
			}
			// For column CLASS_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column METHOD_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column MSG_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column MSG_DETAIL
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			// For column DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(8);
				if(tempDate != null)
					pstmt.setDate(8,tempDate);
				else
					pstmt.setNull(8,java.sql.Types.DATE);
			}
			// For column TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(9);
				if(tempTime != null)
					pstmt.setTime(9,tempTime);
				else
					pstmt.setNull(9,java.sql.Types.TIME);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)oldRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(11,tempInteger.intValue());
				else
					pstmt.setNull(11,java.sql.Types.INTEGER);
			}
			// For column MSG_NO
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(2);
				if(tempDouble != null)
					pstmt.setDouble(12,tempDouble.doubleValue());
				else
					pstmt.setNull(12,java.sql.Types.DECIMAL);
			}
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
	private static String findByProposalIdQuery_0 = " select  q1.\"MESSAGE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"MSG_NO\",  q1.\"CLASS_NAME\",  q1.\"METHOD_NAME\",  q1.\"MSG_DESC\",  q1.\"MSG_DETAIL\",  q1.\"USER_ID\",  q1.\"DATE\",  q1.\"TIME\" from BH.ERRORLIST q1 where  ( q1.\"PROPOSAL_ID\" = ?) ";
	/**
	 * FindByProposalId
	 */
	public javax.resource.cci.Record FindByProposalId(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from ErrorList o where o.proposalId = ?1 */
			pstmt = prepareStatement(connection, findByProposalIdQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByProposalIdQuery_0);

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
	private static String findByProposalIdForUpdateQuery_0 = " select  q1.\"MESSAGE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"MSG_NO\",  q1.\"CLASS_NAME\",  q1.\"METHOD_NAME\",  q1.\"MSG_DESC\",  q1.\"MSG_DETAIL\",  q1.\"USER_ID\",  q1.\"DATE\",  q1.\"TIME\" from BH.ERRORLIST q1 where  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalId444Update
	 */
	public javax.resource.cci.Record FindByProposalId444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from ErrorList o where o.proposalId = ?1 */
			pstmt = prepareStatement(connection, findByProposalIdForUpdateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByProposalIdForUpdateQuery_0);

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
	private static String findByProposalIdForUpdateWithRRQuery_0 = " select  q1.\"MESSAGE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"MSG_NO\",  q1.\"CLASS_NAME\",  q1.\"METHOD_NAME\",  q1.\"MSG_DESC\",  q1.\"MSG_DETAIL\",  q1.\"USER_ID\",  q1.\"DATE\",  q1.\"TIME\" from BH.ERRORLIST q1 where  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalIdForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByProposalIdForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from ErrorList o where o.proposalId = ?1 */
			pstmt = prepareStatement(connection, findByProposalIdForUpdateWithRRQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByProposalIdForUpdateWithRRQuery_0);

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
	private static String findByProposalIdForUpdateWithRSQuery_0 = " select  q1.\"MESSAGE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"MSG_NO\",  q1.\"CLASS_NAME\",  q1.\"METHOD_NAME\",  q1.\"MSG_DESC\",  q1.\"MSG_DETAIL\",  q1.\"USER_ID\",  q1.\"DATE\",  q1.\"TIME\" from BH.ERRORLIST q1 where  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalIdForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByProposalIdForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from ErrorList o where o.proposalId = ?1 */
			pstmt = prepareStatement(connection, findByProposalIdForUpdateWithRSQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByProposalIdForUpdateWithRSQuery_0);

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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.MESSAGE_ID, T1.PROPOSAL_ID, T1.MSG_NO, T1.CLASS_NAME, T1.METHOD_NAME, T1.MSG_DESC, T1.MSG_DETAIL, T1.USER_ID, T1.DATE, T1.TIME FROM BH.ERRORLIST  T1 WHERE T1.MESSAGE_ID = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column MESSAGE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.MESSAGE_ID, T1.PROPOSAL_ID, T1.MSG_NO, T1.CLASS_NAME, T1.METHOD_NAME, T1.MSG_DESC, T1.MSG_DETAIL, T1.USER_ID, T1.DATE, T1.TIME FROM BH.ERRORLIST  T1 WHERE T1.MESSAGE_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column MESSAGE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyForUpdateWithRRQuery_0 = " SELECT T1.MESSAGE_ID, T1.PROPOSAL_ID, T1.MSG_NO, T1.CLASS_NAME, T1.METHOD_NAME, T1.MSG_DESC, T1.MSG_DETAIL, T1.USER_ID, T1.DATE, T1.TIME FROM BH.ERRORLIST  T1 WHERE T1.MESSAGE_ID = ? FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRRQuery_0);

			// For column MESSAGE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyForUpdateWithRSQuery_0 = " SELECT T1.MESSAGE_ID, T1.PROPOSAL_ID, T1.MSG_NO, T1.CLASS_NAME, T1.METHOD_NAME, T1.MSG_DESC, T1.MSG_DETAIL, T1.USER_ID, T1.DATE, T1.TIME FROM BH.ERRORLIST  T1 WHERE T1.MESSAGE_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRSQuery_0);

			// For column MESSAGE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
	private static String findMaxQuery_0 = " select  q1.\"MESSAGE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"MSG_NO\",  q1.\"CLASS_NAME\",  q1.\"METHOD_NAME\",  q1.\"MSG_DESC\",  q1.\"MSG_DETAIL\",  q1.\"USER_ID\",  q1.\"DATE\",  q1.\"TIME\" from BH.ERRORLIST q1 where  ( q1.\"MESSAGE_ID\" =  ( select  max( q2.\"MESSAGE_ID\") from BH.ERRORLIST q2) ) ";
	/**
	 * FindMax
	 */
	public javax.resource.cci.Record FindMax(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from ErrorList o where  o.messageId = (select max(a.messageId) from ErrorList a) */
			pstmt = prepareStatement(connection, findMaxQuery_0);

			result = executeQuery(connection, pstmt, findMaxQuery_0);

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
	private static String findMaxForUpdateQuery_0 = " select  q1.\"MESSAGE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"MSG_NO\",  q1.\"CLASS_NAME\",  q1.\"METHOD_NAME\",  q1.\"MSG_DESC\",  q1.\"MSG_DETAIL\",  q1.\"USER_ID\",  q1.\"DATE\",  q1.\"TIME\" from BH.ERRORLIST q1 where  ( q1.\"MESSAGE_ID\" =  ( select  max( q2.\"MESSAGE_ID\") from BH.ERRORLIST q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMax444Update
	 */
	public javax.resource.cci.Record FindMax444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from ErrorList o where  o.messageId = (select max(a.messageId) from ErrorList a) */
			pstmt = prepareStatement(connection, findMaxForUpdateQuery_0);

			result = executeQuery(connection, pstmt, findMaxForUpdateQuery_0);

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
	private static String findMaxForUpdateWithRRQuery_0 = " select  q1.\"MESSAGE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"MSG_NO\",  q1.\"CLASS_NAME\",  q1.\"METHOD_NAME\",  q1.\"MSG_DESC\",  q1.\"MSG_DETAIL\",  q1.\"USER_ID\",  q1.\"DATE\",  q1.\"TIME\" from BH.ERRORLIST q1 where  ( q1.\"MESSAGE_ID\" =  ( select  max( q2.\"MESSAGE_ID\") from BH.ERRORLIST q2) )  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxForUpdateWithRR
	 */
	public javax.resource.cci.Record FindMaxForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from ErrorList o where  o.messageId = (select max(a.messageId) from ErrorList a) */
			pstmt = prepareStatement(connection, findMaxForUpdateWithRRQuery_0);

			result = executeQuery(connection, pstmt, findMaxForUpdateWithRRQuery_0);

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
	private static String findMaxForUpdateWithRSQuery_0 = " select  q1.\"MESSAGE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"MSG_NO\",  q1.\"CLASS_NAME\",  q1.\"METHOD_NAME\",  q1.\"MSG_DESC\",  q1.\"MSG_DETAIL\",  q1.\"USER_ID\",  q1.\"DATE\",  q1.\"TIME\" from BH.ERRORLIST q1 where  ( q1.\"MESSAGE_ID\" =  ( select  max( q2.\"MESSAGE_ID\") from BH.ERRORLIST q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxForUpdateWithRS
	 */
	public javax.resource.cci.Record FindMaxForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from ErrorList o where  o.messageId = (select max(a.messageId) from ErrorList a) */
			pstmt = prepareStatement(connection, findMaxForUpdateWithRSQuery_0);

			result = executeQuery(connection, pstmt, findMaxForUpdateWithRSQuery_0);

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
	 * ErrorListBeanFunctionSet_889e0b9b
	 */
	public ErrorListBeanFunctionSet_889e0b9b() {
		functionHash=new java.util.HashMap(20);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindByProposalId",new Integer(4));
		functionHash.put("FindByProposalId444Update",new Integer(5));
		functionHash.put("FindByProposalIdForUpdateWithRR",new Integer(6));
		functionHash.put("FindByProposalIdForUpdateWithRS",new Integer(7));
		functionHash.put("FindByPrimaryKey",new Integer(8));
		functionHash.put("FindByPrimaryKey444Update",new Integer(9));
		functionHash.put("FindByPrimaryKeyForUpdateWithRR",new Integer(10));
		functionHash.put("FindByPrimaryKeyForUpdateWithRS",new Integer(11));
		functionHash.put("FindMax",new Integer(12));
		functionHash.put("FindMax444Update",new Integer(13));
		functionHash.put("FindMaxForUpdateWithRR",new Integer(14));
		functionHash.put("FindMaxForUpdateWithRS",new Integer(15));
		functionHash.put("ReadReadChecking",new Integer(16));
		functionHash.put("ReadReadCheckingForUpdate",new Integer(17));
		functionHash.put("PartialStore",new Integer(18));
		functionHash.put("PartialStoreUsingOCC",new Integer(19));
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
			outputRecord=FindByProposalId(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindByProposalId444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindByProposalIdForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindByProposalIdForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=FindByPrimaryKeyForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=FindByPrimaryKeyForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 12:
			outputRecord=FindMax(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=FindMax444Update(inputRecord,connection,interactionSpec);
			break;
		case 14:
			outputRecord=FindMaxForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 15:
			outputRecord=FindMaxForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 16:
			ReadReadChecking(inputRecord,connection,interactionSpec);
			break;
		case 17:
			ReadReadCheckingForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 18:
			PartialStore(inputRecord,connection,interactionSpec);
			break;
		case 19:
			PartialStoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		}
		return outputRecord;
	}
	private static String ReadReadQuery_0 = " SELECT 1 FROM BH.ERRORLIST  T1 WHERE T1.MESSAGE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.MSG_NO = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column MESSAGE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column MSG_NO
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(2);
				if(tempDouble != null)
					pstmt.setDouble(3,tempDouble.doubleValue());
				else
					pstmt.setNull(3,java.sql.Types.DECIMAL);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM BH.ERRORLIST  T1 WHERE T1.MESSAGE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.MSG_NO = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column MESSAGE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column MSG_NO
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(2);
				if(tempDouble != null)
					pstmt.setDouble(3,tempDouble.doubleValue());
				else
					pstmt.setNull(3,java.sql.Types.DECIMAL);
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
		updateTemplateList = ErrorListBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(1);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[2])
					{
						// For column MSG_NO
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(2);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[3])
					{
						// For column CLASS_NAME
						String tempString;


						tempString=(String)inputRecord.get(3);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column METHOD_NAME
						String tempString;


						tempString=(String)inputRecord.get(4);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column MSG_DESC
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
						// For column MSG_DETAIL
						String tempString;


						tempString=(String)inputRecord.get(6);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column USER_ID
						String tempString;


						tempString=(String)inputRecord.get(7);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(8);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[9])
					{
						// For column TIME
						java.sql.Time tempTime;


						tempTime=(java.sql.Time)inputRecord.get(9);
						if(tempTime != null){
							pstmt.setTime(stmtIndex,tempTime);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIME);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column MESSAGE_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(0);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
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
				IndexedRecord oldRecord = interactionSpec.getOldRecord();
				Object[] oldValues = new Object[2];
				oldValues[0] = oldRecord.get(1);
				oldValues[1] = oldRecord.get(2);
				String updateQuery = aTemplate.nativeOptimisticQuery(changedFieldIndexes,oldValues);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[1])
					{
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(1);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[2])
					{
						// For column MSG_NO
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(2);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[3])
					{
						// For column CLASS_NAME
						String tempString;


						tempString=(String)inputRecord.get(3);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column METHOD_NAME
						String tempString;


						tempString=(String)inputRecord.get(4);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column MSG_DESC
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
						// For column MSG_DETAIL
						String tempString;


						tempString=(String)inputRecord.get(6);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column USER_ID
						String tempString;


						tempString=(String)inputRecord.get(7);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(8);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[9])
					{
						// For column TIME
						java.sql.Time tempTime;


						tempTime=(java.sql.Time)inputRecord.get(9);
						if(tempTime != null){
							pstmt.setTime(stmtIndex,tempTime);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIME);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column MESSAGE_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(0);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					// optimistic predicate columns
					{
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)oldValues[0];
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;
						}

					}
					{
						// For column MSG_NO
						Double tempDouble;


						tempDouble=(Double)oldValues[1];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

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
