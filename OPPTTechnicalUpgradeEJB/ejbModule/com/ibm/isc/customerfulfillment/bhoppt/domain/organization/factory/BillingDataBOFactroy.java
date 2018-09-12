/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.FinderException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BillingBlockBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BillingDataBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BillingFrequencyBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BillingTypeBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.PaymentTermBDO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingBlockLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingFrequencyLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingTypeLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BillingTypeLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
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
public class BillingDataBOFactroy
{
	private static final String EXCEPTION = "EXCEPTION";
	private static final String CLASS_NAME = "BillingDataBOFactroy";

	public BillingDataBO getBillingDataBO() throws DomainException
	{
		String methodName = "getBillingDataBO";

		BillingDataBO bo = new BillingDataBO();

		PaymentTermLocalHome paymentTermLocalHome =
			(PaymentTermLocalHome) HomeProvider.getLocal(HomeProvider.PAYMENT_TERM_LOCAL_HOME);
		Collection collection;
		try
		{
			collection = paymentTermLocalHome.findAllPaymentTerm();
		}
		catch (FinderException e)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		Iterator iter = collection.iterator();
		PaymentTermLocal paymentTermLocal;
		PaymentTermBDO paymentTermBDO;
		List paymentTermList = new ArrayList();

		while (iter.hasNext())
		{
			paymentTermBDO = new PaymentTermBDO();
			paymentTermLocal = (PaymentTermLocal) iter.next();
			paymentTermBDO.setPaymentTerm(OPPTHelper.trimString(paymentTermLocal.getPaymentTerm()));
			paymentTermBDO.setPaymentDesc(OPPTHelper.trimString(paymentTermLocal.getPaymentTermDesc()));
			paymentTermList.add(paymentTermBDO);
		}

		bo.setPaymentTermList(paymentTermList);

		BillingTypeLocalHome billingTypeLocalHome =
			(BillingTypeLocalHome) HomeProvider.getLocal(HomeProvider.BILLING_TYPE_LOCAL_HOME);
		try
		{
			collection = billingTypeLocalHome.findAllBillingType();
		}
		catch (FinderException e)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		iter = collection.iterator();
		BillingTypeLocal billingTypeLocal;
		BillingTypeBDO billingTypeBDO;
		List billingTypeList = new ArrayList();

		while (iter.hasNext())
		{
			billingTypeBDO = new BillingTypeBDO();
			billingTypeLocal = (BillingTypeLocal) iter.next();
			billingTypeBDO.setBillingType(OPPTHelper.trimString(billingTypeLocal.getBillingType()));
			billingTypeBDO.setBillingTypeDesc(OPPTHelper.trimString(billingTypeLocal.getBillingDesc()));
			billingTypeList.add(billingTypeBDO);
		}
		bo.setBillingTypeList(billingTypeList);

		//	//	BillingFrequencyLocalHome billingFrequencyLocalHome = (BillingFrequencyLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome("BillingFrequencyLocalHome");
		//		try {
		//			collection = billingFrequencyLocalHome.findAllBillingFreq();
		//		} catch (FinderException e) {
		//			e.printStackTrace();
		//			throw new DomainException();
		//		}
		//		
		//		iter = collection.iterator();
		//		BillingFrequencyLocal billingFrequencyLocal;
		//		BillingFrequencyBDO billingFrequencyBDO;
		List billingFrequencyList = new ArrayList();

		//		while (iter.hasNext())
		//		{
		//			billingFrequencyBDO = new BillingFrequencyBDO();
		//			billingFrequencyLocal = (BillingFrequencyLocal)iter.next();
		//			billingFrequencyBDO.setBillingFreqCode(billingFrequencyLocal.getBillingFreqCode());
		//			billingFrequencyBDO.setBillingFreqDesc(billingFrequencyLocal.getBillingFreqDescription());
		//			billingFrequencyList.add(billingFrequencyBDO);
		//		}		

		// This is a bypass till billing freq is resolved.		

		BillingFrequencyBDO billingFrequencyBDO = new BillingFrequencyBDO();
		billingFrequencyBDO.setBillingFreqCode("A");
		billingFrequencyBDO.setBillingFreqDesc("ANNUALLY");
		BillingFrequencyBDO billingFrequencyBDO1 = new BillingFrequencyBDO();
		billingFrequencyBDO1.setBillingFreqCode("M");
		billingFrequencyBDO1.setBillingFreqDesc("MONTHLY");
		BillingFrequencyBDO billingFrequencyBDO2 = new BillingFrequencyBDO();
		billingFrequencyBDO2.setBillingFreqCode("S");
		billingFrequencyBDO2.setBillingFreqDesc("SEMIANNUALLY");
		BillingFrequencyBDO billingFrequencyBDO3 = new BillingFrequencyBDO();
		billingFrequencyBDO3.setBillingFreqCode("Q");
		billingFrequencyBDO3.setBillingFreqDesc("QUARTERLY");

		billingFrequencyList.add(billingFrequencyBDO);
		billingFrequencyList.add(billingFrequencyBDO1);
		billingFrequencyList.add(billingFrequencyBDO2);
		billingFrequencyList.add(billingFrequencyBDO3);

		bo.setBillingFreqList(billingFrequencyList);

		BillingBlockLocalHome billingBlockLocalHome =
			(BillingBlockLocalHome) HomeProvider.getLocal(HomeProvider.BILLING_BLOCK_LOCAL_HOME);
		try
		{
			collection = billingBlockLocalHome.findAllBillingBlock();
		}
		catch (FinderException e)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		iter = collection.iterator();
		BillingBlockLocal billingBlockLocal;
		BillingBlockBDO billingBlockBDO;
		List billingBlockList = new ArrayList();

		while (iter.hasNext())
		{
			billingBlockBDO = new BillingBlockBDO();
			billingBlockLocal = (BillingBlockLocal) iter.next();
			billingBlockBDO.setBillingBlock(OPPTHelper.trimString(billingBlockLocal.getBillingBlock()));
			billingBlockBDO.setBillingBlockDesc(
				OPPTHelper.trimString(billingBlockLocal.getBillingBlockDescription()));
			billingBlockList.add(billingBlockBDO);
		}
		bo.setBillingBlockList(billingBlockList);

		return bo;
	}
}