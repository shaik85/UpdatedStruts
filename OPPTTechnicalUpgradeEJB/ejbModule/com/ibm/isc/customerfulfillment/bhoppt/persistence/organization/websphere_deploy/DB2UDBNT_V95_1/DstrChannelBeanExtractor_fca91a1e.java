package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * DstrChannelBeanExtractor_fca91a1e
 */
public class DstrChannelBeanExtractor_fca91a1e extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * DstrChannelBeanExtractor_fca91a1e
	 */
	public DstrChannelBeanExtractor_fca91a1e() {
		int[] pkCols={1,3,4,5};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.DstrChannelBeanCacheEntryImpl_fca91a1e entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.DstrChannelBeanCacheEntryImpl_fca91a1e) createDataCacheEntry();

		entry.setDataForDSTR_CHANNEL(dataRow.getString(dataColumns[0]));
		entry.setDataForDSTR_CHANNEL_DESC(dataRow.getString(dataColumns[1]));
		entry.setDataForSALES_GROUP(dataRow.getString(dataColumns[2]));
		entry.setDataForCHANNEL_ROLE(dataRow.getString(dataColumns[3]));
		entry.setDataForSUBMITTER_ROLE(dataRow.getString(dataColumns[4]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelKey();

		key.distributionChannel=dataRow.getString(primaryKeyColumns[0]);
		key.salesGroup=dataRow.getString(primaryKeyColumns[1]);
		key.channelRole=dataRow.getString(primaryKeyColumns[2]);
		key.submitterRole=dataRow.getString(primaryKeyColumns[3]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "DstrChannel";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 5;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.DstrChannelBeanCacheEntryImpl_fca91a1e();
	}
}
