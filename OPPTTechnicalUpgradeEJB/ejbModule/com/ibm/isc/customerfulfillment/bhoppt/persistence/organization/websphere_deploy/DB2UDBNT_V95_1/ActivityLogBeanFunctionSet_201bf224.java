package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.websphere.rsadapter.WSInteractionSpec;
import javax.resource.ResourceException;
import javax.resource.cci.Record;
import javax.resource.cci.IndexedRecord;
import java.sql.*;

/**
 * ActivityLogBeanFunctionSet_201bf224
 */
public class ActivityLogBeanFunctionSet_201bf224 extends com.ibm.ws.rsadapter.cci.WSResourceAdapterBase implements com.ibm.websphere.rsadapter.DataAccessFunctionSet {
	private java.util.HashMap functionHash;
	private static String CreateQuery_0 = "INSERT INTO BH.ACTIVITYLOG (ACTIVITYDATE, ACTIVITYTIME, USERID, MESSAGE) VALUES (?, ?, ?, ?)";
	/**
	 * Create
	 */
	public void Create(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, CreateQuery_0);

			// For column ACTIVITYDATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(0);
				if(tempDate != null)
					pstmt.setDate(1,tempDate);
				else
					pstmt.setNull(1,java.sql.Types.DATE);
			}
			// For column ACTIVITYTIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(1);
				if(tempTime != null)
					pstmt.setTime(2,tempTime);
				else
					pstmt.setNull(2,java.sql.Types.TIME);
			}
			// For column MESSAGE
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
			}
			// For column USERID
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
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
	private static String RemoveQuery_0 = "DELETE FROM BH.ACTIVITYLOG  WHERE ACTIVITYDATE = ? AND ACTIVITYTIME = ? AND USERID = ?";
	/**
	 * Remove
	 */
	public void Remove(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, RemoveQuery_0);

			// For column ACTIVITYDATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(0);
				if(tempDate != null)
					pstmt.setDate(1,tempDate);
				else
					pstmt.setNull(1,java.sql.Types.DATE);
			}
			// For column ACTIVITYTIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(1);
				if(tempTime != null)
					pstmt.setTime(2,tempTime);
				else
					pstmt.setNull(2,java.sql.Types.TIME);
			}
			// For column USERID
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
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
	private static String StoreQuery_0 = "UPDATE BH.ACTIVITYLOG  SET MESSAGE = ? WHERE ACTIVITYDATE = ? AND ACTIVITYTIME = ? AND USERID = ?";
	/**
	 * Store
	 */
	public void Store(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreQuery_0);

			// For column ACTIVITYDATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(0);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For column ACTIVITYTIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(1);
				if(tempTime != null)
					pstmt.setTime(3,tempTime);
				else
					pstmt.setNull(3,java.sql.Types.TIME);
			}
			// For column MESSAGE
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column USERID
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
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
	private static String StoreOCCQuery_0 = "UPDATE BH.ACTIVITYLOG  SET MESSAGE = ? WHERE ACTIVITYDATE = ? AND ACTIVITYTIME = ? AND USERID = ?";
	/**
	 * StoreUsingOCC
	 */
	public void StoreUsingOCC(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, StoreOCCQuery_0);

			// For column ACTIVITYDATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(0);
				if(tempDate != null)
					pstmt.setDate(2,tempDate);
				else
					pstmt.setNull(2,java.sql.Types.DATE);
			}
			// For column ACTIVITYTIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(1);
				if(tempTime != null)
					pstmt.setTime(3,tempTime);
				else
					pstmt.setNull(3,java.sql.Types.TIME);
			}
			// For column MESSAGE
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(1,tempString);
				else
					pstmt.setNull(1,java.sql.Types.VARCHAR);
			}
			// For column USERID
			{
				String tempString;


				tempString=(String)inputRecord.get(3);
				if(tempString != null)
					pstmt.setString(4,tempString);
				else
					pstmt.setNull(4,java.sql.Types.VARCHAR);
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
	private static String FindByPrimaryKeyQuery_0 = " SELECT T1.ACTIVITYDATE, T1.ACTIVITYTIME, T1.MESSAGE, T1.USERID FROM BH.ACTIVITYLOG  T1 WHERE T1.ACTIVITYDATE = ? AND T1.ACTIVITYTIME = ? AND T1.USERID = ?";
	/**
	 * FindByPrimaryKey
	 */
	public javax.resource.cci.Record FindByPrimaryKey(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyQuery_0);

			// For column ACTIVITYTIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(0);
				if(tempTime != null)
					pstmt.setTime(2,tempTime);
				else
					pstmt.setNull(2,java.sql.Types.TIME);
			}
			// For column ACTIVITYDATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(1);
				if(tempDate != null)
					pstmt.setDate(1,tempDate);
				else
					pstmt.setNull(1,java.sql.Types.DATE);
			}
			// For column USERID
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
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
	private static String FindByPrimaryKeyForUpdateQuery_0 = " SELECT T1.ACTIVITYDATE, T1.ACTIVITYTIME, T1.MESSAGE, T1.USERID FROM BH.ACTIVITYLOG  T1 WHERE T1.ACTIVITYDATE = ? AND T1.ACTIVITYTIME = ? AND T1.USERID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKey444Update
	 */
	public javax.resource.cci.Record FindByPrimaryKey444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateQuery_0);

			// For column ACTIVITYTIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(0);
				if(tempTime != null)
					pstmt.setTime(2,tempTime);
				else
					pstmt.setNull(2,java.sql.Types.TIME);
			}
			// For column ACTIVITYDATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(1);
				if(tempDate != null)
					pstmt.setDate(1,tempDate);
				else
					pstmt.setNull(1,java.sql.Types.DATE);
			}
			// For column USERID
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
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
	private static String FindByPrimaryKeyForUpdateWithRRQuery_0 = " SELECT T1.ACTIVITYDATE, T1.ACTIVITYTIME, T1.MESSAGE, T1.USERID FROM BH.ACTIVITYLOG  T1 WHERE T1.ACTIVITYDATE = ? AND T1.ACTIVITYTIME = ? AND T1.USERID = ? FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRR
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRRQuery_0);

			// For column ACTIVITYTIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(0);
				if(tempTime != null)
					pstmt.setTime(2,tempTime);
				else
					pstmt.setNull(2,java.sql.Types.TIME);
			}
			// For column ACTIVITYDATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(1);
				if(tempDate != null)
					pstmt.setDate(1,tempDate);
				else
					pstmt.setNull(1,java.sql.Types.DATE);
			}
			// For column USERID
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
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
	private static String FindByPrimaryKeyForUpdateWithRSQuery_0 = " SELECT T1.ACTIVITYDATE, T1.ACTIVITYTIME, T1.MESSAGE, T1.USERID FROM BH.ACTIVITYLOG  T1 WHERE T1.ACTIVITYDATE = ? AND T1.ACTIVITYTIME = ? AND T1.USERID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindByPrimaryKeyForUpdateWithRS
	 */
	public javax.resource.cci.Record FindByPrimaryKeyForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			pstmt = prepareStatement(connection, FindByPrimaryKeyForUpdateWithRSQuery_0);

			// For column ACTIVITYTIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(0);
				if(tempTime != null)
					pstmt.setTime(2,tempTime);
				else
					pstmt.setNull(2,java.sql.Types.TIME);
			}
			// For column ACTIVITYDATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(1);
				if(tempDate != null)
					pstmt.setDate(1,tempDate);
				else
					pstmt.setNull(1,java.sql.Types.DATE);
			}
			// For column USERID
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
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
	private static String findAllActivitiesQuery_0 = " select  q1.\"ACTIVITYDATE\",  q1.\"ACTIVITYTIME\",  q1.\"MESSAGE\",  q1.\"USERID\" from BH.ACTIVITYLOG q1";
	/**
	 * FindAllActivities
	 */
	public javax.resource.cci.Record FindAllActivities(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from ActivityLog o */
			pstmt = prepareStatement(connection, findAllActivitiesQuery_0);

			result = executeQuery(connection, pstmt, findAllActivitiesQuery_0);

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
	private static String findAllActivitiesForUpdateQuery_0 = " select  q1.\"ACTIVITYDATE\",  q1.\"ACTIVITYTIME\",  q1.\"MESSAGE\",  q1.\"USERID\" from BH.ACTIVITYLOG q1 FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindAllActivities444Update
	 */
	public javax.resource.cci.Record FindAllActivities444Update(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from ActivityLog o */
			pstmt = prepareStatement(connection, findAllActivitiesForUpdateQuery_0);

			result = executeQuery(connection, pstmt, findAllActivitiesForUpdateQuery_0);

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
	private static String findAllActivitiesForUpdateWithRRQuery_0 = " select  q1.\"ACTIVITYDATE\",  q1.\"ACTIVITYTIME\",  q1.\"MESSAGE\",  q1.\"USERID\" from BH.ACTIVITYLOG q1 FOR READ ONLY WITH RR USE AND KEEP UPDATE LOCKS";
	/**
	 * FindAllActivitiesForUpdateWithRR
	 */
	public javax.resource.cci.Record FindAllActivitiesForUpdateWithRR(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from ActivityLog o */
			pstmt = prepareStatement(connection, findAllActivitiesForUpdateWithRRQuery_0);

			result = executeQuery(connection, pstmt, findAllActivitiesForUpdateWithRRQuery_0);

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
	private static String findAllActivitiesForUpdateWithRSQuery_0 = " select  q1.\"ACTIVITYDATE\",  q1.\"ACTIVITYTIME\",  q1.\"MESSAGE\",  q1.\"USERID\" from BH.ACTIVITYLOG q1 FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * FindAllActivitiesForUpdateWithRS
	 */
	public javax.resource.cci.Record FindAllActivitiesForUpdateWithRS(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		ResultSet result=null;
		try {
			/* select object(o) from ActivityLog o */
			pstmt = prepareStatement(connection, findAllActivitiesForUpdateWithRSQuery_0);

			result = executeQuery(connection, pstmt, findAllActivitiesForUpdateWithRSQuery_0);

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
	 * ActivityLogBeanFunctionSet_201bf224
	 */
	public ActivityLogBeanFunctionSet_201bf224() {
		functionHash=new java.util.HashMap(16);

		functionHash.put("Create",new Integer(0));
		functionHash.put("Remove",new Integer(1));
		functionHash.put("Store",new Integer(2));
		functionHash.put("StoreUsingOCC",new Integer(3));
		functionHash.put("FindByPrimaryKey",new Integer(4));
		functionHash.put("FindByPrimaryKey444Update",new Integer(5));
		functionHash.put("FindByPrimaryKeyForUpdateWithRR",new Integer(6));
		functionHash.put("FindByPrimaryKeyForUpdateWithRS",new Integer(7));
		functionHash.put("FindAllActivities",new Integer(8));
		functionHash.put("FindAllActivities444Update",new Integer(9));
		functionHash.put("FindAllActivitiesForUpdateWithRR",new Integer(10));
		functionHash.put("FindAllActivitiesForUpdateWithRS",new Integer(11));
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
			outputRecord=FindAllActivities(inputRecord,connection,interactionSpec);
			break;
		case 9:
			outputRecord=FindAllActivities444Update(inputRecord,connection,interactionSpec);
			break;
		case 10:
			outputRecord=FindAllActivitiesForUpdateWithRR(inputRecord,connection,interactionSpec);
			break;
		case 11:
			outputRecord=FindAllActivitiesForUpdateWithRS(inputRecord,connection,interactionSpec);
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
	private static String ReadReadQuery_0 = " SELECT 1 FROM BH.ACTIVITYLOG  T1 WHERE T1.ACTIVITYDATE = ? AND T1.ACTIVITYTIME = ? AND T1.USERID = ?";
	/**
	 * ReadReadChecking
	 */
	public void ReadReadChecking(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadQuery_0);

			// For column ACTIVITYTIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(0);
				if(tempTime != null)
					pstmt.setTime(2,tempTime);
				else
					pstmt.setNull(2,java.sql.Types.TIME);
			}
			// For column ACTIVITYDATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(1);
				if(tempDate != null)
					pstmt.setDate(1,tempDate);
				else
					pstmt.setNull(1,java.sql.Types.DATE);
			}
			// For column USERID
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
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
	private static String ReadReadForUpdateQuery_0 = " SELECT 1 FROM BH.ACTIVITYLOG  T1 WHERE T1.ACTIVITYDATE = ? AND T1.ACTIVITYTIME = ? AND T1.USERID = ? FOR READ ONLY WITH RS USE AND KEEP UPDATE LOCKS";
	/**
	 * ReadReadCheckingForUpdate
	 */
	public void ReadReadCheckingForUpdate(IndexedRecord inputRecord, Object connection, WSInteractionSpec interactionSpec) throws ResourceException {
		PreparedStatement pstmt = null;
		try {
			pstmt = prepareStatement(connection, ReadReadForUpdateQuery_0);

			// For column ACTIVITYTIME
			{
				java.sql.Time tempTime;


				tempTime=(java.sql.Time)inputRecord.get(0);
				if(tempTime != null)
					pstmt.setTime(2,tempTime);
				else
					pstmt.setNull(2,java.sql.Types.TIME);
			}
			// For column ACTIVITYDATE
			{
				java.sql.Date tempDate;


				tempDate=(java.sql.Date)inputRecord.get(1);
				if(tempDate != null)
					pstmt.setDate(1,tempDate);
				else
					pstmt.setNull(1,java.sql.Types.DATE);
			}
			// For column USERID
			{
				String tempString;


				tempString=(String)inputRecord.get(2);
				if(tempString != null)
					pstmt.setString(3,tempString);
				else
					pstmt.setNull(3,java.sql.Types.VARCHAR);
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
		updateTemplateList = ActivityLogBeanPartialUpdateQueryHelper.getUpdateTemplates();
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
						// For column MESSAGE
						String tempString;


						tempString=(String)inputRecord.get(2);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column ACTIVITYDATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(0);
						pstmt.setDate(stmtIndex,tempDate);
							stmtIndex++;

					}
					{
						// For column ACTIVITYTIME
						java.sql.Time tempTime;


						tempTime=(java.sql.Time)inputRecord.get(1);
						pstmt.setTime(stmtIndex,tempTime);
							stmtIndex++;

					}
					{
						// For column USERID
						String tempString;


						tempString=(String)inputRecord.get(3);
						pstmt.setString(stmtIndex,tempString);
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
						// For column MESSAGE
						String tempString;


						tempString=(String)inputRecord.get(2);
						if(tempString != null){
							pstmt.setString(stmtIndex,tempString);
						}
						else
							pstmt.setNull(stmtIndex,java.sql.Types.VARCHAR);
						stmtIndex++;

					}
					//Now set the primary key columns
					{
						// For column ACTIVITYDATE
						java.sql.Date tempDate;


						tempDate=(java.sql.Date)inputRecord.get(0);
						pstmt.setDate(stmtIndex,tempDate);
							stmtIndex++;

					}
					{
						// For column ACTIVITYTIME
						java.sql.Time tempTime;


						tempTime=(java.sql.Time)inputRecord.get(1);
						pstmt.setTime(stmtIndex,tempTime);
							stmtIndex++;

					}
					{
						// For column USERID
						String tempString;


						tempString=(String)inputRecord.get(3);
						pstmt.setString(stmtIndex,tempString);
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
