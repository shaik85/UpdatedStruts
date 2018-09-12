package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * UserProfileBeanExtractor_38f5ad96
 */
public class UserProfileBeanExtractor_38f5ad96 extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * UserProfileBeanExtractor_38f5ad96
	 */
	public UserProfileBeanExtractor_38f5ad96() {
		int[] pkCols={1};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.UserProfileBeanCacheEntryImpl_38f5ad96 entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.UserProfileBeanCacheEntryImpl_38f5ad96) createDataCacheEntry();

		entry.setDataForUSER_ID(dataRow.getString(dataColumns[0]));
		entry.setDataForROLE(dataRow.getString(dataColumns[1]));
		entry.setDataForASSO_SALES_ORG(dataRow.getString(dataColumns[2]));
		entry.setDataForAUTHORIZATION(dataRow.getString(dataColumns[3]));
		entry.setDataForAPPROVER_ID(dataRow.getString(dataColumns[4]));
		entry.setDataForGROUP_NAME(dataRow.getString(dataColumns[5]));
		entry.setDataForBP_ACCESS_INDICATOR(dataRow.getString(dataColumns[6]));
		entry.setDataForLAST_LOGIN_DATE(dataRow.getDate(dataColumns[7]));
		entry.setDataForFIRST_NAME(dataRow.getString(dataColumns[8]));
		entry.setDataForLAST_NAME(dataRow.getString(dataColumns[9]));
		entry.setDataForBA_ROLE(dataRow.getString(dataColumns[10]));
		entry.setDataForUSER_TYPE(dataRow.getString(dataColumns[11]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		java.lang.String key;
		key=dataRow.getString(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "UserProfile";
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
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1.UserProfileBeanCacheEntryImpl_38f5ad96();
	}
}
