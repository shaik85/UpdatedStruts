package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * SWOBeanFunctionSet_05de4b81
 */
public class SWOBeanFunctionSet_05de4b81 extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO BH.SYSTEMSWO (SWO_ID, DESG_MACHINE_ID, SOLD_TO_PARTY_ID, PROPOSAL_ID, LOCKED_IND, DELTA_FETCH_ID, ADJUSTMENT_AMT, LAST_UPDATED_DATE, EXCLUSION_ID, BUMP_IND, AMDT_START_DATE, SWO_NO, OLD_CALC_PRICE, AMDT_IND, ESW_PRICE, PLANNED_IND, ALT_PRICE_IND, REF_SER_NO_DESGMC, REF_SERIAL_NO, ALT_PRICE, CALC_PRICE, CUSTOMER_PO_NO, PLAN_START_DATE, ITEM_CATEGORY, SEQUENCE_NO, EQUIPMENT_NO, SWO_ITEM_NO, SALES_DOC_NO, SWO_DESC, PLAN_END_DATE, REQST_DELIVRY_DATE, DUPLICATE_DELETED_IND, S_S_INDICATOR, SERIAL_NO, AMDT_END_DATE, SWO_ADDED_DATE, RE_FETCH_ID, SWO_EXT_CNTR_NUM, SWO_CNTR_STATUS, SWO_CNTR_TYPE, ALT_PRICE_UPDATE_IND, PLAN_DATE_IND) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column SWO_ID
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
			// For column SOLD_TO_PARTY_ID
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
			// For column LOCKED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column DELTA_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column ADJUSTMENT_AMT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(6);
				if(tempDouble != null)
					pstmt.setDouble(7,tempDouble.doubleValue());
				else
					pstmt.setNull(7,java.sql.Types.DECIMAL);
			}
			// For column LAST_UPDATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(7);
				if(tempDate != null)
					pstmt.setDate(8,tempDate);
				else
					pstmt.setNull(8,java.sql.Types.DATE);
			}
			// For column EXCLUSION_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column BUMP_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column AMDT_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(10);
				if(tempDate != null)
					pstmt.setDate(11,tempDate);
				else
					pstmt.setNull(11,java.sql.Types.DATE);
			}
			// For column SWO_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.CHAR);
			}
			// For column OLD_CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(12);
				if(tempDouble != null)
					pstmt.setDouble(13,tempDouble.doubleValue());
				else
					pstmt.setNull(13,java.sql.Types.DECIMAL);
			}
			// For column AMDT_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.CHAR);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(14);
				if(tempDouble != null)
					pstmt.setDouble(15,tempDouble.doubleValue());
				else
					pstmt.setNull(15,java.sql.Types.DECIMAL);
			}
			// For column PLANNED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.CHAR);
			}
			// For column ALT_PRICE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.CHAR);
			}
			// For column REF_SER_NO_DESGMC
			{
				String tempString;


				tempString=(String)inputRecord.get(17);
				if(tempString != null)
					pstmt.setString(18,tempString);
				else
					pstmt.setNull(18,java.sql.Types.CHAR);
			}
			// For column REF_SERIAL_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(18);
				if(tempString != null)
					pstmt.setString(19,tempString);
				else
					pstmt.setNull(19,java.sql.Types.CHAR);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(19);
				if(tempDouble != null)
					pstmt.setDouble(20,tempDouble.doubleValue());
				else
					pstmt.setNull(20,java.sql.Types.DECIMAL);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(20);
				if(tempDouble != null)
					pstmt.setDouble(21,tempDouble.doubleValue());
				else
					pstmt.setNull(21,java.sql.Types.DECIMAL);
			}
			// For column CUSTOMER_PO_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.CHAR);
			}
			// For column PLAN_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(22);
				if(tempDate != null)
					pstmt.setDate(23,tempDate);
				else
					pstmt.setNull(23,java.sql.Types.DATE);
			}
			// For column ITEM_CATEGORY
			{
				String tempString;


				tempString=(String)inputRecord.get(23);
				if(tempString != null)
					pstmt.setString(24,tempString);
				else
					pstmt.setNull(24,java.sql.Types.CHAR);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(24);
				if(tempInteger != null)
					pstmt.setInt(25,tempInteger.intValue());
				else
					pstmt.setNull(25,java.sql.Types.INTEGER);
			}
			// For column EQUIPMENT_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(25);
				if(tempString != null)
					pstmt.setString(26,tempString);
				else
					pstmt.setNull(26,java.sql.Types.CHAR);
			}
			// For column SWO_ITEM_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(26);
				if(tempString != null)
					pstmt.setString(27,tempString);
				else
					pstmt.setNull(27,java.sql.Types.CHAR);
			}
			// For column SALES_DOC_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(27);
				if(tempString != null)
					pstmt.setString(28,tempString);
				else
					pstmt.setNull(28,java.sql.Types.CHAR);
			}
			// For column SWO_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(28);
				if(tempString != null)
					pstmt.setString(29,tempString);
				else
					pstmt.setNull(29,java.sql.Types.CHAR);
			}
			// For column PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(29);
				if(tempDate != null)
					pstmt.setDate(30,tempDate);
				else
					pstmt.setNull(30,java.sql.Types.DATE);
			}
			// For column REQST_DELIVRY_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(30);
				if(tempDate != null)
					pstmt.setDate(31,tempDate);
				else
					pstmt.setNull(31,java.sql.Types.DATE);
			}
			// For column DUPLICATE_DELETED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(31);
				if(tempString != null)
					pstmt.setString(32,tempString);
				else
					pstmt.setNull(32,java.sql.Types.CHAR);
			}
			// For column S_S_INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(32);
				if(tempString != null)
					pstmt.setString(33,tempString);
				else
					pstmt.setNull(33,java.sql.Types.CHAR);
			}
			// For column SERIAL_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(33);
				if(tempString != null)
					pstmt.setString(34,tempString);
				else
					pstmt.setNull(34,java.sql.Types.CHAR);
			}
			// For column AMDT_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(34);
				if(tempDate != null)
					pstmt.setDate(35,tempDate);
				else
					pstmt.setNull(35,java.sql.Types.DATE);
			}
			// For column SWO_ADDED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(35);
				if(tempDate != null)
					pstmt.setDate(36,tempDate);
				else
					pstmt.setNull(36,java.sql.Types.DATE);
			}
			// For column RE_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(36);
				if(tempString != null)
					pstmt.setString(37,tempString);
				else
					pstmt.setNull(37,java.sql.Types.CHAR);
			}
			// For column SWO_EXT_CNTR_NUM
			{
				String tempString;


				tempString=(String)inputRecord.get(37);
				if(tempString != null)
					pstmt.setString(38,tempString);
				else
					pstmt.setNull(38,java.sql.Types.CHAR);
			}
			// For column SWO_CNTR_STATUS
			{
				String tempString;


				tempString=(String)inputRecord.get(38);
				if(tempString != null)
					pstmt.setString(39,tempString);
				else
					pstmt.setNull(39,java.sql.Types.CHAR);
			}
			// For column SWO_CNTR_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(39);
				if(tempString != null)
					pstmt.setString(40,tempString);
				else
					pstmt.setNull(40,java.sql.Types.CHAR);
			}
			// For column ALT_PRICE_UPDATE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(40);
				if(tempString != null)
					pstmt.setString(41,tempString);
				else
					pstmt.setNull(41,java.sql.Types.CHAR);
			}
			// For column PLAN_DATE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(41);
				if(tempString != null)
					pstmt.setString(42,tempString);
				else
					pstmt.setNull(42,java.sql.Types.CHAR);
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
	private static String RemoveQuery_0 = "DELETE FROM BH.SYSTEMSWO  WHERE SWO_ID = ? AND DESG_MACHINE_ID = ? AND SOLD_TO_PARTY_ID = ? AND PROPOSAL_ID = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column SWO_ID
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
			// For column SOLD_TO_PARTY_ID
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
	private static String StoreQuery_0 = "UPDATE BH.SYSTEMSWO  SET LOCKED_IND = ?, DELTA_FETCH_ID = ?, ADJUSTMENT_AMT = ?, LAST_UPDATED_DATE = ?, EXCLUSION_ID = ?, BUMP_IND = ?, AMDT_START_DATE = ?, SWO_NO = ?, OLD_CALC_PRICE = ?, AMDT_IND = ?, ESW_PRICE = ?, PLANNED_IND = ?, ALT_PRICE_IND = ?, REF_SER_NO_DESGMC = ?, REF_SERIAL_NO = ?, ALT_PRICE = ?, CALC_PRICE = ?, CUSTOMER_PO_NO = ?, PLAN_START_DATE = ?, ITEM_CATEGORY = ?, SEQUENCE_NO = ?, EQUIPMENT_NO = ?, SWO_ITEM_NO = ?, SALES_DOC_NO = ?, SWO_DESC = ?, PLAN_END_DATE = ?, REQST_DELIVRY_DATE = ?, DUPLICATE_DELETED_IND = ?, S_S_INDICATOR = ?, SERIAL_NO = ?, AMDT_END_DATE = ?, SWO_ADDED_DATE = ?, RE_FETCH_ID = ?, SWO_EXT_CNTR_NUM = ?, SWO_CNTR_STATUS = ?, SWO_CNTR_TYPE = ?, ALT_PRICE_UPDATE_IND = ?, PLAN_DATE_IND = ? WHERE SWO_ID = ? AND DESG_MACHINE_ID = ? AND SOLD_TO_PARTY_ID = ? AND PROPOSAL_ID = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(39,tempInteger.intValue());
				else
					pstmt.setNull(39,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(40,tempInteger.intValue());
				else
					pstmt.setNull(40,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(41,tempInteger.intValue());
				else
					pstmt.setNull(41,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(42,tempInteger.intValue());
				else
					pstmt.setNull(42,java.sql.Types.INTEGER);
			}
			// For column LOCKED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column DELTA_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column ADJUSTMENT_AMT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(6);
				if(tempDouble != null)
					pstmt.setDouble(3,tempDouble.doubleValue());
				else
					pstmt.setNull(3,java.sql.Types.DECIMAL);
			}
			// For column LAST_UPDATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(7);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			// For column EXCLUSION_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column BUMP_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column AMDT_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(10);
				if(tempDate != null)
					pstmt.setDate(7,tempDate);
				else
					pstmt.setNull(7,java.sql.Types.DATE);
			}
			// For column SWO_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column OLD_CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(12);
				if(tempDouble != null)
					pstmt.setDouble(9,tempDouble.doubleValue());
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column AMDT_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(14);
				if(tempDouble != null)
					pstmt.setDouble(11,tempDouble.doubleValue());
				else
					pstmt.setNull(11,java.sql.Types.DECIMAL);
			}
			// For column PLANNED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.CHAR);
			}
			// For column ALT_PRICE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.CHAR);
			}
			// For column REF_SER_NO_DESGMC
			{
				String tempString;


				tempString=(String)inputRecord.get(17);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.CHAR);
			}
			// For column REF_SERIAL_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(18);
				if(tempString != null)
					pstmt.setString(15,tempString);
				else
					pstmt.setNull(15,java.sql.Types.CHAR);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(19);
				if(tempDouble != null)
					pstmt.setDouble(16,tempDouble.doubleValue());
				else
					pstmt.setNull(16,java.sql.Types.DECIMAL);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(20);
				if(tempDouble != null)
					pstmt.setDouble(17,tempDouble.doubleValue());
				else
					pstmt.setNull(17,java.sql.Types.DECIMAL);
			}
			// For column CUSTOMER_PO_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(18,tempString);
				else
					pstmt.setNull(18,java.sql.Types.CHAR);
			}
			// For column PLAN_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(22);
				if(tempDate != null)
					pstmt.setDate(19,tempDate);
				else
					pstmt.setNull(19,java.sql.Types.DATE);
			}
			// For column ITEM_CATEGORY
			{
				String tempString;


				tempString=(String)inputRecord.get(23);
				if(tempString != null)
					pstmt.setString(20,tempString);
				else
					pstmt.setNull(20,java.sql.Types.CHAR);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(24);
				if(tempInteger != null)
					pstmt.setInt(21,tempInteger.intValue());
				else
					pstmt.setNull(21,java.sql.Types.INTEGER);
			}
			// For column EQUIPMENT_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(25);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.CHAR);
			}
			// For column SWO_ITEM_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(26);
				if(tempString != null)
					pstmt.setString(23,tempString);
				else
					pstmt.setNull(23,java.sql.Types.CHAR);
			}
			// For column SALES_DOC_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(27);
				if(tempString != null)
					pstmt.setString(24,tempString);
				else
					pstmt.setNull(24,java.sql.Types.CHAR);
			}
			// For column SWO_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(28);
				if(tempString != null)
					pstmt.setString(25,tempString);
				else
					pstmt.setNull(25,java.sql.Types.CHAR);
			}
			// For column PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(29);
				if(tempDate != null)
					pstmt.setDate(26,tempDate);
				else
					pstmt.setNull(26,java.sql.Types.DATE);
			}
			// For column REQST_DELIVRY_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(30);
				if(tempDate != null)
					pstmt.setDate(27,tempDate);
				else
					pstmt.setNull(27,java.sql.Types.DATE);
			}
			// For column DUPLICATE_DELETED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(31);
				if(tempString != null)
					pstmt.setString(28,tempString);
				else
					pstmt.setNull(28,java.sql.Types.CHAR);
			}
			// For column S_S_INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(32);
				if(tempString != null)
					pstmt.setString(29,tempString);
				else
					pstmt.setNull(29,java.sql.Types.CHAR);
			}
			// For column SERIAL_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(33);
				if(tempString != null)
					pstmt.setString(30,tempString);
				else
					pstmt.setNull(30,java.sql.Types.CHAR);
			}
			// For column AMDT_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(34);
				if(tempDate != null)
					pstmt.setDate(31,tempDate);
				else
					pstmt.setNull(31,java.sql.Types.DATE);
			}
			// For column SWO_ADDED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(35);
				if(tempDate != null)
					pstmt.setDate(32,tempDate);
				else
					pstmt.setNull(32,java.sql.Types.DATE);
			}
			// For column RE_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(36);
				if(tempString != null)
					pstmt.setString(33,tempString);
				else
					pstmt.setNull(33,java.sql.Types.CHAR);
			}
			// For column SWO_EXT_CNTR_NUM
			{
				String tempString;


				tempString=(String)inputRecord.get(37);
				if(tempString != null)
					pstmt.setString(34,tempString);
				else
					pstmt.setNull(34,java.sql.Types.CHAR);
			}
			// For column SWO_CNTR_STATUS
			{
				String tempString;


				tempString=(String)inputRecord.get(38);
				if(tempString != null)
					pstmt.setString(35,tempString);
				else
					pstmt.setNull(35,java.sql.Types.CHAR);
			}
			// For column SWO_CNTR_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(39);
				if(tempString != null)
					pstmt.setString(36,tempString);
				else
					pstmt.setNull(36,java.sql.Types.CHAR);
			}
			// For column ALT_PRICE_UPDATE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(40);
				if(tempString != null)
					pstmt.setString(37,tempString);
				else
					pstmt.setNull(37,java.sql.Types.CHAR);
			}
			// For column PLAN_DATE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(41);
				if(tempString != null)
					pstmt.setString(38,tempString);
				else
					pstmt.setNull(38,java.sql.Types.CHAR);
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
	private static String StoreOCCQuery_0 = "UPDATE BH.SYSTEMSWO  SET LOCKED_IND = ?, DELTA_FETCH_ID = ?, ADJUSTMENT_AMT = ?, LAST_UPDATED_DATE = ?, EXCLUSION_ID = ?, BUMP_IND = ?, AMDT_START_DATE = ?, SWO_NO = ?, OLD_CALC_PRICE = ?, AMDT_IND = ?, ESW_PRICE = ?, PLANNED_IND = ?, ALT_PRICE_IND = ?, REF_SER_NO_DESGMC = ?, REF_SERIAL_NO = ?, ALT_PRICE = ?, CALC_PRICE = ?, CUSTOMER_PO_NO = ?, PLAN_START_DATE = ?, ITEM_CATEGORY = ?, SEQUENCE_NO = ?, EQUIPMENT_NO = ?, SWO_ITEM_NO = ?, SALES_DOC_NO = ?, SWO_DESC = ?, PLAN_END_DATE = ?, REQST_DELIVRY_DATE = ?, DUPLICATE_DELETED_IND = ?, S_S_INDICATOR = ?, SERIAL_NO = ?, AMDT_END_DATE = ?, SWO_ADDED_DATE = ?, RE_FETCH_ID = ?, SWO_EXT_CNTR_NUM = ?, SWO_CNTR_STATUS = ?, SWO_CNTR_TYPE = ?, ALT_PRICE_UPDATE_IND = ?, PLAN_DATE_IND = ? WHERE SWO_ID = ? AND DESG_MACHINE_ID = ? AND SOLD_TO_PARTY_ID = ? AND PROPOSAL_ID = ? AND ADJUSTMENT_AMT = ? AND OLD_CALC_PRICE = ? AND ESW_PRICE = ? AND ALT_PRICE = ? AND CALC_PRICE = ? AND SEQUENCE_NO = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(39,tempInteger.intValue());
				else
					pstmt.setNull(39,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(40,tempInteger.intValue());
				else
					pstmt.setNull(40,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(41,tempInteger.intValue());
				else
					pstmt.setNull(41,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(42,tempInteger.intValue());
				else
					pstmt.setNull(42,java.sql.Types.INTEGER);
			}
			// For column LOCKED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column DELTA_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column ADJUSTMENT_AMT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(6);
				if(tempDouble != null)
					pstmt.setDouble(3,tempDouble.doubleValue());
				else
					pstmt.setNull(3,java.sql.Types.DECIMAL);
			}
			// For column LAST_UPDATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(7);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			// For column EXCLUSION_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column BUMP_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column AMDT_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(10);
				if(tempDate != null)
					pstmt.setDate(7,tempDate);
				else
					pstmt.setNull(7,java.sql.Types.DATE);
			}
			// For column SWO_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column OLD_CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(12);
				if(tempDouble != null)
					pstmt.setDouble(9,tempDouble.doubleValue());
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column AMDT_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(14);
				if(tempDouble != null)
					pstmt.setDouble(11,tempDouble.doubleValue());
				else
					pstmt.setNull(11,java.sql.Types.DECIMAL);
			}
			// For column PLANNED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.CHAR);
			}
			// For column ALT_PRICE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.CHAR);
			}
			// For column REF_SER_NO_DESGMC
			{
				String tempString;


				tempString=(String)inputRecord.get(17);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.CHAR);
			}
			// For column REF_SERIAL_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(18);
				if(tempString != null)
					pstmt.setString(15,tempString);
				else
					pstmt.setNull(15,java.sql.Types.CHAR);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(19);
				if(tempDouble != null)
					pstmt.setDouble(16,tempDouble.doubleValue());
				else
					pstmt.setNull(16,java.sql.Types.DECIMAL);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(20);
				if(tempDouble != null)
					pstmt.setDouble(17,tempDouble.doubleValue());
				else
					pstmt.setNull(17,java.sql.Types.DECIMAL);
			}
			// For column CUSTOMER_PO_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(18,tempString);
				else
					pstmt.setNull(18,java.sql.Types.CHAR);
			}
			// For column PLAN_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(22);
				if(tempDate != null)
					pstmt.setDate(19,tempDate);
				else
					pstmt.setNull(19,java.sql.Types.DATE);
			}
			// For column ITEM_CATEGORY
			{
				String tempString;


				tempString=(String)inputRecord.get(23);
				if(tempString != null)
					pstmt.setString(20,tempString);
				else
					pstmt.setNull(20,java.sql.Types.CHAR);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(24);
				if(tempInteger != null)
					pstmt.setInt(21,tempInteger.intValue());
				else
					pstmt.setNull(21,java.sql.Types.INTEGER);
			}
			// For column EQUIPMENT_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(25);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.CHAR);
			}
			// For column SWO_ITEM_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(26);
				if(tempString != null)
					pstmt.setString(23,tempString);
				else
					pstmt.setNull(23,java.sql.Types.CHAR);
			}
			// For column SALES_DOC_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(27);
				if(tempString != null)
					pstmt.setString(24,tempString);
				else
					pstmt.setNull(24,java.sql.Types.CHAR);
			}
			// For column SWO_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(28);
				if(tempString != null)
					pstmt.setString(25,tempString);
				else
					pstmt.setNull(25,java.sql.Types.CHAR);
			}
			// For column PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(29);
				if(tempDate != null)
					pstmt.setDate(26,tempDate);
				else
					pstmt.setNull(26,java.sql.Types.DATE);
			}
			// For column REQST_DELIVRY_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(30);
				if(tempDate != null)
					pstmt.setDate(27,tempDate);
				else
					pstmt.setNull(27,java.sql.Types.DATE);
			}
			// For column DUPLICATE_DELETED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(31);
				if(tempString != null)
					pstmt.setString(28,tempString);
				else
					pstmt.setNull(28,java.sql.Types.CHAR);
			}
			// For column S_S_INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(32);
				if(tempString != null)
					pstmt.setString(29,tempString);
				else
					pstmt.setNull(29,java.sql.Types.CHAR);
			}
			// For column SERIAL_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(33);
				if(tempString != null)
					pstmt.setString(30,tempString);
				else
					pstmt.setNull(30,java.sql.Types.CHAR);
			}
			// For column AMDT_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(34);
				if(tempDate != null)
					pstmt.setDate(31,tempDate);
				else
					pstmt.setNull(31,java.sql.Types.DATE);
			}
			// For column SWO_ADDED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(35);
				if(tempDate != null)
					pstmt.setDate(32,tempDate);
				else
					pstmt.setNull(32,java.sql.Types.DATE);
			}
			// For column RE_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(36);
				if(tempString != null)
					pstmt.setString(33,tempString);
				else
					pstmt.setNull(33,java.sql.Types.CHAR);
			}
			// For column SWO_EXT_CNTR_NUM
			{
				String tempString;


				tempString=(String)inputRecord.get(37);
				if(tempString != null)
					pstmt.setString(34,tempString);
				else
					pstmt.setNull(34,java.sql.Types.CHAR);
			}
			// For column SWO_CNTR_STATUS
			{
				String tempString;


				tempString=(String)inputRecord.get(38);
				if(tempString != null)
					pstmt.setString(35,tempString);
				else
					pstmt.setNull(35,java.sql.Types.CHAR);
			}
			// For column SWO_CNTR_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(39);
				if(tempString != null)
					pstmt.setString(36,tempString);
				else
					pstmt.setNull(36,java.sql.Types.CHAR);
			}
			// For column ALT_PRICE_UPDATE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(40);
				if(tempString != null)
					pstmt.setString(37,tempString);
				else
					pstmt.setNull(37,java.sql.Types.CHAR);
			}
			// For column PLAN_DATE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(41);
				if(tempString != null)
					pstmt.setString(38,tempString);
				else
					pstmt.setNull(38,java.sql.Types.CHAR);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			// For column ADJUSTMENT_AMT
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(6);
				if(tempDouble != null)
					pstmt.setDouble(43,tempDouble.doubleValue());
				else
					pstmt.setNull(43,java.sql.Types.DECIMAL);
			}
			// For column OLD_CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(12);
				if(tempDouble != null)
					pstmt.setDouble(44,tempDouble.doubleValue());
				else
					pstmt.setNull(44,java.sql.Types.DECIMAL);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(14);
				if(tempDouble != null)
					pstmt.setDouble(45,tempDouble.doubleValue());
				else
					pstmt.setNull(45,java.sql.Types.DECIMAL);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(19);
				if(tempDouble != null)
					pstmt.setDouble(46,tempDouble.doubleValue());
				else
					pstmt.setNull(46,java.sql.Types.DECIMAL);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(20);
				if(tempDouble != null)
					pstmt.setDouble(47,tempDouble.doubleValue());
				else
					pstmt.setNull(47,java.sql.Types.DECIMAL);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)oldRecord.get(24);
				if(tempInteger != null)
					pstmt.setInt(48,tempInteger.intValue());
				else
					pstmt.setNull(48,java.sql.Types.INTEGER);
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
	private static String findSVCLicenseForProposalQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"ITEM_CATEGORY\" = ?) ";
	/**
	 * FindSVCLicenseForProposal
	 */
	public javax.resource.cci.Record FindSVCLicenseForProposal(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.itemCategory = ?2 */
			pstmt = prepareStatement(connection, findSVCLicenseForProposalQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (itemCategory)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findSVCLicenseForProposalQuery_0);

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
	private static String findSVCLicenseForProposalForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"ITEM_CATEGORY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindSVCLicenseForProposal444Update
	 */
	public javax.resource.cci.Record FindSVCLicenseForProposal444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.itemCategory = ?2 */
			pstmt = prepareStatement(connection, findSVCLicenseForProposalForUpdateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (itemCategory)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findSVCLicenseForProposalForUpdateQuery_0);

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
	private static String findSVCLicenseForProposalForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"ITEM_CATEGORY\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindSVCLicenseForProposalForUpdateWithRR
	 */
	public javax.resource.cci.Record FindSVCLicenseForProposalForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.itemCategory = ?2 */
			pstmt = prepareStatement(connection, findSVCLicenseForProposalForUpdateWithRRQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (itemCategory)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findSVCLicenseForProposalForUpdateWithRRQuery_0);

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
	private static String findSVCLicenseForProposalForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"ITEM_CATEGORY\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindSVCLicenseForProposalForUpdateWithRS
	 */
	public javax.resource.cci.Record FindSVCLicenseForProposalForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.itemCategory = ?2 */
			pstmt = prepareStatement(connection, findSVCLicenseForProposalForUpdateWithRSQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (itemCategory)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findSVCLicenseForProposalForUpdateWithRSQuery_0);

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
	private static String findByProposalQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?) ";
	/**
	 * FindByProposal
	 */
	public javax.resource.cci.Record FindByProposal(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 */
			pstmt = prepareStatement(connection, findByProposalQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByProposalQuery_0);

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
	private static String findByProposalForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposal444Update
	 */
	public javax.resource.cci.Record FindByProposal444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 */
			pstmt = prepareStatement(connection, findByProposalForUpdateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByProposalForUpdateQuery_0);

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
	private static String findByProposalForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByProposalForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 */
			pstmt = prepareStatement(connection, findByProposalForUpdateWithRRQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByProposalForUpdateWithRRQuery_0);

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
	private static String findByProposalForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByProposalForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 */
			pstmt = prepareStatement(connection, findByProposalForUpdateWithRSQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByProposalForUpdateWithRSQuery_0);

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
	private static String findByQuotesQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?) ";
	/**
	 * FindByQuotes
	 */
	public javax.resource.cci.Record FindByQuotes(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.salesDocNo =?1 and o.proposalId=?2 and o.swoItemNo=?3 */
			pstmt = prepareStatement(connection, findByQuotesQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByQuotesQuery_0);

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
	private static String findByQuotesForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByQuotes444Update
	 */
	public javax.resource.cci.Record FindByQuotes444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.salesDocNo =?1 and o.proposalId=?2 and o.swoItemNo=?3 */
			pstmt = prepareStatement(connection, findByQuotesForUpdateQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByQuotesForUpdateQuery_0);

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
	private static String findByQuotesForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByQuotesForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByQuotesForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.salesDocNo =?1 and o.proposalId=?2 and o.swoItemNo=?3 */
			pstmt = prepareStatement(connection, findByQuotesForUpdateWithRRQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByQuotesForUpdateWithRRQuery_0);

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
	private static String findByQuotesForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByQuotesForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByQuotesForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.salesDocNo =?1 and o.proposalId=?2 and o.swoItemNo=?3 */
			pstmt = prepareStatement(connection, findByQuotesForUpdateWithRSQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByQuotesForUpdateWithRSQuery_0);

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
	private static String findByDMQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?) ";
	/**
	 * FindByDM
	 */
	public javax.resource.cci.Record FindByDM(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.dmId = ?1 and  o.customerId = ?2 and  o.proposalId = ?3 */
			pstmt = prepareStatement(connection, findByDMQuery_0);

			// For ?1 (dmId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByDMQuery_0);

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
	private static String findByDMForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByDM444Update
	 */
	public javax.resource.cci.Record FindByDM444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.dmId = ?1 and  o.customerId = ?2 and  o.proposalId = ?3 */
			pstmt = prepareStatement(connection, findByDMForUpdateQuery_0);

			// For ?1 (dmId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByDMForUpdateQuery_0);

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
	private static String findByDMForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByDMForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByDMForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.dmId = ?1 and  o.customerId = ?2 and  o.proposalId = ?3 */
			pstmt = prepareStatement(connection, findByDMForUpdateWithRRQuery_0);

			// For ?1 (dmId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByDMForUpdateWithRRQuery_0);

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
	private static String findByDMForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"DESG_MACHINE_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByDMForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByDMForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.dmId = ?1 and  o.customerId = ?2 and  o.proposalId = ?3 */
			pstmt = prepareStatement(connection, findByDMForUpdateWithRSQuery_0);

			// For ?1 (dmId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByDMForUpdateWithRSQuery_0);

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
	private static String findMaxBumpIndQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"BUMP_IND\" =  ( select  max( q2.\"BUMP_IND\") from BH.SYSTEMSWO q2 where  ( q2.\"SALES_DOC_NO\" = ?)  and  ( q2.\"SWO_ITEM_NO\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?) ) )  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?) ";
	/**
	 * FindMaxBumpInd
	 */
	public javax.resource.cci.Record FindMaxBumpInd(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.bumpInd= (select max(a.bumpInd) from SWO a where a.salesDocNo=?1 and  a.swoItemNo=?2 and a.proposalId=?3) and  o.salesDocNo=?1 and  o.swoItemNo=?2 and o.proposalId=?3 */
			pstmt = prepareStatement(connection, findMaxBumpIndQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findMaxBumpIndQuery_0);

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
	private static String findMaxBumpIndForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"BUMP_IND\" =  ( select  max( q2.\"BUMP_IND\") from BH.SYSTEMSWO q2 where  ( q2.\"SALES_DOC_NO\" = ?)  and  ( q2.\"SWO_ITEM_NO\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?) ) )  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxBumpInd444Update
	 */
	public javax.resource.cci.Record FindMaxBumpInd444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.bumpInd= (select max(a.bumpInd) from SWO a where a.salesDocNo=?1 and  a.swoItemNo=?2 and a.proposalId=?3) and  o.salesDocNo=?1 and  o.swoItemNo=?2 and o.proposalId=?3 */
			pstmt = prepareStatement(connection, findMaxBumpIndForUpdateQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findMaxBumpIndForUpdateQuery_0);

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
	private static String findMaxBumpIndForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"BUMP_IND\" =  ( select  max( q2.\"BUMP_IND\") from BH.SYSTEMSWO q2 where  ( q2.\"SALES_DOC_NO\" = ?)  and  ( q2.\"SWO_ITEM_NO\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?) ) )  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxBumpIndForUpdateWithRR
	 */
	public javax.resource.cci.Record FindMaxBumpIndForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.bumpInd= (select max(a.bumpInd) from SWO a where a.salesDocNo=?1 and  a.swoItemNo=?2 and a.proposalId=?3) and  o.salesDocNo=?1 and  o.swoItemNo=?2 and o.proposalId=?3 */
			pstmt = prepareStatement(connection, findMaxBumpIndForUpdateWithRRQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findMaxBumpIndForUpdateWithRRQuery_0);

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
	private static String findMaxBumpIndForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"BUMP_IND\" =  ( select  max( q2.\"BUMP_IND\") from BH.SYSTEMSWO q2 where  ( q2.\"SALES_DOC_NO\" = ?)  and  ( q2.\"SWO_ITEM_NO\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?) ) )  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxBumpIndForUpdateWithRS
	 */
	public javax.resource.cci.Record FindMaxBumpIndForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.bumpInd= (select max(a.bumpInd) from SWO a where a.salesDocNo=?1 and  a.swoItemNo=?2 and a.proposalId=?3) and  o.salesDocNo=?1 and  o.swoItemNo=?2 and o.proposalId=?3 */
			pstmt = prepareStatement(connection, findMaxBumpIndForUpdateWithRSQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findMaxBumpIndForUpdateWithRSQuery_0);

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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.SWO_ID, T1.DESG_MACHINE_ID, T1.SOLD_TO_PARTY_ID, T1.PROPOSAL_ID, T1.LOCKED_IND, T1.DELTA_FETCH_ID, T1.ADJUSTMENT_AMT, T1.LAST_UPDATED_DATE, T1.EXCLUSION_ID, T1.BUMP_IND, T1.AMDT_START_DATE, T1.SWO_NO, T1.OLD_CALC_PRICE, T1.AMDT_IND, T1.ESW_PRICE, T1.PLANNED_IND, T1.ALT_PRICE_IND, T1.REF_SER_NO_DESGMC, T1.REF_SERIAL_NO, T1.ALT_PRICE, T1.CALC_PRICE, T1.CUSTOMER_PO_NO, T1.PLAN_START_DATE, T1.ITEM_CATEGORY, T1.SEQUENCE_NO, T1.EQUIPMENT_NO, T1.SWO_ITEM_NO, T1.SALES_DOC_NO, T1.SWO_DESC, T1.PLAN_END_DATE, T1.REQST_DELIVRY_DATE, T1.DUPLICATE_DELETED_IND, T1.S_S_INDICATOR, T1.SERIAL_NO, T1.AMDT_END_DATE, T1.SWO_ADDED_DATE, T1.RE_FETCH_ID, T1.SWO_EXT_CNTR_NUM, T1.SWO_CNTR_STATUS, T1.SWO_CNTR_TYPE, T1.ALT_PRICE_UPDATE_IND, T1.PLAN_DATE_IND FROM BH.SYSTEMSWO  T1 WHERE T1.SWO_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column SWO_ID
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
			// For column SOLD_TO_PARTY_ID
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.SWO_ID, T1.DESG_MACHINE_ID, T1.SOLD_TO_PARTY_ID, T1.PROPOSAL_ID, T1.LOCKED_IND, T1.DELTA_FETCH_ID, T1.ADJUSTMENT_AMT, T1.LAST_UPDATED_DATE, T1.EXCLUSION_ID, T1.BUMP_IND, T1.AMDT_START_DATE, T1.SWO_NO, T1.OLD_CALC_PRICE, T1.AMDT_IND, T1.ESW_PRICE, T1.PLANNED_IND, T1.ALT_PRICE_IND, T1.REF_SER_NO_DESGMC, T1.REF_SERIAL_NO, T1.ALT_PRICE, T1.CALC_PRICE, T1.CUSTOMER_PO_NO, T1.PLAN_START_DATE, T1.ITEM_CATEGORY, T1.SEQUENCE_NO, T1.EQUIPMENT_NO, T1.SWO_ITEM_NO, T1.SALES_DOC_NO, T1.SWO_DESC, T1.PLAN_END_DATE, T1.REQST_DELIVRY_DATE, T1.DUPLICATE_DELETED_IND, T1.S_S_INDICATOR, T1.SERIAL_NO, T1.AMDT_END_DATE, T1.SWO_ADDED_DATE, T1.RE_FETCH_ID, T1.SWO_EXT_CNTR_NUM, T1.SWO_CNTR_STATUS, T1.SWO_CNTR_TYPE, T1.ALT_PRICE_UPDATE_IND, T1.PLAN_DATE_IND FROM BH.SYSTEMSWO  T1 WHERE T1.SWO_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column SWO_ID
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
			// For column SOLD_TO_PARTY_ID
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
	private static String FindByPrimaryKeyForUpdateWithRRQuery_0 = " SELECT T1.SWO_ID, T1.DESG_MACHINE_ID, T1.SOLD_TO_PARTY_ID, T1.PROPOSAL_ID, T1.LOCKED_IND, T1.DELTA_FETCH_ID, T1.ADJUSTMENT_AMT, T1.LAST_UPDATED_DATE, T1.EXCLUSION_ID, T1.BUMP_IND, T1.AMDT_START_DATE, T1.SWO_NO, T1.OLD_CALC_PRICE, T1.AMDT_IND, T1.ESW_PRICE, T1.PLANNED_IND, T1.ALT_PRICE_IND, T1.REF_SER_NO_DESGMC, T1.REF_SERIAL_NO, T1.ALT_PRICE, T1.CALC_PRICE, T1.CUSTOMER_PO_NO, T1.PLAN_START_DATE, T1.ITEM_CATEGORY, T1.SEQUENCE_NO, T1.EQUIPMENT_NO, T1.SWO_ITEM_NO, T1.SALES_DOC_NO, T1.SWO_DESC, T1.PLAN_END_DATE, T1.REQST_DELIVRY_DATE, T1.DUPLICATE_DELETED_IND, T1.S_S_INDICATOR, T1.SERIAL_NO, T1.AMDT_END_DATE, T1.SWO_ADDED_DATE, T1.RE_FETCH_ID, T1.SWO_EXT_CNTR_NUM, T1.SWO_CNTR_STATUS, T1.SWO_CNTR_TYPE, T1.ALT_PRICE_UPDATE_IND, T1.PLAN_DATE_IND FROM BH.SYSTEMSWO  T1 WHERE T1.SWO_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ? FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRRQuery_0);

			// For column SWO_ID
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
			// For column SOLD_TO_PARTY_ID
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
	private static String FindByPrimaryKeyForUpdateWithRSQuery_0 = " SELECT T1.SWO_ID, T1.DESG_MACHINE_ID, T1.SOLD_TO_PARTY_ID, T1.PROPOSAL_ID, T1.LOCKED_IND, T1.DELTA_FETCH_ID, T1.ADJUSTMENT_AMT, T1.LAST_UPDATED_DATE, T1.EXCLUSION_ID, T1.BUMP_IND, T1.AMDT_START_DATE, T1.SWO_NO, T1.OLD_CALC_PRICE, T1.AMDT_IND, T1.ESW_PRICE, T1.PLANNED_IND, T1.ALT_PRICE_IND, T1.REF_SER_NO_DESGMC, T1.REF_SERIAL_NO, T1.ALT_PRICE, T1.CALC_PRICE, T1.CUSTOMER_PO_NO, T1.PLAN_START_DATE, T1.ITEM_CATEGORY, T1.SEQUENCE_NO, T1.EQUIPMENT_NO, T1.SWO_ITEM_NO, T1.SALES_DOC_NO, T1.SWO_DESC, T1.PLAN_END_DATE, T1.REQST_DELIVRY_DATE, T1.DUPLICATE_DELETED_IND, T1.S_S_INDICATOR, T1.SERIAL_NO, T1.AMDT_END_DATE, T1.SWO_ADDED_DATE, T1.RE_FETCH_ID, T1.SWO_EXT_CNTR_NUM, T1.SWO_CNTR_STATUS, T1.SWO_CNTR_TYPE, T1.ALT_PRICE_UPDATE_IND, T1.PLAN_DATE_IND FROM BH.SYSTEMSWO  T1 WHERE T1.SWO_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRSQuery_0);

			// For column SWO_ID
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
			// For column SOLD_TO_PARTY_ID
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
	private static String findByQuotesSoldToPartyDMQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?) ";
	/**
	 * FindByQuotesSoldToPartyDM
	 */
	public javax.resource.cci.Record FindByQuotesSoldToPartyDM(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.salesDocNo =?1 and o.proposalId=?2 and o.swoItemNo=?3 and o.customerId=?4 and o.dmId=?5 */
			pstmt = prepareStatement(connection, findByQuotesSoldToPartyDMQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For ?5 (dmId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByQuotesSoldToPartyDMQuery_0);

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
	private static String findByQuotesSoldToPartyDMForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByQuotesSoldToPartyDM444Update
	 */
	public javax.resource.cci.Record FindByQuotesSoldToPartyDM444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.salesDocNo =?1 and o.proposalId=?2 and o.swoItemNo=?3 and o.customerId=?4 and o.dmId=?5 */
			pstmt = prepareStatement(connection, findByQuotesSoldToPartyDMForUpdateQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For ?5 (dmId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByQuotesSoldToPartyDMForUpdateQuery_0);

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
	private static String findByQuotesSoldToPartyDMForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByQuotesSoldToPartyDMForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByQuotesSoldToPartyDMForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.salesDocNo =?1 and o.proposalId=?2 and o.swoItemNo=?3 and o.customerId=?4 and o.dmId=?5 */
			pstmt = prepareStatement(connection, findByQuotesSoldToPartyDMForUpdateWithRRQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For ?5 (dmId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByQuotesSoldToPartyDMForUpdateWithRRQuery_0);

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
	private static String findByQuotesSoldToPartyDMForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByQuotesSoldToPartyDMForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByQuotesSoldToPartyDMForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.salesDocNo =?1 and o.proposalId=?2 and o.swoItemNo=?3 and o.customerId=?4 and o.dmId=?5 */
			pstmt = prepareStatement(connection, findByQuotesSoldToPartyDMForUpdateWithRSQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For ?5 (dmId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByQuotesSoldToPartyDMForUpdateWithRSQuery_0);

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
	private static String findMaxSquenceNoQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SEQUENCE_NO\" =  ( select  max( q2.\"SEQUENCE_NO\") from BH.SYSTEMSWO q2 where  ( q2.\"SALES_DOC_NO\" = ?)  and  ( q2.\"SWO_ITEM_NO\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?) ) )  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?) ";
	/**
	 * FindMaxSquenceNo
	 */
	public javax.resource.cci.Record FindMaxSquenceNo(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.sequenceNo= (select max(a.sequenceNo) from SWO a where a.salesDocNo=?1 and  a.swoItemNo=?2 and a.proposalId=?3) and  o.salesDocNo=?1 and  o.swoItemNo=?2 and o.proposalId=?3 */
			pstmt = prepareStatement(connection, findMaxSquenceNoQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findMaxSquenceNoQuery_0);

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
	private static String findMaxSquenceNoForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SEQUENCE_NO\" =  ( select  max( q2.\"SEQUENCE_NO\") from BH.SYSTEMSWO q2 where  ( q2.\"SALES_DOC_NO\" = ?)  and  ( q2.\"SWO_ITEM_NO\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?) ) )  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxSquenceNo444Update
	 */
	public javax.resource.cci.Record FindMaxSquenceNo444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.sequenceNo= (select max(a.sequenceNo) from SWO a where a.salesDocNo=?1 and  a.swoItemNo=?2 and a.proposalId=?3) and  o.salesDocNo=?1 and  o.swoItemNo=?2 and o.proposalId=?3 */
			pstmt = prepareStatement(connection, findMaxSquenceNoForUpdateQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findMaxSquenceNoForUpdateQuery_0);

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
	private static String findMaxSquenceNoForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SEQUENCE_NO\" =  ( select  max( q2.\"SEQUENCE_NO\") from BH.SYSTEMSWO q2 where  ( q2.\"SALES_DOC_NO\" = ?)  and  ( q2.\"SWO_ITEM_NO\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?) ) )  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxSquenceNoForUpdateWithRR
	 */
	public javax.resource.cci.Record FindMaxSquenceNoForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.sequenceNo= (select max(a.sequenceNo) from SWO a where a.salesDocNo=?1 and  a.swoItemNo=?2 and a.proposalId=?3) and  o.salesDocNo=?1 and  o.swoItemNo=?2 and o.proposalId=?3 */
			pstmt = prepareStatement(connection, findMaxSquenceNoForUpdateWithRRQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findMaxSquenceNoForUpdateWithRRQuery_0);

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
	private static String findMaxSquenceNoForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SEQUENCE_NO\" =  ( select  max( q2.\"SEQUENCE_NO\") from BH.SYSTEMSWO q2 where  ( q2.\"SALES_DOC_NO\" = ?)  and  ( q2.\"SWO_ITEM_NO\" = ?)  and  ( q2.\"PROPOSAL_ID\" = ?) ) )  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxSquenceNoForUpdateWithRS
	 */
	public javax.resource.cci.Record FindMaxSquenceNoForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.sequenceNo= (select max(a.sequenceNo) from SWO a where a.salesDocNo=?1 and  a.swoItemNo=?2 and a.proposalId=?3) and  o.salesDocNo=?1 and  o.swoItemNo=?2 and o.proposalId=?3 */
			pstmt = prepareStatement(connection, findMaxSquenceNoForUpdateWithRSQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For ?2 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(5);
				if(tempInteger != null)
					pstmt.setInt(6,tempInteger.intValue());
				else
					pstmt.setNull(6,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findMaxSquenceNoForUpdateWithRSQuery_0);

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
	private static String findByExtContrNumberQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_EXT_CNTR_NUM\" IS NULL ) ";
	/**
	 * FindByExtContrNumber
	 */
	public javax.resource.cci.Record FindByExtContrNumber(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.swoExtContrNo is null */
			pstmt = prepareStatement(connection, findByExtContrNumberQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByExtContrNumberQuery_0);

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
	private static String findByExtContrNumberForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_EXT_CNTR_NUM\" IS NULL )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByExtContrNumber444Update
	 */
	public javax.resource.cci.Record FindByExtContrNumber444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.swoExtContrNo is null */
			pstmt = prepareStatement(connection, findByExtContrNumberForUpdateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByExtContrNumberForUpdateQuery_0);

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
	private static String findByExtContrNumberForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_EXT_CNTR_NUM\" IS NULL )  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByExtContrNumberForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByExtContrNumberForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.swoExtContrNo is null */
			pstmt = prepareStatement(connection, findByExtContrNumberForUpdateWithRRQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByExtContrNumberForUpdateWithRRQuery_0);

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
	private static String findByExtContrNumberForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_EXT_CNTR_NUM\" IS NULL )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByExtContrNumberForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByExtContrNumberForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.swoExtContrNo is null */
			pstmt = prepareStatement(connection, findByExtContrNumberForUpdateWithRSQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByExtContrNumberForUpdateWithRSQuery_0);

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
	private static String findByEquimentAndSalesDocNoQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"EQUIPMENT_NO\" = ?)  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?) ";
	/**
	 * FindByEquimentAndSalesDocNo
	 */
	public javax.resource.cci.Record FindByEquimentAndSalesDocNo(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.equipmentNo = ?1 and  o.salesDocNo = ?2 and  o.proposalId = ?3 */
			pstmt = prepareStatement(connection, findByEquimentAndSalesDocNoQuery_0);

			// For ?1 (equipmentNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalID)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEquimentAndSalesDocNoQuery_0);

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
	private static String findByEquimentAndSalesDocNoForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"EQUIPMENT_NO\" = ?)  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByEquimentAndSalesDocNo444Update
	 */
	public javax.resource.cci.Record FindByEquimentAndSalesDocNo444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.equipmentNo = ?1 and  o.salesDocNo = ?2 and  o.proposalId = ?3 */
			pstmt = prepareStatement(connection, findByEquimentAndSalesDocNoForUpdateQuery_0);

			// For ?1 (equipmentNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalID)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEquimentAndSalesDocNoForUpdateQuery_0);

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
	private static String findByEquimentAndSalesDocNoForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"EQUIPMENT_NO\" = ?)  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByEquimentAndSalesDocNoForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByEquimentAndSalesDocNoForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.equipmentNo = ?1 and  o.salesDocNo = ?2 and  o.proposalId = ?3 */
			pstmt = prepareStatement(connection, findByEquimentAndSalesDocNoForUpdateWithRRQuery_0);

			// For ?1 (equipmentNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalID)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEquimentAndSalesDocNoForUpdateWithRRQuery_0);

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
	private static String findByEquimentAndSalesDocNoForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"EQUIPMENT_NO\" = ?)  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByEquimentAndSalesDocNoForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByEquimentAndSalesDocNoForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.equipmentNo = ?1 and  o.salesDocNo = ?2 and  o.proposalId = ?3 */
			pstmt = prepareStatement(connection, findByEquimentAndSalesDocNoForUpdateWithRSQuery_0);

			// For ?1 (equipmentNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (proposalID)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEquimentAndSalesDocNoForUpdateWithRSQuery_0);

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
	private static String findExcludedLicensesQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"EXCLUSION_ID\" = \'Y\') ";
	/**
	 * FindExcludedLicenses
	 */
	public javax.resource.cci.Record FindExcludedLicenses(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.exclusionId = 'Y' */
			pstmt = prepareStatement(connection, findExcludedLicensesQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findExcludedLicensesQuery_0);

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
	private static String findExcludedLicensesForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"EXCLUSION_ID\" = \'Y\')  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindExcludedLicenses444Update
	 */
	public javax.resource.cci.Record FindExcludedLicenses444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.exclusionId = 'Y' */
			pstmt = prepareStatement(connection, findExcludedLicensesForUpdateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findExcludedLicensesForUpdateQuery_0);

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
	private static String findExcludedLicensesForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"EXCLUSION_ID\" = \'Y\')  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindExcludedLicensesForUpdateWithRR
	 */
	public javax.resource.cci.Record FindExcludedLicensesForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.exclusionId = 'Y' */
			pstmt = prepareStatement(connection, findExcludedLicensesForUpdateWithRRQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findExcludedLicensesForUpdateWithRRQuery_0);

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
	private static String findExcludedLicensesForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"EXCLUSION_ID\" = \'Y\')  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindExcludedLicensesForUpdateWithRS
	 */
	public javax.resource.cci.Record FindExcludedLicensesForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.exclusionId = 'Y' */
			pstmt = prepareStatement(connection, findExcludedLicensesForUpdateWithRSQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findExcludedLicensesForUpdateWithRSQuery_0);

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
	private static String findBySandSIndicatorQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"S_S_INDICATOR\" = ?) ";
	/**
	 * FindBySandSIndicator
	 */
	public javax.resource.cci.Record FindBySandSIndicator(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.sandsIndicator = ?2 */
			pstmt = prepareStatement(connection, findBySandSIndicatorQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (indicator)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySandSIndicatorQuery_0);

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
	private static String findBySandSIndicatorForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"S_S_INDICATOR\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySandSIndicator444Update
	 */
	public javax.resource.cci.Record FindBySandSIndicator444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.sandsIndicator = ?2 */
			pstmt = prepareStatement(connection, findBySandSIndicatorForUpdateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (indicator)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySandSIndicatorForUpdateQuery_0);

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
	private static String findBySandSIndicatorForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"S_S_INDICATOR\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySandSIndicatorForUpdateWithRR
	 */
	public javax.resource.cci.Record FindBySandSIndicatorForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.sandsIndicator = ?2 */
			pstmt = prepareStatement(connection, findBySandSIndicatorForUpdateWithRRQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (indicator)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySandSIndicatorForUpdateWithRRQuery_0);

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
	private static String findBySandSIndicatorForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"S_S_INDICATOR\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySandSIndicatorForUpdateWithRS
	 */
	public javax.resource.cci.Record FindBySandSIndicatorForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where o.proposalId = ?1 and o.sandsIndicator = ?2 */
			pstmt = prepareStatement(connection, findBySandSIndicatorForUpdateWithRSQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (indicator)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySandSIndicatorForUpdateWithRSQuery_0);

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
	private static String findByCustomerQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?) ";
	/**
	 * FindByCustomer
	 */
	public javax.resource.cci.Record FindByCustomer(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 and  o.customerId = ?2 */
			pstmt = prepareStatement(connection, findByCustomerQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByCustomerQuery_0);

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
	private static String findByCustomerForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByCustomer444Update
	 */
	public javax.resource.cci.Record FindByCustomer444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 and  o.customerId = ?2 */
			pstmt = prepareStatement(connection, findByCustomerForUpdateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByCustomerForUpdateQuery_0);

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
	private static String findByCustomerForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByCustomerForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByCustomerForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 and  o.customerId = ?2 */
			pstmt = prepareStatement(connection, findByCustomerForUpdateWithRRQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByCustomerForUpdateWithRRQuery_0);

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
	private static String findByCustomerForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByCustomerForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByCustomerForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 and  o.customerId = ?2 */
			pstmt = prepareStatement(connection, findByCustomerForUpdateWithRSQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByCustomerForUpdateWithRSQuery_0);

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
	private static String findBySwoNoSerialNoQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_NO\" = ?)  and  ( q1.\"SERIAL_NO\" = ?) ";
	/**
	 * FindBySwoNoSerialNo
	 */
	public javax.resource.cci.Record FindBySwoNoSerialNo(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 and o.swoNo = ?2  and o.serialNo = ?3 */
			pstmt = prepareStatement(connection, findBySwoNoSerialNoQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (serialNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySwoNoSerialNoQuery_0);

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
	private static String findBySwoNoSerialNoForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_NO\" = ?)  and  ( q1.\"SERIAL_NO\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySwoNoSerialNo444Update
	 */
	public javax.resource.cci.Record FindBySwoNoSerialNo444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 and o.swoNo = ?2  and o.serialNo = ?3 */
			pstmt = prepareStatement(connection, findBySwoNoSerialNoForUpdateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (serialNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySwoNoSerialNoForUpdateQuery_0);

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
	private static String findBySwoNoSerialNoForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_NO\" = ?)  and  ( q1.\"SERIAL_NO\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySwoNoSerialNoForUpdateWithRR
	 */
	public javax.resource.cci.Record FindBySwoNoSerialNoForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 and o.swoNo = ?2  and o.serialNo = ?3 */
			pstmt = prepareStatement(connection, findBySwoNoSerialNoForUpdateWithRRQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (serialNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySwoNoSerialNoForUpdateWithRRQuery_0);

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
	private static String findBySwoNoSerialNoForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_NO\" = ?)  and  ( q1.\"SERIAL_NO\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySwoNoSerialNoForUpdateWithRS
	 */
	public javax.resource.cci.Record FindBySwoNoSerialNoForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 and o.swoNo = ?2  and o.serialNo = ?3 */
			pstmt = prepareStatement(connection, findBySwoNoSerialNoForUpdateWithRSQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (serialNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySwoNoSerialNoForUpdateWithRSQuery_0);

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
	private static String findByEquipSoldToPartyDMQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"EQUIPMENT_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?) ";
	/**
	 * FindByEquipSoldToPartyDM
	 */
	public javax.resource.cci.Record FindByEquipSoldToPartyDM(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.equipmentNo=?1 and o.proposalId=?2 and o.customerId=?3 and o.dmId=?4 */
			pstmt = prepareStatement(connection, findByEquipSoldToPartyDMQuery_0);

			// For ?1 (equipmentNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (dmId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEquipSoldToPartyDMQuery_0);

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
	private static String findByEquipSoldToPartyDMForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"EQUIPMENT_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByEquipSoldToPartyDM444Update
	 */
	public javax.resource.cci.Record FindByEquipSoldToPartyDM444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.equipmentNo=?1 and o.proposalId=?2 and o.customerId=?3 and o.dmId=?4 */
			pstmt = prepareStatement(connection, findByEquipSoldToPartyDMForUpdateQuery_0);

			// For ?1 (equipmentNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (dmId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEquipSoldToPartyDMForUpdateQuery_0);

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
	private static String findByEquipSoldToPartyDMForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"EQUIPMENT_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByEquipSoldToPartyDMForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByEquipSoldToPartyDMForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.equipmentNo=?1 and o.proposalId=?2 and o.customerId=?3 and o.dmId=?4 */
			pstmt = prepareStatement(connection, findByEquipSoldToPartyDMForUpdateWithRRQuery_0);

			// For ?1 (equipmentNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (dmId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEquipSoldToPartyDMForUpdateWithRRQuery_0);

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
	private static String findByEquipSoldToPartyDMForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"EQUIPMENT_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"DESG_MACHINE_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByEquipSoldToPartyDMForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByEquipSoldToPartyDMForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.equipmentNo=?1 and o.proposalId=?2 and o.customerId=?3 and o.dmId=?4 */
			pstmt = prepareStatement(connection, findByEquipSoldToPartyDMForUpdateWithRSQuery_0);

			// For ?1 (equipmentNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For ?3 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For ?4 (dmId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEquipSoldToPartyDMForUpdateWithRSQuery_0);

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
	private static String findBySWONoSalesDocSwoItemNoQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_NO\" = ?)  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?) ";
	/**
	 * FindBySWONoSalesDocSwoItemNo
	 */
	public javax.resource.cci.Record FindBySWONoSalesDocSwoItemNo(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 and  o.swoNo = ?2 and  o.salesDocNo = ?3   and  o.swoItemNo = ?4 */
			pstmt = prepareStatement(connection, findBySWONoSalesDocSwoItemNoQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySWONoSalesDocSwoItemNoQuery_0);

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
	private static String findBySWONoSalesDocSwoItemNoForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_NO\" = ?)  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySWONoSalesDocSwoItemNo444Update
	 */
	public javax.resource.cci.Record FindBySWONoSalesDocSwoItemNo444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 and  o.swoNo = ?2 and  o.salesDocNo = ?3   and  o.swoItemNo = ?4 */
			pstmt = prepareStatement(connection, findBySWONoSalesDocSwoItemNoForUpdateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySWONoSalesDocSwoItemNoForUpdateQuery_0);

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
	private static String findBySWONoSalesDocSwoItemNoForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_NO\" = ?)  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySWONoSalesDocSwoItemNoForUpdateWithRR
	 */
	public javax.resource.cci.Record FindBySWONoSalesDocSwoItemNoForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 and  o.swoNo = ?2 and  o.salesDocNo = ?3   and  o.swoItemNo = ?4 */
			pstmt = prepareStatement(connection, findBySWONoSalesDocSwoItemNoForUpdateWithRRQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySWONoSalesDocSwoItemNoForUpdateWithRRQuery_0);

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
	private static String findBySWONoSalesDocSwoItemNoForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SWO_NO\" = ?)  and  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"SWO_ITEM_NO\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySWONoSalesDocSwoItemNoForUpdateWithRS
	 */
	public javax.resource.cci.Record FindBySWONoSalesDocSwoItemNoForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.proposalId = ?1 and  o.swoNo = ?2 and  o.salesDocNo = ?3   and  o.swoItemNo = ?4 */
			pstmt = prepareStatement(connection, findBySWONoSalesDocSwoItemNoForUpdateWithRSQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (swoNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (swoItemNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySWONoSalesDocSwoItemNoForUpdateWithRSQuery_0);

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
	private static String findBySalesDocNoQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?) ";
	/**
	 * FindBySalesDocNo
	 */
	public javax.resource.cci.Record FindBySalesDocNo(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.salesDocNo =?1 and o.proposalId=?2 */
			pstmt = prepareStatement(connection, findBySalesDocNoQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findBySalesDocNoQuery_0);

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
	private static String findBySalesDocNoForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySalesDocNo444Update
	 */
	public javax.resource.cci.Record FindBySalesDocNo444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.salesDocNo =?1 and o.proposalId=?2 */
			pstmt = prepareStatement(connection, findBySalesDocNoForUpdateQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findBySalesDocNoForUpdateQuery_0);

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
	private static String findBySalesDocNoForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySalesDocNoForUpdateWithRR
	 */
	public javax.resource.cci.Record FindBySalesDocNoForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.salesDocNo =?1 and o.proposalId=?2 */
			pstmt = prepareStatement(connection, findBySalesDocNoForUpdateWithRRQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findBySalesDocNoForUpdateWithRRQuery_0);

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
	private static String findBySalesDocNoForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SALES_DOC_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySalesDocNoForUpdateWithRS
	 */
	public javax.resource.cci.Record FindBySalesDocNoForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.salesDocNo =?1 and o.proposalId=?2 */
			pstmt = prepareStatement(connection, findBySalesDocNoForUpdateWithRSQuery_0);

			// For ?1 (salesDocNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findBySalesDocNoForUpdateWithRSQuery_0);

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
	private static String findByEquipmentNoQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"EQUIPMENT_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?) ";
	/**
	 * FindByEquipmentNo
	 */
	public javax.resource.cci.Record FindByEquipmentNo(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.equipmentNo=?1 and o.proposalId=?2 */
			pstmt = prepareStatement(connection, findByEquipmentNoQuery_0);

			// For ?1 (equipmentNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEquipmentNoQuery_0);

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
	private static String findByEquipmentNoForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"EQUIPMENT_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByEquipmentNo444Update
	 */
	public javax.resource.cci.Record FindByEquipmentNo444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.equipmentNo=?1 and o.proposalId=?2 */
			pstmt = prepareStatement(connection, findByEquipmentNoForUpdateQuery_0);

			// For ?1 (equipmentNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEquipmentNoForUpdateQuery_0);

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
	private static String findByEquipmentNoForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"EQUIPMENT_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByEquipmentNoForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByEquipmentNoForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.equipmentNo=?1 and o.proposalId=?2 */
			pstmt = prepareStatement(connection, findByEquipmentNoForUpdateWithRRQuery_0);

			// For ?1 (equipmentNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEquipmentNoForUpdateWithRRQuery_0);

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
	private static String findByEquipmentNoForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"EQUIPMENT_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByEquipmentNoForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByEquipmentNoForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.equipmentNo=?1 and o.proposalId=?2 */
			pstmt = prepareStatement(connection, findByEquipmentNoForUpdateWithRSQuery_0);

			// For ?1 (equipmentNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			result = executeQuery(connection, pstmt, findByEquipmentNoForUpdateWithRSQuery_0);

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
	private static String findMaxSWOIdQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SWO_ID\" =  ( select  max( q2.\"SWO_ID\") from BH.SYSTEMSWO q2) ) ";
	/**
	 * FindMaxSWOId
	 */
	public javax.resource.cci.Record FindMaxSWOId(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.swoId = (select max(a.swoId) from SWO a) */
			pstmt = prepareStatement(connection, findMaxSWOIdQuery_0);

			result = executeQuery(connection, pstmt, findMaxSWOIdQuery_0);

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
	private static String findMaxSWOIdForUpdateQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SWO_ID\" =  ( select  max( q2.\"SWO_ID\") from BH.SYSTEMSWO q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxSWOId444Update
	 */
	public javax.resource.cci.Record FindMaxSWOId444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.swoId = (select max(a.swoId) from SWO a) */
			pstmt = prepareStatement(connection, findMaxSWOIdForUpdateQuery_0);

			result = executeQuery(connection, pstmt, findMaxSWOIdForUpdateQuery_0);

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
	private static String findMaxSWOIdForUpdateWithRRQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SWO_ID\" =  ( select  max( q2.\"SWO_ID\") from BH.SYSTEMSWO q2) )  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxSWOIdForUpdateWithRR
	 */
	public javax.resource.cci.Record FindMaxSWOIdForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.swoId = (select max(a.swoId) from SWO a) */
			pstmt = prepareStatement(connection, findMaxSWOIdForUpdateWithRRQuery_0);

			result = executeQuery(connection, pstmt, findMaxSWOIdForUpdateWithRRQuery_0);

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
	private static String findMaxSWOIdForUpdateWithRSQuery_0 = " select  q1.\"SWO_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"LOCKED_IND\",  q1.\"DELTA_FETCH_ID\",  q1.\"ADJUSTMENT_AMT\",  q1.\"LAST_UPDATED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"BUMP_IND\",  q1.\"AMDT_START_DATE\",  q1.\"SWO_NO\",  q1.\"OLD_CALC_PRICE\",  q1.\"AMDT_IND\",  q1.\"ESW_PRICE\",  q1.\"PLANNED_IND\",  q1.\"ALT_PRICE_IND\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE\",  q1.\"CALC_PRICE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"PLAN_END_DATE\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"DUPLICATE_DELETED_IND\",  q1.\"S_S_INDICATOR\",  q1.\"SERIAL_NO\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ALT_PRICE_UPDATE_IND\",  q1.\"PLAN_DATE_IND\" from BH.SYSTEMSWO q1 where  ( q1.\"SWO_ID\" =  ( select  max( q2.\"SWO_ID\") from BH.SYSTEMSWO q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxSWOIdForUpdateWithRS
	 */
	public javax.resource.cci.Record FindMaxSWOIdForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from SWO o where  o.swoId = (select max(a.swoId) from SWO a) */
			pstmt = prepareStatement(connection, findMaxSWOIdForUpdateWithRSQuery_0);

			result = executeQuery(connection, pstmt, findMaxSWOIdForUpdateWithRSQuery_0);

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
	 * SWOBeanFunctionSet_05de4b81
	 */
	public SWOBeanFunctionSet_05de4b81() {
		functionHash=new java.util.HashMap(84);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindSVCLicenseForProposal",new Integer(4));
		functionHash.put("FindSVCLicenseForProposal444Update",new Integer(5));
		functionHash.put("FindSVCLicenseForProposalForUpdateWithRR",new Integer(6));
		functionHash.put("FindSVCLicenseForProposalForUpdateWithRS",new Integer(7));
		functionHash.put("FindByProposal",new Integer(8));
		functionHash.put("FindByProposal444Update",new Integer(9));
		functionHash.put("FindByProposalForUpdateWithRR",new Integer(10));
		functionHash.put("FindByProposalForUpdateWithRS",new Integer(11));
		functionHash.put("FindByQuotes",new Integer(12));
		functionHash.put("FindByQuotes444Update",new Integer(13));
		functionHash.put("FindByQuotesForUpdateWithRR",new Integer(14));
		functionHash.put("FindByQuotesForUpdateWithRS",new Integer(15));
		functionHash.put("FindByDM",new Integer(16));
		functionHash.put("FindByDM444Update",new Integer(17));
		functionHash.put("FindByDMForUpdateWithRR",new Integer(18));
		functionHash.put("FindByDMForUpdateWithRS",new Integer(19));
		functionHash.put("FindMaxBumpInd",new Integer(20));
		functionHash.put("FindMaxBumpInd444Update",new Integer(21));
		functionHash.put("FindMaxBumpIndForUpdateWithRR",new Integer(22));
		functionHash.put("FindMaxBumpIndForUpdateWithRS",new Integer(23));
		functionHash.put("FindByPrimaryKey",new Integer(24));
		functionHash.put("FindByPrimaryKey444Update",new Integer(25));
		functionHash.put("FindByPrimaryKeyForUpdateWithRR",new Integer(26));
		functionHash.put("FindByPrimaryKeyForUpdateWithRS",new Integer(27));
		functionHash.put("FindByQuotesSoldToPartyDM",new Integer(28));
		functionHash.put("FindByQuotesSoldToPartyDM444Update",new Integer(29));
		functionHash.put("FindByQuotesSoldToPartyDMForUpdateWithRR",new Integer(30));
		functionHash.put("FindByQuotesSoldToPartyDMForUpdateWithRS",new Integer(31));
		functionHash.put("FindMaxSquenceNo",new Integer(32));
		functionHash.put("FindMaxSquenceNo444Update",new Integer(33));
		functionHash.put("FindMaxSquenceNoForUpdateWithRR",new Integer(34));
		functionHash.put("FindMaxSquenceNoForUpdateWithRS",new Integer(35));
		functionHash.put("FindByExtContrNumber",new Integer(36));
		functionHash.put("FindByExtContrNumber444Update",new Integer(37));
		functionHash.put("FindByExtContrNumberForUpdateWithRR",new Integer(38));
		functionHash.put("FindByExtContrNumberForUpdateWithRS",new Integer(39));
		functionHash.put("FindByEquimentAndSalesDocNo",new Integer(40));
		functionHash.put("FindByEquimentAndSalesDocNo444Update",new Integer(41));
		functionHash.put("FindByEquimentAndSalesDocNoForUpdateWithRR",new Integer(42));
		functionHash.put("FindByEquimentAndSalesDocNoForUpdateWithRS",new Integer(43));
		functionHash.put("FindExcludedLicenses",new Integer(44));
		functionHash.put("FindExcludedLicenses444Update",new Integer(45));
		functionHash.put("FindExcludedLicensesForUpdateWithRR",new Integer(46));
		functionHash.put("FindExcludedLicensesForUpdateWithRS",new Integer(47));
		functionHash.put("FindBySandSIndicator",new Integer(48));
		functionHash.put("FindBySandSIndicator444Update",new Integer(49));
		functionHash.put("FindBySandSIndicatorForUpdateWithRR",new Integer(50));
		functionHash.put("FindBySandSIndicatorForUpdateWithRS",new Integer(51));
		functionHash.put("FindByCustomer",new Integer(52));
		functionHash.put("FindByCustomer444Update",new Integer(53));
		functionHash.put("FindByCustomerForUpdateWithRR",new Integer(54));
		functionHash.put("FindByCustomerForUpdateWithRS",new Integer(55));
		functionHash.put("FindBySwoNoSerialNo",new Integer(56));
		functionHash.put("FindBySwoNoSerialNo444Update",new Integer(57));
		functionHash.put("FindBySwoNoSerialNoForUpdateWithRR",new Integer(58));
		functionHash.put("FindBySwoNoSerialNoForUpdateWithRS",new Integer(59));
		functionHash.put("FindByEquipSoldToPartyDM",new Integer(60));
		functionHash.put("FindByEquipSoldToPartyDM444Update",new Integer(61));
		functionHash.put("FindByEquipSoldToPartyDMForUpdateWithRR",new Integer(62));
		functionHash.put("FindByEquipSoldToPartyDMForUpdateWithRS",new Integer(63));
		functionHash.put("FindBySWONoSalesDocSwoItemNo",new Integer(64));
		functionHash.put("FindBySWONoSalesDocSwoItemNo444Update",new Integer(65));
		functionHash.put("FindBySWONoSalesDocSwoItemNoForUpdateWithRR",new Integer(66));
		functionHash.put("FindBySWONoSalesDocSwoItemNoForUpdateWithRS",new Integer(67));
		functionHash.put("FindBySalesDocNo",new Integer(68));
		functionHash.put("FindBySalesDocNo444Update",new Integer(69));
		functionHash.put("FindBySalesDocNoForUpdateWithRR",new Integer(70));
		functionHash.put("FindBySalesDocNoForUpdateWithRS",new Integer(71));
		functionHash.put("FindByEquipmentNo",new Integer(72));
		functionHash.put("FindByEquipmentNo444Update",new Integer(73));
		functionHash.put("FindByEquipmentNoForUpdateWithRR",new Integer(74));
		functionHash.put("FindByEquipmentNoForUpdateWithRS",new Integer(75));
		functionHash.put("FindMaxSWOId",new Integer(76));
		functionHash.put("FindMaxSWOId444Update",new Integer(77));
		functionHash.put("FindMaxSWOIdForUpdateWithRR",new Integer(78));
		functionHash.put("FindMaxSWOIdForUpdateWithRS",new Integer(79));
		functionHash.put("ReadReadChecking",new Integer(80));
		functionHash.put("ReadReadCheckingForUpdate",new Integer(81));
		functionHash.put("PartialStore",new Integer(82));
		functionHash.put("PartialStoreUsingOCC",new Integer(83));
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
			outputRecord=FindSVCLicenseForProposal(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindSVCLicenseForProposal444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindSVCLicenseForProposalForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindSVCLicenseForProposalForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 8:
			outputRecord=FindByProposal(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindByProposal444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=FindByProposalForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=FindByProposalForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 12:
			outputRecord=FindByQuotes(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=FindByQuotes444Update(inputRecord,connection,interactionSpec);
			break;
		case 14:
			outputRecord=FindByQuotesForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 15:
			outputRecord=FindByQuotesForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 16:
			outputRecord=FindByDM(inputRecord,connection,interactionSpec);
			break;
		case 17:
			outputRecord=FindByDM444Update(inputRecord,connection,interactionSpec);
			break;
		case 18:
			outputRecord=FindByDMForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 19:
			outputRecord=FindByDMForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 20:
			outputRecord=FindMaxBumpInd(inputRecord,connection,interactionSpec);
			break;
		case 21:
			outputRecord=FindMaxBumpInd444Update(inputRecord,connection,interactionSpec);
			break;
		case 22:
			outputRecord=FindMaxBumpIndForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 23:
			outputRecord=FindMaxBumpIndForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 24:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 25:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 26:
			outputRecord=FindByPrimaryKeyForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 27:
			outputRecord=FindByPrimaryKeyForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 28:
			outputRecord=FindByQuotesSoldToPartyDM(inputRecord,connection,interactionSpec);
			break;
		case 29:
			outputRecord=FindByQuotesSoldToPartyDM444Update(inputRecord,connection,interactionSpec);
			break;
		case 30:
			outputRecord=FindByQuotesSoldToPartyDMForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 31:
			outputRecord=FindByQuotesSoldToPartyDMForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 32:
			outputRecord=FindMaxSquenceNo(inputRecord,connection,interactionSpec);
			break;
		case 33:
			outputRecord=FindMaxSquenceNo444Update(inputRecord,connection,interactionSpec);
			break;
		case 34:
			outputRecord=FindMaxSquenceNoForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 35:
			outputRecord=FindMaxSquenceNoForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 36:
			outputRecord=FindByExtContrNumber(inputRecord,connection,interactionSpec);
			break;
		case 37:
			outputRecord=FindByExtContrNumber444Update(inputRecord,connection,interactionSpec);
			break;
		case 38:
			outputRecord=FindByExtContrNumberForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 39:
			outputRecord=FindByExtContrNumberForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 40:
			outputRecord=FindByEquimentAndSalesDocNo(inputRecord,connection,interactionSpec);
			break;
		case 41:
			outputRecord=FindByEquimentAndSalesDocNo444Update(inputRecord,connection,interactionSpec);
			break;
		case 42:
			outputRecord=FindByEquimentAndSalesDocNoForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 43:
			outputRecord=FindByEquimentAndSalesDocNoForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 44:
			outputRecord=FindExcludedLicenses(inputRecord,connection,interactionSpec);
			break;
		case 45:
			outputRecord=FindExcludedLicenses444Update(inputRecord,connection,interactionSpec);
			break;
		case 46:
			outputRecord=FindExcludedLicensesForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 47:
			outputRecord=FindExcludedLicensesForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 48:
			outputRecord=FindBySandSIndicator(inputRecord,connection,interactionSpec);
			break;
		case 49:
			outputRecord=FindBySandSIndicator444Update(inputRecord,connection,interactionSpec);
			break;
		case 50:
			outputRecord=FindBySandSIndicatorForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 51:
			outputRecord=FindBySandSIndicatorForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 52:
			outputRecord=FindByCustomer(inputRecord,connection,interactionSpec);
			break;
		case 53:
			outputRecord=FindByCustomer444Update(inputRecord,connection,interactionSpec);
			break;
		case 54:
			outputRecord=FindByCustomerForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 55:
			outputRecord=FindByCustomerForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 56:
			outputRecord=FindBySwoNoSerialNo(inputRecord,connection,interactionSpec);
			break;
		case 57:
			outputRecord=FindBySwoNoSerialNo444Update(inputRecord,connection,interactionSpec);
			break;
		case 58:
			outputRecord=FindBySwoNoSerialNoForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 59:
			outputRecord=FindBySwoNoSerialNoForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 60:
			outputRecord=FindByEquipSoldToPartyDM(inputRecord,connection,interactionSpec);
			break;
		case 61:
			outputRecord=FindByEquipSoldToPartyDM444Update(inputRecord,connection,interactionSpec);
			break;
		case 62:
			outputRecord=FindByEquipSoldToPartyDMForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 63:
			outputRecord=FindByEquipSoldToPartyDMForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 64:
			outputRecord=FindBySWONoSalesDocSwoItemNo(inputRecord,connection,interactionSpec);
			break;
		case 65:
			outputRecord=FindBySWONoSalesDocSwoItemNo444Update(inputRecord,connection,interactionSpec);
			break;
		case 66:
			outputRecord=FindBySWONoSalesDocSwoItemNoForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 67:
			outputRecord=FindBySWONoSalesDocSwoItemNoForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 68:
			outputRecord=FindBySalesDocNo(inputRecord,connection,interactionSpec);
			break;
		case 69:
			outputRecord=FindBySalesDocNo444Update(inputRecord,connection,interactionSpec);
			break;
		case 70:
			outputRecord=FindBySalesDocNoForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 71:
			outputRecord=FindBySalesDocNoForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 72:
			outputRecord=FindByEquipmentNo(inputRecord,connection,interactionSpec);
			break;
		case 73:
			outputRecord=FindByEquipmentNo444Update(inputRecord,connection,interactionSpec);
			break;
		case 74:
			outputRecord=FindByEquipmentNoForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 75:
			outputRecord=FindByEquipmentNoForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 76:
			outputRecord=FindMaxSWOId(inputRecord,connection,interactionSpec);
			break;
		case 77:
			outputRecord=FindMaxSWOId444Update(inputRecord,connection,interactionSpec);
			break;
		case 78:
			outputRecord=FindMaxSWOIdForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 79:
			outputRecord=FindMaxSWOIdForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 80:
			ReadReadChecking(inputRecord,connection,interactionSpec);
			break;
		case 81:
			ReadReadCheckingForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 82:
			PartialStore(inputRecord,connection,interactionSpec);
			break;
		case 83:
			PartialStoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		}
		return outputRecord;
	}
	private static String ReadReadQuery_0 = " SELECT 1 FROM BH.SYSTEMSWO  T1 WHERE T1.SWO_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ? AND T1.ADJUSTMENT_AMT = ? AND T1.OLD_CALC_PRICE = ? AND T1.ESW_PRICE = ? AND T1.ALT_PRICE = ? AND T1.CALC_PRICE = ? AND T1.SEQUENCE_NO = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column SWO_ID
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
			// For column SOLD_TO_PARTY_ID
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
			// For column ADJUSTMENT_AMT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(4);
				if(tempDouble != null)
					pstmt.setDouble(5,tempDouble.doubleValue());
				else
					pstmt.setNull(5,java.sql.Types.DECIMAL);
			}
			// For column OLD_CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(5);
				if(tempDouble != null)
					pstmt.setDouble(6,tempDouble.doubleValue());
				else
					pstmt.setNull(6,java.sql.Types.DECIMAL);
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
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(7);
				if(tempDouble != null)
					pstmt.setDouble(8,tempDouble.doubleValue());
				else
					pstmt.setNull(8,java.sql.Types.DECIMAL);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(8);
				if(tempDouble != null)
					pstmt.setDouble(9,tempDouble.doubleValue());
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(9);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM BH.SYSTEMSWO  T1 WHERE T1.SWO_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ? AND T1.ADJUSTMENT_AMT = ? AND T1.OLD_CALC_PRICE = ? AND T1.ESW_PRICE = ? AND T1.ALT_PRICE = ? AND T1.CALC_PRICE = ? AND T1.SEQUENCE_NO = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column SWO_ID
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
			// For column SOLD_TO_PARTY_ID
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
			// For column ADJUSTMENT_AMT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(4);
				if(tempDouble != null)
					pstmt.setDouble(5,tempDouble.doubleValue());
				else
					pstmt.setNull(5,java.sql.Types.DECIMAL);
			}
			// For column OLD_CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(5);
				if(tempDouble != null)
					pstmt.setDouble(6,tempDouble.doubleValue());
				else
					pstmt.setNull(6,java.sql.Types.DECIMAL);
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
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(7);
				if(tempDouble != null)
					pstmt.setDouble(8,tempDouble.doubleValue());
				else
					pstmt.setNull(8,java.sql.Types.DECIMAL);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(8);
				if(tempDouble != null)
					pstmt.setDouble(9,tempDouble.doubleValue());
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(9);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
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
		updateTemplateList = SWOBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
					if (changedFieldIndexes[4])
					{
						// For column LOCKED_IND
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
						// For column DELTA_FETCH_ID
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
						// For column ADJUSTMENT_AMT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(6);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column LAST_UPDATED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(7);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[18])
					{
						// For column EXCLUSION_ID
						String tempString;


						tempString=(String)inputRecord.get(8);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column BUMP_IND
						String tempString;


						tempString=(String)inputRecord.get(9);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column AMDT_START_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(10);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[19])
					{
						// For column SWO_NO
						String tempString;


						tempString=(String)inputRecord.get(11);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column OLD_CALC_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(12);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[17])
					{
						// For column AMDT_IND
						String tempString;


						tempString=(String)inputRecord.get(13);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column ESW_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(14);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[23])
					{
						// For column PLANNED_IND
						String tempString;


						tempString=(String)inputRecord.get(15);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[24])
					{
						// For column ALT_PRICE_IND
						String tempString;


						tempString=(String)inputRecord.get(16);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[26])
					{
						// For column REF_SER_NO_DESGMC
						String tempString;


						tempString=(String)inputRecord.get(17);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[25])
					{
						// For column REF_SERIAL_NO
						String tempString;


						tempString=(String)inputRecord.get(18);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[27])
					{
						// For column ALT_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(19);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[28])
					{
						// For column CALC_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(20);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[36])
					{
						// For column CUSTOMER_PO_NO
						String tempString;


						tempString=(String)inputRecord.get(21);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[35])
					{
						// For column PLAN_START_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(22);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[34])
					{
						// For column ITEM_CATEGORY
						String tempString;


						tempString=(String)inputRecord.get(23);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[33])
					{
						// For column SEQUENCE_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(24);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[32])
					{
						// For column EQUIPMENT_NO
						String tempString;


						tempString=(String)inputRecord.get(25);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[31])
					{
						// For column SWO_ITEM_NO
						String tempString;


						tempString=(String)inputRecord.get(26);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[30])
					{
						// For column SALES_DOC_NO
						String tempString;


						tempString=(String)inputRecord.get(27);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[29])
					{
						// For column SWO_DESC
						String tempString;


						tempString=(String)inputRecord.get(28);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[37])
					{
						// For column PLAN_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(29);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[39])
					{
						// For column REQST_DELIVRY_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(30);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[41])
					{
						// For column DUPLICATE_DELETED_IND
						String tempString;


						tempString=(String)inputRecord.get(31);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[40])
					{
						// For column S_S_INDICATOR
						String tempString;


						tempString=(String)inputRecord.get(32);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[38])
					{
						// For column SERIAL_NO
						String tempString;


						tempString=(String)inputRecord.get(33);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column AMDT_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(34);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column SWO_ADDED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(35);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column RE_FETCH_ID
						String tempString;


						tempString=(String)inputRecord.get(36);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column SWO_EXT_CNTR_NUM
						String tempString;


						tempString=(String)inputRecord.get(37);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column SWO_CNTR_STATUS
						String tempString;


						tempString=(String)inputRecord.get(38);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column SWO_CNTR_TYPE
						String tempString;


						tempString=(String)inputRecord.get(39);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[9])
					{
						// For column ALT_PRICE_UPDATE_IND
						String tempString;


						tempString=(String)inputRecord.get(40);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column PLAN_DATE_IND
						String tempString;


						tempString=(String)inputRecord.get(41);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column SWO_ID
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
						// For column SOLD_TO_PARTY_ID
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
				Object[] oldValues = new Object[6];
				oldValues[0] = oldRecord.get(6);
				oldValues[1] = oldRecord.get(12);
				oldValues[2] = oldRecord.get(14);
				oldValues[3] = oldRecord.get(19);
				oldValues[4] = oldRecord.get(20);
				oldValues[5] = oldRecord.get(24);
				String updateQuery = aTemplate.nativeOptimisticQuery(changedFieldIndexes,oldValues);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[4])
					{
						// For column LOCKED_IND
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
						// For column DELTA_FETCH_ID
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
						// For column ADJUSTMENT_AMT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(6);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column LAST_UPDATED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(7);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[18])
					{
						// For column EXCLUSION_ID
						String tempString;


						tempString=(String)inputRecord.get(8);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column BUMP_IND
						String tempString;


						tempString=(String)inputRecord.get(9);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column AMDT_START_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(10);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[19])
					{
						// For column SWO_NO
						String tempString;


						tempString=(String)inputRecord.get(11);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column OLD_CALC_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(12);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[17])
					{
						// For column AMDT_IND
						String tempString;


						tempString=(String)inputRecord.get(13);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column ESW_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(14);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[23])
					{
						// For column PLANNED_IND
						String tempString;


						tempString=(String)inputRecord.get(15);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[24])
					{
						// For column ALT_PRICE_IND
						String tempString;


						tempString=(String)inputRecord.get(16);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[26])
					{
						// For column REF_SER_NO_DESGMC
						String tempString;


						tempString=(String)inputRecord.get(17);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[25])
					{
						// For column REF_SERIAL_NO
						String tempString;


						tempString=(String)inputRecord.get(18);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[27])
					{
						// For column ALT_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(19);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[28])
					{
						// For column CALC_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(20);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[36])
					{
						// For column CUSTOMER_PO_NO
						String tempString;


						tempString=(String)inputRecord.get(21);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[35])
					{
						// For column PLAN_START_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(22);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[34])
					{
						// For column ITEM_CATEGORY
						String tempString;


						tempString=(String)inputRecord.get(23);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[33])
					{
						// For column SEQUENCE_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(24);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[32])
					{
						// For column EQUIPMENT_NO
						String tempString;


						tempString=(String)inputRecord.get(25);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[31])
					{
						// For column SWO_ITEM_NO
						String tempString;


						tempString=(String)inputRecord.get(26);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[30])
					{
						// For column SALES_DOC_NO
						String tempString;


						tempString=(String)inputRecord.get(27);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[29])
					{
						// For column SWO_DESC
						String tempString;


						tempString=(String)inputRecord.get(28);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[37])
					{
						// For column PLAN_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(29);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[39])
					{
						// For column REQST_DELIVRY_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(30);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[41])
					{
						// For column DUPLICATE_DELETED_IND
						String tempString;


						tempString=(String)inputRecord.get(31);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[40])
					{
						// For column S_S_INDICATOR
						String tempString;


						tempString=(String)inputRecord.get(32);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[38])
					{
						// For column SERIAL_NO
						String tempString;


						tempString=(String)inputRecord.get(33);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column AMDT_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(34);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column SWO_ADDED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(35);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column RE_FETCH_ID
						String tempString;


						tempString=(String)inputRecord.get(36);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column SWO_EXT_CNTR_NUM
						String tempString;


						tempString=(String)inputRecord.get(37);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column SWO_CNTR_STATUS
						String tempString;


						tempString=(String)inputRecord.get(38);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column SWO_CNTR_TYPE
						String tempString;


						tempString=(String)inputRecord.get(39);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[9])
					{
						// For column ALT_PRICE_UPDATE_IND
						String tempString;


						tempString=(String)inputRecord.get(40);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column PLAN_DATE_IND
						String tempString;


						tempString=(String)inputRecord.get(41);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column SWO_ID
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
						// For column SOLD_TO_PARTY_ID
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
					// optimistic predicate columns
					{
						// For column ADJUSTMENT_AMT
						Double tempDouble;


						tempDouble=(Double)oldValues[0];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column OLD_CALC_PRICE
						Double tempDouble;


						tempDouble=(Double)oldValues[1];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column ESW_PRICE
						Double tempDouble;


						tempDouble=(Double)oldValues[2];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column ALT_PRICE
						Double tempDouble;


						tempDouble=(Double)oldValues[3];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column CALC_PRICE
						Double tempDouble;


						tempDouble=(Double)oldValues[4];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column SEQUENCE_NO
						Integer tempInteger;


						tempInteger=(Integer)oldValues[5];
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
