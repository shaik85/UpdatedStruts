/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.commons;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SecondaryProposalCustomDTO;

/**
 * Holds secondary proposal date  
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
public class SecondaryProposalDataBean extends OPPTDataBean{
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
		comments = newComments;
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
		igfOfferNumber = newIgfOfferNumber;
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
	 * @param purchaseOrderNumber String
	 * @param paymentTerms String
	 * @param igfOfferNumber String
	 * @param comments String
	 * @param fixedValDate Date
	 * @param purchaseOrderDate Date
	 * @param addValueDays int 
	 * @param sandsExcluded boolean
	 */
	public void setData(String purchaseOrderNumber, String paymentTerms, String igfOfferNumber, 
						String comments, Date fixedValDate, Date purchaseOrderDate,
						int addValueDays, boolean sandsExcluded){
		setPurchaseOrderNumber(purchaseOrderNumber);
		setPaymentTerms(paymentTerms);
		setIgfOfferNumber(igfOfferNumber);
		setComments(comments);
		setFixedValDate(fixedValDate);
		setPurchaseOrderDate(purchaseOrderDate);
		setAddValueDays(addValueDays);
		setSandsExcluded(sandsExcluded);
	}

	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(SecondaryProposalCustomDTO customDTO){
		if(null != customDTO){
			setPurchaseOrderNumber(customDTO.getPurchaseOrderNumber());
			setPaymentTerms(customDTO.getPaymentTerms());
			setIgfOfferNumber(customDTO.getIgfOfferNumber());
			setComments(customDTO.getComments());
			setFixedValDate(customDTO.getFixedValDate());
			setPurchaseOrderDate(customDTO.getPurchaseOrderDate());
			setAddValueDays(customDTO.getAddValueDays());
			setSandsExcluded(customDTO.isSandsExcluded());
		}
	}

	/**
     * SecondaryProposalDataBean
     * 
     * @author thirumalai
     */
    public SecondaryProposalDataBean(){
	}

	/**
     * SecondaryProposalDataBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public SecondaryProposalDataBean(SecondaryProposalCustomDTO customDTO){
		setData(customDTO);
	}

	/**
     * toString
     * 
     * @see java.lang.Object#toString()
     * @author thirumalai
     */
    public String toString(){
		StringBuffer strValue = new StringBuffer();
		
		strValue.append("\n\n[SecondaryProposalDataBean] - [toString] - Start...");  //$NON-NLS-1$
		strValue.append("\nPurchase order number: "+getPurchaseOrderNumber());  //$NON-NLS-1$
		strValue.append("\nPayment terms: "+getPaymentTerms());  //$NON-NLS-1$
		strValue.append("\nIgf offer number: "+getIgfOfferNumber());  //$NON-NLS-1$
		strValue.append("\nComments: "+getComments());  //$NON-NLS-1$
		strValue.append("\nFixed val date: "+getFixedValDate());  //$NON-NLS-1$
		strValue.append("\nPurchase order date: "+getPurchaseOrderDate());  //$NON-NLS-1$
		strValue.append("\nAdd value days: "+getAddValueDays());  //$NON-NLS-1$
		strValue.append("\nS & s excluded: "+isSandsExcluded());  //$NON-NLS-1$
		strValue.append("[SecondaryProposalDataBean] - [toString] - End...\n\n");  //$NON-NLS-1$

		return strValue.toString();
	}

	/**
     * equals
     * 
     * @param dataBean
     * @return
     * @author thirumalai
     */
    public boolean equals(SecondaryProposalDataBean dataBean)
	{
		boolean equal = true;

		if(null != dataBean){
			if(isDifferent(getPurchaseOrderNumber(), dataBean.getPurchaseOrderNumber())){
				equal = false;		
			}
			else if(isDifferent(getPaymentTerms(), dataBean.getPaymentTerms())){
				equal = false;		
			}
			else if(isDifferent(getIgfOfferNumber(), dataBean.getIgfOfferNumber())){
				equal = false;		
			}
			else if(isDifferent(getComments(), dataBean.getComments())){
				equal = false;		
			}
			else if(isDifferent(getPaymentTerms(), dataBean.getPaymentTerms())){
				equal = false;		
			}
			else if(isDifferent(getAddValueDays(), dataBean.getAddValueDays())){
				equal = false;		
			}
			else if(isDifferent(isSandsExcluded(), dataBean.isSandsExcluded())){
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
		}
		else{
			if(null == newValue){
				different = false;
			}
		}
		
		return different;
	}

	private boolean isDifferent(int oldValue, int newValue){
		boolean different = true;

		if(oldValue == newValue){
			different = false;		
		}
		
		return different;
	}

	private boolean isDifferent(boolean oldValue, boolean newValue){
		boolean different = true;

		if(oldValue == newValue){
			different = false;		
		}
		
		return different;
	}
}
