package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * BaseAgreementChangeLogBeanPartialUpdateQueryHelper
 */
public class BaseAgreementChangeLogBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"AGREEMENT_ID = ?, ","CREATED_BY = ?, ","CHANGED_DATE = ?, ","CHANGED_TIME = ?, ","CHANGED_DETAILS = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.BASEAGREEMENTCHANGELOG SET ", " WHERE CHANGE_ID = ? ", assignmentColumns,160, isNullablePredicates);
			int[] dirtyMap = {1,2,3,4,5};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
