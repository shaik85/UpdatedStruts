package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * HistoryEEBeanCacheEntryImpl_2f4f3e31
 */
public class HistoryEEBeanCacheEntryImpl_2f4f3e31 extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.HistoryEEBeanCacheEntry_2f4f3e31 {
	static final long serialVersionUID = 61;
	/**
	 * getEeId
	 */
	public int getEeId() {
		return SWOEE_ID_Data;
	}
	/**
	 * setEeId
	 */
	public void setEeId(int data) {
		this.SWOEE_ID_Data=data;
	}
	/**
	 * setDataForSWOEE_ID
	 */
	public void setDataForSWOEE_ID(int data) {
		this.SWOEE_ID_Data=data;
	}
	private int SWOEE_ID_Data;
	/**
	 * getSwoId
	 */
	public int getSwoId() {
		return SWO_ID_Data;
	}
	/**
	 * setSwoId
	 */
	public void setSwoId(int data) {
		this.SWO_ID_Data=data;
	}
	/**
	 * setDataForSWO_ID
	 */
	public void setDataForSWO_ID(int data) {
		this.SWO_ID_Data=data;
	}
	private int SWO_ID_Data;
	/**
	 * getDmId
	 */
	public int getDmId() {
		return DESG_MACHINE_ID_Data;
	}
	/**
	 * setDmId
	 */
	public void setDmId(int data) {
		this.DESG_MACHINE_ID_Data=data;
	}
	/**
	 * setDataForDESG_MACHINE_ID
	 */
	public void setDataForDESG_MACHINE_ID(int data) {
		this.DESG_MACHINE_ID_Data=data;
	}
	private int DESG_MACHINE_ID_Data;
	/**
	 * getCustomerId
	 */
	public int getCustomerId() {
		return SOLD_TO_PARTY_ID_Data;
	}
	/**
	 * setCustomerId
	 */
	public void setCustomerId(int data) {
		this.SOLD_TO_PARTY_ID_Data=data;
	}
	/**
	 * setDataForSOLD_TO_PARTY_ID
	 */
	public void setDataForSOLD_TO_PARTY_ID(int data) {
		this.SOLD_TO_PARTY_ID_Data=data;
	}
	private int SOLD_TO_PARTY_ID_Data;
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
	 * getSalesDocNo
	 */
	public java.lang.String getSalesDocNo() {
		return SALES_DOC_NO_Data;
	}
	/**
	 * setSalesDocNo
	 */
	public void setSalesDocNo(String data) {
		this.SALES_DOC_NO_Data=data;
	}
	/**
	 * setDataForSALES_DOC_NO
	 */
	public void setDataForSALES_DOC_NO(String data) {
		this.SALES_DOC_NO_Data=data;
	}
	private String SALES_DOC_NO_Data;
	/**
	 * getEeItemNo
	 */
	public java.lang.String getEeItemNo() {
		return EE_ITEM_NO_Data;
	}
	/**
	 * setEeItemNo
	 */
	public void setEeItemNo(String data) {
		this.EE_ITEM_NO_Data=data;
	}
	/**
	 * setDataForEE_ITEM_NO
	 */
	public void setDataForEE_ITEM_NO(String data) {
		this.EE_ITEM_NO_Data=data;
	}
	private String EE_ITEM_NO_Data;
	/**
	 * getSwoItemNo
	 */
	public java.lang.String getSwoItemNo() {
		return SWO_ITEM_NO_Data;
	}
	/**
	 * setSwoItemNo
	 */
	public void setSwoItemNo(String data) {
		this.SWO_ITEM_NO_Data=data;
	}
	/**
	 * setDataForSWO_ITEM_NO
	 */
	public void setDataForSWO_ITEM_NO(String data) {
		this.SWO_ITEM_NO_Data=data;
	}
	private String SWO_ITEM_NO_Data;
	/**
	 * getEeNo
	 */
	public java.lang.String getEeNo() {
		return EE_NO_Data;
	}
	/**
	 * setEeNo
	 */
	public void setEeNo(String data) {
		this.EE_NO_Data=data;
	}
	/**
	 * setDataForEE_NO
	 */
	public void setDataForEE_NO(String data) {
		this.EE_NO_Data=data;
	}
	private String EE_NO_Data;
	/**
	 * getEeDesc
	 */
	public java.lang.String getEeDesc() {
		return EE_DESC_Data;
	}
	/**
	 * setEeDesc
	 */
	public void setEeDesc(String data) {
		this.EE_DESC_Data=data;
	}
	/**
	 * setDataForEE_DESC
	 */
	public void setDataForEE_DESC(String data) {
		this.EE_DESC_Data=data;
	}
	private String EE_DESC_Data;
	/**
	 * getPlanStartDate
	 */
	public java.sql.Date getPlanStartDate() {
		return PLAN_START_DATE_Data;
	}
	/**
	 * setPlanStartDate
	 */
	public void setPlanStartDate(java.sql.Date data) {
		if (data == null)
			this.PLAN_START_DATE_Data= null;
		else {
			this.PLAN_START_DATE_Data=data; }
	}
	/**
	 * setDataForPLAN_START_DATE
	 */
	public void setDataForPLAN_START_DATE(java.sql.Date data) {
		this.PLAN_START_DATE_Data=data;
	}
	private java.sql.Date PLAN_START_DATE_Data;
	/**
	 * getPlanEndDate
	 */
	public java.sql.Date getPlanEndDate() {
		return PLAN_END_DATE_Data;
	}
	/**
	 * setPlanEndDate
	 */
	public void setPlanEndDate(java.sql.Date data) {
		if (data == null)
			this.PLAN_END_DATE_Data= null;
		else {
			this.PLAN_END_DATE_Data=data; }
	}
	/**
	 * setDataForPLAN_END_DATE
	 */
	public void setDataForPLAN_END_DATE(java.sql.Date data) {
		this.PLAN_END_DATE_Data=data;
	}
	private java.sql.Date PLAN_END_DATE_Data;
	/**
	 * getReqstDeliveryDate
	 */
	public java.sql.Date getReqstDeliveryDate() {
		return REQST_DELIVRY_DATE_Data;
	}
	/**
	 * setReqstDeliveryDate
	 */
	public void setReqstDeliveryDate(java.sql.Date data) {
		if (data == null)
			this.REQST_DELIVRY_DATE_Data= null;
		else {
			this.REQST_DELIVRY_DATE_Data=data; }
	}
	/**
	 * setDataForREQST_DELIVRY_DATE
	 */
	public void setDataForREQST_DELIVRY_DATE(java.sql.Date data) {
		this.REQST_DELIVRY_DATE_Data=data;
	}
	private java.sql.Date REQST_DELIVRY_DATE_Data;
	/**
	 * getValueMetric
	 */
	public java.lang.String getValueMetric() {
		return VALUE_METRIC_Data;
	}
	/**
	 * setValueMetric
	 */
	public void setValueMetric(String data) {
		this.VALUE_METRIC_Data=data;
	}
	/**
	 * setDataForVALUE_METRIC
	 */
	public void setDataForVALUE_METRIC(String data) {
		this.VALUE_METRIC_Data=data;
	}
	private String VALUE_METRIC_Data;
	/**
	 * getUseLevel
	 */
	public java.lang.String getUseLevel() {
		return USE_LEVEL_Data;
	}
	/**
	 * setUseLevel
	 */
	public void setUseLevel(String data) {
		this.USE_LEVEL_Data=data;
	}
	/**
	 * setDataForUSE_LEVEL
	 */
	public void setDataForUSE_LEVEL(String data) {
		this.USE_LEVEL_Data=data;
	}
	private String USE_LEVEL_Data;
	/**
	 * getLicenseType
	 */
	public java.lang.String getLicenseType() {
		return LISC_TYPE_Data;
	}
	/**
	 * setLicenseType
	 */
	public void setLicenseType(String data) {
		this.LISC_TYPE_Data=data;
	}
	/**
	 * setDataForLISC_TYPE
	 */
	public void setDataForLISC_TYPE(String data) {
		this.LISC_TYPE_Data=data;
	}
	private String LISC_TYPE_Data;
	/**
	 * getEswPrice
	 */
	public double getEswPrice() {
		return ESW_PRICE_Data;
	}
	/**
	 * setEswPrice
	 */
	public void setEswPrice(double data) {
		this.ESW_PRICE_Data=data;
	}
	/**
	 * setDataForESW_PRICE
	 */
	public void setDataForESW_PRICE(double data) {
		this.ESW_PRICE_Data=data;
	}
	private double ESW_PRICE_Data;
	/**
	 * getCalculatedPrice
	 */
	public double getCalculatedPrice() {
		return CALC_PRICE_Data;
	}
	/**
	 * setCalculatedPrice
	 */
	public void setCalculatedPrice(double data) {
		this.CALC_PRICE_Data=data;
	}
	/**
	 * setDataForCALC_PRICE
	 */
	public void setDataForCALC_PRICE(double data) {
		this.CALC_PRICE_Data=data;
	}
	private double CALC_PRICE_Data;
	/**
	 * getAlternatePrice
	 */
	public double getAlternatePrice() {
		return ALT_PRICE_Data;
	}
	/**
	 * setAlternatePrice
	 */
	public void setAlternatePrice(double data) {
		this.ALT_PRICE_Data=data;
	}
	/**
	 * setDataForALT_PRICE
	 */
	public void setDataForALT_PRICE(double data) {
		this.ALT_PRICE_Data=data;
	}
	private double ALT_PRICE_Data;
	/**
	 * getBillingStartDate
	 */
	public java.sql.Date getBillingStartDate() {
		return BILLING_START_DATE_Data;
	}
	/**
	 * setBillingStartDate
	 */
	public void setBillingStartDate(java.sql.Date data) {
		if (data == null)
			this.BILLING_START_DATE_Data= null;
		else {
			this.BILLING_START_DATE_Data=data; }
	}
	/**
	 * setDataForBILLING_START_DATE
	 */
	public void setDataForBILLING_START_DATE(java.sql.Date data) {
		this.BILLING_START_DATE_Data=data;
	}
	private java.sql.Date BILLING_START_DATE_Data;
	/**
	 * getBillingEndDate
	 */
	public java.sql.Date getBillingEndDate() {
		return BILLING_END_DATE_Data;
	}
	/**
	 * setBillingEndDate
	 */
	public void setBillingEndDate(java.sql.Date data) {
		if (data == null)
			this.BILLING_END_DATE_Data= null;
		else {
			this.BILLING_END_DATE_Data=data; }
	}
	/**
	 * setDataForBILLING_END_DATE
	 */
	public void setDataForBILLING_END_DATE(java.sql.Date data) {
		this.BILLING_END_DATE_Data=data;
	}
	private java.sql.Date BILLING_END_DATE_Data;
	/**
	 * getExclusionId
	 */
	public java.lang.String getExclusionId() {
		return EXCLUSION_ID_Data;
	}
	/**
	 * setExclusionId
	 */
	public void setExclusionId(String data) {
		this.EXCLUSION_ID_Data=data;
	}
	/**
	 * setDataForEXCLUSION_ID
	 */
	public void setDataForEXCLUSION_ID(String data) {
		this.EXCLUSION_ID_Data=data;
	}
	private String EXCLUSION_ID_Data;
	/**
	 * getSequenceNo
	 */
	public int getSequenceNo() {
		return SEQUENCE_NO_Data;
	}
	/**
	 * setSequenceNo
	 */
	public void setSequenceNo(int data) {
		this.SEQUENCE_NO_Data=data;
	}
	/**
	 * setDataForSEQUENCE_NO
	 */
	public void setDataForSEQUENCE_NO(int data) {
		this.SEQUENCE_NO_Data=data;
	}
	private int SEQUENCE_NO_Data;
	/**
	 * getBumpId
	 */
	public java.lang.String getBumpId() {
		return BUMP_ID_Data;
	}
	/**
	 * setBumpId
	 */
	public void setBumpId(String data) {
		this.BUMP_ID_Data=data;
	}
	/**
	 * setDataForBUMP_ID
	 */
	public void setDataForBUMP_ID(String data) {
		this.BUMP_ID_Data=data;
	}
	private String BUMP_ID_Data;
	/**
	 * getChargeOptionDesc
	 */
	public java.lang.String getChargeOptionDesc() {
		return CHARGE_OPTION_DESC_Data;
	}
	/**
	 * setChargeOptionDesc
	 */
	public void setChargeOptionDesc(String data) {
		this.CHARGE_OPTION_DESC_Data=data;
	}
	/**
	 * setDataForCHARGE_OPTION_DESC
	 */
	public void setDataForCHARGE_OPTION_DESC(String data) {
		this.CHARGE_OPTION_DESC_Data=data;
	}
	private String CHARGE_OPTION_DESC_Data;
	/**
	 * getAlternatePriceId
	 */
	public java.lang.String getAlternatePriceId() {
		return ALT_PRICE_ID_Data;
	}
	/**
	 * setAlternatePriceId
	 */
	public void setAlternatePriceId(String data) {
		this.ALT_PRICE_ID_Data=data;
	}
	/**
	 * setDataForALT_PRICE_ID
	 */
	public void setDataForALT_PRICE_ID(String data) {
		this.ALT_PRICE_ID_Data=data;
	}
	private String ALT_PRICE_ID_Data;
	/**
	 * getPriceEffectiveDate
	 */
	public java.sql.Date getPriceEffectiveDate() {
		return PRICE_EFFC_DATE_Data;
	}
	/**
	 * setPriceEffectiveDate
	 */
	public void setPriceEffectiveDate(java.sql.Date data) {
		if (data == null)
			this.PRICE_EFFC_DATE_Data= null;
		else {
			this.PRICE_EFFC_DATE_Data=data; }
	}
	/**
	 * setDataForPRICE_EFFC_DATE
	 */
	public void setDataForPRICE_EFFC_DATE(java.sql.Date data) {
		this.PRICE_EFFC_DATE_Data=data;
	}
	private java.sql.Date PRICE_EFFC_DATE_Data;
	/**
	 * getSandsdiscountpercent
	 */
	public double getSandsdiscountpercent() {
		return S_S_DISCOUNT_PERCENT_Data;
	}
	/**
	 * setSandsdiscountpercent
	 */
	public void setSandsdiscountpercent(double data) {
		this.S_S_DISCOUNT_PERCENT_Data=data;
	}
	/**
	 * setDataForS_S_DISCOUNT_PERCENT
	 */
	public void setDataForS_S_DISCOUNT_PERCENT(double data) {
		this.S_S_DISCOUNT_PERCENT_Data=data;
	}
	private double S_S_DISCOUNT_PERCENT_Data;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
}
