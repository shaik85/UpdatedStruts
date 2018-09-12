/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;


import java.util.StringTokenizer;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ComplexContractIdentifiers;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;


public class ProposalHeaderActionForm extends OPPTActionForm {
	private BasicProposalDataBean basicProposalData = null;
	private PricingInformationDataBean pricingInformation = null;
	private VarianceDataBean varianceData = null;
	private SecondaryProposalDataBean secondaryProposalData = null;

	private DateDataBean contractStartDate = null;
	private DateDataBean contractEndDate = null;
	private DateDataBean contractPeriodStartDate = null;
	private DateDataBean contractPeriodEndDate = null;
	private DateDataBean purchaseOrderDate = null;
	private DateDataBean fixedValueDate = null;
	private DateDataBean replacementDate = null;
	private DateDataBean varianceDate = null;

	private String capAmount = null;
	private String capMinus = null;
	private String capPlus = null;
	private String proposalStatus = null;
	
	private boolean varianceProposal = false;

	/**
	 * Returns basic proposal data of proposal header 
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
	 * @return BasicProposalDataBean 
	 */
	public BasicProposalDataBean getBasicProposalData() {
		if (null == basicProposalData) {
			basicProposalData = new BasicProposalDataBean();
		}
		return basicProposalData;
	}

	/**
	 * Returns pricing information of proposal header 
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
	 * @return PricingInformationDataBean 
	 */
	public PricingInformationDataBean getPricingInformation() {
		if (null == pricingInformation) {
			pricingInformation = new PricingInformationDataBean();
		}
		return pricingInformation;
	}

	/**
	 * Returns secondary proposal information of proposal header 
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
	 * @return SecondaryProposalDataBean 
	 */
	public SecondaryProposalDataBean getSecondaryProposalData() {
		if (null == secondaryProposalData) {
			secondaryProposalData = new SecondaryProposalDataBean();
		}
		return secondaryProposalData;
	}

	/**
	 * Returns variance information from proposal header 
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
	 * @return VarianceDataBean 
	 */
	public VarianceDataBean getVarianceData() {
		if (null == varianceData) {
			varianceData = new VarianceDataBean();
		}
		return varianceData;
	}

	/**
	 * Returns contract end date information 
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
	 * @return DateDataBean
	 */
	public DateDataBean getContractEndDate() {
		if (null == contractEndDate) {
			contractEndDate = new DateDataBean();
		}
		return contractEndDate;
	}

	/**
	 * Returns contract period beginning information 
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
	 * @return DateDataBean
	 */
	public DateDataBean getContractPeriodStartDate() {
		if (null == contractPeriodStartDate) {
			contractPeriodStartDate = new DateDataBean();
		}
		return contractPeriodStartDate;
	}

	/**
	 * Returns contract period beginning 
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
	 * @return DateDataBean
	 */
	public DateDataBean getContractPeriodEndDate() {
		if (null == contractPeriodEndDate) {
			contractPeriodEndDate = new DateDataBean();
		}
		return contractPeriodEndDate;
	}

	/**
	 * Returns contract start date 
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
	 * @return DateDataBean
	 */
	public DateDataBean getContractStartDate() {
		if (null == contractStartDate) {
			contractStartDate = new DateDataBean();
		}
		return contractStartDate;
	}

	/**
	 * Returns fixed value date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DateDataBean
	 */
	public DateDataBean getFixedValueDate() {
		if (null == fixedValueDate) {
			fixedValueDate = new DateDataBean();
		}
		return fixedValueDate;
	}

	/**
	 * Returns purchase order date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DateDataBean
	 */
	public DateDataBean getPurchaseOrderDate() {
		if (null == purchaseOrderDate) {
			purchaseOrderDate = new DateDataBean();
		}
		return purchaseOrderDate;
	}

	/**
	 * Sets basic proposal information 
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
	 * @param newBasicProposalData BasicProposalData 
	 */
	public void setBasicProposalData(BasicProposalDataBean newBasicProposalData) {
		basicProposalData = newBasicProposalData;
	}

