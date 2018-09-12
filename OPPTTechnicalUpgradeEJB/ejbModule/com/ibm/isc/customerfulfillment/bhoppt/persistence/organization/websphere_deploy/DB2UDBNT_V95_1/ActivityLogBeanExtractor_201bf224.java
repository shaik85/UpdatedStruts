package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * ActivityLogBeanExtractor_201bf224
 */
public class ActivityLogBeanExtractor_201bf224 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * ActivityLogBeanExtractor_201bf224
	 */
	public ActivityLogBeanExtractor_201bf224() {
		int[] pkCols={1,2,4};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.ActivityLogBeanCacheEntryImpl_201bf224 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.ActivityLogBeanCacheEntryImpl_201bf224) createDataCacheEntry();

		entry.setDataForACTIVITYDATE(dataRow.getDate(dataColumns[0]));
		entry.setDataForACTIVITYTIME(dataRow.getTime(dataColumns[1]));
		entry.setDataForMESSAGE(dataRow.getString(dataColumns[2]));
		entry.setDataForUSERID(dataRow.getString(dataColumns[3]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.ActivityLogKey();

		key.activityDate=dataRow.getDate(primaryKeyColumns[0]);
		key.activityTime=dataRow.getTime(primaryKeyColumns[1]);
		key.userId=dataRow.getString(primaryKeyColumns[2]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "ActivityLog";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 4;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.ActivityLogBeanCacheEntryImpl_201bf224();
	}
}
