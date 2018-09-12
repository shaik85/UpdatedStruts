package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * StatusBeanCacheEntryImpl_7d6e2679
 */
public class StatusBeanCacheEntryImpl_7d6e2679 extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.StatusBeanCacheEntry_7d6e2679 {
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
	 * getStatusDesc
	 */
	public java.lang.String getStatusDesc() {
		return STATUS_DESC_Data;
	}
	/**
	 * setStatusDesc
	 */
	public void setStatusDesc(String data) {
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
