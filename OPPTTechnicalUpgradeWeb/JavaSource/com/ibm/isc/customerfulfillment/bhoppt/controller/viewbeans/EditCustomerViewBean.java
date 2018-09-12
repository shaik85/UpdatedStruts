/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.*;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.CustomerInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ESWCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.EditCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalCustomerCustomDTO;

/**
 * Holds complete information required for edit customer view  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 19, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class EditCustomerViewBean extends OPPTViewBean {
	private CustomerInfoDataBean iSoldToParty = null;
	private TreeMap iBillToPartyNumber = null;
	private TreeMap iBillToPartyName = null;
	private TreeMap iPayerNumber = null;
	private TreeMap iPayerName = null;
	
	private String iSelectedBillToParty = null;
	private String iSelectedPayer = null;
	
	private Date iDefaultStartDate = null;
	private Date iDefaultEndDate = null;
	
	private Date iSelectedPlanEndDate = null;
	private Date iSelectedPlanStartDate = null;

	/**
	 * Returns collection of bill to parties  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getBillToPartyNumber() {
		return iBillToPartyNumber;
	}
	/**
     * getBillToPartyName
     * 
     * @return
     * @author thirumalai
     */
    public TreeMap getBillToPartyName() {
		return iBillToPartyName;
	}

	/**
	 * Returns default end date for the customer
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getDefaultEndDate() {
		return iDefaultEndDate;
	}

	/**
	 * Returns default start date for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	public Date getDefaultStartDate() {
		return iDefaultStartDate;
	}

	/**
	 * Returns collection of payers available for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getPayerNumber() {
		return iPayerNumber;
	}
	/**
     * getPayerName
     * 
     * @return
     * @author thirumalai
     */
    public TreeMap getPayerName() {
		return iPayerName;
	}

	/**
	 * Returns the current bill to party for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedBillToParty() {
		return iSelectedBillToParty;
	}

	/**
	 * Returns current payer for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedPayer() {
		return iSelectedPayer;
	}

	/**
	 * Returns sold to party information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CustomerInfoDataBean
	 */
	public CustomerInfoDataBean getSoldToParty() {
		return iSoldToParty;
	}

	/**
     * Sets bill to party collection
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 19, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newBillToPartyNumber 
     */
	public void setBillToPartyNumber(TreeMap newBillToPartyNumber) {
		iBillToPartyNumber = newBillToPartyNumber;
	}
	/**
     * setBillToPartyName
     * 
     * @param newBillToPartyName
     * @author thirumalai
     */
    public void setBillToPartyName(TreeMap newBillToPartyName) {
		iBillToPartyName = newBillToPartyName;
	}

	/**
	 * Sets default end date for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDefaultEndDate Date 
	 */
	public void setDefaultEndDate(Date newDefaultEndDate) {
		iDefaultEndDate = newDefaultEndDate;
	}

	/**
	 * Sets default start date for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDefaultStartDate Date 
	 */
	public void setDefaultStartDate(Date newDefaultStartDate) {
		iDefaultStartDate = newDefaultStartDate;
	}

	/**
     * Sets the payer collection
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 19, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newPayerNumber 
     */
	public void setPayerNumber(TreeMap newPayerNumber) {
		iPayerNumber = newPayerNumber;
	}
	/**
     * @param newPayerName
     * @author thirumalai
     */
    public void setPayerName(TreeMap newPayerName) {
		iPayerName = newPayerName;
	}

	/**
	 * Sets the selected bill to party 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedBillToParty String 
	 */
	public void setSelectedBillToParty(String newSelectedBillToParty) {
		iSelectedBillToParty = newSelectedBillToParty;
	}

	/**
	 * Sets selected payer for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedPayer String 
	 */
	public void setSelectedPayer(String newSelectedPayer) {
		iSelectedPayer = newSelectedPayer;
	}

	/**
	 * Sets sold to party for the customer 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSoldToParty CustomerInfoDataBean 
	 */
	public void setSoldToParty(CustomerInfoDataBean newSoldToParty) {
		iSoldToParty = newSoldToParty;
	}

	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(EditCustomerCustomDTO customDTO){
		if(null != customDTO){
			setSoldToParty(new CustomerInfoDataBean(customDTO.getSelectedCustomer()));
			
			ESWCustomerCustomDTO eswCustomer = customDTO.getSelectedBillToParty();
			if(null != eswCustomer){
				setSelectedBillToParty(eswCustomer.getSAPCustomerNumber());
			}
			
			eswCustomer = customDTO.getSelectedPayer();
			if(null != eswCustomer){
				setSelectedPayer(eswCustomer.getSAPCustomerNumber());
			}
			
			ProposalCustomerCustomDTO selectedCustomer = customDTO.getSelectedCustomer();
			if(null != selectedCustomer){
				setDefaultStartDate(selectedCustomer.getPlanStartDate());
				setDefaultEndDate(selectedCustomer.getPlanEndDate());
			}

			Map collection = customDTO.getBillToParty();
			if(null != collection){
				Iterator iterator = collection.values().iterator();
				while(iterator.hasNext()){
					addBillToParty(new CustomerInfoDataBean((ESWCustomerCustomDTO)iterator.next()));
				}
			}

			collection = customDTO.getPayer();
			if(null != collection){
				Iterator iterator = collection.values().iterator();
				while(iterator.hasNext()){
					addPayer(new CustomerInfoDataBean((ESWCustomerCustomDTO)iterator.next()));
				}
			}
			
			setSelectedPlanEndDate(customDTO.getEditPlanEndDate());
			setSelectedPlanStartDate(customDTO.getEditPlanStartDate());
		}
	}
	
	/**
     * addBillToParty
     *  
     * @param billToParty
     * @author thirumalai
     */
    public void addBillToParty(CustomerInfoDataBean billToParty){
		if(null != billToParty){
			if(null == iBillToPartyNumber){
				iBillToPartyNumber = new TreeMap(); 
			}
			if(null == iBillToPartyName){
				iBillToPartyName = new TreeMap(); 
			}
			iBillToPartyNumber.put(billToParty.getCustomerNumber(), billToParty.getLegacyCustomerNumberWithAS());
			iBillToPartyName.put(billToParty.getCustomerNumber(), billToParty.getCustomerName());
		}
	}
	/**
     * addPayer
     * 
     * @param payer
     * @author thirumalai
     */
    public void addPayer(CustomerInfoDataBean payer){
		if(null != payer){
			if(null == iPayerNumber){
				iPayerNumber = new TreeMap(); 
			}
			if(null == iPayerName){
				iPayerName = new TreeMap(); 
			}
			iPayerNumber.put(payer.getCustomerNumber(), payer.getLegacyCustomerNumberWithAS());
			iPayerName.put(payer.getCustomerNumber(), payer.getCustomerName());
		}
	}
	
	/**
     * EditCustomerViewBean
     * 
     * @author thirumalai
     */
    public EditCustomerViewBean(){
	}
	/**
     * EditCustomerViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public EditCustomerViewBean(EditCustomerCustomDTO customDTO){
		setData(customDTO);
	}
	
	/**
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public Date getSelectedPlanEndDate() {
		return iSelectedPlanEndDate;
	}

	/**
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public Date getSelectedPlanStartDate() {
		return iSelectedPlanStartDate;
	}

	/**
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedPlanEndDate
	 */
	public void setSelectedPlanEndDate(Date newSelectedPlanEndDate) {
		iSelectedPlanEndDate = newSelectedPlanEndDate;
	}

	/**
	 * Enter one sentence as a brief description for this method. 
	 * You can enter more text here. Please think of 
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedPlanStartDate
	 */
	public void setSelectedPlanStartDate(Date newSelectedPlanStartDate) {
		iSelectedPlanStartDate = newSelectedPlanStartDate;
	}
}