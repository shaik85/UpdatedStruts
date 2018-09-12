/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo;

/** 
 * Contains the constants which define the rule names for PropsoalContractBO 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 9, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Arun Nagarajan
 * @version 5.1A 
 */
public interface ProposalContractBOPostCondConstants {
	// Values start with "P" to mark proposal, "C" - Contract and
	// "PC" - Proposal and contract
	public static final String PC_PROPOSAL_CHANGE_PROPADMIN = "P1";
	public static final String PC_PROPOSAL_CHANGE_PROPAPPV = "P2";
	public static final String PC_EASII_PROPOSAL = "P3";
	public static final String PC_OTHERTHANEASII_PROPOSAL = "P4";
	public static final String PC_EAS_PROPOSAL = "P5";
	public static final String PC_TP_PROPOSAL = "P6";
	
	public static final String PC_PROPOSALCONTRACT_CHANGE = "PC1";
	public static final String PC_PROPOSALCONTRACT_STAUS_CHECK = "PC2";	
	public static final String PC_USER_AUTH_FORCHANGE = "PC3";
	public static final String PC_USER_AUTH_FORAPPORREJ = "PC4"; 
	
	public static final String PC_CONTRACT_CHANGE_PROPADMIN = "C1";	
	public static final String PC_CONTRACT_CHANGE_PROPAPPV = "C2";	
	public static final String PC_CONTRACT_EASII_REVERT = "C3";
	public static final String PC_CONTRACT_REVERT_STATE = "C4";
	public static final String PC_CONTRACT_CLOSURE_STATE = "C5";
}
