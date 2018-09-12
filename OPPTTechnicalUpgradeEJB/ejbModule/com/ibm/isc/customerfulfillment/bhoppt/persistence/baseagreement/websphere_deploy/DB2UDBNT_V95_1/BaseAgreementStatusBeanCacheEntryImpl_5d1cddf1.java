package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BaseAgreementStatusBeanCacheEntryImpl_5d1cddf1
 */
public class BaseAgreementStatusBeanCacheEntryImpl_5d1cddf1 extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementStatusBeanCacheEntry_5d1cddf1 {
	static final long serialVersionUID = 61;
	/**
	 * getStatusCode
	 */
	public java.lang.String getStatusCode() {
		return STATUS_CODE_Data;
	}
	/**
	 * setStatusCode
	 */
	public void setStatusCode(String data) {
		this.STATUS_CODE_Data=data;
	}
	/**
	 * setDataForSTATUS_CODE
	 */
	public void setDataForSTATUS_CODE(String data) {
		this.STATUS_CODE_Data=data;
	}
	private String STATUS_CODE_Data;
	/**
	 * getStatusDescription
	 */
	public java.lang.String getStatusDescription() {
		return STATUS_DESC_Data;
	}
	/**
	 * setStatusDescription
	 */
	public void setStatusDescription(String data) {
		this.STATUS_DESC_Data=data;
	}
	/**
	 * setDataForSTATUS_DESC
	 */
	public void setDataForSTATUS_DESC(String data) {
		this.STATUS_DESC_Data=data;
	}
	private String STATUS_DESC_Data;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
}
