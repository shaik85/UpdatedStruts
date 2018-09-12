package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BaseAgreementBeanExtractor_2e70ac6a
 */
public class BaseAgreementBeanExtractor_2e70ac6a extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * BaseAgreementBeanExtractor_2e70ac6a
	 */
	public BaseAgreementBeanExtractor_2e70ac6a() {
		int[] pkCols={1};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementBeanCacheEntryImpl_2e70ac6a entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementBeanCacheEntryImpl_2e70ac6a) createDataCacheEntry();

		entry.setDataForAGREEMENT_ID(dataRow.getInt(dataColumns[0]), dataRow.wasNull());
		entry.setDataForAGREEMENT_NUMBER(dataRow.getString(dataColumns[1]));
		entry.setDataForFORM_NUMBER(dataRow.getString(dataColumns[2]));
		entry.setDataForLEGACY_CUSTOMER_NUMBER(dataRow.getString(dataColumns[3]));
		entry.setDataForINAC(dataRow.getString(dataColumns[4]));
		entry.setDataForEXPIRATION_DATE(dataRow.getDate(dataColumns[5]));
		entry.setDataForCHANGED_DATE(dataRow.getDate(dataColumns[6]));
		entry.setDataForCHANGED_BY(dataRow.getString(dataColumns[7]));
		entry.setDataForONE_WAY(dataRow.getString(dataColumns[8]));
		entry.setDataForIS_ELECTRONIC_SUBMITTER(dataRow.getString(dataColumns[9]));
		entry.setDataForIMAGE_REFERENCE_NUMBER(dataRow.getString(dataColumns[10]));
		entry.setDataForCUSTOMER_REPRESENTATIVE(dataRow.getString(dataColumns[11]));
		entry.setDataForBRANCH_OFFICE(dataRow.getString(dataColumns[12]));
		entry.setDataForCOVERAGE_TYPE(dataRow.getString(dataColumns[13]));
		entry.setDataForFILE_NUMBER(dataRow.getString(dataColumns[14]));
		entry.setDataForLEGAL_CONTACT_HDR(dataRow.getString(dataColumns[15]));
		entry.setDataForACCOUNTING_CONTACT_HDR(dataRow.getString(dataColumns[16]));
		entry.setDataForSALES_ORG(dataRow.getString(dataColumns[17]));
		entry.setDataForACCEPTED_DATE(dataRow.getDate(dataColumns[18]));
		entry.setDataForCREATED_BY(dataRow.getString(dataColumns[19]));
		entry.setDataForCREATED_DATE(dataRow.getDate(dataColumns[20]));
		entry.setDataForIS_MODIFIED_AGGREEMENT(dataRow.getString(dataColumns[21]));
		entry.setDataForSIGN_CUSTOMER_NUMBER(dataRow.getString(dataColumns[22]));
		entry.setDataForSIGN_CUSTOMER_NAME(dataRow.getString(dataColumns[23]));
		entry.setDataForACTUAL_AGREEMENT_TITLE(dataRow.getString(dataColumns[24]), dataRow.wasNull());
		entry.setDataForSTATUS_CODE(dataRow.getString(dataColumns[25]));
		entry.setDataForAGREEMENT_IDENTIFIER1(dataRow.getString(dataColumns[26]));
		entry.setDataForLEGACY_CC(dataRow.getString(dataColumns[27]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementKey();

		key.agreementId=new Integer(dataRow.getInt(primaryKeyColumns[0]));

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "BaseAgreement";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 28;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementBeanCacheEntryImpl_2e70ac6a();
	}
}
