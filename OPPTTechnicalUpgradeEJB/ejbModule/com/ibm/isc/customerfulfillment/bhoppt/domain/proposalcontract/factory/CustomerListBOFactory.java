/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.CustomerListBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListKey;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.CustomerListLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;


/** 
 *  
 * This class is to Create, Update, Remove and Find CustomerList entities. 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 22, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */


public class CustomerListBOFactory {
	
	private static final String CLASS_NAME="CustomerListBOFactory";
	private static final String CUSTOMER_LIST_LOCAL_HOME = "CustomerListLocalHome";

	/**
	 * @param customerListBO
	 * @throws DomainException
	 */
	public void createCustomerListBO(CustomerListBO customerListBO) throws DomainException {
		CustomerListLocalHome customerListLocalHome = getCustomerListLocalHome();

		CustomerListLocal customerListLocal = null;
		try {
			OPPTLogger.debug("Creating Customer list : "+customerListBO.getCustomerListNo()+" For proposal : "+customerListBO.getProposalId(),"CustomerListBOFactory","createCustomerListBO");
			customerListLocal = customerListLocalHome.create(customerListBO.getProposalId(), customerListBO.getCustomerListNo());
		} catch (CreateException e) {
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.SE0801);
		}

		customerListLocal.setCustomerListName(customerListBO.getCustomerListDesc());
		customerListLocal.setLastUpdatedDate(customerListBO.getLastUpdatedDate());
	}


	/**
	 * @param proposalID
	 * @return
	 * @throws DomainException
	 */
	public List findCustomerListBOForProposal(int proposalID) throws DomainException {
		CustomerListLocalHome localHome = getCustomerListLocalHome();
		List list = new ArrayList();
              		try {
			Collection collection = localHome.findByProposalId(proposalID);

			if (collection != null) {
				Iterator iter = collection.iterator();
				CustomerListLocal customerListLocal;

				while (iter.hasNext()) {
					customerListLocal = (CustomerListLocal) iter.next();
					list.add(getCustomerListBO(customerListLocal));
				}
			}
		} catch (FinderException e) {			
			// This exception would need to be discarded, if No CustomerList is found for the Proposal
			// It can be a valid business scenerio			
		}
		return list;
	}

	/** 
	 * To populate the customer list from the customer list local
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param local
	 * @return CustomerListBO
	 */
	private CustomerListBO getCustomerListBO(CustomerListLocal customerLocal) {
		CustomerListBO customerListBO = new CustomerListBO();
		CustomerListKey key = (CustomerListKey) customerLocal.getPrimaryKey();

		customerListBO.setProposalId(key.proposalId);
		customerListBO.setCustomerListNo(OPPTHelper.trimString(key.customerListNo));
		customerListBO.setCustomerListDesc(customerLocal.getCustomerListName());

		return customerListBO;
	}

	/** 
	 * To get the customer list local home
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return CustomerListLocalHome
	 */
	private CustomerListLocalHome getCustomerListLocalHome() {
		return (CustomerListLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(CUSTOMER_LIST_LOCAL_HOME);
	}

	/**
	 * @param customerListBO
	 * @throws DomainException
	 */
	public void deleteCustomerListBO(CustomerListBO customerListBO) throws DomainException {
		CustomerListLocalHome customerListLocalHome = getCustomerListLocalHome();
		CustomerListKey key = new CustomerListKey(customerListBO.getProposalId(), customerListBO.getCustomerListNo());
		try {
			customerListLocalHome.remove(key);
		} catch (EJBException e1) {
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.SE0801);
		} catch (RemoveException e1) {
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.SE0801);
		}
	}
}
