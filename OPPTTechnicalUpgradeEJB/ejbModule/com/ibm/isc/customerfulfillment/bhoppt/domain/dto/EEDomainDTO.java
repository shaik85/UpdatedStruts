/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.domain.dto;


import java.sql.Date;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;


/** 
 * This Domain DTOS have same attributes like EEBDO.
 * But this DTOs are mainly used to transfer the data across service layer 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar * @version 5.1A 
 */


public class EEDomainDTO extends OPPTDomainDTO{
	private int eeId;
	private int proposalId;
	private int customerId;
	private int dmId;
	private int swoId;
	private String salesDocNo;
	private String eeItemNo;
	private String swoItemNo;
	private String eeNo;
	private String eeDesc;
	private Date planStartDate;
	private Date planEndDate;
	private Date reqstDeliveryDate;
	private String valueMetric;
	private String useLevel;
	private String licenseType;
	private double eswPrice;
	private double calculatedPrice;
	private double alternatePrice;
	private Date billingStartDate;
	private Date billingEndDate;
	private String exclusionId;
	private int sequenceNo;
	private String bumpId;
	private String chargeOption;
	private String chargeOptionDesc;
	private String alternatePriceUpdateInd;
	private double listPrice;
	private String pletNo;
	private double sAndSDiscountPercent;
	private List priceDTOList;
	
