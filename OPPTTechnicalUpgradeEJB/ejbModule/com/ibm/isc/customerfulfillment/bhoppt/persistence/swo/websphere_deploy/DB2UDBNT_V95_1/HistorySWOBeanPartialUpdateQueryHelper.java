package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * HistorySWOBeanPartialUpdateQueryHelper
 */
public class HistorySWOBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"REQST_DELIVRY_DATE = ?, ","SERIAL_NO = ?, ","PLAN_END_DATE = ?, ","CUSTOMER_PO_NO = ?, ","PLAN_START_DATE = ?, ","ITEM_CATEGORY = ?, ","SEQUENCE_NO = ?, ","EQUIPMENT_NO = ?, ","SWO_ITEM_NO = ?, ","SALES_DOC_NO = ?, ","SWO_DESC = ?, ","CALC_PRICE = ?, ","ALT_PRICE = ?, ","REF_SER_NO_DESGMC = ?, ","REF_SERIAL_NO = ?, ","ALT_PRICE_IND = ?, ","PLANNED_IND = ?, ","ESW_PRICE = ?, ","OLD_CALC_PRICE = ?, ","LAST_UPDATED_DATE = ?, ","SWO_NO = ?, ","EXCLUSION_ID = ?, ","AMDT_IND = ?, ","AMDT_START_DATE = ?, ","BUMP_IND = ?, ","SWO_ADDED_DATE = ?, ","RE_FETCH_ID = ?, ","AMDT_END_DATE = ?, ","SWO_EXT_CNTR_NUM = ?, ","SWO_CNTR_STATUS = ?, ","SWO_CNTR_TYPE = ?, ","ADJUSTMENT_AMT = ?, ","DELTA_FETCH_ID = ?, ","S_S_INDICATOR = ?, ","LOCKED_IND = ?, "};
			boolean isNullablePredicates = true;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.HISSYSTEMSWO SET ", " WHERE SOLD_TO_PARTY_ID = ?  AND DESG_MACHINE_ID = ? AND PROPOSAL_ID = ? AND SWO_ID = ?", assignmentColumns,826, isNullablePredicates);
			String[] predicateColumns = {"SEQUENCE_NO", "CALC_PRICE", "ALT_PRICE", "ESW_PRICE", "OLD_CALC_PRICE", "ADJUSTMENT_AMT"};
			aTemplate0.setPredicateColumns(predicateColumns,1013);
			int[] dirtyMap = {4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,38,37};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
