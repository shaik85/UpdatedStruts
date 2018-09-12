/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;


/**
 * Custom dto that holds basic information about a contract  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 15, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ContractInfoCustomDTO extends OPPTCustomDTO {
	private String proposalName;
	private String proposalType;
	private String contractType;
	private String contractNumber;
	private String externalContractNumber;
	private Date contractPeriodStartDate;
	private Date contractPeriodEndDate;
	
	/**
	 * Returns contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
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
	 * Returns contract period start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getContractPeriodEndDate() {
		return contractPeriodEndDate;
	}

	/**
	 * Returns contract period start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getContractPeriodStartDate() {
		return contractPeriodStartDate;
	}

	/**
	 * Returns contract type value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
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
	 * Returns external contract number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
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
	 * Returns proposal name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
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
	 * Returns proposal type value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
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
	 * Sets contract number
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractNumber 
	 */
	public void setContractNumber(String newContractNumber) {
		contractNumber = newContractNumber;
	}

	/**
	 * Sets contract period end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractPeriodEndDate 
	 */
	public void setContractPeriodEndDate(Date newContractPeriodEndDate) {
		contractPeriodEndDate = newContractPeriodEndDate;
	}

	/**
	 * Sets contract period start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractPeriodStartDate 
	 */
	public void setContractPeriodStartDate(Date newContractPeriodStartDate) {
		contractPeriodStartDate = newContractPeriodStartDate;
	}

	/**
	 * Sets contract type value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractType 
	 */
	public void setContractType(String newContractType) {
		contractType = newContractType;
	}

	/**
	 * Sets external contract number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newExternalContractNumber 
	 */
	public void setExternalContractNumber(String newExternalContractNumber) {
		externalContractNumber = newExternalContractNumber;
	}

	/**
	 * Sets proposal name value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalName 
	 */
	public void setProposalName(String newProposalName) {
		proposalName = newProposalName;
	}

	/**
	 * Sets proposal type value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalType 
	 */
	public void setProposalType(String newProposalType) {
		proposalType = newProposalType;
	}
	
	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 15, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lproposalName 
	 * @param lproposalType 
	 * @param lcontractType 
	 * @param lcontractNumber 
	 * @param lexternalContractNumber 
	 * @param lcontractPeriodStartDate 
	 * @param lcontractPeriodEndDate 
	 */
	public void setData(String lproposalName, String lproposalType, String lcontractType,
						String lcontractNumber, String lexternalContractNumber, 
						Date lcontractPeriodStartDate, Date lcontractPeriodEndDate){
		setProposalName(lproposalName);
		setProposalType(lproposalType);
		setContractType(lcontractType);
		setContractNumber(lcontractNumber);
		setExternalContractNumber(lexternalContractNumber);
		setContractPeriodStartDate(lcontractPeriodStartDate);
		setContractPeriodEndDate(lcontractPeriodEndDate);
	}
}
