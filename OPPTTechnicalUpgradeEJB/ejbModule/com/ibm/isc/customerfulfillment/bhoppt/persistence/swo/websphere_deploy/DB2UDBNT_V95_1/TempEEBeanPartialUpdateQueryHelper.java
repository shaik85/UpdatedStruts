package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * TempEEBeanPartialUpdateQueryHelper
 */
public class TempEEBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"SESSIONID = ?, ","SWO_ID = ?, ","SWOEE_ID = ?, ","EE_NO = ?, ","SALES_DOC_NO = ?, ","SWO_ITEM_NO = ?, ","EE_ITEM_NO = ?, ","VALUE_METRIC = ?, ","LISC_TYPE = ?, ","CHARGE_OPTION_DESC = ?, ","USE_LEVEL = ?, ","VALID_IND = ?, ","VALUEMETRIC_TYPE = ?, ","VM = ?, ","LCS = ?, ","CHO = ?, ","UL = ?, ","DEFAULT_FLAG = ?, "};
			boolean isNullablePredicates = true;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.TEMPSYSTEMSWOEE SET ", " WHERE PROPOSAL_ID = ?  AND SOLD_TO_PARTY_ID = ? AND DESG_MACHINE_ID = ?", assignmentColumns,403, isNullablePredicates);
			String[] predicateColumns = {"SWO_ID", "SWOEE_ID"};
			aTemplate0.setPredicateColumns(predicateColumns,457);
			int[] dirtyMap = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
