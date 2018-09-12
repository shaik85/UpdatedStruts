package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * DMBeanFunctionSet_53964662
 */
public class DMBeanFunctionSet_53964662 extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO BH.CUSTDESGMACHINE (DESG_MACHINE_ID, SOLD_TO_PARTY_ID, PROPOSAL_ID, DESG_MACHINE_DESC, DESG_MACHINE_NO, PLAN_START_DATE, PLAN_END_DATE, PLANNED_IND, LAST_UPDATED_DATE, DM_ADDED_DATE, EXCLUSION_ID, DM_COPY_INCR_NO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column DESG_MACHINE_ID
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
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.CHAR);
			}
			// For column DESG_MACHINE_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column PLAN_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(5);
				if(tempDate != null)
					pstmt.setDate(6,tempDate);
				else
					pstmt.setNull(6,java.sql.Types.DATE);
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
			// For column PLANNED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column LAST_UPDATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(8);
				if(tempDate != null)
					pstmt.setDate(9,tempDate);
				else
					pstmt.setNull(9,java.sql.Types.DATE);
			}
			// For column DM_ADDED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(9);
				if(tempDate != null)
					pstmt.setDate(10,tempDate);
				else
					pstmt.setNull(10,java.sql.Types.DATE);
			}
			// For column EXCLUSION_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(11,tempString);
				else
					pstmt.setNull(11,java.sql.Types.CHAR);
			}
			// For column DM_COPY_INCR_NO
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(11);
				if(tempDouble != null)
					pstmt.setDouble(12,tempDouble.doubleValue());
				else
					pstmt.setNull(12,java.sql.Types.DECIMAL);
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
	private static String RemoveQuery_0 = "DELETE FROM BH.CUSTDESGMACHINE  WHERE DESG_MACHINE_ID = ? AND SOLD_TO_PARTY_ID = ? AND PROPOSAL_ID = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column DESG_MACHINE_ID
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
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
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
	private static String StoreQuery_0 = "UPDATE BH.CUSTDESGMACHINE  SET DESG_MACHINE_DESC = ?, DESG_MACHINE_NO = ?, PLAN_START_DATE = ?, PLAN_END_DATE = ?, PLANNED_IND = ?, LAST_UPDATED_DATE = ?, DM_ADDED_DATE = ?, EXCLUSION_ID = ?, DM_COPY_INCR_NO = ? WHERE DESG_MACHINE_ID = ? AND SOLD_TO_PARTY_ID = ? AND PROPOSAL_ID = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(11,tempInteger.intValue());
				else
					pstmt.setNull(11,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(12,tempInteger.intValue());
				else
					pstmt.setNull(12,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column DESG_MACHINE_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column PLAN_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(5);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For column PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(6);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			// For column PLANNED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column LAST_UPDATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(8);
				if(tempDate != null)
					pstmt.setDate(6,tempDate);
				else
					pstmt.setNull(6,java.sql.Types.DATE);
			}
			// For column DM_ADDED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(9);
				if(tempDate != null)
					pstmt.setDate(7,tempDate);
				else
					pstmt.setNull(7,java.sql.Types.DATE);
			}
			// For column EXCLUSION_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column DM_COPY_INCR_NO
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(11);
				if(tempDouble != null)
					pstmt.setDouble(9,tempDouble.doubleValue());
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
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
	private static String StoreOCCQuery_0 = "UPDATE BH.CUSTDESGMACHINE  SET DESG_MACHINE_DESC = ?, DESG_MACHINE_NO = ?, PLAN_START_DATE = ?, PLAN_END_DATE = ?, PLANNED_IND = ?, LAST_UPDATED_DATE = ?, DM_ADDED_DATE = ?, EXCLUSION_ID = ?, DM_COPY_INCR_NO = ? WHERE DESG_MACHINE_ID = ? AND SOLD_TO_PARTY_ID = ? AND PROPOSAL_ID = ? AND DM_COPY_INCR_NO = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column DESG_MACHINE_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(10,tempInteger.intValue());
				else
					pstmt.setNull(10,java.sql.Types.INTEGER);
			}
			// For column SOLD_TO_PARTY_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(1);
				if(tempInteger != null)
					pstmt.setInt(11,tempInteger.intValue());
				else
					pstmt.setNull(11,java.sql.Types.INTEGER);
			}
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(12,tempInteger.intValue());
				else
					pstmt.setNull(12,java.sql.Types.INTEGER);
			}
			// For column DESG_MACHINE_DESC
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.CHAR);
			}
			// For column DESG_MACHINE_NO
			{
				String tempString;


				tempString=(String)inputRecord.get(4);
				if(tempString != null)
					pstmt.setString(2,tempString);
				else
					pstmt.setNull(2,java.sql.Types.CHAR);
			}
			// For column PLAN_START_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(5);
				if(tempDate != null)
					pstmt.setDate(3,tempDate);
				else
					pstmt.setNull(3,java.sql.Types.DATE);
			}
			// For column PLAN_END_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(6);
				if(tempDate != null)
					pstmt.setDate(4,tempDate);
				else
					pstmt.setNull(4,java.sql.Types.DATE);
			}
			// For column PLANNED_IND
			{
				String tempString;


				tempString=(String)inputRecord.get(7);
				if(tempString != null)
					pstmt.setString(5,tempString);
				else
					pstmt.setNull(5,java.sql.Types.CHAR);
			}
			// For column LAST_UPDATED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(8);
				if(tempDate != null)
					pstmt.setDate(6,tempDate);
				else
					pstmt.setNull(6,java.sql.Types.DATE);
			}
			// For column DM_ADDED_DATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(9);
				if(tempDate != null)
					pstmt.setDate(7,tempDate);
				else
					pstmt.setNull(7,java.sql.Types.DATE);
			}
			// For column EXCLUSION_ID
			{
				String tempString;


				tempString=(String)inputRecord.get(10);
				if(tempString != null)
					pstmt.setString(8,tempString);
				else
					pstmt.setNull(8,java.sql.Types.CHAR);
			}
			// For column DM_COPY_INCR_NO
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(11);
				if(tempDouble != null)
					pstmt.setDouble(9,tempDouble.doubleValue());
				else
					pstmt.setNull(9,java.sql.Types.DECIMAL);
			}
			IndexedRecord oldRecord = interactionSpec.getOldRecord();
			// For column DM_COPY_INCR_NO
			{
				Double tempDouble;


				tempDouble=(Double)oldRecord.get(11);
				if(tempDouble != null)
					pstmt.setDouble(13,tempDouble.doubleValue());
				else
					pstmt.setNull(13,java.sql.Types.DECIMAL);
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
	private static String findMaxDMIdQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"DESG_MACHINE_ID\" =  ( select  max( q2.\"DESG_MACHINE_ID\") from BH.CUSTDESGMACHINE q2) ) ";
	/**
	 * FindMaxDMId
	 */
	public javax.resource.cci.Record FindMaxDMId(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where  o.dmId = (select max(a.dmId) from DM a) */
			pstmt = prepareStatement(connection, findMaxDMIdQuery_0);

			result = executeQuery(connection, pstmt, findMaxDMIdQuery_0);

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
	private static String findMaxDMIdForUpdateQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"DESG_MACHINE_ID\" =  ( select  max( q2.\"DESG_MACHINE_ID\") from BH.CUSTDESGMACHINE q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxDMId444Update
	 */
	public javax.resource.cci.Record FindMaxDMId444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where  o.dmId = (select max(a.dmId) from DM a) */
			pstmt = prepareStatement(connection, findMaxDMIdForUpdateQuery_0);

			result = executeQuery(connection, pstmt, findMaxDMIdForUpdateQuery_0);

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
	private static String findMaxDMIdForUpdateWithRRQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"DESG_MACHINE_ID\" =  ( select  max( q2.\"DESG_MACHINE_ID\") from BH.CUSTDESGMACHINE q2) )  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxDMIdForUpdateWithRR
	 */
	public javax.resource.cci.Record FindMaxDMIdForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where  o.dmId = (select max(a.dmId) from DM a) */
			pstmt = prepareStatement(connection, findMaxDMIdForUpdateWithRRQuery_0);

			result = executeQuery(connection, pstmt, findMaxDMIdForUpdateWithRRQuery_0);

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
	private static String findMaxDMIdForUpdateWithRSQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"DESG_MACHINE_ID\" =  ( select  max( q2.\"DESG_MACHINE_ID\") from BH.CUSTDESGMACHINE q2) )  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindMaxDMIdForUpdateWithRS
	 */
	public javax.resource.cci.Record FindMaxDMIdForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where  o.dmId = (select max(a.dmId) from DM a) */
			pstmt = prepareStatement(connection, findMaxDMIdForUpdateWithRSQuery_0);

			result = executeQuery(connection, pstmt, findMaxDMIdForUpdateWithRSQuery_0);

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
	private static String findByProposalQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"PROPOSAL_ID\" = ?) ";
	/**
	 * FindByProposal
	 */
	public javax.resource.cci.Record FindByProposal(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where o.proposalId = ?1 */
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
	private static String findByProposalForUpdateQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposal444Update
	 */
	public javax.resource.cci.Record FindByProposal444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where o.proposalId = ?1 */
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
	private static String findByProposalForUpdateWithRRQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByProposalForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where o.proposalId = ?1 */
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
	private static String findByProposalForUpdateWithRSQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"PROPOSAL_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByProposalForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByProposalForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where o.proposalId = ?1 */
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
	private static String findByDMNoQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"DESG_MACHINE_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?) ";
	/**
	 * FindByDMNo
	 */
	public javax.resource.cci.Record FindByDMNo(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where o.dmNo=?1 and o.proposalId=?2 and o.customerId=?3 */
			pstmt = prepareStatement(connection, findByDMNoQuery_0);

			// For ?1 (dmNo)
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
			result = executeQuery(connection, pstmt, findByDMNoQuery_0);

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
	private static String findByDMNoForUpdateQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"DESG_MACHINE_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByDMNo444Update
	 */
	public javax.resource.cci.Record FindByDMNo444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where o.dmNo=?1 and o.proposalId=?2 and o.customerId=?3 */
			pstmt = prepareStatement(connection, findByDMNoForUpdateQuery_0);

			// For ?1 (dmNo)
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
			result = executeQuery(connection, pstmt, findByDMNoForUpdateQuery_0);

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
	private static String findByDMNoForUpdateWithRRQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"DESG_MACHINE_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByDMNoForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByDMNoForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where o.dmNo=?1 and o.proposalId=?2 and o.customerId=?3 */
			pstmt = prepareStatement(connection, findByDMNoForUpdateWithRRQuery_0);

			// For ?1 (dmNo)
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
			result = executeQuery(connection, pstmt, findByDMNoForUpdateWithRRQuery_0);

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
	private static String findByDMNoForUpdateWithRSQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"DESG_MACHINE_NO\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  and  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByDMNoForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByDMNoForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where o.dmNo=?1 and o.proposalId=?2 and o.customerId=?3 */
			pstmt = prepareStatement(connection, findByDMNoForUpdateWithRSQuery_0);

			// For ?1 (dmNo)
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
			result = executeQuery(connection, pstmt, findByDMNoForUpdateWithRSQuery_0);

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
	private static String findByCustomerQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  order by  q1.\"PLAN_END_DATE\" asc";
	/**
	 * FindByCustomer
	 */
	public javax.resource.cci.Record FindByCustomer(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where  o.customerId = ?1 and  o.proposalId = ?2 order by o.planEndDate */
			pstmt = prepareStatement(connection, findByCustomerQuery_0);

			// For ?1 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
	private static String findByCustomerForUpdateQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  order by  q1.\"PLAN_END_DATE\" asc FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByCustomer444Update
	 */
	public javax.resource.cci.Record FindByCustomer444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where  o.customerId = ?1 and  o.proposalId = ?2 order by o.planEndDate */
			pstmt = prepareStatement(connection, findByCustomerForUpdateQuery_0);

			// For ?1 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
	private static String findByCustomerForUpdateWithRRQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  order by  q1.\"PLAN_END_DATE\" asc FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByCustomerForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByCustomerForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where  o.customerId = ?1 and  o.proposalId = ?2 order by o.planEndDate */
			pstmt = prepareStatement(connection, findByCustomerForUpdateWithRRQuery_0);

			// For ?1 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
	private static String findByCustomerForUpdateWithRSQuery_0 = " select  q1.\"DESG_MACHINE_ID\",  q1.\"SOLD_TO_PARTY_ID\",  q1.\"PROPOSAL_ID\",  q1.\"DESG_MACHINE_DESC\",  q1.\"DESG_MACHINE_NO\",  q1.\"PLAN_START_DATE\",  q1.\"PLAN_END_DATE\",  q1.\"PLANNED_IND\",  q1.\"LAST_UPDATED_DATE\",  q1.\"DM_ADDED_DATE\",  q1.\"EXCLUSION_ID\",  q1.\"DM_COPY_INCR_NO\" from BH.CUSTDESGMACHINE q1 where  ( q1.\"SOLD_TO_PARTY_ID\" = ?)  and  ( q1.\"PROPOSAL_ID\" = ?)  order by  q1.\"PLAN_END_DATE\" asc FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByCustomerForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByCustomerForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from DM o where  o.customerId = ?1 and  o.proposalId = ?2 order by o.planEndDate */
			pstmt = prepareStatement(connection, findByCustomerForUpdateWithRSQuery_0);

			// For ?1 (customerId)
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(0);
				if(tempInteger != null)
					pstmt.setInt(1,tempInteger.intValue());
				else
					pstmt.setNull(1,java.sql.Types.INTEGER);
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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.DESG_MACHINE_ID, T1.SOLD_TO_PARTY_ID, T1.PROPOSAL_ID, T1.DESG_MACHINE_DESC, T1.DESG_MACHINE_NO, T1.PLAN_START_DATE, T1.PLAN_END_DATE, T1.PLANNED_IND, T1.LAST_UPDATED_DATE, T1.DM_ADDED_DATE, T1.EXCLUSION_ID, T1.DM_COPY_INCR_NO FROM BH.CUSTDESGMACHINE  T1 WHERE T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column DESG_MACHINE_ID
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
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.DESG_MACHINE_ID, T1.SOLD_TO_PARTY_ID, T1.PROPOSAL_ID, T1.DESG_MACHINE_DESC, T1.DESG_MACHINE_NO, T1.PLAN_START_DATE, T1.PLAN_END_DATE, T1.PLANNED_IND, T1.LAST_UPDATED_DATE, T1.DM_ADDED_DATE, T1.EXCLUSION_ID, T1.DM_COPY_INCR_NO FROM BH.CUSTDESGMACHINE  T1 WHERE T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column DESG_MACHINE_ID
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
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
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
	private static String FindByPrimaryKeyForUpdateWithRRQuery_0 = " SELECT T1.DESG_MACHINE_ID, T1.SOLD_TO_PARTY_ID, T1.PROPOSAL_ID, T1.DESG_MACHINE_DESC, T1.DESG_MACHINE_NO, T1.PLAN_START_DATE, T1.PLAN_END_DATE, T1.PLANNED_IND, T1.LAST_UPDATED_DATE, T1.DM_ADDED_DATE, T1.EXCLUSION_ID, T1.DM_COPY_INCR_NO FROM BH.CUSTDESGMACHINE  T1 WHERE T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ? FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRRQuery_0);

			// For column DESG_MACHINE_ID
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
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
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
	private static String FindByPrimaryKeyForUpdateWithRSQuery_0 = " SELECT T1.DESG_MACHINE_ID, T1.SOLD_TO_PARTY_ID, T1.PROPOSAL_ID, T1.DESG_MACHINE_DESC, T1.DESG_MACHINE_NO, T1.PLAN_START_DATE, T1.PLAN_END_DATE, T1.PLANNED_IND, T1.LAST_UPDATED_DATE, T1.DM_ADDED_DATE, T1.EXCLUSION_ID, T1.DM_COPY_INCR_NO FROM BH.CUSTDESGMACHINE  T1 WHERE T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRSQuery_0);

			// For column DESG_MACHINE_ID
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
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
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
	/**
	 * DMBeanFunctionSet_53964662
	 */
	public DMBeanFunctionSet_53964662() {
		functionHash=new java.util.HashMap(28);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindMaxDMId",new Integer(4));
		functionHash.put("FindMaxDMId444Update",new Integer(5));
		functionHash.put("FindMaxDMIdForUpdateWithRR",new Integer(6));
		functionHash.put("FindMaxDMIdForUpdateWithRS",new Integer(7));
		functionHash.put("FindByProposal",new Integer(8));
		functionHash.put("FindByProposal444Update",new Integer(9));
		functionHash.put("FindByProposalForUpdateWithRR",new Integer(10));
		functionHash.put("FindByProposalForUpdateWithRS",new Integer(11));
		functionHash.put("FindByDMNo",new Integer(12));
		functionHash.put("FindByDMNo444Update",new Integer(13));
		functionHash.put("FindByDMNoForUpdateWithRR",new Integer(14));
		functionHash.put("FindByDMNoForUpdateWithRS",new Integer(15));
		functionHash.put("FindByCustomer",new Integer(16));
		functionHash.put("FindByCustomer444Update",new Integer(17));
		functionHash.put("FindByCustomerForUpdateWithRR",new Integer(18));
		functionHash.put("FindByCustomerForUpdateWithRS",new Integer(19));
		functionHash.put("FindByPrimaryKey",new Integer(20));
		functionHash.put("FindByPrimaryKey444Update",new Integer(21));
		functionHash.put("FindByPrimaryKeyForUpdateWithRR",new Integer(22));
		functionHash.put("FindByPrimaryKeyForUpdateWithRS",new Integer(23));
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
			outputRecord=FindMaxDMId(inputRecord,connection,interactionSpec);
			break;
		case 5:
			outputRecord=FindMaxDMId444Update(inputRecord,connection,interactionSpec);
			break;
		case 6:
			outputRecord=FindMaxDMIdForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 7:
			outputRecord=FindMaxDMIdForUpdateWithRS(inputRecord,connection,interactionSpec);
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
			outputRecord=FindByDMNo(inputRecord,connection,interactionSpec);
			break;
		case 13:
			outputRecord=FindByDMNo444Update(inputRecord,connection,interactionSpec);
			break;
		case 14:
			outputRecord=FindByDMNoForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 15:
			outputRecord=FindByDMNoForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 16:
			outputRecord=FindByCustomer(inputRecord,connection,interactionSpec);
			break;
		case 17:
			outputRecord=FindByCustomer444Update(inputRecord,connection,interactionSpec);
			break;
		case 18:
			outputRecord=FindByCustomerForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 19:
			outputRecord=FindByCustomerForUpdateWithRS(inputRecord,connection,interactionSpec);
			break;
		case 20:
			outputRecord=FindByPrimaryKey(inputRecord,connection,interactionSpec);
			break;
		case 21:
			outputRecord=FindByPrimaryKey444Update(inputRecord,connection,interactionSpec);
			break;
		case 22:
			outputRecord=FindByPrimaryKeyForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 23:
			outputRecord=FindByPrimaryKeyForUpdateWithRS(inputRecord,connection,interactionSpec);
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
	private static String ReadReadQuery_0 = " SELECT 1 FROM BH.CUSTDESGMACHINE  T1 WHERE T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ? AND T1.DM_COPY_INCR_NO = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column DESG_MACHINE_ID
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
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column DM_COPY_INCR_NO
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(3);
				if(tempDouble != null)
					pstmt.setDouble(4,tempDouble.doubleValue());
				else
					pstmt.setNull(4,java.sql.Types.DECIMAL);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM BH.CUSTDESGMACHINE  T1 WHERE T1.DESG_MACHINE_ID = ? AND T1.SOLD_TO_PARTY_ID = ? AND T1.PROPOSAL_ID = ? AND T1.DM_COPY_INCR_NO = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column DESG_MACHINE_ID
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
			// For column PROPOSAL_ID
			{
				Integer tempInteger;


				tempInteger=(Integer)inputRecord.get(2);
				if(tempInteger != null)
					pstmt.setInt(3,tempInteger.intValue());
				else
					pstmt.setNull(3,java.sql.Types.INTEGER);
			}
			// For column DM_COPY_INCR_NO
			{
				Double tempDouble;


				tempDouble=(Double)inputRecord.get(3);
				if(tempDouble != null)
					pstmt.setDouble(4,tempDouble.doubleValue());
				else
					pstmt.setNull(4,java.sql.Types.DECIMAL);
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
		updateTemplateList = DMBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
					if (changedFieldIndexes[3])
					{
						// For column DESG_MACHINE_DESC
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
						// For column DESG_MACHINE_NO
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
						// For column PLAN_START_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(5);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
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
						// For column PLANNED_IND
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
						// For column LAST_UPDATED_DATE
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
						// For column DM_ADDED_DATE
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
						// For column EXCLUSION_ID
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
						// For column DM_COPY_INCR_NO
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(11);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column DESG_MACHINE_ID
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
					{
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(2);
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
				oldValues[0] = oldRecord.get(11);
				String updateQuery = aTemplate.nativeOptimisticQuery(changedFieldIndexes,oldValues);
				if (updateQuery != null){
					pstmt = prepareStatement(connection, updateQuery);

					int stmtIndex = 1;
					if (changedFieldIndexes[3])
					{
						// For column DESG_MACHINE_DESC
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
						// For column DESG_MACHINE_NO
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
						// For column PLAN_START_DATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(5);
						if(tempDate != null){
							pstmt.setDate(stmtIndex,tempDate);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DATE);
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
						// For column PLANNED_IND
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
						// For column LAST_UPDATED_DATE
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
						// For column DM_ADDED_DATE
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
						// For column EXCLUSION_ID
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
						// For column DM_COPY_INCR_NO
						Double tempDouble;


						tempDouble=(Double)inputRecord.get(11);
						if(tempDouble != null){
							pstmt.setDouble(stmtIndex,tempDouble.doubleValue());
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.DECIMAL);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column DESG_MACHINE_ID
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
					{
						// For column PROPOSAL_ID
						Integer tempInteger;


						tempInteger=(Integer)inputRecord.get(2);
						pstmt.setInt(stmtIndex,tempInteger.intValue());
							stmtIndex++;

					}
					// optimistic predicate columns
					{
						// For column DM_COPY_INCR_NO
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