	/**
	 *  
	 * Empty Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public EEDomainDTO(){
		
	}
	/**
	 *  
	 * Constructor 
	 * Customer Domain DTO Constructor takes the CustomerBO object 
	 * Getter and setter methods act on the constructor itself 
	 * 
	 * <br/><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param bo
	 */
	public EEDomainDTO(EEBO eebo){
		//System.out.println("getDiscunt...."+getDiscount1());
		eeId=eebo.getEeId();
		proposalId=eebo.getProposalId();
		customerId=eebo.getCustomerId();
		dmId=eebo.getDmId();
		swoId=eebo.getSwoId();
		salesDocNo=eebo.getSalesDocNo();
		eeItemNo=eebo.getEeItemNo();
		swoItemNo=eebo.getSwoItemNo();
		eeNo=eebo.getEeNo();
		eeDesc=eebo.getEeDesc();
		planStartDate=eebo.getPlanStartDate();
		planEndDate=eebo.getPlanEndDate();
		reqstDeliveryDate=eebo.getReqstDeliveryDate();
		valueMetric=eebo.getValueMetric();
		useLevel=eebo.getUseLevel();
		licenseType=eebo.getLicenseType();
		eswPrice=eebo.getEswPrice();
		calculatedPrice=eebo.getCalculatedPrice();
		alternatePrice=eebo.getAlternatePrice();
		billingStartDate=eebo.getBillingStartDate();
		billingEndDate=eebo.getBillingEndDate();
		exclusionId=eebo.getExclusionId();
		sequenceNo=eebo.getSequenceNo();
		bumpId=eebo.getBumpId();
		chargeOption=eebo.getChargeOption();
		chargeOptionDesc=eebo.getChargeOptionDesc();
		alternatePriceUpdateInd=eebo.getAlternatePriceUpdateInd();
		listPrice=eebo.getListPrice();
		pletNo=eebo.getPletNo();
		sAndSDiscountPercent=eebo.getSAndSDiscountPercent();	
         
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
			//System.out.println("EEDomainDTO.getAlternatePrice()"+alternatePrice);
			return alternatePrice;
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
			return  alternatePriceUpdateInd;
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
			return billingEndDate;
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
			return billingStartDate;
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
			return bumpId;
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
			/*if (alternatePrice > 0){
				calculatedPrice=alternatePrice;	
			}*/
			//System.out.println("EEDomainDTO.getCalculatedPrice()"+calculatedPrice);
			return calculatedPrice;
			
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
			return chargeOption;
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
			return chargeOptionDesc;
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
			return customerId;
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
			return dmId;
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
			return eeDesc;
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
			//System.out.println("EEDomainDTO.getEeId()"+eeId);
			return eeId;
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
			return eeItemNo;
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
			return eeNo;
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
			return eswPrice;
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
			return exclusionId;
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
			return licenseType;
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
			return listPrice;
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
			return planEndDate;
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
			return planStartDate;
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
			return pletNo;
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
			return proposalId;
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
			return reqstDeliveryDate;
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
			return salesDocNo;
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
			return sequenceNo;
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
			return swoId;
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
			return swoItemNo;
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
			return useLevel;
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
			return valueMetric;
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
		public void setAlternatePrice(double iAlternatePrice) {
			alternatePrice = iAlternatePrice;
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
		public void setAlternatePriceUpdateInd(String iAlternatePriceUpdateInd) {
			alternatePriceUpdateInd = iAlternatePriceUpdateInd;
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
		public void setBillingEndDate(Date iBillingEndDate) {
			billingEndDate = iBillingEndDate;
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
		public void setBillingStartDate(Date iBillingStartDate) {
			billingStartDate = iBillingStartDate;
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
		public void setBumpId(String iBumpId) {
			bumpId = iBumpId;
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
		public void setCalculatedPrice(double iCalculatedPrice) {
			calculatedPrice = iCalculatedPrice;
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
		public void setChargeOption(String iChargeOption) {
			chargeOption = iChargeOption;
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
		public void setChargeOptionDesc(String iChargeOptionDesc) {
			chargeOptionDesc = iChargeOptionDesc;
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
		public void setCustomerId(int iCustomerId) {
			customerId = iCustomerId;
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
		public void setDmId(int iDmId) {
			dmId = iDmId;
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
		public void setEeDesc(String iEeDesc) {
			eeDesc = iEeDesc;
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
		public void setEeId(int iEeId) {
			eeId = iEeId;
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
		public void setEeItemNo(String iEeItemNo) {
			eeItemNo = iEeItemNo;
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
		public void setEeNo(String iEeNo) {
			eeNo = iEeNo;
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
		public void setEswPrice(double iEswPrice) {
			eswPrice = iEswPrice;
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
		public void setExclusionId(String iExclusionId) {
			exclusionId = iExclusionId;
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
		public void setLicenseType(String iLicenseType) {
			licenseType = iLicenseType;
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
		public void setListPrice(double iListPrice) {
			listPrice = iListPrice;
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
		public void setPlanEndDate(Date iPlanEndDate) {
			planEndDate = iPlanEndDate;
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
		public void setPlanStartDate(Date iPlanStartDate) {
			planStartDate = iPlanStartDate;
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
		public void setPletNo(String iPletNo) {
			pletNo = iPletNo;
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
		public void setProposalId(int iProposalId) {
			proposalId = iProposalId;
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
		public void setReqstDeliveryDate(Date iReqstDeliveryDate) {
			reqstDeliveryDate = iReqstDeliveryDate;
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
		public void setSalesDocNo(String iSalesDocNo) {
			salesDocNo = iSalesDocNo;
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
		public void setSequenceNo(int iSequenceNo) {
			sequenceNo = iSequenceNo;
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
		public void setSwoId(int iSwoId) {
			swoId = iSwoId;
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
		public void setSwoItemNo(String iSwoItemNo) {
			swoItemNo = iSwoItemNo;
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
		public void setUseLevel(String iUseLevel) {
			useLevel = iUseLevel;
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
		public void setValueMetric(String iValueMetric) {
			valueMetric = iValueMetric;
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
		 * @return 
		 */
		public double getSAndSDiscountPercent() {
			return sAndSDiscountPercent;
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
		 * @param d 
		 */
		public void setSAndSDiscountPercent(double iSAndSDiscountPercent) {
			sAndSDiscountPercent = iSAndSDiscountPercent;
		}
	

	/** 
	 * Get the Price DTO List from Domain DTO Object 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public List getPriceDTOList() {
		return priceDTOList;
	}

	/** 
	 * Set the Price List Object in Domain DTO Object 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
	public void setPriceDTOList(List iPriceDTOList) {
		priceDTOList = iPriceDTOList;
	}
	
	/**
		 * This method is used to copy inventory
		 * <br><b>Known Bugs</b><br> 
		 * 
		 * <br><PRE> 
		 * date Apr 26, 2004 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @return
		 * @author balajiv
		 */
	
	public String getSQL() {

			StringBuffer bufferSQL = new StringBuffer();
			OPPTCalender cal = new OPPTCalender();
            bufferSQL.append(
				"INSERT INTO BH.SYSTEMSWOEE (SWOEE_ID,PROPOSAL_ID,SOLD_TO_PARTY_ID,DESG_MACHINE_ID,SWO_ID,SALES_DOC_NO,EE_ITEM_NO,SWO_ITEM_NO,EE_NO,EE_DESC,PLAN_START_DATE,PLAN_END_DATE,REQST_DELIVRY_DATE,VALUE_METRIC,USE_LEVEL,LISC_TYPE,ESW_PRICE,CALC_PRICE,ALT_PRICE,BILLING_START_DATE,BILLING_END_DATE,EXCLUSION_ID,SEQUENCE_NO,BUMP_ID,CHARGE_OPTION,CHARGE_OPTION_DESC,ALT_PRICE_UPDATE_IND,LIST_PRICE,PLET_NO,S_S_DISCOUNT_PERCENT) VALUES ( ");
			bufferSQL.append(getEeId());
			bufferSQL.append(",");
			bufferSQL.append(getProposalId());
			bufferSQL.append(",");
			bufferSQL.append(getCustomerId());
			bufferSQL.append(",");
			bufferSQL.append(getDmId());
			bufferSQL.append(",");
			bufferSQL.append(getSwoId());
			bufferSQL.append(",'");
			bufferSQL.append(getSalesDocNo());
			bufferSQL.append("','");
			bufferSQL.append(getEeItemNo());
			bufferSQL.append("','");
			bufferSQL.append(getSwoItemNo());
			bufferSQL.append("','");
			bufferSQL.append(getEeNo());
			bufferSQL.append("','");
			bufferSQL.append(getEeDesc());
			bufferSQL.append("','");
			bufferSQL.append(cal.getDateString(getPlanStartDate()));
			bufferSQL.append("','");
			bufferSQL.append(cal.getDateString(getPlanEndDate()));
			bufferSQL.append("','");
			bufferSQL.append(cal.getDateString(getReqstDeliveryDate()));
			bufferSQL.append("','");
			bufferSQL.append(getValueMetric());
			bufferSQL.append("','");
			bufferSQL.append(getUseLevel());
			bufferSQL.append("','");
			bufferSQL.append(getLicenseType());
			bufferSQL.append("',");
			bufferSQL.append(getEswPrice());
			bufferSQL.append(",");
			bufferSQL.append(getCalculatedPrice());
			bufferSQL.append(",");
			bufferSQL.append(getAlternatePrice());
			bufferSQL.append(",'");
			bufferSQL.append(cal.getDateString(getBillingStartDate()));
			bufferSQL.append("','");
			bufferSQL.append(cal.getDateString(getBillingEndDate()));
			bufferSQL.append("','");
			bufferSQL.append(getExclusionId());
			bufferSQL.append("',");
			bufferSQL.append(getSequenceNo());
			bufferSQL.append(",'");
			bufferSQL.append(getBumpId());
			bufferSQL.append("','");
			bufferSQL.append(getChargeOption());
			bufferSQL.append("','");
			bufferSQL.append(getChargeOptionDesc());
			bufferSQL.append("','");
			bufferSQL.append(getAlternatePriceUpdateInd());
			bufferSQL.append("',");
			bufferSQL.append(getListPrice());
			bufferSQL.append(",'");
			bufferSQL.append(getPletNo());
			bufferSQL.append("',");
			bufferSQL.append(getSAndSDiscountPercent());
			bufferSQL.append(" )");

			return formatSQL(bufferSQL.toString());
		}

}
