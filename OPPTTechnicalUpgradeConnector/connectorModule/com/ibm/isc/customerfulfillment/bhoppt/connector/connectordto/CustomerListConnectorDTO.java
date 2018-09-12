/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */

package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * Customer list connector dto
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
public class CustomerListConnectorDTO implements ConnectorDTOInterface
{
	private String customerListNo;
	private String customerListName;

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
	public CustomerListConnectorDTO()
	{
	}
	
	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getCustomerListName()
	{
		return customerListName;
	}

	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
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
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param lcustomerListName 
	 */
	public void setCustomerListName(String lcustomerListName)
	{
		customerListName = lcustomerListName;
	}

	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Dec 3, 2003 
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
}
