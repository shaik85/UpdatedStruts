/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;


/**
 *  RetrievePartnerConnectorDTO
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
public class RetrievePartnerConnectorDTO implements ConnectorDTOInterface
{
	private String flag;
	private String customerNumber;
	private String customerName;
	private String legacyNumber;
	private String sequenceNumber;
	private String siteID; //DADO02&DADO09

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
	public RetrievePartnerConnectorDTO()
	{
	}

	/** 
	 * To get the customer name
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
	 * @return customer name
	 */
	public String getCustomerName()
	{
		return customerName;
	}

	/** 
	 * To get the customer number
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
	 * @return customer number
	 */
	public String getCustomerNumber()
	{
		return customerNumber;
	}

	/** 
	 * To get the flag
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
	 * @return flag
	 */
	public String getFlag()
	{
		return flag;
	}

	/** 
	 * To get the legacy number
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
	 * @return legacy number
	 */
	public String getLegacyNumber()
	{
		return legacyNumber;
	}

	/** 
	 * To get the sequence number
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
	 * @return sequence number
	 */
	public String getSequenceNumber()
	{
		return sequenceNumber;
	}

	/** 
	 * To set the customer name
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
	 * @param lcustomerName 
	 */
	public void setCustomerName(String lcustomerName)
	{
		customerName = lcustomerName;
	}

	/** 
	 * To set the customer number
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
	 * @param lcustomerNumber 
	 */
	public void setCustomerNumber(String lcustomerNumber)
	{
		customerNumber = lcustomerNumber;
	}

	/** 
	 * To set the flag
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
	 * @param lflag 
	 */
	public void setFlag(String lflag)
	{
		flag = lflag;
	}

	/** 
	 * To set the legacy number
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
	 * @param llegacyNumber 
	 */
	public void setLegacyNumber(String llegacyNumber)
	{
		legacyNumber = llegacyNumber;
	}

	/** 
	 * To set the sequence number
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
	 * @param lsequenceNumber 
	 */
	public void setSequenceNumber(String lsequenceNumber)
	{
		sequenceNumber = lsequenceNumber;
	}
	/**
	 * @return Returns the siteID.
	 */
	public String getSiteID() {
		return siteID;
	}
	/**
	 * @param siteID The siteID to set.
	 */
	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}
}
