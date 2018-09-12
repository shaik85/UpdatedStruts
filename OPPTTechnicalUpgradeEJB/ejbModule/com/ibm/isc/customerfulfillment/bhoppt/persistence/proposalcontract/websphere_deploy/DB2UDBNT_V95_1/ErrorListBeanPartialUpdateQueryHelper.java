package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * ErrorListBeanPartialUpdateQueryHelper
 */
public class ErrorListBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"PROPOSAL_ID = ?, ","MSG_NO = ?, ","CLASS_NAME = ?, ","METHOD_NAME = ?, ","MSG_DESC = ?, ","MSG_DETAIL = ?, ","USER_ID = ?, ","DATE = ?, ","TIME = ?, "};
			boolean isNullablePredicates = true;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.ERRORLIST SET ", " WHERE MESSAGE_ID = ? ", assignmentColumns,190, isNullablePredicates);
			String[] predicateColumns = {"PROPOSAL_ID", "MSG_NO"};
			aTemplate0.setPredicateColumns(predicateColumns,247);
			int[] dirtyMap = {1,2,3,4,5,6,7,8,9};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
