/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ButtonConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.VarianceHeaderInformationCustomDTO;

/**
 * Holds complete data required for variance header information view.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class VarianceHeaderInformationViewBean extends OPPTViewBean {
	private String iCurrency = null;
	private String iProposalType = null;
	private String iSoldToCustomerNumber = null;
	private String iExternalContractNumber = null;
	private Date iVarianceDate = null;
	private Date iContractPeriodStartDate = null;
	private Date iContractPeriodEndDate = null;
	private double iInvAtPeriodStartOfContract = 0;
	private double iCumulativeActualInvAsOfVarianceDate = 0;
	private double iCapAmount = 0;
	private double iCapVariance = 0;
	private boolean showOption = false;
	private boolean positiveCap = false;
	
	/**
     * VarianceHeaderInformationViewBean
     * 
     * @author thirumalai
     */
    public VarianceHeaderInformationViewBean(){
	}
	
	/**
     * VarianceHeaderInformationViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public VarianceHeaderInformationViewBean(VarianceHeaderInformationCustomDTO customDto){
		populateBean(customDto);
	}
	/**
	 * Returns cap amount
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
	 * @return double
	 */
	public double getCapAmount() {
		return iCapAmount;
	}

	/**
	 * Returns cap variance amount
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
	 * @return double
	 */
	public double getCapVariance() {
		return iCapVariance;
	}

	/**
	 * Returns contract period end date
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
	public Date getContractPeriodEndDate() {
		return iContractPeriodEndDate;
	}

	/**
	 * Returns contract period start date 
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
	public Date getContractPeriodStartDate() {
		return iContractPeriodStartDate;
	}

	/**
	 * Returns cumulative actual inventory as of variance date 
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
	 * @return double
	 */
	public double getCumulativeActualInvAsOfVarianceDate() {
		return iCumulativeActualInvAsOfVarianceDate;
	}

	/**
	 * Returns currency type 
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
	public String getCurrency() {
		return iCurrency;
	}

	/**
	 * Returns external contract number 
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
	public String getExternalContractNumber() {
		return iExternalContractNumber;
	}

	/**
	 * Returns inventory at period start of contract 
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
	 * @return double
	 */
	public double getInvAtPeriodStartOfContract() {
		return iInvAtPeriodStartOfContract;
	}

	/**
	 * Returns proposal type 
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
	public String getProposalType() {
		return iProposalType;
	}

	/**
	 * Returns sold to customer number 
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
	public String getSoldToCustomerNumber() {
		return iSoldToCustomerNumber;
	}

	/**
	 * Returns variance date 
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
	 * Sets cap amount 
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
	 * @param newCapAmount double 
	 */
	public void setCapAmount(double newCapAmount) {
		iCapAmount = newCapAmount;
	}

	/**
	 * Sets cap variance 
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
	 * @param newCapVariance double 
	 */
	public void setCapVariance(double newCapVariance) {
		iCapVariance = newCapVariance;
	}

	/**
	 * Sets contract period end date 
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
	 * @param newContractPeriodEndDate Date 
	 */
	public void setContractPeriodEndDate(Date newContractPeriodEndDate) {
		iContractPeriodEndDate = newContractPeriodEndDate;
	}

	/**
	 * Sets contract period start date 
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
	 * @param newContractPeriodStartDate Date 
	 */
	public void setContractPeriodStartDate(Date newContractPeriodStartDate) {
		iContractPeriodStartDate = newContractPeriodStartDate;
	}

	/**
	 * sets cumulative actual invoice as of variance date 
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
	 * @param newCumulativeActualInvAsOfVarianceDate double 
	 */
	public void setCumulativeActualInvAsOfVarianceDate(double newCumulativeActualInvAsOfVarianceDate) {
		iCumulativeActualInvAsOfVarianceDate = newCumulativeActualInvAsOfVarianceDate;
	}

	/**
	 * Sets currency 
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
	 * @param newCurrency String 
	 */
	public void setCurrency(String newCurrency) {
		iCurrency = newCurrency;
	}

	/**
	 * Sets external contract number 
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
	 * @param newExternalContractNumber String 
	 */
	public void setExternalContractNumber(String newExternalContractNumber) {
		iExternalContractNumber = newExternalContractNumber;
	}

	/**
	 * Sets inventory at period start of contract 
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
	 * @param newInvAtPerodStartOfContract double 
	 */
	public void setInvAtPeriodStartOfContract(double newInvAtPerodStartOfContract) {
		iInvAtPeriodStartOfContract = newInvAtPerodStartOfContract;
	}

	/**
	 * Sets proposal type 
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
	 * @param newProposalType String 
	 */
	public void setProposalType(String newProposalType) {
		iProposalType = newProposalType;
	}

	/**
	 * Sets sold to customer number 
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
	 * @param newSoldToCustomerNumber String 
	 */
	public void setSoldToCustomerNumber(String newSoldToCustomerNumber) {
		iSoldToCustomerNumber = newSoldToCustomerNumber;
	}

	/**
     * Sets variance date
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newVarianceDate 
     */
	public void setVarianceDate(Date newVarianceDate) {
		iVarianceDate = newVarianceDate;
	}

	/**
     * Sets complete data in a single method call
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 21, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param currency String
     * @param proposalType String
     * @param soldToCustomerNumber String
     * @param externalContractNumber String
     * @param varianceDate Date
     * @param contractPeriodStartDate Date
     * @param contractPeriodEndDate Date
     * @param invAtPeriodStartOfContract double
     * @param cumulativeActualInvAsOfVarianceDate double
     * @param capAmount double
     * @param capVariance double
     * @param checkCap
     * @param option 
     */
	public void setData(String currency, String proposalType, String soldToCustomerNumber, 
						String externalContractNumber, Date varianceDate, Date contractPeriodStartDate, 
						Date contractPeriodEndDate, double invAtPeriodStartOfContract, 
						double cumulativeActualInvAsOfVarianceDate, double capAmount, double capVariance,
						boolean option, boolean checkCap){
		setCurrency(currency);
		setProposalType(proposalType);
		setSoldToCustomerNumber(soldToCustomerNumber);
		setExternalContractNumber(externalContractNumber);
		setVarianceDate(varianceDate);
		setContractPeriodStartDate(contractPeriodStartDate);
		setContractPeriodEndDate(contractPeriodEndDate);
		setInvAtPeriodStartOfContract(invAtPeriodStartOfContract);
		setCumulativeActualInvAsOfVarianceDate(cumulativeActualInvAsOfVarianceDate);
		setCapAmount(capAmount);
		setCapVariance(capVariance);
		setShowOption(option);
		setPositiveCap(checkCap);
	}
	
	private void populateBean(VarianceHeaderInformationCustomDTO customDto){
		setData(customDto.getCurrency(),customDto.getProposalType(),customDto.getSoldToCustomerNumber(),
		customDto.getExternalContractNumber(), customDto.getVarianceDate(),customDto.getContractPeriodStartDate(),
		customDto.getContractPeriodEndDate(),customDto.getInvAtPeriodStartOfContract(),
		customDto.getCumulativeActualInvAsOfVarianceDate(),customDto.getCapAmount(),
		customDto.getCapVariance(), customDto.isShowOption(), customDto.isPositiveCap());
		setButtonFlags(customDto.getButtonFlags());
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
	 * date Mar 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isShowOption() {
		return showOption;
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
	 * date Mar 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setShowOption(boolean b) {
		showOption = b;
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
	 * date Mar 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isPositiveCap() {
		return positiveCap;
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
	 * date Mar 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setPositiveCap(boolean b) {
		positiveCap = b;
	}
	
	/**
     * showViewDownLoad
     * 
     * @return
     * @author thirumalai
     */
    public boolean showViewDownLoad(){
		boolean showViewDownLoad = true;
	
		if(null != getButtonFlags()){
			if(getButtonFlags().contains(ButtonConstants.VIEW) && getButtonFlags().contains(ButtonConstants.DOWNLOAD)){
				showViewDownLoad = false;
			}
		}
	
		return showViewDownLoad;
	}
	
	/**
     * showVarianceProposal
     * 
     * @return
     * @author thirumalai
     */
    public boolean showVarianceProposal(){
		boolean showVarianceProposal = true;

		if(null != getButtonFlags()){
			if(getButtonFlags().contains(ButtonConstants.CREATE_VARIANCE_PROPOSAL_BUTTON)){
				showVarianceProposal = false;
			}
		}

		return showVarianceProposal;
	}

}
