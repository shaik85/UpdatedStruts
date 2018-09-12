/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.service.pcm;

import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ErrorListBO;
import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory.ErrorListBOFactory;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ServiceException;

/**
 * Bean implementation class for Enterprise Bean: ErrorListManager
 */
public class ErrorListManagerBean implements javax.ejb.SessionBean {
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
	 * storeErrorList
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
	 * @param errorListBO
	 * @return void
	 * @throws ServiceException
	 * @author balajiv
	 */
	public void storeErrorList(ErrorListBO errorListBO) throws ServiceException {
		ErrorListBOFactory 	factory = new ErrorListBOFactory();
		try {
			factory.createErrorListBO(errorListBO);
		} catch (DomainException e) {
			throw ExceptionGenerator.generateServiceException(e.getErrorReport());
		}
	}
	
}
