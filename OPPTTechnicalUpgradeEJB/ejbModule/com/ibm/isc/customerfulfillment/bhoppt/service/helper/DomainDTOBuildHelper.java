/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.service.helper;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.*;
import com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.dto.customdto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * This helper class used to build domain dtos
 * Based on the values returned from back end 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 1, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Ravishankar J
 * @version 5.1A 
 */
public class DomainDTOBuildHelper {

	private static final String CLASS_NAME = "DomainDTOBuildHelper";
	/**
	 *  
	 * This method populate the Customer Domain DTO list from ProposalDomainDTO 
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
	 * @param proposalDomainDTO
	 * @return
	 */
	public static void populateProposalDomainDTO(ProposalDomainDTO proposalDomainDTO, ConnectorDTOInterface outputDTO, List selectedList, boolean option, int decimalAllowed, boolean fetch) {
		
		TimeTaken timeTaken = new TimeTaken(CLASS_NAME, "populateProposalDomainDTO");
		List list = null;
		populateCustomerDomainDTO(proposalDomainDTO);
		RetrieveInvenDetailOutputConnectorDTO invenDetailOutputConnectorDTO = null;
		RetrieveDeltaInventoryOutputConnectorDTO retrieveDeltaInventoryOutputConnectorDTO = null;
		CheckVarianceOutputConnectorDTO checkVarianceOutputConnectorDTO = null;
		if (outputDTO instanceof RetrieveInvenDetailOutputConnectorDTO) {
			invenDetailOutputConnectorDTO = (RetrieveInvenDetailOutputConnectorDTO) outputDTO;
			list = invenDetailOutputConnectorDTO.getSWOConnectorDTOList();
		} else if (outputDTO instanceof RetrieveDeltaInventoryOutputConnectorDTO) {
			retrieveDeltaInventoryOutputConnectorDTO = (RetrieveDeltaInventoryOutputConnectorDTO) outputDTO;
			list = retrieveDeltaInventoryOutputConnectorDTO.getSWOConnectorDTOList();

		} else if (outputDTO instanceof CheckVarianceOutputConnectorDTO) {
			checkVarianceOutputConnectorDTO = (CheckVarianceOutputConnectorDTO) outputDTO;
			list = checkVarianceOutputConnectorDTO.getSWOConnectorDTOList();
		}

		SWOConnectorDTO swoConnectorDTO;
		CustomerDomainDTO customerDomainDTO = null;

		Iterator iter = list.iterator();

		while (iter.hasNext()) {
			swoConnectorDTO = (SWOConnectorDTO) iter.next();

			if ((customerDomainDTO == null) || (customerDomainDTO.getSapCustomerNo().equals(swoConnectorDTO.getCustomerNumber()) == false)) {
				customerDomainDTO = getCustomer(proposalDomainDTO, swoConnectorDTO.getCustomerNumber());
			}

			populateDMDomainDTO(customerDomainDTO, swoConnectorDTO, outputDTO, selectedList, option, decimalAllowed, fetch);
		}
		timeTaken.end();
	}

	/**
	 *  
	 * This method populates the Customer domain dto from Connector dto 
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
	 * @param proposalDomainDTO
	 * @return
	 */
	private static CustomerDomainDTO getCustomer(ProposalDomainDTO proposalDomainDTO, String customerNumber) {
		List list = proposalDomainDTO.getCustomerDTOList();
		CustomerDomainDTO customerDomainDTO = null;
		if (list != null) {
			CustomerDomainDTO dto;
			for (int i = 0; i < list.size(); i++) {
				dto = (CustomerDomainDTO) list.get(i);

				if (customerNumber != null && customerNumber.equals(dto.getSapCustomerNo().trim())) {
					customerDomainDTO = dto;
					break;
				}
			}
		}

		return customerDomainDTO;
	}

	/**
	 *  
	 * This method populates the customer domain dtos 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param proposalDomainDTO
	 */
	private static void populateCustomerDomainDTO(ProposalDomainDTO proposalDomainDTO) {
		List list = proposalDomainDTO.getCustomerDTOList();
		if (list == null) {
			list = new ArrayList();
			proposalDomainDTO.setCustomerDTOList(list);
		}

		Iterator iter = list.iterator();
		CustomerDomainDTO customerDomainDTO;

		while (iter.hasNext()) {
			customerDomainDTO = (CustomerDomainDTO) iter.next();
			customerDomainDTO.setActionName(proposalDomainDTO.getActionName());

			if (customerDomainDTO != null) {
				if (customerDomainDTO.getPlanStartDate() == null)
					customerDomainDTO.setPlanStartDate((java.sql.Date) proposalDomainDTO.getContrStartPeriod());

				if (customerDomainDTO.getPlanEndDate() == null)
					customerDomainDTO.setPlanEndDate((java.sql.Date) proposalDomainDTO.getContrEndPeriod());
			}
		}
	}

