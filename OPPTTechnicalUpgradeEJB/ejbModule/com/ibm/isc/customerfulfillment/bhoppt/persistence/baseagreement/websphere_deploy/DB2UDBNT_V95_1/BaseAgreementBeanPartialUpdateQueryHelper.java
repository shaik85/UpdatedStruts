package com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.websphere_deploy.DB2UDBNT_V95_1;

import com.ibm.ws.ejbdeploy.JOPPTTechnicalUpgradeEJB.DB2UDBNT_V95_1.RdbRuntimeUpdateTemplate;

/**
 * BaseAgreementBeanPartialUpdateQueryHelper
 */
public class BaseAgreementBeanPartialUpdateQueryHelper {
	/**
	 * getUpdateTemplates
	 */
	static java.util.List getUpdateTemplates() {
		java.util.List result = new java.util.ArrayList(1);
		{
			String[] assignmentColumns = {"AGREEMENT_NUMBER = ?, ","FORM_NUMBER = ?, ","LEGACY_CUSTOMER_NUMBER = ?, ","INAC = ?, ","EXPIRATION_DATE = ?, ","CHANGED_DATE = ?, ","CHANGED_BY = ?, ","ONE_WAY = ?, ","IS_ELECTRONIC_SUBMITTER = ?, ","IMAGE_REFERENCE_NUMBER = ?, ","CUSTOMER_REPRESENTATIVE = ?, ","BRANCH_OFFICE = ?, ","COVERAGE_TYPE = ?, ","FILE_NUMBER = ?, ","LEGAL_CONTACT_HDR = ?, ","ACCOUNTING_CONTACT_HDR = ?, ","SALES_ORG = ?, ","ACCEPTED_DATE = ?, ","CREATED_BY = ?, ","CREATED_DATE = ?, ","IS_MODIFIED_AGGREEMENT = ?, ","SIGN_CUSTOMER_NUMBER = ?, ","SIGN_CUSTOMER_NAME = ?, ","ACTUAL_AGREEMENT_TITLE = ?, ","STATUS_CODE = ?, ","AGREEMENT_IDENTIFIER1 = ?, ","LEGACY_CC = ?, "};
			boolean isNullablePredicates = false;
			RdbRuntimeUpdateTemplate aTemplate0 = new RdbRuntimeUpdateTemplate(" UPDATE BH.BASEAGREEMENT SET ", " WHERE AGREEMENT_ID = ? ", assignmentColumns,677, isNullablePredicates);
			int[] dirtyMap = {1,2,25,24,23,22,21,18,9,16,15,11,14,17,26,27,20,8,7,5,12,4,19,13,10,3,6};
			aTemplate0.cmpFieldMap(dirtyMap);
			result.add(aTemplate0);
		}
		 return result;
	}
}
