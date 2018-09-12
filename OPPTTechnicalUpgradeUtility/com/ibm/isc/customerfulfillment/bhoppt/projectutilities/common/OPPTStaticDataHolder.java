/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common;

import java.util.Map;


/** 
 * This class will be used by UI to get description for the key values 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 19, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */
public class OPPTStaticDataHolder {
	
	/** static map object*/  public   static Map proposalTypeMap = null;
	/** static map object*/  public   static Map contractTypeMap= null;
	/** static map object*/  public   static Map proposalStatusMap= null;
	/** static map object*/  public   static Map currencyMap= null;
	/** static map object*/  public   static Map salesOrgMap= null;
	/** static map object*/  public   static Map countryCodeMap = null;
	/** static map object*/  public   static Map salesOrgMapForBaseAgreement = null;
	/** static map object*/  public   static Map billingFreqMap= null;
	/** static map object*/  public   static Map billingTypeMap= null;
	/** static map object*/  public   static Map billingBlockMap= null;
	/** static map object*/  public   static Map paymentTermMap= null;
	/** static map object*/  public   static Map distributionChannelMap= null;
	/** static map object*/  public   static Map divisionCodeMap= null;
	/** static map object*/  public   static Map sAndSMap= null;
	/** static map object*/  public   static Map roleMap= null;
	// Changes start Added by Sasi R Challa for BaseAgreement 
	/** static map object*/  public   static Map modificationTypeMap = null;
	/** static map object*/  public   static Map formNumberMap = null;
	/** static map object*/  public   static Map coverageTypeMap = null;
	/** static map object*/  public   static Map baseAgreementStatusMap = null;
	/** static map object*/  public   static Map rolOptionsMap = null;
	/** static map object*/  public   static Map userTypeMap = null;
	/** static map object*/  public   static Map baRoleMap = null;
	/** static map object*/  public   static Map rolMap = null;
	/** static map object*/  public   static Map statusMap = null;
	// Changes for BH Wave1 DAD003 by Bhanu 
	/** static map object*/  public   static Map blbIndicatorMap = null;
	
//	Added by Srinivas-------OPPTBH-DAD003
	/** static map object*/  public   static Map ComplexTypesMap = null;
	//added by nomita
	/** static map object*/  public   static Map operationMap = null;
	/** static map object*/  public   static Map cpsSalesorg = null;
	
	
	// Changes End 
	/**
	 *  Returns proposal type descrption
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
	 * @param key
	 * @return String
	 */
	
	public static String getProposalTypeDesc(String key) {
		return (String)proposalTypeMap.get(key);
	}
	
	/**
	 *  Returns proposal type descrption
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
	 * @param key
	 * @return String
	 */
	
	public static String getContractTypeDesc(String key) {
		return (String)contractTypeMap.get(key);
	}
	/**
	 *  Returns proposal type descrption
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
	 * @param key
	 * @return String
	 */
	
	public static String getProposalStatusDesc(String key) {
		return (String)proposalStatusMap.get(key);
	}
	/**
	 *  Returns proposal type descrption
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
	 * @param key
	 * @return String
	 */
	
	public static String getCurrencyDesc(String key) {
		return (String)currencyMap.get(key);
	}
	/**
	 *  Returns proposal type descrption
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
	 * @param key
	 * @return String
	 */
	
	public static String getSalesOrgDesc(String key) {
		return (String)salesOrgMap.get(key);
	}
	
	/**
	 *  Returns proposal type descrption
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
	 * @param key
	 * @return String
	 */
	
	public static String getSalesOrgDescForBaseAgreement(String key) {
		return (String)salesOrgMapForBaseAgreement.get(key);
	}
	/**
	 *  Returns proposal type descrption
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
	 * @param key
	 * @return String
	 */
	
	public static String getBillingFreqDesc(String key) {
		return (String)billingFreqMap.get(key);
	}
	/**
	 *  Returns proposal type descrption
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
	 * @param key
	 * @return String
	 */
	
	public static String getBillingTypeDesc(String key) {
		return (String)billingTypeMap.get(key);
	}
	/**
	 *  Returns proposal type descrption
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
	 * @param key
	 * @return String
	 */
	
	public static String getBillingBlockDesc(String key) {
		return (String)billingBlockMap.get(key);
	}
	/**
	 *  Returns proposal type descrption
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
	 * @param key
	 * @return String
	 */
	
	public static String getDistributionChannelDesc(String key) {
		return (String)distributionChannelMap.get(key);
	}
	/**
	 *  Returns proposal type descrption
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
	 * @param key
	 * @return String
	 */
	
	public static String getDivisionCodeDesc(String key) {
		return (String)divisionCodeMap.get(key);
	}
	/**
	 *  Returns proposal type descrption
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
	 * @param key
	 * @return String
	 */
	
	public static String getPaymentTermDesc(String key) {
		return (String)paymentTermMap.get(key);
	}
	/**
	 *  Returns proposal type descrption
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
	 * @param key
	 * @return String
	 */
	
	public static String getRoleDesc(String key) {
		return (String)roleMap.get(key);
	}
	/**
	 *  Returns proposal type descrption
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
	 * @param key
	 * @return String
	 */
	
	public static String getProposalContentDesc(String key) {
		return (String)sAndSMap.get(key);
	}
	
	
	
	/**
	 *  Returns modification type descrption
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 16, 2006
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param key
	 * @return String
	 */
	
	public static String getModificationTypeDescription(String key) {
		return (String)modificationTypeMap.get(key);
	}
	
	/**
	 *  Returns coverage type descrption
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 16, 2006 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param key
	 * @return String
	 */
	
	public static String getCoverageTypeDescription(String key) {
		return (String)coverageTypeMap.get(key);
	}
	
	
	/**
	 *  Returns form short and long descrption
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 16, 2006 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param key
	 * @return String
	 */
	
	public static String getFormDescription(String key) {
		return (String)formNumberMap.get(key);
	}
	
	
	/**
	 *  Returns base agreement status description
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 16, 2006
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param key
	 * @return String
	 */
	
	public static String getStatusDescription(String key) {
		return (String)baseAgreementStatusMap.get(key);
	}
	/**
	 *  Returns rol options
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 16, 2006
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param key
	 * @return String
	 */
	
	public static String getRolOptions(String key) {
		return (String)rolOptionsMap.get(key);
	}
	
	
	/**
	 *  Returns user type description
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 16, 2006
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param key
	 * @return String
	 */
	
	public static String getUserTypeDesc(String key) {
		return (String)userTypeMap.get(key);
	}
	
	/**
	 *  Returns Base agreement role description
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jun 16, 2006
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param key
	 * @return String
	 */
	
	public static String getBARoleDesc(String key) {
		return (String)baRoleMap.get(key);
	}
	
	/**
	 * @return Returns the complexTypesMap.
	 */
	public static Map getComplexTypesMap() {
		return ComplexTypesMap;
	}
	/**
	 * @param complexTypesMap The complexTypesMap to set.
	 */
	public static void setComplexTypesMap(Map complexTypesMap) {
		ComplexTypesMap = complexTypesMap;
	}
//added by Nomita
	public static String getOperationDesc(String key) {
		return (String)operationMap.get(key);

	}
	//added by Nomita
	//added by Manoj
	public static String getCpsSalesorg(String key) {
		return (String)cpsSalesorg.get(key);
	}
}
