/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.service.dmmgr;


import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.domain.dto.*;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;


/**
 * This Local Interface for DMManager
 * <br/><b>Known Bugs</b><br/>
 * <br/><PRE>
 * date Nov 24, 2003
 * revision date author reason
 * </PRE><br/>
 *
 * @author Ravishankar * @version 5.1A
 * @version 
 */
public interface DMManagerLocal extends javax.ejb.EJBLocalObject
{
    /**
     *RetrieveDM
     *
     * @return DMDomainDTO
     * @param dmDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public DMDomainDTO retrieveDM(DMDomainDTO dmDTO)throws ServiceException;
    /**
     *RetrieveSWOInfo
     *
     * @return DMDomainDTO
     * @param swoDomainDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public DMDomainDTO retrieveEditSWOInfo(SWODomainDTO swoDomainDTO)throws ServiceException;
    /**
     *updateDMForCustomer
     *
     * @param customerDomainDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public void updateDMForCustomer(CustomerDomainDTO customerDomainDTO)throws ServiceException;
    /**
     *retrieveDMForCopyInventory
     *
     * @return CustomerDomainDTO
     * @param customerDomainDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public CustomerDomainDTO retrieveDMForCopyInventory(CustomerDomainDTO customerDomainDTO)throws ServiceException;
    /**
     *storeBumpInfo
     *
     * @param bumpDMDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public void storeBumpInfo(DMDomainDTO bumpDMDTO)throws ServiceException;
    /**
     *storeDMInfo
     *
     * @param dmDTOList
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public void storeDMInfo(List dmDTOList) throws ServiceException;
    /**
     *storeIneligibleLicenseInfo
     *
     * @param dmDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public void storeIneligibleLicenseInfo(DMDomainDTO dmDTO) throws ServiceException;
    /**
     *storeVarianceInfoForDM
     *
     * @param dto
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public void storeVarianceInfoForDM(DMDomainDTO dto) throws ServiceException;
    /**
     *updateDMDetails
     *
     * @param dmDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public void updateDMDetails(DMDomainDTO dmDTO)throws ServiceException;
    /**
     *retrieveSWOInfo
     *
     * @param swoDomainDTO
     * @return DMDomainDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     */
    public DMDomainDTO retrieveSWOInfo(SWODomainDTO swoDomainDTO)throws ServiceException;
    /**
     *storeConfigureDMInfo
     *
     * @param dmDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public void storeConfigureDMInfo(DMDomainDTO dmDTO)throws ServiceException;
    /**
     *uremoveDMInfo
     *
     * @param dmDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public void removeDMInfo(DMDomainDTO dmDTO)throws ServiceException;
    /**
     *removeLicenses
     *
     * @param swoDomainDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public void removeLicenses(SWODomainDTO swoDomainDTO)throws ServiceException;
    /**
     *copyStoreDMHistoryInfo
     *
     * @param dmDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public void copyStoreDMHistoryInfo(DMDomainDTO dmDTO)throws ServiceException;
    /**
     *repalceSkipLicenses
     *
     * @param dmDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public void repalceSkipLicenses(DMDomainDTO dmDTO) throws ServiceException;
    /**
     *copyInventory
     *
     * @param copyInventoryDomainDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public void copyInventory(CopyInventoryDomainDTO copyInventoryDomainDTO)throws ServiceException;
    /**
     *deleteVarianceDM
     *
     * @param proposal
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public void deleteVarianceDM(ProposalDomainDTO proposal) throws ServiceException;
	/**
     *retrieveDMForCustomer
     *
     * @return CustomerDomainDTO
     * @param customerDomainDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException 
     */
    public CustomerDomainDTO retrieveDMForCustomer(CustomerDomainDTO customerDomainDTO)throws ServiceException;
	
}
