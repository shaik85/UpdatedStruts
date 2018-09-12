/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * Retrieve Ineligible Delta Inventory Output Connector DTO
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
public class RetrieveIneligDeltaInvenOutputConnectorDTO implements ConnectorDTOInterface 
{
	private Date iSystemDate;
	private Time iSystemTime;
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
   public RetrieveIneligDeltaInvenOutputConnectorDTO() 
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
	* @return Price ConnectorDTO List
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
	* @return SWO ConnectorDTO List
	*/
   public List getSWOConnectorDTOList()
   {
	   return iSWOConnectorDTOList;
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
	   return iSystemDate;
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
	   return iSystemTime;
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
	* @param Return Code 
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
	   iSystemDate = date;
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
	   iSystemTime = time;
   }
}
