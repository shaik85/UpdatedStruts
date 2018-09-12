package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BaseAgreementChangeLogBeanExtractor_508109ee
 */
public class BaseAgreementChangeLogBeanExtractor_508109ee extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * BaseAgreementChangeLogBeanExtractor_508109ee
	 */
	public BaseAgreementChangeLogBeanExtractor_508109ee() {
		int[] pkCols={1};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementChangeLogBeanCacheEntryImpl_508109ee entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementChangeLogBeanCacheEntryImpl_508109ee) createDataCacheEntry();

		java.sql.Clob tempClob;

		entry.setDataForCHANGE_ID(dataRow.getInt(dataColumns[0]), dataRow.wasNull());
		entry.setDataForAGREEMENT_ID(dataRow.getInt(dataColumns[1]), dataRow.wasNull());
		entry.setDataForCREATED_BY(dataRow.getString(dataColumns[2]));
		entry.setDataForCHANGED_DATE(dataRow.getDate(dataColumns[3]));
		entry.setDataForCHANGED_TIME(dataRow.getTime(dataColumns[4]));
		tempClob = dataRow.getClob(dataColumns[5]);
		if (tempClob!=null) {
			try {
				entry.setDataForCHANGED_DETAILS(tempClob.getSubString(1, (int)tempClob.length()));
			} catch (java.sql.SQLException e) {
				throw new com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow("An error occured fetching field value.", e);
			}
		}
		else {
			entry.setDataForCHANGED_DETAILS(null);
		}

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogKey();

		key.changeId=new Integer(dataRow.getInt(primaryKeyColumns[0]));

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "BaseAgreementChangeLog";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 6;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1.BaseAgreementChangeLogBeanCacheEntryImpl_508109ee();
	}
}
