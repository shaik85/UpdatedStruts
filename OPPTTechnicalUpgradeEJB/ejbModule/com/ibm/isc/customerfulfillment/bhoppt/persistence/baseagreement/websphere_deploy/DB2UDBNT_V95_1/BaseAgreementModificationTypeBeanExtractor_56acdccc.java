package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BaseAgreementModificationTypeBeanExtractor_56acdccc
 */
public class BaseAgreementModificationTypeBeanExtractor_56acdccc extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * BaseAgreementModificationTypeBeanExtractor_56acdccc
	 */
	public BaseAgreementModificationTypeBeanExtractor_56acdccc() {
		int[] pkCols={1,3};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementModificationTypeBeanCacheEntryImpl_56acdccc entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementModificationTypeBeanCacheEntryImpl_56acdccc) createDataCacheEntry();

		entry.setDataForMODIFICATION_TYPE_CODE(dataRow.getString(dataColumns[0]));
		entry.setDataForMODIFICATION_TYPE_DESC(dataRow.getString(dataColumns[1]));
		entry.setDataForSALES_ORG(dataRow.getString(dataColumns[2]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationTypeKey();

		key.modificationTypeCode=dataRow.getString(primaryKeyColumns[0]);
		key.salesOrganization=dataRow.getString(primaryKeyColumns[1]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "BaseAgreementModificationType";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 3;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementModificationTypeBeanCacheEntryImpl_56acdccc();
	}
}
