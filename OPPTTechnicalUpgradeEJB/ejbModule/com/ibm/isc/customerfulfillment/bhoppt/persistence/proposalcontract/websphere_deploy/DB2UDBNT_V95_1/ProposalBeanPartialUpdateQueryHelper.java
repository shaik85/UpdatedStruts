package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * ProposalBeanPartialUpdateQueryHelper
 */
public class ProposalBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"ADD_VALUE_DAYS = ?, ","ADVANCE_BILLING = ?, ","AMDT_IND = ?, ","AMDT_EFFC_DATE = ?, ","APPROVED_BY = ?, ","PROPOSAL_TYPE = ?, ","BILLING_FREQ_CODE = ?, ","CREATED_BY = ?, ","STATUS_CODE = ?, ","SALES_ORG = ?, ","DSTR_CHANNEL = ?, ","DIVISION_CODE = ?, ","PROPOSAL_NAME = ?, ","CNTR_START_DATE = ?, ","CNTR_END_DATE = ?, ","CNTR_START_PERIOD = ?, ","CNTR_END_PERIOD = ?, ","TVM_RATE = ?, ","GROWTH_FACTOR = ?, ","SPECIAL_RATE = ?, ","INVOICE_AMOUNT = ?, ","DATE_PRICED = ?, ","COMMENTS = ?, ","CREATED_DATE = ?, ","APPROVED_DATE = ?, ","DELETED_IND = ?, ","REG_SOLD_TO_P_NO = ?, ","REG_SOLD_TO_P_NAME = ?, ","REG_BILL_TO_P_NO = ?, ","REG_BILL_TO_P_NAME = ?, ","REG_PAYER_NO = ?, ","REG_PAYER_NAME = ?, ","REG_SHIP_TO_P_NO = ?, ","REG_SHIP_TO_P_NAME = ?, ","CURRENCY = ?, ","LAST_UPDATE_DATE = ?, ","RE_FETCH_ID = ?, ","FETCH_DATE = ?, ","DELTA_FETCH_ID = ?, ","CNTR_TYPE = ?, ","REPORT_NAME = ?, ","CAP_AMOUNT = ?, ","CAP_PLUS = ?, ","CAP_MINUS = ?, ","PRE_TVM = ?, ","CNTR_EXTN_DATE = ?, ","CNTR_RETR_DATE = ?, ","CNTR_REPL_DATE = ?, ","CNTR_CLS_DATE = ?, ","CNTR_NUMBER = ?, ","CNTR_AMDT_NO = ?, ","REG_SOLD_TO_P_LNO = ?, ","REG_BILL_TO_P_LNO = ?, ","REG_PAYER_LNO = ?, ","REG_SHIP_TO_P_LNO = ?, ","INVOICE_AMOUNT_SEM = ?, ","INVOICE_AMOUNT_ANN = ?, ","INVOICE_AMOUNT_MON = ?, ","INVOICE_AMOUNT_QRT = ?, ","OLD_CNTR_NUMBER = ?, ","PRE_TVM_INV_AMT = ?, ","PROPOSAL_SHARING = ?, ","EXT_CNTR_NUMBER = ?, ","CNTR_CREATE_FLAG = ?, ","PAK_ID = ?, ","BILLING_TYPE = ?, ","PAYMENT_TERM = ?, ","FIXED_VAL_DATE = ?, ","TP_CNTR_NUMBER = ?, ","INELIGIBLE_IND = ?, ","INVOICE_IND = ?, ","AUTOPOPULATE_IND = ?, ","CCI_IND = ?, ","PREBILL_INDICATOR = ?, ","BLB_INDICATOR = ?, ","CONTRACT_TYPE = ?, ","OCPS = ?, ","CPS = ?, ","S_S_DISCOUNT_AMOUNT5 = ?, ","S_S_DISCOUNT_AMOUNT4 = ?, ","S_S_DISCOUNT_AMOUNT3 = ?, ","S_S_DISCOUNT_AMOUNT2 = ?, ","S_S_DISCOUNT_AMOUNT1 = ?, ","S_S_ANNV_AMOUNT5 = ?, ","S_S_ANNV_AMOUNT4 = ?, ","S_S_ANNV_AMOUNT3 = ?, ","S_S_ANNV_AMOUNT2 = ?, ","S_S_EXTEND_CNTR_IND = ?, ","GROUP_NAME = ?, ","SUBMITTED_BY = ?, ","PROPOSAL_CONTENT = ?, ","S_S_DISCOUNT_SUM = ?, ","S_S_ANNV_AMOUNT = ?, ","REG_9D_PARTNER_NO = ?, ","REG_9D_PARTNER_NAME = ?, ","CUM_VALUE = ?, ","CAP_VARIANCE = ?, ","ORG_VAR_CNTR_NUMBER = ?, ","VAR_DATE = ?, ","VAR_IND = ?, ","REG_SOLD_TO_P_ASNO = ?, ","REG_BILL_TO_P_ASNO = ?, ","REG_PAYER_ASNO = ?, ","REG_SHIP_TO_P_ASNO = ?, ","SUPPRESS_INVOICE = ?, ","ESW_FETCH_DATE = ?, ","ESW_FETCH_TIME = ?, ","GSA_IND = ?, ","FREE_TEXT = ?, ","LOCKED_BY = ?, ","LOCKED_ON = ?, ","PO_NUMBER = ?, ","PO_DATE = ?, ","ANNV_AMOUNT = ?, ","CNTR_NEWRENEW_NO = ?, ","BILLING_BLOCK = ?, ","CNTR_PERIOD_VAR_NO = ?, ","CNTR_VAR_NO = ?, ","DEVIATING_DATE_RULE = ?, ","S_S_EXCLUDED = ?, ","CNTR_REPL_NO = ?, ","FIN_CNTR_NO = ?, ","SALES_GROUP = ?, ","CHANNEL_ROLE = ?, ","SUBMITTER_ROLE = ?, ","PAYMENTMETHOD = ?, ","DISCOUNT = ?, "};
			boolean isNullablePredicates = true;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.PROPOSAL SET ", " WHERE PROPOSAL_ID = ? ", assignmentColumns,2759, isNullablePredicates);
			String[] predicateColumns = {"ADD_VALUE_DAYS", "TVM_RATE", "GROWTH_FACTOR", "SPECIAL_RATE", "INVOICE_AMOUNT", "CAP_AMOUNT", "CAP_PLUS", "CAP_MINUS", "PRE_TVM", "CNTR_AMDT_NO", "INVOICE_AMOUNT_SEM", "INVOICE_AMOUNT_ANN", "INVOICE_AMOUNT_MON", "INVOICE_AMOUNT_QRT", "PRE_TVM_INV_AMT", "S_S_DISCOUNT_AMOUNT5", "S_S_DISCOUNT_AMOUNT4", "S_S_DISCOUNT_AMOUNT3", "S_S_DISCOUNT_AMOUNT2", "S_S_DISCOUNT_AMOUNT1", "S_S_ANNV_AMOUNT5", "S_S_ANNV_AMOUNT4", "S_S_ANNV_AMOUNT3", "S_S_ANNV_AMOUNT2", "S_S_DISCOUNT_SUM", "S_S_ANNV_AMOUNT", "CUM_VALUE", "CAP_VARIANCE", "ANNV_AMOUNT", "CNTR_NEWRENEW_NO", "CNTR_PERIOD_VAR_NO", "CNTR_VAR_NO", "CNTR_REPL_NO", "DISCOUNT"};
			aTemplate0.setPredicateColumns(predicateColumns,3925);
			int[] dirtyMap = {0,1,3,2,6,66,9,31,92,89,39,40,63,29,25,30,26,95,47,91,50,35,15,32,7,36,78,77,74,73,82,81,86,85,34,52,68,44,37,23,87,11,13,12,62,18,22,21,17,19,16,76,72,80,84,90,4,54,67,55,61,65,43,24,58,10,59,45,94,49,51,122,121,120,119,118,117,116,115,114,113,112,111,110,109,108,107,106,105,104,103,102,101,70,69,33,14,57,96,97,75,71,79,83,93,41,42,48,46,53,98,60,56,5,20,8,27,28,38,88,99,100,123,124,125,126,127};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
