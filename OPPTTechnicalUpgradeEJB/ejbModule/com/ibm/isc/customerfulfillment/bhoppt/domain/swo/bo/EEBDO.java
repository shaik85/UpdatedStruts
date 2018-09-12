/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo;

import java.sql.Date;

/**
 *  
 * EEBDO class represents attribute defined in EE Entity 
 * This data can be validated using EE Business Object class
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar * @version 5.1A
 */

public class EEBDO {
	private int iEeId;
	private int iProposalId;
	private int iCustomerId;
	private int iDmId;
	private int iSwoId;
	private String iSalesDocNo;
	private String iEeItemNo;
	private String iSwoItemNo;
	private String iEeNo;
	private String iEeDesc;
	private Date iPlanStartDate;
	private Date iPlanEndDate;
	private Date iReqstDeliveryDate;
	private String iValueMetric;
	private String iUseLevel;
	private String iLicenseType;
	private double iEswPrice;
	private double iCalculatedPrice;
	private double iAlternatePrice;
	private Date iBillingStartDate;
	private Date iBillingEndDate;
	private String iExclusionId;
	private int iSequenceNo;
	private String iBumpId;
	private String iChargeOption;
	private String iChargeOptionDesc;
	private String iAlternatePriceUpdateInd;
	private double iListPrice;
	private String iPletNo;
	private double iSAndSDiscountPercent;

	/**
	 *  
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public EEBDO() {

	}
	/**
	 * Get EE Alternate Price  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return AlternatePrice
	 */
	public double getAlternatePrice() {
		return iAlternatePrice;
	}

	/**
	 * Get Alternate price update Ind 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return AlternatePriceUpdateInd
	 */
	public String getAlternatePriceUpdateInd() {
		return iAlternatePriceUpdateInd;
	}

	/**
	 * Get Billing End Date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return BillingEndDate
	 */
	public Date getBillingEndDate() {
		return iBillingEndDate;
	}

	/**
	 * Get Billing Start date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return BillingStartDate
	 */
	public Date getBillingStartDate() {
		return iBillingStartDate;
	}

	/**
	 * Get Bump Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return BumpId
	 */
	public String getBumpId() {
		return iBumpId;
	}

	/**
	 * Get Calculated Price  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CalculatedPrice
	 */
	public double getCalculatedPrice() {
		return iCalculatedPrice;
	}

	/**
	 * Get Charge Option  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ChargeOption
	 */
	public String getChargeOption() {
		return iChargeOption;
	}

	/**
	 * Get Charge Option Description  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ChargeOptionDesc
	 */
	public String getChargeOptionDesc() {
		return iChargeOptionDesc;
	}

	/**
	 * Get Customer Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CustomerId
	 */
	public int getCustomerId() {
		return iCustomerId;
	}

	/**
	 * Get the DM Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DmId
	 */
	public int getDmId() {
		return iDmId;
	}

	/**
	 * Get EE Description  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return EeDesc
	 */
	public String getEeDesc() {
		return iEeDesc;
	}

	/**
	 * Get EE Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return EeId
	 */
	public int getEeId() {
		return iEeId;
	}

	/**
	 * Get EE Item No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return EeItemNo
	 */
	public String getEeItemNo() {
		return iEeItemNo;
	}

	/**
	 * Get EE No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return EeNo
	 */
	public String getEeNo() {
		return iEeNo;
	}

	/**
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return EswPrice
	 */
	public double getEswPrice() {
		return iEswPrice;
	}

	/**
	 * Get the Exclusion Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ExclusionId
	 */
	public String getExclusionId() {
		return iExclusionId;
	}

	/**
	 * Get the License type 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return LicenseType
	 */
	public String getLicenseType() {
		return iLicenseType;
	}

	/**
	 *  Get the List Price
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ListPrice
	 */
	public double getListPrice() {
		return iListPrice;
	}

	/**
	 *  Get the Planned End Date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PlanEndDate
	 */
	public Date getPlanEndDate() {
		return iPlanEndDate;
	}

	/**
	 *  Get Plan start date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PlanStartDate
	 */
	public Date getPlanStartDate() {
		return iPlanStartDate;
	}

	/**
	 * Get the PLET No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PletNo
	 */
	public String getPletNo() {
		return iPletNo;
	}

	/**
	 * Get Proposal Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalId
	 */
	public int getProposalId() {
		return iProposalId;
	}

	/**
	 *  get the Request Delivery Date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ReqstDeliveryDate
	 */
	public Date getReqstDeliveryDate() {
		return iReqstDeliveryDate;
	}

	/**
	 *  Get the Sales Document No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SalesDocNo
	 */
	public String getSalesDocNo() {
		return iSalesDocNo;
	}

	/**
	 *  Get the Sequence No
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SequenceNo
	 */
	public int getSequenceNo() {
		return iSequenceNo;
	}

	/**
	 * Get the SWO Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SwoId
	 */
	public int getSwoId() {
		return iSwoId;
	}

	/**
	 * Get the SWO Item No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SwoItemNo
	 */
	public String getSwoItemNo() {
		return iSwoItemNo;
	}

	/**
	 * get the Use Level  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return UseLevel
	 */
	public String getUseLevel() {
		return iUseLevel;
	}

