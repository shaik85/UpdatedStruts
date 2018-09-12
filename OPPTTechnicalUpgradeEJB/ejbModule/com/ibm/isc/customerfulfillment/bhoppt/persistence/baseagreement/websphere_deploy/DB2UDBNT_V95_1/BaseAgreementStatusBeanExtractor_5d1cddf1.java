package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BaseAgreementStatusBeanExtractor_5d1cddf1
 */
public class BaseAgreementStatusBeanExtractor_5d1cddf1 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * BaseAgreementStatusBeanExtractor_5d1cddf1
	 */
	public BaseAgreementStatusBeanExtractor_5d1cddf1() {
		int[] pkCols={1};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementStatusBeanCacheEntryImpl_5d1cddf1 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementStatusBeanCacheEntryImpl_5d1cddf1) createDataCacheEntry();

		entry.setDataForSTATUS_CODE(dataRow.getString(dataColumns[0]));
		entry.setDataForSTATUS_DESC(dataRow.getString(dataColumns[1]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementStatusKey();

		key.statusCode=dataRow.getString(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "BaseAgreementStatus";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 2;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementStatusBeanCacheEntryImpl_5d1cddf1();
	}
}