	/**
	 * Sets pricing information 
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
	 * @param newPricingInformation PricingInformation 
	 */
	public void setPricingInformation(PricingInformationDataBean newPricingInformation) {
		pricingInformation = newPricingInformation;
	}

	/**
	 * Sets secondary proposal data 
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
	 * @param newSecondaryProposalData SecondaryProposalData 
	 */
	public void setSecondaryProposalData(SecondaryProposalDataBean newSecondaryProposalData) {
		secondaryProposalData = newSecondaryProposalData;
	}

	/**
	 * Sets variance data 
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
	 * @param newVarianceData VarianceData 
	 */
	public void setVarianceData(VarianceDataBean newVarianceData) {
		varianceData = newVarianceData;
	}

	/**
	 * Sets contract end date 
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
	 * @param newContractEndDate DateDataBean 
	 */
	public void setContractEndDate(DateDataBean newContractEndDate) {
		contractEndDate = newContractEndDate;
	}

	/**
	 * Sets contract period beginning information 
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
	 * @param newContractPeriodStartDate DateDataBean 
	 */
	public void setContractPeriodStartDate(DateDataBean newContractPeriodStartDate) {
		contractPeriodStartDate = newContractPeriodStartDate;
	}

	/**
	 * Sets contract period end date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractPeriodEndDate DateDataBean 
	 */
	public void setContractPeriodEndDate(DateDataBean newContractPeriodEndDate) {
		contractPeriodEndDate = newContractPeriodEndDate;
	}

	/**
	 * Sets contract start date information 
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
	 * @param newContractStartDate DateDataBean 
	 */
	public void setContractStartDate(DateDataBean newContractStartDate) {
		contractStartDate = newContractStartDate;
	}

	/**
	 * Sets fixed value date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newFixedValueDate DateDataBean 
	 */
	public void setFixedValueDate(DateDataBean newFixedValueDate) {
		fixedValueDate = newFixedValueDate;
	}

	/**
	 * Sets purchase order date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPurchaseOrderDate DateDataBean 
	 */
	public void setPurchaseOrderDate(DateDataBean newPurchaseOrderDate) {
		purchaseOrderDate = newPurchaseOrderDate;
	}

	/**
	 * Returns cap amount value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCapAmount() {
		return capAmount;
	}

	/**
	 * Returns cap minus value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCapMinus() {
		return capMinus;
	}

	/**
	 * Returns cap plus value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCapPlus() {
		return capPlus;
	}

	/**
	 * Sets cap amount value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCapAmount String 
	 */
	public void setCapAmount(String newCapAmount) {
		capAmount = newCapAmount;
	}

	/**
	 * Sets cap minus value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCapMinus String 
	 */
	public void setCapMinus(String newCapMinus) {
		capMinus = newCapMinus;
	}

	/**
	 * Sets cap plus value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCapPlus String 
	 */
	public void setCapPlus(String newCapPlus) {
		capPlus = newCapPlus;
	}

	public void reset(){
		basicProposalData = null;
		pricingInformation = null;
		varianceData = null;
		secondaryProposalData = null;
		
		contractStartDate = null;
		contractEndDate = null;
		contractPeriodStartDate = null;
		contractPeriodEndDate = null;
		
		purchaseOrderDate = null;
		fixedValueDate = null;
		replacementDate = null;
		
		capAmount = null;
		capMinus = null;
		capPlus = null;
	}
	
	/**
	 * Returns replacement date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DateDataBean
	 */
	public DateDataBean getReplacementDate() {
		if(null == replacementDate){
			replacementDate = new DateDataBean();
		}
		return replacementDate;
	}

	/**
	 * Sets replacement date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newReplacementDate DateDataBean
	 */
	public void setReplacementDate(DateDataBean newReplacementDate) {
		replacementDate = newReplacementDate;
	}

	/**
	 * Populates the custome dto with all the input values for proposal header  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTO ProposalHeaderCustomDTO
	 */
	public void getRequestParams(ProposalHeaderCustomDTO customDTO) {
		customDTO.setBasicProposalCustomDTO(getBasicProposalRequestParams());
		customDTO.setSecondaryProposalCustomDTO(getSecondaryProposalRequestParams());
		customDTO.setPricingInformationCustomDTO(getPricingRequestParams());
		customDTO.setVarianceInformationCustomDTO(getVarianceRequestParams());
	}

