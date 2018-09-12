/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Iterator;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.SearchParamActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SearchBaseAgreementCustomDTO;

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
public class SearchBaseAgreementViewBean extends OPPTViewBean{
   
    private String customerNumber = null;

    private String enterpriseNumber = null;

    private String formNumber = null;

    private String agreementNumber = null;

    private ArrayList baseAgreementList = null;
    
    private String customerName = null;
    
    private String imageReferenceNumber =null;
    
    private String customerLegacyNumber=null;
    
    private String iNAC=null;
    
	
	/**
	 * 
	 *setCustomerLegacyNumber
	 *
	 *@author Ravi Yandapalli
	 *
	 * Dec 27, 20066:18:38 PM
	 * @param lcustomerLegacyNumber
	 */
	public void setCustomerLegacyNumber(String lcustomerLegacyNumber) {
		SearchParamActionForm searchParamActionForm = new SearchParamActionForm();
    	if(null != getActionForm() && getActionForm() instanceof SearchParamActionForm){
    		searchParamActionForm = (SearchParamActionForm) getActionForm();
    	}
    	searchParamActionForm.setAccountNumber(customerLegacyNumber);
    	setActionForm(searchParamActionForm);
		
		customerLegacyNumber = lcustomerLegacyNumber;
	}
	
    /**
     *this is the getter method for customerLegacyNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:20:05 PM
     *
     * @return String.
     */
    public String getCustomerLegacyNumber() {
        return customerLegacyNumber;
    }
	/**
	 *getCustomerName
	 *
	 *@author Ravi Yandapalli
	 *
	 * Dec 27, 20066:18:48 PM
	 * @return
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
     *setCustomerName
     *
     *@author Ravi Yandapalli
     * Dec 27, 20066:27:10 PM
     * @param lcustomerName 
     */
	public void setCustomerName(String lcustomerName) {
		SearchParamActionForm searchParamActionForm = new SearchParamActionForm();
    	if(null != getActionForm() && getActionForm() instanceof SearchParamActionForm){
    		searchParamActionForm = (SearchParamActionForm) getActionForm();
    	}
    	searchParamActionForm.setAccountNumber(customerName);
    	setActionForm(searchParamActionForm);
		
		customerName = lcustomerName;
	}
	/**
	 *getImageReferenceNumber
	 *
	 *@author Ravi Yandapalli
	 *
	 * Dec 27, 20066:19:12 PM
	 * @return
	 */
	public String getImageReferenceNumber() {
		return imageReferenceNumber;
	}
	/**
	 *setImageReferenceNumber
	 *
	 *@author Ravi Yandapalli
	 *
	 * Dec 27, 20066:19:19 PM
	 * @param limageReferenceNumber
	 */
	public void setImageReferenceNumber(String limageReferenceNumber) {
		
		SearchParamActionForm searchParamActionForm = new SearchParamActionForm();
    	if(null != getActionForm() && getActionForm() instanceof SearchParamActionForm){
    		searchParamActionForm = (SearchParamActionForm) getActionForm();
    	}
    	searchParamActionForm.setAccountNumber(imageReferenceNumber);
    	setActionForm(searchParamActionForm);
        
		imageReferenceNumber = limageReferenceNumber;
	}
	/**
	 *getINAC
	 *
	 *@author Ravi Yandapalli
	 *
	 * Dec 27, 20066:19:34 PM
	 * @return
	 */
	public String getINAC() {
		return iNAC;
	}
	/**
	 *setINAC
	 *
	 *@author Ravi Yandapalli
	 *
	 * Dec 27, 20066:19:40 PM
	 * @param inac
	 */
	public void setINAC(String inac) {
		SearchParamActionForm searchParamActionForm = new SearchParamActionForm();
    	if(null != getActionForm() && getActionForm() instanceof SearchParamActionForm){
    		searchParamActionForm = (SearchParamActionForm) getActionForm();
    	}
    	searchParamActionForm.setAccountNumber(inac);
    	setActionForm(searchParamActionForm);
        iNAC = inac;
	}
    /**
     * default constructor
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
     public SearchBaseAgreementViewBean(){
        
    }
     /**
      * constructor 
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
      * @param searchBACustomDto
      * 
      */
    public SearchBaseAgreementViewBean(SearchBaseAgreementCustomDTO searchBACustomDto){
      
        setAgreementNumber(searchBACustomDto.getAgreementNumber());
        setCustomerNumber(searchBACustomDto.getCustomerNumber());
        setEnterpriseNumber(searchBACustomDto.getEnterpriseNumber());
        setFormNumber(searchBACustomDto.getFormNumber());
        setCustomerName(searchBACustomDto.getCustomerName());
        setImageReferenceNumber(searchBACustomDto.getImageReferenceNumber());
        setCustomerLegacyNumber(searchBACustomDto.getCustomerLegacyNumber());
        setINAC(searchBACustomDto.getINAC());
        
       ArrayList lbaseAgreementList = searchBACustomDto.getBaseAgreementList();
        
        Iterator baseAgreementIterator = lbaseAgreementList.iterator();
        ArrayList baseAgreementViewList = new ArrayList();
        
         while (baseAgreementIterator.hasNext()) {
          BaseAgreementCustomDTO baseAgreementCustomDTO = (BaseAgreementCustomDTO)baseAgreementIterator.next();
          BaseAgreementViewBean baseAgreementVewBean = new BaseAgreementViewBean(baseAgreementCustomDTO);
          baseAgreementViewList.add(baseAgreementVewBean);
         }
        setBaseAgreementList(baseAgreementViewList);
        setButtonFlags(searchBACustomDto.getButtonFlags());
        
        
        SearchParamActionForm searchParamActionForm = new SearchParamActionForm();
        searchParamActionForm.setAgreementNumber(getAgreementNumber());
        searchParamActionForm.setFormNumber(getFormNumber());
        searchParamActionForm.setCustomerNumber(getCustomerNumber());
        searchParamActionForm.setEnterpriseNumber(getEnterpriseNumber());
        searchParamActionForm.setAccountNumber(getINAC());
        searchParamActionForm.setImageReferenceNumber(getImageReferenceNumber());
        searchParamActionForm.setCustomerLegacyNumber(getCustomerLegacyNumber());
        searchParamActionForm.setCustomerName(getCustomerName());
        setActionForm(searchParamActionForm);
        
        
    }
    /**
     * returns the agreementNumber
     *
     * @return Returns the agreementNumber.
     */
    public String getAgreementNumber() {
        return agreementNumber;
    }
    /**
     * sets the agreementNumber
     *
     * @param lAgreementNumber The agreementNumber to set.
     */
    public void setAgreementNumber(String lAgreementNumber) {
    	SearchParamActionForm searchParamActionForm = new SearchParamActionForm();
    	if(null != getActionForm() && getActionForm() instanceof SearchParamActionForm){
    		searchParamActionForm = (SearchParamActionForm) getActionForm();
    	}
    	searchParamActionForm.setAgreementNumber(lAgreementNumber);
    	setActionForm(searchParamActionForm);
        agreementNumber = lAgreementNumber;
    }
    
