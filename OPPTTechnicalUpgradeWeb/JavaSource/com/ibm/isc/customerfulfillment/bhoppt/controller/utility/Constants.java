/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.utility;

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
public interface Constants {
	/** constant */
    String STRING_SEPERATOR_PLUS = "+"; /* NOI18N */
    /** constant */
    String STRING_SEPERATOR = "_"; /* NOI18N */

    /** constant */
    String DEFAULT_SELECT = "Select one"; /* NOI18N */

    /** constant */
    String CONFIRMATION_HEADER = "Confirmation messages"; /* NOI18N */

    /** constant */
    String CONFIRMATION_FOOTER = "Are you sure you want to continue?"; /* NOI18N */
    /** constant */
    String CONFIRMATION_INACTIVATE_FOOTER = "Are you sure you want to inactivate the object?"; /* NOI18N */
    /** constant */
    String CONFIRMATION_REACTIVATE_FOOTER = "Are you sure you want to reactivate the object?"; /* NOI18N */
    /** constant */
    String DEFAULT_STRING = ""; /* NOI18N */

    /** constant */
    String NO_INELIGIBLE_LICENSES = "No ineligible license under this catagory."; /* NOI18N */

    /** constant */
    String NO_SWOS_FOR_DM = "No eligible licences found within the contract range for this designated machine."; /* NOI18N */

    /** constant */
    String NO_DMS_FOR_STP = "No eligible licences found within the contract range for this sold-to-party."; /* NOI18N */

    /** constant */
    String NO_ERROR_HISTORY_FOR_PROPOSAL = "No error messages available for this proposal."; /* NOI18N */

    /** constant */
    String NO_ACCESS_HISTORY_FOR_PROPOSAL = "No access history available for this proposal."; /* NOI18N */

    /** constant added by Nomita as a part of activity log */ 
    String NO_ACTIVITY_LOG_FOR_USER = "No access history available for this user."; /* NOI18N */

    /** constant */
    String NO_QUOTES = "No quotes are available."; /* NOI18N */

    /** constant */
    String ALTERNATE_PARTNER_SOLD_TO_PARTY = "soldToParty"; /* NOI18N */

    /** constant */
    String ALTERNATE_PARTNER_SHIP_TO_PARTY = "shipToParty"; /* NOI18N */

    /** constant */
    String ALTERNATE_PARTNER_BILL_TO_PARTY = "billToParty"; /* NOI18N */

    /** constant */
    String ALTERNATE_PARTNER_PAYER = "payer"; /* NOI18N */

    /** constant */
    String ALTERNATE_PARTNER_SOURCE = "Other"; /* NOI18N */

    /** constant */
    String CUSTOMER_SELECTION_ALTERNATE_CUSTOMER = "alternateCustomer"; /* NOI18N */

    /** constant */
    String SKIP_IDENTIFIER = "skip"; /* NOI18N */

    /** constant */
    int SOLD_TO_PARTY = 1; /* NOI18N */

    /** constant */
    int BILL_TO_PARTY = 2; /* NOI18N */

    /** constant */    
    int SHIP_TO_PARTY = 4; /* NOI18N */

    /** constant */
    int PAYER = 3; /* NOI18N */

    /** constant */
    int NINED_PARTNER = 5; /* NOI18N */

    /** constant */
    int PROPOSAL_DETAILS_NORMAL = 1; /* NOI18N */

    /** constant */
    int PROPOSAL_DETAILS_SEARCH = 2; /* NOI18N */

    /** constant */    
    int PROPOSAL_DETAILS_DUPLICATE_SERIAL = 3; /* NOI18N */

    /** constant */
    int CUSTOMER = 1; /* NOI18N */

    /** constant */    
    int DM = 2; /* NOI18N */

    /** constant */    
    int SWO = 3; /* NOI18N */

    /** constant */    
    int PROPOSAL_ADMINISTRATOR = 1; /* NOI18N */

    /** constant */
    int PROPOSAL_APPROVER = 2; /* NOI18N */

    /** constant */    
    int PROPOSAL_CREATE_APPROVER = 3; /* NOI18N */

    /** constant */    
    int ADMINISTRATOR = 4; /* NOI18N */

    int DATA_MIGRATOR = 9; 
    int OPPT_READ =0;
    /**
	 * Read only
	 */
	int READ_ONLY = 1;

	/**
	 * Read limited
	 */
	int READ_LIMITED = 2;

	/**
	 * Create Upadate
	 */
	int CREATE_UPDATE = 3;

	/**
	 * Software User
	 */	
    String SOFTWARE_USER = "S";

    /**
	 * Base agreement user 
	 */    
    String BASE_CONTRACT_USER = "B";
    /**
	 * all Base agreement report 
	 */    
    int BA_REPORT = 1;
    /**
	 * Base agreement report for modification
	 */    
    int BA_REPORT_MODIFICATION = 2;
    /**
	 * Base agreement report by formnumber
	 */    
    int BA_REPORT_FORMNUMBER = 3;
    /**
	 * Base agreement report by modificationtype
	 */    
    int BA_REPORT_MODTYPE = 4;

    String MLC_DESC = "MLC contract only"; /* NOI18N */

    String SNS_DESC = "S&S contract only"; /* NOI18N */

}