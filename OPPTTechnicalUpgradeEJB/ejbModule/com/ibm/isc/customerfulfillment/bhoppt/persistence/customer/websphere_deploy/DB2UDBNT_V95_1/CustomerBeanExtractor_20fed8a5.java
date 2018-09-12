package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.DB2UDBNT_V95_1;

/**
 * CustomerBeanExtractor_20fed8a5
 */
public class CustomerBeanExtractor_20fed8a5 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * CustomerBeanExtractor_20fed8a5
	 */
	public CustomerBeanExtractor_20fed8a5() {
		int[] pkCols={1,2};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.DB2UDBNT_V95_1.CustomerBeanCacheEntryImpl_20fed8a5 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.DB2UDBNT_V95_1.CustomerBeanCacheEntryImpl_20fed8a5) createDataCacheEntry();

		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[0]));
		entry.setDataForSOLD_TO_PARTY_ID(dataRow.getInt(dataColumns[1]));
		entry.setDataForCUSTOMER_LIST_NO(dataRow.getString(dataColumns[2]));
		entry.setDataForLEGACY_SOLD_P_NO(dataRow.getString(dataColumns[3]));
		entry.setDataForSAP_SOLD_TO_P_NO(dataRow.getString(dataColumns[4]));
		entry.setDataForBILL_TO_P_NO(dataRow.getString(dataColumns[5]));
		entry.setDataForBILL_TO_P_NAME(dataRow.getString(dataColumns[6]));
		entry.setDataForPAYER_NO(dataRow.getString(dataColumns[7]));
		entry.setDataForPAYER_NAME(dataRow.getString(dataColumns[8]));
		entry.setDataForSHIP_TO_P_NO(dataRow.getString(dataColumns[9]));
		entry.setDataForSHIP_TO_P_NAME(dataRow.getString(dataColumns[10]));
		entry.setDataForPLAN_START_DATE(dataRow.getDate(dataColumns[11]));
		entry.setDataForPLAN_END_DATE(dataRow.getDate(dataColumns[12]));
		entry.setDataForLAST_UPDATED_DATE(dataRow.getDate(dataColumns[13]));
		entry.setDataForBILL_TO_P_LNO(dataRow.getString(dataColumns[14]));
		entry.setDataForPAYER_LNO(dataRow.getString(dataColumns[15]));
		entry.setDataForSHIP_TO_P_LNO(dataRow.getString(dataColumns[16]));
		entry.setDataForSOLD_TO_P_ASNO(dataRow.getString(dataColumns[17]));
		entry.setDataForBILL_TO_P_ASNO(dataRow.getString(dataColumns[18]));
		entry.setDataForSHIP_TO_P_ASNO(dataRow.getString(dataColumns[19]));
		entry.setDataForPAYER_ASNO(dataRow.getString(dataColumns[20]));
		entry.setDataForCOUNTRY_CODE(dataRow.getString(dataColumns[21]));
		entry.setDataForSAP_SOLD_TO_P_NAME(dataRow.getString(dataColumns[22]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.CustomerKey();

		key.proposalId=dataRow.getInt(primaryKeyColumns[0]);
		key.customerId=dataRow.getInt(primaryKeyColumns[1]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Customer";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 23;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.DB2UDBNT_V95_1.CustomerBeanCacheEntryImpl_20fed8a5();
	}
}