	/**
	 *  
	 * This method populate dm domain dto from swo connecto dto 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param swoConnectorDTOList
	 * @return
	 */
	private static void populateDMDomainDTO(CustomerDomainDTO customerDomainDTO, SWOConnectorDTO swoConnectorDTO, ConnectorDTOInterface outputDTO, List selectedList, boolean option, int decimalAllowed, boolean fetch) {
		if (customerDomainDTO != null) {
			List dmList = customerDomainDTO.getDMDTOList();

			DMDomainDTO dmDomainDTO = null;

			if (dmList == null) {
				dmList = new ArrayList();
				customerDomainDTO.setDMDTOList(dmList);
			} else if (dmList.size() > 0) {
				dmDomainDTO = (DMDomainDTO) dmList.get(dmList.size() - 1);
			}

			boolean canAddDm = false;
			if ((dmDomainDTO == null) || (dmDomainDTO.getDmNo().equals(swoConnectorDTO.getDesignatedMachine()) == false)) {

				dmDomainDTO = new DMDomainDTO();
				dmDomainDTO.setActionName(customerDomainDTO.getActionName());

				dmDomainDTO.setDmNo(swoConnectorDTO.getDesignatedMachine());
				dmDomainDTO.setDmDesc(swoConnectorDTO.getDesigMachineDesc());
				dmDomainDTO.setPlanStartDate(customerDomainDTO.getPlanStartDate());
				dmDomainDTO.setPlanEndDate(customerDomainDTO.getPlanEndDate());

				dmDomainDTO.setCustomerId(customerDomainDTO.getCustomerId());
				dmDomainDTO.setProposalId(customerDomainDTO.getProposalId());
				canAddDm = true;

			}
			populateSWODomainDTO(dmDomainDTO, swoConnectorDTO, outputDTO, selectedList, option, decimalAllowed, fetch);
			if (ActionNameConstants.ADD_PLANNED_QUOTES.equals(dmDomainDTO.getActionName()) || ActionNameConstants.ADD_INELIGIBLE_LICENSES.equals(dmDomainDTO.getActionName())) {
				if (dmDomainDTO.getSWODTOList() != null && dmDomainDTO.getSWODTOList().size() == 0) {
					canAddDm = false;
				}
				if (dmDomainDTO.getSWODTOList() == null) {
					canAddDm = false;
				}
			}
			if (canAddDm) {
				dmList.add(dmDomainDTO);
			}
		}

	}

	/**
	 *  
	 * This method populates the swo domain dto from connector dto 
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
	 * @param swoConnectorDTOList
	 * @param dmDomainDTO
	 * @return
	 */

	private static void populateSWODomainDTO(DMDomainDTO dmDomainDTO, SWOConnectorDTO swoConnectorDTO, ConnectorDTOInterface outputDTO, List selectedList, boolean option, int decimalAllowed, boolean fetch) {
		String methodName="populateSWODomainDTO";
		if (dmDomainDTO != null) {
			SWODomainDTO swoDomainDTO = null;

			List list = dmDomainDTO.getSWODTOList();
						
			if (list == null) {
				list = new ArrayList();
				dmDomainDTO.setSwoDTOList(list);
			} else if (list.size() > 0) {
				if(selectedList == null || selectedList.size() == 0){
					swoDomainDTO = (SWODomainDTO) list.get(list.size() - 1);
				}
			}

			if (dmDomainDTO.getDmNo().equals(swoConnectorDTO.getDesignatedMachine())) {
				if (swoDomainDTO == null || (swoDomainDTO.getSalesDocNo().equals(swoConnectorDTO.getSalesDocumentNumber()) && swoDomainDTO.getSerialNo().equals(swoConnectorDTO.getSWOMaterialNumber())) == false) {
					if (selectedList == null || selectedList.size() == 0) {
						swoDomainDTO = new SWODomainDTO();
					}else if (selectedList.size() > 0 && selectedList.contains(swoConnectorDTO.getEquipmentNumber())) {
						OPPTLogger.debug("Equipment No--B4 build"+swoConnectorDTO.getEquipmentNumber(),CLASS_NAME,methodName);
						swoDomainDTO = new SWODomainDTO();
					}else if (selectedList.size() > 0 && selectedList.contains(swoConnectorDTO.getSalesDocumentNumber())) {
						OPPTLogger.debug("Sales Doc No--B4 build"+swoConnectorDTO.getSalesDocumentNumber(),CLASS_NAME,methodName);
						swoDomainDTO = new SWODomainDTO();
					} else if(selectedList.size() > 0 && selectedList.contains(swoConnectorDTO.getKey())) {
						OPPTLogger.debug("Key--B4 build"+swoConnectorDTO.getKey(),CLASS_NAME,methodName);
						swoDomainDTO = new SWODomainDTO();
					}
			}
			if (swoDomainDTO != null) {
					swoDomainDTO.setSalesDocNo(swoConnectorDTO.getSalesDocumentNumber());
					swoDomainDTO.setSwoItemNo(swoConnectorDTO.getSWOItemPositionNumber());
					swoDomainDTO.setItemCategory(swoConnectorDTO.getSalesDocumentCategory());
					if(swoConnectorDTO.getRequestDeliveryDate()!=null){
						swoDomainDTO.setRequestDeliveryDate((Date) swoConnectorDTO.getRequestDeliveryDate());	
					}
					swoDomainDTO.setCustomerPoNo(swoConnectorDTO.getCustomerPurchaseOrderNumber());
					swoDomainDTO.setSwoNo(swoConnectorDTO.getSWOMaterialNumber());
					swoDomainDTO.setSwoDesc(swoConnectorDTO.getSWODesc());
					swoDomainDTO.setSerialNo(swoConnectorDTO.getSWOSerialNumber());
					swoDomainDTO.setReferenceSerialNo(swoConnectorDTO.getReferenceSerialNumber());
					swoDomainDTO.setReferenceSerialNoDM(swoConnectorDTO.getReferenceDesignatedMachine());
					swoDomainDTO.setEquipmentNo(swoConnectorDTO.getEquipmentNumber());
					swoDomainDTO.setSwoExtContrNo(swoConnectorDTO.getSWOExternalContractNumber());
					swoDomainDTO.setSwoContrType(swoConnectorDTO.getSWOContractType());
					swoDomainDTO.setSwoContrStatus(swoConnectorDTO.getSWOContractStatus());
					swoDomainDTO.setIneligFlag(swoConnectorDTO.getIneligibleFlag());
					swoDomainDTO.setComments(swoConnectorDTO.getIneligibilityComment());
					if( swoConnectorDTO.getLicenseEffectiveDate()!=null){
						swoDomainDTO.setLicenseEffectiveDate((Date) swoConnectorDTO.getLicenseEffectiveDate());
					}
					swoDomainDTO.setPlanStartDate(dmDomainDTO.getPlanStartDate());
					swoDomainDTO.setPlanEndDate(dmDomainDTO.getPlanEndDate());
					swoDomainDTO.setPlanDateInd(UtilityConstants.YES);
					if (option) {
						swoDomainDTO.setDeltaFetchId(LicenseConstants.LICENSE_DELTAFETCH);
						swoDomainDTO.setSkipOption(UtilityConstants.YES);
					} else {
						swoDomainDTO.setSkipOption(UtilityConstants.NO);
					}
					if (!fetch) {
						swoDomainDTO.setRefetchId(LicenseConstants.LICENSE_REFETCHED);
					}
					swoDomainDTO.setProposalId(dmDomainDTO.getProposalId());
					swoDomainDTO.setCustomerId(dmDomainDTO.getCustomerId());
					swoDomainDTO.setDmId(dmDomainDTO.getDmId());
					if ((null != swoConnectorDTO.getSAndSIndicator()) && (OPPTHelper.trimString(swoConnectorDTO.getSAndSIndicator())).length() != 0) {
						swoDomainDTO.setSAndSInd(swoConnectorDTO.getSAndSIndicator());
					} else {
						swoDomainDTO.setSAndSInd(null);
					}

					list.add(swoDomainDTO);

					populateEEDomainDTO(swoDomainDTO, outputDTO, decimalAllowed);
				}
			}
		}
	}

