/*
 * IBM Confidential
 * Offering Proposal and Planning Tool
 * (C) Copyright IBM Corp. 2003, 2006  All Rights Reserved.
 */
 
package com.ibm.isc.customerfulfillment.bhoppt.connector.connectordto;

import com.ibm.isc.customerfulfillment.bhoppt.connector.ConnectorDTOInterface;

/**
 *  PartnerCheckOutputConnectorDTO
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
public class PartnerCheckOutputConnectorDTO implements ConnectorDTOInterface
{
	private String flag;
	private String customerNo;
	private String partnerName;
	private String legacyNo;
	private String addressSeqNo;
	private String classType;
	private String returnCode;

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
	public PartnerCheckOutputConnectorDTO()
	{
	}

	/** 
	 * To get the address sequence number
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
	 * @return 
	 */
	public String getAddressSeqNo()
	{
		return addressSeqNo;
	}

	/** 
	 * To get the class type
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
	 * @return 
	 */
	public String getClassType()
	{
		return classType;
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
	 * @return 
	 */
	public String getCustomerNo()
	{
		return customerNo;
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
	 * @return 
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
	 * @return 
	 */
	public String getLegacyNo()
	{
		return legacyNo;
	}

	/** 
	 * To get the partner name
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
	 * @return 
	 */
	public String getPartnerName()
	{
		return partnerName;
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
	 * @return 
	 */
	public String getReturnCode()
	{
		return returnCode;
	}

	/** 
	 * To set the address sequence number
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
	 * @param laddressSeqNo 
	 */
	public void setAddressSeqNo(String laddressSeqNo)
	{
		addressSeqNo = laddressSeqNo;
	}

	/** 
	 * To set the class type
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
	 * @param lclassType 
	 */
	public void setClassType(String lclassType)
	{
		classType = lclassType;
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
	 * @param lcustomerNo 
	 */
	public void setCustomerNo(String lcustomerNo)
	{
		customerNo = lcustomerNo;
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
	 * @param llegacyNo 
	 */
	public void setLegacyNo(String llegacyNo)
	{
		legacyNo = llegacyNo;
	}

	/** 
	 * To set the partner name
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
	 * @param lpartnerName 
	 */
	public void setPartnerName(String lpartnerName)
	{
		partnerName = lpartnerName;
	}

	/** 
	 * To set the return code
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
