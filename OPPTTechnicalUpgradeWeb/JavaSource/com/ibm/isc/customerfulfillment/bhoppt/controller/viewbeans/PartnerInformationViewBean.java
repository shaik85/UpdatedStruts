/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.*;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.CustomerInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;

/**
 * Holds complete information about the partners of a proposal.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class PartnerInformationViewBean extends OPPTViewBean {
	private CustomerInfoDataBean iSoldToParty = null;
	private CustomerInfoDataBean iBillToParty = null;
	private CustomerInfoDataBean iPayer = null;
	private CustomerInfoDataBean iShipToParty = null;
	private String iNineDPartnerNumber = null;
	private String iNineDPartnerName = null;
	private String iComments = null;
	private List iCustomerLists = null;
	//DADO02&DADO09 Sateesh Anne BlueHarmony
	private List iselectedCustomers = null;
	private InventoryCustomDTO  inventoryCustomDTO= null; //Added by Ramesh
	
	
	/**
	 * Returns bill to party information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CustomerInfoDataBean
	 */
	public CustomerInfoDataBean getBillToParty() {
		return iBillToParty;
	}
	/**
     * @return
     * @author thirumalai
     */
    public String getBillToPartyNumber() {
		String number = null;
		if(null != iBillToParty){
			//DADO02&DADO09 BlueHarmony Sateesh Anne number = iBillToParty.getLegacyCustomerNumberWithAS();
			number = iBillToParty.getCustomerNumber();
			}
		return number;
	}
	/**
     * @return
     * @author thirumalai
     */
    public String getBillToPartyName() {
		String name = null;
		if(null != iBillToParty){
			name = iBillToParty.getCustomerName();
		}
		return name;
	}

	/**
	 * Returns comments 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
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
	 * Returns customer lists 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public List getCustomerLists() {
		return iCustomerLists;
	}

	/**
	 * Returns 9 digit partner name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getNineDPartnerName() {
		return iNineDPartnerName;
	}

	/**
	 * Returns 9 digit partner number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getNineDPartnerNumber() {
		return iNineDPartnerNumber;
	}

	/** 
	 * Returns payer information
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CustomerInfoDataBean
	 */
	public CustomerInfoDataBean getPayer() {
		return iPayer;
	}
	/**
     * getPayerNumber
     * 
     * @return
     * @author thirumalai
     */
    public String getPayerNumber() {
		String number = null;
		if(null != iPayer){
			//DADO02&DADO09 BlueHarmony Sateesh Anne number = iPayer.getLegacyCustomerNumberWithAS();
			number = iPayer.getCustomerNumber();
		}
		return number;
	}
	/**
     * getPayerName
     * 
     * @return
     * @author thirumalai
     */
    public String getPayerName() {
		String name = null;
		if(null != iPayer){
			name = iPayer.getCustomerName();
		}
		return name;
	}

	/**
	 * Returns ship to party information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CustomerInfoDataBean
	 */
	public CustomerInfoDataBean getShipToParty() {
		return iShipToParty;
	}
	/**
     * getShipToPartyNumber
     * 
     * @return
     * @author thirumalai
     */
    public String getShipToPartyNumber() {
		String number = null;
		if(null != iShipToParty){
			//DADO02&DADO09 BlueHarmony Sateesh Anne number = iShipToParty.getLegacyCustomerNumberWithAS();
			number = iShipToParty.getCustomerNumber();
		}
		return number;
	}
	/**
     * getShipToPartyName
     * 
     * @return
     * @author thirumalai
     */
    public String getShipToPartyName() {
		String name = null;
		if(null != iShipToParty){
			name = iShipToParty.getCustomerName();
		}
		return name;
	}

	/**
	 * Returns sold to party information
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
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
     * getSoldToPartyNumber
     * 
     * @return
     * @author thirumalai
     */
    public String getSoldToPartyNumber() {
		String number = null;
		if(null != iSoldToParty){
			//DADO02&DADO09 BlueHarmony Sateesh Anne number = iSoldToParty.getLegacyCustomerNumberWithAS();
			number = iSoldToParty.getCustomerNumber();
		}
		return number;
	}
	/**
     * getSoldToPartyName
     * 
     * @return
     * @author thirumalai
     */
    public String getSoldToPartyName() {
		String name = null;
		if(null != iSoldToParty){
			name = iSoldToParty.getCustomerName();
		}
		return name;
	}

	/**
	 * Sets bill to party information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillToParty CustomerInfoDataBean 
	 */
	public void setBillToParty(CustomerInfoDataBean newBillToParty) {
		iBillToParty = newBillToParty;
	}

	/**
	 * Sets comments 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
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
	 * Sets customer lists collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerLists TreeMap 
	 */
	public void setCustomerLists(List newCustomerLists) {
		iCustomerLists = newCustomerLists;
	}

	/**
	 * Sets 9 digit partner name 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNineDPartnerName String 
	 */
	public void setNineDPartnerName(String newNineDPartnerName) {
		iNineDPartnerName = newNineDPartnerName;
	}

	/**
	 * Sets 9 digit partner number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNineDPartnerNumber String 
	 */
	public void setNineDPartnerNumber(String newNineDPartnerNumber) {
		iNineDPartnerNumber = newNineDPartnerNumber;
	}

	/**
	 * Sets payer information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPayer CustomerInfoDataBean 
	 */
	public void setPayer(CustomerInfoDataBean newPayer) {
		iPayer = newPayer;
	}

	/**
	 * Sets ship to party information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newShipToParty CustomerInfoDataBean 
	 */
	public void setShipToParty(CustomerInfoDataBean newShipToParty) {
		iShipToParty = newShipToParty;
	}

	/**
	 * Sets sold to party information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
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
	 * Adds a new customer list to already existing collection of customer lists.  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerList CustomerListViewBean
	 */
	 public void addCustomerList(CustomerListViewBean customerList){
		if(null != customerList){
			if(null == iCustomerLists){
				iCustomerLists = new ArrayList();
			}
			iCustomerLists.add(customerList);
		}
	}
	
	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param soldToParty CustomerInfoDataBean
	 * @param billToParty CustomerInfoDataBean
	 * @param payer CustomerInfoDataBean
	 * @param shipToParty CustomerInfoDataBean
	 * @param nineDPartnerNumber String
	 * @param nineDPartnerName String
	 * @param comments String
	 * @param customerLists TreeMap
	 */
	public void setData(CustomerInfoDataBean soldToParty, CustomerInfoDataBean billToParty, 
						CustomerInfoDataBean payer, CustomerInfoDataBean shipToParty, 
						String nineDPartnerNumber, String nineDPartnerName, 
						String comments, List customerLists){
		setSoldToParty(soldToParty);
		setBillToParty(billToParty);
		setPayer(payer);
		setShipToParty(shipToParty);
		setNineDPartnerNumber(nineDPartnerNumber);
		setNineDPartnerName(nineDPartnerName);
		setComments(comments);
		setCustomerLists(customerLists);
	}
	
	/**
     * PartnerInformationViewBean
     * 
     * @author thirumalai
     */
    public PartnerInformationViewBean(){
		
	}
	
	/**
     * PartnerInformationViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public PartnerInformationViewBean(PartnerInformationCustomDTO customDTO){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			setSoldToParty(new CustomerInfoDataBean(customDTO.getSoldToParty()));
			setBillToParty(new CustomerInfoDataBean(customDTO.getBillToParty()));
			setPayer(new CustomerInfoDataBean(customDTO.getPayer()));
			setShipToParty(new CustomerInfoDataBean(customDTO.getShipToParty()));
			ESWCustomerCustomDTO nineDPartner = customDTO.getNineDPartner(); 
			if(null != nineDPartner){
				setNineDPartnerName(nineDPartner.getCustomerName());
				setNineDPartnerNumber(nineDPartner.getSAPCustomerNumber());
			}
			setComments(customDTO.getComments());
			


			setSelectedCustomers(customDTO.getSelectedCustomers()); //DADO02  Sateesh Anne BlueHarmony
			setInventoryCustomDTO(customDTO.getInventoryCustomDTO()); //Added by Ramesh
			
		}
	}
	
	/**
	 * @return Returns the selectedCustomers.
	 */
	public List getSelectedCustomers() {
		return iselectedCustomers;
	}
	/**
	 * @param selectedCustomers The selectedCustomers to set.
	 */
	public void setSelectedCustomers(List selectedCustomers) {
		iselectedCustomers = selectedCustomers;
	}
	/**
	 * @return Returns the inventoryCustomDTO.
	 */
	public InventoryCustomDTO getInventoryCustomDTO() {
		return inventoryCustomDTO;
	}
	/**
	 * @param inventoryCustomDTO The inventoryCustomDTO to set.
	 */
	public void setInventoryCustomDTO(InventoryCustomDTO inventoryCustomDTO) {
		this.inventoryCustomDTO = inventoryCustomDTO;
	}
}