	/**
	 *  
	 * This method populate the ee domain dto from ee connector dto 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param eeConnectorDTOList
	 * @return
	 */
	private static void populateEEDomainDTO(SWODomainDTO swoDomainDTO, ConnectorDTOInterface outputDTO, int decimalAllowed) {
		List list = swoDomainDTO.getEEDTOList();
		List eeConnectorList = null;
		if (list == null) {
			list = new ArrayList();
			swoDomainDTO.setEEDTOList(list);
		}
		RetrieveInvenDetailOutputConnectorDTO invenDetailOutputConnectorDTO = null;
		RetrieveDeltaInventoryOutputConnectorDTO retrieveDeltaInventoryOutputConnectorDTO = null;
		CheckVarianceOutputConnectorDTO checkVarianceOutputConnectorDTO = null;
		if (outputDTO instanceof RetrieveInvenDetailOutputConnectorDTO) {
			invenDetailOutputConnectorDTO = (RetrieveInvenDetailOutputConnectorDTO) outputDTO;
			eeConnectorList = invenDetailOutputConnectorDTO.getEEConnectorDTOList();
		} else if (outputDTO instanceof RetrieveDeltaInventoryOutputConnectorDTO) {
			retrieveDeltaInventoryOutputConnectorDTO = (RetrieveDeltaInventoryOutputConnectorDTO) outputDTO;
			eeConnectorList = retrieveDeltaInventoryOutputConnectorDTO.getEEConnectorDTOList();
		} else if (outputDTO instanceof CheckVarianceOutputConnectorDTO) {
			checkVarianceOutputConnectorDTO = (CheckVarianceOutputConnectorDTO) outputDTO;
			eeConnectorList = checkVarianceOutputConnectorDTO.getEEConnectorDTOList();
		}

		Iterator iter = eeConnectorList.iterator();

		EEConnectorDTO eeConnectorDTO;
		String salesDocNo = swoDomainDTO.getSalesDocNo();
		String itemNo = swoDomainDTO.getSwoItemNo();

		while (iter.hasNext()) {
			eeConnectorDTO = (EEConnectorDTO) iter.next();

			if (salesDocNo.equals(eeConnectorDTO.getSalesDocumentNumber()) && itemNo.equals(eeConnectorDTO.getSWOItemPositionNumber())) {
				EEDomainDTO eeDomainDTO = new EEDomainDTO();
				eeDomainDTO.setSalesDocNo(eeConnectorDTO.getSalesDocumentNumber());
				eeDomainDTO.setEeItemNo(eeConnectorDTO.getEEItemPositionNumber());
				eeDomainDTO.setSwoItemNo(eeConnectorDTO.getSWOItemPositionNumber());
				eeDomainDTO.setValueMetric(eeConnectorDTO.getValueMetric());
				eeDomainDTO.setUseLevel(eeConnectorDTO.getUseLevel());
				eeDomainDTO.setLicenseType(eeConnectorDTO.getLicenseType());
				//add material no
				eeDomainDTO.setEeNo(eeConnectorDTO.getEEMaterialNumber());
				eeDomainDTO.setEeDesc(eeConnectorDTO.getDescriptionOfEEMaterial());
				eeDomainDTO.setChargeOptionDesc(eeConnectorDTO.getChargeOption());
				eeDomainDTO.setListPrice(convertToPrice(eeConnectorDTO.getFirstMonthListPrice(), decimalAllowed));
				eeDomainDTO.setPletNo(eeConnectorDTO.getPLETNo());
				eeDomainDTO.setPlanStartDate(swoDomainDTO.getPlanStartDate());
				eeDomainDTO.setPlanEndDate(swoDomainDTO.getPlanEndDate());

				eeDomainDTO.setProposalId(swoDomainDTO.getProposalId());
				eeDomainDTO.setCustomerId(swoDomainDTO.getCustomerId());
				eeDomainDTO.setDmId(swoDomainDTO.getDmId());
				eeDomainDTO.setSwoId(swoDomainDTO.getSwoId());
				list.add(eeDomainDTO);

				populatePriceDomainDTO(eeDomainDTO, outputDTO, decimalAllowed,swoDomainDTO);
			}
		}
	}

