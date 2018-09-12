/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception;

import java.io.Serializable;

/**
 * ErrorEntry is an object that holds complete information about an error message. It holds information
 * like the message, type of the error and all the field names that are involved in generation of this 
 * error message. 
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
public class ErrorEntry implements Serializable
{
	/*
	 * Message corresponding to the id in the OPPTMessageCatalog.
	 */
	private String errorMessage = null;
	
	/*
	 * These are the fields that involved in the occurance of this error.
	 */
	private String[] fieldNames = null;
	
	/*
	 * These are the inputs to fill a dynamic message.
	 */
	private String[] messageInputs = null;
	
	/*
	 * This is the count value of the number of dynamic messages that can be inserted into the message
	 */
	private int messageInputCount = -1;

	/**
	 * Constructor 
	 * Creates a new ErrorEntry object.
	 * 
	 * <br/><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public ErrorEntry(){
	}

	/**
	 * Constructor 
	 * Creates a new ErrorEntry object for the particular errorId.
	 * 
	 * <br/><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param ierrorMessage 
	 * @param ifieldNames 
	 */
	public ErrorEntry(String ierrorMessage, String[] ifieldNames){
		setErrorMessage(ierrorMessage);
		setFieldNames(ifieldNames);
	}

	/**
	 * Constructor 
	 * Creates a new ErrorEntry object for the particular errorId.
	 * 
	 * <br/><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param ierrorMessage 
	 * @param ifieldNames 
	 * @param imessageInputs  
	 */
	public ErrorEntry(String ierrorMessage, String[] ifieldNames, String[] imessageInputs){
		setErrorMessage(ierrorMessage);
		setFieldNames(ifieldNames);
		setMessageInputs(imessageInputs);
	}

	/**
	 * Constructor 
	 * Creates a new ErrorEntry object for the particular errorId.
	 * 
	 * <br/><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param ierrorMessage 
	 * @param ifieldNames 
	 * @param imessageInputs 
	 * @param imessageInputCount 
	 */
	public ErrorEntry(String ierrorMessage, String[] ifieldNames, String[] imessageInputs, int imessageInputCount){
		setErrorMessage(ierrorMessage);
		setFieldNames(ifieldNames);
		setMessageInputs(imessageInputs);
		setMessageInputCount(imessageInputCount);
	}

	/**
	 * Constructor 
	 * Creates a new ErrorEntry object for the particular errorId.
	 * 
	 * <br/><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param ierrorMessage 
	 * @param ifieldNames 
	 * @param imessageInputCount 
	 */
	public ErrorEntry(String ierrorMessage, String[] ifieldNames, int imessageInputCount){
		setErrorMessage(ierrorMessage);
		setFieldNames(ifieldNames);
		setMessageInputCount(imessageInputCount);
	}

	/**
	 * Constructor 
	 * Creates a new ErrorEntry object for the particular errorId.
	 * 
	 * <br/><PRE> 
	 * date Nov 11, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param imessageInputs 
	 */
	public ErrorEntry(String[] imessageInputs){
		setMessageInputs(imessageInputs);
	}

	/**
	 * Returns errorMessage
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
	 * @return String
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Returns collection of fields that are involved in the occurance of this error.
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
	 * @return String[]
	 */
	public String[] getFieldNames() {
		return fieldNames;
	}

	/**
	 * Sets the newErrorMessage to errorMessage
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
	 * @param newErrorMessage 
	 */
	public void setErrorMessage(String newErrorMessage) {
		errorMessage = newErrorMessage;
	}

	/**
	 * Sets the fieldNames that are involved in this errorMessage.
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
	 * @param newFieldNames 
	 */
	public void setFieldNames(String[] newFieldNames) {
		fieldNames = newFieldNames;
	}
	
	/** 
	 * Gets the message inputs for dynamic message 
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String[]
	 */
	public String[] getMessageInputs() {
		return messageInputs;
	}

	/** 
	 * Sets the messages for filling a dynamic message
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 22, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param strings 
	 */
	public void setMessageInputs(String[] strings) {
		messageInputs = strings;
	}

	/**
	 * Returns the message input count value
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return int
	 */
	public int getMessageInputCount() {
		return messageInputCount;
	}

	/**
	 * Sets dynamic message input count value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newMessageInputCount 
	 */
	public void setMessageInputCount(int newMessageInputCount) {
		messageInputCount = newMessageInputCount;
	}
	
	/**
	 * Sets dynamic message input count value 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 29, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return String 
	 */
	
	public String toString(){
		String value = "\n[ErrorEntry] - [toString] - Start...";  /* NOI18N */
		
		value += "\n\t[ErrorEntry] - Error message: "+errorMessage;  /* NOI18N */
		value += "\n\t[ErrorEntry] - File names: "+fieldNames;  /* NOI18N */
		value += "\n\t[ErrorEntry] - Message input count: "+messageInputCount;  /* NOI18N */ 
		value += "\n\t[ErrorEntry] - Message inputs: "+messageInputs;  /* NOI18N */
		
		value = "\n[ErrorEntry] - [toString] - End...\n";  /* NOI18N */
		return value;
	}
}
