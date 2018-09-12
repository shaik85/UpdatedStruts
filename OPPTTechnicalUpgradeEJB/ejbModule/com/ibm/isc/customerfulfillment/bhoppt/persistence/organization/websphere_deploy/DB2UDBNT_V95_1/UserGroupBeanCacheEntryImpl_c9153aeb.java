package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

/**
 * UserGroupBeanCacheEntryImpl_c9153aeb
 */
public class UserGroupBeanCacheEntryImpl_c9153aeb extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.UserGroupBeanCacheEntry_c9153aeb {
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
	 * getGroupName
	 */
	public java.lang.String getGroupName() {
		return GROUP_NAME_Data;
	}
	/**
	 * setGroupName
	 */
	public void setGroupName(String data) {
		this.GROUP_NAME_Data=data;
	}
	/**
	 * setDataForGROUP_NAME
	 */
	public void setDataForGROUP_NAME(String data) {
		this.GROUP_NAME_Data=data;
	}
	private String GROUP_NAME_Data;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
}
