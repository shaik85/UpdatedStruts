/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms;


import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.BasicProposalDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.DateDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;


/**
 * Action form for amend contract view  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 25, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */


public class AmendContractActionForm extends OPPTActionForm {
	private String externalContractNumber = null;
	private DateDataBean amendmentEffectiveDate = null;
	private BasicProposalDataBean basicProposalData = null;
	private boolean gsa = false;
	private String proposalType = null;
	private String billingBlock = null;
	private String freeTextForInvoicePrint = null;
	private String purchaseOrderNumber = null;
	private String anniversaryContractAmount=null;
	private String ssAnniversaryContractAmount=null;
	/* CR6153 start change */
	private boolean extendPeriod = false;
	private String ssAnninversaryAmountPeriod2 = null;
	private String ssAnninversaryAmountPeriod3 = null;
	private String ssAnninversaryAmountPeriod4 = null;
	private String ssAnninversaryAmountPeriod5 = null;
	private int contractDuration;
	/* CR6153 end change */
	private DateDataBean purchaseOrderDate = null;
	
	// BH Wave1 - DAD003 - Complex Contract Identifiers - Begin - Manoj
	private String cpsID = null;
	private String ocpsID = null;
	private String contractType = null;
	private String blbIndicator = null;
	private String prebillIndicator = null;
	//	BH Wave1 - DAD003 - Complex Contract Identifiers - End -Manoj
	
	/**
	 * Returns amendment effective date 
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
	 * @return DateDataBean
	 */
	public DateDataBean getAmendmentEffectiveDate() {
		if(null == amendmentEffectiveDate){
			amendmentEffectiveDate = new DateDataBean();
		}
		return amendmentEffectiveDate;
	}

	/**
	 * Returns anniversary contract amount 
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
	 * @return double
	 */
	public String getAnniversaryContractAmount() {
		return anniversaryContractAmount;
	}

	/**
	 * Returns billing block value 
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
	 * @return String
	 */
	public String getBillingBlock() {
		return billingBlock;
	}

	/**
	 * Returns external contract number 
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
	 * @return String
	 */
	public String getExternalContractNumber() {
		return externalContractNumber;
	}

	/**
	 * Returns free text for invoice print value 
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
	 * @return String
	 */
	public String getFreeTextForInvoicePrint() {
		return freeTextForInvoicePrint;
	}

	/**
	 * Returns gsa flag 
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
	 * @return boolean
	 */
	public boolean isGsa() {
		return gsa;
	}

	/**
	 * Returns purchase order date value 
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
	 * @return DateDataBean
	 */
	public DateDataBean getPurchaseOrderDate() {
		if(null == purchaseOrderDate){
			purchaseOrderDate = new DateDataBean();
		}
		return purchaseOrderDate;
	}

	/**
	 * Returns purchase order number 
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
	 * @return String
	 */
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	/**
	 * Sets amendment effective date  
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
	 * @param newAmendmentEffectiveDate DateDataBean 
	 */
	public void setAmendmentEffectiveDate(DateDataBean newAmendmentEffectiveDate) {
		amendmentEffectiveDate = newAmendmentEffectiveDate;
	}

	/**
	 * Sets anniversary contract amount value 
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
	 * @param newAnniversaryContractAmount double 
	 */
	public void setAnniversaryContractAmount(String newAnniversaryContractAmount) {
		anniversaryContractAmount = newAnniversaryContractAmount;
	}

	/**
	 * Sets billing block value 
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
	 * @param newBillingBlock String 
	 */
	public void setBillingBlock(String newBillingBlock) {
		billingBlock = newBillingBlock;
	}

	/**
	 * Sets external contract number 
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
	 * @param newExternalContractNumber String 
	 */
	public void setExternalContractNumber(String newExternalContractNumber) {
		externalContractNumber = newExternalContractNumber;
	}

	/**
	 * Sets free text for invoice print value 
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
	 * @param newFreeTextForInvoicePrint String 
	 */
	public void setFreeTextForInvoicePrint(String newFreeTextForInvoicePrint) {
		freeTextForInvoicePrint = newFreeTextForInvoicePrint;
	}

	/**
	 * Sets gsa flag 
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
	 * @param newGsa boolean 
	 */
	public void setGsa(boolean newGsa) {
		gsa = newGsa;
	}

	/**
	 * Sets purchase order date value 
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
	 * @param newPurchaseOrderDate DateDataBean 
	 */
	public void setPurchaseOrderDate(DateDataBean newPurchaseOrderDate) {
		purchaseOrderDate = newPurchaseOrderDate;
	}

