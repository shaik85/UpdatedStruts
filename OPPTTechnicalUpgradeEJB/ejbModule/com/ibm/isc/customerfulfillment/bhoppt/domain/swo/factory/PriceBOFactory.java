/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.swo.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo.PriceBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/** 
 * This class returns Price BO objects based on the arguement 
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
public class PriceBOFactory {
	private static final String PRICE_LOCAL_HOME = "PriceLocalHome";
	private static final String VARIANCE_PRICE_LOCAL_HOME = "VariancePriceLocalHome";
/** Price_Table */
	public static final int PRICE_TABLE = 1;
	/** Variance_Price_Table */
	public static final int VARIANCE_PRICE_TABLE = 2;
	private static final String CLASS_NAME = "PriceBOFactory";

	/**
	 *  
	 * This method set the price data in Price entities 
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
	 * @param priceBO
	 * @param table
	 * @throws DomainException
	 */
	public void createPriceBO(PriceBO priceBO, int table) throws DomainException {
		PriceLocalHome priceLocalHome = null;
		PriceLocal priceLocal = null;
		VariancePriceLocalHome variancePriceLocalHome = null;
		VariancePriceLocal variancePriceLocal = null;

		if (table != 0 && table == PRICE_TABLE) {
			priceLocalHome = getPriceLocalHome();
			try {
				priceLocal = priceLocalHome.create(priceBO.getPriceId(), priceBO.getEeId(), priceBO.getSwoId(), priceBO.getDmId(), priceBO.getCustomerId(), priceBO.getProposalId());
			} catch (CreateException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "createPriceBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			populatePriceLocal(priceLocal, priceBO);
		} else if (0 != table && VARIANCE_PRICE_TABLE == table) {
			variancePriceLocalHome = getVariancePriceLocalHome();
			try {
				variancePriceLocal = variancePriceLocalHome.create(priceBO.getPriceId(), priceBO.getEeId(), priceBO.getSwoId(), priceBO.getDmId(), priceBO.getCustomerId(), priceBO.getProposalId());
			} catch (CreateException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "createPriceBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			populatePriceLocal(variancePriceLocal, priceBO);
		}

	}

	/** 
	 * To populate the price local with the price BO
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
	 * @param priceBO 
	 */
	private void populatePriceLocal(PriceLocal priceLocal, PriceBO priceBO) {
		priceLocal.setBillingStatus(OPPTHelper.trimStringToNull(priceBO.getBillingStatus()));
		priceLocal.setBillPlanEndDate(priceBO.getBillPlanEndDate());
		priceLocal.setBillPlanStartDate(priceBO.getBillPlanStartDate());
		priceLocal.setCurrency(OPPTHelper.trimStringToNull(priceBO.getCurrency()));
		priceLocal.setEeItemNo(OPPTHelper.trimStringToNull(priceBO.getEeItemNo()));
		priceLocal.setEswPrice(priceBO.getEswPrice());
		priceLocal.setExclusionId(OPPTHelper.trimStringToNull(priceBO.getExclusionId()));
		priceLocal.setMonthId(priceBO.getMonthId());
		priceLocal.setSalesDocNo(OPPTHelper.trimStringToNull(priceBO.getSalesDocNo()));
	}

	/** 
	 * To populate the price local with the price BO
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
	 * @param priceBO 
	 */
	private void populatePriceLocal(VariancePriceLocal variancePriceLocal, PriceBO priceBO) {
		variancePriceLocal.setSalesDocNo(OPPTHelper.trimStringToNull(priceBO.getSalesDocNo()));
		variancePriceLocal.setEeItemNo(OPPTHelper.trimStringToNull(priceBO.getEeItemNo()));
		variancePriceLocal.setBillPlanStartDate(priceBO.getBillPlanStartDate());
		variancePriceLocal.setBillPlanEndDate(priceBO.getBillPlanEndDate());
		variancePriceLocal.setEswPrice(priceBO.getEswPrice());
		variancePriceLocal.setCurrency(OPPTHelper.trimStringToNull(priceBO.getCurrency()));
		variancePriceLocal.setIndicator(OPPTHelper.trimStringToNull(priceBO.getBillingStatus()));

	}

	/**
	 *  
	 * find the Price business object for the particular EE  
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
	 * @param eeId
	 * @param swoId
	 * @param dmId
	 * @param customerId
	 * @param proposalId
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	public List findPriceBOForEE(int eeId, int swoId, int dmId, int customerId, int proposalId, int table) throws DomainException {
		PriceLocalHome priceLocalHome = null;
		PriceLocal priceLocal = null;
		Collection priceLocalList = null;
		VariancePriceLocalHome variancePriceLocalHome = null;
		VariancePriceLocal variancePriceLocal = null;
		Collection variancePriceLocalList = null;
		PriceBO priceBO = null;
		List priceBOList = null;

		if (PRICE_TABLE == table) {
			priceLocalHome = getPriceLocalHome();
			try {
				priceLocalList = priceLocalHome.findByEE(eeId, swoId, dmId, customerId, proposalId);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findPriceBOForEE", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			Iterator iterator = priceLocalList.iterator();
			priceBOList = new ArrayList();
			while (iterator.hasNext()) {
				priceLocal = (PriceLocal) iterator.next();
				priceBOList.add(getPriceBOForLocal(priceLocal));
			}
		} else if (VARIANCE_PRICE_TABLE == table) {
			variancePriceLocalHome = getVariancePriceLocalHome();
			try {
				variancePriceLocalList = variancePriceLocalHome.findByEE(eeId, swoId, dmId, customerId, proposalId);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findPriceBOForEE", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			Iterator iterator = variancePriceLocalList.iterator();
			priceBOList = new ArrayList();
			while (iterator.hasNext()) {
				variancePriceLocal = (VariancePriceLocal) iterator.next();
				priceBOList.add(getPriceBOForLocal(variancePriceLocal));
			}

		}
		return priceBOList;
	}

	/**
	 *  
	 * find the Price business object for the particular EE  
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
	 * @param eeId
	 * @param swoId
	 * @param dmId
	 * @param customerId
	 * @param proposalId
	 * @return
	 * @throws DomainException
	 */
	public List findPriceBOForEEVariance(int eeId, int swoId, int dmId, int customerId, int proposalId) throws DomainException {
		PriceLocalHome priceLocalHome = null;
		PriceLocal priceLocal = null;
		Collection priceLocalList = null;
		VariancePriceLocalHome variancePriceLocalHome = null;
		VariancePriceLocal variancePriceLocal = null;
		Collection variancePriceLocalList = null;
		PriceBO priceBO = null;
		List priceBOList = null;

		variancePriceLocalHome = getVariancePriceLocalHome();
		try {
			variancePriceLocalList = variancePriceLocalHome.findByEEForVariance(eeId, swoId, dmId, customerId, proposalId);
		} catch (FinderException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findPriceBOForEEVariance", null, e);
			//throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		Iterator iterator = variancePriceLocalList.iterator();
		priceBOList = new ArrayList();
		while (iterator.hasNext()) {
			variancePriceLocal = (VariancePriceLocal) iterator.next();
			priceBOList.add(getPriceBOForLocal(variancePriceLocal));
		}
		return priceBOList;
	}

	
	/** 
	 * To get the price bo out of local
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
	 * @param priceLocal
	 * @return PriceBO
	 */
	private PriceBO getPriceBOForLocal(PriceLocal priceLocal) {
		PriceBO priceBO = new PriceBO();
		priceBO.setPriceId(priceLocal.getPriceId());
		priceBO.setEeId(priceLocal.getEeId());
		priceBO.setSwoId(priceLocal.getSwoId());
		priceBO.setDmId(priceLocal.getDmId());
		priceBO.setCustomerId(priceLocal.getCustomerId());
		priceBO.setProposalId(priceLocal.getProposalId());
		priceBO.setBillingStatus(priceLocal.getBillingStatus());
		priceBO.setBillPlanEndDate(priceLocal.getBillPlanEndDate());
		priceBO.setBillPlanStartDate(priceLocal.getBillPlanStartDate());
		priceBO.setCurrency(OPPTHelper.trimStringToNull(priceLocal.getCurrency()));
		priceBO.setEeItemNo(OPPTHelper.trimStringToNull(priceLocal.getEeItemNo()));
		priceBO.setEswPrice(priceLocal.getEswPrice());
		priceBO.setExclusionId(OPPTHelper.trimStringToNull(priceLocal.getExclusionId()));
		priceBO.setMonthId(priceLocal.getMonthId());
		priceBO.setSalesDocNo(OPPTHelper.trimStringToNull(priceLocal.getSalesDocNo()));

		return priceBO;
	}

	/** 
	 * To get the price bo out of VariancePricelocal
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
	 * @param priceLocal
	 * @return PriceBO
	 */
	private PriceBO getPriceBOForLocal(VariancePriceLocal variancePriceLocal) {
		PriceBO priceBO = new PriceBO();

		priceBO.setSalesDocNo(OPPTHelper.trimStringToNull(variancePriceLocal.getSalesDocNo()));
		priceBO.setEeItemNo(OPPTHelper.trimStringToNull(variancePriceLocal.getEeItemNo()));
		priceBO.setBillPlanStartDate(variancePriceLocal.getBillPlanStartDate());
		priceBO.setBillPlanEndDate(variancePriceLocal.getBillPlanEndDate());
		priceBO.setEswPrice(variancePriceLocal.getEswPrice());
		priceBO.setCurrency(variancePriceLocal.getCurrency());
		priceBO.setIIndicator(OPPTHelper.trimStringToNull(variancePriceLocal.getIndicator()));
		priceBO.setPriceId(variancePriceLocal.getPriceId());
		priceBO.setEeId(variancePriceLocal.getEeId());
		priceBO.setSwoId(variancePriceLocal.getSwoId());
		priceBO.setDmId(variancePriceLocal.getDmId());
		priceBO.setCustomerId(variancePriceLocal.getCustomerId());
		priceBO.setProposalId(variancePriceLocal.getProposalId());

		return priceBO;
	}

	/**
	 *  
	 * This method updates the price data 
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
	 * @param priceBO
	 * @param table
	 * @throws DomainException
	 */
	public void updatePriceBO(PriceBO priceBO, int table) throws DomainException {
		PriceLocalHome priceLocalHome = null;
		PriceLocal priceLocal = null;
		PriceKey priceKey = null;
		VariancePriceLocalHome variancePriceLocalHome = null;
		VariancePriceLocal variancePriceLocal = null;
		VariancePriceKey variancePriceKey = null;

		if (table == PRICE_TABLE) {
			priceLocalHome = getPriceLocalHome();
			priceKey = new PriceKey(priceBO.getPriceId(), priceBO.getEeId(), priceBO.getSwoId(), priceBO.getDmId(), priceBO.getCustomerId(), priceBO.getProposalId());
			try {
				priceLocal = priceLocalHome.findByPrimaryKey(priceKey);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "updatePriceBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			populatePriceLocal(priceLocal, priceBO);
		} else if (table == VARIANCE_PRICE_TABLE) {
			variancePriceLocalHome = getVariancePriceLocalHome();
			variancePriceKey = new VariancePriceKey(priceBO.getPriceId(), priceBO.getEeId(), priceBO.getSwoId(), priceBO.getDmId(), priceBO.getCustomerId(), priceBO.getProposalId());
			try {
				variancePriceLocal = variancePriceLocalHome.findByPrimaryKey(variancePriceKey);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "updatePriceBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			populatePriceLocal(variancePriceLocal, priceBO);
		}
	}

	/**
	 * This factory method finds the maximum price id from table 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 8, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	public PriceBO findMaxPriceBO(int table) throws DomainException {
		PriceLocalHome priceLocalHome = null;
		PriceLocal priceLocal = null;
		VariancePriceLocalHome variancePriceLocalHome = null;
		VariancePriceLocal variancePriceLocal = null;

		Collection priceLocalCollection = null;
		PriceBO priceBO = null;

		if (table != 0 && table == PRICE_TABLE) {
			priceLocalHome = getPriceLocalHome();
			try {
				priceLocalCollection = priceLocalHome.findMaxPriceId();
				Iterator iteratePrice = priceLocalCollection.iterator();
				while (iteratePrice.hasNext()) {
					priceLocal = (PriceLocal) iteratePrice.next();
				}
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findMaxPriceBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			if(priceLocal!=null){
				priceBO = getPriceBOForLocal(priceLocal);
			}else {
				priceBO = new PriceBO();
				priceBO.setPriceId(0);
			}	
				
		} else if (0 != table && VARIANCE_PRICE_TABLE == table) {
			variancePriceLocalHome = getVariancePriceLocalHome();
			try {
				priceLocalCollection = variancePriceLocalHome.findMaxVariancePrice();
				Iterator iteratePrice = priceLocalCollection.iterator();
				while (iteratePrice.hasNext()) {
					variancePriceLocal = (VariancePriceLocal) iteratePrice.next();
				}
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findMaxPriceBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			if (variancePriceLocal != null) {
				priceBO = getPriceBOForLocal(variancePriceLocal);
			} else {
				priceBO = new PriceBO();
				priceBO.setPriceId(0);
			}

		}

		return priceBO;
	}

	/** 
	 * To get hte price local home
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
	 * @return PriceLocalHome
	 */
	private PriceLocalHome getPriceLocalHome() {
		return (PriceLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(PRICE_LOCAL_HOME);
	}

	/** 
	 * To get hte Variance price local home
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * Venkat 
	 * 
	 * </PRE><br> 
	 * 
	 * @return VariancePriceLocalHome
	 */
	private VariancePriceLocalHome getVariancePriceLocalHome() {
		return (VariancePriceLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(VARIANCE_PRICE_LOCAL_HOME);
	}

}