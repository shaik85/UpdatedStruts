/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common;

import java.math.BigDecimal;

/** 
 * This is a common helper class. 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 22, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Balaji Venkatesan
 * @version 5.1A 
 */
public class OPPTHelper
{
	/**
	 * To trim the string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param value
	 * @return String
	 */
	public static String trimString(String value)
	{
		return (value == null) ? value : value.trim();
	}

	/**
	 * To trim the string to null 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param value
	 * @return String
	 */
	
	public static String trimStringToNull(String value)
	{
		value =  (value == null) ? value : value.trim();
		if(null != value && value.length() == 0) {
			value = null;
		}
		return value;
	}
		
	/**
	 * convert the string in to upper case 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param value
	 * @return String
	 */
	
	public static String toUpperCase(String value)
	{
		return (value == null) ? value : value.trim().toUpperCase();
	}

	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param valueOne
	 * @return String
	 */
	
	public static String getLogString(String valueOne)
	{
		return getLogString(new String[] { valueOne });
	}

	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param valueOne
	 * @param valueTwo
	 * @return String
	 */
	public static String getLogString(String valueOne, String valueTwo)
	{
		return getLogString(new String[] { valueOne, valueTwo });
	}

	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param valueOne
	 * @param valueTwo
	 * @param valueThree
	 * @return String
	 */
	public static String getLogString(String valueOne, String valueTwo, String valueThree)
	{
		return getLogString(new String[] { valueOne, valueTwo, valueThree });
	}

	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param valueOne
	 * @param valueTwo
	 * @param valueThree
	 * @param valueFour
	 * @return String
	 */
	public static String getLogString(String valueOne, String valueTwo, String valueThree, String valueFour)
	{
		return getLogString(new String[] { valueOne, valueTwo, valueThree, valueFour });
	}

	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param valueOne
	 * @param valueTwo
	 * @param valueThree
	 * @param valueFour
	 * @param valueFive
	 * @return String
	 */
	public static String getLogString(String valueOne, String valueTwo, String valueThree, String valueFour, String valueFive)
	{
		return getLogString(new String[] { valueOne, valueTwo, valueThree, valueFour, valueFive });
	}

	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param valueOne
	 * @param valueTwo
	 * @param valueThree
	 * @param valueFour
	 * @param valueFive
	 * @param valueSix
	 * @return String
	 */
	public static String getLogString(String valueOne, String valueTwo, String valueThree, String valueFour, String valueFive, String valueSix)
	{
		return getLogString(new String[] { valueOne, valueTwo, valueThree, valueFour, valueFive, valueSix });
	}

	/** 
	 * To get the log message
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param values
	 * @return String
	 */
	public static String getLogString(String[] values)
	{
		return getLogString(values, new StringBuffer());
	}

	/**
	 * To get the log string 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param values
	 * @param buffer
	 * @return String
	 */
	public static String getLogString(String[] values, StringBuffer buffer)
	{
		if (values != null)
		{
			if (values.length >= 1)
			{
				if (buffer.length() > 0)
				{
					buffer.append(UtilityConstants.MESSAGE_VALUE_DELIMITER);
				}
				
				buffer.append(values[0]);

				for (int i = 1; i < values.length; i++)
				{
					buffer.append(UtilityConstants.MESSAGE_VALUE_DELIMITER);
					buffer.append(values[i]);
				}
			}
		}

		return buffer.toString();
	}

	/**
	 * To convert to big decimal 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param amount
	 * @return BigDecimal
	 */
	
	
	public static BigDecimal convertToBigDecimal(double amount) {
		return new BigDecimal((new Double(amount)).toString());
	}
	
	/**
	 * To get number of bills 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 28, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param code
	 * @return integer
	 */
	
	public static int getNumberOfBills(String code) {
		
		int bills = 0;
		
		char codeArray[] = code.toCharArray();
	
		switch(codeArray[0]){
		 case 'A': bills = 1;
		 break;
		 case 'M': bills = 12;
		 break;
		 case 'Q': bills = 4;
		 break;
		 case 'S': bills = 2;
		 break;
		 default:
		}
		return bills;
	}
	/**
	 * Will replace Old with new string.(We have replaceString in jdk1.4)
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Apr 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param aInput
	 * @param aOldPattern
	 * @param aNewPattern
	 * @author balajiv 
	 * @return String
	 */
	public static String replace(final String aInput,
								 final String aOldPattern,
								 final String aNewPattern){

		final StringBuffer result = new StringBuffer();
		int startIdx = 0;
		int idxOld = 0;
		while ((idxOld = aInput.indexOf(aOldPattern, startIdx)) >= 0) {
		   result.append( aInput.substring(startIdx, idxOld) );
		   result.append( aNewPattern );
		   startIdx = idxOld + aOldPattern.length();
		}
		result.append( aInput.substring(startIdx) );
		return result.toString();
	 }
	
	/**
	 * Will be used to concat strings using StringBuffer
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date May 22, 2006 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param first
	 * @param second
	 * @author balajiv 
	 * @return
	 */
	
	public static String concat(String first, String second) {
		StringBuffer result = new StringBuffer(first);
		result.append(second);
		String strResult =  result.toString();
		result = null;
		return strResult;
	}
	
	/* Defect 89 added for Japan by Balaji */
	/**
	 * @param d
	 * @return
	 */
	public static boolean decimalCheck(double d) {
		boolean hasDecimals = false;
		long i = (long) d;
		if (d - i > 0) {
			hasDecimals = true;
	 }
		return hasDecimals;
	}	
	
	/**
	 * @param value
	 * @return
	 */
	public static boolean validNumberRangeForJapan(double value) {
		boolean valid = true;
		if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_AMOUNT_FOR_JAPAN < value) {
			valid = false;
		}
		return valid;
	}
	
	/**
	 * @param value
	 * @return
	 */
	public static boolean validNumberRangeForVietnam(double value) {
		boolean valid = true;
		if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_AMOUNT_FOR_VIETNAM < value) {
			valid = false;
		}
		return valid;
	}
	
	
	
	/**
	 * @param value
	 * @return
	 */
	public static boolean validNumberRange(double value) {
		boolean valid = true;
		if (UtilityConstants.MIN_AMOUNT_IN_OPPT > value || UtilityConstants.MAX_AMOUNT < value) {
			valid = false;
		}
		return valid;
	}

	
}
