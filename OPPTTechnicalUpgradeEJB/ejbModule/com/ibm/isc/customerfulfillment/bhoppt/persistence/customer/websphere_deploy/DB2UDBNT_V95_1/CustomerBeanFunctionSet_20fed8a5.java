package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * CustomerBeanFunctionSet_20fed8a5
 */
public class CustomerBeanFunctionSet_20fed8a5 extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO BH.SOLDTOPARTY (PROPOSAL_ID, SOLD_TO_PARTY_ID, CUSTOMER_LIST_NO, LEGACY_SOLD_P_NO, SAP_SOLD_TO_P_NO, BILL_TO_P_NO, BILL_TO_P_NAME, PAYER_NO, PAYER_NAME, SHIP_TO_P_NO, SHIP_TO_P_NAME, PLAN_START_DATE, PLAN_END_DATE, LAST_UPDATED_DATE, BILL_TO_P_LNO, PAYER_LNO, SHIP_TO_P_LNO, SOLD_TO_P_ASNO, BILL_TO_P_ASNO, SHIP_TO_P_ASNO, PAYER_ASNO, COUNTRY_CODE, SAP_SOLD_TO_P_NAME) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
			}
			// For column CUSTOMER_LIST_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.CHAR);
			}
			// For column LEGACY_SOLD_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.CHAR);
			}
			// For column SAP_SOLD_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column BILL_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column BILL_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			// For column PAYER_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column PAYER_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column SHIP_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column SHIP_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.CHAR);
			}
			// For column PLAN_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(11);
				if(tempDate != null)
					pstmt.setDate(12,tempDate);
				else
					pstmt.setNull(12,java.sql.Types.DATE);
			}
			// For column PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(12);
				if(tempDate != null)
					pstmt.setDate(13,tempDate);
				else
					pstmt.setNull(13,java.sql.Types.DATE);
			}
			// For column LAST_UPDATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(13);
				if(tempDate != null)
					pstmt.setDate(14,tempDate);
				else
					pstmt.setNull(14,java.sql.Types.DATE);
			}
			// For column BILL_TO_P_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(15,tempString);
				else
					pstmt.setNull(15,java.sql.Types.CHAR);
			}
			// For column PAYER_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.CHAR);
			}
			// For column SHIP_TO_P_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.CHAR);
			}
			// For column SOLD_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(17);
				if(tempString != null)
					pstmt.setString(18,tempString);
				else
					pstmt.setNull(18,java.sql.Types.CHAR);
			}
			// For column BILL_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(18);
				if(tempString != null)
					pstmt.setString(19,tempString);
				else
					pstmt.setNull(19,java.sql.Types.CHAR);
			}
			// For column SHIP_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(20,tempString);
				else
					pstmt.setNull(20,java.sql.Types.CHAR);
			}
			// For column PAYER_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(20);
				if(tempString != null)
					pstmt.setString(21,tempString);
				else
					pstmt.setNull(21,java.sql.Types.CHAR);
			}
			// For column COUNTRY_CODE
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.CHAR);
			}
			// For column SAP_SOLD_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(22);
				if(tempString != null)
					pstmt.setString(23,tempString);
				else
					pstmt.setNull(23,java.sql.Types.CHAR);
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
	private static String RemoveQuery_0 = "DELETE FROM BH.SOLDTOPARTY  WHERE PROPOSAL_ID = ? AND SOLD_TO_PARTY_ID = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
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
	private static String StoreQuery_0 = "UPDATE BH.SOLDTOPARTY  SET CUSTOMER_LIST_NO = ?, LEGACY_SOLD_P_NO = ?, SAP_SOLD_TO_P_NO = ?, BILL_TO_P_NO = ?, BILL_TO_P_NAME = ?, PAYER_NO = ?, PAYER_NAME = ?, SHIP_TO_P_NO = ?, SHIP_TO_P_NAME = ?, PLAN_START_DATE = ?, PLAN_END_DATE = ?, LAST_UPDATED_DATE = ?, BILL_TO_P_LNO = ?, PAYER_LNO = ?, SHIP_TO_P_LNO = ?, SOLD_TO_P_ASNO = ?, BILL_TO_P_ASNO = ?, SHIP_TO_P_ASNO = ?, PAYER_ASNO = ?, COUNTRY_CODE = ?, SAP_SOLD_TO_P_NAME = ? WHERE PROPOSAL_ID = ? AND SOLD_TO_PARTY_ID = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(22,tempInteger.intValue());
				else
					pstmt.setNull(22,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(23,tempInteger.intValue());
				else
					pstmt.setNull(23,java.sql.Types.INTEGER);
			}
			// For column CUSTOMER_LIST_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column LEGACY_SOLD_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column SAP_SOLD_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.CHAR);
			}
			// For column BILL_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.CHAR);
			}
			// For column BILL_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column PAYER_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column PAYER_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			// For column SHIP_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column SHIP_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column PLAN_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(11);
				if(tempDate != null)
					pstmt.setDate(10,tempDate);
				else
					pstmt.setNull(10,java.sql.Types.DATE);
			}
			// For column PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(12);
				if(tempDate != null)
					pstmt.setDate(11,tempDate);
				else
					pstmt.setNull(11,java.sql.Types.DATE);
			}
			// For column LAST_UPDATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(13);
				if(tempDate != null)
					pstmt.setDate(12,tempDate);
				else
					pstmt.setNull(12,java.sql.Types.DATE);
			}
			// For column BILL_TO_P_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.CHAR);
			}
			// For column PAYER_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.CHAR);
			}
			// For column SHIP_TO_P_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(15,tempString);
				else
					pstmt.setNull(15,java.sql.Types.CHAR);
			}
			// For column SOLD_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(17);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.CHAR);
			}
			// For column BILL_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(18);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.CHAR);
			}
			// For column SHIP_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(18,tempString);
				else
					pstmt.setNull(18,java.sql.Types.CHAR);
			}
			// For column PAYER_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(20);
				if(tempString != null)
					pstmt.setString(19,tempString);
				else
					pstmt.setNull(19,java.sql.Types.CHAR);
			}
			// For column COUNTRY_CODE
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(20,tempString);
				else
					pstmt.setNull(20,java.sql.Types.CHAR);
			}
			// For column SAP_SOLD_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(22);
				if(tempString != null)
					pstmt.setString(21,tempString);
				else
					pstmt.setNull(21,java.sql.Types.CHAR);
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
	private static String StoreOCCQuery_0 = "UPDATE BH.SOLDTOPARTY  SET CUSTOMER_LIST_NO = ?, LEGACY_SOLD_P_NO = ?, SAP_SOLD_TO_P_NO = ?, BILL_TO_P_NO = ?, BILL_TO_P_NAME = ?, PAYER_NO = ?, PAYER_NAME = ?, SHIP_TO_P_NO = ?, SHIP_TO_P_NAME = ?, PLAN_START_DATE = ?, PLAN_END_DATE = ?, LAST_UPDATED_DATE = ?, BILL_TO_P_LNO = ?, PAYER_LNO = ?, SHIP_TO_P_LNO = ?, SOLD_TO_P_ASNO = ?, BILL_TO_P_ASNO = ?, SHIP_TO_P_ASNO = ?, PAYER_ASNO = ?, COUNTRY_CODE = ?, SAP_SOLD_TO_P_NAME = ? WHERE PROPOSAL_ID = ? AND SOLD_TO_PARTY_ID = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(22,tempInteger.intValue());
				else
					pstmt.setNull(22,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(23,tempInteger.intValue());
				else
					pstmt.setNull(23,java.sql.Types.INTEGER);
			}
			// For column CUSTOMER_LIST_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column LEGACY_SOLD_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column SAP_SOLD_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.CHAR);
			}
			// For column BILL_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(5);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.CHAR);
			}
			// For column BILL_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(6);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column PAYER_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(6,tempString);
				else
					pstmt.setNull(6,java.sql.Types.CHAR);
			}
			// For column PAYER_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.CHAR);
			}
			// For column SHIP_TO_P_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column SHIP_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column PLAN_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(11);
				if(tempDate != null)
					pstmt.setDate(10,tempDate);
				else
					pstmt.setNull(10,java.sql.Types.DATE);
			}
			// For column PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(12);
				if(tempDate != null)
					pstmt.setDate(11,tempDate);
				else
					pstmt.setNull(11,java.sql.Types.DATE);
			}
			// For column LAST_UPDATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(13);
				if(tempDate != null)
					pstmt.setDate(12,tempDate);
				else
					pstmt.setNull(12,java.sql.Types.DATE);
			}
			// For column BILL_TO_P_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.CHAR);
			}
			// For column PAYER_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.CHAR);
			}
			// For column SHIP_TO_P_LNO
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(15,tempString);
				else
					pstmt.setNull(15,java.sql.Types.CHAR);
			}
			// For column SOLD_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(17);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.CHAR);
			}
			// For column BILL_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(18);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.CHAR);
			}
			// For column SHIP_TO_P_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(18,tempString);
				else
					pstmt.setNull(18,java.sql.Types.CHAR);
			}
			// For column PAYER_ASNO
			{
				String tempString;


				tempString=(String)inputRecord.get(20);
				if(tempString != null)
					pstmt.setString(19,tempString);
				else
					pstmt.setNull(19,java.sql.Types.CHAR);
			}
			// For column COUNTRY_CODE
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(20,tempString);
				else
					pstmt.setNull(20,java.sql.Types.CHAR);
			}
			// For column SAP_SOLD_TO_P_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(22);
				if(tempString != null)
					pstmt.setString(21,tempString);
				else
					pstmt.setNull(21,java.sql.Types.CHAR);
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
	private static String findByProposalAndCustomerListQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"CUSTOMER_LIST_NO\" = ?) ";
	/**
	 * FindByProposalAndCustomerList
	 */
	public javax.resource.cci.Record FindByProposalAndCustomerList(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.customerListNo = ?2 */
			pstmt = prepareStatement(connection, findByProposalAndCustomerListQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (customerListNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByProposalAndCustomerListQuery_0);

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
	private static String findByProposalAndCustomerListForUpdateQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"CUSTOMER_LIST_NO\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalAndCustomerList444Update
	 */
	public javax.resource.cci.Record FindByProposalAndCustomerList444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.customerListNo = ?2 */
			pstmt = prepareStatement(connection, findByProposalAndCustomerListForUpdateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (customerListNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByProposalAndCustomerListForUpdateQuery_0);

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
	private static String findByProposalAndCustomerListForUpdateWithRRQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"CUSTOMER_LIST_NO\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalAndCustomerListForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByProposalAndCustomerListForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.customerListNo = ?2 */
			pstmt = prepareStatement(connection, findByProposalAndCustomerListForUpdateWithRRQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (customerListNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByProposalAndCustomerListForUpdateWithRRQuery_0);

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
	private static String findByProposalAndCustomerListForUpdateWithRSQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"CUSTOMER_LIST_NO\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalAndCustomerListForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByProposalAndCustomerListForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.customerListNo = ?2 */
			pstmt = prepareStatement(connection, findByProposalAndCustomerListForUpdateWithRSQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (customerListNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByProposalAndCustomerListForUpdateWithRSQuery_0);

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
	private static String findByProposalQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  order by  q1.\"PLAN_END_DATE\" asc";
	/**
	 * FindByProposal
	 */
	public javax.resource.cci.Record FindByProposal(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 order by o.planEndDate */
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
	private static String findByProposalForUpdateQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  order by  q1.\"PLAN_END_DATE\" asc FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposal444Update
	 */
	public javax.resource.cci.Record FindByProposal444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 order by o.planEndDate */
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
	private static String findByProposalForUpdateWithRRQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  order by  q1.\"PLAN_END_DATE\" asc FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByProposalForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 order by o.planEndDate */
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
	private static String findByProposalForUpdateWithRSQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  order by  q1.\"PLAN_END_DATE\" asc FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByProposalForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 order by o.planEndDate */
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
	private static String findBySapCustNoAndPlanStartEndDateQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SAP_SOLD_TO_P_NO\" = ?)  and  ( q1.\"PLAN_START_DATE\" = ?)  and  ( q1.\"PLAN_END_DATE\" = ?) ";
	/**
	 * FindBySapCustNoAndPlanStartEndDate
	 */
	public javax.resource.cci.Record FindBySapCustNoAndPlanStartEndDate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.sapCustomerNo = ?2 and o.planStartDate = ?3 and o.planEndDate = ?4 */
			pstmt = prepareStatement(connection, findBySapCustNoAndPlanStartEndDateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (sapCustomerNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (planStartDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For ?4 (planEndDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findBySapCustNoAndPlanStartEndDateQuery_0);

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
	private static String findBySapCustNoAndPlanStartEndDateForUpdateQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SAP_SOLD_TO_P_NO\" = ?)  and  ( q1.\"PLAN_START_DATE\" = ?)  and  ( q1.\"PLAN_END_DATE\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySapCustNoAndPlanStartEndDate444Update
	 */
	public javax.resource.cci.Record FindBySapCustNoAndPlanStartEndDate444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.sapCustomerNo = ?2 and o.planStartDate = ?3 and o.planEndDate = ?4 */
			pstmt = prepareStatement(connection, findBySapCustNoAndPlanStartEndDateForUpdateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (sapCustomerNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (planStartDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For ?4 (planEndDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findBySapCustNoAndPlanStartEndDateForUpdateQuery_0);

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
	private static String findBySapCustNoAndPlanStartEndDateForUpdateWithRRQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SAP_SOLD_TO_P_NO\" = ?)  and  ( q1.\"PLAN_START_DATE\" = ?)  and  ( q1.\"PLAN_END_DATE\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySapCustNoAndPlanStartEndDateForUpdateWithRR
	 */
	public javax.resource.cci.Record FindBySapCustNoAndPlanStartEndDateForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.sapCustomerNo = ?2 and o.planStartDate = ?3 and o.planEndDate = ?4 */
			pstmt = prepareStatement(connection, findBySapCustNoAndPlanStartEndDateForUpdateWithRRQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (sapCustomerNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (planStartDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For ?4 (planEndDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findBySapCustNoAndPlanStartEndDateForUpdateWithRRQuery_0);

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
	private static String findBySapCustNoAndPlanStartEndDateForUpdateWithRSQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SAP_SOLD_TO_P_NO\" = ?)  and  ( q1.\"PLAN_START_DATE\" = ?)  and  ( q1.\"PLAN_END_DATE\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySapCustNoAndPlanStartEndDateForUpdateWithRS
	 */
	public javax.resource.cci.Record FindBySapCustNoAndPlanStartEndDateForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.sapCustomerNo = ?2 and o.planStartDate = ?3 and o.planEndDate = ?4 */
			pstmt = prepareStatement(connection, findBySapCustNoAndPlanStartEndDateForUpdateWithRSQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (sapCustomerNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (planStartDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For ?4 (planEndDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(3);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findBySapCustNoAndPlanStartEndDateForUpdateWithRSQuery_0);

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
	private static String findMaxCustomerIdQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"SOLD_TO_PARTY_ID\" =  ( select  max( q2.\"SOLD_TO_PARTY_ID\") from BH.SOLDTOPARTY q2) ) ";
	/**
	 * FindMaxCustomerId
	 */
	public javax.resource.cci.Record FindMaxCustomerId(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.customerId = (select max(a.customerId) from Customer a) */
			pstmt = prepareStatement(connection, findMaxCustomerIdQuery_0);

			result = executeQuery(connection, pstmt, findMaxCustomerIdQuery_0);

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
	private static String findMaxCustomerIdForUpdateQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"SOLD_TO_PARTY_ID\" =  ( select  max( q2.\"SOLD_TO_PARTY_ID\") from BH.SOLDTOPARTY q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxCustomerId444Update
	 */
	public javax.resource.cci.Record FindMaxCustomerId444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.customerId = (select max(a.customerId) from Customer a) */
			pstmt = prepareStatement(connection, findMaxCustomerIdForUpdateQuery_0);

			result = executeQuery(connection, pstmt, findMaxCustomerIdForUpdateQuery_0);

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
	private static String findMaxCustomerIdForUpdateWithRRQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"SOLD_TO_PARTY_ID\" =  ( select  max( q2.\"SOLD_TO_PARTY_ID\") from BH.SOLDTOPARTY q2) )  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxCustomerIdForUpdateWithRR
	 */
	public javax.resource.cci.Record FindMaxCustomerIdForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.customerId = (select max(a.customerId) from Customer a) */
			pstmt = prepareStatement(connection, findMaxCustomerIdForUpdateWithRRQuery_0);

			result = executeQuery(connection, pstmt, findMaxCustomerIdForUpdateWithRRQuery_0);

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
	private static String findMaxCustomerIdForUpdateWithRSQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"SOLD_TO_PARTY_ID\" =  ( select  max( q2.\"SOLD_TO_PARTY_ID\") from BH.SOLDTOPARTY q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxCustomerIdForUpdateWithRS
	 */
	public javax.resource.cci.Record FindMaxCustomerIdForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.customerId = (select max(a.customerId) from Customer a) */
			pstmt = prepareStatement(connection, findMaxCustomerIdForUpdateWithRSQuery_0);

			result = executeQuery(connection, pstmt, findMaxCustomerIdForUpdateWithRSQuery_0);

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
	private static String findBySapCustNoQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SAP_SOLD_TO_P_NO\" = ?) ";
	/**
	 * FindBySapCustNo
	 */
	public javax.resource.cci.Record FindBySapCustNo(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.sapCustomerNo = ?2 */
			pstmt = prepareStatement(connection, findBySapCustNoQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (sapCustomerNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySapCustNoQuery_0);

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
	private static String findBySapCustNoForUpdateQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SAP_SOLD_TO_P_NO\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySapCustNo444Update
	 */
	public javax.resource.cci.Record FindBySapCustNo444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.sapCustomerNo = ?2 */
			pstmt = prepareStatement(connection, findBySapCustNoForUpdateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (sapCustomerNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySapCustNoForUpdateQuery_0);

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
	private static String findBySapCustNoForUpdateWithRRQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SAP_SOLD_TO_P_NO\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySapCustNoForUpdateWithRR
	 */
	public javax.resource.cci.Record FindBySapCustNoForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.sapCustomerNo = ?2 */
			pstmt = prepareStatement(connection, findBySapCustNoForUpdateWithRRQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (sapCustomerNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySapCustNoForUpdateWithRRQuery_0);

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
	private static String findBySapCustNoForUpdateWithRSQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SAP_SOLD_TO_P_NO\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySapCustNoForUpdateWithRS
	 */
	public javax.resource.cci.Record FindBySapCustNoForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.sapCustomerNo = ?2 */
			pstmt = prepareStatement(connection, findBySapCustNoForUpdateWithRSQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (sapCustomerNo)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySapCustNoForUpdateWithRSQuery_0);

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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.PROPOSAL_ID, T1.SOLD_TO_PARTY_ID, T1.CUSTOMER_LIST_NO, T1.LEGACY_SOLD_P_NO, T1.SAP_SOLD_TO_P_NO, T1.BILL_TO_P_NO, T1.BILL_TO_P_NAME, T1.PAYER_NO, T1.PAYER_NAME, T1.SHIP_TO_P_NO, T1.SHIP_TO_P_NAME, T1.PLAN_START_DATE, T1.PLAN_END_DATE, T1.LAST_UPDATED_DATE, T1.BILL_TO_P_LNO, T1.PAYER_LNO, T1.SHIP_TO_P_LNO, T1.SOLD_TO_P_ASNO, T1.BILL_TO_P_ASNO, T1.SHIP_TO_P_ASNO, T1.PAYER_ASNO, T1.COUNTRY_CODE, T1.SAP_SOLD_TO_P_NAME FROM BH.SOLDTOPARTY  T1 WHERE T1.PROPOSAL_ID = ? AND T1.SOLD_TO_PARTY_ID = ?";
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.PROPOSAL_ID, T1.SOLD_TO_PARTY_ID, T1.CUSTOMER_LIST_NO, T1.LEGACY_SOLD_P_NO, T1.SAP_SOLD_TO_P_NO, T1.BILL_TO_P_NO, T1.BILL_TO_P_NAME, T1.PAYER_NO, T1.PAYER_NAME, T1.SHIP_TO_P_NO, T1.SHIP_TO_P_NAME, T1.PLAN_START_DATE, T1.PLAN_END_DATE, T1.LAST_UPDATED_DATE, T1.BILL_TO_P_LNO, T1.PAYER_LNO, T1.SHIP_TO_P_LNO, T1.SOLD_TO_P_ASNO, T1.BILL_TO_P_ASNO, T1.SHIP_TO_P_ASNO, T1.PAYER_ASNO, T1.COUNTRY_CODE, T1.SAP_SOLD_TO_P_NAME FROM BH.SOLDTOPARTY  T1 WHERE T1.PROPOSAL_ID = ? AND T1.SOLD_TO_PARTY_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyForUpdateWithRRQuery_0 = " SELECT T1.PROPOSAL_ID, T1.SOLD_TO_PARTY_ID, T1.CUSTOMER_LIST_NO, T1.LEGACY_SOLD_P_NO, T1.SAP_SOLD_TO_P_NO, T1.BILL_TO_P_NO, T1.BILL_TO_P_NAME, T1.PAYER_NO, T1.PAYER_NAME, T1.SHIP_TO_P_NO, T1.SHIP_TO_P_NAME, T1.PLAN_START_DATE, T1.PLAN_END_DATE, T1.LAST_UPDATED_DATE, T1.BILL_TO_P_LNO, T1.PAYER_LNO, T1.SHIP_TO_P_LNO, T1.SOLD_TO_P_ASNO, T1.BILL_TO_P_ASNO, T1.SHIP_TO_P_ASNO, T1.PAYER_ASNO, T1.COUNTRY_CODE, T1.SAP_SOLD_TO_P_NAME FROM BH.SOLDTOPARTY  T1 WHERE T1.PROPOSAL_ID = ? AND T1.SOLD_TO_PARTY_ID = ? FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyForUpdateWithRSQuery_0 = " SELECT T1.PROPOSAL_ID, T1.SOLD_TO_PARTY_ID, T1.CUSTOMER_LIST_NO, T1.LEGACY_SOLD_P_NO, T1.SAP_SOLD_TO_P_NO, T1.BILL_TO_P_NO, T1.BILL_TO_P_NAME, T1.PAYER_NO, T1.PAYER_NAME, T1.SHIP_TO_P_NO, T1.SHIP_TO_P_NAME, T1.PLAN_START_DATE, T1.PLAN_END_DATE, T1.LAST_UPDATED_DATE, T1.BILL_TO_P_LNO, T1.PAYER_LNO, T1.SHIP_TO_P_LNO, T1.SOLD_TO_P_ASNO, T1.BILL_TO_P_ASNO, T1.SHIP_TO_P_ASNO, T1.PAYER_ASNO, T1.COUNTRY_CODE, T1.SAP_SOLD_TO_P_NAME FROM BH.SOLDTOPARTY  T1 WHERE T1.PROPOSAL_ID = ? AND T1.SOLD_TO_PARTY_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
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
	private static String findByProposalStartEndDateQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"PLAN_START_DATE\" = ?)  and  ( q1.\"PLAN_END_DATE\" = ?) ";
	/**
	 * FindByProposalStartEndDate
	 */
	public javax.resource.cci.Record FindByProposalStartEndDate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.planStartDate = ?2 and o.planEndDate = ?3 */
			pstmt = prepareStatement(connection, findByProposalStartEndDateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (planStartDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(1);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For ?3 (planEndDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findByProposalStartEndDateQuery_0);

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
	private static String findByProposalStartEndDateForUpdateQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"PLAN_START_DATE\" = ?)  and  ( q1.\"PLAN_END_DATE\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalStartEndDate444Update
	 */
	public javax.resource.cci.Record FindByProposalStartEndDate444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.planStartDate = ?2 and o.planEndDate = ?3 */
			pstmt = prepareStatement(connection, findByProposalStartEndDateForUpdateQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (planStartDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(1);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For ?3 (planEndDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findByProposalStartEndDateForUpdateQuery_0);

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
	private static String findByProposalStartEndDateForUpdateWithRRQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"PLAN_START_DATE\" = ?)  and  ( q1.\"PLAN_END_DATE\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalStartEndDateForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByProposalStartEndDateForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.planStartDate = ?2 and o.planEndDate = ?3 */
			pstmt = prepareStatement(connection, findByProposalStartEndDateForUpdateWithRRQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (planStartDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(1);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For ?3 (planEndDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findByProposalStartEndDateForUpdateWithRRQuery_0);

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
	private static String findByProposalStartEndDateForUpdateWithRSQuery_0 = " select  q1.\"PROPOSAL_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"CUSTOMER_LIST_NO\",  q1.\"LEGACY_SOLD_P_NO\",  q1.\"SAP_SOLD_TO_P_NO\",  q1.\"BILL_TO_P_NO\",  q1.\"BILL_TO_P_NAME\",  q1.\"PAYER_NO\",  q1.\"PAYER_NAME\",  q1.\"SHIP_TO_P_NO\",  q1.\"SHIP_TO_P_NAME\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"LAST_UPDATED_DATE\",  q1.\"BILL_TO_P_LNO\",  q1.\"PAYER_LNO\",  q1.\"SHIP_TO_P_LNO\",  q1.\"SOLD_TO_P_ASNO\",  q1.\"BILL_TO_P_ASNO\",  q1.\"SHIP_TO_P_ASNO\",  q1.\"PAYER_ASNO\",  q1.\"COUNTRY_CODE\",  q1.\"SAP_SOLD_TO_P_NAME\" from BH.SOLDTOPARTY q1 where  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"PLAN_START_DATE\" = ?)  and  ( q1.\"PLAN_END_DATE\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalStartEndDateForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByProposalStartEndDateForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from Customer o where  o.proposalId = ?1 and  o.planStartDate = ?2 and o.planEndDate = ?3 */
			pstmt = prepareStatement(connection, findByProposalStartEndDateForUpdateWithRSQuery_0);

			// For ?1 (proposalId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For ?2 (planStartDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(1);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For ?3 (planEndDate)
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(2);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			result = executeQuery(connection, pstmt, findByProposalStartEndDateForUpdateWithRSQuery_0);

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
	 * CustomerBeanFunctionSet_20fed8a5
	 */
	public CustomerBeanFunctionSet_20fed8a5() {
		functionHash=new java.util.HashMap(36);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindByProposalAndCustomerList",new Integer(4));
		functionHash.put("FindByProposalAndCustomerList444Update",new Integer(5));
		functionHash.put("FindByProposalAndCustomerListForUpdateWithRR",new Integer(6));
		functionHash.put("FindByProposalAndCustomerListForUpdateWithRS",new Integer(7));
		functionHash.put("FindByProposal",new Integer(8));
		functionHash.put("FindByProposal444Update",new Integer(9));
		functionHash.put("FindByProposalForUpdateWithRR",new Integer(10));
		functionHash.put("FindByProposalForUpdateWithRS",new Integer(11));
		functionHash.put("FindBySapCustNoAndPlanStartEndDate",new Integer(12));
		functionHash.put("FindBySapCustNoAndPlanStartEndDate444Update",new Integer(13));
		functionHash.put("FindBySapCustNoAndPlanStartEndDateForUpdateWithRR",new Integer(14));
		functionHash.put("FindBySapCustNoAndPlanStartEndDateForUpdateWithRS",new Integer(15));
		functionHash.put("FindMaxCustomerId",new Integer(16));
		functionHash.put("FindMaxCustomerId444Update",new Integer(17));
		functionHash.put("FindMaxCustomerIdForUpdateWithRR",new Integer(18));
		functionHash.put("FindMaxCustomerIdForUpdateWithRS",new Integer(19));
		functionHash.put("FindBySapCustNo",new Integer(20));
		functionHash.put("FindBySapCustNo444Update",new Integer(21));
		functionHash.put("FindBySapCustNoForUpdateWithRR",new Integer(22));
		functionHash.put("FindBySapCustNoForUpdateWithRS",new Integer(23));
		functionHash.put("FindByPrimaryKey",new Integer(24));
		functionHash.put("FindByPrimaryKey444Update",new Integer(25));
		functionHash.put("FindByPrimaryKeyForUpdateWithRR",new Integer(26));
		functionHash.put("FindByPrimaryKeyForUpdateWithRS",new Integer(27));
		functionHash.put("FindByProposalStartEndDate",new Integer(28));
		functionHash.put("FindByProposalStartEndDate444Update",new Integer(29));
		functionHash.put("FindByProposalStartEndDateForUpdateWithRR",new Integer(30));
		functionHash.put("FindByProposalStartEndDateForUpdateWithRS",new Integer(31));
		functionHash.put("ReadReadChecking",new Integer(32));
		functionHash.put("ReadReadCheckingForUpdate",new Integer(33));
		functionHash.put("PartialStore",new Integer(34));
		functionHash.put("PartialStoreUsingOCC",new Integer(35));
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
			outputRecord=FindByProposalAndCustomerList(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindByProposalAndCustomerList444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindByProposalAndCustomerListForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindByProposalAndCustomerListForUpdateWithRS(inputRecord,connection,interactionSpec);
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
			outputRecord=FindBySapCustNoAndPlanStartEndDate(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=FindBySapCustNoAndPlanStartEndDate444Update(inputRecord,connection,interactionSpec);
			break;
		case 14:
			outputRecord=FindBySapCustNoAndPlanStartEndDateForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 15:
			outputRecord=FindBySapCustNoAndPlanStartEndDateForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 16:
			outputRecord=FindMaxCustomerId(inputRecord,connection,interactionSpec);
			break;
		case 17:
			outputRecord=FindMaxCustomerId444Update(inputRecord,connection,interactionSpec);
			break;
		case 18:
			outputRecord=FindMaxCustomerIdForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 19:
			outputRecord=FindMaxCustomerIdForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 20:
			outputRecord=FindBySapCustNo(inputRecord,connection,interactionSpec);
			break;
		case 21:
			outputRecord=FindBySapCustNo444Update(inputRecord,connection,interactionSpec);
			break;
		case 22:
			outputRecord=FindBySapCustNoForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 23:
			outputRecord=FindBySapCustNoForUpdateWithRS(inputRecord,connection,interactionSpec);
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
			outputRecord=FindByProposalStartEndDate(inputRecord,connection,interactionSpec);
			break;
		case 29:
			outputRecord=FindByProposalStartEndDate444Update(inputRecord,connection,interactionSpec);
			break;
		case 30:
			outputRecord=FindByProposalStartEndDateForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 31:
			outputRecord=FindByProposalStartEndDateForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 32:
			ReadReadChecking(inputRecord,connection,interactionSpec);
			break;
		case 33:
			ReadReadCheckingForUpdate(inputRecord,connection,interactionSpec);
			break;
		case 34:
			PartialStore(inputRecord,connection,interactionSpec);
			break;
		case 35:
			PartialStoreUsingOCC(inputRecord,connection,interactionSpec);
			break;
		}
		return outputRecord;
	}
	private static String ReadReadQuery_0 = " SELECT 1 FROM BH.SOLDTOPARTY  T1 WHERE T1.PROPOSAL_ID = ? AND T1.SOLD_TO_PARTY_ID = ?";
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM BH.SOLDTOPARTY  T1 WHERE T1.PROPOSAL_ID = ? AND T1.SOLD_TO_PARTY_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
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
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(2,tempInteger.intValue());
				else
					pstmt.setNull(2,java.sql.Types.INTEGER);
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
		updateTemplateList = CustomerBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
						// For column CUSTOMER_LIST_NO
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
						// For column LEGACY_SOLD_P_NO
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
						// For column SAP_SOLD_TO_P_NO
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
						// For column BILL_TO_P_NO
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
						// For column BILL_TO_P_NAME
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
						// For column PAYER_NO
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
						// For column PAYER_NAME
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
						// For column SHIP_TO_P_NO
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
						// For column SHIP_TO_P_NAME
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
						// For column PLAN_START_DATE
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
						// For column PLAN_END_DATE
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
						// For column LAST_UPDATED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(13);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column BILL_TO_P_LNO
						String tempString;


						tempString=(String)inputRecord.get(14);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column PAYER_LNO
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
						// For column SHIP_TO_P_LNO
						String tempString;


						tempString=(String)inputRecord.get(16);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[17])
					{
						// For column SOLD_TO_P_ASNO
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
						// For column BILL_TO_P_ASNO
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
						// For column SHIP_TO_P_ASNO
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
						// For column PAYER_ASNO
						String tempString;


						tempString=(String)inputRecord.get(20);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column COUNTRY_CODE
						String tempString;


						tempString=(String)inputRecord.get(21);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column SAP_SOLD_TO_P_NAME
						String tempString;


						tempString=(String)inputRecord.get(22);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(0);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column SOLD_TO_PARTY_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(1);
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
						// For column CUSTOMER_LIST_NO
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
						// For column LEGACY_SOLD_P_NO
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
						// For column SAP_SOLD_TO_P_NO
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
						// For column BILL_TO_P_NO
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
						// For column BILL_TO_P_NAME
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
						// For column PAYER_NO
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
						// For column PAYER_NAME
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
						// For column SHIP_TO_P_NO
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
						// For column SHIP_TO_P_NAME
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
						// For column PLAN_START_DATE
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
						// For column PLAN_END_DATE
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
						// For column LAST_UPDATED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(13);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column BILL_TO_P_LNO
						String tempString;


						tempString=(String)inputRecord.get(14);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column PAYER_LNO
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
						// For column SHIP_TO_P_LNO
						String tempString;


						tempString=(String)inputRecord.get(16);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[17])
					{
						// For column SOLD_TO_P_ASNO
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
						// For column BILL_TO_P_ASNO
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
						// For column SHIP_TO_P_ASNO
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
						// For column PAYER_ASNO
						String tempString;


						tempString=(String)inputRecord.get(20);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column COUNTRY_CODE
						String tempString;


						tempString=(String)inputRecord.get(21);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column SAP_SOLD_TO_P_NAME
						String tempString;


						tempString=(String)inputRecord.get(22);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(0);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					{
						// For column SOLD_TO_PARTY_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(1);
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
