/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.util;

/** 
 * Constants of connector module
 *  
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public interface ConnectorConstants
{
	/*constant*/  String DATA_TRANSFER_OBJECT = "DTO";
	/*constant*/  String ID = "id";
	/*constant*/  String MSG_TYPE = "1";

	/*constant*/  String REMOTE_FUNCTION_CALL = "RFC"; /* NOI18N */
	/*constant*/  String NAME = "name"; /* NOI18N */

	/*constant*/  String INPUT_DTO = "InputDTO"; /* NOI18N */
	/*constant*/  String OUTPUT_DTO = "OutputDTO"; /* NOI18N */

	/*constant*/  String DATE_FORMAT = "yyyyMMdd"; /* NOI18N */
	/*constant*/  String TIME_FORMAT = "kkmmss"; /* NOI18N */ // 24H:mm:ss

	/*constant*/  String PACKAGE_SEPARATOR = "."; /* NOI18N */
	/*constant*/  String DATE_DELIMITER = "-"; /* NOI18N */
	/*constant*/  String TIME_DELIMITER = ":"; /* NOI18N */
	/*constant*/  String CONNECTOR_STRING_DELIMITOR = "|"; /* NOI18N */

	/*constant*/  String SERIALZIER = "Object2String"; /* NOI18N */
	/*constant*/  String DESERIALZIER = "String2Object"; /* NOI18N */

	/*constant*/  String RFC_SUCCESS_CODE = "0"; /* NOI18N */

	/*constant*/  String RFC_VALIDATE_HEADER_DATA_OPPT = "Z_WV_VALIDATE_HEADER_DATA_OPPT"; /* NOI18N */
	/*constant*/  String RFC_RETRIEVE_CUSTLIST_OPPT = "Z_FV_RETRIEVE_CUSTLIST_OPPT"; /* NOI18N */
	/*constant*/  String RFC_RETRIEVE_SITEIDLIST_OPPT = "Z_FV_RETRIEVE_SITEIDLIST_OPPT"; /*DAD O02*/
	/*constant*/  String RFC_RETRIEVE_CUSTOMER_OPPT = "Z_FV_RETRIEVE_CUSTOMER_OPPT"; /* NOI18N */
	/*constant*/  String RFC_RETRIEVE_PARTNER_OPPT = "Z_FV_RETRIEVE_PARTNER_OPPT"; /* NOI18N */
	/*constant*/  String RFC_PARTNER_CHECK_OPPT = "Z_FV_PARTNER_CHECK_OPPT"; /* NOI18N */
	/*constant*/  String RFC_RETRIEVE_DETAIL_OPPT = "Z_FV_RETRIEVE_DETAIL_OPPT"; /* NOI18N */
	/*constant*/  String RFC_INELIG_DETAIL_OPPT = "Z_WV_INELIG_DETAIL_OPPT"; /* NOI18N */
	/*constant*/  String RFC_VALIDATE_USER_ACCESS_OPPT = "Z_WV_VALIDATE_USER_ACCESS_OPPT"; /* NOI18N */
	/*constant*/  String RFC_CREATE_CONTRACT_OPPT = "Z_FV_CREATE_CONTRACT_OPPT"; /* NOI18N */
	/*constant*/  String RFC_COMPARE_AUTHOR_OPPT = "Z_WV_COMPARE_AUTHOR_OPPT"; /* NOI18N */
	/*constant*/  String RFC_STATUS_CHECK_OPPT = "Z_FV_STATUS_CHECK_OPPT"; /* NOI18N */
	/*constant*/  String RFC_USERID_MAINT_OPPT = "Z_FV_USERID_MAINT_OPPT"; /* NOI18N */
	/*constant*/  String RFC_VALIDATE_BP_ACCESS_OPPT = "Z_WV_VALIDATE_BP_ACCESS_OPPT"; /* NOI18N */
	/*constant*/  String RFC_CREATE_VAR_OPPT = "Z_WV_CREATE_VAR_OPPT"; /* NOI18N */
	/*constant*/  String RFC_CHECK_VARIANCE_OPPT = "Z_WV_CHECK_VARIANCE_OPPT"; /* NOI18N */
	/*constant*/  String RFC_REFRESH_VARIANCE_OPPT = "Z_WV_REFRESH_VARIANCE_OPPT"; /* NOI18N */
	/*constant*/  String RFC_END_DATE_CONVERT_OPPT = "Z_WV_END_DATE_CONVERT_OPPT"; /* NOI18N */
	
	/*constant*/  String RFC_RETRIEVE_COMPLEX_TYPES_OPPT = "Z_YOTCCM_BLB_INDICATOR_RETR"; /* NOI18N */

	/*constant*/  String RFC_CHANGE_CONTRACT_OPPT = "Z_FV_CHANGE_CONTRACT_OPPT"; /* NOI18N */
	/*constant*/  String RFC_RETRIEVE_DELTA_OPPT = "Z_FV_RETRIEVE_DELTA_OPPT"; /* NOI18N */
	/*constant*/  String RFC_INELIG_DELTA_OPPT = "Z_WV_INELIG_DELTA_OPPT"; /* NOI18N */
	/*constant*/  String RFC_RETRIEVE_USERAUTH_OPPT = "Z_WV_RETRIEVE_USERAUTH_OPPT"; /* NOI18N */

	/*constant*/  String RFC_REFRESH_CURRENCY_OPPT = "Z_FV_REFRESH_CURRENCY_OPPT"; /* NOI18N */
	/*constant*/  String RFC_RETRIEVE_DATE_RULES_OPPT = "Z_WV_RETRIEVE_DATE_RULES_OPPT"; /* NOI18N */
	/*constant*/  String RFC_RETRIEVE_PAYM_TERMS_OPPT = "Z_WV_RETRIEVE_PAYM_TERMS_OPPT"; /* NOI18N */
	/*constant*/  String RFC_RETRIEVE_BILL_BLOCK_OPPT = "Z_WV_RETRIEVE_BILL_BLOCK_OPPT"; /* NOI18N */
	/*constant*/  String RFC_REFRESH_SALES_AREA_OPPT = "Z_FV_REFRESH_SALES_AREA_OPPT"; /* NOI18N */
	/*constant*/  String RFC_COMP_CONTR_IDNT_VALD = "Z_YOTCCM_COMP_CONTR_IDNT_VALD"; /* NOI18N */
	//  String RFC_VALIDATE_COMPLEX_DATA_OPPT = "Z_FV_VALIDATE_COMPLEX_DATA_OPPT"; 

	/*constant*/  String RFC_RETRIEVE_CONFIG_OPPT = "Z_FV_RETRIEVE_CONFIG_OPPT"; /* NOI18N */
	/*constant*/  String RFC_VALIDATE_CONFIG_OPPT = "Z_FV_VALIDATE_CONFIG_OPPT"; /* NOI18N */
	/*constant*/  String RFC_PRICE_INQUIRY_OPPT = "Z_FV_PRICE_INQUIRY_OPPT"; /* NOI18N */
	
	// Added for CR 4520 
	/*constant*/  String RFC_RETRIEVE_SORG_AUTH_OPPT = "Z_WV_RETRIEVE_SORG_AUTH_OPPT"; /* NOI18N */
	/*constant*/  String RFC_BASE_AGREEMENT_CREATE = "Z_WV_BASE_AGREEMENT_CREATE"; /* NOI18N */
	/*constant*/  String RFC_BASE_AGREEMENT_UPDATE = "Z_WV_BASE_AGREEMENT_UPDATE"; /* NOI18N */
	/*constant*/  String RFC_BA_MODIFICATION_CREATE = "Z_WV_BA_MODIFICATION_CREATE"; /* NOI18N */
	/*constant*/  String RFC_BA_MODIFICATION_UPDATE = "Z_WV_BA_MODIFICATION_UPDATE"; /* NOI18N */
	/*constant*/  String DEFAULT_DATE = "00000000"; /* NOI18N */
	
	/*constant*/  String DEFAULT_EXPIRATION_DATE = "99991231"; /* NOI18N */
}
