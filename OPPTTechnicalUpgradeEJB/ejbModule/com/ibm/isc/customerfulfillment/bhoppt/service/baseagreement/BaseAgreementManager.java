/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement;

import java.rmi.RemoteException;


import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementChangeLogDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.BaseAgreementDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SearchBaseAgreementCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Remote interface for Enterprise Bean: BaseAgreementManager
 */
public interface BaseAgreementManager extends javax.ejb.EJBObject {
	/**
     * @param customDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Sasi R Challa
     */
    public SearchBaseAgreementCustomDTO getAllBaseAgreements(SearchBaseAgreementCustomDTO customDTO) throws ServiceException, RemoteException;
	/**
     * @param baDetailsCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Sudharsan Reddy
     */
    public BaseAgreementDetailsCustomDTO getBaseAgreement(BaseAgreementDetailsCustomDTO baDetailsCustomDTO) throws ServiceException, RemoteException;
	/**
     * @param baDetailsCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Sudharsan Reddy
     */
    public BaseAgreementDetailsCustomDTO registerBaseAgreement(BaseAgreementDetailsCustomDTO baDetailsCustomDTO) throws ServiceException, RemoteException;
	/**
     * @param baCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Sasi R Challa
     */
    public BaseAgreementCustomDTO inActivateBaseAgreement(BaseAgreementCustomDTO baCustomDTO) throws ServiceException, RemoteException;
	/**
     * @param baDetailsCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Sasi R Challa
     */
    public BaseAgreementDetailsCustomDTO amendBaseAgreement(BaseAgreementDetailsCustomDTO baDetailsCustomDTO) throws ServiceException, RemoteException;
	/**
     * @param baseAgreementDetailsCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Sudharsan Reddy
     */
    public BaseAgreementDetailsCustomDTO validateAgreementHeader(BaseAgreementDetailsCustomDTO baseAgreementDetailsCustomDTO) throws ServiceException, RemoteException;
    
    /**
     * @param BaseAgreementChangeLogDetailsCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return BaseAgreementChangeLogDetailsCustomDTO
     * @author Thirumalaikumar
     */
    public BaseAgreementChangeLogDetailsCustomDTO getBaseAgreementChangeLogDetails(BaseAgreementChangeLogDetailsCustomDTO baChangeLogDetailsCustomDTO) throws ServiceException, RemoteException;
	/**
     * @param baCustomDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Sudharsan Reddy
     */
    public BaseAgreementCustomDTO reActivateBaseAgreement(BaseAgreementCustomDTO baCustomDTO) throws ServiceException, RemoteException;
}
