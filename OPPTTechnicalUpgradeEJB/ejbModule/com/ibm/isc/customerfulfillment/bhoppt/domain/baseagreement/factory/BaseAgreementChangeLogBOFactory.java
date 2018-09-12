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
import javax.ejb.FinderException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.baseagreement.bo.BaseAgreementChangeLogBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.baseagreement.BaseAgreementChangeLogLocalHome;
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
public class BaseAgreementChangeLogBOFactory {
	
	
	/**
	 * createChangeLog method used to create change history details
     * @param BaseAgreementChangeLogBO
     * @throws com.ibm.support.oppt.projectutilities.exception.DomainException
     * @author Thirumalaikumar
     */
	public void createChangeLog(BaseAgreementChangeLogBO baChangeLogBO) throws DomainException
	{
		BaseAgreementChangeLogLocalHome baseAgreementChangeLogLocalHome = getBaseAgreementChangeLogLocalHome();
		try
		{
			BaseAgreementChangeLogLocal local = baseAgreementChangeLogLocalHome.create(new Integer(baChangeLogBO.getChangeId()),new Integer(baChangeLogBO.getAgreementId()));
			populateDataLocalFromBO(baChangeLogBO, local);			
			
		} catch(CreateException ex){
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "BaseAgreementBOFactory", "createBaseAgreement", null, ex);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		
	}
	
	
	/**
	 * findMaxBaseAgreementChangeLogBO
     * @throws com.ibm.support.oppt.projectutilities.exception.DomainException
     * @return BaseAgreementChangeLogBO
     * @author Lakshmanan Thirumalaikumar
     */
    public BaseAgreementChangeLogBO findMaxBaseAgreementChangeLogBO() throws DomainException
	{

		BaseAgreementChangeLogBO baseAgreementChangeLogBO = new BaseAgreementChangeLogBO();
		BaseAgreementChangeLogLocalHome baseAgreementChangeLogLocalHome = getBaseAgreementChangeLogLocalHome();
		BaseAgreementChangeLogLocal baseAgreementChangeLogLocal = null;

		try {
			baseAgreementChangeLogLocal = baseAgreementChangeLogLocalHome.findMaxChangeId();
			if(null != baseAgreementChangeLogLocal) {
				baseAgreementChangeLogBO.setChangeId(baseAgreementChangeLogLocal.getChangeId().intValue());
			}else {
				baseAgreementChangeLogBO.setChangeId(0);
			}

		} catch (FinderException ex) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "BaseAgreementChangeLogBOFactory", "findMaxBaseAgreementChangeLogBO", null, ex);
			baseAgreementChangeLogBO.setAgreementId(0);
		}
		return baseAgreementChangeLogBO;
	}	


	
	private void populateDataLocalFromBO(BaseAgreementChangeLogBO baChangeLogBO, BaseAgreementChangeLogLocal baseAgreementChangeLogLocal)
	{   
		if(baseAgreementChangeLogLocal != null)
		{
		    baseAgreementChangeLogLocal.setChangeId(new Integer(baChangeLogBO.getChangeId()));
		    baseAgreementChangeLogLocal.setCreatedBy(baChangeLogBO.getChangedBy());
		    baseAgreementChangeLogLocal.setChangedDate(baChangeLogBO.getChangedDate());
		    baseAgreementChangeLogLocal.setChangedTime(baChangeLogBO.getChangedTime());
		    baseAgreementChangeLogLocal.setChangedDetails(OPPTHelper.trimString(baChangeLogBO.getChangedDetails()));
		}		
	}
	
	/**
	 * @return
	 */
	private BaseAgreementChangeLogLocalHome getBaseAgreementChangeLogLocalHome() {
		return (BaseAgreementChangeLogLocalHome)ServiceLocator.getEJBHomeFactory().getLocalHome(HomeProvider.BASE_AGREEMENT_CHANGELOG_LOCAL_HOME);
	}
}
