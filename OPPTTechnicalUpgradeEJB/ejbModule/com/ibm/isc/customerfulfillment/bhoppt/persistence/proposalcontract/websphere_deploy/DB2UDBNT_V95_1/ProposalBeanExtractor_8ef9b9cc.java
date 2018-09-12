package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

/**
 * ProposalBeanExtractor_8ef9b9cc
 */
public class ProposalBeanExtractor_8ef9b9cc extends com.ibm.ws.ejbpersistence.dataaccess.AbstractEJBExtractor {
	/**
	 * ProposalBeanExtractor_8ef9b9cc
	 */
	public ProposalBeanExtractor_8ef9b9cc() {
		int[] pkCols={6};
		setPrimaryKeyColumns(pkCols);

		int[] dataCols={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128};
		setDataColumns(dataCols);
	}
	/**
	 * extractData
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry extractData(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] dataColumns = getDataColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1.ProposalBeanCacheEntryImpl_8ef9b9cc entry=
			(com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1.ProposalBeanCacheEntryImpl_8ef9b9cc) createDataCacheEntry();

		entry.setDataForADD_VALUE_DAYS(dataRow.getInt(dataColumns[0]));
		entry.setDataForADVANCE_BILLING(dataRow.getString(dataColumns[1]));
		entry.setDataForAMDT_IND(dataRow.getString(dataColumns[2]));
		entry.setDataForAMDT_EFFC_DATE(dataRow.getDate(dataColumns[3]));
		entry.setDataForAPPROVED_BY(dataRow.getString(dataColumns[4]));
		entry.setDataForPROPOSAL_ID(dataRow.getInt(dataColumns[5]));
		entry.setDataForPROPOSAL_TYPE(dataRow.getString(dataColumns[6]));
		entry.setDataForBILLING_FREQ_CODE(dataRow.getString(dataColumns[7]));
		entry.setDataForCREATED_BY(dataRow.getString(dataColumns[8]));
		entry.setDataForSTATUS_CODE(dataRow.getString(dataColumns[9]));
		entry.setDataForSALES_ORG(dataRow.getString(dataColumns[10]));
		entry.setDataForDSTR_CHANNEL(dataRow.getString(dataColumns[11]));
		entry.setDataForDIVISION_CODE(dataRow.getString(dataColumns[12]));
		entry.setDataForPROPOSAL_NAME(dataRow.getString(dataColumns[13]));
		entry.setDataForCNTR_START_DATE(dataRow.getDate(dataColumns[14]));
		entry.setDataForCNTR_END_DATE(dataRow.getDate(dataColumns[15]));
		entry.setDataForCNTR_START_PERIOD(dataRow.getDate(dataColumns[16]));
		entry.setDataForCNTR_END_PERIOD(dataRow.getDate(dataColumns[17]));
		entry.setDataForTVM_RATE(dataRow.getDouble(dataColumns[18]));
		entry.setDataForGROWTH_FACTOR(dataRow.getDouble(dataColumns[19]));
		entry.setDataForSPECIAL_RATE(dataRow.getDouble(dataColumns[20]));
		entry.setDataForINVOICE_AMOUNT(dataRow.getDouble(dataColumns[21]));
		entry.setDataForDATE_PRICED(dataRow.getDate(dataColumns[22]));
		entry.setDataForCOMMENTS(dataRow.getString(dataColumns[23]));
		entry.setDataForCREATED_DATE(dataRow.getDate(dataColumns[24]));
		entry.setDataForAPPROVED_DATE(dataRow.getDate(dataColumns[25]));
		entry.setDataForDELETED_IND(dataRow.getString(dataColumns[26]));
		entry.setDataForREG_SOLD_TO_P_NO(dataRow.getString(dataColumns[27]));
		entry.setDataForREG_SOLD_TO_P_NAME(dataRow.getString(dataColumns[28]));
		entry.setDataForREG_BILL_TO_P_NO(dataRow.getString(dataColumns[29]));
		entry.setDataForREG_BILL_TO_P_NAME(dataRow.getString(dataColumns[30]));
		entry.setDataForREG_PAYER_NO(dataRow.getString(dataColumns[31]));
		entry.setDataForREG_PAYER_NAME(dataRow.getString(dataColumns[32]));
		entry.setDataForREG_SHIP_TO_P_NO(dataRow.getString(dataColumns[33]));
		entry.setDataForREG_SHIP_TO_P_NAME(dataRow.getString(dataColumns[34]));
		entry.setDataForCURRENCY(dataRow.getString(dataColumns[35]));
		entry.setDataForLAST_UPDATE_DATE(dataRow.getDate(dataColumns[36]));
		entry.setDataForRE_FETCH_ID(dataRow.getString(dataColumns[37]));
		entry.setDataForFETCH_DATE(dataRow.getDate(dataColumns[38]));
		entry.setDataForDELTA_FETCH_ID(dataRow.getString(dataColumns[39]));
		entry.setDataForCNTR_TYPE(dataRow.getString(dataColumns[40]));
		entry.setDataForREPORT_NAME(dataRow.getString(dataColumns[41]));
		entry.setDataForCAP_AMOUNT(dataRow.getDouble(dataColumns[42]));
		entry.setDataForCAP_PLUS(dataRow.getDouble(dataColumns[43]));
		entry.setDataForCAP_MINUS(dataRow.getDouble(dataColumns[44]));
		entry.setDataForPRE_TVM(dataRow.getDouble(dataColumns[45]));
		entry.setDataForCNTR_EXTN_DATE(dataRow.getDate(dataColumns[46]));
		entry.setDataForCNTR_RETR_DATE(dataRow.getDate(dataColumns[47]));
		entry.setDataForCNTR_REPL_DATE(dataRow.getDate(dataColumns[48]));
		entry.setDataForCNTR_CLS_DATE(dataRow.getDate(dataColumns[49]));
		entry.setDataForCNTR_NUMBER(dataRow.getString(dataColumns[50]));
		entry.setDataForCNTR_AMDT_NO(dataRow.getDouble(dataColumns[51]));
		entry.setDataForREG_SOLD_TO_P_LNO(dataRow.getString(dataColumns[52]));
		entry.setDataForREG_BILL_TO_P_LNO(dataRow.getString(dataColumns[53]));
		entry.setDataForREG_PAYER_LNO(dataRow.getString(dataColumns[54]));
		entry.setDataForREG_SHIP_TO_P_LNO(dataRow.getString(dataColumns[55]));
		entry.setDataForINVOICE_AMOUNT_SEM(dataRow.getDouble(dataColumns[56]));
		entry.setDataForINVOICE_AMOUNT_ANN(dataRow.getDouble(dataColumns[57]));
		entry.setDataForINVOICE_AMOUNT_MON(dataRow.getDouble(dataColumns[58]));
		entry.setDataForINVOICE_AMOUNT_QRT(dataRow.getDouble(dataColumns[59]));
		entry.setDataForOLD_CNTR_NUMBER(dataRow.getString(dataColumns[60]));
		entry.setDataForPRE_TVM_INV_AMT(dataRow.getDouble(dataColumns[61]));
		entry.setDataForPROPOSAL_SHARING(dataRow.getString(dataColumns[62]));
		entry.setDataForEXT_CNTR_NUMBER(dataRow.getString(dataColumns[63]));
		entry.setDataForCNTR_CREATE_FLAG(dataRow.getString(dataColumns[64]));
		entry.setDataForPAK_ID(dataRow.getString(dataColumns[65]));
		entry.setDataForBILLING_TYPE(dataRow.getString(dataColumns[66]));
		entry.setDataForPAYMENT_TERM(dataRow.getString(dataColumns[67]));
		entry.setDataForFIXED_VAL_DATE(dataRow.getDate(dataColumns[68]));
		entry.setDataForTP_CNTR_NUMBER(dataRow.getString(dataColumns[69]));
		entry.setDataForINELIGIBLE_IND(dataRow.getString(dataColumns[70]));
		entry.setDataForINVOICE_IND(dataRow.getString(dataColumns[71]));
		entry.setDataForAUTOPOPULATE_IND(dataRow.getString(dataColumns[72]));
		entry.setDataForCCI_IND(dataRow.getString(dataColumns[73]));
		entry.setDataForPREBILL_INDICATOR(dataRow.getString(dataColumns[74]));
		entry.setDataForBLB_INDICATOR(dataRow.getString(dataColumns[75]));
		entry.setDataForCONTRACT_TYPE(dataRow.getString(dataColumns[76]));
		entry.setDataForOCPS(dataRow.getString(dataColumns[77]));
		entry.setDataForCPS(dataRow.getString(dataColumns[78]));
		entry.setDataForS_S_DISCOUNT_AMOUNT5(dataRow.getDouble(dataColumns[79]));
		entry.setDataForS_S_DISCOUNT_AMOUNT4(dataRow.getDouble(dataColumns[80]));
		entry.setDataForS_S_DISCOUNT_AMOUNT3(dataRow.getDouble(dataColumns[81]));
		entry.setDataForS_S_DISCOUNT_AMOUNT2(dataRow.getDouble(dataColumns[82]));
		entry.setDataForS_S_DISCOUNT_AMOUNT1(dataRow.getDouble(dataColumns[83]));
		entry.setDataForS_S_ANNV_AMOUNT5(dataRow.getDouble(dataColumns[84]));
		entry.setDataForS_S_ANNV_AMOUNT4(dataRow.getDouble(dataColumns[85]));
		entry.setDataForS_S_ANNV_AMOUNT3(dataRow.getDouble(dataColumns[86]));
		entry.setDataForS_S_ANNV_AMOUNT2(dataRow.getDouble(dataColumns[87]));
		entry.setDataForS_S_EXTEND_CNTR_IND(dataRow.getString(dataColumns[88]));
		entry.setDataForGROUP_NAME(dataRow.getString(dataColumns[89]));
		entry.setDataForSUBMITTED_BY(dataRow.getString(dataColumns[90]));
		entry.setDataForPROPOSAL_CONTENT(dataRow.getString(dataColumns[91]));
		entry.setDataForS_S_DISCOUNT_SUM(dataRow.getDouble(dataColumns[92]));
		entry.setDataForS_S_ANNV_AMOUNT(dataRow.getDouble(dataColumns[93]));
		entry.setDataForREG_9D_PARTNER_NO(dataRow.getString(dataColumns[94]));
		entry.setDataForREG_9D_PARTNER_NAME(dataRow.getString(dataColumns[95]));
		entry.setDataForCUM_VALUE(dataRow.getDouble(dataColumns[96]));
		entry.setDataForCAP_VARIANCE(dataRow.getDouble(dataColumns[97]));
		entry.setDataForORG_VAR_CNTR_NUMBER(dataRow.getString(dataColumns[98]));
		entry.setDataForVAR_DATE(dataRow.getDate(dataColumns[99]));
		entry.setDataForVAR_IND(dataRow.getString(dataColumns[100]));
		entry.setDataForREG_SOLD_TO_P_ASNO(dataRow.getString(dataColumns[101]));
		entry.setDataForREG_BILL_TO_P_ASNO(dataRow.getString(dataColumns[102]));
		entry.setDataForREG_PAYER_ASNO(dataRow.getString(dataColumns[103]));
		entry.setDataForREG_SHIP_TO_P_ASNO(dataRow.getString(dataColumns[104]));
		entry.setDataForSUPPRESS_INVOICE(dataRow.getString(dataColumns[105]));
		entry.setDataForESW_FETCH_DATE(dataRow.getDate(dataColumns[106]));
		entry.setDataForESW_FETCH_TIME(dataRow.getTime(dataColumns[107]));
		entry.setDataForGSA_IND(dataRow.getString(dataColumns[108]));
		entry.setDataForFREE_TEXT(dataRow.getString(dataColumns[109]));
		entry.setDataForLOCKED_BY(dataRow.getString(dataColumns[110]));
		entry.setDataForLOCKED_ON(dataRow.getDate(dataColumns[111]));
		entry.setDataForPO_NUMBER(dataRow.getString(dataColumns[112]));
		entry.setDataForPO_DATE(dataRow.getDate(dataColumns[113]));
		entry.setDataForANNV_AMOUNT(dataRow.getDouble(dataColumns[114]));
		entry.setDataForCNTR_NEWRENEW_NO(dataRow.getInt(dataColumns[115]));
		entry.setDataForBILLING_BLOCK(dataRow.getString(dataColumns[116]));
		entry.setDataForCNTR_PERIOD_VAR_NO(dataRow.getInt(dataColumns[117]));
		entry.setDataForCNTR_VAR_NO(dataRow.getInt(dataColumns[118]));
		entry.setDataForDEVIATING_DATE_RULE(dataRow.getString(dataColumns[119]));
		entry.setDataForS_S_EXCLUDED(dataRow.getString(dataColumns[120]));
		entry.setDataForCNTR_REPL_NO(dataRow.getInt(dataColumns[121]));
		entry.setDataForFIN_CNTR_NO(dataRow.getString(dataColumns[122]));
		entry.setDataForSALES_GROUP(dataRow.getString(dataColumns[123]));
		entry.setDataForCHANNEL_ROLE(dataRow.getString(dataColumns[124]));
		entry.setDataForSUBMITTER_ROLE(dataRow.getString(dataColumns[125]));
		entry.setDataForPAYMENTMETHOD(dataRow.getString(dataColumns[126]));
		entry.setDataForDISCOUNT(dataRow.getDouble(dataColumns[127]));

		return entry;
	}
	/**
	 * extractPrimaryKey
	 */
	public Object extractPrimaryKey(com.ibm.ws.ejbpersistence.dataaccess.RawBeanData dataRow) throws com.ibm.ws.ejbpersistence.utilpm.ErrorProcessingResultCollectionRow, com.ibm.ws.ejbpersistence.utilpm.PersistenceManagerInternalError {
		int[] primaryKeyColumns = getPrimaryKeyColumns();

		com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey key=
			new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ProposalKey();

		key.proposalId=dataRow.getInt(primaryKeyColumns[0]);

		return key;
	}
	/**
	 * getHomeName
	 */
	public String getHomeName() {
		return "Proposal";
	}
	/**
	 * getChunkLength
	 */
	public int getChunkLength() {
		return 128;
	}
	/**
	 * createDataCacheEntry
	 */
	public com.ibm.ws.ejbpersistence.cache.DataCacheEntry createDataCacheEntry() {
		return new com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1.ProposalBeanCacheEntryImpl_8ef9b9cc();
	}
}
