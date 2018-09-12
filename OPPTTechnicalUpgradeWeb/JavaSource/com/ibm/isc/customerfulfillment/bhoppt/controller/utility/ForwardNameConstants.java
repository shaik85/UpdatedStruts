/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.utility;

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
 * date Feb 10, 2004
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
public interface ForwardNameConstants {
    // Global action forwards
    /** constant */
    String ACTION_ADMINISTRATOR = "administrator"; /* NOI18N */

    /** constant */
    String ACTION_PROPOSAL_ADMINISTRATOR = "proposaladministrator"; /* NOI18N */

    /** constant */
    String ACTION_PROPOSAL_APPROVER = "proposalapprover"; /* NOI18N */

    /** constant */
    String ACTION_PROPOSAL_CREATE_APPROVER = "createapprover"; /* NOI18N */

    /** constant */
    String ACTION_REGISTER_USER = "registeruser"; /* NOI18N */

    /** constant */
    String ACTION_PROPOSAL_MAINTENANCE = "proposalmaintenanceaction"; /* NOI18N */
    
    /** constant */
    // added for the change DAD O11 Remove approval step,Blue Harmony - by Ramesh
    String ACTION_SUBMIT_REGISTRATION = "submitregistrationaction"; /*added by Ramesh */ 
    
    String ACTION_APPROVE_PROPOSAL = "approveproposalaction"; /*added by Ramesh */ 
    
    String ACTION_SUBMIT_EXTENDED_CONTRACT = "submitextendcontractaction"; /*added by Ramesh */ 

    /** constant */
    String ACTION_CONTRACT_MAINTENANCE = "contractmaintenanceaction"; /* NOI18N */

    /** constant */
    String ACTION_PROPOSALS_FOR_APPROVAL = "proposalsforapprovalaction"; /* NOI18N */

    /** constant */
    String ACTION_USER_MAINTENACE = "usermaintenanceaction"; /* NOI18N */

    /** constant */
    String ACTION_GROUP_MAINTENANCE = "groupmaintenanceaction"; /* NOI18N */

    /** constant */
    String ACTION_CONTRACT_MAINTENANCE_STATUS = "contractmaintenancestatuaction"; /* NOI18N */

    /** constant */
    String ACTION_PROPOSAL_HEADER = "proposalheaderaction"; /* NOI18N */

    /** constant */
    String ACTION_PROPOSAL_DETAILS = "proposaldetailsaction"; /* NOI18N */

    /** constant */
    String ACTION_PROPOSAL_CONTRACT_DETAILS = "proposalcontractdetails"; /* NOI18N */

    /** constant */
    String ACTION_CONTRACT_CHANGE_PROPOSAL = "contractchangeproposal"; /* NOI18N */

    /** constant */
    String ACTION_CHANGE_VARIANCE_PROPOSAL = "changevarianceproposalaction"; /* NOI18N */

    /** constant */
    String ACTION_REFRESH_PROPOSAL_DETAILS = "refreshproposaldetailsaction"; /* NOI18N */

    /** constant */
    String ACTION_REFRESH_PROPOSAL_MAINTENANCE = "refreshproposalmaintenanceaction"; /* NOI18N */

    /** constant */
    String ACTION_REFRESH_PROPOSALS_FOR_APPROVAL = "refreshproposalsforapprovalaction"; /* NOI18N */

    /** constant */
    String ACTION_PRICE_PROPOSAL = "priceproposalaction"; /* NOI18N */

    /** constant */
    String ACTION_FETCH_INVENTORY = "fetchinventoryaction"; /* NOI18N */

    /** constant */
    String ACTION_FETCH_PLANNED_INVENTORY = "fetchplannedinventoryaction"; /* NOI18N */

    /** constant */
    String ACTION_ERROR_HISTORY = "errorhistoryaction"; /* NOI18N */

    /** constant */
    String ACTION_REPORT_GENERATOR = "reportgenerator"; /* NOI18N */

