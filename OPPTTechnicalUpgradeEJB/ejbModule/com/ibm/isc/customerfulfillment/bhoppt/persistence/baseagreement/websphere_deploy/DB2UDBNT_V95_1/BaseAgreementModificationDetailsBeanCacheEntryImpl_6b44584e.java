package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BaseAgreementModificationDetailsBeanCacheEntryImpl_6b44584e
 */
public class BaseAgreementModificationDetailsBeanCacheEntryImpl_6b44584e extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementModificationDetailsBeanCacheEntry_6b44584e {
	static final long serialVersionUID = 61;
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
	 * getModificationTypeCode
	 */
	public java.lang.String getModificationTypeCode() {
		return MODIFICATION_TYPE_CODE_Data;
	}
	/**
	 * setModificationTypeCode
	 */
	public void setModificationTypeCode(String data) {
		this.MODIFICATION_TYPE_CODE_Data=data;
	}
	/**
	 * setDataForMODIFICATION_TYPE_CODE
	 */
	public void setDataForMODIFICATION_TYPE_CODE(String data) {
		this.MODIFICATION_TYPE_CODE_Data=data;
	}
	private String MODIFICATION_TYPE_CODE_Data;
	/**
	 * getLegalContract
	 */
	public java.lang.String getLegalContract() {
		return LEGAL_CONTACT_Data;
	}
	/**
	 * setLegalContract
	 */
	public void setLegalContract(String data) {
		this.LEGAL_CONTACT_Data=data;
	}
	/**
	 * setDataForLEGAL_CONTACT
	 */
	public void setDataForLEGAL_CONTACT(String data) {
		this.LEGAL_CONTACT_Data=data;
	}
	private String LEGAL_CONTACT_Data;
	/**
	 * getAccountingContact
	 */
	public java.lang.String getAccountingContact() {
		return ACCOUNTING_CONTACT_Data;
	}
	/**
	 * setAccountingContact
	 */
	public void setAccountingContact(String data) {
		this.ACCOUNTING_CONTACT_Data=data;
	}
	/**
	 * setDataForACCOUNTING_CONTACT
	 */
	public void setDataForACCOUNTING_CONTACT(String data) {
		this.ACCOUNTING_CONTACT_Data=data;
	}
	private String ACCOUNTING_CONTACT_Data;
	/**
	 * getRevenueRecognition
	 */
	public java.lang.String getRevenueRecognition() {
		return REVENUE_RECOGNITION_Data;
	}
	/**
	 * setRevenueRecognition
	 */
	public void setRevenueRecognition(String data) {
		this.REVENUE_RECOGNITION_Data=data;
	}
	/**
	 * setDataForREVENUE_RECOGNITION
	 */
	public void setDataForREVENUE_RECOGNITION(String data) {
		this.REVENUE_RECOGNITION_Data=data;
	}
	private String REVENUE_RECOGNITION_Data;
	/**
	 * getModifiedIBMLetterHead
	 */
	public java.lang.String getModifiedIBMLetterHead() {
		return REFERENCE_TEXT_Data;
	}
	/**
	 * setModifiedIBMLetterHead
	 */
	public void setModifiedIBMLetterHead(String data) {
		this.REFERENCE_TEXT_Data=data;
	}
	/**
	 * setDataForREFERENCE_TEXT
	 */
	public void setDataForREFERENCE_TEXT(String data) {
		this.REFERENCE_TEXT_Data=data;
	}
	private String REFERENCE_TEXT_Data;
	/**
	 * getModificationOption
	 */
	public java.lang.String getModificationOption() {
		return CATEGORY_Data;
	}
	/**
	 * setModificationOption
	 */
	public void setModificationOption(String data) {
		this.CATEGORY_Data=data;
	}
	/**
	 * setDataForCATEGORY
	 */
	public void setDataForCATEGORY(String data) {
		this.CATEGORY_Data=data;
	}
	private String CATEGORY_Data;
	/**
	 * getDetails
	 */
	public java.lang.String getDetails() {
		return DETAILS_Data;
	}
	/**
	 * setDetails
	 */
	public void setDetails(String data) {
		this.DETAILS_Data=data;
	}
	/**
	 * setDataForDETAILS
	 */
	public void setDataForDETAILS(String data) {
		this.DETAILS_Data=data;
	}
	private String DETAILS_Data;
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
	 * getCreatedDate
	 */
	public java.sql.Date getCreatedDate() {
		return CREATED_DATE_Data;
	}
	/**
	 * setCreatedDate
	 */
	public void setCreatedDate(java.sql.Date data) {
		if (data == null)
			this.CREATED_DATE_Data= null;
		else {
			this.CREATED_DATE_Data=data; }
	}
	/**
	 * setDataForCREATED_DATE
	 */
	public void setDataForCREATED_DATE(java.sql.Date data) {
		this.CREATED_DATE_Data=data;
	}
	private java.sql.Date CREATED_DATE_Data;
	/**
	 * getChangedBy
	 */
	public java.lang.String getChangedBy() {
		return CHANGED_BY_Data;
	}
	/**
	 * setChangedBy
	 */
	public void setChangedBy(String data) {
		this.CHANGED_BY_Data=data;
	}
	/**
	 * setDataForCHANGED_BY
	 */
	public void setDataForCHANGED_BY(String data) {
		this.CHANGED_BY_Data=data;
	}
	private String CHANGED_BY_Data;
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
	 * getRolStartDate
	 */
	public java.sql.Date getRolStartDate() {
		return MODIFICATION_START_DATE_Data;
	}
	/**
	 * setRolStartDate
	 */
	public void setRolStartDate(java.sql.Date data) {
		if (data == null)
			this.MODIFICATION_START_DATE_Data= null;
		else {
			this.MODIFICATION_START_DATE_Data=data; }
	}
	/**
	 * setDataForMODIFICATION_START_DATE
	 */
	public void setDataForMODIFICATION_START_DATE(java.sql.Date data) {
		this.MODIFICATION_START_DATE_Data=data;
	}
	private java.sql.Date MODIFICATION_START_DATE_Data;
	/**
	 * getRolEndDate
	 */
	public java.sql.Date getRolEndDate() {
		return MODIFICATION_END_DATE_Data;
	}
	/**
	 * setRolEndDate
	 */
	public void setRolEndDate(java.sql.Date data) {
		if (data == null)
			this.MODIFICATION_END_DATE_Data= null;
		else {
			this.MODIFICATION_END_DATE_Data=data; }
	}
	/**
	 * setDataForMODIFICATION_END_DATE
	 */
	public void setDataForMODIFICATION_END_DATE(java.sql.Date data) {
		this.MODIFICATION_END_DATE_Data=data;
	}
	private java.sql.Date MODIFICATION_END_DATE_Data;
	/**
	 * getStatus
	 */
	public java.lang.String getStatus() {
		return STATUS_Data;
	}
	/**
	 * setStatus
	 */
	public void setStatus(String data) {
		this.STATUS_Data=data;
	}
	/**
	 * setDataForSTATUS
	 */
	public void setDataForSTATUS(String data) {
		this.STATUS_Data=data;
	}
	private String STATUS_Data;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
}
