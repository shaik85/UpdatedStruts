/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.util;

/** 
 * Mail message constants
 * 
 *  
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 8, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Prakash Mall
 * @version 5.1A 
 */
public interface MailMessageConstants
{

	/*constant*/ String REGISTRATION_MAIL_SUBJECT = "You have recieved OPPT Proposal ?1 for authorization"; /* NOI18N */
	/*constant*/ String REGISTRATION_MAIL_TEXT =
		" ?1 was submitted to you by ?2 for your authorization. Please access BH-OPPT at ?3 to accept or reject this proposal."; /* NOI18N */
	/*
	 * Fix by Balaji
	 * Defect 6
	 * MN 19769207
	 */

	/*constant*/ String REGISTRATION_USER_MAIL_SUBJECT = "You have received OPPT user-id ?1"; /* NOI18N */
	/*constant*/ String REGISTRATION_USER_MAIL_TEXT =
		"Kindly approve the request for registration to OPPT tool and reply to administrator whose id is in CC    User Name:?1   User Id:?2  User Type:?7 Role:?3  Group:?4  ?5  \nURL of the application is ?6"; /* NOI18N */

	/*constant*/ String USER_CREATION_MAIL_SUBJECT = "UserId : ?1 created for BH-OPPT"; /* NOI18N */
	
	/*constant*/ String USER_DELETION_MAIL_SUBJECT = "BH OPPT UserId deleted : ?1 "; /* NOI18N */
	
	/*constant*/ String USER_CREATION_USER_MAIL_TEXT =
		"Your request for User-Id is complete and ready for use,details as below    User Name:?1   User Id:?2  User Type:?7 Role:?3  Group:?4  ?5  \nURL of the application is ?6"; /* NOI18N */

	/*constant*/ String USER_DELETION_USER_MAIL_TEXT =
		"User Profile of  ?1 has been deleted,details as below\n" +
		"User Name: ?11\n" +
		"User Id: ?2\n" + 
		"User Type: ?3\n" + 
		"Role: ?4 \n" + 
		"Group: ?5\n" +
		"Sales Area: ?7 \n"    +
		"Access Type: ?8 \n"  + 
		
		"Deleted by: ?9\n"   +
		"Deleted time: ?10 \n"    +
		"URL of the application is ?6"; /* NOI18N */

	/*constant*/ String USER_CHANGE_MAIL_SUBJECT = "User Profile : ?1 has been changed"; /* NOI18N */
	/*constant*/ String USER_CHANGE_USER_MAIL_TEXT =
		"Your user profile has been changed,details as below    User Name:?1   User Id:?2  User Type:?7 Role:?3  Group:?4  ?5  \nURL of the application is ?6"; /* NOI18N */

	/*
	 * Fix by Balaji
	 * Defect 6
	 * MN 19769207
	 */
		
	/*constant*/ String PROP_APPROVE_MAIL_SUBJ = "Proposal ?1 is Approved"; /* NOI18N */
	/*constant*/ String PROP_REJECT_MAIL_SUBJ = "Proposal ?1 is Rejected"; /* NOI18N */
	/*constant*/ String CNTR_APPROVE_MAIL_SUBJ = "Contract ?1 is Approved"; /* NOI18N */
	/*constant*/ String CNTR_REJECT_MAIL_SUBJ = "Contract ?1 is Rejected"; /* NOI18N */
	/*constant*/ String PROP_REJECT_MAIL_TEXT = 
		"Proposal ?1 has been Rejected by ?2 for the following Reason: \n" +
		"?3. \n" +
		"You can access your proposal by signing on to BH-OPPT. \n" +
		"?4."; /* NOI18N */
	/*constant*/ String CNTR_REJECT_MAIL_TEXT = 
		"Contract ?1 has been Rejected by ?2 for the following Reason: \n" +
		"?3. \n" +
		"You can access your contract by signing on to BH-OPPT. \n" +
		"?4."; /* NOI18N */
	/*constant*/ String CNTR_CREATE_APPROVE_MAIL_TEXT = "?1 is Approved and sent for Registration, kindly check the status of the proposal/contract. \n" +
		"The details of the proposal/contract are \n" +
		"Contract Number : ?2 \n" +
		"Sold-to-party name : ?3 \n" +
		"Sold-to-party number : ?4 \n" +
		"Contract period dates : ?5 through ?6 \n" +
		"Billing frequency : ?7 \n" +
		"Billing period amount : ?8 \n" +
		"You can access your proposal/contract by signing on to BH-OPPT. \n" +
		"?9"; /* NOI18N */
	/*constant*/ String CNTR_CLS_APPROVE_MAIL_TEXT = "?1 is Approved for closure.Kindly check the status of the contract. \n" +
		"You can access your contract by signing on to BH-OPPT. \n" +
		"?2"; /* NOI18N */
}
