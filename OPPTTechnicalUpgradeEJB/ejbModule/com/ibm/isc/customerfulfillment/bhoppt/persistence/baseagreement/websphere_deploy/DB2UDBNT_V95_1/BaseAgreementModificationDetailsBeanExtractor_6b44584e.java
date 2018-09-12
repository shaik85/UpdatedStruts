package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BaseAgreementModificationDetailsBeanExtractor_6b44584e
 */
public class BaseAgreementModificationDetailsBeanExtractor_6b44584e extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * BaseAgreementModificationDetailsBeanExtractor_6b44584e
	 */
	public BaseAgreementModificationDetailsBeanExtractor_6b44584e() {
		int[] pkCols={1,2};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementModificationDetailsBeanCacheEntryImpl_6b44584e entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementModificationDetailsBeanCacheEntryImpl_6b44584e) createDataCacheEntry();

		entry.setDataForAGREEMENT_ID(dataRow.getInt(dataColumns[0]), dataRow.wasNull());
		entry.setDataForMODIFICATION_TYPE_CODE(dataRow.getString(dataColumns[1]));
		entry.setDataForLEGAL_CONTACT(dataRow.getString(dataColumns[2]));
		entry.setDataForACCOUNTING_CONTACT(dataRow.getString(dataColumns[3]));
		entry.setDataForREVENUE_RECOGNITION(dataRow.getString(dataColumns[4]));
		entry.setDataForREFERENCE_TEXT(dataRow.getString(dataColumns[5]));
		entry.setDataForCATEGORY(dataRow.getString(dataColumns[6]));
		entry.setDataForDETAILS(dataRow.getString(dataColumns[7]));
		entry.setDataForCREATED_BY(dataRow.getString(dataColumns[8]));
		entry.setDataForCREATED_DATE(dataRow.getDate(dataColumns[9]));
		entry.setDataForCHANGED_BY(dataRow.getString(dataColumns[10]));
		entry.setDataForCHANGED_DATE(dataRow.getDate(dataColumns[11]));
		entry.setDataForMODIFICATION_START_DATE(dataRow.getDate(dataColumns[12]));
		entry.setDataForMODIFICATION_END_DATE(dataRow.getDate(dataColumns[13]));
		entry.setDataForSTATUS(dataRow.getString(dataColumns[14]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementModificationDetailsKey();

		key.agreementId=new Integer(dataRow.getInt(primaryKeyColumns[0]));
		key.modificationTypeCode=dataRow.getString(primaryKeyColumns[1]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "BaseAgreementModificationDetails";
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
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementModificationDetailsBeanCacheEntryImpl_6b44584e();
	}
}