	/**
	 *  
	 * This method populate price domain dto from price connector dto 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param priceConnectorDTOList
	 * @return
	 */
	private static void populatePriceDomainDTO(EEDomainDTO eeDomainDTO, ConnectorDTOInterface outputDTO, int decimalAllowed,SWODomainDTO swoDomainDTO) {
		String methodName="populatePriceDomainDTO";
		List list = null;
		list = eeDomainDTO.getPriceDTOList();
	
		if (list == null) {
			list = new ArrayList();
			eeDomainDTO.setPriceDTOList(list);
		}
			 
		RetrieveInvenDetailOutputConnectorDTO invenDetailOutputConnectorDTO = null;
		RetrieveDeltaInventoryOutputConnectorDTO retrieveDeltaInventoryOutputConnectorDTO = null;
		CheckVarianceOutputConnectorDTO checkVarianceOutputConnectorDTO = null;
		List priceList = null;
		Date tempPlanStartDate=null;
		Date tempPlanEndDate=null;
		Date minPlanStartDate=null;
		Date maxPlanEndDate=null;
		OPPTCalender calendar=new OPPTCalender();
	
		if (outputDTO instanceof RetrieveInvenDetailOutputConnectorDTO) {
			invenDetailOutputConnectorDTO = (RetrieveInvenDetailOutputConnectorDTO) outputDTO;
			priceList = invenDetailOutputConnectorDTO.getPriceConnectorDTOList();
		} else if (outputDTO instanceof RetrieveDeltaInventoryOutputConnectorDTO) {
			retrieveDeltaInventoryOutputConnectorDTO = (RetrieveDeltaInventoryOutputConnectorDTO) outputDTO;
			priceList = retrieveDeltaInventoryOutputConnectorDTO.getPriceConnectorDTOList();
		} else if (outputDTO instanceof CheckVarianceOutputConnectorDTO) {
			checkVarianceOutputConnectorDTO = (CheckVarianceOutputConnectorDTO) outputDTO;
			priceList = checkVarianceOutputConnectorDTO.getPriceConnectorDTOList();
		}
	
		if (priceList != null && priceList.size() > 0) {
			Iterator iter = priceList.iterator();
	
			String salesDocNo = eeDomainDTO.getSalesDocNo();
			String itemPositionNo = eeDomainDTO.getEeItemNo();
	
			PriceConnectorDTO priceConnectorDTO = null;
	
			while (iter.hasNext()) {
				priceConnectorDTO = (PriceConnectorDTO) iter.next();
	
				if (priceConnectorDTO != null && (salesDocNo.equals(priceConnectorDTO.getSalesDocumentNumber())) && (itemPositionNo.equals(priceConnectorDTO.getEEItemPositionNo()))) {
					PriceDomainDTO priceDomainDTO = new PriceDomainDTO();
					priceDomainDTO.setSalesDocNo(priceConnectorDTO.getSalesDocumentNumber());
					priceDomainDTO.setEeItemNo(priceConnectorDTO.getEEItemPositionNo());
					priceDomainDTO.setBillPlanEndDate((java.sql.Date) priceConnectorDTO.getBillingEndDate());
					priceDomainDTO.setEswPrice(convertToPrice(priceConnectorDTO.getESWPrice(), decimalAllowed));
					priceDomainDTO.setCurrency(priceConnectorDTO.getCurrency());
					priceDomainDTO.setProposalId(eeDomainDTO.getProposalId());
					priceDomainDTO.setCustomerId(eeDomainDTO.getCustomerId());
					priceDomainDTO.setDmId(eeDomainDTO.getDmId());
					priceDomainDTO.setSwoId(eeDomainDTO.getSwoId());
					priceDomainDTO.setEeId(eeDomainDTO.getEeId());
					if ("C".equals(priceConnectorDTO.getBillingStatus())) {
						priceDomainDTO.setBillPlanStartDate(OPPTCalender.getDayPlusOneSqlDate(priceConnectorDTO.getBillingStartDate()));
					} else {
						priceDomainDTO.setBillPlanStartDate((java.sql.Date) priceConnectorDTO.getBillingStartDate());
					}
					if(priceDomainDTO.getBillPlanStartDate()!=null && tempPlanStartDate == null ){
						tempPlanStartDate=priceDomainDTO.getBillPlanStartDate();
					}
					if(priceDomainDTO.getBillPlanEndDate()!=null && tempPlanEndDate==null){
						tempPlanEndDate=priceDomainDTO.getBillPlanEndDate();
					}
						
					if(priceDomainDTO.getBillPlanStartDate()!=null){
						if(calendar.isDateLesser(priceDomainDTO.getBillPlanStartDate(),tempPlanStartDate)){
							minPlanStartDate=priceDomainDTO.getBillPlanStartDate();	
						}else{
							minPlanStartDate=tempPlanStartDate;
						}
					}
						
					if(priceDomainDTO.getBillPlanEndDate()!=null){
						if(calendar.isDateGreater(priceDomainDTO.getBillPlanEndDate(),tempPlanEndDate)){
							maxPlanEndDate=priceDomainDTO.getBillPlanEndDate();	
						}else{
							maxPlanEndDate=tempPlanEndDate;
						}
					}
					priceDomainDTO.setBillingStatus(priceConnectorDTO.getBillingStatus());
	
					list.add(priceDomainDTO);
	
				}
			}
		}
		if (minPlanStartDate!= null) {
				if (calendar.isDateGreater(minPlanStartDate, swoDomainDTO.getPlanStartDate())) {
					swoDomainDTO.setPlanStartDate(minPlanStartDate);
					swoDomainDTO.setPlanDateInd(UtilityConstants.NO);
				}
		} else {
			swoDomainDTO.setPlanDateInd(UtilityConstants.YES);
		}
		if (maxPlanEndDate != null) {
				if (calendar.isDateLesser(maxPlanEndDate, swoDomainDTO.getPlanEndDate())) {
					swoDomainDTO.setPlanEndDate(maxPlanEndDate);
					swoDomainDTO.setPlanDateInd(UtilityConstants.NO);
				}
		} else {
			swoDomainDTO.setPlanDateInd(UtilityConstants.YES);
		}
	   			
	 }

