/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.report.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ibm.isc.customerfulfillment.bhoppt.persistence.dao.BaseAgreementReportsDAO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementReportsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import java.util.HashMap;
/**
 * BaseAgreementReportDTOFactory
 * @author Gavaskar Bhojan
 *
 */
public class BaseAgreementReportDTOFactory {
	/**
	 * getAllBaseAgreements
	 * @author Gavaskar Bhojan
	 * @param status
	 * @param salesOrg
	 * @return BaseAgreementReportsCustomDTO
	 * @throws DomainException
	 */
	public BaseAgreementReportsCustomDTO getAllBaseAgreements(String status,String salesOrg)throws DomainException{
		BaseAgreementReportsCustomDTO baseAgreementReportsCustomDTO= new BaseAgreementReportsCustomDTO();
		List baseAgreementList= null;
		baseAgreementList = BaseAgreementReportsDAO.retriveDataForAllBaseAgreements(status,salesOrg);
		baseAgreementReportsCustomDTO.setBaseAgreementReportCustomDTOs(baseAgreementList);
		return baseAgreementReportsCustomDTO;
	}
	/**
	 * getAllModifications
	 * @author Gavaskar Bhojan
	 * @param status
	 * @param salesOrg
	 * @return BaseAgreementReportsCustomDTO
	 * @throws DomainException
	 */
    public BaseAgreementReportsCustomDTO getAllModifications(String status,String salesOrg)throws DomainException{
    	BaseAgreementReportsCustomDTO baseAgreementReportsCustomDTO= new BaseAgreementReportsCustomDTO();
    	List  modificationList= null;
    	modificationList = BaseAgreementReportsDAO.retriveDataForAllModifications(status,salesOrg);
       	baseAgreementReportsCustomDTO.setBaseAgreementReportDetailCustomDTOs(modificationList);
    	return baseAgreementReportsCustomDTO;
    }
    /**
	 * getReportByFormNumbers
	 * @author Gavaskar Bhojan
	 * @param status
	 * @param salesOrg
	 * @return BaseAgreementReportsCustomDTO
	 * @throws DomainException
	 */
    public BaseAgreementReportsCustomDTO getReportByFormNumbers(String status,String salesOrg,String[] formNumbers)throws DomainException{
    	BaseAgreementReportsCustomDTO baseAgreementReportsCustomDTO= new BaseAgreementReportsCustomDTO();
    	List agreementsByFormNumberList= null;
    	agreementsByFormNumberList = BaseAgreementReportsDAO.retriveDataByFormNumbers(status,salesOrg,formNumbers);
       	baseAgreementReportsCustomDTO.setBaseAgreementReportCustomDTOs(agreementsByFormNumberList);
    	return baseAgreementReportsCustomDTO;
    }
    /**
	 * getReportByModTypes
	 * @author Gavaskar Bhojan
	 * @param status
	 * @param salesOrg
	 * @return BaseAgreementReportsCustomDTO
	 * @throws DomainException
	 */
    public BaseAgreementReportsCustomDTO getReportByModTypes(String status,String salesOrg,String[] modTypes)throws DomainException{
    	BaseAgreementReportsCustomDTO baseAgreementReportsCustomDTO= new BaseAgreementReportsCustomDTO();
    	List  modificationList= null;
    	modificationList = BaseAgreementReportsDAO.retriveDataByModTypes(status,salesOrg,modTypes);
    	baseAgreementReportsCustomDTO.setBaseAgreementReportDetailCustomDTOs(modificationList);
    	return baseAgreementReportsCustomDTO;
    }
}