    /** constant */
    String ACTION_CONTRACT_DETAIL = "contractlink"; /* NOI18N */

    /** constant */
    String ACTION_INDEX = "index"; /* NOI18N */

    /** constant */
    String ACTION_PROGRESS = "progress"; /* NOI18N */

    /** constant */
    String ACTION_CLEAR_ALL = "clearAll"; /* NOI18N */

    /** constant */
    String ACTION_CANCEL = "cancel"; /* NOI18N */

    /** constant */
    String ACTION_CANCEL_REGISTER = "cancelRegister"; /* NOI18N */

    // Forward name for proposal administrator - proposal section
    /** constant */
    String PAGE_CREATE_PROPOSAL = "createproposal"; /* NOI18N */

    /** constant */
    String PAGE_PARTNER_DETAILS = "partnerdetails"; /* NOI18N */

    /** constant */
    String PAGE_CHANGE_PROPOSAL = "changeproposal"; /* NOI18N */

    /** constant */
    String PAGE_CHANGE_VARIANCE_PROPOSAL = "changevarianceproposal"; /* NOI18N */

    /** constant */
    String PAGE_CUSTOMER_LIST_SELECTION = "customerlistselection"; /* NOI18N */

    /** constant */
    String PAGE_CUSTOMER_SELECTION = "customerselection"; /* NOI18N */

    /** constant */
    String PAGE_PARTNER_SELECTION = "partnerselection"; /* NOI18N */

    /** constant */
    String PAGE_ALTERNATE_PARTNER = "alternatepartner"; /* NOI18N */

    /** constant */
    String PAGE_PROPOSAL_DETAILS = "proposaldetails"; /* NOI18N */

    /** constant */
    String PAGE_PROPOSAL_HEADER = "proposalheader"; /* NOI18N */

    /** constant */
    String PAGE_VARIANCE_PROPOSAL_HEADER = "varianceproposalheader"; /* NOI18N */

    /** constant */
    String PAGE_PARTNER_INFORMATION = "partnerinformation"; /* NOI18N */

    /** constant */
    String PAGE_PROPOSAL_REGISTRATION = "proposalregistration"; /* NOI18N */

    /** constant */
    String PAGE_CONTRACT_REGISTRATION = "contractregistration"; /* NOI18N */

    /** constant */
    String PAGE_PROPOSAL_MAINTENANCE = "proposalmaintenance"; /* NOI18N */

    /** constant */
    String PAGE_PROPOSAL_SHARING = "proposalsharing"; /* NOI18N */

    /** constant */
    String PAGE_REMOVE_PROPOSAL_SHARING = "removeproposalsharing"; /* NOI18N */

    /** constant */
    String PAGE_PROPOSAL_HISTORY = "proposalhistory"; /* NOI18N */

    /** constant */
    String PAGE_ERROR_HISTORY = "errorhistory"; /* NOI18N */

    /** constant */
    String PAGE_ERROR_DETAILS = "errordetails"; /* NOI18N */

    /** constant */
    String PAGE_SS_PLANNING = "ssplanning"; /* NOI18N */

    /** constant */
    String PAGE_ADD_CUSTOMER = "addcustomer"; /* NOI18N */

    /** constant */
    String PAGE_INVENTORY_DATE_RANGE = "inventorydaterange"; /* NOI18N */

    /** constant */
    String PAGE_INELIGIBLE_LICENSES = "ineligiblelicenses"; /* NOI18N */

    /** constant */
    String PAGE_QUOTES_LIST = "quoteslist"; /* NOI18N */

    /** constant */
    String PAGE_TP_VALIDATION = "tpvalidation"; /* NOI18N */

    /** constant */
    String PAGE_CUSTOMER_DETAILS = "customerdetails"; /* NOI18N */

    /** constant */
    String PAGE_SWO_DETAILS = "swodetails"; /* NOI18N */

    /** constant */
    String PAGE_EDIT_INVENTORY = "editinventory"; /* NOI18N */

