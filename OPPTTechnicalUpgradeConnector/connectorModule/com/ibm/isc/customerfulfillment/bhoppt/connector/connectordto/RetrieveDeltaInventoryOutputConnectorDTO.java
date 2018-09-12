/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * Retrieve Delta Inventory Output Connector DTO
 * 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 3, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Muruganantham Mani
 * @version 5.1A
 */
public class RetrieveDeltaInventoryOutputConnectorDTO implements ConnectorDTOInterface
{
	private String iReturnCode;

	private List iEEConnectorDTOList;
	private List iPriceConnectorDTOList;
	private List iSWOConnectorDTOList;

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public RetrieveDeltaInventoryOutputConnectorDTO()
	{
	}

	/** 
		* To get the EEConnectorDTO List
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
		* @return 
		*/
	public List getEEConnectorDTOList()
	{
		return iEEConnectorDTOList;
	}

	/** 
		* To get the Price ConnectorDTO List
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
		* @return 
		*/
	public List getPriceConnectorDTOList()
	{
		return iPriceConnectorDTOList;
	}

	/** 
		* To get the Return code
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
		* @return Return code
		*/
	public String getReturnCode()
	{
		return iReturnCode;
	}

	/** 
		* To get the SWO ConnectorDTO List
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
		* @return 
		*/
	public List getSWOConnectorDTOList()
	{
		return iSWOConnectorDTOList;
	}

	/** 
		* To set the EEConnectorDTO List 
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
	public void setEEConnectorDTOList(List list)
	{
		iEEConnectorDTOList = list;
	}

	/** 
		* To set the PriceConnectorDTO List
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
	public void setPriceConnectorDTOList(List list)
	{
		iPriceConnectorDTOList = list;
	}

	/** 
		* To set the return code
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
		* @param aReturnCode
		*/
	public void setReturnCode(String aReturnCode)
	{
		iReturnCode = aReturnCode;
	}

	/** 
		* To set the SWOConnectorDTO List
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
	public void setSWOConnectorDTOList(List list)
	{
		iSWOConnectorDTOList = list;
	}
}
