package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

/**
 * ErrorListBeanCacheEntryImpl_889e0b9b
 */
public class ErrorListBeanCacheEntryImpl_889e0b9b extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.ErrorListBeanCacheEntry_889e0b9b {
	static final long serialVersionUID = 61;
	/**
	 * getMessageId
	 */
	public java.lang.Integer getMessageId() {
		if(MESSAGE_ID_IsNull)
			return null;
		else
			return new Integer(MESSAGE_ID_Data);
	}
	/**
	 * setMessageId
	 */
	public void setMessageId(Integer data) {
		if (data == null)
			this.MESSAGE_ID_IsNull= true;
		else {
			this.MESSAGE_ID_IsNull= false;
			this.MESSAGE_ID_Data=data.intValue(); }
	}
	/**
	 * setDataForMESSAGE_ID
	 */
	public void setDataForMESSAGE_ID(int data, boolean isNull) {
		this.MESSAGE_ID_Data=data;
		this.MESSAGE_ID_IsNull=isNull;
	}
	private int MESSAGE_ID_Data;
	private boolean MESSAGE_ID_IsNull = true;
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
	 * getMessageNO
	 */
	public double getMessageNO() {
		return MSG_NO_Data;
	}
	/**
	 * setMessageNO
	 */
	public void setMessageNO(double data) {
		this.MSG_NO_Data=data;
	}
	/**
	 * setDataForMSG_NO
	 */
	public void setDataForMSG_NO(double data) {
		this.MSG_NO_Data=data;
	}
	private double MSG_NO_Data;
	/**
	 * getClassName
	 */
	public java.lang.String getClassName() {
		return CLASS_NAME_Data;
	}
	/**
	 * setClassName
	 */
	public void setClassName(String data) {
		this.CLASS_NAME_Data=data;
	}
	/**
	 * setDataForCLASS_NAME
	 */
	public void setDataForCLASS_NAME(String data) {
		this.CLASS_NAME_Data=data;
	}
	private String CLASS_NAME_Data;
	/**
	 * getMethodName
	 */
	public java.lang.String getMethodName() {
		return METHOD_NAME_Data;
	}
	/**
	 * setMethodName
	 */
	public void setMethodName(String data) {
		this.METHOD_NAME_Data=data;
	}
	/**
	 * setDataForMETHOD_NAME
	 */
	public void setDataForMETHOD_NAME(String data) {
		this.METHOD_NAME_Data=data;
	}
	private String METHOD_NAME_Data;
	/**
	 * getMessageDesc
	 */
	public java.lang.String getMessageDesc() {
		return MSG_DESC_Data;
	}
	/**
	 * setMessageDesc
	 */
	public void setMessageDesc(String data) {
		this.MSG_DESC_Data=data;
	}
	/**
	 * setDataForMSG_DESC
	 */
	public void setDataForMSG_DESC(String data) {
		this.MSG_DESC_Data=data;
	}
	private String MSG_DESC_Data;
	/**
	 * getMessageDetail
	 */
	public java.lang.String getMessageDetail() {
		return MSG_DETAIL_Data;
	}
	/**
	 * setMessageDetail
	 */
	public void setMessageDetail(String data) {
		this.MSG_DETAIL_Data=data;
	}
	/**
	 * setDataForMSG_DETAIL
	 */
	public void setDataForMSG_DETAIL(String data) {
		this.MSG_DETAIL_Data=data;
	}
	private String MSG_DETAIL_Data;
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
	 * getDate
	 */
	public java.sql.Date getDate() {
		return DATE_Data;
	}
	/**
	 * setDate
	 */
	public void setDate(java.sql.Date data) {
		if (data == null)
			this.DATE_Data= null;
		else {
			this.DATE_Data=data; }
	}
	/**
	 * setDataForDATE
	 */
	public void setDataForDATE(java.sql.Date data) {
		this.DATE_Data=data;
	}
	private java.sql.Date DATE_Data;
	/**
	 * getTime
	 */
	public java.sql.Time getTime() {
		return TIME_Data;
	}
	/**
	 * setTime
	 */
	public void setTime(java.sql.Time data) {
		if (data == null)
			this.TIME_Data= null;
		else {
			this.TIME_Data=data; }
	}
	/**
	 * setDataForTIME
	 */
	public void setDataForTIME(java.sql.Time data) {
		this.TIME_Data=data;
	}
	private java.sql.Time TIME_Data;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
}
