package com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * ProposalCountBeanPartialUpdateQueryHelper
 */
public class ProposalCountBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"PROPOSAL_COUNT = ?, "};
			boolean isNullablePredicates = true;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.PROPOSALCOUNT SET ", " WHERE SALES_ORG = ?  AND PROPOSAL_CONTENT = ? AND CUSTOMER_NAME = ?", assignmentColumns,119, isNullablePredicates);
			String[] predicateColumns = {"PROPOSAL_COUNT"};
			aTemplate0.setPredicateColumns(predicateColumns,153);
			int[] dirtyMap = {0};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
