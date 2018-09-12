package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * BaseAgreementChangeLogBeanFunctionSet_508109ee
 */
public class BaseAgreementChangeLogBeanFunctionSet_508109ee extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO BH.BASEAGREEMENTCHANGELOG (CHANGE_ID, AGREEMENT_ID, CREATED_BY, CHANGED_DATE, CHANGED_TIME, CHANGED_DETAILS) VALUES (?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column CHANGE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column AGREEMENT_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column CREATED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column CHANGED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			// For column CHANGED_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(4);
				if(tempTime != null)
					pstmt.setTime(5,tempTime);
				else
					pstmt.setNull(5,java.sql.Types.TIME);
			}
			// For column CHANGED_DETAILS
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setCharacterStream(6,new java.io.StringReader(tempString),tempString.length());
				else
					pstmt.setNull(6,java.sql.Types.CLOB);
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
	private static String RemoveQuery_0 = "DELETE FROM BH.BASEAGREEMENTCHANGELOG  WHERE CHANGE_ID = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column CHANGE_ID
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
	private static String StoreQuery_0 = "UPDATE BH.BASEAGREEMENTCHANGELOG  SET AGREEMENT_ID = ?, CREATED_BY = ?, CHANGED_DATE = ?, CHANGED_TIME = ?, CHANGED_DETAILS = ? WHERE CHANGE_ID = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column CHANGE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For column AGREEMENT_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column CREATED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column CHANGED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For column CHANGED_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(4);
				if(tempTime != null)
					pstmt.setTime(4,tempTime);
				else
					pstmt.setNull(4,java.sql.Types.TIME);
			}
			// For column CHANGED_DETAILS
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setCharacterStream(5,new java.io.StringReader(tempString),tempString.length());
				else
					pstmt.setNull(5,java.sql.Types.CLOB);
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
	private static String StoreOCCQuery_0 = "UPDATE BH.BASEAGREEMENTCHANGELOG  SET AGREEMENT_ID = ?, CREATED_BY = ?, CHANGED_DATE = ?, CHANGED_TIME = ?, CHANGED_DETAILS = ? WHERE CHANGE_ID = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column CHANGE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For column AGREEMENT_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column CREATED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column CHANGED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For column CHANGED_TIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(4);
				if(tempTime != null)
					pstmt.setTime(4,tempTime);
				else
					pstmt.setNull(4,java.sql.Types.TIME);
			}
			// For column CHANGED_DETAILS
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setCharacterStream(5,new java.io.StringReader(tempString),tempString.length());
				else
					pstmt.setNull(5,java.sql.Types.CLOB);
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
	private static String findByAgreementIdQuery_0 = " select  q1.\"CHANGE_ID\",  q1.\"AGREEMENT_ID\",  q1.\"CREATED_BY\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_TIME\",  q1.\"CHANGED_DETAILS\" from BH.BASEAGREEMENTCHANGELOG q1 where  ( q1.\"AGREEMENT_ID\" = ?) ";
	/**
	 * FindByAgreementId
	 */
	public javax.resource.cci.Record FindByAgreementId(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreementChangeLog o where  o.agreementId = ?1 */
			pstmt = prepareStatement(connection, findByAgreementIdQuery_0);

			// For ?1 (agreementId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByAgreementIdQuery_0);

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
	private static String findByAgreementIdForUpdateQuery_0 = " select  q1.\"CHANGE_ID\",  q1.\"AGREEMENT_ID\",  q1.\"CREATED_BY\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_TIME\",  q1.\"CHANGED_DETAILS\" from BH.BASEAGREEMENTCHANGELOG q1 where  ( q1.\"AGREEMENT_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByAgreementId444Update
	 */
	public javax.resource.cci.Record FindByAgreementId444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreementChangeLog o where  o.agreementId = ?1 */
			pstmt = prepareStatement(connection, findByAgreementIdForUpdateQuery_0);

			// For ?1 (agreementId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByAgreementIdForUpdateQuery_0);

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
	private static String findByAgreementIdForUpdateWithRRQuery_0 = " select  q1.\"CHANGE_ID\",  q1.\"AGREEMENT_ID\",  q1.\"CREATED_BY\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_TIME\",  q1.\"CHANGED_DETAILS\" from BH.BASEAGREEMENTCHANGELOG q1 where  ( q1.\"AGREEMENT_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByAgreementIdForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByAgreementIdForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreementChangeLog o where  o.agreementId = ?1 */
			pstmt = prepareStatement(connection, findByAgreementIdForUpdateWithRRQuery_0);

			// For ?1 (agreementId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByAgreementIdForUpdateWithRRQuery_0);

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
	private static String findByAgreementIdForUpdateWithRSQuery_0 = " select  q1.\"CHANGE_ID\",  q1.\"AGREEMENT_ID\",  q1.\"CREATED_BY\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_TIME\",  q1.\"CHANGED_DETAILS\" from BH.BASEAGREEMENTCHANGELOG q1 where  ( q1.\"AGREEMENT_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByAgreementIdForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByAgreementIdForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreementChangeLog o where  o.agreementId = ?1 */
			pstmt = prepareStatement(connection, findByAgreementIdForUpdateWithRSQuery_0);

			// For ?1 (agreementId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByAgreementIdForUpdateWithRSQuery_0);

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
	private static String findMaxChangeIdQuery_0 = " select  q1.\"CHANGE_ID\",  q1.\"AGREEMENT_ID\",  q1.\"CREATED_BY\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_TIME\",  q1.\"CHANGED_DETAILS\" from BH.BASEAGREEMENTCHANGELOG q1 where  ( q1.\"CHANGE_ID\" =  ( select  max( q2.\"CHANGE_ID\") from BH.BASEAGREEMENTCHANGELOG q2) ) ";
	/**
	 * FindMaxChangeId
	 */
	public javax.resource.cci.Record FindMaxChangeId(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreementChangeLog o where  o.changeId = (select max(a.changeId) from BaseAgreementChangeLog a) */
			pstmt = prepareStatement(connection, findMaxChangeIdQuery_0);

			result = executeQuery(connection, pstmt, findMaxChangeIdQuery_0);

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
	private static String findMaxChangeIdForUpdateQuery_0 = " select  q1.\"CHANGE_ID\",  q1.\"AGREEMENT_ID\",  q1.\"CREATED_BY\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_TIME\",  q1.\"CHANGED_DETAILS\" from BH.BASEAGREEMENTCHANGELOG q1 where  ( q1.\"CHANGE_ID\" =  ( select  max( q2.\"CHANGE_ID\") from BH.BASEAGREEMENTCHANGELOG q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxChangeId444Update
	 */
	public javax.resource.cci.Record FindMaxChangeId444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreementChangeLog o where  o.changeId = (select max(a.changeId) from BaseAgreementChangeLog a) */
			pstmt = prepareStatement(connection, findMaxChangeIdForUpdateQuery_0);

			result = executeQuery(connection, pstmt, findMaxChangeIdForUpdateQuery_0);

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
	private static String findMaxChangeIdForUpdateWithRRQuery_0 = " select  q1.\"CHANGE_ID\",  q1.\"AGREEMENT_ID\",  q1.\"CREATED_BY\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_TIME\",  q1.\"CHANGED_DETAILS\" from BH.BASEAGREEMENTCHANGELOG q1 where  ( q1.\"CHANGE_ID\" =  ( select  max( q2.\"CHANGE_ID\") from BH.BASEAGREEMENTCHANGELOG q2) )  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxChangeIdForUpdateWithRR
	 */
	public javax.resource.cci.Record FindMaxChangeIdForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreementChangeLog o where  o.changeId = (select max(a.changeId) from BaseAgreementChangeLog a) */
			pstmt = prepareStatement(connection, findMaxChangeIdForUpdateWithRRQuery_0);

			result = executeQuery(connection, pstmt, findMaxChangeIdForUpdateWithRRQuery_0);

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
	private static String findMaxChangeIdForUpdateWithRSQuery_0 = " select  q1.\"CHANGE_ID\",  q1.\"AGREEMENT_ID\",  q1.\"CREATED_BY\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_TIME\",  q1.\"CHANGED_DETAILS\" from BH.BASEAGREEMENTCHANGELOG q1 where  ( q1.\"CHANGE_ID\" =  ( select  max( q2.\"CHANGE_ID\") from BH.BASEAGREEMENTCHANGELOG q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxChangeIdForUpdateWithRS
	 */
	public javax.resource.cci.Record FindMaxChangeIdForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreementChangeLog o where  o.changeId = (select max(a.changeId) from BaseAgreementChangeLog a) */
			pstmt = prepareStatement(connection, findMaxChangeIdForUpdateWithRSQuery_0);

			result = executeQuery(connection, pstmt, findMaxChangeIdForUpdateWithRSQuery_0);

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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.CHANGE_ID, T1.AGREEMENT_ID, T1.CREATED_BY, T1.CHANGED_DATE, T1.CHANGED_TIME, T1.CHANGED_DETAILS FROM BH.BASEAGREEMENTCHANGELOG  T1 WHERE T1.CHANGE_ID = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column CHANGE_ID
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.CHANGE_ID, T1.AGREEMENT_ID, T1.CREATED_BY, T1.CHANGED_DATE, T1.CHANGED_TIME, T1.CHANGED_DETAILS FROM BH.BASEAGREEMENTCHANGELOG  T1 WHERE T1.CHANGE_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column CHANGE_ID
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
	private static String FindByPrimaryKeyForUpdateWithRRQuery_0 = " SELECT T1.CHANGE_ID, T1.AGREEMENT_ID, T1.CREATED_BY, T1.CHANGED_DATE, T1.CHANGED_TIME, T1.CHANGED_DETAILS FROM BH.BASEAGREEMENTCHANGELOG  T1 WHERE T1.CHANGE_ID = ? FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRRQuery_0);

			// For column CHANGE_ID
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
	private static String FindByPrimaryKeyForUpdateWithRSQuery_0 = " SELECT T1.CHANGE_ID, T1.AGREEMENT_ID, T1.CREATED_BY, T1.CHANGED_DATE, T1.CHANGED_TIME, T1.CHANGED_DETAILS FROM BH.BASEAGREEMENTCHANGELOG  T1 WHERE T1.CHANGE_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRSQuery_0);

			// For column CHANGE_ID
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
	/**
	 * BaseAgreementChangeLogBeanFunctionSet_508109ee
	 */
	public BaseAgreementChangeLogBeanFunctionSet_508109ee() {
		functionHash=new java.util.HashMap(20);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindByAgreementId",new Integer(4));
		functionHash.put("FindByAgreementId444Update",new Integer(5));
		functionHash.put("FindByAgreementIdForUpdateWithRR",new Integer(6));
		functionHash.put("FindByAgreementIdForUpdateWithRS",new Integer(7));
		functionHash.put("FindMaxChangeId",new Integer(8));
		functionHash.put("FindMaxChangeId444Update",new Integer(9));
		functionHash.put("FindMaxChangeIdForUpdateWithRR",new Integer(10));
		functionHash.put("FindMaxChangeIdForUpdateWithRS",new Integer(11));
		functionHash.put("FindByPrimaryKey",new Integer(12));
		functionHash.put("FindByPrimaryKey444Update",new Integer(13));
		functionHash.put("FindByPrimaryKeyForUpdateWithRR",new Integer(14));
		functionHash.put("FindByPrimaryKeyForUpdateWithRS",new Integer(15));
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
			outputRecord=FindByAgreementId(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindByAgreementId444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindByAgreementIdForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindByAgreementIdForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=FindMaxChangeId(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindMaxChangeId444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=FindMaxChangeIdForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=FindMaxChangeIdForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 12:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 14:
			outputRecord=FindByPrimaryKeyForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 15:
			outputRecord=FindByPrimaryKeyForUpdateWithRS(inputRecord,connection,interactionSpec);
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
	private static String ReadReadQuery_0 = " SELECT 1 FROM BH.BASEAGREEMENTCHANGELOG  T1 WHERE T1.CHANGE_ID = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column CHANGE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM BH.BASEAGREEMENTCHANGELOG  T1 WHERE T1.CHANGE_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column CHANGE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
		updateTemplateList = BaseAgreementChangeLogBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
						// For column AGREEMENT_ID
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
						// For column CREATED_BY
						String tempString;


						tempString=(String)inputRecord.get(2);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[3])
					{
						// For column CHANGED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(3);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column CHANGED_TIME
						java.sql.Time tempTime;


						tempTime=(java.sql.Time)inputRecord.get(4);
						if(tempTime != null){
							pstmt.setTime(stmtIndex,tempTime);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIME);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column CHANGED_DETAILS
						String tempString;


						tempString=(String)inputRecord.get(5);
						if(tempString != null){
							pstmt.setCharacterStream(stmtIndex, new java.io.StringReader(tempString),tempString.length());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CLOB);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column CHANGE_ID
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
				String updateQuery = aTemplate.nativeQuery(changedFieldIndexes);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[1])
					{
						// For column AGREEMENT_ID
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
						// For column CREATED_BY
						String tempString;


						tempString=(String)inputRecord.get(2);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[3])
					{
						// For column CHANGED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(3);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column CHANGED_TIME
						java.sql.Time tempTime;


						tempTime=(java.sql.Time)inputRecord.get(4);
						if(tempTime != null){
							pstmt.setTime(stmtIndex,tempTime);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.TIME);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column CHANGED_DETAILS
						String tempString;


						tempString=(String)inputRecord.get(5);
						if(tempString != null){
							pstmt.setCharacterStream(stmtIndex, new java.io.StringReader(tempString),tempString.length());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CLOB);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column CHANGE_ID
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
}
