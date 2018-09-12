package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * SWOBeanExtractor_05de4b81
 */
public class SWOBeanExtractor_05de4b81 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * SWOBeanExtractor_05de4b81
	 */
	public SWOBeanExtractor_05de4b81() {
		int[] pkCols={1,2,3,4};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.SWOBeanCacheEntryImpl_05de4b81 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.SWOBeanCacheEntryImpl_05de4b81) createDataCacheEntry();

		entry.setDataForSWO_ID(dataRow.getInt(dataColumns[0]));
		entry.setDataForDESG_MACHINE_ID(dataRow.getInt(dataColumns[1]));
		entry.setDataForSOLD_TO_PARTY_ID(dataRow.getInt(dataColumns[2]));
		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[3]));
		entry.setDataForLOCKED_IND(dataRow.getString(dataColumns[4]));
		entry.setDataForDELTA_FETCH_ID(dataRow.getString(dataColumns[5]));
		entry.setDataForADJUSTMENT_AMT(dataRow.getDouble(dataColumns[6]));
		entry.setDataForLAST_UPDATED_DATE(dataRow.getDate(dataColumns[7]));
		entry.setDataForEXCLUSION_ID(dataRow.getString(dataColumns[8]));
		entry.setDataForBUMP_IND(dataRow.getString(dataColumns[9]));
		entry.setDataForAMDT_START_DATE(dataRow.getDate(dataColumns[10]));
		entry.setDataForSWO_NO(dataRow.getString(dataColumns[11]));
		entry.setDataForOLD_CALC_PRICE(dataRow.getDouble(dataColumns[12]));
		entry.setDataForAMDT_IND(dataRow.getString(dataColumns[13]));
		entry.setDataForESW_PRICE(dataRow.getDouble(dataColumns[14]));
		entry.setDataForPLANNED_IND(dataRow.getString(dataColumns[15]));
		entry.setDataForALT_PRICE_IND(dataRow.getString(dataColumns[16]));
		entry.setDataForREF_SER_NO_DESGMC(dataRow.getString(dataColumns[17]));
		entry.setDataForREF_SERIAL_NO(dataRow.getString(dataColumns[18]));
		entry.setDataForALT_PRICE(dataRow.getDouble(dataColumns[19]));
		entry.setDataForCALC_PRICE(dataRow.getDouble(dataColumns[20]));
		entry.setDataForCUSTOMER_PO_NO(dataRow.getString(dataColumns[21]));
		entry.setDataForPLAN_START_DATE(dataRow.getDate(dataColumns[22]));
		entry.setDataForITEM_CATEGORY(dataRow.getString(dataColumns[23]));
		entry.setDataForSEQUENCE_NO(dataRow.getInt(dataColumns[24]));
		entry.setDataForEQUIPMENT_NO(dataRow.getString(dataColumns[25]));
		entry.setDataForSWO_ITEM_NO(dataRow.getString(dataColumns[26]));
		entry.setDataForSALES_DOC_NO(dataRow.getString(dataColumns[27]));
		entry.setDataForSWO_DESC(dataRow.getString(dataColumns[28]));
		entry.setDataForPLAN_END_DATE(dataRow.getDate(dataColumns[29]));
		entry.setDataForREQST_DELIVRY_DATE(dataRow.getDate(dataColumns[30]));
		entry.setDataForDUPLICATE_DELETED_IND(dataRow.getString(dataColumns[31]));
		entry.setDataForS_S_INDICATOR(dataRow.getString(dataColumns[32]));
		entry.setDataForSERIAL_NO(dataRow.getString(dataColumns[33]));
		entry.setDataForAMDT_END_DATE(dataRow.getDate(dataColumns[34]));
		entry.setDataForSWO_ADDED_DATE(dataRow.getDate(dataColumns[35]));
		entry.setDataForRE_FETCH_ID(dataRow.getString(dataColumns[36]));
		entry.setDataForSWO_EXT_CNTR_NUM(dataRow.getString(dataColumns[37]));
		entry.setDataForSWO_CNTR_STATUS(dataRow.getString(dataColumns[38]));
		entry.setDataForSWO_CNTR_TYPE(dataRow.getString(dataColumns[39]));
		entry.setDataForALT_PRICE_UPDATE_IND(dataRow.getString(dataColumns[40]));
		entry.setDataForPLAN_DATE_IND(dataRow.getString(dataColumns[41]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.SWOKey();

		key.swoId=dataRow.getInt(primaryKeyColumns[0]);
		key.dmId=dataRow.getInt(primaryKeyColumns[1]);
		key.customerId=dataRow.getInt(primaryKeyColumns[2]);
		key.proposalId=dataRow.getInt(primaryKeyColumns[3]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "SWO";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 42;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.SWOBeanCacheEntryImpl_05de4b81();
	}
}
