/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.reportmgr;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ejb.CreateException;

import com.ibm.isc.customerfulfillment.bhoppt.connector.JMSConnectorLocal;
import com.ibm.isc.customerfulfillment.bhoppt.connector.UserProfileConnector;
import com.ibm.isc.customerfulfillment.bhoppt.connector.UserProfileConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.UserProfilesConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.GenericConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveSalesOrgAuthInputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.RetrieveSalesOrgAuthOutputConnectorDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.SalesOrgAccessDTO;
import com.ibm.isc.customerfulfillment.bhoppt.connector.util.ConnectorConstants;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.ReportsDomainDTO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ProposalContractBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ProposalContractBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ProposalContractDTOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.domain.report.factory.ReportDTOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.UserDAO;
import com.ibm.isc.customerfulfillment.bhoppt.report.factory.BaseAgreementReportDTOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.service.pcm.ProposalManagerLocal;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTPropertiesReader;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.TimeTaken;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;

/**
 * Bean implementation class for Enterprise Bean: ReportManager
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 6, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Kedar 
 * @version 5.1A
 */
public class ReportManagerBean implements javax.ejb.SessionBean {
	private static final String CLASS_NAME = "ReportManagerBean";

	private javax.ejb.SessionContext mySessionCtx;
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

	/**
	 *  Method to get the Variance(ALL) report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param VarianceRptCustomDTO
	 * @return VarianceRptCustomDTO
	 * @throws ServiceException	  
	 */
	public VarianceRptCustomDTO getVarianceAllRpt(VarianceRptCustomDTO varianceRptCustomDTO) throws ServiceException {
		String methodName = "getVarianceAllRpt";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "getVarianceAllRpt");
		try {
			ReportDTOFactory reportDTOFactory = new ReportDTOFactory();
			ProposalManagerLocal proposalManagerLocal = null;
			ErrorReport errorReport;
			try {
				proposalManagerLocal = HomeProvider.getProposalManagerLocal();
			} catch (CreateException ex) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			}
			ProposalContractBO proposalContractBO = new ProposalContractBO();
			proposalContractBO = proposalManagerLocal.getProposal(varianceRptCustomDTO.getProposalDTO().getId());
			ContractBO contractBO = new ContractBO();
			try {
				if (!proposalContractBO.getProposalType().equals("ES")) {
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0702);
				} else if (proposalContractBO instanceof ContractBO) {
					contractBO = (ContractBO) proposalContractBO;
					if (!contractBO.isContractForVariance()) {
						throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0702);
					}
					if (!contractBO.isVarianceCheckDone()) {
						throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0703);
					}
					if (!contractBO.isVarianceCheckDoneForContract()) {
						throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0704);
					}
				} else {
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0703);
				}
			} catch (DomainException ex) {
				throw new ServiceException();
			}

			/*	Data doesnt exist in temp tables	*/

			if (!(contractBO.getVarInd().equals("C") && contractBO.getCapVariance() > 0)) {
				//VarianceReportDomainDTO varianceReportDomainDTO = new VarianceReportDomainDTO();
				//varianceReportDomainDTO.setContractBO(contractBO);
				//proposalManagerLocal.checkVarianceForReport(varianceReportDomainDTO);
				proposalManagerLocal.checkVarianceForReport(varianceRptCustomDTO);

			}

			VarianceRptDomainDTO varianceRptDomainDTO = new VarianceRptDomainDTO();
			String proposalID = String.valueOf(varianceRptCustomDTO.getProposalDTO().getId());
			try {
				varianceRptDomainDTO = reportDTOFactory.getVarianceAllRpt(proposalID);
			} catch (DomainException ex) {
				throw new ServiceException();
			}
			varianceRptCustomDTO.setReportDTO(varianceRptDomainDTO);

			return varianceRptCustomDTO;
		} catch (ServiceException ex) {
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *  Method to get the Variance(Price) report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param VarianceRptCustomDTO
	 * @return VarianceRptCustomDTO
	 * @throws ServiceException  
	 */
	public VarianceRptCustomDTO getVariancePriceRpt(VarianceRptCustomDTO varianceRptCustomDTO) throws ServiceException {
		String methodName = "getVariancePriceRpt";
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "getVariancePriceRpt");
		try {
			ReportDTOFactory reportDTOFactory = new ReportDTOFactory();
			ProposalManagerLocal proposalManagerLocal = null;
			ErrorReport errorReport;

			try {
				proposalManagerLocal = HomeProvider.getProposalManagerLocal();
			} catch (CreateException ex) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			}
			ProposalContractBO proposalContractBO = new ContractBO();
			proposalContractBO = proposalManagerLocal.getProposal(varianceRptCustomDTO.getProposalDTO().getId());
			ContractBO contractBO = new ContractBO();

			try {
				if (!proposalContractBO.getProposalType().equals("ES")) {
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0702);
				} else if (proposalContractBO instanceof ContractBO) {
					contractBO = (ContractBO) proposalContractBO;
					if (!contractBO.isContractForVariance()) {
						throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0702);
					}
					if (!contractBO.isVarianceCheckDone()) {
						throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0703);
					}
					if (!contractBO.isVarianceCheckDoneForContract()) {
						throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0704);
					}
				} else {
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0703);
				}
			} catch (DomainException ex) {
				throw new ServiceException();
			}

			/*	Data doesnt exist in temp tables	*/

			if (!(contractBO.getVarInd().equals("C") && contractBO.getCapVariance() > 0)) {
				proposalManagerLocal.checkVarianceForReport(varianceRptCustomDTO);
			}

			VarianceRptDomainDTO varianceRptDomainDTO = new VarianceRptDomainDTO();
			String proposalID = String.valueOf(varianceRptCustomDTO.getProposalDTO().getId());

			try {
				varianceRptDomainDTO = reportDTOFactory.getVariancePriceRpt(proposalID);
			} catch (DomainException ex) {
				throw new ServiceException();
			}
			varianceRptCustomDTO.setReportDTO(varianceRptDomainDTO);
			return varianceRptCustomDTO;
		} catch (ServiceException ex) {
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		} finally {
			timeTaken.end();
		}

	}

	/**
	 *  Method to get the reports in report selection 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param ReportsCustomDTO
	 * @return ReportsCustomDTO
	 * @throws ServiceException	  
	 */

	public ReportsCustomDTO listProposals(ReportsCustomDTO reportsCustomDTO) throws ServiceException {
		String methodName = "listProposals";

		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, methodName);
		try {
			ProposalManagerLocal proposalManagerLocal = null;
			ReportsDomainDTO reportsDomainDTO = new ReportsDomainDTO();
			try {
				proposalManagerLocal = HomeProvider.getProposalManagerLocal();
			} catch (CreateException ex) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
			}

			reportsDomainDTO = proposalManagerLocal.listProposalsForReport(reportsCustomDTO.getUserId(), reportsCustomDTO.getGroupName(), reportsCustomDTO.getRole());

			TreeMap proposalCustomDTO = reportsDomainDTO.getProposalCustomDTO();
			if (proposalCustomDTO == null || proposalCustomDTO.size() == 0) {
				ErrorReport report = ExceptionGenerator.addErrorEntry(null, ErrorCodeConstants.SE0026, OPPTMessageCatalog.TYPE_SERVICE);
				reportsCustomDTO.setMessageReport(report);
			}

			reportsCustomDTO.setProposalCustomDTO(proposalCustomDTO);

			return reportsCustomDTO;
		} catch (ServiceException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ex);
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *  Method to get the Contract Attachment Final report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param ContractAttachmentReportCustomDTO
	 * @return ContractAttachmentReportCustomDTO
	 * @throws ServiceException	  
	 */

	public ContractAttachmentReportCustomDTO getContractAttachRpt(ContractAttachmentReportCustomDTO contractAttachmentReportCustomDTO) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "getContractAttachRpt");
		try {
			ReportDTOFactory reportDTOFactory = new ReportDTOFactory();
			ContractAttchRptDomainDTO contractAttchRptDomainDTO = new ContractAttchRptDomainDTO();
			String proposalID = String.valueOf(contractAttachmentReportCustomDTO.getProposalDTO().getId());
			try {
				contractAttchRptDomainDTO = reportDTOFactory.getContractAttachRpt(proposalID);
			} catch (DomainException ex) {
				throw new ServiceException();
			}
			contractAttachmentReportCustomDTO.setReportDTO(contractAttchRptDomainDTO);
			return contractAttachmentReportCustomDTO;
		} catch (ServiceException ex) {
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		} finally {
			timeTaken.end();
		}

	}

	/**
	 *  Method to get the Contract Planning report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param ContractAttachmentReportCustomDTO
	 * @return ContractAttachmentReportCustomDTO
	 * @throws ServiceException	  
	 */
	public ContractPlanningReportCustomDTO getContractPlanningRpt(ContractPlanningReportCustomDTO contractPlanningReportCustomDTO) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "getContractPlanningRpt");
		try {
			ReportDTOFactory reportDTOFactory = new ReportDTOFactory();
			ContractPlanningRptDomainDTO contractPlanningRptDomainDTO = new ContractPlanningRptDomainDTO();
			String proposalID = String.valueOf(contractPlanningReportCustomDTO.getProposalDTO().getId());
			try {
				contractPlanningRptDomainDTO = reportDTOFactory.getContractPlanningRpt(proposalID);
			} catch (DomainException ex) {
				throw new ServiceException();
			}
			contractPlanningReportCustomDTO.setReportDTO(contractPlanningRptDomainDTO);
			return contractPlanningReportCustomDTO;
		} catch (ServiceException ex) {
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		} finally {
			timeTaken.end();
		}
	}
	/**
	 *  Method to get the Contract Amendment report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param  ContractAmendmentReportCustomDTO
	 * @return ContractAmendmentReportCustomDTO
	 * @throws ServiceException	  
	 */
	public ContractAmendmentReportCustomDTO getContractAmdRpt(ContractAmendmentReportCustomDTO contractAmendmentReportCustomDTO) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "getContractAmdRpt");
		try {
			ReportDTOFactory reportDTOFactory = new ReportDTOFactory();
			ContractAmendmentRptDomainDTO contractAmendmentRptDomainDTO = new ContractAmendmentRptDomainDTO();
			String proposalID = String.valueOf(contractAmendmentReportCustomDTO.getProposalDTO().getId());

			try {

				if (!contractAmendmentReportCustomDTO.getProposalDTO().getStatus().equals("AP")) {
					throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0705);
				}
				contractAmendmentRptDomainDTO = reportDTOFactory.getContractAmdRpt(proposalID);
			} catch (DomainException ex) {
				throw new ServiceException();
			}

			contractAmendmentReportCustomDTO.setReportDTO(contractAmendmentRptDomainDTO);
			return contractAmendmentReportCustomDTO;
		} catch (ServiceException ex) {
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		} finally {
			timeTaken.end();
		}

	}

	/**
	 *  Method to get the Deleted SWO report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param DeletedSWOReportCustomDTO
	 * @return DeletedSWOReportCustomDTO
	 * @throws ServiceException	  
	 */
	public DeletedSWOReportCustomDTO getDeletedSWORpt(DeletedSWOReportCustomDTO deletedSWOReportCustomDTO) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "getDeletedSWORpt");
		try {
			ReportDTOFactory reportDTOFactory = new ReportDTOFactory();
			DeletedSWORptDomainDTO deletedSWORptDomainDTO = new DeletedSWORptDomainDTO();
			String proposalID = String.valueOf(deletedSWOReportCustomDTO.getProposalDTO().getId());
			try {
				deletedSWORptDomainDTO = reportDTOFactory.getDeletedSWORpt(proposalID);
			} catch (DomainException ex) {
				throw new ServiceException();
			}
			deletedSWOReportCustomDTO.setReportDTO(deletedSWORptDomainDTO);
			return deletedSWOReportCustomDTO;
		} catch (ServiceException ex) {
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *  Method to get the List Entitled  report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param ListEntitledPricesReportCustomDTO
	 * @return ListEntitledPricesReportCustomDTO
	 * @throws ServiceException	  
	 */
	public ListEntitledPricesReportCustomDTO getListEntitledRpt(ListEntitledPricesReportCustomDTO listEntitledPricesReportCustomDTO) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "getListEntitledRpt");
		try {
			ReportDTOFactory reportDTOFactory = new ReportDTOFactory();
			ListEntitledPricesRptDomainDTO listEntitledPricesRptDomainDTO = new ListEntitledPricesRptDomainDTO();
			String proposalID = String.valueOf(listEntitledPricesReportCustomDTO.getProposalDTO().getId());
			try {
				listEntitledPricesRptDomainDTO = reportDTOFactory.getListEntitledRpt(proposalID);
			} catch (DomainException ex) {
				throw new ServiceException();
			}
			listEntitledPricesReportCustomDTO.setReportDTO(listEntitledPricesRptDomainDTO);
			return listEntitledPricesReportCustomDTO;
		} catch (ServiceException ex) {
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		} finally {
			timeTaken.end();
		}
	}

	/**
	 *  Method to get the Inventory List  report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param InventoryListReportCustomDTO
	 * @return InventoryListReportCustomDTO
	 * @throws ServiceException	  
	 */
	public InventoryListReportCustomDTO getInventoryListRpt(InventoryListReportCustomDTO inventoryListReportCustomDTO) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "getInventoryListRpt");
		try {
			ReportDTOFactory reportDTOFactory = new ReportDTOFactory();
			InventoryListRptDomainDTO inventoryListRptDomainDTO = new InventoryListRptDomainDTO();
			String proposalID = String.valueOf(inventoryListReportCustomDTO.getProposalDTO().getId());
			try {
				inventoryListRptDomainDTO = reportDTOFactory.getInventoryListRpt(proposalID);
			} catch (DomainException ex) {
				throw new ServiceException();
			}
			inventoryListReportCustomDTO.setReportDTO(inventoryListRptDomainDTO);
			return inventoryListReportCustomDTO;
		} catch (ServiceException ex) {
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		} finally {
			timeTaken.end();
		}

	}

	/**
	 *  Method to get the Sysplex report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param SysplexReportCustomDTO
	 * @return SysplexReportCustomDTO
	 * @throws ServiceException	  
	 */
	public SysplexReportCustomDTO getSysplexRpt(SysplexReportCustomDTO sysplexReportCustomDTO) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "getSysplexRpt");
		try {
			ReportDTOFactory reportDTOFactory = new ReportDTOFactory();
			SysplexRptDomainDTO sysplexRptDomainDTO = new SysplexRptDomainDTO();
			String proposalID = String.valueOf(sysplexReportCustomDTO.getProposalDTO().getId());
			try {
				sysplexRptDomainDTO = reportDTOFactory.getSysPlexRpt(proposalID);
			} catch (DomainException ex) {
				throw new ServiceException();
			}
			sysplexReportCustomDTO.setReportDTO(sysplexRptDomainDTO);
			return sysplexReportCustomDTO;
		} catch (ServiceException ex) {
			throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
		} finally {
			timeTaken.end();
		}

	}
	/**
	 *  
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param compareTPReportCustomDTO
	 * @return
	 * @throws ServiceException
	 */
	public CompareTPReportCustomDTO getCompareTPRpt(CompareTPReportCustomDTO compareTPReportCustomDTO) throws ServiceException {
		//		if (compareTPReportCustomDTO == null)
		//		{
		//			compareTPReportCustomDTO = new CompareTPReportCustomDTO();
		//			compareTPReportCustomDTO.setCompareTPRptDomainDTO(new CompareTPRptDomainDTO());
		//			compareTPReportCustomDTO.setContractCustomDTO(new ContractCustomDTO());
		//			compareTPReportCustomDTO.getContractCustomDTO().setId(415);
		//		}

		CompareTPRptDomainDTO compareTPRptDomainDTO = compareTPReportCustomDTO.getCompareTPRptDomainDTO();
		ContractCustomDTO contractCustomDTO = compareTPReportCustomDTO.getContractCustomDTO();

		try {
			ProposalContractBOFactory factory = new ProposalContractBOFactory();
			ProposalContractBO proposalContractBO = factory.getProposalContractBO(contractCustomDTO.getId());

			HashMap map = new HashMap();
			map.put(UtilityConstants.BO_USERID, compareTPReportCustomDTO.getUserId());
			map.put(UtilityConstants.CONTRACT_TYPE, proposalContractBO.getContrType());

			proposalContractBO.validateCompareTP(UtilityConstants.BUSINESSRULE_PRE_COND_TYPE, map);
			String contractNo = proposalContractBO.getContrNo();
			String oldContractNo = proposalContractBO.getOldContrNo();

			ProposalContractBO oldProposalContractBO = factory.getProposalContractBOForContractNumber(contractNo, true);

			int oldProposalID = oldProposalContractBO.getProposalId();

			ReportDTOFactory reportFactory = new ReportDTOFactory();
			compareTPReportCustomDTO = reportFactory.getCompareTPRpt(proposalContractBO.getProposalId(), oldProposalID, contractNo, oldContractNo, compareTPReportCustomDTO);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}

		return compareTPReportCustomDTO;
	}

	/**
	 *  
	 * checkForDownload
	 * checkForDownload
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposal
	 * @return boolean
	 * @throws ServiceException
	 */
	public boolean checkForDownload(ProposalCustomDTO proposal) throws ServiceException {
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "printProposal");
		try {
			ProposalContractDTOFactory factory = new ProposalContractDTOFactory();

			int swoCount = factory.getSWOCount(proposal.getId());
			int maxSWOForView = OPPTPropertiesReader.getMaxSWOForViewProposal();
			String[] messageInputs = { String.valueOf(maxSWOForView)};
			if (swoCount > maxSWOForView) {
				ErrorReport errReport = new ErrorReport();
				errReport = ExceptionGenerator.addErrorEntry(errReport, messageInputs, ErrorCodeConstants.SE0019, OPPTMessageCatalog.TYPE_SERVICE);
				throw ExceptionGenerator.generateServiceException(errReport);
			}

		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, "printProposal", null, e);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		} finally {
			timeTaken.end();
		}
		return true;
	}
	
	/**
	 *  
	 * getReverificationReport
	 * getReverificationReport
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param customDTO
	 * @return ReverificationReportCustomDTO
	 * @throws ServiceException
	 */

	public ReverificationReportCustomDTO getReverificationReport(ReverificationReportCustomDTO customDTO) throws ServiceException{
		String methodName = "getReverificationReport";
		TimeTaken log = new TimeTaken(CLASS_NAME,methodName);
		JMSConnectorLocal jmsConnectorLocal = null;
		ReverificationReportDomainDTO domainDTO = null;
		customDTO.setReportPrintedDate(new Date());
		
		RetrieveSalesOrgAuthInputConnectorDTO inputConnectorDTO = new RetrieveSalesOrgAuthInputConnectorDTO();
		GenericConnectorDTO genericConnectorDTO = new GenericConnectorDTO();
		genericConnectorDTO.setFunctionModuleName(ConnectorConstants.RFC_RETRIEVE_SORG_AUTH_OPPT);
		genericConnectorDTO.setSessionID(customDTO.getSessionId());
		genericConnectorDTO.setUserID(customDTO.getUserId());
		inputConnectorDTO.setGenericConnectorDTO(genericConnectorDTO);
		inputConnectorDTO.setSalesOrg(customDTO.getSalesOrg());
		
		try {
			jmsConnectorLocal = HomeProvider.getJMSConnectorLocal();
		} catch (CreateException e) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

		RetrieveSalesOrgAuthOutputConnectorDTO outputConnectorDTO = null;
		try {
			outputConnectorDTO = (RetrieveSalesOrgAuthOutputConnectorDTO)jmsConnectorLocal.sendReceive(inputConnectorDTO);
		} catch (Exception e1) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, e1);
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		if (ConnectorConstants.RFC_SUCCESS_CODE.equals(outputConnectorDTO.getReturnCode())) {
			domainDTO = new ReverificationReportDomainDTO();
			domainDTO.setSalesOrg(customDTO.getSalesOrg());
			
			// Populae the domain dto with all the sales orgs with access types that are
			// retrieved from the back end.
			List salesOrgAccessList = outputConnectorDTO.getSalesOrgAccessList();
			for(int k=0, size=salesOrgAccessList.size(); k<size; k++) {
				SalesOrgAccessDTO salesOrgAccess = (SalesOrgAccessDTO)salesOrgAccessList.get(k);
				domainDTO.addUser(salesOrgAccess.getUserID(), salesOrgAccess.getSalesOrg(), salesOrgAccess.getAccessType());			
			}
			
			// Call to database to retrieve the last login date,first name and last name for the users
			domainDTO = UserDAO.retriveDataForUserReverification(domainDTO);
			domainDTO.cleanUpUsersFromOPPT(); // Remove all users who are not present in OPPT.
			
			UserProfilesConnectorDTO userProfilesDTO = new UserProfilesConnectorDTO();
			Map users = domainDTO.getUsers();
			if(null != users && 0 < users.size()){
				Iterator iterator = users.keySet().iterator();
				while(iterator.hasNext()){
					/* If User Profile information like First Name and Last Name are not present in OPPT then
					   get the information from Web Identity.
					*/
					ReverificationReportUserDomainDTO user = (ReverificationReportUserDomainDTO) users.get(iterator.next());
					String userId = user.getUserID();
					userProfilesDTO.addUser(userId);					
				}
			}
			
			// Call to connector to get the user's first name and last name
			try {
				UserProfileConnector connector = new UserProfileConnector();
				userProfilesDTO = connector.populateNames(userProfilesDTO);
				
				if(null != userProfilesDTO){
					users = userProfilesDTO.getUserProfiles();
					if(null != users && 0 < users.size()){
						Iterator iterator = users.keySet().iterator();
						while(iterator.hasNext()){
							String userID = (String)iterator.next();
							UserProfileConnectorDTO userProfile = userProfilesDTO.getUserProfile(userID);
							if(null != userProfile){
								//domainDTO.updateUserProfile(userID, userProfile.getFirstName(), userProfile.getLastName(), true);
							    domainDTO.updateUserProfile(userProfile,true);
								/* Update User Profile Information of First name and last Name into OPPT tables */
						//		UserDAO.updateUserProfile(userProfile.getFirstName(),userProfile.getLastName(),userID);
							}
						}
					}
				}
				domainDTO.cleanUpUsersNotInBluePages(); // Remove all the users who are not present in WI.
				
			} catch (ConnectorException ce) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, CLASS_NAME, methodName, null, ce);
				throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0215);
			}
		}
		else {
			throwServiceException(outputConnectorDTO.getReturnCode(), OPPTMessageCatalog.TYPE_BACKEND);
		}
		customDTO.setReportDTO(domainDTO);
		log.end();
		return customDTO;
	}

	private void throwServiceException(String errorCode, int messageType) throws ServiceException {
		if (messageType == OPPTMessageCatalog.TYPE_BACKEND) {
			OPPTLogger.debug("Message Code = " + errorCode, CLASS_NAME, "throwServiceException");
			try {
				Integer.parseInt(errorCode);
			} catch (NumberFormatException ne) {
				errorCode = ErrorCodeConstants.CE0801;
			} catch (Exception e) {
				errorCode = ErrorCodeConstants.CE0801;
			}
		}
		ErrorReport errorReport = new ErrorReport();
		ErrorKey key = new ErrorKey(errorCode, messageType);
		errorReport.addErrorEntry(key, null);
		ServiceException se = new ServiceException();
		se.setErrorReport(errorReport);
		throw se;
	}
	/**
	 *  method to get all baseagreement reports
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date oct 17, 2006 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param ReportsCustomDTO
	 * @return ReportsCustomDTO
	 * @throws ServiceException	  
	 */
 public BaseAgreementReportsCustomDTO getAllBAReports(BaseAgreementReportCustomDTO customDto)throws ServiceException{
 	
 	TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "getAllBAReports");
	try {
		BaseAgreementReportDTOFactory reportDTOFactory = new BaseAgreementReportDTOFactory();
		BaseAgreementReportsCustomDTO baseAgreementReportsCustomDTO= new BaseAgreementReportsCustomDTO();
		String salesOrg = customDto.getSalesOrg();
		String status = customDto.getStatus();
		
		try {
			baseAgreementReportsCustomDTO = reportDTOFactory.getAllBaseAgreements(status,salesOrg);
		} catch (DomainException ex) {
			throw new ServiceException();
		}
		
		return baseAgreementReportsCustomDTO;
	} catch (ServiceException ex) {
		throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
	} finally {
		timeTaken.end();
	}
 	
 }
 /**
	 *  method to get all active/inactive baseagreement reports
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date oct 17, 2006 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param ReportsCustomDTO
	 * @return ReportsCustomDTO
	 * @throws ServiceException	  
	 */
 public BaseAgreementReportsCustomDTO getActiveOrInactiveBAReports(BaseAgreementReportsCustomDTO customDto)throws ServiceException{
 	
 	return null;
 }
 /**
	 *  method to get all active/inactive baseagreement reports
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date oct 17, 2006 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param ReportsCustomDTO
	 * @return ReportsCustomDTO
	 * @throws ServiceException	  
	 */
 public BaseAgreementReportsCustomDTO getAllBAModificationReports(BaseAgreementReportCustomDTO customDto)throws ServiceException{
 	
 	TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "getAllBAModificationReports");
	try {
		BaseAgreementReportDTOFactory reportDTOFactory = new BaseAgreementReportDTOFactory();
		BaseAgreementReportsCustomDTO baseAgreementReportsCustomDTO= new BaseAgreementReportsCustomDTO();
		String salesOrg = customDto.getSalesOrg();
		String status = customDto.getStatus();
		
		try {
			baseAgreementReportsCustomDTO = reportDTOFactory.getAllModifications(status,salesOrg);
		} catch (DomainException ex) {
			throw new ServiceException();
		}
		
		return baseAgreementReportsCustomDTO;
	} catch (ServiceException ex) {
		throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
	} finally {
		timeTaken.end();
	}
 }
 /**
	 *  method to get all active/inactive baseagreement reports
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date oct 17, 2006 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param ReportsCustomDTO
	 * @return ReportsCustomDTO
	 * @throws ServiceException	  
	 */
 public BaseAgreementReportsCustomDTO getActiveOrInactiveModificationReports(BaseAgreementReportsCustomDTO customDto)throws ServiceException{
 	
 	return null;
 }
 /**
	 *  method to get all active/inactive baseagreement reports
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date oct 17, 2006 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param ReportsCustomDTO
	 * @return ReportsCustomDTO
	 * @throws ServiceException	  
	 */
 public BaseAgreementReportsCustomDTO getBAReportsbyFormNumbers(BaseAgreementReportCustomDTO customDto)throws ServiceException{
 	TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "getBAReportsbyFormNumbers");
	try {
		BaseAgreementReportDTOFactory reportDTOFactory = new BaseAgreementReportDTOFactory();
		BaseAgreementReportsCustomDTO baseAgreementReportsCustomDTO= new BaseAgreementReportsCustomDTO();
		String salesOrg = customDto.getSalesOrg();
		String status = customDto.getStatus();
		//List formNumbers = customDto.getFormNumbers();
		String[] string = customDto.getFormNumbers();
		try {
			baseAgreementReportsCustomDTO = reportDTOFactory.getReportByFormNumbers(status,salesOrg,string);
		} catch (DomainException ex) {
			throw new ServiceException();
		}
		
		return baseAgreementReportsCustomDTO;
	} catch (ServiceException ex) {
		throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
	} finally {
		timeTaken.end();
	}
 	
 }
 /**
	 *  method to get all active/inactive baseagreement reports
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date oct 17, 2006 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param ReportsCustomDTO
	 * @return ReportsCustomDTO
	 * @throws ServiceException	  
	 */
