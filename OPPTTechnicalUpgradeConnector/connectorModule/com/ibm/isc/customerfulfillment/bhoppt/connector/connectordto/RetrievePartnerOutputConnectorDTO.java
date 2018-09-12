/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 *  RetrievePartnerOutputConnectorDTO
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 4, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */
public class RetrievePartnerOutputConnectorDTO implements ConnectorDTOInterface
{
	private String returnCode;
	private List retrievePartnerConnectorDTOList;

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public RetrievePartnerOutputConnectorDTO()
	{
	}

	/** 
	 * To get the RetrievePartnerConnectorDTO List
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return List of RetrievePartnerConnectorDTO
	 */
	public List getRetrievePartnerConnectorDTOList()
	{
		return retrievePartnerConnectorDTOList;
	}

	/** 
	 * To get the return code
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return returnCode 
	 */
	public String getReturnCode()
	{
		return returnCode;
	}

	/** 
	 * To set the RetrievePartnerConnectorDTO  List
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
	public void setRetrievePartnerConnectorDTOList(List list)
	{
		retrievePartnerConnectorDTOList = list;
	}

	/** 
	 * To set the returnCode
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 4, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lreturnCode 
	 */
	public void setReturnCode(String lreturnCode)
	{
		returnCode = lreturnCode;
	}
}
