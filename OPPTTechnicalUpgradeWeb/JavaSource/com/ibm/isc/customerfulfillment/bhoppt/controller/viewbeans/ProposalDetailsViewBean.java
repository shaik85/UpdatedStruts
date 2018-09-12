/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.*;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.utility.Constants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ButtonConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;

/**
 * Holds complete data required for proposal details  
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
public class ProposalDetailsViewBean extends OPPTViewBean {
	private String iProposalName = null;
	private String iProposalContent = null;
	private String iProposalType = null;
	private TreeMap iCustomers = null;
	private TreeMap iSAndSCustomers = null;
	private int iViewType = Constants.PROPOSAL_DETAILS_NORMAL;
	private double iInvoiceAmount = 0;
	private double iSAndSDiscountAmount = 0;
	private int iPageIndex = 0;
	private int iTotalNoOfPages = 0;
	private int iMLCTotalNoOfPages = 0;
	private int iMLCExcess = 0;
	private boolean iProposalEditable = false;
	private boolean iSAndS = false;
	private boolean iPriced = false;
	private String iSearchString = null;
	
	private boolean iContract = false;
	private boolean proposalForApproval = false;
	
	private Date iAmendmentEffectiveDate = null;
	private boolean iContractInAmendment = false;

	// CR 2031	
	private boolean isDuplicateSerial = false;
	private boolean selectAll = false;
	private boolean clearAll  = false;

	/* start change CR6153 */
	private int iSAndSExtendedYears;
	private double iSAndSDiscountAmount1 = 0;
    private double iSAndSDiscountAmount2 = 0;
    private double iSAndSDiscountAmount3 = 0;
    private double iSAndSDiscountAmount4 = 0;
    private double iSAndSDiscountAmount5 = 0;
    /* end change CR6153 */

	/**
	 * Returns customers collection 
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
	public TreeMap getCustomers() {
		return iCustomers;
	}

	/**
	 * Returns invoice amount 
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
	 * @return double
	 */
	public double getInvoiceAmount() {
		return iInvoiceAmount;
	}

	/**
	 * Returns page index 
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
	 * @return int
	 */
	public int getPageIndex() {
		return iPageIndex;
	}

	/**
	 * Returns proposal name 
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
	public String getProposalName() {
		return iProposalName;
	}

	/**
	 * Returns proposal type 
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
	public String getProposalType() {
		return iProposalType;
	}

	/**
	 * Returns total numner of pages 
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
	 * @return int
	 */
	public int getTotalNoOfPages() {
		return iTotalNoOfPages;
	}

	/**
	 * Returns view type. That is either search or normal or edit 
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
	 * @return int
	 */
	public int getViewType() {
		return iViewType;
	}

	/**
	 * Sets customers collection whose inventory is fetched into proposal 
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
	 * @param newCustomers TreeMap
	 */
	public void setCustomers(TreeMap newCustomers) {
		iCustomers = newCustomers;
	}

	/**
	 * Sets invoice amount 
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
	 * @param newInvoiceAmount double 
	 */
	public void setInvoiceAmount(double newInvoiceAmount) {
		iInvoiceAmount = newInvoiceAmount;
	}

	/**
	 * Sets page index 
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
	 * @param newPageIndex int 
	 */
	public void setPageIndex(int newPageIndex) {
		iPageIndex = newPageIndex;
	}

	/**
	 * Sets proposal name 
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
	 * @param newProposalName String 
	 */
	public void setProposalName(String newProposalName) {
		iProposalName = newProposalName;
	}

	/**
	 * Sets proposal type 
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
	 * @param newProposalType String 
	 */
	public void setProposalType(String newProposalType) {
		iProposalType = newProposalType;
	}

	/**
	 * Sets total number of pages available 
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
	 * @param newTotalNoOfPages int 
	 */
	public void setTotalNoOfPages(int newTotalNoOfPages) {
		iTotalNoOfPages = newTotalNoOfPages;
	}

	/**
	 * Sets the type of view. That is either normal or search or edit 
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
	 * @param newViewType int 
	 */
	public void setViewType(int newViewType) {
		iViewType = newViewType;
	}

	/**
	 * Adds a new customer to already existin (if none exists creates a new) collection of customers.  
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
	 * @param customer CustomerViewBean
	 */
	public void addCustomer(String key, CustomerViewBean customer){
		if(null != customer){
			if(null == iCustomers){
				iCustomers = new TreeMap();
			}
			// iCustomers.put(customer.getId(), customer);
			iCustomers.put(key, customer);
		}
	}
	
	/**
     * Adds a new customer to already existin (if none exists creates a new) collection of customers.
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 20, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param key
     * @param ssCustomer 
     */
	public void addSSCustomer(String key, CustomerViewBean ssCustomer){
		if(null != ssCustomer){
			if(null == iSAndSCustomers){
				iSAndSCustomers = new TreeMap();
			}
			// iSAndSCustomers.put(ssCustomer.getId(), ssCustomer);
			iSAndSCustomers.put(key, ssCustomer);
		}
	}
	
	/**
	 * Sets complete data for proposal details view from custom dto   
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
	 * @param customDTO ProposalDetailsCustomDTO
	 */
	public void setData(ProposalDetailsCustomDTO customDTO){
		if(null != customDTO){
			if(customDTO.getProposalDTO() instanceof ContractCustomDTO){
				setContract(true);
			}
			else if(customDTO.getProposalDTO() instanceof ProposalForApprovalCustomDTO){
				setProposalForApproval(true);
			}
			
			setProposalName(customDTO.getProposalDTO().getName());
			setProposalContent(customDTO.getProposalDTO().getContent());
			setProposalType(customDTO.getProposalDTO().getType());
			setInvoiceAmount(customDTO.getInvoiceAmount());
			setPageIndex(customDTO.getPageIndex());
			setTotalNoOfPages(customDTO.getTotalNoOfPages());
			setMLCExcess(customDTO.getMLCExcess());
			setMLCTotalNoOfPages(customDTO.getMLCTotalNoOfPages());
			setViewType(customDTO.getRequestFor());

			setAmendmentEffectiveDate(customDTO.getAmendmentEffectiveDate());
			setContractInAmendment(customDTO.isContractInAmendment());

			if(customDTO.getProposalEditable() && customDTO.isVarianceProposal()){
				setProposalEditable(false);
			}
			else{
				setProposalEditable(customDTO.getProposalEditable());
			}
			
			setSearchString(customDTO.getSearchString());
			setSAndS(customDTO.isSAndS());
			setSAndSDiscountAmount(customDTO.getSAndSDiscountAmount());
			setPriced(customDTO.isIsPriced());
			setButtonFlags(customDTO.getButtonFlags());
		
			TreeMap customers = customDTO.getCustomers();
			if(null != customers){
				Iterator iterator = customers.keySet().iterator();
				while(iterator.hasNext()){
					String customerId = iterator.next().toString();
					addCustomer(customerId,  new CustomerViewBean((ProposalCustomerCustomDTO)customers.get(customerId)));
				}
			}
			
			TreeMap ssCustomers = customDTO.getSAndSCustomers();
			if(null != ssCustomers){
				Iterator iterator = ssCustomers.keySet().iterator();
				while(iterator.hasNext()){
					String customerId = iterator.next().toString();
					addSSCustomer(customerId, new CustomerViewBean((ProposalCustomerCustomDTO)ssCustomers.get(customerId)));
				}
			}
			
			//CR 2031 - starts
			setDuplicateSerial(customDTO.isDuplicateSerial());
			if(customDTO.isDuplicateSerial()) {
				setViewType(Constants.PROPOSAL_DETAILS_DUPLICATE_SERIAL);				
			}
			// CR 2031 - ends
			/* CR6153 - start changes */
			setSAndSExtendedYears(customDTO.getSAndSExtendedYears());
			setSAndSDiscountAmount1(customDTO.getSAndSDiscountAmount1());
			setSAndSDiscountAmount2(customDTO.getSAndSDiscountAmount2());
            setSAndSDiscountAmount3(customDTO.getSAndSDiscountAmount3());
            setSAndSDiscountAmount4(customDTO.getSAndSDiscountAmount4());
            setSAndSDiscountAmount5(customDTO.getSAndSDiscountAmount5());
            /* CR6153 - end changes */
		}
	}
	
	/**
     * ProposalDetailsViewBean
     * 
     * @author thirumalai
     */
    public ProposalDetailsViewBean(){
	}
	/**
     * ProposalDetailsViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public ProposalDetailsViewBean(ProposalDetailsCustomDTO customDTO){
		setData(customDTO);
	}
	
	/**
	 * Returns true if proposal is editable or not 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isProposalEditable() {
		return iProposalEditable;
	}

	/**
	 * Returns the search string if any 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getSearchString() {
		return iSearchString;
	}

	/**
	 * Sets the proposal editable flag 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalEditable boolean 
	 */
	public void setProposalEditable(boolean newProposalEditable) {
		iProposalEditable = newProposalEditable;
	}

	/**
	 * Sets the search string 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSearchString String 
	 */
	public void setSearchString(String newSearchString) {
		iSearchString = newSearchString;
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
	 * @return 
	 */
	public boolean isSAndS() {
		return iSAndS;
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
		iSAndS = b;
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
	 * @return 
	 */
	public TreeMap getSAndSCustomers() {
		return iSAndSCustomers;
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
		iSAndSCustomers = map;
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
	 * @return 
	 */
	public double getSAndSDiscountAmount() {
		return iSAndSDiscountAmount;
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
		iSAndSDiscountAmount = d;
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
	 * @return 
	 */
	public boolean isPriced() {
		return iPriced;
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
	 * @param newPriced boolean
	 */
	public void setPriced(boolean newPriced) {
		iPriced = newPriced;
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
	 * @return 
	 */
	public int getMLCTotalNoOfPages() {
		return iMLCTotalNoOfPages;
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
		iMLCTotalNoOfPages = i;
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
	 * @return 
	 */
	public int getMLCExcess() {
		return iMLCExcess;
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
		iMLCExcess = i;
	}
	
	/**
	 * Returns the true if the current view is for a contract 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isContract() {
		return iContract;
	}

	/**
	 * Sets whether the current view is for a contract or for a proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContract boolean
	 */
	public void setContract(boolean newContract) {
		iContract = newContract;
	}

	/**
	 * Returns true if the current view is for proposal for approval 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 */
	public boolean isProposalForApproval() {
		return proposalForApproval;
	}

	/**
	 * Sets the current view is for a proposal or proposal waiting for approval  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 27, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalForApproval boolean
	 */
	public void setProposalForApproval(boolean newProposalForApproval) {
		proposalForApproval = newProposalForApproval;
	}
	
	/**
     * showPrintProposal
     * 
     * @return
     * @author thirumalai
     */
    public boolean showPrintProposal(){
		boolean showPrintProposal = true;
		
		if(null != getButtonFlags()){
			if(getButtonFlags().contains(ButtonConstants.PRINT_PROPOSAL)){
				showPrintProposal = false;
			}
		}
		// CR 2031
		if(isDuplicateSerial()) {
			showPrintProposal = false;
		}
		
		return showPrintProposal;
	}
	
	/**
     * isSearchLicenses
     * 
     * @return
     * @author thirumalai
     */
    public boolean isSearchLicenses(){
		boolean searchLicenses = false;
		
		if(Constants.PROPOSAL_DETAILS_SEARCH == getViewType()){
			searchLicenses = true;
		}
		
		return searchLicenses;
	}

	/**
	 * getAmendmentEffectiveDate
	 * 
	 * @return
	 */
	public Date getAmendmentEffectiveDate() {
		return iAmendmentEffectiveDate;
	}

	/**
	 * isContractInAmendment
	 * 
	 * @return
	 */
	public boolean isContractInAmendment() {
		return iContractInAmendment;
	}

	/**
	 * setAmendmentEffectiveDate
	 * 
	 * @param date
	 */
	public void setAmendmentEffectiveDate(Date date) {
		iAmendmentEffectiveDate = date;
	}

	/**
	 * setContractInAmendment
	 * 
	 * @param b
	 */
	public void setContractInAmendment(boolean b) {
		iContractInAmendment = b;
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
	 * date Oct 27, 2004 
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
	 * date Oct 27, 2004 
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
	 * date Oct 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isClearAll() {
		return clearAll;
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
	 * date Oct 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public boolean isSelectAll() {
		return selectAll;
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
	 * date Oct 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setClearAll(boolean b) {
		clearAll = b;
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
	 * date Oct 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param b 
	 */
	public void setSelectAll(boolean b) {
		selectAll = b;
	}
	
	/**
     * selectAll
     * 
     * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean#selectAll()
     * @author thirumalai
     */
    public void selectAll(){
		setSelectAll(true);
		setClearAll(false);
	}
	
	/**
     * clearAll
     * 
     * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean#clearAll()
     * @author thirumalai
     */
    public void clearAll(){
		setClearAll(true);
		setSelectAll(false);
	}
    /**
     * @return Returns the iSAndSDiscountAmount2.
     */
    public double getSAndSDiscountAmount1() {
            return iSAndSDiscountAmount1;
    }
    /**
     * @param andSDiscountAmount2 The iSAndSDiscountAmount2 to set.
     */
    public void setSAndSDiscountAmount1(double d) {
            iSAndSDiscountAmount1 = d;
    }
    /**
     * @return Returns the iSAndSDiscountAmount2.
     */
    public double getSAndSDiscountAmount2() {
            return iSAndSDiscountAmount2;
    }
    /**
     * @param andSDiscountAmount2 The iSAndSDiscountAmount2 to set.
     */
    public void setSAndSDiscountAmount2(double d) {
            iSAndSDiscountAmount2 = d;
    }
    /**
     * @return Returns the iSAndSDiscountAmount3.
     */
    public double getSAndSDiscountAmount3() {
            return iSAndSDiscountAmount3;
    }
    /**
     * @param andSDiscountAmount3 The iSAndSDiscountAmount3 to set.
     */
    public void setSAndSDiscountAmount3(double d) {
            iSAndSDiscountAmount3 = d;
    }
    /**
     * @return Returns the iSAndSDiscountAmount4.
     */
    public double getSAndSDiscountAmount4() {
            return iSAndSDiscountAmount4;
    }
    /**
     * @param andSDiscountAmount4 The iSAndSDiscountAmount4 to set.
     */
    public void setSAndSDiscountAmount4(double d) {
            iSAndSDiscountAmount4 = d;
    }
    /**
     * @return Returns the iSAndSDiscountAmount5.
     */
    public double getSAndSDiscountAmount5() {
            return iSAndSDiscountAmount5;
    }
    /**
     * @param andSDiscountAmount5 The iSAndSDiscountAmount5 to set.
     */
    public void setSAndSDiscountAmount5(double d) {
            iSAndSDiscountAmount5 = d;
    }
    
	/**
	 * @return Returns the iSAndSExtendedYears.
	 */
	public int getSAndSExtendedYears() {
		return iSAndSExtendedYears;
	}
	/**
	 * @param andSExtendedYears The iSAndSExtendedYears to set.
	 */
	public void setSAndSExtendedYears(int andSExtendedYears) {
		iSAndSExtendedYears = andSExtendedYears;
	}
	/**
	 * @return Returns the iProposalContent.
	 */
	public String getProposalContent() {
		return iProposalContent;
	}
	/**
	 * @param proposalContent The iProposalContent to set.
	 */
	public void setProposalContent(String proposalContent) {
		iProposalContent = proposalContent;
	}
}
