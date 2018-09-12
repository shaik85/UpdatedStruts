package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

/**
 * CustomerListBeanExtractor_93c2f859
 */
public class CustomerListBeanExtractor_93c2f859 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * CustomerListBeanExtractor_93c2f859
	 */
	public CustomerListBeanExtractor_93c2f859() {
		int[] pkCols={1,2};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1.CustomerListBeanCacheEntryImpl_93c2f859 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1.CustomerListBeanCacheEntryImpl_93c2f859) createDataCacheEntry();

		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[0]));
		entry.setDataForCUSTOMER_LIST_NO(dataRow.getString(dataColumns[1]));
		entry.setDataForCUSTOMER_LIST_NAME(dataRow.getString(dataColumns[2]));
		entry.setDataForLAST_UPDATE_DATE(dataRow.getDate(dataColumns[3]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey();

		key.proposalId=dataRow.getInt(primaryKeyColumns[0]);
		key.customerListNo=dataRow.getString(primaryKeyColumns[1]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "CustomerList";
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
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1.CustomerListBeanCacheEntryImpl_93c2f859();
	}
}
