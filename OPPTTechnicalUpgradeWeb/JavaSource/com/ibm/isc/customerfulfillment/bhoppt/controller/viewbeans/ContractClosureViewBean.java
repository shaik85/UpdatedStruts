/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CloseContractCustomDTO;

/**
 * Hold information required for the contract closure view.  
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
public class ContractClosureViewBean extends ContractInfoViewBean {
	private Date contractStartDate = null;
	private Date contractEndDate = null;
	private Date contractClosureDate = null;
	private ArrayList yearList =null;
	private boolean closureDateEditable = true;
	
	/*start change CR6153*/
	private String isExtendPeriod ;
	private String proposalContent;
	/*end change CR6153*/
	
	/**
     * ContractClosureViewBean
     * 
     * @author thirumalai
     */
    public ContractClosureViewBean(){
	}

	/**
     * ContractClosureViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public ContractClosureViewBean(CloseContractCustomDTO customDto){
		populateBean(customDto);
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
		return contractEndDate;
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
		return contractStartDate;
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
		contractEndDate = newContractEndDate;
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
		contractStartDate = newContractStartDate;
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
	 * date Jan 15, 2004 
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
	 * date Jan 15, 2004 
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
	 * date Mar 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isClosureDateEditable() {
		return closureDateEditable;
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
	 * date Mar 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setClosureDateEditable(boolean b) {
		closureDateEditable = b;
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
	 * date Mar 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public Date getContractClosureDate() {
		return contractClosureDate;
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
	 * date Mar 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date 
	 */
	public void setContractClosureDate(Date date) {
		contractClosureDate = date;
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
	
	
	/**
     * Sets complete data in a single method call
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
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
     * @param closureDateEditable
     * @param contractClosureDate 
     */
	public void setData(String proposalName, String proposalType, String contractType, String contractNumber,
						String externalContractNumber, Date contractPeriodStartDate, Date contractPeriodEndDate, 
						Date contractStartDate, Date contractEndDate, boolean closureDateEditable, Date contractClosureDate){
							
		super.setData(proposalName, proposalType, contractType, contractNumber, externalContractNumber, contractPeriodStartDate, contractPeriodEndDate);
		setContractStartDate(contractStartDate);
		setContractEndDate(contractEndDate);
		setClosureDateEditable(closureDateEditable);
		setContractClosureDate(contractClosureDate);
		
	
	}

	private void populateBean(CloseContractCustomDTO customDto){
		setData(customDto.getProposalName(),customDto.getProposalType(), customDto.getContractType(), 
			customDto.getContractNumber(), customDto.getExternalContractNumber(), customDto.getContractPeriodStartDate(),
			customDto.getContractPeriodEndDate(), customDto.getContractStartDate(), customDto.getContractEndDate(),
			customDto.isClosureDateEditable(),customDto.getContractClosureDate());
		/*start change CR6153*/
		setExtendPeriod(customDto.isISandsExtendPeriod());
		setProposalContent(customDto.getProposalContent());
		/*start change CR6153*/
	}
	
	
}
