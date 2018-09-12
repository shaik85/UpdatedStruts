/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeMap; 

/**
 * Holds complete date required for creating a proposal  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class ProposalFormDataCustomDTO extends OPPTCustomDTO {
	private TreeMap salesOrganizationOptions = null;
	private String primarySalesOrg = null;
	private TreeMap distributionChannelOptions = null;
	private TreeMap divisionOptions = null;
	//added by srinivas -oppt-bh dad001
	private TreeMap currencyCodeOptions = null;
	// BH Wave-1 complex contract type - begin - Bhanu
	private TreeMap ocpsIDOptions = null;
	private TreeMap contractTypeOptions = null;
	private TreeMap blbIndicatorOptions = null;
	// BH Wave-1 complex contract type - end - Bhanu
	private LinkedHashMap proposalTypeOptions = null;
//	private TreeMap proposalTypeOptions = null;
	private TreeMap plannedGrowthOptions = null;
	private TreeMap billingFrequencyOptions = null;
	private TreeMap growthLimitOptions = null;
	private TreeMap billingBlockOptions = null;
	private TreeMap deviatingDateRuleOptions = null;
	private TreeMap billingDateRuleOptions = null;
	private TreeMap paymentTermsOptions = null;
	private TreeMap proposalContentOptions = null;
	private ArrayList startYears = null;
	private ArrayList endYears = null;
	
	/**
	 * Return collection of billing block options available, 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getBillingBlockOptions() {
		return billingBlockOptions;
	}

	/**
	 * Returns collection of billing date rules available 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getBillingDateRuleOptions() {
		return billingDateRuleOptions;
	}

	/**
	 * Returns collection of billing frequency options available 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getBillingFrequencyOptions() {
		return billingFrequencyOptions;
	}

	/**
	 * Returns collection of currency code options available 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getCurrencyCodeOptions() {
		return currencyCodeOptions;
	}

	/**
	 * Returns collection of deviating rule options available 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getDeviatingDateRuleOptions() {
		return deviatingDateRuleOptions;
	}

	/**
	 * Returns collection of distribution channel options available 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getDistributionChannelOptions() {
		return distributionChannelOptions;
	}

	/**
	 * Returns collection of division options available 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getDivisionOptions() {
		return divisionOptions;
	}

	/**
	 * Returns collection of growth limit options available 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getGrowthLimitOptions() {
		return growthLimitOptions;
	}

	/**
	 * Returns collection of payment terms options available 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getPaymentTermsOptions() {
		return paymentTermsOptions;
	}

	/**
	 * Returns collection of planned growth options available 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getPlannedGrowthOptions() {
		return plannedGrowthOptions;
	}

	/**
	 * Returns collection of proposal type options available 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
//	added by srinivas -oppt-bh dad001
	public LinkedHashMap getProposalTypeOptions() {
	
		return proposalTypeOptions;
	}

	/**
	 * Returns collection of sales organization options available 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return TreeMap
	 */
	public TreeMap getSalesOrganizationOptions() {
		return salesOrganizationOptions;
	}

	/**
	 * Returns contract end year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ArrayList
	 */
	public ArrayList getEndYears() {
		return endYears;
	}

	/**
	 * Returns contract start year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ArrayList
	 */
	public ArrayList getStartYears() {
		return startYears;
	}

	/**
	 * Sets the billing block options collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillingBlockOptions TreeMap 
	 */
	public void setBillingBlockOptions(TreeMap newBillingBlockOptions) {
		billingBlockOptions = newBillingBlockOptions;
	}

	/**
     * Sets billing date rule options collection
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 18, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newBillingDateRuleOptions 
     */
	public void setBillingDateRuleOptions(TreeMap newBillingDateRuleOptions) {
		billingDateRuleOptions = newBillingDateRuleOptions;
	}

	/**
	 * Sets collection of billing frequency options collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newBillingFrequencyOptions TreeMap 
	 */
	public void setBillingFrequencyOptions(TreeMap newBillingFrequencyOptions) {
		billingFrequencyOptions = newBillingFrequencyOptions;
	}

	/** 
	 * Sets currency code options collection
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newCurrencyCodeOptions TreeMap 
	 */
	public void setCurrencyCodeOptions(TreeMap newCurrencyCodeOptions) {
		currencyCodeOptions = newCurrencyCodeOptions;
	}

	/**
	 * Sets collection of deviating date rule options 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDeviatingRuleOptions TreeMap
	 */
	public void setDeviatingDateRuleOptions(TreeMap newDeviatingRuleOptions) {
		deviatingDateRuleOptions = newDeviatingRuleOptions;
	}

	/**
	 * Sets collection of distribution channel options 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDistributionChannelOptions TreeMap 
	 */
	public void setDistributionChannelOptions(TreeMap newDistributionChannelOptions) {
		distributionChannelOptions = newDistributionChannelOptions;
	}

	/**
	 * Sets collection of division options 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newDivisionOptions TreeMap 
	 */
	public void setDivisionOptions(TreeMap newDivisionOptions) {
		divisionOptions = newDivisionOptions;
	}

	/**
	 * Sets collection of growth limit options 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newGrowthLimitOptions TreeMap  
	 */
	public void setGrowthLimitOptions(TreeMap newGrowthLimitOptions) {
		growthLimitOptions = newGrowthLimitOptions;
	}

	/**
	 * Sets collection of payment terms options 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPaymentTermsOptions TreeMap 
	 */
	public void setPaymentTermsOptions(TreeMap newPaymentTermsOptions) {
		paymentTermsOptions = newPaymentTermsOptions;
	}

	/**
	 * Sets collection of planned growth options 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newPlannedGrowthOptions TreeMap 
	 */
	public void setPlannedGrowthOptions(TreeMap newPlannedGrowthOptions) {
		plannedGrowthOptions = newPlannedGrowthOptions;
	}

	/**
	 * Sets collection of proposal type options 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newProposalTypeOptions TreeMap
	 */
