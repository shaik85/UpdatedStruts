package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * PriceBeanCacheEntryImpl_dffc00c5
 */
public class PriceBeanCacheEntryImpl_dffc00c5 extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.PriceBeanCacheEntry_dffc00c5 {
	static final long serialVersionUID = 61;
	/**
	 * getPriceId
	 */
	public int getPriceId() {
		return PRICE_ID_Data;
	}
	/**
	 * setPriceId
	 */
	public void setPriceId(int data) {
		this.PRICE_ID_Data=data;
	}
	/**
	 * setDataForPRICE_ID
	 */
	public void setDataForPRICE_ID(int data) {
		this.PRICE_ID_Data=data;
	}
	private int PRICE_ID_Data;
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
	 * getBillPlanStartDate
	 */
	public java.sql.Date getBillPlanStartDate() {
		return BILL_PLAN_ST_DATE_Data;
	}
	/**
	 * setBillPlanStartDate
	 */
	public void setBillPlanStartDate(java.sql.Date data) {
		if (data == null)
			this.BILL_PLAN_ST_DATE_Data= null;
		else {
			this.BILL_PLAN_ST_DATE_Data=data; }
	}
	/**
	 * setDataForBILL_PLAN_ST_DATE
	 */
	public void setDataForBILL_PLAN_ST_DATE(java.sql.Date data) {
		this.BILL_PLAN_ST_DATE_Data=data;
	}
	private java.sql.Date BILL_PLAN_ST_DATE_Data;
	/**
	 * getBillPlanEndDate
	 */
	public java.sql.Date getBillPlanEndDate() {
		return BILL_PLAN_END_DATE_Data;
	}
	/**
	 * setBillPlanEndDate
	 */
	public void setBillPlanEndDate(java.sql.Date data) {
		if (data == null)
			this.BILL_PLAN_END_DATE_Data= null;
		else {
			this.BILL_PLAN_END_DATE_Data=data; }
	}
	/**
	 * setDataForBILL_PLAN_END_DATE
	 */
	public void setDataForBILL_PLAN_END_DATE(java.sql.Date data) {
		this.BILL_PLAN_END_DATE_Data=data;
	}
	private java.sql.Date BILL_PLAN_END_DATE_Data;
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
	 * getCurrency
	 */
	public java.lang.String getCurrency() {
		return CURRENCY_Data;
	}
	/**
	 * setCurrency
	 */
	public void setCurrency(String data) {
		this.CURRENCY_Data=data;
	}
	/**
	 * setDataForCURRENCY
	 */
	public void setDataForCURRENCY(String data) {
		this.CURRENCY_Data=data;
	}
	private String CURRENCY_Data;
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
	 * getBillingStatus
	 */
	public java.lang.String getBillingStatus() {
		return BILLING_STATUS_Data;
	}
	/**
	 * setBillingStatus
	 */
	public void setBillingStatus(String data) {
		this.BILLING_STATUS_Data=data;
	}
	/**
	 * setDataForBILLING_STATUS
	 */
	public void setDataForBILLING_STATUS(String data) {
		this.BILLING_STATUS_Data=data;
	}
	private String BILLING_STATUS_Data;
	/**
	 * getMonthId
	 */
	public java.lang.String getMonthId() {
		return MONTH_ID_Data;
	}
	/**
	 * setMonthId
	 */
	public void setMonthId(String data) {
		this.MONTH_ID_Data=data;
	}
	/**
	 * setDataForMONTH_ID
	 */
	public void setDataForMONTH_ID(String data) {
		this.MONTH_ID_Data=data;
	}
	private String MONTH_ID_Data;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
}
