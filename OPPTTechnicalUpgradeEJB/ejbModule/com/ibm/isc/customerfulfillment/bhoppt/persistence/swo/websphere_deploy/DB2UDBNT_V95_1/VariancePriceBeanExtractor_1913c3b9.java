package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * VariancePriceBeanExtractor_1913c3b9
 */
public class VariancePriceBeanExtractor_1913c3b9 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * VariancePriceBeanExtractor_1913c3b9
	 */
	public VariancePriceBeanExtractor_1913c3b9() {
		int[] pkCols={1,2,3,4,5,6};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.VariancePriceBeanCacheEntryImpl_1913c3b9 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.VariancePriceBeanCacheEntryImpl_1913c3b9) createDataCacheEntry();

		entry.setDataForSOLD_TO_PARTY_ID(dataRow.getInt(dataColumns[0]));
		entry.setDataForDESG_MACHINE_ID(dataRow.getInt(dataColumns[1]));
		entry.setDataForSWOEE_ID(dataRow.getInt(dataColumns[2]));
		entry.setDataForPRICE_ID(dataRow.getInt(dataColumns[3]));
		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[4]));
		entry.setDataForSWO_ID(dataRow.getInt(dataColumns[5]));
		entry.setDataForSALES_DOC_NO(dataRow.getString(dataColumns[6]));
		entry.setDataForEE_ITEM_NO(dataRow.getString(dataColumns[7]));
		entry.setDataForBILL_PLAN_ST_DATE(dataRow.getDate(dataColumns[8]));
		entry.setDataForBILL_PLAN_END_DATE(dataRow.getDate(dataColumns[9]));
		entry.setDataForESW_PRICE(dataRow.getDouble(dataColumns[10]));
		entry.setDataForCURRENCY(dataRow.getString(dataColumns[11]));
		entry.setDataForINDICATOR(dataRow.getString(dataColumns[12]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.VariancePriceKey();

		key.customerId=dataRow.getInt(primaryKeyColumns[0]);
		key.dmId=dataRow.getInt(primaryKeyColumns[1]);
		key.eeId=dataRow.getInt(primaryKeyColumns[2]);
		key.priceId=dataRow.getInt(primaryKeyColumns[3]);
		key.proposalId=dataRow.getInt(primaryKeyColumns[4]);
		key.swoId=dataRow.getInt(primaryKeyColumns[5]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "VariancePrice";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 13;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1.VariancePriceBeanCacheEntryImpl_1913c3b9();
	}
}
