/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BillingBlockBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BillingTypeBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ComplexTypesBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.CurrencyBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.DistrChannelBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.DivisionBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.PaymentTermBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.SalesOrgBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ValidCombinationBDO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.SystemUpdateDAO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTStaticDataHolder;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
/** 
 * This is the Factory class to updates the Static tables 
 * Sales Org, Currency, Payment Term, Billing Type and Billing Block
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 29, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A 
 */
public class SystemUpdateFactory
{

	/** 
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 29, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public SystemUpdateFactory()
	{

	}

	/**
	 * This method is used to   
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *	  
	 * 
	 * @return 
	 * @throws 
	 */

	public void updateSalesOrg(List salesOrgList, List salesAreaList, List divisionList, List dstrChannelList)
		throws DomainException
	{
		//		SystemUpdateDAO.removeAllSalesArea();
		//		SystemUpdateDAO.removeAllSalesOrg();
		//		SystemUpdateDAO.removeAllDstrChannel();
		//		SystemUpdateDAO.removeAllDivision();	

		HashMap salesOrgMap = new HashMap();
		HashMap distributionChannelMap = new HashMap();
		HashMap divisionMap = new HashMap();

		SalesOrgBDO salesOrgBDO = new SalesOrgBDO();
		Iterator iter = salesOrgList.iterator();
		while (iter.hasNext())
		{
			salesOrgBDO = (SalesOrgBDO) iter.next();
			SystemUpdateDAO.updateSalesOrg(
				salesOrgBDO.getSalesOrg(),
				salesOrgBDO.getSalesOrgDesc(),
				salesOrgBDO.getDefaultCurrncy());
			salesOrgMap.put(salesOrgBDO.getSalesOrg(), salesOrgBDO.getSalesOrgDesc());
		}

		DistrChannelBDO distrChannelBDO = new DistrChannelBDO();
		iter = dstrChannelList.iterator();
		while (iter.hasNext())
		{
			distrChannelBDO = (DistrChannelBDO) iter.next();
			//Commented by Ramesh For distribution Channel Requirement
			/*SystemUpdateDAO.updateDstrChannel(
				distrChannelBDO.getDistrChannel(),
				distrChannelBDO.getDistrDescription());
			distributionChannelMap.put(distrChannelBDO.getDistrChannel(), distrChannelBDO.getDistrDescription());
			*/
		}

		DivisionBDO divisionBDO = new DivisionBDO();
		iter = divisionList.iterator();
		while (iter.hasNext())
		{
			divisionBDO = (DivisionBDO) iter.next();
			SystemUpdateDAO.updateDivision(divisionBDO.getDivisionCode(), divisionBDO.getDivisionDesc());
			divisionMap.put(divisionBDO.getDivisionCode(), divisionBDO.getDivisionDesc());
		}

		ValidCombinationBDO validCombinationBDO = new ValidCombinationBDO();
		iter = salesAreaList.iterator();
		while (iter.hasNext())
		{
			validCombinationBDO = (ValidCombinationBDO) iter.next();
			SystemUpdateDAO.updateSalesArea(
				validCombinationBDO.getSalerOrg(),
				validCombinationBDO.getDistributionChannel(),
				validCombinationBDO.getDivisionCode());
		}

		OPPTStaticDataHolder.divisionCodeMap = divisionMap;
		OPPTStaticDataHolder.distributionChannelMap = distributionChannelMap;
		OPPTStaticDataHolder.salesOrgMap = salesOrgMap;
	}

	/**
	 * This method is used to   
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *	  
	 * 
	 * @return 
	 * @throws 
	 */
	public void updateCurrency(List currencyList) throws DomainException
	{
		//		SystemUpdateDAO.removeAllCurrency();
		CurrencyBDO currencyBDO = new CurrencyBDO();
		Iterator iter = currencyList.iterator();
		HashMap currencyMap = new HashMap();
		while (iter.hasNext())
		{
			currencyBDO = (CurrencyBDO) iter.next();
			SystemUpdateDAO.updateCurrency(
				currencyBDO.getCurrencyCode(),
				currencyBDO.getCurrencyName(),
				currencyBDO.getDecimalAllowed());
			currencyMap.put(currencyBDO.getCurrencyCode(), currencyBDO.getCurrencyName());
		}
		OPPTStaticDataHolder.currencyMap = currencyMap;
	}

