package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * SalesAreaBeanExtractor_ac159cf0
 */
public class SalesAreaBeanExtractor_ac159cf0 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * SalesAreaBeanExtractor_ac159cf0
	 */
	public SalesAreaBeanExtractor_ac159cf0() {
		int[] pkCols={1,2,3};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.SalesAreaBeanCacheEntryImpl_ac159cf0 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.SalesAreaBeanCacheEntryImpl_ac159cf0) createDataCacheEntry();

		entry.setDataForSALES_ORG(dataRow.getString(dataColumns[0]));
		entry.setDataForDIVISION_CODE(dataRow.getString(dataColumns[1]));
		entry.setDataForDSTR_CHANNEL(dataRow.getString(dataColumns[2]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesAreaKey();

		key.salesOrg=dataRow.getString(primaryKeyColumns[0]);
		key.divisionCode=dataRow.getString(primaryKeyColumns[1]);
		key.distributionChannelCode=dataRow.getString(primaryKeyColumns[2]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "SalesArea";
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
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.SalesAreaBeanCacheEntryImpl_ac159cf0();
	}
}
