/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;
import java.util.TreeMap;


/**
 * Custom dto that holds basic proposal header information  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 28, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class BasicProposalCustomDTO extends OPPTCustomDTO {
	private String salesOrganization = null;
	private TreeMap defaultSalesOrg = null;
	private String defaultCurrencyCode = null;
	private String distributionChannel = null;
	private String salesGroup = null;
	private String channelRole = null;
	private String submitterRole = null;
	private String division = null;
	private String currencyCode = null;
	// BH Wave1 - DAD003 - Complex Contract Identifiers - Begin - Bhanu
	private String cpsID = null;
	//private String masterContractID = null;
	private String ocpsID = null;
	private String contractType = null;
	//private String complexContractAmendment = null;
	//private String masterContractAmendment = null;
	private String blbIndicator = null;
	private String isPreBillIndicator = null;
	private String cciInd = null;
	// BH Wave1 - DAD003 - Complex Contract Identifiers - End - Bhanu
	private String proposalName = null;
	private String proposalType = null;
	private String reportName = null;
	private String externalContractNumber = null;
	private Date contractStartDate = null;
	private Date contractEndDate = null;
	private Date contractPeriodBeginning = null;
	private Date contractPeriodEnding = null;

	private String proposalContent;
	private boolean showProposalContent = false;
	private boolean proposalContentEditable = false;

	private String replacementContractNumber = null;
	private Date replacementContractDate = null;

	/* start change CR6153*/
	private String iSandsExtendPeriod = null;
	private boolean iChangeDateFlag = false; 
	/* end change CR6153*/

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
	 * @param salesGroup the salesGroup to set
	 */
	public void setSalesGroup(String newSalesGroup) {
		salesGroup = newSalesGroup;
	}

	/**
	 * @return the channelRole
	 */
	public String getChannelRole() {
		return channelRole;
	}

	/**
	 * @param channelRole the channelRole to set
	 */
	public void setChannelRole(String newChannelRole) {
		channelRole = newChannelRole;
	}

	/**
	 * @return the submitterRole
	 */
	public String getSubmitterRole() {
		return submitterRole;
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
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 24, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newReportName 
     */
	public void setSalesOrganization(String newReportName) {
		salesOrganization = newReportName;
	}

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
	 * @param isalesOrganization 
	 * @param idistributionChannel 
	 * @param idivision 
	 * @param icurrencyCode 
	 * @param iproposalName 
	 * @param iproposalType 
	 * @param ireportName 
	 * @param iexternalContractNumber 
	 * @param icontractStartDate 
	 * @param icontractEndDate 
	 * @param icontractPeriodBeginning 
	 * @param icontractPeriodEnding 
	 */
	public void setData(
		String isalesOrganization,
		String idistributionChannel,
		String iSalesGroup,
		String iChannelRole,
		String iSubmitterRole,
		String idivision,
		String icurrencyCode,
		String iproposalName,
		String iproposalType,
		String ireportName,
		String iexternalContractNumber,
		Date icontractStartDate,
		Date icontractEndDate,
		Date icontractPeriodBeginning,
		Date icontractPeriodEnding) {
		setSalesOrganization(isalesOrganization);
		setDistributionChannel(idistributionChannel);
		setSalesGroup(iSalesGroup);
		setChannelRole(iChannelRole);
		setSubmitterRole(iSubmitterRole);
		setDivision(idivision);
		setCurrencyCode(icurrencyCode);
		setProposalName(iproposalName);
		setProposalType(iproposalType);
		setReportName(ireportName);
		setExternalContractNumber(iexternalContractNumber);
		setContractStartDate(icontractStartDate);
		setContractEndDate(icontractEndDate);
		setContractPeriodBeginning(icontractPeriodBeginning);
		setContractPeriodEnding(icontractPeriodEnding);
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
	 * date Feb 12, 2004 
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
	 * date Feb 12, 2004 
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
		 * 
		 * <br><b>Known Bugs</b><br> 
		 * 
		 * <br><PRE> 
		 * date Feb 12, 2004 
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
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
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
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
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
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
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
	
	/**
	 * Returns the default currency code value for the selected sales org 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jul 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getDefaultCurrencyCode() {
		return defaultCurrencyCode;
	}

	/**
	 * Sets default currency code value for the selected sales org 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jul 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDefaultCurrencyCode String 
	 */
	public void setDefaultCurrencyCode(String newDefaultCurrencyCode) {
		defaultCurrencyCode = newDefaultCurrencyCode;
	}
	
	/* start change CR6153*/
	/**
	 * @return Returns the iSandsExtendPeriod.
	 */
	public String isISandsExtendPeriod() {
		return iSandsExtendPeriod;
	}
	/**
	 * @param sandsExtendPeriod The iSandsExtendPeriod to set.
	 */
	public void setISandsExtendPeriod(String sandsExtendPeriod) {
		iSandsExtendPeriod = sandsExtendPeriod;
	}
	
	/* end change CR6153*/
		/**
	 * Sets default currency code value for the selected sales org 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jul 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String 
	 */
	public String getSalesOrganizationValue(){
		StringBuffer buffer = new StringBuffer();
		
		if(null != getSalesOrganization()){
			buffer.append(getSalesOrganization().trim());
			if(null != getDefaultCurrencyCode()){
				buffer.append("|");  /* NOI18N */
				buffer.append(getDefaultCurrencyCode().trim());
			}
			else if(null != getCurrencyCode()){
				buffer.append("|");  /* NOI18N */
				buffer.append(getCurrencyCode().trim());
			}
		}		
		
		return buffer.toString();
	}
	
	/**
	 * @return Returns the iChangeDateFlag.
	 */
	public boolean isChangeDate() {
		return iChangeDateFlag;
	}
	/**
	 * @param changeDateFlag The iChangeDateFlag to set.
	 */
	public void setChangeDate(boolean changeDateFlag) {
		iChangeDateFlag = changeDateFlag;
	}
	// BH Wave1 - DAD003 - CCI - Bhanu - Begin
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
	 * @return Returns the iChangeDateFlag.
	 */
	public boolean isIChangeDateFlag() {
		return iChangeDateFlag;
	}
	/**
	 * @param changeDateFlag The iChangeDateFlag to set.
	 */
	public void setIChangeDateFlag(boolean changeDateFlag) {
		iChangeDateFlag = changeDateFlag;
	}
	/**
	 * @return Returns the isPreBillIndicator.
	 */
	public String getIsPreBillIndicator() {
		return isPreBillIndicator;
	}
	/**
	 * @param isPreBillIndicator The isPreBillIndicator to set.
	 */
	public void setIsPreBillIndicator(String isPreBillIndicator) {
		this.isPreBillIndicator = isPreBillIndicator;
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
	}*/
	/**
	 * @return Returns the masterContractID.
	 */
	/*public String getMasterContractID() {
		return masterContractID;
	}
	*//**
	 * @param masterContractID The masterContractID to set.
	 *//*
	public void setMasterContractID(String masterContractID) {
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
	 * @return Returns the iSandsExtendPeriod.
	 */
	public String getISandsExtendPeriod() {
		return iSandsExtendPeriod;
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
	// BH Wave1 - DAD003 - CCI - Bhanu - End

	public TreeMap getDefaultSalesOrg() {
		
		return defaultSalesOrg;
	}

	public void setDefaultSalesOrg(TreeMap newDefaultSalesOrg) {
		// TODO Auto-generated method stub
		defaultSalesOrg = newDefaultSalesOrg;
	}
}
