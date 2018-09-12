/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CCMSCustomerSelectionActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.CCMSCustomerDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.CCMSCustomerSelectionCustomDTO;

/**
 * @author Ravi Yandapalli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CCMSCustomerSelectionViewBean extends OPPTViewBean {
   
    private String cMRNumber= null;
    private String enterpriseNumber= null;
    private String countryCode= null;
   // private TreeMap salesOrgMap = null;
    private ArrayList customerList = null;
    
    
    /**
     *Default Constructor
     *
     */
    public CCMSCustomerSelectionViewBean(){
        
    }
    
    /**
     *Parameterised Constructor
     *
     *@param customDTO
     *
     */
    public CCMSCustomerSelectionViewBean(CCMSCustomerSelectionCustomDTO customDTO){
        
      setCMRNumber(customDTO.getCMRNumber());
      setEnterpriseNumber(customDTO.getEnterpriseNumber());
      setCountryCode(customDTO.getCountryCode());
      ArrayList displayCustomerList = new ArrayList();
      ArrayList dTOList = (ArrayList)customDTO.getCustomerList();
       Iterator iterator=dTOList.iterator();
        while(iterator.hasNext()){
            CCMSCustomerDetailsCustomDTO cCMSCustomerDetailsCustomDTO = (CCMSCustomerDetailsCustomDTO)iterator.next();
            CCMSCustomerDetailsViewBean viewBean =new CCMSCustomerDetailsViewBean(cCMSCustomerDetailsCustomDTO);
            displayCustomerList.add(viewBean);
        }
    setCustomerList(displayCustomerList);
    
    CCMSCustomerSelectionActionForm actionForm = new CCMSCustomerSelectionActionForm();
              
    actionForm.setCmrNumber(customDTO.getCMRNumber());
    actionForm.setEnterpriseNumber(customDTO.getEnterpriseNumber());
    String countrycode = customDTO.getCountryCode();
    actionForm.setCountryCode(countrycode);
    setActionForm(actionForm);
    }
    /**
     *gets the  cMRNumber
     *
     * @return Returns the cMRNumber.
     */
    public String getCMRNumber() {
        return cMRNumber;
    }
    /**
     * sets the cMRNumber
     * @param number The cMRNumber to set.
     */
    public void setCMRNumber(String number) {
        cMRNumber = number;
    }
    /**
     *gets the  countryCode
     *
     * @return Returns the countryCode.
     */
    public String getCountryCode() {
        return countryCode;
    }
    /**
     * sets the countryCode
     * @param countryCode The countryCode to set.
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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
     * @param enterpriseNumber The enterpriseNumber to set.
     */
    public void setEnterpriseNumber(String enterpriseNumber) {
        this.enterpriseNumber = enterpriseNumber;
    }
    
    /**
     *gets the  customerList
     *
     * @return Returns the customerList.
     */
    public ArrayList getCustomerList() {
        return customerList;
    }
    /**
     * sets the customerList
     * @param customerList The customerList to set.
     */
    public void setCustomerList(ArrayList customerList) {
        this.customerList = customerList;
    }
 /*   *//**
     *gets the  salesOrgMap
     *
     * @return Returns the salesOrgMap.
     *//*
    public TreeMap getSalesOrgMap() {
        return salesOrgMap;
    }
    *//**
     * sets the salesOrgMap
     * @param salesOrgMap The salesOrgMap to set.
     *//*
    public void setSalesOrgMap(TreeMap salesOrgMap) {
        this.salesOrgMap = salesOrgMap;
    }*/
    
    public TreeMap getSalesOrgDetails(){
    	TreeMap salesOrgMap = new TreeMap();
    	TreeMap staticSalesOrgMap = new TreeMap();
        staticSalesOrgMap.putAll(OPPTStaticDataHolder.countryCodeMap);
    	Iterator iterator = staticSalesOrgMap.keySet().iterator();
    	while(iterator.hasNext()){
    		String key = (String)iterator.next();
    		String value = (String)staticSalesOrgMap.get(key);
    		salesOrgMap.put(key,value +"-"+ key);
    	}
    	return salesOrgMap;
    }
  
       
}
