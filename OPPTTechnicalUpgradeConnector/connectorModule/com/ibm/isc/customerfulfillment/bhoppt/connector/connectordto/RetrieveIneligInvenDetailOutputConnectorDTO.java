/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;


/**
 * Retrieve Ineligible Inventory Detail Output DTO 
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

public class RetrieveIneligInvenDetailOutputConnectorDTO implements ConnectorDTOInterface
{
	private Date systemDate;
	private Time systemTime;
	private String returnCode;

	private List eEConnectorDTOList = new ArrayList();
	private List priceConnectorDTOList = new ArrayList();
	private List sWOConnectorDTOList = new ArrayList();

	/**
	 *  
	 * Constructor 
	 * 
	 * <br/><PRE> 
	 * date Nov 21, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br/> 
	 *
	 */
	public RetrieveIneligInvenDetailOutputConnectorDTO()
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
		return returnCode;
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

	/** 
	 * To get the System Date
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
	 * @return System Date
	 */
	public Date getSystemDate()
	{
		return systemDate;
	}

	/** 
	 * To get the System Time
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
	 * @return System Time
	 */
	public Time getSystemTime()
	{
		return systemTime;
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
		returnCode = aReturnCode;
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
	 * To set the system date
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
	 * @param date 
	 */
	public void setSystemDate(Date date)
	{
		systemDate = date;
	}

	/** 
	 * To set the system time
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
	 * @param time 
	 */
	public void setSystemTime(Time time)
	{
		systemTime = time;
	}
}
