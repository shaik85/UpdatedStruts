/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.projectutilities.logging;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.FileAppender;

/**
 *
 *
 * <br/><b>Known Bugs</b><br/>
 *
 * <br/><PRE>
 * date Feb 9, 2004
 *
 * revision date author reason
 *
 * </PRE><br/>
 * @author Muruganantham Mani
 * @version 5.1A
 */
public class OPPTFileAppender extends FileAppender
{
    

	/**
     * close
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Jan 15, 2004
     * revision date author reason
     * </PRE><br>
     *
     * @concurrency $none
     */
    
	public synchronized void close()
	{
		if (canClose())
		{
			super.close();
		}
	}


	/** 
	 * 	canClose
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
	 * @return boolean
	 */
	
	private boolean canClose()
	{
		boolean canClose = true;

		try
		{
			String a = null;
			a.toString();
		}
		catch (Exception e)
		{
			StringWriter writer = new StringWriter();
			PrintWriter out = new PrintWriter(writer);
			e.printStackTrace(out);

			canClose = writer.toString().indexOf("OPPTLogger.") > -1;  //$NON-NLS-1$
		}

		return canClose;
	}
}