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
import javax.ejb.RemoveException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo.EEBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;
/** 
 * This factory class returns instance of EE Business object
 * Based on the argument 
 * 
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
public class EEBOFactory {
	private static final String EE_HISTORY_LOCAL_HOME = "HistoryEELocalHome";
	private static final String EE_LOCAL_HOME = "EELocalHome";
	private static final String EE_VARIANCE_HOME = "VarianceEELocalHome";

	public static final int EE_TABLE = 1;
	public static final int EE_HISTORY_TABLE = 2;
	public static final int EE_VARIANCE_TABLE = 3;

	private static final String CLASS_NAME = "EEBOFactory";

	/**
	 *  
	 * This method find the EEBO based on the SWO ID unique 
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
	 * @param dmId
	 * @param swoId
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	public List findEEBOForSWO(int proposalId, int customerId, int dmId, int swoId, int table) throws DomainException {
		EELocalHome eeLocalHome = null;
		EELocal eeLocal = null;
		VarianceEELocal varianceEELocal = null;
		VarianceEELocalHome varianceEELocalHome = null;
		Collection eeLocalList = null;
		Collection eeLocalVarianceList = null;

		List eeBOList = null;
		if (EE_TABLE == table) {
			eeLocalHome = getEELocalHome();
			try {
				eeLocalList = eeLocalHome.findBySWO(swoId, dmId, customerId, proposalId);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findEEBOForSWO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			Iterator iterator = eeLocalList.iterator();
			eeBOList = new ArrayList();
			while (iterator.hasNext()) {
				eeLocal = (EELocal) iterator.next();
				eeBOList.add(getEEBO(eeLocal));
			}
		} else if (EE_VARIANCE_TABLE == table) {
			varianceEELocalHome = getVarianceEELocalHome();
			try {
				eeLocalVarianceList = varianceEELocalHome.findBySWO(swoId, dmId, customerId, proposalId);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findEEBOForSWO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			Iterator iterator = eeLocalVarianceList.iterator();
			eeBOList = new ArrayList();
			while (iterator.hasNext()) {
				varianceEELocal = (VarianceEELocal) iterator.next();
				eeBOList.add(getEEBO(varianceEELocal));
			}

		}
		return eeBOList;
	}
	
	/**
	 *  
	 * This method finds all the EE's for the SWO and deletest them 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date June 02, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalId
	 * @param customerId
	 * @param dmId
	 * @param swoId
	 * @param table
	 * @return
	 * @throws DomainException
	 * Added by Sara for MN19391947 - CMVCDEFECT 352 on 02-June-2004
	 */
	public void deleteEEBOForSWO(int proposalId, int customerId, int dmId, int swoId, int table) throws DomainException {
		EELocalHome eeLocalHome = null;
		EELocal eeLocal = null;
		VarianceEELocal varianceEELocal = null;
		VarianceEELocalHome varianceEELocalHome = null;
		Collection eeLocalList = null;
		Collection eeLocalVarianceList = null;

		if (EE_TABLE == table) {
			eeLocalHome = getEELocalHome();
			try {
				eeLocalList = eeLocalHome.findBySWO(swoId, dmId, customerId, proposalId);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "deleteEEBOForSWO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			Iterator iterator = eeLocalList.iterator();
			try {
				while (iterator.hasNext()) {
					eeLocal = (EELocal) iterator.next();
					eeLocal.remove();
				}
			}
			catch (RemoveException re) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "deleteEEBOForSWO", null, re);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
		} else if (EE_VARIANCE_TABLE == table) {
			varianceEELocalHome = getVarianceEELocalHome();
			try {
				eeLocalVarianceList = varianceEELocalHome.findBySWO(swoId, dmId, customerId, proposalId);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "deleteEEBOForSWO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			Iterator iterator = eeLocalVarianceList.iterator();
			try {
				while (iterator.hasNext()) {
					varianceEELocal = (VarianceEELocal) iterator.next();
					varianceEELocal.remove();
				}
			}
			catch (RemoveException re) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "deleteEEBOForSWO", null, re);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
		}
	}
	
	/**
	 *  
	 * This method finds the EEBO and removes that  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date June 02, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalId
	 * @param customerId
	 * @param dmId
	 * @param swoId
	 * @param table
	 * @return
	 * @throws DomainException
	 * Added by Sara for MN19391947 - CMVCDEFECT 352 on 02-June-2004
	 */
	public void deleteEEBO(EEBO eeBO,int table) throws DomainException {
		EELocalHome eeLocalHome = null;
		EELocal eeLocal = null;
		EEKey eeKey = null;

		if (table != 0 && table == EE_TABLE) {
			eeLocalHome = getEELocalHome();
			eeKey = new EEKey(eeBO.getEeId(),eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId());

			try {

				eeLocalHome.remove(eeKey);

			} catch (RemoveException re) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "deleteSWOBO", null, re);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
		}
	}

	/** 
	 * To get the ee BO using the local
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
	 * @param eeLocal
	 * @return EEBO 
	 */
	private EEBO getEEBO(EELocal eeLocal) {
		EEBO eeBO = new EEBO();
		eeBO.setEeId(eeLocal.getEeId());
		eeBO.setSwoId(eeLocal.getSwoId());
		eeBO.setDmId(eeLocal.getDmId());
		eeBO.setCustomerId(eeLocal.getCustomerId());
		eeBO.setProposalId(eeLocal.getProposalId());
		eeBO.setAlternatePrice(eeLocal.getAlternatePrice());
		eeBO.setAlternatePriceUpdateInd(eeLocal.getAlternatePriceUpdateInd());
		eeBO.setBillingEndDate(eeLocal.getBillingEndDate());
		eeBO.setBillingStartDate(eeLocal.getBillingStartDate());
		eeBO.setBumpId(eeLocal.getBumpId());
		eeBO.setCalculatedPrice(eeLocal.getCalculatedPrice());
		eeBO.setChargeOption(eeLocal.getChargeOption());
		eeBO.setChargeOptionDesc(OPPTHelper.trimStringToNull(eeLocal.getChargeOptionDesc()));
		eeBO.setEeDesc(eeLocal.getEeDesc());
		eeBO.setEeItemNo(eeLocal.getEeItemNo());
		eeBO.setEeNo(eeLocal.getEeNo());
		eeBO.setEswPrice(eeLocal.getEswPrice());
		eeBO.setExclusionId(eeLocal.getExclusionId());
		eeBO.setLicenseType(eeLocal.getLicenseType());
		eeBO.setListPrice(eeLocal.getListPrice());
		eeBO.setPlanEndDate(eeLocal.getPlanEndDate());
		eeBO.setPlanStartDate(eeLocal.getPlanStartDate());
		eeBO.setPletNo(eeLocal.getPletNo());
		eeBO.setReqstDeliveryDate(eeLocal.getReqstDeliveryDate());
		eeBO.setSalesDocNo(eeLocal.getSalesDocNo());
		eeBO.setSAndSDiscountPercent(eeLocal.getSAndSDiscountPercent());
		eeBO.setSequenceNo(eeLocal.getSequenceNo());
		eeBO.setSwoItemNo(eeLocal.getSwoItemNo());
		eeBO.setUseLevel(eeLocal.getUseLevel());
		eeBO.setValueMetric(eeLocal.getValueMetric());

		return eeBO;
	}

	/** 
	 * To get the ee BO using the history local
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
	 * @param eeLocal
	 * @return EEBO 
	 */
	private EEBO getEEBO(HistoryEELocal eeLocal) {
		EEBO eeBO = new EEBO();
		eeBO.setEeId(eeLocal.getEeId());
		eeBO.setSwoId(eeLocal.getSwoId());
		eeBO.setDmId(eeLocal.getDmId());
		eeBO.setCustomerId(eeLocal.getCustomerId());
		eeBO.setProposalId(eeLocal.getProposalId());
		eeBO.setAlternatePrice(eeLocal.getAlternatePrice());
		//System.out.println("EEBOFactory.getEEBO():eeLocal.getAlternatePrice():"+eeLocal.getAlternatePrice());
		eeBO.setBillingEndDate(eeLocal.getBillingEndDate());
		eeBO.setBillingStartDate(eeLocal.getBillingStartDate());
		eeBO.setBumpId(eeLocal.getBumpId());
		eeBO.setCalculatedPrice(eeLocal.getCalculatedPrice());
		//System.out.println("EEBOFactory.getEEBO():eeLocal.getCalculatedPrice():"+eeLocal.getCalculatedPrice());
		eeBO.setChargeOptionDesc(OPPTHelper.trimStringToNull(eeLocal.getChargeOptionDesc()));
		eeBO.setEeDesc(eeLocal.getEeDesc());
		eeBO.setEeItemNo(eeLocal.getEeItemNo());
		eeBO.setEeNo(eeLocal.getEeNo());
		eeBO.setEswPrice(eeLocal.getEswPrice());
		eeBO.setExclusionId(eeLocal.getExclusionId());
		eeBO.setLicenseType(eeLocal.getLicenseType());
		eeBO.setPlanEndDate(eeLocal.getPlanEndDate());
		eeBO.setPlanStartDate(eeLocal.getPlanStartDate());
		eeBO.setReqstDeliveryDate(eeLocal.getReqstDeliveryDate());
		eeBO.setSalesDocNo(eeLocal.getSalesDocNo());
		eeBO.setSequenceNo(eeLocal.getSequenceNo());
		eeBO.setSwoItemNo(eeLocal.getSwoItemNo());
		eeBO.setUseLevel(eeLocal.getUseLevel());
		eeBO.setValueMetric(eeLocal.getValueMetric());

		return eeBO;
	}

	/** 
	 * To get the ee BO using the local
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
	 * @param varianceEELocal
	 * @return EEBO 
	 */
	private EEBO getEEBO(VarianceEELocal varianceEELocal) {
		EEBO eeBO = new EEBO();
		eeBO.setSalesDocNo(varianceEELocal.getSalesDocNo());
		eeBO.setEeItemNo(varianceEELocal.getEeItemNo());
		eeBO.setSwoItemNo(varianceEELocal.getSwoItemNo());
		eeBO.setEeNo(varianceEELocal.getEeNo());
		eeBO.setEeDesc(varianceEELocal.getEeDesc());
		eeBO.setValueMetric(varianceEELocal.getValueMetric());
		eeBO.setUseLevel(varianceEELocal.getUseLevel());
		eeBO.setLicenseType(varianceEELocal.getLicenseType());
		eeBO.setEswPrice(varianceEELocal.getEswPrice());
		eeBO.setSequenceNo(varianceEELocal.getSequenceNo());
		eeBO.setChargeOption(varianceEELocal.getChargeOption());
		eeBO.setChargeOptionDesc(OPPTHelper.trimStringToNull(varianceEELocal.getChargeOptionDesc()));
		eeBO.setEeId(varianceEELocal.getEeId());
		eeBO.setSwoId(varianceEELocal.getSwoId());
		eeBO.setDmId(varianceEELocal.getDmId());
		eeBO.setCustomerId(varianceEELocal.getCustomerId());
		eeBO.setProposalId(varianceEELocal.getProposalId());

		return eeBO;
	}

	/**
	 * This method finds the EE BO based on the proposal id 
	 *  
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
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	public List findEEBOForProposal(int proposalId, int table) throws DomainException {
		EELocalHome eeLocalHome = null;
		EELocal eeLocal = null;
		Collection eeLocalList = null;

		List eeBOList = null;
		if (table != 0 && table == EE_TABLE) {
			eeLocalHome = getEELocalHome();
			try {
				eeLocalList = eeLocalHome.findByProposal(proposalId);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findEEBOForProposal", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			Iterator iterator = eeLocalList.iterator();
			eeBOList = new ArrayList();
			while (iterator.hasNext()) {
				eeLocal = (EELocal) iterator.next();
				eeBOList.add(getEEBO(eeLocal));
			}
		}
		return eeBOList;
	}

	/**
	 *  
	 * This method stores EEBO object entities in EE table 
	 * Based on the table argument it stores history or original table 
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
	 * @param eeBO
	 * @param table
	 * @throws DomainException
	 */
	public void createEEBO(EEBO eeBO, int table) throws DomainException {
		EELocalHome eeLocalHome = null;
		EELocal eeLocal = null;
		HistoryEELocalHome historyEELocalHome = null;
		HistoryEELocal historyEELocal = null;
		VarianceEELocalHome varianceEELocalHome = null;
		VarianceEELocal varianceEELocal = null;

		int maxEEId = 0;
		EEKey eeKey = null;

		if (table != 0 && table == EE_TABLE) {
			eeLocalHome = getEELocalHome();

			try {
				eeLocal = eeLocalHome.create(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId(), eeBO.getEeNo());
			} catch (CreateException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "createEEBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			populateLocalWithBO(eeLocal, eeBO);
		} else if (table != 0 && table == EE_HISTORY_TABLE) {
			historyEELocalHome = getHistoryEELocalHome();
			try {
				historyEELocal = historyEELocalHome.create(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId(), eeBO.getEeNo());
			} catch (CreateException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "createEEBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			populateLocalWithBO(historyEELocal, eeBO);
		} else if (0 != table && EE_VARIANCE_TABLE == table) {
			varianceEELocalHome = getVarianceEELocalHome();

			try {
				varianceEELocal = varianceEELocalHome.create(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId(), eeBO.getEeNo());
			} catch (CreateException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "createEEBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			populateLocalWithBO(varianceEELocal, eeBO);
		}

	}

	/** 
	 * To populate the local
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
	 * @param eeLocal
	 * @param eeBO 
	 */
	private void populateLocalWithBO(HistoryEELocal historyEELocal, EEBO eeBO) {
		historyEELocal.setAlternatePrice(eeBO.getAlternatePrice());
		//System.out.println("EEBOFactory.populateLocalWithBO():eeBO.getAlternatePrice():"+eeBO.getAlternatePrice());
		//System.out.println("EEBOFactory.populateLocalWithBO():eeBO.getCalculatedPrice():"+eeBO.getCalculatedPrice());
		historyEELocal.setBillingEndDate(eeBO.getBillingEndDate());
		historyEELocal.setBillingStartDate(eeBO.getBillingStartDate());
		historyEELocal.setBumpId(OPPTHelper.trimStringToNull(eeBO.getBumpId()));
		/*if(eeBO.getAlternatePrice()> 0){
			System.out.println("EEBOFactory.populateLocalWithBO():inside:");
		historyEELocal.setCalculatedPrice(eeBO.getAlternatePrice());
		}
		else{
			historyEELocal.setCalculatedPrice(eeBO.getCalculatedPrice());
		}*/
		historyEELocal.setChargeOptionDesc(OPPTHelper.trimStringToNull(eeBO.getChargeOptionDesc()));
		historyEELocal.setEeDesc(OPPTHelper.trimStringToNull(eeBO.getEeDesc()));
		historyEELocal.setEeItemNo(OPPTHelper.trimStringToNull(eeBO.getEeItemNo()));
		historyEELocal.setEeNo(OPPTHelper.trimStringToNull(eeBO.getEeNo()));
		historyEELocal.setEswPrice(eeBO.getEswPrice());
		historyEELocal.setExclusionId(OPPTHelper.trimStringToNull(eeBO.getExclusionId()));
		historyEELocal.setLicenseType(OPPTHelper.trimStringToNull(eeBO.getLicenseType()));
		historyEELocal.setPlanEndDate(eeBO.getPlanEndDate());
		historyEELocal.setPlanStartDate(eeBO.getPlanStartDate());
		historyEELocal.setReqstDeliveryDate(eeBO.getReqstDeliveryDate());
		historyEELocal.setSalesDocNo(OPPTHelper.trimStringToNull(eeBO.getSalesDocNo()));
		historyEELocal.setSequenceNo(eeBO.getSequenceNo());
		historyEELocal.setSwoItemNo(OPPTHelper.trimStringToNull(eeBO.getSwoItemNo()));
		historyEELocal.setUseLevel(OPPTHelper.trimStringToNull(eeBO.getUseLevel()));
		historyEELocal.setValueMetric(OPPTHelper.trimStringToNull(eeBO.getValueMetric()));
	}

	/** 
	 * To populate variancelocal from EEBO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * Author 
	 * 
	 * </PRE><br> 
	 * 
	 * @param varianceEELocal
	 * @param eeBO
	 * @author Venkat 
	 */
	private void populateLocalWithBO(VarianceEELocal varianceEELocal, EEBO eeBO) {

		varianceEELocal.setSalesDocNo(OPPTHelper.trimStringToNull(eeBO.getSalesDocNo()));
		varianceEELocal.setEeItemNo(OPPTHelper.trimStringToNull(eeBO.getEeItemNo()));
		varianceEELocal.setSwoItemNo(OPPTHelper.trimStringToNull(eeBO.getSwoItemNo()));
		varianceEELocal.setEeNo(OPPTHelper.trimStringToNull(eeBO.getEeNo()));
		varianceEELocal.setEeDesc(OPPTHelper.trimStringToNull(eeBO.getEeDesc()));
		varianceEELocal.setValueMetric(OPPTHelper.trimStringToNull(eeBO.getValueMetric()));
		varianceEELocal.setUseLevel(OPPTHelper.trimStringToNull(eeBO.getUseLevel()));
		varianceEELocal.setLicenseType(OPPTHelper.trimStringToNull(eeBO.getLicenseType()));
		varianceEELocal.setEswPrice(eeBO.getEswPrice());
		varianceEELocal.setSequenceNo(eeBO.getSequenceNo());
		varianceEELocal.setChargeOption(OPPTHelper.trimStringToNull(eeBO.getChargeOption()));
		varianceEELocal.setChargeOptionDesc(OPPTHelper.trimStringToNull(eeBO.getChargeOptionDesc()));

	}

	/** 
	 * To populate the local
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
	 * @param eeLocal
	 * @param eeBO 
	 */
	private void populateLocalWithBO(EELocal eeLocal, EEBO eeBO) {
		eeLocal.setAlternatePrice(eeBO.getAlternatePrice());
		//System.out.println("EEBOFactory.populateLocalWithBO():eeBO.getAlternatePrice():"+eeBO.getAlternatePrice());
		/*if(eeBO.getAlternatePrice()> 0)
		{
			//System.out.println("EEBOFactory.populateLocalWithBO():inside1:");
			eeLocal.setCalculatedPrice(eeBO.getAlternatePrice());
		}*/
		//else
		//{
			eeLocal.setCalculatedPrice(eeBO.getCalculatedPrice());
		//}
		//System.out.println("EEBOFactory.populateLocalWithBO():eeBO.getCalculatedPrice():"+eeBO.getCalculatedPrice());
		eeLocal.setAlternatePriceUpdateInd(OPPTHelper.trimStringToNull(eeBO.getAlternatePriceUpdateInd()));
		eeLocal.setBillingEndDate(eeBO.getBillingEndDate());
		eeLocal.setBillingStartDate(eeBO.getBillingStartDate());
		eeLocal.setBumpId(OPPTHelper.trimStringToNull(eeBO.getBumpId()));
		
		eeLocal.setChargeOption(OPPTHelper.trimStringToNull(eeBO.getChargeOption()));
		eeLocal.setChargeOptionDesc(OPPTHelper.trimStringToNull(eeBO.getChargeOptionDesc()));
		eeLocal.setEeDesc(OPPTHelper.trimStringToNull(eeBO.getEeDesc()));
		eeLocal.setEeItemNo(OPPTHelper.trimStringToNull(eeBO.getEeItemNo()));
		eeLocal.setEswPrice(eeBO.getEswPrice());
		eeLocal.setExclusionId(OPPTHelper.trimStringToNull(eeBO.getExclusionId()));
		eeLocal.setLicenseType(OPPTHelper.trimStringToNull(eeBO.getLicenseType()));
		eeLocal.setListPrice(eeBO.getListPrice());
		eeLocal.setPlanEndDate(eeBO.getPlanEndDate());
		eeLocal.setPlanStartDate(eeBO.getPlanStartDate());
		eeLocal.setPletNo(OPPTHelper.trimStringToNull(eeBO.getPletNo()));
		eeLocal.setReqstDeliveryDate(eeBO.getReqstDeliveryDate());
		eeLocal.setSalesDocNo(OPPTHelper.trimStringToNull(eeBO.getSalesDocNo()));
		eeLocal.setSAndSDiscountPercent(eeBO.getSAndSDiscountPercent());
		eeLocal.setSequenceNo(eeBO.getSequenceNo());
		eeLocal.setSwoItemNo(OPPTHelper.trimStringToNull(eeBO.getSwoItemNo()));
		eeLocal.setUseLevel(OPPTHelper.trimStringToNull(eeBO.getUseLevel()));
		eeLocal.setValueMetric(OPPTHelper.trimStringToNull(eeBO.getValueMetric()));
	}

	/**
	 *  
	 * This method updates the EE data 
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
	 * @param eeBO
	 * @param table
	 * @throws DomainException
	 */
	public void updateEEBO(EEBO eeBO, int table) throws DomainException {
		EELocalHome eeLocalHome = null;
		EELocal eeLocal = null;
		EEKey eeKey = null;
		VarianceEELocalHome varianceEELocalHome = null;
		VarianceEELocal varianceEELocal = null;
		VarianceEEKey varianceEEKey = null;

		if (table == EE_TABLE) {
			eeLocalHome = getEELocalHome();
			eeKey = new EEKey(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId());
			try {
				eeLocal = eeLocalHome.findByPrimaryKey(eeKey);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "updateEEBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			populateLocalWithBO(eeLocal, eeBO);
		}else if (table == EE_VARIANCE_TABLE) {
			varianceEELocalHome = getVarianceEELocalHome();
			varianceEEKey = new VarianceEEKey(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId());
			try {
				varianceEELocal = varianceEELocalHome.findByPrimaryKey(varianceEEKey);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "updateEEBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
	
			populateLocalWithBO(varianceEELocal, eeBO);
		}
	}

	/**
	 *  
	 * This factory method finds the max ee id from the table 
	 * 
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
	public EEBO findMaxEEBO(int table) throws DomainException {
		EELocalHome eeLocalHome = null;
		EELocal eeLocal = null;
		VarianceEELocalHome varianceEELocalHome = null;
		VarianceEELocal varianceEELocal = null;
		HistoryEELocal historyEELocal = null;
		HistoryEELocalHome historyEELocalHome = null;

		Collection eeLocalCollection;
		EEBO eeBO = null;

		if (table != 0 && table == EE_TABLE) {
			eeLocalHome = getEELocalHome();
			try {
				eeLocalCollection = eeLocalHome.findMaxEEId();
				Iterator iterateEE = eeLocalCollection.iterator();
				while (iterateEE.hasNext()) {
					eeLocal = (EELocal) iterateEE.next();
				}
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findMaxEEBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			if(eeLocal!=null){
				eeBO = getEEBO(eeLocal);
			}else{
				eeBO = new EEBO();
				eeBO.setEeId(0);	
			}
		} else if (0 != table && EE_VARIANCE_TABLE == table) {
			varianceEELocalHome = getVarianceEELocalHome();
			try {
				eeLocalCollection = varianceEELocalHome.findMaxEEId();
				Iterator iterateEE = eeLocalCollection.iterator();
				while (iterateEE.hasNext()) {
					varianceEELocal = (VarianceEELocal) iterateEE.next();
				}
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findMaxEEBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			if (varianceEELocal != null) {
				eeBO = getEEBO(varianceEELocal);
			} else {
				eeBO = new EEBO();
				eeBO.setEeId(0);
			}
		} else if (0 != table && EE_HISTORY_TABLE == table) {
			historyEELocalHome = getHistoryEELocalHome();
			try {
				eeLocalCollection = historyEELocalHome.findMaxEEId();
				Iterator iterateEE = eeLocalCollection.iterator();
				while (iterateEE.hasNext()) {
					historyEELocal = (HistoryEELocal) iterateEE.next();
				}
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findMaxEEBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			if(historyEELocal!=null){
				eeBO = getEEBO(historyEELocal);
			}else{
				eeBO = new EEBO();
				eeBO.setEeId(0);	
			}
		}

		return eeBO;
	}

	/**
	 * To get the ee local home
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
	 * @return
	 */
	private EELocalHome getEELocalHome() {
		return (EELocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(EE_LOCAL_HOME);
	}

	/**
	 * To get the Variance ee local home
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
	 * @return VarianceEELocalHome
	 */
	private VarianceEELocalHome getVarianceEELocalHome() {
		return (VarianceEELocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(EE_VARIANCE_HOME);
	}

	/**
	 * To get the ee local home
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
	 * @return
	 */
	private HistoryEELocalHome getHistoryEELocalHome() {
		return (HistoryEELocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(EE_HISTORY_LOCAL_HOME);
	}

	/** 
	 * Retrieves EEBO, if present, for the identifies provided
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @param customerID
	 * @param dmID
	 * @param swoID
	 * @param eeID
	 * @param table
	 * @return EEBO
	 * @throws DomainException 
	 */
	public EEBO getEEBO(int proposalID, int customerID, int dmID, int swoID, int eeID, int table) throws DomainException {
		EEBO eeBO = null;
		EELocalHome eeLocalHome = null;
		EELocal eeLocal = null;
		EEKey eeKey = null;

		if (table == EE_TABLE) {
			eeLocalHome = getEELocalHome();
			eeKey = new EEKey(eeID, swoID, dmID, customerID, proposalID);
			try {
				eeLocal = eeLocalHome.findByPrimaryKey(eeKey);
				eeBO = getEEBO(eeLocal);
			} catch (FinderException f) {
				OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "EEBOFactory", "getEEBO", null);
				ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			} catch (Exception e) {
				OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "EEBOFactory", "getEEBO", null);
				ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "EEBOFactory", "getEEBO", null);
			ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		return eeBO;
	}
	
	/* CR6153 start change */
	public List findByEENoSalesDocEEItemSwoItem(int proposalId, String EENo,String SalesDocNo, String EEItemNo, String SWOItemNo) throws DomainException {
		EELocalHome eeLocalHome = null;
		EELocal eeLocal = null;
		Collection eeLocalList = null;
	
		List eeBOList = null;
		
		eeLocalHome = getEELocalHome();
		try {
			eeLocalList = eeLocalHome.findByEENoSalesDocEEItemSwoItem(proposalId, EENo, SalesDocNo, EEItemNo, SWOItemNo );
		} catch (FinderException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findEEBOForEENoandSalesDocNo", null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		Iterator iterator = eeLocalList.iterator();
		eeBOList = new ArrayList();
		while (iterator.hasNext()) {
			eeLocal = (EELocal) iterator.next();
			eeBOList.add(getEEBO(eeLocal));
		}
		 
		return eeBOList;
	}
	/* CR6153 end change */
}