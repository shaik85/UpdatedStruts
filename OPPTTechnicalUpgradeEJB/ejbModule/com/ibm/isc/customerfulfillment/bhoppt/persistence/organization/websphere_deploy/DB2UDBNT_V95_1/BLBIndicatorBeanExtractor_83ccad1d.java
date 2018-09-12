package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BLBIndicatorBeanExtractor_83ccad1d
 */
public class BLBIndicatorBeanExtractor_83ccad1d extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * BLBIndicatorBeanExtractor_83ccad1d
	 */
	public BLBIndicatorBeanExtractor_83ccad1d() {
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

		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BLBIndicatorBeanCacheEntryImpl_83ccad1d entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BLBIndicatorBeanCacheEntryImpl_83ccad1d) createDataCacheEntry();

		entry.setDataForBLB_TYPE(dataRow.getString(dataColumns[0]));
		entry.setDataForBLB_DESC(dataRow.getString(dataColumns[1]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorKey();

		key.blbType=dataRow.getString(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "BLBIndicator";
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
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BLBIndicatorBeanCacheEntryImpl_83ccad1d();
	}
}
