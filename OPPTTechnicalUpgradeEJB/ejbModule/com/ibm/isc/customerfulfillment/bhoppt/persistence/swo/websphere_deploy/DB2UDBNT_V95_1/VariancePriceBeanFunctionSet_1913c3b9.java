package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * VariancePriceBeanFunctionSet_1913c3b9
 */
public class VariancePriceBeanFunctionSet_1913c3b9 extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO BH.TEMPVARPRICE (SOLD_TO_PARTY_ID, DESG_MACHINE_ID, SWOEE_ID, PRICE_ID, PROPOSAL_ID, SWO_ID, SALES_DOC_NO, EE_ITEM_NO, BILL_PLAN_ST_DATE, BILL_PLAN_END_DATE, ESW_PRICE, CURRENCY, INDICATOR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column PRICE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For column SALES_DOC_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			// For column EE_ITEM_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column BILL_PLAN_ST_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(8);
				if(tempDate != null)
					pstmt.setDate(9,tempDate);
				else
					pstmt.setNull(9,java.sql.Types.DATE);
			}
			// For column BILL_PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(9);
				if(tempDate != null)
					pstmt.setDate(10,tempDate);
				else
					pstmt.setNull(10,java.sql.Types.DATE);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(10);
				if(tempDouble != null)
					pstmt.setDouble(11,tempDouble.doubleValue());
				else
					pstmt.setNull(11,java.sql.Types.DECIMAL);
			}
			// For column CURRENCY
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.CHAR);
			}
			// For column INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.CHAR);
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
	private static String RemoveQuery_0 = "DELETE FROM BH.TEMPVARPRICE  WHERE SOLD_TO_PARTY_ID = ? AND DESG_MACHINE_ID = ? AND SWOEE_ID = ? AND PRICE_ID = ? AND PROPOSAL_ID = ? AND SWO_ID = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column PRICE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
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
	private static String StoreQuery_0 = "UPDATE BH.TEMPVARPRICE  SET SALES_DOC_NO = ?, EE_ITEM_NO = ?, BILL_PLAN_ST_DATE = ?, BILL_PLAN_END_DATE = ?, ESW_PRICE = ?, CURRENCY = ?, INDICATOR = ? WHERE SOLD_TO_PARTY_ID = ? AND DESG_MACHINE_ID = ? AND SWOEE_ID = ? AND PRICE_ID = ? AND PROPOSAL_ID = ? AND SWO_ID = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(8,tempInteger.intValue());
				else
					pstmt.setNull(8,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(9,tempInteger.intValue());
				else
					pstmt.setNull(9,java.sql.Types.INTEGER);
			}
			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			// For column PRICE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(11,tempInteger.intValue());
				else
					pstmt.setNull(11,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(12,tempInteger.intValue());
				else
					pstmt.setNull(12,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(13,tempInteger.intValue());
				else
					pstmt.setNull(13,java.sql.Types.INTEGER);
			}
			// For column SALES_DOC_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column EE_ITEM_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column BILL_PLAN_ST_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(8);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For column BILL_PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(9);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(10);
				if(tempDouble != null)
					pstmt.setDouble(5,tempDouble.doubleValue());
				else
					pstmt.setNull(5,java.sql.Types.DECIMAL);
			}
			// For column CURRENCY
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
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
	private static String StoreOCCQuery_0 = "UPDATE BH.TEMPVARPRICE  SET SALES_DOC_NO = ?, EE_ITEM_NO = ?, BILL_PLAN_ST_DATE = ?, BILL_PLAN_END_DATE = ?, ESW_PRICE = ?, CURRENCY = ?, INDICATOR = ? WHERE SOLD_TO_PARTY_ID = ? AND DESG_MACHINE_ID = ? AND SWOEE_ID = ? AND PRICE_ID = ? AND PROPOSAL_ID = ? AND SWO_ID = ? AND ESW_PRICE = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(8,tempInteger.intValue());
				else
					pstmt.setNull(8,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(9,tempInteger.intValue());
				else
					pstmt.setNull(9,java.sql.Types.INTEGER);
			}
			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			// For column PRICE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(11,tempInteger.intValue());
				else
					pstmt.setNull(11,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(12,tempInteger.intValue());
				else
					pstmt.setNull(12,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(13,tempInteger.intValue());
				else
					pstmt.setNull(13,java.sql.Types.INTEGER);
			}
			// For column SALES_DOC_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column EE_ITEM_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column BILL_PLAN_ST_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(8);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For column BILL_PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(9);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(10);
				if(tempDouble != null)
					pstmt.setDouble(5,tempDouble.doubleValue());
				else
					pstmt.setNull(5,java.sql.Types.DECIMAL);
			}
			// For column CURRENCY
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(10);
				if(tempDouble != null)
					pstmt.setDouble(14,tempDouble.doubleValue());
				else
					pstmt.setNull(14,java.sql.Types.DECIMAL);
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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.SOLD_TO_PARTY_ID, T1.DESG_MACHINE_ID, T1.SWOEE_ID, T1.PRICE_ID, T1.PROPOSAL_ID, T1.SWO_ID, T1.SALES_DOC_NO, T1.EE_ITEM_NO, T1.BILL_PLAN_ST_DATE, T1.BILL_PLAN_END_DATE, T1.ESW_PRICE, T1.CURRENCY, T1.INDICATOR FROM BH.TEMPVARPRICE  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SWOEE_ID = ? AND T1.PRICE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column PRICE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.SOLD_TO_PARTY_ID, T1.DESG_MACHINE_ID, T1.SWOEE_ID, T1.PRICE_ID, T1.PROPOSAL_ID, T1.SWO_ID, T1.SALES_DOC_NO, T1.EE_ITEM_NO, T1.BILL_PLAN_ST_DATE, T1.BILL_PLAN_END_DATE, T1.ESW_PRICE, T1.CURRENCY, T1.INDICATOR FROM BH.TEMPVARPRICE  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SWOEE_ID = ? AND T1.PRICE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column PRICE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyForUpdateWithRRQuery_0 = " SELECT T1.SOLD_TO_PARTY_ID, T1.DESG_MACHINE_ID, T1.SWOEE_ID, T1.PRICE_ID, T1.PROPOSAL_ID, T1.SWO_ID, T1.SALES_DOC_NO, T1.EE_ITEM_NO, T1.BILL_PLAN_ST_DATE, T1.BILL_PLAN_END_DATE, T1.ESW_PRICE, T1.CURRENCY, T1.INDICATOR FROM BH.TEMPVARPRICE  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SWOEE_ID = ? AND T1.PRICE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ? FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRRQuery_0);

			// For column PRICE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyForUpdateWithRSQuery_0 = " SELECT T1.SOLD_TO_PARTY_ID, T1.DESG_MACHINE_ID, T1.SWOEE_ID, T1.PRICE_ID, T1.PROPOSAL_ID, T1.SWO_ID, T1.SALES_DOC_NO, T1.EE_ITEM_NO, T1.BILL_PLAN_ST_DATE, T1.BILL_PLAN_END_DATE, T1.ESW_PRICE, T1.CURRENCY, T1.INDICATOR FROM BH.TEMPVARPRICE  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SWOEE_ID = ? AND T1.PRICE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRSQuery_0);

			// For column PRICE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
	private static String findByEEQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PRICE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"BILL_PLAN_ST_DATE\",  q1.\"BILL_PLAN_END_DATE\",  q1.\"ESW_PRICE\",  q1.\"CURRENCY\",  q1.\"INDICATOR\" from BH.TEMPVARPRICE q1 where  ( q1.\"SWOEE_ID\" = ?)  and  ( q1.\"SWO_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"BILL_PLAN_ST_DATE\" =  ( select  max( q2.\"BILL_PLAN_ST_DATE\") from BH.TEMPVARPRICE q2 where  ( q2.\"SWOEE_ID\" = ?)  and  ( q2.\"SWO_ID\" = ?)  and  ( q2.\"DESG_MACHINE_ID\" = ?)  and  ( q2.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?) ) ) ";
	/**
	 * FindByEE
	 */
	public javax.resource.cci.Record FindByEE(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VariancePrice o where  o.eeId = ?1 and  o.swoId = ?2 and  o.dmId = ?3 and  o.customerId = ?4 and  o.proposalId = ?5 and o.billPlanStartDate = (select max(a.billPlanStartDate) from VariancePrice a where a.eeId = ?1 and  a.swoId = ?2 and  a.dmId = ?3 and  a.customerId = ?4 and  a.proposalId = ?5) */
			pstmt = prepareStatement(connection, findByEEQuery_0);

			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(6);
				if(tempInteger != null)
					pstmt.setInt(7,tempInteger.intValue());
				else
					pstmt.setNull(7,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(7);
				if(tempInteger != null)
					pstmt.setInt(8,tempInteger.intValue());
				else
					pstmt.setNull(8,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(8);
				if(tempInteger != null)
					pstmt.setInt(9,tempInteger.intValue());
				else
					pstmt.setNull(9,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(9);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEEQuery_0);

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
	private static String findByEEForUpdateQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PRICE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"BILL_PLAN_ST_DATE\",  q1.\"BILL_PLAN_END_DATE\",  q1.\"ESW_PRICE\",  q1.\"CURRENCY\",  q1.\"INDICATOR\" from BH.TEMPVARPRICE q1 where  ( q1.\"SWOEE_ID\" = ?)  and  ( q1.\"SWO_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"BILL_PLAN_ST_DATE\" =  ( select  max( q2.\"BILL_PLAN_ST_DATE\") from BH.TEMPVARPRICE q2 where  ( q2.\"SWOEE_ID\" = ?)  and  ( q2.\"SWO_ID\" = ?)  and  ( q2.\"DESG_MACHINE_ID\" = ?)  and  ( q2.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?) ) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByEE444Update
	 */
	public javax.resource.cci.Record FindByEE444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VariancePrice o where  o.eeId = ?1 and  o.swoId = ?2 and  o.dmId = ?3 and  o.customerId = ?4 and  o.proposalId = ?5 and o.billPlanStartDate = (select max(a.billPlanStartDate) from VariancePrice a where a.eeId = ?1 and  a.swoId = ?2 and  a.dmId = ?3 and  a.customerId = ?4 and  a.proposalId = ?5) */
			pstmt = prepareStatement(connection, findByEEForUpdateQuery_0);

			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(6);
				if(tempInteger != null)
					pstmt.setInt(7,tempInteger.intValue());
				else
					pstmt.setNull(7,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(7);
				if(tempInteger != null)
					pstmt.setInt(8,tempInteger.intValue());
				else
					pstmt.setNull(8,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(8);
				if(tempInteger != null)
					pstmt.setInt(9,tempInteger.intValue());
				else
					pstmt.setNull(9,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(9);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEEForUpdateQuery_0);

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
	private static String findByEEForUpdateWithRRQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PRICE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"BILL_PLAN_ST_DATE\",  q1.\"BILL_PLAN_END_DATE\",  q1.\"ESW_PRICE\",  q1.\"CURRENCY\",  q1.\"INDICATOR\" from BH.TEMPVARPRICE q1 where  ( q1.\"SWOEE_ID\" = ?)  and  ( q1.\"SWO_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"BILL_PLAN_ST_DATE\" =  ( select  max( q2.\"BILL_PLAN_ST_DATE\") from BH.TEMPVARPRICE q2 where  ( q2.\"SWOEE_ID\" = ?)  and  ( q2.\"SWO_ID\" = ?)  and  ( q2.\"DESG_MACHINE_ID\" = ?)  and  ( q2.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?) ) )  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByEEForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByEEForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VariancePrice o where  o.eeId = ?1 and  o.swoId = ?2 and  o.dmId = ?3 and  o.customerId = ?4 and  o.proposalId = ?5 and o.billPlanStartDate = (select max(a.billPlanStartDate) from VariancePrice a where a.eeId = ?1 and  a.swoId = ?2 and  a.dmId = ?3 and  a.customerId = ?4 and  a.proposalId = ?5) */
			pstmt = prepareStatement(connection, findByEEForUpdateWithRRQuery_0);

			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(6);
				if(tempInteger != null)
					pstmt.setInt(7,tempInteger.intValue());
				else
					pstmt.setNull(7,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(7);
				if(tempInteger != null)
					pstmt.setInt(8,tempInteger.intValue());
				else
					pstmt.setNull(8,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(8);
				if(tempInteger != null)
					pstmt.setInt(9,tempInteger.intValue());
				else
					pstmt.setNull(9,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(9);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEEForUpdateWithRRQuery_0);

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
	private static String findByEEForUpdateWithRSQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PRICE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"BILL_PLAN_ST_DATE\",  q1.\"BILL_PLAN_END_DATE\",  q1.\"ESW_PRICE\",  q1.\"CURRENCY\",  q1.\"INDICATOR\" from BH.TEMPVARPRICE q1 where  ( q1.\"SWOEE_ID\" = ?)  and  ( q1.\"SWO_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"BILL_PLAN_ST_DATE\" =  ( select  max( q2.\"BILL_PLAN_ST_DATE\") from BH.TEMPVARPRICE q2 where  ( q2.\"SWOEE_ID\" = ?)  and  ( q2.\"SWO_ID\" = ?)  and  ( q2.\"DESG_MACHINE_ID\" = ?)  and  ( q2.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?) ) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByEEForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByEEForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VariancePrice o where  o.eeId = ?1 and  o.swoId = ?2 and  o.dmId = ?3 and  o.customerId = ?4 and  o.proposalId = ?5 and o.billPlanStartDate = (select max(a.billPlanStartDate) from VariancePrice a where a.eeId = ?1 and  a.swoId = ?2 and  a.dmId = ?3 and  a.customerId = ?4 and  a.proposalId = ?5) */
			pstmt = prepareStatement(connection, findByEEForUpdateWithRSQuery_0);

			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(6);
				if(tempInteger != null)
					pstmt.setInt(7,tempInteger.intValue());
				else
					pstmt.setNull(7,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(7);
				if(tempInteger != null)
					pstmt.setInt(8,tempInteger.intValue());
				else
					pstmt.setNull(8,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(8);
				if(tempInteger != null)
					pstmt.setInt(9,tempInteger.intValue());
				else
					pstmt.setNull(9,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(9);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEEForUpdateWithRSQuery_0);

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
	private static String findByEEForVarianceQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PRICE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"BILL_PLAN_ST_DATE\",  q1.\"BILL_PLAN_END_DATE\",  q1.\"ESW_PRICE\",  q1.\"CURRENCY\",  q1.\"INDICATOR\" from BH.TEMPVARPRICE q1 where  ( q1.\"SWOEE_ID\" = ?)  and  ( q1.\"SWO_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"BILL_PLAN_ST_DATE\" =  ( select  max( q2.\"BILL_PLAN_ST_DATE\") from BH.TEMPVARPRICE q2 where  ( q2.\"SWOEE_ID\" = ?)  and  ( q2.\"SWO_ID\" = ?)  and  ( q2.\"DESG_MACHINE_ID\" = ?)  and  ( q2.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?)  and  ( q2.\"INDICATOR\" <> \'D\')  and  ( q2.\"INDICATOR\" <> \'S\') ) ) ";
	/**
	 * FindByEEForVariance
	 */
	public javax.resource.cci.Record FindByEEForVariance(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VariancePrice o where  o.eeId = ?1 and  o.swoId = ?2 and  o.dmId = ?3 and  o.customerId = ?4 and  o.proposalId = ?5 and o.billPlanStartDate = (select max(a.billPlanStartDate) from VariancePrice a where a.eeId = ?1 and  a.swoId = ?2 and  a.dmId = ?3 and  a.customerId = ?4 and  a.proposalId = ?5 and a.indicator not in ('D','S')) */
			pstmt = prepareStatement(connection, findByEEForVarianceQuery_0);

			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(6);
				if(tempInteger != null)
					pstmt.setInt(7,tempInteger.intValue());
				else
					pstmt.setNull(7,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(7);
				if(tempInteger != null)
					pstmt.setInt(8,tempInteger.intValue());
				else
					pstmt.setNull(8,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(8);
				if(tempInteger != null)
					pstmt.setInt(9,tempInteger.intValue());
				else
					pstmt.setNull(9,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(9);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEEForVarianceQuery_0);

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
	private static String findByEEForVarianceForUpdateQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PRICE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"BILL_PLAN_ST_DATE\",  q1.\"BILL_PLAN_END_DATE\",  q1.\"ESW_PRICE\",  q1.\"CURRENCY\",  q1.\"INDICATOR\" from BH.TEMPVARPRICE q1 where  ( q1.\"SWOEE_ID\" = ?)  and  ( q1.\"SWO_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"BILL_PLAN_ST_DATE\" =  ( select  max( q2.\"BILL_PLAN_ST_DATE\") from BH.TEMPVARPRICE q2 where  ( q2.\"SWOEE_ID\" = ?)  and  ( q2.\"SWO_ID\" = ?)  and  ( q2.\"DESG_MACHINE_ID\" = ?)  and  ( q2.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?)  and  ( q2.\"INDICATOR\" <> \'D\')  and  ( q2.\"INDICATOR\" <> \'S\') ) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByEEForVariance444Update
	 */
	public javax.resource.cci.Record FindByEEForVariance444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VariancePrice o where  o.eeId = ?1 and  o.swoId = ?2 and  o.dmId = ?3 and  o.customerId = ?4 and  o.proposalId = ?5 and o.billPlanStartDate = (select max(a.billPlanStartDate) from VariancePrice a where a.eeId = ?1 and  a.swoId = ?2 and  a.dmId = ?3 and  a.customerId = ?4 and  a.proposalId = ?5 and a.indicator not in ('D','S')) */
			pstmt = prepareStatement(connection, findByEEForVarianceForUpdateQuery_0);

			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(6);
				if(tempInteger != null)
					pstmt.setInt(7,tempInteger.intValue());
				else
					pstmt.setNull(7,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(7);
				if(tempInteger != null)
					pstmt.setInt(8,tempInteger.intValue());
				else
					pstmt.setNull(8,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(8);
				if(tempInteger != null)
					pstmt.setInt(9,tempInteger.intValue());
				else
					pstmt.setNull(9,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(9);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEEForVarianceForUpdateQuery_0);

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
	private static String findByEEForVarianceForUpdateWithRRQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PRICE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"BILL_PLAN_ST_DATE\",  q1.\"BILL_PLAN_END_DATE\",  q1.\"ESW_PRICE\",  q1.\"CURRENCY\",  q1.\"INDICATOR\" from BH.TEMPVARPRICE q1 where  ( q1.\"SWOEE_ID\" = ?)  and  ( q1.\"SWO_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"BILL_PLAN_ST_DATE\" =  ( select  max( q2.\"BILL_PLAN_ST_DATE\") from BH.TEMPVARPRICE q2 where  ( q2.\"SWOEE_ID\" = ?)  and  ( q2.\"SWO_ID\" = ?)  and  ( q2.\"DESG_MACHINE_ID\" = ?)  and  ( q2.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?)  and  ( q2.\"INDICATOR\" <> \'D\')  and  ( q2.\"INDICATOR\" <> \'S\') ) )  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByEEForVarianceForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByEEForVarianceForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VariancePrice o where  o.eeId = ?1 and  o.swoId = ?2 and  o.dmId = ?3 and  o.customerId = ?4 and  o.proposalId = ?5 and o.billPlanStartDate = (select max(a.billPlanStartDate) from VariancePrice a where a.eeId = ?1 and  a.swoId = ?2 and  a.dmId = ?3 and  a.customerId = ?4 and  a.proposalId = ?5 and a.indicator not in ('D','S')) */
			pstmt = prepareStatement(connection, findByEEForVarianceForUpdateWithRRQuery_0);

			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(6);
				if(tempInteger != null)
					pstmt.setInt(7,tempInteger.intValue());
				else
					pstmt.setNull(7,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(7);
				if(tempInteger != null)
					pstmt.setInt(8,tempInteger.intValue());
				else
					pstmt.setNull(8,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(8);
				if(tempInteger != null)
					pstmt.setInt(9,tempInteger.intValue());
				else
					pstmt.setNull(9,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(9);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEEForVarianceForUpdateWithRRQuery_0);

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
	private static String findByEEForVarianceForUpdateWithRSQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PRICE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"BILL_PLAN_ST_DATE\",  q1.\"BILL_PLAN_END_DATE\",  q1.\"ESW_PRICE\",  q1.\"CURRENCY\",  q1.\"INDICATOR\" from BH.TEMPVARPRICE q1 where  ( q1.\"SWOEE_ID\" = ?)  and  ( q1.\"SWO_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"BILL_PLAN_ST_DATE\" =  ( select  max( q2.\"BILL_PLAN_ST_DATE\") from BH.TEMPVARPRICE q2 where  ( q2.\"SWOEE_ID\" = ?)  and  ( q2.\"SWO_ID\" = ?)  and  ( q2.\"DESG_MACHINE_ID\" = ?)  and  ( q2.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?)  and  ( q2.\"INDICATOR\" <> \'D\')  and  ( q2.\"INDICATOR\" <> \'S\') ) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByEEForVarianceForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByEEForVarianceForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VariancePrice o where  o.eeId = ?1 and  o.swoId = ?2 and  o.dmId = ?3 and  o.customerId = ?4 and  o.proposalId = ?5 and o.billPlanStartDate = (select max(a.billPlanStartDate) from VariancePrice a where a.eeId = ?1 and  a.swoId = ?2 and  a.dmId = ?3 and  a.customerId = ?4 and  a.proposalId = ?5 and a.indicator not in ('D','S')) */
			pstmt = prepareStatement(connection, findByEEForVarianceForUpdateWithRSQuery_0);

			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For ?1 (eeId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For ?2 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(6);
				if(tempInteger != null)
					pstmt.setInt(7,tempInteger.intValue());
				else
					pstmt.setNull(7,java.sql.Types.INTEGER);
			}
			// For ?3 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(7);
				if(tempInteger != null)
					pstmt.setInt(8,tempInteger.intValue());
				else
					pstmt.setNull(8,java.sql.Types.INTEGER);
			}
			// For ?4 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(8);
				if(tempInteger != null)
					pstmt.setInt(9,tempInteger.intValue());
				else
					pstmt.setNull(9,java.sql.Types.INTEGER);
			}
			// For ?5 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(9);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEEForVarianceForUpdateWithRSQuery_0);

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
	private static String findMaxVariancePriceQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PRICE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"BILL_PLAN_ST_DATE\",  q1.\"BILL_PLAN_END_DATE\",  q1.\"ESW_PRICE\",  q1.\"CURRENCY\",  q1.\"INDICATOR\" from BH.TEMPVARPRICE q1 where  ( q1.\"PRICE_ID\" =  ( select  max( q2.\"PRICE_ID\") from BH.TEMPVARPRICE q2) ) ";
	/**
	 * FindMaxVariancePrice
	 */
	public javax.resource.cci.Record FindMaxVariancePrice(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VariancePrice o where   o.priceId = (select max(a.priceId) from VariancePrice a) */
			pstmt = prepareStatement(connection, findMaxVariancePriceQuery_0);

			result = executeQuery(connection, pstmt, findMaxVariancePriceQuery_0);

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
	private static String findMaxVariancePriceForUpdateQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PRICE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"BILL_PLAN_ST_DATE\",  q1.\"BILL_PLAN_END_DATE\",  q1.\"ESW_PRICE\",  q1.\"CURRENCY\",  q1.\"INDICATOR\" from BH.TEMPVARPRICE q1 where  ( q1.\"PRICE_ID\" =  ( select  max( q2.\"PRICE_ID\") from BH.TEMPVARPRICE q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxVariancePrice444Update
	 */
	public javax.resource.cci.Record FindMaxVariancePrice444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VariancePrice o where   o.priceId = (select max(a.priceId) from VariancePrice a) */
			pstmt = prepareStatement(connection, findMaxVariancePriceForUpdateQuery_0);

			result = executeQuery(connection, pstmt, findMaxVariancePriceForUpdateQuery_0);

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
	private static String findMaxVariancePriceForUpdateWithRRQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PRICE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"BILL_PLAN_ST_DATE\",  q1.\"BILL_PLAN_END_DATE\",  q1.\"ESW_PRICE\",  q1.\"CURRENCY\",  q1.\"INDICATOR\" from BH.TEMPVARPRICE q1 where  ( q1.\"PRICE_ID\" =  ( select  max( q2.\"PRICE_ID\") from BH.TEMPVARPRICE q2) )  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxVariancePriceForUpdateWithRR
	 */
	public javax.resource.cci.Record FindMaxVariancePriceForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VariancePrice o where   o.priceId = (select max(a.priceId) from VariancePrice a) */
			pstmt = prepareStatement(connection, findMaxVariancePriceForUpdateWithRRQuery_0);

			result = executeQuery(connection, pstmt, findMaxVariancePriceForUpdateWithRRQuery_0);

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
	private static String findMaxVariancePriceForUpdateWithRSQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PRICE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"BILL_PLAN_ST_DATE\",  q1.\"BILL_PLAN_END_DATE\",  q1.\"ESW_PRICE\",  q1.\"CURRENCY\",  q1.\"INDICATOR\" from BH.TEMPVARPRICE q1 where  ( q1.\"PRICE_ID\" =  ( select  max( q2.\"PRICE_ID\") from BH.TEMPVARPRICE q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxVariancePriceForUpdateWithRS
	 */
	public javax.resource.cci.Record FindMaxVariancePriceForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VariancePrice o where   o.priceId = (select max(a.priceId) from VariancePrice a) */
			pstmt = prepareStatement(connection, findMaxVariancePriceForUpdateWithRSQuery_0);

			result = executeQuery(connection, pstmt, findMaxVariancePriceForUpdateWithRSQuery_0);

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
	 * VariancePriceBeanFunctionSet_1913c3b9
	 */
	public VariancePriceBeanFunctionSet_1913c3b9() {
		functionHash=new java.util.HashMap(24);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindByPrimaryKey",new Integer(4));
		functionHash.put("FindByPrimaryKey444Update",new Integer(5));
		functionHash.put("FindByPrimaryKeyForUpdateWithRR",new Integer(6));
		functionHash.put("FindByPrimaryKeyForUpdateWithRS",new Integer(7));
		functionHash.put("FindByEE",new Integer(8));
		functionHash.put("FindByEE444Update",new Integer(9));
		functionHash.put("FindByEEForUpdateWithRR",new Integer(10));
		functionHash.put("FindByEEForUpdateWithRS",new Integer(11));
		functionHash.put("FindByEEForVariance",new Integer(12));
		functionHash.put("FindByEEForVariance444Update",new Integer(13));
		functionHash.put("FindByEEForVarianceForUpdateWithRR",new Integer(14));
		functionHash.put("FindByEEForVarianceForUpdateWithRS",new Integer(15));
		functionHash.put("FindMaxVariancePrice",new Integer(16));
		functionHash.put("FindMaxVariancePrice444Update",new Integer(17));
		functionHash.put("FindMaxVariancePriceForUpdateWithRR",new Integer(18));
		functionHash.put("FindMaxVariancePriceForUpdateWithRS",new Integer(19));
		functionHash.put("ReadReadChecking",new Integer(20));
		functionHash.put("ReadReadCheckingForUpdate",new Integer(21));
		functionHash.put("PartialStore",new Integer(22));
		functionHash.put("PartialStoreUsingOCC",new Integer(23));
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
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindByPrimaryKeyForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindByPrimaryKeyForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=FindByEE(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindByEE444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=FindByEEForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=FindByEEForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 12:
			outputRecord=FindByEEForVariance(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=FindByEEForVariance444Update(inputRecord,connection,interactionSpec);
			break;
		case 14:
			outputRecord=FindByEEForVarianceForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 15:
			outputRecord=FindByEEForVarianceForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 16:
			outputRecord=FindMaxVariancePrice(inputRecord,connection,interactionSpec);
			break;
		case 17:
			outputRecord=FindMaxVariancePrice444Update(inputRecord,connection,interactionSpec);
			break;
		case 18:
			outputRecord=FindMaxVariancePriceForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 19:
			outputRecord=FindMaxVariancePriceForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 20:
			ReadReadChecking(inputRecord,connection,interactionSpec);
			break;
		case 21:
			ReadReadCheckingForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 22:
			PartialStore(inputRecord,connection,interactionSpec);
			break;
		case 23:
			PartialStoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		}
		return outputRecord;
	}
	private static String ReadReadQuery_0 = " SELECT 1 FROM BH.TEMPVARPRICE  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SWOEE_ID = ? AND T1.PRICE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ? AND T1.ESW_PRICE = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column PRICE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(6);
				if(tempDouble != null)
					pstmt.setDouble(7,tempDouble.doubleValue());
				else
					pstmt.setNull(7,java.sql.Types.DECIMAL);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM BH.TEMPVARPRICE  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SWOEE_ID = ? AND T1.PRICE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ? AND T1.ESW_PRICE = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column PRICE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(6);
				if(tempDouble != null)
					pstmt.setDouble(7,tempDouble.doubleValue());
				else
					pstmt.setNull(7,java.sql.Types.DECIMAL);
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
		updateTemplateList = VariancePriceBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
					if (changedFieldIndexes[6])
					{
						// For column SALES_DOC_NO
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
						// For column EE_ITEM_NO
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
						// For column BILL_PLAN_ST_DATE
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
						// For column BILL_PLAN_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(9);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column ESW_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(10);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column CURRENCY
						String tempString;


						tempString=(String)inputRecord.get(11);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column INDICATOR
						String tempString;


						tempString=(String)inputRecord.get(12);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column SOLD_TO_PARTY_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(0);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column DESG_MACHINE_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(1);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column SWOEE_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(2);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column PRICE_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(3);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(4);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column SWO_ID
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
				IndexedRecord oldRecord = interactionSpec.getOldRecord();
				Object[] oldValues = new Object[1];
				oldValues[0] = oldRecord.get(10);
				String updateQuery = aTemplate.nativeOptimisticQuery(changedFieldIndexes,oldValues);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[6])
					{
						// For column SALES_DOC_NO
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
						// For column EE_ITEM_NO
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
						// For column BILL_PLAN_ST_DATE
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
						// For column BILL_PLAN_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(9);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column ESW_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(10);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column CURRENCY
						String tempString;


						tempString=(String)inputRecord.get(11);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column INDICATOR
						String tempString;


						tempString=(String)inputRecord.get(12);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column SOLD_TO_PARTY_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(0);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column DESG_MACHINE_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(1);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column SWOEE_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(2);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column PRICE_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(3);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(4);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column SWO_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(5);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					// optimistic predicate columns
					{
						// For column ESW_PRICE
						Double tempDouble;


						tempDouble=(Double)oldValues[0];
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
