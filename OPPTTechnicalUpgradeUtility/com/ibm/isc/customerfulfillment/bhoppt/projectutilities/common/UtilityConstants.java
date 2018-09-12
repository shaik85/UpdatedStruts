/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common;

import java.sql.Date;

/**
 * Enter one sentence as a brief description for your class. You can enter more
 * text here (e.g. describe the purpose of the class here).
 * 
 * <br/><b>Known Bugs </b> <br/>
 * 
 * <br/>
 * 
 * <PRE>
 * 
 * date Dec 12, 2003
 * 
 * revision date author reason
 * 
 * </PRE>
 * 
 * <br/>
 * 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public interface UtilityConstants {
    /** constant */
    int PARTNER_SOLD_TO_PARTY = 1;

    /** constant */
    int PARTNER_BILL_TO_PARTY = 2;

    /** constant */
    int PARTNER_PAYER = 3;

    /** constant */
    int PARTNER_SHIP_TO_PARTY = 4;

    /** constant */
    int PARTNER_NINE_D = 5;

    /** constant */
    int GOTO_PAGE = 1;

    /** constant */
    int SEARCH_PAGE = 2;

    /** constant */
    int PRINT_PAGE = 3;

    /** constant */
    int ZERO = 0;

    /** constant */
    int BUSINESSRULE_POST_COND_TYPE = 1;

    /** constant */
    int BUSINESSRULE_PRE_COND_TYPE = 2;

    /** constant */
    int BUSINESSRULE_OTHER_TYPE = 3;

    /** constant */
    String BO_USERID = "BO_UID"; /* NOI18N */

    /** constant */
    String BO_GROUPNAME = "BO_GNAME"; /* NOI18N */

    /** constant */
    String BO_SHARING = "BO_SHNG"; /* NOI18N */

    /** constant */
    String BO_LOCKED_BY = "lockedBy"; /* NOI18N */

    /** constant */
    String BO_ROLE = "role"; /* NOI18N */

    /** constant */
    String BO_SHARING_ID = "BO_SHNGID"; /* NOI18N */

    /** constant */
    String PROPOSAL_TYPE = "PROP_TYPE"; /* NOI18N */

    /** constant */
    String CONTRACT_TYPE = "CNTR_TYPE"; /* NOI18N */

    /** constant */
    String STATUS_CODE = "STATUS_CODE"; /* NOI18N */

    /** constant */
    String RELATED_PNAME_FOR_OVERLAY = "R_PNAME"; /* NOI18N */

    /** constant */
    String CONTRACT_PERIOD_START = "CPSD"; /* NOI18N */

    /** constant */
    String CONTRACT_PERIOD_END = "CPED"; /* NOI18N */

    /** constant */
    Date CONTRACT_EXTEND_DATE = null; /* NOI18N */

    /** constant */
    String CONTRACT_START = "CSD"; /* NOI18N */

    /** constant */
    String CONTRACT_END = "CED"; /* NOI18N */

    /** constant */
    String AMENDMENT_EFFE_DATE = "AMED"; /* NOI18N */

    /** constant */
    String LICENSE_AMEND_START = "LASD"; /* NOI18N */

    /** constant */
    String LICENSE_AMEND_END = "LAED"; /* NOI18N */

    /** constant */
    String CONTRACT_CLS_DATE = "CLSD"; /* NOI18N */

    /** constant */
    String CREATOR_FULL_MODE = "R"; /* NOI18N */

    /** constant */
    String CREATOR_READ_MODE = "F"; /* NOI18N */

    /** constant */
    String SHARED_FULL_MODE = "F"; /* NOI18N */

    /** constant */
    String SHARED_READ_MODE = "R"; /* NOI18N */

    /** constant */
    String SIMULATE_VARIANCE = "S"; /* NOI18N */

    /** constant */
    String CREATE_VARIANCE = "C"; /* NOI18N */

    /** constant */
    String ADMIN_FLAG = "A"; /* NOI18N */

    /** constant */
    String YES = "Y"; /* NOI18N */

    /** constant */
    String NO = "N"; /* NOI18N */

    /** constant */
    String NIL = "NIL"; /* NOI18N */

    /** constant */
    String NULL = "NULL"; /* NOI18N */

    /** constant */
    String OTHER = "OTHER"; /* NOI18N */

    /** constant */
    String INCREMENT = "INCREMENT"; /* NOI18N */

    /** constant */
    String DECREMENT = "DECREMENT"; /* NOI18N */

    /** constant */
    String PLAN_START_DATE = "PSD"; /* NOI18N */

    /** constant */
    String PLAN_END_DATE = "PED"; /* NOI18N */

    /** constant */
    String DM_NO = "DMNo"; /* NOI18N */

    /** constant */
    String DM_DESC = "DMDesc"; /* NOI18N */

    /** constant */
    String DM_ID = "DMId"; /* NOI18N */

    /** constant */
    String SWO_ALTERNATE_PRICE = "SwoAlternatePrice"; /* NOI18N */

    /** constant */
    String NO_INVENTORY_AVAIL_CODE = "29"; /* NOI18N */

    /** constant */
    String NO_FI_INVENTORY_AVAIL_CODE = "FI29"; /* NOI18N */

    /** constant */
    String NO_RE_INVENTORY_AVAIL_CODE = "RE29"; /* NOI18N */

    /** constant */
    String NO_DE_INVENTORY_AVAIL_CODE = "DE29"; /* NOI18N */

    /** constant */
    String NO_FP_INVENTORY_AVAIL_CODE = "FP29"; /* NOI18N */

    /** constant */
    String NO_DEFAULT_CONFIG_AVAIL_CODE = "69"; /* NOI18N */

    /** constant */
    String NO_EE_INFO_AVAIL_CODE = "90"; /* NOI18N */

    /** constant */
    String STATUS = "Status"; /* NOI18N */

    /** constant */
    String EXTERNAL_CNTR_NUM_ASSOCIATED = "EXT_CNTR_NUM_ASSC"; /* NOI18N */

    /** constant */
    String ESW_STATUS_RUN = "RUN"; /* NOI18N */

    /** constant */
    String ESW_STATUS_REPL = "REPL"; /* NOI18N */

    /** constant */
    String ESW_STATUS_RENW = "RENW"; /* NOI18N */

    /** constant */
    String ESW_STATUS_RECL = "RECL"; /* NOI18N */

    /** constant */
    String ESW_STATUS_CLSD = "CLSD"; /* NOI18N */

    /** constant */
    String ESW_STATUS_EXTN = "EXTN"; /* NOI18N */

    /** constant */
    String FETCH_PLAN = "FP"; /* NOI18N */

    /** constant */
    String FETCH_INELIGIBLE = "FI"; /* NOI18N */

    /** constant */
    String CONNECTOR_DTO = "DTO"; /* NOI18N */

    /** constant */
    String TP_ORIGINAL_OR_RENEWAL = "TP_ORG_REN"; /* NOI18N */

    /** constant */
    String TP_CREATION_FLAG = "TP_CREATION_FLAG"; /* NOI18N */

    /** constant */
    String TP_VALID_FLAG = "TP_VALID"; /* NOI18N */

    /** constant */
    String TP_SWO_LIST = "TP_SWO_LIST"; /* NOI18N */

    /** constant */
    String ESW_CONTRACT_STATUS = "RUN"; /* NOI18N */

    /** constant */
    String ESW_EXTENSION_IN_PROGRESS = "EXTN"; /* NOI18N */

    /** constant */
    String MESSAGE_DELIMITER = "{|}"; /* NOI18N */

    /** constant */
    String MESSAGE_VALUE_DELIMITER = "{~}"; /* NOI18N */

    /** constant */
    String PROPOSAL_DETAILS_TOTAL_PAGE = "PD_TOTAL_PAGES"; /* NOI18N */

    /** constant */
    String PROPOSAL_DETAILS_PAGE_INDEX = "PD_PAGE_INDEX"; /* NOI18N */

    /** constant */
    boolean TRUE = true;

    /** constant */
    boolean FALSE = false;

    /** constant */
    String SVCLICENSE_EXIST = "SVCLICENSE_EXIST"; /* NOI18N */

    /** constant */
    String PROPOSAL_APPROVAL = "PROPOSAL_APPROVAL"; /* NOI18N */

    /** constant */
    String CONTRPERIOD_VARNO = "CONTRPERIOD_VARNO"; /* NOI18N */

    /** constant */
    String USER_ROLE = "USER_ROLE"; /* NOI18N */

    /** constant */
    String BPCUSTOMERLIST_ACCESS_TYPE_OPPT = "C"; /* NOI18N */

    /** constant */
    String BPLEGACYNO_ACCESS_TYPE_OPPT = "L"; /* NOI18N */

    /** constant */
    String BPCUSTOMERLIST_ACCESS_TYPE_ESW = "CL"; /* NOI18N */

    /** constant */
    String BPLEGACYNO_ACCESS_TYPE_ESW = "SP"; /* NOI18N */

    /** constant */
    String USER_DELETE = "D"; /* NOI18N */

    /** constant */
    String USER_CREATE = "M"; /* NOI18N */

    /** constant */
    String BPUSER_CREATE_DEFAULT_ACCESS_TYPE = "*"; /* NOI18N */
    
    /** constant */
    String MANDATORY_CHAR = "*"; /* NOI18N */

    /** constant */
    String USER_IN_GROUP = "USER_IN_GROUP"; /* NOI18N */

    /** constant */
    String MLC_PRICE_COND_TYPE = "ZGOA"; /* NOI18N */

    /** constant */
    String VARIANCE_PRICE_COND_TYPE = "ZGVU"; /* NOI18N */

    /** constant */
    String S_AND_S_PRICE_COND_TYPE = "ZGOF"; /* NOI18N */

    /** constant */
    String CUSTOMER_LIST_TYPE = "CL"; /* NOI18N */

    /** constant */
    String BILLING_FREQ_MONTHLY = "M"; /* NOI18N */

    /** constant */
    String BILLING_FREQ_QUARTERLY = "Q"; /* NOI18N */

    /** constant */
    String BILLING_FREQ_SEMIANNUAL = "S"; /* NOI18N */

    /** constant */
    String BILLING_FREQ_ANNUAL = "A"; /* NOI18N */

    /** constant */
    String SWO_QUOTE_FLAG = "SWO_QUOTE_FLAG"; /* NOI18N */

    /** constant */
    String SWO_AMENDED_INDEX = "SWO_AMENDED_INDEX"; /* NOI18N */

    /** constant */
    String SWO_EXCLUDED = "SWO_EXCLUDED"; /* NOI18N */

    /** constant */
    String SWO_FOR_CONTRACT = "SWO_FOR_CONTRACT"; /* NOI18N */

    /** constant */
    String SWO_DELTA_FETCH_INDEX = "SWO_DELTA_FETCH_INDEX"; /* NOI18N */

    /** constant */
    String SWO_REFETCH_LICENSE = "SWO_REFETCH_LICENSE"; /* NOI18N */

    /** constant */
    String SWO_SVC_LICENSE = "SWO_SVC_LICENSE"; /* NOI18N */

    /** constant */
    String SWO_EDITED_LICENSE = "SWO_EDITED_LICENSE"; /* NOI18N */

    /** constant */
    String BUMP_INDICATOR = "BUMP_INDICATOR"; /* NOI18N */

    /** constant */
    String FIRST_BUMP_INDICATOR = "FIRST_BUMP_INDICATOR"; /* NOI18N */

    /** constant */
    String SWO_LOCKED_INDICATOR = "SWO_LOCKED_INDICATOR"; /* NOI18N */

    /** constant */
    String SWO_ALREADY_BILLED = "SWO_ALREADY_BILLED"; /* NOI18N */

    /** constant */
    String DUPLICATE_DELETED_IND = "DUPLICATE_DELETED_IND"; /* NOI18N */

    /** constant */
    int MAIL_PROP_APPV = 1;

    /** constant */
    int MAIL_CNTR_APPV = 2;

    /** constant */
    int MAIL_CLS_CNTR_APPV = 3;

    /** constant */
    int MAIL_PROP_REJECT = 4;

    /** constant */
    int MAIL_CNTR_REJECT = 5;

    // S And S Types allowed
    /** constant */
    String MLC_ONLY = "M"; /* NOI18N */

    /** constant */
    String SANDS_ONLY = "S"; /* NOI18N */

    /** constant */
    String MLC_AND_SANDS = "A"; /* NOI18N */

    // SWO Level
    /** constant */
    String SANDS_IND = "04"; /* NOI18N */

    /** constant */
    String PROPOSAL_DETAILS_EDITABLE = "DETAILS_EDITABLE"; /* NOI18N */

    /** constant */
    String MLC_TOTAL_PAGE = "mlcTotalPage"; /* NOI18N */

    /** constant */
    String MLC_EXCESS = "mlcExcess"; /* NOI18N */

    /** constant */
    String QUOTE_EXIST = "QUOTE"; /* NOI18N */

    /** constant */
    String REQUEST_REJECT = "Reject Request For Approval"; /* NOI18N */

    /** constant */
    String REQUEST_APPROVED = "Approve Request"; /* NOI18N */

    /** constant */
    String GSA_SELECTED = "X"; /* NOI18N */

    /** constant */
    String DETAILED_INVOICE_SELECTED = "D"; /* NOI18N */

    /** constant */
    String ADVANCED_BILLING_SELECTED = "N"; /* NOI18N */
    
    /** constant */
    String S_S_EXTEND_PERIOD = "X"; /* NOI18N */

    /** constant */
    String INVOICE_SUPPRESSION_SELECTED_35 = "F"; /* NOI18N */

    /** constant */
    String INVOICE_SUPPRESSION_SELECTED_NOT_35 = "B"; /* NOI18N */

    /** constant */
    String BO_STATUS_OF_LAST_CONTRACT = "statusOfLastContract"; /* NOI18N */

    /** constant */
    String REGISTRATION_REQUEST = "REGISTRATION_REQUEST"; /* NOI18N */

    /** constant */
    String TP_MESSAGE = "TP_MESSAGE"; /* NOI18N */

    /** constant */
    String NO_CHARGE = "NO CHARGE"; /* NOI18N */
    
    
