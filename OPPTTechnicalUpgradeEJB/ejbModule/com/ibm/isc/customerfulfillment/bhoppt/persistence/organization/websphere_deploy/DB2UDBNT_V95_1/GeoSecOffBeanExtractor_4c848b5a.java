package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * GeoSecOffBeanExtractor_4c848b5a
 */
public class GeoSecOffBeanExtractor_4c848b5a extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * GeoSecOffBeanExtractor_4c848b5a
	 */
	public GeoSecOffBeanExtractor_4c848b5a() {
		int[] pkCols={1};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.GeoSecOffBeanCacheEntryImpl_4c848b5a entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.GeoSecOffBeanCacheEntryImpl_4c848b5a) createDataCacheEntry();

		entry.setDataForSALES_ORG(dataRow.getString(dataColumns[0]));
		entry.setDataForGEO_SECOFF_SO(dataRow.getString(dataColumns[1]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		java.lang.String key;
		key=dataRow.getString(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "GeoSecOff";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 2;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.GeoSecOffBeanCacheEntryImpl_4c848b5a();
	}
}
