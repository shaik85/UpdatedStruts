package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

/**
 * CustomerListBeanCacheEntryImpl_93c2f859
 */
public class CustomerListBeanCacheEntryImpl_93c2f859 extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.CustomerListBeanCacheEntry_93c2f859 {
	static final long serialVersionUID = 61;
	/**
	 * getProposalId
	 */
	public int getProposalId() {
		return PROPOSAL_ID_Data;
	}
	/**
	 * setProposalId
	 */
	public void setProposalId(int data) {
		this.PROPOSAL_ID_Data=data;
	}
	/**
	 * setDataForPROPOSAL_ID
	 */
	public void setDataForPROPOSAL_ID(int data) {
		this.PROPOSAL_ID_Data=data;
	}
	private int PROPOSAL_ID_Data;
	/**
	 * getCustomerListNo
	 */
	public java.lang.String getCustomerListNo() {
		return CUSTOMER_LIST_NO_Data;
	}
	/**
	 * setCustomerListNo
	 */
	public void setCustomerListNo(String data) {
		this.CUSTOMER_LIST_NO_Data=data;
	}
	/**
	 * setDataForCUSTOMER_LIST_NO
	 */
	public void setDataForCUSTOMER_LIST_NO(String data) {
		this.CUSTOMER_LIST_NO_Data=data;
	}
	private String CUSTOMER_LIST_NO_Data;
	/**
	 * getCustomerListName
	 */
	public java.lang.String getCustomerListName() {
		return CUSTOMER_LIST_NAME_Data;
	}
	/**
	 * setCustomerListName
	 */
	public void setCustomerListName(String data) {
		this.CUSTOMER_LIST_NAME_Data=data;
	}
	/**
	 * setDataForCUSTOMER_LIST_NAME
	 */
	public void setDataForCUSTOMER_LIST_NAME(String data) {
		this.CUSTOMER_LIST_NAME_Data=data;
	}
	private String CUSTOMER_LIST_NAME_Data;
	/**
	 * getLastUpdatedDate
	 */
	public java.sql.Date getLastUpdatedDate() {
		return LAST_UPDATE_DATE_Data;
	}
	/**
	 * setLastUpdatedDate
	 */
	public void setLastUpdatedDate(java.sql.Date data) {
		if (data == null)
			this.LAST_UPDATE_DATE_Data= null;
		else {
			this.LAST_UPDATE_DATE_Data=data; }
	}
	/**
	 * setDataForLAST_UPDATE_DATE
	 */
	public void setDataForLAST_UPDATE_DATE(java.sql.Date data) {
		this.LAST_UPDATE_DATE_Data=data;
	}
	private java.sql.Date LAST_UPDATE_DATE_Data;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
}