	/**
	 *  
	 * This method validates the plan dates returned from back end 
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
	 * @param proposalDomainDTO
	 * @return
	 * @throws ServiceException
	 */
	public static void validatePlanDates(DMDomainDTO dmDomainDTO) {
		String methodName = "validatePlanDates";
		List swoDomainDTOList = null;
		List eeDomainDTOList = null;
		List priceDomainDTOList = null;
		SWODomainDTO swoDomainDTO = null;
		EEDomainDTO eeDomainDTO = null;
		PriceDomainDTO priceDomainDTO = null;
		OPPTCalender calendar = new OPPTCalender();

			swoDomainDTOList = dmDomainDTO.getSWODTOList();
				if (swoDomainDTOList != null && swoDomainDTOList.size() > 0) {
					for (int k = 0; k < swoDomainDTOList.size(); k++) {
						swoDomainDTO = (SWODomainDTO) swoDomainDTOList.get(k);
						Date planStartDate = null;
						Date planEndDate = null;
						eeDomainDTOList = swoDomainDTO.getEEDTOList();
						if (eeDomainDTOList != null && eeDomainDTOList.size() > 0) {
							for (int l = 0; l < eeDomainDTOList.size(); l++) {
								eeDomainDTO = (EEDomainDTO) eeDomainDTOList.get(l);
								priceDomainDTOList = eeDomainDTO.getPriceDTOList();
								if (priceDomainDTOList != null && priceDomainDTOList.size() > 0) {
									for (int m = 0; m < priceDomainDTOList.size(); m++) {
										priceDomainDTO = priceDomainDTO = (PriceDomainDTO) priceDomainDTOList.get(m);
										if (m == 0) {
											planStartDate = priceDomainDTO.getBillPlanStartDate();
										}
										if (m == (priceDomainDTOList.size() - 1)) {
											planEndDate = priceDomainDTO.getBillPlanEndDate();
										}
									}
								}
						
							}
						}
						if (planStartDate != null) {
							if (calendar.isDateGreater(planStartDate, swoDomainDTO.getPlanStartDate())) {
								swoDomainDTO.setPlanStartDate(planStartDate);
								swoDomainDTO.setPlanDateInd(UtilityConstants.NO);
							}
						} else {
							swoDomainDTO.setPlanDateInd(UtilityConstants.YES);
						}
						if (planEndDate != null) {
							if (calendar.isDateLesser(planEndDate, swoDomainDTO.getPlanEndDate())) {
								swoDomainDTO.setPlanEndDate(planEndDate);
								swoDomainDTO.setPlanDateInd(UtilityConstants.NO);
							}
						} else {
							swoDomainDTO.setPlanDateInd(UtilityConstants.YES);
						}
					}
				}
			
		}
	/**
	 *  
	 * This method builds the DMDomainDTO using Configure DM Custom dto
	 * and PriceInquiryConnector dto 
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
	 * @param configureDMCustomDTO
	 * @param priceInquiryOutputConnectorDTO
	 * @return
	 */
	public static DMDomainDTO buildDMDomainDTOFromConfigureDMCustomDTO(ConfigureDMCustomDTO configureDMCustomDTO, PriceInquiryOutputConnectorDTO priceInquiryOutputConnectorDTO,int decimalValue) {
		String methodName="buildDMDomainDTOFromConfigureDMCustomDTO";
		DMDomainDTO dmDomainDTO = null;
		ConfigureDMSWOCustomDTO configureDMSWOCustomDTO = null;
		ConfigureDMEECustomDTO configureDMEECustomDTO = null;
		SWODomainDTO swoDomainDTO = null;
		EEDomainDTO eeDomainDTO = null;
		List swoDTOList = null;
		List eeDTOList = null;
		dmDomainDTO = new DMDomainDTO();
		swoDTOList = new ArrayList();
		dmDomainDTO.setDmId(Integer.parseInt(configureDMCustomDTO.getId()));
		dmDomainDTO.setCustomerId(Integer.parseInt(configureDMCustomDTO.getCustomerId()));
		dmDomainDTO.setProposalId(configureDMCustomDTO.getProposalId());
		OPPTLogger.debug("DM Bump start date"+configureDMCustomDTO.getBumpPlanStartDate(),CLASS_NAME,methodName);
		dmDomainDTO.setPlanStartDate(new Date(configureDMCustomDTO.getBumpPlanStartDate().getTime()));
		dmDomainDTO.setPlanEndDate(new Date(configureDMCustomDTO.getBumpPlanEndDate().getTime()));

		for (int i = 0; i < configureDMCustomDTO.getSwos().size(); i++) {

			configureDMSWOCustomDTO = (ConfigureDMSWOCustomDTO) configureDMCustomDTO.getSwos().get(i);
			swoDomainDTO = new SWODomainDTO();
			swoDomainDTO.setSwoId(Integer.parseInt(configureDMSWOCustomDTO.getId()));
			swoDomainDTO.setProposalId(dmDomainDTO.getProposalId());
			swoDomainDTO.setCustomerId(dmDomainDTO.getCustomerId());
			swoDomainDTO.setDmId(dmDomainDTO.getDmId());
			swoDomainDTO.setPlanStartDate(dmDomainDTO.getPlanStartDate());
			swoDomainDTO.setPlanEndDate(dmDomainDTO.getPlanEndDate());
			swoDTOList.add(swoDomainDTO);
			eeDTOList = new ArrayList();

			for (int j = 0; j < configureDMSWOCustomDTO.getEes().size(); j++) {

				configureDMEECustomDTO = (ConfigureDMEECustomDTO) configureDMSWOCustomDTO.getEes().get(j);
				if (!configureDMEECustomDTO.isInvalidEE()) {
					eeDomainDTO = new EEDomainDTO();
					eeDomainDTO.setEeId(Integer.parseInt(configureDMEECustomDTO.getId()));
					eeDomainDTO.setSwoId(swoDomainDTO.getSwoId());
					eeDomainDTO.setDmId(swoDomainDTO.getDmId());
					eeDomainDTO.setCustomerId(swoDomainDTO.getCustomerId());
					eeDomainDTO.setProposalId(swoDomainDTO.getProposalId());
					eeDomainDTO.setPlanStartDate(swoDomainDTO.getPlanStartDate());
					eeDomainDTO.setPlanEndDate(swoDomainDTO.getPlanEndDate());
					eeDomainDTO.setSalesDocNo(configureDMEECustomDTO.getSalesDocNumber());
					eeDomainDTO.setEeItemNo(configureDMEECustomDTO.getEeItemNumber());

					populateEEDomainDTOWithPrice(swoDomainDTO,eeDomainDTO, priceInquiryOutputConnectorDTO,decimalValue);

					eeDTOList.add(eeDomainDTO);
					swoDomainDTO.setEEDTOList(eeDTOList);
				}
			}
			dmDomainDTO.setSwoDTOList(swoDTOList);
			validatePlanDates(dmDomainDTO);
		}

		return dmDomainDTO;
	}