	private BasicProposalCustomDTO getBasicProposalRequestParams() {
		BasicProposalCustomDTO customDTO = new BasicProposalCustomDTO();
		
		String salesOrg = getBasicProposalData().getSalesOrganization();
		if(null != salesOrg){
			StringTokenizer st = new StringTokenizer(salesOrg, "|");
			if(1 < st.countTokens()){
				customDTO.setSalesOrganization(st.nextToken());
			}
		}
		//customDTO.setDistributionChannel(getBasicProposalData().getDistributionChannel()); commented by Ramesh
		// BH Wave1 - DADO14 - Distribution Channel- Added by Ramesh
		//As per the new requirement the Distribution channel is the combination of DistributionChannel,Salesarea,Channelrole,Submitterrole.
		String dstrChannelId=getBasicProposalData().getDistributionChannel();
		String[] dstrchannel = dstrChannelId.trim().split("\\|");
		customDTO.setDistributionChannel(dstrchannel[0]);
    	customDTO.setSalesGroup(dstrchannel[1]);
    	customDTO.setChannelRole(dstrchannel[2]);
    	customDTO.setSubmitterRole(dstrchannel[3]);
		customDTO.setDivision(getBasicProposalData().getDivision());
		customDTO.setCurrencyCode(getBasicProposalData().getCurrencyCode());
		// BH Wave1 - DAD003 - Complex Contract Identifiers - Begin
		ComplexContractIdentifiers complexContractIdentifiers = ComplexContractIdentifiers.getComplexContractIdentifiers();
		customDTO.setCpsID(getBasicProposalData().getCpsID());
		customDTO.setOcpsID(basicProposalData.getOcpsID());
		customDTO.setContractType(basicProposalData.getContractType());
		customDTO.setBlbIndicator(complexContractIdentifiers.getBlbIndicator());
		//customDTO.setBlbIndicator(getBasicProposalData().getBlbIndicator());
		customDTO.setIsPreBillIndicator(getPricingInformation().isPrebillIndicator());
		// BH Wave1 - DAD003 - Complex Contract Identifiers - End
		customDTO.setProposalName(getBasicProposalData().getProposalName());
		customDTO.setProposalType(getBasicProposalData().getProposalType());
		customDTO.setReportName(getBasicProposalData().getReportName());
		customDTO.setExternalContractNumber(getBasicProposalData().getExternalContractNumber());
		customDTO.setContractStartDate(getContractStartDate().getDate());
		customDTO.setContractEndDate(getContractEndDate().getDate());
		customDTO.setContractPeriodBeginning(getContractPeriodStartDate().getDate());
		customDTO.setContractPeriodEnding(getContractPeriodEndDate().getDate());
		customDTO.setProposalContent(getDefaultOptionValue(getBasicProposalData().getProposalContent()));
		if(null != getBasicProposalData().getReplacementContractNumber() && 0 < getBasicProposalData().getReplacementContractNumber().length()){
			customDTO.setReplacementContractNumber(getBasicProposalData().getReplacementContractNumber());
		}
		customDTO.setReplacementContractDate(getReplacementDate().getDate());
		
		return customDTO;
	}

	private SecondaryProposalCustomDTO getSecondaryProposalRequestParams() {
		SecondaryProposalCustomDTO customDTO = new SecondaryProposalCustomDTO();
		customDTO.setPurchaseOrderNumber(getSecondaryProposalData().getPurchaseOrderNumber());
		customDTO.setPaymentTerms(getSecondaryProposalData().getPaymentTerms());
		customDTO.setIgfOfferNumber(getSecondaryProposalData().getIgfOfferNumber());
		customDTO.setComments(getSecondaryProposalData().getComments());
		customDTO.setAddValueDays(getSecondaryProposalData().getAddValueDays());
		customDTO.setSandsExcluded(getSecondaryProposalData().isSandsExcluded());
		customDTO.setFixedValDate(getFixedValueDate().getDate());
		customDTO.setPurchaseOrderDate(getPurchaseOrderDate().getDate());
		return customDTO;
	}

