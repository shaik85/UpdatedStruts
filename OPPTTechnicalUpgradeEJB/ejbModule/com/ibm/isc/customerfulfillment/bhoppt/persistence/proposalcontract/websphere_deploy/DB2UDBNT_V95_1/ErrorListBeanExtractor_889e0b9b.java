package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

/**
 * ErrorListBeanExtractor_889e0b9b
 */
public class ErrorListBeanExtractor_889e0b9b extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * ErrorListBeanExtractor_889e0b9b
	 */
	public ErrorListBeanExtractor_889e0b9b() {
		int[] pkCols={1};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1.ErrorListBeanCacheEntryImpl_889e0b9b entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1.ErrorListBeanCacheEntryImpl_889e0b9b) createDataCacheEntry();

		entry.setDataForMESSAGE_ID(dataRow.getInt(dataColumns[0]), dataRow.wasNull());
		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[1]));
		entry.setDataForMSG_NO(dataRow.getDouble(dataColumns[2]));
		entry.setDataForCLASS_NAME(dataRow.getString(dataColumns[3]));
		entry.setDataForMETHOD_NAME(dataRow.getString(dataColumns[4]));
		entry.setDataForMSG_DESC(dataRow.getString(dataColumns[5]));
		entry.setDataForMSG_DETAIL(dataRow.getString(dataColumns[6]));
		entry.setDataForUSER_ID(dataRow.getString(dataColumns[7]));
		entry.setDataForDATE(dataRow.getDate(dataColumns[8]));
		entry.setDataForTIME(dataRow.getTime(dataColumns[9]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		java.lang.Integer key;
		key=new Integer(dataRow.getInt(primaryKeyColumns[0]));

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "ErrorList";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 10;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1.ErrorListBeanCacheEntryImpl_889e0b9b();
	}
}