//	added by srinivas -oppt-bh dad001
	public void setProposalTypeOptions(LinkedHashMap newProposalTypeOptions) {
	
		proposalTypeOptions = newProposalTypeOptions;
	}

	/**
	 * Sets collection of sales organization options 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newSalesOrganizationOptions TreeMap 
	 */
	public void setSalesOrganizationOptions(TreeMap newSalesOrganizationOptions) {
		salesOrganizationOptions = newSalesOrganizationOptions;
	}

	/**
     * Adds new sales organization option to already existing collection
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 19, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param salesOrganization 
     */
	public void addSalesOrganizationOption(SalesOrganizationCustomDTO salesOrganization){
		if(null != salesOrganization) {
			if(salesOrganizationOptions == null){
				salesOrganizationOptions = new TreeMap();
			}
			salesOrganizationOptions.put(salesOrganization.getId(), salesOrganization);
		}
	}
	
	/**
	 * Adds new distribition channel option to already existing collection  
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
	 * @param distributionChannelId String
	 * @param distributionChannelOption String
	 */
	public void addDistributionChannelOption(String distributionChannelId, String distributionChannelOption){
		if(distributionChannelOption != null){
			if(distributionChannelOptions == null){
				distributionChannelOptions = new TreeMap();
			}
			distributionChannelOptions.put(distributionChannelId, distributionChannelOption);
		}
	}
	
	/**
	 * Adds new division option to already existing collection  
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
	 * @param divisionId String
	 * @param divisionOption String
	 */
	public void addDivisionOption(String divisionId, String divisionOption){
		if(divisionOption != null){
			if(divisionOptions == null){
				divisionOptions = new TreeMap();
			}
			divisionOptions.put(divisionId, divisionOption);
		}
	}
	
	/**
	 * Adds new currency code option to already existing collection  
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
	 * @param currencyCodeId String
	 * @param currencyCodeOption String
	 */
	public void addCurrencyCodeOption(String currencyCodeId, String currencyCodeOption){
		if(currencyCodeOption != null){
			if(currencyCodeOptions == null){
				currencyCodeOptions = new TreeMap();
			}
			currencyCodeOptions.put(currencyCodeId, currencyCodeOption);
		}
	}
	
	/**
	 * Adds new proposal type option to already existing collection  
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
	 * @param proposalTypeId String
	 * @param proposalTypeOption String
	 */
