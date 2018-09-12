package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * VarianceEEBeanPartialUpdateQueryHelper
 */
public class VarianceEEBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"SALES_DOC_NO = ?, ","EE_ITEM_NO = ?, ","SWO_ITEM_NO = ?, ","EE_NO = ?, ","EE_DESC = ?, ","VALUE_METRIC = ?, ","USE_LEVEL = ?, ","LISC_TYPE = ?, ","ESW_PRICE = ?, ","SEQUENCE_NO = ?, ","CHARGE_OPTION = ?, ","CHARGE_OPTION_DESC = ?, "};
			boolean isNullablePredicates = true;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.TEMPVARSYSTEMSWOEE SET ", " WHERE SOLD_TO_PARTY_ID = ?  AND DESG_MACHINE_ID = ? AND SWOEE_ID = ? AND PROPOSAL_ID = ? AND SWO_ID = ?", assignmentColumns,360, isNullablePredicates);
			String[] predicateColumns = {"ESW_PRICE", "SEQUENCE_NO"};
			aTemplate0.setPredicateColumns(predicateColumns,420);
			int[] dirtyMap = {5,6,7,8,9,10,11,12,13,14,15,16};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
