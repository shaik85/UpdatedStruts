package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.DB2UDBNT_V95_1;

/**
 * HistoryCustomerBeanExtractor_44a753d1
 */
public class HistoryCustomerBeanExtractor_44a753d1 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * HistoryCustomerBeanExtractor_44a753d1
	 */
	public HistoryCustomerBeanExtractor_44a753d1() {
		int[] pkCols={1,2};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.DB2UDBNT_V95_1.HistoryCustomerBeanCacheEntryImpl_44a753d1 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.DB2UDBNT_V95_1.HistoryCustomerBeanCacheEntryImpl_44a753d1) createDataCacheEntry();

		entry.setDataForSOLD_TO_PARTY_ID(dataRow.getInt(dataColumns[0]));
		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[1]));
		entry.setDataForCUSTOMER_LIST_NO(dataRow.getString(dataColumns[2]));
		entry.setDataForLEGACY_SOLD_P_NO(dataRow.getString(dataColumns[3]));
		entry.setDataForSAP_SOLD_TO_P_NO(dataRow.getString(dataColumns[4]));
		entry.setDataForSAP_SOLD_TO_P_NAME(dataRow.getString(dataColumns[5]));
		entry.setDataForBILL_TO_P_NO(dataRow.getString(dataColumns[6]));
		entry.setDataForBILL_TO_P_NAME(dataRow.getString(dataColumns[7]));
		entry.setDataForPAYER_NO(dataRow.getString(dataColumns[8]));
		entry.setDataForPAYER_NAME(dataRow.getString(dataColumns[9]));
		entry.setDataForSHIP_TO_P_NO(dataRow.getString(dataColumns[10]));
		entry.setDataForSHIP_TO_P_NAME(dataRow.getString(dataColumns[11]));
		entry.setDataForPLAN_START_DATE(dataRow.getDate(dataColumns[12]));
		entry.setDataForPLAN_END_DATE(dataRow.getDate(dataColumns[13]));
		entry.setDataForLAST_UPDATED_DATE(dataRow.getDate(dataColumns[14]));
		entry.setDataForPAYER_LNO(dataRow.getString(dataColumns[15]));
		entry.setDataForBILL_TO_P_LNO(dataRow.getString(dataColumns[16]));
		entry.setDataForSHIP_TO_P_LNO(dataRow.getString(dataColumns[17]));
		entry.setDataForSOLD_TO_P_ASNO(dataRow.getString(dataColumns[18]));
		entry.setDataForBILL_TO_P_ASNO(dataRow.getString(dataColumns[19]));
		entry.setDataForPAYER_ASNO(dataRow.getString(dataColumns[20]));
		entry.setDataForSHIP_TO_P_ASNO(dataRow.getString(dataColumns[21]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.HistoryCustomerKey();

		key.customerId=dataRow.getInt(primaryKeyColumns[0]);
		key.proposalId=dataRow.getInt(primaryKeyColumns[1]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "HistoryCustomer";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 22;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.DB2UDBNT_V95_1.HistoryCustomerBeanCacheEntryImpl_44a753d1();
	}
}
