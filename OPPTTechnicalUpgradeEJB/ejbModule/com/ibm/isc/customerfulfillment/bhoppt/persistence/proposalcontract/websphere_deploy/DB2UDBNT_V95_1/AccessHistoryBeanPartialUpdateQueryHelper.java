package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * AccessHistoryBeanPartialUpdateQueryHelper
 */
public class AccessHistoryBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"OPERATION_PERFORMED = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.ACCESSHISTORY SET ", " WHERE USER_ID = ?  AND ACCESS_DATE = ? AND ACCESS_TIME = ? AND SEQ_NO = ? AND PROPOSAL_ID = ?", assignmentColumns,150, isNullablePredicates);
			int[] dirtyMap = {2};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
