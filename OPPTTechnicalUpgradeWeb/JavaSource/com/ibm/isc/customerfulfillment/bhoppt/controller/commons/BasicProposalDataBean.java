/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.BasicProposalCustomDTO;

/**
 * Holds basic proposal information  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class BasicProposalDataBean extends OPPTDataBean {
	private String salesOrganization = null;
	private String distributionChannel = null;
	private String salesGroup = null;
	private String channelRole = null;
	private String submitterRole = null;
	private String division = null;
	private String currencyCode = null;
	private String proposalName = null;
	private String proposalType = null;
	private String proposalContent = null;
	private String reportName = null;
	private String externalContractNumber = null;
	private Date contractStartDate = null;
	private Date contractEndDate = null;
	private Date contractPeriodBeginning = null;
	private Date contractPeriodEnding = null;
	private boolean showProposalContent = false;
	private boolean proposalContentEditable = false;
	
	private String replacementContractNumber = null;
	private Date replacementContractDate = null;
	
	/* start change CR6153*/
	private String isExtendPeriod ;
	/* end change CR6153*/
	
	/* BH Wave1 - DAD003 - CCI - Begin - Manoj */
	private String cpsID = null;
	private String ocpsID = null;
	private String contractType = null;
	private String blbIndicator = null;
	private String isPreBillIndicator = null;
	private String cciInd = null;
	/* BH Wave1 - DAD003 - CCI - End - Manoj  */
	/**
	 * Returns contract end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
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
	 * Returns contract period beginning 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getContractPeriodBeginning() {
		return contractPeriodBeginning;
	}

	/**
	 * Returns contract period ending 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getContractPeriodEnding() {
		return contractPeriodEnding;
	}

	/**
	 * Returns contract start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
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
	 * Returns currency code 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * Returns distribution channel 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDistributionChannel() {
		return distributionChannel;
	}

	/**
	 * @return the salesGroup
	 */
	public String getSalesGroup() {
		return salesGroup;
	}

	/**
	 * @return the channelRole
	 */
	public String getChannelRole() {
		return channelRole;
	}

	/**
	 * @return the submitterRole
	 */
	public String getSubmitterRole() {
		return submitterRole;
	}

	/**
	 * @param salesGroup the salesGroup to set
	 */
	public void setSalesGroup(String newSalesGroup) {
		salesGroup = newSalesGroup;
	}

	/**
	 * @param channelRole the channelRole to set
	 */
	public void setChannelRole(String newChannelRole) {
		channelRole = newChannelRole;
	}

	/**
	 * @param submitterRole the submitterRole to set
	 */
	public void setSubmitterRole(String newSubmitterRole) {
		submitterRole = newSubmitterRole;
	}

	/**
	 * Returns division value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDivision() {
		return division;
	}

	/**
	 * Returns external contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
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
	 * Returns proposal name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
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
	 * Returns proposal type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
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
	 * Returns report name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getReportName() {
		if(null != reportName && "null".equalsIgnoreCase(reportName)){  //$NON-NLS-1$
			reportName = null;
		}
		return reportName;
	}

	/**
	 * Returns sales organization value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSalesOrganization() {
		return salesOrganization;
	}

	/**
	 * Sets contract end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
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
	 * Sets contract period beginning 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractPeriodBeginning Date 
	 */
	public void setContractPeriodBeginning(Date newContractPeriodBeginning) {
		contractPeriodBeginning = newContractPeriodBeginning;
	}

	/**
	 * Sets contract period ending value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractPeriofEnding Date 
	 */
	public void setContractPeriodEnding(Date newContractPeriofEnding) {
		contractPeriodEnding = newContractPeriofEnding;
	}

	/**
	 * Sets contract start date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
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
	 * Sets currency code 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCurrencyCode String 
	 */
	public void setCurrencyCode(String newCurrencyCode) {
		currencyCode = newCurrencyCode;
	}

	/**
	 * Sets distribution channel 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDistributionChannel String 
	 */
	public void setDistributionChannel(String newDistributionChannel) {
		distributionChannel = newDistributionChannel;
	}

	/**
	 * Sets division value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDivision String 
	 */
	public void setDivision(String newDivision) {
		division = newDivision;
	}

	/**
	 * Sets external contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
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
	 * Sets proposal name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
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
	 * Sets proposal type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalType String 
	 */
	public void setProposalType(String newProposalType) {
		proposalType = newProposalType;
	}

	/**
	 * Sets report name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newReportName String 
	 */
	public void setReportName(String newReportName) {
		reportName = newReportName;
	}

	/**
	 * Sets sales organization value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSalesOrganization String 
	 */
	public void setSalesOrganization(String newSalesOrganization) {
//		if(null != newSalesOrganization){
//			StringTokenizer st = new StringTokenizer(newSalesOrganization, "|");
//			if(1 < st.countTokens()){
//				newSalesOrganization = st.nextToken();
//			}
//		}
		salesOrganization = newSalesOrganization;
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
	 * date Feb 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getProposalContent() {
		if(null != proposalContent && "null".equalsIgnoreCase(proposalContent)){  //$NON-NLS-1$
			proposalContent = null;
		}
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
	 * date Feb 18, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isProposalContentEditable() {
		return proposalContentEditable;
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
	 * date Feb 18, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isShowProposalContent() {
		return showProposalContent;
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
	 * date Feb 18, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setProposalContentEditable(boolean b) {
		proposalContentEditable = b;
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
	 * date Feb 18, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setShowProposalContent(boolean b) {
		showProposalContent = b;
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
	 * date Feb 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setProposalContent(String string) {
		proposalContent = string;
	}

	/**
	 * Returns old contract number, if any, associated with the proposal
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getReplacementContractNumber() {
		return replacementContractNumber;
	}

	/** 
	 * Sets the old contract number value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newReplacementContractNumber String 
	 */
	public void setReplacementContractNumber(String newReplacementContractNumber) {
		replacementContractNumber = newReplacementContractNumber;
	}
	/**
	 * Returns replacement contract date
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getReplacementContractDate() {
		return replacementContractDate;
	}

	/** 
	 * Sets the old contract number value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newReplacementContractDate Date 
	 */
	public void setReplacementContractDate(Date newReplacementContractDate) {
		replacementContractDate = newReplacementContractDate;
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
	
	/*end change CR6153*/
	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param salesOrganization String
	 * @param distributionChannel String
	 * @param division String
	 * @param currencyCode String
	 * @param proposalName String
	 * @param proposalType String
	 * @param reportName String
	 * @param externalContractNumber String
	 * @param contractStartDate Date
	 * @param contractEndDate Date
	 * @param contractPeriodBeginning Date
	 * @param contractPeriodEnding Date
	 */
	public void setData(String salesOrganization, String distributionChannel, String salesGroup, String channelRole, String submitterRole, String division, 
						String currencyCode, String proposalName, String proposalType, 
						String reportName, String externalContractNumber, Date contractStartDate, 
						Date contractEndDate, Date contractPeriodBeginning, Date contractPeriodEnding){
		setSalesOrganization(salesOrganization);
		setDistributionChannel(distributionChannel);
		setSalesGroup(salesGroup);
		setChannelRole(channelRole);
		setSubmitterRole(submitterRole);
		setDivision(division);
		setCurrencyCode(currencyCode);
		setProposalName(proposalName);
		setProposalType(proposalType);
		setReportName(reportName);
		setExternalContractNumber(externalContractNumber);
		setContractStartDate(contractStartDate);
		setContractEndDate(contractEndDate);
		setContractPeriodBeginning(contractPeriodBeginning);
		setContractPeriodEnding(contractPeriodEnding);
	}
	
	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(BasicProposalCustomDTO customDTO){
		if(null != customDTO){
			setSalesOrganization(customDTO.getSalesOrganization());
			setDistributionChannel(customDTO.getDistributionChannel());
			setSalesGroup(customDTO.getSalesGroup());
			setChannelRole(customDTO.getChannelRole());
			setSubmitterRole(customDTO.getSubmitterRole());
			setDivision(customDTO.getDivision());
			setCurrencyCode(customDTO.getCurrencyCode());
			setProposalName(customDTO.getProposalName());
			setProposalType(customDTO.getProposalType());
			setReportName(customDTO.getReportName());
			setExternalContractNumber(customDTO.getExternalContractNumber());
			setContractStartDate(customDTO.getContractStartDate());
			setContractEndDate(customDTO.getContractEndDate());
			setContractPeriodBeginning(customDTO.getContractPeriodBeginning());
			setContractPeriodEnding(customDTO.getContractPeriodEnding());
			setProposalContent(customDTO.getProposalContent());
			setShowProposalContent(customDTO.isShowProposalContent());
			setProposalContentEditable(customDTO.isProposalContentEditable());
			setReplacementContractNumber(customDTO.getReplacementContractNumber());
			setReplacementContractDate(customDTO.getReplacementContractDate());
			/*start change CR6153*/
			setExtendPeriod(customDTO.isISandsExtendPeriod());
			/*end change CR6153*/
			/* BH Wave1 - DAD003 - Manoj - Begin */
			setCpsID(customDTO.getCpsID());
			setOcpsID(customDTO.getOcpsID());
			setContractType(customDTO.getContractType());
			setBlbIndicator(customDTO.getBlbIndicator());
			setPreBillIndicator(customDTO.getIsPreBillIndicator());
			setCciInd(customDTO.getCciInd());			
			/* BH Wave1 - DAD003 - Manoj - End */
		}
	}

	/**
     * toString()
     * 
     * @see java.lang.Object#toString()
     * @author thirumalai
     */
    public String toString(){
		StringBuffer strValue = new StringBuffer();
		
		strValue.append("\n\n[BasicProposalDataBean] - [toString] - Start...");  //$NON-NLS-1$
		strValue.append("\nSales organization: "+getSalesOrganization());  //$NON-NLS-1$
		strValue.append("\nDistribution channel: "+getDistributionChannel());  //$NON-NLS-1$
		strValue.append("\nSales group: "+getSalesGroup());  //$NON-NLS-1$
		strValue.append("\nChannel role: "+getChannelRole());  //$NON-NLS-1$
		strValue.append("\nSubmitter role: "+getSubmitterRole());  //$NON-NLS-1$
		strValue.append("\nDivision: "+getDivision());  //$NON-NLS-1$
		strValue.append("\nCurrency code: "+getCurrencyCode());  //$NON-NLS-1$
		strValue.append("\nProposal name: "+getProposalName());  //$NON-NLS-1$
		strValue.append("\nProposal type: "+getProposalType());  //$NON-NLS-1$
		strValue.append("\nReport name: "+getReportName());  //$NON-NLS-1$
		strValue.append("\nExternal contract number: "+getExternalContractNumber());  //$NON-NLS-1$
		strValue.append("\nContract start date: "+getContractStartDate());  //$NON-NLS-1$
		strValue.append("\nContract end date: "+getContractEndDate());  //$NON-NLS-1$
		strValue.append("\nContract period beginning: "+getContractPeriodBeginning());  //$NON-NLS-1$
		strValue.append("\nContract period ending: "+getContractPeriodEnding());  //$NON-NLS-1$
		strValue.append("\nReplacement contract number: "+getReplacementContractNumber());  //$NON-NLS-1$
		strValue.append("\nReplacement contract date: "+getReplacementContractDate());  //$NON-NLS-1$
		strValue.append("[BasicProposalDataBean] - [toString] - End...\n\n");  //$NON-NLS-1$

		return strValue.toString();
	}
	
	/**
     * BasicProposalDataBean
     * 
     * @author thirumalai
     */
    public BasicProposalDataBean(){
	}
	/**
     * BasicProposalDataBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public BasicProposalDataBean(BasicProposalCustomDTO customDTO){
		setData(customDTO);
	}
	
	/**
     * equals
     * 
     * @param dataBean
     * @return
     * @author thirumalai
     */
    public boolean equals(BasicProposalDataBean dataBean)
	{
		boolean equal = true;

		if(null != dataBean){
			if(isDifferent(getSalesOrganization()+"|"+getCurrencyCode(), dataBean.getSalesOrganization())){  //$NON-NLS-1$
				equal = false;		
			}
			else if(isDifferent(getDistributionChannel(), dataBean.getDistributionChannel())){
				equal = false;		
			}
			else if(isDifferent(getSalesGroup(), dataBean.getSalesGroup())){
				equal = false;		
			}
			else if(isDifferent(getChannelRole(), dataBean.getChannelRole())){
				equal = false;		
			}
			else if(isDifferent(getSubmitterRole(), dataBean.getSubmitterRole())){
				equal = false;		
			}
			else if(isDifferent(getDivision(), dataBean.getDivision())){
				equal = false;		
			}
			else if(isDifferent(getCurrencyCode(), dataBean.getCurrencyCode())){
				equal = false;		
			}
			else if(isDifferent(getProposalName(), dataBean.getProposalName())){
				equal = false;		
			}
			else if(isDifferent(getProposalType(), dataBean.getProposalType())){
				equal = false;		
			}
			else if(isDifferent(getProposalContent(), dataBean.getProposalContent())){
				equal = false;		
			}
			else if(isDifferent(getReportName(), dataBean.getReportName())){
				equal = false;
			}
			else if(isDifferent(getExternalContractNumber(), dataBean.getExternalContractNumber())){
				equal = false;		
			}
			else if(isDifferent(getReplacementContractNumber(), dataBean.getReplacementContractNumber())){
				equal = false;		
			}
		}
		else{
			equal = false;
		}

		return equal;
	}
	
	private boolean isDifferent(String oldValue, String newValue){
		boolean different = true;
		
		if(null != oldValue){
			if(null != newValue){
				if(oldValue.equals(newValue)){
					different = false;
				}
			}
			else{
				if(0 == oldValue.length()){
					different = false;
				}
			}
		}
		else{
			if(null == newValue || 0 == newValue.length()){
				different = false;
			}
		}
		
		return different;
	}
	 
	public String getProposalContentDescription() {

		if (proposalType != null) {
		if (proposalContent != null) {
			if (proposalContent.equalsIgnoreCase("M")) {
				return Constants.MLC_DESC;
			} if (proposalContent.equalsIgnoreCase("S")) {
				return Constants.SNS_DESC;
			}
		} 
		if (proposalType.equalsIgnoreCase("EA")) {
			return Constants.MLC_DESC;
		}
		}
		return "";

	}
	/* Start of BH Wave-1 for complex contract id - DAD003 - Manoj */
	
	/**
	 * @return Returns the blbIndicator.
	 */
	public String getBlbIndicator() {
		return blbIndicator;
	}	/**
	 * @param blbIndicator The blbIndicator to set.
	 */
	public void setBlbIndicator(String blbIndicator) {
		this.blbIndicator = blbIndicator;
	}
	/**
	 * @return Returns the complexContractAmendment.
	 */
	/*public String getComplexContractAmendment() {
		return complexContractAmendment;
	}
	*//**
	 * @param complexContractAmendment The complexContractAmendment to set.
	 *//*
	public void setComplexContractAmendment(String complexContractAmendment) {
		this.complexContractAmendment = complexContractAmendment;
	}*/
	/**
	 * @return Returns the complexContractID.
	 */
	public String getCpsID() {
		return cpsID;
	}
	/**
	 * @param complexContractID The complexContractID to set.
	 */
	public void setCpsID(String cpsID) {
		this.cpsID = cpsID;
	}
	/**
	 * @return Returns the complexContractType.
	 */
	public String getOcpsID() {
		return ocpsID;
	}
	/**
	 * @param complexContractType The complexContractType to set.
	 */
	public void setOcpsID(String ocpsID) {
		this.ocpsID = ocpsID;
	}
	/**
	 * @return Returns the masterContractAmendment.
	 */
	/*public String getMasterContractAmendment() {
		return masterContractAmendment;
	}
	*//**
	 * @param masterContractAmendment The masterContractAmendment to set.
	 *//*
	public void setMasterContractAmendment(String masterContractAmendment) {
		this.masterContractAmendment = masterContractAmendment;
	}
	*//**
	 * @return Returns the masterContractID.
	 *//*
	public String getMasterContractID() {
		return masterContractID;
	}*/
	/**
	 * @param masterContractID The masterContractID to set.
	 */
	/*public void setMasterContractID(String masterContractID) {
		this.masterContractID = masterContractID;
	}*/
	/**
	 * @return Returns the masterContractType.
	 */
	public String getContractType() {
		return contractType;
	}
	/**
	 * @param masterContractType The masterContractType to set.
	 */
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	/**
	 * @return Returns the isPreBillIndicator.
	 */
	public String isPreBillIndicator() {
		return isPreBillIndicator;
	}
	/**
	 * @param isExtendPeriod The isPreBillIndicator to set.
	 */
	public void setPreBillIndicator(String isPreBillIndicator) {
		this.isPreBillIndicator = isPreBillIndicator;
	}
	/**
	 * @return Returns the cciInd.
	 */
	public String getCciInd() {
		return cciInd;
	}
	/**
	 * @param cciInd The cciInd to set.
	 */
	public void setCciInd(String cciInd) {
		this.cciInd = cciInd;
	}
	/* End of BH Wave-1 for complex contract id - DAD003 - Manoj */ 
} 
