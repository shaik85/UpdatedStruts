package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * ActivityLogBeanCacheEntryImpl_201bf224
 */
public class ActivityLogBeanCacheEntryImpl_201bf224 extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.ActivityLogBeanCacheEntry_201bf224 {
	static final long serialVersionUID = 61;
	/**
	 * getActivityDate
	 */
	public java.sql.Date getActivityDate() {
		return ACTIVITYDATE_Data;
	}
	/**
	 * setActivityDate
	 */
	public void setActivityDate(java.sql.Date data) {
		if (data == null)
			this.ACTIVITYDATE_Data= null;
		else {
			this.ACTIVITYDATE_Data=data; }
	}
	/**
	 * setDataForACTIVITYDATE
	 */
	public void setDataForACTIVITYDATE(java.sql.Date data) {
		this.ACTIVITYDATE_Data=data;
	}
	private java.sql.Date ACTIVITYDATE_Data;
	/**
	 * getActivityTime
	 */
	public java.sql.Time getActivityTime() {
		return ACTIVITYTIME_Data;
	}
	/**
	 * setActivityTime
	 */
	public void setActivityTime(java.sql.Time data) {
		if (data == null)
			this.ACTIVITYTIME_Data= null;
		else {
			this.ACTIVITYTIME_Data=data; }
	}
	/**
	 * setDataForACTIVITYTIME
	 */
	public void setDataForACTIVITYTIME(java.sql.Time data) {
		this.ACTIVITYTIME_Data=data;
	}
	private java.sql.Time ACTIVITYTIME_Data;
	/**
	 * getMessage
	 */
	public java.lang.String getMessage() {
		return MESSAGE_Data;
	}
	/**
	 * setMessage
	 */
	public void setMessage(String data) {
		this.MESSAGE_Data=data;
	}
	/**
	 * setDataForMESSAGE
	 */
	public void setDataForMESSAGE(String data) {
		this.MESSAGE_Data=data;
	}
	private String MESSAGE_Data;
	/**
	 * getUserId
	 */
	public java.lang.String getUserId() {
		return USERID_Data;
	}
	/**
	 * setUserId
	 */
	public void setUserId(String data) {
		this.USERID_Data=data;
	}
	/**
	 * setDataForUSERID
	 */
	public void setDataForUSERID(String data) {
		this.USERID_Data=data;
	}
	private String USERID_Data;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
}