//	public void addProposalTypeOption(String proposalTypeId, String proposalTypeOption){
//		if(proposalTypeOption != null){
//			if(proposalTypeOptions == null){
//				proposalTypeOptions = new TreeMap();
//			}
//			proposalTypeOptions.put(proposalTypeId, proposalTypeOption);
//		}
//	}
//	
	/**
	 * Adds new planned growth option to already existing collection  
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
	 * @param plannedGrowthId String
	 * @param plannedGrowthOption String
	 */
	public void addPlannedGrowthOption(String plannedGrowthId, String plannedGrowthOption){
		if(plannedGrowthOption != null){
			if(plannedGrowthOptions == null){
				plannedGrowthOptions = new TreeMap();
			}
			plannedGrowthOptions.put(plannedGrowthId, plannedGrowthOption);
		}
	}
	
	/**
	 * Adds new billing frequency option to already existing colletion  
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
	 * @param billingFrequencyId String
	 * @param billingFrequencyOption String
	 */
	public void addBillingFrequencyOption(String billingFrequencyId, String billingFrequencyOption){
		if(billingFrequencyOption != null){
			if(billingFrequencyOptions == null){
				billingFrequencyOptions = new TreeMap();
			}
			billingFrequencyOptions.put(billingFrequencyId, billingFrequencyOption);
		}
	}
	
	/**
	 * Adds new growth limit option to already existing collection  
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
	 * @param growthLimitId String
	 * @param growthLimitOption String
	 */
	public void addGrowthLimitOption(String growthLimitId, String growthLimitOption){
		if(growthLimitOption != null){
			if(growthLimitOptions == null){
				growthLimitOptions = new TreeMap();
			}
			growthLimitOptions.put(growthLimitId, growthLimitOption);
		}
	}
	
	/**
	 * Adds new billing block option to already existing collection  
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
	 * @param billingBlockId String
	 * @param billingBlockOption String
	 */
	public void addBillingBlockOption(String billingBlockId, String billingBlockOption){
		if(billingBlockOption != null){
			if(billingBlockOptions == null){
				billingBlockOptions = new TreeMap();
			}
			billingBlockOptions.put(billingBlockId, billingBlockOption);
		}
	}
	
	/**
	 * Adds new deviating rule option to already existing collection  
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
	 * @param deviatingDateRuleId String
	 * @param deviatingDateRuleOption String
	 */
	public void addDeviatingDateRuleOption(String deviatingDateRuleId, String deviatingDateRuleOption){
		if(deviatingDateRuleOption != null){
			if(deviatingDateRuleOptions == null){
				deviatingDateRuleOptions = new TreeMap();
			}
			deviatingDateRuleOptions.put(deviatingDateRuleId, deviatingDateRuleOption);
		}
	}
	
	/**
	 * Adds new billing date rule option to already existing collection.  
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
	 * @param billingDateRuleId String
	 * @param billingDateRuleOption String
	 */
	public void addBillingDateRuleOption(String billingDateRuleId, String billingDateRuleOption){
		if(billingDateRuleOption != null){
			if(billingDateRuleOptions == null){
				billingDateRuleOptions = new TreeMap();
			}
			billingDateRuleOptions.put(billingDateRuleId, billingDateRuleOption);
		}
	}
	
	/**
	 * Adds a new payment terms option to already existing collection 
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
	 * @param paymentTermsId String
	 * @param paymentTermsOption String
	 */
	public void addPaymentTermsOption(String paymentTermsId, String paymentTermsOption){
		if(paymentTermsOption != null){
			if(paymentTermsOptions == null){
				paymentTermsOptions = new TreeMap();
			}
			paymentTermsOptions.put(paymentTermsId, paymentTermsOption);
		}
	}

	/**
	 * Sets contract end year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newEndYears ArrayList 
	 */
	public void setEndYears(ArrayList newEndYears) {
		endYears = newEndYears;
	}

	/**
	 * Sets contract start year collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newStartYears ArrayList 
	 */
	public void setStartYears(ArrayList newStartYears) {
		startYears = newStartYears;
	}

	/**
	 * Sets complete data in a single method call 
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
	 * @param isalesOrganizationOptions TreeMap
	 * @param idistributionChannelOptions TreeMap
	 * @param idivisionOptions TreeMap
	 * @param icurrencyCodeOptions TreeMap
	 * @param iproposalTypeOptions TreeMap
	 * @param iplannedGrowthOptions TreeMap
	 * @param ibillingFrequencyOptions TreeMap
	 * @param igrowthLimitOptions TreeMap
	 * @param ibillingBlockOptions TreeMap
	 * @param ideviatingDateRuleOptions TreeMap
	 * @param ibillingDateRuleOptions TreeMap
	 * @param ipaymentTermsOptions TreeMap
	 * @param istartYears ArrayList
	 * @param iendYears ArrayList
	 */	
