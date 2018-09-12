package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * TempEEBeanExtractor_6756a896
 */
public class TempEEBeanExtractor_6756a896 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * TempEEBeanExtractor_6756a896
	 */
	public TempEEBeanExtractor_6756a896() {
		int[] pkCols={2,3,4};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.TempEEBeanCacheEntryImpl_6756a896 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.TempEEBeanCacheEntryImpl_6756a896) createDataCacheEntry();

		entry.setDataForSESSIONID(dataRow.getString(dataColumns[0]));
		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[1]));
		entry.setDataForSOLD_TO_PARTY_ID(dataRow.getInt(dataColumns[2]));
		entry.setDataForDESG_MACHINE_ID(dataRow.getInt(dataColumns[3]));
		entry.setDataForSWO_ID(dataRow.getInt(dataColumns[4]));
		entry.setDataForSWOEE_ID(dataRow.getInt(dataColumns[5]));
		entry.setDataForEE_NO(dataRow.getString(dataColumns[6]));
		entry.setDataForSALES_DOC_NO(dataRow.getString(dataColumns[7]));
		entry.setDataForSWO_ITEM_NO(dataRow.getString(dataColumns[8]));
		entry.setDataForEE_ITEM_NO(dataRow.getString(dataColumns[9]));
		entry.setDataForVALUE_METRIC(dataRow.getString(dataColumns[10]));
		entry.setDataForLISC_TYPE(dataRow.getString(dataColumns[11]));
		entry.setDataForCHARGE_OPTION_DESC(dataRow.getString(dataColumns[12]));
		entry.setDataForUSE_LEVEL(dataRow.getString(dataColumns[13]));
		entry.setDataForVALID_IND(dataRow.getString(dataColumns[14]));
		entry.setDataForVALUEMETRIC_TYPE(dataRow.getString(dataColumns[15]));
		entry.setDataForVM(dataRow.getString(dataColumns[16]));
		entry.setDataForLCS(dataRow.getString(dataColumns[17]));
		entry.setDataForCHO(dataRow.getString(dataColumns[18]));
		entry.setDataForUL(dataRow.getString(dataColumns[19]));
		entry.setDataForDEFAULT_FLAG(dataRow.getString(dataColumns[20]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.TempEEKey();

		key.proposalId=dataRow.getInt(primaryKeyColumns[0]);
		key.customerId=dataRow.getInt(primaryKeyColumns[1]);
		key.dmId=dataRow.getInt(primaryKeyColumns[2]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "TempEE";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 21;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.TempEEBeanCacheEntryImpl_6756a896();
	}
}
