package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * AccessHistoryBeanFunctionSet_1c91e0cb
 */
public class AccessHistoryBeanFunctionSet_1c91e0cb extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO BH.ACCESSHISTORY (USER_ID, ACCESS_DATE, ACCESS_TIME, SEQ_NO, PROPOSAL_ID, OPERATION_PERFORMED) VALUES (?, ?, ?, ?, ?, ?)";
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
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column OPERATION_PERFORMED
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.VARCHAR);
			}
			// For column ACCESS_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For column ACCESS_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(3);
				if(tempTime != null)
					pstmt.setTime(3,tempTime);
				else
					pstmt.setNull(3,java.sql.Types.TIME);
			}
			// For column SEQ_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
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
	private static String RemoveQuery_0 = "DELETE FROM BH.ACCESSHISTORY  WHERE USER_ID = ? AND ACCESS_DATE = ? AND ACCESS_TIME = ? AND SEQ_NO = ? AND PROPOSAL_ID = ?";
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
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column ACCESS_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For column ACCESS_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(3);
				if(tempTime != null)
					pstmt.setTime(3,tempTime);
				else
					pstmt.setNull(3,java.sql.Types.TIME);
			}
			// For column SEQ_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
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
	private static String StoreQuery_0 = "UPDATE BH.ACCESSHISTORY  SET OPERATION_PERFORMED = ? WHERE USER_ID = ? AND ACCESS_DATE = ? AND ACCESS_TIME = ? AND SEQ_NO = ? AND PROPOSAL_ID = ?";
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
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column OPERATION_PERFORMED
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ACCESS_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For column ACCESS_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(3);
				if(tempTime != null)
					pstmt.setTime(4,tempTime);
				else
					pstmt.setNull(4,java.sql.Types.TIME);
			}
			// For column SEQ_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
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
	private static String StoreOCCQuery_0 = "UPDATE BH.ACCESSHISTORY  SET OPERATION_PERFORMED = ? WHERE USER_ID = ? AND ACCESS_DATE = ? AND ACCESS_TIME = ? AND SEQ_NO = ? AND PROPOSAL_ID = ?";
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
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column OPERATION_PERFORMED
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column ACCESS_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For column ACCESS_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(3);
				if(tempTime != null)
					pstmt.setTime(4,tempTime);
				else
					pstmt.setNull(4,java.sql.Types.TIME);
			}
			// For column SEQ_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
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
	private static String findByProposalIDQuery_0 = " select  q1.\"USER_ID\",  q1.\"OPERATION_PERFORMED\",  q1.\"ACCESS_DATE\",  q1.\"ACCESS_TIME\",  q1.\"SEQ_NO\",  q1.\"PROPOSAL_ID\" from BH.ACCESSHISTORY q1 where  ( q1.\"PROPOSAL_ID\" = ?) ";
	/**
	 * FindByProposalID
	 */
	public javax.resource.cci.Record FindByProposalID(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from AccessHistory o where o.proposalId = ?1 */
			pstmt = prepareStatement(connection, findByProposalIDQuery_0);

			// For ?1 (proposalID)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByProposalIDQuery_0);

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
	private static String findByProposalIDForUpdateQuery_0 = " select  q1.\"USER_ID\",  q1.\"OPERATION_PERFORMED\",  q1.\"ACCESS_DATE\",  q1.\"ACCESS_TIME\",  q1.\"SEQ_NO\",  q1.\"PROPOSAL_ID\" from BH.ACCESSHISTORY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalID444Update
	 */
	public javax.resource.cci.Record FindByProposalID444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from AccessHistory o where o.proposalId = ?1 */
			pstmt = prepareStatement(connection, findByProposalIDForUpdateQuery_0);

			// For ?1 (proposalID)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByProposalIDForUpdateQuery_0);

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
	private static String findByProposalIDForUpdateWithRRQuery_0 = " select  q1.\"USER_ID\",  q1.\"OPERATION_PERFORMED\",  q1.\"ACCESS_DATE\",  q1.\"ACCESS_TIME\",  q1.\"SEQ_NO\",  q1.\"PROPOSAL_ID\" from BH.ACCESSHISTORY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalIDForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByProposalIDForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from AccessHistory o where o.proposalId = ?1 */
			pstmt = prepareStatement(connection, findByProposalIDForUpdateWithRRQuery_0);

			// For ?1 (proposalID)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByProposalIDForUpdateWithRRQuery_0);

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
	private static String findByProposalIDForUpdateWithRSQuery_0 = " select  q1.\"USER_ID\",  q1.\"OPERATION_PERFORMED\",  q1.\"ACCESS_DATE\",  q1.\"ACCESS_TIME\",  q1.\"SEQ_NO\",  q1.\"PROPOSAL_ID\" from BH.ACCESSHISTORY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalIDForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByProposalIDForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from AccessHistory o where o.proposalId = ?1 */
			pstmt = prepareStatement(connection, findByProposalIDForUpdateWithRSQuery_0);

			// For ?1 (proposalID)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByProposalIDForUpdateWithRSQuery_0);

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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.USER_ID, T1.OPERATION_PERFORMED, T1.ACCESS_DATE, T1.ACCESS_TIME, T1.SEQ_NO, T1.PROPOSAL_ID FROM BH.ACCESSHISTORY  T1 WHERE T1.USER_ID = ? AND T1.ACCESS_DATE = ? AND T1.ACCESS_TIME = ? AND T1.SEQ_NO = ? AND T1.PROPOSAL_ID = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column ACCESS_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For column ACCESS_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(3);
				if(tempTime != null)
					pstmt.setTime(3,tempTime);
				else
					pstmt.setNull(3,java.sql.Types.TIME);
			}
			// For column SEQ_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.USER_ID, T1.OPERATION_PERFORMED, T1.ACCESS_DATE, T1.ACCESS_TIME, T1.SEQ_NO, T1.PROPOSAL_ID FROM BH.ACCESSHISTORY  T1 WHERE T1.USER_ID = ? AND T1.ACCESS_DATE = ? AND T1.ACCESS_TIME = ? AND T1.SEQ_NO = ? AND T1.PROPOSAL_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column ACCESS_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For column ACCESS_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(3);
				if(tempTime != null)
					pstmt.setTime(3,tempTime);
				else
					pstmt.setNull(3,java.sql.Types.TIME);
			}
			// For column SEQ_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyForUpdateWithRRQuery_0 = " SELECT T1.USER_ID, T1.OPERATION_PERFORMED, T1.ACCESS_DATE, T1.ACCESS_TIME, T1.SEQ_NO, T1.PROPOSAL_ID FROM BH.ACCESSHISTORY  T1 WHERE T1.USER_ID = ? AND T1.ACCESS_DATE = ? AND T1.ACCESS_TIME = ? AND T1.SEQ_NO = ? AND T1.PROPOSAL_ID = ? FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRRQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column ACCESS_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For column ACCESS_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(3);
				if(tempTime != null)
					pstmt.setTime(3,tempTime);
				else
					pstmt.setNull(3,java.sql.Types.TIME);
			}
			// For column SEQ_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyForUpdateWithRSQuery_0 = " SELECT T1.USER_ID, T1.OPERATION_PERFORMED, T1.ACCESS_DATE, T1.ACCESS_TIME, T1.SEQ_NO, T1.PROPOSAL_ID FROM BH.ACCESSHISTORY  T1 WHERE T1.USER_ID = ? AND T1.ACCESS_DATE = ? AND T1.ACCESS_TIME = ? AND T1.SEQ_NO = ? AND T1.PROPOSAL_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRSQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column ACCESS_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For column ACCESS_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(3);
				if(tempTime != null)
					pstmt.setTime(3,tempTime);
				else
					pstmt.setNull(3,java.sql.Types.TIME);
			}
			// For column SEQ_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
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
	private static String findByProposalIDAndUserIDQuery_0 = " select  q1.\"USER_ID\",  q1.\"OPERATION_PERFORMED\",  q1.\"ACCESS_DATE\",  q1.\"ACCESS_TIME\",  q1.\"SEQ_NO\",  q1.\"PROPOSAL_ID\" from BH.ACCESSHISTORY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"USER_ID\" = ?) ";
	/**
	 * FindByProposalIDAndUserID
	 */
	public javax.resource.cci.Record FindByProposalIDAndUserID(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from AccessHistory o where  o.proposalId = ?1 and  o.userId = ?2 */
			pstmt = prepareStatement(connection, findByProposalIDAndUserIDQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByProposalIDAndUserIDQuery_0);

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
	private static String findByProposalIDAndUserIDForUpdateQuery_0 = " select  q1.\"USER_ID\",  q1.\"OPERATION_PERFORMED\",  q1.\"ACCESS_DATE\",  q1.\"ACCESS_TIME\",  q1.\"SEQ_NO\",  q1.\"PROPOSAL_ID\" from BH.ACCESSHISTORY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"USER_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalIDAndUserID444Update
	 */
	public javax.resource.cci.Record FindByProposalIDAndUserID444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from AccessHistory o where  o.proposalId = ?1 and  o.userId = ?2 */
			pstmt = prepareStatement(connection, findByProposalIDAndUserIDForUpdateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByProposalIDAndUserIDForUpdateQuery_0);

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
	private static String findByProposalIDAndUserIDForUpdateWithRRQuery_0 = " select  q1.\"USER_ID\",  q1.\"OPERATION_PERFORMED\",  q1.\"ACCESS_DATE\",  q1.\"ACCESS_TIME\",  q1.\"SEQ_NO\",  q1.\"PROPOSAL_ID\" from BH.ACCESSHISTORY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"USER_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalIDAndUserIDForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByProposalIDAndUserIDForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from AccessHistory o where  o.proposalId = ?1 and  o.userId = ?2 */
			pstmt = prepareStatement(connection, findByProposalIDAndUserIDForUpdateWithRRQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByProposalIDAndUserIDForUpdateWithRRQuery_0);

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
	private static String findByProposalIDAndUserIDForUpdateWithRSQuery_0 = " select  q1.\"USER_ID\",  q1.\"OPERATION_PERFORMED\",  q1.\"ACCESS_DATE\",  q1.\"ACCESS_TIME\",  q1.\"SEQ_NO\",  q1.\"PROPOSAL_ID\" from BH.ACCESSHISTORY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"USER_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalIDAndUserIDForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByProposalIDAndUserIDForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from AccessHistory o where  o.proposalId = ?1 and  o.userId = ?2 */
			pstmt = prepareStatement(connection, findByProposalIDAndUserIDForUpdateWithRSQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (userId)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByProposalIDAndUserIDForUpdateWithRSQuery_0);

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
	 * AccessHistoryBeanFunctionSet_1c91e0cb
	 */
	public AccessHistoryBeanFunctionSet_1c91e0cb() {
		functionHash=new java.util.HashMap(20);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindByProposalID",new Integer(4));
		functionHash.put("FindByProposalID444Update",new Integer(5));
		functionHash.put("FindByProposalIDForUpdateWithRR",new Integer(6));
		functionHash.put("FindByProposalIDForUpdateWithRS",new Integer(7));
		functionHash.put("FindByPrimaryKey",new Integer(8));
		functionHash.put("FindByPrimaryKey444Update",new Integer(9));
		functionHash.put("FindByPrimaryKeyForUpdateWithRR",new Integer(10));
		functionHash.put("FindByPrimaryKeyForUpdateWithRS",new Integer(11));
		functionHash.put("FindByProposalIDAndUserID",new Integer(12));
		functionHash.put("FindByProposalIDAndUserID444Update",new Integer(13));
		functionHash.put("FindByProposalIDAndUserIDForUpdateWithRR",new Integer(14));
		functionHash.put("FindByProposalIDAndUserIDForUpdateWithRS",new Integer(15));
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
			outputRecord=FindByProposalID(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindByProposalID444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindByProposalIDForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindByProposalIDForUpdateWithRS(inputRecord,connection,interactionSpec);
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
			outputRecord=FindByProposalIDAndUserID(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=FindByProposalIDAndUserID444Update(inputRecord,connection,interactionSpec);
			break;
		case 14:
			outputRecord=FindByProposalIDAndUserIDForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 15:
			outputRecord=FindByProposalIDAndUserIDForUpdateWithRS(inputRecord,connection,interactionSpec);
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
	private static String ReadReadQuery_0 = " SELECT 1 FROM BH.ACCESSHISTORY  T1 WHERE T1.USER_ID = ? AND T1.ACCESS_DATE = ? AND T1.ACCESS_TIME = ? AND T1.SEQ_NO = ? AND T1.PROPOSAL_ID = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column ACCESS_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For column ACCESS_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(3);
				if(tempTime != null)
					pstmt.setTime(3,tempTime);
				else
					pstmt.setNull(3,java.sql.Types.TIME);
			}
			// For column SEQ_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM BH.ACCESSHISTORY  T1 WHERE T1.USER_ID = ? AND T1.ACCESS_DATE = ? AND T1.ACCESS_TIME = ? AND T1.SEQ_NO = ? AND T1.PROPOSAL_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column USER_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column ACCESS_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For column ACCESS_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(3);
				if(tempTime != null)
					pstmt.setTime(3,tempTime);
				else
					pstmt.setNull(3,java.sql.Types.TIME);
			}
			// For column SEQ_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
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
		updateTemplateList = AccessHistoryBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
					if (changedFieldIndexes[2])
					{
						// For column OPERATION_PERFORMED
						String tempString;


						tempString=(String)inputRecord.get(1);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
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
					{
						// For column ACCESS_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(2);
						pstmt.setDate(stmtIndex,tempDate);
							stmtIndex++;

					}
					{
						// For column ACCESS_TIME
						java.sql.Time tempTime;


						tempTime=(java.sql.Time)inputRecord.get(3);
						pstmt.setTime(stmtIndex,tempTime);
							stmtIndex++;

					}
					{
						// For column SEQ_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(4);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(5);
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
				String updateQuery = aTemplate.nativeQuery(changedFieldIndexes);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[2])
					{
						// For column OPERATION_PERFORMED
						String tempString;


						tempString=(String)inputRecord.get(1);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
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
					{
						// For column ACCESS_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(2);
						pstmt.setDate(stmtIndex,tempDate);
							stmtIndex++;

					}
					{
						// For column ACCESS_TIME
						java.sql.Time tempTime;


						tempTime=(java.sql.Time)inputRecord.get(3);
						pstmt.setTime(stmtIndex,tempTime);
							stmtIndex++;

					}
					{
						// For column SEQ_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(4);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(5);
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
}
