/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Custom dto that holds data required fro fetch inventory. 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 18, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class InventoryCustomDTO extends ProposalCustomDTO {
	/**
     * customer
     *
     */
    public List customers = null;
	
	/**
     * fetch_inventory
     *
     */
    public static final String FETCH_INVENTORY = "N";  /* NOI18N */
	/**
     * static variable
     *
     */
    public static final String REFETCH_INVENTORY = "Y";  /* NOI18N */
	
	private String fetchType = FETCH_INVENTORY;
	
	private Map designatedMachineID;
	private Map materialID;
	private Map serialNumber;
	private List customersList;
	private boolean selectedInventory=false;
	//Added by Ramesh
	private List errDesignatedMachineID;
	private List errMaterialID;
	private List errSerialNumber;
	private String errCustomersList;
	private List errListData;
	private boolean errSelectedInventory=false;
	private boolean continuErrSelectInv=false;
	private String Search_type;
	private boolean refetch=false;
	public boolean changeProposal = false;

	/**
	 * Returns fetch type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getFetchType() {
		return fetchType;
	}

	/**
	 * Sets fetch type 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newFetchType 
	 */
	public void setFetchType(String newFetchType) {
		fetchType = newFetchType;
	}
	
	/**
	 * Returns customers collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getCustomers() {
		return customers;
	}

	/**
	 * Sets customers collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomers 
	 */
	public void setCustomers(List newCustomers) {
		customers = newCustomers;
	}
	

	/**
	 * add Customers
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTO
	 */
	
	public void addCustomers(CustomerListCustomerCustomDTO customDTO){
		if(null != customDTO){
			if(null == customers){
				customers = new ArrayList(); 
			}
			customers.add(customDTO);
		}
	}
	
	/**
	 * @return Returns the designatedMachineID.
	 */
	public Map getDesignatedMachineID() {
		return designatedMachineID;
	}
	/**
	 * @param designatedMachineID The designatedMachineID to set.
	 */
	public void setDesignatedMachineID(Map designatedMachineID) {
		this.designatedMachineID = designatedMachineID;
	}
	/**
	 * @return Returns the materialID.
	 */
	public Map getMaterialID() {
		return materialID;
	}
	/**
	 * @param materialID The materialID to set.
	 */
	public void setMaterialID(Map materialID) {
		this.materialID = materialID;
	}
	/**
	 * @return Returns the customersList.
	 * Added by SJD.. for Integrating code
	 */
	public List getCustomersList() {
		return customersList;
	}
	/**
	 * @param customersList The customersList to set.
	 */
	public void setCustomersList(List customersList) {
		this.customersList = customersList;
	}
	/**
	 * @return Returns the serialNumber.
	 */
	public Map getSerialNumber() {
		return serialNumber;
	}
	/**
	 * @param serialNumber The serialNumber to set.
	 */
	public void setSerialNumber(Map serialNumber) {
		this.serialNumber = serialNumber;
	}
	/**
	 * @return Returns the selectedInventory.
	 */
	public boolean isSelectedInventory() {
		return selectedInventory;
	}
	/**
	 * @param selectedInventory The selectedInventory to set.
	 */
	public void setSelectedInventory(boolean selectedInventory) {
		this.selectedInventory = selectedInventory;
	}
	/**
	 * @return Returns the errCustomersList.
	 */
	public String getErrCustomersList() {
		return errCustomersList;
	}
	/**
	 * @param errCustomersList The errCustomersList to set.
	 */
	public void setErrCustomersList(String errCustomersList) {
		this.errCustomersList = errCustomersList;
	}
	/**
	 * @return Returns the errDesignatedMachineID.
	 */
	public List getErrDesignatedMachineID() {
		return errDesignatedMachineID;
	}
	/**
	 * @param errDesignatedMachineID The errDesignatedMachineID to set.
	 */
	public void setErrDesignatedMachineID(List errDesignatedMachineID) {
		this.errDesignatedMachineID = errDesignatedMachineID;
	}
	/**
	 * @return Returns the errMaterialID.
	 */
	public List getErrMaterialID() {
		return errMaterialID;
	}
	/**
	 * @param errMaterialID The errMaterialID to set.
	 */
	public void setErrMaterialID(List errMaterialID) {
		this.errMaterialID = errMaterialID;
	}
	/**
	 * @return Returns the errSerialNumber.
	 */
	public List getErrSerialNumber() {
		return errSerialNumber;
	}
	/**
	 * @param errSerialNumber The errSerialNumber to set.
	 */
	public void setErrSerialNumber(List errSerialNumber) {
		this.errSerialNumber = errSerialNumber;
	}
	/**
	 * @return Returns the errSelectedInventory.
	 */
	public boolean isErrSelectedInventory() {
		return errSelectedInventory;
	}
	/**
	 * @param errSelectedInventory The errSelectedInventory to set.
	 */
	public void setErrSelectedInventory(boolean errSelectedInventory) {
		this.errSelectedInventory = errSelectedInventory;
	}
	
	/**
	 * @return Returns the errListData.
	 */
	public List getErrListData() {
		return errListData;
	}
	/**
	 * @param errMaterialID The errListData to set.
	 */
	public void setErrListData(List errListData) {
		this.errListData = errListData;
	}
	/**
	 * @return Returns the continuErrSelectInv.
	 */
	public boolean isContinuErrSelectInv() {
		return continuErrSelectInv;
	}
	/**
	 * @param continuErrSelectInv The continuErrSelectInv to set.
	 */
	public void setContinuErrSelectInv(boolean continuErrSelectInv) {
		this.continuErrSelectInv = continuErrSelectInv;
	}
	/**
	 * @return Returns the search_type.
	 */
	public String getSearch_type() {
		return Search_type;
	}
	/**
	 * @param search_type The search_type to set.
	 */
	public void setSearch_type(String search_type) {
		Search_type = search_type;
	}
	/**
	 * @return Returns the refetch.
	 */
	public boolean isRefetch() {
		return refetch;
	}
	/**
	 * @param refetch The refetch to set.
	 */
	public void setRefetch(boolean refetch) {
		this.refetch = refetch;
	}
	/**
	 * @return Returns the changeProposal.
	 */
	public boolean isChangeProposal() {
		return changeProposal;
	}
	/**
	 * @param changeProposal The changeProposal to set.
	 */
	public void setChangeProposal(boolean changeProposal) {
		this.changeProposal = changeProposal;
	}
}