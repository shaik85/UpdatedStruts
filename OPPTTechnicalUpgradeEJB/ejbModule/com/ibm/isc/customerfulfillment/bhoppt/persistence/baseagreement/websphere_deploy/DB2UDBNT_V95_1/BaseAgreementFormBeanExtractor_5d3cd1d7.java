package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BaseAgreementFormBeanExtractor_5d3cd1d7
 */
public class BaseAgreementFormBeanExtractor_5d3cd1d7 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * BaseAgreementFormBeanExtractor_5d3cd1d7
	 */
	public BaseAgreementFormBeanExtractor_5d3cd1d7() {
		int[] pkCols={1,4};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementFormBeanCacheEntryImpl_5d3cd1d7 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementFormBeanCacheEntryImpl_5d3cd1d7) createDataCacheEntry();

		entry.setDataForFORM_NUMBER(dataRow.getString(dataColumns[0]));
		entry.setDataForFORM_SHORT_DESCRIPTION(dataRow.getString(dataColumns[1]));
		entry.setDataForFORM_LONG_DESCRIPTION(dataRow.getString(dataColumns[2]));
		entry.setDataForSALES_ORG(dataRow.getString(dataColumns[3]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementFormKey();

		key.formNumber=dataRow.getString(primaryKeyColumns[0]);
		key.salesOrganization=dataRow.getString(primaryKeyColumns[1]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "BaseAgreementForm";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 4;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementFormBeanCacheEntryImpl_5d3cd1d7();
	}
}
