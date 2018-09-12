/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.RenewContractCustomDTO;

/**
 * Holds complete data for renew contract view.  
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
public class RenewContractViewBean extends ContractInfoViewBean {
	private Date iContractStartDate = null;
	private Date iContractEndDate = null;
	
	private boolean iAnniversaryRenewal = false;
	private boolean iChooseRenewalType = false;
	
	/*start change CR6153*/
	private String isExtendPeriod ;
	private String proposalContent;
	/*end change CR6153*/
	
	/**
     * RenewContractViewBean
     * 
     * @author thirumalai
     */
    public RenewContractViewBean(){
	}
	
	/**
     * RenewContractViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public RenewContractViewBean(RenewContractCustomDTO customDto){
		setData(customDto);
	}

	/**
	 * Returns the contract end date 
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
	 * @return Date
	 */
	public Date getContractEndDate() {
		return iContractEndDate;
	}

	/**
	 * Returns contract start date 
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
	 * @return Date
	 */
	public Date getContractStartDate() {
		return iContractStartDate;
	}

	/**
	 * Sets contract end date 
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
	 * @param newContractEndDate Date 
	 */
	public void setContractEndDate(Date newContractEndDate) {
		iContractEndDate = newContractEndDate;
	}

	/**
	 * Sets contract start date 
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
	 * @param newContractStartDate Date
	 */
	public void setContractStartDate(Date newContractStartDate) {
		iContractStartDate = newContractStartDate;
	}
	
	/**
	 * Sets complete data in a single method call  
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
	 * @param proposalName String
	 * @param proposalType String
	 * @param contractType String
	 * @param contractNumber String
	 * @param externalContractNumber String
	 * @param contractPeriodStartDate Date
	 * @param contractPeriodEndDate Date
	 * @param contractStartDate Date
	 * @param contractEndDate Date
	 */
	public void setData(String proposalName, String proposalType, String contractType, String contractNumber,
						String externalContractNumber, Date contractPeriodStartDate, Date contractPeriodEndDate, 
						Date contractStartDate, Date contractEndDate){
		super.setData(proposalName, proposalType, contractType, contractNumber, externalContractNumber, contractPeriodStartDate, contractPeriodEndDate);
		setContractStartDate(contractStartDate);
		setContractEndDate(contractEndDate);
	
	}
	
	private void setData(RenewContractCustomDTO customDto){
		setProposalName(customDto.getProposalName());
		setProposalType(customDto.getProposalType());
		setContractType(customDto.getContractType());
		setContractNumber(customDto.getContractNumber());
		setChooseRenewalType(customDto.isChooseRenewalType());
		setExternalContractNumber(customDto.getExternalContractNumber());
		setContractPeriodStartDate(customDto.getContractPeriodStartDate());
		setContractPeriodEndDate(customDto.getContractPeriodEndDate());
		setContractStartDate(customDto.getContractStartDate());
		setContractEndDate(customDto.getContractEndDate());
		setAnniversaryRenewal(customDto.isAnniversaryRenewal());
		/*start change CR6153*/
		setExtendPeriod(customDto.isISandsExtendPeriod());
		setProposalContent(customDto.getProposalContent());
		/*start change CR6153*/
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
	 * date Apr 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isAnniversaryRenewal() {
		return iAnniversaryRenewal;
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
	 * date Apr 7, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setAnniversaryRenewal(boolean b) {
		iAnniversaryRenewal = b;
	}

	/**
	 * Returns choose renewal type flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date May 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isChooseRenewalType() {
		return iChooseRenewalType;
	}

	/**
	 * Sets choose renewal type flag value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date May 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newChooseRenewalType boolean
	 */
	public void setChooseRenewalType(boolean newChooseRenewalType) {
		iChooseRenewalType = newChooseRenewalType;
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
	/*end change CR6153*/
}
