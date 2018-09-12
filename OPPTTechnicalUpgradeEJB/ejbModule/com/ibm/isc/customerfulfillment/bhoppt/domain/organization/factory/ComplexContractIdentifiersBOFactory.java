/*
 * Created on Apr 27, 2010
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/*
* IBM Confidential
*
* ©  Copyright IBM Corp. 2004, 2005  All Rights Reserved.

* The source code for this program is not published or otherwise divested of
* its trade secrets, irrespective of what has been deposited with the U.S. Copyright office.
*/
package com.ibm.isc.customerfulfillment.bhoppt.domain.organization.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.FinderException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.BLBIndicatorBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ComplexContractIdentifiersBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ComplexContractIdentifiersBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.ComplexContractTypeBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.MasterContractTypeBDO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.organization.bo.PaymentTermBDO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.BLBIndicatorLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.CCTypeLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.MCTypeLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.organization.PaymentTermLocal;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.OPPTHelper;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ComplexContractIdentifiersBOFactory {
	private static final String EXCEPTION = "EXCEPTION";
	private static final String CLASS_NAME = "ComplexContractIdentifiersBOFactroy";
	
	public ComplexContractIdentifiersBO getComplexContractIdentifiersBO() throws DomainException 
	{
		String methodName = "getComplexContractIdentifiersBO";
		ComplexContractIdentifiersBO bo = new ComplexContractIdentifiersBO();
		//CCTypeLocalHome cctypelocalhome = (CCTypeLocalHome)HomeProvider.getLocal(HomeProvider.CC_TYPE_LOCAL_HOME);
		Collection collection;
		/*try
		{
			collection = cctypelocalhome.findAllCCType();			
		}
		catch (FinderException e)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		Iterator iter = collection.iterator();
		CCTypeLocal ccTypeLocal;
		
		ComplexContractTypeBDO complexContractTypeBDO;
		
		List complexContractTypeList = new ArrayList();

		while (iter.hasNext())
		{			
			complexContractTypeBDO = new ComplexContractTypeBDO();
			ccTypeLocal = (CCTypeLocal) iter.next();
			complexContractTypeBDO.setComplexContractType(OPPTHelper.trimString(ccTypeLocal.getCcType()));
			complexContractTypeBDO.setComplexContractDesc(OPPTHelper.trimString(ccTypeLocal.getCcDesc()));
			complexContractTypeList.add(complexContractTypeBDO);			
		}

		bo.setIComplexContractTypeList(complexContractTypeList);
		
		//Master contract type starts here
		MCTypeLocalHome mcTypeLocalHome = (MCTypeLocalHome)HomeProvider.getLocal(HomeProvider.MC_TYPE_LOCAL_HOME);
		try
		{
			collection = mcTypeLocalHome.findAllMCType();
		}
		catch (FinderException e)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		iter = collection.iterator();
		MCTypeLocal mcTypeLocal;
		MasterContractTypeBDO masterContractTypeBDO;
		List masterContractTypeList = new ArrayList();
		while (iter.hasNext())
		{
			masterContractTypeBDO = new MasterContractTypeBDO();
			mcTypeLocal = (MCTypeLocal)iter.next();
			masterContractTypeBDO.setMasterContractType(OPPTHelper.trimString(mcTypeLocal.getMcType()));
			masterContractTypeBDO.setMasterContractDesc(OPPTHelper.trimString(mcTypeLocal.getMcDesc()));
			masterContractTypeList.add(masterContractTypeBDO);
		}
		bo.setIMasterContractTypeList(masterContractTypeList);*/
		
		//BLB Indicator Starts here
		BLBIndicatorLocalHome blbIndicatorLocalHome = (BLBIndicatorLocalHome)HomeProvider.getLocal(HomeProvider.BLB_Indicator_LOCAL_HOME);
		
		try
		{
			collection = blbIndicatorLocalHome.findAllBLBIndicator();
		}
		catch (FinderException e)
		{
			OPPTLogger.log(EXCEPTION, OPPTLogger.ERROR, CLASS_NAME, methodName, null, e);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
		Iterator iter = collection.iterator();
		BLBIndicatorLocal blbIndicatorLocal;
		BLBIndicatorBDO blbIndicatorBDO;
		List blbIndicatorList = new ArrayList();
		while (iter.hasNext())
		{			
			blbIndicatorBDO = new BLBIndicatorBDO();
			blbIndicatorLocal = (BLBIndicatorLocal)iter.next();
			blbIndicatorBDO.setBlbIndicatorType(OPPTHelper.trimString(blbIndicatorLocal.getBlbType()));
			blbIndicatorBDO.setBlbIndicatorDesc(OPPTHelper.trimString(blbIndicatorLocal.getBlbDesc()));
			blbIndicatorList.add(blbIndicatorBDO);
		}
		bo.setIBLBIndicatorList(blbIndicatorList);
		
		return bo;		
	}
}
