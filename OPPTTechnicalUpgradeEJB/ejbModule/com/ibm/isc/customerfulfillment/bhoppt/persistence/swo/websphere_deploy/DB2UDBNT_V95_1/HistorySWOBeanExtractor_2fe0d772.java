package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * HistorySWOBeanExtractor_2fe0d772
 */
public class HistorySWOBeanExtractor_2fe0d772 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * HistorySWOBeanExtractor_2fe0d772
	 */
	public HistorySWOBeanExtractor_2fe0d772() {
		int[] pkCols={1,2,3,4};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.HistorySWOBeanCacheEntryImpl_2fe0d772 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.HistorySWOBeanCacheEntryImpl_2fe0d772) createDataCacheEntry();

		entry.setDataForSOLD_TO_PARTY_ID(dataRow.getInt(dataColumns[0]));
		entry.setDataForDESG_MACHINE_ID(dataRow.getInt(dataColumns[1]));
		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[2]));
		entry.setDataForSWO_ID(dataRow.getInt(dataColumns[3]));
		entry.setDataForREQST_DELIVRY_DATE(dataRow.getDate(dataColumns[4]));
		entry.setDataForSERIAL_NO(dataRow.getString(dataColumns[5]));
		entry.setDataForPLAN_END_DATE(dataRow.getDate(dataColumns[6]));
		entry.setDataForCUSTOMER_PO_NO(dataRow.getString(dataColumns[7]));
		entry.setDataForPLAN_START_DATE(dataRow.getDate(dataColumns[8]));
		entry.setDataForITEM_CATEGORY(dataRow.getString(dataColumns[9]));
		entry.setDataForSEQUENCE_NO(dataRow.getInt(dataColumns[10]));
		entry.setDataForEQUIPMENT_NO(dataRow.getString(dataColumns[11]));
		entry.setDataForSWO_ITEM_NO(dataRow.getString(dataColumns[12]));
		entry.setDataForSALES_DOC_NO(dataRow.getString(dataColumns[13]));
		entry.setDataForSWO_DESC(dataRow.getString(dataColumns[14]));
		entry.setDataForCALC_PRICE(dataRow.getDouble(dataColumns[15]));
		entry.setDataForALT_PRICE(dataRow.getDouble(dataColumns[16]));
		entry.setDataForREF_SER_NO_DESGMC(dataRow.getString(dataColumns[17]));
		entry.setDataForREF_SERIAL_NO(dataRow.getString(dataColumns[18]));
		entry.setDataForALT_PRICE_IND(dataRow.getString(dataColumns[19]));
		entry.setDataForPLANNED_IND(dataRow.getString(dataColumns[20]));
		entry.setDataForESW_PRICE(dataRow.getDouble(dataColumns[21]));
		entry.setDataForOLD_CALC_PRICE(dataRow.getDouble(dataColumns[22]));
		entry.setDataForLAST_UPDATED_DATE(dataRow.getDate(dataColumns[23]));
		entry.setDataForSWO_NO(dataRow.getString(dataColumns[24]));
		entry.setDataForEXCLUSION_ID(dataRow.getString(dataColumns[25]));
		entry.setDataForAMDT_IND(dataRow.getString(dataColumns[26]));
		entry.setDataForAMDT_START_DATE(dataRow.getDate(dataColumns[27]));
		entry.setDataForBUMP_IND(dataRow.getString(dataColumns[28]));
		entry.setDataForSWO_ADDED_DATE(dataRow.getDate(dataColumns[29]));
		entry.setDataForRE_FETCH_ID(dataRow.getString(dataColumns[30]));
		entry.setDataForAMDT_END_DATE(dataRow.getDate(dataColumns[31]));
		entry.setDataForSWO_EXT_CNTR_NUM(dataRow.getString(dataColumns[32]));
		entry.setDataForSWO_CNTR_STATUS(dataRow.getString(dataColumns[33]));
		entry.setDataForSWO_CNTR_TYPE(dataRow.getString(dataColumns[34]));
		entry.setDataForADJUSTMENT_AMT(dataRow.getDouble(dataColumns[35]));
		entry.setDataForDELTA_FETCH_ID(dataRow.getString(dataColumns[36]));
		entry.setDataForS_S_INDICATOR(dataRow.getString(dataColumns[37]));
		entry.setDataForLOCKED_IND(dataRow.getString(dataColumns[38]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.HistorySWOKey();

		key.customerId=dataRow.getInt(primaryKeyColumns[0]);
		key.dmId=dataRow.getInt(primaryKeyColumns[1]);
		key.proposalId=dataRow.getInt(primaryKeyColumns[2]);
		key.swoId=dataRow.getInt(primaryKeyColumns[3]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "HistorySWO";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 39;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.HistorySWOBeanCacheEntryImpl_2fe0d772();
	}
}
