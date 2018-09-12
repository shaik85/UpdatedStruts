/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CustomerSelectionActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomersCustomDTO;

/**
 * Holds complete information about customer selection view. This class has collection of
 * selected customer lists (CustomerListViewBean's). CustomerListViewBean in turn has 
 * collection of customers, which inturn will be displayed to the user for selection.   
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
public class CustomerSelectionViewBean extends OPPTViewBean {
	private TreeMap iSelectedCustomerLists = null;
	private TreeMap iAlternateCustomers = null;
	private String iComments = null;
	private boolean iChangeProposal = false;

	private String legacyCustomerNumber = null;
	private String sequenceNumber = null;
	private String countryCode = null;
	private boolean alternatePartnerINV = false;
	private boolean alternatePartnerSTP = false;
	
	/**
	 * Returns collection of selected customer lists 
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
	public TreeMap getSelectedCustomerLists() {
		return iSelectedCustomerLists;
	}

	/**
	 * Sets collection of selected customer lists 
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
	 * @param newSelectedCustomerLists TreeMap 
	 */
	public void setSelectedCustomerLists(TreeMap newSelectedCustomerLists) {
		iSelectedCustomerLists = newSelectedCustomerLists;
	}
	
	/**
	 * Adds the customer list to the already existing collection of selected customer lists. 
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
	 * @param customerList CustomerListViewBean
	 */
	public void addCustomerList(CustomerListViewBean customerList){
		if(customerList != null){
			if(iSelectedCustomerLists == null){
				iSelectedCustomerLists = new TreeMap();
			}
			iSelectedCustomerLists.put(customerList.getCustomerNumber(), customerList); //DADO02
		}
	}
	
	/**
	 * Sets complete data in a single method call.  
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
	 * @param selectedCustomerLists
	 */
	public void setData(TreeMap selectedCustomerLists){
		setSelectedCustomerLists(selectedCustomerLists);
	}
	
	/**
     * CustomerSelectionViewBean
     * 
     * @author thirumalai
     */
    public CustomerSelectionViewBean(){
	}

	/**
     * CustomerSelectionViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public CustomerSelectionViewBean(FetchCustomersCustomDTO customDTO){
		setData(customDTO);
	}
	/**
     * CustomerSelectionViewBean
     * 
     * @param customDTO
     * @param changeProposal
     * @author thirumalai
     */
    public CustomerSelectionViewBean(FetchCustomersCustomDTO customDTO, boolean changeProposal){
		setChangeProposal(changeProposal);
		setData(customDTO);
	}
	/**
     * CustomerSelectionViewBean
     * 
     * @param customDTO
     * @param comments
     * @param changeProposal
     * @author thirumalai
     */
    public CustomerSelectionViewBean(FetchCustomersCustomDTO customDTO, String comments, boolean changeProposal){
		setChangeProposal(changeProposal);
		setComments(comments);
		setData(customDTO);
	}

	/**
     * setData
     * 
     * @param customDTO
     * @author thirumalai
     */
    public void setData(FetchCustomersCustomDTO customDTO){
		if(null != customDTO){
			TreeMap customerLists = customDTO.getSelectedCustomers();
			if(null != customerLists){
				Iterator iterator = customerLists.values().iterator();
				while(iterator.hasNext()){
					addCustomerList(new CustomerListViewBean((CustomerListCustomDTO)iterator.next()));
				}
			}
			
			if(isChangeProposal()){
				TreeMap alternateCustomers = customDTO.getAlternatePartners();
				if(null != alternateCustomers){
					Iterator iterator = alternateCustomers.values().iterator();
					while(iterator.hasNext()){
						addAlternateCustomer(new CustomerListCustomerViewBean((CustomerListCustomerCustomDTO)iterator.next()));
					}
				}
			}
		}
	}
	
	/**
	 * Returns true if the view is for change proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isChangeProposal() {
		return iChangeProposal;
	}

	/**
	 * Sets change proposal view flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newChangeProposal boolean
	 */
	public void setChangeProposal(boolean newChangeProposal) {
		iChangeProposal = newChangeProposal;
	}

	/**
	 * Returns alternate customers collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap 
	 */
	public TreeMap getAlternateCustomers() {
		return iAlternateCustomers;
	}

	/**
	 * Sets alternate customers collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newAlternateCustomers TreeMap
	 */
	public void setAlternateCustomers(TreeMap newAlternateCustomers) {
		iAlternateCustomers = newAlternateCustomers;
	}
	
	/**
	 * Adds new alternate partner to the collection of existing alternate customers  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param alternateCustomer CustomerListCustomerCustomDTO
	 */
	public void addAlternateCustomer(CustomerListCustomerViewBean alternateCustomer){
		if(null != alternateCustomer){
			if(null == iAlternateCustomers){
				iAlternateCustomers = new TreeMap();
			}
			iAlternateCustomers.put(alternateCustomer.getCustomerNumber(), alternateCustomer);
		}
	}

	/**
	 * Returns comments 
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
	public String getComments() {
		return iComments;
	}

	/**
	 * Sets comments 
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
	 * @param newComments String 
	 */
	public void setComments(String newComments) {
		iComments = newComments;
	}
	
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param newActionForm 
	 * 
	 */
	//DADO02
	public void setActionForm(OPPTActionForm newActionForm) {
		super.setActionForm(newActionForm);
		CustomerSelectionActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof CustomerSelectionActionForm){
			actionForm = (CustomerSelectionActionForm)getActionForm();
			
			setComments(actionForm.getComments());
			String selectedSTP = actionForm.getSelectedSTP();
			
			if(null != selectedSTP){
				/*
				StringTokenizer st = new StringTokenizer(selectedSTP, Constants.STRING_SEPERATOR);
				if(2 == st.countTokens()){
					String customerList = st.nextToken();
					String customer = st.nextToken();
					if("alternate".equalsIgnoreCase(customerList)){  //$NON-NLS-1$
						if(null != getAlternateCustomers()){
							((CustomerListCustomerViewBean)getAlternateCustomers().get(customer)).setSelectedSTP(true);
						}
					}
					else{
						if(null != getSelectedCustomerLists()){
							CustomerListViewBean customerListView = (CustomerListViewBean)getSelectedCustomerLists().get(customerList);
							if(null != customerListView){
								TreeMap customers = customerListView.getCustomers();
							
								if(null != customers){
								
									((CustomerListCustomerViewBean)customers.get(customer)).setSelectedSTP(true);
								}
							}
						}
					}
				}
				else{
					setAlternatePartnerSTP(true);
				}*/
				
				//DADO02 
				((CustomerListViewBean)getSelectedCustomerLists().get(selectedSTP)).setSelectedSTP(true);
				
				
			}
			
			String selectedINV[] = actionForm.getSelectedINV();
			if(null != selectedINV){
				
				TreeMap newCustomers = new TreeMap();
				Iterator customers = getSelectedCustomerLists().entrySet().iterator();
				while(customers.hasNext()){
					Map.Entry entry = (Map.Entry) customers.next();
					CustomerListViewBean customerListViewBean1 =  (CustomerListViewBean)entry.getValue(); 
					customerListViewBean1.setInvSelected(false);
					newCustomers.put(customerListViewBean1.getCustomerNumber(),customerListViewBean1);
					
					}
			
				setSelectedCustomerLists(newCustomers);
				
				for(int i=0, size = selectedINV.length; i<size; i++){
					
					String customerList = selectedINV[i];
					String customer = selectedINV[i];
					if("alternate".equalsIgnoreCase(customerList)){  //$NON-NLS-1$
							if(null != getAlternateCustomers()){
								((CustomerListCustomerViewBean)getAlternateCustomers().get(customer)).setUserINVSelection(true);
							}
						}
						else{
							if(null != getSelectedCustomerLists()&& getSelectedCustomerLists().size()>0&&customer!=null){
								
								CustomerListViewBean customerListViewBean =	(CustomerListViewBean)getSelectedCustomerLists().get(customer);	
                                customerListViewBean.setInvSelected(true);
							
								
							}
							
						}
					
				}
			}

			setLegacyCustomerNumber(actionForm.getLegacyCustomerNumber());
			setSequenceNumber(actionForm.getSequenceNumber());
			setCountryCode(actionForm.getCountryCode());
			setAlternatePartnerINV(actionForm.getAlternatePartnerINV() != null);
		}
	}
	
	/**
     * Returns alternate partner inv is selected
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Mar 19, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return boolean
     */
	public boolean isAlternatePartnerINV() {
		return alternatePartnerINV;
	}

	/**
     * Returns alternate partner STP is selected
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Mar 19, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return boolean
     */
	public boolean isAlternatePartnerSTP() {
		return alternatePartnerSTP;
	}

	/**
	 * Returns alternate partner legacy customer number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getLegacyCustomerNumber() {
		return legacyCustomerNumber;
	}

	/**
	 * Sets alternate partner sequence number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSequenceNumber() {
		return sequenceNumber;
	}

	/**
     * Sets alternate partner inv is selected
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Mar 19, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param newAlternatePartnerINV 
     */
	public void setAlternatePartnerINV(boolean newAlternatePartnerINV) {
		alternatePartnerINV = newAlternatePartnerINV;
	}

	/**
     * Sets alternate partner STP is selected
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Mar 19, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param newAlternatePartnerSTP 
     */
	public void setAlternatePartnerSTP(boolean newAlternatePartnerSTP) {
		alternatePartnerSTP = newAlternatePartnerSTP;
	}

	/**
	 * Sets alternate partner legacy customer number value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLegacyCustomerNumber String 
	 */
	public void setLegacyCustomerNumber(String newLegacyCustomerNumber) {
		legacyCustomerNumber = newLegacyCustomerNumber;
	}

	/**
	 * Sets alternate partners sequence number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 19, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSequenceNumber String 
	 */
	public void setSequenceNumber(String newSequenceNumber) {
		sequenceNumber = newSequenceNumber;
	}
	
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean#clearAll() 
	 *  
	 * 
	 */
	public void clearAll() {
		//Changed according to DADO02
		if(null != iSelectedCustomerLists){
			Iterator customerListIterator = iSelectedCustomerLists.values().iterator();
			while(customerListIterator.hasNext()){
				CustomerListViewBean customerList = (CustomerListViewBean)customerListIterator.next();
						if(null != customerList){
						customerList.setUserINVSelection(false);
							}
						}
					}
		}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean#selectAll() 
	 *  
	 * 
	 */
	public void selectAll() {
                 //		Changed according to DADO02
		if(null != iSelectedCustomerLists){
			Iterator customerListIterator = iSelectedCustomerLists.values().iterator();
			while(customerListIterator.hasNext()){
				CustomerListViewBean customerList = (CustomerListViewBean)customerListIterator.next();//
				
				if(null != customerList){
					customerList.setUserINVSelection(true);
							}
						}
					}
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
	 * date Jun 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getCountryCode() {
		return countryCode;
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
	 * date Jun 17, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setCountryCode(String string) {
		countryCode = string;
	}

}