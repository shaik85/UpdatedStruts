package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * VarianceEEBeanFunctionSet_4da349e6
 */
public class VarianceEEBeanFunctionSet_4da349e6 extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO BH.TEMPVARSYSTEMSWOEE (SOLD_TO_PARTY_ID, DESG_MACHINE_ID, SWOEE_ID, PROPOSAL_ID, SWO_ID, SALES_DOC_NO, EE_ITEM_NO, SWO_ITEM_NO, EE_NO, EE_DESC, VALUE_METRIC, USE_LEVEL, LISC_TYPE, ESW_PRICE, SEQUENCE_NO, CHARGE_OPTION, CHARGE_OPTION_DESC) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column SALES_DOC_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column EE_ITEM_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			// For column SWO_ITEM_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column EE_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column EE_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column VALUE_METRIC
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.CHAR);
			}
			// For column USE_LEVEL
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.CHAR);
			}
			// For column LISC_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.CHAR);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(13);
				if(tempDouble != null)
					pstmt.setDouble(14,tempDouble.doubleValue());
				else
					pstmt.setNull(14,java.sql.Types.DECIMAL);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(14);
				if(tempInteger != null)
					pstmt.setInt(15,tempInteger.intValue());
				else
					pstmt.setNull(15,java.sql.Types.INTEGER);
			}
			// For column CHARGE_OPTION
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.CHAR);
			}
			// For column CHARGE_OPTION_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.CHAR);
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
	private static String RemoveQuery_0 = "DELETE FROM BH.TEMPVARSYSTEMSWOEE  WHERE SOLD_TO_PARTY_ID = ? AND DESG_MACHINE_ID = ? AND SWOEE_ID = ? AND PROPOSAL_ID = ? AND SWO_ID = ?";
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
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
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
	private static String StoreQuery_0 = "UPDATE BH.TEMPVARSYSTEMSWOEE  SET SALES_DOC_NO = ?, EE_ITEM_NO = ?, SWO_ITEM_NO = ?, EE_NO = ?, EE_DESC = ?, VALUE_METRIC = ?, USE_LEVEL = ?, LISC_TYPE = ?, ESW_PRICE = ?, SEQUENCE_NO = ?, CHARGE_OPTION = ?, CHARGE_OPTION_DESC = ? WHERE SOLD_TO_PARTY_ID = ? AND DESG_MACHINE_ID = ? AND SWOEE_ID = ? AND PROPOSAL_ID = ? AND SWO_ID = ?";
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
					pstmt.setInt(13,tempInteger.intValue());
				else
					pstmt.setNull(13,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(14,tempInteger.intValue());
				else
					pstmt.setNull(14,java.sql.Types.INTEGER);
			}
			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(15,tempInteger.intValue());
				else
					pstmt.setNull(15,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(16,tempInteger.intValue());
				else
					pstmt.setNull(16,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(17,tempInteger.intValue());
				else
					pstmt.setNull(17,java.sql.Types.INTEGER);
			}
			// For column SALES_DOC_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column EE_ITEM_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column SWO_ITEM_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.CHAR);
			}
			// For column EE_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.CHAR);
			}
			// For column EE_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column VALUE_METRIC
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column USE_LEVEL
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			// For column LISC_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(13);
				if(tempDouble != null)
					pstmt.setDouble(9,tempDouble.doubleValue());
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(14);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			// For column CHARGE_OPTION
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.CHAR);
			}
			// For column CHARGE_OPTION_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.CHAR);
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
	private static String StoreOCCQuery_0 = "UPDATE BH.TEMPVARSYSTEMSWOEE  SET SALES_DOC_NO = ?, EE_ITEM_NO = ?, SWO_ITEM_NO = ?, EE_NO = ?, EE_DESC = ?, VALUE_METRIC = ?, USE_LEVEL = ?, LISC_TYPE = ?, ESW_PRICE = ?, SEQUENCE_NO = ?, CHARGE_OPTION = ?, CHARGE_OPTION_DESC = ? WHERE SOLD_TO_PARTY_ID = ? AND DESG_MACHINE_ID = ? AND SWOEE_ID = ? AND PROPOSAL_ID = ? AND SWO_ID = ? AND ESW_PRICE = ? AND SEQUENCE_NO = ?";
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
					pstmt.setInt(13,tempInteger.intValue());
				else
					pstmt.setNull(13,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(14,tempInteger.intValue());
				else
					pstmt.setNull(14,java.sql.Types.INTEGER);
			}
			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(15,tempInteger.intValue());
				else
					pstmt.setNull(15,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(16,tempInteger.intValue());
				else
					pstmt.setNull(16,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(17,tempInteger.intValue());
				else
					pstmt.setNull(17,java.sql.Types.INTEGER);
			}
			// For column SALES_DOC_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column EE_ITEM_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column SWO_ITEM_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.CHAR);
			}
			// For column EE_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.CHAR);
			}
			// For column EE_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column VALUE_METRIC
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column USE_LEVEL
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			// For column LISC_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(13);
				if(tempDouble != null)
					pstmt.setDouble(9,tempDouble.doubleValue());
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(14);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			// For column CHARGE_OPTION
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.CHAR);
			}
			// For column CHARGE_OPTION_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.CHAR);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(13);
				if(tempDouble != null)
					pstmt.setDouble(18,tempDouble.doubleValue());
				else
					pstmt.setNull(18,java.sql.Types.DECIMAL);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)oldRecord.get(14);
				if(tempInteger != null)
					pstmt.setInt(19,tempInteger.intValue());
				else
					pstmt.setNull(19,java.sql.Types.INTEGER);
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
	private static String findMaxEEIdQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"EE_NO\",  q1.\"EE_DESC\",  q1.\"VALUE_METRIC\",  q1.\"USE_LEVEL\",  q1.\"LISC_TYPE\",  q1.\"ESW_PRICE\",  q1.\"SEQUENCE_NO\",  q1.\"CHARGE_OPTION\",  q1.\"CHARGE_OPTION_DESC\" from BH.TEMPVARSYSTEMSWOEE q1 where  ( q1.\"SWOEE_ID\" =  ( select  max( q2.\"SWOEE_ID\") from BH.TEMPVARSYSTEMSWOEE q2) ) ";
	/**
	 * FindMaxEEId
	 */
	public javax.resource.cci.Record FindMaxEEId(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VarianceEE o where   o.eeId = (select max(a.eeId) from VarianceEE a) */
			pstmt = prepareStatement(connection, findMaxEEIdQuery_0);

			result = executeQuery(connection, pstmt, findMaxEEIdQuery_0);

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
	private static String findMaxEEIdForUpdateQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"EE_NO\",  q1.\"EE_DESC\",  q1.\"VALUE_METRIC\",  q1.\"USE_LEVEL\",  q1.\"LISC_TYPE\",  q1.\"ESW_PRICE\",  q1.\"SEQUENCE_NO\",  q1.\"CHARGE_OPTION\",  q1.\"CHARGE_OPTION_DESC\" from BH.TEMPVARSYSTEMSWOEE q1 where  ( q1.\"SWOEE_ID\" =  ( select  max( q2.\"SWOEE_ID\") from BH.TEMPVARSYSTEMSWOEE q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxEEId444Update
	 */
	public javax.resource.cci.Record FindMaxEEId444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VarianceEE o where   o.eeId = (select max(a.eeId) from VarianceEE a) */
			pstmt = prepareStatement(connection, findMaxEEIdForUpdateQuery_0);

			result = executeQuery(connection, pstmt, findMaxEEIdForUpdateQuery_0);

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
	private static String findMaxEEIdForUpdateWithRRQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"EE_NO\",  q1.\"EE_DESC\",  q1.\"VALUE_METRIC\",  q1.\"USE_LEVEL\",  q1.\"LISC_TYPE\",  q1.\"ESW_PRICE\",  q1.\"SEQUENCE_NO\",  q1.\"CHARGE_OPTION\",  q1.\"CHARGE_OPTION_DESC\" from BH.TEMPVARSYSTEMSWOEE q1 where  ( q1.\"SWOEE_ID\" =  ( select  max( q2.\"SWOEE_ID\") from BH.TEMPVARSYSTEMSWOEE q2) )  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxEEIdForUpdateWithRR
	 */
	public javax.resource.cci.Record FindMaxEEIdForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VarianceEE o where   o.eeId = (select max(a.eeId) from VarianceEE a) */
			pstmt = prepareStatement(connection, findMaxEEIdForUpdateWithRRQuery_0);

			result = executeQuery(connection, pstmt, findMaxEEIdForUpdateWithRRQuery_0);

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
	private static String findMaxEEIdForUpdateWithRSQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"EE_NO\",  q1.\"EE_DESC\",  q1.\"VALUE_METRIC\",  q1.\"USE_LEVEL\",  q1.\"LISC_TYPE\",  q1.\"ESW_PRICE\",  q1.\"SEQUENCE_NO\",  q1.\"CHARGE_OPTION\",  q1.\"CHARGE_OPTION_DESC\" from BH.TEMPVARSYSTEMSWOEE q1 where  ( q1.\"SWOEE_ID\" =  ( select  max( q2.\"SWOEE_ID\") from BH.TEMPVARSYSTEMSWOEE q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxEEIdForUpdateWithRS
	 */
	public javax.resource.cci.Record FindMaxEEIdForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VarianceEE o where   o.eeId = (select max(a.eeId) from VarianceEE a) */
			pstmt = prepareStatement(connection, findMaxEEIdForUpdateWithRSQuery_0);

			result = executeQuery(connection, pstmt, findMaxEEIdForUpdateWithRSQuery_0);

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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.SOLD_TO_PARTY_ID, T1.DESG_MACHINE_ID, T1.SWOEE_ID, T1.PROPOSAL_ID, T1.SWO_ID, T1.SALES_DOC_NO, T1.EE_ITEM_NO, T1.SWO_ITEM_NO, T1.EE_NO, T1.EE_DESC, T1.VALUE_METRIC, T1.USE_LEVEL, T1.LISC_TYPE, T1.ESW_PRICE, T1.SEQUENCE_NO, T1.CHARGE_OPTION, T1.CHARGE_OPTION_DESC FROM BH.TEMPVARSYSTEMSWOEE  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SWOEE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.SOLD_TO_PARTY_ID, T1.DESG_MACHINE_ID, T1.SWOEE_ID, T1.PROPOSAL_ID, T1.SWO_ID, T1.SALES_DOC_NO, T1.EE_ITEM_NO, T1.SWO_ITEM_NO, T1.EE_NO, T1.EE_DESC, T1.VALUE_METRIC, T1.USE_LEVEL, T1.LISC_TYPE, T1.ESW_PRICE, T1.SEQUENCE_NO, T1.CHARGE_OPTION, T1.CHARGE_OPTION_DESC FROM BH.TEMPVARSYSTEMSWOEE  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SWOEE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
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
	private static String FindByPrimaryKeyForUpdateWithRRQuery_0 = " SELECT T1.SOLD_TO_PARTY_ID, T1.DESG_MACHINE_ID, T1.SWOEE_ID, T1.PROPOSAL_ID, T1.SWO_ID, T1.SALES_DOC_NO, T1.EE_ITEM_NO, T1.SWO_ITEM_NO, T1.EE_NO, T1.EE_DESC, T1.VALUE_METRIC, T1.USE_LEVEL, T1.LISC_TYPE, T1.ESW_PRICE, T1.SEQUENCE_NO, T1.CHARGE_OPTION, T1.CHARGE_OPTION_DESC FROM BH.TEMPVARSYSTEMSWOEE  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SWOEE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ? FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRRQuery_0);

			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
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
	private static String FindByPrimaryKeyForUpdateWithRSQuery_0 = " SELECT T1.SOLD_TO_PARTY_ID, T1.DESG_MACHINE_ID, T1.SWOEE_ID, T1.PROPOSAL_ID, T1.SWO_ID, T1.SALES_DOC_NO, T1.EE_ITEM_NO, T1.SWO_ITEM_NO, T1.EE_NO, T1.EE_DESC, T1.VALUE_METRIC, T1.USE_LEVEL, T1.LISC_TYPE, T1.ESW_PRICE, T1.SEQUENCE_NO, T1.CHARGE_OPTION, T1.CHARGE_OPTION_DESC FROM BH.TEMPVARSYSTEMSWOEE  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SWOEE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRSQuery_0);

			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
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
	private static String findBySWOQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"EE_NO\",  q1.\"EE_DESC\",  q1.\"VALUE_METRIC\",  q1.\"USE_LEVEL\",  q1.\"LISC_TYPE\",  q1.\"ESW_PRICE\",  q1.\"SEQUENCE_NO\",  q1.\"CHARGE_OPTION\",  q1.\"CHARGE_OPTION_DESC\" from BH.TEMPVARSYSTEMSWOEE q1 where  ( q1.\"SWO_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?) ";
	/**
	 * FindBySWO
	 */
	public javax.resource.cci.Record FindBySWO(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VarianceEE o where  o.swoId = ?1 and  o.dmId = ?2 and  o.customerId = ?3 and  o.proposalId = ?4 */
			pstmt = prepareStatement(connection, findBySWOQuery_0);

			// For ?1 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findBySWOQuery_0);

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
	private static String findBySWOForUpdateQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"EE_NO\",  q1.\"EE_DESC\",  q1.\"VALUE_METRIC\",  q1.\"USE_LEVEL\",  q1.\"LISC_TYPE\",  q1.\"ESW_PRICE\",  q1.\"SEQUENCE_NO\",  q1.\"CHARGE_OPTION\",  q1.\"CHARGE_OPTION_DESC\" from BH.TEMPVARSYSTEMSWOEE q1 where  ( q1.\"SWO_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySWO444Update
	 */
	public javax.resource.cci.Record FindBySWO444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VarianceEE o where  o.swoId = ?1 and  o.dmId = ?2 and  o.customerId = ?3 and  o.proposalId = ?4 */
			pstmt = prepareStatement(connection, findBySWOForUpdateQuery_0);

			// For ?1 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findBySWOForUpdateQuery_0);

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
	private static String findBySWOForUpdateWithRRQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"EE_NO\",  q1.\"EE_DESC\",  q1.\"VALUE_METRIC\",  q1.\"USE_LEVEL\",  q1.\"LISC_TYPE\",  q1.\"ESW_PRICE\",  q1.\"SEQUENCE_NO\",  q1.\"CHARGE_OPTION\",  q1.\"CHARGE_OPTION_DESC\" from BH.TEMPVARSYSTEMSWOEE q1 where  ( q1.\"SWO_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySWOForUpdateWithRR
	 */
	public javax.resource.cci.Record FindBySWOForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VarianceEE o where  o.swoId = ?1 and  o.dmId = ?2 and  o.customerId = ?3 and  o.proposalId = ?4 */
			pstmt = prepareStatement(connection, findBySWOForUpdateWithRRQuery_0);

			// For ?1 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findBySWOForUpdateWithRRQuery_0);

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
	private static String findBySWOForUpdateWithRSQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SWOEE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"EE_NO\",  q1.\"EE_DESC\",  q1.\"VALUE_METRIC\",  q1.\"USE_LEVEL\",  q1.\"LISC_TYPE\",  q1.\"ESW_PRICE\",  q1.\"SEQUENCE_NO\",  q1.\"CHARGE_OPTION\",  q1.\"CHARGE_OPTION_DESC\" from BH.TEMPVARSYSTEMSWOEE q1 where  ( q1.\"SWO_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySWOForUpdateWithRS
	 */
	public javax.resource.cci.Record FindBySWOForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from VarianceEE o where  o.swoId = ?1 and  o.dmId = ?2 and  o.customerId = ?3 and  o.proposalId = ?4 */
			pstmt = prepareStatement(connection, findBySWOForUpdateWithRSQuery_0);

			// For ?1 (swoid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (dmid)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (custometId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findBySWOForUpdateWithRSQuery_0);

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
	 * VarianceEEBeanFunctionSet_4da349e6
	 */
	public VarianceEEBeanFunctionSet_4da349e6() {
		functionHash=new java.util.HashMap(20);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindMaxEEId",new Integer(4));
		functionHash.put("FindMaxEEId444Update",new Integer(5));
		functionHash.put("FindMaxEEIdForUpdateWithRR",new Integer(6));
		functionHash.put("FindMaxEEIdForUpdateWithRS",new Integer(7));
		functionHash.put("FindByPrimaryKey",new Integer(8));
		functionHash.put("FindByPrimaryKey444Update",new Integer(9));
		functionHash.put("FindByPrimaryKeyForUpdateWithRR",new Integer(10));
		functionHash.put("FindByPrimaryKeyForUpdateWithRS",new Integer(11));
		functionHash.put("FindBySWO",new Integer(12));
		functionHash.put("FindBySWO444Update",new Integer(13));
		functionHash.put("FindBySWOForUpdateWithRR",new Integer(14));
		functionHash.put("FindBySWOForUpdateWithRS",new Integer(15));
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
			outputRecord=FindMaxEEId(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindMaxEEId444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindMaxEEIdForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindMaxEEIdForUpdateWithRS(inputRecord,connection,interactionSpec);
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
			outputRecord=FindBySWO(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=FindBySWO444Update(inputRecord,connection,interactionSpec);
			break;
		case 14:
			outputRecord=FindBySWOForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 15:
			outputRecord=FindBySWOForUpdateWithRS(inputRecord,connection,interactionSpec);
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
	private static String ReadReadQuery_0 = " SELECT 1 FROM BH.TEMPVARSYSTEMSWOEE  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SWOEE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ? AND T1.ESW_PRICE = ? AND T1.SEQUENCE_NO = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(5);
				if(tempDouble != null)
					pstmt.setDouble(6,tempDouble.doubleValue());
				else
					pstmt.setNull(6,java.sql.Types.DECIMAL);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(6);
				if(tempInteger != null)
					pstmt.setInt(7,tempInteger.intValue());
				else
					pstmt.setNull(7,java.sql.Types.INTEGER);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM BH.TEMPVARSYSTEMSWOEE  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SWOEE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ? AND T1.ESW_PRICE = ? AND T1.SEQUENCE_NO = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(5);
				if(tempDouble != null)
					pstmt.setDouble(6,tempDouble.doubleValue());
				else
					pstmt.setNull(6,java.sql.Types.DECIMAL);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(6);
				if(tempInteger != null)
					pstmt.setInt(7,tempInteger.intValue());
				else
					pstmt.setNull(7,java.sql.Types.INTEGER);
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
		updateTemplateList = VarianceEEBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
					if (changedFieldIndexes[5])
					{
						// For column SALES_DOC_NO
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
						// For column EE_ITEM_NO
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
						// For column SWO_ITEM_NO
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
						// For column EE_NO
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
						// For column EE_DESC
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
						// For column VALUE_METRIC
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
						// For column USE_LEVEL
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
						// For column LISC_TYPE
						String tempString;


						tempString=(String)inputRecord.get(12);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column ESW_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(13);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column SEQUENCE_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(14);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column CHARGE_OPTION
						String tempString;


						tempString=(String)inputRecord.get(15);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column CHARGE_OPTION_DESC
						String tempString;


						tempString=(String)inputRecord.get(16);
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
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(3);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column SWO_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(4);
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
				oldValues[0] = oldRecord.get(13);
				oldValues[1] = oldRecord.get(14);
				String updateQuery = aTemplate.nativeOptimisticQuery(changedFieldIndexes,oldValues);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[5])
					{
						// For column SALES_DOC_NO
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
						// For column EE_ITEM_NO
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
						// For column SWO_ITEM_NO
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
						// For column EE_NO
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
						// For column EE_DESC
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
						// For column VALUE_METRIC
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
						// For column USE_LEVEL
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
						// For column LISC_TYPE
						String tempString;


						tempString=(String)inputRecord.get(12);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column ESW_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(13);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column SEQUENCE_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(14);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column CHARGE_OPTION
						String tempString;


						tempString=(String)inputRecord.get(15);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column CHARGE_OPTION_DESC
						String tempString;


						tempString=(String)inputRecord.get(16);
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
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(3);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column SWO_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(4);
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
					{
						// For column SEQUENCE_NO
						Integer tempInteger;


						tempInteger=(Integer)oldValues[1];
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
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