public BaseAgreementReportsCustomDTO getBAReportsbyModTypes(BaseAgreementReportCustomDTO customDto)throws ServiceException{
	TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "getBAReportsbyModTypes");
	try {
		BaseAgreementReportDTOFactory reportDTOFactory = new BaseAgreementReportDTOFactory();
		BaseAgreementReportsCustomDTO baseAgreementReportsCustomDTO= new BaseAgreementReportsCustomDTO();
		String salesOrg = customDto.getSalesOrg();
		String status = customDto.getStatus();
		//List formNumbers = customDto.getFormNumbers();
		String[] string = customDto.getModTypes();
		try {
			baseAgreementReportsCustomDTO = reportDTOFactory.getReportByModTypes(status,salesOrg,string);
		} catch (DomainException ex) {
			throw new ServiceException();
		}
		
		return baseAgreementReportsCustomDTO;
	} catch (ServiceException ex) {
		throw ExceptionGenerator.generateServiceException(ex.getErrorReport());
	} finally {
		timeTaken.end();
	}
}

public DeletedUsersReportCustomDTO getdeletedUsersReport(DeletedUsersReportCustomDTO customDto)throws ServiceException{
	TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "getdeletedUsersReport");
	
		String salesOrg = customDto.getSalesOrg();
		ReverificationReportDomainDTO domainDTO = null;
		domainDTO = new ReverificationReportDomainDTO();
		domainDTO.setSalesOrg(customDto.getSalesOrg());
		
		domainDTO = UserDAO.retriveDataForDeletedUsersReport(domainDTO);
		customDto.setReportDTO(domainDTO);
		
		return customDto;
	
}

















}
