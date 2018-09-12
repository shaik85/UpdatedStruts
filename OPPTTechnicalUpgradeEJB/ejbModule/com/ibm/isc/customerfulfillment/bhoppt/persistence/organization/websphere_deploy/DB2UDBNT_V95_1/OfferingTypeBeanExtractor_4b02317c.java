package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * OfferingTypeBeanExtractor_4b02317c
 */
public class OfferingTypeBeanExtractor_4b02317c extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * OfferingTypeBeanExtractor_4b02317c
	 */
	public OfferingTypeBeanExtractor_4b02317c() {
		int[] pkCols={1,2};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.OfferingTypeBeanCacheEntryImpl_4b02317c entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.OfferingTypeBeanCacheEntryImpl_4b02317c) createDataCacheEntry();

		entry.setDataForOFFERING_TYPE(dataRow.getString(dataColumns[0]));
		entry.setDataForOFFERING_DESC(dataRow.getString(dataColumns[1]));
		entry.setDataForTVM_ALLOWED(dataRow.getString(dataColumns[2]));
		entry.setDataForSPECIAL_RATE_IND(dataRow.getString(dataColumns[3]));
		entry.setDataForANNV_CNTR_AMT_IND(dataRow.getString(dataColumns[4]));
		entry.setDataForDURATION(dataRow.getInt(dataColumns[5]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey();

		key.offeringType=dataRow.getString(primaryKeyColumns[0]);
		key.offeringDesc=dataRow.getString(primaryKeyColumns[1]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "OfferingType";
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
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.OfferingTypeBeanCacheEntryImpl_4b02317c();
	}
}
