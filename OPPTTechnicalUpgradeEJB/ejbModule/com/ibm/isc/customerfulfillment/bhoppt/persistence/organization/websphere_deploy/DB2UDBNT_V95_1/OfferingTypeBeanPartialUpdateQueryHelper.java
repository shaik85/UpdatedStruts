package com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * OfferingTypeBeanPartialUpdateQueryHelper
 */
public class OfferingTypeBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"TVM_ALLOWED = ?, ","SPECIAL_RATE_IND = ?, ","ANNV_CNTR_AMT_IND = ?, ","DURATION = ?, "};
			boolean isNullablePredicates = true;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.OFFERINGTYPE SET ", " WHERE OFFERING_TYPE = ?  AND OFFERING_DESC = ?", assignmentColumns,159, isNullablePredicates);
			String[] predicateColumns = {"DURATION"};
			aTemplate0.setPredicateColumns(predicateColumns,187);
			int[] dirtyMap = {2,3,4,5};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
