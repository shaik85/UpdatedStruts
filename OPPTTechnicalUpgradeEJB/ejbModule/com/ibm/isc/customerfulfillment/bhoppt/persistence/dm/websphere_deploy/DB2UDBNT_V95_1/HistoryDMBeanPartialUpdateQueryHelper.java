package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * HistoryDMBeanPartialUpdateQueryHelper
 */
public class HistoryDMBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"DESG_MACHINE_NO = ?, ","DESG_MACHINE_DESC = ?, ","PLAN_START_DATE = ?, ","PLAN_END_DATE = ?, ","PLANNED_IND = ?, ","LAST_UPDATED_DATE = ?, ","DM_ADDED_DATE = ?, ","EXCLUSION_ID = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.HISCUSTDESGMACHINE SET ", " WHERE SOLD_TO_PARTY_ID = ?  AND PROPOSAL_ID = ? AND DESG_MACHINE_ID = ?", assignmentColumns,283, isNullablePredicates);
			int[] dirtyMap = {3,4,5,6,7,8,9,10};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
