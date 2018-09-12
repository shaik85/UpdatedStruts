package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BaseAgreementChangeLogBeanCacheEntryImpl_508109ee
 */
public class BaseAgreementChangeLogBeanCacheEntryImpl_508109ee extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementChangeLogBeanCacheEntry_508109ee {
	static final long serialVersionUID = 61;
	/**
	 * getChangeId
	 */
	public java.lang.Integer getChangeId() {
		if(CHANGE_ID_IsNull)
			return null;
		else
			return new Integer(CHANGE_ID_Data);
	}
	/**
	 * setChangeId
	 */
	public void setChangeId(Integer data) {
		if (data == null)
			this.CHANGE_ID_IsNull= true;
		else {
			this.CHANGE_ID_IsNull= false;
			this.CHANGE_ID_Data=data.intValue(); }
	}
	/**
	 * setDataForCHANGE_ID
	 */
	public void setDataForCHANGE_ID(int data, boolean isNull) {
		this.CHANGE_ID_Data=data;
		this.CHANGE_ID_IsNull=isNull;
	}
	private int CHANGE_ID_Data;
	private boolean CHANGE_ID_IsNull = true;
	/**
	 * getAgreementId
	 */
	public java.lang.Integer getAgreementId() {
		if(AGREEMENT_ID_IsNull)
			return null;
		else
			return new Integer(AGREEMENT_ID_Data);
	}
	/**
	 * setAgreementId
	 */
	public void setAgreementId(Integer data) {
		if (data == null)
			this.AGREEMENT_ID_IsNull= true;
		else {
			this.AGREEMENT_ID_IsNull= false;
			this.AGREEMENT_ID_Data=data.intValue(); }
	}
	/**
	 * setDataForAGREEMENT_ID
	 */
	public void setDataForAGREEMENT_ID(int data, boolean isNull) {
		this.AGREEMENT_ID_Data=data;
		this.AGREEMENT_ID_IsNull=isNull;
	}
	private int AGREEMENT_ID_Data;
	private boolean AGREEMENT_ID_IsNull = true;
	/**
	 * getCreatedBy
	 */
	public java.lang.String getCreatedBy() {
		return CREATED_BY_Data;
	}
	/**
	 * setCreatedBy
	 */
	public void setCreatedBy(String data) {
		this.CREATED_BY_Data=data;
	}
	/**
	 * setDataForCREATED_BY
	 */
	public void setDataForCREATED_BY(String data) {
		this.CREATED_BY_Data=data;
	}
	private String CREATED_BY_Data;
	/**
	 * getChangedDate
	 */
	public java.sql.Date getChangedDate() {
		return CHANGED_DATE_Data;
	}
	/**
	 * setChangedDate
	 */
	public void setChangedDate(java.sql.Date data) {
		if (data == null)
			this.CHANGED_DATE_Data= null;
		else {
			this.CHANGED_DATE_Data=data; }
	}
	/**
	 * setDataForCHANGED_DATE
	 */
	public void setDataForCHANGED_DATE(java.sql.Date data) {
		this.CHANGED_DATE_Data=data;
	}
	private java.sql.Date CHANGED_DATE_Data;
	/**
	 * getChangedTime
	 */
	public java.sql.Time getChangedTime() {
		return CHANGED_TIME_Data;
	}
	/**
	 * setChangedTime
	 */
	public void setChangedTime(java.sql.Time data) {
		if (data == null)
			this.CHANGED_TIME_Data= null;
		else {
			this.CHANGED_TIME_Data=data; }
	}
	/**
	 * setDataForCHANGED_TIME
	 */
	public void setDataForCHANGED_TIME(java.sql.Time data) {
		this.CHANGED_TIME_Data=data;
	}
	private java.sql.Time CHANGED_TIME_Data;
	/**
	 * getChangedDetails
	 */
	public java.lang.String getChangedDetails() {
		return CHANGED_DETAILS_Data;
	}
	/**
	 * setChangedDetails
	 */
	public void setChangedDetails(java.lang.String data) {
		this.CHANGED_DETAILS_Data=data;
	}
	/**
	 * setDataForCHANGED_DETAILS
	 */
	public void setDataForCHANGED_DETAILS(String data) {
		this.CHANGED_DETAILS_Data=data;
	}
	private String CHANGED_DETAILS_Data;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
}
