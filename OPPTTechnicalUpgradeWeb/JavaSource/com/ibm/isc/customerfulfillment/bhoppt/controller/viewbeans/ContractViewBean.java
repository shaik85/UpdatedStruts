/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.PreparedString;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ContractCustomDTO;

/**
 * Holds the basic information about a contract  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 17, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ContractViewBean extends OPPTViewBean {
	private String id = null;
	private String proposalName = null;
	private String proposalType = null;
	private String proposalContent = null; //Added by Ramesh for DAD003
	private String contractNumber = null;
	private String status = null;
	private String lockedBy = null;
	/* start change CR6153 */
	private String extendPeriod = null;
	/* start change CR6153 */
   //OPPT BH 1.0-DAD001-Srinivas
	private String contractPeriodStartDate = null;
	private String contractPeriodEndDate = null;
	


	
	/**
	 * Retuns the proposal name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
	 * Returns locked by user name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getLockedBy() {
		return lockedBy;
	}

	/**
	 * Returns proposal name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getProposalName() {
		return proposalName;
	}

	/**
	 * Returns proposalType 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getProposalType() {
		return proposalType;
	}

	/** 
	 * Returns the status of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Returns the contract identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getId() {
		return id;
	}

	/* start change CR6153 */
	/**
	 * @return Returns the isExtendPeriod.
	 */
	public String getExtendPeriod() {
		return extendPeriod;
	}
	/* end change CR6153 */
	/**
	 * Sets the contract identifier 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newId String 
	 */
	public void setId(String newId) {
		id = newId;
	}

	/**
	 * Sets the contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
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
	 * Sets the user who locked the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLockedBy String 
	 */
	public void setLockedBy(String newLockedBy) {
		lockedBy = newLockedBy;
	}

	/**
	 * Sets the proposal name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalName String 
	 */
	public void setProposalName(String newProposalName) {
		proposalName = newProposalName;
	}

	/**
	 * Sets the proposal type. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalType String 
	 */
	public void setProposalType(String newProposalType) {
		//proposalType = OPPTStaticDataHolder.getProposalTypeDesc(newProposalType);
		this.proposalType = newProposalType;

	}

	/**
	 * Sets the status of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStatus String 
	 */
	public void setStatus(String newStatus) {
		status = OPPTStaticDataHolder.getProposalStatusDesc(newStatus);
	}
	
	/* start change CR6153 */
	/**
	 * @param isExtendPeriod The isExtendPeriod to set.
	 */
	public void setExtendPeriod(String extendPeriod) {
		this.extendPeriod = extendPeriod;
	}
	/* end change CR6153 */
	/**
	 * Sets the complete data in a single method call.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param id String
	 * @param proposalName String
	 * @param proposalType String
	 * @param contractNumber String
	 * @param status String
	 * @param lockedBy String
	 */
	public void setData(String id, String proposalName, String proposalType, String contractNumber, String status, String lockedBy){
		setId(id);
		setProposalName(proposalName);
		setProposalType(proposalType);
		//setProposalContent(proposalContent);
		setContractNumber(contractNumber);
		setStatus(status);
		setLockedBy(lockedBy);
	}
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(ContractCustomDTO customDTO){
		if(null != customDTO){
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			setId(String.valueOf(customDTO.getId()));
			setProposalName(customDTO.getName());
			setProposalType(customDTO.getType());
			setProposalContent(customDTO.getContent()); //Added by Ramesh DAD003
			ProposalTypeContent(customDTO.getType(),customDTO.getContent());
			setContractNumber(customDTO.getContractNumber());
			setLockedBy(customDTO.getLockedBy());
			/* start change CR6153 */
			setExtendPeriod(customDTO.getExtendPeriod());
			/* end change CR6153 */
			
			 /*  //OPPT BH 1.0-DAD001-Srinivas
			java.util.Date endDate = new java.util.Date(customDTO.getContractPeriodEndDate().getYear(),customDTO.getContractPeriodEndDate().getMonth(),customDTO.getContractPeriodEndDate().getDay()); 
			setContractPeriodEndDate(dateFormat.format(endDate));
			java.util.Date startDate = new java.util.Date(customDTO.getContractPeriodStartDate().getYear(),customDTO.getContractPeriodStartDate().getMonth(),customDTO.getContractPeriodStartDate().getDay());
			setContractPeriodStartDate(dateFormat.format(startDate));
			setStatus(customDTO.getStatus());*/
			
			Date endDate = (customDTO.getContractPeriodEndDate()); 
			setContractPeriodEndDate(dateFormat.format(endDate));
			Date startDate = (customDTO.getContractPeriodStartDate());
			setContractPeriodStartDate(dateFormat.format(startDate));
			setStatus(customDTO.getStatus());
			
			if(null != getStatus()){
				if("VP".equalsIgnoreCase(customDTO.getStatus()) || "VB".equalsIgnoreCase(customDTO.getStatus()) || "CV".equalsIgnoreCase(customDTO.getStatus())){  //$NON-NLS-3$  //$NON-NLS-2$  //$NON-NLS-1$
					StringBuffer buffer = new StringBuffer("{}");  //$NON-NLS-1$
		
					int searchStringLenth = buffer.length();
					int stringLocationIndex = getStatus().indexOf(buffer.toString());
		
					buffer.delete(0, searchStringLenth);
					if (stringLocationIndex > -1)
					{
						buffer.append(getStatus().substring(0, stringLocationIndex));
						buffer.append(String.valueOf(customDTO.getVarianceCount()));
						buffer.append(getStatus().substring(stringLocationIndex + searchStringLenth));
					}
					else{
						buffer.append(getStatus());
					}
					status = buffer.toString();
				}
			}
		}
	}
	
	/**
     * ContractViewBean
     * 
     * @author thirumalai
     */
    public ContractViewBean(){
	}
	/**
     * ContractViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public ContractViewBean(ContractCustomDTO customDTO){
		setData(customDTO);
	}
	
	/**
     * getContractKey
     * 
     * @return
     * @author thirumalai
     */
    public String getContractKey(){
		StringBuffer buffer = new StringBuffer();
		if(null != status){
			buffer.append(status.toUpperCase());
		}
		if(null != proposalName){
			buffer.append(proposalName);
		}
		return buffer.toString();
	}
	
	
	/**
	 * @return Returns the contractPeriodEndDate.
	 */
	
	/**
	 * @return Returns the contractPeriodEndDate.
	 */

	/**
	 * @return Returns the contractPeriodEndDate.
	 */
    
    //OPPT BH 1.0-DAD001-Srinivas
	public String getContractPeriodEndDate() {
		return contractPeriodEndDate;
	}
	/**
	 * @param contractPeriodEndDate The contractPeriodEndDate to set.
	 */
	   //OPPT BH 1.0-DAD001-Srinivas
	public void setContractPeriodEndDate(String contractPeriodEndDate) {
		this.contractPeriodEndDate = contractPeriodEndDate;
	}
	/**
	 * @return Returns the contractPeriodStartDate.
	 */
	   //OPPT BH 1.0-DAD001-Srinivas
	public String getContractPeriodStartDate() {
		return contractPeriodStartDate;
	}
	/**
	 * @param contractPeriodStartDate The contractPeriodStartDate to set.
	 */
	   //OPPT BH 1.0-DAD001-Srinivas
	public void setContractPeriodStartDate(String contractPeriodStartDate) {
		this.contractPeriodStartDate = contractPeriodStartDate;
	}
	/**
	 * @return Returns the proposalContent.
	 */
	public String getProposalContent() {
		return proposalContent;
	}
	/**
	 * @param proposalContent The proposalContent to set.
	 */
	public void setProposalContent(String proposalContent) {
		this.proposalContent = proposalContent;
	}
	public void ProposalTypeContent(String proposaltype, String proposalcontent){
		if (proposaltype .equalsIgnoreCase("ES") && proposalcontent.equalsIgnoreCase("M")){
			proposalType = "MLC";
		}else if(proposaltype.equalsIgnoreCase("ES") && proposalcontent.equalsIgnoreCase("S")){
			proposalType = "S&S";
		}else{
			proposalType = OPPTStaticDataHolder.getProposalTypeDesc(proposalType);
		}
		setProposalType( proposalType);
	}
}
