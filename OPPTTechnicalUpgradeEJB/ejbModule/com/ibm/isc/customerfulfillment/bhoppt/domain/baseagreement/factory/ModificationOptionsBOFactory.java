/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;


import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.ModificationOptionsBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsKey;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.ModificationOptionsLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.util.customdto.ModificationTypeCustomDTO;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.ServiceLocator;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ModificationOptionsBOFactory {
	
	    
	   /**
	    * 
	    * @param modificationOptionsBO
	    * @return
	    * @throws DomainException
	    */

	public ArrayList getAllModificationOptionsBO(ModificationOptionsBO modificationOptionsBO)throws DomainException{
	       
	    
	        ModificationTypeCustomDTO modificationTypeCustomDTO = null;   
	        ModificationOptionsLocal modificationOptionsLocal = null; 
	        ModificationOptionsLocalHome modificationOptionsLocalHome = getModificationOptionsLocalHome();
	        Collection baModificationOptionsCollection = null;
	        ArrayList modificationOptionsList = new ArrayList();
	        try
			{
	            baModificationOptionsCollection = modificationOptionsLocalHome.findByTypeCode(modificationOptionsBO.getModificationTypeCode());
	    	} catch(FinderException ex) {
				OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ModificationOptionsBOFactory", "getAllModificationOptionsBO", null, ex);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
			}
			if(baModificationOptionsCollection != null)
			{	Iterator baModificationOptionsIterator = baModificationOptionsCollection.iterator();
					while(baModificationOptionsIterator.hasNext())
					{ 	
						modificationOptionsBO = new ModificationOptionsBO(); //....
					    modificationOptionsLocal = (ModificationOptionsLocal)baModificationOptionsIterator.next();
					    populateDataFromEntity(modificationOptionsBO, modificationOptionsLocal);
					    modificationOptionsList.add(modificationOptionsBO);			
					}
			}
	    
	       return  modificationOptionsList;
	       
	   }
	
	/**
     * 
     * @param modificationOptionsBO
     * @param modificationoptionslocal
     */
    
    private void populateDataFromEntity (ModificationOptionsBO modificationOptionsBO,ModificationOptionsLocal modificationoptionslocal){
    	if(modificationoptionslocal != null){
            modificationOptionsBO.setModificationTypeCode(OPPTHelper.trimString(modificationoptionslocal.getModificationTypeCode()));
            modificationOptionsBO.setModificationOption(OPPTHelper.trimString(modificationoptionslocal.getModificationOption()));
            modificationOptionsBO.setModificationOptionDesc(OPPTHelper.trimString(modificationoptionslocal.getModificationOptionDescription()));
            
        }
    
        
    }
    
    /**
	    * updateModificationOptions
	    * @param modificationOptionsBO
	    * @throws DomainException
	    */
    public void updateModificationOptionsBO(ModificationOptionsBO modificationOptionsBO)throws DomainException{
        ModificationOptionsKey key = new ModificationOptionsKey(modificationOptionsBO.getModificationTypeCode(),modificationOptionsBO.getModificationOption());
        ModificationOptionsLocal modificationOptionsLocal = null; 
        ModificationOptionsLocalHome modificationOptionsLocalHome = getModificationOptionsLocalHome();
        try
		{
            modificationOptionsLocal = modificationOptionsLocalHome.findByPrimaryKey(key);
		} catch(FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "BaseAgreementModificationTypesBOFactory", "updateModificationTypeBO", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		if(modificationOptionsLocal!=null){
		    modificationOptionsLocal.setModificationOptionDescription(OPPTHelper.trimString(modificationOptionsBO.getModificationOptionDesc()));
		}
        
    }
    /**
	    * addModificationOptions
	    * @param modificationOptionsBO
	    * @throws DomainException
	    */


    public void addModificationOptionBO(ModificationOptionsBO modificationOptionsBO)throws DomainException{
        
        ModificationOptionsLocal optionLocal = null;
        ModificationOptionsLocalHome modificationOptionsLocalHome = getModificationOptionsLocalHome();
        try
    	{
            optionLocal = modificationOptionsLocalHome.create(OPPTHelper.trimString(modificationOptionsBO.getModificationTypeCode()),OPPTHelper.trimString(modificationOptionsBO.getModificationOption()));
            optionLocal.setModificationOptionDescription(OPPTHelper.trimString(modificationOptionsBO.getModificationOptionDesc()));
    
 		} catch(CreateException e) {
 		    OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ModificationOptionBOFactory", "addModificationTypeBO", null, e);
 		    throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
 		} catch (EJBException e) {
 		    OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "tModificationOptionBOFactory", "addModificationTypeBO", null, e);
 		    throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
 		}
        
    }
    
    /**
     * get the home object reference
     * 
     * @return BaseAgreementModificationTypeLocalHome
     */
    private ModificationOptionsLocalHome getModificationOptionsLocalHome() {
        return (ModificationOptionsLocalHome)ServiceLocator.getEJBHomeFactory().getLocalHome(HomeProvider.MODIFICATION_OPTIONS_LOCAL_HOME);
       }

    

}
