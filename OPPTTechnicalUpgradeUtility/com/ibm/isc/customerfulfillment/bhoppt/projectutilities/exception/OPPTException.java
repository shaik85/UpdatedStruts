/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception;


/**
 * All the exceptions in OPPT application should extend from this class. This has ErrorReport object. 
 * When an exception is thrown from the service layer, controller layer catches the exception, gets the
 * ErrorReport of the exception which has only the errorIds in it. Controller populates the ErrorReport
 * based on the errorIds and gives to presentation layer, which in turn displays the error messages.
 * 
 * <br/><b>Known Bugs</b><br/> 
 *  
 * <br/><PRE> 
 * date Nov 11, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version 5.1A
 */
public class OPPTException extends Exception {
	/**
	 * This is the place holder for all the error messages in form of ErrorEntry's (each error entry is
	 * an error message created for an exception)
	 */
	private ErrorReport errorReport = null;

	/**
	 * Returns the ErrorReport object. If ErrorReport is null it creates a new ErrorReport object and returns. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return ErrorReport
	 */
	public ErrorReport getErrorReport() {
		if (errorReport == null){
			errorReport = new ErrorReport();
		}
		return errorReport;
	}

	/**
	 * Sets the ErrorReport object
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newErrorReport ErrorReport object
	 */	
	public void setErrorReport(ErrorReport newErrorReport){
		errorReport = newErrorReport;
	}
}
