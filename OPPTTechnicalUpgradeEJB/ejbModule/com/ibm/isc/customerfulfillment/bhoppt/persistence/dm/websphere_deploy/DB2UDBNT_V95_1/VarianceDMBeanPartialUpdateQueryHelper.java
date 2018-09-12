package com.ibm.isc.customerfulfillment.bhoppt.persistence.dm.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * VarianceDMBeanPartialUpdateQueryHelper
 */
public class VarianceDMBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"DESG_MACHINE_NO = ?, ","DESG_MACHINE_DESC = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.TEMPVARCUSTDESGMACHINE SET ", " WHERE SOLD_TO_PARTY_ID = ?  AND DESG_MACHINE_ID = ? AND PROPOSAL_ID = ?", assignmentColumns,158, isNullablePredicates);
			int[] dirtyMap = {3,4};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
