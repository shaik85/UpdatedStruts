/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import javax.ejb.FinderException;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.AmendContractActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.BasicProposalDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.PricingInformationDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.SecondaryProposalDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.VarianceDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BLBIndicatorBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ComplexContractIdentifiersBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory.ComplexContractIdentifiersBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.AmendContractCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;

/**
 * This class holds the information required for amending a contract. The information include complete 
 * proposal header information. That is BasicProposalData, PricingInformation, SecondaryProposalData 
 * and VarianceData along with the amendment effective date and financing contract number.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 14, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class AmendContractViewBean extends OPPTViewBean {
	private Date amendmentEffectiveDate = null;
	private String financingContractNumber = null;
	private TreeMap billingBlockList = null; 
	private BasicProposalDataBean basicProposalData = null;
	private PricingInformationDataBean pricingInformation = null;
	private SecondaryProposalDataBean secondaryProposalData = null;
	private VarianceDataBean varianceData = null;
	private String proposalContent = "";  //$NON-NLS-1$
	private ArrayList yearList=null;
	private TreeMap blbIndicatorList = null; // BH Wave 1 - DAD003 - Manoj

	/**
     * AmendContractViewBean
     * 
     * @author thirumalai
     */
    public AmendContractViewBean(){
	}
	
	/**
     * AmendContractViewBean
     * 
     * @param customDto
     * @author thirumalai
     */
    public AmendContractViewBean(AmendContractCustomDTO customDto){
		populateBean(customDto);
	}
	
	
	/**
	 * Returns amendment effective date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getAmendmentEffectiveDate() {
		return amendmentEffectiveDate;
	}

	/**
	 * Returns basic proposal data 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return BasicProposalDataBean
	 */
	public BasicProposalDataBean getBasicProposalData() {
		return basicProposalData;
	}

	/**
	 * Returns financing contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return FinancingContractNumber
	 */
	public String getFinancingContractNumber() {
		return financingContractNumber;
	}

	/**
	 * Returns the pricing information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PricingInformationDataBean
	 */
	public PricingInformationDataBean getPricingInformation() {
		return pricingInformation;
	}

	/**
	 * Returns secondary proposal data 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SecondaryProposalDataBean
	 */
	public SecondaryProposalDataBean getSecondaryProposalData() {
		return secondaryProposalData;
	}

	/**
	 * Returns the variance information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return VarianceDataBean
	 */
	public VarianceDataBean getVarianceData() {
		return varianceData;
	}

	/**
	 * Sets the data value passed as amendment effective date 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAmendmentEffectiveDate Date
	 */
	public void setAmendmentEffectiveDate(Date newAmendmentEffectiveDate) {
		amendmentEffectiveDate = newAmendmentEffectiveDate;
	}

	/**
	 * Sets basic proposal information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBasicProposalData BasicProposalDataBean 
	 */
	public void setBasicProposalData(BasicProposalDataBean newBasicProposalData) {
		basicProposalData = newBasicProposalData;
	}

	/**
	 * Sets the string value passed as the financing contract number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newFinancingContractNumber String 
	 */
	public void setFinancingContractNumber(String newFinancingContractNumber) {
		financingContractNumber = newFinancingContractNumber;
	}

	/**
	 * Sets the procing information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPricingInformation PricingInformationDataBean 
	 */
	public void setPricingInformation(PricingInformationDataBean newPricingInformation) {
		pricingInformation = newPricingInformation;
	}

	/**
	 * Sets the secondary information about the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSecondaryProposalData SecondaryProposalDataBean 
	 */
	public void setSecondaryProposalData(SecondaryProposalDataBean newSecondaryProposalData) {
		secondaryProposalData = newSecondaryProposalData;
	}

	/**
	 * Sets the variance information for the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newVarianceData VarianceDataBean 
	 */
	public void setVarianceData(VarianceDataBean newVarianceData) {
		varianceData = newVarianceData;
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
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public TreeMap getBillingBlockList() {
		return billingBlockList;
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
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setBillingBlockList(TreeMap map) {
		
		billingBlockList = map;
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
	 * date Feb 19, 2004 
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
	 * date Feb 19, 2004 
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
	 * date Jan 23, 2004 
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
	 * date Jan 23, 2004 
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
	 * Sets complete data in a single call.   
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 14, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param basicProposalData
	 * @param pricingInformation
	 * @param secondaryProposalData
	 * @param varianceData
	 * @param amendmentEffectiveDate
	 * @param financingContractNumber
	 */
	public void setData(BasicProposalDataBean basicProposalData, PricingInformationDataBean pricingInformation, SecondaryProposalDataBean secondaryProposalData, VarianceDataBean varianceData, Date amendmentEffectiveDate, String financingContractNumber){
		setBasicProposalData(basicProposalData);
		setPricingInformation(pricingInformation);
		setSecondaryProposalData(secondaryProposalData);
		setVarianceData(varianceData);
		setAmendmentEffectiveDate(amendmentEffectiveDate);
		setFinancingContractNumber(financingContractNumber);
	}
	
	/**
	 * populateBean
	 * 
	 * @param customDto   
	 */
	private void populateBean(AmendContractCustomDTO customDto){
		AmendContractActionForm actionForm = (AmendContractActionForm)getActionForm();
		if(null == actionForm){
			actionForm = new AmendContractActionForm();
		}
		populateForm(actionForm, customDto);
		
		setBasicProposalData(new BasicProposalDataBean(customDto.getBasicProposalCustomDTO()));
		setPricingInformation(new PricingInformationDataBean(customDto.getPricingInformationCustomDTO()));
		setSecondaryProposalData(new SecondaryProposalDataBean(customDto.getSecondaryProposalCustomDTO()));
		setVarianceData(new VarianceDataBean(customDto.getVarianceInformationCustomDTO()));
		setAmendmentEffectiveDate(customDto.getAmendmentEffectiveDate());
		setFinancingContractNumber(customDto.getFinancingContractNumber());
		setBillingBlockList(populateBillingList());
		setBlbIndicatorList(populateBlbIndicatorList());
		if(getBasicProposalData().isShowProposalContent()){
			setProposalContent(OPPTStaticDataHolder.getProposalContentDesc(getBasicProposalData().getProposalContent()));
		}
	}

	/**
	 * populateForm
	 * 
	 * @param actionForm
	 * @param customDto   
	 */
	private void populateForm(AmendContractActionForm actionForm, AmendContractCustomDTO customDto){
		actionForm.setExternalContractNumber(customDto.getBasicProposalCustomDTO().getExternalContractNumber());
		actionForm.setGsa(customDto.getPricingInformationCustomDTO().isGsa());
		actionForm.setBillingBlock(customDto.getPricingInformationCustomDTO().getBillingBlock());
		actionForm.setFreeTextForInvoicePrint(customDto.getPricingInformationCustomDTO().getFreeTextForInvoicePrint());
		actionForm.setPurchaseOrderNumber(customDto.getSecondaryProposalCustomDTO().getPurchaseOrderNumber());
		actionForm.setAnniversaryContractAmount(String.valueOf(customDto.getPricingInformationCustomDTO().getAnniversaryContractAmount()));
		actionForm.setSsAnniversaryContractAmount(String.valueOf(customDto.getPricingInformationCustomDTO().getSAndSAnniversaryContractAmount()));
        /*CR6153 start changes */
		actionForm.setExtendPeriod(customDto.getPricingInformationCustomDTO().isExtendPeriod());
		actionForm.setSsAnninversaryAmountPeriod2(String.valueOf(customDto.getPricingInformationCustomDTO().getSAndSAnniversaryContractAmountPeriod2()));
		actionForm.setSsAnninversaryAmountPeriod3(String.valueOf(customDto.getPricingInformationCustomDTO().getSAndSAnniversaryContractAmountPeriod3()));
		actionForm.setSsAnninversaryAmountPeriod4(String.valueOf(customDto.getPricingInformationCustomDTO().getSAndSAnniversaryContractAmountPeriod4()));
		actionForm.setSsAnninversaryAmountPeriod5(String.valueOf(customDto.getPricingInformationCustomDTO().getSAndSAnniversaryContractAmountPeriod5()));
		/* CR6153 changes ends */	
		// BH Wave1 - DAD003 - Manoj - Begin
		actionForm.setPrebillIndicator(customDto.getPricingInformationCustomDTO().isPrebillIndicator());
		// BH Wave1 - DAD 003 - Manoj - End
		setActionForm(actionForm);
	}
	
	/**
	 * populateBillingList
	 * 
	 * @return
	 */	
	private TreeMap populateBillingList(){
		TreeMap newBillingList =  null;
		TreeMap billingList = new TreeMap(OPPTStaticDataHolder.billingBlockMap);

		if(null != billingList){
			newBillingList = new TreeMap();
			Iterator itr = billingList.keySet().iterator();
			
			while(itr.hasNext()){
				String key = (String)itr.next();
				String value = key + " - " + (String)billingList.get(key);  //$NON-NLS-1$
				newBillingList.put(key, value);
			}
		}
		
		return newBillingList;
	}
	
	
	// BH Wave1 - DAD003 - Bhanu - Begin
	/**
	 * populateBLBIndicatorList
	 * 
	 * @return
	 */	
	private TreeMap populateBlbIndicatorList(){
		//		BLB Indicator Starts here
		TreeMap newBlbIndicatorMap =null;
		TreeMap blbIndicatorTypeMap = new TreeMap(OPPTStaticDataHolder.blbIndicatorMap);
		if(null != blbIndicatorTypeMap){
			newBlbIndicatorMap = new TreeMap();
			Iterator itr = blbIndicatorTypeMap.keySet().iterator();
			while(itr.hasNext()){
				String key = (String)itr.next();
				String value = (String)blbIndicatorTypeMap.get(key);
				newBlbIndicatorMap.put(value,key);				
			}
			
			
		}
					
		return newBlbIndicatorMap;
	}
	
	/**
	 * @return Returns the blbIndicator.
	 */
	public TreeMap getBlbIndicatorList() {
		return blbIndicatorList;
	}
	/**
	 * @param blbIndicator The blbIndicator to set.
	 */
	public void setBlbIndicatorList(TreeMap blbIndicator) {
		this.blbIndicatorList = blbIndicator;
	}
	// BH Wave1 - DAD003 - Bhanu - End
}
