/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.factory;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import com.ibm.isc.customerfulfillment.bhoppt.domain.proposalcontract.bo.ErrorListBO;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListLocal;
import com.ibm.isc.customerfulfillment.bhoppt.persistence.proposalcontract.ErrorListLocalHome;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.ErrorCodeConstants;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.DomainException;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ErrorReport;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ExceptionGenerator;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.servicelocator.HomeProvider;


/** 
 * This is the Factory class for ErrorList Bean.  
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 29, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author prakash
 * @version 5.1A 
 */


public class ErrorListBOFactory {
	
	ErrorReport errorReport = new ErrorReport();
	private static final String ERRORLIST_LOCAL_HOME = "ErrorListLocalHome";
	private static final String CLASS_NAME = "ErrorListBOFactory";
	

	/** 
	 * To get the ErrorList local home 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	private ErrorListLocalHome getErrorListLocalHome()
	{
		return (ErrorListLocalHome) HomeProvider.getLocal(ERRORLIST_LOCAL_HOME);
		
	}


	/** 
	 * Find all Error History for a Proposal/Contract 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param int
	 * @author prakash
	 * @return List
	 */
	
	public List findErrorListBOForProposal(int proposalId) throws DomainException {
		ErrorListLocalHome errorListLocalHome = getErrorListLocalHome();
		Collection errorHistoryCollection = null;
			
		try {
				errorHistoryCollection = errorListLocalHome.findByProposalId(proposalId);
		} catch (FinderException ex) {			
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0416);					
		}
		
		Iterator iter = errorHistoryCollection.iterator();
		ErrorListLocal errorListLocal = null;
		 
		List errorList = new ArrayList();
		 
		while (iter.hasNext()) {
			ErrorListBO errorListBO = new ErrorListBO();
			errorListLocal = (ErrorListLocal) iter.next();
			populateDataFromEntity(errorListBO, errorListLocal);						
			
			errorList.add(errorListBO);			
		}		
		return errorList;	
	}
	
	/** 
	 * Populates data from Entity to ErrorListBO 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param Entity
	 * @param ErrorListBO
	 * @author prakash
	 * @return void
	 */
	
	
	
	private void populateDataFromEntity(ErrorListBO errorListBO, ErrorListLocal errorListLocal) {
		errorListBO.setDate(errorListLocal.getDate());
		errorListBO.setTime(errorListLocal.getTime());
		errorListBO.setMessageDesc(errorListLocal.getMessageDesc());
		errorListBO.setMessageDetail(errorListLocal.getMessageDetail());
		errorListBO.setMessageNo(errorListLocal.getMessageNO());
		errorListBO.setMethodName(errorListLocal.getMethodName());
		errorListBO.setProposalId(errorListLocal.getProposalId());
		errorListBO.setUserId(errorListLocal.getUserId());
		errorListBO.setMessageId(errorListLocal.getMessageId());		
	}
	
	/**
	 * This method will add data from BO to Entity 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorListBO
	 * @param errorListLocal
	 */
	private void populateDataToEntity(ErrorListBO errorListBO, ErrorListLocal errorListLocal) {
		errorListLocal.setDate(errorListBO.getDate());
		errorListLocal.setTime(errorListBO.getTime());
		errorListLocal.setMessageDesc(errorListBO.getMessageDesc());
		errorListLocal.setMessageDetail(errorListBO.getMessageDetail());
		errorListLocal.setMessageNO(errorListBO.getMessageNo());
		errorListLocal.setMethodName(errorListBO.getMethodName());
		errorListLocal.setUserId(errorListBO.getUserId());
	}
 

	/** 
	 * Deletes the error history of a proposal/contract 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 22, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param int
	 * @author prakash
	 * @return void
	 */


	public void deleteErrorListBO(Integer messageId)   throws DomainException   {
			ErrorListLocalHome errorListLocalHome = getErrorListLocalHome();
			try {	
				 ErrorListLocal errorListLocal = errorListLocalHome.findByPrimaryKey(messageId);
				 errorListLocal.remove();
			 				
			} catch(FinderException ex) {
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"deleteErrorListBO",null,ex);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);		
			} catch (RemoveException ex) {
				OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"deleteErrorListBO",null,ex);
				throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
	}
	/**
	 * This method is used to create a ErrorList BO 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 5, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorListBO
	 */
	public void createErrorListBO(ErrorListBO errorListBO) throws DomainException {
		java.util.Date today = new java.util.Date();
		ErrorListLocalHome errorListLocalHome = getErrorListLocalHome();
		ErrorListLocal errorListLocal = null;
		int messageId = 1;
		try {
			errorListLocal = errorListLocalHome.findMax();
			messageId = errorListLocal.getMessageId().intValue()+1;
		}catch(FinderException ex) {			
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"createErrorListBO",null,ex);
		}
		try{
			errorListLocal = errorListLocalHome.create(new Integer(messageId), errorListBO.getProposalId());
			errorListBO.setTime(new Time(today.getTime()));
			errorListBO.setDate(new java.sql.Date(today.getTime()));
			populateDataToEntity(errorListBO,errorListLocal);							
		}catch(CreateException ce) {
			OPPTLogger.log("EXCEPTION",OPPTLogger.ERROR,CLASS_NAME,"createErrorListBO",null,ce);
			throw ExceptionGenerator.generateDomainException(ErrorCodeConstants.DE0801);
		}
	}
}