//	added by srinivas -oppt-bh dad001
	public void setData(TreeMap isalesOrganizationOptions, TreeMap idistributionChannelOptions, TreeMap idivisionOptions, 
						TreeMap icurrencyCodeOptions, LinkedHashMap iproposalTypeOptions, TreeMap iplannedGrowthOptions,
					//TreeMap icurrencyCodeOptions, TreeMap iproposalTypeOptions, TreeMap iplannedGrowthOptions,		
		TreeMap ibillingFrequencyOptions, TreeMap igrowthLimitOptions, TreeMap ibillingBlockOptions, 
						TreeMap ideviatingDateRuleOptions, TreeMap ibillingDateRuleOptions, TreeMap ipaymentTermsOptions, 
						ArrayList istartYears, ArrayList iendYears){
		setSalesOrganizationOptions(isalesOrganizationOptions);
		setDistributionChannelOptions(idistributionChannelOptions);
		setDivisionOptions(idivisionOptions);
		setCurrencyCodeOptions(icurrencyCodeOptions);
		setProposalTypeOptions(iproposalTypeOptions);
		setPlannedGrowthOptions(iplannedGrowthOptions);
		setBillingFrequencyOptions(ibillingFrequencyOptions);
		setGrowthLimitOptions(igrowthLimitOptions);
		setBillingBlockOptions(ibillingBlockOptions);
		setDeviatingDateRuleOptions(ideviatingDateRuleOptions);
		setBillingDateRuleOptions(ibillingDateRuleOptions);
		setPaymentTermsOptions(ipaymentTermsOptions);	
		setStartYears(istartYears);
		setEndYears(iendYears);
	}
	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public TreeMap getProposalContentOptions() {
		return proposalContentOptions;
	}

	/** 
	
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param map 
	 */
	public void setProposalContentOptions(TreeMap map) {
		proposalContentOptions = map;
	}
	// BH Wave1 - DAD003 - Complex Contract Identifiers - Begin - Bhanu
	/**
	 * @return Returns the blbIndicatorOptions.
	 */
	public TreeMap getBlbIndicatorOptions() {
		return blbIndicatorOptions;
	}
	/**
	 * @param blbIndicatorOptions The blbIndicatorOptions to set.
	 */
	public void setBlbIndicatorOptions(TreeMap blbIndicatorOptions) {
		this.blbIndicatorOptions = blbIndicatorOptions;
	}
	/**
	 * @return Returns the complexContractTypeOptions.
	 */
	public TreeMap getOcpsIDOptions() {
		return ocpsIDOptions;
	}
	/**
	 * @param complexContractTypeOptions The complexContractTypeOptions to set.
	 */
	public void setOcpsIDOptions(TreeMap ocpsIDOptions) {
		this.ocpsIDOptions = ocpsIDOptions;
	}
	/**
	 * @return Returns the masterContractTypeOptions.
	 */
	public TreeMap getContractTypeOptions() {
		return contractTypeOptions;
	}
	/**
	 * @param masterContractTypeOptions The masterContractTypeOptions to set.
	 */
	public void setContractTypeOptions(TreeMap contractTypeOptions) {
		this.contractTypeOptions = contractTypeOptions;
	}
	// BH Wave1 - DAD003 - Complex Contract Identifiers - End - Bhanu
	
	public String getPrimarySalesOrg() {
		System.out.println("ProposalFormDataCustomDTO.getPrimarySalesOrg()"+primarySalesOrg);
		return primarySalesOrg;
	}
	/**
	 * @param blbIndicatorOptions The blbIndicatorOptions to set.
	 */
	public void setPrimarySalesOrg(String newPrimarySalesOrg) {
		System.out.println("ProposalFormDataCustomDTO.setPrimarySalesOrg()"+newPrimarySalesOrg);
		primarySalesOrg = newPrimarySalesOrg;
	}
}
