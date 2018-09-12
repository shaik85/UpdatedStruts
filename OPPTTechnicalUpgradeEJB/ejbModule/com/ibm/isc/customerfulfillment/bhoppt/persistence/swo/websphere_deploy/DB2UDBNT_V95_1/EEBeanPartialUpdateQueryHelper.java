package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * EEBeanPartialUpdateQueryHelper
 */
public class EEBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"SALES_DOC_NO = ?, ","EE_ITEM_NO = ?, ","SWO_ITEM_NO = ?, ","EE_NO = ?, ","EE_DESC = ?, ","PLAN_START_DATE = ?, ","PLAN_END_DATE = ?, ","REQST_DELIVRY_DATE = ?, ","VALUE_METRIC = ?, ","USE_LEVEL = ?, ","LISC_TYPE = ?, ","ESW_PRICE = ?, ","CALC_PRICE = ?, ","ALT_PRICE = ?, ","BILLING_START_DATE = ?, ","BILLING_END_DATE = ?, ","EXCLUSION_ID = ?, ","SEQUENCE_NO = ?, ","BUMP_ID = ?, ","CHARGE_OPTION = ?, ","CHARGE_OPTION_DESC = ?, ","ALT_PRICE_UPDATE_IND = ?, ","LIST_PRICE = ?, ","PLET_NO = ?, ","S_S_DISCOUNT_PERCENT = ?, "};
			boolean isNullablePredicates = true;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.SYSTEMSWOEE SET ", " WHERE SWOEE_ID = ?  AND SWO_ID = ? AND DESG_MACHINE_ID = ? AND SOLD_TO_PARTY_ID = ? AND PROPOSAL_ID = ?", assignmentColumns,632, isNullablePredicates);
			String[] predicateColumns = {"ESW_PRICE", "CALC_PRICE", "ALT_PRICE", "SEQUENCE_NO", "LIST_PRICE", "S_S_DISCOUNT_PERCENT"};
			aTemplate0.setPredicateColumns(predicateColumns,821);
			int[] dirtyMap = {5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
