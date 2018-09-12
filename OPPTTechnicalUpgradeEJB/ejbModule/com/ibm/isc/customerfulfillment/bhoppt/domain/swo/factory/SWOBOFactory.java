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

import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo.SWOBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.swo.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.LicenseConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.TimeTaken;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/** 
 * This factory class creates SWO BO object based on the argument 
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
public class SWOBOFactory {
	private static final String SWO_LOCAL_HOME = "SWOLocalHome";
	private static final String HISTORY_SWO_LOCAL_HOME = "HistorySWOLocalHome";
	private static final String VARIANCE_SWO_LOCAL_HOME = "VarianceSWOLocalHome";
	/** SWO_TABLE */
	public static final int SWO_TABLE = 1;
	/**HISTORY_SWO_TABLE */
	public static final int HISTORY_SWO_TABLE = 2;
	/** VARIANCE_SWO_TABLE */
	public static final int VARIANCE_SWO_TABLE = 3;
	private static final String CLASS_NAME = "SWOBOFactory";

	private static final String ITEM_CATEGORY = "V";

	public void createSWOBO(SWOBO swoBO, int table) throws DomainException {
		
		TimeTaken log = new TimeTaken(CLASS_NAME, "createSWOBO");
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		HistorySWOLocalHome historySWOLocalHome = null;
		HistorySWOLocal historySWOLocal = null;
		VarianceSWOLocalHome varianceSWOLocalHome = null;
		VarianceSWOLocal varianceSWOLocal = null;

		int maxSWOId = 0;
		SWOKey swoKey = null;

		if (table != 0 && table == SWO_TABLE) {
			swoLocalHome = getSWOLocalHome();
			try {
				swoLocal = swoLocalHome.create(swoBO.getSwoId(), swoBO.getDmId(), swoBO.getCustomerId(), swoBO.getProposalId(), swoBO.getSwoNo());
			} catch (CreateException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "createSWOBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			populateLocalWithBO(swoLocal, swoBO);
		} else if (table != 0 && table == HISTORY_SWO_TABLE) {
			historySWOLocalHome = getHistorySWOLocalHome();

			try {
				historySWOLocal = historySWOLocalHome.create(swoBO.getSwoId(), swoBO.getDmId(), swoBO.getCustomerId(), swoBO.getProposalId(), swoBO.getSwoNo().trim(), swoBO.getLastUpdatedDate());

			} catch (CreateException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "createSWOBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			populateLocalWithBO(historySWOLocal, swoBO);
		} else if (0 != table && VARIANCE_SWO_TABLE == table) {

			varianceSWOLocalHome = getVarianceSWOLocalHome();
			try {
				varianceSWOLocal = varianceSWOLocalHome.create(swoBO.getSwoId(), swoBO.getDmId(), swoBO.getCustomerId(), swoBO.getProposalId(), swoBO.getSwoNo());
			} catch (CreateException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "createSWOBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			populateLocalWithBO(varianceSWOLocal, swoBO);
		}
		log.end();

	}

	/**
	 *  
	 * This method retrieves the DM BO object based on the Primary key value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 23, 2003 
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
	 * @return SWOBO
	 * @throws DomainException
	 */
	public SWOBO getSWOBO(int proposalId, int customerId, int dmId, int swoId, int table) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		SWOBO swoBO = null;
		SWOKey swoKey = null;

		if (table != 0 && table == SWO_TABLE) {
			swoLocalHome = getSWOLocalHome();
			swoKey = new SWOKey(swoId, dmId, customerId, proposalId);

			try {

				swoLocal = swoLocalHome.findByPrimaryKey(swoKey);
				swoBO = getSWOBOForLocal(swoLocal);

			} catch (FinderException f) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "getSWOBO", null, f);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
		}
		return swoBO;
	}

	/** 
	 * To populate the local with the BO values
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
	 * @param historySWOLocal
	 * @param swoBO 
	 */
	private void populateLocalWithBO(HistorySWOLocal historySWOLocal, SWOBO swoBO) {
		historySWOLocal.setAdjustmentAmount(swoBO.getAdjustmentAmount());
		//System.out.println("SWOBOFactory.populateLocalWithBO():swoBO.getAlternatePrice():"+swoBO.getAlternatePrice());
		historySWOLocal.setAlternatePrice(swoBO.getAlternatePrice());
		historySWOLocal.setAlternatePriceInd(OPPTHelper.trimStringToNull(swoBO.getAlternatePriceUpdateInd()));
		historySWOLocal.setAmendEndDate(swoBO.getAmendEndDate());
		historySWOLocal.setAmendInd(OPPTHelper.trimStringToNull(swoBO.getAmendInd()));
		historySWOLocal.setBumpInd(OPPTHelper.trimStringToNull(swoBO.getBumpInd()));
		//System.out.println("SWOBOFactory.populateLocalWithBO():swoBO.getCalcPrice():"+swoBO.getCalcPrice());
		historySWOLocal.setCalcPrice(swoBO.getCalcPrice());
		historySWOLocal.setCustomerPONo(OPPTHelper.trimStringToNull(swoBO.getCustomerPoNo()));
		historySWOLocal.setDeltaFetchId(OPPTHelper.trimStringToNull(swoBO.getDeltaFetchId()));
		historySWOLocal.setEquipmentNo(OPPTHelper.trimStringToNull(swoBO.getEquipmentNo()));
		historySWOLocal.setEswPrice(swoBO.getEswPrice());
		historySWOLocal.setExclusionId(OPPTHelper.trimStringToNull(swoBO.getExclusionId()));
		historySWOLocal.setItemCategory(OPPTHelper.trimStringToNull(swoBO.getItemCategory()));
		historySWOLocal.setLockedInd(OPPTHelper.trimStringToNull(swoBO.getLockedInd()));
		historySWOLocal.setOldCalcPrice(swoBO.getOldCalcPrice());
		historySWOLocal.setPlanEndDate(swoBO.getPlanEndDate());
		historySWOLocal.setPlannedInd(swoBO.getPlannedInd());
		historySWOLocal.setPlanStartDate(swoBO.getPlanStartDate());
		historySWOLocal.setReferenceSerialNo(OPPTHelper.trimStringToNull(swoBO.getReferenceSerialNo()));
		historySWOLocal.setRefetchId(OPPTHelper.trimStringToNull(swoBO.getRefetchId()));
		historySWOLocal.setRequestDeliveryDate(swoBO.getRequestDeliveryDate());
		historySWOLocal.setSalesDocNo(OPPTHelper.trimStringToNull(swoBO.getSalesDocNo()));
		historySWOLocal.setSequenceNo(swoBO.getSequenceNo());
		historySWOLocal.setSerialNo(swoBO.getSerialNo());
		historySWOLocal.setSwoAddedDate(swoBO.getSwoAddedDate());
		historySWOLocal.setSwoContrStatus(OPPTHelper.trimStringToNull(swoBO.getSwoContrStatus()));
		historySWOLocal.setSwoContrType(OPPTHelper.trimStringToNull(swoBO.getSwoContrType()));
		historySWOLocal.setSwoDesc(OPPTHelper.trimStringToNull(swoBO.getSwoDesc()));
		historySWOLocal.setSwoExtContrNo(OPPTHelper.trimStringToNull(swoBO.getSwoExtContrNo()));
		historySWOLocal.setSwoItemNo(OPPTHelper.trimStringToNull(swoBO.getSwoItemNo()));
		historySWOLocal.setSandsIndicator(OPPTHelper.trimStringToNull(swoBO.getSAndSInd()));
	}

	/**
	 *  
	 * This method deletes the SWO BO 
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
	 * @param swoBO
	 * @param table
	 * @throws DomainException
	 */
	public void deleteSWOBO(SWOBO swoBO, int table) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		SWOKey swoKey = null;

		if (table != 0 && table == SWO_TABLE) {
			swoLocalHome = getSWOLocalHome();
			swoKey = new SWOKey(swoBO.getSwoId(), swoBO.getDmId(), swoBO.getCustomerId(), swoBO.getProposalId());

			try {

				swoLocalHome.remove(swoKey);

			} catch (RemoveException re) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "deleteSWOBO", null, re);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
		}

	}

	/** 
	 * To populate the local with the BO values
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
	 * @param swoLocal
	 * @param swoBO 
	 */
	private void populateLocalWithBO(SWOLocal swoLocal, SWOBO swoBO) {
		swoLocal.setAdjustmentAmount(swoBO.getAdjustmentAmount());
		swoLocal.setAlternatePrice(swoBO.getAlternatePrice());
		//System.out.println("SWOBOFactory.populateLocalWithBO():swoBO.getAlternatePrice():"+swoBO.getAlternatePrice());
		swoLocal.setAlternatePriceInd(OPPTHelper.trimStringToNull(swoBO.getAlternatePriceInd()));
		swoLocal.setAlternatePriceUpdateInd(OPPTHelper.trimStringToNull(swoBO.getAlternatePriceUpdateInd()));
		swoLocal.setAmendStartDate(swoBO.getAmendStartDate());
		swoLocal.setAmendEndDate(swoBO.getAmendEndDate());
		swoLocal.setAmendInd(OPPTHelper.trimStringToNull(swoBO.getAmendInd()));
		swoLocal.setBumpInd(OPPTHelper.trimStringToNull(swoBO.getBumpInd()));
		//System.out.println("SWOBOFactory.populateLocalWithBO():swoBO.getCalcPrice():"+swoBO.getCalcPrice());
		swoLocal.setCalcPrice(swoBO.getCalcPrice());
		swoLocal.setCustomerPONo(OPPTHelper.trimStringToNull(swoBO.getCustomerPoNo()));
		swoLocal.setDeltaFetchId(OPPTHelper.trimStringToNull(swoBO.getDeltaFetchId()));
		swoLocal.setEquipmentNo(OPPTHelper.trimStringToNull(swoBO.getEquipmentNo()));
		swoLocal.setEswPrice(swoBO.getEswPrice());
		swoLocal.setExclusionId(OPPTHelper.trimStringToNull(swoBO.getExclusionId()));
		swoLocal.setItemCategory(OPPTHelper.trimStringToNull(swoBO.getItemCategory()));
		swoLocal.setLastUpdatedDate(swoBO.getLastUpdatedDate());
		swoLocal.setLockedInd(OPPTHelper.trimStringToNull(swoBO.getLockedInd()));
		swoLocal.setOldCalcPrice(swoBO.getOldCalcPrice());
		swoLocal.setPlanDateInd(OPPTHelper.trimStringToNull(swoBO.getPlanDateInd()));
		swoLocal.setPlanEndDate(swoBO.getPlanEndDate());
		swoLocal.setPlannedInd(OPPTHelper.trimStringToNull(swoBO.getPlannedInd()));
		swoLocal.setPlanStartDate(swoBO.getPlanStartDate());
		swoLocal.setReferenceSerialNo(OPPTHelper.trimStringToNull(swoBO.getReferenceSerialNo()));
		swoLocal.setRefetchId(OPPTHelper.trimStringToNull(swoBO.getRefetchId()));
		swoLocal.setRequestDeliveryDate(swoBO.getRequestDeliveryDate());
		swoLocal.setSalesDocNo(OPPTHelper.trimStringToNull(swoBO.getSalesDocNo()));
		swoLocal.setSequenceNo(swoBO.getSequenceNo());
		swoLocal.setSerialNo(OPPTHelper.trimStringToNull(swoBO.getSerialNo()));
		swoLocal.setSwoAddedDate(swoBO.getSwoAddedDate());
		swoLocal.setSwoContrStatus(OPPTHelper.trimStringToNull(swoBO.getSwoContrStatus()));
		swoLocal.setSwoContrType(OPPTHelper.trimStringToNull(swoBO.getSwoContrType()));
		swoLocal.setSwoDesc(OPPTHelper.trimStringToNull(swoBO.getSwoDesc()));
		swoLocal.setSwoExtContrNo(OPPTHelper.trimStringToNull(swoBO.getSwoExtContrNo()));
		swoLocal.setSwoItemNo(OPPTHelper.trimStringToNull(swoBO.getSwoItemNo()));
		swoLocal.setSwoNo(OPPTHelper.trimStringToNull(swoBO.getSwoNo()));
		swoLocal.setSandsIndicator(OPPTHelper.trimStringToNull(swoBO.getSAndSInd()));
		//CR 2031
		swoLocal.setDuplicateDeletedInd(OPPTHelper.trimStringToNull(swoBO.getDuplicateDeletedInd()));
	}

	/** 
	 * To populate the Variance SWO local with the BO values
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param varianceSWOLocal
	 * @param swoBO 
	 * @author Venkat
	 */
	private void populateLocalWithBO(VarianceSWOLocal varianceSWOLocal, SWOBO swoBO) {

		varianceSWOLocal.setSwoNo(OPPTHelper.trimStringToNull(swoBO.getSwoNo()));
		varianceSWOLocal.setSalesDocNo(OPPTHelper.trimStringToNull(swoBO.getSalesDocNo()));
		varianceSWOLocal.setSwoDesc(OPPTHelper.trimStringToNull(swoBO.getSwoDesc()));
		varianceSWOLocal.setSwoItemNo(OPPTHelper.trimStringToNull(swoBO.getSwoItemNo()));
		varianceSWOLocal.setSequenceNo(swoBO.getSequenceNo());
		varianceSWOLocal.setItemCategory(OPPTHelper.trimStringToNull(swoBO.getItemCategory()));
		varianceSWOLocal.setSerialNo(OPPTHelper.trimStringToNull(swoBO.getSerialNo()));
		varianceSWOLocal.setCustomerPONo(OPPTHelper.trimStringToNull(swoBO.getCustomerPoNo()));
		varianceSWOLocal.setEquipmentNo(OPPTHelper.trimStringToNull(swoBO.getEquipmentNo()));
		varianceSWOLocal.setEswPrice(swoBO.getEswPrice());
		varianceSWOLocal.setReferenceSerialNo(OPPTHelper.trimStringToNull(swoBO.getReferenceSerialNo()));
		varianceSWOLocal.setReferenceSerialNoDM(OPPTHelper.trimStringToNull(swoBO.getReferenceSerialNoDM()));

	}

	/**
	 *  
	 * This method returns DMBO object based on the DMId(Unique id) 
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
	 * @param dmId
	 * @param customerId
	 * @param proposalId
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	public List findSWOBOForDM(int dmId, int customerId, int proposalId, int table) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		Collection swoLocalList = null;
		VarianceSWOLocalHome varianceSWOLocalHome = null;
		VarianceSWOLocal varianceSWOLocal = null;
		Collection varianceSWOLocalList = null;

		List swoBOList = null;
		swoBOList = new ArrayList();
		if (table != 0 && table == SWO_TABLE) {
			swoLocalHome = getSWOLocalHome();
			try {
				swoLocalList = swoLocalHome.findByDM(dmId, customerId, proposalId);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findSWOBOForDM", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			Iterator iterator = swoLocalList.iterator();

			while (iterator.hasNext()) {
				swoLocal = (SWOLocal) iterator.next();
				swoBOList.add(getSWOBOForLocal(swoLocal));
			}
		} else if (VARIANCE_SWO_TABLE == table) {
			varianceSWOLocalHome = getVarianceSWOLocalHome();
			try {
				varianceSWOLocalList = varianceSWOLocalHome.findByDM(dmId, customerId, proposalId);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findSWOBOForDM", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			Iterator iterator = varianceSWOLocalList.iterator();

			while (iterator.hasNext()) {
				varianceSWOLocal = (VarianceSWOLocal) iterator.next();
				swoBOList.add(getSWOBOForLocal(varianceSWOLocal));
			}

		}
		return swoBOList;
	}

	/**
	 *  
	 * This method finds the swo information based on the customer      
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * 
	 * @param customerId
	 * @param proposalId
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	public List findSWOBOForCustomer(int customerId, int proposalId, int table) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		Collection swoLocalList = null;

		List swoBOList = null;
		swoBOList = new ArrayList();
		if (table != 0 && table == SWO_TABLE) {
			swoLocalHome = getSWOLocalHome();
			try {
				swoLocalList = swoLocalHome.findByCustomer(proposalId, customerId);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findSWOBOForCustomer", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			Iterator iterator = swoLocalList.iterator();

			while (iterator.hasNext()) {
				swoLocal = (SWOLocal) iterator.next();
				swoBOList.add(getSWOBOForLocal(swoLocal));
			}
		}
		return swoBOList;
	}

	/** 
	 * Returns a SWO BO for the given local
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
	 * @param swoLocal
	 * @return SWOBO
	 */
	private SWOBO getSWOBOForLocal(SWOLocal swoLocal) {
		SWOBO swoBO = new SWOBO();

		swoBO.setSwoId(swoLocal.getSwoId());
		swoBO.setDmId(swoLocal.getDmId());
		swoBO.setCustomerId(swoLocal.getCustomerId());
		swoBO.setProposalId(swoLocal.getProposalId());
		swoBO.setAdjustmentAmount(swoLocal.getAdjustmentAmount());
		swoBO.setAlternatePrice(swoLocal.getAlternatePrice());
		//System.out.println("SWOBOFactory.getSWOBOForLocal():swoLocal.getAlternatePrice():"+swoLocal.getAlternatePrice());
		swoBO.setAlternatePriceInd(OPPTHelper.trimStringToNull(swoLocal.getAlternatePriceInd()));
		swoBO.setAlternatePriceUpdateInd(OPPTHelper.trimStringToNull(swoLocal.getAlternatePriceUpdateInd()));
		swoBO.setAmendEndDate(swoLocal.getAmendEndDate());
		swoBO.setAmendInd(OPPTHelper.trimStringToNull(swoLocal.getAmendInd()));
		swoBO.setBumpInd(OPPTHelper.trimStringToNull(swoLocal.getBumpInd()));
		//System.out.println("SWOBOFactory.getSWOBOForLocal():swoLocal.getCalcPrice():"+swoLocal.getCalcPrice());
		swoBO.setCalcPrice(swoLocal.getCalcPrice());
		swoBO.setDeltaFetchId(OPPTHelper.trimStringToNull(swoLocal.getDeltaFetchId()));
		swoBO.setEquipmentNo(OPPTHelper.trimStringToNull(swoLocal.getEquipmentNo()));
		swoBO.setEswPrice(swoLocal.getEswPrice());
		swoBO.setExclusionId(OPPTHelper.trimStringToNull(swoLocal.getExclusionId()));
		swoBO.setItemCategory(OPPTHelper.trimStringToNull(swoLocal.getItemCategory()));
		swoBO.setLastUpdatedDate(swoLocal.getLastUpdatedDate());
		swoBO.setLockedInd(OPPTHelper.trimStringToNull(swoLocal.getLockedInd()));
		swoBO.setOldCalcPrice(swoLocal.getOldCalcPrice());
		swoBO.setPlanDateInd(swoLocal.getPlanDateInd());
		swoBO.setPlanEndDate(swoLocal.getPlanEndDate());
		swoBO.setPlannedInd(OPPTHelper.trimStringToNull(swoLocal.getPlannedInd()));
		swoBO.setPlanStartDate(swoLocal.getPlanStartDate());
		swoBO.setReferenceSerialNo(OPPTHelper.trimStringToNull(swoLocal.getReferenceSerialNo()));
		swoBO.setRefetchId(OPPTHelper.trimStringToNull(swoLocal.getRefetchId()));
		swoBO.setRequestDeliveryDate(swoLocal.getRequestDeliveryDate());
		swoBO.setSalesDocNo(OPPTHelper.trimStringToNull(swoLocal.getSalesDocNo()));
		swoBO.setSequenceNo(swoLocal.getSequenceNo());
		swoBO.setSerialNo(OPPTHelper.trimStringToNull(swoLocal.getSerialNo()));
		swoBO.setSwoAddedDate(swoLocal.getSwoAddedDate());
		swoBO.setSwoContrStatus(OPPTHelper.trimStringToNull(swoLocal.getSwoContrStatus()));
		swoBO.setSwoContrType(OPPTHelper.trimStringToNull(swoLocal.getSwoContrType()));
		swoBO.setSwoDesc(OPPTHelper.trimStringToNull(swoLocal.getSwoDesc()));
		swoBO.setSwoExtContrNo(OPPTHelper.trimStringToNull(swoLocal.getSwoExtContrNo()));
		swoBO.setSwoItemNo(OPPTHelper.trimStringToNull(swoLocal.getSwoItemNo()));
		swoBO.setSwoNo(OPPTHelper.trimStringToNull(swoLocal.getSwoNo()));
		swoBO.setSAndSInd(OPPTHelper.trimStringToNull(swoLocal.getSandsIndicator()));
		//CR 2031
		swoBO.setDuplicateDeletedInd(OPPTHelper.trimStringToNull(swoLocal.getDuplicateDeletedInd()));
		return swoBO;
	}

	/** 
	 * Returns a SWO BO for the given history local
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
	 * @param swoLocal
	 * @return SWOBO
	 */
	private SWOBO getSWOBOForLocal(HistorySWOLocal swoLocal) {
		SWOBO swoBO = new SWOBO();

		swoBO.setSwoId(swoLocal.getSwoId());
		swoBO.setDmId(swoLocal.getDmId());
		swoBO.setCustomerId(swoLocal.getCustomerId());
		swoBO.setProposalId(swoLocal.getProposalId());
		swoBO.setAdjustmentAmount(swoLocal.getAdjustmentAmount());
		//System.out.println("SWOBOFactory.getSWOBOForLocal():swoLocal.getAlternatePrice():"+swoLocal.getAlternatePrice());
		swoBO.setAlternatePrice(swoLocal.getAlternatePrice());
		swoBO.setAmendEndDate(swoLocal.getAmendEndDate());
		swoBO.setAmendInd(OPPTHelper.trimStringToNull(swoLocal.getAmendInd()));
		swoBO.setBumpInd(OPPTHelper.trimStringToNull(swoLocal.getBumpInd()));
		//System.out.println("SWOBOFactory.getSWOBOForLocal():swoLocal.getCalcPrice():"+swoLocal.getCalcPrice());
		swoBO.setCalcPrice(swoLocal.getCalcPrice());
		swoBO.setDeltaFetchId(OPPTHelper.trimStringToNull(swoLocal.getDeltaFetchId()));
		swoBO.setEquipmentNo(OPPTHelper.trimStringToNull(swoLocal.getEquipmentNo()));
		swoBO.setEswPrice(swoLocal.getEswPrice());
		swoBO.setExclusionId(OPPTHelper.trimStringToNull(swoLocal.getExclusionId()));
		swoBO.setItemCategory(OPPTHelper.trimStringToNull(swoLocal.getItemCategory()));
		swoBO.setLastUpdatedDate(swoLocal.getLastUpdatedDate());
		swoBO.setLockedInd(OPPTHelper.trimStringToNull(swoLocal.getLockedInd()));
		swoBO.setOldCalcPrice(swoLocal.getOldCalcPrice());
		swoBO.setPlanEndDate(swoLocal.getPlanEndDate());
		swoBO.setPlannedInd(swoLocal.getPlannedInd());
		swoBO.setPlanStartDate(swoLocal.getPlanStartDate());
		swoBO.setReferenceSerialNo(OPPTHelper.trimStringToNull(swoLocal.getReferenceSerialNo()));
		swoBO.setRefetchId(OPPTHelper.trimStringToNull(swoLocal.getRefetchId()));
		swoBO.setRequestDeliveryDate(swoLocal.getRequestDeliveryDate());
		swoBO.setSalesDocNo(OPPTHelper.trimStringToNull(swoLocal.getSalesDocNo()));
		swoBO.setSequenceNo(swoLocal.getSequenceNo());
		swoBO.setSerialNo(OPPTHelper.trimStringToNull(swoLocal.getSerialNo()));
		swoBO.setSwoAddedDate(swoLocal.getSwoAddedDate());
		swoBO.setSwoContrStatus(OPPTHelper.trimStringToNull(swoLocal.getSwoContrStatus()));
		swoBO.setSwoContrType(OPPTHelper.trimStringToNull(swoLocal.getSwoContrType()));
		swoBO.setSwoDesc(OPPTHelper.trimStringToNull(swoLocal.getSwoDesc()));
		swoBO.setSwoExtContrNo(OPPTHelper.trimStringToNull(swoLocal.getSwoExtContrNo()));
		swoBO.setSwoItemNo(OPPTHelper.trimStringToNull(swoLocal.getSwoItemNo()));
		swoBO.setSwoNo(OPPTHelper.trimStringToNull(swoLocal.getSwoNo()));
		swoBO.setSAndSInd(OPPTHelper.trimStringToNull(swoLocal.getSandsIndicator()));
		return swoBO;
	}

	/** 
	 * Returns a SWO BO for the given varianceSWOLocal
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param varianceSWOLocal
	 * @return SWOBO
	 * @author Venkat
	 */
	private SWOBO getSWOBOForLocal(VarianceSWOLocal varianceSWOLocal) {
		SWOBO swoBO = new SWOBO();

		swoBO.setSwoNo(OPPTHelper.trimStringToNull(varianceSWOLocal.getSwoNo()));
		swoBO.setSalesDocNo(OPPTHelper.trimStringToNull(varianceSWOLocal.getSalesDocNo()));
		swoBO.setSwoDesc(OPPTHelper.trimStringToNull(varianceSWOLocal.getSwoDesc()));
		swoBO.setSwoItemNo(OPPTHelper.trimStringToNull(varianceSWOLocal.getSwoItemNo()));
		swoBO.setSequenceNo(varianceSWOLocal.getSequenceNo());
		swoBO.setItemCategory(OPPTHelper.trimStringToNull(varianceSWOLocal.getItemCategory()));
		swoBO.setSerialNo(OPPTHelper.trimStringToNull(varianceSWOLocal.getSerialNo()));
		swoBO.setCustomerPoNo(OPPTHelper.trimStringToNull(varianceSWOLocal.getCustomerPONo()));
		swoBO.setEquipmentNo(OPPTHelper.trimStringToNull(varianceSWOLocal.getEquipmentNo()));
		swoBO.setEswPrice(varianceSWOLocal.getEswPrice());
		swoBO.setReferenceSerialNo(OPPTHelper.trimStringToNull(varianceSWOLocal.getReferenceSerialNo()));
		swoBO.setReferenceSerialNoDM(OPPTHelper.trimStringToNull(varianceSWOLocal.getReferenceSerialNoDM()));
		swoBO.setSwoId(varianceSWOLocal.getSwoId());
		swoBO.setDmId(varianceSWOLocal.getDmId());
		swoBO.setCustomerId(varianceSWOLocal.getCustomerId());
		swoBO.setProposalId(varianceSWOLocal.getProposalId());

		return swoBO;
	}

	/**
	 *  
	 * This method returns SWO objects based on the Proposal id 
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
	public List findSWOBOForProposal(int proposalId, int table) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		Collection swoLocalList = null;

		List swoBOList = null;
		swoBOList = new ArrayList();
		if (table != 0 && table == SWO_TABLE) {
			swoLocalHome = getSWOLocalHome();
			try {
				swoLocalList = swoLocalHome.findByProposal(proposalId);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findSWOBOForProposal", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			Iterator iterator = swoLocalList.iterator();

			while (iterator.hasNext()) {
				swoLocal = (SWOLocal) iterator.next();
				swoBOList.add(getSWOBOForLocal(swoLocal));
			}
		}
		return swoBOList;
	}

	/**
	 *  
	 * This method finds the SWOBO for the equipment no 
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
	 * @param equipmentNo
	 * @param proposalId
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	public List findSWOBOForEquipmentNo(String equipmentNo, int proposalId, int table) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		VarianceSWOLocalHome varianceSWOLocalHome = null;
		VarianceSWOLocal varianceSWOLocal = null;

		Collection swoLocalList = null;

		List swoBOList = null;
		swoBOList = new ArrayList();
		if (table != 0 && table == SWO_TABLE) {
			swoLocalHome = getSWOLocalHome();
			try {
				swoLocalList = swoLocalHome.findByEquipmentNo(equipmentNo, proposalId);
			} catch (FinderException e) {
				//OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findSWOBOForEquipmentNo", null, e);
			}
			Iterator iterator = swoLocalList.iterator();

			while (iterator.hasNext()) {
				swoLocal = (SWOLocal) iterator.next();
				swoBOList.add(getSWOBOForLocal(swoLocal));
			}
		} else if (table != 0 && VARIANCE_SWO_TABLE == table) {
			varianceSWOLocalHome = getVarianceSWOLocalHome();
			try {
				swoLocalList = varianceSWOLocalHome.findByEquipmentNo(equipmentNo, proposalId);
			} catch (FinderException e) {
				// OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findSWOBOForEquipmentNo", null, e);

			}
			Iterator iterator = swoLocalList.iterator();

			while (iterator.hasNext()) {
				varianceSWOLocal = (VarianceSWOLocal) iterator.next();
				swoBOList.add(getSWOBOForLocal(varianceSWOLocal));
			}
		}

		return swoBOList;
	}

	/**
	 *  
	 * This method finds the SWOBO for the Order 
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
	 * @param salesDocNo
	 * @param proposalId
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	public List findSWOBOForSalesDocNo(String salesDocNo, int proposalId, int table) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		VarianceSWOLocalHome varianceSWOLocalHome = null;
		VarianceSWOLocal varianceSWOLocal = null;

		Collection swoLocalList = null;

		List swoBOList = null;
		swoBOList = new ArrayList();
		if (table != 0 && table == SWO_TABLE) {
			swoLocalHome = getSWOLocalHome();
			try {
				swoLocalList = swoLocalHome.findBySalesDocNo(salesDocNo, proposalId);
			} catch (FinderException e) {
				// OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findSWOBOForSalesDocNo", null, e);
			}
			Iterator iterator = swoLocalList.iterator();

			while (iterator.hasNext()) {
				swoLocal = (SWOLocal) iterator.next();
				swoBOList.add(getSWOBOForLocal(swoLocal));
			}
		} else if (table != 0 && VARIANCE_SWO_TABLE == table) {
			findSWOBOForEquipmentNo(salesDocNo, proposalId, table);
		}

		return swoBOList;
	}

	/**
	 *  
	 * This method finds the SWOBO for the Quotes 
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
	 * @param salesDocNo
	 * @param proposalId
	 * @param swoItemNo
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	public List findSWOBOForQuotes(String salesDocNo, int proposalId, String swoItemNo, int table) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		VarianceSWOLocalHome varianceSWOLocalHome = null;
		VarianceSWOLocal varianceSWOLocal = null;

		Collection swoLocalList = null;

		List swoBOList = null;
		swoBOList = new ArrayList();
		if (table != 0 && table == SWO_TABLE) {
			swoLocalHome = getSWOLocalHome();
			try {
				swoLocalList = swoLocalHome.findByQuotes(salesDocNo, proposalId, swoItemNo);
			} catch (FinderException e) {
			 //	OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findSWOBOForSalesDocNo", null, e);
			}
			Iterator iterator = swoLocalList.iterator();

			while (iterator.hasNext()) {
				swoLocal = (SWOLocal) iterator.next();
				swoBOList.add(getSWOBOForLocal(swoLocal));
			}
		} else if (table != 0 && VARIANCE_SWO_TABLE == table) {
			findSWOBOForEquipmentNo(salesDocNo, proposalId, table);
		}

		return swoBOList;
	}

	/**
	 *  
	 * This method updates the SWO datas 
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
	 * @param swoBO
	 * @param table
	 * @throws DomainException
	 */
	public void updateSWOBO(SWOBO swoBO, int table) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		HistorySWOLocalHome historySWOLocalHome = null;
		HistorySWOLocal historySWOLocal = null;
		SWOKey swoKey = null;
		VarianceSWOKey varianceSWOKey = null;
		VarianceSWOLocalHome varianceSWOLocalHome = null;
		VarianceSWOLocal varianceSWOLocal = null;

		if (table == SWO_TABLE) {
			swoLocalHome = getSWOLocalHome();
			swoKey = new SWOKey(swoBO.getSwoId(), swoBO.getDmId(), swoBO.getCustomerId(), swoBO.getProposalId());
			try {
				swoLocal = swoLocalHome.findByPrimaryKey(swoKey);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "updateSWOBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}

			populateLocalWithBO(swoLocal, swoBO);
		} else if (table == VARIANCE_SWO_TABLE) {
			varianceSWOLocalHome = getVarianceSWOLocalHome();
			varianceSWOKey = new VarianceSWOKey(swoBO.getSwoId(), swoBO.getDmId(), swoBO.getCustomerId(), swoBO.getProposalId());
			try {
				varianceSWOLocal = varianceSWOLocalHome.findByPrimaryKey(varianceSWOKey);
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "updateSWOBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			populateLocalWithBO(varianceSWOLocal, swoBO);
		}
	}

	/**
	 *  
	 * This method returns the max swo bo 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	public SWOBO findMaxSWOBO(int table) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		VarianceSWOLocalHome varianceSWOLocalHome = null;
		VarianceSWOLocal varianceSWOLocal = null;
		HistorySWOLocal historySWOLocal = null;
		HistorySWOLocalHome historySWOLocalHome = null;
		SWOBO swoBO = null;
		Collection swoLocalCollection = null;

		if (table != 0 && table == SWO_TABLE) {
			swoLocalHome = getSWOLocalHome();
			try {
				swoLocalCollection = swoLocalHome.findMaxSWOId();
				Iterator iterateSWO = swoLocalCollection.iterator();
				while (iterateSWO.hasNext()) {
					swoLocal = (SWOLocal) iterateSWO.next();
				}
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findMaxSWOBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			if (swoLocal != null) {
				swoBO = getSWOBOForLocal(swoLocal);
			} else {
				swoBO = new SWOBO();
				swoBO.setSwoId(0);
			}
		} else if (0 != table && VARIANCE_SWO_TABLE == table) {
			varianceSWOLocalHome = getVarianceSWOLocalHome();
			try {
				swoLocalCollection = varianceSWOLocalHome.findMaxVarianceSWOId();
				Iterator iterateSWO = swoLocalCollection.iterator();
				while (iterateSWO.hasNext()) {
					varianceSWOLocal = (VarianceSWOLocal) iterateSWO.next();
				}
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findMaxSWOBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			if (varianceSWOLocal != null) {
				swoBO = getSWOBOForLocal(varianceSWOLocal);
			} else {
				swoBO = new SWOBO();
				swoBO.setSwoId(0);
			}

		} else if (0 != table && HISTORY_SWO_TABLE == table) {
			historySWOLocalHome = getHistorySWOLocalHome();
			try {
				swoLocalCollection = historySWOLocalHome.findMaxSWOId();
				Iterator iterateSWO = swoLocalCollection.iterator();
				while (iterateSWO.hasNext()) {
					historySWOLocal = (HistorySWOLocal) iterateSWO.next();
				}
			} catch (FinderException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findMaxSWOBO", null, e);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			if (historySWOLocal != null) {
				swoBO = getSWOBOForLocal(historySWOLocal);
			} else {
				swoBO = new SWOBO();
				swoBO.setSwoId(0);
			}
		}
		return swoBO;
	}

	/** 
	 * Check if SVC license is present for a proposal
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
	 * @return boolean
	 * @author prakash
	 * @exception 
	 */
	public boolean isSVCLicenseExistForProposal(int proposalID, String transactionName) {

		boolean exist = false;
		SWOLocalHome swoLocalHome = null;
		Collection swoLocalCollection = null;

		swoLocalHome = getSWOLocalHome();

		try {
			if (UtilityConstants.SVCLICENSE_EXIST.equalsIgnoreCase(transactionName)) {
				swoLocalCollection = swoLocalHome.findSVCLicenseForProposal(proposalID, LicenseConstants.SVC_LICENSE_FLAG);
			} else {
				if (UtilityConstants.QUOTE_EXIST.equalsIgnoreCase(transactionName)) {
					swoLocalCollection = swoLocalHome.findSVCLicenseForProposal(proposalID, LicenseConstants.QUOTE_FLAG);
				}
			}

			if (swoLocalCollection != null && swoLocalCollection.size() > 0) {
				exist = true;
			}

		} catch (FinderException ex) {
			exist = false;
		}
		return exist;
	}

	/** 
	 * Check if Proposal has S&S licneses
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * Date March 9, 2004
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean
	 * @author prakash
	 * @exception 
	 */

	public boolean isSandSLicenseExist(int proposalId, String flag) {
		boolean exist = false;
		SWOLocalHome swoLocalHome = null;
		Collection swoLocalCollection = null;
		List swoBOList = new ArrayList();

		swoLocalHome = getSWOLocalHome();

		try {
			swoLocalCollection = swoLocalHome.findBySandSIndicator(proposalId, flag);
		} catch (FinderException ex) {
			exist = false;
		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "isSandSLicenseExist", null, e);
			//swoLocalCollection = isSandSLicenseExistAlternate(proposalId);			
		}

		if (swoLocalCollection != null && swoLocalCollection.size() > 0) {
			Iterator iter = swoLocalCollection.iterator();
			while (iter.hasNext()) {
				SWOLocal swoLocal = (SWOLocal) iter.next();
				SWOBO swoBO = getSWOBOForLocal(swoLocal);
				swoBOList.add(swoBO);
				exist = true;
			}
		}

		return exist;
	}

	/**
	 * @param proposalId
	 * @return
	 */
	public boolean isAllLicensesExcluded(int proposalId) {
		boolean result = false;

		SWOLocalHome swoLocalHome = null;
		Collection swoCollection = null;
		Collection excludedSWOCollection = null;

		try {
			swoCollection = swoLocalHome.findByProposal(proposalId);
			excludedSWOCollection = swoLocalHome.findExcludedLicenses(proposalId);
		} catch (FinderException ex) {

		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "isSandSLicenseExist", null, e);
			//swoLocalCollection = isSandSLicenseExistAlternate(proposalId);			
		}

		return result;

	}

	//	public boolean chkSWOExternalContractNumber(int proposalId) {
	//		SWOLocalHome swoLocalHome = null;
	//		Collection swoLocalCollection = null;
	//		List swoBOList = null;
	//		boolean exist = true;
	//
	//		swoLocalHome = getSWOLocalHome();
	//		
	//		String messageString = OPPTHelper.getLogString(String.valueOf(proposalId));		
	//		OPPTLogger.log("PROPOSAL_ID", OPPTLogger.DEBUG, CLASS_NAME, "chkSWOExternalContractNumber", messageString);
	//		
	//
	//		try {
	//			
	//			swoLocalCollection = swoLocalHome.findByExtContrNumber(proposalId);
	//		} catch (FinderException ex) {
	//			// true means that External Contract number is present for Licenses
	//			return true;
	//		} catch (Exception e) {
	//			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "chkSWOExternalContractNumber", null, e);						
	//		}
	//		
	//		if (null != swoLocalCollection && 0 != swoLocalCollection.size()) {
	//			exist = false;		
	//		}
	//		
	//		return exist;
	//	}

	//	public Collection isSandSLicenseExistAlternate(int proposalId) {
	//		boolean exist = false;
	//		SWOLocalHome swoLocalHome = null;
	//		Collection swoLocalCollection = null;		
	//
	//		swoLocalHome = getSWOLocalHome();
	//		try {
	//			swoLocalCollection = swoLocalHome.findByProposal(proposalId);
	//		} catch (FinderException ex) {
	//			// leave blank.. Dont do anything 
	//		} catch (Exception e) {
	//		OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "isSandSLicenseExist", null, e);
	//		}
	//		
	//		return swoLocalCollection;
	//	}
	//

	/**
	 *  
	 * This method finds the Max Sequence no for the SWO 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	public SWOBO findMaxSequenceNo(String salesDocNo, String swoItemNo, int proposalId, int table) throws DomainException {
		String methodName = "findMaxSequenceNo";
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		SWOBO swoBO = null;
		Collection swoLocalCollection = null;

		if (table != 0 && table == SWO_TABLE) {
			swoLocalHome = getSWOLocalHome();
			try {
				swoLocal = swoLocalHome.findMaxSquenceNo(salesDocNo, swoItemNo, proposalId);
				OPPTLogger.debug("Max Sequence NO---Factory" + swoLocal.getSequenceNo(), CLASS_NAME, methodName);
				swoBO = getSWOBOForLocal(swoLocal);
			} catch (FinderException e) {
				swoBO = new SWOBO();
				swoBO.setSequenceNo(0);
			}
		}
		return swoBO;
	}

	/**
	 *  
	 * This method finds the Max Bump Ind for the SWO 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 13, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param table
	 * @return
	 * @throws DomainException
	 */
	public SWOBO findMaxBumpInd(String salesDocNo, String swoItemNo, int proposalId, int table) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		SWOBO swoBO = null;
		Collection swoLocalCollection = null;

		if (table != 0 && table == SWO_TABLE) {
			swoLocalHome = getSWOLocalHome();
			try {
				swoLocalCollection = swoLocalHome.findMaxBumpInd(salesDocNo, swoItemNo, proposalId);
				Iterator iterateSWO = swoLocalCollection.iterator();
				while (iterateSWO.hasNext()) {
					swoLocal = (SWOLocal) iterateSWO.next();
				}
				if (swoLocal != null) {
					swoBO = getSWOBOForLocal(swoLocal);
				}
			} catch (FinderException e) {
				swoBO = new SWOBO();
				swoBO.setBumpInd(LicenseConstants.LICENSE_BUMPED);
			}
		}
		return swoBO;
	}

	/** 
	 * To get the swo local home
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
	 * @return SWOLocalHome 
	 */
	private SWOLocalHome getSWOLocalHome() {
		return (SWOLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(SWO_LOCAL_HOME);
	}

	/** 
	 * To get the swo history local home
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
	 * @return HistorySWOLocalHome 
	 */
	private HistorySWOLocalHome getHistorySWOLocalHome() {
		return (HistorySWOLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(HISTORY_SWO_LOCAL_HOME);
	}

	/** 
	 * To get the Variance swo local home
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return VarianceSWOLocalHome 
	 * @author Venkat
	 */

	private VarianceSWOLocalHome getVarianceSWOLocalHome() {
		return (VarianceSWOLocalHome) ServiceLocator.getEJBHomeFactory().getLocalHome(VARIANCE_SWO_LOCAL_HOME);
	}

	/** 
	 * Removes the SVC Licenses from the proposal
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 12, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @param table
	 * @throws DomainException 
	 */
	public void removeSVCLicensesOfProposal(int proposalID, int table) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		Collection svcLicenses = null;

		if (table == SWO_TABLE) {
			swoLocalHome = getSWOLocalHome();
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "SWOBOFactory", "removeSVCLicensesOfProposal", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		try {
			svcLicenses = swoLocalHome.findSVCLicenseForProposal(proposalID, LicenseConstants.SVC_LICENSE_FLAG);
			if (svcLicenses != null && svcLicenses.size() > 0) {
				Iterator iterateSVCLicense = svcLicenses.iterator();
				SWOLocal swoLocal = null;
				while (iterateSVCLicense.hasNext()) {
					swoLocal = (SWOLocal) iterateSVCLicense.next();
					swoLocal.getEJBLocalHome().remove(swoLocal.getPrimaryKey());
				}
			} else {
				return;
			}
		} catch (FinderException e) {
			// SVC Licenses might not be present in the proposal
			return;
		} catch (Exception e) {
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "SWOBOFactory", "removeSVCLicensesOfProposal", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
	}

	/** 
		 * Removes the Quotes from the proposal
		 *  
		 * <br><b>Known Bugs
		 * </b><br> 
		 * 
		 * <br><PRE> 
		 * date Feb 14, 2004 
		 * 
		 * revision date author reason 
		 * 
		 * </PRE><br> 
		 * 
		 * @param proposalID
		 * @param table
		 * @throws DomainException
		 * @author Saravanan Viswanathan 
		 */
	public boolean removeQuotes(int proposalID, int table) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		Collection quotes = null;
		boolean returnvalue = false;

		if (table == SWO_TABLE) {
			swoLocalHome = getSWOLocalHome();
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "SWOBOFactory", "removeQuotes", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}

		try {
			// This method is for finding quotes in a proposal. The item category flag passed is B which will identify quotes in the proposal
			quotes = swoLocalHome.findSVCLicenseForProposal(proposalID, LicenseConstants.QUOTE_FLAG);
			if (quotes != null && quotes.size() > 0)
				returnvalue = true;
			if (returnvalue) {
				Iterator iterateQuote = quotes.iterator();
				SWOLocal swoLocal = null;
				while (iterateQuote.hasNext()) {
					swoLocal = (SWOLocal) iterateQuote.next();
					swoLocal.remove();
				}
			} else {
				return returnvalue;
			}
		} catch (FinderException e) {
			// Quotes might not be present in the proposal
			return returnvalue;
		} catch (Exception e) {
			OPPTLogger.log(ErrorCodeConstants.APP_GENERAL_EXCEPTION, OPPTLogger.ERROR, "SWOBOFactory", "removeQuotes", null);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		return returnvalue;
	}

	/**
	 * @param equipmentNo
	 * @param salesDocNo
	 * @param proposalId
	 * @return
	 * @throws DomainException
	 */
	public SWOBO findSWOBOForEquipmentAndSalesDocNo(String equipmentNo, String salesDocNo, int proposalId) throws DomainException {
		SWOBO swoBO = null;
		SWOLocal swoLocal = null;
		SWOLocalHome swoLocalHome = getSWOLocalHome();

		try {
			swoLocal = swoLocalHome.findByEquimentAndSalesDocNo(equipmentNo, salesDocNo, proposalId);
			swoBO = getSWOBOForLocal(swoLocal);
		} catch (FinderException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findSWOBOForEquipmentAndSalesDocNo", null, e);
		}

		return swoBO;
	}

	/**
	 * @param proposalId
	 * @param swoNo
	 * @param serialNo
	 * @return
	 * @throws DomainException
	 */
	public List findBySwoNoSerialNo(int proposalId, String swoNo, String serialNo) throws DomainException {

		SWOBO swoBO = null;
		SWOLocal swoLocal = null;
		SWOLocalHome swoLocalHome = getSWOLocalHome();
		Collection swoLocalList = null;
		List swoBOList = new ArrayList();

		try {
			swoLocalList = swoLocalHome.findBySwoNoSerialNo(proposalId, swoNo, serialNo);
		} catch (FinderException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findBySwoNoSerialNO", null, e);
		}
		if (swoLocalList != null) {
			Iterator iterator = swoLocalList.iterator();
			while (iterator.hasNext()) {
				swoLocal = (SWOLocal) iterator.next();
				swoBOList.add(getSWOBOForLocal(swoLocal));
			}
		}

		return swoBOList;

	}
	
	
	/* CR6153 start change */
	public List findSWOBOForEquipSoldToPartyDM(String equipmentNo, int proposalId,int customerId, int dmId) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		
		Collection swoLocalList = null;

		List swoBOList = null;
		swoBOList = new ArrayList();
		
		swoLocalHome = getSWOLocalHome();
		try {
			swoLocalList = swoLocalHome.findByEquipSoldToPartyDM(equipmentNo, proposalId,customerId, dmId);
		} catch (FinderException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findSWOBOForEquipSoldToPartyDM", null, e);
		}
		if(swoLocalList != null){
			Iterator iterator = swoLocalList.iterator();
			
			while (iterator.hasNext()) {
				swoLocal = (SWOLocal) iterator.next();
				swoBOList.add(getSWOBOForLocal(swoLocal));
			}
		}
		return swoBOList;
	}
	
	public List findSWOBOForQuotesSoldToPartyDM(String salesDocNo, int proposalId, String swoItemNo, int customerId, int dmId) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		Collection swoLocalList = null;
		List swoBOList = null;
		swoBOList = new ArrayList();
	
		swoLocalHome = getSWOLocalHome();
		try {
			swoLocalList = swoLocalHome.findByQuotesSoldToPartyDM(salesDocNo, proposalId, swoItemNo, customerId, dmId);
		} catch (FinderException e) {
		 	OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findSWOBOForQuotesSoldToPartyDM", null, e);
		}
		if(swoLocalList != null){
			Iterator iterator = swoLocalList.iterator();
	
			while (iterator.hasNext()) {
				swoLocal = (SWOLocal) iterator.next();
				swoBOList.add(getSWOBOForLocal(swoLocal));
			}
		}
		return swoBOList;
	}
	
	public List findBySWONoSalesDocSwoItemNo(int proposalId, String swoNo, String salesDocNo, String swoItemNo) throws DomainException {
		SWOLocalHome swoLocalHome = null;
		SWOLocal swoLocal = null;
		Collection swoLocalList = null;
		List swoBOList = null;
		swoBOList = new ArrayList();
	
		swoLocalHome = getSWOLocalHome();
		try {
			swoLocalList = swoLocalHome.findBySWONoSalesDocSwoItemNo(proposalId, swoNo, salesDocNo, swoItemNo);
		} catch (FinderException e) {
		 	OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "findSWOBOForQuotesSoldToPartyDM", null, e);
		}
		if(swoLocalList != null){
			Iterator iterator = swoLocalList.iterator();
	
			while (iterator.hasNext()) {
				swoLocal = (SWOLocal) iterator.next();
				swoBOList.add(getSWOBOForLocal(swoLocal));
			}
		}
		return swoBOList;
	}
	/* CR6153 end change */
	
}
