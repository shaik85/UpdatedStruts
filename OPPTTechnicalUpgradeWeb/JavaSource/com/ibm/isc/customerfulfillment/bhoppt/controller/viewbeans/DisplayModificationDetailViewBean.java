/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.common.BaseAgreementStatusConstant;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ModificationTypeCodeActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ROLModificationCustomDTO;

/**
 * Holds the basic information about a contract  
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
public class DisplayModificationDetailViewBean extends OPPTViewBean{

    private int agreementId = 0;

    private String modificationTypeCode = null;

    private String legalContact = null;

    private String accountingContact = null;

    private String modifiedIBMLetterHead = null;

    private String revenueRecognition = null;

    private String rolStartDate = null;
    
    private String rolEndDate = null;

    private TreeMap rolOptions = null;
    
    private String details = null; 
    
    private String selectedRolOption = null;
    
    private Date rolStartDateView = null;
    
    private Date rolEndDateView = null;
 
    private String status=null;
  
    private Date createdDate=null;
    
    private Date changedDate=null;
    
    private String createdBy=null;
    
    private String changedBy=null;
    
    
    
    /**
     * Default Constructor 
     * 
     * 
     */
    public DisplayModificationDetailViewBean(){
        
    }
    /**
     * Constructor 
     * 
     * @param rOLModificationCustomDTO
     */
    public DisplayModificationDetailViewBean(ROLModificationCustomDTO rOLModificationCustomDTO){
    	
    	String string1= null;
       	String string2 = null;    	
       	setAccountingContact(rOLModificationCustomDTO.getAccountingContact());
        setAgreementId(rOLModificationCustomDTO.getAgreementId());
        setLegalContact(rOLModificationCustomDTO.getLegalContract());
        setModificationTypeCode(OPPTStaticDataHolder.getModificationTypeDescription(rOLModificationCustomDTO.getModificationTypeCode()));
        setModifiedIBMLetterHead(rOLModificationCustomDTO.getModifiedLetterHead());
        setRevenueRecognition(rOLModificationCustomDTO.getRevenueRecognition());
       	setStatus(rOLModificationCustomDTO.getStatus());      
        SimpleDateFormat sdf =  new SimpleDateFormat("MM/dd/yyyy");  /* NOI18N */
      try
	  {
     if(null != rOLModificationCustomDTO.getRolStartDate() ){
       	string1 = sdf.format(rOLModificationCustomDTO.getRolStartDate());
     }
     if(null != rOLModificationCustomDTO.getRolEndDate()){
       	string2 = sdf.format(rOLModificationCustomDTO.getRolEndDate());
     }
	  }catch(Exception e){}
      
        setRolStartDate(string1);
        setRolEndDate(string2);
        setRolStartDateView(rOLModificationCustomDTO.getRolStartDate());
        setRolEndDateView(rOLModificationCustomDTO.getRolEndDate());
        setDetails(rOLModificationCustomDTO.getDetails());
        setSelectedRolOption(rOLModificationCustomDTO.getModificationOption());
        setCreatedDate(rOLModificationCustomDTO.getCreatedDate());
        setChangedDate(rOLModificationCustomDTO.getChangedDate());
        setCreatedBy(rOLModificationCustomDTO.getCreatedBy());
        setChangedBy(rOLModificationCustomDTO.getChangedBy());
        TreeMap rolOptionsMap = new TreeMap();
        rolOptionsMap.putAll(OPPTStaticDataHolder.rolOptionsMap);
        setRolOptions(rolOptionsMap);        
        ModificationActionForm modificationActionForm = new ModificationActionForm();
        modificationActionForm.setagreementId(rOLModificationCustomDTO.getAgreementId());
        modificationActionForm.setLegalContact(rOLModificationCustomDTO.getAccountingContact());
        modificationActionForm.setAccountingContact(rOLModificationCustomDTO.getLegalContract());
        modificationActionForm.setDetails(rOLModificationCustomDTO.getDetails());
        modificationActionForm.setModificationTypeCode(rOLModificationCustomDTO.getModificationTypeCode());
        modificationActionForm.setModifiedIBMLetterHead(rOLModificationCustomDTO.getModifiedLetterHead());
        modificationActionForm.setRevenueRecognition(rOLModificationCustomDTO.getRevenueRecognition());
        modificationActionForm.setRolOptions(rOLModificationCustomDTO.getModificationOption());
        modificationActionForm.setRolStartDate(string1);
        modificationActionForm.setRolEndDate(string2);
        setActionForm(modificationActionForm);
    }
  /**
   *Constructor of DisplayModificationDetailViewBean
   *@author Ravi Yandapalli
   *
   *Dec 27, 2006   6:09:19 PM
   * @param modificationCustomDTO
   */
   
	public DisplayModificationDetailViewBean(ModificationCustomDTO modificationCustomDTO){
    	
    	setAccountingContact(modificationCustomDTO.getAccountingContact());
        setAgreementId(modificationCustomDTO.getAgreementId());
        setLegalContact(modificationCustomDTO.getLegalContract());
        setModificationTypeCode(OPPTStaticDataHolder.getModificationTypeDescription(modificationCustomDTO.getModificationTypeCode()));
        setStatus(modificationCustomDTO.getStatus());
        setModifiedIBMLetterHead(modificationCustomDTO.getModifiedLetterHead());
        setRevenueRecognition(modificationCustomDTO.getRevenueRecognition());
        setDetails(modificationCustomDTO.getDetails());   
        setCreatedDate(modificationCustomDTO.getCreatedDate());
        setChangedDate(modificationCustomDTO.getChangedDate());
        setCreatedBy(modificationCustomDTO.getCreatedBy());
        setChangedBy(modificationCustomDTO.getChangedBy());
        ModificationActionForm modificationActionForm = new ModificationActionForm();
        modificationActionForm.setagreementId(modificationCustomDTO.getAgreementId());
        modificationActionForm.setLegalContact(modificationCustomDTO.getAccountingContact());
        modificationActionForm.setAccountingContact(modificationCustomDTO.getLegalContract());
        modificationActionForm.setDetails(modificationCustomDTO.getDetails());
        modificationActionForm.setModificationTypeCode(modificationCustomDTO.getModificationTypeCode());
        modificationActionForm.setModifiedIBMLetterHead(modificationCustomDTO.getModifiedLetterHead());
        modificationActionForm.setRevenueRecognition(modificationCustomDTO.getRevenueRecognition());
        setActionForm(modificationActionForm);  
    }
    /**
     *Constructor of DisplayModificationDetailViewBean
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:09:33 PM
     * @param actionForm
     * @param lstatus
     */
    
    public DisplayModificationDetailViewBean(ModificationActionForm actionForm,String lstatus){
    	 if((BaseAgreementStatusConstant.Active).equals(lstatus)){
        	setStatus(("A"));  /* NOI18N */
            }
            else{
            	setStatus(("I"));  /* NOI18N */
            }
        setAccountingContact(actionForm.getAccountingContact());
        setAgreementId(actionForm.getAgreementId());
        setLegalContact(actionForm.getLegalContact());
        setModificationTypeCode(actionForm.getModificationTypeCode());
        if("true".equals(actionForm.getModifiedIBMLetterHead())) { /* NOI18N */
           
        	setModifiedIBMLetterHead(UtilityConstants.YES);
	    }else {
	    	setModifiedIBMLetterHead(UtilityConstants.NO);
	    }
	    if("true".equals(actionForm.getRevenueRecognition())) {  /* NOI18N */
	    	 setRevenueRecognition(UtilityConstants.YES);
	    }else {
	    	 setRevenueRecognition(UtilityConstants.NO);
	    }		    
	    TreeMap rolOptionsMap = new TreeMap();
        rolOptionsMap.putAll(OPPTStaticDataHolder.rolOptionsMap);
        setRolOptions(rolOptionsMap);
	    setRolStartDate(actionForm.getRolStartDate());
	    setRolEndDate(actionForm.getRolEndDate());
	    setRolStartDateView(reverseDate(actionForm.getRolStartDate()));
	    setRolEndDateView(reverseDate(actionForm.getRolEndDate())); 
        setDetails(actionForm.getDetails());
        setSelectedRolOption(actionForm.getRolOptions());
        setActionForm(actionForm);                               
    }
          
    /**
     * Returns the accountingContact.
     * 
     * @return String
     */
    public String getAccountingContact() {
        return accountingContact;
    }

    /**
     * sets the accountingContact
     * 
     * @param laccountingContact String
     *           
     */
    public void setAccountingContact(String laccountingContact) {
        accountingContact = laccountingContact;
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
     * Sets the agreementId
     * 
     * @param lagreementId int
     *            
     */
    public void setAgreementId(int lagreementId) {
        agreementId = lagreementId;
    }

    /**
     * Returns the legalContact.
     * 
     * @return String
     */
    public String getLegalContact() {
        return legalContact;
    }

    /**
     * sets the legalContact
     * 
     * @param llegalContact
     *            
     */
    public void setLegalContact(String llegalContact) {
        legalContact = llegalContact;
    }

    /**
     * Returns the modificationTypeCode.
     * 
     * @return String
     */
    public String getModificationTypeCode() {
        return modificationTypeCode;
    }

    /**
     * sets the modTypeCodes
     * 
     * @param lmodificationTypeCode
     *           
     */
    public void setModificationTypeCode(String lmodificationTypeCode) {
        modificationTypeCode = lmodificationTypeCode;
    }

    /**
     * Returns the modifiedIBMLetterHead.
     * 
     * @return String
     */
    public String getModifiedIBMLetterHead() {
        return modifiedIBMLetterHead;
    }

    /**
     * sets modifiedIBMLetterHead boolean field
     * 
     * @param lmodifiedIBMLetterHead
     *           
     */
    public void setModifiedIBMLetterHead(String lmodifiedIBMLetterHead) {
        modifiedIBMLetterHead = lmodifiedIBMLetterHead;
    }

    /**
     * Returns the revenueRecognition.
     * 
     * @return String
     */
    public String getRevenueRecognition() {
        return revenueRecognition;
    }

    /**
     * sets the revenue regognition info
     * 
     * @param lrevenueRecognition String
     *            
     */
    public void setRevenueRecognition(String lrevenueRecognition) {
        revenueRecognition = lrevenueRecognition;
    }

    /**
     * sets the Rolmovedate 
     * 
     * @param lrolMoveDate Date
     *            
     */
    public void setRolStartDate(String lrolMoveDate) {
        rolStartDate = lrolMoveDate;
    }
   
    /**
     * returns the details
     *
     * @return Returns the details.
     */
    public String getDetails() {
        return details;
    }
    /**
     * sets the details
     *
     * @param lDetails The details to set.
     */
    public void setDetails(String lDetails) {
        details = lDetails;
    }
    /**
     * returns the rolOptions
     *
     * @return Returns the rolOptions.
     */
    public TreeMap getRolOptions() {
        return rolOptions;
    }
    /**
     * sets the rolOptions
     *
     * @param lRolOptions The rolOptions to set.
     */
    public void setRolOptions(TreeMap lRolOptions) {
        rolOptions = lRolOptions;
    }
    
    /**
     * returns ModificationActionForm
     *
     * @return ModificationActionForm
     */
    public ModificationActionForm getModificationActionForm(){
        ModificationActionForm modificationActionForm = (ModificationActionForm)getActionForm();
        return modificationActionForm;
    }
    /**
     * returns ModificationTypeCodeActionForm
     *
     * @return ModificationActionForm
     */
    public ModificationTypeCodeActionForm getModificationTypeCodeActionForm(){
        ModificationTypeCodeActionForm modificationTypeCodeActionForm = (ModificationTypeCodeActionForm)getActionForm();
        return modificationTypeCodeActionForm;
    }
    /**
     * returns the selectedRolOption
     *
     * @return Returns the selectedRolOption.
     */
    public String getSelectedRolOption() {
        return selectedRolOption;
    }
    /**
     * sets the selectedRolOption
     *
     * @param lSelectedRolOption The selectedRolOption to set.
     */
    public void setSelectedRolOption(String lSelectedRolOption) {
        selectedRolOption = lSelectedRolOption;
    }
    /**
     * 
     *reverseDate
     *
     *@author Ravi Yandapalli
     *
     * Dec 27, 20066:10:15 PM
     * @param dateString
     * @return
     */
    public Date reverseDate(String dateString){
    	Date date = null;
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");  /* NOI18N */
    	try{
    		if(null != dateString){
           date = simpleDateFormat.parse(dateString);
    		}
    	}catch(Exception e){
	    	// We do not handle this exception
	    }
    	
    	return date;
    }
    
	
    /**
     *this is the getter method for changedBy 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:50 PM
     *
     * @return String.
     */
    public String getChangedBy() {
        return changedBy;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:50 PM
     * @param lChangedBy changedBy.
     */
    public void setChangedBy(String lChangedBy) {
        changedBy = lChangedBy;
    }
    /**
     *this is the getter method for changedDate 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:50 PM
     *
     * @return Date.
     */
    public Date getChangedDate() {
        return changedDate;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:50 PM
     * @param lChangedDate changedDate.
     */
    public void setChangedDate(Date lChangedDate) {
        changedDate = lChangedDate;
    }
    /**
     *this is the getter method for createdBy 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:50 PM
     *
     * @return String.
     */
    public String getCreatedBy() {
        return createdBy;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:50 PM
     * @param lCreatedBy createdBy.
     */
    public void setCreatedBy(String lCreatedBy) {
        createdBy = lCreatedBy;
    }
    /**
     *this is the getter method for createdDate 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:50 PM
     *
     * @return Date.
     */
    public Date getCreatedDate() {
        return createdDate;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:50 PM
     * @param lCreatedDate createdDate.
     */
    public void setCreatedDate(Date lCreatedDate) {
        createdDate = lCreatedDate;
    }
    /**
     *this is the getter method for rolEndDate 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:50 PM
     *
     * @return String.
     */
    public String getRolEndDate() {
        return rolEndDate;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:50 PM
     * @param lRolEndDate rolEndDate.
     */
    public void setRolEndDate(String lRolEndDate) {
        rolEndDate = lRolEndDate;
    }
    /**
     *this is the getter method for rolEndDateView 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:50 PM
     *
     * @return Date.
     */
    public Date getRolEndDateView() {
        return rolEndDateView;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:50 PM
     * @param lRolEndDateView rolEndDateView.
     */
    public void setRolEndDateView(Date lRolEndDateView) {
        rolEndDateView = lRolEndDateView;
    }
    /**
     *this is the getter method for rolStartDateView 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:50 PM
     *
     * @return Date.
     */
    public Date getRolStartDateView() {
        return rolStartDateView;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:50 PM
     * @param lRolStartDateView rolStartDateView.
     */
    public void setRolStartDateView(Date lRolStartDateView) {
        rolStartDateView = lRolStartDateView;
    }
    /**
     *this is the getter method for status 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:50 PM
     *
     * @return String.
     */
    public String getStatus() {
        return status;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:51 PM
     * @param lStatus status.
     */
    public void setStatus(String lStatus) {
        status = lStatus;
    }
    /**
     *this is the getter method for rolStartDate 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:11:51 PM
     *
     * @return String.
     */
    public String getRolStartDate() {
        return rolStartDate;
    }
 }