	/**
	 *  
	 * This method sets the Pricing information for the corresponding ees 
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
	 * @param eeDomainDTO
	 * @param priceInquiryOutputConnectorDTO
	 */
	private static void populateEEDomainDTOWithPrice(SWODomainDTO swoDomainDTO,EEDomainDTO eeDomainDTO, PriceInquiryOutputConnectorDTO priceInquiryOutputConnectorDTO,int decimalValue) {
		PriceInquiryConnectorDTO priceInquiryConnectorDTO = null;
		PriceDomainDTO priceDomainDTO = null;
		List priceDomainDTOList = new ArrayList();
		for (int i = 0; i < priceInquiryOutputConnectorDTO.getPriceInquiryConnectorDTOList().size(); i++) {
			priceInquiryConnectorDTO = (PriceInquiryConnectorDTO) priceInquiryOutputConnectorDTO.getPriceInquiryConnectorDTOList().get(i);
			if (eeDomainDTO.getSalesDocNo().equals(priceInquiryConnectorDTO.getSalesDocNo()) && eeDomainDTO.getEeItemNo().equals(priceInquiryConnectorDTO.getEeItemNo())) {
				priceDomainDTO = new PriceDomainDTO();
				priceDomainDTO.setProposalId(eeDomainDTO.getProposalId());
				priceDomainDTO.setCustomerId(eeDomainDTO.getCustomerId());
				priceDomainDTO.setDmId(eeDomainDTO.getDmId());
				priceDomainDTO.setSwoId(eeDomainDTO.getSwoId());
				priceDomainDTO.setEeId(eeDomainDTO.getEeId());
				priceDomainDTO.setCurrency(priceInquiryConnectorDTO.getCurrency());
				if(priceInquiryConnectorDTO.getBillPlanStartDte()!=null){
					priceDomainDTO.setBillPlanStartDate(new Date(priceInquiryConnectorDTO.getBillPlanStartDte().getTime()));
				}else{
					priceDomainDTO.setBillPlanStartDate(eeDomainDTO.getPlanStartDate());
				}
				if(priceInquiryConnectorDTO.getBillPlanEndDte()!=null){
					priceDomainDTO.setBillPlanEndDate(new Date(priceInquiryConnectorDTO.getBillPlanEndDte().getTime()));	
				}else{
					priceDomainDTO.setBillPlanEndDate(eeDomainDTO.getPlanEndDate());
				}
				priceDomainDTO.setEswPrice(convertToPrice(priceInquiryConnectorDTO.getPrice(),decimalValue));
				priceDomainDTOList.add(priceDomainDTO);
			}
			eeDomainDTO.setPriceDTOList(priceDomainDTOList);
		}
	}

