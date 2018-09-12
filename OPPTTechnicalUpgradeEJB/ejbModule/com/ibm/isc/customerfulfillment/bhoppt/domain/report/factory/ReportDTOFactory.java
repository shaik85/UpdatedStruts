/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.report.factory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.CustomerDAO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.DMDAO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.PriceDAO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.ProposalDAO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.SWODAO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.SWOEEDAO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.CompareTPReportCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.reportdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;

/** 
 * This is the factory class for creating all Reports.  
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
public class ReportDTOFactory {


	/**
	 *  Method to get the Contract Attachment Draft report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return ContractAttchRptDomainDTO
	 *	  
	 */

	public ContractAttchRptDomainDTO getContractAttachRpt(String proposalID) throws DomainException {
		BigDecimal monthPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal calculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal totalMonthPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal totalCalculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
		
		ContractAttchRptDomainDTO contractAttchRptDomainDTO = new ContractAttchRptDomainDTO();
		
		ContractAttchRptDMDDomainTO contractAttchRptDMDomainDTO = new ContractAttchRptDMDDomainTO();
		ContractAttchRptSWODomainDTO contractAttchRptSWODomainDTO = new ContractAttchRptSWODomainDTO();

		List contractAttchRptCustomerDomainDTOList;
		List contractAttchRptDMDomainDTOList=null,contractAttchRptSSDMDomainDTOList=null;
		List contractAttchRptSWODomainDTOList=null,contractAttchRptSSSWODomainDTOList=null;
		List contractAttchRptSWOEEDomainDTOList=null,contractAttchRptSSSWOEEDomainDTOList=null;

		contractAttchRptDomainDTO = ProposalDAO.retriveDataForContractAttchRpt(proposalID);
		
		java.util.Date today = new java.util.Date();
		contractAttchRptDomainDTO.setRptPrintedDate(new Date(today.getTime()));
		
		/* Populate MLC DM's and SWO's */
		
		if(contractAttchRptDomainDTO.getProposalContent().equals("M") || contractAttchRptDomainDTO.getProposalContent().equals("A")) {
			
			ContractAttchRptCustomerDomainDTO contractAttchRptCustomerDomainDTO = new ContractAttchRptCustomerDomainDTO();
			contractAttchRptCustomerDomainDTOList = CustomerDAO.retriveDataForContractAttchDraftRpt(proposalID);
			contractAttchRptDomainDTO.setCustomerDomainDTOList(contractAttchRptCustomerDomainDTOList);
			
			for (int i = 0; i < contractAttchRptCustomerDomainDTOList.size(); i++) {
				calculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
				monthPrice = OPPTHelper.convertToBigDecimal(0.0);
			
				contractAttchRptCustomerDomainDTO = (ContractAttchRptCustomerDomainDTO) contractAttchRptCustomerDomainDTOList.get(i);
				contractAttchRptDMDomainDTOList = new ArrayList();
				contractAttchRptDMDomainDTOList = DMDAO.retriveDataForContractAttchDraftRpt(proposalID, contractAttchRptCustomerDomainDTO.getSoldToPartyID(),true);
				contractAttchRptCustomerDomainDTO.addDMDomainDTOList(contractAttchRptDMDomainDTOList);
				contractAttchRptCustomerDomainDTO.setDmDomainTO(contractAttchRptDMDomainDTOList);
								
				
				
				int dmSize = contractAttchRptCustomerDomainDTO.getDmDomainTO().size(); 

				for (int j = 0; j < dmSize; j++) {
					contractAttchRptDMDomainDTO = (ContractAttchRptDMDDomainTO) contractAttchRptCustomerDomainDTO.getDmDomainTO().get(j);
					
					contractAttchRptSWODomainDTOList = new ArrayList();
					contractAttchRptSWODomainDTOList = SWODAO.retriveDataForContractAttchDraftRpt(proposalID, contractAttchRptDMDomainDTO.getSoldToPartyID(), contractAttchRptDMDomainDTO.getDesgMcID(),true);
					contractAttchRptDMDomainDTO.addSWODomainDTOList(contractAttchRptSWODomainDTOList);
					contractAttchRptDMDomainDTO.setSWODomainDTOList(contractAttchRptSWODomainDTOList);
									
				
										
					for (int k = 0; k < contractAttchRptDMDomainDTO.getSWODomainDTOList().size(); k++) {
						contractAttchRptSWODomainDTO = (ContractAttchRptSWODomainDTO) contractAttchRptDMDomainDTO.getSWODomainDTOList().get(k);
						
						calculatedPrice = calculatedPrice.add(OPPTHelper.convertToBigDecimal(contractAttchRptSWODomainDTO.getCalculatedPrice()));
						
						if(contractAttchRptSWODomainDTO.getAlternatePrice() !=0) {
							contractAttchRptSWODomainDTO.setComments("A");
							contractAttchRptSWODomainDTO.setAlternatePrice(contractAttchRptSWODomainDTO.getAlternatePrice());
							monthPrice = monthPrice.add(OPPTHelper.convertToBigDecimal(contractAttchRptSWODomainDTO.getAlternatePrice()));
						}
						else {
							contractAttchRptSWODomainDTO.setComments("-");
							contractAttchRptSWODomainDTO.setESWPrice(contractAttchRptSWODomainDTO.getESWPrice());
							monthPrice = monthPrice.add(OPPTHelper.convertToBigDecimal(contractAttchRptSWODomainDTO.getESWPrice()));
						}
						
						contractAttchRptSWOEEDomainDTOList = new ArrayList();
						contractAttchRptSWOEEDomainDTOList = SWOEEDAO.retriveDataForContractAttchDraftRpt(proposalID, contractAttchRptSWODomainDTO.getSoldToPartyID(), contractAttchRptSWODomainDTO.getDmID(), contractAttchRptSWODomainDTO.getSwoID());
						contractAttchRptSWODomainDTO.addSWOEEDomainDTOList(contractAttchRptSWOEEDomainDTOList);
										
					}
				}
				if(dmSize > 0) {
					contractAttchRptCustomerDomainDTO.setTotalESWPrice(monthPrice.doubleValue());
					contractAttchRptCustomerDomainDTO.setTotalCalculatedPrice(calculatedPrice.doubleValue());
				}
				
				
				totalMonthPrice = totalMonthPrice.add(monthPrice);
				totalCalculatedPrice = totalCalculatedPrice.add(calculatedPrice);
			}
		}
		
		/* Populate S&S DM's and SWO's */
		
		if(contractAttchRptDomainDTO.getProposalContent().equals("S") || contractAttchRptDomainDTO.getProposalContent().equals("A")) {
			
			ContractAttchRptCustomerDomainDTO contractAttchRptCustomerDomainDTO = new ContractAttchRptCustomerDomainDTO();
			contractAttchRptCustomerDomainDTOList = CustomerDAO.retriveDataForContractAttchDraftRpt(proposalID);
			contractAttchRptDomainDTO.setSSCustomerDomainDTOList(contractAttchRptCustomerDomainDTOList);
			
			for (int i = 0; i < contractAttchRptCustomerDomainDTOList.size(); i++) {
				calculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
				monthPrice = OPPTHelper.convertToBigDecimal(0.0);
			
				contractAttchRptCustomerDomainDTO = (ContractAttchRptCustomerDomainDTO) contractAttchRptCustomerDomainDTOList.get(i);
				contractAttchRptSSDMDomainDTOList = new ArrayList();
				contractAttchRptSSDMDomainDTOList = DMDAO.retriveDataForContractAttchDraftRpt(proposalID, contractAttchRptCustomerDomainDTO.getSoldToPartyID(),false);
				contractAttchRptCustomerDomainDTO.addSSDMDomainDTOList(contractAttchRptSSDMDomainDTOList);
				contractAttchRptCustomerDomainDTO.setSSDmDomainTO(contractAttchRptSSDMDomainDTOList);
				
				
				
				int dmSize = contractAttchRptCustomerDomainDTO.getSSDmDomainTO().size();
				
				for (int j = 0; j < dmSize; j++) {
					contractAttchRptDMDomainDTO = (ContractAttchRptDMDDomainTO) contractAttchRptCustomerDomainDTO.getSSDmDomainTO().get(j);
			
					contractAttchRptSSSWODomainDTOList = new ArrayList();
					contractAttchRptSSSWODomainDTOList = SWODAO.retriveDataForContractAttchDraftRpt(proposalID, contractAttchRptDMDomainDTO.getSoldToPartyID(), contractAttchRptDMDomainDTO.getDesgMcID(),false);
					contractAttchRptDMDomainDTO.addSSSWODomainDTOList(contractAttchRptSSSWODomainDTOList);
					contractAttchRptDMDomainDTO.setSSSWODomainDTOList(contractAttchRptSSSWODomainDTOList);
								
					for (int k = 0; k < contractAttchRptDMDomainDTO.getSSSWODomainDTOList().size(); k++) {
						contractAttchRptSWODomainDTO = (ContractAttchRptSWODomainDTO) contractAttchRptDMDomainDTO.getSSSWODomainDTOList().get(k);
				
						calculatedPrice = calculatedPrice.add(OPPTHelper.convertToBigDecimal(contractAttchRptSWODomainDTO.getCalculatedPrice()));
				
						if(contractAttchRptSWODomainDTO.getAlternatePrice() !=0) {
							contractAttchRptSWODomainDTO.setComments("A");
							contractAttchRptSWODomainDTO.setAlternatePrice(contractAttchRptSWODomainDTO.getAlternatePrice());
							monthPrice = monthPrice.add(OPPTHelper.convertToBigDecimal(contractAttchRptSWODomainDTO.getAlternatePrice()));
						}
						else {
							contractAttchRptSWODomainDTO.setComments("-");
							contractAttchRptSWODomainDTO.setESWPrice(contractAttchRptSWODomainDTO.getESWPrice());
							monthPrice = monthPrice.add(OPPTHelper.convertToBigDecimal(contractAttchRptSWODomainDTO.getESWPrice()));
						}
					
						contractAttchRptSSSWOEEDomainDTOList = new ArrayList();
						contractAttchRptSSSWOEEDomainDTOList = SWOEEDAO.retriveDataForContractAttchDraftRpt(proposalID, contractAttchRptSWODomainDTO.getSoldToPartyID(), contractAttchRptSWODomainDTO.getDmID(), contractAttchRptSWODomainDTO.getSwoID());
						contractAttchRptSWODomainDTO.addSWOEEDomainDTOList(contractAttchRptSSSWOEEDomainDTOList);
				
						
					}
				}
				if(dmSize > 0) {
					contractAttchRptCustomerDomainDTO.setTotalESWPrice(monthPrice.doubleValue());
					contractAttchRptCustomerDomainDTO.setTotalCalculatedPrice(calculatedPrice.doubleValue());
				}
				totalMonthPrice = totalMonthPrice.add(monthPrice);
				totalCalculatedPrice = totalCalculatedPrice.add(calculatedPrice);
			}
		}
		
		contractAttchRptDomainDTO.setTotalESWPrice(totalMonthPrice.doubleValue());
		contractAttchRptDomainDTO.setCalculatedPrice(totalCalculatedPrice.doubleValue());
	
		return contractAttchRptDomainDTO;
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
	 * @param proposalID
	 * @return ContractPlanningRptDomainDTO
	 *	  
	 */

	public ContractPlanningRptDomainDTO getContractPlanningRpt(String proposalID) throws DomainException {
		BigDecimal totalCalculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal calculatedDMPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal calculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
		
		ContractPlanningRptDomainDTO contractPlanningRptDomainDTO = new ContractPlanningRptDomainDTO();
		ContractPlanningRptDMDomainDTO contractPlanningRptDMDomainDTO = new ContractPlanningRptDMDomainDTO();
		ContractPlanningRptSWODomainDTO contractPlanningRptSWODomainDTO = new ContractPlanningRptSWODomainDTO();

		List contractPlanningRptCustomerDomainDTOList;
		List contractPlanningRptDMDomainDTOList=null,contractPlanningRptSSDMDomainDTOList=null;
		List contractPlanningRptSWODomainDTOList=null,contractPlanningRptSSSWODomainDTOList=null;
		List contractPlanningRptSWOEEDomainDTOList=null,contractPlanningRptSSSWOEEDomainDTOList=null;

		contractPlanningRptDomainDTO = ProposalDAO.retriveDataForContractPlnRpt(proposalID);
		
		java.util.Date today = new java.util.Date();
		contractPlanningRptDomainDTO.setRptPrintedDate(new Date(today.getTime()));

		/* Populate MLC DM's and SWO's */
		
		if(contractPlanningRptDomainDTO.getProposalContent().equals("M") || contractPlanningRptDomainDTO.getProposalContent().equals("A")) {
		
			ContractPlanningRptCustomerDomainDTO contractPlanningRptCustomerDomainDTO = new ContractPlanningRptCustomerDomainDTO();
			contractPlanningRptCustomerDomainDTOList = CustomerDAO.retriveDataForContractPlnRpt(proposalID);
			contractPlanningRptDomainDTO.setCustomerDomainDTOList(contractPlanningRptCustomerDomainDTOList);
		

			for (int i = 0; i < contractPlanningRptCustomerDomainDTOList.size(); i++) {
				calculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
			
				contractPlanningRptCustomerDomainDTO = (ContractPlanningRptCustomerDomainDTO) contractPlanningRptCustomerDomainDTOList.get(i);
				contractPlanningRptDMDomainDTOList = new ArrayList();
				contractPlanningRptDMDomainDTOList = DMDAO.retriveDataForContractPlnRpt(proposalID, contractPlanningRptCustomerDomainDTO.getSoldToPartyID(),true);
				contractPlanningRptCustomerDomainDTO.addDMDomainDTOList(contractPlanningRptDMDomainDTOList);
				contractPlanningRptCustomerDomainDTO.setIDMDomainDTOListO(contractPlanningRptDMDomainDTOList);
				
				int dmSize = contractPlanningRptCustomerDomainDTO.getIDMDomainDTOListO().size();
				 
				for (int j = 0; j < dmSize; j++) {
					contractPlanningRptDMDomainDTO = (ContractPlanningRptDMDomainDTO) contractPlanningRptCustomerDomainDTO.getIDMDomainDTOListO().get(j);
					contractPlanningRptSWODomainDTOList = new ArrayList();
					contractPlanningRptSWODomainDTOList = SWODAO.retriveDataForContractPlnRpt(proposalID, contractPlanningRptDMDomainDTO.getSoldToPartyID(), contractPlanningRptDMDomainDTO.getDesgMcID(),true);
					contractPlanningRptDMDomainDTO.addSWODomainDTOList(contractPlanningRptSWODomainDTOList);
					contractPlanningRptDMDomainDTO.setSWODomainDTOList(contractPlanningRptSWODomainDTOList);
					calculatedDMPrice = OPPTHelper.convertToBigDecimal(0.0);
					for (int k = 0; k < contractPlanningRptDMDomainDTO.getSWODomainDTOList().size(); k++) {
						contractPlanningRptSWODomainDTO = (ContractPlanningRptSWODomainDTO) contractPlanningRptDMDomainDTO.getSWODomainDTOList().get(k);
					
						calculatedPrice = calculatedPrice.add(OPPTHelper.convertToBigDecimal(contractPlanningRptSWODomainDTO.getCalculatedPrice()));
						calculatedDMPrice = calculatedDMPrice.add(OPPTHelper.convertToBigDecimal(contractPlanningRptSWODomainDTO.getCalculatedPrice()));
				
						contractPlanningRptSWOEEDomainDTOList = new ArrayList();
						contractPlanningRptSWOEEDomainDTOList = SWOEEDAO.retriveDataForContractPlnRpt(proposalID, contractPlanningRptSWODomainDTO.getSoldToPartyID(), contractPlanningRptSWODomainDTO.getDmID(), contractPlanningRptSWODomainDTO.getSwoID());
						contractPlanningRptSWODomainDTO.addSWOEEDomainDTOList(contractPlanningRptSWOEEDomainDTOList);
					}
					contractPlanningRptDMDomainDTO.setTotalCalculatedPrice(calculatedDMPrice.doubleValue());
				}
				if(dmSize > 0) {
					contractPlanningRptCustomerDomainDTO.setTotalCalculatedPrice(calculatedPrice.doubleValue());
				}
		
				contractPlanningRptCustomerDomainDTO.setTotalCalculatedPrice(calculatedPrice.doubleValue());
				totalCalculatedPrice = totalCalculatedPrice.add(calculatedPrice);
			}
		}
		
		/* Populate S&S DM's and SWO's */
		
		if(contractPlanningRptDomainDTO.getProposalContent().equals("S") || contractPlanningRptDomainDTO.getProposalContent().equals("A")) {
		
			ContractPlanningRptCustomerDomainDTO contractPlanningRptCustomerDomainDTO = new ContractPlanningRptCustomerDomainDTO();
			contractPlanningRptCustomerDomainDTOList = CustomerDAO.retriveDataForContractPlnRpt(proposalID);
			contractPlanningRptDomainDTO.setSSCustomerDomainDTOList(contractPlanningRptCustomerDomainDTOList);
		

			for (int i = 0; i < contractPlanningRptCustomerDomainDTOList.size(); i++) {
				calculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
		
				contractPlanningRptCustomerDomainDTO = (ContractPlanningRptCustomerDomainDTO) contractPlanningRptCustomerDomainDTOList.get(i);
				contractPlanningRptDMDomainDTOList = new ArrayList();
				contractPlanningRptDMDomainDTOList = DMDAO.retriveDataForContractPlnRpt(proposalID, contractPlanningRptCustomerDomainDTO.getSoldToPartyID(),false);
				contractPlanningRptCustomerDomainDTO.addSSDMDomainDTOList(contractPlanningRptDMDomainDTOList);
				contractPlanningRptCustomerDomainDTO.setSSDmDomainTO(contractPlanningRptDMDomainDTOList);
				
				int dmSize = contractPlanningRptCustomerDomainDTO.getSSDmDomainTO().size();
			 
				for (int j = 0; j < dmSize; j++) {
					contractPlanningRptDMDomainDTO = (ContractPlanningRptDMDomainDTO) contractPlanningRptCustomerDomainDTO.getSSDmDomainTO().get(j);
					contractPlanningRptSWODomainDTOList = new ArrayList();
					contractPlanningRptSWODomainDTOList = SWODAO.retriveDataForContractPlnRpt(proposalID, contractPlanningRptDMDomainDTO.getSoldToPartyID(), contractPlanningRptDMDomainDTO.getDesgMcID(),false);
					contractPlanningRptDMDomainDTO.addSSSWODomainDTOList(contractPlanningRptSWODomainDTOList);
					contractPlanningRptDMDomainDTO.setSSSWODomainDTOList(contractPlanningRptSWODomainDTOList);
					calculatedDMPrice = OPPTHelper.convertToBigDecimal(0.0);
					for (int k = 0; k < contractPlanningRptDMDomainDTO.getSSSWODomainDTOList().size(); k++) {
						contractPlanningRptSWODomainDTO = (ContractPlanningRptSWODomainDTO) contractPlanningRptDMDomainDTO.getSSSWODomainDTOList().get(k);
			
						calculatedPrice = calculatedPrice.add(OPPTHelper.convertToBigDecimal(contractPlanningRptSWODomainDTO.getCalculatedPrice()));
						calculatedDMPrice = calculatedDMPrice.add(OPPTHelper.convertToBigDecimal(contractPlanningRptSWODomainDTO.getCalculatedPrice()));
						contractPlanningRptSWOEEDomainDTOList = new ArrayList();
						contractPlanningRptSWOEEDomainDTOList = SWOEEDAO.retriveDataForContractPlnRpt(proposalID, contractPlanningRptSWODomainDTO.getSoldToPartyID(), contractPlanningRptSWODomainDTO.getDmID(), contractPlanningRptSWODomainDTO.getSwoID());
						contractPlanningRptSWODomainDTO.addSWOEEDomainDTOList(contractPlanningRptSWOEEDomainDTOList);
					}
					contractPlanningRptDMDomainDTO.setTotalCalculatedPrice(calculatedDMPrice.doubleValue());
				}
				if(dmSize > 0) {
					contractPlanningRptCustomerDomainDTO.setTotalCalculatedPrice(calculatedPrice.doubleValue());
				}
		
				contractPlanningRptCustomerDomainDTO.setTotalCalculatedPrice(calculatedPrice.doubleValue());
				totalCalculatedPrice = totalCalculatedPrice.add(calculatedPrice);
			}
		}

		contractPlanningRptDomainDTO.setTotalCalculatedPrice(totalCalculatedPrice.doubleValue());
		
		return contractPlanningRptDomainDTO;
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
	 * @param proposalID
	 * @return ContractAmendmentRptDomainDTO
	 *	  
	 */

	public ContractAmendmentRptDomainDTO getContractAmdRpt(String proposalID) throws DomainException {
		BigDecimal monthPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal calculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal adjustmentPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal totalCalculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal totalMonthPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal totalPrevBilled = OPPTHelper.convertToBigDecimal(0.0);
				
		ContractAmendmentRptDomainDTO contractAmendmentRptDomainDTO = new ContractAmendmentRptDomainDTO();
		ContractAmendmentRptDMDomainDTO contractAmendmentRptDMDomainDTO = new ContractAmendmentRptDMDomainDTO();
		ContractAmendmentRptSWODomainDTO contractAmendmentRptSWODomainDTO = new ContractAmendmentRptSWODomainDTO();

		List contractAmendmentRptCustomerDomainDTOList;
		List contractAmendmentRptDMDomainDTOList=null,contractAmendmentRptSSDMDomainDTOList=null;
		List contractAmendmentRptSWODomainDTOList=null,contractAmendmentRptSSSWODomainDTOList=null;
		List contractAmendmentRptSWOEEDomainDTOList=null,contractAmendmentRptSSSWOEEDomainDTOList=null;

		contractAmendmentRptDomainDTO = ProposalDAO.retriveDataForContractAmdRpt(proposalID);
		
		java.util.Date today = new java.util.Date();
		contractAmendmentRptDomainDTO.setRptPrintedDate(new Date(today.getTime()));

		/* Populate MLC DM's and SWO's */
		
		
		if(contractAmendmentRptDomainDTO.getProposalContent().equals("M") || contractAmendmentRptDomainDTO.getProposalContent().equals("A")) {
			
			ContractAmendmentRptCustomerDomainDTO contractAmendmentRptCustomerDomainDTO = new ContractAmendmentRptCustomerDomainDTO();			
			contractAmendmentRptCustomerDomainDTOList = CustomerDAO.retriveDataForContractAmdRpt(proposalID);
			contractAmendmentRptDomainDTO.setCustomerDomainDTOList(contractAmendmentRptCustomerDomainDTOList);
		
			for (int i = 0; i < contractAmendmentRptCustomerDomainDTOList.size(); i++) {
				calculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
				monthPrice = OPPTHelper.convertToBigDecimal(0.0);
			
				contractAmendmentRptCustomerDomainDTO = (ContractAmendmentRptCustomerDomainDTO) contractAmendmentRptCustomerDomainDTOList.get(i);
				contractAmendmentRptDMDomainDTOList = new ArrayList();
				contractAmendmentRptDMDomainDTOList = DMDAO.retriveDataForContractAmdRpt(proposalID, contractAmendmentRptCustomerDomainDTO.getSoldToPartyID(),true);
				contractAmendmentRptCustomerDomainDTO.addDMDomainDTOList(contractAmendmentRptDMDomainDTOList);
				contractAmendmentRptCustomerDomainDTO.setDMDomainDTOList(contractAmendmentRptDMDomainDTOList);
				
				int dmSize = contractAmendmentRptCustomerDomainDTO.getDMDomainDTOList().size();
						
				
				for (int j = 0; j < dmSize; j++) {
					contractAmendmentRptDMDomainDTO = (ContractAmendmentRptDMDomainDTO) contractAmendmentRptCustomerDomainDTO.getDMDomainDTOList().get(j);
					contractAmendmentRptSWODomainDTOList = new ArrayList();
					contractAmendmentRptSWODomainDTOList = SWODAO.retriveDataForContractAmdRpt(proposalID, contractAmendmentRptDMDomainDTO.getSoldToPartyID(), contractAmendmentRptDMDomainDTO.getDesgMcID(),true);
					contractAmendmentRptDMDomainDTO.addSWODomainDTOList(contractAmendmentRptSWODomainDTOList);
					contractAmendmentRptDMDomainDTO.setSWODomainDTO(contractAmendmentRptSWODomainDTOList);
					
		

					for (int k = 0; k < contractAmendmentRptDMDomainDTO.getSWODomainDTO().size(); k++) {
						contractAmendmentRptSWODomainDTO = (ContractAmendmentRptSWODomainDTO) contractAmendmentRptDMDomainDTO.getSWODomainDTO().get(k);
					
						//calculatedPrice = calculatedPrice + contractAmendmentRptSWODomainDTO.getCalculatedPrice();
						calculatedPrice = calculatedPrice.add(OPPTHelper.convertToBigDecimal(contractAmendmentRptSWODomainDTO.getCalculatedPrice()));
						adjustmentPrice = adjustmentPrice.add(OPPTHelper.convertToBigDecimal(contractAmendmentRptSWODomainDTO.getAdjustmentAmt()));
						totalPrevBilled = totalPrevBilled.add(OPPTHelper.convertToBigDecimal(contractAmendmentRptSWODomainDTO.getOldCalculatedPrice()));
					
						if(contractAmendmentRptSWODomainDTO.getAlternatePrice() !=0) {
							contractAmendmentRptSWODomainDTO.setAlternatePrice(contractAmendmentRptSWODomainDTO.getAlternatePrice());
							monthPrice = monthPrice.add(OPPTHelper.convertToBigDecimal(contractAmendmentRptSWODomainDTO.getAlternatePrice()));
						}
						else {
							contractAmendmentRptSWODomainDTO.setESWPrice(contractAmendmentRptSWODomainDTO.getESWPrice());
							monthPrice = monthPrice.add(OPPTHelper.convertToBigDecimal(contractAmendmentRptSWODomainDTO.getESWPrice()));
						}
										
						contractAmendmentRptSWOEEDomainDTOList = new ArrayList();
						contractAmendmentRptSWOEEDomainDTOList = SWOEEDAO.retriveDataForContractAmdRpt(proposalID, contractAmendmentRptSWODomainDTO.getSoldToPartyID(), contractAmendmentRptSWODomainDTO.getDmID(), contractAmendmentRptSWODomainDTO.getSwoID());
						contractAmendmentRptSWODomainDTO.addSWOEEDomainDTOList(contractAmendmentRptSWOEEDomainDTOList);
								
					}
				}
				if(dmSize > 0) {
					contractAmendmentRptCustomerDomainDTO.setTotalMonthlyPrice(monthPrice.doubleValue());
					contractAmendmentRptCustomerDomainDTO.setTotalCalculatedPrice(calculatedPrice.doubleValue());
				}
		
				totalCalculatedPrice = totalCalculatedPrice.add(calculatedPrice);
				totalMonthPrice = totalMonthPrice.add(monthPrice);
			}
		}
		
		/* Populate S&S DM's and SWO's */
		
		if(contractAmendmentRptDomainDTO.getProposalContent().equals("S") || contractAmendmentRptDomainDTO.getProposalContent().equals("A")) {
			
			ContractAmendmentRptCustomerDomainDTO contractAmendmentRptCustomerDomainDTO = new ContractAmendmentRptCustomerDomainDTO();			
			contractAmendmentRptCustomerDomainDTOList = CustomerDAO.retriveDataForContractAmdRpt(proposalID);
			contractAmendmentRptDomainDTO.setSSCustomerDomainDTOList(contractAmendmentRptCustomerDomainDTOList);
		
			for (int i = 0; i < contractAmendmentRptCustomerDomainDTOList.size(); i++) {
				calculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
				monthPrice = OPPTHelper.convertToBigDecimal(0.0);
			
				contractAmendmentRptCustomerDomainDTO = (ContractAmendmentRptCustomerDomainDTO) contractAmendmentRptCustomerDomainDTOList.get(i);
				contractAmendmentRptDMDomainDTOList = new ArrayList();
				contractAmendmentRptDMDomainDTOList = DMDAO.retriveDataForContractAmdRpt(proposalID, contractAmendmentRptCustomerDomainDTO.getSoldToPartyID(),false);
				contractAmendmentRptCustomerDomainDTO.addSSDMDomainDTOList(contractAmendmentRptDMDomainDTOList);
				contractAmendmentRptCustomerDomainDTO.setSSDmDomainTO(contractAmendmentRptDMDomainDTOList);
				
				int dmSize = contractAmendmentRptCustomerDomainDTO.getSSDmDomainTO().size(); 				
		
				for (int j = 0; j < dmSize; j++) {
					contractAmendmentRptDMDomainDTO = (ContractAmendmentRptDMDomainDTO) contractAmendmentRptCustomerDomainDTO.getSSDmDomainTO().get(j);
					contractAmendmentRptSWODomainDTOList = new ArrayList();
					contractAmendmentRptSWODomainDTOList = SWODAO.retriveDataForContractAmdRpt(proposalID, contractAmendmentRptDMDomainDTO.getSoldToPartyID(), contractAmendmentRptDMDomainDTO.getDesgMcID(),false);
					contractAmendmentRptDMDomainDTO.addSSSWODomainDTOList(contractAmendmentRptSWODomainDTOList);
					contractAmendmentRptDMDomainDTO.setSSSWODomainDTOList(contractAmendmentRptSWODomainDTOList);

					for (int k = 0; k < contractAmendmentRptDMDomainDTO.getSSSWODomainDTOList().size(); k++) {
						contractAmendmentRptSWODomainDTO = (ContractAmendmentRptSWODomainDTO) contractAmendmentRptDMDomainDTO.getSSSWODomainDTOList().get(k);
					
						//calculatedPrice = calculatedPrice + contractAmendmentRptSWODomainDTO.getCalculatedPrice();
						calculatedPrice = calculatedPrice.add(OPPTHelper.convertToBigDecimal(contractAmendmentRptSWODomainDTO.getCalculatedPrice()));
						adjustmentPrice = adjustmentPrice.add(OPPTHelper.convertToBigDecimal(contractAmendmentRptSWODomainDTO.getAdjustmentAmt()));
						totalPrevBilled = totalPrevBilled.add(OPPTHelper.convertToBigDecimal(contractAmendmentRptSWODomainDTO.getOldCalculatedPrice()));
					
						if(contractAmendmentRptSWODomainDTO.getAlternatePrice() !=0) {
							contractAmendmentRptSWODomainDTO.setAlternatePrice(contractAmendmentRptSWODomainDTO.getAlternatePrice());
							monthPrice = monthPrice.add(OPPTHelper.convertToBigDecimal(contractAmendmentRptSWODomainDTO.getAlternatePrice()));
						}
						else {
							contractAmendmentRptSWODomainDTO.setESWPrice(contractAmendmentRptSWODomainDTO.getESWPrice());
							monthPrice = monthPrice.add(OPPTHelper.convertToBigDecimal(contractAmendmentRptSWODomainDTO.getESWPrice()));
						}
										
						contractAmendmentRptSWOEEDomainDTOList = new ArrayList();
						contractAmendmentRptSWOEEDomainDTOList = SWOEEDAO.retriveDataForContractAmdRpt(proposalID, contractAmendmentRptSWODomainDTO.getSoldToPartyID(), contractAmendmentRptSWODomainDTO.getDmID(), contractAmendmentRptSWODomainDTO.getSwoID());
						contractAmendmentRptSWODomainDTO.addSWOEEDomainDTOList(contractAmendmentRptSWOEEDomainDTOList);
					
					}
				}
				if(dmSize > 0) {
					contractAmendmentRptCustomerDomainDTO.setTotalMonthlyPrice(monthPrice.doubleValue());
					contractAmendmentRptCustomerDomainDTO.setTotalCalculatedPrice(calculatedPrice.doubleValue());
				}
				totalCalculatedPrice = totalCalculatedPrice.add(calculatedPrice);
				totalMonthPrice = totalMonthPrice.add(monthPrice);
			}
		}					
		
		contractAmendmentRptDomainDTO.setTotalCalculatedPrice(totalCalculatedPrice.doubleValue());
		contractAmendmentRptDomainDTO.setTotalMonthlyPrice(totalMonthPrice.doubleValue());
		contractAmendmentRptDomainDTO.setAdjustmentAmt(adjustmentPrice.doubleValue());
		contractAmendmentRptDomainDTO.setAmendBilledPrev(totalPrevBilled.doubleValue());
		contractAmendmentRptDomainDTO.setAmendTotal(totalCalculatedPrice.doubleValue() * OPPTHelper.getNumberOfBills(contractAmendmentRptDomainDTO.getBillingFreq()));
		contractAmendmentRptDomainDTO.setOriginalContractTotal(totalPrevBilled.doubleValue() * OPPTHelper.getNumberOfBills(contractAmendmentRptDomainDTO.getBillingFreq()));
		
		return contractAmendmentRptDomainDTO;
	}

	/**
	 *  Method to get the Sysplex  report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return SysplexRptDomainDTO
	 *	  
	 */

	public SysplexRptDomainDTO getSysPlexRpt(String proposalID) throws DomainException {
		BigDecimal calculatedPrice = OPPTHelper.convertToBigDecimal(0.0);

		SysplexRptDomainDTO sysplexRptDomainDTO = new SysplexRptDomainDTO();
		SysplexRptCustomerDomainDTO sysplexRptCustomerDomainDTO = new SysplexRptCustomerDomainDTO();
		SysplexRptDMDomainDTO sysplexRptDMDomainDTO = new SysplexRptDMDomainDTO();
		SysplexRptSWODomainDTO sysplexRptSWODomainDTO = new SysplexRptSWODomainDTO();
		SysplexRptSWOEEDomainDTO sysplexRptSWOEEDomainDTO = new SysplexRptSWOEEDomainDTO();

		List sysplexRptCustomerDomainDTOList;
		List sysplexRptDMDomainDTOList;
		List sysplexRptSWODomainDTOList;
		List sysplexRptSWOEEDomainDTOList;

		sysplexRptDomainDTO = ProposalDAO.retriveDataForSysplexRpt(proposalID);
		sysplexRptDMDomainDTOList = DMDAO.retriveDataForSysplexRpt(proposalID);
		sysplexRptDomainDTO.setDMDomainDTOList(sysplexRptDMDomainDTOList);
		
		java.util.Date today = new java.util.Date();
		sysplexRptDomainDTO.setRptPrintedOn(new Date(today.getTime()));

		for (int i = 0; i < sysplexRptDMDomainDTOList.size(); i++) {
			sysplexRptDMDomainDTO = (SysplexRptDMDomainDTO) sysplexRptDMDomainDTOList.get(i);
			sysplexRptSWODomainDTOList = new ArrayList();
			sysplexRptSWODomainDTOList = SWODAO.retriveDataForSysplexRpt(proposalID);
			sysplexRptDMDomainDTO.addSWODomainDTOList(sysplexRptSWODomainDTOList);
			sysplexRptDMDomainDTO.setSWODomainDTOLiat(sysplexRptSWODomainDTOList);

			for (int j = 0; j < sysplexRptDMDomainDTO.getSWODomainDTOLiat().size(); j++) {
				sysplexRptSWODomainDTO = (SysplexRptSWODomainDTO) sysplexRptDMDomainDTO.getSWODomainDTOLiat().get(j);
				
				sysplexRptSWOEEDomainDTOList = new ArrayList();
				sysplexRptSWOEEDomainDTOList = SWOEEDAO.retriveDataForSysplexRpt(proposalID,sysplexRptSWODomainDTO.getEENo().trim(),sysplexRptSWODomainDTO.getSerialNo().trim());
				sysplexRptSWODomainDTO.addSWOEEDomainDTOList(sysplexRptSWOEEDomainDTOList);
								
				for (int k = 0; k < sysplexRptSWODomainDTO.getSWOEEDomainDTOList().size(); k++) {
					sysplexRptSWOEEDomainDTO = (SysplexRptSWOEEDomainDTO) sysplexRptSWODomainDTO.getSWOEEDomainDTOList().get(k);
					calculatedPrice = calculatedPrice.add(OPPTHelper.convertToBigDecimal(sysplexRptSWOEEDomainDTO.getPrice()));
				}
			}
		}
		sysplexRptDomainDTO.setTotalCharge(calculatedPrice.doubleValue());
		return sysplexRptDomainDTO;
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
	 * @param proposalID
	 * @return InventoryListRptDomainDTO
	 * Changed by Sara for MN19976016 - CMVC Defect 56 on Nov 08,2004	  
	 */

	public InventoryListRptDomainDTO getInventoryListRpt(String proposalID) throws DomainException {
		BigDecimal listPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal listDMPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal totalListPrice = OPPTHelper.convertToBigDecimal(0.0);
		
		InventoryListRptDomainDTO inventoryListRptDomainDTO = new InventoryListRptDomainDTO();
		InventoryListRptDMDomainDTO inventoryListRptDMDomainDTO = new InventoryListRptDMDomainDTO();
		InventoryListRptSWODomainDTO inventoryListRptSWODomainDTO = new InventoryListRptSWODomainDTO();
		InventoryListRptSWOEEDomainDTO inventoryListRptSWOEEDomainDTO = new InventoryListRptSWOEEDomainDTO();

		List inventoryListRptCustomerDomainDTOList;
		List inventoryListRptDMDomainDTOList=null,inventoryListRptSSDMDomainDTOList=null;
		List inventoryListRptSWODomainDTOList=null,inventoryListRptSSSWODomainDTOList=null;
		List inventoryListRptSWOEEDomainDTOList=null,inventoryListRptSSSWOEEDomainDTOList=null;

		inventoryListRptDomainDTO = ProposalDAO.retriveDataForInventoryRpt(proposalID);
		
		java.util.Date today = new java.util.Date();
		inventoryListRptDomainDTO.setRptPrintedDate(new Date(today.getTime()));
		
		/* Populate MLC DM's and SWO's */
		if(inventoryListRptDomainDTO.getProposalContent().equals("M") || inventoryListRptDomainDTO.getProposalContent().equals("A")) {
			
			InventoryListRptCustomerDomainDTO inventoryListRptCustomerDomainDTO = new InventoryListRptCustomerDomainDTO();			
			inventoryListRptCustomerDomainDTOList = CustomerDAO.retriveDataForInventoryRpt(proposalID);
			inventoryListRptDomainDTO.setCustomerDomainDTOList(inventoryListRptCustomerDomainDTOList);
		

			for (int i = 0; i < inventoryListRptCustomerDomainDTOList.size(); i++) {
				listPrice = OPPTHelper.convertToBigDecimal(0.0);
			
				inventoryListRptCustomerDomainDTO = (InventoryListRptCustomerDomainDTO) inventoryListRptCustomerDomainDTOList.get(i);
				inventoryListRptDMDomainDTOList = new ArrayList();
				inventoryListRptDMDomainDTOList = DMDAO.retriveDataForInventoryRpt(proposalID, inventoryListRptCustomerDomainDTO.getSoldToPartyID(),true);
				inventoryListRptCustomerDomainDTO.addDMDomainDTOList(inventoryListRptDMDomainDTOList);
				inventoryListRptCustomerDomainDTO.setDMDomainDTOList(inventoryListRptDMDomainDTOList);
				
				int dmSize = inventoryListRptCustomerDomainDTO.getDMDomainDTOList().size(); 

				for (int j = 0; j < dmSize; j++) {
					inventoryListRptDMDomainDTO = (InventoryListRptDMDomainDTO) inventoryListRptCustomerDomainDTO.getDMDomainDTOList().get(j);
					inventoryListRptSWODomainDTOList = new ArrayList();
					inventoryListRptSWODomainDTOList = SWODAO.retriveDataForInventoryRpt(proposalID, inventoryListRptDMDomainDTO.getSoldToPartyID(), inventoryListRptDMDomainDTO.getDesgMcID(),true);
					inventoryListRptDMDomainDTO.addSWODomainDTOList(inventoryListRptSWODomainDTOList);
					inventoryListRptDMDomainDTO.setSWODomainDTOList(inventoryListRptSWODomainDTOList);
					listDMPrice = OPPTHelper.convertToBigDecimal(0.0);

					
					for (int k = 0; k < inventoryListRptDMDomainDTO.getSWODomainDTOList().size(); k++) {
						inventoryListRptSWODomainDTO = (InventoryListRptSWODomainDTO) inventoryListRptDMDomainDTO.getSWODomainDTOList().get(k);
						inventoryListRptSWOEEDomainDTOList = new ArrayList();
						inventoryListRptSWOEEDomainDTOList = SWOEEDAO.retriveDataForInventoryRpt(proposalID, inventoryListRptSWODomainDTO.getSoldToPartyID(), inventoryListRptSWODomainDTO.getDmID(), inventoryListRptSWODomainDTO.getSwoID());
						inventoryListRptSWODomainDTO.addSWOEEDomainDTOList(inventoryListRptSWOEEDomainDTOList);

						for (int z = 0; z < inventoryListRptSWODomainDTO.getSWOEEDomainDTOList().size(); z++) {
							inventoryListRptSWOEEDomainDTO = (InventoryListRptSWOEEDomainDTO) inventoryListRptSWODomainDTO.getSWOEEDomainDTOList().get(z);
							listPrice = listPrice.add(OPPTHelper.convertToBigDecimal(inventoryListRptSWOEEDomainDTO.getListPrice()));
							/* MN19976016S */
							if(inventoryListRptSWOEEDomainDTO.getAlternatePrice()!=0) {
								listDMPrice = listDMPrice.add(OPPTHelper.convertToBigDecimal(inventoryListRptSWOEEDomainDTO.getAlternatePrice()));
							}
							else {
								listDMPrice = listDMPrice.add(OPPTHelper.convertToBigDecimal(inventoryListRptSWOEEDomainDTO.getListPrice()));
							}
							/* MN19976016E */
						}	
					}
					if(dmSize > 0) {
						inventoryListRptDMDomainDTO.setTotalListPrice(listDMPrice.doubleValue());
					}
				}
				inventoryListRptCustomerDomainDTO.setTotalListPrice(listPrice.doubleValue());
				totalListPrice = totalListPrice.add(listPrice);
			}
		}
		
		/* Populate S&S DM's and SWO's */
		
		if(inventoryListRptDomainDTO.getProposalContent().equals("S") || inventoryListRptDomainDTO.getProposalContent().equals("A")) {
			InventoryListRptCustomerDomainDTO inventoryListRptCustomerDomainDTO = new InventoryListRptCustomerDomainDTO();			
			inventoryListRptCustomerDomainDTOList = CustomerDAO.retriveDataForInventoryRpt(proposalID);
			inventoryListRptDomainDTO.setSSCustomerDomainDTOList(inventoryListRptCustomerDomainDTOList);
		

			for (int i = 0; i < inventoryListRptCustomerDomainDTOList.size(); i++) {
				listPrice = OPPTHelper.convertToBigDecimal(0.0);
			
				inventoryListRptCustomerDomainDTO = (InventoryListRptCustomerDomainDTO) inventoryListRptCustomerDomainDTOList.get(i);
				inventoryListRptDMDomainDTOList = new ArrayList();
				inventoryListRptDMDomainDTOList = DMDAO.retriveDataForInventoryRpt(proposalID, inventoryListRptCustomerDomainDTO.getSoldToPartyID(),false);
				inventoryListRptCustomerDomainDTO.addSSDMDomainDTOList(inventoryListRptDMDomainDTOList);
				inventoryListRptCustomerDomainDTO.setSSDmDomainTO(inventoryListRptDMDomainDTOList);
				

				
				int dmSize = inventoryListRptCustomerDomainDTO.getSSDmDomainTO().size(); 

				for (int j = 0; j < dmSize; j++) {
					inventoryListRptDMDomainDTO = (InventoryListRptDMDomainDTO) inventoryListRptCustomerDomainDTO.getSSDmDomainTO().get(j);
					inventoryListRptSWODomainDTOList = new ArrayList();
					inventoryListRptSWODomainDTOList = SWODAO.retriveDataForInventoryRpt(proposalID, inventoryListRptDMDomainDTO.getSoldToPartyID(), inventoryListRptDMDomainDTO.getDesgMcID(),false);
					inventoryListRptDMDomainDTO.addSSSWODomainDTOList(inventoryListRptSWODomainDTOList);
					inventoryListRptDMDomainDTO.setSSSWODomainDTOList(inventoryListRptSWODomainDTOList);
					listDMPrice = OPPTHelper.convertToBigDecimal(0.0);

					
					for (int k = 0; k < inventoryListRptDMDomainDTO.getSSSWODomainDTOList().size(); k++) {
						inventoryListRptSWODomainDTO = (InventoryListRptSWODomainDTO) inventoryListRptDMDomainDTO.getSSSWODomainDTOList().get(k);
						inventoryListRptSWOEEDomainDTOList = new ArrayList();
						inventoryListRptSWOEEDomainDTOList = SWOEEDAO.retriveDataForInventoryRpt(proposalID, inventoryListRptSWODomainDTO.getSoldToPartyID(), inventoryListRptSWODomainDTO.getDmID(), inventoryListRptSWODomainDTO.getSwoID());
						inventoryListRptSWODomainDTO.addSWOEEDomainDTOList(inventoryListRptSWOEEDomainDTOList);

						for (int z = 0; z < inventoryListRptSWODomainDTO.getSWOEEDomainDTOList().size(); z++) {
							inventoryListRptSWOEEDomainDTO = (InventoryListRptSWOEEDomainDTO) inventoryListRptSWODomainDTO.getSWOEEDomainDTOList().get(z);
							listPrice = listPrice.add(OPPTHelper.convertToBigDecimal(inventoryListRptSWOEEDomainDTO.getListPrice()));
							/* MN19976016S */
							if(inventoryListRptSWOEEDomainDTO.getAlternatePrice()!=0) {
								listDMPrice = listDMPrice.add(OPPTHelper.convertToBigDecimal(inventoryListRptSWOEEDomainDTO.getAlternatePrice()));
							}
							else {
								listDMPrice = listDMPrice.add(OPPTHelper.convertToBigDecimal(inventoryListRptSWOEEDomainDTO.getListPrice()));
							}
							/* MN19976016E */
						}	
					}
					if(dmSize > 0) {
						inventoryListRptDMDomainDTO.setTotalListPrice(listDMPrice.doubleValue());
					}
				}
				inventoryListRptCustomerDomainDTO.setTotalListPrice(listPrice.doubleValue());
				totalListPrice = totalListPrice.add(listPrice);
			}
		}			

		inventoryListRptDomainDTO.setTotalListPrice(totalListPrice.doubleValue());
		return inventoryListRptDomainDTO;
	}

	/**
	 *  Method to get the ListEntitled  report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return ListEntitledPricesRptDomainDTO
	 *	  
	 */

	public ListEntitledPricesRptDomainDTO getListEntitledRpt(String proposalID) throws DomainException {
		BigDecimal listPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal listDMPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal entitledPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal entitledDMPrice = OPPTHelper.convertToBigDecimal(0.0);

		BigDecimal totalListPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal totalEntitledPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal deltaListPrice = OPPTHelper.convertToBigDecimal(0.0);
		
		ListEntitledPricesRptDomainDTO listEntitledPricesRptDomainDTO = new ListEntitledPricesRptDomainDTO();
		ListEntitledPricesRptDMDomainDTO listEntitledPricesRptDMDomainDTO = new ListEntitledPricesRptDMDomainDTO();
		ListEntitledPricesRptSWODomainDTO listEntitledPricesRptSWODomainDTO = new ListEntitledPricesRptSWODomainDTO();
		ListEntitledPricesRptSWOEEDomainDTO listEntitledPricesRptSWOEEDomainDTO = new ListEntitledPricesRptSWOEEDomainDTO();

		List listEntitledPricesRptCustomerDomainDTOList;
		List listEntitledPricesRptDMDomainDTOList=null,listEntitledPricesRptSSDMDomainDTOList=null;
		List listEntitledPricesRptSWODomainDTOList=null,listEntitledPricesRptSSSWODomainDTOList=null;
		List listEntitledPricesRptSWOEEDomainDTOList=null,listEntitledPricesRptSSSWOEEDomainDTOList=null;

		listEntitledPricesRptDomainDTO = ProposalDAO.retriveDataForEERpt(proposalID);
		
		java.util.Date today = new java.util.Date();
		listEntitledPricesRptDomainDTO.setRptPrintedDate(new Date(today.getTime()));
		
		/* Populate MLC DM's and SWO's */
		
		
		
		if(listEntitledPricesRptDomainDTO.getProposalContent().equals("M") || listEntitledPricesRptDomainDTO.getProposalContent().equals("A")) {
			
			ListEntitledPricesRptCustomerDomainDTO listEntitledPricesRptCustomerDomainDTO = new ListEntitledPricesRptCustomerDomainDTO();					
			listEntitledPricesRptCustomerDomainDTOList = CustomerDAO.retriveDataForEERpt(proposalID);
			listEntitledPricesRptDomainDTO.setCustomerDomainDTOList(listEntitledPricesRptCustomerDomainDTOList);
		
		
			for (int i = 0; i < listEntitledPricesRptCustomerDomainDTOList.size(); i++) {
				entitledPrice = OPPTHelper.convertToBigDecimal(0.0);
				listPrice = OPPTHelper.convertToBigDecimal(0.0);
			
				listEntitledPricesRptCustomerDomainDTO = (ListEntitledPricesRptCustomerDomainDTO) listEntitledPricesRptCustomerDomainDTOList.get(i);
				listEntitledPricesRptDMDomainDTOList = new ArrayList();
				listEntitledPricesRptDMDomainDTOList = DMDAO.retriveDataForEERpt(proposalID, listEntitledPricesRptCustomerDomainDTO.getSoldToPartyID(),true);
				listEntitledPricesRptCustomerDomainDTO.addDMDomainDTOList(listEntitledPricesRptDMDomainDTOList);
				listEntitledPricesRptCustomerDomainDTO.setDMDomainDTOList(listEntitledPricesRptDMDomainDTOList);
				
		
				
				int dmSize = listEntitledPricesRptCustomerDomainDTO.getDMDomainDTOList().size(); 

				for (int j = 0; j < dmSize; j++) {
				
					listEntitledPricesRptDMDomainDTO = (ListEntitledPricesRptDMDomainDTO) listEntitledPricesRptCustomerDomainDTO.getDMDomainDTOList().get(j);
					listEntitledPricesRptSWODomainDTOList = new ArrayList();
					listEntitledPricesRptSWODomainDTOList = SWODAO.retriveDataForEERpt(proposalID, listEntitledPricesRptDMDomainDTO.getSoldToPartyID(), listEntitledPricesRptDMDomainDTO.getDesgMcID(),true);
					listEntitledPricesRptDMDomainDTO.addSWODomainDTOList(listEntitledPricesRptSWODomainDTOList);
					listEntitledPricesRptDMDomainDTO.setSWODomainDTOList(listEntitledPricesRptSWODomainDTOList);
					entitledDMPrice = OPPTHelper.convertToBigDecimal(0.0);
					listDMPrice = OPPTHelper.convertToBigDecimal(0.0);

		
				
					for (int k = 0; k < listEntitledPricesRptDMDomainDTO.getSWODomainDTOList().size(); k++) {
						listEntitledPricesRptSWODomainDTO = (ListEntitledPricesRptSWODomainDTO) listEntitledPricesRptDMDomainDTO.getSWODomainDTOList().get(k);
					
						listEntitledPricesRptSWOEEDomainDTOList = new ArrayList();
						listEntitledPricesRptSWOEEDomainDTOList = SWOEEDAO.retriveDataForEERpt(proposalID, listEntitledPricesRptSWODomainDTO.getSoldToPartyID(), listEntitledPricesRptSWODomainDTO.getDmID(), listEntitledPricesRptSWODomainDTO.getSwoID());
						listEntitledPricesRptSWODomainDTO.addSWOEEDomainDTOList(listEntitledPricesRptSWOEEDomainDTOList);
					
		
					
						for (int z = 0; z < listEntitledPricesRptSWODomainDTO.getSWOEEDomainDTOList().size(); z++) {
							deltaListPrice = OPPTHelper.convertToBigDecimal(0.0);
						
							listEntitledPricesRptSWOEEDomainDTO = (ListEntitledPricesRptSWOEEDomainDTO) listEntitledPricesRptSWODomainDTO.getSWOEEDomainDTOList().get(z);
							entitledPrice = entitledPrice.add(OPPTHelper.convertToBigDecimal(listEntitledPricesRptSWOEEDomainDTO.getESWPrice()));
							listPrice = listPrice.add(OPPTHelper.convertToBigDecimal(listEntitledPricesRptSWOEEDomainDTO.getListPrice()));
							entitledDMPrice = entitledDMPrice.add(OPPTHelper.convertToBigDecimal(listEntitledPricesRptSWOEEDomainDTO.getESWPrice()));
							listDMPrice = listDMPrice.add(OPPTHelper.convertToBigDecimal(listEntitledPricesRptSWOEEDomainDTO.getListPrice()));
							deltaListPrice = OPPTHelper.convertToBigDecimal(listEntitledPricesRptSWOEEDomainDTO.getListPrice()).subtract(OPPTHelper.convertToBigDecimal(listEntitledPricesRptSWOEEDomainDTO.getESWPrice()));
							listEntitledPricesRptSWOEEDomainDTO.setDeltaList(deltaListPrice.doubleValue());
						}	

					}
					listEntitledPricesRptDMDomainDTO.setITotalListPrice(listDMPrice.doubleValue());
					listEntitledPricesRptDMDomainDTO.setTotalEntitledPrice(entitledDMPrice.doubleValue());
				}
				if(dmSize > 0) {
					listEntitledPricesRptCustomerDomainDTO.setTotalEntitledPrice(entitledPrice.doubleValue());
					listEntitledPricesRptCustomerDomainDTO.setTotalListPrice(listPrice.doubleValue());
				}
				totalListPrice = totalListPrice.add(listPrice);
				totalEntitledPrice = totalEntitledPrice.add(entitledPrice);	
			}
		}
		
		/* Populate S&S DM's and SWO's */
		
		if(listEntitledPricesRptDomainDTO.getProposalContent().equals("S") || listEntitledPricesRptDomainDTO.getProposalContent().equals("A")) {
			ListEntitledPricesRptCustomerDomainDTO listEntitledPricesRptCustomerDomainDTO = new ListEntitledPricesRptCustomerDomainDTO();					
			listEntitledPricesRptCustomerDomainDTOList = CustomerDAO.retriveDataForEERpt(proposalID);
			listEntitledPricesRptDomainDTO.setSSCustomerDomainDTOList(listEntitledPricesRptCustomerDomainDTOList);
		
		
		
			for (int i = 0; i < listEntitledPricesRptCustomerDomainDTOList.size(); i++) {
				entitledPrice = OPPTHelper.convertToBigDecimal(0.0);
				listPrice = OPPTHelper.convertToBigDecimal(0.0);
			
				listEntitledPricesRptCustomerDomainDTO = (ListEntitledPricesRptCustomerDomainDTO) listEntitledPricesRptCustomerDomainDTOList.get(i);
				listEntitledPricesRptDMDomainDTOList = new ArrayList();
				listEntitledPricesRptDMDomainDTOList = DMDAO.retriveDataForEERpt(proposalID, listEntitledPricesRptCustomerDomainDTO.getSoldToPartyID(),false);
				listEntitledPricesRptCustomerDomainDTO.addSSDMDomainDTOList(listEntitledPricesRptDMDomainDTOList);
				listEntitledPricesRptCustomerDomainDTO.setSSDmDomainTO(listEntitledPricesRptDMDomainDTOList);
				
		
				
				int dmSize = listEntitledPricesRptCustomerDomainDTO.getSSDmDomainTO().size(); 

				for (int j = 0; j < dmSize; j++) {
				
					listEntitledPricesRptDMDomainDTO = (ListEntitledPricesRptDMDomainDTO) listEntitledPricesRptCustomerDomainDTO.getSSDmDomainTO().get(j);
					listEntitledPricesRptSWODomainDTOList = new ArrayList();
					listEntitledPricesRptSWODomainDTOList = SWODAO.retriveDataForEERpt(proposalID, listEntitledPricesRptDMDomainDTO.getSoldToPartyID(), listEntitledPricesRptDMDomainDTO.getDesgMcID(),false);
					listEntitledPricesRptDMDomainDTO.addSSSWODomainDTOList(listEntitledPricesRptSWODomainDTOList);
					listEntitledPricesRptDMDomainDTO.setSSSWODomainDTOList(listEntitledPricesRptSWODomainDTOList);
					entitledDMPrice = OPPTHelper.convertToBigDecimal(0.0);
					listDMPrice = OPPTHelper.convertToBigDecimal(0.0);

		
				
					for (int k = 0; k < listEntitledPricesRptDMDomainDTO.getSSSWODomainDTOList().size(); k++) {
						listEntitledPricesRptSWODomainDTO = (ListEntitledPricesRptSWODomainDTO) listEntitledPricesRptDMDomainDTO.getSSSWODomainDTOList().get(k);
					
						listEntitledPricesRptSWOEEDomainDTOList = new ArrayList();
						listEntitledPricesRptSWOEEDomainDTOList = SWOEEDAO.retriveDataForEERpt(proposalID, listEntitledPricesRptSWODomainDTO.getSoldToPartyID(), listEntitledPricesRptSWODomainDTO.getDmID(), listEntitledPricesRptSWODomainDTO.getSwoID());
						listEntitledPricesRptSWODomainDTO.addSWOEEDomainDTOList(listEntitledPricesRptSWOEEDomainDTOList);
					
		
					
						for (int z = 0; z < listEntitledPricesRptSWODomainDTO.getSWOEEDomainDTOList().size(); z++) {
							deltaListPrice = OPPTHelper.convertToBigDecimal(0.0);
						
							listEntitledPricesRptSWOEEDomainDTO = (ListEntitledPricesRptSWOEEDomainDTO) listEntitledPricesRptSWODomainDTO.getSWOEEDomainDTOList().get(z);
							entitledPrice = entitledPrice.add(OPPTHelper.convertToBigDecimal(listEntitledPricesRptSWOEEDomainDTO.getESWPrice()));
							listPrice = listPrice.add(OPPTHelper.convertToBigDecimal(listEntitledPricesRptSWOEEDomainDTO.getListPrice()));
							entitledDMPrice = entitledDMPrice.add(OPPTHelper.convertToBigDecimal(listEntitledPricesRptSWOEEDomainDTO.getESWPrice()));
							listDMPrice = listDMPrice.add(OPPTHelper.convertToBigDecimal(listEntitledPricesRptSWOEEDomainDTO.getListPrice()));
							deltaListPrice = OPPTHelper.convertToBigDecimal(listEntitledPricesRptSWOEEDomainDTO.getListPrice()).subtract(OPPTHelper.convertToBigDecimal(listEntitledPricesRptSWOEEDomainDTO.getESWPrice()));
							listEntitledPricesRptSWOEEDomainDTO.setDeltaList(deltaListPrice.doubleValue());
						}	

					}
					listEntitledPricesRptDMDomainDTO.setITotalListPrice(listDMPrice.doubleValue());
					listEntitledPricesRptDMDomainDTO.setTotalEntitledPrice(entitledDMPrice.doubleValue());
				}
				if(dmSize > 0) {
					listEntitledPricesRptCustomerDomainDTO.setTotalEntitledPrice(entitledPrice.doubleValue());
					listEntitledPricesRptCustomerDomainDTO.setTotalListPrice(listPrice.doubleValue());
				}
				totalListPrice = totalListPrice.add(listPrice);
				totalEntitledPrice = totalEntitledPrice.add(entitledPrice);	
			}
		}			
			
		
		listEntitledPricesRptDomainDTO.setTotalListPrice(totalListPrice.doubleValue());
		listEntitledPricesRptDomainDTO.setTotalEntitledPrice(totalEntitledPrice.doubleValue());

		return listEntitledPricesRptDomainDTO;
	}

	/**
	 *  Method to get the Deleted SWO's report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return DeletedSWORptDomainDTO
	 *	  
	 */

	public DeletedSWORptDomainDTO getDeletedSWORpt(String proposalID) throws DomainException {
		BigDecimal calculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal calculatedDMPrice = OPPTHelper.convertToBigDecimal(0.0);
		BigDecimal totalCalculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
				
		DeletedSWORptDomainDTO deletedSWORptDomainDTO = new DeletedSWORptDomainDTO();
		DeletedSWORptDMDomainDTO deletedSWORptDMDomainDTO = new DeletedSWORptDMDomainDTO();
		DeletedSWORptSWODomainDTO deletedSWORptSWODomainDTO = new DeletedSWORptSWODomainDTO();

		List deletedSWORptCustomerDomainDTOList;
		List deletedSWORptDMDomainDTOList=null,deletedSWORptSSDMDomainDTOList=null;
		List deletedSWORptSWODomainDTOList=null,deletedSWORptSSSWODomainDTOList=null;
		List deletedSWORptSWOEEDomainDTOList=null,deletedSWORptSSSWOEEDomainDTOList=null;

		deletedSWORptDomainDTO = ProposalDAO.retriveDataForDelSWORpt(proposalID);
		
		java.util.Date today = new java.util.Date();
		deletedSWORptDomainDTO.setRptPrintedDate(new Date(today.getTime()));
		
		/* Populate MLC DM's and SWO's */
		
		
		
		if(deletedSWORptDomainDTO.getProposalContent().equals("M") || deletedSWORptDomainDTO.getProposalContent().equals("A")) {
			
			DeletedSWORptCustomerDomainDTO deletedSWORptCustomerDomainDTO = new DeletedSWORptCustomerDomainDTO();
			deletedSWORptCustomerDomainDTOList = CustomerDAO.retriveDataForDelSWORpt(proposalID);
			deletedSWORptDomainDTO.setCustomerDomainDTOList(deletedSWORptCustomerDomainDTOList);
		
			for (int i = 0; i < deletedSWORptCustomerDomainDTOList.size(); i++) {
				calculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
						
				deletedSWORptCustomerDomainDTO = (DeletedSWORptCustomerDomainDTO) deletedSWORptCustomerDomainDTOList.get(i);
				deletedSWORptDMDomainDTOList = new ArrayList();
				deletedSWORptDMDomainDTOList = DMDAO.retriveDataForDelSWORpt(proposalID, deletedSWORptCustomerDomainDTO.getSoldToPartyID(),true);
				deletedSWORptCustomerDomainDTO.addDMDomainDTOList(deletedSWORptDMDomainDTOList);
				deletedSWORptCustomerDomainDTO.setDMDomainDTOList(deletedSWORptDMDomainDTOList);
				
		
				
				int dmSize = deletedSWORptCustomerDomainDTO.getDMDomainDTOList().size();

				for (int j = 0; j < dmSize; j++) {
					deletedSWORptDMDomainDTO = (DeletedSWORptDMDomainDTO) deletedSWORptCustomerDomainDTO.getDMDomainDTOList().get(j);
					deletedSWORptSWODomainDTOList = new ArrayList();
					deletedSWORptSWODomainDTOList = SWODAO.retriveDataForDelSWORpt(proposalID, deletedSWORptDMDomainDTO.getSoldToPartyID(), deletedSWORptDMDomainDTO.getDesgMcID(),true);
					deletedSWORptDMDomainDTO.addSWODomainDTOList(deletedSWORptSWODomainDTOList);
					deletedSWORptDMDomainDTO.setSWODomainDTOList(deletedSWORptSWODomainDTOList);
					calculatedDMPrice = OPPTHelper.convertToBigDecimal(0.0);
					
		
					
					for (int k = 0; k < deletedSWORptDMDomainDTO.getSWODomainDTOList().size(); k++) {
						deletedSWORptSWODomainDTO = (DeletedSWORptSWODomainDTO) deletedSWORptDMDomainDTO.getSWODomainDTOList().get(k);
					
						calculatedPrice = calculatedPrice.add(OPPTHelper.convertToBigDecimal(deletedSWORptSWODomainDTO.getCalculatedPrice()));
						calculatedDMPrice = calculatedDMPrice.add(OPPTHelper.convertToBigDecimal(deletedSWORptSWODomainDTO.getCalculatedPrice()));
						deletedSWORptSWOEEDomainDTOList = new ArrayList();
						deletedSWORptSWOEEDomainDTOList = SWOEEDAO.retriveDataForDelSWORpt(proposalID, deletedSWORptSWODomainDTO.getSoldToPartyID(), deletedSWORptSWODomainDTO.getDmID(), deletedSWORptSWODomainDTO.getSwoID());
						deletedSWORptSWODomainDTO.addSWOEEDomainDTOList(deletedSWORptSWOEEDomainDTOList);
					}
					deletedSWORptDMDomainDTO.setTotalCalculatedPrice(calculatedDMPrice.doubleValue());
				}
				if(dmSize > 0) {
					deletedSWORptCustomerDomainDTO.setTotalCalculatedPrice(calculatedPrice.doubleValue());
				}
				totalCalculatedPrice = totalCalculatedPrice.add(calculatedPrice);
			}
		}
		
		/* Populate S&S DM's and SWO's */
		
		if(deletedSWORptDomainDTO.getProposalContent().equals("S") || deletedSWORptDomainDTO.getProposalContent().equals("A")) {
			DeletedSWORptCustomerDomainDTO deletedSWORptCustomerDomainDTO = new DeletedSWORptCustomerDomainDTO();
			deletedSWORptCustomerDomainDTOList = CustomerDAO.retriveDataForDelSWORpt(proposalID);
			deletedSWORptDomainDTO.setSSCustomerDomainDTOList(deletedSWORptCustomerDomainDTOList);
		
			for (int i = 0; i < deletedSWORptCustomerDomainDTOList.size(); i++) {
				calculatedPrice = OPPTHelper.convertToBigDecimal(0.0);
						
				deletedSWORptCustomerDomainDTO = (DeletedSWORptCustomerDomainDTO) deletedSWORptCustomerDomainDTOList.get(i);
				deletedSWORptDMDomainDTOList = new ArrayList();
				deletedSWORptDMDomainDTOList = DMDAO.retriveDataForDelSWORpt(proposalID, deletedSWORptCustomerDomainDTO.getSoldToPartyID(),false);
				deletedSWORptCustomerDomainDTO.addSSDMDomainDTOList(deletedSWORptDMDomainDTOList);
				deletedSWORptCustomerDomainDTO.setSSDmDomainTO(deletedSWORptDMDomainDTOList);
				
		
				
				int dmSize = deletedSWORptCustomerDomainDTO.getSSDmDomainTO().size();

				for (int j = 0; j < dmSize; j++) {
					deletedSWORptDMDomainDTO = (DeletedSWORptDMDomainDTO) deletedSWORptCustomerDomainDTO.getSSDmDomainTO().get(j);
					deletedSWORptSWODomainDTOList = new ArrayList();
					deletedSWORptSWODomainDTOList = SWODAO.retriveDataForDelSWORpt(proposalID, deletedSWORptDMDomainDTO.getSoldToPartyID(), deletedSWORptDMDomainDTO.getDesgMcID(),false);
					deletedSWORptDMDomainDTO.addSSSWODomainDTOList(deletedSWORptSWODomainDTOList);
					deletedSWORptDMDomainDTO.setSSSWODomainDTOList(deletedSWORptSWODomainDTOList);
					calculatedDMPrice = OPPTHelper.convertToBigDecimal(0.0);
					
		
					
					for (int k = 0; k < deletedSWORptDMDomainDTO.getSSSWODomainDTOList().size(); k++) {
						deletedSWORptSWODomainDTO = (DeletedSWORptSWODomainDTO) deletedSWORptDMDomainDTO.getSSSWODomainDTOList().get(k);
					
						calculatedPrice = calculatedPrice.add(OPPTHelper.convertToBigDecimal(deletedSWORptSWODomainDTO.getCalculatedPrice()));
						calculatedDMPrice = calculatedDMPrice.add(OPPTHelper.convertToBigDecimal(deletedSWORptSWODomainDTO.getCalculatedPrice()));
						deletedSWORptSWOEEDomainDTOList = new ArrayList();
						deletedSWORptSWOEEDomainDTOList = SWOEEDAO.retriveDataForDelSWORpt(proposalID, deletedSWORptSWODomainDTO.getSoldToPartyID(), deletedSWORptSWODomainDTO.getDmID(), deletedSWORptSWODomainDTO.getSwoID());
						deletedSWORptSWODomainDTO.addSWOEEDomainDTOList(deletedSWORptSWOEEDomainDTOList);
					}
					deletedSWORptDMDomainDTO.setTotalCalculatedPrice(calculatedDMPrice.doubleValue());
				}
				if(dmSize > 0) {
					deletedSWORptCustomerDomainDTO.setTotalCalculatedPrice(calculatedPrice.doubleValue());
				}
				totalCalculatedPrice = totalCalculatedPrice.add(calculatedPrice);
			}
		}			

		deletedSWORptDomainDTO.setTotalCalculatedPrice(totalCalculatedPrice.doubleValue());
		return deletedSWORptDomainDTO;
	}
	/**
	 *  Method to get the Variance All report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return VarianceRptDomainDTO
	 *	  
	 */

	public VarianceRptDomainDTO getVarianceAllRpt(String proposalID) throws DomainException {
		
		VarianceRptDomainDTO varianceRptDomainDTO = new VarianceRptDomainDTO();
		VarianceRptCustomerDomainDTO varianceRptCustomerDomainDTO = new VarianceRptCustomerDomainDTO();
		VarianceRptDMDomainDTO varianceRptDMDomainDTO = new VarianceRptDMDomainDTO();
		VarianceRptSWODomainDTO varianceRptSWODomainDTO = new VarianceRptSWODomainDTO();
		VarianceRptSWOEEDomainDTO varianceRptSWOEEDomainDTO = new VarianceRptSWOEEDomainDTO();

		List varianceRptCustomerDomainDTOList;
		List varianceRptDMDomainDTOList;
		List varianceRptSWODomainDTOList;
		List varianceRptSWOEEDomainDTOList;
		List varianceRptPriceDomainDTOList;

		varianceRptDomainDTO = ProposalDAO.retriveDataForVarianceAllRpt(proposalID);
		varianceRptCustomerDomainDTOList = CustomerDAO.retriveDataForVarianceAllRp(proposalID);
		varianceRptDomainDTO.setCustomerDomainDTOList(varianceRptCustomerDomainDTOList);

		for (int i = 0; i < varianceRptCustomerDomainDTOList.size(); i++) {
			varianceRptCustomerDomainDTO = (VarianceRptCustomerDomainDTO) varianceRptCustomerDomainDTOList.get(i);
			varianceRptDMDomainDTOList = new ArrayList();
			varianceRptDMDomainDTOList = DMDAO.retriveDataForVarianceAllRpt(proposalID, varianceRptCustomerDomainDTO.getSoldToPartyID());
			varianceRptCustomerDomainDTO.addDMDomainDTOList(varianceRptDMDomainDTOList);
			varianceRptCustomerDomainDTO.setDMDomainDTOList(varianceRptDMDomainDTOList);

			for (int j = 0; j < varianceRptCustomerDomainDTO.getDMDomainDTOList().size(); j++) {
				varianceRptDMDomainDTO = (VarianceRptDMDomainDTO) varianceRptCustomerDomainDTO.getDMDomainDTOList().get(j);
				varianceRptSWODomainDTOList = new ArrayList();
				varianceRptSWODomainDTOList = SWODAO.retriveDataForVarianceAllRpt(proposalID, varianceRptCustomerDomainDTO.getSoldToPartyID(), varianceRptDMDomainDTO.getDesgMcID());
				varianceRptDMDomainDTO.addSWODomainDTOList(varianceRptSWODomainDTOList);
				varianceRptDMDomainDTO.setSWODomainDTOList(varianceRptSWODomainDTOList);

				for (int k = 0; k < varianceRptDMDomainDTO.getSWODomainDTOList().size(); k++) {
					varianceRptSWODomainDTO = (VarianceRptSWODomainDTO) varianceRptDMDomainDTO.getSWODomainDTOList().get(k);
					varianceRptSWOEEDomainDTOList = new ArrayList();
					varianceRptSWOEEDomainDTOList = SWOEEDAO.retriveDataForVarianceAllRpt(proposalID, varianceRptCustomerDomainDTO.getSoldToPartyID(), varianceRptDMDomainDTO.getDesgMcID(), varianceRptSWODomainDTO.getSwoID());
					varianceRptSWODomainDTO.addSWOEEDomainDTOList(varianceRptSWOEEDomainDTOList);
					varianceRptSWODomainDTO.setSWOEEDomainDTOList(varianceRptSWOEEDomainDTOList);
					
					for (int h = 0; h < varianceRptSWODomainDTO.getSWOEEDomainDTOList().size(); h++) {
						varianceRptSWOEEDomainDTO = (VarianceRptSWOEEDomainDTO) varianceRptSWODomainDTO.getSWOEEDomainDTOList().get(h);
						varianceRptPriceDomainDTOList = new ArrayList();
						varianceRptPriceDomainDTOList = PriceDAO.retriveDataForVarianceAllRp(proposalID, varianceRptCustomerDomainDTO.getSoldToPartyID(), varianceRptDMDomainDTO.getDesgMcID(), varianceRptSWODomainDTO.getSwoID(), varianceRptSWOEEDomainDTO.getSwoEEID());
						varianceRptSWOEEDomainDTO.addPriceDomainDTOList(varianceRptPriceDomainDTOList);
					}
				}
			}
		}
		return varianceRptDomainDTO;
	}
	/**
	 *  Method to get the Variance All report 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 9, 2003 
	 * 
	 * revision date author reason 
	 * </PRE><br> 
	 * 
	 * @param proposalID
	 * @return VarianceRptDomainDTO
	 *	  
	 */

	public VarianceRptDomainDTO getVariancePriceRpt(String proposalID) throws DomainException {
		double eswPrice1=0.0,eswPrice2=0.0;
		
		VarianceRptDomainDTO varianceRptDomainDTO = new VarianceRptDomainDTO();
		VarianceRptCustomerDomainDTO varianceRptCustomerDomainDTO = new VarianceRptCustomerDomainDTO();
		VarianceRptDMDomainDTO varianceRptDMDomainDTO = new VarianceRptDMDomainDTO();
		VarianceRptSWODomainDTO varianceRptSWODomainDTO = new VarianceRptSWODomainDTO();
		VarianceRptSWOEEDomainDTO varianceRptSWOEEDomainDTO = new VarianceRptSWOEEDomainDTO();

		List varianceRptCustomerDomainDTOList;
		List varianceRptDMDomainDTOList;
		List varianceRptSWODomainDTOList;
		List varianceRptSWOEEDomainDTOList;
		List varianceRptPriceDomainDTOList;

		varianceRptDomainDTO = ProposalDAO.retriveDataForVarianceAllRpt(proposalID);
		varianceRptCustomerDomainDTOList = CustomerDAO.retriveDataForVarianceAllRp(proposalID);
		varianceRptDomainDTO.setCustomerDomainDTOList(varianceRptCustomerDomainDTOList);

		for (int i = 0; i < varianceRptCustomerDomainDTOList.size(); i++) {
			varianceRptCustomerDomainDTO = (VarianceRptCustomerDomainDTO) varianceRptCustomerDomainDTOList.get(i);
			varianceRptDMDomainDTOList = new ArrayList();
			varianceRptDMDomainDTOList = DMDAO.retriveDataForVarianceAllRpt(proposalID, varianceRptCustomerDomainDTO.getSoldToPartyID());
			varianceRptCustomerDomainDTO.addDMDomainDTOList(varianceRptDMDomainDTOList);
			varianceRptCustomerDomainDTO.setDMDomainDTOList(varianceRptDMDomainDTOList);

			for (int j = 0; j < varianceRptCustomerDomainDTO.getDMDomainDTOList().size(); j++) {
				varianceRptDMDomainDTO = (VarianceRptDMDomainDTO) varianceRptCustomerDomainDTO.getDMDomainDTOList().get(j);
				varianceRptSWODomainDTOList = new ArrayList();
				varianceRptSWODomainDTOList = SWODAO.retriveDataForVarianceAllRpt(proposalID, varianceRptCustomerDomainDTO.getSoldToPartyID(), varianceRptDMDomainDTO.getDesgMcID());
				varianceRptDMDomainDTO.addSWODomainDTOList(varianceRptSWODomainDTOList);
				varianceRptDMDomainDTO.setSWODomainDTOList(varianceRptSWODomainDTOList);

				for (int k = 0; k < varianceRptDMDomainDTO.getSWODomainDTOList().size(); k++) {
					varianceRptSWODomainDTO = (VarianceRptSWODomainDTO) varianceRptDMDomainDTO.getSWODomainDTOList().get(k);
					varianceRptSWOEEDomainDTOList = new ArrayList();
					varianceRptSWOEEDomainDTOList = SWOEEDAO.retriveDataForVarianceAllRpt(proposalID, varianceRptCustomerDomainDTO.getSoldToPartyID(), varianceRptDMDomainDTO.getDesgMcID(), varianceRptSWODomainDTO.getSwoID());
					varianceRptSWODomainDTO.addSWOEEDomainDTOList(varianceRptSWOEEDomainDTOList);
					varianceRptSWODomainDTO.setSWOEEDomainDTOList(varianceRptSWOEEDomainDTOList);
					
					for (int h = 0; h < varianceRptSWODomainDTO.getSWOEEDomainDTOList().size(); h++) {
						varianceRptSWOEEDomainDTO = (VarianceRptSWOEEDomainDTO) varianceRptSWODomainDTO.getSWOEEDomainDTOList().get(h);
						varianceRptPriceDomainDTOList = new ArrayList();
						varianceRptPriceDomainDTOList = PriceDAO.retriveDataForVarianceAllRp(proposalID, varianceRptCustomerDomainDTO.getSoldToPartyID(), varianceRptDMDomainDTO.getDesgMcID(), varianceRptSWODomainDTO.getSwoID(), varianceRptSWOEEDomainDTO.getSwoEEID());
						int length = varianceRptPriceDomainDTOList.size();
						if(length > 1) {
							eswPrice1 = 0.00;
							eswPrice2 = 0.00;
							VarianceRptPriceDomainDTO varianceRptPriceDomainDTO = new VarianceRptPriceDomainDTO();
							
							for(int x = 0; x < length; x++) {
								varianceRptPriceDomainDTO = (VarianceRptPriceDomainDTO) varianceRptPriceDomainDTOList.get(x);
								eswPrice2 = varianceRptPriceDomainDTO.getESWPrice();
								if(x!=0) {
									if(eswPrice1 == eswPrice2) {
										varianceRptPriceDomainDTOList.remove(x);
										x--;
										length--;
									}
								}
								eswPrice1 = eswPrice2;
							}
						}
						varianceRptSWOEEDomainDTO.addPriceDomainDTOList(varianceRptPriceDomainDTOList);
					}
				}
			}
		}
	
		return varianceRptDomainDTO;
	}

	/** 
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
	 * @param proposalID
	 * @param oldProposalID
	 * @param contractNo
	 * @param oldContractNo
	 * @param compareTPReportCustomDTO
	 * @return 
	 */
	public CompareTPReportCustomDTO getCompareTPRpt(int proposalID, int oldProposalID, String contractNo, String oldContractNo, CompareTPReportCustomDTO compareTPReportCustomDTO) throws ServiceException {
		CompareTPRptDomainDTO reportDomainDTO = compareTPReportCustomDTO.getCompareTPRptDomainDTO();

		try {
			SWODAO dao = new SWODAO();
			reportDomainDTO = dao.getCompareTPRpt(proposalID, oldProposalID, reportDomainDTO);
		} catch (Exception e) {
			throw ExceptionGenerator.generateServiceException(ErrorCodeConstants.DE0801);
		}

		return compareTPReportCustomDTO;
	}
}

