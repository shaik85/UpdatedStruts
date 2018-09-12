/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementStatusConstant;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementCustomDTO;

/**
 * Holds the basic information about an agreement  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date jun 13, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Gavaskar Bhojan
 *
 */
public class BaseAgreementViewBean extends OPPTViewBean{

    private int agreementId = 0;

    private String enterpriseNumber = null;

    private String formNumber = null;

    private String agreementNumber = null;

    private String customerName = null;

    private String agreementStatus = null;

    private String customerNumber = null;
   
    private String customerLegacyNumber = null;

	private String imageReferenceNumber = null;
	
	private String iNAC = null;
    
    
    /**
     * constructor
     * 
     * 
     */
    public BaseAgreementViewBean(){
        
    }
    
    /**
     * 
     * Constructor of BaseAgreementViewBean
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:06:14 PM
     * @param customdto
     */
    public BaseAgreementViewBean(BaseAgreementCustomDTO customdto){
        
        setAgreementId(customdto.getAgreementId());
        setEnterpriseNumber(customdto.getEnterpriseNumber());
        setFormNumber(customdto.getFormNumber());
        setAgreementNumber(customdto.getAgreementNumber());
        setCustomerName(customdto.getCustomerName());
        setCustomerNumber(customdto.getCustomerNumber());
        setCustomerLegacyNumber(customdto.getCustomerLegacyNumber());
        setImageReferenceNumber(customdto.getImageReferenceNumber());
        setINAC(customdto.getINAC());
        
        if((BaseAgreementStatusConstant.Active).equals(customdto.getAgreementStatus())){
        setAgreementStatus("Active");  /* NOI18N */
        }
        else{
            setAgreementStatus("InActive");  /* NOI18N */ 
            
        }
        
        
       }
    
     /**
     * Returns the agreementId.
     * 
     * @return int
     */
    public int getAgreementId() {
        return agreementId;
    }

    /**
     * sets the agreementId
     * 
     * @param lagreementId int
     *            
     */
    public void setAgreementId(int lagreementId) {
        agreementId = lagreementId;
    }

    /**
     * Returns the agreementNumber.
     * 
     * @return String
     */
    public String getAgreementNumber() {
        return agreementNumber;
    }

    /**
     * 
     * sets the agreementNumber
     * 
     * @param lagreementNumber
     *            
     */
    public void setAgreementNumber(String lagreementNumber) {
        agreementNumber = lagreementNumber;
    }

   

    /**
     *this is the getter method for agreementStatus 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:08:23 PM
     *
     * @return String.
     */
    public String getAgreementStatus() {
        return agreementStatus;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:08:23 PM
     * @param lAgreementStatus agreementStatus.
     */
    public void setAgreementStatus(String lAgreementStatus) {
        agreementStatus = lAgreementStatus;
    }
    /**
     *this is the getter method for customerName 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:08:23 PM
     *
     * @return String.
     */
    public String getCustomerName() {
        return customerName;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:08:23 PM
     * @param lCustomerName customerName.
     */
    public void setCustomerName(String lCustomerName) {
        customerName = lCustomerName;
    }
    /**
     * returns the customerNumber
     * 
     * @return String
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * sets the customerNumber
     * 
     * @param lcustomerNumber
     *            
     */
    public void setCustomerNumber(String lcustomerNumber) {
        customerNumber = lcustomerNumber;
    }

    /**
     * returns enterpriseNumber
     * 
     * @return String
     */
    public String getEnterpriseNumber() {
        return enterpriseNumber;
    }

    /**
     * 
     * sets enterpriseNumber
     * 
     * @param lenterpriseNumber String
     *           
     */
    public void setEnterpriseNumber(String lenterpriseNumber) {
        enterpriseNumber = lenterpriseNumber;
    }

    /**
     * returns formNumber for agreement
     * 
     * @return String
     */
    public String getFormNumber() {
        return formNumber;
    }

   
	
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:07:56 PM
     * @param lFormNumber formNumber.
     */
    public void setFormNumber(String lFormNumber) {
        formNumber = lFormNumber;
    }
    /**
     *this is the getter method for customerLegacyNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:07:46 PM
     *
     * @return String.
     */
    public String getCustomerLegacyNumber() {
        return customerLegacyNumber;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:07:46 PM
     * @param lCustomerLegacyNumber customerLegacyNumber.
     */
    public void setCustomerLegacyNumber(String lCustomerLegacyNumber) {
        customerLegacyNumber = lCustomerLegacyNumber;
    }
    /**
     *this is the getter method for imageReferenceNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:07:46 PM
     *
     * @return String.
     */
    public String getImageReferenceNumber() {
        return imageReferenceNumber;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:07:46 PM
     * @param lImageReferenceNumber imageReferenceNumber.
     */
    public void setImageReferenceNumber(String lImageReferenceNumber) {
        imageReferenceNumber = lImageReferenceNumber;
    }
    /**
     *this is the getter method for iNAC 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:07:46 PM
     *
     * @return String.
     */
    public String getINAC() {
        return iNAC;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:07:46 PM
     * @param lInac iNAC.
     */
    public void setINAC(String lInac) {
        iNAC = lInac;
    }
}
