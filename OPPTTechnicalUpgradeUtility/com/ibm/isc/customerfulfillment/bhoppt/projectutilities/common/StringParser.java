/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common;

/** 
 * This class is used to parse the string and tokenize based on 
 * the given delimiter.  It also provides the users with the 
 * iterative mechnism like StringTokenizer.
 *  
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Nov 21, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class StringParser
{
	private String iDelimiter;
	private String iParseString;

	private int iFromIndex = 0;
	private int iEndIndex = -1;
	private int iLength = 0;
	private int iDelimiterLength = 0;
	private int iCountTokens = -1;
	
	/** 
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param aParseString
	 * @param aDelimiter
	 */
	public StringParser(String aParseString, String aDelimiter)
	{
		iParseString = (aParseString == null) ? "" : aParseString;  /* NOI18N */
		
		if (aDelimiter == null)
		{
			throw new IllegalArgumentException("Delimiter should not be NULL");  /* NOI18N */
		}
		
		iDelimiter = aDelimiter;

		iLength = iParseString.length();
		iDelimiterLength = iDelimiter.length();
	}

	/**
	 * This method is used to determine whether there are more tokens
	 * available in the given string.
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 24, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return boolean true if there are tokens, false otherwise
	 */
	public boolean hasMoreTokens()
	{
		iEndIndex = iParseString.indexOf(iDelimiter, iFromIndex);
		return (iEndIndex > -1) || (iLength > iFromIndex);
	}

	/** 
	 * This method return the next token in the given string.
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @return String tokenized string 
	 * 
	 */
	public String nextToken()
	{
		String returnString = null;

		if (hasMoreTokens())
		{
			if (iEndIndex > -1)
			{
				returnString = iParseString.substring(iFromIndex, iEndIndex);
			}
			else
			{
				returnString = iParseString.substring(iFromIndex);
				iEndIndex = iLength;
			}

			iFromIndex = iEndIndex + iDelimiterLength;
		}

		return returnString;
	}
	

	/** 
	 * This method return the next token in the given string.
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @return int tokenized string 
	 * 
	 */
	
	public int countTokens()
	{
		if (iCountTokens < 0)
		{
			StringParser parser = new StringParser(iParseString, iDelimiter);
			iCountTokens = 0;
			
			while (parser.hasMoreTokens())
			{
				parser.nextToken();
				iCountTokens++;
			}
		}
		
		return iCountTokens;
	}
}
