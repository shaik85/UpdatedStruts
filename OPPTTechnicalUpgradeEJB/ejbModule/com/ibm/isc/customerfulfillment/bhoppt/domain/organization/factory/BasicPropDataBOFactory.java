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

import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BasicPropDataBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.CurrencyBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.DistrChannelBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.DivisionBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.SalesOrgBDO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CurrencyLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CurrencyLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DivisionLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DivisionLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.DstrChannelLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesOrgLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.SalesOrgLocalHome;
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
 * date Nov 20, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */
public class BasicPropDataBOFactory
{
	private static final String EXCEPTION = "EXCEPTION";
	private static final String CLASS_NAME = "BasicPropDataBOFactory";

	public BasicPropDataBOFactory()
	{
	}

	/**
	 *  
	 *  This method gets all the data from SalesOrg,Currency,Division and 
	 *  DistributionChannel details and creates BasicPropDataBO
	 *   
	 * - visibility decision 
	 * - changes that are made to objects, which are passed as parameters 
	 * - concurrency issues 
	 * - examples how to invoke this methods 
	 * - preconditions that this method relies on 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 * @throws DomainException
	 */

	public BasicPropDataBO getBasicPropDataBO() throws DomainException
	{
		String methodName = "getBasicPropDataBO";

		SalesOrgLocalHome salesOrgLocalHome =
			(SalesOrgLocalHome) HomeProvider.getLocal(HomeProvider.SALES_ORG_LOCAL_HOME);

		Collection collection;

		try
		{
			collection = salesOrgLocalHome.findAllSalesOrg();
		}
		catch (FinderException e)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		BasicPropDataBO bo = new BasicPropDataBO();

		Iterator iter = collection.iterator();

		SalesOrgLocal local;
		SalesOrgBDO bdo;
		List salesOrgList = new ArrayList();
		while (iter.hasNext())
		{
			bdo = new SalesOrgBDO();
			local = (SalesOrgLocal) iter.next();
			bdo.setSalesOrgDesc(OPPTHelper.trimString(local.getSalesOrgDesc()));
			bdo.setSalesOrg(OPPTHelper.trimString(local.getSalesOrg()));
			bdo.setDefaultCurrncy(OPPTHelper.trimString(local.getDefaultCurrency()));
			salesOrgList.add(bdo);
		}
		bo.setSalesOrgList(salesOrgList);

		DivisionLocalHome divisionLocalHome =
			(DivisionLocalHome) HomeProvider.getLocal(HomeProvider.DIVISION_LOCAL_HOME);

		try
		{
			collection = divisionLocalHome.findAllDivision();
		}
		catch (FinderException e)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		iter = collection.iterator();

		DivisionLocal divisionLocal;
		DivisionBDO divisionBDO;
		List divisionList = new ArrayList();
		while (iter.hasNext())
		{
			divisionBDO = new DivisionBDO();
			divisionLocal = (DivisionLocal) iter.next();
			divisionBDO.setDivisionCode(OPPTHelper.trimString(divisionLocal.getDivision()));
			divisionBDO.setDivisionDesc(OPPTHelper.trimString(divisionLocal.getDivisionDesc()));
			divisionList.add(divisionBDO);
		}

		bo.setDivisionList(divisionList);

		DstrChannelLocalHome dstrChannelLocalHome =
			(DstrChannelLocalHome) HomeProvider.getLocal(HomeProvider.DSTR_CHANNEL_LOCAL_HOME);
		try
		{
			collection = dstrChannelLocalHome.findAllDstrChannel();
		}
		catch (FinderException e)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		iter = collection.iterator();

		DstrChannelLocal dstrChannelLocal;
		DistrChannelBDO dstrChannelBDO;
		List dstrChannelList = new ArrayList();
		while (iter.hasNext())
		{
			dstrChannelBDO = new DistrChannelBDO();
			dstrChannelLocal = (DstrChannelLocal) iter.next();
			dstrChannelBDO.setDistrChannel(OPPTHelper.trimString(dstrChannelLocal.getDistributionChannel()));
			dstrChannelBDO.setSalesGroup(OPPTHelper.trimString(dstrChannelLocal.getSalesGroup()));
			dstrChannelBDO.setChannelRole(OPPTHelper.trimString(dstrChannelLocal.getChannelRole()));
			dstrChannelBDO.setSubmitterRole(OPPTHelper.trimString(dstrChannelLocal.getSubmitterRole()));
			dstrChannelBDO.setDistrDescription(
				OPPTHelper.trimString(dstrChannelLocal.getDistributionChannelDesc()));
			dstrChannelList.add(dstrChannelBDO);
		}

		bo.setDistributionChannelList(dstrChannelList);

		CurrencyLocalHome currencyLocalHome =
			(CurrencyLocalHome) HomeProvider.getLocal(HomeProvider.CURRENCY_LOCAL_HOME);
		try
		{
			collection = currencyLocalHome.findAllCurrency();
		}
		catch (FinderException e)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		iter = collection.iterator();

		CurrencyLocal currencyLocal;
		CurrencyBDO currencyBDO;
		List currencyList = new ArrayList();

		while (iter.hasNext())
		{
			currencyBDO = new CurrencyBDO();
			currencyLocal = (CurrencyLocal) iter.next();
			currencyBDO.setCurrencyCode(OPPTHelper.trimString(currencyLocal.getCurrency()));
			currencyBDO.setCurrencyName(OPPTHelper.trimString(currencyLocal.getCurrencyDesc()));
			currencyBDO.setDecimalAllowed(currencyLocal.getDecimalsAllowed().intValue());
			currencyList.add(currencyBDO);
		}

		bo.setCurrencyList(currencyList);

		return bo;
	}

	/**
	 * This method is used to get Currency object
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 17, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param currencyCode
	 * @return
	 * @throws DomainException
	 */

	public CurrencyBDO getCurrencyBDO(String currencyCode) throws DomainException
	{
		String methodName = "getCurrencyBDO";

		CurrencyLocalHome currencyLocalHome =
			(CurrencyLocalHome) HomeProvider.getLocal(HomeProvider.CURRENCY_LOCAL_HOME);
		CurrencyLocal currencyLocal;
		try
		{
			currencyLocal = currencyLocalHome.findByPrimaryKey(currencyCode);
		}
		catch (FinderException e)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		CurrencyBDO currencyBDO = new CurrencyBDO();
		currencyBDO.setCurrencyCode(OPPTHelper.trimString(currencyLocal.getCurrency()));
		currencyBDO.setCurrencyName(OPPTHelper.trimString(currencyLocal.getCurrencyDesc()));
		currencyBDO.setDecimalAllowed(currencyLocal.getDecimalsAllowed().intValue());

		return currencyBDO;
	}
}