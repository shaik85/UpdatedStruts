package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * UserProfileBeanPartialUpdateQueryHelper
 */
public class UserProfileBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"ROLE = ?, ","ASSO_SALES_ORG = ?, ","AUTHORIZATION = ?, ","APPROVER_ID = ?, ","GROUP_NAME = ?, ","BP_ACCESS_INDICATOR = ?, ","LAST_LOGIN_DATE = ?, ","FIRST_NAME = ?, ","LAST_NAME = ?, ","BA_ROLE = ?, ","USER_TYPE = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.USERPROFILE SET ", " WHERE USER_ID = ? ", assignmentColumns,255, isNullablePredicates);
			int[] dirtyMap = {1,2,3,4,5,6,7,8,9,10,11};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