	/**
	 *  
	 * This method converts the Pricing information based on the currency and decimal allowed
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
	 * @param value
	 * @param decimalAllowed
	 */
	/*
	public static double convertToPrice(double value, int decimalAllowed) {
		double price = 0.0;
		int orgPrice = (int) value;
		String priceString = null;
		priceString = Integer.toString(orgPrice);
		int length = priceString.length();
		if (length > decimalAllowed) {
			priceString = priceString.substring(0, length - decimalAllowed) + "." + priceString.substring(length - decimalAllowed);
			price = Double.parseDouble(priceString);
		}
		return price;
	}
	*/
	/** 
	 * convertToPrice
	 * Build SWO Domain DTO from custom
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
	 * @param value
	 * @param decimalAllowed
	 * @return double
	 */
	 
	public static double convertToPrice(double value, int decimalAllowed) {
		double price = 0.0;
		BigDecimal orgPrice = OPPTHelper.convertToBigDecimal(value);
		BigDecimal divider = OPPTHelper.convertToBigDecimal(1);
		BigDecimal ten = OPPTHelper.convertToBigDecimal(10);
		for (int i=0;i<decimalAllowed;i++) {
			divider = divider.multiply(ten);
		}
		orgPrice = orgPrice.divide(divider,decimalAllowed,BigDecimal.ROUND_DOWN);
		return orgPrice.doubleValue();
	}
	
	/** 
	 * Builds a DomainDTOs from CustomDTO
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
	 * @param customCustomers
	 * @param transactionName
	 * @return CustomerDomainDTO[]
	 */
	public static CustomerDomainDTO[] buildCustomerDomainDTOsWithIDFromCustomDTO(ProposalCustomerCustomDTO[] customCustomers, String transactionName) {
		CustomerDomainDTO[] customers = null;
		if (customCustomers != null && customCustomers.length > 0) {
			int arrayLength = customCustomers.length;
			customers = new CustomerDomainDTO[arrayLength];
			for (int i = 0; i < arrayLength; i++) {
				customers[i] = buildCustomerDomainDTOWithOnlyID(customCustomers[i].getProposalId(), customCustomers[i].getCustomerId(), transactionName);
			}
		}
		return customers;
	}

	/** 
	 * Builds a DomainDTOs from CustomDTO
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
	 * @param customMachines
	 * @param transactionName
	 * @return DMDomainDTO[]
	 */
	public static DMDomainDTO[] buildDMDomainDTOsWithIDFromCustomDTO(DMCustomDTO[] customMachines, String transactionName) {
		DMDomainDTO[] machines = null;
		if (customMachines != null && customMachines.length > 0) {
			int arrayLength = customMachines.length;
			machines = new DMDomainDTO[arrayLength];
			for (int i = 0; i < arrayLength; i++) {
				machines[i] = buildDMDomainDTOWithOnlyID(customMachines[i].getProposalId(), customMachines[i].getCustomerId(), customMachines[i].getId(), transactionName);
			}
		}
		return machines;
	}

	/** 
	 * Builds a DomainDTOs from CustomDTO
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
	 * @param customLicenses
	 * @param transactionName
	 * @return SWODomainDTO[]
	 */
	public static SWODomainDTO[] buildSWODomainDTOsWithIDFromCustomDTO(SWOCustomDTO[] customLicenses, String transactionName) {
		SWODomainDTO[] licenses = null;
		if (customLicenses != null && customLicenses.length > 0) {
			int arrayLength = customLicenses.length;
			licenses = new SWODomainDTO[arrayLength];
			for (int i = 0; i < arrayLength; i++) {
				licenses[i] = buildSWODomainDTOWithOnlyID(customLicenses[i].getProposalId(), customLicenses[i].getCustomerId(), customLicenses[i].getDMId(), customLicenses[i].getId(), transactionName);
			}
		}
		return licenses;
	}

	/** 
	 * Builds a DomainDTOs from CustomDTO
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
	 * @param customLicense
	 * @param customEEs
	 * @param transactionName
	 * @return EEDomainDTO[]
	 */
	public static EEDomainDTO[] buildEEDomainDTOsFromCustomDTO(SWOCustomDTO customLicense, EECustomDTO[] customEEs, String transactionName) {
		EEDomainDTO[] domainEEs = null;
		if (customEEs != null && customEEs.length > 0) {
			int arrayLength = customEEs.length;
			domainEEs = new EEDomainDTO[arrayLength];
			for (int i = 0; i < arrayLength; i++) {
				domainEEs[i] = buildEEDomainDTO(customLicense, customEEs[i], transactionName);
			}
		}
		return domainEEs;
	}

	/** 
	 * Builds a DomainDTOs from CustomDTO
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
	 * @param customLicense
	 * @param customEEs
	 * @param transactionName
	 * @return List
	 */
	public static List buildEEDomainDTOsFromCustomDTO(SWOCustomDTO customLicense, TreeMap customEEs, String transactionName) {
		List domainEEs = null;
		EEDomainDTO eeDomain = null;
		if (customEEs != null && customEEs.size() > 0) {
			int arrayLength = customEEs.size();
			domainEEs = new ArrayList();
			Iterator values = customEEs.values().iterator();
			for (int i = 0; i < arrayLength; i++) {
				eeDomain = buildEEDomainDTO(customLicense, (EECustomDTO) values.next(), transactionName);
				domainEEs.add(eeDomain);
			}
		}
		return domainEEs;
	}

	/** 
	 * Builds CustomerDomainDTO with only identifiers and transaction name
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
	 * @param propID
	 * @param custID
	 * @param transactionName
	 * @return CustomerDomainDTO
	 */
	public static CustomerDomainDTO buildCustomerDomainDTOWithOnlyID(int propID, int custID, String transactionName) {
		CustomerDomainDTO customer = new CustomerDomainDTO();
		customer.setActionName(transactionName);
		customer.setCustomerId(custID);
		customer.setProposalId(propID);
		return customer;
	}

