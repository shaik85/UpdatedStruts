/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.util.ArrayList;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * Retrieve Customer Output ConnectorDTO  
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
public class RetrieveCustOutputConnectorDTO implements ConnectorDTOInterface
{
	private String returnCode;
	private List retrieveCustConnectorDTOList = new ArrayList();

	/**
	 *  
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public RetrieveCustOutputConnectorDTO()
	{

	}

	/** 
	 * To get the List of Retrieve Customer ConnectorDTO 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public List getRetrieveCustConnectorDTOList()
	{
		return retrieveCustConnectorDTOList;
	}

	/** 
	 * To get the return code
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return return code
	 */
	public String getReturnCode()
	{
		return returnCode;
	}

	/** 
	 * To set the List of Retrieve Customer ConnectorDTO
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param list 
	 */
	public void setRetrieveCustConnectorDTOList(List list)
	{
		retrieveCustConnectorDTOList = list;
	}

	/**
	 * To add the customer ConnectorDTO this method is useful
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param connectorDTO
	 */
	public void addCustConnectorDTO(ConnectorDTOInterface connectorDTO)
	{
		retrieveCustConnectorDTOList.add(connectorDTO);
	}

	/** 
	 * To set the return code 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Nov 21, 2003 
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
