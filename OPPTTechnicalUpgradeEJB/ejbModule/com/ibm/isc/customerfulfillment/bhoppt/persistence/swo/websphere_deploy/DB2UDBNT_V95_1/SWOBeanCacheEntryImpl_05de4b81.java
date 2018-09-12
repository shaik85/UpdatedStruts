package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

/**
 * SWOBeanCacheEntryImpl_05de4b81
 */
public class SWOBeanCacheEntryImpl_05de4b81 extends com.ibm.ws.ejbpersistence.cache.DataCacheEntry implements com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.SWOBeanCacheEntry_05de4b81 {
	static final long serialVersionUID = 61;
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
	 * getLockedInd
	 */
	public java.lang.String getLockedInd() {
		return LOCKED_IND_Data;
	}
	/**
	 * setLockedInd
	 */
	public void setLockedInd(String data) {
		this.LOCKED_IND_Data=data;
	}
	/**
	 * setDataForLOCKED_IND
	 */
	public void setDataForLOCKED_IND(String data) {
		this.LOCKED_IND_Data=data;
	}
	private String LOCKED_IND_Data;
	/**
	 * getDeltaFetchId
	 */
	public java.lang.String getDeltaFetchId() {
		return DELTA_FETCH_ID_Data;
	}
	/**
	 * setDeltaFetchId
	 */
	public void setDeltaFetchId(String data) {
		this.DELTA_FETCH_ID_Data=data;
	}
	/**
	 * setDataForDELTA_FETCH_ID
	 */
	public void setDataForDELTA_FETCH_ID(String data) {
		this.DELTA_FETCH_ID_Data=data;
	}
	private String DELTA_FETCH_ID_Data;
	/**
	 * getAdjustmentAmount
	 */
	public double getAdjustmentAmount() {
		return ADJUSTMENT_AMT_Data;
	}
	/**
	 * setAdjustmentAmount
	 */
	public void setAdjustmentAmount(double data) {
		this.ADJUSTMENT_AMT_Data=data;
	}
	/**
	 * setDataForADJUSTMENT_AMT
	 */
	public void setDataForADJUSTMENT_AMT(double data) {
		this.ADJUSTMENT_AMT_Data=data;
	}
	private double ADJUSTMENT_AMT_Data;
	/**
	 * getLastUpdatedDate
	 */
	public java.sql.Date getLastUpdatedDate() {
		return LAST_UPDATED_DATE_Data;
	}
	/**
	 * setLastUpdatedDate
	 */
	public void setLastUpdatedDate(java.sql.Date data) {
		if (data == null)
			this.LAST_UPDATED_DATE_Data= null;
		else {
			this.LAST_UPDATED_DATE_Data=data; }
	}
	/**
	 * setDataForLAST_UPDATED_DATE
	 */
	public void setDataForLAST_UPDATED_DATE(java.sql.Date data) {
		this.LAST_UPDATED_DATE_Data=data;
	}
	private java.sql.Date LAST_UPDATED_DATE_Data;
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
	 * getBumpInd
	 */
	public java.lang.String getBumpInd() {
		return BUMP_IND_Data;
	}
	/**
	 * setBumpInd
	 */
	public void setBumpInd(String data) {
		this.BUMP_IND_Data=data;
	}
	/**
	 * setDataForBUMP_IND
	 */
	public void setDataForBUMP_IND(String data) {
		this.BUMP_IND_Data=data;
	}
	private String BUMP_IND_Data;
	/**
	 * getAmendStartDate
	 */
	public java.sql.Date getAmendStartDate() {
		return AMDT_START_DATE_Data;
	}
	/**
	 * setAmendStartDate
	 */
	public void setAmendStartDate(java.sql.Date data) {
		if (data == null)
			this.AMDT_START_DATE_Data= null;
		else {
			this.AMDT_START_DATE_Data=data; }
	}
	/**
	 * setDataForAMDT_START_DATE
	 */
	public void setDataForAMDT_START_DATE(java.sql.Date data) {
		this.AMDT_START_DATE_Data=data;
	}
	private java.sql.Date AMDT_START_DATE_Data;
	/**
	 * getSwoNo
	 */
	public java.lang.String getSwoNo() {
		return SWO_NO_Data;
	}
	/**
	 * setSwoNo
	 */
	public void setSwoNo(String data) {
		this.SWO_NO_Data=data;
	}
	/**
	 * setDataForSWO_NO
	 */
	public void setDataForSWO_NO(String data) {
		this.SWO_NO_Data=data;
	}
	private String SWO_NO_Data;
	/**
	 * getOldCalcPrice
	 */
	public double getOldCalcPrice() {
		return OLD_CALC_PRICE_Data;
	}
	/**
	 * setOldCalcPrice
	 */
	public void setOldCalcPrice(double data) {
		this.OLD_CALC_PRICE_Data=data;
	}
	/**
	 * setDataForOLD_CALC_PRICE
	 */
	public void setDataForOLD_CALC_PRICE(double data) {
		this.OLD_CALC_PRICE_Data=data;
	}
	private double OLD_CALC_PRICE_Data;
	/**
	 * getAmendInd
	 */
	public java.lang.String getAmendInd() {
		return AMDT_IND_Data;
	}
	/**
	 * setAmendInd
	 */
	public void setAmendInd(String data) {
		this.AMDT_IND_Data=data;
	}
	/**
	 * setDataForAMDT_IND
	 */
	public void setDataForAMDT_IND(String data) {
		this.AMDT_IND_Data=data;
	}
	private String AMDT_IND_Data;
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
	 * getPlannedInd
	 */
	public java.lang.String getPlannedInd() {
		return PLANNED_IND_Data;
	}
	/**
	 * setPlannedInd
	 */
	public void setPlannedInd(String data) {
		this.PLANNED_IND_Data=data;
	}
	/**
	 * setDataForPLANNED_IND
	 */
	public void setDataForPLANNED_IND(String data) {
		this.PLANNED_IND_Data=data;
	}
	private String PLANNED_IND_Data;
	/**
	 * getAlternatePriceInd
	 */
	public java.lang.String getAlternatePriceInd() {
		return ALT_PRICE_IND_Data;
	}
	/**
	 * setAlternatePriceInd
	 */
	public void setAlternatePriceInd(String data) {
		this.ALT_PRICE_IND_Data=data;
	}
	/**
	 * setDataForALT_PRICE_IND
	 */
	public void setDataForALT_PRICE_IND(String data) {
		this.ALT_PRICE_IND_Data=data;
	}
	private String ALT_PRICE_IND_Data;
	/**
	 * getReferenceSerialNoDM
	 */
	public java.lang.String getReferenceSerialNoDM() {
		return REF_SER_NO_DESGMC_Data;
	}
	/**
	 * setReferenceSerialNoDM
	 */
	public void setReferenceSerialNoDM(String data) {
		this.REF_SER_NO_DESGMC_Data=data;
	}
	/**
	 * setDataForREF_SER_NO_DESGMC
	 */
	public void setDataForREF_SER_NO_DESGMC(String data) {
		this.REF_SER_NO_DESGMC_Data=data;
	}
	private String REF_SER_NO_DESGMC_Data;
	/**
	 * getReferenceSerialNo
	 */
	public java.lang.String getReferenceSerialNo() {
		return REF_SERIAL_NO_Data;
	}
	/**
	 * setReferenceSerialNo
	 */
	public void setReferenceSerialNo(String data) {
		this.REF_SERIAL_NO_Data=data;
	}
	/**
	 * setDataForREF_SERIAL_NO
	 */
	public void setDataForREF_SERIAL_NO(String data) {
		this.REF_SERIAL_NO_Data=data;
	}
	private String REF_SERIAL_NO_Data;
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
	 * getCalcPrice
	 */
	public double getCalcPrice() {
		return CALC_PRICE_Data;
	}
	/**
	 * setCalcPrice
	 */
	public void setCalcPrice(double data) {
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
	 * getCustomerPONo
	 */
	public java.lang.String getCustomerPONo() {
		return CUSTOMER_PO_NO_Data;
	}
	/**
	 * setCustomerPONo
	 */
	public void setCustomerPONo(String data) {
		this.CUSTOMER_PO_NO_Data=data;
	}
	/**
	 * setDataForCUSTOMER_PO_NO
	 */
	public void setDataForCUSTOMER_PO_NO(String data) {
		this.CUSTOMER_PO_NO_Data=data;
	}
	private String CUSTOMER_PO_NO_Data;
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
	 * getItemCategory
	 */
	public java.lang.String getItemCategory() {
		return ITEM_CATEGORY_Data;
	}
	/**
	 * setItemCategory
	 */
	public void setItemCategory(String data) {
		this.ITEM_CATEGORY_Data=data;
	}
	/**
	 * setDataForITEM_CATEGORY
	 */
	public void setDataForITEM_CATEGORY(String data) {
		this.ITEM_CATEGORY_Data=data;
	}
	private String ITEM_CATEGORY_Data;
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
	 * getEquipmentNo
	 */
	public java.lang.String getEquipmentNo() {
		return EQUIPMENT_NO_Data;
	}
	/**
	 * setEquipmentNo
	 */
	public void setEquipmentNo(String data) {
		this.EQUIPMENT_NO_Data=data;
	}
	/**
	 * setDataForEQUIPMENT_NO
	 */
	public void setDataForEQUIPMENT_NO(String data) {
		this.EQUIPMENT_NO_Data=data;
	}
	private String EQUIPMENT_NO_Data;
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
	 * getSwoDesc
	 */
	public java.lang.String getSwoDesc() {
		return SWO_DESC_Data;
	}
	/**
	 * setSwoDesc
	 */
	public void setSwoDesc(String data) {
		this.SWO_DESC_Data=data;
	}
	/**
	 * setDataForSWO_DESC
	 */
	public void setDataForSWO_DESC(String data) {
		this.SWO_DESC_Data=data;
	}
	private String SWO_DESC_Data;
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
	 * getRequestDeliveryDate
	 */
	public java.sql.Date getRequestDeliveryDate() {
		return REQST_DELIVRY_DATE_Data;
	}
	/**
	 * setRequestDeliveryDate
	 */
	public void setRequestDeliveryDate(java.sql.Date data) {
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
	 * getDuplicateDeletedInd
	 */
	public java.lang.String getDuplicateDeletedInd() {
		return DUPLICATE_DELETED_IND_Data;
	}
	/**
	 * setDuplicateDeletedInd
	 */
	public void setDuplicateDeletedInd(String data) {
		this.DUPLICATE_DELETED_IND_Data=data;
	}
	/**
	 * setDataForDUPLICATE_DELETED_IND
	 */
	public void setDataForDUPLICATE_DELETED_IND(String data) {
		this.DUPLICATE_DELETED_IND_Data=data;
	}
	private String DUPLICATE_DELETED_IND_Data;
	/**
	 * getSandsIndicator
	 */
	public java.lang.String getSandsIndicator() {
		return S_S_INDICATOR_Data;
	}
	/**
	 * setSandsIndicator
	 */
	public void setSandsIndicator(String data) {
		this.S_S_INDICATOR_Data=data;
	}
	/**
	 * setDataForS_S_INDICATOR
	 */
	public void setDataForS_S_INDICATOR(String data) {
		this.S_S_INDICATOR_Data=data;
	}
	private String S_S_INDICATOR_Data;
	/**
	 * getSerialNo
	 */
	public java.lang.String getSerialNo() {
		return SERIAL_NO_Data;
	}
	/**
	 * setSerialNo
	 */
	public void setSerialNo(String data) {
		this.SERIAL_NO_Data=data;
	}
	/**
	 * setDataForSERIAL_NO
	 */
	public void setDataForSERIAL_NO(String data) {
		this.SERIAL_NO_Data=data;
	}
	private String SERIAL_NO_Data;
	/**
	 * getAmendEndDate
	 */
	public java.sql.Date getAmendEndDate() {
		return AMDT_END_DATE_Data;
	}
	/**
	 * setAmendEndDate
	 */
	public void setAmendEndDate(java.sql.Date data) {
		if (data == null)
			this.AMDT_END_DATE_Data= null;
		else {
			this.AMDT_END_DATE_Data=data; }
	}
	/**
	 * setDataForAMDT_END_DATE
	 */
	public void setDataForAMDT_END_DATE(java.sql.Date data) {
		this.AMDT_END_DATE_Data=data;
	}
	private java.sql.Date AMDT_END_DATE_Data;
	/**
	 * getSwoAddedDate
	 */
	public java.sql.Date getSwoAddedDate() {
		return SWO_ADDED_DATE_Data;
	}
	/**
	 * setSwoAddedDate
	 */
	public void setSwoAddedDate(java.sql.Date data) {
		if (data == null)
			this.SWO_ADDED_DATE_Data= null;
		else {
			this.SWO_ADDED_DATE_Data=data; }
	}
	/**
	 * setDataForSWO_ADDED_DATE
	 */
	public void setDataForSWO_ADDED_DATE(java.sql.Date data) {
		this.SWO_ADDED_DATE_Data=data;
	}
	private java.sql.Date SWO_ADDED_DATE_Data;
	/**
	 * getRefetchId
	 */
	public java.lang.String getRefetchId() {
		return RE_FETCH_ID_Data;
	}
	/**
	 * setRefetchId
	 */
	public void setRefetchId(String data) {
		this.RE_FETCH_ID_Data=data;
	}
	/**
	 * setDataForRE_FETCH_ID
	 */
	public void setDataForRE_FETCH_ID(String data) {
		this.RE_FETCH_ID_Data=data;
	}
	private String RE_FETCH_ID_Data;
	/**
	 * getSwoExtContrNo
	 */
	public java.lang.String getSwoExtContrNo() {
		return SWO_EXT_CNTR_NUM_Data;
	}
	/**
	 * setSwoExtContrNo
	 */
	public void setSwoExtContrNo(String data) {
		this.SWO_EXT_CNTR_NUM_Data=data;
	}
	/**
	 * setDataForSWO_EXT_CNTR_NUM
	 */
	public void setDataForSWO_EXT_CNTR_NUM(String data) {
		this.SWO_EXT_CNTR_NUM_Data=data;
	}
	private String SWO_EXT_CNTR_NUM_Data;
	/**
	 * getSwoContrStatus
	 */
	public java.lang.String getSwoContrStatus() {
		return SWO_CNTR_STATUS_Data;
	}
	/**
	 * setSwoContrStatus
	 */
	public void setSwoContrStatus(String data) {
		this.SWO_CNTR_STATUS_Data=data;
	}
	/**
	 * setDataForSWO_CNTR_STATUS
	 */
	public void setDataForSWO_CNTR_STATUS(String data) {
		this.SWO_CNTR_STATUS_Data=data;
	}
	private String SWO_CNTR_STATUS_Data;
	/**
	 * getSwoContrType
	 */
	public java.lang.String getSwoContrType() {
		return SWO_CNTR_TYPE_Data;
	}
	/**
	 * setSwoContrType
	 */
	public void setSwoContrType(String data) {
		this.SWO_CNTR_TYPE_Data=data;
	}
	/**
	 * setDataForSWO_CNTR_TYPE
	 */
	public void setDataForSWO_CNTR_TYPE(String data) {
		this.SWO_CNTR_TYPE_Data=data;
	}
	private String SWO_CNTR_TYPE_Data;
	/**
	 * getAlternatePriceUpdateInd
	 */
	public java.lang.String getAlternatePriceUpdateInd() {
		return ALT_PRICE_UPDATE_IND_Data;
	}
	/**
	 * setAlternatePriceUpdateInd
	 */
	public void setAlternatePriceUpdateInd(String data) {
		this.ALT_PRICE_UPDATE_IND_Data=data;
	}
	/**
	 * setDataForALT_PRICE_UPDATE_IND
	 */
	public void setDataForALT_PRICE_UPDATE_IND(String data) {
		this.ALT_PRICE_UPDATE_IND_Data=data;
	}
	private String ALT_PRICE_UPDATE_IND_Data;
	/**
	 * getPlanDateInd
	 */
	public java.lang.String getPlanDateInd() {
		return PLAN_DATE_IND_Data;
	}
	/**
	 * setPlanDateInd
	 */
	public void setPlanDateInd(String data) {
		this.PLAN_DATE_IND_Data=data;
	}
	/**
	 * setDataForPLAN_DATE_IND
	 */
	public void setDataForPLAN_DATE_IND(String data) {
		this.PLAN_DATE_IND_Data=data;
	}
	private String PLAN_DATE_IND_Data;
	/**
	 * getOCCColumn
	 */
	public long getOCCColumn() {
		return 0;
	}
}
