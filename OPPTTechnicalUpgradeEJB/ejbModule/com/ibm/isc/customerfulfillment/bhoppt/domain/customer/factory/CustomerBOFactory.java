/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.domain.customer.factory;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo.CustomerBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.customer.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;


/** 
 * This factory class returns CustomerBO objects
 * based on the arguments it returns Collection of BO or single BO
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 24, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar J
 * @version 5.1A 
 */


public class CustomerBOFactory
{
	/**CUSTOMER_TABLE 
     */
    public static final int CUSTOMER_TABLE = 1;
    /**HISTORY_CUSTOMER_TABLE 
     */
	public static final int HISTORY_CUSTOMER_TABLE =2;
	/**CUSTOMER_HOME
     */
	private static final String CUSTOMER_HOME = "CustomerLocalHome";
	/**HISTORY_CUSTOMER_HOME 
     */
	private static final String HISTORY_CUSTOMER_HOME = "HistoryCustomerLocalHome";
	/**CLASS_NAME
     */
	private static final String CLASS_NAME="CustomerBOFactory";

	/**
     *  findCustomerBOforProposal
     * Find the CustomerBO based on the Proposal id as a input
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 1, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param proposalId
     * @return
     * @param table
     * @throws com.ibm.support.oppt.projectutilities.exception.DomainException 
     */
	public List findCustomerBOforProposal(int proposalId, int table) throws DomainException
	{
		CustomerLocalHome customerLocalHome = null;
		CustomerLocal customerLocal = null;
		Collection customerLocalList = null;
		List customerBOList = null;
		if (table != 0 && table==CUSTOMER_TABLE)
		{
			customerLocalHome = getCustomerLocalHome();

			try
			{
				customerLocalList = customerLocalHome.findByProposal(proposalId);
				
			}
			catch (FinderException e)
			{
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"findCustomerBOforProposal",null,e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			
			customerBOList = new ArrayList();
			Iterator iterator = customerLocalList.iterator();
			while (iterator.hasNext())
			{
				customerLocal = (CustomerLocal) iterator.next();
				customerBOList.add(getCustomerBOForLocal(customerLocal));
			}
		}
		return customerBOList;
	}

	/**
	 *  getCustomerBO
	 * This factory method gets the Customer Business Object 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalId
	 * @param customerId
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	public CustomerBO getCustomerBO(int proposalId, int customerId, int table) throws DomainException
	{
		CustomerLocalHome customerLocalHome = null;
		CustomerLocal customerLocal = null;
		CustomerBO customerBO = null;
		HistoryCustomerLocal historyCustomerLocal=null;
		HistoryCustomerLocalHome historyCustomerLocalHome=null;
		
		if (table != 0 && table==CUSTOMER_TABLE)
		{
			customerLocalHome = getCustomerLocalHome();
			CustomerKey customerKey = new CustomerKey(proposalId, customerId);
			try
			{
				customerLocal = customerLocalHome.findByPrimaryKey(customerKey);
				customerBO = getCustomerBOForLocal(customerLocal);
			}
			catch (FinderException e)
			{
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"getCustomerBO",null,e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
		}else if (table != 0 && table==HISTORY_CUSTOMER_TABLE)
		{
			historyCustomerLocalHome = getHistoryCustomerLocalHome();
			HistoryCustomerKey customerKey = new HistoryCustomerKey(customerId,proposalId);
			try
			{
				historyCustomerLocal = historyCustomerLocalHome.findByPrimaryKey(customerKey);
				customerBO = getCustomerBOForLocal(historyCustomerLocal);
			}
			catch (FinderException e)
			{
				//OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"getCustomerBO",null,e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
		}
	 return customerBO;
	}

	/**
	 *  
	 * This method populates the CustomerBO from Local Object 
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
	 * @param customerLocal
	 * @return CustomerBO
	 */
	private CustomerBO getCustomerBOForLocal(CustomerLocal customerLocal)
	{
		CustomerBO customerBO = new CustomerBO();
		customerBO.setCustomerId(customerLocal.getCustomerId());
		customerBO.setProposalId(customerLocal.getProposalId());
		customerBO.setBillToPartyASNo(OPPTHelper.trimStringToNull(customerLocal.getBillToPartyASNo()));
		customerBO.setBillToPartyLNo(OPPTHelper.trimStringToNull(customerLocal.getBillToPartyLNo()));
		customerBO.setBillToPartyName(OPPTHelper.trimStringToNull(customerLocal.getBillToPartyName()));
		customerBO.setBillToPartyNo(OPPTHelper.trimStringToNull(customerLocal.getBillToPartyNo()));
		customerBO.setCustmerASNo(OPPTHelper.trimStringToNull(customerLocal.getCustomerASNo()));
		customerBO.setCustomerListNo(OPPTHelper.trimStringToNull(customerLocal.getCustomerListNo()));
		customerBO.setLastUpdatedDate(customerLocal.getLastUpdatedDate());
		customerBO.setLegacyCustomerNo(OPPTHelper.trimStringToNull(customerLocal.getLegacyCustomerNo()));
		customerBO.setPayerASNo(OPPTHelper.trimStringToNull(customerLocal.getPayerASNo()));
		customerBO.setPayerNo(OPPTHelper.trimStringToNull(customerLocal.getPayerNo()));
		customerBO.setPayerName(OPPTHelper.trimStringToNull(customerLocal.getPayerName()));
		customerBO.setPayerLNo(OPPTHelper.trimStringToNull(customerLocal.getPayerLNo()));
		customerBO.setPlanStartDate(customerLocal.getPlanStartDate());
		customerBO.setPlanEndDate(customerLocal.getPlanEndDate());
		customerBO.setSapCustomerName(OPPTHelper.trimStringToNull(customerLocal.getSapCustomerName()));
		customerBO.setSapCustomerNo(OPPTHelper.trimStringToNull(customerLocal.getSapCustomerNo()));
		customerBO.setShipToPartyASNo(OPPTHelper.trimStringToNull(customerLocal.getShipToPartyASNo()));
		customerBO.setShipToPartyLNo(OPPTHelper.trimStringToNull(customerLocal.getShipToPartyLNo()));
		customerBO.setShipToPartyName(OPPTHelper.trimStringToNull(customerLocal.getShipToPartyName()));
		customerBO.setShipToPartyNo(OPPTHelper.trimStringToNull(customerLocal.getShipToPartyNo()));
		customerBO.setCountryCode(OPPTHelper.trimStringToNull(customerLocal.getCountryCode())); /* Changed for EF0607044559	by Sara on June 16,2004 */
		//DADO02&DADO09  BlueHarmony Sateesh
		
		return customerBO;
	}
	
	/**
		 *  
		 * This method populates the CustomerBO from Local Object 
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
		 * @param customerLocal
		 * @return CustomerBO
		 */
		private CustomerBO getCustomerBOForLocal(HistoryCustomerLocal customerLocal)
		{
			CustomerBO customerBO = new CustomerBO();

			customerBO.setCustomerId(customerLocal.getCustomerId());
			customerBO.setProposalId(customerLocal.getProposalId());
			customerBO.setBillToPartyASNo(OPPTHelper.trimStringToNull(customerLocal.getBillToPartyASNo()));
			customerBO.setBillToPartyLNo(OPPTHelper.trimStringToNull(customerLocal.getBillToPartyLNo()));
			customerBO.setBillToPartyName(OPPTHelper.trimStringToNull(customerLocal.getBillToPartyName()));
			customerBO.setBillToPartyNo(OPPTHelper.trimStringToNull(customerLocal.getBillToPartyNo()));
			customerBO.setCustmerASNo(OPPTHelper.trimStringToNull(customerLocal.getCustomerASNo()));
			customerBO.setCustomerListNo(OPPTHelper.trimStringToNull(customerLocal.getCustomerListNo()));
			customerBO.setLastUpdatedDate(customerLocal.getLastUpdatedDate());
			customerBO.setLegacyCustomerNo(OPPTHelper.trimStringToNull(customerLocal.getLegacyCustomerNo()));
			customerBO.setPayerASNo(OPPTHelper.trimStringToNull(customerLocal.getPayerASNo()));
			customerBO.setPayerNo(OPPTHelper.trimStringToNull(customerLocal.getPayerNo()));
			customerBO.setPayerName(OPPTHelper.trimStringToNull(customerLocal.getPayerName()));
			customerBO.setPayerNo(OPPTHelper.trimStringToNull(customerLocal.getPayerNo()));
			customerBO.setPlanStartDate(customerLocal.getPlanStartDate());
			customerBO.setPlanEndDate(customerLocal.getPlanEndDate());
			customerBO.setSapCustomerName(OPPTHelper.trimStringToNull(customerLocal.getSapCustomerName()));
			customerBO.setSapCustomerNo(OPPTHelper.trimStringToNull(customerLocal.getSapCustomerNo()));
			customerBO.setShipToPartyASNo(OPPTHelper.trimStringToNull(customerLocal.getShipToPartyASNo()));
			customerBO.setShipToPartyLNo(OPPTHelper.trimStringToNull(customerLocal.getShipToPartyLNo()));
			customerBO.setShipToPartyName(OPPTHelper.trimStringToNull(customerLocal.getShipToPartyName()));
			customerBO.setShipToPartyNo(OPPTHelper.trimStringToNull(customerLocal.getShipToPartyNo()));
			customerBO.setPayerNo(OPPTHelper.trimStringToNull(customerLocal.getPayerNo()));
			
			return customerBO;
		}


	/**
	 *  createCustomerBO
	 * This method stores the Customer data in Customer table 
	 * Based on the table argument it stores the Customer or HistoryCustomer table. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 1, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerBO
	 * @param table
	 * @throws DomainException
	 */
	public void createCustomerBO(CustomerBO customerBO, int table) throws DomainException
	{
		
		CustomerLocalHome customerLocalHome = null;
		CustomerLocal customerLocal = null;
		HistoryCustomerLocalHome historyCustomerLocalHome = null;
		HistoryCustomerLocal historyCustomerLocal = null;

		if (table==CUSTOMER_TABLE)
		{
			try
			{				    
				/* CR6153 start change... 2 new params customerBO.getPlanStartDate(), customerBO.getPlanEndDate() added */
				customerLocal =HomeProvider.getCustomerLocal(customerBO.getProposalId(),customerBO.getCustomerId(),customerBO.getSapCustomerNo(),customerBO.getPlanStartDate(), customerBO.getPlanEndDate());
				  
				/* CR6153 end change */
				}
			catch (CreateException c)
			{
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"createCustomerBO",null,c);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			populateLocalWithCustomerBO(customerLocal, customerBO);
		}
		else if (table==HISTORY_CUSTOMER_TABLE)
		{
			try
			{
				historyCustomerLocal =HomeProvider.getHistoryCustomerLocal(customerBO.getCustomerId(), customerBO.getProposalId());
			}
			catch (CreateException c)
			{
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"createCustomerBO",null,c);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			populateLocalWithCustomerBO(historyCustomerLocal, customerBO);
		}
	}

	/**
	 *  
	 * This method populates the history local object from BO 
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
	 * @param historyCustomerLocal
	 * @param customerBO
	 */
	private void populateLocalWithCustomerBO(HistoryCustomerLocal historyCustomerLocal, CustomerBO customerBO)
	{
		historyCustomerLocal.setBillToPartyASNo(OPPTHelper.trimStringToNull(customerBO.getBillToPartyASNo()));
		historyCustomerLocal.setBillToPartyLNo(OPPTHelper.trimStringToNull(customerBO.getBillToPartyLNo()));
		historyCustomerLocal.setBillToPartyName(OPPTHelper.trimStringToNull(customerBO.getBillToPartyName()));
		historyCustomerLocal.setBillToPartyNo(OPPTHelper.trimStringToNull(customerBO.getBillToPartyNo()));
		historyCustomerLocal.setCustomerASNo(OPPTHelper.trimStringToNull(customerBO.getCustmerASNo()));
		historyCustomerLocal.setCustomerListNo(OPPTHelper.trimStringToNull(customerBO.getCustomerListNo()));
		historyCustomerLocal.setLastUpdatedDate(customerBO.getLastUpdatedDate());
		historyCustomerLocal.setLegacyCustomerNo(OPPTHelper.trimStringToNull(customerBO.getLegacyCustomerNo()));
		historyCustomerLocal.setPayerASNo(OPPTHelper.trimStringToNull(customerBO.getPayerASNo()));
		historyCustomerLocal.setPayerNo(OPPTHelper.trimStringToNull(customerBO.getPayerNo()));
		historyCustomerLocal.setPayerName(OPPTHelper.trimStringToNull(customerBO.getPayerName()));
		historyCustomerLocal.setPayerNo(OPPTHelper.trimStringToNull(customerBO.getPayerNo()));
		historyCustomerLocal.setPlanEndDate(customerBO.getPlanEndDate());
		historyCustomerLocal.setSapCustomerName(OPPTHelper.trimStringToNull(customerBO.getSapCustomerName()));
		historyCustomerLocal.setSapCustomerNo(OPPTHelper.trimStringToNull(customerBO.getSapCustomerNo()));
		historyCustomerLocal.setShipToPartyASNo(OPPTHelper.trimStringToNull(customerBO.getShipToPartyASNo()));
		historyCustomerLocal.setShipToPartyLNo(OPPTHelper.trimStringToNull(customerBO.getShipToPartyLNo()));
		historyCustomerLocal.setShipToPartyName(OPPTHelper.trimStringToNull(customerBO.getShipToPartyName()));
		historyCustomerLocal.setShipToPartyNo(OPPTHelper.trimStringToNull(customerBO.getShipToPartyNo()));
	}

	/**
	 *  
	 * This method populates the customer local object from BO 
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
	 * @param customerLocal
	 * @param customerBO
	 */
	private void populateLocalWithCustomerBO(CustomerLocal customerLocal, CustomerBO customerBO)
	{
		customerLocal.setBillToPartyASNo(customerBO.getBillToPartyASNo());
		customerLocal.setBillToPartyLNo(customerBO.getBillToPartyLNo());
		customerLocal.setBillToPartyName(customerBO.getBillToPartyName());
		customerLocal.setBillToPartyNo(customerBO.getBillToPartyNo());
		customerLocal.setCustomerASNo(customerBO.getCustmerASNo());
		//DADO02 customerLocal.setCustomerListNo(customerBO.getCustomerListNo());
		customerLocal.setLastUpdatedDate(customerBO.getLastUpdatedDate());
		//DADO02 customerLocal.setLegacyCustomerNo(customerBO.getLegacyCustomerNo());
		customerLocal.setPayerASNo(customerBO.getPayerASNo());
		customerLocal.setPayerNo(customerBO.getPayerNo());
		customerLocal.setPayerName(customerBO.getPayerName());
		customerLocal.setPayerLNo(customerBO.getPayerLNo());
		//customerLocal.setPlanStartDate(customerBO.getPlanStartDate());
		//customerLocal.setPlanEndDate(customerBO.getPlanEndDate());
		customerLocal.setSapCustomerName(customerBO.getSapCustomerName());
		customerLocal.setSapCustomerNo(customerBO.getSapCustomerNo());
		customerLocal.setShipToPartyASNo(customerBO.getShipToPartyASNo());
		customerLocal.setShipToPartyLNo(customerBO.getShipToPartyLNo());
		customerLocal.setShipToPartyName(customerBO.getShipToPartyName());
		customerLocal.setShipToPartyNo(customerBO.getShipToPartyNo());
		//DADO02customerLocal.setCountryCode(customerBO.getCountryCode()); /* Changed for EF0607044559	by Sara on June 16,2004 */
		
	}

	/**
	 *  
	 * This method updates the customer data 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerBO
	 * @param table
	 * @throws DomainException
	 */
	public void updateCustomerBO(CustomerBO customerBO, int table) throws DomainException
	{
		CustomerLocalHome customerLocalHome = null;
		CustomerLocal customerLocal = null;
		CustomerKey customerKey = null;
		if (table != 0 && table==CUSTOMER_TABLE)
		{
			customerLocalHome = getCustomerLocalHome();
			customerKey = new CustomerKey(customerBO.getProposalId(), customerBO.getCustomerId());
			try
			{			
				customerLocal = customerLocalHome.findByPrimaryKey(customerKey);
			}
			catch (FinderException e)
			{
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"updateCustomerBO",null,e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			populateLocalWithCustomerBO(customerLocal, customerBO);
		}
	}

	/**
	 *  
	 * This method deltes the Customer BO 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customerBO
	 * @param table
	 * @throws DomainException
	 */
	public void deleteCustomerBO(CustomerBO customerBO,int table)throws DomainException{
		CustomerLocalHome customerLocalHome = null;
		CustomerLocal customerLocal = null;
		CustomerKey customerKey = null;
			if (table != 0 && table==CUSTOMER_TABLE){
				
					customerLocalHome = getCustomerLocalHome();
					customerKey = new CustomerKey(customerBO.getProposalId(), customerBO.getCustomerId());
					try{
						customerLocalHome.remove(customerKey);
					}catch (RemoveException e){
						OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"updateCustomerBO",null,e);
						throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
					}
			}
	
	}
	/**
	 *  
	 * This method returns the max customer id 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 * @throws DomainException
	 */	
	public CustomerBO findMaxCustomerBO() throws DomainException
	{
		CustomerLocalHome customerLocalHome = getCustomerLocalHome();
		CustomerLocal customerLocal = null;
		CustomerBO customerBO = null;

		try
		{
			Collection customerCollection = customerLocalHome.findMaxCustomerId();
			Iterator iterateCustomer = customerCollection.iterator();

			while (iterateCustomer.hasNext())
			{
				customerLocal = (CustomerLocal) iterateCustomer.next();
			}
             
			customerBO = getCustomerBOForLocal(customerLocal);
			
		}
		catch (FinderException ex)
		{
			customerBO=new CustomerBO();
			customerBO.setCustomerId(0);
			//OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"findMaxCustomerBO",null,ex);
			//throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		return customerBO;
	}
	
	/**
	 *  
	 * This method finds the Customer for customer list and proposal 
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
	 * @param customerListNo
	 * @param proposalId
	 * @return
	 * @throws DomainException
	 */
	public List findCustomerBOForCustomerListAndProposal(String customerListNo, int proposalId) throws DomainException {
		
		CustomerLocal customerLocal = null;
		CustomerLocalHome customerLocalHome = getCustomerLocalHome();
		List boList = new ArrayList();
		try
		{
			// DADO02 Collection customerCollection = customerLocalHome.findByProposalAndCustomerList(proposalId, customerListNo);
			Collection customerCollection = customerLocalHome.findByProposal(proposalId);
			//end of DADO02 
			Iterator iterateCustomer = customerCollection.iterator();

			while (iterateCustomer.hasNext())
			{
				customerLocal = (CustomerLocal) iterateCustomer.next();
				CustomerBO customerBO = getCustomerBOForLocal(customerLocal);
				boList.add(customerBO);
			}

			
		}
		catch (FinderException ex)
		{
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"findCustomerBOForCustomerListAndProposal",null,ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		return boList;
		
	}
	
	/**
	 *  
	 * This method returns Customer Local home 
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
	 * @return
	 */
	private CustomerLocalHome getCustomerLocalHome()
	{
		return (CustomerLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(CUSTOMER_HOME);
	}

	/**
	 *  
	 * This method returns History Customer Local Home 
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
	 * @return
	 */
	private HistoryCustomerLocalHome getHistoryCustomerLocalHome()
	{
		return (HistoryCustomerLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(HISTORY_CUSTOMER_HOME);
	}
	
	/**
	 * isCustomerAvailableForProposal
     * @param proposalId
     * @param sapCustomerNo
     * @return
     */
    public boolean isCustomerAvailableForProposal(int proposalId,String sapCustomerNo) {
		boolean result = true;
		CustomerLocalHome customerLocalHome = getCustomerLocalHome();
		try{
		 customerLocalHome.findBySapCustNo(proposalId,sapCustomerNo);
			
		}catch(FinderException fe) {
			result= false;
		}catch(Exception e) {
			result= false;
		}
		return result;
	}
    
    /**
	 * isCustomerAvailableForProposalAndPlanStartDate
     * @param proposalId
     * @param sapCustomerNo
     * @param planStartDate
     * @return
     */
    /* CR6153 start change */
    public boolean isCustomerAvailableForProposalPlanStartEndDate(int proposalId,String sapCustomerNo,Date planStartDate, Date planEndDate ) {
    	
		boolean result = true;
		CustomerLocalHome customerLocalHome = getCustomerLocalHome();
		try{
			customerLocalHome.findBySapCustNoAndPlanStartEndDate(proposalId,sapCustomerNo,planStartDate,planEndDate);
		}catch(FinderException fe) {
			result= false;
		}catch(Exception e) {
			result= false;
		}
		
		return result;
	}
    /* CR6153 end change */
    
	/* Changed for EF0607044559S by Sara on June 16,2004 */
	/**
	 * findSTPForProposal
     * @param proposalId
     * @param sapCustomerNo
     * @throws com.ibm.support.oppt.projectutilities.exception.DomainException
     * @return
     */
    public CustomerBO findSTPForProposal(int proposalId,String sapCustomerNo) throws DomainException {
		CustomerBO customerBO = new CustomerBO();
		CustomerLocal customerLocal = null;
		
		CustomerLocalHome customerLocalHome = getCustomerLocalHome();
		try{
			customerLocal = customerLocalHome.findBySapCustNo(proposalId,sapCustomerNo);
			customerBO = getCustomerBOForLocal(customerLocal);
		}catch(FinderException fe) {
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"findSTPForProposal",null,fe);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}catch(Exception e) {
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"findSTPForProposal",null,e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		return customerBO;
	}
	/* EF0607044559E */	
    
    /* CR6153 start change */
    public CustomerBO findSTPForProposalPlanStartEndDate(int proposalId,String sapCustomerNo,Date planStartDate, Date planEndDate) throws DomainException {
		CustomerBO customerBO = new CustomerBO();
		CustomerLocal customerLocal = null;
		
		CustomerLocalHome customerLocalHome = getCustomerLocalHome();
		
		try{
			customerLocal = customerLocalHome.findBySapCustNoAndPlanStartEndDate(proposalId,sapCustomerNo,planStartDate, planEndDate);
			customerBO = getCustomerBOForLocal(customerLocal);
		}catch(FinderException fe) {
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"findSTPForProposal",null,fe);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}catch(Exception e) {
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"findSTPForProposal",null,e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		return customerBO;
	}
    
    public List findCustomerBOForProposalStartEndDate(int proposalId,Date planStartDate, Date planEndDate) throws DomainException {
		
		CustomerLocal customerLocal = null;
		CustomerLocalHome customerLocalHome = getCustomerLocalHome();
		List boList = new ArrayList();
		try
		{
			Collection customerCollection = customerLocalHome.findByProposalStartEndDate(proposalId, planStartDate, planEndDate);
			if(customerCollection != null){
				Iterator iterateCustomer = customerCollection.iterator();

				while (iterateCustomer.hasNext())
				{
					customerLocal = (CustomerLocal) iterateCustomer.next();
					CustomerBO customerBO = getCustomerBOForLocal(customerLocal);
					boList.add(customerBO);
				}

			}
			
		}
		catch (FinderException ex)
		{
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"findCustomerBOForCustomerListAndProposal",null,ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		return boList;
		
	}
    /* CR6153 end change */
}
