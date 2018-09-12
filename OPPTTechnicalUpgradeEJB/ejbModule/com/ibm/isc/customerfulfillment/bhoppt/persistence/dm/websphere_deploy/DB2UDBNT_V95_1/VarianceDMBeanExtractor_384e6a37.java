package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DB2UDBNT_V95_1;

/**
 * VarianceDMBeanExtractor_384e6a37
 */
public class VarianceDMBeanExtractor_384e6a37 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * VarianceDMBeanExtractor_384e6a37
	 */
	public VarianceDMBeanExtractor_384e6a37() {
		int[] pkCols={1,2,3};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DB2UDBNT_V95_1.VarianceDMBeanCacheEntryImpl_384e6a37 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DB2UDBNT_V95_1.VarianceDMBeanCacheEntryImpl_384e6a37) createDataCacheEntry();

		entry.setDataForSOLD_TO_PARTY_ID(dataRow.getInt(dataColumns[0]));
		entry.setDataForDESG_MACHINE_ID(dataRow.getInt(dataColumns[1]));
		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[2]));
		entry.setDataForDESG_MACHINE_NO(dataRow.getString(dataColumns[3]));
		entry.setDataForDESG_MACHINE_DESC(dataRow.getString(dataColumns[4]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.VarianceDMKey();

		key.customerId=dataRow.getInt(primaryKeyColumns[0]);
		key.dmId=dataRow.getInt(primaryKeyColumns[1]);
		key.proposalId=dataRow.getInt(primaryKeyColumns[2]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "VarianceDM";
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
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DB2UDBNT_V95_1.VarianceDMBeanCacheEntryImpl_384e6a37();
	}
}
