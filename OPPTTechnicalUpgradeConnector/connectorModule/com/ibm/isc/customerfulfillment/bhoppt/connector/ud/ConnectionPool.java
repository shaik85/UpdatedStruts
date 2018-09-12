/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.ud;

import com.ibm.isc.customerfulfillment.bhoppt.projectutilities.exception.ConnectorException;

/**
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Mar 18, 2005 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Vinod Kumar Burugupalli
 * @version CBS 1.0
 */
public interface ConnectionPool
{
	public UDServiceProxy checkOut() throws ConnectorException;
}
