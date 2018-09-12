/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */


package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;


import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;


/**
 *  
 * Retrieve Customer ConnectorDTO
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
public class RetrieveCustConnectorDTO implements ConnectorDTOInterface
{
	private String customerListNo;
	private String customerNo;
	private String customerName;
	private String legacyCustomerNo;
	private String addressSeqNo;
	private String countryCode; //EF0607044559

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

	public RetrieveCustConnectorDTO()
	{
	}
	
	/** 
	 * To get the Address Sequence Number
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
	public String getAddressSeqNo()
	{
		return addressSeqNo;
	}

	/** 
	 * To get the Customer List Number
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
	public String getCustomerListNo()
	{
		return customerListNo;
	}

	/** 
	 * To get the Customer Name 
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
	public String getCustomerName()
	{
		return customerName;
	}

	/** 
	 * To get the Customer Number
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
	public String getCustomerNo()
	{
		return customerNo;
	}

	/** 
	 * To get the Legacy Customer Number
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
	public String getLegacyCustomerNo()
	{
		return legacyCustomerNo;
	}

	/** 
	 * To get the country code
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date June 16, 2004 
	 * Added for EF0607044559 by Sara
	 *  
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getCountryCode()
	{
		return countryCode;
	}	

	/** 
	 * To set the Address Sequence Number
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
	 * @param laddressSeqNo
	 */
	public void setAddressSeqNo(String laddressSeqNo)
	{
		addressSeqNo = laddressSeqNo;
	}

	/** 
	 * To set the Customer List Number
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
	 * @param lcustomerListNo
	 */
	public void setCustomerListNo(String lcustomerListNo)
	{
		customerListNo = lcustomerListNo;
	}

	/** 
	 * To set the Customer Name
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
	 * @param lcustomerName
	 */
	public void setCustomerName(String lcustomerName)
	{
		customerName = lcustomerName;
	}

	/** 
	 * To set the Customer Number
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
	 * @param lcustomerNo 
	 */
	public void setCustomerNo(String lcustomerNo)
	{
		customerNo = lcustomerNo;
	}

	/** 
	 * To set the Legacy Customer Number
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
	 * @param llegacyCustomerNo
	 */
	public void setLegacyCustomerNo(String llegacyCustomerNo)
	{
		legacyCustomerNo = llegacyCustomerNo;
	}
	
	/** 
	 * To set the country code
	 *  
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date June 16, 2004
	 * Added for EF0607044559 by Sara
	 *  
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lcountryCode
	 */
	public void setCountryCode(String lcountryCode)
	{
		countryCode = lcountryCode;
	}	
}
