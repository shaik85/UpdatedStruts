package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * SWOBeanPartialUpdateQueryHelper
 */
public class SWOBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"LOCKED_IND = ?, ","DELTA_FETCH_ID = ?, ","ADJUSTMENT_AMT = ?, ","LAST_UPDATED_DATE = ?, ","EXCLUSION_ID = ?, ","BUMP_IND = ?, ","AMDT_START_DATE = ?, ","SWO_NO = ?, ","OLD_CALC_PRICE = ?, ","AMDT_IND = ?, ","ESW_PRICE = ?, ","PLANNED_IND = ?, ","ALT_PRICE_IND = ?, ","REF_SER_NO_DESGMC = ?, ","REF_SERIAL_NO = ?, ","ALT_PRICE = ?, ","CALC_PRICE = ?, ","CUSTOMER_PO_NO = ?, ","PLAN_START_DATE = ?, ","ITEM_CATEGORY = ?, ","SEQUENCE_NO = ?, ","EQUIPMENT_NO = ?, ","SWO_ITEM_NO = ?, ","SALES_DOC_NO = ?, ","SWO_DESC = ?, ","PLAN_END_DATE = ?, ","REQST_DELIVRY_DATE = ?, ","DUPLICATE_DELETED_IND = ?, ","S_S_INDICATOR = ?, ","SERIAL_NO = ?, ","AMDT_END_DATE = ?, ","SWO_ADDED_DATE = ?, ","RE_FETCH_ID = ?, ","SWO_EXT_CNTR_NUM = ?, ","SWO_CNTR_STATUS = ?, ","SWO_CNTR_TYPE = ?, ","ALT_PRICE_UPDATE_IND = ?, ","PLAN_DATE_IND = ?, "};
			boolean isNullablePredicates = true;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.SYSTEMSWO SET ", " WHERE SWO_ID = ?  AND DESG_MACHINE_ID = ? AND SOLD_TO_PARTY_ID = ? AND PROPOSAL_ID = ?", assignmentColumns,901, isNullablePredicates);
			String[] predicateColumns = {"ADJUSTMENT_AMT", "OLD_CALC_PRICE", "ESW_PRICE", "ALT_PRICE", "CALC_PRICE", "SEQUENCE_NO"};
			aTemplate0.setPredicateColumns(predicateColumns,1088);
			int[] dirtyMap = {4,5,6,20,18,15,16,19,21,17,22,23,24,26,25,27,28,36,35,34,33,32,31,30,29,37,39,41,40,38,12,14,13,11,10,8,9,7};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