	private PricingInformationCustomDTO getPricingRequestParams() {
		PricingInformationCustomDTO customDTO = new PricingInformationCustomDTO();
		customDTO.setPlannedGrowthOption(getPricingInformation().getPlannedGrowthOption());
		customDTO.setPlannedGrowthValue(getDoubleValue(getPricingInformation().getPlannedGrowthValue()));
		customDTO.setBillingFrequency(getPricingInformation().getBillingFrequency());
		customDTO.setGrowthLimitValue(getDoubleValue(getPricingInformation().getGrowthLimitValue()));
		customDTO.setGrowthLimitOption(getPricingInformation().getGrowthLimitOption());
		customDTO.setTvmRate(getDoubleValue(getPricingInformation().getTvmRate()));
		customDTO.setAdditionalGrowthLimit(getDoubleValue(getPricingInformation().getAdditionalGrowthLimit()));
		customDTO.setPakid(getPricingInformation().getPakid());
		System.out.println("ProposalHeaderActionForm.getPricingRequestParams:DISCOUNT()1:"+getDoubleValue(getPricingInformation().getDiscount()));
		customDTO.setDiscount(getDoubleValue(getPricingInformation().getDiscount()));
		customDTO.setAnniversaryContractAmount(getDoubleValue(getPricingInformation().getAnniversaryContractAmount()));
	    /*CR6153 start changes  */
		customDTO.setExtendPeriod(getPricingInformation().isExtendPeriod());
		
		//<!-- BlueHarmony DAD006  changed by Anand Sugumaran  --> 
	/*	customDTO.setSAndSAnniversaryContractAmount(getDoubleValue(getPricingInformation().getSsAnninversaryContractAmount(), -1));
		customDTO.setSAndSAnniversaryContractAmountPeriod2(getDoubleValue(getPricingInformation().getSsAnninversaryAmountPeriod2(),-1));
		customDTO.setSAndSAnniversaryContractAmountPeriod3(getDoubleValue(getPricingInformation().getSsAnninversaryAmountPeriod3(),-1));
		customDTO.setSAndSAnniversaryContractAmountPeriod4(getDoubleValue(getPricingInformation().getSsAnninversaryAmountPeriod4(),-1));
		customDTO.setSAndSAnniversaryContractAmountPeriod5(getDoubleValue(getPricingInformation().getSsAnninversaryAmountPeriod5(),-1));
        CR6153 end changes 
        //<!-- BlueHarmony DAD006  changed by Anand Sugumaran  --> 
	*/	customDTO.setDetailedInvoice(getPricingInformation().isDetailedInvoice());
		customDTO.setGsa(getPricingInformation().isGsa());
		customDTO.setBillingBlock(getPricingInformation().getBillingBlock());
		customDTO.setDeviatingDateRule(getPricingInformation().getDeviatingDateRule());
		customDTO.setBillingDateRule(getPricingInformation().getBillingDateRule());
		customDTO.setFreeTextForInvoicePrint(getPricingInformation().getFreeTextForInvoicePrint());
		customDTO.setAdvance(getPricingInformation().isAdvance());
		// BH Wave-1 - DAD003 - Complex Contract Identifiers - Manoj - Begin
		customDTO.setPrebillIndicator(getPricingInformation().isPrebillIndicator());
		// BH Wave-1 - DAD003 - Complex Contract Identifiers - Manoj - Begin
		return customDTO;
	}

	private VarianceInformationCustomDTO getVarianceRequestParams() {
		VarianceInformationCustomDTO customDTO = new VarianceInformationCustomDTO();
		customDTO.setCapAmount(getVarianceData().getCapAmount());
		customDTO.setCapPlus(getVarianceData().getCapPlus());
		customDTO.setCapMinus(getVarianceData().getCapMinus());
		return customDTO;
	}

