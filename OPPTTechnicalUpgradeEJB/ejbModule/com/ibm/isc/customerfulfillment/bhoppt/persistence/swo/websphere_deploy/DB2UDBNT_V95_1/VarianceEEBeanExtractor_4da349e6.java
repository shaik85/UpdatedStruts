package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * VarianceEEBeanExtractor_4da349e6
 */
public class VarianceEEBeanExtractor_4da349e6 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * VarianceEEBeanExtractor_4da349e6
	 */
	public VarianceEEBeanExtractor_4da349e6() {
		int[] pkCols={1,2,3,4,5};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.VarianceEEBeanCacheEntryImpl_4da349e6 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.VarianceEEBeanCacheEntryImpl_4da349e6) createDataCacheEntry();

		entry.setDataForSOLD_TO_PARTY_ID(dataRow.getInt(dataColumns[0]));
		entry.setDataForDESG_MACHINE_ID(dataRow.getInt(dataColumns[1]));
		entry.setDataForSWOEE_ID(dataRow.getInt(dataColumns[2]));
		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[3]));
		entry.setDataForSWO_ID(dataRow.getInt(dataColumns[4]));
		entry.setDataForSALES_DOC_NO(dataRow.getString(dataColumns[5]));
		entry.setDataForEE_ITEM_NO(dataRow.getString(dataColumns[6]));
		entry.setDataForSWO_ITEM_NO(dataRow.getString(dataColumns[7]));
		entry.setDataForEE_NO(dataRow.getString(dataColumns[8]));
		entry.setDataForEE_DESC(dataRow.getString(dataColumns[9]));
		entry.setDataForVALUE_METRIC(dataRow.getString(dataColumns[10]));
		entry.setDataForUSE_LEVEL(dataRow.getString(dataColumns[11]));
		entry.setDataForLISC_TYPE(dataRow.getString(dataColumns[12]));
		entry.setDataForESW_PRICE(dataRow.getDouble(dataColumns[13]));
		entry.setDataForSEQUENCE_NO(dataRow.getInt(dataColumns[14]));
		entry.setDataForCHARGE_OPTION(dataRow.getString(dataColumns[15]));
		entry.setDataForCHARGE_OPTION_DESC(dataRow.getString(dataColumns[16]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VarianceEEKey();

		key.customerId=dataRow.getInt(primaryKeyColumns[0]);
		key.dmId=dataRow.getInt(primaryKeyColumns[1]);
		key.eeId=dataRow.getInt(primaryKeyColumns[2]);
		key.proposalId=dataRow.getInt(primaryKeyColumns[3]);
		key.swoId=dataRow.getInt(primaryKeyColumns[4]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "VarianceEE";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 17;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.VarianceEEBeanCacheEntryImpl_4da349e6();
	}
}
