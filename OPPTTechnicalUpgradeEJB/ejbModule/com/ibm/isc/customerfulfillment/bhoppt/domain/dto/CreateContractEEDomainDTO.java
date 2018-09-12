/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.dto;

import java.math.BigDecimal;
import java.util.Date;

/** 
 * Domain DTO which carries information related to EEs for contract creation 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 27, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Arun Nagarajan
 * @version 5.1A 
 */
public class CreateContractEEDomainDTO extends EEDomainDTO {
	
	private String billToPartySAPNo;
	private String payerSAPNo;
	private String currency;
	private int decimalAllowed;
	private String priceConditionType;
	private Date sAndSUptoDate;
	// fix for EF EF0702045441
	private BigDecimal calculatedPriceForApproval;

	/** 
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public CreateContractEEDomainDTO() {
		super();
	}

	/** 
	 * Returns the Bill to Party SAP number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getBillToPartySAPNo() {
		return billToPartySAPNo;
	}

	/** 
	 * Returns the curreny code
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getCurrency() {
		return currency;
	}

	/** 
	 * Returns the decimal allowed for the currency
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getDecimalAllowed() {
		return decimalAllowed;
	}

	/** 
	 * Returns the Payer SAP number
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPayerSAPNo() {
		return payerSAPNo;
	}

	/** 
	 * Returns the price condition type
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getPriceConditionType() {
		return priceConditionType;
	}

	/** 
	 * Sets the Bill to party SAP no
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setBillToPartySAPNo(String string) {
		billToPartySAPNo = string;
	}

	/** 
	 * Sets the currency
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setCurrency(String string) {
		currency = string;
	}

	/** 
	 * Sets the decimal allowed
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param decimalAllowed 
	 */
	public void setDecimalAllowed(int decimalAllowed) {
		this.decimalAllowed = decimalAllowed;
	}

	/** 
	 * Sets the Payer SAP no
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setPayerSAPNo(String string) {
		payerSAPNo = string;
	}

	/** 
	 * Sets the price condition type
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setPriceConditionType(String string) {
		priceConditionType = string;
	}
	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public Date getSAndSUptoDate() {
		return sAndSUptoDate;
	}

	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date 
	 */
	public void setSAndSUptoDate(Date date) {
		sAndSUptoDate = date;
	}

	/**
	 * @return
	 */
	public BigDecimal getCalculatedPriceForApproval() {
		return calculatedPriceForApproval;
	}

	/**
	 * @param decimal
	 */
	public void setCalculatedPriceForApproval(BigDecimal decimal) {
		calculatedPriceForApproval = decimal;
	}

}
