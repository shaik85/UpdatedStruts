package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * HistoryEEBeanFunctionSet_2f4f3e31
 */
public class HistoryEEBeanFunctionSet_2f4f3e31 extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO BH.HISSYSTEMSWOEE (SWOEE_ID, SWO_ID, DESG_MACHINE_ID, SOLD_TO_PARTY_ID, PROPOSAL_ID, SALES_DOC_NO, EE_ITEM_NO, SWO_ITEM_NO, EE_NO, EE_DESC, PLAN_START_DATE, PLAN_END_DATE, REQST_DELIVRY_DATE, VALUE_METRIC, USE_LEVEL, LISC_TYPE, ESW_PRICE, CALC_PRICE, ALT_PRICE, BILLING_START_DATE, BILLING_END_DATE, EXCLUSION_ID, SEQUENCE_NO, BUMP_ID, CHARGE_OPTION_DESC, ALT_PRICE_ID, PRICE_EFFC_DATE, S_S_DISCOUNT_PERCENT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
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
			// For column PLAN_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(10);
				if(tempDate != null)
					pstmt.setDate(11,tempDate);
				else
					pstmt.setNull(11,java.sql.Types.DATE);
			}
			// For column PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(11);
				if(tempDate != null)
					pstmt.setDate(12,tempDate);
				else
					pstmt.setNull(12,java.sql.Types.DATE);
			}
			// For column REQST_DELIVRY_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(12);
				if(tempDate != null)
					pstmt.setDate(13,tempDate);
				else
					pstmt.setNull(13,java.sql.Types.DATE);
			}
			// For column VALUE_METRIC
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.CHAR);
			}
			// For column USE_LEVEL
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(15,tempString);
				else
					pstmt.setNull(15,java.sql.Types.CHAR);
			}
			// For column LISC_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.CHAR);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(16);
				if(tempDouble != null)
					pstmt.setDouble(17,tempDouble.doubleValue());
				else
					pstmt.setNull(17,java.sql.Types.DECIMAL);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(17);
				if(tempDouble != null)
					pstmt.setDouble(18,tempDouble.doubleValue());
				else
					pstmt.setNull(18,java.sql.Types.DECIMAL);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(18);
				if(tempDouble != null)
					pstmt.setDouble(19,tempDouble.doubleValue());
				else
					pstmt.setNull(19,java.sql.Types.DECIMAL);
			}
			// For column BILLING_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(19);
				if(tempDate != null)
					pstmt.setDate(20,tempDate);
				else
					pstmt.setNull(20,java.sql.Types.DATE);
			}
			// For column BILLING_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(20);
				if(tempDate != null)
					pstmt.setDate(21,tempDate);
				else
					pstmt.setNull(21,java.sql.Types.DATE);
			}
			// For column EXCLUSION_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.CHAR);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(22);
				if(tempInteger != null)
					pstmt.setInt(23,tempInteger.intValue());
				else
					pstmt.setNull(23,java.sql.Types.INTEGER);
			}
			// For column BUMP_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(23);
				if(tempString != null)
					pstmt.setString(24,tempString);
				else
					pstmt.setNull(24,java.sql.Types.CHAR);
			}
			// For column CHARGE_OPTION_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(24);
				if(tempString != null)
					pstmt.setString(25,tempString);
				else
					pstmt.setNull(25,java.sql.Types.CHAR);
			}
			// For column ALT_PRICE_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(25);
				if(tempString != null)
					pstmt.setString(26,tempString);
				else
					pstmt.setNull(26,java.sql.Types.CHAR);
			}
			// For column PRICE_EFFC_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(26);
				if(tempDate != null)
					pstmt.setDate(27,tempDate);
				else
					pstmt.setNull(27,java.sql.Types.DATE);
			}
			// For column S_S_DISCOUNT_PERCENT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(27);
				if(tempDouble != null)
					pstmt.setDouble(28,tempDouble.doubleValue());
				else
					pstmt.setNull(28,java.sql.Types.DECIMAL);
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
	private static String RemoveQuery_0 = "DELETE FROM BH.HISSYSTEMSWOEE  WHERE SWOEE_ID = ? AND SWO_ID = ? AND DESG_MACHINE_ID = ? AND SOLD_TO_PARTY_ID = ? AND PROPOSAL_ID = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
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
	private static String StoreQuery_0 = "UPDATE BH.HISSYSTEMSWOEE  SET SALES_DOC_NO = ?, EE_ITEM_NO = ?, SWO_ITEM_NO = ?, EE_NO = ?, EE_DESC = ?, PLAN_START_DATE = ?, PLAN_END_DATE = ?, REQST_DELIVRY_DATE = ?, VALUE_METRIC = ?, USE_LEVEL = ?, LISC_TYPE = ?, ESW_PRICE = ?, CALC_PRICE = ?, ALT_PRICE = ?, BILLING_START_DATE = ?, BILLING_END_DATE = ?, EXCLUSION_ID = ?, SEQUENCE_NO = ?, BUMP_ID = ?, CHARGE_OPTION_DESC = ?, ALT_PRICE_ID = ?, PRICE_EFFC_DATE = ?, S_S_DISCOUNT_PERCENT = ? WHERE SWOEE_ID = ? AND SWO_ID = ? AND DESG_MACHINE_ID = ? AND SOLD_TO_PARTY_ID = ? AND PROPOSAL_ID = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(24,tempInteger.intValue());
				else
					pstmt.setNull(24,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(25,tempInteger.intValue());
				else
					pstmt.setNull(25,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(26,tempInteger.intValue());
				else
					pstmt.setNull(26,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(27,tempInteger.intValue());
				else
					pstmt.setNull(27,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(28,tempInteger.intValue());
				else
					pstmt.setNull(28,java.sql.Types.INTEGER);
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
			// For column PLAN_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(10);
				if(tempDate != null)
					pstmt.setDate(6,tempDate);
				else
					pstmt.setNull(6,java.sql.Types.DATE);
			}
			// For column PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(11);
				if(tempDate != null)
					pstmt.setDate(7,tempDate);
				else
					pstmt.setNull(7,java.sql.Types.DATE);
			}
			// For column REQST_DELIVRY_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(12);
				if(tempDate != null)
					pstmt.setDate(8,tempDate);
				else
					pstmt.setNull(8,java.sql.Types.DATE);
			}
			// For column VALUE_METRIC
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column USE_LEVEL
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column LISC_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.CHAR);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(16);
				if(tempDouble != null)
					pstmt.setDouble(12,tempDouble.doubleValue());
				else
					pstmt.setNull(12,java.sql.Types.DECIMAL);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(17);
				if(tempDouble != null)
					pstmt.setDouble(13,tempDouble.doubleValue());
				else
					pstmt.setNull(13,java.sql.Types.DECIMAL);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(18);
				if(tempDouble != null)
					pstmt.setDouble(14,tempDouble.doubleValue());
				else
					pstmt.setNull(14,java.sql.Types.DECIMAL);
			}
			// For column BILLING_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(19);
				if(tempDate != null)
					pstmt.setDate(15,tempDate);
				else
					pstmt.setNull(15,java.sql.Types.DATE);
			}
			// For column BILLING_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(20);
				if(tempDate != null)
					pstmt.setDate(16,tempDate);
				else
					pstmt.setNull(16,java.sql.Types.DATE);
			}
			// For column EXCLUSION_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.CHAR);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(22);
				if(tempInteger != null)
					pstmt.setInt(18,tempInteger.intValue());
				else
					pstmt.setNull(18,java.sql.Types.INTEGER);
			}
			// For column BUMP_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(23);
				if(tempString != null)
					pstmt.setString(19,tempString);
				else
					pstmt.setNull(19,java.sql.Types.CHAR);
			}
			// For column CHARGE_OPTION_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(24);
				if(tempString != null)
					pstmt.setString(20,tempString);
				else
					pstmt.setNull(20,java.sql.Types.CHAR);
			}
			// For column ALT_PRICE_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(25);
				if(tempString != null)
					pstmt.setString(21,tempString);
				else
					pstmt.setNull(21,java.sql.Types.CHAR);
			}
			// For column PRICE_EFFC_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(26);
				if(tempDate != null)
					pstmt.setDate(22,tempDate);
				else
					pstmt.setNull(22,java.sql.Types.DATE);
			}
			// For column S_S_DISCOUNT_PERCENT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(27);
				if(tempDouble != null)
					pstmt.setDouble(23,tempDouble.doubleValue());
				else
					pstmt.setNull(23,java.sql.Types.DECIMAL);
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
	private static String StoreOCCQuery_0 = "UPDATE BH.HISSYSTEMSWOEE  SET SALES_DOC_NO = ?, EE_ITEM_NO = ?, SWO_ITEM_NO = ?, EE_NO = ?, EE_DESC = ?, PLAN_START_DATE = ?, PLAN_END_DATE = ?, REQST_DELIVRY_DATE = ?, VALUE_METRIC = ?, USE_LEVEL = ?, LISC_TYPE = ?, ESW_PRICE = ?, CALC_PRICE = ?, ALT_PRICE = ?, BILLING_START_DATE = ?, BILLING_END_DATE = ?, EXCLUSION_ID = ?, SEQUENCE_NO = ?, BUMP_ID = ?, CHARGE_OPTION_DESC = ?, ALT_PRICE_ID = ?, PRICE_EFFC_DATE = ?, S_S_DISCOUNT_PERCENT = ? WHERE SWOEE_ID = ? AND SWO_ID = ? AND DESG_MACHINE_ID = ? AND SOLD_TO_PARTY_ID = ? AND PROPOSAL_ID = ? AND ESW_PRICE = ? AND CALC_PRICE = ? AND ALT_PRICE = ? AND SEQUENCE_NO = ? AND S_S_DISCOUNT_PERCENT = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column SWOEE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(24,tempInteger.intValue());
				else
					pstmt.setNull(24,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(25,tempInteger.intValue());
				else
					pstmt.setNull(25,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(26,tempInteger.intValue());
				else
					pstmt.setNull(26,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(27,tempInteger.intValue());
				else
					pstmt.setNull(27,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(28,tempInteger.intValue());
				else
					pstmt.setNull(28,java.sql.Types.INTEGER);
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
			// For column PLAN_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(10);
				if(tempDate != null)
					pstmt.setDate(6,tempDate);
				else
					pstmt.setNull(6,java.sql.Types.DATE);
			}
			// For column PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(11);
				if(tempDate != null)
					pstmt.setDate(7,tempDate);
				else
					pstmt.setNull(7,java.sql.Types.DATE);
			}
			// For column REQST_DELIVRY_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(12);
				if(tempDate != null)
					pstmt.setDate(8,tempDate);
				else
					pstmt.setNull(8,java.sql.Types.DATE);
			}
			// For column VALUE_METRIC
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column USE_LEVEL
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column LISC_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.CHAR);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(16);
				if(tempDouble != null)
					pstmt.setDouble(12,tempDouble.doubleValue());
				else
					pstmt.setNull(12,java.sql.Types.DECIMAL);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(17);
				if(tempDouble != null)
					pstmt.setDouble(13,tempDouble.doubleValue());
				else
					pstmt.setNull(13,java.sql.Types.DECIMAL);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(18);
				if(tempDouble != null)
					pstmt.setDouble(14,tempDouble.doubleValue());
				else
					pstmt.setNull(14,java.sql.Types.DECIMAL);
			}
			// For column BILLING_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(19);
				if(tempDate != null)
					pstmt.setDate(15,tempDate);
				else
					pstmt.setNull(15,java.sql.Types.DATE);
			}
			// For column BILLING_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(20);
				if(tempDate != null)
					pstmt.setDate(16,tempDate);
				else
					pstmt.setNull(16,java.sql.Types.DATE);
			}
			// For column EXCLUSION_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.CHAR);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(22);
				if(tempInteger != null)
					pstmt.setInt(18,tempInteger.intValue());
				else
					pstmt.setNull(18,java.sql.Types.INTEGER);
			}
			// For column BUMP_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(23);
				if(tempString != null)
					pstmt.setString(19,tempString);
				else
					pstmt.setNull(19,java.sql.Types.CHAR);
			}
			// For column CHARGE_OPTION_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(24);
				if(tempString != null)
					pstmt.setString(20,tempString);
				else
					pstmt.setNull(20,java.sql.Types.CHAR);
			}
			// For column ALT_PRICE_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(25);
				if(tempString != null)
					pstmt.setString(21,tempString);
				else
					pstmt.setNull(21,java.sql.Types.CHAR);
			}
			// For column PRICE_EFFC_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(26);
				if(tempDate != null)
					pstmt.setDate(22,tempDate);
				else
					pstmt.setNull(22,java.sql.Types.DATE);
			}
			// For column S_S_DISCOUNT_PERCENT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(27);
				if(tempDouble != null)
					pstmt.setDouble(23,tempDouble.doubleValue());
				else
					pstmt.setNull(23,java.sql.Types.DECIMAL);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(16);
				if(tempDouble != null)
					pstmt.setDouble(29,tempDouble.doubleValue());
				else
					pstmt.setNull(29,java.sql.Types.DECIMAL);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(17);
				if(tempDouble != null)
					pstmt.setDouble(30,tempDouble.doubleValue());
				else
					pstmt.setNull(30,java.sql.Types.DECIMAL);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(18);
				if(tempDouble != null)
					pstmt.setDouble(31,tempDouble.doubleValue());
				else
					pstmt.setNull(31,java.sql.Types.DECIMAL);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)oldRecord.get(22);
				if(tempInteger != null)
					pstmt.setInt(32,tempInteger.intValue());
				else
					pstmt.setNull(32,java.sql.Types.INTEGER);
			}
			// For column S_S_DISCOUNT_PERCENT
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(27);
				if(tempDouble != null)
					pstmt.setDouble(33,tempDouble.doubleValue());
				else
					pstmt.setNull(33,java.sql.Types.DECIMAL);
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
	private static String findMaxEEIdQuery_0 = " select  q1.\"SWOEE_ID\",  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"EE_NO\",  q1.\"EE_DESC\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"VALUE_METRIC\",  q1.\"USE_LEVEL\",  q1.\"LISC_TYPE\",  q1.\"ESW_PRICE\",  q1.\"CALC_PRICE\",  q1.\"ALT_PRICE\",  q1.\"BILLING_START_DATE\",  q1.\"BILLING_END_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"SEQUENCE_NO\",  q1.\"BUMP_ID\",  q1.\"CHARGE_OPTION_DESC\",  q1.\"ALT_PRICE_ID\",  q1.\"PRICE_EFFC_DATE\",  q1.\"S_S_DISCOUNT_PERCENT\" from BH.HISSYSTEMSWOEE q1 where  ( q1.\"SWOEE_ID\" =  ( select  max( q2.\"SWOEE_ID\") from BH.HISSYSTEMSWOEE q2) ) ";
	/**
	 * FindMaxEEId
	 */
	public javax.resource.cci.Record FindMaxEEId(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from HistoryEE o where  o.eeId = (select max(a.eeId) from HistoryEE a) */
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
	private static String findMaxEEIdForUpdateQuery_0 = " select  q1.\"SWOEE_ID\",  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"EE_NO\",  q1.\"EE_DESC\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"VALUE_METRIC\",  q1.\"USE_LEVEL\",  q1.\"LISC_TYPE\",  q1.\"ESW_PRICE\",  q1.\"CALC_PRICE\",  q1.\"ALT_PRICE\",  q1.\"BILLING_START_DATE\",  q1.\"BILLING_END_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"SEQUENCE_NO\",  q1.\"BUMP_ID\",  q1.\"CHARGE_OPTION_DESC\",  q1.\"ALT_PRICE_ID\",  q1.\"PRICE_EFFC_DATE\",  q1.\"S_S_DISCOUNT_PERCENT\" from BH.HISSYSTEMSWOEE q1 where  ( q1.\"SWOEE_ID\" =  ( select  max( q2.\"SWOEE_ID\") from BH.HISSYSTEMSWOEE q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxEEId444Update
	 */
	public javax.resource.cci.Record FindMaxEEId444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from HistoryEE o where  o.eeId = (select max(a.eeId) from HistoryEE a) */
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
	private static String findMaxEEIdForUpdateWithRRQuery_0 = " select  q1.\"SWOEE_ID\",  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"EE_NO\",  q1.\"EE_DESC\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"VALUE_METRIC\",  q1.\"USE_LEVEL\",  q1.\"LISC_TYPE\",  q1.\"ESW_PRICE\",  q1.\"CALC_PRICE\",  q1.\"ALT_PRICE\",  q1.\"BILLING_START_DATE\",  q1.\"BILLING_END_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"SEQUENCE_NO\",  q1.\"BUMP_ID\",  q1.\"CHARGE_OPTION_DESC\",  q1.\"ALT_PRICE_ID\",  q1.\"PRICE_EFFC_DATE\",  q1.\"S_S_DISCOUNT_PERCENT\" from BH.HISSYSTEMSWOEE q1 where  ( q1.\"SWOEE_ID\" =  ( select  max( q2.\"SWOEE_ID\") from BH.HISSYSTEMSWOEE q2) )  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxEEIdForUpdateWithRR
	 */
	public javax.resource.cci.Record FindMaxEEIdForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from HistoryEE o where  o.eeId = (select max(a.eeId) from HistoryEE a) */
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
	private static String findMaxEEIdForUpdateWithRSQuery_0 = " select  q1.\"SWOEE_ID\",  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SALES_DOC_NO\",  q1.\"EE_ITEM_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"EE_NO\",  q1.\"EE_DESC\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"VALUE_METRIC\",  q1.\"USE_LEVEL\",  q1.\"LISC_TYPE\",  q1.\"ESW_PRICE\",  q1.\"CALC_PRICE\",  q1.\"ALT_PRICE\",  q1.\"BILLING_START_DATE\",  q1.\"BILLING_END_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"SEQUENCE_NO\",  q1.\"BUMP_ID\",  q1.\"CHARGE_OPTION_DESC\",  q1.\"ALT_PRICE_ID\",  q1.\"PRICE_EFFC_DATE\",  q1.\"S_S_DISCOUNT_PERCENT\" from BH.HISSYSTEMSWOEE q1 where  ( q1.\"SWOEE_ID\" =  ( select  max( q2.\"SWOEE_ID\") from BH.HISSYSTEMSWOEE q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxEEIdForUpdateWithRS
	 */
	public javax.resource.cci.Record FindMaxEEIdForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from HistoryEE o where  o.eeId = (select max(a.eeId) from HistoryEE a) */
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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.SWOEE_ID, T1.SWO_ID, T1.DESG_MACHINE_ID, T1.SOLD_TO_PARTY_ID, T1.PROPOSAL_ID, T1.SALES_DOC_NO, T1.EE_ITEM_NO, T1.SWO_ITEM_NO, T1.EE_NO, T1.EE_DESC, T1.PLAN_START_DATE, T1.PLAN_END_DATE, T1.REQST_DELIVRY_DATE, T1.VALUE_METRIC, T1.USE_LEVEL, T1.LISC_TYPE, T1.ESW_PRICE, T1.CALC_PRICE, T1.ALT_PRICE, T1.BILLING_START_DATE, T1.BILLING_END_DATE, T1.EXCLUSION_ID, T1.SEQUENCE_NO, T1.BUMP_ID, T1.CHARGE_OPTION_DESC, T1.ALT_PRICE_ID, T1.PRICE_EFFC_DATE, T1.S_S_DISCOUNT_PERCENT FROM BH.HISSYSTEMSWOEE  T1 WHERE T1.SWOEE_ID = ? AND T1.SWO_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ?";
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.SWOEE_ID, T1.SWO_ID, T1.DESG_MACHINE_ID, T1.SOLD_TO_PARTY_ID, T1.PROPOSAL_ID, T1.SALES_DOC_NO, T1.EE_ITEM_NO, T1.SWO_ITEM_NO, T1.EE_NO, T1.EE_DESC, T1.PLAN_START_DATE, T1.PLAN_END_DATE, T1.REQST_DELIVRY_DATE, T1.VALUE_METRIC, T1.USE_LEVEL, T1.LISC_TYPE, T1.ESW_PRICE, T1.CALC_PRICE, T1.ALT_PRICE, T1.BILLING_START_DATE, T1.BILLING_END_DATE, T1.EXCLUSION_ID, T1.SEQUENCE_NO, T1.BUMP_ID, T1.CHARGE_OPTION_DESC, T1.ALT_PRICE_ID, T1.PRICE_EFFC_DATE, T1.S_S_DISCOUNT_PERCENT FROM BH.HISSYSTEMSWOEE  T1 WHERE T1.SWOEE_ID = ? AND T1.SWO_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
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
	private static String FindByPrimaryKeyForUpdateWithRRQuery_0 = " SELECT T1.SWOEE_ID, T1.SWO_ID, T1.DESG_MACHINE_ID, T1.SOLD_TO_PARTY_ID, T1.PROPOSAL_ID, T1.SALES_DOC_NO, T1.EE_ITEM_NO, T1.SWO_ITEM_NO, T1.EE_NO, T1.EE_DESC, T1.PLAN_START_DATE, T1.PLAN_END_DATE, T1.REQST_DELIVRY_DATE, T1.VALUE_METRIC, T1.USE_LEVEL, T1.LISC_TYPE, T1.ESW_PRICE, T1.CALC_PRICE, T1.ALT_PRICE, T1.BILLING_START_DATE, T1.BILLING_END_DATE, T1.EXCLUSION_ID, T1.SEQUENCE_NO, T1.BUMP_ID, T1.CHARGE_OPTION_DESC, T1.ALT_PRICE_ID, T1.PRICE_EFFC_DATE, T1.S_S_DISCOUNT_PERCENT FROM BH.HISSYSTEMSWOEE  T1 WHERE T1.SWOEE_ID = ? AND T1.SWO_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ? FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
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
	private static String FindByPrimaryKeyForUpdateWithRSQuery_0 = " SELECT T1.SWOEE_ID, T1.SWO_ID, T1.DESG_MACHINE_ID, T1.SOLD_TO_PARTY_ID, T1.PROPOSAL_ID, T1.SALES_DOC_NO, T1.EE_ITEM_NO, T1.SWO_ITEM_NO, T1.EE_NO, T1.EE_DESC, T1.PLAN_START_DATE, T1.PLAN_END_DATE, T1.REQST_DELIVRY_DATE, T1.VALUE_METRIC, T1.USE_LEVEL, T1.LISC_TYPE, T1.ESW_PRICE, T1.CALC_PRICE, T1.ALT_PRICE, T1.BILLING_START_DATE, T1.BILLING_END_DATE, T1.EXCLUSION_ID, T1.SEQUENCE_NO, T1.BUMP_ID, T1.CHARGE_OPTION_DESC, T1.ALT_PRICE_ID, T1.PRICE_EFFC_DATE, T1.S_S_DISCOUNT_PERCENT FROM BH.HISSYSTEMSWOEE  T1 WHERE T1.SWOEE_ID = ? AND T1.SWO_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
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
	 * HistoryEEBeanFunctionSet_2f4f3e31
	 */
	public HistoryEEBeanFunctionSet_2f4f3e31() {
		functionHash=new java.util.HashMap(16);

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
		functionHash.put("ReadReadChecking",new Integer(12));
		functionHash.put("ReadReadCheckingForUpdate",new Integer(13));
		functionHash.put("PartialStore",new Integer(14));
		functionHash.put("PartialStoreUsingOCC",new Integer(15));
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
			ReadReadChecking(inputRecord,connection,interactionSpec);
			break;
		case 13:
			ReadReadCheckingForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 14:
			PartialStore(inputRecord,connection,interactionSpec);
			break;
		case 15:
			PartialStoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		}
		return outputRecord;
	}
	private static String ReadReadQuery_0 = " SELECT 1 FROM BH.HISSYSTEMSWOEE  T1 WHERE T1.SWOEE_ID = ? AND T1.SWO_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ? AND T1.ESW_PRICE = ? AND T1.CALC_PRICE = ? AND T1.ALT_PRICE = ? AND T1.SEQUENCE_NO = ? AND T1.S_S_DISCOUNT_PERCENT = ?";
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
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
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(5);
				if(tempDouble != null)
					pstmt.setDouble(6,tempDouble.doubleValue());
				else
					pstmt.setNull(6,java.sql.Types.DECIMAL);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(6);
				if(tempDouble != null)
					pstmt.setDouble(7,tempDouble.doubleValue());
				else
					pstmt.setNull(7,java.sql.Types.DECIMAL);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(7);
				if(tempDouble != null)
					pstmt.setDouble(8,tempDouble.doubleValue());
				else
					pstmt.setNull(8,java.sql.Types.DECIMAL);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(8);
				if(tempInteger != null)
					pstmt.setInt(9,tempInteger.intValue());
				else
					pstmt.setNull(9,java.sql.Types.INTEGER);
			}
			// For column S_S_DISCOUNT_PERCENT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(9);
				if(tempDouble != null)
					pstmt.setDouble(10,tempDouble.doubleValue());
				else
					pstmt.setNull(10,java.sql.Types.DECIMAL);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM BH.HISSYSTEMSWOEE  T1 WHERE T1.SWOEE_ID = ? AND T1.SWO_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ? AND T1.ESW_PRICE = ? AND T1.CALC_PRICE = ? AND T1.ALT_PRICE = ? AND T1.SEQUENCE_NO = ? AND T1.S_S_DISCOUNT_PERCENT = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
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
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(5);
				if(tempDouble != null)
					pstmt.setDouble(6,tempDouble.doubleValue());
				else
					pstmt.setNull(6,java.sql.Types.DECIMAL);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(6);
				if(tempDouble != null)
					pstmt.setDouble(7,tempDouble.doubleValue());
				else
					pstmt.setNull(7,java.sql.Types.DECIMAL);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(7);
				if(tempDouble != null)
					pstmt.setDouble(8,tempDouble.doubleValue());
				else
					pstmt.setNull(8,java.sql.Types.DECIMAL);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(8);
				if(tempInteger != null)
					pstmt.setInt(9,tempInteger.intValue());
				else
					pstmt.setNull(9,java.sql.Types.INTEGER);
			}
			// For column S_S_DISCOUNT_PERCENT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(9);
				if(tempDouble != null)
					pstmt.setDouble(10,tempDouble.doubleValue());
				else
					pstmt.setNull(10,java.sql.Types.DECIMAL);
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
		updateTemplateList = HistoryEEBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
						// For column PLAN_START_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(10);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column PLAN_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(11);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column REQST_DELIVRY_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(12);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column VALUE_METRIC
						String tempString;


						tempString=(String)inputRecord.get(13);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column USE_LEVEL
						String tempString;


						tempString=(String)inputRecord.get(14);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column LISC_TYPE
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
						// For column ESW_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(16);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[17])
					{
						// For column CALC_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(17);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[18])
					{
						// For column ALT_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(18);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[19])
					{
						// For column BILLING_START_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(19);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column BILLING_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(20);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column EXCLUSION_ID
						String tempString;


						tempString=(String)inputRecord.get(21);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column SEQUENCE_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(22);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[23])
					{
						// For column BUMP_ID
						String tempString;


						tempString=(String)inputRecord.get(23);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[24])
					{
						// For column CHARGE_OPTION_DESC
						String tempString;


						tempString=(String)inputRecord.get(24);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[25])
					{
						// For column ALT_PRICE_ID
						String tempString;


						tempString=(String)inputRecord.get(25);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[26])
					{
						// For column PRICE_EFFC_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(26);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[27])
					{
						// For column S_S_DISCOUNT_PERCENT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(27);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column SWOEE_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(0);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column SWO_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(1);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column DESG_MACHINE_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(2);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column SOLD_TO_PARTY_ID
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
				Object[] oldValues = new Object[5];
				oldValues[0] = oldRecord.get(16);
				oldValues[1] = oldRecord.get(17);
				oldValues[2] = oldRecord.get(18);
				oldValues[3] = oldRecord.get(22);
				oldValues[4] = oldRecord.get(27);
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
						// For column PLAN_START_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(10);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column PLAN_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(11);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column REQST_DELIVRY_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(12);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column VALUE_METRIC
						String tempString;


						tempString=(String)inputRecord.get(13);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column USE_LEVEL
						String tempString;


						tempString=(String)inputRecord.get(14);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column LISC_TYPE
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
						// For column ESW_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(16);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[17])
					{
						// For column CALC_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(17);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[18])
					{
						// For column ALT_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(18);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[19])
					{
						// For column BILLING_START_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(19);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column BILLING_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(20);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column EXCLUSION_ID
						String tempString;


						tempString=(String)inputRecord.get(21);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column SEQUENCE_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(22);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[23])
					{
						// For column BUMP_ID
						String tempString;


						tempString=(String)inputRecord.get(23);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[24])
					{
						// For column CHARGE_OPTION_DESC
						String tempString;


						tempString=(String)inputRecord.get(24);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[25])
					{
						// For column ALT_PRICE_ID
						String tempString;


						tempString=(String)inputRecord.get(25);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[26])
					{
						// For column PRICE_EFFC_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(26);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[27])
					{
						// For column S_S_DISCOUNT_PERCENT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(27);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column SWOEE_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(0);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column SWO_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(1);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column DESG_MACHINE_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(2);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column SOLD_TO_PARTY_ID
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
						// For column CALC_PRICE
						Double tempDouble;


						tempDouble=(Double)oldValues[1];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column ALT_PRICE
						Double tempDouble;


						tempDouble=(Double)oldValues[2];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column SEQUENCE_NO
						Integer tempInteger;


						tempInteger=(Integer)oldValues[3];
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;
						}

					}
					{
						// For column S_S_DISCOUNT_PERCENT
						Double tempDouble;


						tempDouble=(Double)oldValues[4];
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
