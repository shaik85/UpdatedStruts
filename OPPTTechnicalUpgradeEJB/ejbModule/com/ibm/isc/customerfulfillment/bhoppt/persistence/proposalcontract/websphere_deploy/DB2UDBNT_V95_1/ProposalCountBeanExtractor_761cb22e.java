package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

/**
 * ProposalCountBeanExtractor_761cb22e
 */
public class ProposalCountBeanExtractor_761cb22e extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * ProposalCountBeanExtractor_761cb22e
	 */
	public ProposalCountBeanExtractor_761cb22e() {
		int[] pkCols={2,3,4};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1.ProposalCountBeanCacheEntryImpl_761cb22e entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1.ProposalCountBeanCacheEntryImpl_761cb22e) createDataCacheEntry();

		entry.setDataForPROPOSAL_COUNT(dataRow.getInt(dataColumns[0]));
		entry.setDataForSALES_ORG(dataRow.getString(dataColumns[1]));
		entry.setDataForPROPOSAL_CONTENT(dataRow.getString(dataColumns[2]));
		entry.setDataForCUSTOMER_NAME(dataRow.getString(dataColumns[3]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalCountKey();

		key.salesOrg=dataRow.getString(primaryKeyColumns[0]);
		key.proposalContent=dataRow.getString(primaryKeyColumns[1]);
		key.customerName=dataRow.getString(primaryKeyColumns[2]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "ProposalCount";
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
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1.ProposalCountBeanCacheEntryImpl_761cb22e();
	}
}
