package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * HistorySWOBeanFunctionSet_2fe0d772
 */
public class HistorySWOBeanFunctionSet_2fe0d772 extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO BH.HISSYSTEMSWO (SOLD_TO_PARTY_ID, DESG_MACHINE_ID, PROPOSAL_ID, SWO_ID, REQST_DELIVRY_DATE, SERIAL_NO, PLAN_END_DATE, CUSTOMER_PO_NO, PLAN_START_DATE, ITEM_CATEGORY, SEQUENCE_NO, EQUIPMENT_NO, SWO_ITEM_NO, SALES_DOC_NO, SWO_DESC, CALC_PRICE, ALT_PRICE, REF_SER_NO_DESGMC, REF_SERIAL_NO, ALT_PRICE_IND, PLANNED_IND, ESW_PRICE, OLD_CALC_PRICE, LAST_UPDATED_DATE, SWO_NO, EXCLUSION_ID, AMDT_IND, AMDT_START_DATE, BUMP_IND, SWO_ADDED_DATE, RE_FETCH_ID, AMDT_END_DATE, SWO_EXT_CNTR_NUM, SWO_CNTR_STATUS, SWO_CNTR_TYPE, ADJUSTMENT_AMT, DELTA_FETCH_ID, S_S_INDICATOR, LOCKED_IND) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
			}
			// For column REQST_DELIVRY_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(4);
				if(tempDate != null)
					pstmt.setDate(5,tempDate);
				else
					pstmt.setNull(5,java.sql.Types.DATE);
			}
			// For column SERIAL_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(6);
				if(tempDate != null)
					pstmt.setDate(7,tempDate);
				else
					pstmt.setNull(7,java.sql.Types.DATE);
			}
			// For column CUSTOMER_PO_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column PLAN_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(8);
				if(tempDate != null)
					pstmt.setDate(9,tempDate);
				else
					pstmt.setNull(9,java.sql.Types.DATE);
			}
			// For column ITEM_CATEGORY
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(10);
				if(tempInteger != null)
					pstmt.setInt(11,tempInteger.intValue());
				else
					pstmt.setNull(11,java.sql.Types.INTEGER);
			}
			// For column EQUIPMENT_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.CHAR);
			}
			// For column SWO_ITEM_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.CHAR);
			}
			// For column SALES_DOC_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.CHAR);
			}
			// For column SWO_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(15,tempString);
				else
					pstmt.setNull(15,java.sql.Types.CHAR);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(15);
				if(tempDouble != null)
					pstmt.setDouble(16,tempDouble.doubleValue());
				else
					pstmt.setNull(16,java.sql.Types.DECIMAL);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(16);
				if(tempDouble != null)
					pstmt.setDouble(17,tempDouble.doubleValue());
				else
					pstmt.setNull(17,java.sql.Types.DECIMAL);
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
			// For column ALT_PRICE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(20,tempString);
				else
					pstmt.setNull(20,java.sql.Types.CHAR);
			}
			// For column PLANNED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(20);
				if(tempString != null)
					pstmt.setString(21,tempString);
				else
					pstmt.setNull(21,java.sql.Types.CHAR);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(21);
				if(tempDouble != null)
					pstmt.setDouble(22,tempDouble.doubleValue());
				else
					pstmt.setNull(22,java.sql.Types.DECIMAL);
			}
			// For column OLD_CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(22);
				if(tempDouble != null)
					pstmt.setDouble(23,tempDouble.doubleValue());
				else
					pstmt.setNull(23,java.sql.Types.DECIMAL);
			}
			// For column LAST_UPDATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(23);
				if(tempDate != null)
					pstmt.setDate(24,tempDate);
				else
					pstmt.setNull(24,java.sql.Types.DATE);
			}
			// For column SWO_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(24);
				if(tempString != null)
					pstmt.setString(25,tempString);
				else
					pstmt.setNull(25,java.sql.Types.CHAR);
			}
			// For column EXCLUSION_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(25);
				if(tempString != null)
					pstmt.setString(26,tempString);
				else
					pstmt.setNull(26,java.sql.Types.CHAR);
			}
			// For column AMDT_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(26);
				if(tempString != null)
					pstmt.setString(27,tempString);
				else
					pstmt.setNull(27,java.sql.Types.CHAR);
			}
			// For column AMDT_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(27);
				if(tempDate != null)
					pstmt.setDate(28,tempDate);
				else
					pstmt.setNull(28,java.sql.Types.DATE);
			}
			// For column BUMP_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(28);
				if(tempString != null)
					pstmt.setString(29,tempString);
				else
					pstmt.setNull(29,java.sql.Types.CHAR);
			}
			// For column SWO_ADDED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(29);
				if(tempDate != null)
					pstmt.setDate(30,tempDate);
				else
					pstmt.setNull(30,java.sql.Types.DATE);
			}
			// For column RE_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(30);
				if(tempString != null)
					pstmt.setString(31,tempString);
				else
					pstmt.setNull(31,java.sql.Types.CHAR);
			}
			// For column AMDT_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(31);
				if(tempDate != null)
					pstmt.setDate(32,tempDate);
				else
					pstmt.setNull(32,java.sql.Types.DATE);
			}
			// For column SWO_EXT_CNTR_NUM
			{
				String tempString;


				tempString=(String)inputRecord.get(32);
				if(tempString != null)
					pstmt.setString(33,tempString);
				else
					pstmt.setNull(33,java.sql.Types.CHAR);
			}
			// For column SWO_CNTR_STATUS
			{
				String tempString;


				tempString=(String)inputRecord.get(33);
				if(tempString != null)
					pstmt.setString(34,tempString);
				else
					pstmt.setNull(34,java.sql.Types.CHAR);
			}
			// For column SWO_CNTR_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(34);
				if(tempString != null)
					pstmt.setString(35,tempString);
				else
					pstmt.setNull(35,java.sql.Types.CHAR);
			}
			// For column ADJUSTMENT_AMT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(35);
				if(tempDouble != null)
					pstmt.setDouble(36,tempDouble.doubleValue());
				else
					pstmt.setNull(36,java.sql.Types.DECIMAL);
			}
			// For column DELTA_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(36);
				if(tempString != null)
					pstmt.setString(37,tempString);
				else
					pstmt.setNull(37,java.sql.Types.CHAR);
			}
			// For column S_S_INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(37);
				if(tempString != null)
					pstmt.setString(38,tempString);
				else
					pstmt.setNull(38,java.sql.Types.CHAR);
			}
			// For column LOCKED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(38);
				if(tempString != null)
					pstmt.setString(39,tempString);
				else
					pstmt.setNull(39,java.sql.Types.CHAR);
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
	private static String RemoveQuery_0 = "DELETE FROM BH.HISSYSTEMSWO  WHERE SOLD_TO_PARTY_ID = ? AND DESG_MACHINE_ID = ? AND PROPOSAL_ID = ? AND SWO_ID = ?";
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
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
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
	private static String StoreQuery_0 = "UPDATE BH.HISSYSTEMSWO  SET REQST_DELIVRY_DATE = ?, SERIAL_NO = ?, PLAN_END_DATE = ?, CUSTOMER_PO_NO = ?, PLAN_START_DATE = ?, ITEM_CATEGORY = ?, SEQUENCE_NO = ?, EQUIPMENT_NO = ?, SWO_ITEM_NO = ?, SALES_DOC_NO = ?, SWO_DESC = ?, CALC_PRICE = ?, ALT_PRICE = ?, REF_SER_NO_DESGMC = ?, REF_SERIAL_NO = ?, ALT_PRICE_IND = ?, PLANNED_IND = ?, ESW_PRICE = ?, OLD_CALC_PRICE = ?, LAST_UPDATED_DATE = ?, SWO_NO = ?, EXCLUSION_ID = ?, AMDT_IND = ?, AMDT_START_DATE = ?, BUMP_IND = ?, SWO_ADDED_DATE = ?, RE_FETCH_ID = ?, AMDT_END_DATE = ?, SWO_EXT_CNTR_NUM = ?, SWO_CNTR_STATUS = ?, SWO_CNTR_TYPE = ?, ADJUSTMENT_AMT = ?, DELTA_FETCH_ID = ?, S_S_INDICATOR = ?, LOCKED_IND = ? WHERE SOLD_TO_PARTY_ID = ? AND DESG_MACHINE_ID = ? AND PROPOSAL_ID = ? AND SWO_ID = ?";
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
					pstmt.setInt(36,tempInteger.intValue());
				else
					pstmt.setNull(36,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(37,tempInteger.intValue());
				else
					pstmt.setNull(37,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(38,tempInteger.intValue());
				else
					pstmt.setNull(38,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(39,tempInteger.intValue());
				else
					pstmt.setNull(39,java.sql.Types.INTEGER);
			}
			// For column REQST_DELIVRY_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(4);
				if(tempDate != null)
					pstmt.setDate(1,tempDate);
				else
					pstmt.setNull(1,java.sql.Types.DATE);
			}
			// For column SERIAL_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(6);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For column CUSTOMER_PO_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.CHAR);
			}
			// For column PLAN_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(8);
				if(tempDate != null)
					pstmt.setDate(5,tempDate);
				else
					pstmt.setNull(5,java.sql.Types.DATE);
			}
			// For column ITEM_CATEGORY
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(10);
				if(tempInteger != null)
					pstmt.setInt(7,tempInteger.intValue());
				else
					pstmt.setNull(7,java.sql.Types.INTEGER);
			}
			// For column EQUIPMENT_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column SWO_ITEM_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column SALES_DOC_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column SWO_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.CHAR);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(15);
				if(tempDouble != null)
					pstmt.setDouble(12,tempDouble.doubleValue());
				else
					pstmt.setNull(12,java.sql.Types.DECIMAL);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(16);
				if(tempDouble != null)
					pstmt.setDouble(13,tempDouble.doubleValue());
				else
					pstmt.setNull(13,java.sql.Types.DECIMAL);
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
			// For column ALT_PRICE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.CHAR);
			}
			// For column PLANNED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(20);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.CHAR);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(21);
				if(tempDouble != null)
					pstmt.setDouble(18,tempDouble.doubleValue());
				else
					pstmt.setNull(18,java.sql.Types.DECIMAL);
			}
			// For column OLD_CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(22);
				if(tempDouble != null)
					pstmt.setDouble(19,tempDouble.doubleValue());
				else
					pstmt.setNull(19,java.sql.Types.DECIMAL);
			}
			// For column LAST_UPDATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(23);
				if(tempDate != null)
					pstmt.setDate(20,tempDate);
				else
					pstmt.setNull(20,java.sql.Types.DATE);
			}
			// For column SWO_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(24);
				if(tempString != null)
					pstmt.setString(21,tempString);
				else
					pstmt.setNull(21,java.sql.Types.CHAR);
			}
			// For column EXCLUSION_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(25);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.CHAR);
			}
			// For column AMDT_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(26);
				if(tempString != null)
					pstmt.setString(23,tempString);
				else
					pstmt.setNull(23,java.sql.Types.CHAR);
			}
			// For column AMDT_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(27);
				if(tempDate != null)
					pstmt.setDate(24,tempDate);
				else
					pstmt.setNull(24,java.sql.Types.DATE);
			}
			// For column BUMP_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(28);
				if(tempString != null)
					pstmt.setString(25,tempString);
				else
					pstmt.setNull(25,java.sql.Types.CHAR);
			}
			// For column SWO_ADDED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(29);
				if(tempDate != null)
					pstmt.setDate(26,tempDate);
				else
					pstmt.setNull(26,java.sql.Types.DATE);
			}
			// For column RE_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(30);
				if(tempString != null)
					pstmt.setString(27,tempString);
				else
					pstmt.setNull(27,java.sql.Types.CHAR);
			}
			// For column AMDT_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(31);
				if(tempDate != null)
					pstmt.setDate(28,tempDate);
				else
					pstmt.setNull(28,java.sql.Types.DATE);
			}
			// For column SWO_EXT_CNTR_NUM
			{
				String tempString;


				tempString=(String)inputRecord.get(32);
				if(tempString != null)
					pstmt.setString(29,tempString);
				else
					pstmt.setNull(29,java.sql.Types.CHAR);
			}
			// For column SWO_CNTR_STATUS
			{
				String tempString;


				tempString=(String)inputRecord.get(33);
				if(tempString != null)
					pstmt.setString(30,tempString);
				else
					pstmt.setNull(30,java.sql.Types.CHAR);
			}
			// For column SWO_CNTR_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(34);
				if(tempString != null)
					pstmt.setString(31,tempString);
				else
					pstmt.setNull(31,java.sql.Types.CHAR);
			}
			// For column ADJUSTMENT_AMT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(35);
				if(tempDouble != null)
					pstmt.setDouble(32,tempDouble.doubleValue());
				else
					pstmt.setNull(32,java.sql.Types.DECIMAL);
			}
			// For column DELTA_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(36);
				if(tempString != null)
					pstmt.setString(33,tempString);
				else
					pstmt.setNull(33,java.sql.Types.CHAR);
			}
			// For column S_S_INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(37);
				if(tempString != null)
					pstmt.setString(34,tempString);
				else
					pstmt.setNull(34,java.sql.Types.CHAR);
			}
			// For column LOCKED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(38);
				if(tempString != null)
					pstmt.setString(35,tempString);
				else
					pstmt.setNull(35,java.sql.Types.CHAR);
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
	private static String StoreOCCQuery_0 = "UPDATE BH.HISSYSTEMSWO  SET REQST_DELIVRY_DATE = ?, SERIAL_NO = ?, PLAN_END_DATE = ?, CUSTOMER_PO_NO = ?, PLAN_START_DATE = ?, ITEM_CATEGORY = ?, SEQUENCE_NO = ?, EQUIPMENT_NO = ?, SWO_ITEM_NO = ?, SALES_DOC_NO = ?, SWO_DESC = ?, CALC_PRICE = ?, ALT_PRICE = ?, REF_SER_NO_DESGMC = ?, REF_SERIAL_NO = ?, ALT_PRICE_IND = ?, PLANNED_IND = ?, ESW_PRICE = ?, OLD_CALC_PRICE = ?, LAST_UPDATED_DATE = ?, SWO_NO = ?, EXCLUSION_ID = ?, AMDT_IND = ?, AMDT_START_DATE = ?, BUMP_IND = ?, SWO_ADDED_DATE = ?, RE_FETCH_ID = ?, AMDT_END_DATE = ?, SWO_EXT_CNTR_NUM = ?, SWO_CNTR_STATUS = ?, SWO_CNTR_TYPE = ?, ADJUSTMENT_AMT = ?, DELTA_FETCH_ID = ?, S_S_INDICATOR = ?, LOCKED_IND = ? WHERE SOLD_TO_PARTY_ID = ? AND DESG_MACHINE_ID = ? AND PROPOSAL_ID = ? AND SWO_ID = ? AND SEQUENCE_NO = ? AND CALC_PRICE = ? AND ALT_PRICE = ? AND ESW_PRICE = ? AND OLD_CALC_PRICE = ? AND ADJUSTMENT_AMT = ?";
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
					pstmt.setInt(36,tempInteger.intValue());
				else
					pstmt.setNull(36,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(37,tempInteger.intValue());
				else
					pstmt.setNull(37,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(38,tempInteger.intValue());
				else
					pstmt.setNull(38,java.sql.Types.INTEGER);
			}
			// For column SWO_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(39,tempInteger.intValue());
				else
					pstmt.setNull(39,java.sql.Types.INTEGER);
			}
			// For column REQST_DELIVRY_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(4);
				if(tempDate != null)
					pstmt.setDate(1,tempDate);
				else
					pstmt.setNull(1,java.sql.Types.DATE);
			}
			// For column SERIAL_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(6);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For column CUSTOMER_PO_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.CHAR);
			}
			// For column PLAN_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(8);
				if(tempDate != null)
					pstmt.setDate(5,tempDate);
				else
					pstmt.setNull(5,java.sql.Types.DATE);
			}
			// For column ITEM_CATEGORY
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(10);
				if(tempInteger != null)
					pstmt.setInt(7,tempInteger.intValue());
				else
					pstmt.setNull(7,java.sql.Types.INTEGER);
			}
			// For column EQUIPMENT_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column SWO_ITEM_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column SALES_DOC_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column SWO_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.CHAR);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(15);
				if(tempDouble != null)
					pstmt.setDouble(12,tempDouble.doubleValue());
				else
					pstmt.setNull(12,java.sql.Types.DECIMAL);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(16);
				if(tempDouble != null)
					pstmt.setDouble(13,tempDouble.doubleValue());
				else
					pstmt.setNull(13,java.sql.Types.DECIMAL);
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
			// For column ALT_PRICE_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.CHAR);
			}
			// For column PLANNED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(20);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.CHAR);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(21);
				if(tempDouble != null)
					pstmt.setDouble(18,tempDouble.doubleValue());
				else
					pstmt.setNull(18,java.sql.Types.DECIMAL);
			}
			// For column OLD_CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(22);
				if(tempDouble != null)
					pstmt.setDouble(19,tempDouble.doubleValue());
				else
					pstmt.setNull(19,java.sql.Types.DECIMAL);
			}
			// For column LAST_UPDATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(23);
				if(tempDate != null)
					pstmt.setDate(20,tempDate);
				else
					pstmt.setNull(20,java.sql.Types.DATE);
			}
			// For column SWO_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(24);
				if(tempString != null)
					pstmt.setString(21,tempString);
				else
					pstmt.setNull(21,java.sql.Types.CHAR);
			}
			// For column EXCLUSION_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(25);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.CHAR);
			}
			// For column AMDT_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(26);
				if(tempString != null)
					pstmt.setString(23,tempString);
				else
					pstmt.setNull(23,java.sql.Types.CHAR);
			}
			// For column AMDT_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(27);
				if(tempDate != null)
					pstmt.setDate(24,tempDate);
				else
					pstmt.setNull(24,java.sql.Types.DATE);
			}
			// For column BUMP_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(28);
				if(tempString != null)
					pstmt.setString(25,tempString);
				else
					pstmt.setNull(25,java.sql.Types.CHAR);
			}
			// For column SWO_ADDED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(29);
				if(tempDate != null)
					pstmt.setDate(26,tempDate);
				else
					pstmt.setNull(26,java.sql.Types.DATE);
			}
			// For column RE_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(30);
				if(tempString != null)
					pstmt.setString(27,tempString);
				else
					pstmt.setNull(27,java.sql.Types.CHAR);
			}
			// For column AMDT_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(31);
				if(tempDate != null)
					pstmt.setDate(28,tempDate);
				else
					pstmt.setNull(28,java.sql.Types.DATE);
			}
			// For column SWO_EXT_CNTR_NUM
			{
				String tempString;


				tempString=(String)inputRecord.get(32);
				if(tempString != null)
					pstmt.setString(29,tempString);
				else
					pstmt.setNull(29,java.sql.Types.CHAR);
			}
			// For column SWO_CNTR_STATUS
			{
				String tempString;


				tempString=(String)inputRecord.get(33);
				if(tempString != null)
					pstmt.setString(30,tempString);
				else
					pstmt.setNull(30,java.sql.Types.CHAR);
			}
			// For column SWO_CNTR_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(34);
				if(tempString != null)
					pstmt.setString(31,tempString);
				else
					pstmt.setNull(31,java.sql.Types.CHAR);
			}
			// For column ADJUSTMENT_AMT
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(35);
				if(tempDouble != null)
					pstmt.setDouble(32,tempDouble.doubleValue());
				else
					pstmt.setNull(32,java.sql.Types.DECIMAL);
			}
			// For column DELTA_FETCH_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(36);
				if(tempString != null)
					pstmt.setString(33,tempString);
				else
					pstmt.setNull(33,java.sql.Types.CHAR);
			}
			// For column S_S_INDICATOR
			{
				String tempString;


				tempString=(String)inputRecord.get(37);
				if(tempString != null)
					pstmt.setString(34,tempString);
				else
					pstmt.setNull(34,java.sql.Types.CHAR);
			}
			// For column LOCKED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(38);
				if(tempString != null)
					pstmt.setString(35,tempString);
				else
					pstmt.setNull(35,java.sql.Types.CHAR);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)oldRecord.get(10);
				if(tempInteger != null)
					pstmt.setInt(40,tempInteger.intValue());
				else
					pstmt.setNull(40,java.sql.Types.INTEGER);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(15);
				if(tempDouble != null)
					pstmt.setDouble(41,tempDouble.doubleValue());
				else
					pstmt.setNull(41,java.sql.Types.DECIMAL);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(16);
				if(tempDouble != null)
					pstmt.setDouble(42,tempDouble.doubleValue());
				else
					pstmt.setNull(42,java.sql.Types.DECIMAL);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(21);
				if(tempDouble != null)
					pstmt.setDouble(43,tempDouble.doubleValue());
				else
					pstmt.setNull(43,java.sql.Types.DECIMAL);
			}
			// For column OLD_CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(22);
				if(tempDouble != null)
					pstmt.setDouble(44,tempDouble.doubleValue());
				else
					pstmt.setNull(44,java.sql.Types.DECIMAL);
			}
			// For column ADJUSTMENT_AMT
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(35);
				if(tempDouble != null)
					pstmt.setDouble(45,tempDouble.doubleValue());
				else
					pstmt.setNull(45,java.sql.Types.DECIMAL);
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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.SOLD_TO_PARTY_ID, T1.DESG_MACHINE_ID, T1.PROPOSAL_ID, T1.SWO_ID, T1.REQST_DELIVRY_DATE, T1.SERIAL_NO, T1.PLAN_END_DATE, T1.CUSTOMER_PO_NO, T1.PLAN_START_DATE, T1.ITEM_CATEGORY, T1.SEQUENCE_NO, T1.EQUIPMENT_NO, T1.SWO_ITEM_NO, T1.SALES_DOC_NO, T1.SWO_DESC, T1.CALC_PRICE, T1.ALT_PRICE, T1.REF_SER_NO_DESGMC, T1.REF_SERIAL_NO, T1.ALT_PRICE_IND, T1.PLANNED_IND, T1.ESW_PRICE, T1.OLD_CALC_PRICE, T1.LAST_UPDATED_DATE, T1.SWO_NO, T1.EXCLUSION_ID, T1.AMDT_IND, T1.AMDT_START_DATE, T1.BUMP_IND, T1.SWO_ADDED_DATE, T1.RE_FETCH_ID, T1.AMDT_END_DATE, T1.SWO_EXT_CNTR_NUM, T1.SWO_CNTR_STATUS, T1.SWO_CNTR_TYPE, T1.ADJUSTMENT_AMT, T1.DELTA_FETCH_ID, T1.S_S_INDICATOR, T1.LOCKED_IND FROM BH.HISSYSTEMSWO  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ?";
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
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.SOLD_TO_PARTY_ID, T1.DESG_MACHINE_ID, T1.PROPOSAL_ID, T1.SWO_ID, T1.REQST_DELIVRY_DATE, T1.SERIAL_NO, T1.PLAN_END_DATE, T1.CUSTOMER_PO_NO, T1.PLAN_START_DATE, T1.ITEM_CATEGORY, T1.SEQUENCE_NO, T1.EQUIPMENT_NO, T1.SWO_ITEM_NO, T1.SALES_DOC_NO, T1.SWO_DESC, T1.CALC_PRICE, T1.ALT_PRICE, T1.REF_SER_NO_DESGMC, T1.REF_SERIAL_NO, T1.ALT_PRICE_IND, T1.PLANNED_IND, T1.ESW_PRICE, T1.OLD_CALC_PRICE, T1.LAST_UPDATED_DATE, T1.SWO_NO, T1.EXCLUSION_ID, T1.AMDT_IND, T1.AMDT_START_DATE, T1.BUMP_IND, T1.SWO_ADDED_DATE, T1.RE_FETCH_ID, T1.AMDT_END_DATE, T1.SWO_EXT_CNTR_NUM, T1.SWO_CNTR_STATUS, T1.SWO_CNTR_TYPE, T1.ADJUSTMENT_AMT, T1.DELTA_FETCH_ID, T1.S_S_INDICATOR, T1.LOCKED_IND FROM BH.HISSYSTEMSWO  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
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
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyForUpdateWithRRQuery_0 = " SELECT T1.SOLD_TO_PARTY_ID, T1.DESG_MACHINE_ID, T1.PROPOSAL_ID, T1.SWO_ID, T1.REQST_DELIVRY_DATE, T1.SERIAL_NO, T1.PLAN_END_DATE, T1.CUSTOMER_PO_NO, T1.PLAN_START_DATE, T1.ITEM_CATEGORY, T1.SEQUENCE_NO, T1.EQUIPMENT_NO, T1.SWO_ITEM_NO, T1.SALES_DOC_NO, T1.SWO_DESC, T1.CALC_PRICE, T1.ALT_PRICE, T1.REF_SER_NO_DESGMC, T1.REF_SERIAL_NO, T1.ALT_PRICE_IND, T1.PLANNED_IND, T1.ESW_PRICE, T1.OLD_CALC_PRICE, T1.LAST_UPDATED_DATE, T1.SWO_NO, T1.EXCLUSION_ID, T1.AMDT_IND, T1.AMDT_START_DATE, T1.BUMP_IND, T1.SWO_ADDED_DATE, T1.RE_FETCH_ID, T1.AMDT_END_DATE, T1.SWO_EXT_CNTR_NUM, T1.SWO_CNTR_STATUS, T1.SWO_CNTR_TYPE, T1.ADJUSTMENT_AMT, T1.DELTA_FETCH_ID, T1.S_S_INDICATOR, T1.LOCKED_IND FROM BH.HISSYSTEMSWO  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ? FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
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
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyForUpdateWithRSQuery_0 = " SELECT T1.SOLD_TO_PARTY_ID, T1.DESG_MACHINE_ID, T1.PROPOSAL_ID, T1.SWO_ID, T1.REQST_DELIVRY_DATE, T1.SERIAL_NO, T1.PLAN_END_DATE, T1.CUSTOMER_PO_NO, T1.PLAN_START_DATE, T1.ITEM_CATEGORY, T1.SEQUENCE_NO, T1.EQUIPMENT_NO, T1.SWO_ITEM_NO, T1.SALES_DOC_NO, T1.SWO_DESC, T1.CALC_PRICE, T1.ALT_PRICE, T1.REF_SER_NO_DESGMC, T1.REF_SERIAL_NO, T1.ALT_PRICE_IND, T1.PLANNED_IND, T1.ESW_PRICE, T1.OLD_CALC_PRICE, T1.LAST_UPDATED_DATE, T1.SWO_NO, T1.EXCLUSION_ID, T1.AMDT_IND, T1.AMDT_START_DATE, T1.BUMP_IND, T1.SWO_ADDED_DATE, T1.RE_FETCH_ID, T1.AMDT_END_DATE, T1.SWO_EXT_CNTR_NUM, T1.SWO_CNTR_STATUS, T1.SWO_CNTR_TYPE, T1.ADJUSTMENT_AMT, T1.DELTA_FETCH_ID, T1.S_S_INDICATOR, T1.LOCKED_IND FROM BH.HISSYSTEMSWO  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
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
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
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
	private static String findMaxSWOIdQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"SERIAL_NO\",  q1.\"PLAN_END_DATE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"CALC_PRICE\",  q1.\"ALT_PRICE\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE_IND\",  q1.\"PLANNED_IND\",  q1.\"ESW_PRICE\",  q1.\"OLD_CALC_PRICE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"SWO_NO\",  q1.\"EXCLUSION_ID\",  q1.\"AMDT_IND\",  q1.\"AMDT_START_DATE\",  q1.\"BUMP_IND\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ADJUSTMENT_AMT\",  q1.\"DELTA_FETCH_ID\",  q1.\"S_S_INDICATOR\",  q1.\"LOCKED_IND\" from BH.HISSYSTEMSWO q1 where  ( q1.\"SWO_ID\" =  ( select  max( q2.\"SWO_ID\") from BH.HISSYSTEMSWO q2) ) ";
	/**
	 * FindMaxSWOId
	 */
	public javax.resource.cci.Record FindMaxSWOId(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from HistorySWO o where  o.swoId = (select max(a.swoId) from HistorySWO a) */
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
	private static String findMaxSWOIdForUpdateQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"SERIAL_NO\",  q1.\"PLAN_END_DATE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"CALC_PRICE\",  q1.\"ALT_PRICE\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE_IND\",  q1.\"PLANNED_IND\",  q1.\"ESW_PRICE\",  q1.\"OLD_CALC_PRICE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"SWO_NO\",  q1.\"EXCLUSION_ID\",  q1.\"AMDT_IND\",  q1.\"AMDT_START_DATE\",  q1.\"BUMP_IND\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ADJUSTMENT_AMT\",  q1.\"DELTA_FETCH_ID\",  q1.\"S_S_INDICATOR\",  q1.\"LOCKED_IND\" from BH.HISSYSTEMSWO q1 where  ( q1.\"SWO_ID\" =  ( select  max( q2.\"SWO_ID\") from BH.HISSYSTEMSWO q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxSWOId444Update
	 */
	public javax.resource.cci.Record FindMaxSWOId444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from HistorySWO o where  o.swoId = (select max(a.swoId) from HistorySWO a) */
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
	private static String findMaxSWOIdForUpdateWithRRQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"SERIAL_NO\",  q1.\"PLAN_END_DATE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"CALC_PRICE\",  q1.\"ALT_PRICE\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE_IND\",  q1.\"PLANNED_IND\",  q1.\"ESW_PRICE\",  q1.\"OLD_CALC_PRICE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"SWO_NO\",  q1.\"EXCLUSION_ID\",  q1.\"AMDT_IND\",  q1.\"AMDT_START_DATE\",  q1.\"BUMP_IND\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ADJUSTMENT_AMT\",  q1.\"DELTA_FETCH_ID\",  q1.\"S_S_INDICATOR\",  q1.\"LOCKED_IND\" from BH.HISSYSTEMSWO q1 where  ( q1.\"SWO_ID\" =  ( select  max( q2.\"SWO_ID\") from BH.HISSYSTEMSWO q2) )  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxSWOIdForUpdateWithRR
	 */
	public javax.resource.cci.Record FindMaxSWOIdForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from HistorySWO o where  o.swoId = (select max(a.swoId) from HistorySWO a) */
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
	private static String findMaxSWOIdForUpdateWithRSQuery_0 = " select  q1.\"SOLD_TO_PARTY_ID\",  q1.\"DESG_MACHINE_ID\",  q1.\"PROPOSAL_ID\",  q1.\"SWO_ID\",  q1.\"REQST_DELIVRY_DATE\",  q1.\"SERIAL_NO\",  q1.\"PLAN_END_DATE\",  q1.\"CUSTOMER_PO_NO\",  q1.\"PLAN_START_DATE\",  q1.\"ITEM_CATEGORY\",  q1.\"SEQUENCE_NO\",  q1.\"EQUIPMENT_NO\",  q1.\"SWO_ITEM_NO\",  q1.\"SALES_DOC_NO\",  q1.\"SWO_DESC\",  q1.\"CALC_PRICE\",  q1.\"ALT_PRICE\",  q1.\"REF_SER_NO_DESGMC\",  q1.\"REF_SERIAL_NO\",  q1.\"ALT_PRICE_IND\",  q1.\"PLANNED_IND\",  q1.\"ESW_PRICE\",  q1.\"OLD_CALC_PRICE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"SWO_NO\",  q1.\"EXCLUSION_ID\",  q1.\"AMDT_IND\",  q1.\"AMDT_START_DATE\",  q1.\"BUMP_IND\",  q1.\"SWO_ADDED_DATE\",  q1.\"RE_FETCH_ID\",  q1.\"AMDT_END_DATE\",  q1.\"SWO_EXT_CNTR_NUM\",  q1.\"SWO_CNTR_STATUS\",  q1.\"SWO_CNTR_TYPE\",  q1.\"ADJUSTMENT_AMT\",  q1.\"DELTA_FETCH_ID\",  q1.\"S_S_INDICATOR\",  q1.\"LOCKED_IND\" from BH.HISSYSTEMSWO q1 where  ( q1.\"SWO_ID\" =  ( select  max( q2.\"SWO_ID\") from BH.HISSYSTEMSWO q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxSWOIdForUpdateWithRS
	 */
	public javax.resource.cci.Record FindMaxSWOIdForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from HistorySWO o where  o.swoId = (select max(a.swoId) from HistorySWO a) */
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
	 * HistorySWOBeanFunctionSet_2fe0d772
	 */
	public HistorySWOBeanFunctionSet_2fe0d772() {
		functionHash=new java.util.HashMap(16);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindByPrimaryKey",new Integer(4));
		functionHash.put("FindByPrimaryKey444Update",new Integer(5));
		functionHash.put("FindByPrimaryKeyForUpdateWithRR",new Integer(6));
		functionHash.put("FindByPrimaryKeyForUpdateWithRS",new Integer(7));
		functionHash.put("FindMaxSWOId",new Integer(8));
		functionHash.put("FindMaxSWOId444Update",new Integer(9));
		functionHash.put("FindMaxSWOIdForUpdateWithRR",new Integer(10));
		functionHash.put("FindMaxSWOIdForUpdateWithRS",new Integer(11));
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
			outputRecord=FindMaxSWOId(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindMaxSWOId444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=FindMaxSWOIdForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=FindMaxSWOIdForUpdateWithRS(inputRecord,connection,interactionSpec);
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
	private static String ReadReadQuery_0 = " SELECT 1 FROM BH.HISSYSTEMSWO  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ? AND T1.SEQUENCE_NO = ? AND T1.CALC_PRICE = ? AND T1.ALT_PRICE = ? AND T1.ESW_PRICE = ? AND T1.OLD_CALC_PRICE = ? AND T1.ADJUSTMENT_AMT = ?";
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
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(5);
				if(tempDouble != null)
					pstmt.setDouble(6,tempDouble.doubleValue());
				else
					pstmt.setNull(6,java.sql.Types.DECIMAL);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(6);
				if(tempDouble != null)
					pstmt.setDouble(7,tempDouble.doubleValue());
				else
					pstmt.setNull(7,java.sql.Types.DECIMAL);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(7);
				if(tempDouble != null)
					pstmt.setDouble(8,tempDouble.doubleValue());
				else
					pstmt.setNull(8,java.sql.Types.DECIMAL);
			}
			// For column OLD_CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(8);
				if(tempDouble != null)
					pstmt.setDouble(9,tempDouble.doubleValue());
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column ADJUSTMENT_AMT
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM BH.HISSYSTEMSWO  T1 WHERE T1.SOLD_TO_PARTY_ID = ? AND T1.DESG_MACHINE_ID = ? AND T1.PROPOSAL_ID = ? AND T1.SWO_ID = ? AND T1.SEQUENCE_NO = ? AND T1.CALC_PRICE = ? AND T1.ALT_PRICE = ? AND T1.ESW_PRICE = ? AND T1.OLD_CALC_PRICE = ? AND T1.ADJUSTMENT_AMT = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
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
					pstmt.setInt(4,tempInteger.intValue());
				else
					pstmt.setNull(4,java.sql.Types.INTEGER);
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(3);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column SEQUENCE_NO
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(4);
				if(tempInteger != null)
					pstmt.setInt(5,tempInteger.intValue());
				else
					pstmt.setNull(5,java.sql.Types.INTEGER);
			}
			// For column CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(5);
				if(tempDouble != null)
					pstmt.setDouble(6,tempDouble.doubleValue());
				else
					pstmt.setNull(6,java.sql.Types.DECIMAL);
			}
			// For column ALT_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(6);
				if(tempDouble != null)
					pstmt.setDouble(7,tempDouble.doubleValue());
				else
					pstmt.setNull(7,java.sql.Types.DECIMAL);
			}
			// For column ESW_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(7);
				if(tempDouble != null)
					pstmt.setDouble(8,tempDouble.doubleValue());
				else
					pstmt.setNull(8,java.sql.Types.DECIMAL);
			}
			// For column OLD_CALC_PRICE
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(8);
				if(tempDouble != null)
					pstmt.setDouble(9,tempDouble.doubleValue());
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			// For column ADJUSTMENT_AMT
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
		updateTemplateList = HistorySWOBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
						// For column REQST_DELIVRY_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(4);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column SERIAL_NO
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
						// For column PLAN_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(6);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column CUSTOMER_PO_NO
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
						// For column PLAN_START_DATE
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
						// For column ITEM_CATEGORY
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
						// For column SEQUENCE_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(10);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column EQUIPMENT_NO
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
						// For column SWO_ITEM_NO
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
						// For column SALES_DOC_NO
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
						// For column SWO_DESC
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
						// For column CALC_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(15);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column ALT_PRICE
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
					if (changedFieldIndexes[18])
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
					if (changedFieldIndexes[19])
					{
						// For column ALT_PRICE_IND
						String tempString;


						tempString=(String)inputRecord.get(19);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column PLANNED_IND
						String tempString;


						tempString=(String)inputRecord.get(20);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column ESW_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(21);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column OLD_CALC_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(22);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[23])
					{
						// For column LAST_UPDATED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(23);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[24])
					{
						// For column SWO_NO
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
						// For column EXCLUSION_ID
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
						// For column AMDT_IND
						String tempString;


						tempString=(String)inputRecord.get(26);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[27])
					{
						// For column AMDT_START_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(27);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[28])
					{
						// For column BUMP_IND
						String tempString;


						tempString=(String)inputRecord.get(28);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[29])
					{
						// For column SWO_ADDED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(29);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[30])
					{
						// For column RE_FETCH_ID
						String tempString;


						tempString=(String)inputRecord.get(30);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[31])
					{
						// For column AMDT_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(31);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[32])
					{
						// For column SWO_EXT_CNTR_NUM
						String tempString;


						tempString=(String)inputRecord.get(32);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[33])
					{
						// For column SWO_CNTR_STATUS
						String tempString;


						tempString=(String)inputRecord.get(33);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[34])
					{
						// For column SWO_CNTR_TYPE
						String tempString;


						tempString=(String)inputRecord.get(34);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[35])
					{
						// For column ADJUSTMENT_AMT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(35);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[36])
					{
						// For column DELTA_FETCH_ID
						String tempString;


						tempString=(String)inputRecord.get(36);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[38])
					{
						// For column S_S_INDICATOR
						String tempString;


						tempString=(String)inputRecord.get(37);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[37])
					{
						// For column LOCKED_IND
						String tempString;


						tempString=(String)inputRecord.get(38);
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
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(2);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column SWO_ID
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
				oldValues[0] = oldRecord.get(10);
				oldValues[1] = oldRecord.get(15);
				oldValues[2] = oldRecord.get(16);
				oldValues[3] = oldRecord.get(21);
				oldValues[4] = oldRecord.get(22);
				oldValues[5] = oldRecord.get(35);
				String updateQuery = aTemplate.nativeOptimisticQuery(changedFieldIndexes,oldValues);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[4])
					{
						// For column REQST_DELIVRY_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(4);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column SERIAL_NO
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
						// For column PLAN_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(6);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column CUSTOMER_PO_NO
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
						// For column PLAN_START_DATE
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
						// For column ITEM_CATEGORY
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
						// For column SEQUENCE_NO
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(10);
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.INTEGER);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column EQUIPMENT_NO
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
						// For column SWO_ITEM_NO
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
						// For column SALES_DOC_NO
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
						// For column SWO_DESC
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
						// For column CALC_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(15);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[16])
					{
						// For column ALT_PRICE
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
					if (changedFieldIndexes[18])
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
					if (changedFieldIndexes[19])
					{
						// For column ALT_PRICE_IND
						String tempString;


						tempString=(String)inputRecord.get(19);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column PLANNED_IND
						String tempString;


						tempString=(String)inputRecord.get(20);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column ESW_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(21);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column OLD_CALC_PRICE
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(22);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[23])
					{
						// For column LAST_UPDATED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(23);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[24])
					{
						// For column SWO_NO
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
						// For column EXCLUSION_ID
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
						// For column AMDT_IND
						String tempString;


						tempString=(String)inputRecord.get(26);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[27])
					{
						// For column AMDT_START_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(27);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[28])
					{
						// For column BUMP_IND
						String tempString;


						tempString=(String)inputRecord.get(28);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[29])
					{
						// For column SWO_ADDED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(29);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[30])
					{
						// For column RE_FETCH_ID
						String tempString;


						tempString=(String)inputRecord.get(30);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[31])
					{
						// For column AMDT_END_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(31);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[32])
					{
						// For column SWO_EXT_CNTR_NUM
						String tempString;


						tempString=(String)inputRecord.get(32);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[33])
					{
						// For column SWO_CNTR_STATUS
						String tempString;


						tempString=(String)inputRecord.get(33);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[34])
					{
						// For column SWO_CNTR_TYPE
						String tempString;


						tempString=(String)inputRecord.get(34);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[35])
					{
						// For column ADJUSTMENT_AMT
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(35);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					if (changedFieldIndexes[36])
					{
						// For column DELTA_FETCH_ID
						String tempString;


						tempString=(String)inputRecord.get(36);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[38])
					{
						// For column S_S_INDICATOR
						String tempString;


						tempString=(String)inputRecord.get(37);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[37])
					{
						// For column LOCKED_IND
						String tempString;


						tempString=(String)inputRecord.get(38);
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
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(2);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column SWO_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(3);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					// optimistic predicate columns
					{
						// For column SEQUENCE_NO
						Integer tempInteger;


						tempInteger=(Integer)oldValues[0];
						if(tempInteger != null){
							pstmt.setInt(stmtIndex,tempInteger.intValue());
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
						// For column ESW_PRICE
						Double tempDouble;


						tempDouble=(Double)oldValues[3];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column OLD_CALC_PRICE
						Double tempDouble;


						tempDouble=(Double)oldValues[4];
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
							stmtIndex++;
						}

					}
					{
						// For column ADJUSTMENT_AMT
						Double tempDouble;


						tempDouble=(Double)oldValues[5];
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
