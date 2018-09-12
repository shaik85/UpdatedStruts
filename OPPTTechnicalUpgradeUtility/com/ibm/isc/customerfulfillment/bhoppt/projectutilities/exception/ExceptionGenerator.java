/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception;

/** 
 * Generates OPPT related Exception 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 14, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Arun Nagarajan
 * @version 5.1A 
 */
public class ExceptionGenerator {
	
	/** 
	 * Generates ServiceException and returns it. If ErrorReport provided is null,
	 * a default error report is added to the exception and returned.
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param report
	 * @return ServiceExceotion
	 */
	public static ServiceException generateServiceException(ErrorReport report){
		ServiceException exception = new ServiceException();
		if (report != null && report.size() > 0) {
			exception.setErrorReport(report);
		}else{
			exception.setErrorReport(getErrorReport("",OPPTMessageCatalog.TYPE_SERVICE));  /* NOI18N */
		}
		return exception;			
	}
	
	/** 
	 * Generates DomainException and returns it. If ErrorReport provided is null,
	 * a default error report is added to the exception and returned.
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param report
	 * @return DomainException
	 */
	public static DomainException generateDomainException(ErrorReport report){
		DomainException exception = new DomainException();
		if (report != null && report.size() > 0){
			exception.setErrorReport(report);
		}else{
			exception.setErrorReport(getErrorReport("",OPPTMessageCatalog.TYPE_DOMAIN));  /* NOI18N */
		}
		return exception;
	}
	
	/** 
	 * Generates ConnectorException and returns it. If ErrorReport provided is null,
	 * a default error report is added to the exception and returned.
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param report
	 * @return ConnectorException
	 */
	public static ConnectorException generateConnectorException(ErrorReport report){
		ConnectorException exception = new ConnectorException();
		if (report != null && report.size() > 0){
			exception.setErrorReport(report);
		}else{
			exception.setErrorReport(getErrorReport("",OPPTMessageCatalog.TYPE_CONNECTOR));  /* NOI18N */
		}
		return exception;
	}
	
	/** 
	 * Creates a ErrorReport with error entry and returns
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorCode
	 * @param messageType
	 * @return ErrorReport
	 */
	public static ErrorReport getErrorReport(String errorCode, int messageType){
		ErrorReport errorReport = new ErrorReport();
		ErrorKey key = new ErrorKey(errorCode, messageType);
		errorReport.addErrorEntry(key, null);
		return errorReport;
	}
	
	/** 
	 * Generates ServiceException and returns it after adding ErrorReport
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorCode
	 * @return ServiceException
	 */
	public static ServiceException generateServiceException(String errorCode){
		ServiceException exception = new ServiceException();
		ErrorReport errorReport = getErrorReport(errorCode,OPPTMessageCatalog.TYPE_SERVICE);
		exception.setErrorReport(errorReport);
		return exception;
	}

	/** 
	 * Generates DomainException and returns it after adding ErrorReport
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorCode
	 * @return DomainException
	 */
	public static DomainException generateDomainException(String errorCode){
		DomainException exception = new DomainException();
		ErrorReport errorReport = getErrorReport(errorCode,OPPTMessageCatalog.TYPE_DOMAIN);
		exception.setErrorReport(errorReport);
		return exception;
	}
	
	/** 
	 * Generates ConnectorException and returns it after adding ErrorReport
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param errorCode
	 * @return ConnectorException
	 */
	public static ConnectorException generateConnectorException(String errorCode){
		ConnectorException exception = new ConnectorException();
		ErrorReport errorReport = getErrorReport(errorCode,OPPTMessageCatalog.TYPE_CONNECTOR);
		exception.setErrorReport(errorReport);
		return exception;
	}
	
	/** 
	 * Adds an error entry to the ErrorReport object provided and returns the ErrorReport. 
	 * If the ErrorReport object is null, new object is created and returned after adding ErrorEntry
	 *   
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param report
	 * @param errorCode
	 * @param messageType
	 * @return ErrorReport
	 */
	public static ErrorReport addErrorEntry(ErrorReport report, String errorCode, int messageType){
		ErrorKey errorKey =	new ErrorKey(errorCode, messageType);
		if(report != null){
			report.addErrorEntry(errorKey, null);
		}else{
			report = new ErrorReport();
			report.addErrorEntry(errorKey, null);
		}
		
		return report;
	}

	/** 
	 * Adds an error entry to the ErrorReport object provided and returns the ErrorReport. 
	 * If the ErrorReport object is null, new object is created and returned after adding ErrorEntry
	 *   
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 15, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param report
	 * @param messageInputs
	 * @param errorCode
	 * @param messageType
	 * @return ErrorReport
	 */
	public static ErrorReport addErrorEntry(ErrorReport report, String[] messageInputs, 
			String errorCode, int messageType){
		ErrorKey errorKey =	new ErrorKey(errorCode, messageType);
		ErrorEntry errorEntry = new ErrorEntry();
		errorEntry.setMessageInputs(messageInputs);
		if(report != null){
			report.addErrorEntry(errorKey, errorEntry);
		}else{
			report = new ErrorReport();
			report.addErrorEntry(errorKey, errorEntry);
		}
		return report;
	}
}
