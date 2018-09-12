/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;

/**
 * Custom dto that holds proposal headers secondary information  
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
public class SecondaryProposalCustomDTO extends OPPTCustomDTO 
{
	private String purchaseOrderNumber = null;
	private String paymentTerms = null;
	private String igfOfferNumber = null;
	private String comments = null;
	private Date fixedValDate = null;
	private Date purchaseOrderDate = null;
	private int addValueDays = 0;
	private boolean sandsExcluded = false;

	/**
	 * Returns add value days value 
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
	 * @return int
	 */
	public int getAddValueDays() {
		return addValueDays;
	}

	/**
	 * Returns comments 
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
	public String getComments() {
		return comments;
	}

	/**
	 * Returns fixed value date 
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
	public Date getFixedValDate() {
		return fixedValDate;
	}

	/**
	 * Returns igf offer number 
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
	public String getIgfOfferNumber() {
		return igfOfferNumber;
	}

	/**
	 * Returns payment terms 
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
	public String getPaymentTerms() {
		return paymentTerms;
	}

	/**
	 * Returns purchase order date 
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
	public Date getPurchaseOrderDate() {
		return purchaseOrderDate;
	}

	/**
	 * Returns purchase order number 
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
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	/**
	 * Returns s and s excluded value 
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
	 * @return boolean
	 */
	public boolean isSandsExcluded() {
		return sandsExcluded;
	}

	/**
	 * Sets add value days value 
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
	 * @param newAddValueDays int 
	 */
	public void setAddValueDays(int newAddValueDays) {
		addValueDays = newAddValueDays;
	}

	/**
	 * Sets comments  
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
	 * @param newComments Dtring 
	 */
	public void setComments(String newComments) {
		comments= newComments;
	}

	/** 
	 * Sets fixed value date
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
	 * @param newFixedValDate Date 
	 */
	public void setFixedValDate(Date newFixedValDate) {
		fixedValDate = newFixedValDate;
	}

	/**
	 * Sets igf offer number 
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
	 * @param newIgfOfferNumber String 
	 */
	public void setIgfOfferNumber(String newIgfOfferNumber) {
		igfOfferNumber= newIgfOfferNumber;
	}

	/**
	 * Sets payment terms 
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
	 * @param newPaymentTerms String 
	 */
	public void setPaymentTerms(String newPaymentTerms) {
		paymentTerms = newPaymentTerms;
	}

	/**
	 * Sets purchase order date 
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
	 * @param newPurchaseOrderDate Date 
	 */
	public void setPurchaseOrderDate(Date newPurchaseOrderDate) {
		purchaseOrderDate = newPurchaseOrderDate;
	}

	/**
	 * Sets purchase order number 
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
	 * @param newPurchaseOrderNumber String 
	 */
	public void setPurchaseOrderNumber(String newPurchaseOrderNumber) {
		purchaseOrderNumber = newPurchaseOrderNumber;
	}

	/**
	 * Sets s and s excluded flag 
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
	 * @param newSandSExcluded boolean 
	 */
	public void setSandsExcluded(boolean newSandSExcluded) {
		sandsExcluded = newSandSExcluded;
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
	 * @param ipurchaseOrderNumber String
	 * @param ipaymentTerms String
	 * @param iigfOfferNumber String
	 * @param icomments String
	 * @param ifixedValDate Date
	 * @param ipurchaseOrderDate Date
	 * @param iaddValueDays int 
	 * @param isandsExcluded boolean
	 */
	public void setData(String ipurchaseOrderNumber, String ipaymentTerms, String iigfOfferNumber, 
						String icomments, Date ifixedValDate, Date ipurchaseOrderDate,
						int iaddValueDays, boolean isandsExcluded){
		setPurchaseOrderNumber(ipurchaseOrderNumber);
		setPaymentTerms(ipaymentTerms);
		setIgfOfferNumber(iigfOfferNumber);
		setComments(icomments);
		setFixedValDate(ifixedValDate);
		setPurchaseOrderDate(ipurchaseOrderDate);
		setAddValueDays(iaddValueDays);
		setSandsExcluded(isandsExcluded);
	}
}
