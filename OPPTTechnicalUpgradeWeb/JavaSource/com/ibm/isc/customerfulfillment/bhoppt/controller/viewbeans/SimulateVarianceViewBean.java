/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceCustomDTO;

/**
 * Holds complete data about simulate variance view  
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
public class SimulateVarianceViewBean extends ContractInfoViewBean {
	private Date iVarianceDate = null;
	private boolean iIncludeQuotes = false;
	private ArrayList yearList =null;
	
	/**
     * SimulateVarianceViewBean
     * 
     * @author thirumalai
     */
    public SimulateVarianceViewBean(){
	}

	/**
     * SimulateVarianceViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public SimulateVarianceViewBean(VarianceCustomDTO customDto){
		populateBean(customDto);
	}
	
	
	/**
	 * Returns a flag indicating whether the quotes to be included 
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
	 * @return boolean
	 */
	public boolean isIncludeQuotes() {
		return iIncludeQuotes;
	}

	/**
	 * Returns the variance date 
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
	public Date getVarianceDate() {
		return iVarianceDate;
	}

	/**
	 * Sets the include quotes flag 
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
	 * @param newIncludeQuotes boolean 
	 */
	public void setIncludeQuotes(boolean newIncludeQuotes){
		iIncludeQuotes = newIncludeQuotes;
	}

	/**
	 * Sets the variance date 
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
	 * @param newVarianceDate Date 
	 */
	public void setVarianceDate(Date newVarianceDate){
		iVarianceDate = newVarianceDate;
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
	 * @param contractPeriodStartDate
	 * @param contractPeriodEndDate
	 * @param varianceDate
	 * @param includeQuotes
	 */
	public void setData(String proposalName, String proposalType, String contractType, String contractNumber,
						String externalContractNumber, Date contractPeriodStartDate, Date contractPeriodEndDate,
						Date varianceDate, boolean includeQuotes){
		super.setData(proposalName, proposalType, contractType, contractNumber, externalContractNumber, contractPeriodStartDate, contractPeriodEndDate);
		setVarianceDate(varianceDate);
		setIncludeQuotes(includeQuotes);
	}
	
	/**
	 *  
	 * Populate bean with the data in VarianceCustomDTO object
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDto
	 */
	private void populateBean(VarianceCustomDTO customDto){
		setProposalName(customDto.getProposalName());
		setProposalType(customDto.getProposalType());
		setContractType(customDto.getContractType());
		setContractNumber(customDto.getContractNumber());
		setExternalContractNumber(customDto.getExternalContractNumber());
		setContractPeriodStartDate(customDto.getContractPeriodStartDate());
		setContractPeriodEndDate(customDto.getContractPeriodEndDate());
		setVarianceDate(customDto.getVarianceDate());
		setIncludeQuotes(customDto.isIncludeQuotes());
	}
}
