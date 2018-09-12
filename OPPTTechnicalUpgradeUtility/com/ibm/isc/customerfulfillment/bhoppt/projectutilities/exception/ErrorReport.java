/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/**
 * ErrorReport is an HashMap which holds errorId and ErrorEntry pairs. It also provides some
 * extra functionality for appending a new ErrorReport to this ErrorReport, getting all the 
 * fields names that are involved in this ErrorReport.    
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
public class ErrorReport extends HashMap implements Serializable {

	/**
	 * Adds a new ErrorEntry to collection of already existing ErrorEntry's. New entry will be
	 * added only if there is no other entry with the same errorKey of the ErrorEntry in the collection
	 * of already existing ErrorEntry's.
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
	 * @param errorKey ErrorKey object which is used as key value to store the ErrorEntry object
	 * @param errorEntry ErrorEnry value which will be added to collection of already existing
	 * 		  ErrorEntry's.
	 */
	public void addErrorEntry(ErrorKey errorKey, ErrorEntry errorEntry) {
		if (get(errorKey) == null) {
			put(errorKey, errorEntry);
		}
	}

	/**
	 * Appends the ErrorReport to the existing ErrorReport. It adds only the ErrorEntry's that are 
	 * not already existing in the existing ErrorReport object.
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
	 * @param errorReport
	 */
	public void appendErrorReport(ErrorReport errorReport) {
		Iterator errorKeys = errorReport.keySet().iterator();

		while (errorKeys.hasNext()) {
			ErrorKey errorKey = (ErrorKey) errorKeys.next();
			addErrorEntry(errorKey, (ErrorEntry) errorReport.get(errorKey));
		}
	}

	/**
	 * Returns the collection of field names that are involved in generation of this ErrorReport. 
	 * This method iterates through all the error entries present in the ErrorReport, creates a
	 * HashSet out of the fieldNames of the ErrorEntry's. 
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
	 * @return HashSet
	 */
	public HashSet getErrorFieldNames() {
		HashSet errorFieldNames = new HashSet();
		Iterator newErrorEntries = values().iterator();

		while (newErrorEntries.hasNext()) {
			ErrorEntry errorEntry = (ErrorEntry) newErrorEntries.next();
			if(null != errorEntry){
				String[] fieldNames = errorEntry.getFieldNames();
				if (fieldNames != null) {
					for (int i = 0; i < fieldNames.length; i++) {
						errorFieldNames.add(fieldNames[i]);
					}
				}
			}
		}
		return errorFieldNames;
	}

	/**
	 * Displays the error reports content  
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *
	 */
	public void displayErrorReport() {

		Iterator keys = keySet().iterator();

		while (keys.hasNext()) {
			ErrorKey key = (ErrorKey) keys.next();

			ErrorEntry entry = (ErrorEntry) get(key);
			if (entry == null) {
				OPPTLogger.debug(
					"[ErrorReport] - [displayErrorReport] - ErrorEntry null...",  /* NOI18N */
					"ErrorReport",  /* NOI18N */
					"displayErrorReport");  /* NOI18N */
			
			} else {
				OPPTLogger.debug(
					"[ErrorReport] - [displayErrorReport] - Error Message: " + entry.getErrorMessage(),  /* NOI18N */
					"ErrorReport",  /* NOI18N */
					"displayErrorReport");  /* NOI18N */
				OPPTLogger.debug(
					"[ErrorReport] - [displayErrorReport] - Error Message: " + entry.getFieldNames(),  /* NOI18N */
					"ErrorReport",  /* NOI18N */
					"displayErrorReport");  /* NOI18N */
			}
		}
	}
}
