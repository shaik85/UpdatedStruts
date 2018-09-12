package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * CustomerListBeanPartialUpdateQueryHelper
 */
public class CustomerListBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"CUSTOMER_LIST_NAME = ?, ","LAST_UPDATE_DATE = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.CUSTOMERLIST SET ", " WHERE PROPOSAL_ID = ?  AND CUSTOMER_LIST_NO = ?", assignmentColumns,126, isNullablePredicates);
			int[] dirtyMap = {2,3};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
