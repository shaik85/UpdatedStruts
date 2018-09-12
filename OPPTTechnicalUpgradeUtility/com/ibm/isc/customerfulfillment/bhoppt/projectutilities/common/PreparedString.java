/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common;

/** 
 * To replace the predefined tokens with the dynamic strings.
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 8, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class PreparedString
{
	private static final String QUESTION_MARK = "?";   /* NOI18N */
	
	private String originalString = null;   /* NOI18N */
	private String replacedString = null;   /* NOI18N */
	
	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Jan 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param aOriginalString
	 */
	public PreparedString(String aOriginalString)
	{
		if (aOriginalString == null)
		{
			throw new IllegalArgumentException("Invalid string.  NULL is not allowed");  /* NOI18N */
		}
		
		originalString = aOriginalString;
		replacedString = aOriginalString;
	}

	/**
	 * To clear the values if anything is set before. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *
	 */	
	public void clear()
	{
		replacedString = originalString;
	}
	
	/**
	 * To clear the values if anything is set before. 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * @param newString
	 *
	 */	
	public void clear(String newString)
	{
			replacedString = newString;
			originalString = newString;
	}

	/**
	 * To set the given string with the index token. 
	 * If the index is not found in the original string, then an
	 * IllegalArgumentException is thrown.
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Jan 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param index
	 * @param tokenString
	 */
	public void setString(int index, String tokenString)
	{
		StringBuffer buffer = new StringBuffer(QUESTION_MARK);
		buffer.append(index);
		
		int searchStringLenth = buffer.length();
		 
		int stringLocationIndex = replacedString.indexOf(buffer.toString());
		
		buffer.delete(0, searchStringLenth);
		if (stringLocationIndex > -1)
		{
			buffer.append(replacedString.substring(0, stringLocationIndex));
			buffer.append(tokenString);
			buffer.append(replacedString.substring(stringLocationIndex + searchStringLenth));
			
			replacedString = buffer.toString();
		}
		else
		{
			buffer.append("Invalid index [");  /* NOI18N */
			buffer.append(index);
			buffer.append("]");  /* NOI18N */
			
			throw new IllegalArgumentException(buffer.toString());
		}
	}
	
	/**
	 * To get the replaced string with the given token strings. 
	 * 
	 * <br/><PRE> 
	 * date Jan 8, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @see java.lang.Object#toString() 
	 * @return replaced string with the token strings
	 *
	 */
	public String toString()
	{
		return replacedString;
	}
}