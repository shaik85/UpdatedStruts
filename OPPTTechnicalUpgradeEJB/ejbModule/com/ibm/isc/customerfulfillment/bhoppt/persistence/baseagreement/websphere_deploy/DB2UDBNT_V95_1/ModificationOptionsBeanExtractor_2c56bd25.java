package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * ModificationOptionsBeanExtractor_2c56bd25
 */
public class ModificationOptionsBeanExtractor_2c56bd25 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * ModificationOptionsBeanExtractor_2c56bd25
	 */
	public ModificationOptionsBeanExtractor_2c56bd25() {
		int[] pkCols={1,2};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanCacheEntryImpl_2c56bd25 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanCacheEntryImpl_2c56bd25) createDataCacheEntry();

		entry.setDataForMODIFICATION_TYPE_CODE(dataRow.getString(dataColumns[0]));
		entry.setDataForMODIFICATION_OPTION(dataRow.getString(dataColumns[1]));
		entry.setDataForMODIFICATION_OPTION_DESC(dataRow.getString(dataColumns[2]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey();

		key.modificationTypeCode=dataRow.getString(primaryKeyColumns[0]);
		key.modificationOption=dataRow.getString(primaryKeyColumns[1]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "ModificationOptions";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 3;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.ModificationOptionsBeanCacheEntryImpl_2c56bd25();
	}
}
