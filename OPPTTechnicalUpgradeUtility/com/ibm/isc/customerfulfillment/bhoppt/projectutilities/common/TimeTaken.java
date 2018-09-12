/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.common;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging.OPPTLogger;

/** 
 * To log the time taken for methods
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Feb 3, 2004 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A 
 */
public class TimeTaken
{
	private static final String START_TIME = "START_TIME";  /* NOI18N */
	private static final String END_TIME = "END_TIME";  /* NOI18N */

	private String className;
	private String methodName;
	private long startTime;

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Feb 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 * @param aClassName
	 * @param aMethodName
	 */
	public TimeTaken(String aClassName, String aMethodName)
	{
		startTime = System.currentTimeMillis();
		
		className = aClassName;
		methodName = aMethodName;
		
		log(START_TIME, -1);
	}

	/**
	 * To log the message 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param messageID
	 * @param time
	 */
	private void log(String messageID, long time)
	{
		String inputValue = null;

		if (time > -1)
		{
			inputValue = OPPTHelper.getLogString(methodName, Long.toString(time));
		}
		else
		{
			inputValue = OPPTHelper.getLogString(methodName);
		}

		OPPTLogger.log(messageID, OPPTLogger.INFO, className, methodName, inputValue);
	}

	/**
	 * To end the time taken process 
	 * 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 3, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 *
	 */
	public void end()
	{
		log(END_TIME, getTotalTimeTaken());
	}

	/**
     * To get the total time taken for this method
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Feb 3, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @return long
     */
	public long getTotalTimeTaken()
	{
		return (System.currentTimeMillis() - startTime) / 1000;
	}
}
