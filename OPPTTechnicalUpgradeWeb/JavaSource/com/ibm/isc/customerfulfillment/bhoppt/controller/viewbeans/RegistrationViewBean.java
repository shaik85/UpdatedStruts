/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.*;
import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RegistrationCustomDTO;

/**
 * Holds complete data for the registering proposal view.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class RegistrationViewBean extends ContractInfoViewBean {
	/**
	 * constant
     */
    public static final String REGISTRAION_PROPOSAL = "Proposal";  //$NON-NLS-1$
	/**
	 * constant
     */
    public static final String REGISTRAION_CONTRACT = "Contract";  //$NON-NLS-1$
		
	private String iBillingFrequency = null;
	private String iInitiator = REGISTRAION_PROPOSAL;
	private TreeMap iApproverIds = null;

	private boolean iVarianceContractClosure = false;
	private Date iVarianceDate = null;
	private Date iConractClosureDate = null;

	/**
	 * Returns collection of approver ids for sending the proposal for registration 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getApproverIds() {
		return iApproverIds;
	}

	/**
	 * Returns the billing frequency of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getBillingFrequency() {
		return iBillingFrequency;
	}

	/**
	 * Sets the collection of approver ids for sending the proposal for registration 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newApproverIds TreeMap 
	 */
	public void setApproverIds(TreeMap newApproverIds) {
		iApproverIds = newApproverIds;
	}

	/**
	 * Sets the billing frequency of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillingFrequency String 
	 */
	public void setBillingFrequency(String newBillingFrequency) {
		iBillingFrequency = newBillingFrequency;
	}

	/**
	 * Adds new approver id to the collection of already existing approver ids.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param approverId String
	 */
	public void addApproverId(String approverId){
		if(null != approverId){
			if(null == iApproverIds){
				iApproverIds = new TreeMap();
			}
			iApproverIds.put(approverId, approverId);
		}
	}
	
	/**
	 * Sets complete data in a single method call.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalName
	 * @param proposalType
	 * @param contractType
	 * @param contractNumber
	 * @param externalContractNumber
	 * @param billingFrequency
	 * @param approverIds
	 */
	public void setData(String proposalName, String proposalType, String contractType, String contractNumber,
						String externalContractNumber, String billingFrequency, TreeMap approverIds){
		super.setData(proposalName, proposalType, contractType, contractNumber, externalContractNumber, null, null);
		setBillingFrequency(billingFrequency);
		setApproverIds(approverIds);
	}
	
	/**
     * @param customDTO
     * @author thirumalai
     */
    public void setData(RegistrationCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			ProposalCustomDTO proposal = customDTO.getProposalDTO();
			if(null != proposal){
				setProposalName(proposal.getName());
				setProposalType(proposal.getType());
			}
			setContractType(customDTO.getContractType());
			setContractNumber(customDTO.getContractNumber());
			setExternalContractNumber(customDTO.getExternalContractNumber());
			setBillingFrequency(customDTO.getBillingFrequency());
		//	setApproverIds(getChangedMap(customDTO.getApproverIds()));
			
			setVarianceContractClosure(customDTO.isVarianceContractClosure());
			setConractClosureDate(customDTO.getConractClosureDate());
			setVarianceDate(customDTO.getVarianceDate());
		}
	}
	
	private TreeMap getChangedMap(TreeMap approverId){
		TreeMap newApproverId = new TreeMap();
		Iterator itr = approverId.keySet().iterator();
		Object key;
		while(itr.hasNext()){
			key = itr.next();
			newApproverId.put(approverId.get(key), key);
		}
		
		return newApproverId;
	}

	/**
     * RegistrationViewBean
     * 
     * @param customDTO
     * @param initiator
     * @author thirumalai
     */
    public RegistrationViewBean(RegistrationCustomDTO customDTO, String initiator){
		setData(customDTO);
		setInitiator(initiator);
	}
	/**
     * RegistrationViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public RegistrationViewBean(RegistrationCustomDTO customDTO){
		setData(customDTO);
		setInitiator(REGISTRAION_PROPOSAL);
	}
	/**
     * RegistrationViewBean
     * 
     * @author thirumalai
     */
    public RegistrationViewBean(){
	}

	/**
	 * Returns the registration view initiator 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getInitiator() {
		return iInitiator;
	}

	/**
	 * Sets registration view initiator value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newInitiator String 
	 */
	public void setInitiator(String newInitiator) {
		iInitiator = newInitiator;
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
		return iConractClosureDate;
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
		return iVarianceDate;
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
		return iVarianceContractClosure;
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
		iConractClosureDate = newContractClosureDate;
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
		iVarianceDate = newVarianceDate;
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
		iVarianceContractClosure = newVarianceContractClosure;
	}
	
	/**
     * getSubTitle
     * 
     * @return
     * @author thirumalai
     */
    public String getSubTitle(){
		String subTitle = null;
		
		if(isVarianceContractClosure()){
			subTitle = "Contract closure";  //$NON-NLS-1$
		}
		else{
			subTitle = "Contract registration";  //$NON-NLS-1$
		}
		
		return subTitle;
	}
}
