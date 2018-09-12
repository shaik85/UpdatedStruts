/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.utility;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;

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
 * date Dec 24, 2003
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
public interface ConfirmationConstants {
    /** Confirmation constant */
    String CREATE_PROPOSAL = ActionNameConstants.CREATE_PROPOSAL; /* NOI18N */

    /** Confirmation constant */
    String CHANGE_PROPOSAL_HEADER = ActionNameConstants.CHANGE_PROPOSAL; /* NOI18N */

    /** Confirmation constant */
    String DELETE_PROPOSALS = ActionNameConstants.DELETE_PROPOSAL; /* NOI18N */
    
    String DELETE_ARCHIVE = ActionNameConstants.ARCHIVE_CONTRACT; /* NOI18N */

    /** Confirmation constant */
    String DELETE_INVENTORY = ActionNameConstants.DELETE_INVENTORY; /* NOI18N */

    /** Confirmation constant */
    String REMOVE_SVC_LICENSES = ActionNameConstants.REMOVE_SVC_LICENSES; /* NOI18N */

    /** Confirmation constant */
    String CANCEL_CONFIGURE_DM = ActionNameConstants.CANCEL_CONFIGURE_DM; /* NOI18N */

    /** Confirmation constant */
    String APPROVE_PROPOSAL = ActionNameConstants.APPROVE_PROPOSAL; /* NOI18N */

    /** Confirmation constant */
    String REVERT_PROPOSAL = ActionNameConstants.REVERT_PROPOSAL; /* NOI18N */

    /** Confirmation constant */
    String REMOVE_QUOTES = ActionNameConstants.REMOVE_QUOTES; /* NOI18N */
    /** Confirmation constant */
    String INACTIVE_MODIFICATION_DETAILS = ActionNameConstants.INACTIVE_MODIFICATION; /* NOI18N */
    /** Confirmation constant */
    String CONFIRM_REACTIVE_ACTION = ActionNameConstants.CONFIRM_REACTIVE_ACTION; /* NOI18N */
   
    /** Confirmation constant */
    String CONFIRM_INACTIVATE = ActionNameConstants.CONFIRM_INACTIVATE; /* NOI18N */
    //Nayanatara L Pai - Form Maintenance - Begin changes
    /** Confirmation constant */
    String CONFIRM_DELETE_FORM_ACTION = ActionNameConstants.CONFIRM_DELETE_FORM_ACTION;
    //Nayanatara L Pai - Form Maintenance - End changes

    
//  Tapan Malhotra  - Begin changes
    /** Confirmation constant */
    String APPLYTOALL_MODIFICATION = ActionNameConstants.APPLYTOALL_MODIFICATION;
    /** Confirmation constant */
    String ADD_CONTACT_MODIFICATION = ActionNameConstants.ADD_CONTACT_MODIFICATION;
    /** Confirmation constant */
    String CONFIRM_REACTIVATE_MODIFICATION = ActionNameConstants.REACTIVATE_MODIFICATION_DETAILS;

    
    //Tapan malhotra  - End changes


}
