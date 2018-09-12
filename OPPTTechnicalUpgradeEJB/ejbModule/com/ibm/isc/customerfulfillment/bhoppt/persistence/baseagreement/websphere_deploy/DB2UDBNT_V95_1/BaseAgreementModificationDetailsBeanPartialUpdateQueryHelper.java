package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * BaseAgreementModificationDetailsBeanPartialUpdateQueryHelper
 */
public class BaseAgreementModificationDetailsBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"LEGAL_CONTACT = ?, ","ACCOUNTING_CONTACT = ?, ","REVENUE_RECOGNITION = ?, ","REFERENCE_TEXT = ?, ","CATEGORY = ?, ","DETAILS = ?, ","CREATED_BY = ?, ","CREATED_DATE = ?, ","CHANGED_BY = ?, ","CHANGED_DATE = ?, ","MODIFICATION_START_DATE = ?, ","MODIFICATION_END_DATE = ?, ","STATUS = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.BAMODIFICATIONDETAILS SET ", " WHERE AGREEMENT_ID = ?  AND MODIFICATION_TYPE_CODE = ?", assignmentColumns,369, isNullablePredicates);
			int[] dirtyMap = {2,3,4,5,6,7,8,9,10,11,12,13,14};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
