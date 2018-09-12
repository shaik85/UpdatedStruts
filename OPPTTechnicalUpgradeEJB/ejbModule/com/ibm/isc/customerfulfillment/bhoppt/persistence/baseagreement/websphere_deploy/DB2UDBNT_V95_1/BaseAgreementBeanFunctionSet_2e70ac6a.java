package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * BaseAgreementBeanFunctionSet_2e70ac6a
 */
public class BaseAgreementBeanFunctionSet_2e70ac6a extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO BH.BASEAGREEMENT (AGREEMENT_ID, AGREEMENT_NUMBER, FORM_NUMBER, LEGACY_CUSTOMER_NUMBER, INAC, EXPIRATION_DATE, CHANGED_DATE, CHANGED_BY, ONE_WAY, IS_ELECTRONIC_SUBMITTER, IMAGE_REFERENCE_NUMBER, CUSTOMER_REPRESENTATIVE, BRANCH_OFFICE, COVERAGE_TYPE, FILE_NUMBER, LEGAL_CONTACT_HDR, ACCOUNTING_CONTACT_HDR, SALES_ORG, ACCEPTED_DATE, CREATED_BY, CREATED_DATE, IS_MODIFIED_AGGREEMENT, SIGN_CUSTOMER_NUMBER, SIGN_CUSTOMER_NAME, ACTUAL_AGREEMENT_TITLE, STATUS_CODE, AGREEMENT_IDENTIFIER1, LEGACY_CC) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column AGREEMENT_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
			}
			// For column AGREEMENT_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column FORM_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For column LEGACY_CUSTOMER_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.CHAR);
			}
			// For column INAC
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column EXPIRATION_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(5);
				if(tempDate != null)
					pstmt.setDate(6,tempDate);
				else
					pstmt.setNull(6,java.sql.Types.DATE);
			}
			// For column CHANGED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(6);
				if(tempDate != null)
					pstmt.setDate(7,tempDate);
				else
					pstmt.setNull(7,java.sql.Types.DATE);
			}
			// For column CHANGED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.VARCHAR);
			}
			// For column ONE_WAY
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column IS_ELECTRONIC_SUBMITTER
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.CHAR);
			}
			// For column IMAGE_REFERENCE_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.VARCHAR);
			}
			// For column CUSTOMER_REPRESENTATIVE
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
			}
			// For column BRANCH_OFFICE
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.VARCHAR);
			}
			// For column COVERAGE_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.CHAR);
			}
			// For column FILE_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(15,tempString);
				else
					pstmt.setNull(15,java.sql.Types.CHAR);
			}
			// For column LEGAL_CONTACT_HDR
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.VARCHAR);
			}
			// For column ACCOUNTING_CONTACT_HDR
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.VARCHAR);
			}
			// For column SALES_ORG
			{
				String tempString;


				tempString=(String)inputRecord.get(17);
				if(tempString != null)
					pstmt.setString(18,tempString);
				else
					pstmt.setNull(18,java.sql.Types.CHAR);
			}
			// For column ACCEPTED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(18);
				if(tempDate != null)
					pstmt.setDate(19,tempDate);
				else
					pstmt.setNull(19,java.sql.Types.DATE);
			}
			// For column CREATED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(20,tempString);
				else
					pstmt.setNull(20,java.sql.Types.VARCHAR);
			}
			// For column CREATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(20);
				if(tempDate != null)
					pstmt.setDate(21,tempDate);
				else
					pstmt.setNull(21,java.sql.Types.DATE);
			}
			// For column IS_MODIFIED_AGGREEMENT
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.CHAR);
			}
			// For column SIGN_CUSTOMER_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(22);
				if(tempString != null)
					pstmt.setString(23,tempString);
				else
					pstmt.setNull(23,java.sql.Types.CHAR);
			}
			// For column SIGN_CUSTOMER_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(23);
				if(tempString != null)
					pstmt.setString(24,tempString);
				else
					pstmt.setNull(24,java.sql.Types.VARCHAR);
			}
			// For column ACTUAL_AGREEMENT_TITLE

			pstmt.setString(25,(String)inputRecord.get(24));
			// For column STATUS_CODE
			{
				String tempString;


				tempString=(String)inputRecord.get(25);
				if(tempString != null)
					pstmt.setString(26,tempString);
				else
					pstmt.setNull(26,java.sql.Types.CHAR);
			}
			// For column AGREEMENT_IDENTIFIER1
			{
				String tempString;


				tempString=(String)inputRecord.get(26);
				if(tempString != null)
					pstmt.setString(27,tempString);
				else
					pstmt.setNull(27,java.sql.Types.CHAR);
			}
			// For column LEGACY_CC
			{
				String tempString;


				tempString=(String)inputRecord.get(27);
				if(tempString != null)
					pstmt.setString(28,tempString);
				else
					pstmt.setNull(28,java.sql.Types.CHAR);
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
	private static String RemoveQuery_0 = "DELETE FROM BH.BASEAGREEMENT  WHERE AGREEMENT_ID = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column AGREEMENT_ID
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
	private static String StoreQuery_0 = "UPDATE BH.BASEAGREEMENT  SET AGREEMENT_NUMBER = ?, FORM_NUMBER = ?, LEGACY_CUSTOMER_NUMBER = ?, INAC = ?, EXPIRATION_DATE = ?, CHANGED_DATE = ?, CHANGED_BY = ?, ONE_WAY = ?, IS_ELECTRONIC_SUBMITTER = ?, IMAGE_REFERENCE_NUMBER = ?, CUSTOMER_REPRESENTATIVE = ?, BRANCH_OFFICE = ?, COVERAGE_TYPE = ?, FILE_NUMBER = ?, LEGAL_CONTACT_HDR = ?, ACCOUNTING_CONTACT_HDR = ?, SALES_ORG = ?, ACCEPTED_DATE = ?, CREATED_BY = ?, CREATED_DATE = ?, IS_MODIFIED_AGGREEMENT = ?, SIGN_CUSTOMER_NUMBER = ?, SIGN_CUSTOMER_NAME = ?, ACTUAL_AGREEMENT_TITLE = ?, STATUS_CODE = ?, AGREEMENT_IDENTIFIER1 = ?, LEGACY_CC = ? WHERE AGREEMENT_ID = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column AGREEMENT_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(28,tempInteger.intValue());
				else
					pstmt.setNull(28,java.sql.Types.INTEGER);
			}
			// For column AGREEMENT_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column FORM_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column LEGACY_CUSTOMER_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.CHAR);
			}
			// For column INAC
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.CHAR);
			}
			// For column EXPIRATION_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(5);
				if(tempDate != null)
					pstmt.setDate(5,tempDate);
				else
					pstmt.setNull(5,java.sql.Types.DATE);
			}
			// For column CHANGED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(6);
				if(tempDate != null)
					pstmt.setDate(6,tempDate);
				else
					pstmt.setNull(6,java.sql.Types.DATE);
			}
			// For column CHANGED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column ONE_WAY
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column IS_ELECTRONIC_SUBMITTER
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column IMAGE_REFERENCE_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.VARCHAR);
			}
			// For column CUSTOMER_REPRESENTATIVE
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.VARCHAR);
			}
			// For column BRANCH_OFFICE
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
			}
			// For column COVERAGE_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.CHAR);
			}
			// For column FILE_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.CHAR);
			}
			// For column LEGAL_CONTACT_HDR
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(15,tempString);
				else
					pstmt.setNull(15,java.sql.Types.VARCHAR);
			}
			// For column ACCOUNTING_CONTACT_HDR
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.VARCHAR);
			}
			// For column SALES_ORG
			{
				String tempString;


				tempString=(String)inputRecord.get(17);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.CHAR);
			}
			// For column ACCEPTED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(18);
				if(tempDate != null)
					pstmt.setDate(18,tempDate);
				else
					pstmt.setNull(18,java.sql.Types.DATE);
			}
			// For column CREATED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(19,tempString);
				else
					pstmt.setNull(19,java.sql.Types.VARCHAR);
			}
			// For column CREATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(20);
				if(tempDate != null)
					pstmt.setDate(20,tempDate);
				else
					pstmt.setNull(20,java.sql.Types.DATE);
			}
			// For column IS_MODIFIED_AGGREEMENT
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(21,tempString);
				else
					pstmt.setNull(21,java.sql.Types.CHAR);
			}
			// For column SIGN_CUSTOMER_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(22);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.CHAR);
			}
			// For column SIGN_CUSTOMER_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(23);
				if(tempString != null)
					pstmt.setString(23,tempString);
				else
					pstmt.setNull(23,java.sql.Types.VARCHAR);
			}
			// For column ACTUAL_AGREEMENT_TITLE

			pstmt.setString(24,(String)inputRecord.get(24));
			// For column STATUS_CODE
			{
				String tempString;


				tempString=(String)inputRecord.get(25);
				if(tempString != null)
					pstmt.setString(25,tempString);
				else
					pstmt.setNull(25,java.sql.Types.CHAR);
			}
			// For column AGREEMENT_IDENTIFIER1
			{
				String tempString;


				tempString=(String)inputRecord.get(26);
				if(tempString != null)
					pstmt.setString(26,tempString);
				else
					pstmt.setNull(26,java.sql.Types.CHAR);
			}
			// For column LEGACY_CC
			{
				String tempString;


				tempString=(String)inputRecord.get(27);
				if(tempString != null)
					pstmt.setString(27,tempString);
				else
					pstmt.setNull(27,java.sql.Types.CHAR);
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
	private static String StoreOCCQuery_0 = "UPDATE BH.BASEAGREEMENT  SET AGREEMENT_NUMBER = ?, FORM_NUMBER = ?, LEGACY_CUSTOMER_NUMBER = ?, INAC = ?, EXPIRATION_DATE = ?, CHANGED_DATE = ?, CHANGED_BY = ?, ONE_WAY = ?, IS_ELECTRONIC_SUBMITTER = ?, IMAGE_REFERENCE_NUMBER = ?, CUSTOMER_REPRESENTATIVE = ?, BRANCH_OFFICE = ?, COVERAGE_TYPE = ?, FILE_NUMBER = ?, LEGAL_CONTACT_HDR = ?, ACCOUNTING_CONTACT_HDR = ?, SALES_ORG = ?, ACCEPTED_DATE = ?, CREATED_BY = ?, CREATED_DATE = ?, IS_MODIFIED_AGGREEMENT = ?, SIGN_CUSTOMER_NUMBER = ?, SIGN_CUSTOMER_NAME = ?, ACTUAL_AGREEMENT_TITLE = ?, STATUS_CODE = ?, AGREEMENT_IDENTIFIER1 = ?, LEGACY_CC = ? WHERE AGREEMENT_ID = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column AGREEMENT_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(28,tempInteger.intValue());
				else
					pstmt.setNull(28,java.sql.Types.INTEGER);
			}
			// For column AGREEMENT_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column FORM_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For column LEGACY_CUSTOMER_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.CHAR);
			}
			// For column INAC
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.CHAR);
			}
			// For column EXPIRATION_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(5);
				if(tempDate != null)
					pstmt.setDate(5,tempDate);
				else
					pstmt.setNull(5,java.sql.Types.DATE);
			}
			// For column CHANGED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(6);
				if(tempDate != null)
					pstmt.setDate(6,tempDate);
				else
					pstmt.setNull(6,java.sql.Types.DATE);
			}
			// For column CHANGED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(7,tempString);
				else
					pstmt.setNull(7,java.sql.Types.VARCHAR);
			}
			// For column ONE_WAY
			{
				String tempString;


				tempString=(String)inputRecord.get(8);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column IS_ELECTRONIC_SUBMITTER
			{
				String tempString;


				tempString=(String)inputRecord.get(9);
				if(tempString != null)
					pstmt.setString(9,tempString);
				else
					pstmt.setNull(9,java.sql.Types.CHAR);
			}
			// For column IMAGE_REFERENCE_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(10,tempString);
				else
					pstmt.setNull(10,java.sql.Types.VARCHAR);
			}
			// For column CUSTOMER_REPRESENTATIVE
			{
				String tempString;


				tempString=(String)inputRecord.get(11);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.VARCHAR);
			}
			// For column BRANCH_OFFICE
			{
				String tempString;


				tempString=(String)inputRecord.get(12);
				if(tempString != null)
					pstmt.setString(12,tempString);
				else
					pstmt.setNull(12,java.sql.Types.VARCHAR);
			}
			// For column COVERAGE_TYPE
			{
				String tempString;


				tempString=(String)inputRecord.get(13);
				if(tempString != null)
					pstmt.setString(13,tempString);
				else
					pstmt.setNull(13,java.sql.Types.CHAR);
			}
			// For column FILE_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(14);
				if(tempString != null)
					pstmt.setString(14,tempString);
				else
					pstmt.setNull(14,java.sql.Types.CHAR);
			}
			// For column LEGAL_CONTACT_HDR
			{
				String tempString;


				tempString=(String)inputRecord.get(15);
				if(tempString != null)
					pstmt.setString(15,tempString);
				else
					pstmt.setNull(15,java.sql.Types.VARCHAR);
			}
			// For column ACCOUNTING_CONTACT_HDR
			{
				String tempString;


				tempString=(String)inputRecord.get(16);
				if(tempString != null)
					pstmt.setString(16,tempString);
				else
					pstmt.setNull(16,java.sql.Types.VARCHAR);
			}
			// For column SALES_ORG
			{
				String tempString;


				tempString=(String)inputRecord.get(17);
				if(tempString != null)
					pstmt.setString(17,tempString);
				else
					pstmt.setNull(17,java.sql.Types.CHAR);
			}
			// For column ACCEPTED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(18);
				if(tempDate != null)
					pstmt.setDate(18,tempDate);
				else
					pstmt.setNull(18,java.sql.Types.DATE);
			}
			// For column CREATED_BY
			{
				String tempString;


				tempString=(String)inputRecord.get(19);
				if(tempString != null)
					pstmt.setString(19,tempString);
				else
					pstmt.setNull(19,java.sql.Types.VARCHAR);
			}
			// For column CREATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(20);
				if(tempDate != null)
					pstmt.setDate(20,tempDate);
				else
					pstmt.setNull(20,java.sql.Types.DATE);
			}
			// For column IS_MODIFIED_AGGREEMENT
			{
				String tempString;


				tempString=(String)inputRecord.get(21);
				if(tempString != null)
					pstmt.setString(21,tempString);
				else
					pstmt.setNull(21,java.sql.Types.CHAR);
			}
			// For column SIGN_CUSTOMER_NUMBER
			{
				String tempString;


				tempString=(String)inputRecord.get(22);
				if(tempString != null)
					pstmt.setString(22,tempString);
				else
					pstmt.setNull(22,java.sql.Types.CHAR);
			}
			// For column SIGN_CUSTOMER_NAME
			{
				String tempString;


				tempString=(String)inputRecord.get(23);
				if(tempString != null)
					pstmt.setString(23,tempString);
				else
					pstmt.setNull(23,java.sql.Types.VARCHAR);
			}
			// For column ACTUAL_AGREEMENT_TITLE

			pstmt.setString(24,(String)inputRecord.get(24));
			// For column STATUS_CODE
			{
				String tempString;


				tempString=(String)inputRecord.get(25);
				if(tempString != null)
					pstmt.setString(25,tempString);
				else
					pstmt.setNull(25,java.sql.Types.CHAR);
			}
			// For column AGREEMENT_IDENTIFIER1
			{
				String tempString;


				tempString=(String)inputRecord.get(26);
				if(tempString != null)
					pstmt.setString(26,tempString);
				else
					pstmt.setNull(26,java.sql.Types.CHAR);
			}
			// For column LEGACY_CC
			{
				String tempString;


				tempString=(String)inputRecord.get(27);
				if(tempString != null)
					pstmt.setString(27,tempString);
				else
					pstmt.setNull(27,java.sql.Types.CHAR);
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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.AGREEMENT_ID, T1.AGREEMENT_NUMBER, T1.FORM_NUMBER, T1.LEGACY_CUSTOMER_NUMBER, T1.INAC, T1.EXPIRATION_DATE, T1.CHANGED_DATE, T1.CHANGED_BY, T1.ONE_WAY, T1.IS_ELECTRONIC_SUBMITTER, T1.IMAGE_REFERENCE_NUMBER, T1.CUSTOMER_REPRESENTATIVE, T1.BRANCH_OFFICE, T1.COVERAGE_TYPE, T1.FILE_NUMBER, T1.LEGAL_CONTACT_HDR, T1.ACCOUNTING_CONTACT_HDR, T1.SALES_ORG, T1.ACCEPTED_DATE, T1.CREATED_BY, T1.CREATED_DATE, T1.IS_MODIFIED_AGGREEMENT, T1.SIGN_CUSTOMER_NUMBER, T1.SIGN_CUSTOMER_NAME, T1.ACTUAL_AGREEMENT_TITLE, T1.STATUS_CODE, T1.AGREEMENT_IDENTIFIER1, T1.LEGACY_CC FROM BH.BASEAGREEMENT  T1 WHERE T1.AGREEMENT_ID = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column AGREEMENT_ID
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.AGREEMENT_ID, T1.AGREEMENT_NUMBER, T1.FORM_NUMBER, T1.LEGACY_CUSTOMER_NUMBER, T1.INAC, T1.EXPIRATION_DATE, T1.CHANGED_DATE, T1.CHANGED_BY, T1.ONE_WAY, T1.IS_ELECTRONIC_SUBMITTER, T1.IMAGE_REFERENCE_NUMBER, T1.CUSTOMER_REPRESENTATIVE, T1.BRANCH_OFFICE, T1.COVERAGE_TYPE, T1.FILE_NUMBER, T1.LEGAL_CONTACT_HDR, T1.ACCOUNTING_CONTACT_HDR, T1.SALES_ORG, T1.ACCEPTED_DATE, T1.CREATED_BY, T1.CREATED_DATE, T1.IS_MODIFIED_AGGREEMENT, T1.SIGN_CUSTOMER_NUMBER, T1.SIGN_CUSTOMER_NAME, T1.ACTUAL_AGREEMENT_TITLE, T1.STATUS_CODE, T1.AGREEMENT_IDENTIFIER1, T1.LEGACY_CC FROM BH.BASEAGREEMENT  T1 WHERE T1.AGREEMENT_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column AGREEMENT_ID
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
	private static String FindByPrimaryKeyForUpdateWithRRQuery_0 = " SELECT T1.AGREEMENT_ID, T1.AGREEMENT_NUMBER, T1.FORM_NUMBER, T1.LEGACY_CUSTOMER_NUMBER, T1.INAC, T1.EXPIRATION_DATE, T1.CHANGED_DATE, T1.CHANGED_BY, T1.ONE_WAY, T1.IS_ELECTRONIC_SUBMITTER, T1.IMAGE_REFERENCE_NUMBER, T1.CUSTOMER_REPRESENTATIVE, T1.BRANCH_OFFICE, T1.COVERAGE_TYPE, T1.FILE_NUMBER, T1.LEGAL_CONTACT_HDR, T1.ACCOUNTING_CONTACT_HDR, T1.SALES_ORG, T1.ACCEPTED_DATE, T1.CREATED_BY, T1.CREATED_DATE, T1.IS_MODIFIED_AGGREEMENT, T1.SIGN_CUSTOMER_NUMBER, T1.SIGN_CUSTOMER_NAME, T1.ACTUAL_AGREEMENT_TITLE, T1.STATUS_CODE, T1.AGREEMENT_IDENTIFIER1, T1.LEGACY_CC FROM BH.BASEAGREEMENT  T1 WHERE T1.AGREEMENT_ID = ? FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRRQuery_0);

			// For column AGREEMENT_ID
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
	private static String FindByPrimaryKeyForUpdateWithRSQuery_0 = " SELECT T1.AGREEMENT_ID, T1.AGREEMENT_NUMBER, T1.FORM_NUMBER, T1.LEGACY_CUSTOMER_NUMBER, T1.INAC, T1.EXPIRATION_DATE, T1.CHANGED_DATE, T1.CHANGED_BY, T1.ONE_WAY, T1.IS_ELECTRONIC_SUBMITTER, T1.IMAGE_REFERENCE_NUMBER, T1.CUSTOMER_REPRESENTATIVE, T1.BRANCH_OFFICE, T1.COVERAGE_TYPE, T1.FILE_NUMBER, T1.LEGAL_CONTACT_HDR, T1.ACCOUNTING_CONTACT_HDR, T1.SALES_ORG, T1.ACCEPTED_DATE, T1.CREATED_BY, T1.CREATED_DATE, T1.IS_MODIFIED_AGGREEMENT, T1.SIGN_CUSTOMER_NUMBER, T1.SIGN_CUSTOMER_NAME, T1.ACTUAL_AGREEMENT_TITLE, T1.STATUS_CODE, T1.AGREEMENT_IDENTIFIER1, T1.LEGACY_CC FROM BH.BASEAGREEMENT  T1 WHERE T1.AGREEMENT_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRSQuery_0);

			// For column AGREEMENT_ID
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
	private static String findByCustomerNumberandFormNumberQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"SIGN_CUSTOMER_NUMBER\" = ?)  and  ( q1.\"FORM_NUMBER\" = ?) ";
	/**
	 * FindByCustomerNumberandFormNumber
	 */
	public javax.resource.cci.Record FindByCustomerNumberandFormNumber(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where o.customerNumber = ?1 and o.formNumber = ?2 */
			pstmt = prepareStatement(connection, findByCustomerNumberandFormNumberQuery_0);

			// For ?1 (customerNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (formNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByCustomerNumberandFormNumberQuery_0);

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
	private static String findByCustomerNumberandFormNumberForUpdateQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"SIGN_CUSTOMER_NUMBER\" = ?)  and  ( q1.\"FORM_NUMBER\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByCustomerNumberandFormNumber444Update
	 */
	public javax.resource.cci.Record FindByCustomerNumberandFormNumber444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where o.customerNumber = ?1 and o.formNumber = ?2 */
			pstmt = prepareStatement(connection, findByCustomerNumberandFormNumberForUpdateQuery_0);

			// For ?1 (customerNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (formNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByCustomerNumberandFormNumberForUpdateQuery_0);

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
	private static String findByCustomerNumberandFormNumberForUpdateWithRRQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"SIGN_CUSTOMER_NUMBER\" = ?)  and  ( q1.\"FORM_NUMBER\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByCustomerNumberandFormNumberForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByCustomerNumberandFormNumberForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where o.customerNumber = ?1 and o.formNumber = ?2 */
			pstmt = prepareStatement(connection, findByCustomerNumberandFormNumberForUpdateWithRRQuery_0);

			// For ?1 (customerNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (formNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByCustomerNumberandFormNumberForUpdateWithRRQuery_0);

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
	private static String findByCustomerNumberandFormNumberForUpdateWithRSQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"SIGN_CUSTOMER_NUMBER\" = ?)  and  ( q1.\"FORM_NUMBER\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByCustomerNumberandFormNumberForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByCustomerNumberandFormNumberForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where o.customerNumber = ?1 and o.formNumber = ?2 */
			pstmt = prepareStatement(connection, findByCustomerNumberandFormNumberForUpdateWithRSQuery_0);

			// For ?1 (customerNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (formNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findByCustomerNumberandFormNumberForUpdateWithRSQuery_0);

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
	private static String findBySalesOrgAndFormNumberQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"SALES_ORG\" = ?)  and  ( q1.\"FORM_NUMBER\" = ?) ";
	/**
	 * FindBySalesOrgAndFormNumber
	 */
	public javax.resource.cci.Record FindBySalesOrgAndFormNumber(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where  o.salesOrganization = ?1 and  o.formNumber = ?2 */
			pstmt = prepareStatement(connection, findBySalesOrgAndFormNumberQuery_0);

			// For ?1 (salesOrganization)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (formNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySalesOrgAndFormNumberQuery_0);

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
	private static String findBySalesOrgAndFormNumberForUpdateQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"SALES_ORG\" = ?)  and  ( q1.\"FORM_NUMBER\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySalesOrgAndFormNumber444Update
	 */
	public javax.resource.cci.Record FindBySalesOrgAndFormNumber444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where  o.salesOrganization = ?1 and  o.formNumber = ?2 */
			pstmt = prepareStatement(connection, findBySalesOrgAndFormNumberForUpdateQuery_0);

			// For ?1 (salesOrganization)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (formNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySalesOrgAndFormNumberForUpdateQuery_0);

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
	private static String findBySalesOrgAndFormNumberForUpdateWithRRQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"SALES_ORG\" = ?)  and  ( q1.\"FORM_NUMBER\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySalesOrgAndFormNumberForUpdateWithRR
	 */
	public javax.resource.cci.Record FindBySalesOrgAndFormNumberForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where  o.salesOrganization = ?1 and  o.formNumber = ?2 */
			pstmt = prepareStatement(connection, findBySalesOrgAndFormNumberForUpdateWithRRQuery_0);

			// For ?1 (salesOrganization)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (formNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySalesOrgAndFormNumberForUpdateWithRRQuery_0);

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
	private static String findBySalesOrgAndFormNumberForUpdateWithRSQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"SALES_ORG\" = ?)  and  ( q1.\"FORM_NUMBER\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySalesOrgAndFormNumberForUpdateWithRS
	 */
	public javax.resource.cci.Record FindBySalesOrgAndFormNumberForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where  o.salesOrganization = ?1 and  o.formNumber = ?2 */
			pstmt = prepareStatement(connection, findBySalesOrgAndFormNumberForUpdateWithRSQuery_0);

			// For ?1 (salesOrganization)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (formNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySalesOrgAndFormNumberForUpdateWithRSQuery_0);

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
	private static String findMaxAgreementIdQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"AGREEMENT_ID\" =  ( select  max( q2.\"AGREEMENT_ID\") from BH.BASEAGREEMENT q2) ) ";
	/**
	 * FindMaxAgreementId
	 */
	public javax.resource.cci.Record FindMaxAgreementId(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where  o.agreementId = (select max(a.agreementId) from BaseAgreement a) */
			pstmt = prepareStatement(connection, findMaxAgreementIdQuery_0);

			result = executeQuery(connection, pstmt, findMaxAgreementIdQuery_0);

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
	private static String findMaxAgreementIdForUpdateQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"AGREEMENT_ID\" =  ( select  max( q2.\"AGREEMENT_ID\") from BH.BASEAGREEMENT q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxAgreementId444Update
	 */
	public javax.resource.cci.Record FindMaxAgreementId444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where  o.agreementId = (select max(a.agreementId) from BaseAgreement a) */
			pstmt = prepareStatement(connection, findMaxAgreementIdForUpdateQuery_0);

			result = executeQuery(connection, pstmt, findMaxAgreementIdForUpdateQuery_0);

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
	private static String findMaxAgreementIdForUpdateWithRRQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"AGREEMENT_ID\" =  ( select  max( q2.\"AGREEMENT_ID\") from BH.BASEAGREEMENT q2) )  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxAgreementIdForUpdateWithRR
	 */
	public javax.resource.cci.Record FindMaxAgreementIdForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where  o.agreementId = (select max(a.agreementId) from BaseAgreement a) */
			pstmt = prepareStatement(connection, findMaxAgreementIdForUpdateWithRRQuery_0);

			result = executeQuery(connection, pstmt, findMaxAgreementIdForUpdateWithRRQuery_0);

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
	private static String findMaxAgreementIdForUpdateWithRSQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"AGREEMENT_ID\" =  ( select  max( q2.\"AGREEMENT_ID\") from BH.BASEAGREEMENT q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxAgreementIdForUpdateWithRS
	 */
	public javax.resource.cci.Record FindMaxAgreementIdForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where  o.agreementId = (select max(a.agreementId) from BaseAgreement a) */
			pstmt = prepareStatement(connection, findMaxAgreementIdForUpdateWithRSQuery_0);

			result = executeQuery(connection, pstmt, findMaxAgreementIdForUpdateWithRSQuery_0);

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
	private static String findBySearchQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"AGREEMENT_NUMBER\" = ? or  q1.\"FORM_NUMBER\" = ? or  q1.\"SIGN_CUSTOMER_NUMBER\" = ? or  q1.\"AGREEMENT_IDENTIFIER1\" = ?) ";
	/**
	 * FindBySearch
	 */
	public javax.resource.cci.Record FindBySearch(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where  o.agreementNumber = ?1 or  o.formNumber = ?2 or  o.customerNumber = ?3 or  o.enterpriseNumber = ?4 */
			pstmt = prepareStatement(connection, findBySearchQuery_0);

			// For ?1 (agreementNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (formNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (customerNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (enterpriseNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySearchQuery_0);

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
	private static String findBySearchForUpdateQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"AGREEMENT_NUMBER\" = ? or  q1.\"FORM_NUMBER\" = ? or  q1.\"SIGN_CUSTOMER_NUMBER\" = ? or  q1.\"AGREEMENT_IDENTIFIER1\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySearch444Update
	 */
	public javax.resource.cci.Record FindBySearch444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where  o.agreementNumber = ?1 or  o.formNumber = ?2 or  o.customerNumber = ?3 or  o.enterpriseNumber = ?4 */
			pstmt = prepareStatement(connection, findBySearchForUpdateQuery_0);

			// For ?1 (agreementNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (formNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (customerNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (enterpriseNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySearchForUpdateQuery_0);

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
	private static String findBySearchForUpdateWithRRQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"AGREEMENT_NUMBER\" = ? or  q1.\"FORM_NUMBER\" = ? or  q1.\"SIGN_CUSTOMER_NUMBER\" = ? or  q1.\"AGREEMENT_IDENTIFIER1\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySearchForUpdateWithRR
	 */
	public javax.resource.cci.Record FindBySearchForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where  o.agreementNumber = ?1 or  o.formNumber = ?2 or  o.customerNumber = ?3 or  o.enterpriseNumber = ?4 */
			pstmt = prepareStatement(connection, findBySearchForUpdateWithRRQuery_0);

			// For ?1 (agreementNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (formNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (customerNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (enterpriseNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySearchForUpdateWithRRQuery_0);

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
	private static String findBySearchForUpdateWithRSQuery_0 = " select  q1.\"AGREEMENT_ID\",  q1.\"AGREEMENT_NUMBER\",  q1.\"FORM_NUMBER\",  q1.\"LEGACY_CUSTOMER_NUMBER\",  q1.\"INAC\",  q1.\"EXPIRATION_DATE\",  q1.\"CHANGED_DATE\",  q1.\"CHANGED_BY\",  q1.\"ONE_WAY\",  q1.\"IS_ELECTRONIC_SUBMITTER\",  q1.\"IMAGE_REFERENCE_NUMBER\",  q1.\"CUSTOMER_REPRESENTATIVE\",  q1.\"BRANCH_OFFICE\",  q1.\"COVERAGE_TYPE\",  q1.\"FILE_NUMBER\",  q1.\"LEGAL_CONTACT_HDR\",  q1.\"ACCOUNTING_CONTACT_HDR\",  q1.\"SALES_ORG\",  q1.\"ACCEPTED_DATE\",  q1.\"CREATED_BY\",  q1.\"CREATED_DATE\",  q1.\"IS_MODIFIED_AGGREEMENT\",  q1.\"SIGN_CUSTOMER_NUMBER\",  q1.\"SIGN_CUSTOMER_NAME\",  q1.\"ACTUAL_AGREEMENT_TITLE\",  q1.\"STATUS_CODE\",  q1.\"AGREEMENT_IDENTIFIER1\",  q1.\"LEGACY_CC\" from BH.BASEAGREEMENT q1 where  ( q1.\"AGREEMENT_NUMBER\" = ? or  q1.\"FORM_NUMBER\" = ? or  q1.\"SIGN_CUSTOMER_NUMBER\" = ? or  q1.\"AGREEMENT_IDENTIFIER1\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindBySearchForUpdateWithRS
	 */
	public javax.resource.cci.Record FindBySearchForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from BaseAgreement o where  o.agreementNumber = ?1 or  o.formNumber = ?2 or  o.customerNumber = ?3 or  o.enterpriseNumber = ?4 */
			pstmt = prepareStatement(connection, findBySearchForUpdateWithRSQuery_0);

			// For ?1 (agreementNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(0);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For ?2 (formNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(1);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.VARCHAR);
			}
			// For ?3 (customerNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
			}
			// For ?4 (enterpriseNumber)
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			result = executeQuery(connection, pstmt, findBySearchForUpdateWithRSQuery_0);

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
	 * BaseAgreementBeanFunctionSet_2e70ac6a
	 */
	public BaseAgreementBeanFunctionSet_2e70ac6a() {
		functionHash=new java.util.HashMap(28);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindByPrimaryKey",new Integer(4));
		functionHash.put("FindByPrimaryKey444Update",new Integer(5));
		functionHash.put("FindByPrimaryKeyForUpdateWithRR",new Integer(6));
		functionHash.put("FindByPrimaryKeyForUpdateWithRS",new Integer(7));
		functionHash.put("FindByCustomerNumberandFormNumber",new Integer(8));
		functionHash.put("FindByCustomerNumberandFormNumber444Update",new Integer(9));
		functionHash.put("FindByCustomerNumberandFormNumberForUpdateWithRR",new Integer(10));
		functionHash.put("FindByCustomerNumberandFormNumberForUpdateWithRS",new Integer(11));
		functionHash.put("FindBySalesOrgAndFormNumber",new Integer(12));
		functionHash.put("FindBySalesOrgAndFormNumber444Update",new Integer(13));
		functionHash.put("FindBySalesOrgAndFormNumberForUpdateWithRR",new Integer(14));
		functionHash.put("FindBySalesOrgAndFormNumberForUpdateWithRS",new Integer(15));
		functionHash.put("FindMaxAgreementId",new Integer(16));
		functionHash.put("FindMaxAgreementId444Update",new Integer(17));
		functionHash.put("FindMaxAgreementIdForUpdateWithRR",new Integer(18));
		functionHash.put("FindMaxAgreementIdForUpdateWithRS",new Integer(19));
		functionHash.put("FindBySearch",new Integer(20));
		functionHash.put("FindBySearch444Update",new Integer(21));
		functionHash.put("FindBySearchForUpdateWithRR",new Integer(22));
		functionHash.put("FindBySearchForUpdateWithRS",new Integer(23));
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
			outputRecord=FindByCustomerNumberandFormNumber(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindByCustomerNumberandFormNumber444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=FindByCustomerNumberandFormNumberForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=FindByCustomerNumberandFormNumberForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 12:
			outputRecord=FindBySalesOrgAndFormNumber(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=FindBySalesOrgAndFormNumber444Update(inputRecord,connection,interactionSpec);
			break;
		case 14:
			outputRecord=FindBySalesOrgAndFormNumberForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 15:
			outputRecord=FindBySalesOrgAndFormNumberForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 16:
			outputRecord=FindMaxAgreementId(inputRecord,connection,interactionSpec);
			break;
		case 17:
			outputRecord=FindMaxAgreementId444Update(inputRecord,connection,interactionSpec);
			break;
		case 18:
			outputRecord=FindMaxAgreementIdForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 19:
			outputRecord=FindMaxAgreementIdForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 20:
			outputRecord=FindBySearch(inputRecord,connection,interactionSpec);
			break;
		case 21:
			outputRecord=FindBySearch444Update(inputRecord,connection,interactionSpec);
			break;
		case 22:
			outputRecord=FindBySearchForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 23:
			outputRecord=FindBySearchForUpdateWithRS(inputRecord,connection,interactionSpec);
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
	private static String ReadReadQuery_0 = " SELECT 1 FROM BH.BASEAGREEMENT  T1 WHERE T1.AGREEMENT_ID = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column AGREEMENT_ID
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM BH.BASEAGREEMENT  T1 WHERE T1.AGREEMENT_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column AGREEMENT_ID
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
		updateTemplateList = BaseAgreementBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
						// For column AGREEMENT_NUMBER
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
						// For column FORM_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(2);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[25])
					{
						// For column LEGACY_CUSTOMER_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(3);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[24])
					{
						// For column INAC
						String tempString;


						tempString=(String)inputRecord.get(4);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[23])
					{
						// For column EXPIRATION_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(5);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column CHANGED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(6);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column CHANGED_BY
						String tempString;


						tempString=(String)inputRecord.get(7);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[18])
					{
						// For column ONE_WAY
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
						// For column IS_ELECTRONIC_SUBMITTER
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
						// For column IMAGE_REFERENCE_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(10);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column CUSTOMER_REPRESENTATIVE
						String tempString;


						tempString=(String)inputRecord.get(11);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column BRANCH_OFFICE
						String tempString;


						tempString=(String)inputRecord.get(12);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column COVERAGE_TYPE
						String tempString;


						tempString=(String)inputRecord.get(13);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[17])
					{
						// For column FILE_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(14);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[26])
					{
						// For column LEGAL_CONTACT_HDR
						String tempString;


						tempString=(String)inputRecord.get(15);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[27])
					{
						// For column ACCOUNTING_CONTACT_HDR
						String tempString;


						tempString=(String)inputRecord.get(16);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column SALES_ORG
						String tempString;


						tempString=(String)inputRecord.get(17);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column ACCEPTED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(18);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column CREATED_BY
						String tempString;


						tempString=(String)inputRecord.get(19);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column CREATED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(20);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column IS_MODIFIED_AGGREEMENT
						String tempString;


						tempString=(String)inputRecord.get(21);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column SIGN_CUSTOMER_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(22);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[19])
					{
						// For column SIGN_CUSTOMER_NAME
						String tempString;


						tempString=(String)inputRecord.get(23);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column ACTUAL_AGREEMENT_TITLE

						pstmt.setString(stmtIndex,(String)inputRecord.get(24));
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column STATUS_CODE
						String tempString;


						tempString=(String)inputRecord.get(25);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[3])
					{
						// For column AGREEMENT_IDENTIFIER1
						String tempString;


						tempString=(String)inputRecord.get(26);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[6])
					{
						// For column LEGACY_CC
						String tempString;


						tempString=(String)inputRecord.get(27);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column AGREEMENT_ID
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
						// For column AGREEMENT_NUMBER
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
						// For column FORM_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(2);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[25])
					{
						// For column LEGACY_CUSTOMER_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(3);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[24])
					{
						// For column INAC
						String tempString;


						tempString=(String)inputRecord.get(4);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[23])
					{
						// For column EXPIRATION_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(5);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[22])
					{
						// For column CHANGED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(6);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[21])
					{
						// For column CHANGED_BY
						String tempString;


						tempString=(String)inputRecord.get(7);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[18])
					{
						// For column ONE_WAY
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
						// For column IS_ELECTRONIC_SUBMITTER
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
						// For column IMAGE_REFERENCE_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(10);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[15])
					{
						// For column CUSTOMER_REPRESENTATIVE
						String tempString;


						tempString=(String)inputRecord.get(11);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[11])
					{
						// For column BRANCH_OFFICE
						String tempString;


						tempString=(String)inputRecord.get(12);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[14])
					{
						// For column COVERAGE_TYPE
						String tempString;


						tempString=(String)inputRecord.get(13);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[17])
					{
						// For column FILE_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(14);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[26])
					{
						// For column LEGAL_CONTACT_HDR
						String tempString;


						tempString=(String)inputRecord.get(15);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[27])
					{
						// For column ACCOUNTING_CONTACT_HDR
						String tempString;


						tempString=(String)inputRecord.get(16);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[20])
					{
						// For column SALES_ORG
						String tempString;


						tempString=(String)inputRecord.get(17);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[8])
					{
						// For column ACCEPTED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(18);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[7])
					{
						// For column CREATED_BY
						String tempString;


						tempString=(String)inputRecord.get(19);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[5])
					{
						// For column CREATED_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(20);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
						stmtIndex++;

					}
					if (changedFieldIndexes[12])
					{
						// For column IS_MODIFIED_AGGREEMENT
						String tempString;


						tempString=(String)inputRecord.get(21);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[4])
					{
						// For column SIGN_CUSTOMER_NUMBER
						String tempString;


						tempString=(String)inputRecord.get(22);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[19])
					{
						// For column SIGN_CUSTOMER_NAME
						String tempString;


						tempString=(String)inputRecord.get(23);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[13])
					{
						// For column ACTUAL_AGREEMENT_TITLE

						pstmt.setString(stmtIndex,(String)inputRecord.get(24));
						stmtIndex++;

					}
					if (changedFieldIndexes[10])
					{
						// For column STATUS_CODE
						String tempString;


						tempString=(String)inputRecord.get(25);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[3])
					{
						// For column AGREEMENT_IDENTIFIER1
						String tempString;


						tempString=(String)inputRecord.get(26);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					if (changedFieldIndexes[6])
					{
						// For column LEGACY_CC
						String tempString;


						tempString=(String)inputRecord.get(27);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.CHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column AGREEMENT_ID
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
