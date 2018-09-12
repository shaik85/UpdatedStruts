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
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EECustomDTO;
/** 
 * This Domain DTOS have same attributes like SWOBDO.
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
public class SWODomainDTO extends OPPTDomainDTO {
	private int iSwoId;
	private int iProposalId;
	private int iCustomerId;
	private int iDmId;
	private String iLockedInd;
	private String iDeltaFetchId;
	private double iAdjustmentAmount;
	private String iPlanDateInd;
	private String iSwoContrType;
	private String iAlternatePriceUpdateInd;
	private String iSwoContrStatus;
	private String iSwoExtContrNo;
	private Date iAmendEndDate;
	private String iRefetchId;
	private Date iSwoAddedDate;
	private String iBumpInd;
	private Date iAmendStartDate;
	private String iAmendInd;
	private String iExclusionId;
	private String iSwoNo;
	private Date iLastUpdatedDate;
	private double iOldCalcPrice;
	private double iEswPrice;
	private String iPlannedInd;
	private String iAlternatePriceInd;
	private String iReferenceSerialNo;
	private String iReferenceSerialNoDM;
	private double iAlternatePrice;
	private double iCalcPrice;
	private String iSwoDesc;
	private String iSalesDocNo;
	private String iSwoItemNo;
	private String iEquipmentNo;
	private int iSequenceNo;
	private String iItemCategory;
	private Date iPlanStartDate;
	private String iCustomerPoNo;
	private Date iPlanEndDate;
	private String iSerialNo;
	private Date iRequestDeliveryDate;
	private String iIneligFlag;
	private String iComments;
	private Date iLicenseEffectiveDate;
	private String iSkipOption;
	private String iSAndSInd;
	private List iEEDTOList;
	
	//CR 2031
	private String iDuplicateDeletedInd;
	private boolean iMarkedForDeletion;

	/**
	 *  
	 * Empty Constructor 
	 * 
	 * <br/><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public SWODomainDTO() {

	}
	/**
	 *  
	 * Constructor 
	 * SWO Domain DTO Constructor takes the SWOBO object 
	 * Getter and setter methods act on the constructor itself 
	 * 
	 * <br/><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param swoBO
	 */
	public SWODomainDTO(SWOBO swoBO) {
		iSwoId = swoBO.getSwoId();
		iProposalId = swoBO.getProposalId();
		iCustomerId = swoBO.getCustomerId();
		iDmId = swoBO.getDmId();
		iLockedInd = swoBO.getLockedInd();
		iDeltaFetchId = swoBO.getDeltaFetchId();
		iAdjustmentAmount = swoBO.getAdjustmentAmount();
		iPlanDateInd = swoBO.getPlanDateInd();
		iSwoContrType = swoBO.getSwoContrType();
		iAlternatePriceUpdateInd = swoBO.getAlternatePriceUpdateInd();
		//System.out.println("SWODomainDTO.SWODomainDTO():iAlternatePriceUpdateInd:"+iAlternatePriceUpdateInd);
		iAlternatePriceInd = swoBO.getAlternatePriceInd();
		iSwoContrStatus = swoBO.getSwoContrStatus();
		iSwoExtContrNo = swoBO.getSwoExtContrNo();
		iAmendEndDate = swoBO.getAmendEndDate();
		iRefetchId = swoBO.getRefetchId();
		iSwoAddedDate = swoBO.getSwoAddedDate();
		iBumpInd = swoBO.getBumpInd();
		iAmendStartDate = swoBO.getAmendStartDate();
		iAmendInd = swoBO.getAmendInd();
		iExclusionId = swoBO.getExclusionId();
		iSwoNo = swoBO.getSwoNo();
		iLastUpdatedDate = swoBO.getLastUpdatedDate();
		iOldCalcPrice = swoBO.getOldCalcPrice();
		iEswPrice = swoBO.getEswPrice();
		iPlannedInd = swoBO.getPlannedInd();
		iAlternatePriceInd = swoBO.getAlternatePriceInd();
		iReferenceSerialNo = swoBO.getReferenceSerialNo();
		iReferenceSerialNoDM = swoBO.getReferenceSerialNoDM();
		iAlternatePrice = swoBO.getAlternatePrice();
		iCalcPrice = swoBO.getCalcPrice();
		iSwoDesc = swoBO.getSwoDesc();
		iSalesDocNo = swoBO.getSalesDocNo();
		iSwoItemNo = swoBO.getSwoItemNo();
		iEquipmentNo = swoBO.getEquipmentNo();
		iSequenceNo = swoBO.getSequenceNo();
		iItemCategory = swoBO.getItemCategory();
		iPlanStartDate = swoBO.getPlanStartDate();
		iCustomerPoNo = swoBO.getCustomerPoNo();
		iPlanEndDate = swoBO.getPlanEndDate();
		iSerialNo = swoBO.getSerialNo();
		iSAndSInd = swoBO.getSAndSInd();
		iRequestDeliveryDate = swoBO.getRequestDeliveryDate();
		
		iDuplicateDeletedInd = swoBO.getDuplicateDeletedInd();

	}

	/**
		 * get the Adjustment Amount  
		 * <br><b>Known Bugs</b><br> 
		 * 
		 * <br><PRE> 
		 * date Nov 21, 2003 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @return AdjustmentAmount
		 */
	public double getAdjustmentAmount() {
		return iAdjustmentAmount;
	}

	/**
	 * Get the Alternate Price  
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
		//System.out.println("SWODomainDTO.getAlternatePrice()"+iAlternatePrice);
		
				return iAlternatePrice;
	}

	/**
	 * get Alternate Price Indicator  
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
	public String getAlternatePriceInd() {
		return iAlternatePriceInd;
	}

	/**
	 * get Alternate Price Updated Indicator  
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
		/*if(iAlternatePrice > 0)
		{
			iAlternatePriceUpdateInd="Y";	
		}
		System.out.println("SWODomainDTO.getAlternatePriceUpdateInd()iAlternatePriceUpdateInd"+iAlternatePriceUpdateInd);*/
		return iAlternatePriceUpdateInd;
	}

	/**
	 * Get Amendment End Date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return AmendEndDate
	 */
	public Date getAmendEndDate() {
		return iAmendEndDate;
	}

	/**
	 * Get Amendment Indicator  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return AmendInd
	 */
	public String getAmendInd() {
		return iAmendInd;
	}

	/**
	 * Get Amendment start date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return AmendStartDate
	 */
	public Date getAmendStartDate() {
		return iAmendStartDate;
	}

	/**
	 * Get Bump Indicator  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return BumpInd
	 */
	public String getBumpInd() {
		return iBumpInd;
	}

	/**
	 * get the calcultaed price  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CalcPrice
	 */
	public double getCalcPrice() {
		//System.out.println("SWODomainDTO.getCalcPrice()"+iCalcPrice);
		return iCalcPrice;
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
	 * get Customer Purchase Order No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CustomerPoNo
	 */
	public String getCustomerPoNo() {
		return iCustomerPoNo;
	}

	/**
	 * get Delta Fetch Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DeltaFetchId
	 */
	public String getDeltaFetchId() {
		return iDeltaFetchId;
	}

	/**
	 * Get DM Id  
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
	 * Get the Equipment No  
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
	public String getEquipmentNo() {
		return iEquipmentNo;
	}

	/**
	 * Get the ESW Price  
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
	 * Get Exclusion Id  
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
	 * Get Item Category  
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
	public String getItemCategory() {
		return iItemCategory;
	}

	/**
	 * Get Last Updated Date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return LastUpdatedDate
	 */
	public Date getLastUpdatedDate() {
		return iLastUpdatedDate;
	}

	/**
	 * Get Locked Indicator  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return LockedInd
	 */
	public String getLockedInd() {
		return iLockedInd;
	}

	/**
	 * get Old calculated Price  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return OldCalcPrice
	 */
	public double getOldCalcPrice() {
		return iOldCalcPrice;
	}

	/**
	 * Get Plan date Indicator  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PlanDateInd
	 */
	public String getPlanDateInd() {
		return iPlannedInd;
	}

	/**
	 * Get Plan End date  
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
	 * Get Planned Indicator  
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
	public String getPlannedInd() {
		return iPlannedInd;
	}

	/**
	 * Get Plan start date  
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
	 * get Proposal Id 
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
	 * Get the Reference serial No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ReferenceSerialNo
	 */
	public String getReferenceSerialNo() {
		return iReferenceSerialNo;
	}

	/**
	 * Get Reference Serial No DM  
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
	public String getReferenceSerialNoDM() {
		return iReferenceSerialNoDM;
	}

	/**
	 * Get Refetch Id 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RefetchId
	 */
	public String getRefetchId() {
		return iRefetchId;
	}

	/**
	 * Get Request delivery date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return RequestDeliveryDate
	 */
	public Date getRequestDeliveryDate() {
		return iRequestDeliveryDate;
	}

	/**
	 * Get Sales Document No 
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
	 * Get Sequence No  
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
	 * Get Serial No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SerialNo
	 */
	public String getSerialNo() {
		return iSerialNo;
	}

	/**
	 * get SWO Added Date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SwoAddedDate
	 */
	public Date getSwoAddedDate() {
		return iSwoAddedDate;
	}

	/**
	 * get SWO Contract Status  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SwoContrStatus
	 */
	public String getSwoContrStatus() {
		return iSwoContrStatus;
	}

	/**
	 * Get SWO Contract type  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SwoContrType
	 */
	public String getSwoContrType() {
		return iSwoContrType;
	}

	/**
	 * Get SWO Description  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SwoDesc
	 */
	public String getSwoDesc() {
		return iSwoDesc;
	}

	/**
	 * Get SWO External Contract No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SwoExtContrNo
	 */
	public String getSwoExtContrNo() {
		return iSwoExtContrNo;
	}

	/**
	 * Get SWO Id  
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
		//System.out.println("SWODomainDTO.getSwoId()"+iSwoId);
		return iSwoId;
	}

	/**
	 * Get SWO Item No  
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
	 * Get SWO No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SwoNo
	 */
	public String getSwoNo() {
		return iSwoNo;
	}

	/**
	 * Set the Adjustment Amount 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param adjustmentAmount
	 */
	public void setAdjustmentAmount(double adjustmentAmount) {
		iAdjustmentAmount = adjustmentAmount;
	}

	/**
	 * set the Alternate Price  
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
	 * set Alternate Price Indicator  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param alternatePriceInd
	 */
	public void setAlternatePriceInd(String alternatePriceInd) {
		iAlternatePriceInd = alternatePriceInd;
	}

	/**
	 * set Alternate Price Updated Indicator  
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
	 * set Amendment End date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param amendEndDate
	 */
	public void setAmendEndDate(Date amendEndDate) {
		iAmendEndDate = amendEndDate;
	}

	/**
	 * set Amendment Indicator  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param amendInd
	 */
	public void setAmendInd(String amendInd) {
		iAmendInd = amendInd;
	}

	/**
	 * set Amend Start date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param amendStartDate
	 */
	public void setAmendStartDate(Date amendStartDate) {
		iAmendStartDate = amendStartDate;
	}

	/**
	 * set Bump Indicator  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param bumpInd
	 */
	public void setBumpInd(String bumpInd) {
		iBumpInd = bumpInd;
	}

	/**
	 * set Calculated Price  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param calcPrice
	 */
	public void setCalcPrice(double calcPrice) {
		iCalcPrice = calcPrice;
	}

	/**
	 * set the Customer Id  
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
	 * set the Customer Purchase Order No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerPoNo
	 */
	public void setCustomerPoNo(String customerPoNo) {
		iCustomerPoNo = customerPoNo;
	}

	/**
	 * set the Delta Fetch Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param deltaFetchId
	 */
	public void setDeltaFetchId(String deltaFetchId) {
		iDeltaFetchId = deltaFetchId;
	}

	/**
	 * set the DM Id  
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
	 * set the Equipment No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param equipmentNo
	 */
	public void setEquipmentNo(String equipmentNo) {
		iEquipmentNo = equipmentNo;
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
	 * set the Exclusion Id  
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
	 * set the Item category  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param itemCategory
	 */
	public void setItemCategory(String itemCategory) {
		iItemCategory = itemCategory;
	}

	/**
	 * set the last updated date 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lastUpdatedDate
	 */
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		iLastUpdatedDate = lastUpdatedDate;
	}

	/**
	 * set Locked Indicator  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lockedInd
	 */
	public void setLockedInd(String lockedInd) {
		iLockedInd = lockedInd;
	}

	/**
	 * set old calculated  Price  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param oldCalcPrice
	 */
	public void setOldCalcPrice(double oldCalcPrice) {
		iOldCalcPrice = oldCalcPrice;
	}

	/**
	 * set plan date indicator   
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param planDateInd
	 */
	public void setPlanDateInd(String planDateInd) {
		iPlanDateInd = planDateInd;
	}

	/**
	 * set Plan End Date  
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
	 * set Planned Indicator  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param plannedInd
	 */
	public void setPlannedInd(String plannedInd) {
		iPlannedInd = plannedInd;
	}

	/**
	 * set Plan Start Date  
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
	 * set the Proposal Id  
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
	 * set Reference serial No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param referenceSerialNo
	 */
	public void setReferenceSerialNo(String referenceSerialNo) {
		iReferenceSerialNo = referenceSerialNo;
	}

	/**
	 * set Reference serial no dm  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param referenceSerialNoDM
	 */
	public void setReferenceSerialNoDM(String referenceSerialNoDM) {
		iReferenceSerialNoDM = referenceSerialNoDM;
	}

	/**
	 * set Refetch Id  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param refetchId
	 */
	public void setRefetchId(String refetchId) {
		iRefetchId = refetchId;
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
	 * @param requestDeliveryDate
	 */
	public void setRequestDeliveryDate(Date requestDeliveryDate) {
		iRequestDeliveryDate = requestDeliveryDate;
	}

	/**
	 * set Sales Doc No  
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
	 * set Sequence No  
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
	 * set Serial No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param serialNo
	 */
	public void setSerialNo(String serialNo) {
		iSerialNo = serialNo;
	}

	/**
	 * set SWO Added Date  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoAddedDate
	 */
	public void setSwoAddedDate(Date swoAddedDate) {
		iSwoAddedDate = swoAddedDate;
	}

	/**
	 * set SWO Contract Status  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoContrStatus
	 */
	public void setSwoContrStatus(String swoContrStatus) {
		iSwoContrStatus = swoContrStatus;
	}

	/**
	 * set SWO Contract Type  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoContrType
	 */
	public void setSwoContrType(String swoContrType) {
		iSwoContrType = swoContrType;
	}

	/**
	 * set SWO Description  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoDesc
	 */
	public void setSwoDesc(String swoDesc) {
		iSwoDesc = swoDesc;
	}

	/**
	 * set SWO External Contract No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoExtContrNo
	 */
	public void setSwoExtContrNo(String swoExtContrNo) {
		iSwoExtContrNo = swoExtContrNo;
	}

	/**
	 * set SWOId  
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
	 * set SWO No  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoNo
	 */
	public void setSwoNo(String swoNo) {
		iSwoNo = swoNo;
	}

	/** 
	 * Get EE Domain DTO list in SWO Domain DTO 
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
	public List getEEDTOList() {
		return iEEDTOList;
	}

	/**
     * Set EE Domain DTO list in SWO Domain DTO
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 28, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param eeDTOList 
     */
	public void setEEDTOList(List eeDTOList) {
		iEEDTOList = eeDTOList;
	}

	/** 
	 * Get the ineligible flag  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String 
	 */
	public String getIneligFlag() {
		return iIneligFlag;
	}

	/**
     * Set the Ineligible flag
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 8, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param ineligFlag 
     */
	public void setIneligFlag(String ineligFlag) {
		iIneligFlag = ineligFlag;
	}

	/** 
	 * Get the ineligible comments 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getComments() {
		return iComments;
	}

	/**
     * set the ineligible comments
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 9, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param comments 
     */
	public void setComments(String comments) {
		iComments = comments;
	}

	/** 
	 * Get the license effective date
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public Date getLicenseEffectiveDate() {
		return iLicenseEffectiveDate;
	}

	/**
     * set the license effective date
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 9, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param licenseEffectiveDate 
     */
	public void setLicenseEffectiveDate(Date licenseEffectiveDate) {
		iLicenseEffectiveDate = licenseEffectiveDate;
	}

	/** 
	 * Set the Skip value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getSkipOption() {
		return iSkipOption;
	}

	/**
     * Set the Skip option
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 11, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param skipOption 
     */
	public void setSkipOption(String skipOption) {
		iSkipOption = skipOption;
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
	public String getSAndSInd() {
		return iSAndSInd;
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
	public void setSAndSInd(String string) {
		iSAndSInd = string;
	}
	/**
	 * Added for batch update
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 27, 2004 
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
		//System.out.println("SWODomainDTO.getSQL()");

		bufferSQL.append(
			"INSERT INTO BH.SYSTEMSWO (SWO_ID,PROPOSAL_ID,SOLD_TO_PARTY_ID,DESG_MACHINE_ID,SWO_NO,SWO_DESC,SALES_DOC_NO,SWO_ITEM_NO,SEQUENCE_NO,ITEM_CATEGORY,PLAN_START_DATE,PLAN_END_DATE,REQST_DELIVRY_DATE,SERIAL_NO,CUSTOMER_PO_NO,EQUIPMENT_NO,ESW_PRICE,CALC_PRICE,ALT_PRICE,REF_SERIAL_NO,REF_SER_NO_DESGMC,LOCKED_IND,ALT_PRICE_IND,PLANNED_IND,AMDT_IND,LAST_UPDATED_DATE,EXCLUSION_ID,BUMP_IND,AMDT_START_DATE,AMDT_END_DATE,SWO_ADDED_DATE,RE_FETCH_ID,DELTA_FETCH_ID,OLD_CALC_PRICE,ADJUSTMENT_AMT,SWO_EXT_CNTR_NUM,SWO_CNTR_STATUS,SWO_CNTR_TYPE,ALT_PRICE_UPDATE_IND,S_S_INDICATOR,PLAN_DATE_IND) values ( ");
		bufferSQL.append(getSwoId());
		bufferSQL.append(",");
		bufferSQL.append(getProposalId());
		bufferSQL.append(",");
		bufferSQL.append(getCustomerId());
		bufferSQL.append(",");
		bufferSQL.append(getDmId());
		bufferSQL.append(",'");
		bufferSQL.append(getSwoNo());
		bufferSQL.append("','");
		bufferSQL.append(getSwoDesc());
		bufferSQL.append("','");
		bufferSQL.append(getSalesDocNo());
		bufferSQL.append("','");
		bufferSQL.append(getSwoItemNo());
		bufferSQL.append("',");
		bufferSQL.append(getSequenceNo());
		bufferSQL.append(",'");
		bufferSQL.append(getItemCategory());
		bufferSQL.append("','");
		bufferSQL.append(cal.getDateString(getPlanStartDate()));
		bufferSQL.append("','");
		bufferSQL.append(cal.getDateString(getPlanEndDate()));
		bufferSQL.append("','");
		bufferSQL.append(cal.getDateString(getRequestDeliveryDate()));
		bufferSQL.append("','");
		bufferSQL.append(getSerialNo());
		bufferSQL.append("','");
		bufferSQL.append(getCustomerPoNo());
		bufferSQL.append("','");
		bufferSQL.append(getEquipmentNo());
		bufferSQL.append("',");
		bufferSQL.append(getEswPrice());
		bufferSQL.append(",");
		bufferSQL.append(getCalcPrice());
		bufferSQL.append(",");
		bufferSQL.append(getAlternatePrice());
		bufferSQL.append(",'");
		bufferSQL.append(getReferenceSerialNo());
		bufferSQL.append("','");
		bufferSQL.append(getReferenceSerialNoDM());
		bufferSQL.append("','");
		bufferSQL.append(getLockedInd());
		bufferSQL.append("','");
		bufferSQL.append(getAlternatePriceInd());
		bufferSQL.append("','");
		bufferSQL.append(getPlannedInd());
		bufferSQL.append("','");
		bufferSQL.append(getAmendInd());
		bufferSQL.append("','");
		bufferSQL.append(cal.getDateString(getLastUpdatedDate()));
		bufferSQL.append("','");
		bufferSQL.append(getExclusionId());
		bufferSQL.append("','");
		bufferSQL.append(getBumpInd());
		bufferSQL.append("','");
		bufferSQL.append(cal.getDateString(getAmendStartDate()));
		bufferSQL.append("','");
		bufferSQL.append(cal.getDateString(getAmendEndDate()));
		bufferSQL.append("','");
		bufferSQL.append(cal.getDateString(getSwoAddedDate()));
		bufferSQL.append("','");
		bufferSQL.append(getRefetchId());
		bufferSQL.append("','");
		bufferSQL.append(getDeltaFetchId());
		bufferSQL.append("',");
		bufferSQL.append(getOldCalcPrice());
		bufferSQL.append(",");
		bufferSQL.append(getAdjustmentAmount());
		bufferSQL.append(",'");
		bufferSQL.append(getSwoExtContrNo());
		bufferSQL.append("','");
		bufferSQL.append(getSwoContrStatus());
		bufferSQL.append("','");
		bufferSQL.append(getSwoContrType());
		bufferSQL.append("','");
		bufferSQL.append(getAlternatePriceUpdateInd());
		bufferSQL.append("','");
		bufferSQL.append(getSAndSInd());
		bufferSQL.append("','");
		bufferSQL.append(getPlanDateInd());
		bufferSQL.append("' )");

		return formatSQL(bufferSQL.toString());
	}
	/** finalize */
	/*protected void finalize() {
		if (null != iEEDTOList) {
			iEEDTOList.clear();
			iEEDTOList = null;
		}
	}*/

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
	 * date Oct 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getDuplicateDeletedInd() {
		return iDuplicateDeletedInd;
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
	 * date Oct 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setDuplicateDeletedInd(String string) {
		iDuplicateDeletedInd = string;
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
	 * date Nov 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isMarkedForDeletion() {
		return iMarkedForDeletion;
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
	 * date Nov 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setMarkedForDeletion(boolean b) {
		iMarkedForDeletion = b;
	}

}
