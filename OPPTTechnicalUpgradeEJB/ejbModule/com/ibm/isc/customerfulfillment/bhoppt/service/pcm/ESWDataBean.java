/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;

import java.util.HashMap;
import java.util.Map;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ESWDataFactory;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * Bean implementation class for Enterprise Bean: ESWData
 * @author Sara
 * Defect 11 - Fix for GWA XA
 */
public class ESWDataBean implements javax.ejb.SessionBean {
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
	 * deleteESWData
	 * Stores Error Information 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sessionId
	 * @param proposalId
	 * @param transAttribute
	 * @return void
	 * @throws ServiceException
	 * @author balajiv
	 */
	public void deleteESWData(String sessionId, int proposalId, String transAttribute) throws ServiceException {
		ESWDataFactory factory = new ESWDataFactory();
		try {
			factory.deleteESWData(sessionId, proposalId, transAttribute);
		} catch (DomainException de) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ESWDataBean", "", null, de);
			ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}

	}
	
	/**
	 * retrieveESWData
	 * Stores Error Information 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sessionId
	 * @param proposalId
	 * @param transAttribute
	 * @return Map
	 * @throws ServiceException
	 * @author balajiv
	 */
	public Map retrieveESWData(String sessionId, int proposalId, String transAttribute) throws ServiceException {
		ESWDataFactory factory = new ESWDataFactory();
		Map map = new HashMap();
		try {
			map = factory.getESWData(sessionId, proposalId, transAttribute);
		} catch (DomainException de) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ESWDataBean", "", null, de);
			ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
		return map;
	}
	
	/**
	 * storeESWData
	 * Stores Error Information 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 10, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param sessionId
	 * @param dtoList
	 * @param proposalId
	 * @param transAttribute
	 * @return void
	 * @throws ServiceException
	 * @author balajiv
	 */
	public void storeESWData(String sessionId, ConnectorDTOInterface dtoList, int proposalId, String transAttribute) throws ServiceException {
		ESWDataFactory factory = new ESWDataFactory();
		try {
			factory.storeESWData(sessionId, dtoList, proposalId, transAttribute);
		} catch (DomainException de) {
			OPPTLogger.log("EXCEPTION", OPPTLogger.ERROR, "ESWDataBean", "", null, de);
			ExceptionGenerator.generateServiceException(ErrorCodeConstants.SE0801);
		}
	}

}
