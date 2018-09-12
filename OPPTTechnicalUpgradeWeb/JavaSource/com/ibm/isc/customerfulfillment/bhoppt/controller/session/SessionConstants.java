/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.session;

/**
 * Constants class that holds all the key values for that will be used in
 * stroing objects into session.
 * 
 * <br/><b>Known Bugs </b> <br/>
 * 
 * <br/>
 * 
 * <PRE>
 * 
 * date Dec 9, 2003
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
public interface SessionConstants {
    /** constant */
    String SESSION_LAST_ACTION_KEY = "lastaction"; /* NOI18N */
    
    /** constant */
    String SESSION_LAST_VIEW_KEY = "lastview"; /* NOI18N */
    
    /** constant */
    String SESSION_LAST_FORM_KEY = "lastform"; /* NOI18N */
    
    /** constant */
    String SESSION_BACK_BUTTON_ALLOWED_KEY = "backbuttonallowed"; /* NOI18N */
    
    /** constant */
    String SESSION_ACTION_DATA_STORE_KEY = "actiondatastore"; /* NOI18N */
    
    /** constant */
    String SESSION_CURRENT_PROCESS_KEY = "currentprocess"; /* NOI18N */
    
    /** constant */
    String SESSION_PROCESS_INITIAL_VIEW_KEY = "processinitialview"; /* NOI18N */
    
    /** constant */
    String SESSION_PROCESS_INITIAL_FORWARD_NAME_KEY = "processinitialforwardname"; /* NOI18N */
    
    /** constant */
    String SESSION_CURRENT_VIEW_KEY = "currentview"; /* NOI18N */
    
    /** constant */
    String SESSION_CURRENT_MESSAGE_VIEW_KEY = "currentmessageview"; /* NOI18N */
    
    /** constant */
    String SESSION_CURRENT_FORWARD = "currentforward"; /* NOI18N */
    
    /** constant */
    String SESSION_USERINFO_KEY = "userinfo"; /* NOI18N */
    
    /** constant */
    String SESSION_FIRST_ACTION_FORWARD_NAME = "firstactionforwardname"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_FORM_DATA = "proposalformdata"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_CREATION_CUSTOMER_LISTS = "customerlists"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_CREATION_CUSTOMERS = "customers"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_CREATION_SELECTED_CUSTOMERS = "selectedcustomers"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_CREATION_PARTNERS = "partnerinformation"; /* NOI18N */
    
    /** constant */
    String NEW_CUSTOMERS_FOR_INVENTORY = "newcustomersforinventory"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_HEADER_ACTION_FORM = "proposalheaderactionform"; /* NOI18N */
    
    /** constant */
    String PRINT_PROPOSAL = "printproposal"; /* NOI18N */
    
    /** constant */
    String CURRENT_PROPOSAL = "currentproposal"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_HEADER = "proposalheader"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_DETAILS = "proposaldetails"; /* NOI18N */
    
    /** constant */
    String USER_PROPOSALS = "userproposals"; /* NOI18N */
    
    /** constant */
    String REGISTER_PROPOSAL = "registerproposal"; /* NOI18N */
    
    /** constant */
    String INELIGIBLE_LICENSES = "ineligiblelicenses"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_CUSTOMERS = "proposalcustomers"; /* NOI18N */
    
    /** constant */
    String QUOTES_LIST = "quoteslist"; /* NOI18N */
    
    /** constant */
    String SWO_DETAILS = "swodetails"; /* NOI18N */
    
    /** constant */
    String CUSTOMER_DETAILS = "customerdetails"; /* NOI18N */
    
    /** constant */
    String ERROR_HISTORY = "errorhistory"; /* NOI18N */
    
    /** constant */
    String SHARE_PROPOSAL = "shareproposal"; /* NOI18N */
    
    /** constant */
    String SS_PLANNING = "ssplanning"; /* NOI18N */
    
    // For confirmation page
    /** constant */
    String SESSION_PROPOSALS_TO_BE_DELETED = "proposalstobedeleted"; /* NOI18N */
    
    /** constant */
    String SESSION_PROPOSAL_TO_BE_RENAMED = "proposaltoberenamed"; /* NOI18N */
    
    /** constant */
    String SESSION_PROPOSAL_TO_BE_COPIED = "proposaltobecopied"; /* NOI18N */
    
    /** constant */
    String SESSION_INVENTIORY_TO_BE_DELETED = "inventorytobedeleted"; /* NOI18N */
    
    /** constant */
    String SESSION_EDIT_INVENTIORY = "editinventory"; /* NOI18N */
    
    //	/** constant */ String SESSION_EDIT_INVENTIORY_CUSTOMER =
    // "editinventorycustomer";  /* NOI18N */
    //	/** constant */ String SESSION_EDIT_INVENTIORY_DM = "editinventorydm";  /* NOI18N */
    //	/** constant */ String SESSION_EDIT_INVENTIORY_SWO = "editinventoryswo";  /* NOI18N */
    /** constant */
    String SESSION_COPY_INVENTIORY_CUSTOMER = "copyinventorycustomer"; /* NOI18N */
    
    /** constant */
    String SESSION_COPY_INVENTIORY_DM = "copyinventorydm"; /* NOI18N */
    
    /** constant */
    String SESSION_COPY_INVENTIORY_SWO = "copyinventoryswo"; /* NOI18N */
    
    /** constant */
    String SESSION_COPY_BUMP_INVENTIORY_DM = "copybumpinventorydm"; /* NOI18N */
    
    /** constant */
    String SESSION_COPY_BUMP_INVENTIORY_SWO = "copybumpinventoryswo"; /* NOI18N */
    
    /** constant */
    String SESSION_CONFIGURE_DM = "configuredm"; /* NOI18N */
    
    /** constant */
    String SESSION_GROUP_LIST_DETAIL = "grouplistdetail"; /* NOI18N */
    
    /** constant */
    String SESSION_USER_LIST_DETAIL = "userlistdetail"; /* NOI18N */
    
    /** constant */
    String SESSION_SINGLE_USER_DETAIL = "singleuserdetail"; /* NOI18N */
    
    /** constant */
    String SESSION_CREATE_USER_DETAIL = "createuserdetail"; /* NOI18N */
    
    /** constant */
    String SESSION_REGISTER_USER_DETAIL = "registeruserdetail"; /* NOI18N */
    
    /** constant */
    String SESSION_SELECTED_USER_DETAIL = "selecteduserdetail"; /* NOI18N */
    
    /** constant */
    String SESSION_SELECTED_BP_USER_DETAIL = "selectedbpuserdetail"; /* NOI18N */
    
    /** constant */
    String SESSION_NON_BP_USER_DETAIL = "nonbpuserdetail"; /* NOI18N */
    
    /** constant */
    String SESSION_TRANSFER_PROPOSAL_DETAIL = "transferproposaldetail"; /* NOI18N */
    
    // For Contract
    /** constant */
    String PROPOSAL_TO_BE_CHANGED = "proposaltobechanged"; /* NOI18N */
    
    /** constant */
    String USER_CONTRACT = "usercontract"; /* NOI18N */
    
    /** constant */
    String USER_ARCHIVE = "userarchive"; /* NOI18N */
    
    /** constant */
    String REPLACE_USER_CONTRACT = "replaceusercontract"; /* NOI18N */
    
    /** constant */
    String SESSION_CONTRACT_TO_BE_COPIED = "contracttobecopied"; /* NOI18N */
    
    /** constant */
    String SESSION_CONTRACT_EXTEND = "contractextend"; /* NOI18N */
    
    /** constant */
    String SESSION_CONTRACT_RENEW = "contractrenew"; /* NOI18N */
    
    /** constant */
    String SESSION_CONTRACT_SIMULATE = "contractsimulatevariance"; /* NOI18N */
    
    /** constant */
    String SESSION_CREATE_VARIANCE = "contractcreatevariance"; /* NOI18N */
    
    /** constant */
    String SESSION_REPLACE_CONTRACT = "replacecontract"; /* NOI18N */
    
    /** constant */
    String SESSION_AMEND_CONTRACT = "amendcontract"; /* NOI18N */
    
    /** constant */
    String SESSION_CLOSE_CONTRACT = "closecontract"; /* NOI18N */
    
    /** constant */
    String CREATE_VARIANCE_PROPOSAL = "createvarianceproposal"; /* NOI18N */
    
    /** constant */
    String VARIANCE_CHECK = "variancecheck"; /* NOI18N */
    
    /** constant */
    String REVERT_PROPOSAL = "revertproposal"; /* NOI18N */
    
    /** constant */
    String SESSION_REGISTER_EXTEND = "sessionregisterextend"; /* NOI18N */
    
    /** constant */
    String SESSION_AMEND_SWO = "sessionamendswo"; /* NOI18N */
    
    //	For reports
    /** constant */
    String SESSION_REPOTRS_PROPOSAL_DETAIL = "reportsproposaldetail"; /* NOI18N */
    
    /** constant */
    String REPORT_VIEW_BEAN = "reportviewbean"; /* NOI18N */
    
    /** constant */
    String REPORT_PROPOSAL_NAME = "reportproposalname"; /* NOI18N */
    
    /** constant */
    String REPORT_REPORT_TYPE = "reportreporttype"; /* NOI18N */
    
    // For Proposal Approver
    /** constant */
    String PROPOSALS_FOR_APPROVAL = "proposalsforapproval"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_TO_BE_APPROVED = "proposaltobeapproved"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_TO_BE_REJECTED = "proposaltoberejected"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_DETAILS_SEARCH_LICENSES = "proposaldetailssearchlicenses"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_DETAILS_SEARCH_STRING = "proposaldetailssearchstring"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_DETAILS_PAGE_INDEX = "proposaldetailspageindex"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_DETAILS_TOTAL_PAGES = "proposaldetailstotalpages"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_DETAILS_MLC_EXCESS = "proposaldetailsmlcexcess"; /* NOI18N */
    
    /** constant */
    String PROPOSAL_DETAILS_MLC_TOTAL_PAGES = "proposaldetailsmlctotalpages"; /* NOI18N */
    
    //	For CR4520
    
    /** constant */
    String SESSION_REVERIFICATION_PROPOSAL_DETAIL = "reverificationproposaldetail"; /* NOI18N */
    
    /** constant */
    String REVERIFICATION_VIEW_BEAN = "reverificationviewbean"; /* NOI18N */
    
    /** constant */
    String REVERIFICATION_SALES_ORG = "reverificationsalesorg"; /* NOI18N */
    
    //CR 2031
    /** constant */
    String DUPLICATE_SERIAL_NUMBERS = "duplicateSerialNumbers"; /* NOI18N */
    
    /** constant */
    String MARKED_FOR_DELETION = "swoMarkedForDeletion"; /* NOI18N */
    /** constant */
    String SEARCH_BASEAGREEMENT_VIEW_BEAN = "searchbaseagreementviewbean"; /* NOI18N */
    /** constant */
    String SESSION_BASE_AGREEMENT_DETAILS = "baseagreementdetailscustomdto"; /* NOI18N */

    /** constant */
    String SESSION_SEARCH_BASE_AGREEMENT = "searchbaseagreementcustomdto"; /* NOI18N */
    /** constant */
    String DISPLAY_MODIFICATION_VIEWBEAN = "displaymodificationviewbean"; /* NOI18N */
    /** constant */
    String SESSION_VIEW_BASE_AGREEMENT = "baseagreementdetailscustomdto"; /* NOI18N */
    /** constant */
    String SESSION_BASEAGREEMENT_ACTIONFORM = "baseagreementactionform"; /* NOI18N */
    /** constant */
    String SESSION_MODIFICATION_ACTIONFORM = "modificationactionform"; /* NOI18N */
    /** constant */
    String SESSION_MODIFICATIONTYPECODE_ACTIONFORM = "modificationtypecodeactionform"; /* NOI18N */
    /** constant */
    String SESSION_SEARCHLIST_ACTIONFORM = "SearchListActionForm"; /* NOI18N */
    /** constant */
    String SESSION_SEARCH_PARAM_ACTIONFORM = "searchparamactionform"; /* NOI18N */
    /** constant */
    String SESSION_BASEAGREEMENT_CUSTOMDTO = "baseagreementcustomdto"; /* NOI18N */
    
    /** constant */
    //String MODIFICATION_TYPECODE_ACTIONFORM = "modificationtypecodeactionform"; /* NOI18N */
    
    /** constant */
    String SESSION_MODIFICATION_TYPECODE = "modificationtypecode"; /* NOI18N */
    /** constant */
    String SESSION_SEARCH_BUTTONS = "searchbuttons"; /* NOI18N */
    
    /** constant */
    String SESSION_AMEND_FLAG = "amendflag"; /* NOI18N */
    /** constant */
    String SESSION_BASEAGREEMENT_MAP="baseagreementmap";/* NOI18N */
    /** constant */
    String SESSION_LEGAL_CONTACT = "legalcontact";
    /** constant */ 
    String SESSION_ACCOUNTING_CONTACT = "accountingcontact";
    /** constant */
    String SESSION_MODIFICATIONADDCONTACT_ACTIONFORM = "modificationaddcontactactionform";
    /** constant */
    String DISPLAY_MODIFICATIONDETAIL_VIEWBEAN = "displaymodificationdetailviewbean"; /* NOI18N */
    
    /** constant */
    String DISPLAY_MODIFICATION_DETAIL_VIEWBEAN = "displaymodificationDetailviewbean"; /* NOI18N */
    /** constant */
    String SESSION_MODIFICATION_TYPES_CUSTOMDTO = "modificationtypescustomdto";
    /** constant */
    String SESSION_MODIFICATION_TYPELIST_VIEWBEAN = "modificationtypelistviewbean"; /* NOI18N */
    /** constant */
    String SESSION_MODIFICATION_TYPE_VIEWBEAN = "modificationtypeviewbean"; /* NOI18N */ 
    /** constant */
    String SESSION_MODIFICATION_OPTIONS_VIEWBEAN = "modificationoptionsiewbean"; /* NOI18N */ 
    /** constant */
    String SESSION_SALESORG_ACTIONFORM = "SalesOrgActionForm"; /* NOI18N */ 
    /** constant */
    String SESSION_MODIFICATION_TYPECODE_ACTIONFORM = "ModificationTypeCodeActionForm"; /* NOI18N */
    /** constant */
    String SESSION_EDITMODIFICATION_OPTION_ACTIONFORM = "EditModificationOptionActionForm"; /* NOI18N */ 
    /** constant */
    String SESSION_ROLE_ACTIONFORM = "RoleActionForm"; /* NOI18N */ 
    /** constant */
    String SESSION_MODIFICATIONCONTACT_ACTIONFORM = "modificationcontactactionform";
    /** constant */
    //For maintenance
    String SESSION_FORM_MAINTENANCE_VIEWBEAN = "formmaintenanceviewbean";
    /** constant */
    String SESSION_FORM_DETAIL_VIEWBEAN = "formdetailviewbean";
    /** constant */
    String SESSION_FORM_TYPECODE = "formtypecodeactionform"; /* NOI18N */
    /** constant */
    String SESSION_FORM_DETAILS_ACTIONFORM = "formdetailsactionform"; /* NOI18N */
    /** constant */
    String SESSION_FORM_DETAILS_CUSTOMDTO = "formdetailscustomdto";
    /** constant */
    String SESSION_FORM_EDIT_FORM_ACTIONFORM = "editformactionform";
    /** constant */
    String SESSION_FORM_SALESORG = "salesorg";
    //String SESSION_FORM_ROLE = "RoleActionForm";
    /** constant */
    String SESSION_EXCEL_VIEWBEAN = "BaseAgreementReportExcelViewBean";
    /** constant */
    String SESSION_FORM_REPORT_VIEWBEAN = "FormReportViewBean";
    /** constant */
    String SESSION_MODTYPE_REPORT_VIEWBEAN = "ModTypeReportViewBean";
    /** constant */
    String SESSION_CCMSCUSTOMER_SELECTION_VIEWBEAN = "CCMSCustomerSelectionViewBean";
    String CUSTOMERS_FOR_PREVIOUS_SITEID ="CustomersForPreviousSiteID";
    /** constant */  //DADO02 Sateesh Anne BlueHarmony
    String RFETCH_SELECTED_INVENTORY = "refetchselectedInventory";
    String SELECTED_INVENTORY = "selectedInventory";
    String CHANGE_PROPOSAL ="changeproposal";
}