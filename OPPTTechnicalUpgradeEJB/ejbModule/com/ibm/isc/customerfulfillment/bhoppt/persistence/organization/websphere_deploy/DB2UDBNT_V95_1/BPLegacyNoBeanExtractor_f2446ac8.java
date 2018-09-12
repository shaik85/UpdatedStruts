package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BPLegacyNoBeanExtractor_f2446ac8
 */
public class BPLegacyNoBeanExtractor_f2446ac8 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * BPLegacyNoBeanExtractor_f2446ac8
	 */
	public BPLegacyNoBeanExtractor_f2446ac8() {
		int[] pkCols={1,2,3};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanCacheEntryImpl_f2446ac8 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanCacheEntryImpl_f2446ac8) createDataCacheEntry();

		entry.setDataForUSER_ID(dataRow.getString(dataColumns[0]));
		entry.setDataForLEGACY_NUMBER(dataRow.getString(dataColumns[1]));
		entry.setDataForADD_SEQUENCE_NUMBER(dataRow.getString(dataColumns[2]));
		entry.setDataForCUTOMER_NAME(dataRow.getString(dataColumns[3]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BPLegacyNoKey();

		key.userId=dataRow.getString(primaryKeyColumns[0]);
		key.legacyNo=dataRow.getString(primaryKeyColumns[1]);
		key.addressSeqNo=dataRow.getString(primaryKeyColumns[2]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "BPLegacyNo";
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
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.BPLegacyNoBeanCacheEntryImpl_f2446ac8();
	}
}
