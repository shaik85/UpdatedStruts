/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.util.customdto;

import java.util.ArrayList;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.OPPTCustomDTO;

/**
 * Custom dto that holds agreement details data based on search.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jun 14, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Sasi R Challa
 * @version CBS 2.1
 */
public class SearchBaseAgreementCustomDTO extends OPPTCustomDTO {
	
	private String agreementNumber = null;
	private String customerNumber = null;
	private String formNumber = null;
	private String enterpriseNumber = null;
	
	private String imageReferenceNumber = null;
	private String iNAC = null;
	private String customerLegacyNumber = null;
	private String customerName = null;
	
	private ArrayList baseAgreementList = null;
	/**
	 * @return Returns the customerLegacyNumber.
	 */
	public String getCustomerLegacyNumber() {
		return customerLegacyNumber;
	}
	/**
	 * @param customerLegacyNumber The customerLegacyNumber to set.
	 */
	public void setCustomerLegacyNumber(String customerLegacyNumber) {
		this.customerLegacyNumber = customerLegacyNumber;
	}
	/**
	 * @return Returns the customerName.
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName The customerName to set.
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return Returns the imageReferenceNumber.
	 */
	public String getImageReferenceNumber() {
		return imageReferenceNumber;
	}
	/**
	 * @param imageReferenceNumber The imageReferenceNumber to set.
	 */
	public void setImageReferenceNumber(String imageReferenceNumber) {
		this.imageReferenceNumber = imageReferenceNumber;
	}
	/**
	 * @return Returns the iNAC.
	 */
	public String getINAC() {
		return iNAC;
	}
	/**
	 * @param inac The iNAC to set.
	 */
	public void setINAC(String inac) {
		iNAC = inac;
	}
	/**
	 * @return Returns the agreementNumber.
	 */
	public String getAgreementNumber() {
		return agreementNumber;
	}
	/**
	 * @param agreementNumber The agreementNumber to set.
	 */
	public void setAgreementNumber(String agreementNumber) {
		this.agreementNumber = agreementNumber;
	}
	/**
	 * @return Returns the baseAgreementMap.
	 */
	
	/**
	 * @return Returns the customerNumber.
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}
	/**
	 * @param customerNumber The customerNumber to set.
	 */
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	/**
	 * @return Returns the enterpriseNumber.
	 */
	public String getEnterpriseNumber() {
		return enterpriseNumber;
	}
	/**
	 * @param enterpriseNumber The enterpriseNumber to set.
	 */
	public void setEnterpriseNumber(String enterpriseNumber) {
		this.enterpriseNumber = enterpriseNumber;
	}
	/**
	 * @return Returns the formNumber.
	 */
	public String getFormNumber() {
		return formNumber;
	}
	/**
	 * @param formNumber The formNumber to set.
	 */
	public void setFormNumber(String formNumber) {
		this.formNumber = formNumber;
	}
	
    /**
     *gets the  baseAgreementList
     *
     * @return Returns the baseAgreementList.
     */
    public ArrayList getBaseAgreementList() {
        return baseAgreementList;
    }
    /**
     * sets the baseAgreementList
     * @param baseAgreementList The baseAgreementList to set.
     */
    public void setBaseAgreementList(ArrayList baseAgreementList) {
        this.baseAgreementList = baseAgreementList;
    }
}
