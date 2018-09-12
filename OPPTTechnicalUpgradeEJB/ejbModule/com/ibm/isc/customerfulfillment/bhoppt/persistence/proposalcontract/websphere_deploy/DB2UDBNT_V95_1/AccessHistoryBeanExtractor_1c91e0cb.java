package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

/**
 * AccessHistoryBeanExtractor_1c91e0cb
 */
public class AccessHistoryBeanExtractor_1c91e0cb extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * AccessHistoryBeanExtractor_1c91e0cb
	 */
	public AccessHistoryBeanExtractor_1c91e0cb() {
		int[] pkCols={1,3,4,5,6};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1.AccessHistoryBeanCacheEntryImpl_1c91e0cb entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1.AccessHistoryBeanCacheEntryImpl_1c91e0cb) createDataCacheEntry();

		entry.setDataForUSER_ID(dataRow.getString(dataColumns[0]));
		entry.setDataForOPERATION_PERFORMED(dataRow.getString(dataColumns[1]));
		entry.setDataForACCESS_DATE(dataRow.getDate(dataColumns[2]));
		entry.setDataForACCESS_TIME(dataRow.getTime(dataColumns[3]));
		entry.setDataForSEQ_NO(dataRow.getInt(dataColumns[4]));
		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[5]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.AccessHistoryKey();

		key.userId=dataRow.getString(primaryKeyColumns[0]);
		key.accessDate=dataRow.getDate(primaryKeyColumns[1]);
		key.accessTime=dataRow.getTime(primaryKeyColumns[2]);
		key.seqNo=dataRow.getInt(primaryKeyColumns[3]);
		key.proposalId=dataRow.getInt(primaryKeyColumns[4]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "AccessHistory";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 6;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1.AccessHistoryBeanCacheEntryImpl_1c91e0cb();
	}
}
