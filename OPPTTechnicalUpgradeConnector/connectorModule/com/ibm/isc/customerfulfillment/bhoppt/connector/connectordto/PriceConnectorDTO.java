/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import java.util.Date;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 * Price ConnectorDTO  
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

public class PriceConnectorDTO implements ConnectorDTOInterface
{
	private String salesDocumentNumber;
	private String eEItemPositionNo;
	private Date billingStartDate;
	private Date billingEndDate;
	private double eSWPrice;
	private String currency;
	private String billingStatus;

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
	public PriceConnectorDTO()
	{
	}
	
	/** 
	 * To get the billing end date
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
	 * @return Date
	 */
	public Date getBillingEndDate()
	{
		return billingEndDate;
	}

	/** 
	 * To get the Billing start date
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
	 * @return Date
	 */
	public Date getBillingStartDate()
	{
		return billingStartDate;
	}

	/** 
	 * To get the currency
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
	public String getCurrency()
	{
		return currency;
	}

	/** 
	 * To get the EEItem position number
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
	public String getEEItemPositionNo()
	{
		return eEItemPositionNo;
	}

	/** 
	 * To get the ESW price
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
	public double getESWPrice()
	{
		return eSWPrice;
	}

	/** 
	 * To get the sales document number
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
	public String getSalesDocumentNumber()
	{
		return salesDocumentNumber;
	}

	/** 
	 * To set the billing end date
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
	 * @param endDate
	 */
	public void setBillingEndDate(Date endDate)
	{
		billingEndDate = endDate;
	}

	/** 
	 * To set the billing start date
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
	 * @param startDate
	 */
	public void setBillingStartDate(Date startDate)
	{
		billingStartDate = startDate;
	}

	/** 
	 * To set the currency
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
	 * @param lcurrency 
	 */
	public void setCurrency(String lcurrency)
	{
		currency = lcurrency;
	}

	/** 
	 * To set the EE Item Position Number
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
	 * @param positionNo
	 */
	public void setEEItemPositionNo(String positionNo)
	{
		eEItemPositionNo = positionNo;
	}

	/**
     * To set the ESWPrice
     * <br><b>Known Bugs</b><br>
     * <br><PRE>
     * date Nov 21, 2003
     * revision date author reason
     * </PRE><br>
     *
     * @param ESWPrice
     * @param eswPrice 
     */
	public void setESWPrice(double eswPrice)
	{
		eSWPrice = eswPrice;
	}

	/** 
	 * To set the sales document number
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
	 * @param salesDocumentNo
	 */
	public void setSalesDocumentNumber(String salesDocumentNo)
	{
		salesDocumentNumber = salesDocumentNo;
	}
	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @return 
	 */
	public String getBillingStatus() {
		return billingStatus;
	}

	/** 
	 * 
	 * <br><b>Known Bugs</b><br> 
	 * 
	 * <br><PRE> 
	 * date Feb 23, 2004 
	 * 
	 * revision date author reason 
	 * 
	 * </PRE><br> 
	 * 
	 * @param string 
	 */
	public void setBillingStatus(String string) {
		billingStatus = string;
	}

}
