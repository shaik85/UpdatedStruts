/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;
import java.util.TreeMap;

/**
 * Custom dto that holds data required for registering proposal.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 12, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class RegistrationCustomDTO extends OPPTCustomDTO{
	private ProposalCustomDTO proposalDTO = null;
	private String billingFrequency = null;
	private String contractType = null;
	private String contractNumber = null;
	private String externalContractNumber = null;
	private String selectedApproverId = null;
	private String sendContractTo = null;
	private String sendReplyTo = null;
	private TreeMap approverIds = null;
	private Date extensionDate = null;

	private boolean varianceContractClosure = false;
	private Date varianceDate = null;
	private Date conractClosureDate = null;
	
	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getExtensionDate() {
		return extensionDate;
	}

	/** 
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date 
	 */
	public void setExtensionDate(Date date) {
		extensionDate = date;
	}
	/**
	 * Returns collection of approver ids 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getApproverIds() {
		return approverIds;
	}

	/**
	 * Returns billing frequency value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getBillingFrequency() {
		return billingFrequency;
	}

	/**
	 * Returns contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getContractNumber() {
		return contractNumber;
	}

	/**
	 * Returns contract type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getContractType() {
		return contractType;
	}

	/**
	 * Returns external contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getExternalContractNumber() {
		return externalContractNumber;
	}

	/**
	 * Returns proposal information
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalCustomDTO
	 */
	public ProposalCustomDTO getProposalDTO() {
		return proposalDTO;
	}

	/**
	 * Returns selected approver id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedApproverId() {
		return selectedApproverId;
	}

	/**
	 * Returns send contracts to id
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSendContractTo() {
		return sendContractTo;
	}

	/**
	 * Returns send reply to id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSendReplyTo() {
		return sendReplyTo;
	}

	/**
	 * Sets collection of approver ids 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newApproverIds TreeMap 
	 */
	public void setApproverIds(TreeMap newApproverIds) {
		approverIds = newApproverIds;
	}

	/**
	 * Sets billing frequency value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillingFrequency String 
	 */
	public void setBillingFrequency(String newBillingFrequency) {
		billingFrequency = newBillingFrequency;
	}

	/**
	 * Sets contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractNumber String 
	 */
	public void setContractNumber(String newContractNumber) {
		contractNumber = newContractNumber;
	}

	/**
	 * Sets contract type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractType String 
	 */
	public void setContractType(String newContractType) {
		contractType = newContractType;
	}

	/**
	 * Sets external contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newExternalContractNumber String 
	 */
	public void setExternalContractNumber(String newExternalContractNumber) {
		externalContractNumber = newExternalContractNumber;
	}

	/**
     * Sets proposal information
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 12, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newProposalDTO 
     */
	public void setProposalDTO(ProposalCustomDTO newProposalDTO) {
		proposalDTO = newProposalDTO;
	}

	/**
	 * Sets selected approver id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedApproverId String 
	 */
	public void setSelectedApproverId(String newSelectedApproverId) {
		selectedApproverId = newSelectedApproverId;
	}

	/**
	 * Sets send contract to id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSendContractTo String 
	 */
	public void setSendContractTo(String newSendContractTo) {
		sendContractTo = newSendContractTo;
	}

	/**
	 * Sets send reply to value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSendReplyTo String 
	 */
	public void setSendReplyTo(String newSendReplyTo) {
		sendReplyTo = newSendReplyTo;
	}

	/**
	 * Adds to new approver id to collection of approver ids  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param approverId String
	 * @param name
	 */
	public void addApproverId(String approverId, String name){
		if(null != approverId){
			if(null == approverIds){
				approverIds = new TreeMap();
			}
			approverIds.put(approverId, name);
		}
	}

	/**
	 * Returns contract closure date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getConractClosureDate() {
		return conractClosureDate;
	}

	/**
	 * Returns variance date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getVarianceDate() {
		return varianceDate;
	}

	/**
	 * Returns true if the registration is for an variance contract closure registration 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isVarianceContractClosure() {
		return varianceContractClosure;
	}

	/** 
	 * Sets contract closure date value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractClosureDate Date
	 */
	public void setConractClosureDate(Date newContractClosureDate) {
		conractClosureDate = newContractClosureDate;
	}

	/**
	 * Sets variance date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newVarianceDate Date 
	 */
	public void setVarianceDate(Date newVarianceDate) {
		varianceDate = newVarianceDate;
	}

	/**
	 * Sets variance contract closure flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newVarianceContractClosure boolean
	 */
	public void setVarianceContractClosure(boolean newVarianceContractClosure) {
		varianceContractClosure = newVarianceContractClosure;
	}
}