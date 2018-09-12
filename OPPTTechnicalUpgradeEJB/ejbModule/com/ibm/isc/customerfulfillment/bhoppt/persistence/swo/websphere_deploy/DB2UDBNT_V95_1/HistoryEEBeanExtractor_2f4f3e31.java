package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * HistoryEEBeanExtractor_2f4f3e31
 */
public class HistoryEEBeanExtractor_2f4f3e31 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * HistoryEEBeanExtractor_2f4f3e31
	 */
	public HistoryEEBeanExtractor_2f4f3e31() {
		int[] pkCols={1,2,3,4,5};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.HistoryEEBeanCacheEntryImpl_2f4f3e31 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.HistoryEEBeanCacheEntryImpl_2f4f3e31) createDataCacheEntry();

		entry.setDataForSWOEE_ID(dataRow.getInt(dataColumns[0]));
		entry.setDataForSWO_ID(dataRow.getInt(dataColumns[1]));
		entry.setDataForDESG_MACHINE_ID(dataRow.getInt(dataColumns[2]));
		entry.setDataForSOLD_TO_PARTY_ID(dataRow.getInt(dataColumns[3]));
		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[4]));
		entry.setDataForSALES_DOC_NO(dataRow.getString(dataColumns[5]));
		entry.setDataForEE_ITEM_NO(dataRow.getString(dataColumns[6]));
		entry.setDataForSWO_ITEM_NO(dataRow.getString(dataColumns[7]));
		entry.setDataForEE_NO(dataRow.getString(dataColumns[8]));
		entry.setDataForEE_DESC(dataRow.getString(dataColumns[9]));
		entry.setDataForPLAN_START_DATE(dataRow.getDate(dataColumns[10]));
		entry.setDataForPLAN_END_DATE(dataRow.getDate(dataColumns[11]));
		entry.setDataForREQST_DELIVRY_DATE(dataRow.getDate(dataColumns[12]));
		entry.setDataForVALUE_METRIC(dataRow.getString(dataColumns[13]));
		entry.setDataForUSE_LEVEL(dataRow.getString(dataColumns[14]));
		entry.setDataForLISC_TYPE(dataRow.getString(dataColumns[15]));
		entry.setDataForESW_PRICE(dataRow.getDouble(dataColumns[16]));
		entry.setDataForCALC_PRICE(dataRow.getDouble(dataColumns[17]));
		entry.setDataForALT_PRICE(dataRow.getDouble(dataColumns[18]));
		entry.setDataForBILLING_START_DATE(dataRow.getDate(dataColumns[19]));
		entry.setDataForBILLING_END_DATE(dataRow.getDate(dataColumns[20]));
		entry.setDataForEXCLUSION_ID(dataRow.getString(dataColumns[21]));
		entry.setDataForSEQUENCE_NO(dataRow.getInt(dataColumns[22]));
		entry.setDataForBUMP_ID(dataRow.getString(dataColumns[23]));
		entry.setDataForCHARGE_OPTION_DESC(dataRow.getString(dataColumns[24]));
		entry.setDataForALT_PRICE_ID(dataRow.getString(dataColumns[25]));
		entry.setDataForPRICE_EFFC_DATE(dataRow.getDate(dataColumns[26]));
		entry.setDataForS_S_DISCOUNT_PERCENT(dataRow.getDouble(dataColumns[27]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistoryEEKey();

		key.eeId=dataRow.getInt(primaryKeyColumns[0]);
		key.swoId=dataRow.getInt(primaryKeyColumns[1]);
		key.dmId=dataRow.getInt(primaryKeyColumns[2]);
		key.customerId=dataRow.getInt(primaryKeyColumns[3]);
		key.proposalId=dataRow.getInt(primaryKeyColumns[4]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "HistoryEE";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 28;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.HistoryEEBeanCacheEntryImpl_2f4f3e31();
	}
}
