package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

/**
 * AccessHistoryBeanCacheEntryImpl_1c91e0cb
 */
public class AccessHistoryBeanCacheEntryImpl_1c91e0cb extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.AccessHistoryBeanCacheEntry_1c91e0cb {
	static final long serialVersionUID = 61;
	/**
	 * getUserId
	 */
	public java.lang.String getUserId() {
		return USER_ID_Data;
	}
	/**
	 * setUserId
	 */
	public void setUserId(String data) {
		this.USER_ID_Data=data;
	}
	/**
	 * setDataForUSER_ID
	 */
	public void setDataForUSER_ID(String data) {
		this.USER_ID_Data=data;
	}
	private String USER_ID_Data;
	/**
	 * getOperationPerformed
	 */
	public java.lang.String getOperationPerformed() {
		return OPERATION_PERFORMED_Data;
	}
	/**
	 * setOperationPerformed
	 */
	public void setOperationPerformed(String data) {
		this.OPERATION_PERFORMED_Data=data;
	}
	/**
	 * setDataForOPERATION_PERFORMED
	 */
	public void setDataForOPERATION_PERFORMED(String data) {
		this.OPERATION_PERFORMED_Data=data;
	}
	private String OPERATION_PERFORMED_Data;
	/**
	 * getAccessDate
	 */
	public java.sql.Date getAccessDate() {
		return ACCESS_DATE_Data;
	}
	/**
	 * setAccessDate
	 */
	public void setAccessDate(java.sql.Date data) {
		if (data == null)
			this.ACCESS_DATE_Data= null;
		else {
			this.ACCESS_DATE_Data=data; }
	}
	/**
	 * setDataForACCESS_DATE
	 */
	public void setDataForACCESS_DATE(java.sql.Date data) {
		this.ACCESS_DATE_Data=data;
	}
	private java.sql.Date ACCESS_DATE_Data;
	/**
	 * getAccessTime
	 */
	public java.sql.Time getAccessTime() {
		return ACCESS_TIME_Data;
	}
	/**
	 * setAccessTime
	 */
	public void setAccessTime(java.sql.Time data) {
		if (data == null)
			this.ACCESS_TIME_Data= null;
		else {
			this.ACCESS_TIME_Data=data; }
	}
	/**
	 * setDataForACCESS_TIME
	 */
	public void setDataForACCESS_TIME(java.sql.Time data) {
		this.ACCESS_TIME_Data=data;
	}
	private java.sql.Time ACCESS_TIME_Data;
	/**
	 * getSeqNo
	 */
	public int getSeqNo() {
		return SEQ_NO_Data;
	}
	/**
	 * setSeqNo
	 */
	public void setSeqNo(int data) {
		this.SEQ_NO_Data=data;
	}
	/**
	 * setDataForSEQ_NO
	 */
	public void setDataForSEQ_NO(int data) {
		this.SEQ_NO_Data=data;
	}
	private int SEQ_NO_Data;
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
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
}
