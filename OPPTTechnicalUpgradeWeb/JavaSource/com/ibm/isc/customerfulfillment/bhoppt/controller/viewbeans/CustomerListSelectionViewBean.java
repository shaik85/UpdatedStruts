/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.Iterator;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.CustomerListSelectionActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchCustomerListCustomDTO;

/**
 * Holds complete information about customer list selection view.  
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
public class CustomerListSelectionViewBean extends OPPTViewBean{
	private String iCustomerListNumber = null;
	private String iCustomerListName = null;
	private String iZipCode = null;
	private String iCity = null;
	private String iComments = null;
	private TreeMap iCustomerLists = null;
	
	private String searchString = null;
	private int totalNumberOfPages = 0;
	private int currentPage = 0;
	private TreeMap [] customerListArray = null;
	
	private boolean iChangeProposal = false;
	
	//DADO02
	private String isiteID = null;
	private String isiteName = null;
	private TreeMap isiteIDLists = null; 

	/** 
	 * Returns the city
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
	public String getCity() {
		return iCity;
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
	 * Returns customer list name
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
	public String getCustomerListName() {
		return iCustomerListName;
	}

	/**
	 * Returns customer list number 
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
	public String getCustomerListNumber() {
		return iCustomerListNumber;
	}

	/**
	 * Returns zip code 
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
	public String getZipCode() {
		return iZipCode;
	}

	/**
	 * Sets city 
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
	 * @param newCity String 
	 */
	public void setCity(String newCity) {
		iCity = newCity;
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
	 * Sets customer list name 
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
	 * @param newCustomerListName String 
	 */
	public void setCustomerListName(String newCustomerListName) {
		iCustomerListName = newCustomerListName;
	}

	/**
	 * Sets customer list number 
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
	 * @param newCustomerListNumber String 
	 */
	public void setCustomerListNumber(String newCustomerListNumber) {
		iCustomerListNumber = newCustomerListNumber;
	}

	/**
	 * Sets zip code 
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
	 * @param newZipCode String 
	 */
	public void setZipCode(String newZipCode) {
		iZipCode = newZipCode;
	}

	/**
	 * Returns collection of customer lists 
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
	public TreeMap getCustomerLists() {
		return iCustomerLists;
	}

	/**
	 * Sets the customer lists collection 
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
	 * @param newCustomerLists TreeMap 
	 */
	public void setCustomerLists(TreeMap newCustomerLists) {
		iCustomerLists = newCustomerLists;
	}

	/**
	 * Adds new customer list to the already existing collection of customer lists. If none 
	 * exist it creates a new collection adds this.  
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
			if(iCustomerLists == null){
				iCustomerLists = new TreeMap();
			}
			iCustomerLists.put(customerList.getListNumber(), customerList);
		}
	}
	
	//DADO02
	public void addSiteIDList(CustomerListViewBean siteIDList){
		
			if(siteIDList != null){
			if(isiteIDLists == null){
				isiteIDLists = new TreeMap();
			}
			isiteIDLists.put(siteIDList.getCustomerNumber(),siteIDList);
			}
	} 
	
	
	
	public CustomerListSelectionViewBean(){
	}
	
	public CustomerListSelectionViewBean(FetchCustomerListCustomDTO customDTO){
		setData(customDTO);
	}

	public CustomerListSelectionViewBean(FetchCustomerListCustomDTO customDTO, boolean changeProposal){
		setData(customDTO);
		setChangeProposal(changeProposal);
	}

	public void setData(FetchCustomerListCustomDTO customDTO){
		if(null != customDTO){
			setCustomerListNumber(customDTO.getCustomerListNumber());
			setCustomerListName(customDTO.getCustomerListName());
			setZipCode(customDTO.getZipCode());
			setCity(customDTO.getCity());
			setComments(customDTO.getComments());
			setButtonFlags(customDTO.getButtonFlags());
			
			setSiteID(customDTO.getSiteID());
			setSiteName(customDTO.getSiteName());
			
			
			
			/*DADO02 Sateesh BlueHarmony TreeMap customerLists = customDTO.getCustomerLists();
			if(null != customerLists){
				Iterator iterator = customerLists.values().iterator();
				while(iterator.hasNext()){
					addCustomerList(new CustomerListViewBean((CustomerListCustomDTO)iterator.next()));
				}
			}*/
			
			//DADO02
			
			TreeMap siteIDLists = customDTO.getSiteIDLists();
						if(null!=siteIDLists){
				Iterator iterator = siteIDLists.values().iterator();
				while(iterator.hasNext()){    
					addSiteIDList(new CustomerListViewBean((CustomerListCustomDTO)iterator.next()));					
				} 
			}
			
			
		}
	}
	
	/**
	 * Returns true if the request is for change proposal 
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
	 * Sets change proposal flag value 
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

	
	public CustomerListSelectionActionForm getCustomerListSelectionActionForm(){
		CustomerListSelectionActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof CustomerListSelectionActionForm){
			actionForm = (CustomerListSelectionActionForm)getActionForm();
		}
		else{
			actionForm = new CustomerListSelectionActionForm();
		}
		return actionForm;
	}

	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean#setActionForm(com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTActionForm) 
	 * @param newActionForm 
	 * 
	 */
	public void setActionForm(OPPTActionForm newActionForm) {
		super.setActionForm(newActionForm);
		
		CustomerListSelectionActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof CustomerListSelectionActionForm){
			actionForm = (CustomerListSelectionActionForm)getActionForm();
			
			if(null != isiteIDLists){
				String selectedCustomers[] = actionForm.getSelectedCustomers();
				if(null != selectedCustomers && 0 < selectedCustomers.length){
					for(int i=0, length = selectedCustomers.length; i<length; i++){
						((CustomerListViewBean)isiteIDLists.get(selectedCustomers[i])).setSelected(true);
					}
				}
				
				selectedCustomers = actionForm.getDeleteCustomers();
				if(null != selectedCustomers && 0 < selectedCustomers.length){
					for(int i=0, length = selectedCustomers.length; i<length; i++){
						((CustomerListViewBean)isiteIDLists.get(selectedCustomers[i])).setDeleteSelected(true);
					}
				}
			}
			setComments(actionForm.getComments());
		}
	}
	
	/** 
	 * Overridden method - Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Mar 24, 2004 
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
		if(null != isiteIDLists){
			Iterator customerListIterator = isiteIDLists.values().iterator();
			while(customerListIterator.hasNext()){
				((CustomerListViewBean)customerListIterator.next()).setSelected(true);
			}
		}
	}

	public void clearAll() {
		if(null != isiteIDLists){
			Iterator customerListIterator = isiteIDLists.values().iterator();
			while(customerListIterator.hasNext()){
				((CustomerListViewBean)customerListIterator.next()).setSelected(false);
			}
		}
	}
	/**
	 * @return Returns the currentPage.
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * @param currentPage The currentPage to set.
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * @return Returns the customerListArray.
	 */
	public TreeMap[] getCustomerListArray() {
		return customerListArray;
	}
	/**
	 * @param customerListArray The customerListArray to set.
	 */
	public void setCustomerListArray(TreeMap[] customerListArray) {
		this.customerListArray = customerListArray;
	}
	/**
	 * @return Returns the searchString.
	 */
	public String getSearchString() {
		return searchString;
	}
	/**
	 * @param searchString The searchString to set.
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	/**
	 * @return Returns the totalNumberOfPages.
	 */
	public int getTotalNumberOfPages() {
		return totalNumberOfPages;
	}
	/**
	 * @param totalNumberOfPages The totalNumberOfPages to set.
	 */
	public void setTotalNumberOfPages(int totalNumberOfPages) {
		this.totalNumberOfPages = totalNumberOfPages;
	}
	/**
	 * @return Returns the iCustomerLists.
	 */
	public TreeMap getICustomerLists() {
		return iCustomerLists;
	}
	/**
	 * @param customerLists The iCustomerLists to set.
	 */
	public void setICustomerLists(TreeMap customerLists) {
		iCustomerLists = customerLists;
	}
	/**
	 * @return Returns the iZipCode.
	 */
	public String getIZipCode() {
		return iZipCode;
	}
	/**
	 * @param zipCode The iZipCode to set.
	 */
	public void setIZipCode(String zipCode) {
		iZipCode = zipCode;
	}
	
	
	
	/**
	 * @return Returns the siteID.
	 */
	public String getSiteID() {
		return isiteID;
	}
	/**
	 * @param siteID The siteID to set.
	 */
	public void setSiteID(String newsiteID) {
		isiteID = newsiteID;
	}
	/**
	 * @return Returns the siteIDLists.
	 */
	public TreeMap getSiteIDLists() {
		return isiteIDLists;
	}
	/**
	 * @param siteIDLists The siteIDLists to set.
	 */
	public void setSiteIDLists(TreeMap newsiteIDLists) {
		isiteIDLists = newsiteIDLists;
	}
	/**
	 * @return Returns the siteName.
	 */
	public String getSiteName() {
		return isiteName;
	}
	/**
	 * @param siteName The siteName to set.
	 */
	public void setSiteName(String newsiteName) {
		isiteName = newsiteName;
	}
}