    /**
     * returns the customerNumber
     *
     * @return Returns the customerNumber.
     */
    public String getCustomerNumber() {
        return customerNumber;
    }
    /**
     * sets the customerNumber
     *
     * @param lCustomerNumber The customerNumber to set.
     */
    public void setCustomerNumber(String lCustomerNumber) {
    	SearchParamActionForm searchParamActionForm = new SearchParamActionForm();
    	if(null != getActionForm() && getActionForm() instanceof SearchParamActionForm){
    		searchParamActionForm = (SearchParamActionForm) getActionForm();
    	}
    	searchParamActionForm.setCustomerNumber(lCustomerNumber);
    	setActionForm(searchParamActionForm);
        customerNumber = lCustomerNumber;
    }
  
    
    /**
     * returns the formNumber
     *
     * @return Returns the formNumber.
     */
    public String getFormNumber() {
        return formNumber;
    }
    /**
     * sets the formNumber
     *
     * @param lFormNumber The formNumber to set.
     */
    public void setFormNumber(String lFormNumber) {
    	SearchParamActionForm searchParamActionForm = new SearchParamActionForm();
    	if(null != getActionForm() && getActionForm() instanceof SearchParamActionForm){
    		searchParamActionForm = (SearchParamActionForm) getActionForm();
    	}
    	searchParamActionForm.setFormNumber(lFormNumber);
    	setActionForm(searchParamActionForm);
        formNumber = lFormNumber;
    }
    /**
     * return the enterpriseNumber 
     *
     * @return Returns the enterpriseNumber.
     */
    public String getEnterpriseNumber() {
        return enterpriseNumber;
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
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:20:57 PM
     * @param lBaseAgreementList baseAgreementList.
     */
    public void setBaseAgreementList(ArrayList lBaseAgreementList) {
        baseAgreementList = lBaseAgreementList;
    }
    /**
     * sets the enterpriseNumber
     *
     * @param lEnterpriseNumber The enterpriseNumber to set.
     */
    public void setEnterpriseNumber(String lEnterpriseNumber) {
    	SearchParamActionForm searchParamActionForm = new SearchParamActionForm();
    	if(null != getActionForm() && getActionForm() instanceof SearchParamActionForm){
    		searchParamActionForm = (SearchParamActionForm) getActionForm();
    	}
    	searchParamActionForm.setEnterpriseNumber(lEnterpriseNumber);
    	setActionForm(searchParamActionForm);
        enterpriseNumber = lEnterpriseNumber;
    }
    
    
}