	/** 
	 * Builds CustomerDomainDTO with only identifiers and transaction name
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
	 * @param propID
	 * @param custID
	 * @param transactionName
	 * @return CustomerDomainDTO
	 */
	public static CustomerDomainDTO buildCustomerDomainDTOWithOnlyID(int propID, String custID, String transactionName) {
		CustomerDomainDTO customer = new CustomerDomainDTO();
		customer.setActionName(transactionName);
		customer.setCustomerId(Integer.valueOf(custID).intValue());
		customer.setProposalId(propID);
		return customer;
	}

	/** 
	 * Builds DMDomainDTO with only identifiers and transaction name
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
	 * @param propID
	 * @param custID
	 * @param machID
	 * @param transactionName
	 * @return DMDomainDTO
	 */
	public static DMDomainDTO buildDMDomainDTOWithOnlyID(int propID, String custID, String machID, String transactionName) {
		DMDomainDTO machine = new DMDomainDTO();
		machine.setActionName(transactionName);
		machine.setProposalId(propID);
		machine.setCustomerId(Integer.valueOf(custID).intValue());
		machine.setDmId(Integer.valueOf(machID).intValue());
		return machine;
	}

	/** 
	 * Builds SWODomainDTO with only identifiers and transaction name
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
	 * @param propID
	 * @param custID
	 * @param machID
	 * @param swoID
	 * @param transactionName
	 * @return SWODomainDTO
	 */
	public static SWODomainDTO buildSWODomainDTOWithOnlyID(int propID, String custID, String machID, String swoID, String transactionName) {
		SWODomainDTO license = new SWODomainDTO();
		license.setActionName(transactionName);
		license.setProposalId(propID);
		license.setCustomerId(Integer.valueOf(custID).intValue());
		license.setDmId(Integer.valueOf(machID).intValue());
		license.setSwoId(Integer.valueOf(swoID).intValue());
		return license;
	}

	/** 
	 * Builds EEDomainDTO with only identifiers and transaction name
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
	 * @param customLicense
	 * @param customEE
	 * @param transactionName
	 * @return EEDomainDTO
	 */
	public static EEDomainDTO buildEEDomainDTO(SWOCustomDTO customLicense, EECustomDTO customEE, String transactionName) {
		EEDomainDTO domainEE = new EEDomainDTO();
		SWODomainDTO domainSwo = new SWODomainDTO();
		
		domainEE.setActionName(transactionName);
		domainEE.setEeId(Integer.parseInt(customEE.getId()));
		domainEE.setProposalId(customLicense.getProposalId());
		domainEE.setCustomerId(Integer.parseInt(customLicense.getCustomerId()));
		domainEE.setDmId(Integer.parseInt(customLicense.getDMId()));
		domainEE.setSwoId(Integer.parseInt(customLicense.getId()));
		//System.out.println("DomainDTOBuildHelper.buildEEDomainDTO()"+customEE.getAlternatePrice());
		domainSwo.setAlternatePrice(customEE.getAlternatePrice());
		domainEE.setAlternatePrice(customEE.getAlternatePrice());
		//System.out.println("DomainDTOBuildHelper.buildEEDomainDTO():getAlternatePriceUpdateInd():"+domainEE.getAlternatePrice());
		// S and s changes starts
		domainEE.setSAndSDiscountPercent(customEE.getSAndSDiscountPercent());
		OPPTLogger.debug("domainEE.getSAndSDiscountPercent() :"+domainEE.getSAndSDiscountPercent(), CLASS_NAME,"buildEEDomainDTO");
		// S and s changes starts
		return domainEE;
	}

	/** 
	 * Build Customer Domain DTO from Custom
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
	 * @param customCustomer
	 * @param transactionName
	 * @return CustomerDomainDTO
	 */
	public static CustomerDomainDTO buildCustomerDomainDTOFromCustomWithOnlyID(ProposalCustomerCustomDTO customCustomer, String transactionName) {
		CustomerDomainDTO domainCustomer = new CustomerDomainDTO();
		domainCustomer.setActionName(transactionName);
		domainCustomer.setCustomerId(customCustomer.getCustomerId());
		domainCustomer.setProposalId(customCustomer.getProposalId());
		return domainCustomer;
	}

	/** 
	 * Build DM Domain DTO from custom DTO 
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
	 * @param customMachine
	 * @param transactionName
	 * @return DMDomainDTO
	 */
	public static DMDomainDTO buildDMDomainDTOFromCustomWithOnlyID(DMCustomDTO customMachine, String transactionName) {
		DMDomainDTO machine = new DMDomainDTO();
		machine.setActionName(transactionName);
		machine.setProposalId(customMachine.getProposalId());
		machine.setCustomerId(Integer.parseInt(customMachine.getCustomerId()));
		machine.setDmId(Integer.parseInt(customMachine.getId()));
		return machine;
	}

	/** 
	 * Build SWO Domain DTO from custom
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
	 * @param customLicense
	 * @param transactionName
	 * @return SWODomainDTO
	 */
	public static SWODomainDTO buildSWODomainDTOFromCustomWithOnlyID(SWOCustomDTO customLicense, String transactionName) {
		SWODomainDTO license = new SWODomainDTO();
		license.setActionName(transactionName);
		license.setProposalId(customLicense.getProposalId());
		license.setCustomerId(Integer.parseInt(customLicense.getCustomerId()));
		license.setDmId(Integer.parseInt(customLicense.getDMId()));
		license.setSwoId(Integer.parseInt(customLicense.getId()));
		return license;
	}

}