    //	/** constant */ String PAGE_EDIT_CUSTOMER = "editcustomer"; /* NOI18N */
    //	/** constant */ String PAGE_EDIT_DM = "editdm"; /* NOI18N */
    //	/** constant */ String PAGE_EDIT_SWO = "editswo"; /* NOI18N */
    /** constant */
    String PAGE_COPY_CUSTOMER = "copycustomer"; /* NOI18N */

    /** constant */
    String PAGE_COPY_DM = "copydm"; /* NOI18N */

    /** constant */
    String PAGE_COPY_SWO = "copyswo"; /* NOI18N */

    /** constant */
    String PAGE_COPY_BUMP_DM = "copybumpdm"; /* NOI18N */

    /** constant */
    String PAGE_COPY_BUMP_SWO = "copybumpswo"; /* NOI18N */

    /** constant */
    String PAGE_CONFIGURE_DM = "configuredm"; /* NOI18N */

    /** constant */
    String PAGE_STATUS_INFORMATION = "statusinformation"; /* NOI18N */

    // Forward name for proposal administrator - contract section
    /** constant */
    String PAGE_CONTRACT_DETAILS = "contractdetails"; /* NOI18N */

    /** constant */
    String PAGE_CONTRACT_HEADER = "contractheader"; /* NOI18N */

    /** constant */
    String PAGE_VARIANCE_CONTRACT_HEADER = "variancecontractheader"; /* NOI18N */

    /** constant */
    String PAGE_CONTRACT_ERROR_HISTORY = "contracterrorhistory"; /* NOI18N */

    /** constant */
    String PAGE_CONTRACT_ERROR_DETAILS = "contracterrordetails"; /* NOI18N */

    /** constant */
    String PAGE_CONTRACT_HISTORY = "contracthistory"; /* NOI18N */

    /** constant */
    String PAGE_CONTRACT_DATE_RANGE = "contractdaterange"; /* NOI18N */

    /** constant */
    String PAGE_CONTRACT_MAINTENANCE = "contractmaintenance"; /* NOI18N */

    /** constant */
    String PAGE_REPLACE_CONTRACT = "replacecontract"; /* NOI18N */

    /** constant */
    String PAGE_RENEW_CONTRACT = "renewcontract"; /* NOI18N */

    /** constant */
    String PAGE_SELECT_REGISTER_USER = "selectregisteruser"; /* NOI18N */

    /** constant */
    String PAGE_CONTRACT_SWO_DETAILS = "contractswodetails"; /* NOI18N */

    /** constant */
    String PAGE_GET_DELTA_FETCH = "getdeltafetch"; /* NOI18N */

    /** constant */
    String PAGE_AMEND_CONTRACT = "amendcontract"; /* NOI18N */

    /** constant */
    String PAGE_COMPARE_TP = "comparetp"; /* NOI18N */

    /** constant */
    String PAGE_EXTEND_CONTRACT = "extendcontract"; /* NOI18N */

    /** constant */
    String PAGE_CLOSE_CONTRACT = "closecontract"; /* NOI18N */

    /** constant */
    String PAGE_AMEND_SWO = "amendswo"; /* NOI18N */

    /** constant */
    String PAGE_EXTEND_CONTRACT_DETAIL = "extendcontractdetail"; /* NOI18N */

    /** constant */
    String PAGE_REPLACE_CREATE_CONTRACT = "replacecreatecontract"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_VARIANCE_CONTRACT = "createvariancecontract"; /* NOI18N */

    /** constant */
    String PAGE_SIMULATE_VARIANCE_CONTRACT = "simulatevariancecontract"; /* NOI18N */

    /** constant */
    String PAGE_CHECK_VARIANCE_STATUS = "checkvariancestatus"; /* NOI18N */

    // Forward name for proposal administrator - reports section
    /** constant */
    String PAGE_REPORTS = "reports"; /* NOI18N */

    /** constant */
    String PAGE_HELP = "help"; /* NOI18N */

