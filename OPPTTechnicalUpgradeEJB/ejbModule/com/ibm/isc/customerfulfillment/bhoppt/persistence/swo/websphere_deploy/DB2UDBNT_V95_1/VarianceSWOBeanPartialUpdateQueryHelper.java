package com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * VarianceSWOBeanPartialUpdateQueryHelper
 */
public class VarianceSWOBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"SWO_NO = ?, ","SALES_DOC_NO = ?, ","SWO_DESC = ?, ","SWO_ITEM_NO = ?, ","SEQUENCE_NO = ?, ","ITEM_CATEGORY = ?, ","SERIAL_NO = ?, ","CUSTOMER_PO_NO = ?, ","EQUIPMENT_NO = ?, ","ESW_PRICE = ?, ","REF_SERIAL_NO = ?, ","REF_SER_NO_DESGMC = ?, "};
			boolean isNullablePredicates = true;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.TEMPVARSYSTEMSWO SET ", " WHERE SOLD_TO_PARTY_ID = ?  AND DESG_MACHINE_ID = ? AND PROPOSAL_ID = ? AND SWO_ID = ?", assignmentColumns,350, isNullablePredicates);
			String[] predicateColumns = {"SEQUENCE_NO", "ESW_PRICE"};
			aTemplate0.setPredicateColumns(predicateColumns,410);
			int[] dirtyMap = {4,5,6,7,8,9,10,11,12,13,14,15};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
