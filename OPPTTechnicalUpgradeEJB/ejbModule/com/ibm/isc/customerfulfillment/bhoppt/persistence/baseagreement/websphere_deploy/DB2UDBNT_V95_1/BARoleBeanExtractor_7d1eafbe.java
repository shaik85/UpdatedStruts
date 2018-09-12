package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BARoleBeanExtractor_7d1eafbe
 */
public class BARoleBeanExtractor_7d1eafbe extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * BARoleBeanExtractor_7d1eafbe
	 */
	public BARoleBeanExtractor_7d1eafbe() {
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

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BARoleBeanCacheEntryImpl_7d1eafbe entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BARoleBeanCacheEntryImpl_7d1eafbe) createDataCacheEntry();

		entry.setDataForBA_ROLE(dataRow.getString(dataColumns[0]));
		entry.setDataForBA_ROLE_DESC(dataRow.getString(dataColumns[1]));

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
		return "BARole";
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
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BARoleBeanCacheEntryImpl_7d1eafbe();
	}
}
