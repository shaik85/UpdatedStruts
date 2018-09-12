package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * CurrencyBeanCacheEntryImpl_679da69e
 */
public class CurrencyBeanCacheEntryImpl_679da69e extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.CurrencyBeanCacheEntry_679da69e {
	static final long serialVersionUID = 61;
	/**
	 * getCurrency
	 */
	public java.lang.String getCurrency() {
		return CURRENCY_CODE_Data;
	}
	/**
	 * setCurrency
	 */
	public void setCurrency(String data) {
		this.CURRENCY_CODE_Data=data;
	}
	/**
	 * setDataForCURRENCY_CODE
	 */
	public void setDataForCURRENCY_CODE(String data) {
		this.CURRENCY_CODE_Data=data;
	}
	private String CURRENCY_CODE_Data;
	/**
	 * getCurrencyDesc
	 */
	public java.lang.String getCurrencyDesc() {
		return CURRENCY_NAME_Data;
	}
	/**
	 * setCurrencyDesc
	 */
	public void setCurrencyDesc(String data) {
		this.CURRENCY_NAME_Data=data;
	}
	/**
	 * setDataForCURRENCY_NAME
	 */
	public void setDataForCURRENCY_NAME(String data) {
		this.CURRENCY_NAME_Data=data;
	}
	private String CURRENCY_NAME_Data;
	/**
	 * getDecimalsAllowed
	 */
	public java.lang.Integer getDecimalsAllowed() {
		if(DECIMAL_ALLOWED_IsNull)
			return null;
		else
			return new Integer(DECIMAL_ALLOWED_Data);
	}
	/**
	 * setDecimalsAllowed
	 */
	public void setDecimalsAllowed(Integer data) {
		if (data == null)
			this.DECIMAL_ALLOWED_IsNull= true;
		else {
			this.DECIMAL_ALLOWED_IsNull= false;
			this.DECIMAL_ALLOWED_Data=data.intValue(); }
	}
	/**
	 * setDataForDECIMAL_ALLOWED
	 */
	public void setDataForDECIMAL_ALLOWED(int data, boolean isNull) {
		this.DECIMAL_ALLOWED_Data=data;
		this.DECIMAL_ALLOWED_IsNull=isNull;
	}
	private int DECIMAL_ALLOWED_Data;
	private boolean DECIMAL_ALLOWED_IsNull = true;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
}
