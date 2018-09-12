/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/**
 * Custom dto that holds complete data about proposal details  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 9, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ProposalDetailsCustomDTO extends OPPTCustomDTO {
	private TreeMap customers = null;
	private TreeMap sAndSCustomers = null;
	
	private ProposalCustomDTO proposalDTO = null;
	private String searchString = null;
	private int pageIndex = 0;
	private int totalNoOfPages = 0;
	private int mLCTotalNoOfPages = 0;
	private int mLCExcess = 0;
	private double invoiceAmount = 0;
	private double sAndSDiscountAmount = 0;
	private int requestFor ;
	
	private PartnerInformationCustomDTO partnerInformation = null;
	
	private boolean isPriced = false;
	private boolean isSAndS = false;

	private boolean proposalEditable = false;
	private boolean inventoryFetched = true;
	private boolean varianceProposal = false;

	private Date amendmentEffectiveDate = null;
	private boolean isContractInAmendment = false;
	
	private boolean isDuplicateSerial = false;
	
	private List selectedCustomers = null;
	
	/* CR6153 start change */
	private double sAndSDiscountAmount1 = 0;
    private double sAndSDiscountAmount2 = 0;
    private double sAndSDiscountAmount3 = 0;
    private double sAndSDiscountAmount4 = 0;
    private double sAndSDiscountAmount5 = 0;
    
    private int sAndSExtendedYears = 0;
    /* CR6153 end change */
	/**
	 * Adds a new customer to the collection of customers available for the proposal
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customer ProposalCustomerCustomDTO
	 */
	public void addCustomer(ProposalCustomerCustomDTO customer) {
		if (null != customer) {
			if (null == customers) {
				customers = new TreeMap();
			}
			if(null != getProposalDTO()){
				customer.setProposalId(getProposalDTO().getId());
			}
			// customers.put(new Integer(customer.getCustomerId()), customer);
			customers.put(String.valueOf(customers.size()+1), customer);
		}
	}

	/**
	 * Adds a new customer to the collection of customers available for the proposal
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customer ProposalCustomerCustomDTO
	 */
	
	public void addSAndSCustomer(ProposalCustomerCustomDTO customer) {
		if (null != customer) {
			if (null == sAndSCustomers) {
				sAndSCustomers = new TreeMap();
			}
			if(null != getProposalDTO()){
				customer.setProposalId(getProposalDTO().getId());
			}
			// sAndSCustomers.put(new Integer(customer.getCustomerId()), customer);
			sAndSCustomers.put(String.valueOf(sAndSCustomers.size()+1), customer);
		}
	}	
	
	/**
	 * Returns collection of customers for the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getCustomers() {
		return customers;
	}

	/**
	 * Returns customer's parent proposal details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalCustomDTO
	 */
	public ProposalCustomDTO getProposalDTO() {
		return proposalDTO;
	}

	/**
	 * Returns true if proposal is editable 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	
	public boolean getProposalEditable(){
		return proposalEditable;
	}

	/**
	 * Returns search string 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	
	public String getSearchString(){
		return searchString;
	}

	/**
	 * Sets collection of customers available for the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomers TreeMap 
	 */
	
	public void setCustomers(TreeMap newCustomers) {
		customers = newCustomers;
	}

	/**
	 * Sets customer's parent proposal's detaols 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalDTO ProposalCustomDTO 
	 */
	public void setProposalDTO(ProposalCustomDTO newProposalDTO) {
		proposalDTO = newProposalDTO;
	}

	/**
	 * Sets proposalEditable flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalEditable boolean 
	 */
	
	public void setProposalEditable(boolean newProposalEditable){
		proposalEditable = newProposalEditable;
	}

	/**
	 * Sets search string 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSearchString String 
	 */
	
	public void setSearchString(String newSearchString){
		searchString = newSearchString;
	}
	
	/**
	 * Returns current page number 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * Returns total number of pages available for proposal details screen 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	
	public int getTotalNoOfPages() {
		return totalNoOfPages;
	}

	/**
	 * Sets current page index value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPageIndex int 
	 */
	
	public void setPageIndex(int newPageIndex) {
		pageIndex = newPageIndex;
	}

	/**
	 * Sets total number of pages value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newTotalNoOfPages int 
	 */
	
	public void setTotalNoOfPages(int newTotalNoOfPages) {
		totalNoOfPages = newTotalNoOfPages;
	}
	
	/**
	 * Returns invoice amount 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return double
	 */
	
	public double getInvoiceAmount() {
		return invoiceAmount;
	}

	/**
	 * Sets invoice amount value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 12, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newInvoiceAmount double 
	 */
	
	public void setInvoiceAmount(double newInvoiceAmount) {
		invoiceAmount = newInvoiceAmount;
	}

	/** 
	 * To get the request for PRINT or GOTO or SEARCH
	 *   
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 16, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	
	public int getRequestFor()
	{
		return requestFor;
	}

	/** 
	 * To set the request for PRINT or GOTO or SEARCH
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 16, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param arequestFor 
	 */
	
	public void setRequestFor(int arequestFor)
	{
		requestFor = arequestFor;
	}

	/**
	 * Retutns true if the inventory for the proposal is already fetched. 
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
	 * @return boolean
	 */
	
	public boolean isInventoryFetched() {
		return inventoryFetched;
	}

	/**
	 * Sets inventory fetched flag. 
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
	 * @param newInventoryFetched boolean 
	 */
	
	public void setInventoryFetched(boolean newInventoryFetched) {
		inventoryFetched = newInventoryFetched;
	}
	
	/**
	 * Returns partnerinformation 
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
	 * @return PartnerInformationCustomDTO
	 */
	
	public PartnerInformationCustomDTO getPartnerInformation() {
		return partnerInformation;
	}

	/**
	 * Sets partner information. This field will be set only if inventory is not fetched for the proposal. 
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
	 * @param newPartnerInformation PartnerInformationCustomDTO 
	 */
	
	public void setPartnerInformation(PartnerInformationCustomDTO newPartnerInformation) {
		partnerInformation = newPartnerInformation;
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	
	public boolean isIsPriced() {
		return isPriced;
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	
	public void setIsPriced(boolean b) {
		isPriced = b;
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	
	public boolean isSAndS() {
		return isSAndS;
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	
	public TreeMap getSAndSCustomers() {
		return sAndSCustomers;
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	
	public void setSAndS(boolean b) {
		isSAndS = b;
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setSAndSCustomers(TreeMap map) {
		sAndSCustomers = map;
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return double
	 */
	
	public double getSAndSDiscountAmount() {
		return sAndSDiscountAmount;
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
	 * date Feb 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param d 
	 */
	
	public void setSAndSDiscountAmount(double d) {
		sAndSDiscountAmount = d;
	}

	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	
	public int getMLCTotalNoOfPages() {
		return mLCTotalNoOfPages;
	}

	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param i 
	 */
	
	public void setMLCTotalNoOfPages(int i) {
		mLCTotalNoOfPages = i;
	}

	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	
	public int getMLCExcess() {
		return mLCExcess;
	}

	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param i 
	 */
	
	public void setMLCExcess(int i) {
		mLCExcess = i;
	}

	/**
	 * Returns variance proposal flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	
	public boolean isVarianceProposal() {
		return varianceProposal;
	}

	/**
	 * Sets variance proposal flag value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newVarianceProposal boolean
	 */
	
	public void setVarianceProposal(boolean newVarianceProposal) {
		varianceProposal = newVarianceProposal;
	}
	/**
	 * get amendment effective data
	 * @return date
	 */
	public Date getAmendmentEffectiveDate() {
		return amendmentEffectiveDate;
	}

	/**
	 * is correct
	 * 
	 * @return boolean
	 */
	public boolean isContractInAmendment() {
		return isContractInAmendment;
	}

	/**
	 * set ammend effective data
	 * 
	 * @param date
	 */
	public void setAmendmentEffectiveDate(Date date) {
		amendmentEffectiveDate = date;
	}

	/**
	 * set contract in amendent
	 * @param b
	 */
	public void setContractInAmendment(boolean b) {
		isContractInAmendment = b;
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
	 * date Oct 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isDuplicateSerial() {
		return isDuplicateSerial;
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
	 * date Oct 26, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setDuplicateSerial(boolean b) {
		isDuplicateSerial = b;
	}

    /**
     * is priced
     * 
     * @return bollean
     */
    public boolean isPriced() {
        return isPriced;
    }
    /**
     * set priced
     * @param lisPriced The isPriced to set.
     */
    public void setPriced(boolean lisPriced) {
        this.isPriced = lisPriced;
    }
   
    /* start change CR6153 */
    /**
     * @return Returns the sAndSDiscountAmount2.
     */
    public double getSAndSDiscountAmount1() {
            return sAndSDiscountAmount1;
    }
    /**
     * @param andSDiscountAmount2 The sAndSDiscountAmount2 to set.
     */
    public void setSAndSDiscountAmount1(double d) {
            sAndSDiscountAmount1 = d;
    }
    /**
     * @return Returns the sAndSDiscountAmount2.
     */
    public double getSAndSDiscountAmount2() {
            return sAndSDiscountAmount2;
    }
    /**
     * @param andSDiscountAmount2 The sAndSDiscountAmount2 to set.
     */
    public void setSAndSDiscountAmount2(double d) {
            sAndSDiscountAmount2 = d;
    }
    /**
     * @return Returns the sAndSDiscountAmount3.
     */
    public double getSAndSDiscountAmount3() {
            return sAndSDiscountAmount3;
    }
    /**
     * @param andSDiscountAmount3 The sAndSDiscountAmount3 to set.
     */
    public void setSAndSDiscountAmount3(double d) {
            sAndSDiscountAmount3 = d;
    }
    /**
     * @return Returns the sAndSDiscountAmount4.
     */
    public double getSAndSDiscountAmount4() {
            return sAndSDiscountAmount4;
    }
    /**
     * @param andSDiscountAmount4 The sAndSDiscountAmount4 to set.
     */
    public void setSAndSDiscountAmount4(double d) {
            sAndSDiscountAmount4 = d;
    }
    /**
     * @return Returns the sAndSDiscountAmount5.
     */
    public double getSAndSDiscountAmount5() {
            return sAndSDiscountAmount5;
    }
    /**
     * @param andSDiscountAmount5 The sAndSDiscountAmount5 to set.
     */
    public void setSAndSDiscountAmount5(double d) {
            sAndSDiscountAmount5 = d;
    }
    
	/**
	 * @return Returns the sAndSExtendedYears.
	 */
	public int getSAndSExtendedYears() {
		return sAndSExtendedYears;
	}
	/**
	 * @param andSExtendedYears The sAndSExtendedYears to set.
	 */
	public void setSAndSExtendedYears(int andSExtendedYears) {
		sAndSExtendedYears = andSExtendedYears;
	}
	/* end change CR6153 */
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
}