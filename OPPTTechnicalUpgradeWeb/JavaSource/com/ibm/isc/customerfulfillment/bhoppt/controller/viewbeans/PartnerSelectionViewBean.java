/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.PartnerSelectionActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.controller.commons.CustomerInfoDataBean;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CustomerListCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ESWCustomerCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.FetchPartnerInformationCustomDTO;

/**
 * Holds complete date about partner selection view  
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
public class PartnerSelectionViewBean extends OPPTViewBean {
	private String iComments = null;
	private TreeMap iCustomerLists = null;

	private TreeMap iSoldToPartyNumber = null;
	private TreeMap iBillToPartyNumber = null;
	private TreeMap iPayerNumber = null;
	private TreeMap iShipToPartyNumber = null;
	private TreeMap iSoldToPartyName = null;
	private TreeMap iBillToPartyName = null;
	private TreeMap iPayerName = null;
	private TreeMap iShipToPartyName = null;
	
	private String iSelectedSoldToParty = null;
	private String iSelectedBillToParty = null;
	private String iSelectedBillToPartyASNumber = null;
	private String iSelectedBillToPartyName = null;
	private String iSelectedPayer = null;
	private String iSelectedPayerASNumber = null;
	private String iSelectedPayerName = null;
	private String iSelectedShipToParty = null;
	private String iSelectedNineDPartner = null;
	private String iSelectedNineDPartnerName = null;
	
	private boolean iIGFFlag = false;
	private boolean iBillToPartyEditable = false;
	private boolean iSoldToPartyEditable = true; 
	
	//DADO02&DADO09 Added to display in partnerselection page
	private List iselectedCustomers = null;
	
	/**
	 * Adds new bill to party to collection of bill to parties available  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param billToParty CustomerInfoDataBean
	 */
	public void addBillToParty(CustomerInfoDataBean billToParty){
		if(null != billToParty){
			if(null == iBillToPartyNumber){
				iBillToPartyNumber = new TreeMap();
				iBillToPartyNumber.put("Other", "Other");  //$NON-NLS-1$  //$NON-NLS-2$
			}
			if(null == iBillToPartyName){
				iBillToPartyName = new TreeMap();
				iBillToPartyName.put("Other", "Other");  //$NON-NLS-1$  //$NON-NLS-2$
			}
			//DADO02&DADO09 iBillToPartyNumber.put(billToParty.getCustomerNumber(), billToParty.getLegacyCustomerNumberWithAS());
			iBillToPartyNumber.put(billToParty.getCustomerNumber(), billToParty.getCustomerNumber()); //DADO02&DADO09
			iBillToPartyName.put(billToParty.getCustomerNumber(), billToParty.getCustomerName());
		}
	}
	/**
	 * Adds customer list to the collection of already existing customer lists  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerList CustomerListViewBean
	 */
	public void addCustomers(CustomerListViewBean customers){
		if(null != customers){
			if(null == iselectedCustomers){
				iselectedCustomers = new ArrayList(); 
			}
			iselectedCustomers.add(customers);
		}
	}
	/**
	 * Adds bew payer to the collection of payers available  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param payer CustomerInfoDataBean
	 */
	public void addPayer(CustomerInfoDataBean payer){
		if(null != payer){
			if(null == iPayerNumber){
				iPayerNumber = new TreeMap(); 
				iPayerNumber.put("Other", "Other");  //$NON-NLS-1$  //$NON-NLS-2$
			}
			if(null == iPayerName){
				iPayerName = new TreeMap(); 
				iPayerName.put("Other", "Other");  //$NON-NLS-1$  //$NON-NLS-2$
			}
			//DADO02&DADO09 iPayerNumber.put(payer.getCustomerNumber(), payer.getLegacyCustomerNumberWithAS());
			iPayerNumber.put(payer.getCustomerNumber(), payer.getCustomerNumber()); //DADO02&DADO09
			iPayerName.put(payer.getCustomerNumber(), payer.getCustomerName());
		}
	}
	/**
	 * Adds new ship to party to the collection of ship to parties available  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param shipToParty CustomerInfoDataBean
	 */
	public void addShipToParty(CustomerInfoDataBean shipToParty){
		if(null != shipToParty){
			if(null == iShipToPartyNumber){
				iShipToPartyNumber = new TreeMap(); 
				iShipToPartyNumber.put("Other", "Other");  //$NON-NLS-1$  //$NON-NLS-2$
			}
			if(null == iShipToPartyName){
				iShipToPartyName = new TreeMap(); 
				iShipToPartyName.put("Other", "Other");  //$NON-NLS-1$  //$NON-NLS-2$
			}
			//DADO02&DADO09 iShipToPartyNumber.put(shipToParty.getCustomerNumber(), shipToParty.getLegacyCustomerNumberWithAS());
			iShipToPartyNumber.put(shipToParty.getCustomerNumber(), shipToParty.getCustomerNumber()); //DADO02&DADO09 
			iShipToPartyName.put(shipToParty.getCustomerNumber(), shipToParty.getCustomerName());
		}
	}
	/**
	 * Adds new sold to party to the collection of sold to parties available  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param soldToParty CustomerInfoDataBean
	 */
	public void addSoldToParty(CustomerInfoDataBean soldToParty){
		if(null != soldToParty){
			if(null == iSoldToPartyNumber){
				iSoldToPartyNumber = new TreeMap(); 
				iSoldToPartyNumber.put("Other", "Other");  //$NON-NLS-1$  //$NON-NLS-2$
			}
			if(null == iSoldToPartyName){
				iSoldToPartyName= new TreeMap(); 
				iSoldToPartyName.put("Other", "Other");  //$NON-NLS-1$  //$NON-NLS-2$
			}
			//DADO02&DADO09 iSoldToPartyNumber.put(soldToParty.getCustomerNumber(), soldToParty.getLegacyCustomerNumberWithAS());
			iSoldToPartyNumber.put(soldToParty.getCustomerNumber(), soldToParty.getCustomerNumber()); //DADO02&DADO09
			iSoldToPartyName.put(soldToParty.getCustomerNumber(), soldToParty.getCustomerName());
		}
	}
	
	/**
	 * Returns collection of bill to parties 
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
	public TreeMap getBillToPartyNumber() {
		return iBillToPartyNumber;
	}
	/**
     * @return
     * @author thirumalai
     */
    public TreeMap getBillToPartyName() {
		return iBillToPartyName;
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
	 * Returns collection of customer lists 
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
	public TreeMap getCustomerLists() {
		return iCustomerLists;
	}

	/**
	 * Returns collection of payers 
	 * 
	 * <br>Known Bugs</b><br> 
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
	 * Returns collection of ship to party's 
	 * 
	 * <br>Known Bugs</b><br> 
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
	public TreeMap getShipToPartyNumber() {
		return iShipToPartyNumber;
	}
	/**
     * getShipToPartyName
     * 
     * @return
     * @author thirumalai
     */
    public TreeMap getShipToPartyName() {
		return iShipToPartyName;
	}

	/**
	 * Returns collection of sold to party's 
	 * 
	 * <br>Known Bugs</b><br> 
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
	public TreeMap getSoldToPartyNumber() {
		return iSoldToPartyNumber;
	}
	/**
     * getSoldToPartyName
     * 
     * @return
     * @author thirumalai
     */
    public TreeMap getSoldToPartyName() {
		return iSoldToPartyName;
	}

	/**
	 * Sets bill to party collection 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillToPartyNumber TreeMap 
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
	 * Sets comments 
	 * 
	 * <br>Known Bugs</b><br> 
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
	 * Sets the customer list collection 
	 * 
	 * <br>Known Bugs</b><br> 
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
	public void setCustomerLists(TreeMap newCustomerLists){
		iCustomerLists = newCustomerLists;
	}

	/**
	 * Sets the payer collection 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPayerNumber TreeMap 
	 */
	public void setPayerNumber(TreeMap newPayerNumber) {
		iPayerNumber = newPayerNumber;
	}
	/**
     * setPayerName
     * 
     * @param newPayerName
     * @author thirumalai
     */
    public void setPayerName(TreeMap newPayerName) {
		iPayerName = newPayerName;
	}

	/**
     * Sets ship to party collection
     * <br>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newShipToPartyNumber 
     */
	public void setShipToParty(TreeMap newShipToPartyNumber) {
		iShipToPartyNumber = newShipToPartyNumber;
	}
	/**
     * setShipToPartyName
     * 
     * @param newShipToPartyName
     * @author thirumalai
     */
    public void setShipToPartyName(TreeMap newShipToPartyName) {
		iShipToPartyName = newShipToPartyName;
	}

	/**
	 * Sets sold to party collection 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 20, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSoldToPartyNumber TreeMap 
	 */
	public void setSoldToPartyNumber(TreeMap newSoldToPartyNumber) {
		iSoldToPartyNumber = newSoldToPartyNumber;
	}
	/**
     * setSoldToPartyName
     * 
     * @param newSoldToPartyName
     * @author thirumalai
     */
    public void setSoldToPartyName(TreeMap newSoldToPartyName) {
		iSoldToPartyName = newSoldToPartyName;
	}

	/**
     * setData
     * 
     * @param customDTO
     * @param customerLists
     * @author thirumalai
     */
    public void setData(FetchPartnerInformationCustomDTO customDTO, TreeMap customers){
		if(null != customDTO){
			setButtonFlags(customDTO.getButtonFlags());
			setIGFFlag(customDTO.isIGFFlag());
			
			ESWCustomerCustomDTO selectedPartner = customDTO.getSelectedBillToParty();
			if(null != selectedPartner){
				if(isIGFFlag()){
					/* DADO02&DADO09 setSelectedBillToParty(selectedPartner.getLegacyCustomerNumber());
					setSelectedBillToPartyASNumber(selectedPartner.getAddressSequenceNumber());*/
					//setSelectedBillToParty(selectedPartner.getCustomerNumber()); //DADO02&DADO09
					//commented above line and added for defect BHALM00083160
					setSelectedBillToParty(selectedPartner.getSAPCustomerNumber()); 
					setSelectedBillToPartyName(selectedPartner.getCustomerName());
				}
				else{
					setSelectedBillToParty(selectedPartner.getSAPCustomerNumber());
					setSelectedBillToPartyName(selectedPartner.getSAPCustomerNumber());
				}
			}
			
			selectedPartner = customDTO.getSelectedNineDPartner();
			if(null != selectedPartner){
				setSelectedNineDPartner(selectedPartner.getSAPCustomerNumber());
			}

			selectedPartner = customDTO.getSelectedPayer();
			if(null != selectedPartner){
				if(isIGFFlag()){
					/* DADO02&DADO09 setSelectedPayer(selectedPartner.getLegacyCustomerNumber());
					setSelectedPayerASNumber(selectedPartner.getAddressSequenceNumber());*/
					
					//setSelectedPayer(selectedPartner.getCustomerNumber());
					//commented above one line and added for the defect BHALM00083160
					setSelectedPayer(selectedPartner.getSAPCustomerNumber());
					setSelectedPayerName(selectedPartner.getCustomerName());
				}
				else{
					setSelectedPayer(selectedPartner.getSAPCustomerNumber());
					
					setSelectedPayerName(selectedPartner.getSAPCustomerNumber());
				}
			}

			selectedPartner = customDTO.getSelectedShipToParty();
			if(null != selectedPartner){
				setSelectedShipToParty(selectedPartner.getSAPCustomerNumber());
				
			}

			selectedPartner = customDTO.getSelectedSoldToParty();
			if(null != selectedPartner){
				setSelectedSoldToParty(selectedPartner.getSAPCustomerNumber());
				
			}
			
			TreeMap soldToParty = customDTO.getSoldToParty();
			
			if(null != soldToParty){
				Iterator iterator = soldToParty.values().iterator();
				while(iterator.hasNext()){
					ESWCustomerCustomDTO customerInfo = (ESWCustomerCustomDTO)iterator.next();
					addSoldToParty(new CustomerInfoDataBean(customerInfo));
				}
			}

			TreeMap shipToParty = customDTO.getShipToParty();
			
			if(null != shipToParty){
				Iterator iterator = shipToParty.values().iterator();
				while(iterator.hasNext()){
					ESWCustomerCustomDTO customerInfo = (ESWCustomerCustomDTO)iterator.next();
					addShipToParty(new CustomerInfoDataBean(customerInfo));
				}
			}

			TreeMap billToParty = customDTO.getBillToParty();
			if(null != billToParty){
				Iterator iterator = billToParty.values().iterator();
				while(iterator.hasNext()){
					ESWCustomerCustomDTO customerInfo = (ESWCustomerCustomDTO)iterator.next();
					addBillToParty(new CustomerInfoDataBean(customerInfo));
				}
			}

			TreeMap payer = customDTO.getPayer();
			if(null != payer){
				Iterator iterator = payer.values().iterator();
				while(iterator.hasNext()){
					ESWCustomerCustomDTO customerInfo = (ESWCustomerCustomDTO)iterator.next();
					addPayer(new CustomerInfoDataBean(customerInfo));
				}
			}
			populateActionForm();
		}
		 if(null != customers){
			Iterator iterator = customers.values().iterator();
			while(iterator.hasNext()){
				addCustomers(new CustomerListViewBean((CustomerListCustomDTO)iterator.next()));
			}
		}
		
	}
	
	/**
     * PartnerSelectionViewBean
     * 
     * @author thirumalai
     */
    public PartnerSelectionViewBean(){
	}

	/**
     * PartnerSelectionViewBean
     * 
     * @param customDTO
     * @param customerLists
     * @param comments
     * @author thirumalai
     */
    public PartnerSelectionViewBean(FetchPartnerInformationCustomDTO customDTO, TreeMap customerLists, String comments){
		setData(customDTO, customerLists);
		setComments(comments);
	}
	
	/**
     * PartnerSelectionViewBean
     * 
     * @param customDTO
     * @param customerLists
     * @param comments
     * @param billToPartyEditable
     * @author thirumalai
     */
    public PartnerSelectionViewBean(FetchPartnerInformationCustomDTO customDTO, TreeMap customerLists, String comments, boolean billToPartyEditable){
		setData(customDTO, customerLists);
		setComments(comments);
		setBillToPartyEditable(!billToPartyEditable);
	}

	/**
     * PartnerSelectionViewBean
     * 
     * @param customDTO
     * @param customerLists
     * @param comments
     * @param billToPartyEditable
     * @param soldToPartyEditable
     * @author thirumalai
     */
    public PartnerSelectionViewBean(FetchPartnerInformationCustomDTO customDTO, TreeMap customerLists, String comments, boolean billToPartyEditable, boolean soldToPartyEditable){
		setData(customDTO, customerLists);
		setComments(comments);
		setBillToPartyEditable(!billToPartyEditable);
		setSoldToPartyEditable(soldToPartyEditable);
	}

	/**
	 * Returns selected bill to party value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
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
	 * Returns selected 9D partner value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedNineDPartner() {
		return iSelectedNineDPartner;
	}

	/**
	 * Returns selected 9D partner name value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedNineDPartnerName() {
		return iSelectedNineDPartnerName;
	}

	/**
	 * Returns selected payer value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
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
	 * Returns selected ship to party value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedShipToParty() {
		return iSelectedShipToParty;
	}

	/**
	 * Returns selected sold to party value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedSoldToParty() {
		return iSelectedSoldToParty;
	}

	/**
	 * Sets selected bill to party value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
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
	 * Sets selected 9D partner value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedNineDPartner String 
	 */
	public void setSelectedNineDPartner(String newSelectedNineDPartner) {
		iSelectedNineDPartner = newSelectedNineDPartner;
	}

	/**
	 * Sets selected 9D partner value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedNineDPartnerName String 
	 */
	public void setSelectedNineDPartnerName(String newSelectedNineDPartnerName) {
		iSelectedNineDPartnerName = newSelectedNineDPartnerName;
	}
	/**
	 * Sets selected payer value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
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
	 * Sets selected ship to party value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedShipToParty String 
	 */
	public void setSelectedShipToParty(String newSelectedShipToParty) {
		iSelectedShipToParty = newSelectedShipToParty;
	}

	/**
	 * Sets selected sold to party value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedSoldToParty String 
	 */
	public void setSelectedSoldToParty(String newSelectedSoldToParty) {
		iSelectedSoldToParty = newSelectedSoldToParty;
	}
	
	/**
	 * Returns if igf flag is assocated with the proposal 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isIGFFlag() {
		return iIGFFlag;
	}

	/**
	 * Sets igf flag value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newIGFFlag boolean
	 */
	public void setIGFFlag(boolean newIGFFlag) {
		iIGFFlag = newIGFFlag;
	}
	
	/**
	 * Returns selected bill to party address sequence number 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedBillToPartyASNumber() {
		return iSelectedBillToPartyASNumber;
	}

	/**
	 * Returns selected bill to party name 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedBillToPartyName() {
		return iSelectedBillToPartyName;
	}

	/**
	 * Returns selected payers address sequence number 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedPayerASNumber() {
		return iSelectedPayerASNumber;
	}

	/**
	 * Returns selected payer name value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSelectedPayerName() {
		return iSelectedPayerName;
	}

	/**
	 * Sets selected bill to party address sequence number
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedBillToPartyASNumber String 
	 */
	public void setSelectedBillToPartyASNumber(String newSelectedBillToPartyASNumber) {
		iSelectedBillToPartyASNumber = newSelectedBillToPartyASNumber;
	}

	/**
	 * Sets selected bill to party name 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedBillToPartyName String 
	 */
	public void setSelectedBillToPartyName(String newSelectedBillToPartyName) {
		iSelectedBillToPartyName = newSelectedBillToPartyName;
	}

	/**
	 * Sets selected payer address sequence number 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedPayerASNumber String 
	 */
	public void setSelectedPayerASNumber(String newSelectedPayerASNumber) {
		iSelectedPayerASNumber = newSelectedPayerASNumber;
	}

	/**
	 * Sets selected payer name 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSelectedPayerName String 
	 */
	public void setSelectedPayerName(String newSelectedPayerName) {
		iSelectedPayerName = newSelectedPayerName;
	}
	
	/**
	 * Returns the bill to party editable flag value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean 
	 */
	public boolean isBillToPartyEditable() {
		return iBillToPartyEditable;
	}

	/**
	 * Sets bill to party editable flag value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillToPartyEditable boolean
	 */
	public void setBillToPartyEditable(boolean newBillToPartyEditable) {
		iBillToPartyEditable = newBillToPartyEditable;
	}
	
	/**
     * getPartnerSelectionActionForm
     * 
     * @return
     * @author thirumalai
     */
    public PartnerSelectionActionForm getPartnerSelectionActionForm(){
		PartnerSelectionActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof PartnerSelectionActionForm){
			actionForm = (PartnerSelectionActionForm)getActionForm();
		}
		else{
			actionForm = new PartnerSelectionActionForm();
			setActionForm(actionForm);		
		}
		return actionForm;
	}
	
	private void populateActionForm(){
		PartnerSelectionActionForm actionForm = getPartnerSelectionActionForm();

		actionForm.setSoldToPartyNumber(getSelectedSoldToParty());
		actionForm.setSoldToPartyName(getSelectedSoldToParty());
		actionForm.setBillToPartyASNumber(getSelectedBillToPartyASNumber());
		actionForm.setBillToPartyNumber(getSelectedBillToParty());
		actionForm.setBillToPartyName(getSelectedBillToPartyName());
		actionForm.setPayerASNumber(getSelectedPayerASNumber());
		actionForm.setPayerNumber(getSelectedPayer());
		actionForm.setPayerName(getSelectedPayerName());
		actionForm.setShipToPartyNumber(getSelectedShipToParty());
		actionForm.setShipToPartyName(getSelectedShipToParty());
		actionForm.setNineDPartnerNumber(getSelectedNineDPartner());
		actionForm.setNineDPartnerName(getSelectedNineDPartnerName());
		actionForm.setComments(getComments());
		
		actionForm.setIgfNumber(isIGFFlag());
	}
	
	/**
     * clearAll
     * 
     * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean#clearAll()
     * @author thirumalai
     */
    public void clearAll(){
		populateActionForm();
	}
	
	/**
	 * Returns true of sold to party is editable 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isSoldToPartyEditable() {
		return iSoldToPartyEditable;
	}

	/**
	 * Sets sold to party editable flag value 
	 * 
	 * <br>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSoldToPartyEditable booleab
	 */
	public void setSoldToPartyEditable(boolean newSoldToPartyEditable) {
		iSoldToPartyEditable = newSoldToPartyEditable;
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
}