/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception;

import java.io.Serializable;

/** 
 * This class is for storing Error Id and its corresponding ErrorType.
 * Using both these ErrorId can be linked with ErrorType.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Anshuman Singh
 * @version 5.1A 
 */
public class ErrorKey implements Serializable{
	
	/**
	 *  For storing ErrorId of an error.
	 */
	private String errorId = null;
	
	/**
	 *  For storing Error Type of an error.
	 */
	private int errorType = 0;
	
	/**
	 * Creates a new ErrorKey object.
	 * 
	 * <br/><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param ierrorId 
	 * @param ierrorType
	 */
	public ErrorKey(String ierrorId, int ierrorType){
		setErrorId(ierrorId);
		setErrorType(ierrorType);
	}
	
	/**
     * For setting Error Id
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 25, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newerrorId 
     */
	public void setErrorId(String newerrorId){
		errorId = newerrorId;
	}
	
	/**
	 *  
	 * For retrieving Error Id
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	public String getErrorId(){
		return errorId;
	}
	
	/**
     * For setting Error Type
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 25, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param newerrorType 
     */
	public void setErrorType(int newerrorType){
		errorType = newerrorType;
	}
	
	/**
	 *  
	 * For retrieving Error Type
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getErrorType(){
		return errorType;
	}
	
	/**
	 *  
	 * For retrieving Error Type
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 25, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String
	 */
	
	public String toString(){
		return "[ErrorKey] - Id: "+errorId+" Type: "+errorType;  /* NOI18N */  /* NOI18N */
	}
}
