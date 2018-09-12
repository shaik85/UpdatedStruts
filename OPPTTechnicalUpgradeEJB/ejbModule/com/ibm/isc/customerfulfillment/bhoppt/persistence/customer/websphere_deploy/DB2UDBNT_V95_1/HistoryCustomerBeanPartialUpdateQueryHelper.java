package com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * HistoryCustomerBeanPartialUpdateQueryHelper
 */
public class HistoryCustomerBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"CUSTOMER_LIST_NO = ?, ","LEGACY_SOLD_P_NO = ?, ","SAP_SOLD_TO_P_NO = ?, ","SAP_SOLD_TO_P_NAME = ?, ","BILL_TO_P_NO = ?, ","BILL_TO_P_NAME = ?, ","PAYER_NO = ?, ","PAYER_NAME = ?, ","SHIP_TO_P_NO = ?, ","SHIP_TO_P_NAME = ?, ","PLAN_START_DATE = ?, ","PLAN_END_DATE = ?, ","LAST_UPDATED_DATE = ?, ","PAYER_LNO = ?, ","BILL_TO_P_LNO = ?, ","SHIP_TO_P_LNO = ?, ","SOLD_TO_P_ASNO = ?, ","BILL_TO_P_ASNO = ?, ","PAYER_ASNO = ?, ","SHIP_TO_P_ASNO = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.HISSOLDTOPARTY SET ", " WHERE SOLD_TO_PARTY_ID = ?  AND PROPOSAL_ID = ?", assignmentColumns,506, isNullablePredicates);
			int[] dirtyMap = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,21,20};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
