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

import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ProposalTypeBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ProposalTypeConstants;
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
public class ProposalTypeBOFactory
{
	private static final String EXCEPTION = "EXCEPTION";
	private static final String CLASS_NAME = "ProposalTypeBOFactory";

	/**
	 * This method is used to get all the proposaltypes for peoposal creation screen
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 30, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return java.util.List
	 * @throws DomainException
	 * @author balajiv
	 */
	public List findAllProposalTypeBO() throws DomainException
	{
		String methodName = "findAllProposalTypeBO";
		
		OfferingTypeLocalHome offeringTypeLocalHome = getOfferingTypeHome();

		Collection collection;
		try
		{
			collection = offeringTypeLocalHome.findAllOfferingType();
		}
		catch (FinderException e)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		Iterator iter = collection.iterator();

		OfferingTypeLocal local;
		ProposalTypeBO proposalTypeBO;

		List offeringTypeList = new ArrayList();
		while (iter.hasNext())
		{
			proposalTypeBO = new ProposalTypeBO();
			local = (OfferingTypeLocal) iter.next();
			if (!ProposalTypeConstants.EASII.equals(local.getOfferingType()))
			{
				proposalTypeBO.setOfferingType(OPPTHelper.trimString(local.getOfferingType()));
				proposalTypeBO.setOfferingDesc(local.getOfferingDesc());
				proposalTypeBO.setTvmAllowed(OPPTHelper.trimString(local.getTvmAllowed()));
				proposalTypeBO.setAnniversaryContractAmtIndicator(
					OPPTHelper.trimString(local.getAnnivContractAmtInd()));
				proposalTypeBO.setDuration(local.getDuration());
				proposalTypeBO.setSpecialRateIndicator(OPPTHelper.trimString(local.getSpecialRateInd()));

				offeringTypeList.add(proposalTypeBO);
			}
		}

		return offeringTypeList;
	}
	
	/**
	 * This method is used to get proposal type bo 
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
	 * @return ProposalTypeBO
	 * @throws DomainException
	 * @author balajiv
	 */
//	OPPT BH 1.0-DAD001-Srinivas
	public ProposalTypeBO getProposalTypeBO(com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.OfferingTypeKey primaryKey) throws DomainException
	{
		String methodName = "getProposalTypeBO";
		
		OfferingTypeLocalHome offeringTypeLocalHome = getOfferingTypeHome();
		OfferingTypeLocal offeringTypeLocal;
		try
		{
			offeringTypeLocal = offeringTypeLocalHome.findByPrimaryKey(primaryKey);
		}
		catch (FinderException e)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		ProposalTypeBO proposalTypeBO = new ProposalTypeBO();

		proposalTypeBO.setOfferingType(offeringTypeLocal.getOfferingType());
		proposalTypeBO.setOfferingDesc(offeringTypeLocal.getOfferingDesc());
		proposalTypeBO.setTvmAllowed(offeringTypeLocal.getTvmAllowed());
		proposalTypeBO.setAnniversaryContractAmtIndicator(offeringTypeLocal.getAnnivContractAmtInd());
		proposalTypeBO.setDuration(offeringTypeLocal.getDuration());
		proposalTypeBO.setSpecialRateIndicator(offeringTypeLocal.getSpecialRateInd());

		return proposalTypeBO;
	}

	private OfferingTypeLocalHome getOfferingTypeHome()
	{
		return (OfferingTypeLocalHome) HomeProvider.getLocal(HomeProvider.OFFERING_TYPE_LOCAL_HOME);
	}
}