	/**
	 * This method is used to   
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *	  
	 * 
	 * @return 
	 * @throws 
	 */
	public void updatePaymentTerm(List paymentTermList) throws DomainException
	{
		//		SystemUpdateDAO.removeAllPaymentTerm();	
		PaymentTermBDO paymentTermBDO = new PaymentTermBDO();
		Iterator iter = paymentTermList.iterator();
		/*
		 * Once the system is updated we should also update the static data so that it gets reflects in all the 
		 * Proposals
		 */

		HashMap paymentTerm = new HashMap();
		while (iter.hasNext())
		{
			paymentTermBDO = (PaymentTermBDO) iter.next();
			SystemUpdateDAO.updatePaymentTerm(paymentTermBDO.getPaymentTerm(), paymentTermBDO.getPaymentDesc());
			paymentTerm.put(paymentTermBDO.getPaymentTerm(), paymentTermBDO.getPaymentDesc());
		}
		OPPTStaticDataHolder.paymentTermMap = paymentTerm;
	}

	/**
	 * This method is used to   
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *	  
	 * 
	 * @return 
	 * @throws 
	 */
	public void updateBillingType(List billingTypeList) throws DomainException
	{
		//		SystemUpdateDAO.removeAllBillingType();
		BillingTypeBDO billingTypeBDO = new BillingTypeBDO();
		Iterator iter = billingTypeList.iterator();
		HashMap billingTypeMap = new HashMap();
		while (iter.hasNext())
		{
			billingTypeBDO = (BillingTypeBDO) iter.next();
			SystemUpdateDAO.updateBillingType(
				billingTypeBDO.getBillingType(),
				billingTypeBDO.getBillingTypeDesc());
			billingTypeMap.put(billingTypeBDO.getBillingType(), billingTypeBDO.getBillingTypeDesc());
		}
		OPPTStaticDataHolder.billingTypeMap = billingTypeMap;
	}
	/**
	 * This method is used to   
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 28, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 *	  
	 * 
	 * @return 
	 * @throws 
	 */
	public void updateBillingBlock(List billingBlockList) throws DomainException
	{
		//		SystemUpdateDAO.removeAllBillingBlock();
		BillingBlockBDO billingBlockBDO = new BillingBlockBDO();
		Iterator iter = billingBlockList.iterator();
		HashMap billingBlockMap = new HashMap();
		while (iter.hasNext())
		{
			billingBlockBDO = (BillingBlockBDO) iter.next();
			SystemUpdateDAO.updateBillingBlock(
				billingBlockBDO.getBillingBlock(),
				billingBlockBDO.getBillingBlockDesc());
			billingBlockMap.put(billingBlockBDO.getBillingBlock(), billingBlockBDO.getBillingBlockDesc());
		}
		OPPTStaticDataHolder.billingBlockMap = billingBlockMap;
	}
	
	
//	Added by Srinivas-------OPPTBH-DAD003
	public void updateComplexTypes(List complexTypeList) throws DomainException
	{
		Iterator iter = complexTypeList.iterator();
		ComplexTypesBDO complexTypesBDO = new ComplexTypesBDO();
		HashMap complexTypesMap = new HashMap();
		
		while(iter.hasNext())
		{
			complexTypesBDO = (ComplexTypesBDO)iter.next();
			SystemUpdateDAO.updateComplexTypes(complexTypesBDO.getBLBIndicatorType(),complexTypesBDO.getBLBIndicatorDesc());
			complexTypesMap.put(complexTypesBDO.getBLBIndicatorType(),complexTypesBDO.getBLBIndicatorDesc());
			
		}
			OPPTStaticDataHolder.ComplexTypesMap =complexTypesMap;
		
	}
}
