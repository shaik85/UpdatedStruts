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
 * Enter one sentence as a brief description for your class. 
 * You can enter more text here (e.g. describe the purpose of the class here). 
 * 
 * <br/><b>Known Bugs</b><br/> 
 * 
 * <br/><PRE> 
 * date Dec 18, 2003 
 * 
 * revision date author reason 
 * 
 * </PRE><br/> 
 * @author Kedar Harischandrakar
 * @version 5.1A 
 */
public class CheckVarianceOutputConnectorDTO implements ConnectorDTOInterface 
{
	private String returnCode;
	private List eEConnectorDTOList = new ArrayList();
	private List priceConnectorDTOList = new ArrayList();
	private List sWOConnectorDTOList = new ArrayList();
	private CheckVarianceConnectorDTO checkVarianceConnectorDTO;
	
	/** 
	 * Constructor 
	 * Enter your description here. 
	 * 
	 * <br/><PRE> 
	 * date Dec 18, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *  
	 */
	public CheckVarianceOutputConnectorDTO() 
	{
	
	}
	/**
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 16, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public CheckVarianceConnectorDTO getCheckVarianceConnectorDTO()
	{
		return checkVarianceConnectorDTO;
	}
	/**
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 16, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @return
     * @param newReturnCode 
     */
	public void setCheckVarianceConnectorDTO(CheckVarianceConnectorDTO newReturnCode)
	{
		checkVarianceConnectorDTO = newReturnCode;
	}
	/**
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 16, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return
	 */
	public String getReturnCode()
	{
		return returnCode;
	}
	/**
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Dec 16, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @return
     * @param newReturnCode 
     */
	public void setReturnCode(String newReturnCode)
	{
		returnCode = newReturnCode;
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
	 * @return EEConnectorDTO List
	 */
	public List getEEConnectorDTOList()
	{
		return eEConnectorDTOList;
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
	 * @return Price ConnectorDTO List
	 */
	public List getPriceConnectorDTOList()
	{
		return priceConnectorDTOList;
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
	 * @return SWO ConnectorDTO List
	 */
	public List getSWOConnectorDTOList()
	{
		return sWOConnectorDTOList;
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
		eEConnectorDTOList = list;
	}

	/** 
	 * To add the EEConnectorDTO to the List 
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
	 *  
	 */
	public void addEEConnectorDTO(ConnectorDTOInterface connectorDTO)
	{
		eEConnectorDTOList.add(connectorDTO);
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
		priceConnectorDTOList = list;
	}

	/** 
	 * To add the PriceConnectorDTO to the List 
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
	 *  
	 */
	public void addPriceConnectorDTO(ConnectorDTOInterface connectorDTO)
	{
		priceConnectorDTOList.add(connectorDTO);
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
		sWOConnectorDTOList = list;
	}
	/** 
	 * To add the SWOConnectorDTO to the List 
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
	 *  
	 */
	public void addSWOConnectorDTO(ConnectorDTOInterface connectorDTO)
	{
		sWOConnectorDTOList.add(connectorDTO);
	}	
}
