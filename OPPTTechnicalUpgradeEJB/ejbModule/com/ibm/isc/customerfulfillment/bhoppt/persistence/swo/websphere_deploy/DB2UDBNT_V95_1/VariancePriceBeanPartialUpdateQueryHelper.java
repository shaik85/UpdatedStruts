package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * VariancePriceBeanPartialUpdateQueryHelper
 */
public class VariancePriceBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"SALES_DOC_NO = ?, ","EE_ITEM_NO = ?, ","BILL_PLAN_ST_DATE = ?, ","BILL_PLAN_END_DATE = ?, ","ESW_PRICE = ?, ","CURRENCY = ?, ","INDICATOR = ?, "};
			boolean isNullablePredicates = true;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.TEMPVARPRICE SET ", " WHERE SOLD_TO_PARTY_ID = ?  AND DESG_MACHINE_ID = ? AND SWOEE_ID = ? AND PRICE_ID = ? AND PROPOSAL_ID = ? AND SWO_ID = ?", assignmentColumns,288, isNullablePredicates);
			String[] predicateColumns = {"ESW_PRICE"};
			aTemplate0.setPredicateColumns(predicateColumns,317);
			int[] dirtyMap = {6,7,8,9,10,11,12};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
