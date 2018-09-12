/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO;

/**
 * Holds the detail information about a form  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date oct 11, 2006 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Nayanatara L Pai
 *
 */
public class FormDetailViewBean extends OPPTViewBean {
	
	private String formNumber = null;
	
	private String formLongDescription = null;
	
	private String formShortDescription = null;
	
	private String language = null;
	
	private String salesOrg = null;
	
	/**
	 * Default constructor
	 * 
	 */
	public FormDetailViewBean(){
		
	}
	
	/**
     * Constructor - sets the FormDetailsCustomDTO
     *
     * @param formDetailsCustomDTO The formDetailsCustomDTO to set.
     */
	public FormDetailViewBean(FormDetailsCustomDTO formDetailsCustomDTO){
	   
		setFormNumber(formDetailsCustomDTO.getFormNumber());
		setFormLongDescription(formDetailsCustomDTO.getFormLongDescription());
		setFormShortDescription(formDetailsCustomDTO.getFormShortDescription());
		setSalesOrg(formDetailsCustomDTO.getSalesOrg());
           
    }
	
	
	

    /**
     *this is the getter method for formLongDescription 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:13:00 PM
     *
     * @return String.
     */
    public String getFormLongDescription() {
        return formLongDescription;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:13:00 PM
     * @param lFormLongDescription formLongDescription.
     */
    public void setFormLongDescription(String lFormLongDescription) {
        formLongDescription = lFormLongDescription;
    }
    /**
     *this is the getter method for formNumber 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:13:00 PM
     *
     * @return String.
     */
    public String getFormNumber() {
        return formNumber;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:13:00 PM
     * @param lFormNumber formNumber.
     */
    public void setFormNumber(String lFormNumber) {
        formNumber = lFormNumber;
    }
    /**
     *this is the getter method for formShortDescription 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:13:00 PM
     *
     * @return String.
     */
    public String getFormShortDescription() {
        return formShortDescription;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:13:00 PM
     * @param lFormShortDescription formShortDescription.
     */
    public void setFormShortDescription(String lFormShortDescription) {
        formShortDescription = lFormShortDescription;
    }
    /**
     *this is the getter method for language 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:13:00 PM
     *
     * @return String.
     */
    public String getLanguage() {
        return language;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:13:00 PM
     * @param lLanguage language.
     */
    public void setLanguage(String lLanguage) {
        language = lLanguage;
    }
    /**
     *this is the getter method for salesOrg 
     *
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:13:00 PM
     *
     * @return String.
     */
    public String getSalesOrg() {
        return salesOrg;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   6:13:00 PM
     * @param lSalesOrg salesOrg.
     */
    public void setSalesOrg(String lSalesOrg) {
        salesOrg = lSalesOrg;
    }
}
