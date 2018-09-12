/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.baseagreement;

import java.rmi.RemoteException;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormDetailsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormMaintenanceCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.FormNumbersBySalesOrgCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationOptionCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypesCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationsBySalesOrgCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.SalesOrgForReportsCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Remote interface for Enterprise Bean: BaseAgreementDataManager
 */
public interface BaseAgreementDataManager extends javax.ejb.EJBObject {
	
	/**
     * @param customDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Ravi Yandapalli
     */
    public ModificationTypesCustomDTO getAllModificationTypes(ModificationTypesCustomDTO customDTO) throws ServiceException, RemoteException;
    
    /**
     * @param customDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Ravi Yandapalli
     */
    public  ModificationTypeCustomDTO addModificationType(ModificationTypeCustomDTO modificationTypeCustomDTO) throws ServiceException, RemoteException ;
    /**
     * @param customDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Ravi Yandapalli
     */
    public  ModificationTypeCustomDTO updateModificationType(ModificationTypeCustomDTO modificationTypeCustomDTO) throws ServiceException, RemoteException;

    /**
     * @param customDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Ravi Yandapalli
     */
    public  ModificationOptionCustomDTO addModificationOption(ModificationOptionCustomDTO customDTO) throws ServiceException, RemoteException ;

    /**
     * @param customDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Ravi Yandapalli
     */
    public  ModificationTypeCustomDTO getModificationOptions(ModificationTypeCustomDTO customDTO) throws ServiceException, RemoteException ;
    
    /**
     * @param customDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Ravi Yandapalli
     */
    public  ModificationOptionCustomDTO updateModificationOptions(ModificationOptionCustomDTO customDTO) throws ServiceException, RemoteException ;
    
       
    
    /**
     * @param salesOrg
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Sasi R Challa
     */
    public ModificationsBySalesOrgCustomDTO getModificationsBySalesOrg(SalesOrgForReportsCustomDTO salesOrgForReportsCustomDTO)throws ServiceException, RemoteException;
    /**
     * @param salesOrg
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Sasi R Challa
     */
    public FormNumbersBySalesOrgCustomDTO getFormNumbersBySalesOrg(SalesOrgForReportsCustomDTO salesOrgForReportsCustomDTO)throws ServiceException,RemoteException;
    /**
     * @param customDTO
     * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
     * @throws java.rmi.RemoteException
     * @return
     * @author Sasi R Challa
     */
   public FormMaintenanceCustomDTO getAllForms(FormMaintenanceCustomDTO customDTO) throws ServiceException,RemoteException;
   /**
    * @param customDTO
    * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
    * @throws java.rmi.RemoteException
    * @return
    * @author Sasi R Challa
    */
   public  FormDetailsCustomDTO addForm(FormDetailsCustomDTO formDetailsCustomDTO) throws ServiceException,RemoteException;
   /**
    * @param customDTO
    * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
    * @throws java.rmi.RemoteException
    * @return
    * @author Sasi R Challa
    */
  public void deleteForm(FormDetailsCustomDTO customDTO) throws ServiceException,RemoteException;
  /**
   * @param customDTO
   * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
   * @throws java.rmi.RemoteException
   * @return
   * @author Sasi R Challa
   */
  public FormDetailsCustomDTO updateForm(FormDetailsCustomDTO customDTO) throws ServiceException,RemoteException;
  
  /**
   * @param customDTO
   * @throws com.ibm.support.oppt.projectutilities.exception.ServiceException
   * @throws java.rmi.RemoteException
   * @return
   * @author Sasi R Challa
   */
  
  public void deleteModificationType(ModificationTypeCustomDTO modificationTypeCustomDTO) throws ServiceException,RemoteException;
    
}
  
    