	/**
	 * Returns the planned growth option value based on the planned growth option selected  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPlannedGrowthOptionValue(){
		String optionValue = null;
		String value = getPricingInformation().getPlannedGrowthOption();
		
		if(value.equals("Nil") || value.equals("3") || value.equals("6")){
			optionValue = "";
		}
		else{
			optionValue = getPricingInformation().getPlannedGrowthValue();
		}
		return optionValue;
	}

	/**
	 * Returns the growth limit option value based on the growth limit option selected  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getGrowthLimitOptionValue(){
		String optionValue = null;
		String value = getPricingInformation().getGrowthLimitOption();
		
		if(value.equals("Nil") || value.equals("7") || value.equals("15")){
			optionValue = "";
		}
		else{
			optionValue = getPricingInformation().getGrowthLimitValue();
		}
		return optionValue;
	}

	/* (non-Javadoc)
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm#validate()
	 */
	public ErrorReport validate() {
		ErrorReport errorReport = new ErrorReport();
	
	boolean japan = false;
		if (basicProposalData != null) {
			if (UtilityConstants.JAPAN_CURRENCY.equals(OPPTHelper.trimString(basicProposalData.getSalesOrganization()))) {
				japan = true;
			}
		}
	boolean korea = false;
		if (basicProposalData != null) {
			if (UtilityConstants.KOREA_CURRENCY.equals(OPPTHelper.trimString(basicProposalData.getSalesOrganization()))) {
				korea = true;
			}
		}

		boolean vietnam = false;
		if (basicProposalData != null) {
			if (UtilityConstants.VIETNAM_CURRENCY.equals(OPPTHelper.trimString(basicProposalData.getSalesOrganization()))) {
				vietnam = true;
			}
		}

		double value = -1;
		if(!isFieldEmpty(getPricingInformation().getAnniversaryContractAmount())){
			if(isValidDouble(getPricingInformation().getAnniversaryContractAmount())){
				value = getDoubleValue(getPricingInformation().getAnniversaryContractAmount());
				if (japan || korea) {
					if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_AMOUNT_FOR_JAPAN < value) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF113, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
					if(OPPTHelper.decimalCheck(value)) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF116, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
				} 
				else if(vietnam){
					if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_AMOUNT_FOR_VIETNAM < value) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF121, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
					if(OPPTHelper.decimalCheck(value)) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF124, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
				}
				
				
				
				else {
					if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_ANNV_AMOUNT < value) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF16, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
					}
			}
			else{
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF84, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		
		if(!isFieldEmpty(getPricingInformation().getSsAnninversaryContractAmount())){
			if(isValidDouble(getPricingInformation().getSsAnninversaryContractAmount())){
				value = getDoubleValue(getPricingInformation().getSsAnninversaryContractAmount());
				if (japan || korea ) {
					if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_AMOUNT_FOR_JAPAN < value) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF114, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
					if(OPPTHelper.decimalCheck(value)) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF117, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
				}
				else if(vietnam){				

					if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_AMOUNT_FOR_VIETNAM < value) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF122, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
					if(OPPTHelper.decimalCheck(value)) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF125, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}	
				}
				else {
					if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_ANNV_AMOUNT < value) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF93, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
	            }   
			}
			else{
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF85, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		
		/* CR6153 changes start */
		if(!isFieldEmpty(getPricingInformation().getSsAnninversaryAmountPeriod2())){
			if(isValidDouble(getPricingInformation().getSsAnninversaryAmountPeriod2())){
				value = getDoubleValue(getPricingInformation().getSsAnninversaryAmountPeriod2());
				if (japan || korea) {
					if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_AMOUNT_FOR_JAPAN < value) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF114, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
					if(OPPTHelper.decimalCheck(value)) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF117, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
				} else {
					if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_ANNV_AMOUNT < value) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF268, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
	            }   
			}
			else{
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF275, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		if(!isFieldEmpty(getPricingInformation().getSsAnninversaryAmountPeriod3())){
			if(isValidDouble(getPricingInformation().getSsAnninversaryAmountPeriod3())){
				value = getDoubleValue(getPricingInformation().getSsAnninversaryAmountPeriod3());
				if (japan || korea) {
					if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_AMOUNT_FOR_JAPAN < value) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF114, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
					if(OPPTHelper.decimalCheck(value)) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF117, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
				} else {
					if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_ANNV_AMOUNT < value) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF269, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
	            }   
			}
			else{
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF274, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		if(!isFieldEmpty(getPricingInformation().getSsAnninversaryAmountPeriod4())){
			if(isValidDouble(getPricingInformation().getSsAnninversaryAmountPeriod4())){
				value = getDoubleValue(getPricingInformation().getSsAnninversaryAmountPeriod4());
				if (japan || korea) {
					if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_AMOUNT_FOR_JAPAN < value) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF114, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
					if(OPPTHelper.decimalCheck(value)) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF117, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
				} else {
					if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_ANNV_AMOUNT < value) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF270, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
	            }   
			}
			else{
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF273, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		if(!isFieldEmpty(getPricingInformation().getSsAnninversaryAmountPeriod5())){
			if(isValidDouble(getPricingInformation().getSsAnninversaryAmountPeriod5())){
				value = getDoubleValue(getPricingInformation().getSsAnninversaryAmountPeriod5());
				if (japan || korea) {
					if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_AMOUNT_FOR_JAPAN < value) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF114, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
					if(OPPTHelper.decimalCheck(value)) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF117, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
				} else {
					if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_ANNV_AMOUNT < value) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF271, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
	            }   
			}
			else{
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF272, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
				
		/* CR6153 changes end */
		

		if (isSelectEmpty(getBasicProposalData().getSalesOrganization())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF01, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if (isSelectEmpty(getBasicProposalData().getDistributionChannel())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF02, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if (isSelectEmpty(getBasicProposalData().getDivision())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF03, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if (isSelectEmpty(getBasicProposalData().getCurrencyCode())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF04, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		// BH Wave1 - DAD003 - Complex Contract Identifiers - Bhanu - Begin
/*		if (!isFieldEmpty(getBasicProposalData().getCpsID()) 
			//|| !isFieldEmpty(getBasicProposalData().getMasterContractID())
			//|| !isFieldEmpty(getBasicProposalData().getComplexContractAmendment()) 
			//|| !isFieldEmpty(getBasicProposalData().getMasterContractAmendment())
			|| !isSelectEmpty(getBasicProposalData().getBlbIndicator())){
			if(isFieldEmpty(getBasicProposalData().getCpsID())) {
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF276, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
			if(isFieldEmpty(getBasicProposalData().getComplexContractAmendment())){
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF280, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}*/
		
		// BH Wave1 - DAD003 - Complex Contract Identifiers - Bhanu - End

		/*if (isFieldEmpty(getBasicProposalData().getProposalName())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF05, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		else{*/
			if(!isAlphaNumeric(getBasicProposalData().getProposalName())){
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF75, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		

		if (isSelectEmpty(getBasicProposalData().getProposalType())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF06, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if ("0147".equals(getBasicProposalData().getSalesOrganization())) {
			if (null == getBasicProposalData().getExternalContractNumber()) {
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF07, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			} else if (10 < getBasicProposalData().getExternalContractNumber().length()) {
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF08, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}

		if (isDateEmpty(getContractStartDate())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF09, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if (isDateEmpty(getContractEndDate())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF10, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if (isDateEmpty(getContractPeriodStartDate())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF11, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if (isDateEmpty(getContractPeriodEndDate())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF12, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if (isSelectEmpty(getPricingInformation().getBillingFrequency())) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF13, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if(isSelectEmpty(getPricingInformation().getPlannedGrowthOption())){
			getPricingInformation().setPlannedGrowthOption(UtilityConstants.NIL);
		}

		if(isSelectEmpty(getPricingInformation().getGrowthLimitOption())){
			getPricingInformation().setGrowthLimitOption(UtilityConstants.NIL);
		}

		//	(When) Planned growth (exists) in proposal, it must be numeric and only 2 decimals.
		if("Other".equalsIgnoreCase(getPricingInformation().getPlannedGrowthOption())){
			if(!isValidDouble(getPricingInformation().getPlannedGrowthValue(), 2)){
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF68, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		else{
			if(0 < getDoubleValue(getPricingInformation().getPlannedGrowthValue())){
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF87, OPPTMessageCatalog.TYPE_PRESENTATION), null);				
			}
		}

		//	(When) growth limit (exists) in proposal, it must be numeric and only 2 decimals.
		if("Other".equalsIgnoreCase(getPricingInformation().getGrowthLimitOption())){
			if(!isValidDouble(getPricingInformation().getGrowthLimitValue(), 2)){
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF69, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		else{
			if(0 < getDoubleValue(getPricingInformation().getGrowthLimitValue())){
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF88, OPPTMessageCatalog.TYPE_PRESENTATION), null);				
			}
		}

		//	(When) tvm rate (exists) in proposal, it must be numeric and only 2 decimals.
		if(isValidDouble(getPricingInformation().getTvmRate(), 2)){
			value = getDoubleValue(getPricingInformation().getTvmRate());
			if (0 > value && 50 < value) {
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF18, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		else{
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF70, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		//	(When) PAKID (exists) for a proposal, it ust be alphanumeric
		if(!isFieldEmpty(getPricingInformation().getPakid())){
			if(!isAlphaNumeric(getPricingInformation().getPakid())){
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF71, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
//		(When) discount rate (exists) in proposal, it must be numeric and only 2 decimals.
		if(isValidDouble(getPricingInformation().getDiscount(), 2)){
			value = getDoubleValue(getPricingInformation().getDiscount());
			//System.out.println("ProposalHeaderActionForm.validate()"+value);
			if (value > 100 || value < 0) {
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF285, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		else{
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF286, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if (null != getPricingInformation().getFreeTextForInvoicePrint() && 6000 < getPricingInformation().getFreeTextForInvoicePrint().length()) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF20, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if(null != capAmount && 0 < capAmount.length()){
			try{
				getVarianceData().setCapAmount(Double.parseDouble(capAmount));
				if (japan || korea) {
					if (UtilityConstants.MAX_VAR_AMOUNT_FOR_JAPAN < getVarianceData().getCapAmount()) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF115, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
					if(OPPTHelper.decimalCheck(getVarianceData().getCapAmount())) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF118, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
				}
				
				else if(vietnam){
					if (UtilityConstants.MAX_AMOUNT_FOR_VIETNAM < getVarianceData().getCapAmount()) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF123, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
					if(OPPTHelper.decimalCheck(getVarianceData().getCapAmount())) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF126, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
				}
					
					else {
					if (UtilityConstants.MAX_VAR_AMOUNT < getVarianceData().getCapAmount()) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF21, OPPTMessageCatalog.TYPE_PRESENTATION), null);
					}
	}
			}
			catch(Exception e){
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF89, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		
		if(null != capPlus && 0 < capPlus.length()){
			try{
				getVarianceData().setCapPlus(Double.parseDouble(capPlus));
				if (UtilityConstants.MAX_PERCENT < getVarianceData().getCapPlus()) {
					errorReport.put(new ErrorKey(ErrorCodeConstants.PAF22, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}
			catch(Exception e){
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF90, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}

		if(null != capMinus && 0 < capMinus.length()){
			try{
				getVarianceData().setCapMinus(Double.parseDouble(capMinus));
				if (UtilityConstants.MAX_PERCENT < getVarianceData().getCapMinus()) {
					errorReport.put(new ErrorKey(ErrorCodeConstants.PAF23, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}
			catch(Exception e){
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF91, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}

		if (null != getSecondaryProposalData().getPurchaseOrderNumber() && 35 < getSecondaryProposalData().getPurchaseOrderNumber().length()) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF24, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}

		if (1 > getSecondaryProposalData().getAddValueDays() && 99 < getSecondaryProposalData().getAddValueDays()) {
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF25, OPPTMessageCatalog.TYPE_PRESENTATION), null);
		}
		
		if(varianceProposal){
//			if(isFieldEmpty(getPricingInformation().getExceedingAmount())){
//				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF105, OPPTMessageCatalog.TYPE_PRESENTATION), null);
//			}
//			else 
			if(!isValidDouble(getPricingInformation().getExceedingAmount())){
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF103, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		
		//<!-- BlueHarmony DAD006  changed by Anand Sugumaran  --> 
		/* CR6153 changes start 
		if(((getBasicProposalData().getProposalType().equalsIgnoreCase("ES")) ||(getBasicProposalData().getProposalType().equalsIgnoreCase("AM")))
				&& (getBasicProposalData().getProposalContent().equalsIgnoreCase("S"))){
		  if(getPricingInformation().isExtendPeriod() == true){
		   int count =0;
		   int contractEndMonth = new Integer(getContractEndDate().getMonth().toString()).intValue();
		   if(contractEndMonth == 12){
		   	  count=1;
		   }
		   int contractStartYear = new Integer(getContractStartDate().getYear().toString()).intValue();
		   int contractEndYear = new Integer(getContractEndDate().getYear().toString()).intValue();
		   int contractduration = (contractEndYear - contractStartYear)+ count;
		   switch(contractduration){
		   case 5:{
		   	if(isFieldEmpty(getPricingInformation().getSsAnninversaryAmountPeriod5())&&getPricingInformation().getSsAnninversaryAmountPeriod5().equals("")){
		   		errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF263,OPPTMessageCatalog.TYPE_PRESENTATION),null);
		   	 }
		   }
		   case 4:{
		   	if(isFieldEmpty(getPricingInformation().getSsAnninversaryAmountPeriod4())&&getPricingInformation().getSsAnninversaryAmountPeriod4().equals("")){
		   		errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF264,OPPTMessageCatalog.TYPE_PRESENTATION),null);
		   	 }
		   }
		   case 3:{
		   	if(isFieldEmpty(getPricingInformation().getSsAnninversaryAmountPeriod3())&&getPricingInformation().getSsAnninversaryAmountPeriod3().equals("")){
		   		errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF265,OPPTMessageCatalog.TYPE_PRESENTATION),null);
		   	 }
		   }
		   case 2:{
		   	if(isFieldEmpty(getPricingInformation().getSsAnninversaryAmountPeriod2())&&getPricingInformation().getSsAnninversaryAmountPeriod2().equals("")){
		   		errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF266,OPPTMessageCatalog.TYPE_PRESENTATION),null);
		   	}
		   }
		   case 1:{
		   	if(isFieldEmpty(getPricingInformation().getSsAnninversaryContractAmount())&&getPricingInformation().getSsAnninversaryContractAmount().equals("")){
		   		errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF267,OPPTMessageCatalog.TYPE_PRESENTATION),null);
		   	}
		   }
		   
		 } 
		  
	  }
	}
  CR6153 changes end 
  <!-- BlueHarmony DAD006  changes End by Anand Sugumaran  --> 
  **/
		getPricingInformation().setBillingBlock(getDefaultOptionValue(getPricingInformation().getBillingBlock()));
		getPricingInformation().setBillingDateRule(getDefaultOptionValue(getPricingInformation().getBillingDateRule()));
		getPricingInformation().setDeviatingDateRule(getDefaultOptionValue(getPricingInformation().getDeviatingDateRule()));
		getSecondaryProposalData().setPaymentTerms(getDefaultOptionValue(getSecondaryProposalData().getPaymentTerms()));
		
		return errorReport;
	}
	
	/**
	 * Returns proposal status value 
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
	 * @return String
	 */
	public String getProposalStatus() {
		if(null != proposalStatus && "null".equalsIgnoreCase(proposalStatus)){
			proposalStatus = null;
		}
		return proposalStatus;
	}

	/**
	 * Sets proposal status value 
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
	 * @param newProposalStatus String 
	 */
	public void setProposalStatus(String newProposalStatus) {
		proposalStatus = newProposalStatus;
	}
	
	/**
	 * Returns variance date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return DateDataBean
	 */
	public DateDataBean getVarianceDate() {
		if(null == varianceDate){
			varianceDate = new DateDataBean();
		}
		return varianceDate;
	}

	/**
	 * Sets variance date value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newVarianceDate DateDataBean
	 */
	public void setVarianceDate(DateDataBean newVarianceDate) {
		varianceDate = newVarianceDate;
	}
	
	/**
	 * Returns true if the header information is for an variance proposal. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean 
	 */
	public boolean isVarianceProposal() {
		return varianceProposal;
	}

	/** 
	 * Sets true if the header information is for an variance proposal. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newVarianceProposal boolean
	 */
	public void setVarianceProposal(boolean b) {
		varianceProposal = b;
	}
}