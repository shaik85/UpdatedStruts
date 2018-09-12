/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ReplaceContractCustomDTO;

/**
 * Hold information about contract replacement view  
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
public class ContractReplacementViewBean extends ContractInfoViewBean { 
	
	private Date replacementDate = null;
	
	private ArrayList yearList =null;
	
	/*start change CR6153*/
	private String isExtendPeriod ;
	private String proposalContent;
	private Date contractStartDate = null;
	private Date contractEndDate = null;	
	/*end change CR6153*/
	
	/**
     * ContractReplacementViewBean
     * 
     * @author thirumalai
     */
    public ContractReplacementViewBean(){
	}
	
	
	/**
     * ContractReplacementViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public ContractReplacementViewBean(ReplaceContractCustomDTO customDto){
		populateBean(customDto);
	}
	/**
	 * Returns the contract replacement date. 
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
	 * @return Date 
	 */
	public Date getReplacementDate() {
		return replacementDate;
	}

	/**
	 * Sets the contract replacement date. 
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
	 * @param newReplacementDate Date 
	 */
	public void setReplacementDate(Date newReplacementDate) {
		replacementDate = newReplacementDate;
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
	 * date Jan 14, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public ArrayList getYearList() {
		return yearList;
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
	 * date Jan 14, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
	public void setYearList(ArrayList list) {
		yearList = list;
	}

	/*start change CR6153*/
	/**
	 * @return Returns the isExtendPeriod.
	 */
	public String isExtendPeriod() {
		return isExtendPeriod;
	}
	/**
	 * @param isExtendPeriod The isExtendPeriod to set.
	 */
	public void setExtendPeriod(String isExtendPeriod) {
		this.isExtendPeriod = isExtendPeriod;
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
	
	
	/**
	 * @return Returns the contractEndDate.
	 */
	public Date getContractEndDate() {
		return contractEndDate;
	}
	/**
	 * @param contractEndDate The contractEndDate to set.
	 */
	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}
	/**
	 * @return Returns the contractStartDate.
	 */
	public Date getContractStartDate() {
		return contractStartDate;
	}
	/**
	 * @param contractStartDate The contractStartDate to set.
	 */
	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}
	/*end change CR6153*/
		
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
	 * @param proposalName
	 * @param proposalType
	 * @param contractType
	 * @param contractNumber
	 * @param externalContractNumber
	 * @param contractPeriodStartDate
	 * @param contractPeriodEndDate
	 * @param replacementDate
	 */
	public void setData(String proposalName, String proposalType, String contractType, String contractNumber,
						String externalContractNumber, Date contractPeriodStartDate, Date contractPeriodEndDate, 
						Date replacementDate){
		super.setData(proposalName, proposalType, contractType, contractNumber, externalContractNumber, contractPeriodStartDate, contractPeriodEndDate);
		setReplacementDate(replacementDate);
	}
	
	private void populateBean(ReplaceContractCustomDTO customDto){
		setProposalName(customDto.getProposalName());
		setProposalType(customDto.getProposalType());
		setContractType(customDto.getContractType());
		setContractNumber(customDto.getContractNumber());
		setExternalContractNumber(customDto.getExternalContractNumber());
		setContractPeriodStartDate(customDto.getContractPeriodStartDate());
		setContractPeriodEndDate(customDto.getContractPeriodEndDate());
		setReplacementDate(customDto.getContractReplacementDate());
		/*start change CR6153*/
		setExtendPeriod(customDto.isISandsExtendPeriod());
		setProposalContent(customDto.getProposalContent());
		setContractStartDate(customDto.getContractStartDate());
		setContractEndDate(customDto.getContractEndDate());		
		/*start change CR6153*/
	}

}