    // Forward name for proposals for approval - proposal section
    /** constant */
    String PAGE_PROPOSAL_FOR_APPROVAL_DETAILS = "proposalforapprovaldetails"; /* NOI18N */

    /** constant */
    String PAGE_PROPOSAL_FOR_APPROVAL_HEADER = "proposalforapprovalheader"; /* NOI18N */

    /** constant */
    String PAGE_PROPOSAL_FOR_APPROVAL_VARIANCE_HEADER = "varianceproposalforapprovalheader"; /* NOI18N */

    /** constant */
    String PAGE_PROPOSAL_FOR_APPROVAL_MAINTENANCE = "proposalsforapproval"; /* NOI18N */

    /** constant */
    String PAGE_PROPOSAL_FOR_APPROVAL_REJECTION_REASON = "rejectionreason"; /* NOI18N */

    /** constant */
    String PAGE_PROPOSAL_FOR_APPROVAL_HISTORY = "proposalforapprovalhistory"; /* NOI18N */

    /** constant */
    String PAGE_PROPOSAL_FOR_APPROVAL_REPORTS = "proposalforapprovalreports"; /* NOI18N */

    /** constant */
    String PAGE_PROPOSAL_FOR_APPROVAL_SWO_DETAILS = "proposalforapprovalswodetails"; /* NOI18N */

    // Forward names for proposal create approver - proposal section
    /** constant */
    String PAGE_CREATE_APPROVE_MAINTENANCE = "createapproveproposalmaintenance"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CREATE_PROPOSAL = "createapprovecreateproposal"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_PARTNER_DETAILS = "createapprovepartnerdetails"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CHANGE_PROPOSAL = "createapprovechangeproposal"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CHANGE_VARIANCE_PROPOSAL = "createapprovechangevarianceproposal"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CUSTOMER_LIST_SELECTION = "createapprovecustomerlistselection"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CUSTOMER_SELECTION = "createapprovecustomerselection"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_PARTNER_SELECTION = "createapprovepartnerselection"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_ALTERNATE_PARTNER = "createapprovealternatepartner"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_PROPOSAL_DETAILS = "createapproveproposaldetails"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_PROPOSAL_HEADER = "createapproveproposalheader"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_VARIANCE_PROPOSAL_HEADER = "createapprovevarianceproposalheader"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_PARTNER_INFORMATION = "createapprovepartnerinformation"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_PROPOSAL_REGISTRATION = "createapproveproposalregistration"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CONTRACT_REGISTRATION = "createapprovecontractregistration"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_PROPOSAL_SHARING = "createapproveproposalsharing"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_REMOVE_PROPOSAL_SHARING = "createapproveremoveproposalsharing"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_PROPOSAL_HISTORY = "createapproveproposalhistory"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_ERROR_HISTORY = "createapproveerrorhistory"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_ERROR_DETAILS = "createapproveerrordetails"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_SS_PLANNING = "createapprovessplanning"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_ADD_CUSTOMER = "createapproveaddcustomer"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_INVENTORY_DATE_RANGE = "createapproveinventorydaterange"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_INELIGIBLE_LICENSES = "createapproveineligiblelicenses"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_QUOTES_LIST = "createapprovequoteslist"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_TP_VALIDATION = "createapprovetpvalidation"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CUSTOMER_DETAILS = "createapprovecustomerdetails"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_SWO_DETAILS = "createapproveswodetails"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_EDIT_INVENTORY = "createapproveeditinventory"; /* NOI18N */

