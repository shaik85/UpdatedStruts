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
public class IneligibleLicencesCustomDTO extends OPPTCustomDTO {
	private ProposalCustomDTO proposalDTO = null;
	private TreeMap existingContractCoverage = null;
	private TreeMap licensesFailingRemovalDateCheck = null;
	private TreeMap licensesWithRejectionReason = null;
	private TreeMap licensesFailingLicenseEffectiveDateCheck = null;
	private TreeMap licensesFailingDueToDeleveryBlockDate = null;
	private TreeMap customers = null;
	
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
}
