package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

/**
 * BaseAgreementBeanCacheEntryImpl_2e70ac6a
 */
public class BaseAgreementBeanCacheEntryImpl_2e70ac6a extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.BaseAgreementBeanCacheEntry_2e70ac6a {
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
	 * getAgreementNumber
	 */
	public java.lang.String getAgreementNumber() {
		return AGREEMENT_NUMBER_Data;
	}
	/**
	 * setAgreementNumber
	 */
	public void setAgreementNumber(String data) {
		this.AGREEMENT_NUMBER_Data=data;
	}
	/**
	 * setDataForAGREEMENT_NUMBER
	 */
	public void setDataForAGREEMENT_NUMBER(String data) {
		this.AGREEMENT_NUMBER_Data=data;
	}
	private String AGREEMENT_NUMBER_Data;
	/**
	 * getFormNumber
	 */
	public java.lang.String getFormNumber() {
		return FORM_NUMBER_Data;
	}
	/**
	 * setFormNumber
	 */
	public void setFormNumber(String data) {
		this.FORM_NUMBER_Data=data;
	}
	/**
	 * setDataForFORM_NUMBER
	 */
	public void setDataForFORM_NUMBER(String data) {
		this.FORM_NUMBER_Data=data;
	}
	private String FORM_NUMBER_Data;
	/**
	 * getLegacyCustomerNumber
	 */
	public java.lang.String getLegacyCustomerNumber() {
		return LEGACY_CUSTOMER_NUMBER_Data;
	}
	/**
	 * setLegacyCustomerNumber
	 */
	public void setLegacyCustomerNumber(String data) {
		this.LEGACY_CUSTOMER_NUMBER_Data=data;
	}
	/**
	 * setDataForLEGACY_CUSTOMER_NUMBER
	 */
	public void setDataForLEGACY_CUSTOMER_NUMBER(String data) {
		this.LEGACY_CUSTOMER_NUMBER_Data=data;
	}
	private String LEGACY_CUSTOMER_NUMBER_Data;
	/**
	 * getInac
	 */
	public java.lang.String getInac() {
		return INAC_Data;
	}
	/**
	 * setInac
	 */
	public void setInac(String data) {
		this.INAC_Data=data;
	}
	/**
	 * setDataForINAC
	 */
	public void setDataForINAC(String data) {
		this.INAC_Data=data;
	}
	private String INAC_Data;
	/**
	 * getExpirationDate
	 */
	public java.sql.Date getExpirationDate() {
		return EXPIRATION_DATE_Data;
	}
	/**
	 * setExpirationDate
	 */
	public void setExpirationDate(java.sql.Date data) {
		if (data == null)
			this.EXPIRATION_DATE_Data= null;
		else {
			this.EXPIRATION_DATE_Data=data; }
	}
	/**
	 * setDataForEXPIRATION_DATE
	 */
	public void setDataForEXPIRATION_DATE(java.sql.Date data) {
		this.EXPIRATION_DATE_Data=data;
	}
	private java.sql.Date EXPIRATION_DATE_Data;
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
	 * getOneway
	 */
	public java.lang.String getOneway() {
		return ONE_WAY_Data;
	}
	/**
	 * setOneway
	 */
	public void setOneway(String data) {
		this.ONE_WAY_Data=data;
	}
	/**
	 * setDataForONE_WAY
	 */
	public void setDataForONE_WAY(String data) {
		this.ONE_WAY_Data=data;
	}
	private String ONE_WAY_Data;
	/**
	 * getIsElectronicSubmitter
	 */
	public java.lang.String getIsElectronicSubmitter() {
		return IS_ELECTRONIC_SUBMITTER_Data;
	}
	/**
	 * setIsElectronicSubmitter
	 */
	public void setIsElectronicSubmitter(String data) {
		this.IS_ELECTRONIC_SUBMITTER_Data=data;
	}
	/**
	 * setDataForIS_ELECTRONIC_SUBMITTER
	 */
	public void setDataForIS_ELECTRONIC_SUBMITTER(String data) {
		this.IS_ELECTRONIC_SUBMITTER_Data=data;
	}
	private String IS_ELECTRONIC_SUBMITTER_Data;
	/**
	 * getImageReferenceNumber
	 */
	public java.lang.String getImageReferenceNumber() {
		return IMAGE_REFERENCE_NUMBER_Data;
	}
	/**
	 * setImageReferenceNumber
	 */
	public void setImageReferenceNumber(String data) {
		this.IMAGE_REFERENCE_NUMBER_Data=data;
	}
	/**
	 * setDataForIMAGE_REFERENCE_NUMBER
	 */
	public void setDataForIMAGE_REFERENCE_NUMBER(String data) {
		this.IMAGE_REFERENCE_NUMBER_Data=data;
	}
	private String IMAGE_REFERENCE_NUMBER_Data;
	/**
	 * getCustomerRepresentative
	 */
	public java.lang.String getCustomerRepresentative() {
		return CUSTOMER_REPRESENTATIVE_Data;
	}
	/**
	 * setCustomerRepresentative
	 */
	public void setCustomerRepresentative(String data) {
		this.CUSTOMER_REPRESENTATIVE_Data=data;
	}
	/**
	 * setDataForCUSTOMER_REPRESENTATIVE
	 */
	public void setDataForCUSTOMER_REPRESENTATIVE(String data) {
		this.CUSTOMER_REPRESENTATIVE_Data=data;
	}
	private String CUSTOMER_REPRESENTATIVE_Data;
	/**
	 * getBranchOffice
	 */
	public java.lang.String getBranchOffice() {
		return BRANCH_OFFICE_Data;
	}
	/**
	 * setBranchOffice
	 */
	public void setBranchOffice(String data) {
		this.BRANCH_OFFICE_Data=data;
	}
	/**
	 * setDataForBRANCH_OFFICE
	 */
	public void setDataForBRANCH_OFFICE(String data) {
		this.BRANCH_OFFICE_Data=data;
	}
	private String BRANCH_OFFICE_Data;
	/**
	 * getCoverageType
	 */
	public java.lang.String getCoverageType() {
		return COVERAGE_TYPE_Data;
	}
	/**
	 * setCoverageType
	 */
	public void setCoverageType(String data) {
		this.COVERAGE_TYPE_Data=data;
	}
	/**
	 * setDataForCOVERAGE_TYPE
	 */
	public void setDataForCOVERAGE_TYPE(String data) {
		this.COVERAGE_TYPE_Data=data;
	}
	private String COVERAGE_TYPE_Data;
	/**
	 * getFileNumber
	 */
	public java.lang.String getFileNumber() {
		return FILE_NUMBER_Data;
	}
	/**
	 * setFileNumber
	 */
	public void setFileNumber(String data) {
		this.FILE_NUMBER_Data=data;
	}
	/**
	 * setDataForFILE_NUMBER
	 */
	public void setDataForFILE_NUMBER(String data) {
		this.FILE_NUMBER_Data=data;
	}
	private String FILE_NUMBER_Data;
	/**
	 * getLegalContactHdr
	 */
	public java.lang.String getLegalContactHdr() {
		return LEGAL_CONTACT_HDR_Data;
	}
	/**
	 * setLegalContactHdr
	 */
	public void setLegalContactHdr(String data) {
		this.LEGAL_CONTACT_HDR_Data=data;
	}
	/**
	 * setDataForLEGAL_CONTACT_HDR
	 */
	public void setDataForLEGAL_CONTACT_HDR(String data) {
		this.LEGAL_CONTACT_HDR_Data=data;
	}
	private String LEGAL_CONTACT_HDR_Data;
	/**
	 * getAccountingContactHdr
	 */
	public java.lang.String getAccountingContactHdr() {
		return ACCOUNTING_CONTACT_HDR_Data;
	}
	/**
	 * setAccountingContactHdr
	 */
	public void setAccountingContactHdr(String data) {
		this.ACCOUNTING_CONTACT_HDR_Data=data;
	}
	/**
	 * setDataForACCOUNTING_CONTACT_HDR
	 */
	public void setDataForACCOUNTING_CONTACT_HDR(String data) {
		this.ACCOUNTING_CONTACT_HDR_Data=data;
	}
	private String ACCOUNTING_CONTACT_HDR_Data;
	/**
	 * getSalesOrganization
	 */
	public java.lang.String getSalesOrganization() {
		return SALES_ORG_Data;
	}
	/**
	 * setSalesOrganization
	 */
	public void setSalesOrganization(String data) {
		this.SALES_ORG_Data=data;
	}
	/**
	 * setDataForSALES_ORG
	 */
	public void setDataForSALES_ORG(String data) {
		this.SALES_ORG_Data=data;
	}
	private String SALES_ORG_Data;
	/**
	 * getAcceptedDate
	 */
	public java.sql.Date getAcceptedDate() {
		return ACCEPTED_DATE_Data;
	}
	/**
	 * setAcceptedDate
	 */
	public void setAcceptedDate(java.sql.Date data) {
		if (data == null)
			this.ACCEPTED_DATE_Data= null;
		else {
			this.ACCEPTED_DATE_Data=data; }
	}
	/**
	 * setDataForACCEPTED_DATE
	 */
	public void setDataForACCEPTED_DATE(java.sql.Date data) {
		this.ACCEPTED_DATE_Data=data;
	}
	private java.sql.Date ACCEPTED_DATE_Data;
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
	 * getIsModifiedAgreement
	 */
	public java.lang.String getIsModifiedAgreement() {
		return IS_MODIFIED_AGGREEMENT_Data;
	}
	/**
	 * setIsModifiedAgreement
	 */
	public void setIsModifiedAgreement(String data) {
		this.IS_MODIFIED_AGGREEMENT_Data=data;
	}
	/**
	 * setDataForIS_MODIFIED_AGGREEMENT
	 */
	public void setDataForIS_MODIFIED_AGGREEMENT(String data) {
		this.IS_MODIFIED_AGGREEMENT_Data=data;
	}
	private String IS_MODIFIED_AGGREEMENT_Data;
	/**
	 * getCustomerNumber
	 */
	public java.lang.String getCustomerNumber() {
		return SIGN_CUSTOMER_NUMBER_Data;
	}
	/**
	 * setCustomerNumber
	 */
	public void setCustomerNumber(String data) {
		this.SIGN_CUSTOMER_NUMBER_Data=data;
	}
	/**
	 * setDataForSIGN_CUSTOMER_NUMBER
	 */
	public void setDataForSIGN_CUSTOMER_NUMBER(String data) {
		this.SIGN_CUSTOMER_NUMBER_Data=data;
	}
	private String SIGN_CUSTOMER_NUMBER_Data;
	/**
	 * getCustomerName
	 */
	public java.lang.String getCustomerName() {
		return SIGN_CUSTOMER_NAME_Data;
	}
	/**
	 * setCustomerName
	 */
	public void setCustomerName(String data) {
		this.SIGN_CUSTOMER_NAME_Data=data;
	}
	/**
	 * setDataForSIGN_CUSTOMER_NAME
	 */
	public void setDataForSIGN_CUSTOMER_NAME(String data) {
		this.SIGN_CUSTOMER_NAME_Data=data;
	}
	private String SIGN_CUSTOMER_NAME_Data;
	/**
	 * getPreviousAgreementId
	 */
	public java.lang.Integer getPreviousAgreementId() {
		if((ACTUAL_AGREEMENT_TITLE_IsNull) || (ACTUAL_AGREEMENT_TITLE_Data == null))
			return null;
		else
			return new Integer(ACTUAL_AGREEMENT_TITLE_Data);
	}
	/**
	 * setPreviousAgreementId
	 */
	public void setPreviousAgreementId(Integer data) {
		if (data == null)
			this.ACTUAL_AGREEMENT_TITLE_IsNull= true;
		else {
			this.ACTUAL_AGREEMENT_TITLE_IsNull= false;
			this.ACTUAL_AGREEMENT_TITLE_Data=data.toString(); }
	}
	/**
	 * setDataForACTUAL_AGREEMENT_TITLE
	 */
	public void setDataForACTUAL_AGREEMENT_TITLE(String data, boolean isNull) {
		this.ACTUAL_AGREEMENT_TITLE_Data=data;
		this.ACTUAL_AGREEMENT_TITLE_IsNull=isNull;
	}
	private String ACTUAL_AGREEMENT_TITLE_Data;
	private boolean ACTUAL_AGREEMENT_TITLE_IsNull = true;
	/**
	 * getAgreementStatus
	 */
	public java.lang.String getAgreementStatus() {
		return STATUS_CODE_Data;
	}
	/**
	 * setAgreementStatus
	 */
	public void setAgreementStatus(String data) {
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
	 * getEnterpriseNumber
	 */
	public java.lang.String getEnterpriseNumber() {
		return AGREEMENT_IDENTIFIER1_Data;
	}
	/**
	 * setEnterpriseNumber
	 */
	public void setEnterpriseNumber(String data) {
		this.AGREEMENT_IDENTIFIER1_Data=data;
	}
	/**
	 * setDataForAGREEMENT_IDENTIFIER1
	 */
	public void setDataForAGREEMENT_IDENTIFIER1(String data) {
		this.AGREEMENT_IDENTIFIER1_Data=data;
	}
	private String AGREEMENT_IDENTIFIER1_Data;
	/**
	 * getEnterpriseName
	 */
	public java.lang.String getEnterpriseName() {
		return LEGACY_CC_Data;
	}
	/**
	 * setEnterpriseName
	 */
	public void setEnterpriseName(String data) {
		this.LEGACY_CC_Data=data;
	}
	/**
	 * setDataForLEGACY_CC
	 */
	public void setDataForLEGACY_CC(String data) {
		this.LEGACY_CC_Data=data;
	}
	private String LEGACY_CC_Data;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
}