    //	/** constant */ String PAGE_CREATE_APPROVE_EDIT_CUSTOMER =
    // "createapproveeditcustomer"; /* NOI18N */
    //	/** constant */ String PAGE_CREATE_APPROVE_EDIT_DM =
    // "createapproveeditdm"; /* NOI18N */
    //	/** constant */ String PAGE_CREATE_APPROVE_EDIT_SWO =
    // "createapproveeditswo"; /* NOI18N */
    /** constant */
    String PAGE_CREATE_APPROVE_COPY_CUSTOMER = "createapprovecopycustomer"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_COPY_DM = "createapprovecopydm"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_COPY_SWO = "createapprovecopyswo"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_COPY_BUMP_DM = "createapprovecopybumpdm"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_COPY_BUMP_SWO = "createapprovecopybumpswo"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CONFIGURE_DM = "createapproveconfiguredm"; /* NOI18N */

    // Forward names for proposal create approver - proposals for approval
    // section
    /** constant */
    String PAGE_CREATE_APPROVE_PROPOSALS_FOR_APPROVAL_MAINTENACE = "createapproveproposalsforapproval"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_PROPOSALS_FOR_APPROVAL_REJECTION_REASON = "createapproverejectionreason"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_PROPOSALS_FOR_APPROVAL_HISTORY = "createapproveproposalforapprovalhistory"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_PROPOSALS_FOR_APPROVAL_DETAILS = "createapproveproposalforapprovaldetails"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_PROPOSALS_FOR_APPROVAL_HEADER = "createapproveproposalforapprovalheader"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_PROPOSALS_FOR_APPROVAL_VARIANCE_HEADER = "createapprovevarianceproposalforapprovalheader"; /* NOI18N */

    // Forward names for proposal create approver - contract section
    /** constant */
    String PAGE_CREATE_APPROVE_CONTRACT_DATE_RANGE = "createapprovecontractdaterange"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CONTRACT_MAINTENANCE = "createapprovecontractmaintenance"; /* NOI18N */
    
    /** constant DAD-001 BlueHarmony Changed by Anand Sugumaran*/
    String PAGE_ARCHIVE_CONTRACT = "archivecontract"; /* NOI18N */
    
    String ARCHIVE_CONTRACT_MAINTENANCE = "archivecontractmaintenance"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CONTRACT_DETAILS = "createapprovecontractdetails"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CONTRACT_HEADER = "createapprovecontractheader"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_VARIANCE_CONTRACT_HEADER = "createapprovevariancecontractheader"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CONTRACT_HISTORY = "createapprovecontracthistory"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CONTRACT_ERROR_HISTORY = "createapprovecontracterrorhistory"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CONTRACT_ERROR_DETAILS = "createapprovecontracterrordetails"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_REPLACE_CONTRACT = "createapprovereplacecontract"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_RENEW_CONTRACT = "createapproverenewcontract"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_SELECT_REGISTER_USER = "createapproveselectregisteruser"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CONTRACT_SWO_DETAILS = "createapprovecontractswodetails"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_GET_DELTA_FETCH = "createapprovegetdeltafetch"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_AMEND_CONTRACT = "createapproveamendcontract"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_COMPARE_TP = "createapprovecomparetp"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_EXTEND_CONTRACT = "createapproveextendcontract"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CLOSE_CONTRACT = "createapproveclosecontract"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_AMEND_SWO = "createapproveamendswo"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_EXTEND_CONTRACT_DETAIL = "createapproveextendcontractdetail"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_REPLACE_CREATE_CONTRACT = "createapprovereplacecreatecontract"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CREATE_VARIANCE_CONTRACT = "createapprovecreatevariancecontract"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_SIMULATE_VARIANCE_CONTRACT = "createapprovesimulatevariancecontract"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_APPROVE_CHECK_VARIANCE_STATUS = "createapprovecheckvariancestatus"; /* NOI18N */

    /** constant */
    String REGISTRATION = "registration"; /* NOI18N */

    // Forward names for proposal create approver - reports section
    /** constant */
    String PAGE_CREATE_APPROVE_REPORTS = "createapprovereports"; /* NOI18N */

    // Forward names for administrator
    /** constant */
    String PAGE_USER_MAINTENACE = "usermaintenance"; /* NOI18N */

    /** constant */
    String PAGE_GROUP_MAINTENANCE = "groupmaintenance"; /* NOI18N */

