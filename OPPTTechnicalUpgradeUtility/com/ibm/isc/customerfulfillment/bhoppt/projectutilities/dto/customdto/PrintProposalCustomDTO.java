/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * Custom dto that holds complete date required for printing a proposal  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 5, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class PrintProposalCustomDTO extends OPPTCustomDTO {
	private ProposalCustomDTO proposal = null;

	private double invoiceAmount = 0;
	private String contractNumber = null;
	private String contractType = null;
	private String proposalApprover = null;
	private Date amendmentEffectiveDate = null;

	private BasicProposalCustomDTO basicProposalCustomDTO = null;
	private PricingInformationCustomDTO pricingInformationCustomDTO = null;
	private SecondaryProposalCustomDTO secondaryProposalCustomDTO = null;
	private VarianceInformationCustomDTO varianceInformationCustomDTO = null;
	private PartnerInformationCustomDTO partnerInformationCustomDTO = null;

	private Map customers = null;

	private boolean sAndS = false;
	private boolean priced = false;
	private double sandSDiscountAmount = 0;
	private Map sAndSCustomers = null;

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
			customers.put(String.valueOf(customer.getCustomerId()), customer);
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
			sAndSCustomers.put(String.valueOf(customer.getCustomerId()), customer);
		}
	}

	/**
	 * Returns basic proposal information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return BasicProposalCustomDTO
	 */
	
	public BasicProposalCustomDTO getBasicProposalCustomDTO() {
		if (null == basicProposalCustomDTO) {
			basicProposalCustomDTO = new BasicProposalCustomDTO();
		}
		return basicProposalCustomDTO;
	}

	/**
	 * Returns contract number associated with the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	
	public String getContractNumber() {
		return contractNumber;
	}

	/**
	 * Returns type of the contract. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	
	public String getContractType() {
		return contractType;
	}

	/**
	 * Returns the customer collection whose inventory is present in the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Map
	 */
	
	public Map getCustomers() {
		return customers;
	}

	/**
	 * Returns total invoice amount of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
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
	 * Returns partner information of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PartnerInformationCustomDTO
	 */
	
	public PartnerInformationCustomDTO getPartnerInformationCustomDTO() {
		return partnerInformationCustomDTO;
	}

	/**
	 * Returns the pricing information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return PricingInformationCustomDTO
	 */
	
	public PricingInformationCustomDTO getPricingInformationCustomDTO() {
		return pricingInformationCustomDTO;
	}

	/**
	 * Returns proposal information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ProposalCustomDTO
	 */
	
	public ProposalCustomDTO getProposal() {
		return proposal;
	}

	/**
	 * Returns secondary proposal information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return SecondaryProposalCustomDTO
	 */
	
	public SecondaryProposalCustomDTO getSecondaryProposalCustomDTO() {
		return secondaryProposalCustomDTO;
	}

	/**
	 * Returns variance information of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return VarianceInformationCustomDTO
	 */
	
	public VarianceInformationCustomDTO getVarianceInformationCustomDTO() {
		return varianceInformationCustomDTO;
	}

	/**
	 * Sets basic proposal data 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBasicProposalCustomDTO BasicProposalCustomDTO
	 */
	
	public void setBasicProposalCustomDTO(BasicProposalCustomDTO newBasicProposalCustomDTO) {
		basicProposalCustomDTO = newBasicProposalCustomDTO;
	}

	/**
	 * Sets contract number assocated with the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractNumber String 
	 */
	
	public void setContractNumber(String newContractNumber) {
		contractNumber = newContractNumber;
	}

	/**
	 * Sets contract type of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newContractType String 
	 */
	
	public void setContractType(String newContractType) {
		contractType = newContractType;
	}

	/**
	 * Sets customers collection whose inventory is fetched into proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCustomers Map 
	 */
	
	public void setCustomers(Map newCustomers) {
		customers = newCustomers;
	}

	/**
	 * Sets invoice amount of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
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
	 * Sets partner information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPartnerInformationCustomDTO PartnerInformationCustomDTO
	 */
	
	public void setPartnerInformationCustomDTO(PartnerInformationCustomDTO newPartnerInformationCustomDTO) {
		partnerInformationCustomDTO = newPartnerInformationCustomDTO;
	}

	/**
	 * Sets pricing information of the proposal 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPricingInformationCustomDTO PricingInformationCustomDTO
	 */
	
	public void setPricingInformationCustomDTO(PricingInformationCustomDTO newPricingInformationCustomDTO) {
		pricingInformationCustomDTO = newPricingInformationCustomDTO;
	}

	/**
	 * Sets proposal information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposal ProposalCustomDTO
	 */
	
	public void setProposal(ProposalCustomDTO newProposal) {
		proposal = newProposal;
	}

	/**
	 * Sets secondary proposal information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSecondaryProposalCustomDTO SecondaryProposalCustomDTO
	 */
	
	public void setSecondaryProposalCustomDTO(SecondaryProposalCustomDTO newSecondaryProposalCustomDTO) {
		secondaryProposalCustomDTO = newSecondaryProposalCustomDTO;
	}

	/**
	 * Sets variance information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 4, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newVarianceInformationCustomDTO VarianceInformationCustomDTO
	 */
	
	public void setVarianceInformationCustomDTO(VarianceInformationCustomDTO newVarianceInformationCustomDTO) {
		varianceInformationCustomDTO = newVarianceInformationCustomDTO;
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
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Date
	 */
	
	public Date getAmendmentEffectiveDate() {
		return amendmentEffectiveDate;
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
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	
	public String getProposalApprover() {
		return proposalApprover;
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
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param date 
	 */
	
	public void setAmendmentEffectiveDate(Date date) {
		amendmentEffectiveDate = date;
	}

	/** get the data
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	
	public void setProposalApprover(String string) {
		proposalApprover = string;
	}

	/** get the data
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
	 * @return Map 
	 */
	
	public Map getSAndSCustomers() {
		return sAndSCustomers;
	}

	/** 
	* get the data
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return double
	 */
	
	public double getSandSDiscountAmount() {
		return sandSDiscountAmount;
	}

	/** 
	 * set the data
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 23, 2004 
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
	 * set the data
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	
	public void setSAndSCustomers(Map map) {
		sAndSCustomers = map;
	}

	/** 
	 * set the data
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param d 
	 */
	
	public void setSandSDiscountAmount(double d) {
		sandSDiscountAmount = d;
	}

	/** 
	 * set the data
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 23, 2004 
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
	 * is priced
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
	
	public boolean isPriced() {
		return priced;
	}

	/** 
	 * set the method
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
	
	public void setPriced(boolean b) {
		priced = b;
	}

	/** 
	 * finalize the method
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
	 */
	
/*	protected void finalize() {
		proposal = null;
		contractNumber = null;
		contractType = null;
		proposalApprover = null;
		amendmentEffectiveDate = null;

		basicProposalCustomDTO = null;
		pricingInformationCustomDTO = null;
		secondaryProposalCustomDTO = null;
		varianceInformationCustomDTO = null;
		partnerInformationCustomDTO = null;

		if (customers != null) {
			customers.clear();
			customers = null;
		}
		if (null != sAndSCustomers) {
			sAndSCustomers.clear();
			sAndSCustomers = null;
		}
	}*/

}
