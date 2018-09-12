/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.swomgr;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.bo.CustomerBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.customer.factory.CustomerBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CopyInventoryDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.CustomerDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.DMDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.EEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.PriceProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ProposalDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.SWODomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.TempEEDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ProposalContractBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo.EEBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo.PriceBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo.SWOBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.bo.TempEEBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.factory.EEBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.factory.PriceBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.factory.SWOBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.swo.factory.TempEEBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.service.helper.PricingComponentHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ActionNameConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.LicenseConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTCalender;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorKey;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.OPPTMessageCatalog;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
/**
 *  
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
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
public class SWOInfoBean implements javax.ejb.SessionBean {
	private javax.ejb.SessionContext mySessionCtx;
	private final int COPY = 1;
	private final String CLASS_NAME = "SWOInfoBean";

	/**
	 * To copy the inventory for the given proposal  
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
	 * @param copyInventoryDomainDTO
	 * @throws ServiceException
	 */
	public void copyInventory(CopyInventoryDomainDTO copyInventoryDomainDTO) throws ServiceException {
		SWOBOFactory swoBOFactory = new SWOBOFactory();
		List list = new ArrayList();
		SWOBO swoBO;
		SWOBO maxSeqSWOBO;
		int maxSWOId = 0;
		String methodName = "copyInventory";
		/* CR6153 start change */
		ProposalContractBO proposal = null;
		ProposalContractBOFactory proposalBOFactory = new ProposalContractBOFactory();
		/* CR6153 end change */
		
		try {
			if (copyInventoryDomainDTO.getActionName() != null && copyInventoryDomainDTO.getActionName().equals(ActionNameConstants.COPY_INVENTORY_SWO)) {
				swoBO = swoBOFactory.getSWOBO(copyInventoryDomainDTO.getOldProposalID(), copyInventoryDomainDTO.getOldCustomerID(), copyInventoryDomainDTO.getOldDMID(), copyInventoryDomainDTO.getOldSWOID(), SWOBOFactory.SWO_TABLE);
				populateSWOBO(swoBO, copyInventoryDomainDTO);
				maxSWOId = swoBOFactory.findMaxSWOBO(SWOBOFactory.SWO_TABLE).getSwoId();
				swoBO.setSwoId(maxSWOId + 1);
				copyInventoryDomainDTO.setNewSWOID(swoBO.getSwoId());
				maxSeqSWOBO = swoBOFactory.findMaxSequenceNo(swoBO.getSalesDocNo(), swoBO.getSwoItemNo(), swoBO.getProposalId(), SWOBOFactory.SWO_TABLE);
				swoBO.setSequenceNo(maxSeqSWOBO.getSequenceNo() + 1);
				if (swoBO.getSerialNo() != null && swoBO.getSerialNo().length() < 18) {
					swoBO.setSerialNo(swoBO.getSerialNo() + LicenseConstants.LICENSE_PLANNED);
				}
				swoBO.setPlannedInd(LicenseConstants.LICENSE_PLANNED);
				swoBOFactory.createSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
				copyEE(copyInventoryDomainDTO, swoBO.getSequenceNo());

			} else if (ActionNameConstants.CREATE_VARIANCEPROPOSAL.equalsIgnoreCase(copyInventoryDomainDTO.getActionName())) {
				list = swoBOFactory.findSWOBOForDM(copyInventoryDomainDTO.getOldDMID(), copyInventoryDomainDTO.getOldCustomerID(), copyInventoryDomainDTO.getOldProposalID(), SWOBOFactory.VARIANCE_SWO_TABLE);
			} else if (
				copyInventoryDomainDTO.getActionName() != null
					&& copyInventoryDomainDTO.getActionName().equals(ActionNameConstants.COPY_INVENTORY_CUSTOMER)
					|| copyInventoryDomainDTO.getActionName().equals(ActionNameConstants.COPY_INVENTORY_DM)
					|| copyInventoryDomainDTO.getActionName().equals(ActionNameConstants.COPY_PROPOSAL)
					|| copyInventoryDomainDTO.getActionName().equals(ActionNameConstants.REPLACE_CONTRACT)
					|| copyInventoryDomainDTO.getActionName().equals(ActionNameConstants.AMEND_CONTRACT)) {
				list = swoBOFactory.findSWOBOForDM(copyInventoryDomainDTO.getOldDMID(), copyInventoryDomainDTO.getOldCustomerID(), copyInventoryDomainDTO.getOldProposalID(), SWOBOFactory.SWO_TABLE);
			}

			Iterator iter = list.iterator();
			Map values = copyInventoryDomainDTO.getValues();
			
			/* CR6153 start change */
			try {
				proposal = proposalBOFactory.getProposalContractBO(copyInventoryDomainDTO.getOldProposalID());
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}
			/* CR6153 end change */
			
			while (iter.hasNext()) {
				swoBO = (SWOBO) iter.next();
				if (ActionNameConstants.COPY_INVENTORY_CUSTOMER.equals(copyInventoryDomainDTO.getActionName()) || ActionNameConstants.COPY_INVENTORY_DM.equals(copyInventoryDomainDTO.getActionName())) {
					if (swoBO.isSAndS()) {
						// we do not do copy for s and s products 
						continue;
					}
				}
				String actionName = copyInventoryDomainDTO.getActionName();
				/* CR6153 start change */
				if((proposal.getExtendPeriod() != null) && (proposal.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
					if ((ActionNameConstants.REPLACE_CONTRACT.equalsIgnoreCase(actionName)) 
						|| (ActionNameConstants.RENEW_CONTRACT.equalsIgnoreCase(actionName)) ){
							java.sql.Date replaceDate = null;
							if (values != null && values.get(UtilityConstants.PLAN_START_DATE) != null) {
								replaceDate = (java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE);
							}
							if((replaceDate.after(swoBO.getPlanStartDate()) && (replaceDate.before(swoBO.getPlanEndDate())))){
								swoBO.setPlanStartDate((java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE));
							}
							swoBO.setPlanStartDate(swoBO.getPlanStartDate());
						}
				}
				else{
			    /* CR6153 end change */
					if (ActionNameConstants.REPLACE_CONTRACT.equalsIgnoreCase(actionName)) {
						if (values != null && values.get(UtilityConstants.PLAN_START_DATE) != null) {
							swoBO.setPlanStartDate((java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE));
							swoBO.setPlanEndDate((java.sql.Date) values.get(UtilityConstants.PLAN_END_DATE));
						}
					swoBO.setLockedInd(LicenseConstants.LICENSE_UNLOCKED);
					} else if (ActionNameConstants.COPY_PROPOSAL.equalsIgnoreCase(actionName)) {
						swoBO.setLockedInd(LicenseConstants.LICENSE_UNLOCKED);
					} else if (ActionNameConstants.CREATE_VARIANCEPROPOSAL.equalsIgnoreCase(actionName)) {
						if (values != null && values.get(UtilityConstants.PLAN_START_DATE) != null) {
							swoBO.setPlanStartDate((java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE));
							swoBO.setPlanEndDate((java.sql.Date) values.get(UtilityConstants.PLAN_END_DATE));
						}
					}
				/* CR6153 start change */
				}
				/* CR6153 end change */
				copyInventoryDomainDTO.setOldSWOID(swoBO.getSwoId());
				// old swo id is set
				populateSWOBO(swoBO, copyInventoryDomainDTO);

				if (maxSWOId == 0) {
					maxSWOId = swoBOFactory.findMaxSWOBO(SWOBOFactory.SWO_TABLE).getSwoId();
				} else {
					maxSWOId++;
				}
				swoBO.setSwoId(maxSWOId + 1);
				swoBO.setProposalId(copyInventoryDomainDTO.getNewProposalID());
				swoBO.setCustomerId(copyInventoryDomainDTO.getNewCustomerID());
				swoBO.setDmId(copyInventoryDomainDTO.getNewDMID());

				if (copyInventoryDomainDTO.getActionName().equals(ActionNameConstants.COPY_INVENTORY_CUSTOMER) || copyInventoryDomainDTO.getActionName().equals(ActionNameConstants.COPY_INVENTORY_DM)) {
					maxSeqSWOBO = swoBOFactory.findMaxSequenceNo(swoBO.getSalesDocNo(), swoBO.getSwoItemNo(), swoBO.getProposalId(), SWOBOFactory.SWO_TABLE);
					swoBO.setSequenceNo(maxSeqSWOBO.getSequenceNo() + 1);
					if (swoBO.getSerialNo() != null && swoBO.getSerialNo().length() < 18) {
						swoBO.setSerialNo(swoBO.getSerialNo() + LicenseConstants.LICENSE_PLANNED);
					}
					swoBO.setPlannedInd(LicenseConstants.LICENSE_PLANNED);

				}

				// max + 1 for id
				copyInventoryDomainDTO.setNewSWOID(swoBO.getSwoId());
				swoBOFactory.createSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
				copyEE(copyInventoryDomainDTO, swoBO.getSequenceNo());
			}
		} catch (DomainException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}
	}
	
	/**
	 * To copy the inventory for the variance proposal  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Aug 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param copyInventoryDomainDTO
	 * @throws ServiceException
	 * Method added by Sara to be used for Variance proposal. Changed on 23 Aug,2004
	 */
	public void copyInventory(DMDomainDTO dmDomainDTO,CopyInventoryDomainDTO copyInventoryDomainDTO) throws ServiceException {
		SWOBOFactory swoBOFactory = new SWOBOFactory();
		List list = new ArrayList();
		SWOBO swoBO;
		SWOBO maxSeqSWOBO;
		int maxSWOId = 0;
		String methodName = "copyInventory";
		try {
			list = dmDomainDTO.getSWODTOList();

			Iterator iter = list.iterator();
			Map values = copyInventoryDomainDTO.getValues();
			while (iter.hasNext()) {
				SWODomainDTO swoDomainDTO = (SWODomainDTO) iter.next();
				swoBO = new SWOBO();
				swoBO = populateSWOBO(swoDomainDTO,swoBO); 
				if (values != null && values.get(UtilityConstants.PLAN_START_DATE) != null) {
					swoBO.setPlanStartDate((java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE));
					swoBO.setPlanEndDate((java.sql.Date) values.get(UtilityConstants.PLAN_END_DATE));
				}
				populateSWOBO(swoBO, copyInventoryDomainDTO);

				if (maxSWOId == 0) {
					maxSWOId = swoBOFactory.findMaxSWOBO(SWOBOFactory.SWO_TABLE).getSwoId();
				} else {
					maxSWOId++;
				}
				swoBO.setSwoId(maxSWOId + 1);
				swoBO.setProposalId(copyInventoryDomainDTO.getNewProposalID());
				swoBO.setCustomerId(copyInventoryDomainDTO.getNewCustomerID());
				swoBO.setDmId(copyInventoryDomainDTO.getNewDMID());

				// max + 1 for id
				copyInventoryDomainDTO.setNewSWOID(swoBO.getSwoId());
				swoBOFactory.createSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
				copyEE(swoDomainDTO,copyInventoryDomainDTO,swoBO.getSequenceNo());
			}
		} catch (DomainException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}
	}	

	/** 
	 * To populate the swo BO using the copy inventory domaindto
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
	 * @param swoBO
	 * @param copyInventoryDomainDTO 
	 */
	private void populateSWOBO(SWOBO swoBO, CopyInventoryDomainDTO copyInventoryDomainDTO) {
		Map map = copyInventoryDomainDTO.getValues();
		switch (copyInventoryDomainDTO.getChoice()) {
			case COPY :
				Date planStartDate = new Date(((java.util.Date) map.get(UtilityConstants.PLAN_START_DATE)).getTime());
				Date planEndDate = new Date(((java.util.Date) map.get(UtilityConstants.PLAN_END_DATE)).getTime());
				swoBO.setPlanStartDate(planStartDate);
				swoBO.setPlanEndDate(planEndDate);

			default :
				swoBO.setProposalId(copyInventoryDomainDTO.getNewProposalID());
				swoBO.setCustomerId(copyInventoryDomainDTO.getNewCustomerID());
				swoBO.setDmId(copyInventoryDomainDTO.getNewDMID());
				swoBO.setLastUpdatedDate(new Date(System.currentTimeMillis()));
		}
	}

	/** 
	 * To copy the ee
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
	 * @param copyInventoryDomainDTO 
	 * @throws ServiceException
	 */
	private void copyEE(CopyInventoryDomainDTO copyInventoryDomainDTO, int seqNo) throws ServiceException {
		EEBOFactory eeBOFactory = new EEBOFactory();
		/* CR6153 start change */
		ProposalContractBO proposal = null;
		ProposalContractBOFactory proposalBOFactory = new ProposalContractBOFactory();
		
		try {
			proposal = proposalBOFactory.getProposalContractBO(copyInventoryDomainDTO.getOldProposalID());
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}
		/* CR6153 end change */
		try {
			
			List list = new ArrayList();
			if (copyInventoryDomainDTO.getActionName().equalsIgnoreCase(ActionNameConstants.CREATE_VARIANCEPROPOSAL)) {
				list = eeBOFactory.findEEBOForSWO(copyInventoryDomainDTO.getOldProposalID(), copyInventoryDomainDTO.getOldCustomerID(), copyInventoryDomainDTO.getOldDMID(), copyInventoryDomainDTO.getOldSWOID(), EEBOFactory.EE_VARIANCE_TABLE);

			} else {

				list = eeBOFactory.findEEBOForSWO(copyInventoryDomainDTO.getOldProposalID(), copyInventoryDomainDTO.getOldCustomerID(), copyInventoryDomainDTO.getOldDMID(), copyInventoryDomainDTO.getOldSWOID(), EEBOFactory.EE_TABLE);
			}

			Iterator iter = list.iterator();
			EEBO eeBO;
			EEBO maxEEBO;
			int maxeeId = 0;

			while (iter.hasNext()) {
				eeBO = (EEBO) iter.next();
				copyInventoryDomainDTO.setOldEEID(eeBO.getEeId());
				populateEEBO(eeBO, copyInventoryDomainDTO);
				if (maxeeId == 0) {
					maxEEBO = eeBOFactory.findMaxEEBO(EEBOFactory.EE_TABLE);
					maxeeId = maxEEBO.getEeId();
				} else {
					maxeeId++;
				}
				eeBO.setEeId(maxeeId + 1);
				// max ee + 1
				
				/* CR6153 start change */
				if((proposal.getExtendPeriod() != null) && (proposal.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
					if ((ActionNameConstants.REPLACE_CONTRACT.equalsIgnoreCase(copyInventoryDomainDTO.getActionName()))
							|| (ActionNameConstants.RENEW_CONTRACT.equalsIgnoreCase(copyInventoryDomainDTO.getActionName()))){
				
						Map values = copyInventoryDomainDTO.getValues();
						java.sql.Date replaceDate = null;
						if (values != null && values.get(UtilityConstants.PLAN_START_DATE) != null) {
							replaceDate = (java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE);
						}
						if((replaceDate.after(eeBO.getPlanStartDate()) && (replaceDate.before(eeBO.getPlanEndDate())))){
							eeBO.setPlanStartDate((java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE));
							
						}
					}
				}
				/* CR6153 end change */
				
				eeBO.setProposalId(copyInventoryDomainDTO.getNewProposalID());
				eeBO.setCustomerId(copyInventoryDomainDTO.getNewCustomerID());
				eeBO.setDmId(copyInventoryDomainDTO.getNewDMID());
				eeBO.setSwoId(copyInventoryDomainDTO.getNewSWOID());
				eeBO.setSequenceNo(seqNo);

				copyInventoryDomainDTO.setNewEEID(eeBO.getEeId());

				eeBOFactory.createEEBO(eeBO, EEBOFactory.EE_TABLE);

				copyPrice(copyInventoryDomainDTO);
			}
		} catch (DomainException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "copyEE", null, e);
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}
	}

	/** 
	 * To copy the ee for variance proposal
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Aug 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param copyInventoryDomainDTO 
	 * @throws ServiceException
	 * Method added by Sara for copying EE for variance proposal.Changed on 23 Aug, 2004 
	 */
	private void copyEE(SWODomainDTO swoDomainDTO,CopyInventoryDomainDTO copyInventoryDomainDTO, int seqNo) throws ServiceException {
		EEBOFactory eeBOFactory = new EEBOFactory();

		try {
			List list = new ArrayList();
			list = swoDomainDTO.getEEDTOList();

			Iterator iter = list.iterator();
			EEBO eeBO;
			EEBO maxEEBO;
			int maxeeId = 0;

			while (iter.hasNext()) {
				EEDomainDTO eeDomainDTO = (EEDomainDTO) iter.next();
				eeBO = new EEBO();
				eeBO = populateEEBO(eeDomainDTO,eeBO);
				
				populateEEBO(eeBO, copyInventoryDomainDTO);
				
				if (maxeeId == 0) {
					maxEEBO = eeBOFactory.findMaxEEBO(EEBOFactory.EE_TABLE);
					maxeeId = maxEEBO.getEeId();
				} else {
					maxeeId++;
				}
				eeBO.setEeId(maxeeId + 1);
				// max ee + 1
				eeBO.setProposalId(copyInventoryDomainDTO.getNewProposalID());
				eeBO.setCustomerId(copyInventoryDomainDTO.getNewCustomerID());
				eeBO.setDmId(copyInventoryDomainDTO.getNewDMID());
				eeBO.setSwoId(copyInventoryDomainDTO.getNewSWOID());
				eeBO.setSequenceNo(seqNo);

				copyInventoryDomainDTO.setNewEEID(eeBO.getEeId());

				eeBOFactory.createEEBO(eeBO, EEBOFactory.EE_TABLE);

				copyPrice(eeDomainDTO,copyInventoryDomainDTO);
			}
		} catch (DomainException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "copyEE", null, e);
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}
	}
	/** 
	 * To populate the swo BO using the copy inventory domaindto
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
	 * @param eeBO
	 * @param copyInventoryDomainDTO 
	 */
	private void populateEEBO(EEBO eeBO, CopyInventoryDomainDTO copyInventoryDomainDTO) {
		Map map = copyInventoryDomainDTO.getValues();
		switch (copyInventoryDomainDTO.getChoice()) {
			case COPY :
				Date planStartDate = new Date(((java.util.Date) map.get(UtilityConstants.PLAN_START_DATE)).getTime());
				Date planEndDate = new Date(((java.util.Date) map.get(UtilityConstants.PLAN_END_DATE)).getTime());
				eeBO.setPlanStartDate(planStartDate);
				eeBO.setPlanEndDate(planEndDate);

			default :
				eeBO.setProposalId(copyInventoryDomainDTO.getNewProposalID());
				eeBO.setCustomerId(copyInventoryDomainDTO.getNewCustomerID());
				eeBO.setDmId(copyInventoryDomainDTO.getNewDMID());
				eeBO.setSwoId(copyInventoryDomainDTO.getNewSWOID());
		}
	}

	/** 
	 * To copy the price details
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
	 * @param copyInventoryDomainDTO 
	 * @throws ServiceException
	 */
	private void copyPrice(CopyInventoryDomainDTO copyInventoryDomainDTO) throws ServiceException {
		PriceBOFactory priceBOFactory = new PriceBOFactory();
		/* CR6153 start change */
		ProposalContractBO proposal = null;
		ProposalContractBOFactory proposalBOFactory = new ProposalContractBOFactory();
	
		try {
			proposal = proposalBOFactory.getProposalContractBO(copyInventoryDomainDTO.getOldProposalID());
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}
		/* CR6153 end change */
		try {
			List list = new ArrayList();
			if (copyInventoryDomainDTO.getActionName().equalsIgnoreCase(ActionNameConstants.CREATE_VARIANCEPROPOSAL)) {
				list = priceBOFactory.findPriceBOForEE(copyInventoryDomainDTO.getOldEEID(), copyInventoryDomainDTO.getOldSWOID(), copyInventoryDomainDTO.getOldDMID(), copyInventoryDomainDTO.getOldCustomerID(), copyInventoryDomainDTO.getOldProposalID(), PriceBOFactory.VARIANCE_PRICE_TABLE);

			} else {
				list = priceBOFactory.findPriceBOForEE(copyInventoryDomainDTO.getOldEEID(), copyInventoryDomainDTO.getOldSWOID(), copyInventoryDomainDTO.getOldDMID(), copyInventoryDomainDTO.getOldCustomerID(), copyInventoryDomainDTO.getOldProposalID(), PriceBOFactory.PRICE_TABLE);

			}

			Iterator iter = list.iterator();
			PriceBO priceBO;
			int maxPriceId = 0;
			PriceBO maxPriceBO;

			while (iter.hasNext()) {
				priceBO = (PriceBO) iter.next();
				populatePriceBO(priceBO, copyInventoryDomainDTO);
				if (maxPriceId == 0) {
					maxPriceBO = priceBOFactory.findMaxPriceBO(PriceBOFactory.PRICE_TABLE);
					maxPriceId = maxPriceBO.getPriceId();
				} else {
					maxPriceId++;
				}

				priceBO.setPriceId(maxPriceId + 1);
				// max price-id + 1
				
				/* CR6153 start change */
				if((proposal.getExtendPeriod() != null) && (proposal.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
					if ((ActionNameConstants.REPLACE_CONTRACT.equalsIgnoreCase(copyInventoryDomainDTO.getActionName())) 
						|| (ActionNameConstants.RENEW_CONTRACT.equalsIgnoreCase(copyInventoryDomainDTO.getActionName()))) {
						Map values = copyInventoryDomainDTO.getValues();
						java.sql.Date replaceDate = null;
						if (values != null && values.get(UtilityConstants.PLAN_START_DATE) != null) {
							replaceDate = (java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE);
						}
						if((replaceDate.after(priceBO.getBillPlanStartDate()) && (replaceDate.before(priceBO.getBillPlanEndDate())))){
							priceBO.setBillPlanStartDate((java.sql.Date) values.get(UtilityConstants.PLAN_START_DATE));
							
						}
					}
				}
				/* CR6153 end change */
				
				priceBO.setProposalId(copyInventoryDomainDTO.getNewProposalID());
				priceBO.setCustomerId(copyInventoryDomainDTO.getNewCustomerID());
				priceBO.setDmId(copyInventoryDomainDTO.getNewDMID());
				priceBO.setSwoId(copyInventoryDomainDTO.getNewSWOID());
				priceBO.setEeId(copyInventoryDomainDTO.getNewEEID());

				priceBOFactory.createPriceBO(priceBO, PriceBOFactory.PRICE_TABLE);
			}
		} catch (DomainException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "copyPrice", null, e);
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}
	}

	/** 
	 * To copy the price details for variance proposal
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Aug 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param copyInventoryDomainDTO 
	 * @throws ServiceException
	 * Method added by Sara for copying Variance proposal. Changed on 23 Aug 2004
	 */
	private void copyPrice(EEDomainDTO eeDomainDTO,CopyInventoryDomainDTO copyInventoryDomainDTO) throws ServiceException {
		PriceBOFactory priceBOFactory = new PriceBOFactory();
		
		try {
			
			List list = new ArrayList();
			list = eeDomainDTO.getPriceDTOList();

			Iterator iter = list.iterator();
			PriceBO priceBO;
			int maxPriceId = 0;
			PriceBO maxPriceBO;

			while (iter.hasNext()) {
				PriceDomainDTO priceDomainDTO = (PriceDomainDTO) iter.next();
				priceBO = new PriceBO();
				priceBO = populatePriceBO(priceDomainDTO,priceBO);
				populatePriceBO(priceBO, copyInventoryDomainDTO);
				if (maxPriceId == 0) {
					maxPriceBO = priceBOFactory.findMaxPriceBO(PriceBOFactory.PRICE_TABLE);
					maxPriceId = maxPriceBO.getPriceId();
				} else {
					maxPriceId++;
				}

				priceBO.setPriceId(maxPriceId + 1);
				// max price-id + 1
				priceBO.setProposalId(copyInventoryDomainDTO.getNewProposalID());
				priceBO.setCustomerId(copyInventoryDomainDTO.getNewCustomerID());
				priceBO.setDmId(copyInventoryDomainDTO.getNewDMID());
				priceBO.setSwoId(copyInventoryDomainDTO.getNewSWOID());
				priceBO.setEeId(copyInventoryDomainDTO.getNewEEID());

				priceBOFactory.createPriceBO(priceBO, PriceBOFactory.PRICE_TABLE);
			}
		} catch (DomainException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "copyPrice", null, e);
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}
	}
	/** 
	 * To populate the price bo using copy inventory domaindto
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
	 * @param copyInventoryDomainDTO 
	 */
	private void populatePriceBO(PriceBO priceBO, CopyInventoryDomainDTO copyInventoryDomainDTO) {
		switch (copyInventoryDomainDTO.getChoice()) {
			default :
				priceBO.setProposalId(copyInventoryDomainDTO.getNewProposalID());
				priceBO.setCustomerId(copyInventoryDomainDTO.getNewCustomerID());
				priceBO.setDmId(copyInventoryDomainDTO.getNewDMID());
				priceBO.setSwoId(copyInventoryDomainDTO.getNewSWOID());
				priceBO.setEeId(copyInventoryDomainDTO.getNewEEID());
				priceBO.setIIndicator(null);
		}
	}

	/**
	 *  
	 * This method stores the SWO,EE and Price information 
	 * During the fetch inventory case
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
	 * @param swoDomainDTO
	 * @throws ServiceException
	 * Changed by Sara for MN19391947 - CMVCDEFECT 352 on 02-June-2004
	 * Changes in bump logic implemented
	 * Changed by Sara for MN20335956 - CMVCDEFECT 58 on 08-Nov-2004
	 * For S&S licenses, the entire data sent from ESW should be stored in OPPT as it is. No bump logic should be applied. 
	 */
	public void storeSWOInfo(List swoDomainDTOList) throws ServiceException {
		//TimeTaken log = new //TimeTaken(CLASS_NAME, "storeSWOInfo");
		SWOBOFactory swoBOFactory = null;
		EEBOFactory eeBOFactory = null;
		PriceBOFactory priceBOFactory = null;
		List eeDomainDTOList = null;
		SWODomainDTO swoDomainDTO = null;
		List priceDomainDTOList = null;
		EEDomainDTO eeDomainDTO = null;
		PriceDomainDTO priceDomainDTO = null;
		SWOBO swoBO = null;
		SWOBO maxSWOBO = null;
		swoBOFactory = new SWOBOFactory();
		eeBOFactory = new EEBOFactory();
		priceBOFactory = new PriceBOFactory();
		Iterator iterateEE = null;
		Iterator iteratePrice = null;
		String methodName = "storeSWOInfo";
		boolean quoteFlag = false;
		int maxSWOId = 0;
		int maxeeId = 0;
		int maxPriceId = 0;
		boolean isBumpDeleted = false;
		List deleteSWOBOList = new ArrayList();
		boolean deleteFlag = false;

		try {
			if (swoDomainDTOList != null && swoDomainDTOList.size() > 0) {
				/* This code is to remove all existing SWO's matching equipment number in RFC */
				/* CR6153 start change */
				SWODomainDTO swoDomainDTO1 = null;
				swoDomainDTO1 = (SWODomainDTO)swoDomainDTOList.get(0);
				ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
				ProposalContractBO proposalBO = new ProposalContractBO(); 
				try {
					proposalBO = proposalContractBOFactory.getProposalContractBO(swoDomainDTO1.getProposalId());
				} catch (DomainException de) {
					throw ExceptionGenerator.generateServiceException(de.getErrorReport());
				}
				
				if((proposalBO.getExtendPeriod() != null) && (proposalBO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
					for (int i = 0; i < swoDomainDTOList.size(); i++) {
						swoDomainDTO = (SWODomainDTO) swoDomainDTOList.get(i);
						List swoBOList = null;
						if (LicenseConstants.QUOTE_FLAG.equals(swoDomainDTO.getItemCategory())) {
							swoBOList = swoBOFactory.findSWOBOForQuotesSoldToPartyDM(swoDomainDTO.getSalesDocNo(), swoDomainDTO.getProposalId(), swoDomainDTO.getSwoItemNo(), swoDomainDTO.getCustomerId(), swoDomainDTO.getDmId());
							quoteFlag = true;
						} else {
							swoBOList = swoBOFactory.findSWOBOForEquipSoldToPartyDM(swoDomainDTO.getEquipmentNo(), swoDomainDTO.getProposalId(),swoDomainDTO.getCustomerId(),swoDomainDTO.getDmId() );
						}
						int swoBOSize = swoBOList.size();
						if (quoteFlag == false && swoBOSize > 0) {
							//Check if the DB EE exists in RFC data, if doesnt exist delete that EE
							for (int y = 0; y < swoBOSize; y++) {
								SWOBO swoBOFromDB = (SWOBO) swoBOList.get(y);
								swoBOFactory.deleteSWOBO(swoBOFromDB, SWOBOFactory.SWO_TABLE);
							}
						}
					}
				}
				else{
				/* CR6153 end change */
					for (int i = 0; i < swoDomainDTOList.size(); i++) {
						swoDomainDTO = (SWODomainDTO) swoDomainDTOList.get(i);
						List swoBOList = null;
						if (LicenseConstants.QUOTE_FLAG.equals(swoDomainDTO.getItemCategory())) {
							swoBOList = swoBOFactory.findSWOBOForQuotes(swoDomainDTO.getSalesDocNo(), swoDomainDTO.getProposalId(), swoDomainDTO.getSwoItemNo(), SWOBOFactory.SWO_TABLE);
							quoteFlag = true;
						} else {
							
							swoBOList = swoBOFactory.findSWOBOForEquipmentNo(swoDomainDTO.getEquipmentNo(), swoDomainDTO.getProposalId(), SWOBOFactory.SWO_TABLE);
						}
						int swoBOSize = swoBOList.size();
						if (quoteFlag == false && swoBOSize > 0) {
							//Check if the DB EE exists in RFC data, if doesnt exist delete that EE
							for (int y = 0; y < swoBOSize; y++) {
								SWOBO swoBOFromDB = (SWOBO) swoBOList.get(y);
								swoBOFactory.deleteSWOBO(swoBOFromDB, SWOBOFactory.SWO_TABLE);
							}
						}
					}
				}
				
				/* Code for removal of SWO ends here */
				
				for (int i = 0; i < swoDomainDTOList.size(); i++) {
					swoDomainDTO = (SWODomainDTO) swoDomainDTOList.get(i);
					List swoBOList = null;
					if(! LicenseConstants.SS_LICENSE_FLAG.equals(swoDomainDTO.getSAndSInd())) { // MN20335956
						/* CR6153 start change */
						if((proposalBO.getExtendPeriod() != null) && (proposalBO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
							if (LicenseConstants.QUOTE_FLAG.equals(swoDomainDTO.getItemCategory())) {
								swoBOList = swoBOFactory.findSWOBOForQuotesSoldToPartyDM(swoDomainDTO.getSalesDocNo(), swoDomainDTO.getProposalId(), swoDomainDTO.getSwoItemNo(), swoDomainDTO.getCustomerId(), swoDomainDTO.getDmId());
								quoteFlag = true;
							} 
							else {
								swoBOList = swoBOFactory.findSWOBOForEquipSoldToPartyDM(swoDomainDTO.getEquipmentNo(), swoDomainDTO.getProposalId(),swoDomainDTO.getCustomerId(),swoDomainDTO.getDmId() );
							}
						}
						else{
						/* CR6153 end change */
							if (LicenseConstants.QUOTE_FLAG.equals(swoDomainDTO.getItemCategory())) {
								swoBOList = swoBOFactory.findSWOBOForQuotes(swoDomainDTO.getSalesDocNo(), swoDomainDTO.getProposalId(), swoDomainDTO.getSwoItemNo(), SWOBOFactory.SWO_TABLE);
								quoteFlag = true;
							} 
							else {
								swoBOList = swoBOFactory.findSWOBOForEquipmentNo(swoDomainDTO.getEquipmentNo(), swoDomainDTO.getProposalId(), SWOBOFactory.SWO_TABLE);
							}
						}
					} // MN20335956

					if (swoBOList == null || swoBOList.size() == 0) {
						if (maxSWOId == 0) {
							maxSWOBO = swoBOFactory.findMaxSWOBO(SWOBOFactory.SWO_TABLE);
							maxSWOId = maxSWOBO.getSwoId();
						} else {
							++maxSWOId;
						}
						int swoId = (maxSWOId + 1);
						OPPTLogger.debug("SWO Id :" + swoId, CLASS_NAME, methodName);
						swoDomainDTO.setSwoId(swoId);
						swoBO = populateSWOBO(swoDomainDTO, swoBO);
						swoBO.setSwoAddedDate(new Date(new java.util.Date().getTime()));
						swoBO.setExclusionId(UtilityConstants.NO);
						swoBO.setSAndSInd(swoDomainDTO.getSAndSInd());
						swoBO.setSwoId(swoId);
						OPPTLogger.debug("SWO Info-- SWO Id :" + swoBO.getSwoId() + "DM Id:" + swoBO.getDmId() + "Customer Id:" + swoBO.getCustomerId() + "Proposal Id:" + swoBO.getProposalId() + "Equp No:" + swoBO.getEquipmentNo(), CLASS_NAME, methodName);
						swoBOFactory.createSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
						eeDomainDTOList = swoDomainDTO.getEEDTOList();
						if (eeDomainDTOList != null) {
							iterateEE = eeDomainDTOList.iterator();
							while (iterateEE.hasNext()) {
								EEBO eeBO = null;
								EEBO maxEEBO = null;
								eeDomainDTO = (EEDomainDTO) iterateEE.next();
								if (maxeeId == 0) {
									maxEEBO = eeBOFactory.findMaxEEBO(EEBOFactory.EE_TABLE);
									maxeeId = maxEEBO.getEeId();
								} else {
									++maxeeId;
								}
								int eeId = (maxeeId + 1);
								//OPPTLogger.debug("EE Id :"+eeId,CLASS_NAME,methodName);
								eeDomainDTO.setSwoId(swoBO.getSwoId());
								eeDomainDTO.setDmId(swoBO.getDmId());
								eeBO = populateEEBO(eeDomainDTO, eeBO);
								eeBO.setEeId(eeId);
								//OPPTLogger.debug("EE Info--EE Id:" + eeBO.getEeId() + "SWO Id :" + eeBO.getSwoId() + "DMId:" + eeBO.getDmId() + "Customer Id:" + eeBO.getCustomerId() + "Proposal Id:" +eeBO.getProposalId() + "EE_Item No :" + eeBO.getEeItemNo() + "Sales doc no" +eeBO.getSalesDocNo(), CLASS_NAME, methodName);
								eeBOFactory.createEEBO(eeBO, EEBOFactory.EE_TABLE);
								priceDomainDTOList = eeDomainDTO.getPriceDTOList();
								if (priceDomainDTOList != null) {
									iteratePrice = priceDomainDTOList.iterator();
									while (iteratePrice.hasNext()) {
										PriceBO priceBO = null;
										PriceBO maxPriceBO = null;
										priceDomainDTO = (PriceDomainDTO) iteratePrice.next();
										if (maxPriceId == 0) {
											maxPriceBO = priceBOFactory.findMaxPriceBO(PriceBOFactory.PRICE_TABLE);
											maxPriceId = maxPriceBO.getPriceId();
										} else {
											++maxPriceId;
										}
										int priceId = (maxPriceId + 1);
										//OPPTLogger.debug("Price :"+priceId,CLASS_NAME,methodName);
										priceDomainDTO.setEeId(eeBO.getEeId());
										priceDomainDTO.setSwoId(eeBO.getSwoId());
										priceDomainDTO.setDmId(eeBO.getDmId());
										priceBO = populatePriceBO(priceDomainDTO, priceBO);
										priceBO.setPriceId(priceId);
										priceBO.setBillingStatus(priceDomainDTO.getBillingStatus());
										//OPPTLogger.debug("Price Info--Price Id:" + priceBO.getPriceId() + "EE Id:" +priceBO.getEeId() + "SWO Id :" + priceBO.getSwoId() + "DM Id:" + priceBO.getDmId() +"Customer Id:" + priceBO.getCustomerId() + "Proposal Id:" + priceBO.getProposalId() +"EE_Item No :" + priceBO.getEeItemNo() + "Sales doc no" + priceBO.getSalesDocNo(),CLASS_NAME, methodName);
										priceBOFactory.createPriceBO(priceBO, PriceBOFactory.PRICE_TABLE);
									}
								}
							}
						}
					} else if (isLicenseBumped(swoBOList)) {
						Iterator iterateSWO = swoBOList.iterator();
						while (iterateSWO.hasNext()) {
							swoBO = (SWOBO) iterateSWO.next();
							if (swoDomainDTO.getSalesDocNo() != null && !(swoDomainDTO.getSalesDocNo().equals(swoBO.getSalesDocNo()))) {
								maxSWOId = 0;
								maxeeId = 0;
								maxPriceId = 0;
								storeBumpInfo(swoDomainDTO, swoBO);
							} else {
								swoBO = populateSWOBO(swoDomainDTO, swoBO);
								swoBO.setLastUpdatedDate(new Date(new java.util.Date().getTime()));
								if (null == swoBO.getBumpInd()) {
									swoBO.setBumpInd(LicenseConstants.LICENSE_BUMPED);
								}
								swoBO.setRefetchId(LicenseConstants.LICENSE_REFETCHED);
								swoBO.setLastUpdatedDate(new Date(new java.util.Date().getTime()));
								OPPTLogger.debug("SWO Info-- SWO Id :" + swoBO.getSwoId() + "DM Id:" + swoBO.getDmId() + "Customer Id:" + swoBO.getCustomerId() + "Proposal Id:" + swoBO.getProposalId() + "Equp No:" + swoBO.getEquipmentNo(), CLASS_NAME, methodName);
								swoBOFactory.updateSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
								List eeLocalList = eeBOFactory.findEEBOForSWO(swoBO.getProposalId(), swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_TABLE);

								iterateEE = swoDomainDTO.getEEDTOList().iterator();
								while (iterateEE.hasNext()) {
									EEBO eeBO = null;
									eeDomainDTO = (EEDomainDTO) iterateEE.next();
									eeBO = populateEEBOLocalList(eeLocalList, eeDomainDTO);
									if (eeBO != null) {
										//OPPTLogger.debug("EE Info--EE Id:" + eeBO.getEeId() + "SWO Id :" + eeBO.getSwoId() + "DMId:" + eeBO.getDmId() + "Customer Id:" + eeBO.getCustomerId() + "Proposal Id:" +eeBO.getProposalId() + "EE_Item No :" + eeBO.getEeItemNo() + "Sales doc no" +eeBO.getSalesDocNo(), CLASS_NAME, methodName);
										eeBOFactory.updateEEBO(eeBO, EEBOFactory.EE_TABLE);

									}
									List priceLocalList = priceBOFactory.findPriceBOForEE(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId(), PriceBOFactory.PRICE_TABLE);
									iteratePrice = eeDomainDTO.getPriceDTOList().iterator();
									while (iteratePrice.hasNext()) {
										PriceBO priceBO = null;
										priceDomainDTO = (PriceDomainDTO) iteratePrice.next();
										priceBO = populatePriceBOLocalList(priceLocalList, priceDomainDTO);
										if (priceBO != null) {
											//OPPTLogger.debug("Price Info--Price Id:" + priceBO.getPriceId() + "EE Id:" +priceBO.getEeId() + "SWO Id :" + priceBO.getSwoId() + "DM Id:" + priceBO.getDmId() +"Customer Id:" + priceBO.getCustomerId() + "Proposal Id:" + priceBO.getProposalId() +"EE_Item No :" + priceBO.getEeItemNo() + "Sales doc no" + priceBO.getSalesDocNo(),CLASS_NAME, methodName);
											priceBOFactory.updatePriceBO(priceBO, PriceBOFactory.PRICE_TABLE);
										}
									}
								}
							}
						}
					} else if (!(isLicenseBumped(swoBOList))) {
						Iterator iterateSWO = swoBOList.iterator();
						while (iterateSWO.hasNext()) {
							swoBO = (SWOBO) iterateSWO.next();
							if (swoDomainDTO.getSalesDocNo() != null && !(swoDomainDTO.getSalesDocNo().equals(swoBO.getSalesDocNo()))) {
								maxSWOId = 0;
								maxeeId = 0;
								maxPriceId = 0;
								storeBumpInfo(swoDomainDTO, swoBO);

							} else {
								swoBO = populateSWOBO(swoDomainDTO, swoBO);
								swoBO.setLastUpdatedDate(new Date(new java.util.Date().getTime()));
								if (!quoteFlag) {
									swoBO.setRefetchId(LicenseConstants.LICENSE_REFETCHED);
								}
								OPPTLogger.debug("SWO Info-- SWO Id :" + swoBO.getSwoId() + "DM Id:" + swoBO.getDmId() + "Customer Id:" + swoBO.getCustomerId() + "Proposal Id:" + swoBO.getProposalId() + "Equp No:" + swoBO.getEquipmentNo(), CLASS_NAME, methodName);
								swoBOFactory.updateSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
								/* Delete all the EE's belonging to the original SWO */
								eeBOFactory.deleteEEBOForSWO(swoBO.getProposalId(), swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_TABLE);
								/* Insert all the EE's that comes as part of RFC for the Original SWO */
								eeDomainDTOList = swoDomainDTO.getEEDTOList();
								if (eeDomainDTOList != null) {
									iterateEE = eeDomainDTOList.iterator();
									while (iterateEE.hasNext()) {
										EEBO eeBO = null;
										EEBO maxEEBO = null;
										eeDomainDTO = (EEDomainDTO) iterateEE.next();
										if (maxeeId == 0) {
											maxEEBO = eeBOFactory.findMaxEEBO(EEBOFactory.EE_TABLE);
											maxeeId = maxEEBO.getEeId();
										} else {
											++maxeeId;
										}
										int eeId = (maxeeId + 1);
										//OPPTLogger.debug("EE Id :"+eeId,CLASS_NAME,methodName);
										eeDomainDTO.setSwoId(swoBO.getSwoId());
										eeDomainDTO.setDmId(swoBO.getDmId());
										eeBO = populateEEBO(eeDomainDTO, eeBO);
										eeBO.setEeId(eeId);
										//OPPTLogger.debug("EE Info--EE Id:" + eeBO.getEeId() + "SWO Id :" + eeBO.getSwoId() + "DMId:" + eeBO.getDmId() + "Customer Id:" + eeBO.getCustomerId() + "Proposal Id:" +eeBO.getProposalId() + "EE_Item No :" + eeBO.getEeItemNo() + "Sales doc no" +eeBO.getSalesDocNo(), CLASS_NAME, methodName);
										eeBOFactory.createEEBO(eeBO, EEBOFactory.EE_TABLE);
										priceDomainDTOList = eeDomainDTO.getPriceDTOList();
										if (priceDomainDTOList != null) {
											iteratePrice = priceDomainDTOList.iterator();
											while (iteratePrice.hasNext()) {
												PriceBO priceBO = null;
												PriceBO maxPriceBO = null;
												priceDomainDTO = (PriceDomainDTO) iteratePrice.next();
												if (maxPriceId == 0) {
													maxPriceBO = priceBOFactory.findMaxPriceBO(PriceBOFactory.PRICE_TABLE);
													maxPriceId = maxPriceBO.getPriceId();
												} else {
													++maxPriceId;
												}
												int priceId = (maxPriceId + 1);
												//OPPTLogger.debug("Price :"+priceId,CLASS_NAME,methodName);
												priceDomainDTO.setEeId(eeBO.getEeId());
												priceDomainDTO.setSwoId(eeBO.getSwoId());
												priceDomainDTO.setDmId(eeBO.getDmId());
												priceBO = populatePriceBO(priceDomainDTO, priceBO);
												priceBO.setPriceId(priceId);
												priceBO.setBillingStatus(priceDomainDTO.getBillingStatus());
												//OPPTLogger.debug("Price Info--Price Id:" + priceBO.getPriceId() + "EE Id:" +priceBO.getEeId() + "SWO Id :" + priceBO.getSwoId() + "DM Id:" + priceBO.getDmId() +"Customer Id:" + priceBO.getCustomerId() + "Proposal Id:" + priceBO.getProposalId() +"EE_Item No :" + priceBO.getEeItemNo() + "Sales doc no" + priceBO.getSalesDocNo(),CLASS_NAME, methodName);
												priceBOFactory.createPriceBO(priceBO, PriceBOFactory.PRICE_TABLE);
											}
										}
									}
								}
								/* Insert all the EE's code ends here */

								// CHANGED CODE MAYBE NEEDED IN FUTURE
								/* This logic is to compare all existing EEs with the ones returned from RFC.
								 * If RFC doesnt contain some EE which is in table, those EE's will be deleted.
								
								List eeLocalList = eeBOFactory.findEEBOForSWO(swoBO.getProposalId(), swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_TABLE);
								List eeRFCList = null;
								EEBO eeBOFromDB = null;
								
								if (eeLocalList != null && eeLocalList.size() > 0) {
									eeRFCList = swoDomainDTO.getEEDTOList();
								}
								
								int eeLocalSize = eeLocalList.size();
								int eeRFCSize = eeRFCList.size();
																
								for (int x = 0; x < eeLocalSize; x++) {
									boolean flag = false;
									eeBOFromDB = (EEBO) eeLocalList.get(x);
									// Check if the DB EE exists in RFC data, if doesnt exist delete that EE
									for(int y=0;y < eeRFCSize; y++) {
										EEDomainDTO eeRFCDomainDTO = (EEDomainDTO) eeRFCList.get(y);
										if (eeBOFromDB.getSalesDocNo().equals(eeRFCDomainDTO.getSalesDocNo()) && eeBOFromDB.getEeItemNo().equals(eeRFCDomainDTO.getEeItemNo())) {
											flag = true;
											break;
										}
									}
									if(flag==false) {
										// Remove the EE's from DB which are not present in RFC
										//eeLocalList.remove(x);
										//eeLocalSize--;
										//x--;
										eeBOFactory.deleteEEBO(eeBOFromDB,EEBOFactory.EE_TABLE);
									}
								}
								// The other existing EEs will be updated here
								if (eeLocalList != null && eeLocalList.size() > 0) {
									iterateEE = swoDomainDTO.getEEDTOList().iterator();
									while (iterateEE.hasNext()) {
										EEBO eeBO = null;
										eeDomainDTO = (EEDomainDTO) iterateEE.next();
										eeBO = populateEEBOLocalList(eeLocalList, eeDomainDTO);
										if (eeBO != null) {
											//OPPTLogger.debug("EE Info--EE Id:" + eeBO.getEeId() + "SWO Id :" + eeBO.getSwoId() + "DMId:" + eeBO.getDmId() + "Customer Id:" + eeBO.getCustomerId() + "Proposal Id:" +eeBO.getProposalId() + "EE_Item No :" + eeBO.getEeItemNo() + "Sales doc no" +eeBO.getSalesDocNo(), CLASS_NAME, methodName);
											eeBOFactory.updateEEBO(eeBO, EEBOFactory.EE_TABLE);
											List priceLocalList = priceBOFactory.findPriceBOForEE(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId(), PriceBOFactory.PRICE_TABLE);
											if (priceLocalList != null && priceLocalList.size() > 0) {
												iteratePrice = eeDomainDTO.getPriceDTOList().iterator();
												while (iteratePrice.hasNext()) {
													PriceBO priceBO = null;
													priceDomainDTO = (PriceDomainDTO) iteratePrice.next();
													priceBO = populatePriceBOLocalList(priceLocalList, priceDomainDTO);
													if (priceBO != null) {
														//OPPTLogger.debug("Price Info--Price Id:" + priceBO.getPriceId() + "EE Id:" +priceBO.getEeId() + "SWO Id :" + priceBO.getSwoId() + "DM Id:" + priceBO.getDmId() +"Customer Id:" + priceBO.getCustomerId() + "Proposal Id:" + priceBO.getProposalId() +"EE_Item No :" + priceBO.getEeItemNo() + "Sales doc no" + priceBO.getSalesDocNo(),CLASS_NAME, methodName);
														priceBOFactory.updatePriceBO(priceBO, PriceBOFactory.PRICE_TABLE);
													}
												}
											}
										}
									}
								}
								*/
							}
						}
					}
				}
			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}

		//log.end();
	}

	/**
	 *  
	 * This method is used for storing the SWO,EE and Price information 
	 * During the check variance  case
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
	 * @param swoDomainDTO
	 * @throws ServiceException
	 * @author Venkat
	 */
	public void storeVarianceInfoSWO(SWODomainDTO swoDomainDTO) throws ServiceException {
		SWOBOFactory swoBOFactory = null;
		EEBOFactory eeBOFactory = null;
		PriceBOFactory priceBOFactory = null;
		List eeDomainDTOList = null;
		List priceDomainDTOList = null;
		EEDomainDTO eeDomainDTO = null;
		PriceDomainDTO priceDomainDTO = null;
		SWOBO swoBO = null;
		SWOBO maxSWOBO = null;
		swoBOFactory = new SWOBOFactory();
		eeBOFactory = new EEBOFactory();
		priceBOFactory = new PriceBOFactory();
		Iterator iterateEE = null;
		Iterator iteratePrice = null;
		int maxSWOId = 0;
		String methodName = "storeVarianceInfoSWO";
		try {
			List swoBOList = swoBOFactory.findSWOBOForEquipmentNo(swoDomainDTO.getEquipmentNo(), swoDomainDTO.getProposalId(), SWOBOFactory.VARIANCE_SWO_TABLE);
			/*
			 * Simulation of Variance - EF0813045921
			 * Balaji Defect 31
			 * moved up words
			 */
			int maxPriceId = 0;
			/*
			 * Simulation of Variance - EF0813045921
			 * Balaji Defect 31
			 */

			if (null == swoBOList || swoBOList.size() == 0) {
				if (maxSWOId == 0) {
					maxSWOBO = swoBOFactory.findMaxSWOBO(SWOBOFactory.VARIANCE_SWO_TABLE);
					maxSWOId = maxSWOBO.getSwoId();
				} else {
					maxSWOId++;
				}
				swoDomainDTO.setSwoId(maxSWOId + 1);
				swoBO = populateSWOBO(swoDomainDTO, swoBO);
				OPPTLogger.debug("SWO Info-- SWO Id :" + swoBO.getSwoId() + "DM Id:" + swoBO.getDmId() + "Customer Id:" + swoBO.getCustomerId() + "Proposal Id:" + swoBO.getProposalId(), CLASS_NAME, methodName);
				swoBOFactory.createSWOBO(swoBO, SWOBOFactory.VARIANCE_SWO_TABLE);
				eeDomainDTOList = swoDomainDTO.getEEDTOList();
				int maxeeId = 0;
				if (eeDomainDTOList != null) {
					iterateEE = eeDomainDTOList.iterator();
					while (iterateEE.hasNext()) {
						EEBO eeBO = null;
						EEBO maxEEBO = null;
						eeDomainDTO = (EEDomainDTO) iterateEE.next();
						if (maxeeId == 0) {
							maxEEBO = eeBOFactory.findMaxEEBO(EEBOFactory.EE_VARIANCE_TABLE);
							maxeeId = maxEEBO.getEeId();
						} else {
							maxeeId++;
						}
						int eeId = (maxeeId + 1);
						eeDomainDTO.setSwoId(swoBO.getSwoId());
						eeDomainDTO.setDmId(swoBO.getDmId());
						eeBO = populateEEBO(eeDomainDTO, eeBO);
						eeBO.setEeId(eeId);
						OPPTLogger.debug("EE Info--EE Id:" + eeBO.getEeId() + "SWO Id :" + eeBO.getSwoId() + "DM Id:" + eeBO.getDmId() + "Customer Id:" + eeBO.getCustomerId() + "Proposal Id:" + eeBO.getProposalId() + "EE_Item No :" + eeBO.getEeItemNo() + "Sales doc no" + eeBO.getSalesDocNo() + "EE NO:" + eeBO.getEeNo(), CLASS_NAME, methodName);
						eeBOFactory.createEEBO(eeBO, EEBOFactory.EE_VARIANCE_TABLE);
						OPPTLogger.debug("AFTER STORE EE Info--EE Id:" + eeBO.getEeId() + "SWO Id :" + eeBO.getSwoId() + "DM Id:" + eeBO.getDmId() + "Customer Id:" + eeBO.getCustomerId() + "Proposal Id:" + eeBO.getProposalId() + "EE_Item No :" + eeBO.getEeItemNo() + "Sales doc no" + eeBO.getSalesDocNo() + "EE NO:" + eeBO.getEeNo(), CLASS_NAME, methodName);
						priceDomainDTOList = eeDomainDTO.getPriceDTOList();

						if (priceDomainDTOList != null) {
							iteratePrice = priceDomainDTOList.iterator();

							while (iteratePrice.hasNext()) {
								PriceBO priceBO = null;
								PriceBO maxPriceBO = null;
								priceDomainDTO = (PriceDomainDTO) iteratePrice.next();
								if (maxPriceId == 0) {
									maxPriceBO = priceBOFactory.findMaxPriceBO(PriceBOFactory.VARIANCE_PRICE_TABLE);
									maxPriceId = maxPriceBO.getPriceId();
								} else {
									maxPriceId++;
								}
								int priceId = (maxPriceId + 1);
								priceDomainDTO.setEeId(eeBO.getEeId());
								priceDomainDTO.setSwoId(eeBO.getSwoId());
								priceDomainDTO.setDmId(eeBO.getDmId());
								priceBO = populatePriceBO(priceDomainDTO, priceBO);
								priceBO.setPriceId(priceId);
								OPPTLogger.debug("Price Info--Price Id:" + priceBO.getPriceId() + "EE Id:" + priceBO.getEeId() + "SWO Id :" + priceBO.getSwoId() + "DM Id:" + priceBO.getDmId() + "Customer Id:" + priceBO.getCustomerId() + "Proposal Id:" + priceBO.getProposalId() + "EE_Item No :" + priceBO.getEeItemNo() + "Sales doc no" + priceBO.getSalesDocNo(), CLASS_NAME, methodName);
								priceBOFactory.createPriceBO(priceBO, PriceBOFactory.VARIANCE_PRICE_TABLE);
								OPPTLogger.debug("AFTER STORE Price Info--Price Id:" + priceBO.getPriceId() + "EE Id:" + priceBO.getEeId() + "SWO Id :" + priceBO.getSwoId() + "DM Id:" + priceBO.getDmId() + "Customer Id:" + priceBO.getCustomerId() + "Proposal Id:" + priceBO.getProposalId() + "EE_Item No :" + priceBO.getEeItemNo() + "Sales doc no" + priceBO.getSalesDocNo(), CLASS_NAME, methodName);
							}
						}
					}
				}
			} else if (swoBOList != null && swoBOList.size() > 0) {
				Iterator iterateSWO = swoBOList.iterator();
				while (iterateSWO.hasNext()) {
					swoBO = (SWOBO) iterateSWO.next();
					if (swoBO.getSalesDocNo() != null && swoBO.getSalesDocNo().equals(swoDomainDTO.getSalesDocNo())) {
						swoBO = populateSWOBO(swoDomainDTO, swoBO);
						swoBO.setLastUpdatedDate(new Date(new java.util.Date().getTime()));
						OPPTLogger.debug("Updating -SWO Info-- SWO Id :" + swoBO.getSwoId() + "DM Id:" + swoBO.getDmId() + "Customer Id:" + swoBO.getCustomerId() + "Proposal Id:" + swoBO.getProposalId(), CLASS_NAME, methodName);
						swoBOFactory.updateSWOBO(swoBO, SWOBOFactory.VARIANCE_SWO_TABLE);
						List eeLocalList = eeBOFactory.findEEBOForSWO(swoBO.getProposalId(), swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_VARIANCE_TABLE);
						if (eeLocalList != null && eeLocalList.size() > 0) {
							iterateEE = swoDomainDTO.getEEDTOList().iterator();
							while (iterateEE.hasNext()) {
								EEBO eeBO = null;
								eeDomainDTO = (EEDomainDTO) iterateEE.next();
								eeBO = populateEEBOLocalList(eeLocalList, eeDomainDTO);
								if (eeBO != null) {
									OPPTLogger.debug("Updating--EE Info--EE Id:" + eeBO.getEeId() + "SWO Id :" + eeBO.getSwoId() + "DM Id:" + eeBO.getDmId() + "Customer Id:" + eeBO.getCustomerId() + "Proposal Id:" + eeBO.getProposalId() + "EE_Item No :" + eeBO.getEeItemNo() + "Sales doc no" + eeBO.getSalesDocNo() + "EE NO:" + eeBO.getEeNo(), CLASS_NAME, methodName);
									eeBOFactory.updateEEBO(eeBO, EEBOFactory.EE_VARIANCE_TABLE);
									List priceLocalList = priceBOFactory.findPriceBOForEE(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId(), PriceBOFactory.VARIANCE_PRICE_TABLE);
									if (priceLocalList != null && priceLocalList.size() > 0) {
										iteratePrice = eeDomainDTO.getPriceDTOList().iterator();
										while (iteratePrice.hasNext()) {
											PriceBO priceBO = null;
											priceDomainDTO = (PriceDomainDTO) iteratePrice.next();
											priceBO = populatePriceBOLocalList(priceLocalList, priceDomainDTO);
											if (priceBO != null) {
												OPPTLogger.debug(
													"Updating--Price Info--Price Id:" + priceBO.getPriceId() + "EE Id:" + priceBO.getEeId() + "SWO Id :" + priceBO.getSwoId() + "DM Id:" + priceBO.getDmId() + "Customer Id:" + priceBO.getCustomerId() + "Proposal Id:" + priceBO.getProposalId() + "EE_Item No :" + priceBO.getEeItemNo() + "Sales doc no" + priceBO.getSalesDocNo(),
													CLASS_NAME,
													methodName);
												priceBOFactory.updatePriceBO(priceBO, PriceBOFactory.VARIANCE_PRICE_TABLE);
											} else {
												/*
												 * Simulation of Variance - EF0813045921
												 * Balaji Defect 31 Starts
												*/
												PriceBO maxPriceBO = null;
												if (maxPriceId == 0) {
													maxPriceBO = priceBOFactory.findMaxPriceBO(PriceBOFactory.VARIANCE_PRICE_TABLE);
													maxPriceId = maxPriceBO.getPriceId();
												} else {
													maxPriceId++;
												}
												int priceId = (maxPriceId + 1);
												
												priceDomainDTO.setEeId(eeBO.getEeId());
												priceDomainDTO.setSwoId(eeBO.getSwoId());
												priceDomainDTO.setDmId(eeBO.getDmId());
												priceBO = populatePriceBO(priceDomainDTO, priceBO);
												priceBO.setPriceId(priceId);
												OPPTLogger.debug("Price Info--Price Id:" + priceBO.getPriceId() + "EE Id:" + priceBO.getEeId() + "EE_Item No :" + priceBO.getEeItemNo() + "Sales doc no" + priceBO.getSalesDocNo(),CLASS_NAME,methodName);
												priceBOFactory.createPriceBO(priceBO, PriceBOFactory.VARIANCE_PRICE_TABLE);
												OPPTLogger.debug("AFTER STORE Price Info--Price Id:" + priceBO.getPriceId() + "EE Id:" + priceBO.getEeId() + priceBO.getProposalId() + "EE_Item No :" + priceBO.getEeItemNo() + "Sales doc no" + priceBO.getSalesDocNo(),CLASS_NAME,	methodName);
												/*
												 * Simulation of Variance - EF0813045921
												 * Balaji Defect 31 Ends
												*/

											}

										}
									}
								} else {
									/*
									 * Simulation of Variance - EF0813045921
									 * Balaji Defect 31
									 * on hold pending comments from Sara
									 */

								}
							}
						}
					}
				}
			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	} //end of storeVarianceInfoSWO

	/** 
	 * This method sets the values coming from back end 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 13, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param priceLocalList
	 * @param priceDomainDTO
	 * @return 
	 */
	private PriceBO populatePriceBOLocalList(List priceLocalList, PriceDomainDTO priceDomainDTO) {
		PriceBO priceBO = null;
		for (int i = 0; i < priceLocalList.size(); i++) {
			priceBO = (PriceBO) priceLocalList.get(i);
			if (priceBO.getSalesDocNo().equals(priceDomainDTO.getSalesDocNo()) && priceBO.getEeItemNo().equals(priceDomainDTO.getEeItemNo())) {
				priceBO = populatePriceBO(priceDomainDTO, priceBO);
			}
		}
		return priceBO;
	}

	/** 
	 * This method sets the values coming from back end 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 13, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eeLocalList
	 * @param eeDomainDTO
	 * @return EEBO 
	 */
	private EEBO populateEEBOLocalList(List eeLocalList, EEDomainDTO eeDomainDTO) {
		EEBO eeBO = null;
		for (int i = 0; i < eeLocalList.size(); i++) {
			eeBO = (EEBO) eeLocalList.get(i);
			if (eeBO.getSalesDocNo().equals(eeDomainDTO.getSalesDocNo()) && eeBO.getEeItemNo().equals(eeDomainDTO.getEeItemNo())) {
				eeBO = populateEEBO(eeDomainDTO, eeBO);
				break;
			}
		}
		return eeBO;
	}

	/**
	 *  
	 * This method checks license is bumped or not  
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
	 * @param swoBOList
	 * @return
	 */
	private boolean isLicenseBumped(List swoBOList) {
		boolean isBumped = false;
		if (swoBOList != null && swoBOList.size() > 1) {
			isBumped = true;
		} else if (swoBOList != null && swoBOList.size() == 1) {
			isBumped = false;
		}

		return isBumped;
	}

	/**
	 *  
	 * This method stores the Ineligible licenses information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 5, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoDomainDTO
	 * @throws ServiceException
	 */
	public void storeIneligibleLicenses(SWODomainDTO swoDomainDTO) throws ServiceException {
		SWOBOFactory swoBOFactory = null;
		EEBOFactory eeBOFactory = null;
		PriceBOFactory priceBOFactory = null;
		List eeDomainDTOList = null;
		List priceDomainDTOList = null;
		EEDomainDTO eeDomainDTO = null;
		PriceDomainDTO priceDomainDTO = null;
		SWOBO swoBO = null;
		SWOBO maxSWOBO = null;
		swoBOFactory = new SWOBOFactory();
		eeBOFactory = new EEBOFactory();
		priceBOFactory = new PriceBOFactory();
		Iterator iterateEE = null;
		Iterator iteratePrice = null;
		List swoBOList = null;
		int maxSWOId = 0;
		String methodName = "storeIneligibleLicenses";

		try {
			swoBOList = swoBOFactory.findSWOBOForQuotesSoldToPartyDM(swoDomainDTO.getSalesDocNo(), swoDomainDTO.getProposalId(), swoDomainDTO.getSwoItemNo(), swoDomainDTO.getCustomerId(), swoDomainDTO.getDmId());
			if (swoBOList == null || swoBOList.size() == 0) {
				maxSWOBO = swoBOFactory.findMaxSWOBO(SWOBOFactory.SWO_TABLE);
				swoDomainDTO.setSwoId(maxSWOBO.getSwoId() + 1);
				swoBO = populateSWOBO(swoDomainDTO, swoBO);
				swoBO.setSwoAddedDate(new Date(new java.util.Date().getTime()));
				swoBO.setExclusionId(UtilityConstants.NO);
				OPPTLogger.debug("SWO Info-- SWO Id :" + swoBO.getSwoId() + "DM Id:" + swoBO.getDmId() + "Customer Id:" + swoBO.getCustomerId() + "Proposal Id:" + swoBO.getProposalId() + "Equp No:" + swoBO.getEquipmentNo(), CLASS_NAME, methodName);
				swoBOFactory.createSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
				eeDomainDTOList = swoDomainDTO.getEEDTOList();

				if (eeDomainDTOList != null) {
					iterateEE = eeDomainDTOList.iterator();
					while (iterateEE.hasNext()) {
						EEBO eeBO = null;
						EEBO maxEEBO = null;
						eeDomainDTO = (EEDomainDTO) iterateEE.next();
						maxEEBO = eeBOFactory.findMaxEEBO(EEBOFactory.EE_TABLE);
						int maxeeId = maxEEBO.getEeId();
						int eeId = (maxeeId + 1);
						eeDomainDTO.setSwoId(swoBO.getSwoId());
						eeDomainDTO.setDmId(swoBO.getDmId());
						eeBO = populateEEBO(eeDomainDTO, eeBO);
						eeBO.setEeId(maxeeId + 1);
						OPPTLogger.debug("EE Info--EE Id:" + eeBO.getEeId() + "SWO Id :" + eeBO.getSwoId() + "DMId:" + eeBO.getDmId() + "Customer Id:" + eeBO.getCustomerId() + "Proposal Id:" + eeBO.getProposalId() + "EE_Item No :" + eeBO.getEeItemNo() + "Sales doc no" + eeBO.getSalesDocNo(), CLASS_NAME, methodName);
						eeBOFactory.createEEBO(eeBO, EEBOFactory.EE_TABLE);
						priceDomainDTOList = eeDomainDTO.getPriceDTOList();
						if (priceDomainDTOList != null) {
							iteratePrice = priceDomainDTOList.iterator();
							while (iteratePrice.hasNext()) {
								PriceBO priceBO = null;
								PriceBO maxPriceBO = null;
								priceDomainDTO = (PriceDomainDTO) iteratePrice.next();
								maxPriceBO = priceBOFactory.findMaxPriceBO(PriceBOFactory.PRICE_TABLE);
								int maxPriceId = maxPriceBO.getPriceId();
								int priceId = (maxPriceId + 1);
								priceDomainDTO.setEeId(eeBO.getEeId());
								priceDomainDTO.setSwoId(eeBO.getSwoId());
								priceDomainDTO.setDmId(eeBO.getDmId());
								priceBO = populatePriceBO(priceDomainDTO, priceBO);
								priceBO.setPriceId(priceId);
								OPPTLogger.debug("Price Info--Price Id:" + priceBO.getPriceId() + "EE Id:" + priceBO.getEeId() + "SWO Id :" + priceBO.getSwoId() + "DM Id:" + priceBO.getDmId() + "Customer Id:" + priceBO.getCustomerId() + "Proposal Id:" + priceBO.getProposalId() + "EE_Item No :" + priceBO.getEeItemNo() + "Sales doc no" + priceBO.getSalesDocNo(), CLASS_NAME, methodName);
								priceBOFactory.createPriceBO(priceBO, PriceBOFactory.PRICE_TABLE);
							}
						}
					}
				}
			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}

	/**
	 *  
	 * This method checks whether license are already pulled in to proposal or not 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoDomainDTO
	 * @return
	 * @throws ServiceException
	 */
	public boolean verifyLicensesAreExists(SWODomainDTO swoDomainDTO) throws ServiceException {
			boolean isLicenseExists = false;
			SWOBOFactory swoBOFactory = null;
			swoBOFactory = new SWOBOFactory();
			try {
				if (LicenseConstants.QUOTE_FLAG.equals(swoDomainDTO.getItemCategory())) {
					List swoBOList = swoBOFactory.findSWOBOForSalesDocNo(swoDomainDTO.getSalesDocNo(), swoDomainDTO.getProposalId(), SWOBOFactory.SWO_TABLE);
					if(null != swoBOList && 0 < swoBOList.size()) {
						isLicenseExists = true;
					}
				} else {
					SWOBO swoBO = swoBOFactory.findSWOBOForEquipmentAndSalesDocNo(swoDomainDTO.getEquipmentNo(), swoDomainDTO.getSalesDocNo(), swoDomainDTO.getProposalId());
					if(null != swoBO){
						isLicenseExists = true;
					}
				}
			}
			catch (DomainException d) {
				isLicenseExists = false;
			}
			return isLicenseExists;
	}
	
	/**
	 *  
	 * This method retrieves the swo information if it exists..
	 * else it stores the swo information during the delta-fetch
	 * operation 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoDomainDTO
	 * @return
	 * @throws ServiceException
	 */
	public List retrieveSWODetails(SWODomainDTO swoDomainDTO) throws ServiceException {
		SWOBOFactory swoBOFactory = null;
		EEBOFactory eeBOFactory = null;
		PriceBOFactory priceBOFactory = null;
		List swoDomainDTOList = null;
		List eeDomainDTOList = null;
		List priceDomainDTOList = null;
		EEDomainDTO eeDomainDTO = null;
		PriceDomainDTO priceDomainDTO = null;
		SWOBO swoBO = null;
		EEBO eeBO = null;
		PriceBO priceBO = null;
		swoBOFactory = new SWOBOFactory();
		eeBOFactory = new EEBOFactory();
		priceBOFactory = new PriceBOFactory();
		swoDomainDTOList = new ArrayList();
		List swoBOList = null;
		boolean isValidateTP = false;
		boolean isConfigDM = false;
		String methodName = "retrieveSWODetails";

		/* CR6153 start change */
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		ProposalBO proposalBO = new ProposalBO();
		try {
			proposalBO = (ProposalBO) proposalContractBOFactory.getProposalContractBO(swoDomainDTO.getProposalId());
		} catch (DomainException de) {
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());
		}
		/* CR6153 end change */
		try {
			String actionName = swoDomainDTO.getActionName();
			actionName = (actionName == null) ? "" : actionName.trim();

			if (actionName.equals(ActionNameConstants.COPY_BUMP_DM) || actionName.equals(ActionNameConstants.CONFIGURE_DM)) {

				isConfigDM = true;
				swoBOList = swoBOFactory.findSWOBOForDM(swoDomainDTO.getDmId(), swoDomainDTO.getCustomerId(), swoDomainDTO.getProposalId(), SWOBOFactory.SWO_TABLE);

			} else if (ActionNameConstants.VALIDATE_TP.equals(actionName)) {
				isValidateTP = true;
				swoBOList = swoBOFactory.findSWOBOForProposal(swoDomainDTO.getProposalId(), SWOBOFactory.SWO_TABLE);
			} else {
				/* CR6153 start change */
				if((proposalBO.getExtendPeriod() != null) && (proposalBO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
					swoBOList = swoBOFactory.findSWOBOForEquipSoldToPartyDM(swoDomainDTO.getEquipmentNo(), swoDomainDTO.getProposalId(),swoDomainDTO.getCustomerId(),swoDomainDTO.getDmId() );
				}
				else{
				/* CR6153 end change */
					swoBOList = swoBOFactory.findSWOBOForEquipmentNo(swoDomainDTO.getEquipmentNo(), swoDomainDTO.getProposalId(), SWOBOFactory.SWO_TABLE);
				}
			}

			if (swoBOList != null && swoBOList.size() > 0) {
				for (int i = 0; i < swoBOList.size(); i++) {
					swoBO = (SWOBO) swoBOList.get(i);
					swoDomainDTO = new SWODomainDTO(swoBO);

					if (isValidateTP) {
						continue;
					}
					eeDomainDTOList = new ArrayList();
					List eeBOList = eeBOFactory.findEEBOForSWO(swoDomainDTO.getProposalId(), swoDomainDTO.getCustomerId(), swoDomainDTO.getDmId(), swoDomainDTO.getSwoId(), EEBOFactory.EE_TABLE);
					for (int j = 0; j < eeBOList.size(); j++) {
						eeBO = (EEBO) eeBOList.get(j);
						eeDomainDTO = new EEDomainDTO(eeBO);
						priceDomainDTOList = new ArrayList();
						List priceBOList = priceBOFactory.findPriceBOForEE(eeDomainDTO.getEeId(), eeDomainDTO.getSwoId(), eeDomainDTO.getDmId(), eeDomainDTO.getCustomerId(), eeDomainDTO.getProposalId(), PriceBOFactory.PRICE_TABLE);
						for (int k = 0; k < priceBOList.size(); k++) {
							priceBO = (PriceBO) priceBOList.get(k);
							priceDomainDTO = new PriceDomainDTO(priceBO);
							priceDomainDTOList.add(priceDomainDTO);
						}
						eeDomainDTO.setPriceDTOList(priceDomainDTOList);
						eeDomainDTOList.add(eeDomainDTO);
					}
					swoDomainDTO.setEEDTOList(eeDomainDTOList);
					swoDomainDTOList.add(swoDomainDTO);
				}
			} else if (isValidateTP == false && isConfigDM == false) {
				List swoDTOList = new ArrayList();
				swoDomainDTOList.add(swoDomainDTO);
				storeSWOInfo(swoDomainDTOList);
			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
		return swoDomainDTOList;
	}

	/**
	 *  
	 * This method populates the SWO BO from Domain DTO
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
	 * @param swoDomainDTO
	 * @return
	 */
	private SWOBO populateSWOBO(SWODomainDTO swoDomainDTO, SWOBO swoBO) {
		String methodName = "populateSWOBO";
		//TimeTaken log = new //TimeTaken(CLASS_NAME, methodName);
		if (swoBO != null && swoBO.getSwoId() > 0) {

		} else {
			swoBO = new SWOBO();
			swoBO.setSwoId(swoDomainDTO.getSwoId());
			swoBO.setDmId(swoDomainDTO.getDmId());
			swoBO.setCustomerId(swoDomainDTO.getCustomerId());
			swoBO.setProposalId(swoDomainDTO.getProposalId());
		}
		swoBO.setAdjustmentAmount(swoDomainDTO.getAdjustmentAmount());
		//System.out.println("SWOInfoBean.populateSWOBO():swoDomainDTO.getAlternatePrice():"+swoDomainDTO.getAlternatePrice());
		//System.out.println("SWOInfoBean.populateSWOBO():swoDomainDTO.getCalcPrice()"+swoDomainDTO.getCalcPrice());
		swoBO.setAlternatePrice(swoDomainDTO.getAlternatePrice());
		swoBO.setAlternatePriceInd(swoDomainDTO.getAlternatePriceInd());
		swoBO.setAlternatePriceUpdateInd(swoDomainDTO.getAlternatePriceUpdateInd());
		swoBO.setAmendEndDate(swoDomainDTO.getAmendEndDate());
		swoBO.setAmendInd(swoDomainDTO.getAmendInd());
		swoBO.setBumpInd(swoDomainDTO.getBumpInd());
		swoBO.setCalcPrice(swoDomainDTO.getCalcPrice());
		swoBO.setDeltaFetchId(swoDomainDTO.getDeltaFetchId());
		swoBO.setEquipmentNo(swoDomainDTO.getEquipmentNo());
		swoBO.setEswPrice(swoDomainDTO.getEswPrice());
		swoBO.setExclusionId(swoDomainDTO.getExclusionId());
		swoBO.setItemCategory(swoDomainDTO.getItemCategory());
		swoBO.setLastUpdatedDate(swoDomainDTO.getLastUpdatedDate());
		swoBO.setLockedInd(swoDomainDTO.getLockedInd());
		swoBO.setOldCalcPrice(swoDomainDTO.getOldCalcPrice());
		swoBO.setPlanDateInd(swoDomainDTO.getPlanDateInd());
		swoBO.setPlanEndDate(swoDomainDTO.getPlanEndDate());
		swoBO.setPlannedInd(swoDomainDTO.getPlannedInd());
		swoBO.setPlanStartDate(swoDomainDTO.getPlanStartDate());
		swoBO.setReferenceSerialNo(swoDomainDTO.getReferenceSerialNo());
		swoBO.setRefetchId(swoDomainDTO.getRefetchId());
		swoBO.setRequestDeliveryDate(swoDomainDTO.getRequestDeliveryDate());
		swoBO.setSalesDocNo(swoDomainDTO.getSalesDocNo());
		swoBO.setSequenceNo(swoDomainDTO.getSequenceNo());
		swoBO.setSerialNo(swoDomainDTO.getSerialNo());
		swoBO.setSwoAddedDate(swoDomainDTO.getSwoAddedDate());
		swoBO.setSwoContrStatus(swoDomainDTO.getSwoContrStatus());
		swoBO.setSwoContrType(swoDomainDTO.getSwoContrType());
		swoBO.setSwoDesc(swoDomainDTO.getSwoDesc());
		swoBO.setSwoExtContrNo(swoDomainDTO.getSwoExtContrNo());
		swoBO.setSwoItemNo(swoDomainDTO.getSwoItemNo());
		swoBO.setSwoNo(swoDomainDTO.getSwoNo());
		swoBO.setSAndSInd(swoDomainDTO.getSAndSInd());
		//log.end();
		return swoBO;
	}

	/**
	 *  
	 * This method populates the EE BO from Domain DTO 
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
	 * @param eeDomainDTO
	 * @return
	 */
	private EEBO populateEEBO(EEDomainDTO eeDomainDTO, EEBO eeBO) {
		String methodName = "populateEEBO";
		//TimeTaken log = new //TimeTaken(CLASS_NAME, methodName);

		if (eeBO != null && eeBO.getEeId() > 0) {

		} else {
			eeBO = new EEBO();
			eeBO.setEeId(eeDomainDTO.getEeId());
			eeBO.setSwoId(eeDomainDTO.getSwoId());
			eeBO.setDmId(eeDomainDTO.getDmId());
			eeBO.setCustomerId(eeDomainDTO.getCustomerId());
			eeBO.setProposalId(eeDomainDTO.getProposalId());
		}
		eeBO.setAlternatePrice(eeDomainDTO.getAlternatePrice());
		eeBO.setAlternatePriceUpdateInd(eeDomainDTO.getAlternatePriceUpdateInd());
		eeBO.setBillingEndDate(eeDomainDTO.getBillingEndDate());
		eeBO.setBillingStartDate(eeDomainDTO.getBillingStartDate());
		eeBO.setBumpId(eeDomainDTO.getBumpId());
		eeBO.setCalculatedPrice(eeDomainDTO.getCalculatedPrice());
		eeBO.setChargeOptionDesc(eeDomainDTO.getChargeOptionDesc());
		eeBO.setChargeOption(eeDomainDTO.getChargeOption());
		eeBO.setEeDesc(eeDomainDTO.getEeDesc());
		eeBO.setEeItemNo(eeDomainDTO.getEeItemNo());
		eeBO.setEeNo(eeDomainDTO.getEeNo());
		eeBO.setEswPrice(eeDomainDTO.getEswPrice());
		eeBO.setExclusionId(eeDomainDTO.getExclusionId());
		eeBO.setLicenseType(eeDomainDTO.getLicenseType());
		eeBO.setListPrice(eeDomainDTO.getListPrice());
		eeBO.setPlanEndDate(eeDomainDTO.getPlanEndDate());
		eeBO.setPlanStartDate(eeDomainDTO.getPlanStartDate());
		eeBO.setPletNo(eeDomainDTO.getPletNo());
		eeBO.setReqstDeliveryDate(eeDomainDTO.getReqstDeliveryDate());
		eeBO.setSalesDocNo(eeDomainDTO.getSalesDocNo());
		eeBO.setSAndSDiscountPercent(eeDomainDTO.getSAndSDiscountPercent());
		eeBO.setSequenceNo(eeDomainDTO.getSequenceNo());
		eeBO.setSwoItemNo(eeDomainDTO.getSwoItemNo());
		eeBO.setUseLevel(eeDomainDTO.getUseLevel());
		eeBO.setValueMetric(eeDomainDTO.getValueMetric());
		//log.end();
		return eeBO;
	}

	/**
	 *  
	 * This method populates the Price BO 
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
	 * @param priceDomainDTO
	 * @param priceBO
	 * @return
	 */
	private PriceBO populatePriceBO(PriceDomainDTO priceDomainDTO, PriceBO priceBO) {
		String methodName = "populatePriceBO";
		//TimeTaken log = new //TimeTaken(CLASS_NAME, methodName);
		if (priceBO != null && priceBO.getPriceId() > 0) {

		} else {
			priceBO = new PriceBO();
			priceBO.setPriceId(priceDomainDTO.getPriceId());
			priceBO.setEeId(priceDomainDTO.getEeId());
			priceBO.setSwoId(priceDomainDTO.getSwoId());
			priceBO.setDmId(priceDomainDTO.getDmId());
			priceBO.setCustomerId(priceDomainDTO.getCustomerId());
			priceBO.setProposalId(priceDomainDTO.getProposalId());
		}
		priceBO.setBillingStatus(priceDomainDTO.getBillingStatus());
		priceBO.setBillPlanEndDate(priceDomainDTO.getBillPlanEndDate());
		priceBO.setBillPlanStartDate(priceDomainDTO.getBillPlanStartDate());
		priceBO.setCurrency(priceDomainDTO.getCurrency());
		priceBO.setEeItemNo(priceDomainDTO.getEeItemNo());
		priceBO.setEswPrice(priceDomainDTO.getEswPrice());
		priceBO.setExclusionId(priceDomainDTO.getExclusionId());
		priceBO.setSalesDocNo(priceDomainDTO.getSalesDocNo());
		//log.end();
		return priceBO;
	}

	/**
	 *  
	 *This method updates the swo information as part of edit customer 
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
	 * @param swoDTO
	 * @throws ServiceException
	 */
	public void updateSWOForCustomer(CustomerDomainDTO customerDTO) throws ServiceException {
		SWOBOFactory swoBOFactory = null;
		EEBOFactory eeBOFactory = null;
		SWOBO swoBO = null;
		EEBO eeBO = null;
		List swoBOList = null;
		List eeBOList = null;
		swoBOFactory = new SWOBOFactory();
		eeBOFactory = new EEBOFactory();
		String methodName = "updateSWOForCustomer";
		try {
			swoBOList = swoBOFactory.findSWOBOForCustomer(customerDTO.getCustomerId(), customerDTO.getProposalId(), SWOBOFactory.SWO_TABLE);
			for (int i = 0; i < swoBOList.size(); i++) {
				swoBO = (SWOBO) swoBOList.get(i);
				if (swoBO.isSAndS()) {
					// should not update the plan dates for s and s licenses
					continue;
				}
				if (swoBO.getBumpInd() != null && swoBO.getBumpInd().startsWith(LicenseConstants.LICENSE_BUMPED)) {
					if (swoBO.getBumpInd().equals(LicenseConstants.LICENSE_BUMPED)) {
						swoBO.setPlanStartDate(customerDTO.getPlanStartDate());
					} else {
						String maxBumpInd = swoBOFactory.findMaxBumpInd(swoBO.getSalesDocNo(), swoBO.getSwoItemNo(), swoBO.getProposalId(), SWOBOFactory.SWO_TABLE).getBumpInd();
						//validateBumpInd(swoBO, swoBOList, true,null);
						if (swoBO.getBumpInd().equals(maxBumpInd)) {
							swoBO.setPlanEndDate(customerDTO.getPlanEndDate());
						}
					}

				} else {
					swoBO.setPlanStartDate(customerDTO.getPlanStartDate());
					swoBO.setPlanEndDate(customerDTO.getPlanEndDate());
				}
				swoBOFactory.updateSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
				eeBOList = eeBOFactory.findEEBOForSWO(swoBO.getProposalId(), swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_TABLE);
				for (int j = 0; j < eeBOList.size(); j++) {
					eeBO = (EEBO) eeBOList.get(j);
					eeBO.setPlanStartDate(customerDTO.getPlanStartDate());
					eeBO.setPlanEndDate(customerDTO.getPlanEndDate());
					eeBOFactory.updateEEBO(eeBO, EEBOFactory.EE_TABLE);
				}
			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}

	/**
	 *  
	 * This method updates the swo information for dm edited information  
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
	 * @param dmDomainDTO
	 * @throws ServiceException
	 */
	public void updateSWOForDM(DMDomainDTO dmDomainDTO) throws ServiceException {
		SWOBOFactory swoBOFactory = null;
		EEBOFactory eeBOFactory = null;
		SWOBO swoBO = null;
		EEBO eeBO = null;
		List swoBOList = null;
		List eeBOList = null;
		swoBOFactory = new SWOBOFactory();
		eeBOFactory = new EEBOFactory();
		String methodName = "updateSWOForDM";
		try {
			swoBOList = swoBOFactory.findSWOBOForDM(dmDomainDTO.getDmId(), dmDomainDTO.getCustomerId(), dmDomainDTO.getProposalId(), SWOBOFactory.SWO_TABLE);
			for (int i = 0; i < swoBOList.size(); i++) {
				swoBO = (SWOBO) swoBOList.get(i);
				if (swoBO.isSAndS()) {
					// should not update the plan dates for s and s licenses
					continue;
				}
				if (swoBO.getBumpInd() != null && swoBO.getBumpInd().startsWith(LicenseConstants.LICENSE_BUMPED)) {
					if (swoBO.getBumpInd().equals(LicenseConstants.LICENSE_BUMPED)) {
						swoBO.setPlanStartDate(dmDomainDTO.getPlanStartDate());
					} else {
						String maxBumpInd = swoBOFactory.findMaxBumpInd(swoBO.getSalesDocNo(), swoBO.getSwoItemNo(), swoBO.getProposalId(), SWOBOFactory.SWO_TABLE).getBumpInd();
						//validateBumpInd(swoBO, swoBOList, true,null);
						if (swoBO.getBumpInd().equals(maxBumpInd)) {
							swoBO.setPlanEndDate(dmDomainDTO.getPlanEndDate());
						}
					}

				} else {
					swoBO.setPlanStartDate(dmDomainDTO.getPlanStartDate());
					swoBO.setPlanEndDate(dmDomainDTO.getPlanEndDate());
				}
				swoBOFactory.updateSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
				eeBOList = eeBOFactory.findEEBOForSWO(swoBO.getProposalId(), swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_TABLE);
				for (int j = 0; j < eeBOList.size(); j++) {
					eeBO = (EEBO) eeBOList.get(j);
					eeBO.setPlanStartDate(dmDomainDTO.getPlanStartDate());
					eeBO.setPlanEndDate(dmDomainDTO.getPlanEndDate());
					eeBOFactory.updateEEBO(eeBO, EEBOFactory.EE_TABLE);
				}
			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}

	}

	/**
	 *  
	 * This method checks if SVC License is present for a Proposal
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 19, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ProposalID
	 * @return boolean
	 * @author Prakash Mall
	 */
	public boolean chkSVCLicense(int ProposalID, String transactionName) throws ServiceException {
		boolean exist = false;
		SWOBOFactory swoBOFactory = new SWOBOFactory();

		exist = swoBOFactory.isSVCLicenseExistForProposal(ProposalID, transactionName);

		return exist;
	}

	/**
	 *  
	 * This method checks if Proposal containts S&S Licenses
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * Date March 9th, 2004
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ProposalID
	 * @return boolean
	 * @author Prakash Mall
	 */
	public boolean chkSandSLicense(int ProposalID, String flag) throws ServiceException {
		boolean exist = false;
		SWOBOFactory swoBOFactory = new SWOBOFactory();
		exist = swoBOFactory.isSandSLicenseExist(ProposalID, flag);
		return exist;
	}

	public String chkSWOExternalCntrNumber(int proposalId) throws ServiceException {

		String messageString = OPPTHelper.getLogString(String.valueOf(proposalId));
		OPPTLogger.log("PROPOSAL_ID", OPPTLogger.DEBUG, CLASS_NAME, "chkSWOExternalCntrNumber", messageString);

		String extCntrNum = null;

		SWOBOFactory swoBOFactory = new SWOBOFactory();
		try {
			Collection swoBOList = swoBOFactory.findSWOBOForProposal(proposalId, 1);

			if (null != swoBOList && 0 != swoBOList.size()) {
				Iterator iter = swoBOList.iterator();

				while (iter.hasNext()) {
					SWOBO swoBO = (SWOBO) iter.next();
					if (null != swoBO.getSwoExtContrNo()) {
						extCntrNum = swoBO.getSwoExtContrNo();
						return extCntrNum;
					}
				}
			}
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		}
		//boolean exist = swoBOFactory.chkSWOExternalContractNumber(proposalId);
		return extCntrNum;
	}

	/**
	 *  
	 * This method copy and store the swo info 
	 * while deleting the inventory 
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
	 * @param swoDomainDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public void copyStoreInfo(SWODomainDTO swoDomainDTO) throws ServiceException {
		SWOBOFactory swoBOFactory = null;
		EEBOFactory eeBOFactory = null;
		swoBOFactory = new SWOBOFactory();
		eeBOFactory = new EEBOFactory();
		SWOBO swoBO = null;
		List swoBOList = null;
		EEBO eeBO = null;
		List eeBOList = null;
		String methodName = "copyStoreInfo";

		if (swoDomainDTO != null && swoDomainDTO.getSwoId() != 0) {
			try {
				swoBO = swoBOFactory.getSWOBO(swoDomainDTO.getProposalId(), swoDomainDTO.getCustomerId(), swoDomainDTO.getDmId(), swoDomainDTO.getSwoId(), SWOBOFactory.SWO_TABLE);

				if (swoBO != null && !(swoBO.getItemCategory().equals(LicenseConstants.QUOTE_FLAG))) {
					swoBO.setLastUpdatedDate(new Date(new java.util.Date().getTime()));
					eeBOList = eeBOFactory.findEEBOForSWO(swoBO.getProposalId(), swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_TABLE);
					swoBO.setSwoId(swoBOFactory.findMaxSWOBO(SWOBOFactory.HISTORY_SWO_TABLE).getSwoId() + 1);
					OPPTLogger.debug("SWO History Info-- SWO Id :" + swoBO.getSwoId() + "DM Id:" + swoBO.getDmId() + "Customer Id:" + swoBO.getCustomerId() + "Proposal Id:" + swoBO.getProposalId(), CLASS_NAME, methodName);
					swoBOFactory.createSWOBO(swoBO, SWOBOFactory.HISTORY_SWO_TABLE);
					if (eeBOList != null && eeBOList.size() > 0) {
						for (int i = 0; i < eeBOList.size(); i++) {
							eeBO = (EEBO) eeBOList.get(i);
							eeBO.setEeId(eeBOFactory.findMaxEEBO(EEBOFactory.EE_HISTORY_TABLE).getEeId() + 1);
							eeBO.setSwoId(swoBO.getSwoId());
							OPPTLogger.debug("EE History Info--EE Id:" + eeBO.getEeId() + "SWO Id :" + eeBO.getSwoId() + "DM Id:" + eeBO.getDmId() + "Customer Id:" + eeBO.getCustomerId() + "Proposal Id:" + eeBO.getProposalId() + "EE_Item No :" + eeBO.getEeItemNo() + "Sales doc no" + eeBO.getSalesDocNo(), CLASS_NAME, methodName);
							eeBOFactory.createEEBO(eeBO, EEBOFactory.EE_HISTORY_TABLE);

						}
					}
				}
			} catch (DomainException d) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
				throw ExceptionGenerator.generateServiceException(d.getErrorReport());
			}
		} else if (swoDomainDTO != null && swoDomainDTO.getDmId() != 0) {
			try {
				swoBOList = swoBOFactory.findSWOBOForDM(swoDomainDTO.getDmId(), swoDomainDTO.getCustomerId(), swoDomainDTO.getProposalId(), SWOBOFactory.SWO_TABLE);
				if (swoBOList != null && swoBOList.size() > 0) {
					for (int i = 0; i < swoBOList.size(); i++) {
						swoBO = (SWOBO) swoBOList.get(i);
						if (swoBO != null && !(swoBO.getItemCategory().equals(LicenseConstants.QUOTE_FLAG))) {
							swoBO.setLastUpdatedDate(new Date(new java.util.Date().getTime()));
							swoBOFactory.createSWOBO(swoBO, SWOBOFactory.HISTORY_SWO_TABLE);
							eeBOList = eeBOFactory.findEEBOForSWO(swoBO.getProposalId(), swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_TABLE);
							if (eeBOList != null && eeBOList.size() > 0) {
								for (int j = 0; j < eeBOList.size(); j++) {
									eeBO = (EEBO) eeBOList.get(j);
									eeBOFactory.createEEBO(eeBO, EEBOFactory.EE_HISTORY_TABLE);

								}
							}
						}
					}
				}
			} catch (DomainException d) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
				throw ExceptionGenerator.generateServiceException(d.getErrorReport());
			}

		} else if (swoDomainDTO != null && swoDomainDTO.getCustomerId() != 0) {
			try {
				swoBOList = swoBOFactory.findSWOBOForCustomer(swoDomainDTO.getCustomerId(), swoDomainDTO.getProposalId(), SWOBOFactory.SWO_TABLE);
				if (swoBOList != null && swoBOList.size() > 0) {
					for (int i = 0; i < swoBOList.size(); i++) {
						swoBO = (SWOBO) swoBOList.get(i);
						if (swoBO != null && !(swoBO.getItemCategory().equals(LicenseConstants.QUOTE_FLAG))) {
							swoBO.setLastUpdatedDate(new Date(new java.util.Date().getTime()));
							swoBOFactory.createSWOBO(swoBO, SWOBOFactory.HISTORY_SWO_TABLE);
							eeBOList = eeBOFactory.findEEBOForSWO(swoBO.getProposalId(), swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_TABLE);
							if (eeBOList != null && eeBOList.size() > 0) {
								for (int j = 0; j < eeBOList.size(); j++) {
									eeBO = (EEBO) eeBOList.get(j);
									eeBOFactory.createEEBO(eeBO, EEBOFactory.EE_HISTORY_TABLE);
								}
							}
						}
					}
				}
			} catch (DomainException d) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
				throw ExceptionGenerator.generateServiceException(d.getErrorReport());
			}
		}
	}

	/**
	 *  
	 * This method removes the licenses as part of the delete inventory action 
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
	 * @param swoDomainDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public void removeLicenses(SWODomainDTO swoDomainDTO) throws ServiceException {
		SWOBOFactory swoBOFactory = null;
		SWOBO swoBO = null;
		swoBOFactory = new SWOBOFactory();
		String methodName = "removeLicenses";
		swoBO = populateSWOBO(swoDomainDTO, swoBO);
		try {
			swoBO = swoBOFactory.getSWOBO(swoBO.getProposalId(), swoBO.getCustomerId(),swoBO.getDmId(),swoBO.getSwoId(),SWOBOFactory.SWO_TABLE);
			swoBOFactory.deleteSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
			// CR 2031
			if(swoDomainDTO.isMarkedForDeletion()) {
				List swoList = swoBOFactory.findBySwoNoSerialNo(swoBO.getProposalId(),swoBO.getSwoNo(),swoBO.getSerialNo());
				for(int i=0;i<swoList.size();i++) {
					SWOBO swoBOTobeUpdated = (SWOBO) swoList.get(i);
					swoBOTobeUpdated.setDuplicateDeletedInd(UtilityConstants.YES);
					swoBOFactory.updateSWOBO(swoBOTobeUpdated,SWOBOFactory.SWO_TABLE);
				}
			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}

	/**
	 *  
	 * This method validates and updates SWO BO's for a Proposal/Contract For Status Check 
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
	 * @param swoDomainDTO
	 * @throws ServiceException
	 * @author Prakash
	 */
	public SWODomainDTO validateAndPopulateForStatusCheck(SWODomainDTO swoDomainDTO) throws ServiceException {
		SWOBOFactory swoBOFactory = new SWOBOFactory();
		List swoBOList = null;
		String methodName = "validateAndPopulateForStatusCheck";

		try {
			swoBOList = swoBOFactory.findSWOBOForProposal(swoDomainDTO.getProposalId(), SWOBOFactory.SWO_TABLE);
		} catch (DomainException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}

		int size = swoBOList.size();
		for (int i = 0; i < size; i++) {
			SWOBO swoBO = (SWOBO) swoBOList.get(i);
			try {
				String noExternalContrAsso = (String) swoDomainDTO.getValues().get(UtilityConstants.EXTERNAL_CNTR_NUM_ASSOCIATED);
				boolean updated = swoBO.validateAndPopulateForStatusCheck(noExternalContrAsso);
				if (updated) {
					swoBOFactory.updateSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
				}
				swoDomainDTO.setSwoExtContrNo(swoBO.getSwoExtContrNo());
			} catch (DomainException ex) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
			}
		}
		return swoDomainDTO;
	}

	/**
	 *  
	 * This method retrieves the SWO Details for Price 
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
	 * @param priceProposalDomainDTO
	 * @return
	 * @throws ServiceException
	 */

	public PriceProposalDomainDTO retrieveSWODetailsForPricing(PriceProposalDomainDTO priceProposalDomainDTO) throws ServiceException {
		System.out.println("SWOInfoBean.retrieveSWODetailsForPricing()");
		String methodName = "retrieveSWODetailsForPricing";
		int proposalId = priceProposalDomainDTO.getProposalId();
		SWOBOFactory swoBOFactory = new SWOBOFactory();
		List swoBOList = null;
		List swoDomainDTOList = new ArrayList();
		try {
			swoBOList = swoBOFactory.findSWOBOForProposal(proposalId, SWOBOFactory.SWO_TABLE);
		} catch (DomainException e) {
			// TODO Auto-generated catch block
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
		}

		for (int i = 0; i < swoBOList.size(); i++) {
			SWOBO swoBO = (SWOBO) swoBOList.get(i);
			SWODomainDTO swoDomainDTO = new SWODomainDTO(swoBO);
			swoDomainDTO.setActionName(priceProposalDomainDTO.getActionName());
			EEBOFactory eeBOFactory = new EEBOFactory();
			List eeDomainDTOList = new ArrayList();
			List eeBOList = null;
			try {
				eeBOList = eeBOFactory.findEEBOForSWO(proposalId, swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_TABLE);
			} catch (DomainException e1) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e1);
			}

			for (int k = 0; k < eeBOList.size(); k++) {
				EEBO eeBO = (EEBO) eeBOList.get(k);
				EEDomainDTO eeDomainDTO = new EEDomainDTO(eeBO);
				List priceDomainDTOList = new ArrayList();
				//populateEEDTO(eeDomainDTO,eeBO);
				PriceBOFactory priceBOFactory = new PriceBOFactory();
				List priceBOList = null;
				try {
					priceBOList = priceBOFactory.findPriceBOForEE(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId(), PriceBOFactory.PRICE_TABLE);
				} catch (DomainException e2) {
					// TODO Auto-generated catch block
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e2);
				}
				for (int j = 0; j < priceBOList.size(); j++) {
					PriceBO priceBO = (PriceBO) priceBOList.get(j);
					PriceDomainDTO priceDomainDTO = new PriceDomainDTO(priceBO);
					priceDomainDTOList.add(priceDomainDTO);
				} // end of price loop
				eeDomainDTO.setPriceDTOList(priceDomainDTOList);
				eeDomainDTOList.add(eeDomainDTO);
			} // end of eeLoop
			swoDomainDTO.setEEDTOList(eeDomainDTOList);
			swoDomainDTOList.add(swoDomainDTO);
		} // end of SWO Loop

		priceProposalDomainDTO.setSWODomainDTOList(swoDomainDTOList);

		return priceProposalDomainDTO;

	}

	/**
	 *  
	 * This method validates the swo edit information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 6, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoBO
	 * @param eeBO
	 * @throws ServiceException
	 */
	private void validateSWOEditInfo(SWOBO swoBO, EEBO eeBO, int size, List noChargeOption) throws ServiceException {
		ErrorReport errorReport = new ErrorReport();
		ServiceException se = new ServiceException();
		if (UtilityConstants.YES.equals(eeBO.getAlternatePriceUpdateInd()) && (UtilityConstants.YES.equals(swoBO.getAlternatePriceUpdateInd()))) {
			ErrorKey key = new ErrorKey(ErrorCodeConstants.SE0113, OPPTMessageCatalog.TYPE_SERVICE);
			errorReport.addErrorEntry(key, null);
			se.setErrorReport(errorReport);
			throw se;
		}
		if (size > 0) {
			if (UtilityConstants.YES.equals(swoBO.getAlternatePriceUpdateInd()) && LicenseConstants.CHARGE_OPTION_NO.equalsIgnoreCase(eeBO.getChargeOptionDesc())) {
				noChargeOption.add(eeBO);
			}
			if (noChargeOption.size() == size) {
				ErrorKey key = new ErrorKey(ErrorCodeConstants.SE0116, OPPTMessageCatalog.TYPE_SERVICE);
				errorReport.addErrorEntry(key, null);
				se.setErrorReport(errorReport);
				throw se;
			}
		}

		if (swoBO.getItemCategory() != null && !(swoBO.getItemCategory().equals(LicenseConstants.SVC_LICENSE_FLAG))) {
			swoBO.setPlannedInd(LicenseConstants.LICENSE_PLANNED);
			swoBO.setCalcPrice(0.0);
			eeBO.setCalculatedPrice(0.0);
		} else {
			ErrorKey key = new ErrorKey(ErrorCodeConstants.SE0125, OPPTMessageCatalog.TYPE_SERVICE);
			errorReport.addErrorEntry(key, null);
			se.setErrorReport(errorReport);
			throw se;
		}

	}

	/** 
	 * Removes the SVC Licenses of a proposal
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 9, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposal
	 * @throws ServiceException 
	 */
	public void removeSVCLicenses(ProposalDomainDTO proposal) throws ServiceException {
		SWOBOFactory swoBOFactory = null;
		swoBOFactory = new SWOBOFactory();
		if (proposal != null) {
			try {
				swoBOFactory.removeSVCLicensesOfProposal(proposal.getProposalId(), SWOBOFactory.SWO_TABLE);
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "SWOInfoBean", "removeSVCLicenses", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
	}

	/**
	 *  
	 * This method inserts the bumping information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 14, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoDomainDTO
	 * @throws ServiceException
	 */
	public void insertBumpSwoInfo(SWODomainDTO swoDomainDTO) throws ServiceException {

		SWOBOFactory swoBOFactory = null;
		EEBOFactory eeBOFactory = null;
		PriceBOFactory priceBOFactory = null;
		SWOBO swoBO = null;
		SWOBO maxBumpBO = null;
		EEBO eeBO = null;
		PriceBO priceBO = null;
		List swoBOList = null;
		List eeBOList = null;
		List priceBOList = null;
		List eeDomainDTOList = null;
		List priceDomainDTOList = null;
		PriceDomainDTO priceDomainDTO = null;
		EEDomainDTO eeDomainDTO = null;
		HashMap values = new HashMap();
		String methodName = "insertBumpSwoInfo";
		//TimeTaken log = new //TimeTaken(CLASS_NAME, methodName);
		/* CR6153 start change */
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		ProposalBO proposalBO = new ProposalBO();
		try {
			proposalBO = (ProposalBO) proposalContractBOFactory.getProposalContractBO(swoDomainDTO.getProposalId());
		} catch (DomainException de) {
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());
		}
		/* CR6153 end change */
		try {
			swoBOFactory = new SWOBOFactory();
			eeBOFactory = new EEBOFactory();
			priceBOFactory = new PriceBOFactory();

			if (swoDomainDTO.getActionName() != null && swoDomainDTO.getActionName().equals(ActionNameConstants.COPY_BUMP_SWO)) {
				String actionName = swoDomainDTO.getActionName();
				swoBO = swoBOFactory.getSWOBO(swoDomainDTO.getProposalId(), swoDomainDTO.getCustomerId(), swoDomainDTO.getDmId(), swoDomainDTO.getSwoId(), SWOBOFactory.SWO_TABLE);
				values.put(UtilityConstants.PLAN_START_DATE, swoDomainDTO.getPlanStartDate());
				values.put(UtilityConstants.PLAN_END_DATE, swoDomainDTO.getPlanEndDate());
				//maxBumpBO=swoBOFactory.findMaxBumpInd(SWOBOFactory.SWO_TABLE);
				/* CR6153 start change */
				if((proposalBO.getExtendPeriod() != null) && (proposalBO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
					swoBOList = swoBOFactory.findSWOBOForEquipSoldToPartyDM(swoDomainDTO.getEquipmentNo(), swoDomainDTO.getProposalId(),swoDomainDTO.getCustomerId(),swoDomainDTO.getDmId() );
				}
				else{
				/* CR6153 end change */
					swoBOList = swoBOFactory.findSWOBOForEquipmentNo(swoBO.getEquipmentNo(), swoBO.getProposalId(), SWOBOFactory.SWO_TABLE);
				}
				OPPTLogger.debug("SWO List size is" + swoBOList.size(), CLASS_NAME, methodName);

				try {

					swoBO.validateSWOForCopyBump(UtilityConstants.BUSINESSRULE_OTHER_TYPE, values);

				} catch (DomainException d) {
					throw ExceptionGenerator.generateServiceException(d.getErrorReport());
				}

				String bumpInd = validateBumpInd(swoBO, swoBOList, false, actionName);
				eeBOList = eeBOFactory.findEEBOForSWO(swoBO.getProposalId(), swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_TABLE);
				swoBO.setSwoId(swoBOFactory.findMaxSWOBO(SWOBOFactory.SWO_TABLE).getSwoId() + 1);
				OPPTLogger.debug("Max Seq no" + (swoBOFactory.findMaxSequenceNo(swoBO.getSalesDocNo(), swoBO.getSwoItemNo(), swoBO.getProposalId(), SWOBOFactory.SWO_TABLE).getSequenceNo() + 1), CLASS_NAME, methodName);
				swoBO.setSequenceNo(swoBOFactory.findMaxSequenceNo(swoBO.getSalesDocNo(), swoBO.getSwoItemNo(), swoBO.getProposalId(), SWOBOFactory.SWO_TABLE).getSequenceNo() + 1);
				if (bumpInd == null) {
					swoBO.setBumpInd("B1");
				} else {
					swoBO.setBumpInd(bumpInd);
				}
				//				if (swoBO.getSerialNo() != null && swoBO.getSerialNo().length() < 18) {
				//					swoBO.setSerialNo(swoBO.getSerialNo() + LicenseConstants.LICENSE_PLANNED);
				//				}
				swoBO.setPlannedInd(LicenseConstants.LICENSE_PLANNED);
				swoBO.setPlanStartDate(swoDomainDTO.getPlanStartDate());
				swoBO.setPlanEndDate(swoDomainDTO.getPlanEndDate());
				swoBO.setAlternatePrice(swoDomainDTO.getAlternatePrice());
				if (swoDomainDTO.getAlternatePrice() > 0) {
					swoBO.setAlternatePriceUpdateInd(LicenseConstants.ALT_PRICE_SWOLEVEL);
				} else {
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0133);
				}
				swoBO.setLockedInd(null);
				swoBO.setCalcPrice(0.00);
				swoBOFactory.createSWOBO(swoBO, SWOBOFactory.SWO_TABLE);

				for (int i = 0; i < eeBOList.size(); i++) {

					eeBO = (EEBO) eeBOList.get(i);
					validateBumpInfo(swoDomainDTO, swoBO, eeBO, eeBOList.size());
					priceBOList = priceBOFactory.findPriceBOForEE(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId(), EEBOFactory.EE_TABLE);
					eeBO.setEeId(eeBOFactory.findMaxEEBO(EEBOFactory.EE_TABLE).getEeId() + 1);
					eeBO.setSwoId(swoBO.getSwoId());
					eeBO.setCustomerId(swoBO.getCustomerId());
					eeBO.setProposalId(swoBO.getProposalId());
					eeBO.setPlanStartDate(swoBO.getPlanStartDate());
					eeBO.setSequenceNo(swoBO.getSequenceNo());
					eeBO.setPlanEndDate(swoBO.getPlanEndDate());
					if (swoBO.getAlternatePrice() > 0) {
						eeBO.setAlternatePriceUpdateInd(UtilityConstants.NO);
						eeBO.setAlternatePrice(0.00);
					}
					eeBOFactory.createEEBO(eeBO, EEBOFactory.EE_TABLE);

					for (int j = 0; j < priceBOList.size(); j++) {

						priceBO = (PriceBO) priceBOList.get(j);
						priceBO.setPriceId(priceBOFactory.findMaxPriceBO(PriceBOFactory.PRICE_TABLE).getPriceId() + 1);
						priceBO.setEeId(eeBO.getEeId());
						priceBO.setSwoId(eeBO.getSwoId());
						priceBO.setDmId(eeBO.getDmId());
						priceBO.setCustomerId(eeBO.getCustomerId());
						priceBO.setProposalId(eeBO.getProposalId());
						priceBOFactory.createPriceBO(priceBO, PriceBOFactory.PRICE_TABLE);

					}

				}

			} else if (swoDomainDTO.getActionName() != null && swoDomainDTO.getActionName().equals(ActionNameConstants.COPY_BUMP_DM)) {
				String actionName = swoDomainDTO.getActionName();
				swoBO = populateSWOBO(swoDomainDTO, swoBO);
				swoBO.setSwoId(swoBOFactory.findMaxSWOBO(SWOBOFactory.SWO_TABLE).getSwoId() + 1);
				swoBO.setSequenceNo(swoBOFactory.findMaxSequenceNo(swoBO.getSalesDocNo(), swoBO.getSwoItemNo(), swoBO.getProposalId(), SWOBOFactory.SWO_TABLE).getSequenceNo() + 1);
				/* CR6153 start change */
				if((proposalBO.getExtendPeriod() != null) && (proposalBO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
					swoBOList = swoBOFactory.findSWOBOForEquipSoldToPartyDM(swoDomainDTO.getEquipmentNo(), swoDomainDTO.getProposalId(),swoDomainDTO.getCustomerId(),swoDomainDTO.getDmId() );
				}
				else{
				/* CR6153 end change */
					swoBOList = swoBOFactory.findSWOBOForEquipmentNo(swoBO.getEquipmentNo(), swoBO.getProposalId(), SWOBOFactory.SWO_TABLE);
				}
				String bumpInd = validateBumpInd(swoBO, swoBOList, false, actionName);
				//				if (swoBO.getSerialNo() != null && swoBO.getSerialNo().length() < 18)
				//				{
				//					swoBO.setSerialNo(swoBO.getSerialNo() + LicenseConstants.LICENSE_PLANNED);
				//				}
				swoBO.setPlannedInd(LicenseConstants.LICENSE_PLANNED);
				swoBO.setPlanStartDate(swoDomainDTO.getPlanStartDate());
				swoBO.setPlanEndDate(swoDomainDTO.getPlanEndDate());
				//swoBO.setAlternatePrice(swoDomainDTO.getAlternatePrice());
				swoBO.setCalcPrice(0.00);
				SWOBO maxSWOBO = swoBOFactory.findMaxBumpInd(swoBO.getSalesDocNo(), swoBO.getSwoItemNo(), swoBO.getProposalId(), SWOBOFactory.SWO_TABLE);
				if (swoBO.getBumpInd() == null || swoBO.getBumpInd().equals(maxSWOBO.getBumpInd())) {
					if (bumpInd == null) {
						swoBO.setBumpInd("B1");
					} else {
						swoBO.setBumpInd(bumpInd);
					}
					Date dmBumpStartDate = (Date) swoDomainDTO.getValues().get(UtilityConstants.PLAN_START_DATE);
					OPPTLogger.debug("DM Bump start date" + dmBumpStartDate, CLASS_NAME, methodName);
					Date dmBumpEndDate = (Date) swoDomainDTO.getValues().get(UtilityConstants.PLAN_END_DATE);
					OPPTLogger.debug("DM Bump end date" + dmBumpEndDate, CLASS_NAME, methodName);
					swoBO.setPlanStartDate(dmBumpStartDate);
					swoBO.setPlanEndDate(dmBumpEndDate);
					swoBOFactory.createSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
					eeDomainDTOList = swoDomainDTO.getEEDTOList();

					if (eeDomainDTOList != null) {

						for (int i = 0; i < eeDomainDTOList.size(); i++) {

							eeDomainDTO = (EEDomainDTO) eeDomainDTOList.get(i);
							eeDomainDTO.setSwoId(swoBO.getSwoId());
							eeDomainDTO.setDmId(swoBO.getDmId());
							eeDomainDTO.setCustomerId(swoBO.getCustomerId());
							eeDomainDTO.setProposalId(swoDomainDTO.getProposalId());
							eeDomainDTO.setPlanStartDate(swoDomainDTO.getPlanStartDate());
							eeDomainDTO.setPlanEndDate(swoDomainDTO.getPlanEndDate());
							eeBO = populateEEBO(eeDomainDTO, eeBO);
							eeBO.setSequenceNo(swoBO.getSequenceNo());
							eeBO.setEeId(eeBOFactory.findMaxEEBO(EEBOFactory.EE_TABLE).getEeId() + 1);
							eeBOFactory.createEEBO(eeBO, EEBOFactory.EE_TABLE);
							priceDomainDTOList = eeDomainDTO.getPriceDTOList();

							if (priceDomainDTOList != null) {

								for (int j = 0; j < priceDomainDTOList.size(); j++) {

									priceDomainDTO = (PriceDomainDTO) priceDomainDTOList.get(j);
									priceDomainDTO.setEeId(eeBO.getEeId());
									priceDomainDTO.setSwoId(eeBO.getSwoId());
									priceDomainDTO.setDmId(eeBO.getDmId());
									priceDomainDTO.setCustomerId(eeBO.getCustomerId());
									priceDomainDTO.setProposalId(eeBO.getProposalId());
									priceBO = populatePriceBO(priceDomainDTO, priceBO);
									priceBO.setPriceId(priceBOFactory.findMaxPriceBO(PriceBOFactory.PRICE_TABLE).getPriceId() + 1);
									priceBOFactory.createPriceBO(priceBO, PriceBOFactory.PRICE_TABLE);
								}
							}
						}
					}
				}
			}

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
		//log.end();
	}

	/**
	 *  
	 * This method validates bumping information 
	 * <br><b>Known  Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param ee
	 * @param size
	 */
	private void validateBumpInfo(SWODomainDTO swoDomainDTO, SWOBO swoBO, EEBO eeBO, int size) throws ServiceException {
		ErrorReport errorReport = new ErrorReport();
		ServiceException se = new ServiceException();
		List noChargeOption = new ArrayList();
		List swoBOList = null;
		boolean isBumped = true;
		boolean isException = false;
		SWOBOFactory swoBOFactory = new SWOBOFactory();
		String methodName = "validateBumpInfo";
		
		/* CR6153 start change */
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		ProposalBO proposalBO = new ProposalBO();
		try {
			proposalBO = (ProposalBO) proposalContractBOFactory.getProposalContractBO(swoDomainDTO.getProposalId());
		} catch (DomainException de) {
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());
		}
		/* CR6153 end change */
		if (swoBO != null) {
			try {
				/* CR6153 start change */
				if((proposalBO.getExtendPeriod() != null) && (proposalBO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
					swoBOList = swoBOFactory.findSWOBOForEquipSoldToPartyDM(swoDomainDTO.getEquipmentNo(), swoDomainDTO.getProposalId(),swoDomainDTO.getCustomerId(),swoDomainDTO.getDmId() );
				}
				else{
				/* CR6153 end change */
					swoBOList = swoBOFactory.findSWOBOForEquipmentNo(swoBO.getEquipmentNo(), swoBO.getProposalId(), SWOBOFactory.SWO_TABLE);
				}
				if (isLicenseBumped(swoBOList)) {
					if (swoBOList.size() > 0) {
						SWOBO maxBO = (SWOBO) swoBOList.get(0);
						SWOBO temp;
						OPPTCalender calendar = new OPPTCalender();
						for (int i = 1; i < swoBOList.size(); i++) {
							temp = (SWOBO) swoBOList.get(i);
							if (calendar.isDateGreater(temp.getPlanEndDate(), maxBO.getPlanEndDate())) {
								maxBO = temp;
							}
						}
					}

					if (swoDomainDTO != null && swoBO != null && swoDomainDTO.getSwoId() == swoBO.getSwoId() && swoDomainDTO.getProposalId() == swoBO.getProposalId()) {
						isBumped = true;
					}
					if (!isBumped) {
						ErrorKey key = new ErrorKey(ErrorCodeConstants.SE0117, OPPTMessageCatalog.TYPE_SERVICE);
						errorReport.addErrorEntry(key, null);
						se.setErrorReport(errorReport);
						isException = true;
					}

				}
			} catch (DomainException d) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
				throw ExceptionGenerator.generateServiceException(d.getErrorReport());
			}
		}

		if (eeBO.getChargeOptionDesc() != null && eeBO.getChargeOptionDesc().equalsIgnoreCase(LicenseConstants.CHARGE_OPTION_NO)) {
			noChargeOption.add(eeBO);
		}
		if (noChargeOption.size() == size) {
			ErrorKey key = new ErrorKey(ErrorCodeConstants.SE0116, OPPTMessageCatalog.TYPE_SERVICE);
			errorReport.addErrorEntry(key, null);
			se.setErrorReport(errorReport);
			isException = true;
		}

		if (isException) {
			throw se;
		}
	}

	/**
	 *  
	 * This method validates bump indicator 
	 * <br><b>Known  Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param SWOBO
	 * @param List
	 */
	private String validateBumpInd(SWOBO swoBO, List swoList, boolean isEdit, String actionName) throws ServiceException {

		String methodName = "validateBumpInd";
		ErrorReport errorReport = new ErrorReport();
		ServiceException se = new ServiceException();
		boolean isBumped = false;
		boolean isException = false;
		SWOBO maxBO = null;
		String maxBumpInd = null;

		if (swoBO != null) {
			OPPTLogger.debug("License is bumped" + isLicenseBumped(swoList), CLASS_NAME, methodName);
			if (isLicenseBumped(swoList)) {
				if (swoList.size() > 0) {
					maxBO = (SWOBO) swoList.get(0);
					SWOBO temp;
					int tempVal = 0;
					int maxVal = 0;
					for (int i = 1; i < swoList.size(); i++) {
						temp = (SWOBO) swoList.get(i);
						if (temp != null) {
							if (temp.getBumpInd() != null && temp.getBumpInd().length() > 1) {
								tempVal = Integer.parseInt(temp.getBumpInd().substring(1));
							}

						}
						if (maxBO != null) {
							if (maxBO.getBumpInd() != null && maxBO.getBumpInd().length() > 1) {
								maxVal = Integer.parseInt(maxBO.getBumpInd().substring(1));
							}

						}
						if (tempVal > maxVal) {
							maxBO = temp;
						}
					}
				}
				if (!isEdit) {
					if (maxBO != null) {
						if (swoBO.getBumpInd() != null && swoBO.getBumpInd().equals(maxBO.getBumpInd())) {
							isBumped = true;
							isException = false;
							if (maxBO.getBumpInd() != null && !(maxBO.getBumpInd().equals(LicenseConstants.LICENSE_BUMPED))) {
								maxBumpInd = "B" + (Integer.parseInt(maxBO.getBumpInd().substring(1)) + 1);
							}
						} else if (swoBO.getBumpInd() == null) {
							isBumped = true;
							isException = false;
						} else if (actionName != null && ActionNameConstants.COPY_BUMP_DM.equals(actionName)) {
							isBumped = true;
							isException = false;
						}
					}
					if (!isBumped) {
						ErrorKey key = new ErrorKey(ErrorCodeConstants.SE0126, OPPTMessageCatalog.TYPE_SERVICE);
						errorReport.addErrorEntry(key, null);
						se.setErrorReport(errorReport);
						isException = true;
					}
					if (isException) {
						throw se;
					}
				} else {
					maxBumpInd = maxBO.getBumpInd();
				}
			}
		}
		return maxBumpInd;
	}

	/** 
	 * Update the SWO for Include/Exclude
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param license
	 * @return boolean
	 * @throws ServiceException 
	 */
	public boolean updateSWOForExcludeInclude(SWODomainDTO license) throws ServiceException {
		boolean result = false;
		SWOBOFactory factory = null;
		SWOBO licenseBO = null;

		if (license != null) {
			try {
				factory = new SWOBOFactory();
				licenseBO = factory.getSWOBO(license.getProposalId(), license.getCustomerId(), license.getDmId(), license.getSwoId(), SWOBOFactory.SWO_TABLE);
				if (!licenseBO.isSVCLicense()) {
					boolean validateForExclude = licenseBO.isLicenseExcluded();
					if (validateForExclude) {
						licenseBO.setExclusionId(LicenseConstants.LICENSE_INCLUDED);
					} else {
						licenseBO.setExclusionId(LicenseConstants.LICENSE_EXCLUDED);
					}
					licenseBO.setCalcPrice(0.00);
					factory.updateSWOBO(licenseBO, SWOBOFactory.SWO_TABLE);
					result = true;
				} else {
					result = false;
				}
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "SWOInfoBean", "updateSWOForExcludeInclude", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return result;
	}

	/** 
	 * Update all the SWOs of a DM for include/exclude
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param machine
	 * @return boolean
	 * @throws ServiceException 
	 */
	public boolean updateSWOsOfDMForExcludeInclude(DMDomainDTO machine) throws ServiceException {
		boolean result = false;
		SWOBOFactory factory = null;
		SWOBO licenseBO = null;
		List licensesBO = null;

		if (machine != null) {
			try {
				factory = new SWOBOFactory();
				licensesBO = factory.findSWOBOForDM(machine.getDmId(), machine.getCustomerId(), machine.getProposalId(), SWOBOFactory.SWO_TABLE);
				result = updateLicensesForExcludeInclude(licensesBO, factory);
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "SWOInfoBean", "updateSWOsOfDMForExcludeInclude", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return result;
	}

	/** 
	 * Updates all the SWOs of a customer for include/exclude
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customer
	 * @return boolean
	 * @throws ServiceException 
	 */
	public boolean updateSWOsOfCustomerForExcludeInclude(CustomerDomainDTO customer) throws ServiceException {
		boolean result = false;
		SWOBOFactory factory = null;
		SWOBO licenseBO = null;
		List licensesBO = null;

		if (customer != null) {
			try {
				factory = new SWOBOFactory();
				licensesBO = factory.findSWOBOForCustomer(customer.getCustomerId(), customer.getProposalId(), SWOBOFactory.SWO_TABLE);
				result = updateLicensesForExcludeInclude(licensesBO, factory);
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "SWOInfoBean", "updateSWOsOfCustomerForExcludeInclude", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return result;
	}

	/* 
	 * Update Licenses for Include/Exclude
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param licenses
	 * @param factory
	 * @return boolean
	 * @throws DomainException 
	 */
	private boolean updateLicensesForExcludeInclude(List licenses, SWOBOFactory factory) throws DomainException {
		SWOBO licenseBO = null;
		boolean result = false;

		if (licenses != null) {
			Iterator listOfLicenses = licenses.iterator();
			while (listOfLicenses.hasNext()) {
				licenseBO = (SWOBO) listOfLicenses.next();
				if (!licenseBO.isSVCLicense()) {
					boolean validateForExclude = licenseBO.isLicenseExcluded();
					if (validateForExclude) {
						licenseBO.setExclusionId(LicenseConstants.LICENSE_INCLUDED);
					} else {
						licenseBO.setExclusionId(LicenseConstants.LICENSE_EXCLUDED);
					}
					licenseBO.setCalcPrice(0.00);
					factory.updateSWOBO(licenseBO, SWOBOFactory.SWO_TABLE);
					result = true;
				}
			}
		}
		return result;
	}

	/** 
	 * Retrieves the SWO Information
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param license
	 * @return SWODomainDTO
	 * @throws ServiceException 
	 */
	public SWODomainDTO retrieveSWOInformation(SWODomainDTO license) throws ServiceException {
		SWOBO swoBO = null;
		SWOBOFactory swoBOFactory = new SWOBOFactory();
		int tableType = SWOBOFactory.SWO_TABLE;
		String methodName = "retrieveSWOInformation";

		if (license != null) {
			String actionName = license.getActionName();

			try {
				List swoBOList = null;
				swoBO = swoBOFactory.getSWOBO(license.getProposalId(), license.getCustomerId(), license.getDmId(), license.getSwoId(), tableType);
				if (ActionNameConstants.SWO_DETAILS.equals(actionName)) {
					license = populateSWODomainDTOWithEEAndPrice(swoBO, license, tableType, actionName);
					boolean result = swoBO.validateChangeSWOWithEE(UtilityConstants.BUSINESSRULE_PRE_COND_TYPE);
					license.setActionAllowed(result);
				} else if (ActionNameConstants.AMEND_SWO.equals(actionName)) {
					swoBO.validateForAmendSWO(UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, null);
					license = new SWODomainDTO(swoBO);
				} else if (ActionNameConstants.COPY_BUMP_SWO.equals(actionName)) {
					SWOBO maxSWOBO = swoBOFactory.findMaxBumpInd(swoBO.getSalesDocNo(), swoBO.getSwoItemNo(), swoBO.getProposalId(), SWOBOFactory.SWO_TABLE);
					if (swoBO.getBumpInd() != null && swoBO.getBumpInd().equals(maxSWOBO.getBumpInd())) {
						license = new SWODomainDTO(swoBO);
					} else if (swoBO.getBumpInd() == null || swoBO.getBumpInd().equals("")) {
						license = new SWODomainDTO(swoBO);
					} else {
						ErrorReport errorReport = new ErrorReport();
						ServiceException se = new ServiceException();
						ErrorKey key = new ErrorKey(ErrorCodeConstants.SE0126, OPPTMessageCatalog.TYPE_SERVICE);
						errorReport.addErrorEntry(key, null);
						se.setErrorReport(errorReport);
						throw se;
					}
				} else {
					license = new SWODomainDTO(swoBO);
				}
			} catch (DomainException e) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "SWOInfoBean", "retrieveSWOInformation", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return license;
	}

	/* 
	 * Populates the SWODomainDTO with EE and Price information 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param licenseBO
	 * @param requestLicense
	 * @param tableType
	 * @param actionName
	 * @return
	 * @throws DomainException 
	 */
	private SWODomainDTO populateSWODomainDTOWithEEAndPrice(SWOBO licenseBO, SWODomainDTO requestLicense, int tableType, String actionName) throws DomainException {
		EEBOFactory eeBOFactory = null;
		PriceBOFactory priceBOFactory = null;
		List eeDomainDTOList = null;
		List priceDomainDTOList = null;
		EEDomainDTO eeDomainDTO = null;
		PriceDomainDTO priceDomainDTO = null;
		SWODomainDTO license = null;
		EEBO eeBO = null;
		PriceBO priceBO = null;

		eeBOFactory = new EEBOFactory();
		priceBOFactory = new PriceBOFactory();
		eeDomainDTOList = new ArrayList();
		priceDomainDTOList = new ArrayList();

		license = new SWODomainDTO(licenseBO);
		List eeBOList = eeBOFactory.findEEBOForSWO(requestLicense.getProposalId(), requestLicense.getCustomerId(), requestLicense.getDmId(), requestLicense.getSwoId(), tableType);
		for (int j = 0; j < eeBOList.size(); j++) {
			eeBO = (EEBO) eeBOList.get(j);
			eeDomainDTO = new EEDomainDTO(eeBO);
			if (ActionNameConstants.SWO_DETAILS.equals(actionName)) {
				boolean result = !eeBO.isNoChargeOption();
				eeDomainDTO.setActionAllowed(result);
			} else {
				List priceBOList = priceBOFactory.findPriceBOForEE(eeDomainDTO.getEeId(), eeDomainDTO.getSwoId(), eeDomainDTO.getDmId(), eeDomainDTO.getCustomerId(), eeDomainDTO.getProposalId(), tableType);
				for (int k = 0; k < priceBOList.size(); k++) {
					priceBO = (PriceBO) priceBOList.get(k);
					priceDomainDTO = new PriceDomainDTO(priceBO);
					priceDomainDTOList.add(priceDomainDTO);
				}
				eeDomainDTO.setPriceDTOList(priceDomainDTOList);
			}
			eeDomainDTOList.add(eeDomainDTO);
		}
		license.setEEDTOList(eeDomainDTOList);
		license.setActionName(actionName);
		return license;
	}

	/**
	 *  
	 * This method updates the swo information for Edit Inventory operation, 
	 * AmendSWO operation and Copy Bump operation. In Copy Bump, the original license is updated
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 31, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoDomainDTO
	 * @throws ServiceException
	 * @author Ravishankar
	 */
	public void updateSWOEditInfo(SWODomainDTO swoDomainDTO) throws ServiceException {
		SWOBOFactory swoBOFactory = null;
		EEBOFactory eeBOFactory = null;
		swoBOFactory = new SWOBOFactory();
		eeBOFactory = new EEBOFactory();
		SWOBO swoBO = null;
		List swoBOList = null;
		EEBO eeBO = null;
		List eeBOList = null;
		String methodName = "updateSWOEditInfo";
		String actionName = swoDomainDTO.getActionName();
		int tableType = SWOBOFactory.SWO_TABLE;
		OPPTCalender calender = new OPPTCalender();
		OPPTLogger.debug("Action Name : " + actionName, CLASS_NAME, methodName);

		//TimeTaken log = new //TimeTaken(CLASS_NAME, methodName);

		try {
			swoBO = swoBOFactory.getSWOBO(swoDomainDTO.getProposalId(), swoDomainDTO.getCustomerId(), swoDomainDTO.getDmId(), swoDomainDTO.getSwoId(), tableType);
			if (ActionNameConstants.EDIT_INVENTORY_SWO.equals(actionName)) {

				if (swoBO.getBumpInd() != null && swoBO.getBumpInd().equals(LicenseConstants.LICENSE_BUMPED)) {
					if (calender.isDateGreater(swoDomainDTO.getPlanStartDate(), swoBO.getPlanStartDate())) {
						swoBO.setPlanStartDate(OPPTCalender.getDayMinusOneSqlDate(swoDomainDTO.getPlanStartDate()));
						swoBO.setPlanEndDate(OPPTCalender.getDayPlusOneSqlDate(swoDomainDTO.getPlanEndDate()));
					}
				} else {
					/*
					 * MN 19640197
					 * Defect 5
					 * Change made by Balaji
					 */
					//if (calender.isDateGreater(swoDomainDTO.getPlanStartDate(), swoBO.getPlanStartDate())) {
					swoBO.setPlanStartDate(swoDomainDTO.getPlanStartDate());
					swoBO.setPlanEndDate(swoDomainDTO.getPlanEndDate());
					//}
					/*
					 * MN 19640197
					 * Defect 4
					 * Change made by Balaji- Ends
					 */
				}
				swoBO.setAlternatePrice(swoDomainDTO.getAlternatePrice());
				swoBO.setPlannedInd(LicenseConstants.LICENSE_PLANNED);
				swoBO.setPlanDateInd(UtilityConstants.NO);
				swoBO.setCalcPrice(0.00);
				List noChargeOption = new ArrayList();
				eeBOList = eeBOFactory.findEEBOForSWO(swoBO.getProposalId(), swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_TABLE);
				/**
				 * 31/05/2004
				 * MN 19387428
				 * Defect 351
				 * For Alternate Price change added by Balaji
				 */
				boolean swoAltPrice = false;
				if (swoBO.getAlternatePrice() == -1) {
					swoBO.setAlternatePriceUpdateInd(UtilityConstants.NO);
					swoBO.setAlternatePrice(0);
				} else {
					swoBO.setAlternatePriceUpdateInd(UtilityConstants.YES);
					swoAltPrice = true;
				}

				if (eeBOList != null && eeBOList.size() > 0) {
					for (int i = 0; i < eeBOList.size(); i++) {
						eeBO = (EEBO) eeBOList.get(i);
						validateSWOEditInfo(swoBO, eeBO, eeBOList.size(), noChargeOption);
						if (swoAltPrice) {
							eeBO.setAlternatePriceUpdateInd(UtilityConstants.NO);
						}
						eeBO.setAlternatePrice(0.00);
						eeBO.setCalculatedPrice(0.00);
						eeBO.setPlanStartDate(swoDomainDTO.getPlanStartDate());
						eeBO.setPlanEndDate(swoDomainDTO.getPlanEndDate());
						eeBOFactory.updateEEBO(eeBO, tableType);
					}
				}
				/**
				  * 31/05/2004
				  * MN 19387428
				  * Defect 351
				  * For Alternate Price change added by Balaji
				  */
				
				
				/* CR6153 start changes*/
				
				ProposalContractBOFactory proposalFactory = new ProposalContractBOFactory();
				ProposalContractBO proposalContractBO = new ProposalBO();
				SWOBOFactory swoFactory = new SWOBOFactory();
				List swoBOList1 = null;
				List eeBOList1 = null;
				
				proposalContractBO = proposalFactory.getProposalContractBO(swoBO.getProposalId());
				
				if((proposalContractBO.getExtendPeriod() != null) && (proposalContractBO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
					if(((swoBO.getPlanStartDate().after(proposalContractBO.getContrStartPeriod()) &&(swoBO.getPlanEndDate().before(proposalContractBO.getContrEndPeriod())))
								|| (calender.isDateEqual(swoBO.getPlanStartDate(),proposalContractBO.getContrStartPeriod())) 
								|| (calender.isDateEqual(swoBO.getPlanEndDate(),proposalContractBO.getContrEndPeriod())))){
						
						swoBOList1 = swoFactory.findBySWONoSalesDocSwoItemNo(swoBO.getProposalId(), swoBO.getSwoNo(), swoBO.getSalesDocNo(),swoBO.getSwoItemNo());
						if(swoBOList1 != null){
							for (int k = 0; k < swoBOList1.size(); k++) {
								SWOBO swoBOSandS = (SWOBO) swoBOList1.get(k);
								swoBOSandS.setAlternatePrice(swoBO.getAlternatePrice());
								swoBOSandS.setPlannedInd(LicenseConstants.LICENSE_PLANNED);
								swoBOSandS.setPlanDateInd(UtilityConstants.NO);
								swoBOSandS.setCalcPrice(0.00);
								List noChargeOption1 = new ArrayList();
								eeBOList1 = eeBOFactory.findEEBOForSWO(swoBOSandS.getProposalId(), swoBOSandS.getCustomerId(), swoBOSandS.getDmId(), swoBOSandS.getSwoId(), EEBOFactory.EE_TABLE);
								boolean swoAltPrice1 = false;
								if (swoBOSandS.getAlternatePrice() == -1) {
									swoBOSandS.setAlternatePriceUpdateInd(UtilityConstants.NO);
									swoBOSandS.setAlternatePrice(0);
								} else {
									swoBOSandS.setAlternatePriceUpdateInd(UtilityConstants.YES);
									swoAltPrice1 = true;
								}
								swoFactory.updateSWOBO(swoBOSandS, 1);
								if (eeBOList1 != null && eeBOList1.size() > 0) {
									for (int i = 0; i < eeBOList1.size(); i++) {
										EEBO eeBOSandS = (EEBO) eeBOList1.get(i);
										validateSWOEditInfo(swoBOSandS, eeBOSandS, eeBOList1.size(), noChargeOption1);
										if (swoAltPrice1) {
											eeBOSandS.setAlternatePriceUpdateInd(UtilityConstants.NO);
										}
										eeBOSandS.setAlternatePrice(0.00);
										eeBOSandS.setCalculatedPrice(0.00);
										eeBOFactory.updateEEBO(eeBOSandS, tableType);
									}
								}
							}
						}
					}
				}
				/* CR6153 end changes */
			} else if (ActionNameConstants.SUBMIT_AMEND_SWO.equals(actionName)) {

				swoBO.validateForAmendSWO(UtilityConstants.BUSINESSRULE_OTHER_TYPE, swoDomainDTO.getValues());
				swoBO.setAmendStartDate(swoDomainDTO.getAmendStartDate());
				swoBO.setAmendEndDate(swoDomainDTO.getAmendEndDate());
				swoBO.setLockedInd(LicenseConstants.LICENSE_LOCKED);
				swoBO.setLastUpdatedDate(new Date(new java.util.Date().getTime()));
				swoBO.setCalcPrice(0.00);

			} else if (ActionNameConstants.COPY_BUMP_DM.equals(actionName) || ActionNameConstants.COPY_BUMP_SWO.equals(actionName)) {

				if (!ActionNameConstants.COPY_BUMP_DM.equals(actionName)) {
					swoBO.setPlanEndDate(OPPTCalender.getDayMinusOneSqlDate(swoDomainDTO.getPlanStartDate()));
				} else {
					swoBO.setPlanStartDate(swoDomainDTO.getPlanStartDate());
					swoBO.setPlanEndDate(swoDomainDTO.getPlanEndDate());
				}
				OPPTLogger.debug("DM Bump start date" + swoDomainDTO.getPlanStartDate(), CLASS_NAME, methodName);
				OPPTLogger.debug("DM Bump end date" + swoDomainDTO.getPlanEndDate(), CLASS_NAME, methodName);
				if (swoBO.getBumpInd() == null) {
					swoBO.setBumpInd(LicenseConstants.LICENSE_BUMPED);
				}
				swoBO.setPlannedInd(LicenseConstants.LICENSE_PLANNED);
				OPPTLogger.debug("Action Name" + actionName, CLASS_NAME, methodName);
				if (swoDomainDTO.getActionName() != null && ActionNameConstants.COPY_BUMP_SWO.equals(actionName)) {
					HashMap map = null;
					map = swoDomainDTO.getValues();
					if (map != null && map.get(UtilityConstants.SWO_ALTERNATE_PRICE) != null) {
						double altPrice = Double.parseDouble((String) map.get(UtilityConstants.SWO_ALTERNATE_PRICE));
						OPPTLogger.debug("Alternate Price" + altPrice, CLASS_NAME, methodName);
						swoBO.setAlternatePrice(altPrice);
						if (altPrice > 0) {
							swoBO.setAlternatePriceUpdateInd(LicenseConstants.ALT_PRICE_SWOLEVEL);
						} else {
							eeBOList = eeBOFactory.findEEBOForSWO(swoBO.getProposalId(), swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_TABLE);
							List noCharge = new ArrayList();
							if (eeBOList != null && eeBOList.size() > 0) {
								for (int i = 0; i < eeBOList.size(); i++) {
									eeBO = (EEBO) eeBOList.get(i);
									validateSWOEditInfo(swoBO, eeBO, eeBOList.size(), noCharge);
									eeBO.setPlanStartDate(swoBO.getPlanStartDate());
									eeBO.setPlanEndDate(swoBO.getPlanEndDate());
									if (swoBO.getAlternatePrice() == 0) {
										eeBO.setAlternatePrice(0.00);
									}
									eeBO.setCalculatedPrice(0.00);
									eeBOFactory.updateEEBO(eeBO, tableType);
								}
							}
							swoBO.setAlternatePriceUpdateInd(UtilityConstants.NO);
						}
					}
				}
				swoBO.setCalcPrice(0.0);
			}
			swoBOFactory.updateSWOBO(swoBO, tableType);
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
		//log.end();
	}

	/**
	 *  
	 * This method updates the swo information 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoDomainDTO
	 * @throws ServiceException
	 */
	public void updateSWOInfo(SWODomainDTO swoDomainDTO) throws ServiceException {
		//System.out.println("SWOInfoBean.updateSWOInfo()");
		String methodName = "updateSWOInfo";
		//TimeTaken log = new //TimeTaken(CLASS_NAME, methodName);
		SWOBOFactory swoBOFactory = null;
		EEBOFactory eeBOFactory = null;
		PriceBOFactory priceBOFactory = null;
		List eeDomainDTOList = null;
		List priceDomainDTOList = null;
		EEDomainDTO eeDomainDTO = null;
		PriceDomainDTO priceDomainDTO = null;
		SWOBO swoBO = null;
		SWOBO maxSWOBO = null;
		swoBOFactory = new SWOBOFactory();
		eeBOFactory = new EEBOFactory();
		priceBOFactory = new PriceBOFactory();
		Iterator iterateEE = null;
		Iterator iteratePrice = null;
		List swoBOList = null;
		
		/* CR6153 start change */
		ProposalContractBOFactory proposalContractBOFactory = new ProposalContractBOFactory();
		ProposalContractBO proposalContractBO = new ProposalBO();
		try {
			proposalContractBO = (ProposalContractBO) proposalContractBOFactory.getProposalContractBO(swoDomainDTO.getProposalId());
		} catch (DomainException de) {
			throw ExceptionGenerator.generateServiceException(de.getErrorReport());
		}
		/* CR6153 end change */
		
		if (ActionNameConstants.CHANGE_SWODETAILS.equals(swoDomainDTO.getActionName())) {
			//System.out.println("SWOInfoBean.updateSWOInfo():1st if:");
			updateSWODetailsForChangeSWOAndEE(swoDomainDTO);
		} else if (ActionNameConstants.DELTA_FETCH.equals(swoDomainDTO.getActionName())) {
			try {
				/* CR6153 start change */
				//System.out.println("SWOInfoBean.updateSWOInfo():2nd if:");
				if((proposalContractBO.getExtendPeriod() != null) && (proposalContractBO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
					swoBOList = swoBOFactory.findSWOBOForEquipSoldToPartyDM(swoDomainDTO.getEquipmentNo(), swoDomainDTO.getProposalId(),swoDomainDTO.getCustomerId(),swoDomainDTO.getDmId() );
				}
				else{
				/* CR6153 end change */
					swoBOList = swoBOFactory.findSWOBOForEquipmentNo(swoDomainDTO.getEquipmentNo(), swoDomainDTO.getProposalId(), SWOBOFactory.SWO_TABLE);
				}
				Iterator iterateSWO = swoBOList.iterator();
				while (iterateSWO.hasNext()) {
					swoBO = (SWOBO) iterateSWO.next();
					swoBO = populateSWOBO(swoDomainDTO, swoBO);
					swoBO.setLastUpdatedDate(new Date(new java.util.Date().getTime()));
					swoBO.setDeltaFetchId(LicenseConstants.LICENSE_DELTAFETCH);
					swoBOFactory.updateSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
					List eeLocalList = eeBOFactory.findEEBOForSWO(swoBO.getProposalId(), swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_TABLE);
					if (eeLocalList != null && eeLocalList.size() > 0) {
						iterateEE = swoDomainDTO.getEEDTOList().iterator();
						while (iterateEE.hasNext()) {
							EEBO eeBO = null;
							eeDomainDTO = (EEDomainDTO) iterateEE.next();
							eeBO = populateEEBOLocalList(eeLocalList, eeDomainDTO);
							if (eeBO != null) {
								eeBOFactory.updateEEBO(eeBO, EEBOFactory.EE_TABLE);
								List priceLocalList = priceBOFactory.findPriceBOForEE(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId(), PriceBOFactory.PRICE_TABLE);
								if (priceLocalList != null && priceLocalList.size() > 0) {
									iteratePrice = eeDomainDTO.getPriceDTOList().iterator();
									while (iteratePrice.hasNext()) {
										PriceBO priceBO = null;
										priceDomainDTO = (PriceDomainDTO) iteratePrice.next();
										priceBO = populatePriceBOLocalList(priceLocalList, priceDomainDTO);
										if (priceBO != null) {
											priceBOFactory.updatePriceBO(priceBO, PriceBOFactory.PRICE_TABLE);
										}
									}
								}
							}
						}
					}
				}
			} catch (DomainException d) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
				throw ExceptionGenerator.generateServiceException(d.getErrorReport());
			}
		} else {
			try {
				//System.out.println("SWOInfoBean.updateSWOInfo():3rd else:");
				swoBO = populateSWOBO(swoDomainDTO, swoBO);
				swoBOFactory.updateSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
				eeDomainDTOList = swoDomainDTO.getEEDTOList();

				for (int i = 0; i < eeDomainDTOList.size(); i++) {
					eeDomainDTO = (EEDomainDTO) eeDomainDTOList.get(i);
					//System.out.println("SWOInfoBean.updateSWOInfo():4th:");
					// Added to fix a BUG
					if (eeDomainDTO.getEeId() > 0) {
						try {
							EEBO eeBO = null;
							eeBO = eeBOFactory.getEEBO(eeDomainDTO.getProposalId(), eeDomainDTO.getCustomerId(), eeDomainDTO.getDmId(), eeDomainDTO.getSwoId(), eeDomainDTO.getEeId(), EEBOFactory.EE_TABLE);
							eeBO = populateEEBO(eeDomainDTO, eeBO);
							eeBOFactory.updateEEBO(eeBO, EEBOFactory.EE_TABLE);

							if (!(ActionNameConstants.PRICE.equals(swoDomainDTO.getActionName()) || ActionNameConstants.CONFIGURE_DM.equals(swoDomainDTO.getActionName()))) {
								priceDomainDTOList = eeDomainDTO.getPriceDTOList();
								for (int j = 0; j < priceDomainDTOList.size(); j++) {
									priceDomainDTO = (PriceDomainDTO) priceDomainDTOList.get(j);
									PriceBO priceBO = null;
									//priceBO=priceBOFactory.get
									priceBO = populatePriceBO(priceDomainDTO, priceBO);
									priceBOFactory.updatePriceBO(priceBO, PriceBOFactory.PRICE_TABLE);
								}

							}
						} catch (DomainException de) {
							// We do not handle this exception.  	
						}
					}

				}
			} catch (DomainException d) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
				throw ExceptionGenerator.generateServiceException(d.getErrorReport());
			}
		}
		//log.end();
	}

	/* 
	 * Updates the SWO Details for change SWO and EE 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 16, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param domainLicense
	 * @throws ServiceException 
	 */
	private void updateSWODetailsForChangeSWOAndEE(SWODomainDTO domainLicense) throws ServiceException {
		//System.out.println("SWOInfoBean.updateSWODetailsForChangeSWOAndEE()");
		SWOBOFactory swoFactory = null;
		SWOBO license = null;

		int tableType = SWOBOFactory.SWO_TABLE;

		if (domainLicense != null) {
			//System.out.println("SWOInfoBean.updateSWODetailsForChangeSWOAndEE()1:");
			try {
				swoFactory = new SWOBOFactory();
				license = swoFactory.getSWOBO(domainLicense.getProposalId(), domainLicense.getCustomerId(), domainLicense.getDmId(), domainLicense.getSwoId(), tableType);
				boolean isSandS = UtilityConstants.SANDS_IND.equals(license.getSAndSInd()) ? true : false;

				license.validateChangeSWOWithEE(UtilityConstants.BUSINESSRULE_OTHER_TYPE);
				List eeDomainList = domainLicense.getEEDTOList();
				double sumAltEEPrice = 0.0;	
				if (eeDomainList != null && eeDomainList.size() > 0) {
					//System.out.println("SWOInfoBean.updateSWODetailsForChangeSWOAndEE():eeDomainList.size():"+eeDomainList.size());
					Iterator iterate = eeDomainList.iterator();
					EEBOFactory eeFactory = new EEBOFactory();
					EEBO eeBO = null;
					EEDomainDTO domainEE = null;
					
					while (iterate.hasNext()) {
						domainEE = (EEDomainDTO) iterate.next();
						eeBO = eeFactory.getEEBO(domainLicense.getProposalId(), domainLicense.getCustomerId(), domainLicense.getDmId(), domainLicense.getSwoId(), domainEE.getEeId(), tableType);
											
						if (!eeBO.isNoChargeOption()) {
							//System.out.println("SWOInfoBean.updateSWODetailsForChangeSWOAndEE()2:"+domainEE.getAlternatePrice());
							/*if(domainEE.getAlternatePrice()> 0){
								sumAltEEPrice += domainEE.getAlternatePrice();
								//System.out.println("SWOInfoBean.updateSWODetailsForChangeSWOAndEE():sumAltEEPrice:"+sumAltEEPrice);
								license.setAlternatePrice(sumAltEEPrice);
								license.setCalcPrice(sumAltEEPrice);
								swoFactory.updateSWOBO(license, tableType);
							}*/
							eeBO.setAlternatePrice(domainEE.getAlternatePrice());
							if (domainEE.getAlternatePrice() == -1) {
								//System.out.println("SWOInfoBean.updateSWODetailsForChangeSWOAndEE()3:");
								eeBO.setAlternatePrice(0);
								eeBO.setAlternatePriceUpdateInd(null);
							} else {
								//System.out.println("SWOInfoBean.updateSWODetailsForChangeSWOAndEE()4:");
								eeBO.setAlternatePriceUpdateInd(LicenseConstants.ALT_PRICE_EELEVEL);
							}
							if (isSandS) {
								eeBO.setSAndSDiscountPercent(domainEE.getSAndSDiscountPercent());
							}
							eeFactory.updateEEBO(eeBO, tableType);
						}
						
						/* CR6153 start change */
						ProposalContractBOFactory proposalFactory = new ProposalContractBOFactory();
						ProposalContractBO proposalContractBO = null;
						List eeBOList = null;
						OPPTCalender calender = new OPPTCalender();
						
						proposalContractBO = proposalFactory.getProposalContractBO(eeBO.getProposalId());
						
						if(proposalContractBO != null){
							if((proposalContractBO.getExtendPeriod() != null) && (proposalContractBO.getExtendPeriod().equals(UtilityConstants.S_S_EXTEND_PERIOD))){
								if(((eeBO.getPlanStartDate().after(proposalContractBO.getContrStartPeriod()) &&(eeBO.getPlanEndDate().before(proposalContractBO.getContrEndPeriod())))
											|| (calender.isDateEqual(eeBO.getPlanStartDate(),proposalContractBO.getContrStartPeriod())) 
											|| (calender.isDateEqual(eeBO.getPlanEndDate(),proposalContractBO.getContrEndPeriod())))){
									try {
										eeBOList = eeFactory.findByEENoSalesDocEEItemSwoItem(eeBO.getProposalId(), eeBO.getEeNo(), eeBO.getSalesDocNo(),eeBO.getEeItemNo(),eeBO.getSwoItemNo());
									} catch (DomainException e1) {
										OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "updateSWODetailsForChangeSWOAndEE", null, e1);
									}
									if(eeBOList != null){
										for (int k = 0; k < eeBOList.size(); k++) {
											EEBO eeBOSandS = (EEBO) eeBOList.get(k);
											//System.out.println("SWOInfoBean.updateSWODetailsForChangeSWOAndEE()5:"+eeBO.getAlternatePrice());
											eeBOSandS.setAlternatePrice(eeBO.getAlternatePrice());
											eeBOSandS.setAlternatePriceUpdateInd(eeBO.getAlternatePriceUpdateInd());
											eeBOSandS.setSAndSDiscountPercent(eeBO.getSAndSDiscountPercent());
											eeFactory.updateEEBO(eeBOSandS, 1);
											
											List swoBOList = null;
											SWOBO swoBO = null;
											try {
												swoBOList = swoFactory.findSWOBOForProposal(eeBOSandS.getProposalId(),1);
											} catch (DomainException e1) {
												// TODO Auto-generated catch block
												OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "updateSWODetails", null, e1);
											}
											if(swoBOList != null){
												Iterator iter = swoBOList.iterator();
												while (iter.hasNext()) {
													//System.out.println("SWOInfoBean.updateSWODetailsForChangeSWOAndEE()6:");
													swoBO = (SWOBO) iter.next();
													swoBO.setAlternatePrice(0.00);
													swoBO.setCalcPrice(0.00);
													swoFactory.updateSWOBO(swoBO, tableType);
												}
											}
										}
									}
								}
							}
						}
						/* CR6153 end change */
						
					}
				/*	if(domainEE.getAlternatePrice()> 0){
						double sumAltEEPrice = 0.0;
						int size = eeDomainList.size();
						for(int i= 0 ; i < size ; i++) 
						{
								
							sumAltEEPrice += domainEE.getAlternatePrice();
							System.out.println("SWOInfoBean.updateSWODetailsForChangeSWOAndEE():sumAltEEPrice:"+sumAltEEPrice);
							license.setAlternatePrice(sumAltEEPrice);
							license.setCalcPrice(sumAltEEPrice);
							swoFactory.updateSWOBO(license, tableType);
							
						}}*/
					/*for(int i= 0, size = eeDomainList.size(); i < size ; i++) 
					{
						double sumAltEEPrice = 0.0;		
						sumAltEEPrice += domainEE.getAlternatePrice();
						System.out
								.println("SWOInfoBean.updateSWODetailsForChangeSWOAndEE():sumAltEEPrice:"+sumAltEEPrice);
						license.setAlternatePrice(sumAltEEPrice);
						license.setCalcPrice(sumAltEEPrice);
						swoFactory.updateSWOBO(license, tableType);
						
					}*/
				
				} else {
					return;
				}
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "SWOInfoBean", "updateSWODetailsForChangeSWOAndEE", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
	}

	/**
	 *  
	 * This method stores the Configuration information in Temp table 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param tempEEDomainDTO
	 * @throws ServiceException
	 */
	public void storeEEConfigInfo(TempEEDomainDTO tempEEDomainDTO) throws ServiceException {
		TempEEBOFactory tempEEBOFactory = null;
		TempEEBO tempEEBO = null;
		String methodName = "storeEEConfigInfo";
		tempEEBOFactory = new TempEEBOFactory();
		try {
			tempEEBO = tempEEBOFactory.getTempEEBO(tempEEDomainDTO.getProposalId(), tempEEDomainDTO.getCustomerId(), tempEEDomainDTO.getDmId());
			if (tempEEBO != null) {
				populateTempEEBOWithDomainDTO(tempEEBO, tempEEDomainDTO);
				tempEEBOFactory.updateTempEEBO(tempEEBO);
			}
		} catch (DomainException d) {
			tempEEBO = new TempEEBO();
			populateTempEEBOWithDomainDTO(tempEEBO, tempEEDomainDTO);
			try {
				tempEEBOFactory.createTempEEBO(tempEEBO);
			} catch (DomainException d1) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d1);
				throw ExceptionGenerator.generateServiceException(d1.getErrorReport());
			}
		}
	}

	/**
	 *  
	 * This method retrieves the EE Configuration information from temp table 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param tempEEDomainDTO
	 * @return
	 * @throws ServiceException
	 */
	public TempEEDomainDTO retrieveEEConfigInfoFromTemp(TempEEDomainDTO tempEEDomainDTO) throws ServiceException {
		TempEEBOFactory tempEEBOFactory = null;
		TempEEBO tempEEBO = null;
		String methodName = "retrieveEEConfigInfoFromTemp";
		tempEEBOFactory = new TempEEBOFactory();
		try {
			tempEEBO = tempEEBOFactory.getTempEEBO(tempEEDomainDTO.getProposalId(), tempEEDomainDTO.getCustomerId(), tempEEDomainDTO.getDmId());
			tempEEDomainDTO = new TempEEDomainDTO(tempEEBO);

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}

		return tempEEDomainDTO;
	}

	/**
	 *  
	 * This method stores the SWO Configuration information
	 * During the configure dm process
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 24, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoDomainDTO
	 * @throws ServiceException
	 */
	public void storeSWOConfigInfo(SWODomainDTO swoDomainDTO) throws ServiceException {
		SWOBOFactory swoBOFactory = null;
		PriceBOFactory priceBOFactory = null;
		EEBOFactory eeBOFactory = null;
		EEDomainDTO eeDomainDTO = null;
		PriceDomainDTO priceDomainDTO = null;
		HashMap values = null;
		SWOBO swoBO = null;
		int newDMId = 0;
		String methodName = "storeSWOConfigInfo";
		Date planStartDate = null;
		try {
			swoBOFactory = new SWOBOFactory();
			priceBOFactory = new PriceBOFactory();
			eeBOFactory = new EEBOFactory();
			values = swoDomainDTO.getValues();
			newDMId = Integer.parseInt((String) values.get(UtilityConstants.DM_ID));
			swoBO = swoBOFactory.getSWOBO(swoDomainDTO.getProposalId(), swoDomainDTO.getCustomerId(), swoDomainDTO.getDmId(), swoDomainDTO.getSwoId(), SWOBOFactory.SWO_TABLE);
			swoBO.setSwoId(swoBOFactory.findMaxSWOBO(SWOBOFactory.SWO_TABLE).getSwoId() + 1);
			swoBO.setDmId(newDMId);
			swoBO.setPlanStartDate(swoDomainDTO.getPlanStartDate());
			swoBO.setPlanEndDate(swoDomainDTO.getPlanEndDate());
			swoBO.setSequenceNo(swoBOFactory.findMaxSequenceNo(swoBO.getSalesDocNo(), swoBO.getSwoItemNo(), swoBO.getProposalId(), SWOBOFactory.SWO_TABLE).getSequenceNo() + 1);
			swoBO.setPlannedInd(LicenseConstants.LICENSE_PLANNED);
			swoBO.setCalcPrice(0.0);
			swoBOFactory.createSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
			if (swoDomainDTO.getEEDTOList() != null && swoDomainDTO.getEEDTOList().size() > 0) {
				for (int i = 0; i < swoDomainDTO.getEEDTOList().size(); i++) {
					EEBO eeBO = null;
					eeDomainDTO = (EEDomainDTO) swoDomainDTO.getEEDTOList().get(i);
					eeBO = eeBOFactory.getEEBO(eeDomainDTO.getProposalId(), eeDomainDTO.getCustomerId(), eeDomainDTO.getDmId(), eeDomainDTO.getSwoId(), eeDomainDTO.getEeId(), EEBOFactory.EE_TABLE);
					eeBO.setEeId(eeBOFactory.findMaxEEBO(EEBOFactory.EE_TABLE).getEeId() + 1);
					eeBO.setSwoId(swoBO.getSwoId());
					eeBO.setDmId(swoBO.getDmId());
					eeBO.setEswPrice(eeDomainDTO.getEswPrice());
					eeBO.setPlanStartDate(eeDomainDTO.getPlanStartDate());
					eeBO.setPlanEndDate(eeDomainDTO.getPlanEndDate());
					eeBO.setSequenceNo(swoBO.getSequenceNo());
					eeBOFactory.createEEBO(eeBO, EEBOFactory.EE_TABLE);
					if (eeDomainDTO.getPriceDTOList() != null && eeDomainDTO.getPriceDTOList().size() > 0) {
						for (int j = 0; j < eeDomainDTO.getPriceDTOList().size(); j++) {
							PriceBO priceBO = null;
							priceDomainDTO = (PriceDomainDTO) eeDomainDTO.getPriceDTOList().get(j);
							priceBO = new PriceBO();
							priceBO.setPriceId(priceBOFactory.findMaxPriceBO(PriceBOFactory.PRICE_TABLE).getPriceId() + 1);
							priceBO.setEeId(eeBO.getEeId());
							priceBO.setSwoId(eeBO.getSwoId());
							priceBO.setDmId(eeBO.getDmId());
							priceBO.setCustomerId(eeBO.getCustomerId());
							priceBO.setProposalId(eeBO.getProposalId());
							populatePriceBO(priceDomainDTO, priceBO);
							if (priceBO.getBillPlanStartDate() != null) {
								priceBO.setBillPlanStartDate(eeDomainDTO.getPlanStartDate());
							}
							if (priceBO.getBillPlanEndDate() != null) {
								priceBO.setBillPlanEndDate(eeDomainDTO.getPlanEndDate());
							}
							priceBOFactory.createPriceBO(priceBO, PriceBOFactory.PRICE_TABLE);

						}
					}
				}
			}

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}

	/**
	 * This method will be used by create variance proposal to update the eswPrice from price table to all ee's and 
	 * swo's 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 30, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalDomainDTO
	 * @throws ServiceException
	 */
	public void updateESWPriceForVarianceProposal(ProposalDomainDTO proposalDomainDTO) throws ServiceException {

		String methodName = "updateESWPriceForVarianceProposal";
		int proposalId = proposalDomainDTO.getProposalId();
		SWOBOFactory swoBOFactory = new SWOBOFactory();
		List swoBOList = null;
		try {
			swoBOList = swoBOFactory.findSWOBOForProposal(proposalId, SWOBOFactory.SWO_TABLE);
		} catch (DomainException e) {
			// TODO Auto-generated catch block
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
		}

		for (int i = 0; i < swoBOList.size(); i++) {

			SWOBO swoBO = (SWOBO) swoBOList.get(i);
			//we do not update SVC Licence
			if ("V".equals(swoBO.getItemCategory())) {
				continue;
			}
			BigDecimal swoESWPrice = PricingComponentHelper.convertToBigDecimal(0.0);
			EEBOFactory eeBOFactory = new EEBOFactory();
			List eeBOList = null;
			try {
				eeBOList = eeBOFactory.findEEBOForSWO(proposalId, swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_TABLE);
			} catch (DomainException e1) {
				// TODO Auto-generated catch block
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e1);
			}

			for (int k = 0; k < eeBOList.size(); k++) {
				EEBO eeBO = (EEBO) eeBOList.get(k);
				BigDecimal eeESWPrice = PricingComponentHelper.convertToBigDecimal(0.0);
				BigDecimal eswPrice = PricingComponentHelper.convertToBigDecimal(0.0);
				List priceDomainDTOList = new ArrayList();
				PriceBOFactory priceBOFactory = new PriceBOFactory();
				List priceBOList = null;
				try {
					priceBOList = priceBOFactory.findPriceBOForEE(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId(), PriceBOFactory.PRICE_TABLE);
				} catch (DomainException e2) {
					// TODO Auto-generated catch block
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e2);
				}
				for (int j = 0; j < priceBOList.size(); j++) {
					PriceBO priceBO = (PriceBO) priceBOList.get(j);
					if (0 == j) {
						eswPrice = PricingComponentHelper.convertToBigDecimal(priceBO.getEswPrice());
					}
				} // end of price loop
				eeESWPrice = eswPrice;
				eeBO.setEswPrice(eeESWPrice.doubleValue());
				try {
					eeBOFactory.updateEEBO(eeBO, EEBOFactory.EE_TABLE);
				} catch (DomainException e3) {
					throw ExceptionGenerator.generateServiceException(e3.getErrorReport());
				}
				String logMessageString = OPPTHelper.getLogString(String.valueOf(eeESWPrice));
				OPPTLogger.log("EE_ESW_PRICE", OPPTLogger.DEBUG, "SWOInfoBean", "updateESWPriceForVarianceProposal", logMessageString);
				swoESWPrice = swoESWPrice.add(eeESWPrice);
			} // end of eeLoop
			String logMessageString = OPPTHelper.getLogString(String.valueOf(swoESWPrice));
			OPPTLogger.log("SWO_ESW_PRICE", OPPTLogger.DEBUG, "SWOInfoBean", "updateESWPriceForVarianceProposal", logMessageString);
			swoBO.setEswPrice(swoESWPrice.doubleValue());
			try {
				swoBOFactory.updateSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
			} catch (DomainException e2) {
				throw ExceptionGenerator.generateServiceException(e2.getErrorReport());
			}

		} // end of SWO Loop
	}

	/**
	 *  
	 * This method removes the Configuration information from temp tables 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 25, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param tempEEDomainDTO
	 * @throws ServiceException
	 */
	public void removeConfigurationInfo(TempEEDomainDTO tempEEDomainDTO) throws ServiceException {
		TempEEBOFactory tempEEBOFactory = null;
		TempEEBO tempEEBO = null;
		String methodName = "removeConfigurationInfo";
		tempEEBOFactory = new TempEEBOFactory();
		try {
			tempEEBO = new TempEEBO();
			populateTempEEBOWithDomainDTO(tempEEBO, tempEEDomainDTO);
			tempEEBOFactory.deleteTempEEBO(tempEEBO);

		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		}
	}

	/**
	 *  
	 * This method stores the bumped license information (Back end data) 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * 
	 * @param SWODomainDTO
	 */
	private void storeBumpInfo(SWODomainDTO swoDomainDTO, SWOBO oldOrder) throws ServiceException {
		SWOBOFactory swoBOFactory = null;
		EEBOFactory eeBOFactory = null;
		PriceBOFactory priceBOFactory = null;
		List eeDomainDTOList = null;
		List priceDomainDTOList = null;
		EEDomainDTO eeDomainDTO = null;
		PriceDomainDTO priceDomainDTO = null;
		SWOBO swoBO = null;
		SWOBO maxSWOBO = null;
		swoBOFactory = new SWOBOFactory();
		eeBOFactory = new EEBOFactory();
		priceBOFactory = new PriceBOFactory();
		Iterator iterateEE = null;
		Iterator iteratePrice = null;
		String methodName = "storeBumpInfo";
		boolean deleteFlag = true;

		//TimeTaken log = new //TimeTaken(CLASS_NAME, methodName);
		try {
			maxSWOBO = swoBOFactory.findMaxSWOBO(SWOBOFactory.SWO_TABLE);
			swoDomainDTO.setSwoId(maxSWOBO.getSwoId() + 1);
			swoBO = populateSWOBO(swoDomainDTO, swoBO);
			swoBO.setSwoAddedDate(new Date(new java.util.Date().getTime()));
			swoBO.setExclusionId(UtilityConstants.NO);
			swoBO.setRefetchId(UtilityConstants.NO);
			if (!(swoDomainDTO.getSAndSInd() != null && swoDomainDTO.getSAndSInd().equals(LicenseConstants.SS_LICENSE_FLAG))) {
				swoBO.setBumpInd(LicenseConstants.LICENSE_BUMPED);
			}
			swoBO.setSwoId(maxSWOBO.getSwoId() + 1);
			//OPPTLogger.debug("SWO Info-- SWO Id :" + swoBO.getSwoId() + "DM Id:" + swoBO.getDmId() +"Customer Id:" + swoBO.getCustomerId() + "Proposal Id:" + swoBO.getProposalId()+"Equp No:"+swoBO.getEquipmentNo(), CLASS_NAME, methodName);
			swoBOFactory.createSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
			eeDomainDTOList = swoDomainDTO.getEEDTOList();
			if (eeDomainDTOList != null) {
				iterateEE = eeDomainDTOList.iterator();
				while (iterateEE.hasNext()) {
					EEBO eeBO = null;
					EEBO maxEEBO = null;
					eeDomainDTO = (EEDomainDTO) iterateEE.next();
					maxEEBO = eeBOFactory.findMaxEEBO(EEBOFactory.EE_TABLE);
					int maxeeId = maxEEBO.getEeId();
					int eeId = (maxeeId + 1);
					eeDomainDTO.setSwoId(swoBO.getSwoId());
					eeDomainDTO.setDmId(swoBO.getDmId());
					eeBO = populateEEBO(eeDomainDTO, eeBO);
					eeBO.setEeId(maxeeId + 1);
					//OPPTLogger.debug("EE Info--EE Id:" + eeBO.getEeId() + "SWO Id :" + eeBO.getSwoId() + "DMId:" + eeBO.getDmId() + "Customer Id:" + eeBO.getCustomerId() + "Proposal Id:" +eeBO.getProposalId() + "EE_Item No :" + eeBO.getEeItemNo() + "Sales doc no" +eeBO.getSalesDocNo(), CLASS_NAME, methodName);
					eeBOFactory.createEEBO(eeBO, EEBOFactory.EE_TABLE);
					priceDomainDTOList = eeDomainDTO.getPriceDTOList();
					if (priceDomainDTOList != null) {
						iteratePrice = priceDomainDTOList.iterator();
						while (iteratePrice.hasNext()) {
							PriceBO priceBO = null;
							PriceBO maxPriceBO = null;
							priceDomainDTO = (PriceDomainDTO) iteratePrice.next();
							maxPriceBO = priceBOFactory.findMaxPriceBO(PriceBOFactory.PRICE_TABLE);
							int maxPriceId = maxPriceBO.getPriceId();
							int priceId = (maxPriceId + 1);
							priceDomainDTO.setEeId(eeBO.getEeId());
							priceDomainDTO.setSwoId(eeBO.getSwoId());
							priceDomainDTO.setDmId(eeBO.getDmId());
							priceBO = populatePriceBO(priceDomainDTO, priceBO);
							priceBO.setPriceId(priceId);
							//OPPTLogger.debug("Price Info--Price Id:" + priceBO.getPriceId() + "EE Id:" +priceBO.getEeId() + "SWO Id :" + priceBO.getSwoId() + "DM Id:" + priceBO.getDmId() +"Customer Id:" + priceBO.getCustomerId() + "Proposal Id:" + priceBO.getProposalId() +"EE_Item No :" + priceBO.getEeItemNo() + "Sales doc no" + priceBO.getSalesDocNo(),CLASS_NAME, methodName);
							priceBOFactory.createPriceBO(priceBO, PriceBOFactory.PRICE_TABLE);
						}
					}
				}
			}
			if (oldOrder != null && !(swoDomainDTO.getSalesDocNo().equals(oldOrder.getSalesDocNo())) && (!(swoDomainDTO.getSAndSInd() != null && swoDomainDTO.getSAndSInd().equals(LicenseConstants.SS_LICENSE_FLAG)))) {
				List eeBOList = eeBOFactory.findEEBOForSWO(oldOrder.getProposalId(), oldOrder.getCustomerId(), oldOrder.getDmId(), oldOrder.getSwoId(), SWOBOFactory.SWO_TABLE);
				eeDomainDTOList = swoDomainDTO.getEEDTOList();
				if (eeDomainDTOList != null && eeDomainDTOList.size() > 0) {
					//for (int i = 0; i < eeDomainDTOList.size(); i++) {
					eeDomainDTO = (EEDomainDTO) eeDomainDTOList.get(0);
					//copy and store ee info
					copyStoreOldSWOInfo(eeBOList, eeDomainDTO, deleteFlag);

					//}
				}
				if (!(swoDomainDTO.getSAndSInd() != null && swoDomainDTO.getSAndSInd().equals(LicenseConstants.SS_LICENSE_FLAG))) {
					//OPPTLogger.debug("Old Bumped license is Deleting" + oldOrder.getSwoId()+"Equipment no:"+oldOrder.getEquipmentNo(), CLASS_NAME, methodName);
					if (deleteFlag) {
						swoBOFactory.deleteSWOBO(oldOrder, SWOBOFactory.SWO_TABLE);
					}
				}

			}
		} catch (DomainException d) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, d);
			throw ExceptionGenerator.generateServiceException(d.getErrorReport());
		} finally {
			//log.end();
		}

	}

	/**
	 *  
	 * When configuration is split across two ees this method is used. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 01/06/2004    Sara 	Added as part of MN19391947 - CMVCDEFECT 352 for checking the bump order only with Sales doc no.
		 * Previously comparison was with Sales doc no and item position number. Only the combination of sales doc no and item position number is unique always.  
	 * @param EEBOList ,EEDomainDTO
	 */
	private void copyStoreOldSWOInfo(List eeBOList, EEDomainDTO eeDomainDTO, boolean deleteFlag) throws DomainException {
		String methodName = "copyStoreOldSWOInfo";
		EEBO eeBO = null;
		EEBOFactory eeBOFactory = new EEBOFactory();
		PriceBOFactory priceBOFactory = new PriceBOFactory();
		PriceBO priceBO = null;
		List priceBOList = null;
		//TimeTaken log = new //TimeTaken(CLASS_NAME, methodName);

		for (int i = 0; i < eeBOList.size(); i++) {
			eeBO = (EEBO) eeBOList.get(i);
			if (!(eeBO.getSalesDocNo().equals(eeDomainDTO.getSalesDocNo()))) {
				EEBO maxEEBO = eeBOFactory.findMaxEEBO(EEBOFactory.EE_TABLE);
				int maxeeId = maxEEBO.getEeId();
				int eeId = (maxeeId + 1);
				priceBOList = priceBOFactory.findPriceBOForEE(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId(), EEBOFactory.EE_TABLE);
				eeBO.setEeId(eeId);
				eeBO.setSwoId(eeDomainDTO.getSwoId());
				eeBO.setDmId(eeDomainDTO.getDmId());
				OPPTLogger.debug("EE Info-copy store-EE Id:" + eeBO.getEeId() + "SWO Id :" + eeBO.getSwoId() + "DMId:" + eeBO.getDmId() + "Customer Id:" + eeBO.getCustomerId() + "Proposal Id:" + eeBO.getProposalId() + "EE_Item No :" + eeBO.getEeItemNo() + "Sales doc no" + eeBO.getSalesDocNo(), CLASS_NAME, methodName);
				eeBOFactory.createEEBO(eeBO, EEBOFactory.EE_TABLE);
				for (int j = 0; j < priceBOList.size(); j++) {
					priceBO = (PriceBO) priceBOList.get(j);
					PriceBO maxPriceBO = priceBOFactory.findMaxPriceBO(PriceBOFactory.PRICE_TABLE);
					int maxPriceId = maxPriceBO.getPriceId();
					int priceId = (maxPriceId + 1);
					priceBO.setPriceId(priceId);
					priceBO.setSwoId(eeBO.getSwoId());
					priceBO.setEeId(eeBO.getEeId());
					priceBO.setDmId(eeBO.getDmId());
					OPPTLogger.debug("Price Info-copy store-Price Id:" + priceBO.getPriceId() + "EE Id:" + priceBO.getEeId() + "SWO Id :" + priceBO.getSwoId() + "DM Id:" + priceBO.getDmId() + "Customer Id:" + priceBO.getCustomerId() + "Proposal Id:" + priceBO.getProposalId() + "EE_Item No :" + priceBO.getEeItemNo() + "Sales doc no" + priceBO.getSalesDocNo(), CLASS_NAME, methodName);
					priceBOFactory.createPriceBO(priceBO, PriceBOFactory.PRICE_TABLE);

				}
				deleteFlag = false;
			}
		}
		//log.end();
	}
	/**
	 *  
	 * When configuration is split across two ees this method is used. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * 
	 * @param EEBOList ,EEDomainDTO
	 */
	private void copyStoreOldSWOInfo(List eeBOList, EEDomainDTO eeDomainDTO) throws DomainException {
		String methodName = "copyStoreOldSWOInfo";
		EEBO eeBO = null;
		EEBOFactory eeBOFactory = new EEBOFactory();
		PriceBOFactory priceBOFactory = new PriceBOFactory();
		PriceBO priceBO = null;
		List priceBOList = null;

		for (int i = 0; i < eeBOList.size(); i++) {
			eeBO = (EEBO) eeBOList.get(i);
			if (!(eeBO.getSalesDocNo().equals(eeDomainDTO.getSalesDocNo())) && !(eeBO.getEeItemNo().equals(eeDomainDTO.getEeItemNo()))) {
				EEBO maxEEBO = eeBOFactory.findMaxEEBO(EEBOFactory.EE_TABLE);
				int maxeeId = maxEEBO.getEeId();
				int eeId = (maxeeId + 1);
				priceBOList = priceBOFactory.findPriceBOForEE(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId(), EEBOFactory.EE_TABLE);
				eeBO.setEeId(eeId);
				eeBO.setSwoId(eeDomainDTO.getSwoId());
				eeBO.setDmId(eeDomainDTO.getDmId());
				OPPTLogger.debug("EE Info--EE Id:" + eeBO.getEeId() + "SWO Id :" + eeBO.getSwoId() + "DMId:" + eeBO.getDmId() + "Customer Id:" + eeBO.getCustomerId() + "Proposal Id:" + eeBO.getProposalId() + "EE_Item No :" + eeBO.getEeItemNo() + "Sales doc no" + eeBO.getSalesDocNo(), CLASS_NAME, methodName);
				eeBOFactory.createEEBO(eeBO, EEBOFactory.EE_TABLE);
				for (int j = 0; j < priceBOList.size(); j++) {
					priceBO = (PriceBO) priceBOList.get(j);
					PriceBO maxPriceBO = priceBOFactory.findMaxPriceBO(PriceBOFactory.PRICE_TABLE);
					int maxPriceId = maxPriceBO.getPriceId();
					int priceId = (maxPriceId + 1);
					priceBO.setPriceId(priceId);
					priceBO.setSwoId(eeBO.getSwoId());
					priceBO.setEeId(eeBO.getEeId());
					priceBO.setDmId(eeBO.getDmId());
					OPPTLogger.debug("Price Info--Price Id:" + priceBO.getPriceId() + "EE Id:" + priceBO.getEeId() + "SWO Id :" + priceBO.getSwoId() + "DM Id:" + priceBO.getDmId() + "Customer Id:" + priceBO.getCustomerId() + "Proposal Id:" + priceBO.getProposalId() + "EE_Item No :" + priceBO.getEeItemNo() + "Sales doc no" + priceBO.getSalesDocNo(), CLASS_NAME, methodName);
					priceBOFactory.createPriceBO(priceBO, PriceBOFactory.PRICE_TABLE);

				}

			}
		}

	}

	/**
	 *  
	 * This method populate the TempEEBO with TempEEDomainDTO values 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param tempEEBO
	 * @param tempEEDomainDTO
	 */
	private void populateTempEEBOWithDomainDTO(TempEEBO tempEEBO, TempEEDomainDTO tempEEDomainDTO) {

		tempEEBO.setSessionId(tempEEDomainDTO.getSessionId());
		tempEEBO.setProposalId(tempEEDomainDTO.getProposalId());
		tempEEBO.setCustomerId(tempEEDomainDTO.getCustomerId());
		tempEEBO.setDmId(tempEEDomainDTO.getDmId());
		tempEEBO.setSwoId(tempEEDomainDTO.getSwoId());
		tempEEBO.setEeId(tempEEDomainDTO.getEeId());
		tempEEBO.setChargeOptionDesc(tempEEDomainDTO.getChargeOptionDesc());
		tempEEBO.setCho(tempEEDomainDTO.getCho());
		tempEEBO.setDefaultFlag(tempEEDomainDTO.getDefaultFlag());
		tempEEBO.setEeItemNo(tempEEDomainDTO.getEeItemNo());
		tempEEBO.setEeNo(tempEEDomainDTO.getEeNo());
		tempEEBO.setLcs(tempEEDomainDTO.getLcs());
		tempEEBO.setLicenseType(tempEEDomainDTO.getLicenseType());
		tempEEBO.setSalesDocNo(tempEEDomainDTO.getSalesDocNo());
		tempEEBO.setSwoItemNo(tempEEDomainDTO.getSwoItemNo());
		tempEEBO.setUl(tempEEDomainDTO.getUl());
		tempEEBO.setUseLevel(tempEEDomainDTO.getUseLevel());
		tempEEBO.setValidInd(tempEEDomainDTO.getValidInd());
		tempEEBO.setValueMetric(tempEEDomainDTO.getValueMetric());
		tempEEBO.setValueMetricType(tempEEDomainDTO.getValueMetricType());
		tempEEBO.setVm(tempEEDomainDTO.getVm());

	}
	/** 
	 * Removes the Quotes of a proposal
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 14, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposal
	 * @throws ServiceException
	 * @author Saravanan Viswanathan 
	 */
	public boolean removeQuotes(ProposalDomainDTO proposal) throws ServiceException {
		SWOBOFactory swoBOFactory = null;
		boolean returnvalue = false;
		swoBOFactory = new SWOBOFactory();
		if (proposal != null) {
			try {
				returnvalue = swoBOFactory.removeQuotes(proposal.getProposalId(), SWOBOFactory.SWO_TABLE);
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}
		} else {
			OPPTLogger.log(ErrorCodeConstants.APP_INSUFFICIENT_INPUT, OPPTLogger.ERROR, "SWOInfoBean", "removeQuotes", null);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return returnvalue;
	}

	/** 
	 * Fetch the S&S license details of a proposal
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param dmDomainDTOArray
	 * @param swoDomainDTOArray
	 * @throws ServiceException
	 * @author Saravanan Viswanathan 
	 */
	public List fetchSAndSDetails(DMDomainDTO[] dmDomainDTOArray, SWODomainDTO[] swoDomainDTOArray) throws ServiceException {
		SWOBOFactory swoBOFactory = new SWOBOFactory();
		List swoDomainDTOList = new ArrayList();
		List eeDomainDTOList = new ArrayList();
		List swoBOList = new ArrayList();
		SWODomainDTO swoDomainDTO = null;
		SWOBO swoBO = new SWOBO();
		boolean ssFlag = false;
		boolean eeFlag = false;

		/* Start of DMDomainDTO validation */
		if (dmDomainDTOArray != null) {
			try {
				for (int x = 0; x < dmDomainDTOArray.length; x++) {
					swoBOList = swoBOFactory.findSWOBOForDM(dmDomainDTOArray[x].getDmId(), dmDomainDTOArray[x].getCustomerId(), dmDomainDTOArray[x].getProposalId(), SWOBOFactory.SWO_TABLE);
					if (swoBOList != null) {
						for (int i = 0; i < swoBOList.size(); i++) {
							swoBO = (SWOBO) swoBOList.get(i);
							if (swoBO.validateForSAndS()) {
								ssFlag = true;
								swoDomainDTO = new SWODomainDTO(swoBO);
								eeDomainDTOList = validateSWOAndEEForSAndS(swoDomainDTO);

								if (eeDomainDTOList.size() > 0) {
									eeFlag = true;
									//Setting SWO DTO with only Valid EE DTO list
									swoDomainDTO.setEEDTOList(eeDomainDTOList);
									//Copy the valid S&S SWO to the SWODomainDTO array.
									swoDomainDTOList.add(swoDomainDTO);
								}
							}
						}
					}
				}
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}
		}
		/* End of DMDomainDTO validation */

		/* Start of SWODomainDTO validation */
		if (swoDomainDTOArray != null) {
			try {
				for (int y = 0; y < swoDomainDTOArray.length; y++) {
					swoBO = swoBOFactory.getSWOBO(swoDomainDTOArray[y].getProposalId(), swoDomainDTOArray[y].getCustomerId(), swoDomainDTOArray[y].getDmId(), swoDomainDTOArray[y].getSwoId(), SWOBOFactory.SWO_TABLE);
					if (swoBO.validateForSAndS()) {
						ssFlag = true;
						swoDomainDTO = new SWODomainDTO(swoBO);
						eeDomainDTOList = validateSWOAndEEForSAndS(swoDomainDTO);

						if (eeDomainDTOList.size() > 0) {
							eeFlag = true;
							//Setting SWO DTO with only Valid EE DTO list
							swoDomainDTO.setEEDTOList(eeDomainDTOList);
							//Copy the valid S&S SWO to the SWODomainDTO array.
							swoDomainDTOList.add(swoDomainDTO);
						}
					}
				}
			} catch (DomainException e) {
				throw ExceptionGenerator.generateServiceException(e.getErrorReport());
			}
		}
		/* End of SWODomainDTO validation */

		if (!ssFlag) {
			// Here there are no SWO's which are of type S&S. So throw corresponding message
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0700);
		}
		if (!eeFlag) {
			// Here all the EE's in the selected DM's or SWO's are of 'No charge' charge option. So throw corresponding message
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0701);
		}

		return swoDomainDTOList;
	}

	/**
	 *  
	 * This method is to validate the EE's for S&S planning process. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoDomainDTO
	 * @throws ServiceException
	 * @author Saravanan Viswanathan
	 */
	private List validateSWOAndEEForSAndS(SWODomainDTO swoDomainDTO) throws ServiceException {
		EEBOFactory eeBOFactory = new EEBOFactory();
		EEDomainDTO eeDomainDTO = null;
		EEBO eeBO = null;
		List eeBOList = null;
		List eeDomainDTOList = new ArrayList();

		try {
			//Call findEEBOForSWO to get list of EEBO's
			eeBOList = eeBOFactory.findEEBOForSWO(swoDomainDTO.getProposalId(), swoDomainDTO.getCustomerId(), swoDomainDTO.getDmId(), swoDomainDTO.getSwoId(), EEBOFactory.EE_TABLE);
			if (eeBOList != null) {
				for (int j = 0, eesize = eeBOList.size(); j < eesize; j++) {
					eeBO = (EEBO) eeBOList.get(j);
					//If charge option of the EE is not 'No Charge', then EE is valid for S&S planning
					if (!eeBO.isNoChargeOption()) {
						eeDomainDTO = new EEDomainDTO(eeBO);
						// Add EEDomainDTO to the List
						eeDomainDTOList.add(eeDomainDTO);
					}
				}
			}
		} catch (DomainException ex) {
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		}

		return eeDomainDTOList;
	}
	/**
	 *  
	 * This method is to apply the S&S discount percent to all selected EE's 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 21, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eeDomainDTOArray
	 * @param sAndSDiscount
	 * @author Saravanan Viswanathan
	 */
	public void applySAndSDiscount(EEDomainDTO[] eeDomainDTOArray, double sAndSDiscount) throws ServiceException {
		EEBOFactory eeBOFactory = new EEBOFactory();
		SWOBOFactory swoBOFactory = new SWOBOFactory();

		try {
			for (int x = 0; x < eeDomainDTOArray.length; x++) {
				EEBO eeBO = eeBOFactory.getEEBO(eeDomainDTOArray[x].getProposalId(), eeDomainDTOArray[x].getCustomerId(), eeDomainDTOArray[x].getDmId(), eeDomainDTOArray[x].getSwoId(), eeDomainDTOArray[x].getEeId(), EEBOFactory.EE_TABLE);
				eeBO.setSAndSDiscountPercent(sAndSDiscount);
				eeBO.setCalculatedPrice(0);
				eeBOFactory.updateEEBO(eeBO, EEBOFactory.EE_TABLE);
				SWOBO swoBO = swoBOFactory.getSWOBO(eeDomainDTOArray[x].getProposalId(), eeDomainDTOArray[x].getCustomerId(), eeDomainDTOArray[x].getDmId(), eeDomainDTOArray[x].getSwoId(), SWOBOFactory.SWO_TABLE);
				if (swoBO.getCalcPrice() != 0) {
					swoBO.setCalcPrice(0);
					swoBOFactory.updateSWOBO(swoBO, SWOBOFactory.SWO_TABLE);
				}
			}
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}
	}

	public DMDomainDTO retrieveSWOForCopyInventory(DMDomainDTO dmDomainDTO) throws ServiceException {

		String methodName = "retrieveSWOForCopyInventory";
		SWOBOFactory swoBOFactory = new SWOBOFactory();
		List swoBOList = null;
		List swoDomainDTOList = new ArrayList();
		String actionName = dmDomainDTO.getActionName();
		try {
			if (ActionNameConstants.CREATE_VARIANCEPROPOSAL.equals(actionName)) {
				swoBOList = swoBOFactory.findSWOBOForDM(dmDomainDTO.getDmId(), dmDomainDTO.getCustomerId(), dmDomainDTO.getProposalId(), SWOBOFactory.VARIANCE_SWO_TABLE);
			} else {
				swoBOList = swoBOFactory.findSWOBOForDM(dmDomainDTO.getDmId(), dmDomainDTO.getCustomerId(), dmDomainDTO.getProposalId(), SWOBOFactory.SWO_TABLE);
			}
		} catch (DomainException e) {
			// TODO Auto-generated catch block
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
		}

		for (int i = 0; i < swoBOList.size(); i++) {
			SWOBO swoBO = (SWOBO) swoBOList.get(i);
			SWODomainDTO swoDomainDTO = new SWODomainDTO(swoBO);
			swoDomainDTO.setActionName(dmDomainDTO.getActionName());

			if (ActionNameConstants.REPLACE_CONTRACT.equalsIgnoreCase(actionName) || ActionNameConstants.CREATE_VARIANCEPROPOSAL.equalsIgnoreCase(actionName)) {
				swoDomainDTO.setPlanStartDate(dmDomainDTO.getPlanStartDate());
				swoDomainDTO.setPlanStartDate(dmDomainDTO.getPlanStartDate());
			} else if (ActionNameConstants.COPY_PROPOSAL.equalsIgnoreCase(actionName)) {
				swoDomainDTO.setLockedInd(LicenseConstants.LICENSE_UNLOCKED);
			}
			EEBOFactory eeBOFactory = new EEBOFactory();
			List eeDomainDTOList = new ArrayList();
			List eeBOList = null;
			try {
				if (ActionNameConstants.CREATE_VARIANCEPROPOSAL.equals(actionName)) {
					eeBOList = eeBOFactory.findEEBOForSWO(swoBO.getProposalId(), swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_VARIANCE_TABLE);
				} else {
					eeBOList = eeBOFactory.findEEBOForSWO(swoBO.getProposalId(), swoBO.getCustomerId(), swoBO.getDmId(), swoBO.getSwoId(), EEBOFactory.EE_TABLE);
				}
			} catch (DomainException e1) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e1);
			}

			for (int k = 0; k < eeBOList.size(); k++) {
				EEBO eeBO = (EEBO) eeBOList.get(k);
				EEDomainDTO eeDomainDTO = new EEDomainDTO(eeBO);
				List priceDomainDTOList = new ArrayList();
				PriceBOFactory priceBOFactory = new PriceBOFactory();
				List priceBOList = null;
				try {
					if (ActionNameConstants.CREATE_VARIANCEPROPOSAL.equals(actionName)) {
						priceBOList = priceBOFactory.findPriceBOForEE(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId(), PriceBOFactory.VARIANCE_PRICE_TABLE);
					} else {
						priceBOList = priceBOFactory.findPriceBOForEE(eeBO.getEeId(), eeBO.getSwoId(), eeBO.getDmId(), eeBO.getCustomerId(), eeBO.getProposalId(), PriceBOFactory.PRICE_TABLE);
					}
				} catch (DomainException e2) {
					// TODO Auto-generated catch block
					OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e2);
				}
				for (int j = 0; j < priceBOList.size(); j++) {
					PriceBO priceBO = (PriceBO) priceBOList.get(j);
					PriceDomainDTO priceDomainDTO = new PriceDomainDTO(priceBO);
					priceDomainDTOList.add(priceDomainDTO);
				} // end of price loop
				eeDomainDTO.setPriceDTOList(priceDomainDTOList);
				eeDomainDTOList.add(eeDomainDTO);
			} // end of eeLoop
			swoDomainDTO.setEEDTOList(eeDomainDTOList);
			swoDomainDTOList.add(swoDomainDTO);
		} // end of SWO Loop

		dmDomainDTO.setSwoDTOList(swoDomainDTOList);
		return dmDomainDTO;
	}

	/**
	 * getSessionContext
	*/
	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}
	/**
	 * setSessionContext
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		mySessionCtx = ctx;
	}
	/**
	 * ejbCreate
	 */
	public void ejbCreate() throws javax.ejb.CreateException {
	}
	/**
	 * ejbActivate
	 */
	public void ejbActivate() {
	}
	/**
	 * ejbPassivate
	 */
	public void ejbPassivate() {
	}
	/**
	 * ejbRemove
	 */
	public void ejbRemove() {
	}
}