    /** constant */
    String PAGE_GROUP_LIST = "grouplist"; /* NOI18N */

    /** constant */
    String PAGE_BP_USER = "bpuser"; /* NOI18N */

    /** constant */
    String PAGE_NON_BP_USER = "nonbpuser"; /* NOI18N */

    /** constant */
    String PAGE_ADD_GROUP = "addgroup"; /* NOI18N */

    /** constant */
    String PAGE_CREATE_USER = "createuser"; /* NOI18N */

    /** constant */
    String PAGE_EDIT_BP_USER = "editbpuser"; /* NOI18N */

    /** constant */
    String PAGE_EDIT_NON_BP_USER = "editnonbpuser"; /* NOI18N */

    /** constant */
    String PAGE_RELEASE_PROPOSAL = "releaseproposal"; /* NOI18N */

    /** constant */
    String PAGE_TRANSFER_PROPOSAL = "transferproposal"; /* NOI18N */

    /** constant */
    String PAGE_REGISTER_BP_USER = "registerbpuser"; /* NOI18N */

    /** constant */
    String PAGE_REGISTER_NON_BP_USER = "registernonbpuser"; /* NOI18N */

    // General forwards
    /** constant */
    String PAGE_MESSAGE = "message"; /* NOI18N */

    /** constant */
    String PAGE_ERROR = "error"; /* NOI18N */

    /** constant */
    String PAGE_HOME_PAGE = "homepage"; /* NOI18N */

    /** constant */
    String PAGE_SIGN_IN = "signin"; /* NOI18N */

    /** constant */
    String PAGE_CONFIRMATION = "confirmation"; /* NOI18N */

    /** constant */
    String PAGE_NEW_PROPOSAL_NAME = "newproposalname"; /* NOI18N */

    /** constant */
    String PAGE_INVALID_SESSION = "invalidsession"; /* NOI18N */

    /** constant */
    String PAGE_INVALID_SELECTION = "invalidselection"; /* NOI18N */

    /** constant */
    String PAGE_LOGOUT = "logout"; /* NOI18N */

    /** constant */
    String PAGE_REVERIFICATION_REPORT = "reverificationreport"; /* NOI18N */
   
    //added for contract registration project by Gavaskar Bhojan
    /** constant */
    String PAGE_CREATE_BASEAGREEMENT = "createbaseagreement"; /* NOI18N */
    
    /** constant */
    String PAGE_SEARCH_BASEAGREEMENT = "baseagreementmaintenance"; /* NOI18N */
    
    /** constant */
    String PAGE_FORWARD_SEARCH_BASEAGREEMENT = "baseagreementmaintenanceaction"; /* NOI18N */
       
    /** constant */
    String PAGE_AMEND_BASEAGREEMENT = "amendbaseagreement"; /* NOI18N */
    
    /** constant */
    String PAGE_REFRESH_BASEAGREEMENT = "refreshsearchaction"; /* NOI18N */
    
    /** constant */
    String PAGE_DISPLAY_MODIFICATION = "displaymodification"; /* NOI18N */
    
    /** constant */
    String PAGE_DISPLAY_MODIFICATION_FOR_AMEND = "displaymodificationforamend"; /* NOI18N */
    
    /** constant */
    String PAGE_DISPLAY_MODIFICATION_DETAILS = "displaymodificationdetails"; /* NOI18N */
    
    /** constant */
    String PAGE_DISPLAY_MODIFICATION_DETAILS_FOR_AMEND = "displaymodificationdetailsforamend"; /* NOI18N */
    
    /** constant */
    String PAGE_VIEW_BASEAGREEMENT= "viewbaseagreement"; /* NOI18N */
    
    /** constant */
    String PAGE_VIEW_MODIFICATION_DETAILS= "viewmodificationdetails"; /* NOI18N */
    
    /** constant */
    String PAGE_EDIT_MODIFICATION_DETAILS= "editmodificationdetails"; /* NOI18N */
        