//	Defect 89 MN 26850037 Japan change for 11 as CBS can only support 11
    /** constant */
	 double MAX_AMOUNT               = 999999999.99;
	 /** constant */
	 double MAX_ANNV_AMOUNT          = 999999999.00;
	 /** constant */
	 double MAX_AMOUNT_FOR_JAPAN     = 99999999999.00;
	 /** constant */
	 double MAX_AMOUNT_FOR_VIETNAM   = 99999999999.00;
	 /** constant */
	 
	 double MIN_AMOUNT_IN_OPPT       = 0.00;
	 /** constant */
	 double MAX_VAR_AMOUNT           = 999999999.99;
	 /** constant */
	 double MAX_VAR_AMOUNT_FOR_JAPAN   = 99999999999.00;
	 /** constant */
	 double MAX_VAR_AMOUNT_FOR_VIETNAM = 99999999999.00;
	 /** constant */
	 
	 
	 double MAX_PERCENT = 999999.99;
	 /** constant */
	 String JAPAN_CURRENCY = "7600|JPY";
	 
	 String VIETNAM_CURRENCY = "0164|VND";

	 //CR5955 - Begin change
	 /** constant */
	 String KOREA_CURRENCY = "0079|KRW";
	 // CR5955 - End change


    /** constant */
    String SOFTWARE_USER = "S";
    
    /** constant */
    String BASE_CONTRACT_USER = "B";

    
    /** constant */
    String SALES_ORG = "Sales organisation";
    /** constant */
    String AGREEMENT_NUMBER = "Agreement number";
    /** constant */
    String FORM_NUMBER = "Form number";
    /** constant */
    String CUSTOMER_NUMBER = "Customer number";
    /** constant */
    String CUSTOMER_NAME = "Customer name";
    /** constant */
    String ENTERPRISE_NUMBER = "Enterprise number";
    /** constant */
    String ENTERPRISE_NAME = "Enterprise name";
    /** constant */
    String FILE_NUMBER = "File number";
    /** constant */
    String COVERAGE_TYPE = "Coverage type";
    /** constant */
    String BRANCH_OFFICE = "Branch office";
    /** constant */
    String CUSTOMER_REPRESENTATIVE = "Customer representative";
    /** constant */
    String IMAGE_REFERENCE_NO = "Image reference number";
    /** constant */
    String IS_ELECTRONIC_SUBMITTER = "Is electronic submitter";
    /** constant */
    String ONE_WAY = "One way";
        /** constant */
    String ACCEPTED_DATE = "Accepted date";
    /** constant */
    String EXPIRATION_DATE = "Expiration date";   
    /** constant */
    String INAC  = "INAC";
    /** constant */
    String LEGACY_CUSTOMER_NUMBER = "Legacy customer number";
    /** constant */
    String LEGAL_CONTACT_HDR = "Legal contact";
    /** constant */
    String ACCOUNTING_CONTACT_HDR = "Accounting contact";
    /** constant */
    String MODIFICATION_TYPE = "Modification type";
    /** constant */
    String BA_STATUS = "Agreement status";
    /** constant */
    String LANGUAGE = "Language";
    /** constant */
    String LEGAL_CONTACT = "Legal contact";
    /** constant */
    String ACCOUNTING_CONTACT = "Accounting contact";
    /** constant */
    String MODIFIED_IBM_LETTERHEAD = "Modified IBM letterhead";
    /** constant */
    String REVENUE_RECOGNITION = "Revenue recognition";
    /** constant */
    String MODIFICATION_DETAILS = "Details";
    /** constant */
    String ROL_OPTIONs = "ROL transfer event";
    /** constant */
    String ROL_STARTDATE = "ROL start date";
    /** constant */
    String ROL_ENDDATE = "ROL end date";
    /** constant */
    String CHANGEDETAILS_VARIETOR = "|";
    
}