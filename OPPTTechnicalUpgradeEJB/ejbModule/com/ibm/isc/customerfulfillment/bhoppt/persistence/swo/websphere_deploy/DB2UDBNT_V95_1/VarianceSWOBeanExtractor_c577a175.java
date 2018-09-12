package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * VarianceSWOBeanExtractor_c577a175
 */
public class VarianceSWOBeanExtractor_c577a175 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * VarianceSWOBeanExtractor_c577a175
	 */
	public VarianceSWOBeanExtractor_c577a175() {
		int[] pkCols={1,2,3,4};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.VarianceSWOBeanCacheEntryImpl_c577a175 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.VarianceSWOBeanCacheEntryImpl_c577a175) createDataCacheEntry();

		entry.setDataForSOLD_TO_PARTY_ID(dataRow.getInt(dataColumns[0]));
		entry.setDataForDESG_MACHINE_ID(dataRow.getInt(dataColumns[1]));
		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[2]));
		entry.setDataForSWO_ID(dataRow.getInt(dataColumns[3]));
		entry.setDataForSWO_NO(dataRow.getString(dataColumns[4]));
		entry.setDataForSALES_DOC_NO(dataRow.getString(dataColumns[5]));
		entry.setDataForSWO_DESC(dataRow.getString(dataColumns[6]));
		entry.setDataForSWO_ITEM_NO(dataRow.getString(dataColumns[7]));
		entry.setDataForSEQUENCE_NO(dataRow.getInt(dataColumns[8]));
		entry.setDataForITEM_CATEGORY(dataRow.getString(dataColumns[9]));
		entry.setDataForSERIAL_NO(dataRow.getString(dataColumns[10]));
		entry.setDataForCUSTOMER_PO_NO(dataRow.getString(dataColumns[11]));
		entry.setDataForEQUIPMENT_NO(dataRow.getString(dataColumns[12]));
		entry.setDataForESW_PRICE(dataRow.getDouble(dataColumns[13]));
		entry.setDataForREF_SERIAL_NO(dataRow.getString(dataColumns[14]));
		entry.setDataForREF_SER_NO_DESGMC(dataRow.getString(dataColumns[15]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceSWOKey();

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
		return "VarianceSWO";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 16;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.VarianceSWOBeanCacheEntryImpl_c577a175();
	}
}
