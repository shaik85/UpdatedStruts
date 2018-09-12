package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * StatusBeanPartialUpdateQueryHelper
 */
public class StatusBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"STATUS_DESC = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.STATUS SET ", " WHERE STATUS_CODE = ? ", assignmentColumns,64, isNullablePredicates);
			int[] dirtyMap = {1};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
