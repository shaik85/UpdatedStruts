/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2006, 2008
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.BaseAgreementChangeLogActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementChangeLogCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementChangeLogDetailsCustomDTO;

/**
 * BaseAgreement ChangeLog Details ViewBean
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAgreementChangeLogDetailsViewBean extends OPPTViewBean {
    
   
    private ArrayList changedDetailsList= null;
    private String agreementNumber = null;
    private String customerNumber = null;
    private TreeMap salesOrgMap = null;
    private String salesOrg=null;
    private String enterpriseNumber=null;
    private String iNACNumber=null;
    private String isModified = null;
    
    /**
     *Default Constructor of BaseAgreementChangeLogDetailsViewBean
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:52:08 PM
     *
     */
    public BaseAgreementChangeLogDetailsViewBean(){
        
    }
    /**
     *Constructor of BaseAgreementChangeLogDetailsViewBean
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:52:22 PM
     * @param customDTO
     */
    
    public BaseAgreementChangeLogDetailsViewBean(BaseAgreementChangeLogDetailsCustomDTO customDTO){
        TreeMap staticSalesOrgMap = new TreeMap();
        staticSalesOrgMap.putAll(OPPTStaticDataHolder.salesOrgMapForBaseAgreement);
       
     if(null != staticSalesOrgMap){
         setSalesOrgMap(staticSalesOrgMap);
     }
       
        setAgreementNumber(customDTO.getAgreementNumber());
        setCustomerNumber(customDTO.getCustomerNumber());
        setSalesOrg(customDTO.getSalesOrg());
        setEnterpriseNumber(customDTO.getEnterpriseNumber());
        setINACNumber(customDTO.getINACNumber());
        setIsModified(customDTO.getIsModified());
        ArrayList changeLogViewBeanList = new ArrayList();
        ArrayList changeLogList =customDTO.getChangeDetailslist();
        if(changeLogList != null && changeLogList.size()!=0){
          Iterator changeLogIterator = changeLogList.iterator();
           while(changeLogIterator.hasNext()){
            //Integer agreementId = (Integer)changeLogIterator.next();
           // TreeMap changeLogDetailsMap=(TreeMap)changeLogMap.get(agreementId);
           // Iterator changeLogDetailsIterator=changeLogDetailsMap.keySet().iterator();
       // while(changeLogDetailsIterator.hasNext()){
             BaseAgreementChangeLogCustomDTO changeLogCustomDTO  =(BaseAgreementChangeLogCustomDTO)changeLogIterator.next();
             BaseAgreementChangeDetailsViewBean detailsViewBean = new BaseAgreementChangeDetailsViewBean(changeLogCustomDTO);
             changeLogViewBeanList.add(detailsViewBean);
           //}
         }
        }
        setChangedDetailsList(changeLogViewBeanList);
      
        BaseAgreementChangeLogActionForm actionForm=  new  BaseAgreementChangeLogActionForm();
        	actionForm.setSalesOrganization(customDTO.getSalesOrg());
        	actionForm.setAgreementNumber(customDTO.getAgreementNumber());
        	actionForm.setEnterpriseNumber(customDTO.getEnterpriseNumber());
        	actionForm.setCustomerNumber(customDTO.getCustomerNumber());
        	actionForm.setINACNumber(customDTO.getINACNumber());
        setActionForm(actionForm);
    }
    
    /**
     *gets the  agreementNumber
     *
     * @return Returns the agreementNumber.
     */
    public String getAgreementNumber() {
        return agreementNumber;
    }
    /**
     * sets the agreementNumber
     * @param lagreementNumber The agreementNumber to set.
     */
    public void setAgreementNumber(String lagreementNumber) {
        agreementNumber = lagreementNumber;
    }
 
    /**
     *gets the  changedDetailsList
     *
     * @return Returns the changedDetailsList.
     */
    public ArrayList getChangedDetailsList() {
        return changedDetailsList;
    }
   
    /**
     *gets the  customerNumber
     *
     * @return Returns the customerNumber.
     */
    public String getCustomerNumber() {
        return customerNumber;
    }
    /**
     * sets the customerNumber
     * @param lcustomerNumber The customerNumber to set.
     */
    public void setCustomerNumber(String lcustomerNumber) {
        customerNumber = lcustomerNumber;
    }

    
    

    /**
     *gets the  enterpriseNumber
     *
     * @return Returns the enterpriseNumber.
     */
    public String getEnterpriseNumber() {
        return enterpriseNumber;
    }
    /**
     * sets the enterpriseNumber
     * @param lenterpriseNumber The enterpriseNumber to set.
     */
    public void setEnterpriseNumber(String lenterpriseNumber) {
       enterpriseNumber = lenterpriseNumber;
    }
    /**
     *gets the  iNACNumber
     *
     * @return Returns the iNACNumber.
     */
    public String getINACNumber() {
        return iNACNumber;
    }
    /**
     * sets the iNACNumber
     * @param number The iNACNumber to set.
     */
    public void setINACNumber(String number) {
        iNACNumber = number;
    }
    /**
     *gets the  salesOrg
     *
     * @return Returns the salesOrg.
     */
    public String getSalesOrg() {
        return salesOrg;
    }
    /**
     * sets the salesOrg
     * @param lsalesOrg The salesOrg to set.
     */
    public void setSalesOrg(String lsalesOrg) {
        String salesOrginisation = null;
        String value = (String)getSalesOrgMap().get(lsalesOrg);
        salesOrginisation = value+"-"+lsalesOrg;  /* NOI18N */
       
    }
    /**
     *gets the  salesOrgMap
     *
     * @return Returns the salesOrgMap.
     */
    public TreeMap getSalesOrgMap() {
        return salesOrgMap;
    }
   
   
    /**
     *gets the  isModified
     *
     * @return Returns the isModified.
     */
    public String getIsModified() {
        return isModified;
    }
    
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:54:56 PM
     * @param lChangedDetailsList changedDetailsList.
     */
    public void setChangedDetailsList(ArrayList lChangedDetailsList) {
        changedDetailsList = lChangedDetailsList;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:54:56 PM
     * @param lIsModified isModified.
     */
    public void setIsModified(String lIsModified) {
        isModified = lIsModified;
    }
    /**
     * Setere method
     *@author Ravi Yandapalli
     *
     *Dec 27, 2006   5:54:57 PM
     * @param lSalesOrgMap salesOrgMap.
     */
    public void setSalesOrgMap(TreeMap lSalesOrgMap) {
        salesOrgMap = lSalesOrgMap;
    }
  /**
   * 
   *getSalesOrgDetails
   *
   *@author Ravi Yandapalli
   *
   * Dec 27, 20065:54:09 PM
   * @return
   */
    public TreeMap getSalesOrgDetails(){
    	TreeMap lsalesOrgMap = new TreeMap();
    	TreeMap treeMap = getSalesOrgMap();
    	Iterator iterator = treeMap.keySet().iterator();
    	while(iterator.hasNext()){
    		String key = (String)iterator.next();
    		String value = (String)treeMap.get(key);
    		lsalesOrgMap.put(key,value +"-"+ key);  /* NOI18N */
    	}
    	return lsalesOrgMap;
    }
    
    /**
     * 
     *getBaseAgreementChangeLogActionForm
     *
     *@author Ravi Yandapalli
     *
     * Dec 27, 20065:54:38 PM
     * @return
     */
    public BaseAgreementChangeLogActionForm getBaseAgreementChangeLogActionForm(){
        BaseAgreementChangeLogActionForm baseAgreementChangeLogActionForm = null;
        if(null != getActionForm() && getActionForm() instanceof BaseAgreementChangeLogActionForm){
            baseAgreementChangeLogActionForm = (BaseAgreementChangeLogActionForm)getActionForm();
        }
        else{
            baseAgreementChangeLogActionForm = new BaseAgreementChangeLogActionForm();
        }
        return baseAgreementChangeLogActionForm;
    }
}
