/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/** 
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 4, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Kedar Harischandrakar
 * @version 5.1A 
 */
public class CustListAndSeqConnectorDTO implements ConnectorDTOInterface 
{
	private String legacyCustNumber;
	private String addSeqNumber;
	/** 
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public CustListAndSeqConnectorDTO() 
	{
		
	}
	/** 
	 * To get Legacy Customer Number
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Sales Org
	 */
	public String getLegacyCustNumber()
	{
		return legacyCustNumber;
	}
	/** 
	 * To get Address Sequence Number
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return Sales Org
	 */
	public String getAddSeqNumber()
	{
		return addSeqNumber;
	}
	/** 
	 * To set Legacy Customer Number
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param newLegacyCustNumber
	 */
	public void setLegacyCustNumber(String newLegacyCustNumber)
	{
		legacyCustNumber = newLegacyCustNumber;
	}
	/** 
	 * To set Legacy Customer Number
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br>
	 * @param newAddSeqNumber
	 */
	public void setAddSeqNumber(String newAddSeqNumber)
	{
		addSeqNumber = newAddSeqNumber;
	}	
}
