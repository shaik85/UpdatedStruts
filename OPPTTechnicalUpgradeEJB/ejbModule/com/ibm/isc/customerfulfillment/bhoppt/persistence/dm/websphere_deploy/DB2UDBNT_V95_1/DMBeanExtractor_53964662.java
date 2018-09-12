package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DB2UDBNT_V95_1;

/**
 * DMBeanExtractor_53964662
 */
public class DMBeanExtractor_53964662 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * DMBeanExtractor_53964662
	 */
	public DMBeanExtractor_53964662() {
		int[] pkCols={1,2,3};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DB2UDBNT_V95_1.DMBeanCacheEntryImpl_53964662 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DB2UDBNT_V95_1.DMBeanCacheEntryImpl_53964662) createDataCacheEntry();

		entry.setDataForDESG_MACHINE_ID(dataRow.getInt(dataColumns[0]));
		entry.setDataForSOLD_TO_PARTY_ID(dataRow.getInt(dataColumns[1]));
		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[2]));
		entry.setDataForDESG_MACHINE_DESC(dataRow.getString(dataColumns[3]));
		entry.setDataForDESG_MACHINE_NO(dataRow.getString(dataColumns[4]));
		entry.setDataForPLAN_START_DATE(dataRow.getDate(dataColumns[5]));
		entry.setDataForPLAN_END_DATE(dataRow.getDate(dataColumns[6]));
		entry.setDataForPLANNED_IND(dataRow.getString(dataColumns[7]));
		entry.setDataForLAST_UPDATED_DATE(dataRow.getDate(dataColumns[8]));
		entry.setDataForDM_ADDED_DATE(dataRow.getDate(dataColumns[9]));
		entry.setDataForEXCLUSION_ID(dataRow.getString(dataColumns[10]));
		entry.setDataForDM_COPY_INCR_NO(dataRow.getDouble(dataColumns[11]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.DMKey();

		key.dmId=dataRow.getInt(primaryKeyColumns[0]);
		key.customerId=dataRow.getInt(primaryKeyColumns[1]);
		key.proposalId=dataRow.getInt(primaryKeyColumns[2]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "DM";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 12;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DB2UDBNT_V95_1.DMBeanCacheEntryImpl_53964662();
	}
}
