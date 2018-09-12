/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.TreeMap;

/**
 * Custom dto that holds information about ineligible licenses  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 4, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class IneligibleLicensesCustomDTO extends OPPTCustomDTO {
	
    
    /** constant */ 
    public static final int EXISTING_CONTRACT_COVERAGE = 1;
	/** constant */
    public static final int LICENSES_FAILING_REMOVAL_DATE_CHECK = 2;
	/** constant */
    public static final int LICENSES_WITH_REJECTION_REASON = 3;
	/** constant */
    public static final int LICENSES_FAILING_LICENSE_EFFECTIVE_DATE_CHECK = 4;
	/** constant */ 
    public static final int LICENSES_FAILING_DUE_TO_DELIVERY_BLOCK_DATE = 5;
	/** constant */
    public static final int S_AND_S_EXISTING_CONTRACT_COVERAGE = 6;
	/** constant */
    public static final int S_AND_S_LICENSES_FAILING_REMOVAL_DATE_CHECK = 7;
	/** constant */ 
    public static final int S_AND_S_LICENSES_WITH_REJECTION_REASON = 8;
	/** constant */
    public static final int S_AND_S_LICENSES_FAILING_LICENSE_EFFECTIVE_DATE_CHECK = 9;
	/** constant */ 
    public static final int S_AND_S_LICENSES_FAILING_DUE_TO_DELIVERY_BLOCK_DATE = 10;
    /** constant */ 
    public static final int LICENSES_FAILING_WITH_SVC= 11;
    /** constant */ 
    public static final int S_AND_S_LICENSES_FAILING_WITH_SVC = 12;
		
	private ProposalCustomDTO proposalDTO = null;
	private TreeMap existingContractCoverage = null;
	private TreeMap licensesFailingRemovalDateCheck = null;
	private TreeMap licensesWithRejectionReason = null;
	private TreeMap licensesFailingLicenseEffectiveDateCheck = null;
	private TreeMap licensesFailingDueToDeleveryBlockDate = null;
	private TreeMap licensesFailingWithSvc = null;
	private TreeMap customers = null;
	
	private boolean sAndS = false;
	private String mlcSandSOption = null;
	
	private TreeMap sAndSExistingContractCoverage = null;
	private TreeMap sAndSLicensesFailingRemovalDateCheck = null;
	private TreeMap sAndSLicensesWithRejectionReason = null;
	private TreeMap sAndSLicensesFailingLicenseEffectiveDateCheck = null;
	private TreeMap sAndSLicensesFailingDueToDeleveryBlockDate = null;
	private TreeMap sAndSLicensesFailingWithSvc = null;
	
	/**
	 * Returns collection of customers for the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
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
	 * Returns collection of ineligible licenses under existing contract coverage section. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getExistingContractCoverage() {
		return existingContractCoverage;
	}

	/**
	 * Returns collection of ineligible swos under licenses failing due to delivery block date section 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getLicensesFailingDueToDeleveryBlockDate() {
		return licensesFailingDueToDeleveryBlockDate;
	}

	/**
	 * Returns collection of ineligible licenses under licenses failing license effective date check  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getLicensesFailingLicenseEffectiveDateCheck() {
		return licensesFailingLicenseEffectiveDateCheck;
	}

	/**
	 * Returns collection of ineligible licenses under licenses failing removal date check section 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getLicensesFailingRemovalDateCheck() {
		return licensesFailingRemovalDateCheck;
	}

	/**
	 * Returns collection of ineligible licenses under licenses with rejection reason  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getLicensesWithRejectionReason() {
		return licensesWithRejectionReason;
	}
	
	public TreeMap getLicensesFailingWithSvc() {
		return licensesFailingWithSvc;
	}


	/**
	 * Retunrs proposal details 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
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
	 * Sets collection of customers for the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomers 
	 */
	public void setCustomers(TreeMap newCustomers) {
		customers = newCustomers;
	}

	/**
	 * sets collection of ineligible licenses under existing contract coverage section 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newExistingContractCoverage 
	 */
	public void setExistingContractCoverage(TreeMap newExistingContractCoverage) {
		existingContractCoverage = newExistingContractCoverage;
	}

	/**
	 * Sets ineligible licenses collection under licenses failing due to delivery block date section 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLicensesFailingDueToDeleveryBlockDate 
	 */
	public void setLicensesFailingDueToDeleveryBlockDate(TreeMap newLicensesFailingDueToDeleveryBlockDate) {
		licensesFailingDueToDeleveryBlockDate = newLicensesFailingDueToDeleveryBlockDate;
	}

	/**
	 * Sets ineligible licenses collection under licenses failing license effective date check section. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLicensesFailingLicenseEffectiveDateCheck 
	 */
	public void setLicensesFailingLicenseEffectiveDateCheck(TreeMap newLicensesFailingLicenseEffectiveDateCheck) {
		licensesFailingLicenseEffectiveDateCheck = newLicensesFailingLicenseEffectiveDateCheck;
	}

	/** 
	 * Sets ineligible licenses collection under licenses failing removal date check
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLicensesFailingRemovalDateCheck 
	 */
	public void setLicensesFailingRemovalDateCheck(TreeMap newLicensesFailingRemovalDateCheck) {
		licensesFailingRemovalDateCheck = newLicensesFailingRemovalDateCheck;
	}

	/**
	 * Sets licenses with rejection reason colelction 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLicensesWithRejectionReason 
	 */
	public void setLicensesWithRejectionReason(TreeMap newLicensesWithRejectionReason) {
		licensesWithRejectionReason = newLicensesWithRejectionReason;
	}
	
	public void setLicensesFailingWithSvc(TreeMap newLicensesFailingWithSvc) {
		licensesFailingWithSvc = newLicensesFailingWithSvc;
	}

	/**
	 * Sets proposal data 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomDTO 
	 */
	public void setProposalDTO(ProposalCustomDTO newCustomDTO) {
		proposalDTO = newCustomDTO;
	}
	
	/**
	 * Adds customer  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customer
	 */
	public void addCustomer(ProposalCustomerCustomDTO customer){
		if(null != customer){
			if(null == customers){
				customers = new TreeMap(); 
			}
			customers.put(customer.getSAPCustomerNumber(), customer);
		}
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
	 * @return boolean
	 */
	public boolean isSAndS() {
		return sAndS;
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
	 * @return TreeMap
	 */
	public TreeMap getSAndSExistingContractCoverage() {
		return sAndSExistingContractCoverage;
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
	 * @return TreeMap
	 */
	public TreeMap getSAndSLicensesFailingDueToDeleveryBlockDate() {
		return sAndSLicensesFailingDueToDeleveryBlockDate;
	}

	/** 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getSAndSLicensesFailingLicenseEffectiveDateCheck() {
		return sAndSLicensesFailingLicenseEffectiveDateCheck;
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
	 * @return TreeMap
	 */
	public TreeMap getSAndSLicensesFailingRemovalDateCheck() {
		return sAndSLicensesFailingRemovalDateCheck;
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
	 * @return TreeMap
	 */
	public TreeMap getSAndSLicensesWithRejectionReason() {
		return sAndSLicensesWithRejectionReason;
	}
	public TreeMap getSAndSLicensesFailingWithSvc() {
		return sAndSLicensesFailingWithSvc;
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
	 * @param b 
	 */
	public void setSAndS(boolean b) {
		sAndS = b;
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
	 * @param map 
	 */
	public void setSAndSExistingContractCoverage(TreeMap map) {
		sAndSExistingContractCoverage = map;
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
	 * @param map 
	 */
	public void setSAndSLicensesFailingDueToDeleveryBlockDate(TreeMap map) {
		sAndSLicensesFailingDueToDeleveryBlockDate = map;
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
	 * @param map 
	 */
	public void setSAndSLicensesFailingLicenseEffectiveDateCheck(TreeMap map) {
		sAndSLicensesFailingLicenseEffectiveDateCheck = map;
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
	 * @param map 
	 */
	public void setSAndSLicensesFailingRemovalDateCheck(TreeMap map) {
		sAndSLicensesFailingRemovalDateCheck = map;
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
	 * @param map 
	 */
	public void setSAndSLicensesWithRejectionReason(TreeMap map) {
		sAndSLicensesWithRejectionReason = map;
	}
	
	public void setSAndSLicensesFailingWithSvc(TreeMap map) {
		sAndSLicensesFailingWithSvc = map;
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
	 * date Mar 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getMlcSandSOption() {
		return mlcSandSOption;
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
	 * date Mar 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setMlcSandSOption(String string) {
		mlcSandSOption = string;
	}

}
