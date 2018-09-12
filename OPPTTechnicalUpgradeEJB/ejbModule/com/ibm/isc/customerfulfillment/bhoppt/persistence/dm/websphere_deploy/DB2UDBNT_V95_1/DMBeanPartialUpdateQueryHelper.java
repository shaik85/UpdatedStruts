package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * DMBeanPartialUpdateQueryHelper
 */
public class DMBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"DESG_MACHINE_DESC = ?, ","DESG_MACHINE_NO = ?, ","PLAN_START_DATE = ?, ","PLAN_END_DATE = ?, ","PLANNED_IND = ?, ","LAST_UPDATED_DATE = ?, ","DM_ADDED_DATE = ?, ","EXCLUSION_ID = ?, ","DM_COPY_INCR_NO = ?, "};
			boolean isNullablePredicates = true;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.CUSTDESGMACHINE SET ", " WHERE DESG_MACHINE_ID = ?  AND SOLD_TO_PARTY_ID = ? AND PROPOSAL_ID = ?", assignmentColumns,303, isNullablePredicates);
			String[] predicateColumns = {"DM_COPY_INCR_NO"};
			aTemplate0.setPredicateColumns(predicateColumns,338);
			int[] dirtyMap = {3,4,5,6,7,8,9,10,11};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
