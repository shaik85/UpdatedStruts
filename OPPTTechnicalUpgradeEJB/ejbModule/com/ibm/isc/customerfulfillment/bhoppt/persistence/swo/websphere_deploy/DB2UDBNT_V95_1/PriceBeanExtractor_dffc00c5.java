package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * PriceBeanExtractor_dffc00c5
 */
public class PriceBeanExtractor_dffc00c5 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * PriceBeanExtractor_dffc00c5
	 */
	public PriceBeanExtractor_dffc00c5() {
		int[] pkCols={1,2,3,4,5,6};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.PriceBeanCacheEntryImpl_dffc00c5 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.PriceBeanCacheEntryImpl_dffc00c5) createDataCacheEntry();

		entry.setDataForPRICE_ID(dataRow.getInt(dataColumns[0]));
		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[1]));
		entry.setDataForSWOEE_ID(dataRow.getInt(dataColumns[2]));
		entry.setDataForSWO_ID(dataRow.getInt(dataColumns[3]));
		entry.setDataForDESG_MACHINE_ID(dataRow.getInt(dataColumns[4]));
		entry.setDataForSOLD_TO_PARTY_ID(dataRow.getInt(dataColumns[5]));
		entry.setDataForSALES_DOC_NO(dataRow.getString(dataColumns[6]));
		entry.setDataForEE_ITEM_NO(dataRow.getString(dataColumns[7]));
		entry.setDataForBILL_PLAN_ST_DATE(dataRow.getDate(dataColumns[8]));
		entry.setDataForBILL_PLAN_END_DATE(dataRow.getDate(dataColumns[9]));
		entry.setDataForESW_PRICE(dataRow.getDouble(dataColumns[10]));
		entry.setDataForCURRENCY(dataRow.getString(dataColumns[11]));
		entry.setDataForEXCLUSION_ID(dataRow.getString(dataColumns[12]));
		entry.setDataForBILLING_STATUS(dataRow.getString(dataColumns[13]));
		entry.setDataForMONTH_ID(dataRow.getString(dataColumns[14]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.PriceKey();

		key.priceId=dataRow.getInt(primaryKeyColumns[0]);
		key.proposalId=dataRow.getInt(primaryKeyColumns[1]);
		key.eeId=dataRow.getInt(primaryKeyColumns[2]);
		key.swoId=dataRow.getInt(primaryKeyColumns[3]);
		key.dmId=dataRow.getInt(primaryKeyColumns[4]);
		key.customerId=dataRow.getInt(primaryKeyColumns[5]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Price";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 15;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.PriceBeanCacheEntryImpl_dffc00c5();
	}
}