	/**
	 * Sets purchase order number 
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
	 * @param newPurchaseOrderNumber String 
	 */
	public void setPurchaseOrderNumber(String newPurchaseOrderNumber) {
		purchaseOrderNumber = newPurchaseOrderNumber;
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
	public String getSsAnniversaryContractAmount() {
		return ssAnniversaryContractAmount;
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
	public void setSsAnniversaryContractAmount(String string) {
		ssAnniversaryContractAmount = string;
	}
	
	public ErrorReport validate() {
		
		ErrorReport errorReport = new ErrorReport();
		if(isDateEmpty(getAmendmentEffectiveDate())){
			errorReport.put(new ErrorKey(ErrorCodeConstants.PAF63, OPPTMessageCatalog.TYPE_PRESENTATION),null);
		}
		
		if(isDateEmpty(getPurchaseOrderDate())){
			purchaseOrderDate = null;
		}
		
		if(isSelectEmpty(getBillingBlock())){
			billingBlock = null;
		}
		
		if(!isFieldEmpty(getAnniversaryContractAmount())){
			if(isValidDouble(getAnniversaryContractAmount())){
				if (0 > Double.parseDouble(getAnniversaryContractAmount())
					|| 999999999 < Double.parseDouble(getAnniversaryContractAmount())) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF16, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}
			else{
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF84, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		else{
			setAnniversaryContractAmount(null);
		}

		if(!isFieldEmpty(getSsAnniversaryContractAmount())){
			if(isValidDouble(getSsAnniversaryContractAmount())){
				if (0 > Double.parseDouble(getSsAnniversaryContractAmount())
					|| 999999999 < Double.parseDouble(getSsAnniversaryContractAmount())) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF93, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}
			else{
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF85, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		else{
			setSsAnniversaryContractAmount(null);
		}
		/* CR6153 start change */
         int contractDuration = getContractDuration();
         switch(contractDuration){
		   case 5:{
		   	if(isFieldEmpty(getSsAnninversaryAmountPeriod5())&&getSsAnninversaryAmountPeriod5().equals("")){
		   		errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF263,OPPTMessageCatalog.TYPE_PRESENTATION),null);
		   	 }
		   }
		   case 4:{
		   	if(isFieldEmpty(getSsAnninversaryAmountPeriod4())&&getSsAnninversaryAmountPeriod4().equals("")){
		   		errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF264,OPPTMessageCatalog.TYPE_PRESENTATION),null);
		   	 }
		   }
		   case 3:{
		   	if(isFieldEmpty(getSsAnninversaryAmountPeriod3())&&getSsAnninversaryAmountPeriod3().equals("")){
		   		errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF265,OPPTMessageCatalog.TYPE_PRESENTATION),null);
		   	 }
		   }
		   case 2:{
		   	if(isFieldEmpty(getSsAnninversaryAmountPeriod2())&&getSsAnninversaryAmountPeriod2().equals("")){
		   		errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF266,OPPTMessageCatalog.TYPE_PRESENTATION),null);
		   	}
		   }
		   case 1:{
		   	if(isFieldEmpty(getSsAnniversaryContractAmount())&&getSsAnniversaryContractAmount().equals("")){
		   		errorReport.addErrorEntry(new ErrorKey(ErrorCodeConstants.PAF267,OPPTMessageCatalog.TYPE_PRESENTATION),null);
		   	}
		   }
		   
		 }
		if(!isFieldEmpty(getSsAnninversaryAmountPeriod2())){
			if(isValidDouble(getSsAnninversaryAmountPeriod2())){
				if (0 > Double.parseDouble(getSsAnninversaryAmountPeriod2())
					|| 999999999 < Double.parseDouble(getSsAnninversaryAmountPeriod2())) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF93, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}
			else{
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF85, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		else{
			setSsAnninversaryAmountPeriod2("-1.0");
		}
		
		if(!isFieldEmpty(getSsAnninversaryAmountPeriod3())){
			if(isValidDouble(getSsAnninversaryAmountPeriod3())){
				if (0 > Double.parseDouble(getSsAnninversaryAmountPeriod3())
					|| 999999999 < Double.parseDouble(getSsAnninversaryAmountPeriod3())) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF93, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}
			else{
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF85, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		else{
			setSsAnninversaryAmountPeriod3("-1.0");
		}
		if(!isFieldEmpty(getSsAnninversaryAmountPeriod4())){
			if(isValidDouble(getSsAnninversaryAmountPeriod4())){
				if (0 > Double.parseDouble(getSsAnninversaryAmountPeriod4())
					|| 999999999 < Double.parseDouble(getSsAnninversaryAmountPeriod4())) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF93, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}
			else{
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF85, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		else{
			setSsAnninversaryAmountPeriod4("-1.0");
		}
		if(!isFieldEmpty(getSsAnninversaryAmountPeriod5())){
			if(isValidDouble(getSsAnninversaryAmountPeriod5())){
				if (0 > Double.parseDouble(getSsAnninversaryAmountPeriod5())
					|| 999999999 < Double.parseDouble(getSsAnninversaryAmountPeriod5())) {
						errorReport.put(new ErrorKey(ErrorCodeConstants.PAF93, OPPTMessageCatalog.TYPE_PRESENTATION), null);
				}
			}
			else{
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF85, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
		}
		else{
			setSsAnninversaryAmountPeriod5("-1.0");
		}
		/* CR6153 end change */
		// BH Wave1 - DAD003 - Complex Contract Identifiers - Bhanu- Begin
		
		/*if (!isFieldEmpty(getBasicProposalData().getCpsID())
			|| !isFieldEmpty(getBasicProposalData().getMasterContractID())
			|| !isFieldEmpty(getBasicProposalData().getComplexContractAmendment()) 
			|| !isFieldEmpty(getBasicProposalData().getMasterContractAmendment())
			|| !isSelectEmpty(getBasicProposalData().getBlbIndicator())){
			if(isFieldEmpty(getBasicProposalData().getCpsID())) {
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF276, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}
			if(isFieldEmpty(getBasicProposalData().getComplexContractAmendment())){
				errorReport.put(new ErrorKey(ErrorCodeConstants.PAF280, OPPTMessageCatalog.TYPE_PRESENTATION), null);
			}*/
		
		// BH Wave1 - DAD003 - Complex Contract Identifiers - Bhanu - End
		return errorReport;
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
	public String getProposalType() {
		return proposalType;
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
	 * @param string 
	 */
	public void setProposalType(String string) {
		proposalType = string;
	}
	
	/**
	 *  
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
	public Date getEffectiveDate(){
		Date effectiveDate=null;
		if(null != amendmentEffectiveDate && amendmentEffectiveDate.isValidDate()){
			effectiveDate = amendmentEffectiveDate.getDate();
		}
		return effectiveDate;
	}
	
	/**
	 *  
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
	public Date getPurchaseDate(){
		Date purchaseDate=null;
		if(null != purchaseOrderDate && purchaseOrderDate.isValidDate()){
			purchaseDate = purchaseOrderDate.getDate();
		}
		return purchaseDate;
	}
	/**
	 * Returns extendContract flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 28, 2007
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isExtendPeriod() {
		return extendPeriod;
	}
	/**
	 * Sets extendContract flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 28, 2007  
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newExtendContract boolean 
	 */
	public void setExtendPeriod(boolean newExtendContract) {
		extendPeriod = newExtendContract;
	}

	/**
	 * @return Returns the ssAnninversaryAmountPeriod2.
	 */
	public String getSsAnninversaryAmountPeriod2() {
		return ssAnninversaryAmountPeriod2;
	}
	/**
	 * @param ssAnninversaryAmountPeriod2 The ssAnninversaryAmountPeriod2 to set.
	 */
	public void setSsAnninversaryAmountPeriod2(String string) {
		ssAnninversaryAmountPeriod2 = string;
	}
	/**
	 * @return Returns the ssAnninversaryAmountPeriod3.
	 */
	public String getSsAnninversaryAmountPeriod3() {
		return ssAnninversaryAmountPeriod3;
	}
	/**
	 * @param ssAnninversaryAmountPeriod3 The ssAnninversaryAmountPeriod3 to set.
	 */
	public void setSsAnninversaryAmountPeriod3(String string) {
		this.ssAnninversaryAmountPeriod3 = string;
	}
	/**
	 * @return Returns the ssAnninversaryAmountPeriod4.
	 */
	public String getSsAnninversaryAmountPeriod4() {
		return ssAnninversaryAmountPeriod4;
	}
	/**
	 * @param ssAnninversaryAmountPeriod4 The ssAnninversaryAmountPeriod4 to set.
	 */
	public void setSsAnninversaryAmountPeriod4(String string) {
		this.ssAnninversaryAmountPeriod4 = string;
	}
	/**
	 * @return Returns the ssAnninversaryAmountPeriod5.
	 */
	public String getSsAnninversaryAmountPeriod5() {
		return ssAnninversaryAmountPeriod5;
	}
	/**
	 * @param ssAnninversaryAmountPeriod5 The ssAnninversaryAmountPeriod5 to set.
	 */
	public void setSsAnninversaryAmountPeriod5(String string) {
		this.ssAnninversaryAmountPeriod5 = string;
	}
	
	/**
	 * @return Returns the contractDuration.
	 */
	public int getContractDuration() {
		return contractDuration;
	}
	/**
	 * @param contractDuration The contractDuration to set.
	 */
	public void setContractDuration(int contractperiod) {
		contractDuration = contractperiod;
	}
	// BH Wave1 - DAD003 - Complex Contract Identifiers - Manoj - Begin
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
	 * @return Returns the prebillIndicator.
	 */
	public String isPrebillIndicator() {
		return prebillIndicator;
	}
	/**
	 * @param prebillIndicator The prebillIndicator to set.
	 */
	public void setPrebillIndicator(String prebillIndicator) {
		this.prebillIndicator = prebillIndicator;
	}
	// BH Wave1 - DAD003 - Complex Contract Identifiers - Manoj - End	
}
