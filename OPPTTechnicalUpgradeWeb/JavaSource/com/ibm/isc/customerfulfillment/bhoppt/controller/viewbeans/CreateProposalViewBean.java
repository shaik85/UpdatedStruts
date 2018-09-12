/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.controller.viewbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean;
import com.ibm.isc.customerfulfillment.bhoppt.controller.actionforms.ProposalHeaderActionForm;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.ProposalFormDataCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.SalesOrganizationCustomDTO;

/**
 * Hold the information required for create proposal view.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 19, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class CreateProposalViewBean extends OPPTViewBean {
	
	private String selectedSalesOrg = "Germany - 0365";
	
	private TreeMap salesOrganizationOptions = null;
	private TreeMap distributionChannelOptions = null;
	private TreeMap divisionOptions = null;
	private TreeMap currencyCodeOptions = null;
	// BH Wave-1 Complex Contract Identifiers - Manoj - begin
	private TreeMap ocpsIDOptions = null;
	private TreeMap contractTypeOptions = null;
	private TreeMap blbIndicatorOptions = null;
	// BH Wave-1 Complex Contract Identifiers - Manoj - end
	//Added by srinivas-OPPT BH-DAD001
	private LinkedHashMap proposalTypeOptions = null;
	//private TreeMap proposalTypeOptions = null;
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

	private List nonEditableFields = null;
	
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
//	Added by srinivas-OPPT BH-DAD001
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
		if(null == endYears){
			endYears = new ArrayList();
		}
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
		if(null == startYears){
			startYears = new ArrayList();
		}
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
//	Added by srinivas-OPPT BH-DAD001
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
	
	//public void setSalesOrganizationOptions(TreeMap newSalesOrganizationOptions) {
		//salesOrganizationOptions = newSalesOrganizationOptions;
	//}

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
	 * Adds new sales organization option to already existing collection  
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
	 * @param salesOrganizationId String
	 * @param salesOrganizationOption String
	 */
	public void addSalesOrganizationOption(String salesOrganizationId, String salesOrganizationOption){
		if(salesOrganizationOption != null) {
			if(salesOrganizationOptions == null){
				salesOrganizationOptions = new TreeMap();
			}
			salesOrganizationOptions.put(salesOrganizationOption, salesOrganizationId);
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
			distributionChannelOptions.put(distributionChannelOption, distributionChannelId);
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
//public void addProposalTypeOption(String proposalTypeId, String proposalTypeOption){
//		if(proposalTypeOption != null){
//			if(proposalTypeOptions == null){
//				proposalTypeOptions = new TreeMap();
//			}
//			proposalTypeOptions.put(proposalTypeId, proposalTypeOption);
//		}
//	}
	
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
	 * @param salesOrganizationOptions TreeMap
	 * @param distributionChannelOptions TreeMap
	 * @param divisionOptions TreeMap
	 * @param currencyCodeOptions TreeMap
	 * @param proposalTypeOptions TreeMap
	 * @param plannedGrowthOptions TreeMap
	 * @param billingFrequencyOptions TreeMap
	 * @param growthLimitOptions TreeMap
	 * @param billingBlockOptions TreeMap
	 * @param deviatingDateRuleOptions TreeMap
	 * @param billingDateRuleOptions TreeMap
	 * @param paymentTermsOptions TreeMap
	 */	
//	Added by srinivas-OPPT BH-DAD001
	public void setData(TreeMap salesOrganizationOptions,String selectedSalesOrg, TreeMap distributionChannelOptions, TreeMap divisionOptions, 
				TreeMap currencyCodeOptions, LinkedHashMap proposalTypeOptions, TreeMap plannedGrowthOptions,
									TreeMap billingFrequencyOptions, TreeMap growthLimitOptions, TreeMap billingBlockOptions, 
						TreeMap deviatingDateRuleOptions, TreeMap billingDateRuleOptions, TreeMap paymentTermsOptions){
		setSalesOrganizationOptions(salesOrganizationOptions);
		setSelectedSalesOrg(selectedSalesOrg);
		setDistributionChannelOptions(distributionChannelOptions);
		setDivisionOptions(divisionOptions);
		setCurrencyCodeOptions(currencyCodeOptions);
		setProposalTypeOptions(proposalTypeOptions);
		setPlannedGrowthOptions(plannedGrowthOptions);
		setBillingFrequencyOptions(billingFrequencyOptions);
		setGrowthLimitOptions(growthLimitOptions);
		setBillingBlockOptions(billingBlockOptions);
		setDeviatingDateRuleOptions(deviatingDateRuleOptions);
		setBillingDateRuleOptions(billingDateRuleOptions);
		setPaymentTermsOptions(paymentTermsOptions);	
	}
	
	/**
	 * Populates the view bean based on the custom dto  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTO ProposalFormDataCustomDTO
	 */
	public void setData(ProposalFormDataCustomDTO customDTO)
	{
		if(null != customDTO)
		{
			setButtonFlags(customDTO.getButtonFlags());
			TreeMap collection = customDTO.getSalesOrganizationOptions();
			if(null != collection){
				Iterator iterator = collection.values().iterator();
				if(null != iterator){
					while(iterator.hasNext()){
						SalesOrganizationCustomDTO salesOrg = (SalesOrganizationCustomDTO)iterator.next();
						if(null != salesOrg){
							String salesOrgId = salesOrg.getId()+"|"+salesOrg.getDefaultCurrency();  //$NON-NLS-1$
							addSalesOrganizationOption(salesOrgId, salesOrg.toString());	
						}
					}
				}
			}
			
			collection =  customDTO.getDistributionChannelOptions();
			if(null != collection){
				Iterator iterator = collection.keySet().iterator();
				if(null != iterator){
					while(iterator.hasNext()){
						//String dstrChannelId = null;
						String key = (String)iterator.next();
						addDistributionChannelOption(key, (String)collection.get(key));
						//addDistributionChannelOption(key, (String)collection.get(key)+ " - " +key);

					}
				}
			}
			
			collection =  customDTO.getDivisionOptions();
			if(null != collection){
				Iterator iterator = collection.keySet().iterator();
				if(null != iterator){
					while(iterator.hasNext()){
						String key = (String)iterator.next();
						addDivisionOption(key, key +" - "+ (String)collection.get(key));
					}
				}
			}
			
			collection =  customDTO.getCurrencyCodeOptions();
			if(null != collection){
				Iterator iterator = collection.keySet().iterator();
				if(null != iterator){
					while(iterator.hasNext()){
						String key = (String)iterator.next();
						addCurrencyCodeOption(key, key +" - "+ (String)collection.get(key));
					}
				}
			}

			setProposalTypeOptions(customDTO.getProposalTypeOptions());
			setBillingFrequencyOptions(customDTO.getBillingFrequencyOptions());
			
			collection =  customDTO.getBillingBlockOptions();
			if(null != collection){
				Iterator iterator = collection.keySet().iterator();
				if(null != iterator){
					while(iterator.hasNext()){
						String key = (String)iterator.next();
						addBillingBlockOption(key, key +" - "+ (String)collection.get(key));
					}
				}
			}

			collection =  customDTO.getDeviatingDateRuleOptions();
			if(null != collection){
				Iterator iterator = collection.keySet().iterator();
				if(null != iterator){
					while(iterator.hasNext()){
						String key = (String)iterator.next();
						addDeviatingDateRuleOption(key, key +" - "+ (String)collection.get(key));
					}
				}
			}

			collection =  customDTO.getBillingDateRuleOptions();
			if(null != collection){
				Iterator iterator = collection.keySet().iterator();
				if(null != iterator){
					while(iterator.hasNext()){
						String key = (String)iterator.next();
						addBillingDateRuleOption(key, key +" - "+ (String)collection.get(key));  //$NON-NLS-1$
					}
				}
			}

			collection =  customDTO.getPaymentTermsOptions();
			if(null != collection){
				Iterator iterator = collection.keySet().iterator();
				if(null != iterator){
					while(iterator.hasNext()){
						String key = (String)iterator.next();
						addPaymentTermsOption(key, key +" - "+ (String)collection.get(key));  //$NON-NLS-1$
					}
				}
			}
			setEndYears(customDTO.getEndYears());
			setStartYears(customDTO.getStartYears());

			TreeMap plannedGrowth = new TreeMap();
			plannedGrowth.put("Nil", "Nil");  //$NON-NLS-1$  //$NON-NLS-2$
			plannedGrowth.put(3+"", 3+"");  //$NON-NLS-1$  //$NON-NLS-2$
			plannedGrowth.put(6+"", 6+"");  //$NON-NLS-2$
			plannedGrowth.put("Other", "Other");  //$NON-NLS-1$  //$NON-NLS-2$
			setPlannedGrowthOptions(plannedGrowth);
		
			TreeMap growthLimit = new TreeMap();
			growthLimit.put("Nil", "Nil");  //$NON-NLS-1$  //$NON-NLS-2$
			growthLimit.put(7+"", 7+"");  //$NON-NLS-1$  //$NON-NLS-2$
			growthLimit.put(15+"", 15+"");  //$NON-NLS-1$  //$NON-NLS-2$
			growthLimit.put("Other", "Other");  //$NON-NLS-1$  //$NON-NLS-2$
			setGrowthLimitOptions(growthLimit);
			setProposalContentOptions(customDTO.getProposalContentOptions());
			// BH Wave-1 Complex Contract Identifiers - Manoj - begin
			setOcpsIDOptions(customDTO.getOcpsIDOptions());
			setContractTypeOptions(customDTO.getContractTypeOptions());
			setBlbIndicatorOptions(customDTO.getBlbIndicatorOptions());
			// BH Wave-1 Complex Contract Identifiers - Manoj - end
		//	setSalesAreas(customDTO.getSalesAreas());
		//	setSelectedSalesArea(customDTO.getSelectedSalesArea());
			
		}
	}
	
	/**
     * CreateProposalViewBean
     * 
     * @author thirumalai
     */
    public CreateProposalViewBean(){
	}
    
	/**
     * CreateProposalViewBean
     * 
     * @param customDTO
     * @author thirumalai
     */
    public CreateProposalViewBean(ProposalFormDataCustomDTO customDTO){
		setData(customDTO);
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
	 * date Feb 13, 2004 
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
	 * date Feb 13, 2004 
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

	/**
	 * Returns the action form associated with the current view. 
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
	 * @return ProposalHeaderActionForm
	 */
	public ProposalHeaderActionForm getCreateProposalActionForm() {
		ProposalHeaderActionForm actionForm = null;
		if(null != getActionForm() && getActionForm() instanceof ProposalHeaderActionForm){
			actionForm = (ProposalHeaderActionForm)getActionForm();
		}
		else{
			actionForm = new ProposalHeaderActionForm();
			actionForm.getPricingInformation().setAdvance(true);
		}
		return actionForm;
	}

	/**
     * getReplacementDay
     * 
     * @return
     * @author thirumalai
     */
    public String getReplacementDay(){
		String day = "dd";  //$NON-NLS-1$
		Date date = getCreateProposalActionForm().getBasicProposalData().getReplacementContractDate();
		if(null != date){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(date);
			if(9 >= calender.getDay()){
				day = "0"+calender.getDay();  //$NON-NLS-1$
			}
			else{
				day = calender.getDay()+"";  //$NON-NLS-1$
			}
		}
		return day;
	}
	
	/**
     * getReplacementMonth
     * 
     * @return
     * @author thirumalai
     */
    public String getReplacementMonth(){
		String month = "mm";  //$NON-NLS-1$
		Date date = getCreateProposalActionForm().getBasicProposalData().getReplacementContractDate();
		if(null != date){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(date);
			if(9 >= calender.getMonth()){
				month = "0"+calender.getMonth();  //$NON-NLS-1$
			}
			else{
				month = calender.getMonth()+"";  //$NON-NLS-1$
			}
		}
		return month;
	}

	/**
     * getReplacementYear
     * 
     * @return
     * @author thirumalai
     */
    public String getReplacementYear(){
		String year = "yyyy";  //$NON-NLS-1$
		Date date = getCreateProposalActionForm().getBasicProposalData().getReplacementContractDate();
		if(null != date){
			OPPTCalender calender = new OPPTCalender();
			calender.setDate(date);
			year = calender.getYear()+"";  //$NON-NLS-1$
		}
		return year;
	}

	/**
	 * Returs non editable field collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List
	 */
	public List getNonEditableFields() {
		return nonEditableFields;
	}

	/**
	 * Sets non editable field collection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Mar 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newNonEditableFields List
	 */
	public void setNonEditableFields(List newNonEditableFields) {
		nonEditableFields = newNonEditableFields;
	}
	
	/**
     * clearAll
     * 
     * @see com.ibm.isc.customerfulfillment.bhoppt.controller.OPPTViewBean#clearAll()
     * @author thirumalai
     */
    public void clearAll(){
		getCreateProposalActionForm().reset();
		getCreateProposalActionForm().getPricingInformation().setAdvance(true);
	}
    // BH Wave1 - DAD003 - Complex Contract Identifiers - Begin - Manoj
	/**
	 * @return Returns the blbIndicatorOptions.
	 */
	public TreeMap getBlbIndicatorOptions() {
		return blbIndicatorOptions;
	}	/**
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
	// BH Wave1 - DAD003 - Complex Contract Identifiers - End - Manoj
	
	/**
	 * Sets sales areas collection 
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
	 * @param newSalesAreas TreeMap 
	 */
	public void setSalesOrganizationOptions(TreeMap newSalesAreas) {
		TreeMap localSalesArea = null;
		if(null != newSalesAreas){
			localSalesArea = new TreeMap();
			Set keySet = newSalesAreas.keySet();
			Iterator itr = keySet.iterator();
			String key;
	
			while(itr.hasNext()){
				key = (String)itr.next();
				String desc = (String)newSalesAreas.get(key);
				if(null == desc){
					desc = "";  //$NON-NLS-1$
				}
				localSalesArea.put(desc.trim() + "-" + key, key);  //$NON-NLS-1$
				System.out
						.println("CreateProposalViewBean.setSalesOrganizationOptions()"+ key);
			}
		}
		salesOrganizationOptions = localSalesArea;
	}
	/**
	 * Sets selected sales area 
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
	 * @param newSelectedSalesArea String 
	 */
	public void setSelectedSalesOrg(String newSelectedSalesOrg) {
		selectedSalesOrg = newSelectedSalesOrg;
	}
	

	/**
	 * Returns selected sales area 
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
	public String getSelectedSalesOrg() {
		return selectedSalesOrg;
	}


}
