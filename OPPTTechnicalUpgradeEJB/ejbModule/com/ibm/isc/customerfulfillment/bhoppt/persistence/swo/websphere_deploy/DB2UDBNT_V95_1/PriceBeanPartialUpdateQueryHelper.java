package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * PriceBeanPartialUpdateQueryHelper
 */
public class PriceBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"SALES_DOC_NO = ?, ","EE_ITEM_NO = ?, ","BILL_PLAN_ST_DATE = ?, ","BILL_PLAN_END_DATE = ?, ","ESW_PRICE = ?, ","CURRENCY = ?, ","EXCLUSION_ID = ?, ","BILLING_STATUS = ?, ","MONTH_ID = ?, "};
			boolean isNullablePredicates = true;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.PRICE SET ", " WHERE PRICE_ID = ?  AND PROPOSAL_ID = ? AND SWOEE_ID = ? AND SWO_ID = ? AND DESG_MACHINE_ID = ? AND SOLD_TO_PARTY_ID = ?", assignmentColumns,322, isNullablePredicates);
			String[] predicateColumns = {"ESW_PRICE"};
			aTemplate0.setPredicateColumns(predicateColumns,351);
			int[] dirtyMap = {6,7,8,9,10,11,12,13,14};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
