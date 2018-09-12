/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging;

import org.apache.log4j.Level;
import org.apache.log4j.helpers.FormattingInfo;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.PatternConverter;
import org.apache.log4j.helpers.PatternParser;
import org.apache.log4j.spi.LoggingEvent;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.PreparedString;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.StringParser;
import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common.UtilityConstants;

/**
 * Inherits from PatternParser and overrides finalizeConverter() method to format
 * the output as per GWA standards.
 * 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Jan 20, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */
public class OPPTPatternParser extends PatternParser
{
	private static final int ORIGINAL_MESSAGE = 0;
	private static final int CLASS_NAME = 1;
	private static final int METHOD_NAME = 2;
	private static final int MESSAGE_VALUES = 3;

	private static final int MESSAGE_CONVERTER = 2004;
	private static final int CLASS_CONVERTER = 2006;
	private static final int METHOD_CONVERTER = 2007;
	private static final int LEVEL_CONVERTER = 2002;
	private static final int SEVERITY_CONVERTER = 2005;

	private static final char CLASS = 'C';
	private static final char METHOD = 'M';
	private static final char MESSAGE = 'm';
	private static final char PRIORITY = 'p';
	private static final char SEVERITY = 's';

	private String className = null;
	private String methodName = null;
	private String message = null;

	private boolean isInitialized = false;

	
	/**
	 *  
	 * constructor
	 * <br/><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param pattern
	 *
	 */
	
	public OPPTPatternParser(String pattern)
	{
		super(pattern);
	}

	/**
	 *  
	 * Overridden method 
	 * This method accepts the conversion character and uses inner classes to convert
	 * it in a format required as per GWA standards.
	 * 
	 * <br/><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 * @param c char
	 *
	 */
	protected void finalizeConverter(char c)
	{
		PatternConverter pc = null;
		switch (c)
		{
			case CLASS :
				pc = new BasicPatternConverter(formattingInfo, CLASS_CONVERTER);
				currentLiteral.setLength(0);
				break;

			case MESSAGE :
				pc = new BasicPatternConverter(formattingInfo, MESSAGE_CONVERTER);
				currentLiteral.setLength(0);
				break;

			case METHOD :
				pc = new BasicPatternConverter(formattingInfo, METHOD_CONVERTER);
				currentLiteral.setLength(0);
				break;

			case SEVERITY :
				pc = new BasicPatternConverter(formattingInfo, SEVERITY_CONVERTER);
				currentLiteral.setLength(0);
				break;

			case PRIORITY :
				pc = new BasicPatternConverter(formattingInfo, LEVEL_CONVERTER);
				currentLiteral.setLength(0);
				break;

			default :
				super.finalizeConverter(c);
		}

		if (pc != null)
		{
			addConverter(pc);
		}
	}
	/**
	 * inner class
	 * 
	 * <br/><b>Known Bugs</b><br/> 
	 * 
	 * <br/><PRE> 
	 * date Jan 20, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @author Muruganantham Mani
	 * @version 5.1A
	 */
	
	private class BasicPatternConverter extends PatternConverter
	{
		private int type;

		BasicPatternConverter(FormattingInfo formattingInfo, int messageType)
		{
			super(formattingInfo);
			type = messageType;
		}

		public String convert(LoggingEvent event)
		{
			switch (type)
			{
				case LEVEL_CONVERTER :
					return event.getLevel().toString();

				case SEVERITY_CONVERTER :
					String severity = "";  /* NOI18N */
					int level = event.getLevel().toInt();

					switch (level)
					{
						case Level.FATAL_INT :
							severity = "Severity 1";  //$NON-NLS-1$
							break;

						case Level.ERROR_INT :
							severity = "Severity 2";  //$NON-NLS-1$
							break;

						case Level.WARN_INT :
							severity = "Severity 3";  //$NON-NLS-1$
							break;

						case Level.INFO_INT :
							severity = "Severity 4";  //$NON-NLS-1$
							break;

						case Level.DEBUG_INT :
						default :
							severity = "Not Severe";  //$NON-NLS-1$
					}

					return severity;

				case CLASS_CONVERTER :
					setValues(event.getRenderedMessage());
					return className;

				case METHOD_CONVERTER :
					return methodName;

				case MESSAGE_CONVERTER :
					return message;

				default :
					return null;
			}
		}
	}

	/**
	 *  
	 *set the values
	 * <br/><PRE> 
	 * date Dec 2, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * 
	 *
	 */
	
	private void setValues(String givenMessage)
	{
		StringParser tokenizer = new StringParser(givenMessage, UtilityConstants.MESSAGE_DELIMITER);

		int count = 0;
		String originalMessage = null;

		if (tokenizer.countTokens() < 4)
		{
			//LogLog.error(new StringBuffer("Message should be of 4 parts... For Message: ").append(givenMessage).toString());
		}
		else
		{
			try
			{
				while (tokenizer.hasMoreTokens())
				{
					switch (count++)
					{
						case ORIGINAL_MESSAGE :
							originalMessage = tokenizer.nextToken();
							break;

						case CLASS_NAME :
							className = tokenizer.nextToken();
							break;

						case METHOD_NAME :
							methodName = tokenizer.nextToken();
							break;

						case MESSAGE_VALUES :
						default :
							message = tokenizer.nextToken();
					}
				}

				if (message != null && message.trim().length() > 0)
				{
					PreparedString preparedString = new PreparedString(originalMessage);
					StringParser parser = new StringParser(message, UtilityConstants.MESSAGE_VALUE_DELIMITER);

					count = 1;
					while (parser.hasMoreTokens())
					{
						preparedString.setString(count++, parser.nextToken());
					}

					message = preparedString.toString();
				}
				else
				{
					message = originalMessage;
				}
			}
			catch (Exception e)
			{
				LogLog.error("String Parsing Exception", e);  //$NON-NLS-1$
			}
		}
	}
}
