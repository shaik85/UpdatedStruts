/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto;

import java.sql.Date;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.OPPTDomainDTO;
/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 22, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */

public class DeletedSWORptDomainDTO extends OPPTDomainDTO {
	private Date rptPrintedDate = null;
	private Date pricesAsOf = null;
	private Date contractStartDate = null;
	private Date contractEndDate = null;
	private double tvmRate;
	private double plannedGrowthRate;
	private String contractNumer = null;
	private double totalCalculatedPrice;
	private List customerDomainDTOList = null;
	private String billToPartyLegNo = null;
	private String billToPartyASNO = null;
	private String payerLegNo = null;
	private String payerASNO = null;
	private String billToPartyName = null;
	private String payerName = null;
	private String proposalContent = null;
	private List sSCustomerDomainDTOList = null;

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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public Date getContractEndDate() {
		return contractEndDate;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getContractNumer() {
		return contractNumer;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public Date getContractStartDate() {
		return contractStartDate;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public List getCustomerDomainDTOList() {
		return customerDomainDTOList;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public double getPlannedGrowthRate() {
		return plannedGrowthRate;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public Date getPricesAsOf() {
		return pricesAsOf;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public Date getRptPrintedDate() {
		return rptPrintedDate;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public double getTotalCalculatedPrice() {
		return totalCalculatedPrice;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public double getTvmRate() {
		return tvmRate;
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
	public String getBillToPartyLegNo() {
		return billToPartyLegNo;
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
	public String getBillToPartySeqNo() {
		return billToPartyASNO;
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
	public String getBillToPartyName() {
		return billToPartyName;
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
	public String getPayerLegNo() {
		return payerLegNo;
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
	public String getPayerSeqNo() {
		return payerASNO;
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
	public String getPayerName() {
		return payerName;
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
			* date Mar 24, 2004 
			* 
			* revision date author reason 
			* 
			* </PRE><br> 
			* 
			* @return 
			*/
	public String getProposalContent() {
		return proposalContent;
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
		 * date Mar 24, 2004 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @return 
		 */
	public List getSSCustomerDomainDTOList() {
		return sSCustomerDomainDTOList;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date 
	 */
	public void setContractEndDate(Date date) {
		contractEndDate = date;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setContractNumer(String string) {
		contractNumer = string;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date 
	 */
	public void setContractStartDate(Date date) {
		contractStartDate = date;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
	public void setCustomerDomainDTOList(List list) {
		customerDomainDTOList = list;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param d 
	 */
	public void setPlannedGrowthRate(double d) {
		plannedGrowthRate = d;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date 
	 */
	public void setPricesAsOf(Date date) {
		pricesAsOf = date;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date 
	 */
	public void setRptPrintedDate(Date date) {
		rptPrintedDate = date;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param d 
	 */
	public void setTotalCalculatedPrice(double d) {
		totalCalculatedPrice = d;
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
	 * date Nov 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param d 
	 */
	public void setTvmRate(double d) {
		tvmRate = d;
	}
	/**
     * Enter one sentence as a brief description for this method.
     * You can enter more text here. Please think of
     * - visibility decision
     * - changes that are made to objects, which are passed as parameters
     * - concurrency issues
     * - examples how to invoke this methods
     * - preconditions that this method relies on
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Mar 22, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param s 
     */
	public void setBillToPartyLegNo(String s) {
		billToPartyLegNo = s;
	}
	/**
     * Enter one sentence as a brief description for this method.
     * You can enter more text here. Please think of
     * - visibility decision
     * - changes that are made to objects, which are passed as parameters
     * - concurrency issues
     * - examples how to invoke this methods
     * - preconditions that this method relies on
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Mar 22, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param s 
     */
	public void setBillToPartyName(String s) {
		billToPartyName = s;
	}

	/**
     * Enter one sentence as a brief description for this method.
     * You can enter more text here. Please think of
     * - visibility decision
     * - changes that are made to objects, which are passed as parameters
     * - concurrency issues
     * - examples how to invoke this methods
     * - preconditions that this method relies on
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Mar 22, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param s 
     */
	public void setBillToPartySeqNo(String s) {
		billToPartyASNO = s;
	}

	/**
     * Enter one sentence as a brief description for this method.
     * You can enter more text here. Please think of
     * - visibility decision
     * - changes that are made to objects, which are passed as parameters
     * - concurrency issues
     * - examples how to invoke this methods
     * - preconditions that this method relies on
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Mar 22, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param s 
     */
	public void setPayerLegNo(String s) {
		payerLegNo = s;
	}

	/**
     * Enter one sentence as a brief description for this method.
     * You can enter more text here. Please think of
     * - visibility decision
     * - changes that are made to objects, which are passed as parameters
     * - concurrency issues
     * - examples how to invoke this methods
     * - preconditions that this method relies on
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Mar 22, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param s 
     */
	public void setPayerSeqNo(String s) {
		payerASNO = s;
	}

	/**
     * Enter one sentence as a brief description for this method.
     * You can enter more text here. Please think of
     * - visibility decision
     * - changes that are made to objects, which are passed as parameters
     * - concurrency issues
     * - examples how to invoke this methods
     * - preconditions that this method relies on
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Mar 22, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param s 
     */
	public void setPayerName(String s) {
		payerName = s;
	}

	/**
     * Enter one sentence as a brief description for this method.
     * You can enter more text here. Please think of
     * - visibility decision
     * - changes that are made to objects, which are passed as parameters
     * - concurrency issues
     * - examples how to invoke this methods
     * - preconditions that this method relies on
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Mar 24, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param s 
     */
	public void setProposalContent(String s) {
		proposalContent = s;
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
		 * date Mar 24, 2004 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @param list 
		 */
	public void setSSCustomerDomainDTOList(List list) {
		sSCustomerDomainDTOList = list;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date May 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see java.lang.Object#finalize() 
	 * @throws Throwable 
	 * 
	 */
	/*protected void finalize() throws Throwable {
		rptPrintedDate = null;
		pricesAsOf = null;
		contractStartDate = null;
		contractEndDate = null;
		contractNumer = null;
		billToPartyLegNo = null;
		billToPartyASNO = null;
		payerLegNo = null;
		payerASNO = null;
		billToPartyName = null;
		payerName = null;
		proposalContent = null;

		if(null != customerDomainDTOList){
			customerDomainDTOList.clear();
			customerDomainDTOList = null;
		}
		
		if(null != sSCustomerDomainDTOList){
			customerDomainDTOList.clear();
			customerDomainDTOList = null;
		}
	}*/
   
    /**
     * return the billToPartyASNO 
     *
     * @return Returns the billToPartyASNO.
     */
    public String getBillToPartyASNO() {
        return billToPartyASNO;
    }
    /**
     * sets the billToPartyASNO
     *
     * @param lBillToPartyASNO The billToPartyASNO to set.
     */
    public void setBillToPartyASNO(String lBillToPartyASNO) {
        billToPartyASNO = lBillToPartyASNO;
    }
    /**
     * return the payerASNO 
     *
     * @return Returns the payerASNO.
     */
    public String getPayerASNO() {
        return payerASNO;
    }
    /**
     * sets the payerASNO
     *
     * @param lPayerASNO The payerASNO to set.
     */
    public void setPayerASNO(String lPayerASNO) {
        payerASNO = lPayerASNO;
    }
}