	/**
	 * Get the Value Metric  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public String getValueMetric() {
		return iValueMetric;
	}

	/**
	 * Set Alternate Price  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param alternatePrice
	 */
	public void setAlternatePrice(double alternatePrice) {
		iAlternatePrice = alternatePrice;
	}

	/**
	 *  set Alternate Price Updated Indicator
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param alternatePriceUpdateInd
	 */
	public void setAlternatePriceUpdateInd(String alternatePriceUpdateInd) {
		iAlternatePriceUpdateInd = alternatePriceUpdateInd;
	}

	/**
	 *  set the Billing end date
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param billingEndDate
	 */
	public void setBillingEndDate(Date billingEndDate) {
		iBillingEndDate = billingEndDate;
	}

	/**
	 * set billing start date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param billingStartDate
	 */
	public void setBillingStartDate(Date billingStartDate) {
		iBillingStartDate = billingStartDate;
	}

	/**
	 * set Bump Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bumpId
	 */
	public void setBumpId(String bumpId) {
		iBumpId = bumpId;
	}

	/**
	 * set calculate price  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param calculatedPrice
	 */
	public void setCalculatedPrice(double calculatedPrice) {
		iCalculatedPrice = calculatedPrice;
	}

	/**
	 * set charge option  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param chargeOption
	 */
	public void setChargeOption(String chargeOption) {
		iChargeOption = chargeOption;
	}

	/**
	 * set charge option desc  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param chargeOptionDesc
	 */
	public void setChargeOptionDesc(String chargeOptionDesc) {
		iChargeOptionDesc = chargeOptionDesc;
	}

	/**
	 * set Customer id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerId
	 */
	public void setCustomerId(int customerId) {
		iCustomerId = customerId;
	}

	/**
	 * set DM Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmId
	 */
	public void setDmId(int dmId) {
		iDmId = dmId;
	}

	/**
	 * set EE Description  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eeDesc
	 */
	public void setEeDesc(String eeDesc) {
		iEeDesc = eeDesc;
	}

	/**
	 * set EE Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eeId
	 */
	public void setEeId(int eeId) {
		iEeId = eeId;
	}

	/**
	 * set EE Item No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eeItemNo
	 */
	public void setEeItemNo(String eeItemNo) {
		iEeItemNo = eeItemNo;
	}

	/**
	 * set EE No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eeNo
	 */
	public void setEeNo(String eeNo) {
		iEeNo = eeNo;
	}

	/**
	 * set ESW Price  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eswPrice
	 */
	public void setEswPrice(double eswPrice) {
		iEswPrice = eswPrice;
	}

	/**
	 * set Exclusion Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param exclusionId
	 */
	public void setExclusionId(String exclusionId) {
		iExclusionId = exclusionId;
	}

	/**
	 * Set License Type 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param licenseType
	 */
	public void setLicenseType(String licenseType) {
		iLicenseType = licenseType;
	}

	/**
	 * set Lsist Price  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param listPrice
	 */
	public void setListPrice(double listPrice) {
		iListPrice = listPrice;
	}

	/**
	 * set Plan end date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param planEndDate
	 */
	public void setPlanEndDate(Date planEndDate) {
		iPlanEndDate = planEndDate;
	}

	/**
	 * set Plan start date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param planStartDate
	 */
	public void setPlanStartDate(Date planStartDate) {
		iPlanStartDate = planStartDate;
	}

	/**
	 * set Plet No 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param pletNo
	 */
	public void setPletNo(String pletNo) {
		iPletNo = pletNo;
	}

	/**
	 * set Proposal Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalId
	 */
	public void setProposalId(int proposalId) {
		iProposalId = proposalId;
	}

	/**
	 * set Request delivery date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param reqstDeliveryDate
	 */
	public void setReqstDeliveryDate(Date reqstDeliveryDate) {
		iReqstDeliveryDate = reqstDeliveryDate;
	}

	/**
	 * set sales document no  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param salesDocNo
	 */
	public void setSalesDocNo(String salesDocNo) {
		iSalesDocNo = salesDocNo;
	}

	/**
	 * set sequence no 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sequenceNo
	 */
	public void setSequenceNo(int sequenceNo) {
		iSequenceNo = sequenceNo;
	}

	/**
	 * set SWO Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoId
	 */
	public void setSwoId(int swoId) {
		iSwoId = swoId;
	}

	/**
	 * set SWO Item No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoItemNo
	 */
	public void setSwoItemNo(String swoItemNo) {
		iSwoItemNo = swoItemNo;
	}

	/**
	 * set Use Level  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param useLevel
	 */
	public void setUseLevel(String useLevel) {
		iUseLevel = useLevel;
	}

	/**
	 * set Value Metric  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param valueMetric
	 */
	public void setValueMetric(String valueMetric) {
		iValueMetric = valueMetric;
	}

	/** 
	 * Set S&S Discount percent option 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return iSAndSDiscountPercent
	 */
	public double getSAndSDiscountPercent() {
		return iSAndSDiscountPercent;
	}

	/** 
	 * Set S&S Discount percent option 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sAndSDiscountPercent 
	 */
	public void setSAndSDiscountPercent(double sAndSDiscountPercent) {
		iSAndSDiscountPercent = sAndSDiscountPercent;
	}

}