    /** constant */
    String PAGE_VIEW_MODIFICATION_DETAILS_FOR_AMEND= "viewmodificationdetailsforamend"; /* NOI18N */
    
    /** constant */
    String PAGE_EDIT_MODIFICATION_DETAILS_FOR_AMEND= "editmodificationdetailsforamend"; /* NOI18N */
    /** constant */
    String PAGE_REFRESH_DETAILS_MODIFICATION= "refreshmodificationaction"; /* NOI18N */
    /** constant */
    String PAGE_BASEAGREEMENT_CHANGELOG= "baseagreementchangelog"; /* NOI18N */     
    /** constant */
    String PAGE_BASEAGREEMENT_REPORTS= "baseagreementreport"; /* NOI18N */
    /** constant */
    String PAGE_BASEAGREEMENT_CONFIRMATION= "baseagreementconfirmation"; /* NOI18N */
   
    
	/** constant */
    String PAGE_BASEAGREEMENT_REPORTS_ALL= "baseagreementreportsall"; /* NOI18N */
    /** constant */
    String PAGE_BASEAGREEMENT_REPORTS_FORMNUMBER= "baseagreementreportbyformnumber"; /* NOI18N */
    /** constant */
    String PAGE_BASEAGREEMENT_REPORTS_MODTYPE= "baseagreementreportbymodtype"; /* NOI18N */
    /** constant */
    String MODIFICATION_MAINTENANCE= "modificationmaintenance"; /* NOI18N */
    /** constant */
    String PAGE_MODIFICATION_MAINTENANCE= "modificationmaintenanceaction"; /* NOI18N */  
    /** constant */
    String PAGE_REFRESH_MODIFICATION_MAINTENANCE= "refreshmodificationmaintenanceaction"; /* NOI18N */  
    /** constant */
    String PAGE_ADD_MODIFICATION_TYPE= "addmodificationtype"; /* NOI18N */  
    /** constant */
    String PAGE_EDIT_MODIFICATIONTYPE_ACTION= "editmodificationtypeaction"; /* NOI18N */ 
    /** constant */
    String PAGE_EDIT_MODIFICATION_TYPE= "editmodificationtype"; /* NOI18N */ 
    /** constant */
    String PAGE_ADD_MODIFICATION_OPTION= "addmodificationoption"; /* NOI18N */ 
   
    /** constant */
    String PAGE_SAVEEDIT_MODIFICATION_TYPE= "saveeditmodificationtype"; /* NOI18N */ 
    /** constant */
    String PAGE_SAVEADDED_MODIFICATION_TYPE= "saveaddedmodificationtype"; /* NOI18N */ 
    /** constant */
    String PAGE_EDIT_MODIFICATION_OPTIONS= "editmodificationoptions"; /* NOI18N */ 
   
    /** constant */
    String PAGE_BASEAGREEMENT_REPORTS_MOD= "modificationreports"; /* NOI18N */  
    
//  Nayanatara L Pai - Changes begin for Form Maintenance
    /** constant */
    String PAGE_FORM_MAINTENANCE_ACTION= "formmaintenanceaction"; /* NOI18N */
    /** constant */
    String PAGE_FORM_MAINTENANCE = "formmaintenance";
    
    /** constant */
    String PAGE_ADD_FORM = "addform";
    
    /** constant */
    String PAGE_EDIT_FORM = "editform";
    /** constant */
    String PAGE_DISPLAY_FORM_LIST_ACTION= "displayformlistaction";
    //Nayanatara L Pai - Changes end for Form Maintenance
    /** constant */
    String PAGE_CCMSCUSTOMER_FETCH= "ccmscustomerfetch";
    /** constant */
    String PAGE_UNFETCHED_SELECTED_INV= "unfetchdselectedinventoryinput";
    String FETCH_SELECTED_INV= "fetchselectedinventoryinput";
    /** added by Nomita for activity log*/
	String ACTIVITY_LOG="activitylog";
}