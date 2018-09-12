/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * Custom dto that holds information about partners of a proposal 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 8, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class PartnerInformationCustomDTO extends OPPTCustomDTO {
	private ESWCustomerCustomDTO soldToParty = null;
	private ESWCustomerCustomDTO billToParty = null;
	private ESWCustomerCustomDTO shipToParty = null;
	private ESWCustomerCustomDTO payer = null;
	private ESWCustomerCustomDTO nineDPartner = null;

	private TreeMap customerLists = null;
	private String comments = null;
	//DADO02&DADO09 BlueHarmony Sateesh Anne 
	private String slectedCustomerName = null;
	private String selectedCustomerNumber = null;
	private List selectedCustomers = null;
	//Added by Ramesh
	private InventoryCustomDTO inventoryCustomDTO = null;

	/**
	 * Returns bill to party details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getBillToParty() {
		return billToParty;
	}

	/**
	 * Returns 9D partner information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ESWCustomerCustomDTO 
	 */
	public ESWCustomerCustomDTO getNineDPartner() {
		return nineDPartner;
	}

	/**
	 * Returns payer information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getPayer() {
		return payer;
	}

	/**
	 * Returns ship to party information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getShipToParty() {
		return shipToParty;
	}

	/**
	 * Returns sold to party information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ESWCustomerCustomDTO
	 */
	public ESWCustomerCustomDTO getSoldToParty() {
		return soldToParty;
	}

	/**
	 * Sets bill to party information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillToParty ESWCustomerCustomDTO
	 */
	public void setBillToParty(ESWCustomerCustomDTO newBillToParty) {
		billToParty = newBillToParty;
	}

	/**
	 * Sets 9D partner information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNineDPartner ESWCustomerCustomDTO 
	 */
	public void setNineDPartner(ESWCustomerCustomDTO newNineDPartner) {
		nineDPartner = newNineDPartner;
	}

	/**
	 * Sets payer information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPayer ESWCustomerCustomDTO 
	 */
	public void setPayer(ESWCustomerCustomDTO newPayer) {
		payer = newPayer;
	}

	/**
	 * Sets ship to party information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newShipToParty ESWCustomerCustomDTO 
	 */
	public void setShipToParty(ESWCustomerCustomDTO newShipToParty) {
		shipToParty = newShipToParty;
	}

	/**
	 * Sets sold to party information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSoldToParty ESWCustomerCustomDTO 
	 */
	public void setSoldToParty(ESWCustomerCustomDTO newSoldToParty) {
		soldToParty = newSoldToParty;
	}

	/**
	 * Sets complete data in a single method call  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param asoldToParty ESWCustomerCustomDTO
	 * @param abillToParty ESWCustomerCustomDTO
	 * @param ashipToParty ESWCustomerCustomDTO
	 * @param apayer ESWCustomerCustomDTO
	 * @param anineDPartner ESWCustomerCustomDTO
	 * @param acustomerLists TreeMap
	 * @param acomments String
	 */
	public void setData(
		ESWCustomerCustomDTO asoldToParty,
		ESWCustomerCustomDTO abillToParty,
		ESWCustomerCustomDTO ashipToParty,
		ESWCustomerCustomDTO apayer,
		ESWCustomerCustomDTO anineDPartner,
		TreeMap acustomerLists,
		String acomments) {
		setSoldToParty(asoldToParty);
		setBillToParty(abillToParty);
		setShipToParty(ashipToParty);
		setPayer(apayer);
		setNineDPartner(anineDPartner);
		setCustomerLists(acustomerLists);
		setComments(acomments);
	}

	/**
	 * Returns comments value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Returns customer lists collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getCustomerLists() {
		return customerLists;
	}

	/**
	 * Sets comments value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newComments String 
	 */
	public void setComments(String newComments) {
		comments = newComments;
	}

	/**
	 * Sets customer lists collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomerLists TreeMap 
	 */
	public void setCustomerLists(TreeMap newCustomerLists) {
		customerLists = newCustomerLists;
	}

	/**
     * Adds new customer list to the collection of available customer lists
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 2, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @param acustomerList 
     */
	public void addCustomerList(CustomerListCustomDTO acustomerList) {
		if (null != acustomerList) {
			if (null == customerLists) {
				customerLists = new TreeMap();
			}
			customerLists.put(acustomerList.getListNumber(), acustomerList);
		}
	}

	/**
     * to String
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 2, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return String
     */
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("\nSold to party: " + soldToParty);  /* NOI18N */
		buffer.append("\nBill to party: " + billToParty);  /* NOI18N */
		buffer.append("\nPayer: " + payer);  /* NOI18N */
		buffer.append("\nShip to party: " + shipToParty);  /* NOI18N */
		buffer.append("\nNine D Partner: " + nineDPartner);  /* NOI18N */
		buffer.append("\nComments: " + comments);  /* NOI18N */

		if (null != customerLists) {
			buffer.append("\nCustomer lists: Null...");  /* NOI18N */
			Iterator iterator = customerLists.values().iterator();
			while (iterator.hasNext()) {
				buffer.append((CustomerListCustomDTO) iterator.next());
			}
		} else {
			buffer.append("\nCustomer lists: Null...");  /* NOI18N */
		}

		return buffer.toString();
	}

	/**
	 * finalize
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 2, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 */
	
/*	protected void finalize() {
		
		soldToParty = null;
		billToParty = null;
		shipToParty = null;
		payer = null;
		nineDPartner = null;
		comments = null;

		if(null != customerLists) {
			customerLists.clear();
			customerLists = null;
		}
		
	}*/
	/**
	 * @return Returns the selectedCustomerNumber.
	 */
	public String getSelectedCustomerNumber() {
		return selectedCustomerNumber;
	}
	/**
	 * @param selectedCustomerNumber The selectedCustomerNumber to set.
	 */
	public void setSelectedCustomerNumber(String selectedCustomerNumber) {
		this.selectedCustomerNumber = selectedCustomerNumber;
	}
	/**
	 * @return Returns the slectedCustomerName.
	 */
	public String getSlectedCustomerName() {
		return slectedCustomerName;
	}
	/**
	 * @param slectedCustomerName The slectedCustomerName to set.
	 */
	public void setSlectedCustomerName(String slectedCustomerName) {
		this.slectedCustomerName = slectedCustomerName;
	}
	/**
	 * @return Returns the selectedCustomers.
	 */
	public List getSelectedCustomers() {
		return selectedCustomers;
	}
	/**
	 * @param selectedCustomers The selectedCustomers to set.
	 */
	public void setSelectedCustomers(List selectedCustomers) {
		this.selectedCustomers = selectedCustomers;
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
