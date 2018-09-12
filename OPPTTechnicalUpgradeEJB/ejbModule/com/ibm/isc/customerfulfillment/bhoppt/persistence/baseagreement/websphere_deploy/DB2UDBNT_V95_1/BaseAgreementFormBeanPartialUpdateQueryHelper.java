package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * BaseAgreementFormBeanPartialUpdateQueryHelper
 */
public class BaseAgreementFormBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"FORM_SHORT_DESCRIPTION = ?, ","FORM_LONG_DESCRIPTION = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.FORMNUMBERS SET ", " WHERE FORM_NUMBER = ?  AND SALES_ORG = ?", assignmentColumns,127, isNullablePredicates);
			int[] dirtyMap = {1,2};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
